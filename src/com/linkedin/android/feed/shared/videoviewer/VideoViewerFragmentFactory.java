package com.linkedin.android.feed.shared.videoviewer;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class VideoViewerFragmentFactory
  extends FragmentFactory<VideoViewerBundle>
{
  protected final Fragment provideFragment()
  {
    return new VideoViewerFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoViewerFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */