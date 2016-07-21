package com.linkedin.android.feed.shared.imageviewer;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class ImageViewerFragment$3
  extends DefaultModelListener<Update>
{
  ImageViewerFragment$3(ImageViewerFragment paramImageViewerFragment) {}
  
  public final void onCacheError(DataManagerException paramDataManagerException)
  {
    ImageViewerFragment.access$100(this$0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */