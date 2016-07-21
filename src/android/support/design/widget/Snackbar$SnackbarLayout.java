package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.R.dimen;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.design.R.styleable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Snackbar$SnackbarLayout
  extends LinearLayout
{
  private Button mActionView;
  private int mMaxInlineActionWidth;
  private int mMaxWidth;
  private TextView mMessageView;
  private OnAttachStateChangeListener mOnAttachStateChangeListener;
  private OnLayoutChangeListener mOnLayoutChangeListener;
  
  public Snackbar$SnackbarLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Snackbar$SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
    mMaxWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
    mMaxInlineActionWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
    if (paramAttributeSet.hasValue(R.styleable.SnackbarLayout_elevation)) {
      ViewCompat.setElevation(this, paramAttributeSet.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
    }
    paramAttributeSet.recycle();
    setClickable(true);
    LayoutInflater.from(paramContext).inflate(R.layout.design_layout_snackbar_include, this);
    ViewCompat.setAccessibilityLiveRegion$5359dc9a(this);
    ViewCompat.setImportantForAccessibility(this, 1);
  }
  
  private static void updateTopBottomPadding(View paramView, int paramInt1, int paramInt2)
  {
    if (ViewCompat.isPaddingRelative(paramView))
    {
      ViewCompat.setPaddingRelative(paramView, ViewCompat.getPaddingStart(paramView), paramInt1, ViewCompat.getPaddingEnd(paramView), paramInt2);
      return;
    }
    paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
  }
  
  private boolean updateViewsWithinLayout(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if (paramInt1 != getOrientation())
    {
      setOrientation(paramInt1);
      bool = true;
    }
    if ((mMessageView.getPaddingTop() != paramInt2) || (mMessageView.getPaddingBottom() != paramInt3))
    {
      updateTopBottomPadding(mMessageView, paramInt2, paramInt3);
      bool = true;
    }
    return bool;
  }
  
  void animateChildrenIn(int paramInt1, int paramInt2)
  {
    ViewCompat.setAlpha(mMessageView, 0.0F);
    ViewCompat.animate(mMessageView).alpha(1.0F).setDuration(paramInt2).setStartDelay(paramInt1).start();
    if (mActionView.getVisibility() == 0)
    {
      ViewCompat.setAlpha(mActionView, 0.0F);
      ViewCompat.animate(mActionView).alpha(1.0F).setDuration(paramInt2).setStartDelay(paramInt1).start();
    }
  }
  
  void animateChildrenOut(int paramInt1, int paramInt2)
  {
    ViewCompat.setAlpha(mMessageView, 1.0F);
    ViewCompat.animate(mMessageView).alpha(0.0F).setDuration(paramInt2).setStartDelay(paramInt1).start();
    if (mActionView.getVisibility() == 0)
    {
      ViewCompat.setAlpha(mActionView, 1.0F);
      ViewCompat.animate(mActionView).alpha(0.0F).setDuration(paramInt2).setStartDelay(paramInt1).start();
    }
  }
  
  Button getActionView()
  {
    return mActionView;
  }
  
  TextView getMessageView()
  {
    return mMessageView;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (mOnAttachStateChangeListener != null) {
      mOnAttachStateChangeListener.onViewAttachedToWindow(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (mOnAttachStateChangeListener != null) {
      mOnAttachStateChangeListener.onViewDetachedFromWindow(this);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    mMessageView = ((TextView)findViewById(R.id.snackbar_text));
    mActionView = ((Button)findViewById(R.id.snackbar_action));
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (mOnLayoutChangeListener != null) {
      mOnLayoutChangeListener.onLayoutChange(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = paramInt1;
    if (mMaxWidth > 0)
    {
      i = paramInt1;
      if (getMeasuredWidth() > mMaxWidth)
      {
        i = View.MeasureSpec.makeMeasureSpec(mMaxWidth, 1073741824);
        super.onMeasure(i, paramInt2);
      }
    }
    int j = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
    int k = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
    if (mMessageView.getLayout().getLineCount() > 1) {}
    int m;
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      m = 0;
      if ((paramInt1 == 0) || (mMaxInlineActionWidth <= 0) || (mActionView.getMeasuredWidth() <= mMaxInlineActionWidth)) {
        break;
      }
      paramInt1 = m;
      if (updateViewsWithinLayout(1, j, j - k)) {
        paramInt1 = 1;
      }
      if (paramInt1 != 0) {
        super.onMeasure(i, paramInt2);
      }
      return;
    }
    if (paramInt1 != 0) {}
    for (;;)
    {
      paramInt1 = m;
      if (!updateViewsWithinLayout(0, j, j)) {
        break;
      }
      paramInt1 = 1;
      break;
      j = k;
    }
  }
  
  void setOnAttachStateChangeListener(OnAttachStateChangeListener paramOnAttachStateChangeListener)
  {
    mOnAttachStateChangeListener = paramOnAttachStateChangeListener;
  }
  
  void setOnLayoutChangeListener(OnLayoutChangeListener paramOnLayoutChangeListener)
  {
    mOnLayoutChangeListener = paramOnLayoutChangeListener;
  }
  
  static abstract interface OnAttachStateChangeListener
  {
    public abstract void onViewAttachedToWindow(View paramView);
    
    public abstract void onViewDetachedFromWindow(View paramView);
  }
  
  static abstract interface OnLayoutChangeListener
  {
    public abstract void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.Snackbar.SnackbarLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */