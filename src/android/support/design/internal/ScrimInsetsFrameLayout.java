package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout
  extends FrameLayout
{
  private Drawable mInsetForeground;
  private Rect mInsets;
  private Rect mTempRect = new Rect();
  
  public ScrimInsetsFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ScrimInsetsFrameLayout, paramInt, R.style.Widget_Design_ScrimInsetsFrameLayout);
    mInsetForeground = paramContext.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
    paramContext.recycle();
    setWillNotDraw(true);
    ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener()
    {
      public final WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        if (mInsets == null) {
          ScrimInsetsFrameLayout.access$002(ScrimInsetsFrameLayout.this, new Rect());
        }
        mInsets.set(paramAnonymousWindowInsetsCompat.getSystemWindowInsetLeft(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetTop(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetRight(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom());
        onInsetsChanged(mInsets);
        paramAnonymousView = ScrimInsetsFrameLayout.this;
        if ((mInsets.isEmpty()) || (mInsetForeground == null)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setWillNotDraw(bool);
          ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
          return paramAnonymousWindowInsetsCompat.consumeSystemWindowInsets();
        }
      }
    });
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((mInsets != null) && (mInsetForeground != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      mTempRect.set(0, 0, i, mInsets.top);
      mInsetForeground.setBounds(mTempRect);
      mInsetForeground.draw(paramCanvas);
      mTempRect.set(0, j - mInsets.bottom, i, j);
      mInsetForeground.setBounds(mTempRect);
      mInsetForeground.draw(paramCanvas);
      mTempRect.set(0, mInsets.top, mInsets.left, j - mInsets.bottom);
      mInsetForeground.setBounds(mTempRect);
      mInsetForeground.draw(paramCanvas);
      mTempRect.set(i - mInsets.right, mInsets.top, i, j - mInsets.bottom);
      mInsetForeground.setBounds(mTempRect);
      mInsetForeground.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (mInsetForeground != null) {
      mInsetForeground.setCallback(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (mInsetForeground != null) {
      mInsetForeground.setCallback(null);
    }
  }
  
  public void onInsetsChanged(Rect paramRect) {}
}

/* Location:
 * Qualified Name:     android.support.design.internal.ScrimInsetsFrameLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */