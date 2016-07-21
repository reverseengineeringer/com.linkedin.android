package com.google.android.exoplayer.audio;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.MediaFormat;
import android.os.ConditionVariable;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.MimeTypes;
import com.google.android.exoplayer.util.Util;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class AudioTrack
{
  public static boolean enablePreV21AudioSessionWorkaround = false;
  public static boolean failOnSpuriousAudioTimestamp = false;
  public int ac3Bitrate;
  public boolean audioTimestampSet;
  public android.media.AudioTrack audioTrack;
  public final AudioTrackUtil audioTrackUtil;
  public int bufferSize;
  private int channelConfig;
  private int encoding;
  public int frameSize;
  public Method getLatencyMethod;
  public boolean isAc3;
  private android.media.AudioTrack keepSessionIdAudioTrack;
  public long lastPlayheadSampleTimeUs;
  public long lastTimestampSampleTimeUs;
  public long latencyUs;
  public int minBufferSize;
  public int nextPlayheadOffsetIndex;
  public int playheadOffsetCount;
  public final long[] playheadOffsets;
  private final ConditionVariable releasingConditionVariable = new ConditionVariable(true);
  public long resumeSystemTimeUs;
  public int sampleRate;
  public long smoothedPlayheadOffsetUs;
  public int startMediaTimeState;
  public long startMediaTimeUs;
  public long submittedBytes;
  public byte[] temporaryBuffer;
  public int temporaryBufferOffset;
  public int temporaryBufferSize;
  private float volume;
  
  public AudioTrack()
  {
    if (Util.SDK_INT >= 18) {}
    try
    {
      getLatencyMethod = android.media.AudioTrack.class.getMethod("getLatency", null);
      if (Util.SDK_INT >= 19) {}
      for (audioTrackUtil = new AudioTrackUtilV19();; audioTrackUtil = new AudioTrackUtil((byte)0))
      {
        playheadOffsets = new long[10];
        volume = 1.0F;
        startMediaTimeState = 0;
        return;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
  }
  
  @TargetApi(21)
  public static int writeNonBlockingV21(android.media.AudioTrack paramAudioTrack, ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramAudioTrack.write(paramByteBuffer, paramInt, 1);
  }
  
  public final long bytesToFrames(long paramLong)
  {
    if (isAc3)
    {
      if (ac3Bitrate == 0) {
        return 0L;
      }
      return 8L * paramLong * sampleRate / (ac3Bitrate * 1000);
    }
    return paramLong / frameSize;
  }
  
  public final long durationUsToFrames(long paramLong)
  {
    return sampleRate * paramLong / 1000000L;
  }
  
  public final long framesToDurationUs(long paramLong)
  {
    return 1000000L * paramLong / sampleRate;
  }
  
  public final boolean hasPendingData()
  {
    return (isInitialized()) && ((bytesToFrames(submittedBytes) > audioTrackUtil.getPlaybackHeadPosition()) || (audioTrackUtil.overrideHasPendingData()));
  }
  
  /* Error */
  public final int initialize(int paramInt)
    throws AudioTrack.InitializationException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 86	com/google/android/exoplayer/audio/AudioTrack:releasingConditionVariable	Landroid/os/ConditionVariable;
    //   4: invokevirtual 164	android/os/ConditionVariable:block	()V
    //   7: iload_1
    //   8: ifne +78 -> 86
    //   11: aload_0
    //   12: new 93	android/media/AudioTrack
    //   15: dup
    //   16: iconst_3
    //   17: aload_0
    //   18: getfield 135	com/google/android/exoplayer/audio/AudioTrack:sampleRate	I
    //   21: aload_0
    //   22: getfield 166	com/google/android/exoplayer/audio/AudioTrack:channelConfig	I
    //   25: aload_0
    //   26: getfield 168	com/google/android/exoplayer/audio/AudioTrack:encoding	I
    //   29: aload_0
    //   30: getfield 170	com/google/android/exoplayer/audio/AudioTrack:bufferSize	I
    //   33: iconst_1
    //   34: invokespecial 173	android/media/AudioTrack:<init>	(IIIIII)V
    //   37: putfield 175	com/google/android/exoplayer/audio/AudioTrack:audioTrack	Landroid/media/AudioTrack;
    //   40: aload_0
    //   41: getfield 175	com/google/android/exoplayer/audio/AudioTrack:audioTrack	Landroid/media/AudioTrack;
    //   44: invokevirtual 179	android/media/AudioTrack:getState	()I
    //   47: istore_1
    //   48: iload_1
    //   49: iconst_1
    //   50: if_icmpeq +86 -> 136
    //   53: aload_0
    //   54: getfield 175	com/google/android/exoplayer/audio/AudioTrack:audioTrack	Landroid/media/AudioTrack;
    //   57: invokevirtual 182	android/media/AudioTrack:release	()V
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 175	com/google/android/exoplayer/audio/AudioTrack:audioTrack	Landroid/media/AudioTrack;
    //   65: new 16	com/google/android/exoplayer/audio/AudioTrack$InitializationException
    //   68: dup
    //   69: iload_1
    //   70: aload_0
    //   71: getfield 135	com/google/android/exoplayer/audio/AudioTrack:sampleRate	I
    //   74: aload_0
    //   75: getfield 166	com/google/android/exoplayer/audio/AudioTrack:channelConfig	I
    //   78: aload_0
    //   79: getfield 170	com/google/android/exoplayer/audio/AudioTrack:bufferSize	I
    //   82: invokespecial 185	com/google/android/exoplayer/audio/AudioTrack$InitializationException:<init>	(IIII)V
    //   85: athrow
    //   86: aload_0
    //   87: new 93	android/media/AudioTrack
    //   90: dup
    //   91: iconst_3
    //   92: aload_0
    //   93: getfield 135	com/google/android/exoplayer/audio/AudioTrack:sampleRate	I
    //   96: aload_0
    //   97: getfield 166	com/google/android/exoplayer/audio/AudioTrack:channelConfig	I
    //   100: aload_0
    //   101: getfield 168	com/google/android/exoplayer/audio/AudioTrack:encoding	I
    //   104: aload_0
    //   105: getfield 170	com/google/android/exoplayer/audio/AudioTrack:bufferSize	I
    //   108: iconst_1
    //   109: iload_1
    //   110: invokespecial 188	android/media/AudioTrack:<init>	(IIIIIII)V
    //   113: putfield 175	com/google/android/exoplayer/audio/AudioTrack:audioTrack	Landroid/media/AudioTrack;
    //   116: goto -76 -> 40
    //   119: astore_2
    //   120: aload_0
    //   121: aconst_null
    //   122: putfield 175	com/google/android/exoplayer/audio/AudioTrack:audioTrack	Landroid/media/AudioTrack;
    //   125: goto -60 -> 65
    //   128: astore_2
    //   129: aload_0
    //   130: aconst_null
    //   131: putfield 175	com/google/android/exoplayer/audio/AudioTrack:audioTrack	Landroid/media/AudioTrack;
    //   134: aload_2
    //   135: athrow
    //   136: aload_0
    //   137: getfield 175	com/google/android/exoplayer/audio/AudioTrack:audioTrack	Landroid/media/AudioTrack;
    //   140: invokevirtual 191	android/media/AudioTrack:getAudioSessionId	()I
    //   143: istore_1
    //   144: getstatic 71	com/google/android/exoplayer/audio/AudioTrack:enablePreV21AudioSessionWorkaround	Z
    //   147: ifeq +60 -> 207
    //   150: getstatic 91	com/google/android/exoplayer/util/Util:SDK_INT	I
    //   153: bipush 21
    //   155: if_icmpge +52 -> 207
    //   158: aload_0
    //   159: getfield 193	com/google/android/exoplayer/audio/AudioTrack:keepSessionIdAudioTrack	Landroid/media/AudioTrack;
    //   162: ifnull +18 -> 180
    //   165: iload_1
    //   166: aload_0
    //   167: getfield 193	com/google/android/exoplayer/audio/AudioTrack:keepSessionIdAudioTrack	Landroid/media/AudioTrack;
    //   170: invokevirtual 191	android/media/AudioTrack:getAudioSessionId	()I
    //   173: if_icmpeq +7 -> 180
    //   176: aload_0
    //   177: invokevirtual 196	com/google/android/exoplayer/audio/AudioTrack:releaseKeepSessionIdAudioTrack	()V
    //   180: aload_0
    //   181: getfield 193	com/google/android/exoplayer/audio/AudioTrack:keepSessionIdAudioTrack	Landroid/media/AudioTrack;
    //   184: ifnonnull +23 -> 207
    //   187: aload_0
    //   188: new 93	android/media/AudioTrack
    //   191: dup
    //   192: iconst_3
    //   193: sipush 4000
    //   196: iconst_4
    //   197: iconst_2
    //   198: iconst_2
    //   199: iconst_0
    //   200: iload_1
    //   201: invokespecial 188	android/media/AudioTrack:<init>	(IIIIIII)V
    //   204: putfield 193	com/google/android/exoplayer/audio/AudioTrack:keepSessionIdAudioTrack	Landroid/media/AudioTrack;
    //   207: aload_0
    //   208: getfield 106	com/google/android/exoplayer/audio/AudioTrack:audioTrackUtil	Lcom/google/android/exoplayer/audio/AudioTrack$AudioTrackUtil;
    //   211: aload_0
    //   212: getfield 175	com/google/android/exoplayer/audio/AudioTrack:audioTrack	Landroid/media/AudioTrack;
    //   215: aload_0
    //   216: getfield 129	com/google/android/exoplayer/audio/AudioTrack:isAc3	Z
    //   219: invokevirtual 200	com/google/android/exoplayer/audio/AudioTrack$AudioTrackUtil:reconfigure	(Landroid/media/AudioTrack;Z)V
    //   222: aload_0
    //   223: aload_0
    //   224: getfield 110	com/google/android/exoplayer/audio/AudioTrack:volume	F
    //   227: invokevirtual 204	com/google/android/exoplayer/audio/AudioTrack:setVolume	(F)V
    //   230: iload_1
    //   231: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	AudioTrack
    //   0	232	1	paramInt	int
    //   119	1	2	localException	Exception
    //   128	7	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   53	60	119	java/lang/Exception
    //   53	60	128	finally
  }
  
  public final boolean isInitialized()
  {
    return audioTrack != null;
  }
  
  public final void play()
  {
    if (isInitialized())
    {
      resumeSystemTimeUs = (System.nanoTime() / 1000L);
      audioTrack.play();
    }
  }
  
  public final void reconfigure(MediaFormat paramMediaFormat)
  {
    boolean bool2 = true;
    int k = paramMediaFormat.getInteger("channel-count");
    int i;
    int j;
    label113:
    boolean bool1;
    switch (k)
    {
    case 3: 
    case 4: 
    case 5: 
    case 7: 
    default: 
      throw new IllegalArgumentException("Unsupported channel count: " + k);
    case 1: 
      i = 4;
      int m = paramMediaFormat.getInteger("sample-rate");
      paramMediaFormat = paramMediaFormat.getString("mime");
      if ("audio/ac3".equals(paramMediaFormat))
      {
        j = 5;
        if ((j != 5) && (j != 6)) {
          break label342;
        }
        bool1 = true;
        label127:
        if ((!isInitialized()) || (sampleRate != m) || (channelConfig != i) || (isAc3) || (bool1))
        {
          reset();
          encoding = j;
          sampleRate = m;
          channelConfig = i;
          isAc3 = bool1;
          ac3Bitrate = 0;
          frameSize = (k * 2);
          minBufferSize = android.media.AudioTrack.getMinBufferSize(m, i, j);
          if (minBufferSize == -2) {
            break label348;
          }
          bool1 = bool2;
          label226:
          Assertions.checkState(bool1);
          i = minBufferSize * 4;
          j = (int)durationUsToFrames(250000L) * frameSize;
          k = (int)Math.max(minBufferSize, durationUsToFrames(750000L) * frameSize);
          if (i >= j) {
            break label354;
          }
          i = j;
        }
      }
      break;
    }
    for (;;)
    {
      bufferSize = i;
      return;
      i = 12;
      break;
      i = 252;
      break;
      i = 1020;
      break;
      if ("audio/eac3".equals(paramMediaFormat))
      {
        j = 6;
        break label113;
      }
      if (MimeTypes.isAudio(paramMediaFormat))
      {
        j = 2;
        break label113;
      }
      j = 0;
      break label113;
      label342:
      bool1 = false;
      break label127;
      label348:
      bool1 = false;
      break label226;
      label354:
      if (i > k) {
        i = k;
      }
    }
  }
  
  public final void releaseKeepSessionIdAudioTrack()
  {
    if (keepSessionIdAudioTrack == null) {
      return;
    }
    final android.media.AudioTrack localAudioTrack = keepSessionIdAudioTrack;
    keepSessionIdAudioTrack = null;
    new Thread()
    {
      public final void run()
      {
        localAudioTrack.release();
      }
    }.start();
  }
  
  public final void reset()
  {
    if (isInitialized())
    {
      submittedBytes = 0L;
      temporaryBufferSize = 0;
      startMediaTimeState = 0;
      latencyUs = 0L;
      resetSyncParams();
      if (audioTrack.getPlayState() == 3) {
        audioTrack.pause();
      }
      final android.media.AudioTrack localAudioTrack = audioTrack;
      audioTrack = null;
      audioTrackUtil.reconfigure(null, false);
      releasingConditionVariable.close();
      new Thread()
      {
        public final void run()
        {
          try
          {
            localAudioTrack.release();
            return;
          }
          finally
          {
            releasingConditionVariable.open();
          }
        }
      }.start();
    }
  }
  
  public final void resetSyncParams()
  {
    smoothedPlayheadOffsetUs = 0L;
    playheadOffsetCount = 0;
    nextPlayheadOffsetIndex = 0;
    lastPlayheadSampleTimeUs = 0L;
    audioTimestampSet = false;
    lastTimestampSampleTimeUs = 0L;
  }
  
  public final void setVolume(float paramFloat)
  {
    volume = paramFloat;
    if (isInitialized())
    {
      if (Util.SDK_INT >= 21) {
        audioTrack.setVolume(paramFloat);
      }
    }
    else {
      return;
    }
    audioTrack.setStereoVolume(paramFloat, paramFloat);
  }
  
  private static class AudioTrackUtil
  {
    protected android.media.AudioTrack audioTrack;
    private boolean isPassthrough;
    private long lastRawPlaybackHeadPosition;
    private long passthroughWorkaroundPauseOffset;
    private long rawPlaybackHeadWrapCount;
    private int sampleRate;
    
    public final long getPlaybackHeadPosition()
    {
      long l2 = 0xFFFFFFFF & audioTrack.getPlaybackHeadPosition();
      long l1 = l2;
      if (Util.SDK_INT <= 22)
      {
        l1 = l2;
        if (isPassthrough)
        {
          if (audioTrack.getPlayState() != 1) {
            break label89;
          }
          lastRawPlaybackHeadPosition = l2;
        }
      }
      for (;;)
      {
        l1 = l2 + passthroughWorkaroundPauseOffset;
        if (lastRawPlaybackHeadPosition > l1) {
          rawPlaybackHeadWrapCount += 1L;
        }
        lastRawPlaybackHeadPosition = l1;
        return (rawPlaybackHeadWrapCount << 32) + l1;
        label89:
        if ((audioTrack.getPlayState() == 2) && (l2 == 0L)) {
          passthroughWorkaroundPauseOffset = lastRawPlaybackHeadPosition;
        }
      }
    }
    
    public final long getPlaybackHeadPositionUs()
    {
      return getPlaybackHeadPosition() * 1000000L / sampleRate;
    }
    
    public long getTimestampFramePosition()
    {
      throw new UnsupportedOperationException();
    }
    
    public long getTimestampNanoTime()
    {
      throw new UnsupportedOperationException();
    }
    
    public final boolean overrideHasPendingData()
    {
      return (Util.SDK_INT <= 22) && (isPassthrough) && (audioTrack.getPlayState() == 2) && (audioTrack.getPlaybackHeadPosition() == 0);
    }
    
    public void reconfigure(android.media.AudioTrack paramAudioTrack, boolean paramBoolean)
    {
      audioTrack = paramAudioTrack;
      isPassthrough = paramBoolean;
      lastRawPlaybackHeadPosition = 0L;
      rawPlaybackHeadWrapCount = 0L;
      passthroughWorkaroundPauseOffset = 0L;
      if (paramAudioTrack != null) {
        sampleRate = paramAudioTrack.getSampleRate();
      }
    }
    
    public boolean updateTimestamp()
    {
      return false;
    }
  }
  
  @TargetApi(19)
  private static final class AudioTrackUtilV19
    extends AudioTrack.AudioTrackUtil
  {
    private final AudioTimestamp audioTimestamp = new AudioTimestamp();
    private long lastRawTimestampFramePosition;
    private long lastTimestampFramePosition;
    private long rawTimestampFramePositionWrapCount;
    
    public AudioTrackUtilV19()
    {
      super();
    }
    
    public final long getTimestampFramePosition()
    {
      return lastTimestampFramePosition;
    }
    
    public final long getTimestampNanoTime()
    {
      return audioTimestamp.nanoTime;
    }
    
    public final void reconfigure(android.media.AudioTrack paramAudioTrack, boolean paramBoolean)
    {
      super.reconfigure(paramAudioTrack, paramBoolean);
      rawTimestampFramePositionWrapCount = 0L;
      lastRawTimestampFramePosition = 0L;
      lastTimestampFramePosition = 0L;
    }
    
    public final boolean updateTimestamp()
    {
      boolean bool = audioTrack.getTimestamp(audioTimestamp);
      if (bool)
      {
        long l = audioTimestamp.framePosition;
        if (lastRawTimestampFramePosition > l) {
          rawTimestampFramePositionWrapCount += 1L;
        }
        lastRawTimestampFramePosition = l;
        lastTimestampFramePosition = ((rawTimestampFramePositionWrapCount << 32) + l);
      }
      return bool;
    }
  }
  
  public static final class InitializationException
    extends Exception
  {
    public final int audioTrackState;
    
    public InitializationException(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super();
      audioTrackState = paramInt1;
    }
  }
  
  public static final class InvalidAudioTrackTimestampException
    extends RuntimeException
  {
    public InvalidAudioTrackTimestampException(String paramString)
    {
      super();
    }
  }
  
  public static final class WriteException
    extends Exception
  {
    public final int errorCode;
    
    public WriteException(int paramInt)
    {
      super();
      errorCode = paramInt;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.audio.AudioTrack
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */