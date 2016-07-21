package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v4.view.ViewCompat;
import android.view.ViewPropertyAnimator;

class FloatingActionButtonIcs
  extends FloatingActionButtonEclairMr1
{
  private boolean mIsHiding;
  
  FloatingActionButtonIcs(VisibilityAwareImageButton paramVisibilityAwareImageButton, ShadowViewDelegate paramShadowViewDelegate)
  {
    super(paramVisibilityAwareImageButton, paramShadowViewDelegate);
  }
  
  private void updateFromViewRotation(float paramFloat)
  {
    if (mShadowDrawable != null) {
      mShadowDrawable.setRotation(-paramFloat);
    }
    if (mBorderDrawable != null) {
      mBorderDrawable.setRotation(-paramFloat);
    }
  }
  
  void hide(final FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, final boolean paramBoolean)
  {
    if ((mIsHiding) || (mView.getVisibility() != 0)) {
      if (paramInternalVisibilityChangedListener != null) {
        paramInternalVisibilityChangedListener.onHidden();
      }
    }
    do
    {
      return;
      if ((ViewCompat.isLaidOut(mView)) && (!mView.isInEditMode())) {
        break;
      }
      mView.internalSetVisibility(8, paramBoolean);
    } while (paramInternalVisibilityChangedListener == null);
    paramInternalVisibilityChangedListener.onHidden();
    return;
    mView.animate().cancel();
    mView.animate().scaleX(0.0F).scaleY(0.0F).alpha(0.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter()
    {
      private boolean mCancelled;
      
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        FloatingActionButtonIcs.access$002(FloatingActionButtonIcs.this, false);
        mCancelled = true;
      }
      
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        FloatingActionButtonIcs.access$002(FloatingActionButtonIcs.this, false);
        if (!mCancelled)
        {
          mView.internalSetVisibility(8, paramBoolean);
          if (paramInternalVisibilityChangedListener != null) {
            paramInternalVisibilityChangedListener.onHidden();
          }
        }
      }
      
      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        FloatingActionButtonIcs.access$002(FloatingActionButtonIcs.this, true);
        mCancelled = false;
        mView.internalSetVisibility(0, paramBoolean);
      }
    });
  }
  
  void onPreDraw()
  {
    updateFromViewRotation(mView.getRotation());
  }
  
  boolean requirePreDrawListener()
  {
    return true;
  }
  
  void show(final FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener, final boolean paramBoolean)
  {
    if ((mIsHiding) || (mView.getVisibility() != 0))
    {
      if ((!ViewCompat.isLaidOut(mView)) || (mView.isInEditMode())) {
        break label127;
      }
      mView.animate().cancel();
      if (mView.getVisibility() != 0)
      {
        mView.setAlpha(0.0F);
        mView.setScaleY(0.0F);
        mView.setScaleX(0.0F);
      }
      mView.animate().scaleX(1.0F).scaleY(1.0F).alpha(1.0F).setDuration(200L).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (paramInternalVisibilityChangedListener != null) {
            paramInternalVisibilityChangedListener.onShown();
          }
        }
        
        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
          mView.internalSetVisibility(0, paramBoolean);
        }
      });
    }
    label127:
    do
    {
      return;
      mView.internalSetVisibility(0, paramBoolean);
      mView.setAlpha(1.0F);
      mView.setScaleY(1.0F);
      mView.setScaleX(1.0F);
    } while (paramInternalVisibilityChangedListener == null);
    paramInternalVisibilityChangedListener.onShown();
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButtonIcs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */