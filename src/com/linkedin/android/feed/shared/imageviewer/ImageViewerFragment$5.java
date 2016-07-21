package com.linkedin.android.feed.shared.imageviewer;

import android.support.v4.app.SharedElementCallback;
import android.view.View;
import com.linkedin.android.imageviewer.ImageViewerController;
import java.util.List;

final class ImageViewerFragment$5
  extends SharedElementCallback
{
  ImageViewerFragment$5(ImageViewerFragment paramImageViewerFragment) {}
  
  public final void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2)
  {
    super.onSharedElementStart(paramList, paramList1, paramList2);
    if (ImageViewerFragment.access$800(this$0)) {
      ImageViewerFragment.access$000(this$0).cleanUp();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerFragment.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */