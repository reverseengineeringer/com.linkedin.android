package com.linkedin.android.feed.shared;

import com.linkedin.android.imageloader.ManagedDrawableWrapper;
import com.linkedin.android.infra.network.DrawableRequest.DrawableCallback;

final class StackedImagesDrawable$1
  implements DrawableRequest.DrawableCallback
{
  StackedImagesDrawable$1(StackedImagesDrawable paramStackedImagesDrawable, int paramInt) {}
  
  public final void onDrawableLoaded$295bc2c2(ManagedDrawableWrapper paramManagedDrawableWrapper)
  {
    StackedImagesDrawable.access$100(this$0, drawable, val$pos);
    this$0.invalidateSelf();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.StackedImagesDrawable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */