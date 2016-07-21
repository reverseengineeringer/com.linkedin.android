package com.linkedin.android.feed.shared.imageviewer;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class ImageViewerFragmentFactory
  extends FragmentFactory<ImageViewerBundle>
{
  protected final Fragment provideFragment()
  {
    return new ImageViewerFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */