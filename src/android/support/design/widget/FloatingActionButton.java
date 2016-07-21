package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.R.dimen;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatDrawableManager;
import android.support.v7.widget.AppCompatImageHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class FloatingActionButton
  extends VisibilityAwareImageButton
{
  private static final String LOG_TAG = "FloatingActionButton";
  private static final int SIZE_MINI = 1;
  private static final int SIZE_NORMAL = 0;
  private ColorStateList mBackgroundTint;
  private PorterDuff.Mode mBackgroundTintMode;
  private int mBorderWidth;
  private boolean mCompatPadding;
  private AppCompatImageHelper mImageHelper;
  private int mImagePadding;
  private FloatingActionButtonImpl mImpl;
  private int mRippleColor;
  private final Rect mShadowPadding = new Rect();
  private int mSize;
  
  public FloatingActionButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ThemeUtils.checkAppCompatTheme(paramContext);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FloatingActionButton, paramInt, R.style.Widget_Design_FloatingActionButton);
    mBackgroundTint = paramContext.getColorStateList(R.styleable.FloatingActionButton_backgroundTint);
    mBackgroundTintMode = parseTintMode(paramContext.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
    mRippleColor = paramContext.getColor(R.styleable.FloatingActionButton_rippleColor, 0);
    mSize = paramContext.getInt(R.styleable.FloatingActionButton_fabSize, 0);
    mBorderWidth = paramContext.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
    float f1 = paramContext.getDimension(R.styleable.FloatingActionButton_elevation, 0.0F);
    float f2 = paramContext.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0F);
    mCompatPadding = paramContext.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
    paramContext.recycle();
    mImageHelper = new AppCompatImageHelper(this, AppCompatDrawableManager.get());
    mImageHelper.loadFromAttributes(paramAttributeSet, paramInt);
    paramInt = (int)getResources().getDimension(R.dimen.design_fab_image_size);
    mImagePadding = ((getSizeDimension() - paramInt) / 2);
    getImpl().setBackgroundDrawable(mBackgroundTint, mBackgroundTintMode, mRippleColor, mBorderWidth);
    getImpl().setElevation(f1);
    getImpl().setPressedTranslationZ(f2);
    getImpl().updatePadding();
  }
  
  private FloatingActionButtonImpl createImpl()
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21) {
      return new FloatingActionButtonLollipop(this, new ShadowDelegateImpl(null));
    }
    if (i >= 14) {
      return new FloatingActionButtonIcs(this, new ShadowDelegateImpl(null));
    }
    return new FloatingActionButtonEclairMr1(this, new ShadowDelegateImpl(null));
  }
  
  private FloatingActionButtonImpl getImpl()
  {
    if (mImpl == null) {
      mImpl = createImpl();
    }
    return mImpl;
  }
  
  private void hide(OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean)
  {
    getImpl().hide(wrapOnVisibilityChangedListener(paramOnVisibilityChangedListener), paramBoolean);
  }
  
  static PorterDuff.Mode parseTintMode(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    default: 
      return paramMode;
    case 3: 
      return PorterDuff.Mode.SRC_OVER;
    case 5: 
      return PorterDuff.Mode.SRC_IN;
    case 9: 
      return PorterDuff.Mode.SRC_ATOP;
    case 14: 
      return PorterDuff.Mode.MULTIPLY;
    }
    return PorterDuff.Mode.SCREEN;
  }
  
  private static int resolveAdjustedSize(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (i)
    {
    default: 
      return paramInt1;
    case 0: 
      return paramInt1;
    case -2147483648: 
      return Math.min(paramInt1, paramInt2);
    }
    return paramInt2;
  }
  
  private void show(OnVisibilityChangedListener paramOnVisibilityChangedListener, boolean paramBoolean)
  {
    getImpl().show(wrapOnVisibilityChangedListener(paramOnVisibilityChangedListener), paramBoolean);
  }
  
  private FloatingActionButtonImpl.InternalVisibilityChangedListener wrapOnVisibilityChangedListener(final OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    if (paramOnVisibilityChangedListener == null) {
      return null;
    }
    new FloatingActionButtonImpl.InternalVisibilityChangedListener()
    {
      public void onHidden()
      {
        paramOnVisibilityChangedListener.onHidden(FloatingActionButton.this);
      }
      
      public void onShown()
      {
        paramOnVisibilityChangedListener.onShown(FloatingActionButton.this);
      }
    };
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().onDrawableStateChanged(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return mBackgroundTint;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return mBackgroundTintMode;
  }
  
  public float getCompatElevation()
  {
    return getImpl().getElevation();
  }
  
  public Drawable getContentBackground()
  {
    return getImpl().getContentBackground();
  }
  
  public boolean getContentRect(Rect paramRect)
  {
    boolean bool = false;
    if (ViewCompat.isLaidOut(this))
    {
      paramRect.set(0, 0, getWidth(), getHeight());
      left += mShadowPadding.left;
      top += mShadowPadding.top;
      right -= mShadowPadding.right;
      bottom -= mShadowPadding.bottom;
      bool = true;
    }
    return bool;
  }
  
  final int getSizeDimension()
  {
    switch (mSize)
    {
    default: 
      return getResources().getDimensionPixelSize(R.dimen.design_fab_size_normal);
    }
    return getResources().getDimensionPixelSize(R.dimen.design_fab_size_mini);
  }
  
  public boolean getUseCompatPadding()
  {
    return mCompatPadding;
  }
  
  public void hide()
  {
    hide(null);
  }
  
  public void hide(OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    hide(paramOnVisibilityChangedListener, true);
  }
  
  @TargetApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().jumpDrawableToCurrentState();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    getImpl().onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getImpl().onDetachedFromWindow();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getSizeDimension();
    paramInt1 = Math.min(resolveAdjustedSize(i, paramInt1), resolveAdjustedSize(i, paramInt2));
    setMeasuredDimension(mShadowPadding.left + paramInt1 + mShadowPadding.right, mShadowPadding.top + paramInt1 + mShadowPadding.bottom);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Log.i("FloatingActionButton", "Setting a custom background is not supported.");
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (mBackgroundTint != paramColorStateList)
    {
      mBackgroundTint = paramColorStateList;
      getImpl().setBackgroundTintList(paramColorStateList);
    }
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (mBackgroundTintMode != paramMode)
    {
      mBackgroundTintMode = paramMode;
      getImpl().setBackgroundTintMode(paramMode);
    }
  }
  
  public void setCompatElevation(float paramFloat)
  {
    getImpl().setElevation(paramFloat);
  }
  
  public void setImageResource(int paramInt)
  {
    mImageHelper.setImageResource(paramInt);
  }
  
  public void setRippleColor(int paramInt)
  {
    if (mRippleColor != paramInt)
    {
      mRippleColor = paramInt;
      getImpl().setRippleColor(paramInt);
    }
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (mCompatPadding != paramBoolean)
    {
      mCompatPadding = paramBoolean;
      getImpl().onCompatShadowChanged();
    }
  }
  
  public void show()
  {
    show(null);
  }
  
  public void show(OnVisibilityChangedListener paramOnVisibilityChangedListener)
  {
    show(paramOnVisibilityChangedListener, true);
  }
  
  public static class Behavior
    extends CoordinatorLayout.Behavior<FloatingActionButton>
  {
    private static final boolean SNACKBAR_BEHAVIOR_ENABLED;
    private float mFabTranslationY;
    private ValueAnimatorCompat mFabTranslationYAnimator;
    private Rect mTmpRect;
    
    static
    {
      if (Build.VERSION.SDK_INT >= 11) {}
      for (boolean bool = true;; bool = false)
      {
        SNACKBAR_BEHAVIOR_ENABLED = bool;
        return;
      }
    }
    
    private float getFabTranslationYForSnackbar(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
    {
      float f1 = 0.0F;
      List localList = paramCoordinatorLayout.getDependencies(paramFloatingActionButton);
      int i = 0;
      int j = localList.size();
      while (i < j)
      {
        View localView = (View)localList.get(i);
        float f2 = f1;
        if ((localView instanceof Snackbar.SnackbarLayout))
        {
          f2 = f1;
          if (paramCoordinatorLayout.doViewsOverlap(paramFloatingActionButton, localView)) {
            f2 = Math.min(f1, ViewCompat.getTranslationY(localView) - localView.getHeight());
          }
        }
        i += 1;
        f1 = f2;
      }
      return f1;
    }
    
    private void offsetIfNeeded(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton)
    {
      Rect localRect = mShadowPadding;
      CoordinatorLayout.LayoutParams localLayoutParams;
      int j;
      int i;
      if ((localRect != null) && (localRect.centerX() > 0) && (localRect.centerY() > 0))
      {
        localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
        j = 0;
        i = 0;
        if (paramFloatingActionButton.getRight() < paramCoordinatorLayout.getWidth() - rightMargin) {
          break label100;
        }
        i = right;
        if (paramFloatingActionButton.getBottom() < paramCoordinatorLayout.getBottom() - bottomMargin) {
          break label122;
        }
        j = bottom;
      }
      for (;;)
      {
        paramFloatingActionButton.offsetTopAndBottom(j);
        paramFloatingActionButton.offsetLeftAndRight(i);
        return;
        label100:
        if (paramFloatingActionButton.getLeft() > leftMargin) {
          break;
        }
        i = -left;
        break;
        label122:
        if (paramFloatingActionButton.getTop() <= topMargin) {
          j = -top;
        }
      }
    }
    
    private void updateFabTranslationForSnackbar(CoordinatorLayout paramCoordinatorLayout, final FloatingActionButton paramFloatingActionButton, View paramView)
    {
      float f1 = getFabTranslationYForSnackbar(paramCoordinatorLayout, paramFloatingActionButton);
      if (mFabTranslationY == f1) {
        return;
      }
      float f2 = ViewCompat.getTranslationY(paramFloatingActionButton);
      if ((mFabTranslationYAnimator != null) && (mFabTranslationYAnimator.isRunning())) {
        mFabTranslationYAnimator.cancel();
      }
      if ((paramFloatingActionButton.isShown()) && (Math.abs(f2 - f1) > paramFloatingActionButton.getHeight() * 0.667F))
      {
        if (mFabTranslationYAnimator == null)
        {
          mFabTranslationYAnimator = ViewUtils.createAnimator();
          mFabTranslationYAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
          mFabTranslationYAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener()
          {
            public void onAnimationUpdate(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
            {
              ViewCompat.setTranslationY(paramFloatingActionButton, paramAnonymousValueAnimatorCompat.getAnimatedFloatValue());
            }
          });
        }
        mFabTranslationYAnimator.setFloatValues(f2, f1);
        mFabTranslationYAnimator.start();
      }
      for (;;)
      {
        mFabTranslationY = f1;
        return;
        ViewCompat.setTranslationY(paramFloatingActionButton, f1);
      }
    }
    
    private boolean updateFabVisibility(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      if (((CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams()).getAnchorId() != paramAppBarLayout.getId()) {
        return false;
      }
      if (paramFloatingActionButton.getUserSetVisibility() != 0) {
        return false;
      }
      if (mTmpRect == null) {
        mTmpRect = new Rect();
      }
      Rect localRect = mTmpRect;
      ViewGroupUtils.getDescendantRect(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        paramFloatingActionButton.hide(null, false);
      }
      for (;;)
      {
        return true;
        paramFloatingActionButton.show(null, false);
      }
    }
    
    public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      return (SNACKBAR_BEHAVIOR_ENABLED) && ((paramView instanceof Snackbar.SnackbarLayout));
    }
    
    public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      if ((paramView instanceof Snackbar.SnackbarLayout)) {
        updateFabTranslationForSnackbar(paramCoordinatorLayout, paramFloatingActionButton, paramView);
      }
      for (;;)
      {
        return false;
        if ((paramView instanceof AppBarLayout)) {
          updateFabVisibility(paramCoordinatorLayout, (AppBarLayout)paramView, paramFloatingActionButton);
        }
      }
    }
    
    public void onDependentViewRemoved(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      if ((paramView instanceof Snackbar.SnackbarLayout)) {
        updateFabTranslationForSnackbar(paramCoordinatorLayout, paramFloatingActionButton, paramView);
      }
    }
    
    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
    {
      List localList = paramCoordinatorLayout.getDependencies(paramFloatingActionButton);
      int i = 0;
      int j = localList.size();
      while (i < j)
      {
        View localView = (View)localList.get(i);
        if (((localView instanceof AppBarLayout)) && (updateFabVisibility(paramCoordinatorLayout, (AppBarLayout)localView, paramFloatingActionButton))) {
          break;
        }
        i += 1;
      }
      paramCoordinatorLayout.onLayoutChild(paramFloatingActionButton, paramInt);
      offsetIfNeeded(paramCoordinatorLayout, paramFloatingActionButton);
      return true;
    }
  }
  
  public static abstract class OnVisibilityChangedListener
  {
    public void onHidden(FloatingActionButton paramFloatingActionButton) {}
    
    public void onShown(FloatingActionButton paramFloatingActionButton) {}
  }
  
  private class ShadowDelegateImpl
    implements ShadowViewDelegate
  {
    private ShadowDelegateImpl() {}
    
    public float getRadius()
    {
      return getSizeDimension() / 2.0F;
    }
    
    public boolean isCompatPaddingEnabled()
    {
      return mCompatPadding;
    }
    
    public void setBackgroundDrawable(Drawable paramDrawable)
    {
      FloatingActionButton.this.setBackgroundDrawable(paramDrawable);
    }
    
    public void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      mShadowPadding.set(paramInt1, paramInt2, paramInt3, paramInt4);
      setPadding(mImagePadding + paramInt1, mImagePadding + paramInt2, mImagePadding + paramInt3, mImagePadding + paramInt4);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButton
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */