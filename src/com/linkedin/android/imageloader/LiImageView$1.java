package com.linkedin.android.imageloader;

import android.text.TextUtils;
import android.util.Pair;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.logger.Log;

final class LiImageView$1
  implements ImageListener
{
  LiImageView$1(LiImageView paramLiImageView, LiImageView.ImageViewLoadListener paramImageViewLoadListener) {}
  
  public final Pair<Integer, Integer> getTargetDimensions()
  {
    if ((this$0.getMeasuredWidth() <= 0) || (this$0.getMeasuredHeight() <= 0)) {
      return null;
    }
    return new Pair(Integer.valueOf(this$0.getMeasuredWidth()), Integer.valueOf(this$0.getMeasuredHeight()));
  }
  
  public final void onErrorResponse(String paramString, Exception paramException)
  {
    if ((LiImageView.access$000(this$0)) && (LiImageView.access$100(this$0) != null) && (TextUtils.equals(access$100this$0).mRequestUrl, paramString)))
    {
      Log.e(LiImageView.access$200(), "Failed to load image for: " + paramString, paramException);
      LiImageView.access$400(this$0);
      if (val$listener != null) {
        val$listener.onImageLoadFailure(paramString, paramException);
      }
    }
  }
  
  public final void onResponse(String paramString, ManagedBitmap paramManagedBitmap, boolean paramBoolean)
  {
    if ((LiImageView.access$000(this$0)) && (LiImageView.access$100(this$0) != null) && (TextUtils.equals(access$100this$0).mRequestUrl, paramString)))
    {
      FeatureLog.d(LiImageView.access$200(), "Loaded image successfully for: " + paramString, "LI Image Loader");
      LiImageView.access$300(this$0, paramManagedBitmap, paramBoolean);
      if (val$listener != null) {
        val$listener.onImageLoadSuccess(paramManagedBitmap, paramString, paramBoolean);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.LiImageView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */