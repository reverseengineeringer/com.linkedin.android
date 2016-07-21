package com.linkedin.android.feed.promptresponselist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.ui.NativeVideoSurfaceView;
import com.linkedin.android.infra.ui.NativeVideoSurfaceView.PlayerReleasedListener;
import com.linkedin.android.video.LIVideoPlayer;
import com.linkedin.android.video.controller.MediaController;

public class FeedPromptResponseListActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFormat(-3);
    setContentView(2130968943);
    if ((FeedPromptResponseListFragment)getSupportFragmentManager().findFragmentById(16908290) == null)
    {
      paramBundle = new FeedPromptResponseListFragment();
      paramBundle.setArguments(getIntent().getExtras());
      getSupportFragmentManager().beginTransaction().add(16908290, paramBundle).commit();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    NativeVideoSurfaceView localNativeVideoSurfaceView = NativeVideoSurfaceView.getInstance(this);
    if (localNativeVideoSurfaceView != null)
    {
      localNativeVideoSurfaceView.setVisibility(8);
      if (playerReleasedListener != null) {
        playerReleasedListener.onPlayerReleased();
      }
      if (mediaController != null)
      {
        mediaController.hide();
        mediaController = null;
      }
      if (player != null)
      {
        player.detachSurfaceView(videoSurfaceView);
        player.removeViewListeners();
        player.release();
        player = null;
      }
      playerViewListener = null;
      playerReleasedListener = null;
      NativeVideoSurfaceView.instance = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.promptresponselist.FeedPromptResponseListActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */