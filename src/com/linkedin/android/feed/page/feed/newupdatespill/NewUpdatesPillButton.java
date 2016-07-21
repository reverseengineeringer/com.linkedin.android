package com.linkedin.android.feed.page.feed.newupdatespill;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.linkedin.android.infra.shared.KitKatUtils;
import com.linkedin.android.infra.ui.TintableButton;

public class NewUpdatesPillButton
  extends TintableButton
{
  private int animationAmount;
  private final Interpolator interpolator = new AccelerateDecelerateInterpolator();
  private boolean isVisible;
  private int lastPillActionSourceEvent = -1;
  private boolean needDisplay;
  private int origin;
  
  public NewUpdatesPillButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NewUpdatesPillButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NewUpdatesPillButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean hidePill(int paramInt)
  {
    if (!isVisible) {}
    while ((lastPillActionSourceEvent == 2) && (paramInt == 0)) {
      return false;
    }
    isVisible = false;
    final int i = -getAnimationAmount();
    if ((getVisibility() != 0) || (getTranslationY() == i))
    {
      setVisibility(4);
      return false;
    }
    KitKatUtils.bringToFront(this);
    setVisibility(0);
    animate().setInterpolator(interpolator).setDuration(200L).translationY(i).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        setVisibility(4);
        setTranslationY(i);
      }
    });
    lastPillActionSourceEvent = paramInt;
    return true;
  }
  
  private boolean showPill(int paramInt)
  {
    if ((paramInt == 1) && (lastPillActionSourceEvent == 4)) {}
    do
    {
      return false;
      if ((paramInt == 1) && (lastPillActionSourceEvent == 2))
      {
        lastPillActionSourceEvent = paramInt;
        return false;
      }
    } while (isVisible);
    isVisible = true;
    KitKatUtils.bringToFront(this);
    setVisibility(0);
    if (getAnimation() == null) {
      setTranslationY(-getAnimationAmount());
    }
    final int i = origin;
    animate().setInterpolator(interpolator).setDuration(200L).translationY(i).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        setTranslationY(i);
      }
    });
    lastPillActionSourceEvent = paramInt;
    return true;
  }
  
  public int getAnimationAmount()
  {
    if (animationAmount == 0) {
      animationAmount = (getHeight() + getMarginBottom() + 30);
    }
    return animationAmount;
  }
  
  public int getMarginBottom()
  {
    int i = 0;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      i = bottomMargin;
    }
    return i;
  }
  
  public int getOrigin()
  {
    return origin;
  }
  
  public void setAnimationAmount(int paramInt)
  {
    animationAmount = paramInt;
  }
  
  public void setOrigin(int paramInt)
  {
    origin = paramInt;
  }
  
  public final boolean toggleDisplayed(boolean paramBoolean, int paramInt)
  {
    needDisplay = paramBoolean;
    if (paramBoolean) {
      return showPill(paramInt);
    }
    return hidePill(paramInt);
  }
  
  private abstract class RecyclerViewScrollDetector
    extends RecyclerView.OnScrollListener
  {
    public int scrollThreshold;
    
    private RecyclerViewScrollDetector() {}
    
    abstract void onScrollDown();
    
    abstract void onScrollUp();
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      if (Math.abs(paramInt2) > scrollThreshold) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0)
        {
          if (paramInt2 <= 0) {
            break;
          }
          onScrollDown();
        }
        return;
      }
      onScrollUp();
    }
  }
  
  private final class RecyclerViewScrollDetectorImpl
    extends NewUpdatesPillButton.RecyclerViewScrollDetector
  {
    private RecyclerView.OnScrollListener onScrollListener;
    
    private RecyclerViewScrollDetectorImpl()
    {
      super((byte)0);
    }
    
    public final void onScrollDown()
    {
      NewUpdatesPillButton.access$200$13e22efd(NewUpdatesPillButton.this);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      if (onScrollListener != null) {
        onScrollListener.onScrollStateChanged(paramRecyclerView, paramInt);
      }
      super.onScrollStateChanged(paramRecyclerView, paramInt);
    }
    
    public final void onScrollUp()
    {
      if (needDisplay) {
        NewUpdatesPillButton.access$400$13e22efd(NewUpdatesPillButton.this);
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      if (onScrollListener != null) {
        onScrollListener.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      }
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesPillButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */