package com.linkedin.android.video.controller;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.linkedin.android.video.listener.PlayerListener;
import com.linkedin.android.video.util.StringsUtil;
import com.linkedin.gen.avro2pegasus.events.player.PlayPauseChangedReason;

public abstract class MediaController
  extends FrameLayout
  implements PlayerListener
{
  public static final int FADE_ANIM_DURATION_MS = 1000;
  protected static final int FADE_OUT = 1;
  protected static final int SHOW_PROGRESS = 2;
  private static final String TAG = "LIMediaController";
  protected static final int sDefaultTimeout = 3000;
  private ViewGroup mAnchor;
  private MediaControllerAnimationListener mAnimationListener;
  private Context mContext;
  private TextView mCurrentTime;
  private boolean mDragging;
  private TextView mEndTime;
  private boolean mFromXml;
  private Handler mHandler = new MediaController.MessageHandler(this);
  private boolean mListenersSet;
  protected MediaPlayerControl mMediaPlayerControl;
  private ImageButton mNextButton;
  private View.OnClickListener mNextListener;
  private ImageButton mPauseButton;
  private View.OnClickListener mPauseListener = new MediaController.1(this);
  private ImageButton mPrevButton;
  private View.OnClickListener mPrevListener;
  private SeekBar mProgress;
  private ImageButton mRestartButton;
  private View.OnClickListener mRestartListener = new MediaController.3(this);
  private View mRoot;
  private SeekBar.OnSeekBarChangeListener mSeekListener = new MediaController.2(this);
  private boolean mShowing;
  
  public MediaController(Context paramContext)
  {
    super(paramContext);
    init(paramContext, false);
  }
  
  public MediaController(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, true);
  }
  
  private void disableUnsupportedButtons()
  {
    if (mMediaPlayerControl == null) {}
    for (;;)
    {
      return;
      try
      {
        if ((mPauseButton != null) && (!mMediaPlayerControl.canPause()))
        {
          mPauseButton.setEnabled(false);
          return;
        }
      }
      catch (IncompatibleClassChangeError localIncompatibleClassChangeError) {}
    }
  }
  
  private void doPauseResume()
  {
    if (mMediaPlayerControl == null) {
      return;
    }
    if (mMediaPlayerControl.isPlaying()) {
      mMediaPlayerControl.pause(PlayPauseChangedReason.USER_TRIGGERED);
    }
    for (;;)
    {
      updatePausePlay();
      return;
      mMediaPlayerControl.start(PlayPauseChangedReason.USER_TRIGGERED);
    }
  }
  
  private void installPrevNextListeners()
  {
    boolean bool2 = true;
    ImageButton localImageButton;
    if (mNextButton != null)
    {
      mNextButton.setOnClickListener(mNextListener);
      localImageButton = mNextButton;
      if (mNextListener != null)
      {
        bool1 = true;
        localImageButton.setEnabled(bool1);
      }
    }
    else if (mPrevButton != null)
    {
      mPrevButton.setOnClickListener(mPrevListener);
      localImageButton = mPrevButton;
      if (mPrevListener == null) {
        break label82;
      }
    }
    label82:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localImageButton.setEnabled(bool1);
      return;
      bool1 = false;
      break;
    }
  }
  
  public static MediaController newInstance(Context paramContext)
  {
    return new LIMediaController(paramContext);
  }
  
  private void onFadeAnimationEnd()
  {
    if (mAnimationListener != null) {
      mAnimationListener.notifyFadeAnimationEnd();
    }
  }
  
  private void onFadeAnimationStart()
  {
    if (mAnimationListener != null) {
      mAnimationListener.notifyFadeAnimationStart();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (mMediaPlayerControl == null) {}
    int i;
    label85:
    do
    {
      int j;
      do
      {
        do
        {
          return true;
          j = paramKeyEvent.getKeyCode();
          if ((paramKeyEvent.getRepeatCount() == 0) && (paramKeyEvent.getAction() == 0)) {}
          for (i = 1;; i = 0)
          {
            if ((j != 79) && (j != 85) && (j != 62)) {
              break label85;
            }
            if (i == 0) {
              break;
            }
            doPauseResume();
            show(3000);
            if (mPauseButton == null) {
              break;
            }
            mPauseButton.requestFocus();
            return true;
          }
          if (j != 126) {
            break;
          }
        } while ((i == 0) || (mMediaPlayerControl.isPlaying()));
        mMediaPlayerControl.start(PlayPauseChangedReason.USER_TRIGGERED);
        updatePausePlay();
        show(3000);
        return true;
        if ((j != 86) && (j != 127)) {
          break;
        }
      } while ((i == 0) || (!mMediaPlayerControl.isPlaying()));
      mMediaPlayerControl.pause(PlayPauseChangedReason.USER_TRIGGERED);
      updatePausePlay();
      show(3000);
      return true;
      if ((j == 25) || (j == 24) || (j == 164)) {
        return super.dispatchKeyEvent(paramKeyEvent);
      }
      if ((j != 4) && (j != 82)) {
        break;
      }
    } while (i == 0);
    hide();
    return true;
    show(3000);
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected abstract int getLayoutId();
  
  public MediaPlayerControl getMediaPlayer()
  {
    return mMediaPlayerControl;
  }
  
  protected abstract int getNextId();
  
  protected abstract int getPauseDrawable();
  
  protected abstract int getPlayDrawable();
  
  protected abstract int getPlayPauseId();
  
  protected abstract int getPrevId();
  
  protected abstract int getRestartId();
  
  protected abstract int getSeekBarId();
  
  protected abstract int getTimeCurrentId();
  
  protected abstract int getTimeId();
  
  public void hide()
  {
    if (mAnchor == null) {
      return;
    }
    try
    {
      mAnchor.removeView(this);
      mHandler.removeMessages(2);
      mShowing = false;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Log.w("LIMediaController", "already removed");
      }
    }
  }
  
  protected void init(Context paramContext, boolean paramBoolean)
  {
    mContext = paramContext;
    mFromXml = paramBoolean;
    mRoot = null;
  }
  
  protected void initControllerView(View paramView)
  {
    mPauseButton = ((ImageButton)paramView.findViewById(getPlayPauseId()));
    if (mPauseButton != null)
    {
      mPauseButton.requestFocus();
      mPauseButton.setOnClickListener(mPauseListener);
    }
    mRestartButton = ((ImageButton)paramView.findViewById(getRestartId()));
    if (mRestartButton != null)
    {
      mRestartButton.setColorFilter(-1);
      mRestartButton.setOnClickListener(mRestartListener);
    }
    mNextButton = ((ImageButton)paramView.findViewById(getNextId()));
    if ((mNextButton != null) && (!mFromXml) && (!mListenersSet)) {
      mNextButton.setVisibility(8);
    }
    mPrevButton = ((ImageButton)paramView.findViewById(getPrevId()));
    if ((mPrevButton != null) && (!mFromXml) && (!mListenersSet)) {
      mPrevButton.setVisibility(8);
    }
    mProgress = ((SeekBar)paramView.findViewById(getSeekBarId()));
    if (mProgress != null)
    {
      mProgress.setOnSeekBarChangeListener(mSeekListener);
      mProgress.setMax(1000);
    }
    mEndTime = ((TextView)paramView.findViewById(getTimeId()));
    mCurrentTime = ((TextView)paramView.findViewById(getTimeCurrentId()));
    installPrevNextListeners();
  }
  
  public boolean isShowing()
  {
    return mShowing;
  }
  
  protected View makeControllerView()
  {
    mRoot = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(getLayoutId(), null);
    initControllerView(mRoot);
    return mRoot;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    if (mRoot != null) {
      initControllerView(mRoot);
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(MediaController.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(MediaController.class.getName());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    show(3000);
    return true;
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    show(3000);
    return false;
  }
  
  public void setAnchorView(ViewGroup paramViewGroup)
  {
    mAnchor = paramViewGroup;
    paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
    removeAllViews();
    addView(makeControllerView(), paramViewGroup);
  }
  
  public void setAnimationListener(MediaControllerAnimationListener paramMediaControllerAnimationListener)
  {
    mAnimationListener = paramMediaControllerAnimationListener;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    boolean bool2 = true;
    if (mPauseButton != null) {
      mPauseButton.setEnabled(paramBoolean);
    }
    if (mRestartButton != null) {
      mRestartButton.setEnabled(paramBoolean);
    }
    ImageButton localImageButton;
    if (mNextButton != null)
    {
      localImageButton = mNextButton;
      if ((paramBoolean) && (mNextListener != null))
      {
        bool1 = true;
        localImageButton.setEnabled(bool1);
      }
    }
    else if (mPrevButton != null)
    {
      localImageButton = mPrevButton;
      if ((!paramBoolean) || (mPrevListener == null)) {
        break label126;
      }
    }
    label126:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localImageButton.setEnabled(bool1);
      if (mProgress != null) {
        mProgress.setEnabled(paramBoolean);
      }
      disableUnsupportedButtons();
      super.setEnabled(paramBoolean);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void setMediaPlayer(MediaPlayerControl paramMediaPlayerControl)
  {
    mMediaPlayerControl = paramMediaPlayerControl;
    updatePausePlay();
  }
  
  public void setPrevNextListeners(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    mNextListener = paramOnClickListener1;
    mPrevListener = paramOnClickListener2;
    mListenersSet = true;
    if (mRoot != null)
    {
      installPrevNextListeners();
      if ((mNextButton != null) && (!mFromXml)) {
        mNextButton.setVisibility(0);
      }
      if ((mPrevButton != null) && (!mFromXml)) {
        mPrevButton.setVisibility(0);
      }
    }
  }
  
  protected int setProgress()
  {
    int i;
    if ((mMediaPlayerControl == null) || (mDragging)) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = mMediaPlayerControl.getCurrentPosition();
      i = mMediaPlayerControl.getDuration();
      if (mProgress != null)
      {
        if (i > 0)
        {
          long l = 1000L * j / i;
          mProgress.setProgress((int)l);
        }
        int k = mMediaPlayerControl.getBufferPercentage();
        mProgress.setSecondaryProgress(k * 10);
      }
      if (mEndTime != null) {
        mEndTime.setText(StringsUtil.stringForTime(i));
      }
      i = j;
    } while (mCurrentTime == null);
    mCurrentTime.setText(StringsUtil.stringForTime(j));
    return j;
  }
  
  public void show()
  {
    show(3000);
  }
  
  public void show(int paramInt)
  {
    if ((!mShowing) && (mAnchor != null))
    {
      setProgress();
      if (mPauseButton != null) {
        mPauseButton.requestFocus();
      }
      disableUnsupportedButtons();
      localObject = new FrameLayout.LayoutParams(-1, -2, 80);
      mAnchor.addView(this, (ViewGroup.LayoutParams)localObject);
      mShowing = true;
    }
    updatePausePlay();
    mHandler.sendEmptyMessage(2);
    Object localObject = mHandler.obtainMessage(1);
    if (paramInt != 0)
    {
      mHandler.removeMessages(1);
      mHandler.sendMessageDelayed((Message)localObject, paramInt);
    }
  }
  
  public void updatePausePlay()
  {
    if ((mRoot == null) || (mPauseButton == null) || (mMediaPlayerControl == null)) {
      return;
    }
    if (mMediaPlayerControl.isPlaying())
    {
      mPauseButton.setImageResource(getPauseDrawable());
      return;
    }
    mPauseButton.setImageResource(getPlayDrawable());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.video.controller.MediaController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */