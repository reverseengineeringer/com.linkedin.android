package com.linkedin.android.feed.shared.imageviewer;

import com.linkedin.android.imageviewer.ImageViewerController;

final class ImageViewerFragment$1
  implements Runnable
{
  ImageViewerFragment$1(ImageViewerFragment paramImageViewerFragment) {}
  
  public final void run()
  {
    if (ImageViewerFragment.access$000(this$0) != null)
    {
      ImageViewerFragment.access$000(this$0).enterFullscreenMode();
      ImageViewerFragment.access$000(this$0).hideUIElements();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */