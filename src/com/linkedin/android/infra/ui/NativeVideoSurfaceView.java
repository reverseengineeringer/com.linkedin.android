package com.linkedin.android.infra.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.linkedin.android.feed.promptresponselist.PlayerLibDelegate;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.video.LIVideoPlayer;
import com.linkedin.android.video.LIVideoPlayerBuilder;
import com.linkedin.android.video.controller.MediaController;
import com.linkedin.android.video.listener.PlayerViewListener;

public class NativeVideoSurfaceView
  extends FrameLayout
{
  public static final String TAG = NativeVideoSurfaceView.class.getSimpleName();
  public static NativeVideoSurfaceView instance;
  public ApplicationComponent appComponent;
  public Context context;
  public MediaController mediaController;
  public LIVideoPlayer player;
  public PlayerReleasedListener playerReleasedListener;
  public PlayerViewListener playerViewListener;
  public SurfaceView videoSurfaceView;
  
  private NativeVideoSurfaceView(Context paramContext)
  {
    super(paramContext);
    context = paramContext;
    appComponent = Util.getAppComponent(paramContext);
    LayoutInflater.from(paramContext).inflate(2130969111, this, true);
    videoSurfaceView = ((SurfaceView)findViewById(2131757114));
    mediaController = MediaController.newInstance(paramContext);
    mediaController.setAnchorView(this);
    if (player == null)
    {
      player = new LIVideoPlayerBuilder().setContext(context).setTracker(PlayerLibDelegate.getInstance(appComponent)).setSystemDelegate(PlayerLibDelegate.getInstance(appComponent)).build();
      player.setMediaController(mediaController);
      mediaController.setEnabled(true);
      player.addViewListener(new NativeVideoSurfaceView.1(this));
    }
  }
  
  public static NativeVideoSurfaceView getInstance(Context paramContext)
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new NativeVideoSurfaceView(paramContext);
      }
      return instance;
    }
    finally {}
  }
  
  private View.OnClickListener getOnClickListener()
  {
    return new NativeVideoSurfaceView.2(this);
  }
  
  public static abstract interface PlayerReleasedListener
  {
    public abstract void onPlayerReleased();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.ui.NativeVideoSurfaceView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */