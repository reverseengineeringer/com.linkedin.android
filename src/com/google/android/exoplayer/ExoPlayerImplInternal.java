package com.google.android.exoplayer;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.PriorityHandlerThread;
import java.util.ArrayList;
import java.util.List;

final class ExoPlayerImplInternal
  implements Handler.Callback
{
  volatile long bufferedPositionUs;
  private int customMessagesProcessed = 0;
  int customMessagesSent = 0;
  volatile long durationUs;
  private long elapsedRealtimeUs;
  private final List<TrackRenderer> enabledRenderers;
  private final Handler eventHandler;
  final Handler handler;
  private final HandlerThread internalPlaybackThread;
  private final long minBufferUs;
  private final long minRebufferUs;
  private boolean playWhenReady;
  volatile long positionUs;
  private boolean rebuffering;
  private boolean released;
  private final boolean[] rendererEnabledFlags;
  private MediaClock rendererMediaClock;
  private TrackRenderer rendererMediaClockSource;
  private TrackRenderer[] renderers;
  private final StandaloneMediaClock standaloneMediaClock;
  private int state;
  
  public ExoPlayerImplInternal(Handler paramHandler, boolean paramBoolean, boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2)
  {
    eventHandler = paramHandler;
    playWhenReady = paramBoolean;
    rendererEnabledFlags = new boolean[paramArrayOfBoolean.length];
    minBufferUs = (paramInt1 * 1000L);
    minRebufferUs = (paramInt2 * 1000L);
    paramInt1 = 0;
    while (paramInt1 < paramArrayOfBoolean.length)
    {
      rendererEnabledFlags[paramInt1] = paramArrayOfBoolean[paramInt1];
      paramInt1 += 1;
    }
    state = 1;
    durationUs = -1L;
    bufferedPositionUs = -1L;
    standaloneMediaClock = new StandaloneMediaClock();
    enabledRenderers = new ArrayList(paramArrayOfBoolean.length);
    internalPlaybackThread = new PriorityHandlerThread(getClass().getSimpleName() + ":Handler");
    internalPlaybackThread.start();
    handler = new Handler(internalPlaybackThread.getLooper(), this);
  }
  
  private static void ensureStopped(TrackRenderer paramTrackRenderer)
    throws ExoPlaybackException
  {
    if (state == 3) {
      paramTrackRenderer.stop();
    }
  }
  
  private void incrementalPrepareInternal()
    throws ExoPlaybackException
  {
    long l1 = SystemClock.elapsedRealtime();
    int j = 1;
    int i = 0;
    boolean bool;
    if (i < renderers.length)
    {
      localObject = renderers[i];
      k = j;
      if (state == 0)
      {
        l2 = positionUs;
        if (state != 0) {
          break label130;
        }
        bool = true;
        label53:
        Assertions.checkState(bool);
        state = ((TrackRenderer)localObject).doPrepare(l2);
        if ((state != 0) && (state != 1) && (state != -1)) {
          break label136;
        }
      }
      label130:
      label136:
      for (bool = true;; bool = false)
      {
        Assertions.checkState(bool);
        k = j;
        if (state == 0)
        {
          ((TrackRenderer)localObject).maybeThrowError();
          k = 0;
        }
        i += 1;
        j = k;
        break;
        bool = false;
        break label53;
      }
    }
    if (j == 0)
    {
      scheduleNextOperation(2, l1, 10L);
      return;
    }
    long l2 = 0L;
    int n = 1;
    int m = 1;
    Object localObject = new boolean[renderers.length];
    int k = 0;
    if (k < renderers.length)
    {
      TrackRenderer localTrackRenderer = renderers[k];
      if (state == 1)
      {
        bool = true;
        label206:
        localObject[k] = bool;
        j = n;
        i = m;
        l3 = l2;
        if (localObject[k] != 0)
        {
          l1 = l2;
          if (l2 != -1L)
          {
            l3 = localTrackRenderer.getDurationUs();
            if (l3 != -1L) {
              break label362;
            }
            l1 = -1L;
          }
          label263:
          j = n;
          i = m;
          l3 = l1;
          if (rendererEnabledFlags[k] != 0)
          {
            localTrackRenderer.enable(positionUs, false);
            enabledRenderers.add(localTrackRenderer);
            if ((n == 0) || (!localTrackRenderer.isEnded())) {
              break label387;
            }
            j = 1;
            label319:
            if ((m == 0) || (!rendererReadyOrEnded(localTrackRenderer))) {
              break label392;
            }
            i = 1;
          }
        }
      }
      for (long l3 = l1;; l3 = l1)
      {
        k += 1;
        n = j;
        m = i;
        l2 = l3;
        break;
        bool = false;
        break label206;
        label362:
        l1 = l2;
        if (l3 == -2L) {
          break label263;
        }
        l1 = Math.max(l2, l3);
        break label263;
        label387:
        j = 0;
        break label319;
        label392:
        i = 0;
      }
    }
    durationUs = l2;
    if ((n != 0) && ((l2 == -1L) || (l2 <= positionUs))) {
      i = 5;
    }
    for (;;)
    {
      state = i;
      eventHandler.obtainMessage(1, state, 0, localObject).sendToTarget();
      if ((playWhenReady) && (state == 4)) {
        startRenderers();
      }
      handler.sendEmptyMessage(7);
      return;
      if (m != 0) {
        i = 4;
      } else {
        i = 3;
      }
    }
  }
  
  private boolean rendererReadyOrEnded(TrackRenderer paramTrackRenderer)
  {
    if (paramTrackRenderer.isEnded()) {}
    for (;;)
    {
      return true;
      if (!paramTrackRenderer.isReady()) {
        return false;
      }
      if (state != 4)
      {
        long l2 = paramTrackRenderer.getDurationUs();
        long l3 = paramTrackRenderer.getBufferedPositionUs();
        if (rebuffering) {}
        for (long l1 = minRebufferUs; (l1 > 0L) && (l3 != -1L) && (l3 != -3L) && (l3 < positionUs + l1) && ((l2 == -1L) || (l2 == -2L) || (l3 < l2)); l1 = minBufferUs) {
          return false;
        }
      }
    }
  }
  
  private void resetInternal()
  {
    handler.removeMessages(7);
    handler.removeMessages(2);
    rebuffering = false;
    standaloneMediaClock.stop();
    if (renderers == null) {
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i < renderers.length)
      {
        TrackRenderer localTrackRenderer = renderers[i];
        try
        {
          ensureStopped(localTrackRenderer);
          if (state == 2) {
            localTrackRenderer.disable();
          }
          try
          {
            if ((state == 2) || (state == 3) || (state == -2)) {
              break label149;
            }
            bool = true;
            Assertions.checkState(bool);
            state = -2;
            localTrackRenderer.onReleased();
          }
          catch (ExoPlaybackException localExoPlaybackException1)
          {
            for (;;)
            {
              boolean bool;
              Log.e("ExoPlayerImplInternal", "Release failed.", localExoPlaybackException1);
            }
          }
          catch (RuntimeException localRuntimeException1)
          {
            for (;;)
            {
              Log.e("ExoPlayerImplInternal", "Release failed.", localRuntimeException1);
            }
          }
          i += 1;
        }
        catch (ExoPlaybackException localExoPlaybackException2)
        {
          for (;;)
          {
            Log.e("ExoPlayerImplInternal", "Stop failed.", localExoPlaybackException2);
          }
        }
        catch (RuntimeException localRuntimeException2)
        {
          for (;;)
          {
            Log.e("ExoPlayerImplInternal", "Stop failed.", localRuntimeException2);
            continue;
            label149:
            bool = false;
          }
        }
      }
    }
    renderers = null;
    rendererMediaClock = null;
    rendererMediaClockSource = null;
    enabledRenderers.clear();
  }
  
  private void scheduleNextOperation(int paramInt, long paramLong1, long paramLong2)
  {
    paramLong1 = paramLong1 + paramLong2 - SystemClock.elapsedRealtime();
    if (paramLong1 <= 0L)
    {
      handler.sendEmptyMessage(paramInt);
      return;
    }
    handler.sendEmptyMessageDelayed(paramInt, paramLong1);
  }
  
  private void setState(int paramInt)
  {
    if (state != paramInt)
    {
      state = paramInt;
      eventHandler.obtainMessage(2, paramInt, 0).sendToTarget();
    }
  }
  
  private void startRenderers()
    throws ExoPlaybackException
  {
    rebuffering = false;
    StandaloneMediaClock localStandaloneMediaClock = standaloneMediaClock;
    if (!started)
    {
      started = true;
      deltaUs = StandaloneMediaClock.elapsedRealtimeMinus(positionUs);
    }
    int i = 0;
    while (i < enabledRenderers.size())
    {
      ((TrackRenderer)enabledRenderers.get(i)).start();
      i += 1;
    }
  }
  
  private void stopInternal()
  {
    resetInternal();
    setState(1);
  }
  
  private void stopRenderers()
    throws ExoPlaybackException
  {
    standaloneMediaClock.stop();
    int i = 0;
    while (i < enabledRenderers.size())
    {
      ensureStopped((TrackRenderer)enabledRenderers.get(i));
      i += 1;
    }
  }
  
  private void updatePositionUs()
  {
    if ((rendererMediaClock != null) && (enabledRenderers.contains(rendererMediaClockSource)) && (!rendererMediaClockSource.isEnded()))
    {
      positionUs = rendererMediaClock.getPositionUs();
      standaloneMediaClock.setPositionUs(positionUs);
    }
    for (;;)
    {
      elapsedRealtimeUs = (SystemClock.elapsedRealtime() * 1000L);
      return;
      positionUs = standaloneMediaClock.getPositionUs();
    }
  }
  
  /* Error */
  public final void blockingSendMessage$2158118c(ExoPlayer.ExoPlayerComponent paramExoPlayerComponent, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 312	com/google/android/exoplayer/ExoPlayerImplInternal:released	Z
    //   6: ifeq +15 -> 21
    //   9: ldc -17
    //   11: ldc_w 314
    //   14: invokestatic 318	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   17: pop
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 46	com/google/android/exoplayer/ExoPlayerImplInternal:customMessagesSent	I
    //   25: istore_3
    //   26: aload_0
    //   27: iload_3
    //   28: iconst_1
    //   29: iadd
    //   30: putfield 46	com/google/android/exoplayer/ExoPlayerImplInternal:customMessagesSent	I
    //   33: aload_0
    //   34: getfield 125	com/google/android/exoplayer/ExoPlayerImplInternal:handler	Landroid/os/Handler;
    //   37: bipush 9
    //   39: iconst_1
    //   40: iconst_0
    //   41: aload_1
    //   42: aload_2
    //   43: invokestatic 324	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   46: invokevirtual 200	android/os/Handler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   49: invokevirtual 205	android/os/Message:sendToTarget	()V
    //   52: aload_0
    //   53: getfield 48	com/google/android/exoplayer/ExoPlayerImplInternal:customMessagesProcessed	I
    //   56: istore 4
    //   58: iload 4
    //   60: iload_3
    //   61: if_icmpgt -43 -> 18
    //   64: aload_0
    //   65: invokevirtual 327	java/lang/Object:wait	()V
    //   68: goto -16 -> 52
    //   71: astore_1
    //   72: invokestatic 333	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   75: invokevirtual 336	java/lang/Thread:interrupt	()V
    //   78: goto -26 -> 52
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	ExoPlayerImplInternal
    //   0	86	1	paramExoPlayerComponent	ExoPlayer.ExoPlayerComponent
    //   0	86	2	paramObject	Object
    //   25	37	3	i	int
    //   56	6	4	j	int
    // Exception table:
    //   from	to	target	type
    //   64	68	71	java/lang/InterruptedException
    //   2	18	81	finally
    //   21	52	81	finally
    //   52	58	81	finally
    //   64	68	81	finally
    //   72	78	81	finally
  }
  
  /* Error */
  public final boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 341	android/os/Message:what	I
    //   4: tableswitch	default:+1130->1134, 1:+52->56, 2:+135->139, 3:+141->145, 4:+791->795, 5:+797->801, 6:+663->667, 7:+285->289, 8:+935->939, 9:+826->830
    //   56: aload_1
    //   57: getfield 345	android/os/Message:obj	Ljava/lang/Object;
    //   60: checkcast 346	[Lcom/google/android/exoplayer/TrackRenderer;
    //   63: checkcast 346	[Lcom/google/android/exoplayer/TrackRenderer;
    //   66: astore_1
    //   67: aload_0
    //   68: invokespecial 287	com/google/android/exoplayer/ExoPlayerImplInternal:resetInternal	()V
    //   71: aload_0
    //   72: aload_1
    //   73: putfield 146	com/google/android/exoplayer/ExoPlayerImplInternal:renderers	[Lcom/google/android/exoplayer/TrackRenderer;
    //   76: iconst_0
    //   77: istore_2
    //   78: iload_2
    //   79: aload_1
    //   80: arraylength
    //   81: if_icmpge +47 -> 128
    //   84: aload_1
    //   85: iload_2
    //   86: aaload
    //   87: invokevirtual 350	com/google/android/exoplayer/TrackRenderer:getMediaClock	()Lcom/google/android/exoplayer/MediaClock;
    //   90: astore 14
    //   92: aload 14
    //   94: ifnull +1042 -> 1136
    //   97: aload_0
    //   98: getfield 251	com/google/android/exoplayer/ExoPlayerImplInternal:rendererMediaClock	Lcom/google/android/exoplayer/MediaClock;
    //   101: ifnonnull +1042 -> 1143
    //   104: iconst_1
    //   105: istore 5
    //   107: iload 5
    //   109: invokestatic 154	com/google/android/exoplayer/util/Assertions:checkState	(Z)V
    //   112: aload_0
    //   113: aload 14
    //   115: putfield 251	com/google/android/exoplayer/ExoPlayerImplInternal:rendererMediaClock	Lcom/google/android/exoplayer/MediaClock;
    //   118: aload_0
    //   119: aload_1
    //   120: iload_2
    //   121: aaload
    //   122: putfield 253	com/google/android/exoplayer/ExoPlayerImplInternal:rendererMediaClockSource	Lcom/google/android/exoplayer/TrackRenderer;
    //   125: goto +1011 -> 1136
    //   128: aload_0
    //   129: iconst_2
    //   130: invokespecial 289	com/google/android/exoplayer/ExoPlayerImplInternal:setState	(I)V
    //   133: aload_0
    //   134: invokespecial 352	com/google/android/exoplayer/ExoPlayerImplInternal:incrementalPrepareInternal	()V
    //   137: iconst_1
    //   138: ireturn
    //   139: aload_0
    //   140: invokespecial 352	com/google/android/exoplayer/ExoPlayerImplInternal:incrementalPrepareInternal	()V
    //   143: iconst_1
    //   144: ireturn
    //   145: aload_1
    //   146: getfield 355	android/os/Message:arg1	I
    //   149: istore_2
    //   150: iload_2
    //   151: ifeq +43 -> 194
    //   154: iconst_1
    //   155: istore 5
    //   157: aload_0
    //   158: iconst_0
    //   159: putfield 220	com/google/android/exoplayer/ExoPlayerImplInternal:rebuffering	Z
    //   162: aload_0
    //   163: iload 5
    //   165: putfield 52	com/google/android/exoplayer/ExoPlayerImplInternal:playWhenReady	Z
    //   168: iload 5
    //   170: ifne +30 -> 200
    //   173: aload_0
    //   174: invokespecial 357	com/google/android/exoplayer/ExoPlayerImplInternal:stopRenderers	()V
    //   177: aload_0
    //   178: invokespecial 359	com/google/android/exoplayer/ExoPlayerImplInternal:updatePositionUs	()V
    //   181: aload_0
    //   182: getfield 50	com/google/android/exoplayer/ExoPlayerImplInternal:eventHandler	Landroid/os/Handler;
    //   185: iconst_3
    //   186: invokevirtual 362	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   189: invokevirtual 205	android/os/Message:sendToTarget	()V
    //   192: iconst_1
    //   193: ireturn
    //   194: iconst_0
    //   195: istore 5
    //   197: goto -40 -> 157
    //   200: aload_0
    //   201: getfield 62	com/google/android/exoplayer/ExoPlayerImplInternal:state	I
    //   204: iconst_4
    //   205: if_icmpne +63 -> 268
    //   208: aload_0
    //   209: invokespecial 208	com/google/android/exoplayer/ExoPlayerImplInternal:startRenderers	()V
    //   212: aload_0
    //   213: getfield 125	com/google/android/exoplayer/ExoPlayerImplInternal:handler	Landroid/os/Handler;
    //   216: bipush 7
    //   218: invokevirtual 212	android/os/Handler:sendEmptyMessage	(I)Z
    //   221: pop
    //   222: goto -41 -> 181
    //   225: astore_1
    //   226: aload_0
    //   227: getfield 50	com/google/android/exoplayer/ExoPlayerImplInternal:eventHandler	Landroid/os/Handler;
    //   230: iconst_3
    //   231: invokevirtual 362	android/os/Handler:obtainMessage	(I)Landroid/os/Message;
    //   234: invokevirtual 205	android/os/Message:sendToTarget	()V
    //   237: aload_1
    //   238: athrow
    //   239: astore_1
    //   240: ldc -17
    //   242: ldc_w 364
    //   245: aload_1
    //   246: invokestatic 247	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   249: pop
    //   250: aload_0
    //   251: getfield 50	com/google/android/exoplayer/ExoPlayerImplInternal:eventHandler	Landroid/os/Handler;
    //   254: iconst_4
    //   255: aload_1
    //   256: invokevirtual 367	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   259: invokevirtual 205	android/os/Message:sendToTarget	()V
    //   262: aload_0
    //   263: invokespecial 369	com/google/android/exoplayer/ExoPlayerImplInternal:stopInternal	()V
    //   266: iconst_1
    //   267: ireturn
    //   268: aload_0
    //   269: getfield 62	com/google/android/exoplayer/ExoPlayerImplInternal:state	I
    //   272: iconst_3
    //   273: if_icmpne -92 -> 181
    //   276: aload_0
    //   277: getfield 125	com/google/android/exoplayer/ExoPlayerImplInternal:handler	Landroid/os/Handler;
    //   280: bipush 7
    //   282: invokevirtual 212	android/os/Handler:sendEmptyMessage	(I)Z
    //   285: pop
    //   286: goto -105 -> 181
    //   289: ldc_w 371
    //   292: invokestatic 376	com/google/android/exoplayer/util/TraceUtil:beginSection	(Ljava/lang/String;)V
    //   295: invokestatic 144	android/os/SystemClock:elapsedRealtime	()J
    //   298: lstore 8
    //   300: aload_0
    //   301: getfield 66	com/google/android/exoplayer/ExoPlayerImplInternal:durationUs	J
    //   304: ldc2_w 63
    //   307: lcmp
    //   308: ifeq +864 -> 1172
    //   311: aload_0
    //   312: getfield 66	com/google/android/exoplayer/ExoPlayerImplInternal:durationUs	J
    //   315: lstore 6
    //   317: iconst_1
    //   318: istore_2
    //   319: iconst_1
    //   320: istore_3
    //   321: aload_0
    //   322: invokespecial 359	com/google/android/exoplayer/ExoPlayerImplInternal:updatePositionUs	()V
    //   325: iconst_0
    //   326: istore 4
    //   328: iload 4
    //   330: aload_0
    //   331: getfield 80	com/google/android/exoplayer/ExoPlayerImplInternal:enabledRenderers	Ljava/util/List;
    //   334: invokeinterface 279 1 0
    //   339: if_icmpge +112 -> 451
    //   342: aload_0
    //   343: getfield 80	com/google/android/exoplayer/ExoPlayerImplInternal:enabledRenderers	Ljava/util/List;
    //   346: iload 4
    //   348: invokeinterface 283 2 0
    //   353: checkcast 132	com/google/android/exoplayer/TrackRenderer
    //   356: astore_1
    //   357: aload_1
    //   358: aload_0
    //   359: getfield 148	com/google/android/exoplayer/ExoPlayerImplInternal:positionUs	J
    //   362: aload_0
    //   363: getfield 305	com/google/android/exoplayer/ExoPlayerImplInternal:elapsedRealtimeUs	J
    //   366: invokevirtual 379	com/google/android/exoplayer/TrackRenderer:doSomeWork	(JJ)V
    //   369: iload_2
    //   370: ifeq +810 -> 1180
    //   373: aload_1
    //   374: invokevirtual 184	com/google/android/exoplayer/TrackRenderer:isEnded	()Z
    //   377: ifeq +803 -> 1180
    //   380: iconst_1
    //   381: istore_2
    //   382: aload_0
    //   383: aload_1
    //   384: invokespecial 188	com/google/android/exoplayer/ExoPlayerImplInternal:rendererReadyOrEnded	(Lcom/google/android/exoplayer/TrackRenderer;)Z
    //   387: istore 5
    //   389: iload 5
    //   391: ifne +758 -> 1149
    //   394: aload_1
    //   395: invokevirtual 161	com/google/android/exoplayer/TrackRenderer:maybeThrowError	()V
    //   398: goto +751 -> 1149
    //   401: lload 6
    //   403: ldc2_w 63
    //   406: lcmp
    //   407: ifeq +724 -> 1131
    //   410: aload_1
    //   411: invokevirtual 170	com/google/android/exoplayer/TrackRenderer:getDurationUs	()J
    //   414: lstore 10
    //   416: aload_1
    //   417: invokevirtual 218	com/google/android/exoplayer/TrackRenderer:getBufferedPositionUs	()J
    //   420: lstore 12
    //   422: lload 12
    //   424: ldc2_w 63
    //   427: lcmp
    //   428: ifne +762 -> 1190
    //   431: ldc2_w 63
    //   434: lstore 6
    //   436: goto +727 -> 1163
    //   439: lload 6
    //   441: lload 12
    //   443: invokestatic 382	java/lang/Math:min	(JJ)J
    //   446: lstore 6
    //   448: goto +715 -> 1163
    //   451: aload_0
    //   452: lload 6
    //   454: putfield 68	com/google/android/exoplayer/ExoPlayerImplInternal:bufferedPositionUs	J
    //   457: iload_2
    //   458: ifeq +83 -> 541
    //   461: aload_0
    //   462: getfield 66	com/google/android/exoplayer/ExoPlayerImplInternal:durationUs	J
    //   465: ldc2_w 63
    //   468: lcmp
    //   469: ifeq +15 -> 484
    //   472: aload_0
    //   473: getfield 66	com/google/android/exoplayer/ExoPlayerImplInternal:durationUs	J
    //   476: aload_0
    //   477: getfield 148	com/google/android/exoplayer/ExoPlayerImplInternal:positionUs	J
    //   480: lcmp
    //   481: ifgt +60 -> 541
    //   484: aload_0
    //   485: iconst_5
    //   486: invokespecial 289	com/google/android/exoplayer/ExoPlayerImplInternal:setState	(I)V
    //   489: aload_0
    //   490: invokespecial 357	com/google/android/exoplayer/ExoPlayerImplInternal:stopRenderers	()V
    //   493: aload_0
    //   494: getfield 125	com/google/android/exoplayer/ExoPlayerImplInternal:handler	Landroid/os/Handler;
    //   497: bipush 7
    //   499: invokevirtual 228	android/os/Handler:removeMessages	(I)V
    //   502: aload_0
    //   503: getfield 52	com/google/android/exoplayer/ExoPlayerImplInternal:playWhenReady	Z
    //   506: ifeq +11 -> 517
    //   509: aload_0
    //   510: getfield 62	com/google/android/exoplayer/ExoPlayerImplInternal:state	I
    //   513: iconst_4
    //   514: if_icmpeq +11 -> 525
    //   517: aload_0
    //   518: getfield 62	com/google/android/exoplayer/ExoPlayerImplInternal:state	I
    //   521: iconst_3
    //   522: if_icmpne +119 -> 641
    //   525: aload_0
    //   526: bipush 7
    //   528: lload 8
    //   530: ldc2_w 162
    //   533: invokespecial 167	com/google/android/exoplayer/ExoPlayerImplInternal:scheduleNextOperation	(IJJ)V
    //   536: invokestatic 385	com/google/android/exoplayer/util/TraceUtil:endSection	()V
    //   539: iconst_1
    //   540: ireturn
    //   541: aload_0
    //   542: getfield 62	com/google/android/exoplayer/ExoPlayerImplInternal:state	I
    //   545: iconst_3
    //   546: if_icmpne +63 -> 609
    //   549: iload_3
    //   550: ifeq +59 -> 609
    //   553: aload_0
    //   554: iconst_4
    //   555: invokespecial 289	com/google/android/exoplayer/ExoPlayerImplInternal:setState	(I)V
    //   558: aload_0
    //   559: getfield 52	com/google/android/exoplayer/ExoPlayerImplInternal:playWhenReady	Z
    //   562: ifeq -69 -> 493
    //   565: aload_0
    //   566: invokespecial 208	com/google/android/exoplayer/ExoPlayerImplInternal:startRenderers	()V
    //   569: goto -76 -> 493
    //   572: astore_1
    //   573: ldc -17
    //   575: ldc_w 387
    //   578: aload_1
    //   579: invokestatic 247	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   582: pop
    //   583: aload_0
    //   584: getfield 50	com/google/android/exoplayer/ExoPlayerImplInternal:eventHandler	Landroid/os/Handler;
    //   587: iconst_4
    //   588: new 130	com/google/android/exoplayer/ExoPlaybackException
    //   591: dup
    //   592: aload_1
    //   593: iconst_0
    //   594: invokespecial 390	com/google/android/exoplayer/ExoPlaybackException:<init>	(Ljava/lang/Throwable;B)V
    //   597: invokevirtual 367	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   600: invokevirtual 205	android/os/Message:sendToTarget	()V
    //   603: aload_0
    //   604: invokespecial 369	com/google/android/exoplayer/ExoPlayerImplInternal:stopInternal	()V
    //   607: iconst_1
    //   608: ireturn
    //   609: aload_0
    //   610: getfield 62	com/google/android/exoplayer/ExoPlayerImplInternal:state	I
    //   613: iconst_4
    //   614: if_icmpne -121 -> 493
    //   617: iload_3
    //   618: ifne -125 -> 493
    //   621: aload_0
    //   622: aload_0
    //   623: getfield 52	com/google/android/exoplayer/ExoPlayerImplInternal:playWhenReady	Z
    //   626: putfield 220	com/google/android/exoplayer/ExoPlayerImplInternal:rebuffering	Z
    //   629: aload_0
    //   630: iconst_3
    //   631: invokespecial 289	com/google/android/exoplayer/ExoPlayerImplInternal:setState	(I)V
    //   634: aload_0
    //   635: invokespecial 357	com/google/android/exoplayer/ExoPlayerImplInternal:stopRenderers	()V
    //   638: goto -145 -> 493
    //   641: aload_0
    //   642: getfield 80	com/google/android/exoplayer/ExoPlayerImplInternal:enabledRenderers	Ljava/util/List;
    //   645: invokeinterface 393 1 0
    //   650: ifne -114 -> 536
    //   653: aload_0
    //   654: bipush 7
    //   656: lload 8
    //   658: ldc2_w 55
    //   661: invokespecial 167	com/google/android/exoplayer/ExoPlayerImplInternal:scheduleNextOperation	(IJJ)V
    //   664: goto -128 -> 536
    //   667: aload_1
    //   668: getfield 345	android/os/Message:obj	Ljava/lang/Object;
    //   671: checkcast 395	java/lang/Long
    //   674: invokevirtual 398	java/lang/Long:longValue	()J
    //   677: lstore 6
    //   679: aload_0
    //   680: iconst_0
    //   681: putfield 220	com/google/android/exoplayer/ExoPlayerImplInternal:rebuffering	Z
    //   684: aload_0
    //   685: lload 6
    //   687: ldc2_w 55
    //   690: lmul
    //   691: putfield 148	com/google/android/exoplayer/ExoPlayerImplInternal:positionUs	J
    //   694: aload_0
    //   695: getfield 73	com/google/android/exoplayer/ExoPlayerImplInternal:standaloneMediaClock	Lcom/google/android/exoplayer/StandaloneMediaClock;
    //   698: invokevirtual 229	com/google/android/exoplayer/StandaloneMediaClock:stop	()V
    //   701: aload_0
    //   702: getfield 73	com/google/android/exoplayer/ExoPlayerImplInternal:standaloneMediaClock	Lcom/google/android/exoplayer/StandaloneMediaClock;
    //   705: aload_0
    //   706: getfield 148	com/google/android/exoplayer/ExoPlayerImplInternal:positionUs	J
    //   709: invokevirtual 303	com/google/android/exoplayer/StandaloneMediaClock:setPositionUs	(J)V
    //   712: aload_0
    //   713: getfield 62	com/google/android/exoplayer/ExoPlayerImplInternal:state	I
    //   716: iconst_1
    //   717: if_icmpeq +511 -> 1228
    //   720: aload_0
    //   721: getfield 62	com/google/android/exoplayer/ExoPlayerImplInternal:state	I
    //   724: iconst_2
    //   725: if_icmpne +505 -> 1230
    //   728: goto +500 -> 1228
    //   731: iload_2
    //   732: aload_0
    //   733: getfield 80	com/google/android/exoplayer/ExoPlayerImplInternal:enabledRenderers	Ljava/util/List;
    //   736: invokeinterface 279 1 0
    //   741: if_icmpge +36 -> 777
    //   744: aload_0
    //   745: getfield 80	com/google/android/exoplayer/ExoPlayerImplInternal:enabledRenderers	Ljava/util/List;
    //   748: iload_2
    //   749: invokeinterface 283 2 0
    //   754: checkcast 132	com/google/android/exoplayer/TrackRenderer
    //   757: astore_1
    //   758: aload_1
    //   759: invokestatic 231	com/google/android/exoplayer/ExoPlayerImplInternal:ensureStopped	(Lcom/google/android/exoplayer/TrackRenderer;)V
    //   762: aload_1
    //   763: aload_0
    //   764: getfield 148	com/google/android/exoplayer/ExoPlayerImplInternal:positionUs	J
    //   767: invokevirtual 401	com/google/android/exoplayer/TrackRenderer:seekTo	(J)V
    //   770: iload_2
    //   771: iconst_1
    //   772: iadd
    //   773: istore_2
    //   774: goto -43 -> 731
    //   777: aload_0
    //   778: iconst_3
    //   779: invokespecial 289	com/google/android/exoplayer/ExoPlayerImplInternal:setState	(I)V
    //   782: aload_0
    //   783: getfield 125	com/google/android/exoplayer/ExoPlayerImplInternal:handler	Landroid/os/Handler;
    //   786: bipush 7
    //   788: invokevirtual 212	android/os/Handler:sendEmptyMessage	(I)Z
    //   791: pop
    //   792: goto +436 -> 1228
    //   795: aload_0
    //   796: invokespecial 369	com/google/android/exoplayer/ExoPlayerImplInternal:stopInternal	()V
    //   799: iconst_1
    //   800: ireturn
    //   801: aload_0
    //   802: invokespecial 287	com/google/android/exoplayer/ExoPlayerImplInternal:resetInternal	()V
    //   805: aload_0
    //   806: iconst_1
    //   807: invokespecial 289	com/google/android/exoplayer/ExoPlayerImplInternal:setState	(I)V
    //   810: aload_0
    //   811: monitorenter
    //   812: aload_0
    //   813: iconst_1
    //   814: putfield 312	com/google/android/exoplayer/ExoPlayerImplInternal:released	Z
    //   817: aload_0
    //   818: invokevirtual 404	java/lang/Object:notifyAll	()V
    //   821: aload_0
    //   822: monitorexit
    //   823: iconst_1
    //   824: ireturn
    //   825: astore_1
    //   826: aload_0
    //   827: monitorexit
    //   828: aload_1
    //   829: athrow
    //   830: aload_1
    //   831: getfield 355	android/os/Message:arg1	I
    //   834: istore_2
    //   835: aload_1
    //   836: getfield 345	android/os/Message:obj	Ljava/lang/Object;
    //   839: astore_1
    //   840: aload_1
    //   841: checkcast 320	android/util/Pair
    //   844: astore_1
    //   845: aload_1
    //   846: getfield 407	android/util/Pair:first	Ljava/lang/Object;
    //   849: checkcast 409	com/google/android/exoplayer/ExoPlayer$ExoPlayerComponent
    //   852: iload_2
    //   853: aload_1
    //   854: getfield 412	android/util/Pair:second	Ljava/lang/Object;
    //   857: invokeinterface 415 3 0
    //   862: aload_0
    //   863: monitorenter
    //   864: aload_0
    //   865: aload_0
    //   866: getfield 48	com/google/android/exoplayer/ExoPlayerImplInternal:customMessagesProcessed	I
    //   869: iconst_1
    //   870: iadd
    //   871: putfield 48	com/google/android/exoplayer/ExoPlayerImplInternal:customMessagesProcessed	I
    //   874: aload_0
    //   875: invokevirtual 404	java/lang/Object:notifyAll	()V
    //   878: aload_0
    //   879: monitorexit
    //   880: aload_0
    //   881: getfield 62	com/google/android/exoplayer/ExoPlayerImplInternal:state	I
    //   884: iconst_1
    //   885: if_icmpeq +21 -> 906
    //   888: aload_0
    //   889: getfield 62	com/google/android/exoplayer/ExoPlayerImplInternal:state	I
    //   892: iconst_2
    //   893: if_icmpeq +13 -> 906
    //   896: aload_0
    //   897: getfield 125	com/google/android/exoplayer/ExoPlayerImplInternal:handler	Landroid/os/Handler;
    //   900: bipush 7
    //   902: invokevirtual 212	android/os/Handler:sendEmptyMessage	(I)Z
    //   905: pop
    //   906: iconst_1
    //   907: ireturn
    //   908: astore_1
    //   909: aload_0
    //   910: monitorexit
    //   911: aload_1
    //   912: athrow
    //   913: astore_1
    //   914: aload_0
    //   915: monitorenter
    //   916: aload_0
    //   917: aload_0
    //   918: getfield 48	com/google/android/exoplayer/ExoPlayerImplInternal:customMessagesProcessed	I
    //   921: iconst_1
    //   922: iadd
    //   923: putfield 48	com/google/android/exoplayer/ExoPlayerImplInternal:customMessagesProcessed	I
    //   926: aload_0
    //   927: invokevirtual 404	java/lang/Object:notifyAll	()V
    //   930: aload_0
    //   931: monitorexit
    //   932: aload_1
    //   933: athrow
    //   934: astore_1
    //   935: aload_0
    //   936: monitorexit
    //   937: aload_1
    //   938: athrow
    //   939: aload_1
    //   940: getfield 355	android/os/Message:arg1	I
    //   943: istore_2
    //   944: aload_1
    //   945: getfield 418	android/os/Message:arg2	I
    //   948: ifeq +289 -> 1237
    //   951: iconst_1
    //   952: istore 5
    //   954: aload_0
    //   955: getfield 54	com/google/android/exoplayer/ExoPlayerImplInternal:rendererEnabledFlags	[Z
    //   958: iload_2
    //   959: baload
    //   960: iload 5
    //   962: if_icmpeq +273 -> 1235
    //   965: aload_0
    //   966: getfield 54	com/google/android/exoplayer/ExoPlayerImplInternal:rendererEnabledFlags	[Z
    //   969: iload_2
    //   970: iload 5
    //   972: bastore
    //   973: aload_0
    //   974: getfield 62	com/google/android/exoplayer/ExoPlayerImplInternal:state	I
    //   977: iconst_1
    //   978: if_icmpeq +257 -> 1235
    //   981: aload_0
    //   982: getfield 62	com/google/android/exoplayer/ExoPlayerImplInternal:state	I
    //   985: iconst_2
    //   986: if_icmpne +6 -> 992
    //   989: goto +246 -> 1235
    //   992: aload_0
    //   993: getfield 146	com/google/android/exoplayer/ExoPlayerImplInternal:renderers	[Lcom/google/android/exoplayer/TrackRenderer;
    //   996: iload_2
    //   997: aaload
    //   998: astore_1
    //   999: aload_1
    //   1000: getfield 133	com/google/android/exoplayer/TrackRenderer:state	I
    //   1003: istore_2
    //   1004: iload_2
    //   1005: iconst_1
    //   1006: if_icmpeq +13 -> 1019
    //   1009: iload_2
    //   1010: iconst_2
    //   1011: if_icmpeq +8 -> 1019
    //   1014: iload_2
    //   1015: iconst_3
    //   1016: if_icmpne +219 -> 1235
    //   1019: iload 5
    //   1021: ifeq +64 -> 1085
    //   1024: aload_0
    //   1025: getfield 52	com/google/android/exoplayer/ExoPlayerImplInternal:playWhenReady	Z
    //   1028: ifeq +215 -> 1243
    //   1031: aload_0
    //   1032: getfield 62	com/google/android/exoplayer/ExoPlayerImplInternal:state	I
    //   1035: iconst_4
    //   1036: if_icmpne +207 -> 1243
    //   1039: iconst_1
    //   1040: istore 5
    //   1042: aload_1
    //   1043: aload_0
    //   1044: getfield 148	com/google/android/exoplayer/ExoPlayerImplInternal:positionUs	J
    //   1047: iload 5
    //   1049: invokevirtual 174	com/google/android/exoplayer/TrackRenderer:enable	(JZ)V
    //   1052: aload_0
    //   1053: getfield 80	com/google/android/exoplayer/ExoPlayerImplInternal:enabledRenderers	Ljava/util/List;
    //   1056: aload_1
    //   1057: invokeinterface 180 2 0
    //   1062: pop
    //   1063: iload 5
    //   1065: ifeq +7 -> 1072
    //   1068: aload_1
    //   1069: invokevirtual 284	com/google/android/exoplayer/TrackRenderer:start	()V
    //   1072: aload_0
    //   1073: getfield 125	com/google/android/exoplayer/ExoPlayerImplInternal:handler	Landroid/os/Handler;
    //   1076: bipush 7
    //   1078: invokevirtual 212	android/os/Handler:sendEmptyMessage	(I)Z
    //   1081: pop
    //   1082: goto +153 -> 1235
    //   1085: aload_1
    //   1086: aload_0
    //   1087: getfield 253	com/google/android/exoplayer/ExoPlayerImplInternal:rendererMediaClockSource	Lcom/google/android/exoplayer/TrackRenderer;
    //   1090: if_acmpne +19 -> 1109
    //   1093: aload_0
    //   1094: getfield 73	com/google/android/exoplayer/ExoPlayerImplInternal:standaloneMediaClock	Lcom/google/android/exoplayer/StandaloneMediaClock;
    //   1097: aload_0
    //   1098: getfield 251	com/google/android/exoplayer/ExoPlayerImplInternal:rendererMediaClock	Lcom/google/android/exoplayer/MediaClock;
    //   1101: invokeinterface 299 1 0
    //   1106: invokevirtual 303	com/google/android/exoplayer/StandaloneMediaClock:setPositionUs	(J)V
    //   1109: aload_1
    //   1110: invokestatic 231	com/google/android/exoplayer/ExoPlayerImplInternal:ensureStopped	(Lcom/google/android/exoplayer/TrackRenderer;)V
    //   1113: aload_0
    //   1114: getfield 80	com/google/android/exoplayer/ExoPlayerImplInternal:enabledRenderers	Ljava/util/List;
    //   1117: aload_1
    //   1118: invokeinterface 421 2 0
    //   1123: pop
    //   1124: aload_1
    //   1125: invokevirtual 234	com/google/android/exoplayer/TrackRenderer:disable	()V
    //   1128: goto +107 -> 1235
    //   1131: goto +32 -> 1163
    //   1134: iconst_0
    //   1135: ireturn
    //   1136: iload_2
    //   1137: iconst_1
    //   1138: iadd
    //   1139: istore_2
    //   1140: goto -1062 -> 78
    //   1143: iconst_0
    //   1144: istore 5
    //   1146: goto -1039 -> 107
    //   1149: iload_3
    //   1150: ifeq +35 -> 1185
    //   1153: iload 5
    //   1155: ifeq +30 -> 1185
    //   1158: iconst_1
    //   1159: istore_3
    //   1160: goto -759 -> 401
    //   1163: iload 4
    //   1165: iconst_1
    //   1166: iadd
    //   1167: istore 4
    //   1169: goto -841 -> 328
    //   1172: ldc2_w 422
    //   1175: lstore 6
    //   1177: goto -860 -> 317
    //   1180: iconst_0
    //   1181: istore_2
    //   1182: goto -800 -> 382
    //   1185: iconst_0
    //   1186: istore_3
    //   1187: goto -786 -> 401
    //   1190: lload 12
    //   1192: ldc2_w 221
    //   1195: lcmp
    //   1196: ifeq -65 -> 1131
    //   1199: lload 10
    //   1201: ldc2_w 63
    //   1204: lcmp
    //   1205: ifeq -766 -> 439
    //   1208: lload 10
    //   1210: ldc2_w 189
    //   1213: lcmp
    //   1214: ifeq -775 -> 439
    //   1217: lload 12
    //   1219: lload 10
    //   1221: lcmp
    //   1222: ifge -91 -> 1131
    //   1225: goto -786 -> 439
    //   1228: iconst_1
    //   1229: ireturn
    //   1230: iconst_0
    //   1231: istore_2
    //   1232: goto -501 -> 731
    //   1235: iconst_1
    //   1236: ireturn
    //   1237: iconst_0
    //   1238: istore 5
    //   1240: goto -286 -> 954
    //   1243: iconst_0
    //   1244: istore 5
    //   1246: goto -204 -> 1042
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1249	0	this	ExoPlayerImplInternal
    //   0	1249	1	paramMessage	Message
    //   77	1155	2	i	int
    //   320	867	3	j	int
    //   326	842	4	k	int
    //   105	915	5	m	int
    //   1040	205	5	bool	boolean
    //   315	861	6	l1	long
    //   298	359	8	l2	long
    //   414	806	10	l3	long
    //   420	798	12	l4	long
    //   90	24	14	localMediaClock	MediaClock
    // Exception table:
    //   from	to	target	type
    //   157	168	225	finally
    //   173	181	225	finally
    //   200	222	225	finally
    //   268	286	225	finally
    //   0	56	239	com/google/android/exoplayer/ExoPlaybackException
    //   56	76	239	com/google/android/exoplayer/ExoPlaybackException
    //   78	92	239	com/google/android/exoplayer/ExoPlaybackException
    //   97	104	239	com/google/android/exoplayer/ExoPlaybackException
    //   107	125	239	com/google/android/exoplayer/ExoPlaybackException
    //   128	137	239	com/google/android/exoplayer/ExoPlaybackException
    //   139	143	239	com/google/android/exoplayer/ExoPlaybackException
    //   145	150	239	com/google/android/exoplayer/ExoPlaybackException
    //   181	192	239	com/google/android/exoplayer/ExoPlaybackException
    //   226	239	239	com/google/android/exoplayer/ExoPlaybackException
    //   289	317	239	com/google/android/exoplayer/ExoPlaybackException
    //   321	325	239	com/google/android/exoplayer/ExoPlaybackException
    //   328	369	239	com/google/android/exoplayer/ExoPlaybackException
    //   373	380	239	com/google/android/exoplayer/ExoPlaybackException
    //   382	389	239	com/google/android/exoplayer/ExoPlaybackException
    //   394	398	239	com/google/android/exoplayer/ExoPlaybackException
    //   410	422	239	com/google/android/exoplayer/ExoPlaybackException
    //   439	448	239	com/google/android/exoplayer/ExoPlaybackException
    //   451	457	239	com/google/android/exoplayer/ExoPlaybackException
    //   461	484	239	com/google/android/exoplayer/ExoPlaybackException
    //   484	493	239	com/google/android/exoplayer/ExoPlaybackException
    //   493	517	239	com/google/android/exoplayer/ExoPlaybackException
    //   517	525	239	com/google/android/exoplayer/ExoPlaybackException
    //   525	536	239	com/google/android/exoplayer/ExoPlaybackException
    //   536	539	239	com/google/android/exoplayer/ExoPlaybackException
    //   541	549	239	com/google/android/exoplayer/ExoPlaybackException
    //   553	569	239	com/google/android/exoplayer/ExoPlaybackException
    //   609	617	239	com/google/android/exoplayer/ExoPlaybackException
    //   621	638	239	com/google/android/exoplayer/ExoPlaybackException
    //   641	664	239	com/google/android/exoplayer/ExoPlaybackException
    //   667	728	239	com/google/android/exoplayer/ExoPlaybackException
    //   731	770	239	com/google/android/exoplayer/ExoPlaybackException
    //   777	792	239	com/google/android/exoplayer/ExoPlaybackException
    //   795	799	239	com/google/android/exoplayer/ExoPlaybackException
    //   801	812	239	com/google/android/exoplayer/ExoPlaybackException
    //   828	830	239	com/google/android/exoplayer/ExoPlaybackException
    //   830	840	239	com/google/android/exoplayer/ExoPlaybackException
    //   862	864	239	com/google/android/exoplayer/ExoPlaybackException
    //   880	906	239	com/google/android/exoplayer/ExoPlaybackException
    //   911	913	239	com/google/android/exoplayer/ExoPlaybackException
    //   914	916	239	com/google/android/exoplayer/ExoPlaybackException
    //   932	934	239	com/google/android/exoplayer/ExoPlaybackException
    //   937	939	239	com/google/android/exoplayer/ExoPlaybackException
    //   939	951	239	com/google/android/exoplayer/ExoPlaybackException
    //   954	989	239	com/google/android/exoplayer/ExoPlaybackException
    //   992	1004	239	com/google/android/exoplayer/ExoPlaybackException
    //   1024	1039	239	com/google/android/exoplayer/ExoPlaybackException
    //   1042	1063	239	com/google/android/exoplayer/ExoPlaybackException
    //   1068	1072	239	com/google/android/exoplayer/ExoPlaybackException
    //   1072	1082	239	com/google/android/exoplayer/ExoPlaybackException
    //   1085	1109	239	com/google/android/exoplayer/ExoPlaybackException
    //   1109	1128	239	com/google/android/exoplayer/ExoPlaybackException
    //   0	56	572	java/lang/RuntimeException
    //   56	76	572	java/lang/RuntimeException
    //   78	92	572	java/lang/RuntimeException
    //   97	104	572	java/lang/RuntimeException
    //   107	125	572	java/lang/RuntimeException
    //   128	137	572	java/lang/RuntimeException
    //   139	143	572	java/lang/RuntimeException
    //   145	150	572	java/lang/RuntimeException
    //   181	192	572	java/lang/RuntimeException
    //   226	239	572	java/lang/RuntimeException
    //   289	317	572	java/lang/RuntimeException
    //   321	325	572	java/lang/RuntimeException
    //   328	369	572	java/lang/RuntimeException
    //   373	380	572	java/lang/RuntimeException
    //   382	389	572	java/lang/RuntimeException
    //   394	398	572	java/lang/RuntimeException
    //   410	422	572	java/lang/RuntimeException
    //   439	448	572	java/lang/RuntimeException
    //   451	457	572	java/lang/RuntimeException
    //   461	484	572	java/lang/RuntimeException
    //   484	493	572	java/lang/RuntimeException
    //   493	517	572	java/lang/RuntimeException
    //   517	525	572	java/lang/RuntimeException
    //   525	536	572	java/lang/RuntimeException
    //   536	539	572	java/lang/RuntimeException
    //   541	549	572	java/lang/RuntimeException
    //   553	569	572	java/lang/RuntimeException
    //   609	617	572	java/lang/RuntimeException
    //   621	638	572	java/lang/RuntimeException
    //   641	664	572	java/lang/RuntimeException
    //   667	728	572	java/lang/RuntimeException
    //   731	770	572	java/lang/RuntimeException
    //   777	792	572	java/lang/RuntimeException
    //   795	799	572	java/lang/RuntimeException
    //   801	812	572	java/lang/RuntimeException
    //   828	830	572	java/lang/RuntimeException
    //   830	840	572	java/lang/RuntimeException
    //   862	864	572	java/lang/RuntimeException
    //   880	906	572	java/lang/RuntimeException
    //   911	913	572	java/lang/RuntimeException
    //   914	916	572	java/lang/RuntimeException
    //   932	934	572	java/lang/RuntimeException
    //   937	939	572	java/lang/RuntimeException
    //   939	951	572	java/lang/RuntimeException
    //   954	989	572	java/lang/RuntimeException
    //   992	1004	572	java/lang/RuntimeException
    //   1024	1039	572	java/lang/RuntimeException
    //   1042	1063	572	java/lang/RuntimeException
    //   1068	1072	572	java/lang/RuntimeException
    //   1072	1082	572	java/lang/RuntimeException
    //   1085	1109	572	java/lang/RuntimeException
    //   1109	1128	572	java/lang/RuntimeException
    //   812	823	825	finally
    //   826	828	825	finally
    //   864	880	908	finally
    //   909	911	908	finally
    //   840	862	913	finally
    //   916	932	934	finally
    //   935	937	934	finally
  }
  
  public final void release()
  {
    for (;;)
    {
      try
      {
        boolean bool = released;
        if (bool) {
          return;
        }
        handler.sendEmptyMessage(5);
        bool = released;
        if (!bool) {
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            Thread.currentThread().interrupt();
          }
        } else {
          internalPlaybackThread.quit();
        }
      }
      finally {}
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.ExoPlayerImplInternal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */