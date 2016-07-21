package android.support.v4.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.util.List;

public abstract class SharedElementCallback
{
  static int MAX_IMAGE_SIZE = 1048576;
  Matrix mTempMatrix;
  
  static Bitmap createDrawableBitmap(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if ((i <= 0) || (j <= 0)) {
      return null;
    }
    float f = Math.min(1.0F, MAX_IMAGE_SIZE / (i * j));
    if (((paramDrawable instanceof BitmapDrawable)) && (f == 1.0F)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    i = (int)(i * f);
    j = (int)(j * f);
    Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Rect localRect = paramDrawable.getBounds();
    int k = left;
    int m = top;
    int n = right;
    int i1 = bottom;
    paramDrawable.setBounds(0, 0, i, j);
    paramDrawable.draw(localCanvas);
    paramDrawable.setBounds(k, m, n, i1);
    return localBitmap;
  }
  
  public static View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
  {
    Object localObject1 = null;
    if ((paramParcelable instanceof Bundle))
    {
      Object localObject2 = (Bundle)paramParcelable;
      localObject1 = (Bitmap)((Bundle)localObject2).getParcelable("sharedElement:snapshot:bitmap");
      if (localObject1 == null) {
        return null;
      }
      paramParcelable = new ImageView(paramContext);
      paramContext = paramParcelable;
      paramParcelable.setImageBitmap((Bitmap)localObject1);
      paramParcelable.setScaleType(ImageView.ScaleType.valueOf(((Bundle)localObject2).getString("sharedElement:snapshot:imageScaleType")));
      localObject1 = paramContext;
      if (paramParcelable.getScaleType() == ImageView.ScaleType.MATRIX)
      {
        localObject1 = ((Bundle)localObject2).getFloatArray("sharedElement:snapshot:imageMatrix");
        localObject2 = new Matrix();
        ((Matrix)localObject2).setValues((float[])localObject1);
        paramParcelable.setImageMatrix((Matrix)localObject2);
        localObject1 = paramContext;
      }
    }
    for (;;)
    {
      return (View)localObject1;
      if ((paramParcelable instanceof Bitmap))
      {
        paramParcelable = (Bitmap)paramParcelable;
        localObject1 = new ImageView(paramContext);
        ((ImageView)localObject1).setImageBitmap(paramParcelable);
      }
    }
  }
  
  public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
}

/* Location:
 * Qualified Name:     android.support.v4.app.SharedElementCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */