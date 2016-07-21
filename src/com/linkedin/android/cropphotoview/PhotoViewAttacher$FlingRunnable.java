package com.linkedin.android.cropphotoview;

import android.content.Context;
import android.graphics.Matrix;
import android.util.Log;
import android.widget.ImageView;
import com.linkedin.android.cropphotoview.scrollerproxy.IcsScroller;
import com.linkedin.android.cropphotoview.scrollerproxy.ScrollerProxy;

final class PhotoViewAttacher$FlingRunnable
  implements Runnable
{
  int mCurrentX;
  int mCurrentY;
  final ScrollerProxy mScroller;
  
  public PhotoViewAttacher$FlingRunnable(PhotoViewAttacher paramPhotoViewAttacher, Context paramContext)
  {
    mScroller = new IcsScroller(paramContext);
  }
  
  public final void run()
  {
    if (mScroller.isFinished()) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = this$0.getImageView();
    } while ((localImageView == null) || (!mScroller.computeScrollOffset()));
    int i = mScroller.getCurrX();
    int j = mScroller.getCurrY();
    if (PhotoViewAttacher.access$300()) {
      Log.d("PhotoViewAttacher", "fling run(). CurrentX:" + mCurrentX + " CurrentY:" + mCurrentY + " NewX:" + i + " NewY:" + j);
    }
    PhotoViewAttacher.access$100(this$0).postTranslate(mCurrentX - i, mCurrentY - j);
    PhotoViewAttacher.access$400(this$0, this$0.getDrawMatrix());
    mCurrentX = i;
    mCurrentY = j;
    Compat.postOnAnimation(localImageView, this);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.cropphotoview.PhotoViewAttacher.FlingRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */