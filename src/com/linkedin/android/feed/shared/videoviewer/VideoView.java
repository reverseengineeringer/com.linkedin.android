package com.linkedin.android.feed.shared.videoviewer;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.linkedin.android.logger.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VideoView
  extends SurfaceView
  implements VideoControl.MediaPlayerControl
{
  private static final int[] KEYCODE_UNSUPPORTED = { 4, 24, 25, 164, 82, 5, 6 };
  private static final String TAG = VideoView.class.getSimpleName();
  private MediaPlayer.OnBufferingUpdateListener bufferingUpdateListener = new MediaPlayer.OnBufferingUpdateListener()
  {
    public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      VideoView.access$1302(VideoView.this, paramAnonymousInt);
    }
  };
  private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener()
  {
    public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      VideoView.access$202(VideoView.this, 5);
      VideoView.access$602(VideoView.this, 5);
      if (onCompletionListener != null) {
        onCompletionListener.onCompletion(mediaPlayer);
      }
    }
  };
  private int currentBufferPercentage;
  int currentState = 0;
  private MediaPlayer.OnErrorListener errorListener = new MediaPlayer.OnErrorListener()
  {
    public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      VideoView.access$202(VideoView.this, -1);
      VideoView.access$602(VideoView.this, -1);
      if (onErrorListener != null) {
        onErrorListener.onError(mediaPlayer, paramAnonymousInt1, paramAnonymousInt2);
      }
      return true;
    }
  };
  private Map<String, String> headers;
  private MediaPlayer.OnInfoListener infoListener = new MediaPlayer.OnInfoListener()
  {
    public final boolean onInfo(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (onInfoListener != null) {
        onInfoListener.onInfo(paramAnonymousMediaPlayer, paramAnonymousInt1, paramAnonymousInt2);
      }
      return true;
    }
  };
  MediaPlayer mediaPlayer;
  private MediaPlayer.OnCompletionListener onCompletionListener;
  private MediaPlayer.OnErrorListener onErrorListener;
  private MediaPlayer.OnInfoListener onInfoListener;
  private MediaPlayer.OnPreparedListener onPreparedListener;
  private MediaPlayer.OnPreparedListener preparedListener = new MediaPlayer.OnPreparedListener()
  {
    public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
    {
      VideoView.access$202(VideoView.this, 2);
      if (onPreparedListener != null) {
        onPreparedListener.onPrepared(mediaPlayer);
      }
      VideoView.access$002(VideoView.this, paramAnonymousMediaPlayer.getVideoWidth());
      VideoView.access$102(VideoView.this, paramAnonymousMediaPlayer.getVideoHeight());
      int i = seekWhenPrepared;
      if (i != 0) {
        seekTo(i);
      }
      if ((videoWidth == 0) || (videoHeight == 0)) {
        if (targetState == 3) {
          start();
        }
      }
      do
      {
        do
        {
          return;
          getHolder().setFixedSize(videoWidth, videoHeight);
        } while ((surfaceWidth != videoWidth) || (surfaceHeight != videoHeight));
        if (targetState == 3)
        {
          start();
          return;
        }
      } while ((isPlaying()) || ((i == 0) && (getCurrentPosition() <= 0)));
      VideoView.access$900$7a8822bf(VideoView.this);
    }
  };
  private int seekWhenPrepared;
  private MediaPlayer.OnVideoSizeChangedListener sizeChangedListener = new MediaPlayer.OnVideoSizeChangedListener()
  {
    public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      VideoView.access$002(VideoView.this, paramAnonymousMediaPlayer.getVideoWidth());
      VideoView.access$102(VideoView.this, paramAnonymousMediaPlayer.getVideoHeight());
      if ((videoWidth != 0) && (videoHeight != 0))
      {
        getHolder().setFixedSize(videoWidth, videoHeight);
        requestLayout();
      }
    }
  };
  private int surfaceHeight;
  private SurfaceHolder surfaceHolder;
  private SurfaceHolder.Callback surfaceHolderCallback = new SurfaceHolder.Callback()
  {
    public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      VideoView.access$702(VideoView.this, paramAnonymousInt2);
      VideoView.access$802(VideoView.this, paramAnonymousInt3);
      if (targetState == 3)
      {
        paramAnonymousInt1 = 1;
        if ((videoWidth != paramAnonymousInt2) || (videoHeight != paramAnonymousInt3)) {
          break label112;
        }
      }
      label112:
      for (paramAnonymousInt2 = 1;; paramAnonymousInt2 = 0)
      {
        if ((mediaPlayer != null) && (paramAnonymousInt1 != 0) && (paramAnonymousInt2 != 0))
        {
          if (seekWhenPrepared != 0) {
            seekTo(seekWhenPrepared);
          }
          start();
        }
        return;
        paramAnonymousInt1 = 0;
        break;
      }
    }
    
    public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      VideoView.access$1402(VideoView.this, paramAnonymousSurfaceHolder);
      VideoView.this.openVideo();
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      VideoView.access$1402(VideoView.this, null);
      if (videoControl != null) {
        videoControl.hide();
      }
      VideoView.access$1700$7a87e2ee(VideoView.this);
    }
  };
  private int surfaceWidth;
  int targetState = 0;
  private Uri uri;
  private VideoControl videoControl;
  private int videoHeight;
  private int videoWidth;
  
  public VideoView(Context paramContext)
  {
    super(paramContext);
    initVideoView();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initVideoView();
  }
  
  public VideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initVideoView();
  }
  
  private void initVideoView()
  {
    videoWidth = 0;
    videoHeight = 0;
    getHolder().addCallback(surfaceHolderCallback);
    currentState = 0;
    targetState = 0;
  }
  
  private boolean isInPlaybackState()
  {
    return (mediaPlayer != null) && (currentState != -1) && (currentState != 0) && (currentState != 1);
  }
  
  private void openVideo()
  {
    if ((uri == null) || (surfaceHolder == null)) {
      return;
    }
    release(false);
    try
    {
      mediaPlayer = new MediaPlayer();
      mediaPlayer.setOnPreparedListener(preparedListener);
      mediaPlayer.setOnVideoSizeChangedListener(sizeChangedListener);
      mediaPlayer.setOnCompletionListener(completionListener);
      mediaPlayer.setOnErrorListener(errorListener);
      mediaPlayer.setOnInfoListener(infoListener);
      mediaPlayer.setOnBufferingUpdateListener(bufferingUpdateListener);
      currentBufferPercentage = 0;
      mediaPlayer.setDataSource(getContext(), uri, headers);
      mediaPlayer.setDisplay(surfaceHolder);
      mediaPlayer.setAudioStreamType(3);
      mediaPlayer.setScreenOnWhilePlaying(true);
      mediaPlayer.prepareAsync();
      currentState = 1;
      return;
    }
    catch (IOException localIOException)
    {
      Log.e(TAG, "IOException parsing MiniProfile", localIOException);
      currentState = -1;
      targetState = -1;
      errorListener.onError(mediaPlayer, 1, 0);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.e(TAG, "IllegalArgumentException parsing MiniProfile", localIllegalArgumentException);
      currentState = -1;
      targetState = -1;
      errorListener.onError(mediaPlayer, 1, 0);
    }
  }
  
  private void release(boolean paramBoolean)
  {
    if (mediaPlayer != null)
    {
      mediaPlayer.reset();
      mediaPlayer.release();
      mediaPlayer = null;
      currentState = 0;
      if (paramBoolean) {
        targetState = 0;
      }
    }
  }
  
  private void toggleMediaControlsVisiblity()
  {
    if (videoControl.showing)
    {
      videoControl.hide();
      return;
    }
    videoControl.show(3000);
  }
  
  public int getBufferPercentage()
  {
    if (mediaPlayer != null) {
      return currentBufferPercentage;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (currentState == 5) {
      return mediaPlayer.getDuration();
    }
    if (isInPlaybackState()) {
      return mediaPlayer.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (isInPlaybackState()) {
      return mediaPlayer.getDuration();
    }
    return -1;
  }
  
  public final boolean isPlaying()
  {
    return (isInPlaybackState()) && (mediaPlayer.isPlaying());
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(VideoView.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(VideoView.class.getName());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    int j = 1;
    int[] arrayOfInt = KEYCODE_UNSUPPORTED;
    int k = arrayOfInt.length;
    int i = 0;
    while (i < k)
    {
      if (paramInt == arrayOfInt[i]) {
        j = 0;
      }
      i += 1;
    }
    if ((isInPlaybackState()) && (j != 0) && (videoControl != null)) {
      toggleMediaControlsVisiblity();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int n = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int j;
    int i;
    if ((n == 1073741824) && (i1 == 1073741824))
    {
      if (videoWidth * paramInt2 < videoHeight * paramInt1)
      {
        j = videoWidth * paramInt2 / videoHeight;
        i = paramInt2;
      }
      for (;;)
      {
        setMeasuredDimension(j, i);
        return;
        i = paramInt2;
        j = paramInt1;
        if (videoWidth * paramInt2 > videoHeight * paramInt1)
        {
          i = videoHeight * paramInt1 / videoWidth;
          j = paramInt1;
        }
      }
    }
    if (n == 1073741824)
    {
      i = videoHeight * paramInt1 / videoWidth;
      if ((i1 != Integer.MIN_VALUE) || (i <= paramInt2)) {
        break label293;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      if (i1 == 1073741824)
      {
        i = videoWidth * paramInt2 / videoHeight;
        if ((n != Integer.MIN_VALUE) || (i <= paramInt1)) {
          break label288;
        }
      }
      for (;;)
      {
        setMeasuredDimension(paramInt1, paramInt2);
        return;
        int k = videoWidth;
        int m = videoHeight;
        i = m;
        j = k;
        if (i1 == Integer.MIN_VALUE)
        {
          i = m;
          j = k;
          if (m > paramInt2)
          {
            j = videoWidth * paramInt2 / videoHeight;
            i = paramInt2;
          }
        }
        if ((n == Integer.MIN_VALUE) && (j > paramInt1)) {
          i = videoHeight * paramInt1 / videoWidth;
        }
        for (;;)
        {
          setMeasuredDimension(paramInt1, i);
          return;
          paramInt1 = j;
        }
        label288:
        paramInt1 = i;
      }
      label293:
      paramInt2 = i;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((isInPlaybackState()) && (videoControl != null)) {
      toggleMediaControlsVisiblity();
    }
    return false;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if ((isInPlaybackState()) && (videoControl != null)) {
      toggleMediaControlsVisiblity();
    }
    return false;
  }
  
  public final void pause()
  {
    if ((isInPlaybackState()) && (mediaPlayer.isPlaying()))
    {
      mediaPlayer.pause();
      currentState = 4;
    }
    targetState = 4;
  }
  
  public final void seekTo(int paramInt)
  {
    if (isInPlaybackState())
    {
      mediaPlayer.seekTo(paramInt);
      seekWhenPrepared = 0;
      if (currentState == 5)
      {
        currentState = 4;
        targetState = 4;
      }
      return;
    }
    seekWhenPrepared = paramInt;
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    onCompletionListener = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    onErrorListener = paramOnErrorListener;
  }
  
  public void setOnInfoListener(MediaPlayer.OnInfoListener paramOnInfoListener)
  {
    onInfoListener = paramOnInfoListener;
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    onPreparedListener = paramOnPreparedListener;
  }
  
  public void setVideoControl(VideoControl paramVideoControl)
  {
    videoControl = paramVideoControl;
  }
  
  public void setVideoPath(String paramString)
  {
    setVideoURI(Uri.parse(paramString));
  }
  
  public void setVideoURI(Uri paramUri)
  {
    HashMap localHashMap = new HashMap();
    uri = paramUri;
    headers = localHashMap;
    seekWhenPrepared = 0;
    openVideo();
    requestLayout();
    invalidate();
  }
  
  public final void start()
  {
    if (isInPlaybackState())
    {
      mediaPlayer.start();
      currentState = 3;
    }
    targetState = 3;
    if (videoControl != null) {
      videoControl.show(3000);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */