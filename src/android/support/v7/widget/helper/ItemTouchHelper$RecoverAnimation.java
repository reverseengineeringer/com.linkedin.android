package android.support.v7.widget.helper;

import android.support.v4.animation.AnimatorCompatHelper;
import android.support.v4.animation.AnimatorListenerCompat;
import android.support.v4.animation.AnimatorUpdateListenerCompat;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v7.widget.RecyclerView.ViewHolder;

public class ItemTouchHelper$RecoverAnimation
  implements AnimatorListenerCompat
{
  final int mActionState;
  final int mAnimationType;
  boolean mEnded = false;
  float mFraction;
  public boolean mIsPendingCleanup;
  boolean mOverridden = false;
  final float mStartDx;
  final float mStartDy;
  final float mTargetX;
  final float mTargetY;
  final ValueAnimatorCompat mValueAnimator;
  public final RecyclerView.ViewHolder mViewHolder;
  float mX;
  float mY;
  
  public ItemTouchHelper$RecoverAnimation(final ItemTouchHelper paramItemTouchHelper, RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    mActionState = paramInt2;
    mAnimationType = paramInt1;
    mViewHolder = paramViewHolder;
    mStartDx = paramFloat1;
    mStartDy = paramFloat2;
    mTargetX = paramFloat3;
    mTargetY = paramFloat4;
    mValueAnimator = AnimatorCompatHelper.emptyValueAnimator();
    mValueAnimator.addUpdateListener(new AnimatorUpdateListenerCompat()
    {
      public final void onAnimationUpdate(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
      {
        mFraction = paramAnonymousValueAnimatorCompat.getAnimatedFraction();
      }
    });
    mValueAnimator.setTarget(itemView);
    mValueAnimator.addListener(this);
    mFraction = 0.0F;
  }
  
  public final void onAnimationCancel$2feb5e66()
  {
    mFraction = 1.0F;
  }
  
  public void onAnimationEnd(ValueAnimatorCompat paramValueAnimatorCompat)
  {
    if (!mEnded) {
      mViewHolder.setIsRecyclable(true);
    }
    mEnded = true;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.helper.ItemTouchHelper.RecoverAnimation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */