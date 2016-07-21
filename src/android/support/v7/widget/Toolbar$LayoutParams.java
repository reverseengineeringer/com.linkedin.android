package android.support.v7.widget;

import android.content.Context;
import android.support.v7.app.ActionBar.LayoutParams;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class Toolbar$LayoutParams
  extends ActionBar.LayoutParams
{
  int mViewType = 0;
  
  public Toolbar$LayoutParams()
  {
    gravity = 8388627;
  }
  
  public Toolbar$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public Toolbar$LayoutParams(ActionBar.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public Toolbar$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    mViewType = mViewType;
  }
  
  public Toolbar$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
  }
  
  public Toolbar$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
    leftMargin = leftMargin;
    topMargin = topMargin;
    rightMargin = rightMargin;
    bottomMargin = bottomMargin;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.Toolbar.LayoutParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */