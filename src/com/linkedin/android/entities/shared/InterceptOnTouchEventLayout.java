package com.linkedin.android.entities.shared;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class InterceptOnTouchEventLayout
  extends LinearLayout
{
  public InterceptOnTouchEventLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public InterceptOnTouchEventLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public InterceptOnTouchEventLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.InterceptOnTouchEventLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */