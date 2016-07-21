package com.linkedin.android.growth.newtovoyager.banner;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

public class NewToVoyagerPropCardView
  extends CardView
{
  Listener listener;
  
  public NewToVoyagerPropCardView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NewToVoyagerPropCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NewToVoyagerPropCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (listener != null) {
      listener.onCardShow();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (listener != null) {
      listener.onCardHide();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (listener != null))
    {
      listener.onCardHide();
      listener.onCardShow();
    }
  }
  
  public static abstract interface Listener
  {
    public abstract void onCardHide();
    
    public abstract void onCardShow();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerPropCardView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */