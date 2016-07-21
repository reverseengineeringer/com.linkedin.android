package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

public final class TintTypedArray
{
  private final Context mContext;
  public final TypedArray mWrapped;
  
  private TintTypedArray(Context paramContext, TypedArray paramTypedArray)
  {
    mContext = paramContext;
    mWrapped = paramTypedArray;
  }
  
  public static TintTypedArray obtainStyledAttributes(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    return new TintTypedArray(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt));
  }
  
  public static TintTypedArray obtainStyledAttributes$89ace2b(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt, int paramInt)
  {
    return new TintTypedArray(paramContext, paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, paramInt, 0));
  }
  
  public final boolean getBoolean(int paramInt, boolean paramBoolean)
  {
    return mWrapped.getBoolean(paramInt, paramBoolean);
  }
  
  public final int getColor$255f288(int paramInt)
  {
    return mWrapped.getColor(paramInt, -1);
  }
  
  public final int getDimensionPixelOffset(int paramInt1, int paramInt2)
  {
    return mWrapped.getDimensionPixelOffset(paramInt1, paramInt2);
  }
  
  public final int getDimensionPixelSize(int paramInt1, int paramInt2)
  {
    return mWrapped.getDimensionPixelSize(paramInt1, paramInt2);
  }
  
  public final Drawable getDrawable(int paramInt)
  {
    if (mWrapped.hasValue(paramInt))
    {
      int i = mWrapped.getResourceId(paramInt, 0);
      if (i != 0) {
        return AppCompatDrawableManager.get().getDrawable(mContext, i, false);
      }
    }
    return mWrapped.getDrawable(paramInt);
  }
  
  public final Drawable getDrawableIfKnown(int paramInt)
  {
    if (mWrapped.hasValue(paramInt))
    {
      paramInt = mWrapped.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return AppCompatDrawableManager.get().getDrawable(mContext, paramInt, true);
      }
    }
    return null;
  }
  
  public final int getInt(int paramInt1, int paramInt2)
  {
    return mWrapped.getInt(paramInt1, paramInt2);
  }
  
  public final int getLayoutDimension(int paramInt1, int paramInt2)
  {
    return mWrapped.getLayoutDimension(paramInt1, paramInt2);
  }
  
  public final int getResourceId(int paramInt1, int paramInt2)
  {
    return mWrapped.getResourceId(paramInt1, paramInt2);
  }
  
  public final CharSequence getText(int paramInt)
  {
    return mWrapped.getText(paramInt);
  }
  
  public final boolean hasValue(int paramInt)
  {
    return mWrapped.hasValue(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.TintTypedArray
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */