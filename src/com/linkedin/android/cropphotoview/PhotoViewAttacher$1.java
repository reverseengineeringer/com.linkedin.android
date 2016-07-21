package com.linkedin.android.cropphotoview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;

final class PhotoViewAttacher$1
  extends GestureDetector.SimpleOnGestureListener
{
  PhotoViewAttacher$1(PhotoViewAttacher paramPhotoViewAttacher) {}
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    if (PhotoViewAttacher.access$000(this$0) != null) {
      PhotoViewAttacher.access$000(this$0).onLongClick(this$0.getImageView());
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.cropphotoview.PhotoViewAttacher.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */