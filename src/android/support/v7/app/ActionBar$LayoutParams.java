package android.support.v7.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class ActionBar$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  public int gravity = 0;
  
  public ActionBar$LayoutParams()
  {
    super(-2, -2);
    gravity = 8388627;
  }
  
  public ActionBar$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBarLayout);
    gravity = paramContext.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
    paramContext.recycle();
  }
  
  public ActionBar$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    gravity = gravity;
  }
  
  public ActionBar$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.ActionBar.LayoutParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */