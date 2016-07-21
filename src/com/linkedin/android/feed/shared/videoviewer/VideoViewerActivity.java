package com.linkedin.android.feed.shared.videoviewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseActivity;

public class VideoViewerActivity
  extends BaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      return;
    }
    paramBundle = getIntent().getExtras();
    paramBundle = VideoViewerBundle.create(paramBundle.getString("url"), paramBundle.getString("title"), paramBundle.getString("subtitle"));
    paramBundle = fragmentRegistry.videoViewer.newFragment(paramBundle);
    getSupportFragmentManager().beginTransaction().add(16908290, paramBundle).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoViewerActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */