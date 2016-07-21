package com.linkedin.android.relationships.widgets.superslim;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.linkedin.android.R.styleable;
import com.linkedin.android.logger.Log;

public class GridSLM$LayoutParams
  extends LayoutManager.LayoutParams
{
  int mColumnWidth;
  int mNumColumns;
  
  private GridSLM$LayoutParams() {}
  
  public GridSLM$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.superslim_GridSLM);
    mNumColumns = paramContext.getInt(1, -1);
    mColumnWidth = paramContext.getDimensionPixelSize(0, -1);
    paramContext.recycle();
  }
  
  @Deprecated
  private GridSLM$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    init(paramLayoutParams);
  }
  
  @Deprecated
  private GridSLM$LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
  {
    super(paramMarginLayoutParams);
    init(paramMarginLayoutParams);
  }
  
  public static LayoutParams from(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams == null)
    {
      Log.w("SuperSLiM", "Null value passed in call to GridSLM.LayoutParams.from().");
      return new LayoutParams();
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  private void init(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams))
    {
      paramLayoutParams = (LayoutParams)paramLayoutParams;
      mNumColumns = mNumColumns;
      mColumnWidth = mColumnWidth;
      return;
    }
    mNumColumns = -1;
    mColumnWidth = -1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.widgets.superslim.GridSLM.LayoutParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */