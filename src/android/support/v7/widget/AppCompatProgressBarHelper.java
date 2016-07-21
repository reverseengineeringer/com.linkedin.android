package android.support.v7.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class AppCompatProgressBarHelper
{
  private static final int[] TINT_ATTRS = { 16843067, 16843068 };
  final AppCompatDrawableManager mDrawableManager;
  Bitmap mSampleTile;
  private final ProgressBar mView;
  
  AppCompatProgressBarHelper(ProgressBar paramProgressBar, AppCompatDrawableManager paramAppCompatDrawableManager)
  {
    mView = paramProgressBar;
    mDrawableManager = paramAppCompatDrawableManager;
  }
  
  private Drawable tileify(Drawable paramDrawable, boolean paramBoolean)
  {
    if ((paramDrawable instanceof DrawableWrapper))
    {
      localObject1 = ((DrawableWrapper)paramDrawable).getWrappedDrawable();
      if (localObject1 != null)
      {
        localObject1 = tileify((Drawable)localObject1, paramBoolean);
        ((DrawableWrapper)paramDrawable).setWrappedDrawable((Drawable)localObject1);
      }
    }
    do
    {
      return paramDrawable;
      if ((paramDrawable instanceof LayerDrawable))
      {
        localObject2 = (LayerDrawable)paramDrawable;
        int j = ((LayerDrawable)localObject2).getNumberOfLayers();
        paramDrawable = new Drawable[j];
        int i = 0;
        if (i < j)
        {
          int k = ((LayerDrawable)localObject2).getId(i);
          localObject1 = ((LayerDrawable)localObject2).getDrawable(i);
          if ((k == 16908301) || (k == 16908303)) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            paramDrawable[i] = tileify((Drawable)localObject1, paramBoolean);
            i += 1;
            break;
          }
        }
        localObject1 = new LayerDrawable(paramDrawable);
        i = 0;
        for (;;)
        {
          paramDrawable = (Drawable)localObject1;
          if (i >= j) {
            break;
          }
          ((LayerDrawable)localObject1).setId(i, ((LayerDrawable)localObject2).getId(i));
          i += 1;
        }
      }
    } while (!(paramDrawable instanceof BitmapDrawable));
    paramDrawable = (BitmapDrawable)paramDrawable;
    Object localObject2 = paramDrawable.getBitmap();
    if (mSampleTile == null) {
      mSampleTile = ((Bitmap)localObject2);
    }
    Object localObject1 = new ShapeDrawable(new RoundRectShape(new float[] { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F }, null, null));
    localObject2 = new BitmapShader((Bitmap)localObject2, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
    ((ShapeDrawable)localObject1).getPaint().setShader((Shader)localObject2);
    ((ShapeDrawable)localObject1).getPaint().setColorFilter(paramDrawable.getPaint().getColorFilter());
    if (paramBoolean) {
      return new ClipDrawable((Drawable)localObject1, 3, 1);
    }
    return (Drawable)localObject1;
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes$89ace2b(mView.getContext(), paramAttributeSet, TINT_ATTRS, paramInt);
    Object localObject = localTintTypedArray.getDrawableIfKnown(0);
    if (localObject != null)
    {
      ProgressBar localProgressBar = mView;
      paramAttributeSet = (AttributeSet)localObject;
      if ((localObject instanceof AnimationDrawable))
      {
        localObject = (AnimationDrawable)localObject;
        int i = ((AnimationDrawable)localObject).getNumberOfFrames();
        paramAttributeSet = new AnimationDrawable();
        paramAttributeSet.setOneShot(((AnimationDrawable)localObject).isOneShot());
        paramInt = 0;
        while (paramInt < i)
        {
          Drawable localDrawable = tileify(((AnimationDrawable)localObject).getFrame(paramInt), true);
          localDrawable.setLevel(10000);
          paramAttributeSet.addFrame(localDrawable, ((AnimationDrawable)localObject).getDuration(paramInt));
          paramInt += 1;
        }
        paramAttributeSet.setLevel(10000);
      }
      localProgressBar.setIndeterminateDrawable(paramAttributeSet);
    }
    paramAttributeSet = localTintTypedArray.getDrawableIfKnown(1);
    if (paramAttributeSet != null) {
      mView.setProgressDrawable(tileify(paramAttributeSet, false));
    }
    mWrapped.recycle();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AppCompatProgressBarHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */