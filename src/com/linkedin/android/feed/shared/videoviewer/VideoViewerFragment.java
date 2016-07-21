package com.linkedin.android.feed.shared.videoviewer;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import butterknife.InjectView;
import com.linkedin.android.infra.VoyagerShakeDelegate.ShakeDebugDataProvider;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import javax.inject.Inject;

public class VideoViewerFragment
  extends PageFragment
  implements VoyagerShakeDelegate.ShakeDebugDataProvider
{
  @Inject
  ActivityComponent activityComponent;
  @Inject
  MediaCenter mediaCenter;
  @InjectView(2131755885)
  FrameLayout rootLayout;
  private String subTitle;
  private String title;
  private String url;
  @InjectView(2131755887)
  VideoControl videoControl;
  @InjectView(2131755886)
  VideoView videoViewer;
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    url = WebViewerBundle.getUrl(getArguments());
    title = WebViewerBundle.getTitle(getArguments());
    subTitle = WebViewerBundle.getSubtitle(getArguments());
    paramBundle = getActivity();
    if ((Build.VERSION.SDK_INT >= 16) && (paramBundle != null))
    {
      paramBundle = paramBundle.getWindow().getDecorView();
      paramBundle.setSystemUiVisibility(paramBundle.getSystemUiVisibility() | 0x100 | 0x400);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968773, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    VideoView localVideoView = videoViewer;
    if (mediaPlayer != null)
    {
      mediaPlayer.stop();
      mediaPlayer.release();
      mediaPlayer = null;
      currentState = 0;
      targetState = 0;
    }
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    videoControl.setMediaPlayerControl(videoViewer);
    videoControl.setOnVisibilityChangedListener(new VideoControl.OnVisibilityChangedListener()
    {
      public final void onHide$389b3c14()
      {
        FragmentActivity localFragmentActivity = getActivity();
        if ((Build.VERSION.SDK_INT >= 16) && (localFragmentActivity != null))
        {
          int j = localFragmentActivity.getWindow().getDecorView().getSystemUiVisibility() | 0x1 | 0x4;
          int i = j;
          if (Build.VERSION.SDK_INT >= 19) {
            i = j | 0x800;
          }
          localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(i);
        }
      }
      
      public final void onShow$389b3c14()
      {
        FragmentActivity localFragmentActivity = getActivity();
        if ((Build.VERSION.SDK_INT >= 16) && (localFragmentActivity != null))
        {
          int j = localFragmentActivity.getWindow().getDecorView().getSystemUiVisibility() & 0xFFFFFFFE & 0xFFFFFFFB;
          int i = j;
          if (Build.VERSION.SDK_INT >= 19) {
            i = j & 0xF7FF;
          }
          localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(i);
        }
      }
    });
    videoViewer.setVideoControl(videoControl);
    videoViewer.setVideoPath(url);
    videoViewer.requestFocus();
    videoViewer.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return false;
      }
    });
    videoViewer.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        videoViewer.start();
      }
    });
  }
  
  public final String pageKey()
  {
    return "feed_richmedia_viewer";
  }
  
  public final String provideDebugData()
  {
    if (url != null) {
      return "Video URL: " + url;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoViewerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */