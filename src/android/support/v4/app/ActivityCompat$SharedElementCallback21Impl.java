package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;

final class ActivityCompat$SharedElementCallback21Impl
  extends ActivityCompat21.SharedElementCallback21
{
  private SharedElementCallback mCallback;
  
  public ActivityCompat$SharedElementCallback21Impl(SharedElementCallback paramSharedElementCallback)
  {
    mCallback = paramSharedElementCallback;
  }
  
  public final Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
  {
    SharedElementCallback localSharedElementCallback = mCallback;
    ImageView localImageView;
    Object localObject1;
    if ((paramView instanceof ImageView))
    {
      localImageView = (ImageView)paramView;
      localObject1 = localImageView.getDrawable();
      Object localObject2 = localImageView.getBackground();
      if ((localObject1 != null) && (localObject2 == null))
      {
        localObject2 = SharedElementCallback.createDrawableBitmap((Drawable)localObject1);
        if (localObject2 != null)
        {
          localObject1 = new Bundle();
          ((Bundle)localObject1).putParcelable("sharedElement:snapshot:bitmap", (Parcelable)localObject2);
          ((Bundle)localObject1).putString("sharedElement:snapshot:imageScaleType", localImageView.getScaleType().toString());
          if (localImageView.getScaleType() == ImageView.ScaleType.MATRIX)
          {
            paramView = localImageView.getImageMatrix();
            paramMatrix = new float[9];
            paramView.getValues(paramMatrix);
            ((Bundle)localObject1).putFloatArray("sharedElement:snapshot:imageMatrix", paramMatrix);
          }
        }
      }
    }
    do
    {
      do
      {
        return (Parcelable)localObject1;
        j = Math.round(paramRectF.width());
        i = Math.round(paramRectF.height());
        localImageView = null;
        localObject1 = localImageView;
      } while (j <= 0);
      localObject1 = localImageView;
    } while (i <= 0);
    float f = Math.min(1.0F, SharedElementCallback.MAX_IMAGE_SIZE / (j * i));
    int j = (int)(j * f);
    int i = (int)(i * f);
    if (mTempMatrix == null) {
      mTempMatrix = new Matrix();
    }
    mTempMatrix.set(paramMatrix);
    mTempMatrix.postTranslate(-left, -top);
    mTempMatrix.postScale(f, f);
    paramMatrix = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
    paramRectF = new Canvas(paramMatrix);
    paramRectF.concat(mTempMatrix);
    paramView.draw(paramRectF);
    return paramMatrix;
  }
  
  public final View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
  {
    return SharedElementCallback.onCreateSnapshotView(paramContext, paramParcelable);
  }
  
  public final void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2)
  {
    mCallback.onSharedElementStart(paramList, paramList1, paramList2);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.ActivityCompat.SharedElementCallback21Impl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */