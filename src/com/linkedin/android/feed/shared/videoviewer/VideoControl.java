package com.linkedin.android.feed.shared.videoviewer;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import java.lang.ref.WeakReference;
import java.util.Formatter;

public class VideoControl
  extends FrameLayout
{
  @InjectView(2131755876)
  LinearLayout container;
  @InjectView(2131755882)
  TextView currentTimeText;
  private boolean dragging;
  @InjectView(2131755884)
  TextView endTimeText;
  @InjectView(2131755880)
  ImageButton ffwdButton;
  private View.OnClickListener ffwdListener = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      int i = mediaPlayerControl.getCurrentPosition();
      mediaPlayerControl.seekTo(i + 15000);
      VideoControl.this.setProgress();
      show(3000);
    }
  };
  @InjectView(2131755881)
  LinearLayout footer;
  private StringBuilder formatBuilder;
  private Formatter formatter;
  private Handler handler = new VisibilityHandler(this, (byte)0);
  @InjectView(2131755877)
  LinearLayout header;
  private MediaPlayerControl mediaPlayerControl;
  @InjectView(2131755879)
  ImageButton pauseButton;
  private CharSequence pauseDescription;
  private View.OnClickListener pauseListener = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      VideoControl.this.doPauseResume();
      show(3000);
    }
  };
  private CharSequence playDescription;
  @InjectView(2131755878)
  ImageButton rewButton;
  private View.OnClickListener rewListener = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      int i = mediaPlayerControl.getCurrentPosition();
      mediaPlayerControl.seekTo(i - 5000);
      VideoControl.this.setProgress();
      show(3000);
    }
  };
  @InjectView(2131755883)
  SeekBar seekBar;
  private SeekBar.OnSeekBarChangeListener seekListener = new SeekBar.OnSeekBarChangeListener()
  {
    public final void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
      {
        long l = mediaPlayerControl.getDuration() * paramAnonymousInt / 1000L;
        mediaPlayerControl.seekTo((int)l);
        currentTimeText.setText(VideoControl.this.stringForTime((int)l));
      }
    }
    
    public final void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
    {
      show(3600000);
      VideoControl.access$302(VideoControl.this, true);
      handler.removeMessages(2);
    }
    
    public final void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
    {
      VideoControl.access$302(VideoControl.this, false);
      VideoControl.this.setProgress();
      VideoControl.this.updatePausePlay();
      show(3000);
      handler.sendEmptyMessage(2);
    }
  };
  boolean showing;
  private OnVisibilityChangedListener visibilityChangedListener;
  
  public VideoControl(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public VideoControl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public VideoControl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void doPauseResume()
  {
    if (mediaPlayerControl.isPlaying()) {
      mediaPlayerControl.pause();
    }
    for (;;)
    {
      updatePausePlay();
      return;
      mediaPlayerControl.start();
    }
  }
  
  private void init(Context paramContext)
  {
    inflate(paramContext, 2130968772, this);
    ButterKnife.inject(this);
    setClickable(true);
    setLongClickable(true);
  }
  
  private int setProgress()
  {
    if (dragging) {
      return 0;
    }
    int i = mediaPlayerControl.getCurrentPosition();
    int j = mediaPlayerControl.getDuration();
    if (j > 0)
    {
      long l = i * 1000 / j;
      seekBar.setProgress((int)l);
    }
    int k = mediaPlayerControl.getBufferPercentage();
    seekBar.setSecondaryProgress(k * 10);
    endTimeText.setText(stringForTime(j));
    currentTimeText.setText(stringForTime(i));
    return i;
  }
  
  private String stringForTime(int paramInt)
  {
    int j = paramInt / 1000;
    paramInt = j % 60;
    int i = j / 60 % 60;
    j = j / 60 / 60;
    formatBuilder.setLength(0);
    if (j > 0) {
      return formatter.format("%d:%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramInt) }).toString();
    }
    return formatter.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) }).toString();
  }
  
  private void updatePausePlay()
  {
    if (mediaPlayerControl.isPlaying())
    {
      pauseButton.setImageResource(17301539);
      pauseButton.setContentDescription(pauseDescription);
      return;
    }
    pauseButton.setImageResource(17301540);
    pauseButton.setContentDescription(playDescription);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    int i = paramKeyEvent.getKeyCode();
    if ((i == 79) || (i == 85) || (i == 62))
    {
      doPauseResume();
      show(3000);
    }
    do
    {
      do
      {
        return true;
        if (i != 126) {
          break;
        }
      } while (mediaPlayerControl.isPlaying());
      mediaPlayerControl.start();
      updatePausePlay();
      show(3000);
      return true;
      if ((i != 86) && (i != 127)) {
        break;
      }
    } while (!mediaPlayerControl.isPlaying());
    mediaPlayerControl.pause();
    updatePausePlay();
    show(3000);
    return true;
    show(3000);
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public final void hide()
  {
    if (showing)
    {
      handler.removeMessages(2);
      container.setVisibility(4);
      if (visibilityChangedListener != null) {
        visibilityChangedListener.onHide$389b3c14();
      }
      showing = false;
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    Resources localResources = getContext().getResources();
    playDescription = localResources.getString(2131231125);
    pauseDescription = localResources.getString(2131231124);
    pauseButton.setOnClickListener(pauseListener);
    ffwdButton.setOnClickListener(ffwdListener);
    rewButton.setOnClickListener(rewListener);
    seekBar.setOnSeekBarChangeListener(seekListener);
    seekBar.setMax(1000);
    formatBuilder = new StringBuilder();
    formatter = new Formatter(formatBuilder, getContextgetResourcesgetConfigurationlocale);
    endTimeText.setText(stringForTime(0));
    currentTimeText.setText(stringForTime(0));
    setFocusable(true);
    setFocusableInTouchMode(true);
    setDescendantFocusability(262144);
    requestFocus();
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(VideoControl.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(VideoControl.class.getName());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      show(0);
      continue;
      show(3000);
      continue;
      hide();
    }
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    show(3000);
    return false;
  }
  
  public void setMediaPlayerControl(MediaPlayerControl paramMediaPlayerControl)
  {
    mediaPlayerControl = paramMediaPlayerControl;
    updatePausePlay();
  }
  
  public void setOnVisibilityChangedListener(OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    visibilityChangedListener = paramOnVisibilityChangedListener;
  }
  
  public final void show(int paramInt)
  {
    if (!showing)
    {
      setProgress();
      pauseButton.requestFocus();
      container.setVisibility(0);
      if (visibilityChangedListener != null) {
        visibilityChangedListener.onShow$389b3c14();
      }
      showing = true;
    }
    updatePausePlay();
    handler.sendEmptyMessage(2);
    Message localMessage = handler.obtainMessage(1);
    if (paramInt != 0)
    {
      handler.removeMessages(1);
      handler.sendMessageDelayed(localMessage, paramInt);
    }
  }
  
  public static abstract interface MediaPlayerControl
  {
    public abstract int getBufferPercentage();
    
    public abstract int getCurrentPosition();
    
    public abstract int getDuration();
    
    public abstract boolean isPlaying();
    
    public abstract void pause();
    
    public abstract void seekTo(int paramInt);
    
    public abstract void start();
  }
  
  public static abstract interface OnVisibilityChangedListener
  {
    public abstract void onHide$389b3c14();
    
    public abstract void onShow$389b3c14();
  }
  
  private static final class VisibilityHandler
    extends Handler
  {
    private WeakReference<VideoControl> videoControl;
    
    private VisibilityHandler(VideoControl paramVideoControl)
    {
      videoControl = new WeakReference(paramVideoControl);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (videoControl.get() == null) {}
      VideoControl localVideoControl;
      do
      {
        return;
        localVideoControl = (VideoControl)videoControl.get();
        switch (what)
        {
        default: 
          return;
        case 1: 
          localVideoControl.hide();
          return;
        }
        localVideoControl.setProgress();
      } while ((dragging) || (!showing) || (!mediaPlayerControl.isPlaying()));
      sendMessageDelayed(obtainMessage(2), 200L);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoControl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */