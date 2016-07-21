package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;

class ViewCompat$HCViewCompatImpl
  extends ViewCompat.GBViewCompatImpl
{
  public final int combineMeasuredStates(int paramInt1, int paramInt2)
  {
    return View.combineMeasuredStates(paramInt1, paramInt2);
  }
  
  public final float getAlpha(View paramView)
  {
    return paramView.getAlpha();
  }
  
  final long getFrameTime()
  {
    return ValueAnimator.getFrameDelay();
  }
  
  public final int getLayerType(View paramView)
  {
    return paramView.getLayerType();
  }
  
  public final int getMeasuredState(View paramView)
  {
    return paramView.getMeasuredState();
  }
  
  public final int getMeasuredWidthAndState(View paramView)
  {
    return paramView.getMeasuredWidthAndState();
  }
  
  public final float getScaleX(View paramView)
  {
    return paramView.getScaleX();
  }
  
  public final float getTranslationX(View paramView)
  {
    return paramView.getTranslationX();
  }
  
  public final float getTranslationY(View paramView)
  {
    return paramView.getTranslationY();
  }
  
  public final void jumpDrawablesToCurrentState(View paramView)
  {
    paramView.jumpDrawablesToCurrentState();
  }
  
  public void offsetLeftAndRight(View paramView, int paramInt)
  {
    ViewCompatHC.offsetLeftAndRight(paramView, paramInt);
  }
  
  public void offsetTopAndBottom(View paramView, int paramInt)
  {
    ViewCompatHC.offsetTopAndBottom(paramView, paramInt);
  }
  
  public final int resolveSizeAndState(int paramInt1, int paramInt2, int paramInt3)
  {
    return View.resolveSizeAndState(paramInt1, paramInt2, paramInt3);
  }
  
  public final void setActivated(View paramView, boolean paramBoolean)
  {
    paramView.setActivated(paramBoolean);
  }
  
  public final void setAlpha(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }
  
  public final void setLayerType(View paramView, int paramInt, Paint paramPaint)
  {
    paramView.setLayerType(paramInt, paramPaint);
  }
  
  public final void setSaveFromParentEnabled$53599cc9(View paramView)
  {
    paramView.setSaveFromParentEnabled(false);
  }
  
  public final void setScaleX(View paramView, float paramFloat)
  {
    paramView.setScaleX(paramFloat);
  }
  
  public final void setScaleY(View paramView, float paramFloat)
  {
    paramView.setScaleY(paramFloat);
  }
  
  public final void setTranslationX(View paramView, float paramFloat)
  {
    paramView.setTranslationX(paramFloat);
  }
  
  public final void setTranslationY(View paramView, float paramFloat)
  {
    paramView.setTranslationY(paramFloat);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ViewCompat.HCViewCompatImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */