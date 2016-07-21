package com.linkedin.android.feed.shared;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import com.linkedin.android.R.styleable;
import com.linkedin.android.infra.ui.TintableImageView;
import javax.inject.Inject;

public class LikeButton
  extends TintableImageView
{
  private static final int[] LIKED_STATE_SET = { 2130772217 };
  private int filledLikRes;
  private boolean isLiked;
  private int likedColorRes;
  private int unfilledLikeRes;
  private int unlikedColorRes;
  
  @Inject
  public LikeButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LikeButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LikeButton);
    setLikeState(paramContext.getBoolean(0, false), false);
    unlikedColorRes = paramContext.getInt(1, 2131623957);
    likedColorRes = paramContext.getInt(2, 2131623966);
    unfilledLikeRes = paramContext.getResourceId(3, 2130838107);
    filledLikRes = paramContext.getResourceId(4, 2130838109);
    paramContext.recycle();
    updateLikeButtonView();
  }
  
  private void updateLikeButtonView()
  {
    if (isLiked) {
      setImageResource(filledLikRes);
    }
    for (;;)
    {
      int i = ContextCompat.getColor(getContext(), unlikedColorRes);
      int j = ContextCompat.getColor(getContext(), likedColorRes);
      setTintColorList(new ColorStateList(new int[][] { { -2130772217 }, { 2130772217 } }, new int[] { i, j }));
      return;
      setImageResource(unfilledLikeRes);
    }
  }
  
  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isLiked) {
      mergeDrawableStates(arrayOfInt, LIKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  public boolean performClick()
  {
    if (!isLiked) {}
    for (boolean bool = true;; bool = false)
    {
      setLikeState(bool, true);
      return super.performClick();
    }
  }
  
  public final void setLikeState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (isLiked != paramBoolean1)
    {
      isLiked = paramBoolean1;
      updateLikeButtonView();
      if ((paramBoolean2) && (isLiked))
      {
        Object localObject1 = ObjectAnimator.ofFloat(this, View.SCALE_X, new float[] { 1.3F });
        Object localObject2 = ObjectAnimator.ofFloat(this, View.SCALE_Y, new float[] { 1.3F });
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.setDuration(100L);
        localAnimatorSet.playTogether(new Animator[] { localObject1, localObject2 });
        localObject2 = ObjectAnimator.ofFloat(this, View.SCALE_X, new float[] { 1.0F });
        ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, View.SCALE_Y, new float[] { 1.0F });
        localObject1 = new AnimatorSet();
        ((AnimatorSet)localObject1).setDuration(100L);
        ((AnimatorSet)localObject1).playTogether(new Animator[] { localObject2, localObjectAnimator });
        localObject2 = new AnimatorSet();
        ((AnimatorSet)localObject2).playSequentially(new Animator[] { localAnimatorSet, localObject1 });
        ((AnimatorSet)localObject2).start();
      }
    }
  }
  
  public void setLikedColorRes(int paramInt)
  {
    if (likedColorRes != paramInt)
    {
      likedColorRes = paramInt;
      updateLikeButtonView();
    }
  }
  
  public void setUnlikedColorRes(int paramInt)
  {
    if (unlikedColorRes != paramInt)
    {
      unlikedColorRes = paramInt;
      updateLikeButtonView();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.LikeButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */