package com.google.android.exoplayer;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.os.Handler;
import android.util.Log;
import com.google.android.exoplayer.audio.AudioTrack.AudioTrackUtil;
import com.google.android.exoplayer.audio.AudioTrack.InitializationException;
import com.google.android.exoplayer.audio.AudioTrack.InvalidAudioTrackTimestampException;
import com.google.android.exoplayer.audio.AudioTrack.WriteException;
import com.google.android.exoplayer.util.MimeTypes;
import java.lang.reflect.Method;

@TargetApi(16)
public final class MediaCodecAudioTrackRenderer
  extends MediaCodecTrackRenderer
  implements MediaClock
{
  private boolean allowPositionDiscontinuity;
  private int audioSessionId;
  private final com.google.android.exoplayer.audio.AudioTrack audioTrack;
  private long currentPositionUs;
  final EventListener eventListener;
  
  public MediaCodecAudioTrackRenderer(SampleSource paramSampleSource)
  {
    this(paramSampleSource, (byte)0);
  }
  
  private MediaCodecAudioTrackRenderer(SampleSource paramSampleSource, byte paramByte)
  {
    this(paramSampleSource, null, null);
  }
  
  public MediaCodecAudioTrackRenderer(SampleSource paramSampleSource, Handler paramHandler, EventListener paramEventListener)
  {
    super(paramSampleSource, paramHandler, paramEventListener);
    eventListener = paramEventListener;
    audioSessionId = 0;
    audioTrack = new com.google.android.exoplayer.audio.AudioTrack();
  }
  
  private void seekToInternal(long paramLong)
  {
    audioTrack.reset();
    currentPositionUs = paramLong;
    allowPositionDiscontinuity = true;
  }
  
  protected final void configureCodec(MediaCodec paramMediaCodec, String paramString, android.media.MediaFormat paramMediaFormat, MediaCrypto paramMediaCrypto)
  {
    if ("OMX.google.raw.decoder".equals(paramString))
    {
      paramString = paramMediaFormat.getString("mime");
      paramMediaFormat.setString("mime", "audio/raw");
      paramMediaCodec.configure(paramMediaFormat, null, paramMediaCrypto, 0);
      paramMediaFormat.setString("mime", paramString);
      return;
    }
    paramMediaCodec.configure(paramMediaFormat, null, paramMediaCrypto, 0);
  }
  
  protected final DecoderInfo getDecoderInfo(String paramString, boolean paramBoolean)
    throws MediaCodecUtil.DecoderQueryException
  {
    if (MimeTypes.isPassthroughAudio(paramString)) {
      return new DecoderInfo("OMX.google.raw.decoder", true);
    }
    return super.getDecoderInfo(paramString, paramBoolean);
  }
  
  protected final MediaClock getMediaClock()
  {
    return this;
  }
  
  public final long getPositionUs()
  {
    com.google.android.exoplayer.audio.AudioTrack localAudioTrack = audioTrack;
    boolean bool = isEnded();
    int i;
    long l1;
    if ((localAudioTrack.isInitialized()) && (startMediaTimeState != 0))
    {
      i = 1;
      if (i != 0) {
        break label72;
      }
      l1 = Long.MIN_VALUE;
      label37:
      if (l1 != Long.MIN_VALUE) {
        if (!allowPositionDiscontinuity) {
          break label771;
        }
      }
    }
    for (;;)
    {
      currentPositionUs = l1;
      allowPositionDiscontinuity = false;
      return currentPositionUs;
      i = 0;
      break;
      label72:
      long l3;
      long l4;
      if (audioTrack.getPlayState() == 3)
      {
        l1 = audioTrackUtil.getPlaybackHeadPositionUs();
        if (l1 != 0L)
        {
          l2 = System.nanoTime() / 1000L;
          if (l2 - lastPlayheadSampleTimeUs >= 30000L)
          {
            playheadOffsets[nextPlayheadOffsetIndex] = (l1 - l2);
            nextPlayheadOffsetIndex = ((nextPlayheadOffsetIndex + 1) % 10);
            if (playheadOffsetCount < 10) {
              playheadOffsetCount += 1;
            }
            lastPlayheadSampleTimeUs = l2;
            smoothedPlayheadOffsetUs = 0L;
            i = 0;
            while (i < playheadOffsetCount)
            {
              smoothedPlayheadOffsetUs += playheadOffsets[i] / playheadOffsetCount;
              i += 1;
            }
          }
          if ((!isAc3) && (l2 - lastTimestampSampleTimeUs >= 500000L))
          {
            audioTimestampSet = audioTrackUtil.updateTimestamp();
            if (audioTimestampSet)
            {
              l3 = audioTrackUtil.getTimestampNanoTime() / 1000L;
              l4 = audioTrackUtil.getTimestampFramePosition();
              if (l3 >= resumeSystemTimeUs) {
                break label495;
              }
              audioTimestampSet = false;
            }
            label316:
            if (getLatencyMethod == null) {}
          }
        }
      }
      try
      {
        latencyUs = (((Integer)getLatencyMethod.invoke(audioTrack, null)).intValue() * 1000L - localAudioTrack.framesToDurationUs(localAudioTrack.bytesToFrames(bufferSize)));
        latencyUs = Math.max(latencyUs, 0L);
        if (latencyUs > 5000000L)
        {
          Log.w("AudioTrack", "Ignoring impossibly large audio latency: " + latencyUs);
          latencyUs = 0L;
        }
        lastTimestampSampleTimeUs = l2;
        l1 = System.nanoTime() / 1000L;
        if (audioTimestampSet)
        {
          l1 = localAudioTrack.framesToDurationUs(localAudioTrack.durationUsToFrames(l1 - audioTrackUtil.getTimestampNanoTime() / 1000L) + audioTrackUtil.getTimestampFramePosition()) + startMediaTimeUs;
          break label37;
          label495:
          if (Math.abs(l3 - l2) > 5000000L)
          {
            str = "Spurious audio timestamp (system clock mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1;
            if (com.google.android.exoplayer.audio.AudioTrack.failOnSpuriousAudioTimestamp) {
              throw new AudioTrack.InvalidAudioTrackTimestampException(str);
            }
            Log.w("AudioTrack", str);
            audioTimestampSet = false;
            break label316;
          }
          if (Math.abs(localAudioTrack.framesToDurationUs(l4) - l1) <= 5000000L) {
            break label316;
          }
          String str = "Spurious audio timestamp (frame position mismatch): " + l4 + ", " + l3 + ", " + l2 + ", " + l1;
          if (com.google.android.exoplayer.audio.AudioTrack.failOnSpuriousAudioTimestamp) {
            throw new AudioTrack.InvalidAudioTrackTimestampException(str);
          }
          Log.w("AudioTrack", str);
          audioTimestampSet = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          getLatencyMethod = null;
        }
      }
      if (playheadOffsetCount == 0) {}
      for (long l2 = audioTrackUtil.getPlaybackHeadPositionUs() + startMediaTimeUs;; l2 = l1 + smoothedPlayheadOffsetUs + startMediaTimeUs)
      {
        l1 = l2;
        if (bool) {
          break;
        }
        l1 = l2 - latencyUs;
        break;
      }
      label771:
      l1 = Math.max(currentPositionUs, l1);
    }
  }
  
  public final void handleMessage(int paramInt, Object paramObject)
    throws ExoPlaybackException
  {
    if (paramInt == 1)
    {
      audioTrack.setVolume(((Float)paramObject).floatValue());
      return;
    }
    super.handleMessage(paramInt, paramObject);
  }
  
  protected final boolean handlesMimeType(String paramString)
  {
    return (MimeTypes.isAudio(paramString)) && (super.handlesMimeType(paramString));
  }
  
  protected final boolean isEnded()
  {
    if (super.isEnded())
    {
      if (audioTrack.hasPendingData())
      {
        com.google.android.exoplayer.audio.AudioTrack localAudioTrack = audioTrack;
        if (submittedBytes <= minBufferSize * 3 / 2) {
          break label47;
        }
      }
      label47:
      for (int i = 1; i == 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  protected final boolean isReady()
  {
    return (audioTrack.hasPendingData()) || ((super.isReady()) && (sourceState == 2));
  }
  
  protected final void onDisabled()
  {
    audioSessionId = 0;
    try
    {
      com.google.android.exoplayer.audio.AudioTrack localAudioTrack = audioTrack;
      localAudioTrack.reset();
      localAudioTrack.releaseKeepSessionIdAudioTrack();
      return;
    }
    finally
    {
      super.onDisabled();
    }
  }
  
  protected final void onEnabled(long paramLong, boolean paramBoolean)
  {
    super.onEnabled(paramLong, paramBoolean);
    seekToInternal(paramLong);
  }
  
  protected final void onOutputFormatChanged(MediaFormat paramMediaFormat, android.media.MediaFormat paramMediaFormat1)
  {
    if (MimeTypes.isPassthroughAudio(mimeType))
    {
      audioTrack.reconfigure(paramMediaFormat.getFrameworkMediaFormatV16());
      return;
    }
    audioTrack.reconfigure(paramMediaFormat1);
  }
  
  protected final void onStarted()
  {
    super.onStarted();
    audioTrack.play();
  }
  
  protected final void onStopped()
  {
    com.google.android.exoplayer.audio.AudioTrack localAudioTrack = audioTrack;
    if (localAudioTrack.isInitialized())
    {
      localAudioTrack.resetSyncParams();
      audioTrack.pause();
    }
    super.onStopped();
  }
  
  /* Error */
  protected final boolean processOutputBuffer(long paramLong1, long paramLong2, final MediaCodec paramMediaCodec, java.nio.ByteBuffer paramByteBuffer, android.media.MediaCodec.BufferInfo paramBufferInfo, int paramInt, boolean paramBoolean)
    throws ExoPlaybackException
  {
    // Byte code:
    //   0: iload 9
    //   2: ifeq +52 -> 54
    //   5: aload 5
    //   7: iload 8
    //   9: iconst_0
    //   10: invokevirtual 364	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   13: aload_0
    //   14: getfield 368	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:codecCounters	Lcom/google/android/exoplayer/CodecCounters;
    //   17: astore 5
    //   19: aload 5
    //   21: aload 5
    //   23: getfield 373	com/google/android/exoplayer/CodecCounters:skippedOutputBufferCount	I
    //   26: iconst_1
    //   27: iadd
    //   28: putfield 373	com/google/android/exoplayer/CodecCounters:skippedOutputBufferCount	I
    //   31: aload_0
    //   32: getfield 49	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:audioTrack	Lcom/google/android/exoplayer/audio/AudioTrack;
    //   35: astore 5
    //   37: aload 5
    //   39: getfield 122	com/google/android/exoplayer/audio/AudioTrack:startMediaTimeState	I
    //   42: iconst_1
    //   43: if_icmpne +9 -> 52
    //   46: aload 5
    //   48: iconst_2
    //   49: putfield 122	com/google/android/exoplayer/audio/AudioTrack:startMediaTimeState	I
    //   52: iconst_1
    //   53: ireturn
    //   54: aload_0
    //   55: getfield 49	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:audioTrack	Lcom/google/android/exoplayer/audio/AudioTrack;
    //   58: invokevirtual 119	com/google/android/exoplayer/audio/AudioTrack:isInitialized	()Z
    //   61: ifne +37 -> 98
    //   64: aload_0
    //   65: getfield 42	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:audioSessionId	I
    //   68: ifeq +111 -> 179
    //   71: aload_0
    //   72: getfield 49	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:audioTrack	Lcom/google/android/exoplayer/audio/AudioTrack;
    //   75: aload_0
    //   76: getfield 42	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:audioSessionId	I
    //   79: invokevirtual 377	com/google/android/exoplayer/audio/AudioTrack:initialize	(I)I
    //   82: pop
    //   83: aload_0
    //   84: getfield 382	com/google/android/exoplayer/TrackRenderer:state	I
    //   87: iconst_3
    //   88: if_icmpne +10 -> 98
    //   91: aload_0
    //   92: getfield 49	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:audioTrack	Lcom/google/android/exoplayer/audio/AudioTrack;
    //   95: invokevirtual 345	com/google/android/exoplayer/audio/AudioTrack:play	()V
    //   98: aload_0
    //   99: getfield 49	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:audioTrack	Lcom/google/android/exoplayer/audio/AudioTrack;
    //   102: astore 14
    //   104: aload 7
    //   106: getfield 387	android/media/MediaCodec$BufferInfo:offset	I
    //   109: istore 12
    //   111: aload 7
    //   113: getfield 390	android/media/MediaCodec$BufferInfo:size	I
    //   116: istore 13
    //   118: aload 7
    //   120: getfield 393	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   123: lstore_1
    //   124: iload 13
    //   126: ifne +112 -> 238
    //   129: iconst_2
    //   130: istore 10
    //   132: iload 10
    //   134: iconst_1
    //   135: iand
    //   136: ifeq +8 -> 144
    //   139: aload_0
    //   140: iconst_1
    //   141: putfield 58	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:allowPositionDiscontinuity	Z
    //   144: iload 10
    //   146: iconst_2
    //   147: iand
    //   148: ifeq +689 -> 837
    //   151: aload 5
    //   153: iload 8
    //   155: iconst_0
    //   156: invokevirtual 364	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   159: aload_0
    //   160: getfield 368	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:codecCounters	Lcom/google/android/exoplayer/CodecCounters;
    //   163: astore 5
    //   165: aload 5
    //   167: aload 5
    //   169: getfield 396	com/google/android/exoplayer/CodecCounters:renderedOutputBufferCount	I
    //   172: iconst_1
    //   173: iadd
    //   174: putfield 396	com/google/android/exoplayer/CodecCounters:renderedOutputBufferCount	I
    //   177: iconst_1
    //   178: ireturn
    //   179: aload_0
    //   180: aload_0
    //   181: getfield 49	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:audioTrack	Lcom/google/android/exoplayer/audio/AudioTrack;
    //   184: iconst_0
    //   185: invokevirtual 377	com/google/android/exoplayer/audio/AudioTrack:initialize	(I)I
    //   188: putfield 42	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:audioSessionId	I
    //   191: goto -108 -> 83
    //   194: astore 5
    //   196: aload_0
    //   197: getfield 400	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:eventHandler	Landroid/os/Handler;
    //   200: ifnull +28 -> 228
    //   203: aload_0
    //   204: getfield 40	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:eventListener	Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer$EventListener;
    //   207: ifnull +21 -> 228
    //   210: aload_0
    //   211: getfield 400	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:eventHandler	Landroid/os/Handler;
    //   214: new 8	com/google/android/exoplayer/MediaCodecAudioTrackRenderer$1
    //   217: dup
    //   218: aload_0
    //   219: aload 5
    //   221: invokespecial 403	com/google/android/exoplayer/MediaCodecAudioTrackRenderer$1:<init>	(Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;Lcom/google/android/exoplayer/audio/AudioTrack$InitializationException;)V
    //   224: invokevirtual 409	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   227: pop
    //   228: new 277	com/google/android/exoplayer/ExoPlaybackException
    //   231: dup
    //   232: aload 5
    //   234: invokespecial 412	com/google/android/exoplayer/ExoPlaybackException:<init>	(Ljava/lang/Throwable;)V
    //   237: athrow
    //   238: getstatic 417	com/google/android/exoplayer/util/Util:SDK_INT	I
    //   241: bipush 22
    //   243: if_icmpgt +60 -> 303
    //   246: aload 14
    //   248: getfield 170	com/google/android/exoplayer/audio/AudioTrack:isAc3	Z
    //   251: ifeq +52 -> 303
    //   254: aload 14
    //   256: getfield 127	com/google/android/exoplayer/audio/AudioTrack:audioTrack	Landroid/media/AudioTrack;
    //   259: invokevirtual 133	android/media/AudioTrack:getPlayState	()I
    //   262: iconst_2
    //   263: if_icmpne +9 -> 272
    //   266: iconst_0
    //   267: istore 10
    //   269: goto -137 -> 132
    //   272: aload 14
    //   274: getfield 127	com/google/android/exoplayer/audio/AudioTrack:audioTrack	Landroid/media/AudioTrack;
    //   277: invokevirtual 133	android/media/AudioTrack:getPlayState	()I
    //   280: iconst_1
    //   281: if_icmpne +22 -> 303
    //   284: aload 14
    //   286: getfield 137	com/google/android/exoplayer/audio/AudioTrack:audioTrackUtil	Lcom/google/android/exoplayer/audio/AudioTrack$AudioTrackUtil;
    //   289: invokevirtual 420	com/google/android/exoplayer/audio/AudioTrack$AudioTrackUtil:getPlaybackHeadPosition	()J
    //   292: lconst_0
    //   293: lcmp
    //   294: ifeq +9 -> 303
    //   297: iconst_0
    //   298: istore 10
    //   300: goto -168 -> 132
    //   303: iconst_0
    //   304: istore 11
    //   306: iload 11
    //   308: istore 10
    //   310: aload 14
    //   312: getfield 423	com/google/android/exoplayer/audio/AudioTrack:temporaryBufferSize	I
    //   315: ifne +78 -> 393
    //   318: aload 14
    //   320: getfield 170	com/google/android/exoplayer/audio/AudioTrack:isAc3	Z
    //   323: ifeq +26 -> 349
    //   326: aload 14
    //   328: getfield 426	com/google/android/exoplayer/audio/AudioTrack:ac3Bitrate	I
    //   331: ifne +18 -> 349
    //   334: aload 14
    //   336: iload 13
    //   338: aload 14
    //   340: getfield 429	com/google/android/exoplayer/audio/AudioTrack:sampleRate	I
    //   343: invokestatic 435	com/google/android/exoplayer/util/Ac3Util:getBitrate	(II)I
    //   346: putfield 426	com/google/android/exoplayer/audio/AudioTrack:ac3Bitrate	I
    //   349: lload_1
    //   350: aload 14
    //   352: aload 14
    //   354: iload 13
    //   356: i2l
    //   357: invokevirtual 212	com/google/android/exoplayer/audio/AudioTrack:bytesToFrames	(J)J
    //   360: invokevirtual 215	com/google/android/exoplayer/audio/AudioTrack:framesToDurationUs	(J)J
    //   363: lsub
    //   364: lstore_1
    //   365: aload 14
    //   367: getfield 122	com/google/android/exoplayer/audio/AudioTrack:startMediaTimeState	I
    //   370: ifne +271 -> 641
    //   373: aload 14
    //   375: lconst_0
    //   376: lload_1
    //   377: invokestatic 224	java/lang/Math:max	(JJ)J
    //   380: putfield 255	com/google/android/exoplayer/audio/AudioTrack:startMediaTimeUs	J
    //   383: aload 14
    //   385: iconst_1
    //   386: putfield 122	com/google/android/exoplayer/audio/AudioTrack:startMediaTimeState	I
    //   389: iload 11
    //   391: istore 10
    //   393: aload 14
    //   395: getfield 423	com/google/android/exoplayer/audio/AudioTrack:temporaryBufferSize	I
    //   398: ifne +74 -> 472
    //   401: aload 14
    //   403: iload 13
    //   405: putfield 423	com/google/android/exoplayer/audio/AudioTrack:temporaryBufferSize	I
    //   408: aload 6
    //   410: iload 12
    //   412: invokevirtual 441	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   415: pop
    //   416: getstatic 417	com/google/android/exoplayer/util/Util:SDK_INT	I
    //   419: bipush 21
    //   421: if_icmpge +51 -> 472
    //   424: aload 14
    //   426: getfield 445	com/google/android/exoplayer/audio/AudioTrack:temporaryBuffer	[B
    //   429: ifnull +14 -> 443
    //   432: aload 14
    //   434: getfield 445	com/google/android/exoplayer/audio/AudioTrack:temporaryBuffer	[B
    //   437: arraylength
    //   438: iload 13
    //   440: if_icmpge +12 -> 452
    //   443: aload 14
    //   445: iload 13
    //   447: newarray <illegal type>
    //   449: putfield 445	com/google/android/exoplayer/audio/AudioTrack:temporaryBuffer	[B
    //   452: aload 6
    //   454: aload 14
    //   456: getfield 445	com/google/android/exoplayer/audio/AudioTrack:temporaryBuffer	[B
    //   459: iconst_0
    //   460: iload 13
    //   462: invokevirtual 449	java/nio/ByteBuffer:get	([BII)Ljava/nio/ByteBuffer;
    //   465: pop
    //   466: aload 14
    //   468: iconst_0
    //   469: putfield 452	com/google/android/exoplayer/audio/AudioTrack:temporaryBufferOffset	I
    //   472: iconst_0
    //   473: istore 11
    //   475: getstatic 417	com/google/android/exoplayer/util/Util:SDK_INT	I
    //   478: bipush 21
    //   480: if_icmpge +289 -> 769
    //   483: aload 14
    //   485: getfield 302	com/google/android/exoplayer/audio/AudioTrack:submittedBytes	J
    //   488: aload 14
    //   490: getfield 137	com/google/android/exoplayer/audio/AudioTrack:audioTrackUtil	Lcom/google/android/exoplayer/audio/AudioTrack$AudioTrackUtil;
    //   493: invokevirtual 420	com/google/android/exoplayer/audio/AudioTrack$AudioTrackUtil:getPlaybackHeadPosition	()J
    //   496: aload 14
    //   498: getfield 455	com/google/android/exoplayer/audio/AudioTrack:frameSize	I
    //   501: i2l
    //   502: lmul
    //   503: lsub
    //   504: l2i
    //   505: istore 12
    //   507: aload 14
    //   509: getfield 208	com/google/android/exoplayer/audio/AudioTrack:bufferSize	I
    //   512: iload 12
    //   514: isub
    //   515: istore 12
    //   517: iload 12
    //   519: ifle +63 -> 582
    //   522: aload 14
    //   524: getfield 423	com/google/android/exoplayer/audio/AudioTrack:temporaryBufferSize	I
    //   527: iload 12
    //   529: invokestatic 458	java/lang/Math:min	(II)I
    //   532: istore 11
    //   534: aload 14
    //   536: getfield 127	com/google/android/exoplayer/audio/AudioTrack:audioTrack	Landroid/media/AudioTrack;
    //   539: aload 14
    //   541: getfield 445	com/google/android/exoplayer/audio/AudioTrack:temporaryBuffer	[B
    //   544: aload 14
    //   546: getfield 452	com/google/android/exoplayer/audio/AudioTrack:temporaryBufferOffset	I
    //   549: iload 11
    //   551: invokevirtual 462	android/media/AudioTrack:write	([BII)I
    //   554: istore 12
    //   556: iload 12
    //   558: istore 11
    //   560: iload 12
    //   562: iflt +20 -> 582
    //   565: aload 14
    //   567: aload 14
    //   569: getfield 452	com/google/android/exoplayer/audio/AudioTrack:temporaryBufferOffset	I
    //   572: iload 12
    //   574: iadd
    //   575: putfield 452	com/google/android/exoplayer/audio/AudioTrack:temporaryBufferOffset	I
    //   578: iload 12
    //   580: istore 11
    //   582: iload 11
    //   584: ifge +205 -> 789
    //   587: new 360	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   590: dup
    //   591: iload 11
    //   593: invokespecial 465	com/google/android/exoplayer/audio/AudioTrack$WriteException:<init>	(I)V
    //   596: athrow
    //   597: astore 5
    //   599: aload_0
    //   600: getfield 400	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:eventHandler	Landroid/os/Handler;
    //   603: ifnull +28 -> 631
    //   606: aload_0
    //   607: getfield 40	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:eventListener	Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer$EventListener;
    //   610: ifnull +21 -> 631
    //   613: aload_0
    //   614: getfield 400	com/google/android/exoplayer/MediaCodecAudioTrackRenderer:eventHandler	Landroid/os/Handler;
    //   617: new 10	com/google/android/exoplayer/MediaCodecAudioTrackRenderer$2
    //   620: dup
    //   621: aload_0
    //   622: aload 5
    //   624: invokespecial 468	com/google/android/exoplayer/MediaCodecAudioTrackRenderer$2:<init>	(Lcom/google/android/exoplayer/MediaCodecAudioTrackRenderer;Lcom/google/android/exoplayer/audio/AudioTrack$WriteException;)V
    //   627: invokevirtual 409	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   630: pop
    //   631: new 277	com/google/android/exoplayer/ExoPlaybackException
    //   634: dup
    //   635: aload 5
    //   637: invokespecial 412	com/google/android/exoplayer/ExoPlaybackException:<init>	(Ljava/lang/Throwable;)V
    //   640: athrow
    //   641: aload 14
    //   643: getfield 255	com/google/android/exoplayer/audio/AudioTrack:startMediaTimeUs	J
    //   646: aload 14
    //   648: aload 14
    //   650: aload 14
    //   652: getfield 302	com/google/android/exoplayer/audio/AudioTrack:submittedBytes	J
    //   655: invokevirtual 212	com/google/android/exoplayer/audio/AudioTrack:bytesToFrames	(J)J
    //   658: invokevirtual 215	com/google/android/exoplayer/audio/AudioTrack:framesToDurationUs	(J)J
    //   661: ladd
    //   662: lstore_3
    //   663: aload 14
    //   665: getfield 122	com/google/android/exoplayer/audio/AudioTrack:startMediaTimeState	I
    //   668: iconst_1
    //   669: if_icmpne +61 -> 730
    //   672: lload_3
    //   673: lload_1
    //   674: lsub
    //   675: invokestatic 258	java/lang/Math:abs	(J)J
    //   678: ldc2_w 469
    //   681: lcmp
    //   682: ifle +48 -> 730
    //   685: ldc -28
    //   687: new 230	java/lang/StringBuilder
    //   690: dup
    //   691: ldc_w 472
    //   694: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   697: lload_3
    //   698: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   701: ldc_w 474
    //   704: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: lload_1
    //   708: invokevirtual 239	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   711: ldc_w 476
    //   714: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: invokestatic 479	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   723: pop
    //   724: aload 14
    //   726: iconst_2
    //   727: putfield 122	com/google/android/exoplayer/audio/AudioTrack:startMediaTimeState	I
    //   730: iload 11
    //   732: istore 10
    //   734: aload 14
    //   736: getfield 122	com/google/android/exoplayer/audio/AudioTrack:startMediaTimeState	I
    //   739: iconst_2
    //   740: if_icmpne -347 -> 393
    //   743: aload 14
    //   745: lload_1
    //   746: lload_3
    //   747: lsub
    //   748: aload 14
    //   750: getfield 255	com/google/android/exoplayer/audio/AudioTrack:startMediaTimeUs	J
    //   753: ladd
    //   754: putfield 255	com/google/android/exoplayer/audio/AudioTrack:startMediaTimeUs	J
    //   757: aload 14
    //   759: iconst_1
    //   760: putfield 122	com/google/android/exoplayer/audio/AudioTrack:startMediaTimeState	I
    //   763: iconst_1
    //   764: istore 10
    //   766: goto -373 -> 393
    //   769: aload 14
    //   771: getfield 127	com/google/android/exoplayer/audio/AudioTrack:audioTrack	Landroid/media/AudioTrack;
    //   774: aload 6
    //   776: aload 14
    //   778: getfield 423	com/google/android/exoplayer/audio/AudioTrack:temporaryBufferSize	I
    //   781: invokestatic 483	com/google/android/exoplayer/audio/AudioTrack:writeNonBlockingV21	(Landroid/media/AudioTrack;Ljava/nio/ByteBuffer;I)I
    //   784: istore 11
    //   786: goto -204 -> 582
    //   789: aload 14
    //   791: aload 14
    //   793: getfield 423	com/google/android/exoplayer/audio/AudioTrack:temporaryBufferSize	I
    //   796: iload 11
    //   798: isub
    //   799: putfield 423	com/google/android/exoplayer/audio/AudioTrack:temporaryBufferSize	I
    //   802: aload 14
    //   804: aload 14
    //   806: getfield 302	com/google/android/exoplayer/audio/AudioTrack:submittedBytes	J
    //   809: iload 11
    //   811: i2l
    //   812: ladd
    //   813: putfield 302	com/google/android/exoplayer/audio/AudioTrack:submittedBytes	J
    //   816: aload 14
    //   818: getfield 423	com/google/android/exoplayer/audio/AudioTrack:temporaryBufferSize	I
    //   821: istore 11
    //   823: iload 11
    //   825: ifne +14 -> 839
    //   828: iload 10
    //   830: iconst_2
    //   831: ior
    //   832: istore 10
    //   834: goto -702 -> 132
    //   837: iconst_0
    //   838: ireturn
    //   839: goto -5 -> 834
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	842	0	this	MediaCodecAudioTrackRenderer
    //   0	842	1	paramLong1	long
    //   0	842	3	paramLong2	long
    //   0	842	5	paramMediaCodec	MediaCodec
    //   0	842	6	paramByteBuffer	java.nio.ByteBuffer
    //   0	842	7	paramBufferInfo	android.media.MediaCodec.BufferInfo
    //   0	842	8	paramInt	int
    //   0	842	9	paramBoolean	boolean
    //   130	703	10	i	int
    //   304	520	11	j	int
    //   109	470	12	k	int
    //   116	345	13	m	int
    //   102	715	14	localAudioTrack	com.google.android.exoplayer.audio.AudioTrack
    // Exception table:
    //   from	to	target	type
    //   64	83	194	com/google/android/exoplayer/audio/AudioTrack$InitializationException
    //   179	191	194	com/google/android/exoplayer/audio/AudioTrack$InitializationException
    //   98	124	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   238	266	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   272	297	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   310	349	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   349	389	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   393	443	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   443	452	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   452	472	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   475	517	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   522	556	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   565	578	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   587	597	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   641	730	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   734	763	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   769	786	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
    //   789	823	597	com/google/android/exoplayer/audio/AudioTrack$WriteException
  }
  
  protected final void seekTo(long paramLong)
    throws ExoPlaybackException
  {
    super.seekTo(paramLong);
    seekToInternal(paramLong);
  }
  
  public static abstract interface EventListener
    extends MediaCodecTrackRenderer.EventListener
  {
    public abstract void onAudioTrackInitializationError(AudioTrack.InitializationException paramInitializationException);
    
    public abstract void onAudioTrackWriteError(AudioTrack.WriteException paramWriteException);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.MediaCodecAudioTrackRenderer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */