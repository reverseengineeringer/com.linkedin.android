package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;

public final class ActivityCompat
  extends ContextCompat
{
  static ActivityCompat21.SharedElementCallback21 createCallback(SharedElementCallback paramSharedElementCallback)
  {
    SharedElementCallback21Impl localSharedElementCallback21Impl = null;
    if (paramSharedElementCallback != null) {
      localSharedElementCallback21Impl = new SharedElementCallback21Impl(paramSharedElementCallback);
    }
    return localSharedElementCallback21Impl;
  }
  
  public static void requestPermissions(final Activity paramActivity, String[] paramArrayOfString, final int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if ((paramActivity instanceof ActivityCompatApi23.RequestPermissionsRequestCodeValidator)) {
        ((ActivityCompatApi23.RequestPermissionsRequestCodeValidator)paramActivity).validateRequestPermissionsRequestCode(paramInt);
      }
      paramActivity.requestPermissions(paramArrayOfString, paramInt);
    }
    while (!(paramActivity instanceof OnRequestPermissionsResultCallback)) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new Runnable()
    {
      public final void run()
      {
        int[] arrayOfInt = new int[val$permissions.length];
        PackageManager localPackageManager = paramActivity.getPackageManager();
        String str = paramActivity.getPackageName();
        int j = val$permissions.length;
        int i = 0;
        while (i < j)
        {
          arrayOfInt[i] = localPackageManager.checkPermission(val$permissions[i], str);
          i += 1;
        }
        ((ActivityCompat.OnRequestPermissionsResultCallback)paramActivity).onRequestPermissionsResult(paramInt, val$permissions, arrayOfInt);
      }
    });
  }
  
  public static boolean shouldShowRequestPermissionRationale(Activity paramActivity, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramActivity.shouldShowRequestPermissionRationale(paramString);
    }
    return false;
  }
  
  public static void startActivity(Activity paramActivity, Intent paramIntent, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startActivity(paramIntent, paramBundle);
      return;
    }
    paramActivity.startActivity(paramIntent);
  }
  
  public static void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static abstract interface OnRequestPermissionsResultCallback
  {
    public abstract void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt);
  }
  
  private static final class SharedElementCallback21Impl
    extends ActivityCompat21.SharedElementCallback21
  {
    private SharedElementCallback mCallback;
    
    public SharedElementCallback21Impl(SharedElementCallback paramSharedElementCallback)
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
}

/* Location:
 * Qualified Name:     android.support.v4.app.ActivityCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */