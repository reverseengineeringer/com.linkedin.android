package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class LinearLayoutCompat$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  public int gravity = -1;
  public float weight;
  
  public LinearLayoutCompat$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    weight = 0.0F;
  }
  
  public LinearLayoutCompat$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LinearLayoutCompat_Layout);
    weight = paramContext.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
    gravity = paramContext.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
    paramContext.recycle();
  }
  
  public LinearLayoutCompat$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.LinearLayoutCompat.LayoutParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */