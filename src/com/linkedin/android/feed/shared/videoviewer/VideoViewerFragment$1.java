package com.linkedin.android.feed.shared.videoviewer;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

final class VideoViewerFragment$1
  implements VideoControl.OnVisibilityChangedListener
{
  VideoViewerFragment$1(VideoViewerFragment paramVideoViewerFragment) {}
  
  public final void onHide$389b3c14()
  {
    FragmentActivity localFragmentActivity = this$0.getActivity();
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
    FragmentActivity localFragmentActivity = this$0.getActivity();
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoViewerFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */