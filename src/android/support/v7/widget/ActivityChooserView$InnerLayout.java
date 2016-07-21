package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public class ActivityChooserView$InnerLayout
  extends LinearLayoutCompat
{
  private static final int[] TINT_ATTRS = { 16842964 };
  
  public ActivityChooserView$InnerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, TINT_ATTRS);
    setBackgroundDrawable(paramContext.getDrawable(0));
    mWrapped.recycle();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.InnerLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */