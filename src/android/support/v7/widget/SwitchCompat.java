package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.text.AllCapsTransformationMethod;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.CompoundButton;
import java.util.List;

public class SwitchCompat
  extends CompoundButton
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private final AppCompatDrawableManager mDrawableManager;
  private int mMinFlingVelocity;
  private Layout mOffLayout;
  private Layout mOnLayout;
  private ThumbAnimation mPositionAnimator;
  private boolean mShowText;
  private boolean mSplitTrack;
  private int mSwitchBottom;
  private int mSwitchHeight;
  private int mSwitchLeft;
  private int mSwitchMinWidth;
  private int mSwitchPadding;
  private int mSwitchRight;
  private int mSwitchTop;
  private TransformationMethod mSwitchTransformationMethod;
  private int mSwitchWidth;
  private final Rect mTempRect = new Rect();
  private ColorStateList mTextColors;
  private CharSequence mTextOff;
  private CharSequence mTextOn;
  private TextPaint mTextPaint = new TextPaint(1);
  private Drawable mThumbDrawable;
  private float mThumbPosition;
  private int mThumbTextPadding;
  private int mThumbWidth;
  private int mTouchMode;
  private int mTouchSlop;
  private float mTouchX;
  private float mTouchY;
  private Drawable mTrackDrawable;
  private VelocityTracker mVelocityTracker = VelocityTracker.obtain();
  
  public SwitchCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.switchStyle);
  }
  
  public SwitchCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources();
    mTextPaint.density = getDisplayMetricsdensity;
    localObject = TintTypedArray.obtainStyledAttributes$89ace2b(paramContext, paramAttributeSet, R.styleable.SwitchCompat, paramInt);
    mThumbDrawable = ((TintTypedArray)localObject).getDrawable(R.styleable.SwitchCompat_android_thumb);
    if (mThumbDrawable != null) {
      mThumbDrawable.setCallback(this);
    }
    mTrackDrawable = ((TintTypedArray)localObject).getDrawable(R.styleable.SwitchCompat_track);
    if (mTrackDrawable != null) {
      mTrackDrawable.setCallback(this);
    }
    mTextOn = ((TintTypedArray)localObject).getText(R.styleable.SwitchCompat_android_textOn);
    mTextOff = ((TintTypedArray)localObject).getText(R.styleable.SwitchCompat_android_textOff);
    mShowText = ((TintTypedArray)localObject).getBoolean(R.styleable.SwitchCompat_showText, true);
    mThumbTextPadding = ((TintTypedArray)localObject).getDimensionPixelSize(R.styleable.SwitchCompat_thumbTextPadding, 0);
    mSwitchMinWidth = ((TintTypedArray)localObject).getDimensionPixelSize(R.styleable.SwitchCompat_switchMinWidth, 0);
    mSwitchPadding = ((TintTypedArray)localObject).getDimensionPixelSize(R.styleable.SwitchCompat_switchPadding, 0);
    mSplitTrack = ((TintTypedArray)localObject).getBoolean(R.styleable.SwitchCompat_splitTrack, false);
    paramInt = ((TintTypedArray)localObject).getResourceId(R.styleable.SwitchCompat_switchTextAppearance, 0);
    TypedArray localTypedArray;
    int i;
    label344:
    label359:
    label373:
    boolean bool;
    label394:
    float f;
    if (paramInt != 0)
    {
      localTypedArray = paramContext.obtainStyledAttributes(paramInt, R.styleable.TextAppearance);
      paramAttributeSet = localTypedArray.getColorStateList(R.styleable.TextAppearance_android_textColor);
      if (paramAttributeSet == null) {
        break label503;
      }
      mTextColors = paramAttributeSet;
      paramInt = localTypedArray.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
      if ((paramInt != 0) && (paramInt != mTextPaint.getTextSize()))
      {
        mTextPaint.setTextSize(paramInt);
        requestLayout();
      }
      paramInt = localTypedArray.getInt(R.styleable.TextAppearance_android_typeface, -1);
      i = localTypedArray.getInt(R.styleable.TextAppearance_android_textStyle, -1);
      paramAttributeSet = null;
      switch (paramInt)
      {
      default: 
        if (i > 0) {
          if (paramAttributeSet == null)
          {
            paramAttributeSet = Typeface.defaultFromStyle(i);
            setSwitchTypeface(paramAttributeSet);
            if (paramAttributeSet == null) {
              break label545;
            }
            paramInt = paramAttributeSet.getStyle();
            paramInt = i & (paramInt ^ 0xFFFFFFFF);
            paramAttributeSet = mTextPaint;
            if ((paramInt & 0x1) == 0) {
              break label550;
            }
            bool = true;
            paramAttributeSet.setFakeBoldText(bool);
            paramAttributeSet = mTextPaint;
            if ((paramInt & 0x2) == 0) {
              break label556;
            }
            f = -0.25F;
            label416:
            paramAttributeSet.setTextSkewX(f);
            label422:
            if (!localTypedArray.getBoolean(R.styleable.TextAppearance_textAllCaps, false)) {
              break label586;
            }
          }
        }
        break;
      }
    }
    label503:
    label545:
    label550:
    label556:
    label586:
    for (mSwitchTransformationMethod = new AllCapsTransformationMethod(getContext());; mSwitchTransformationMethod = null)
    {
      localTypedArray.recycle();
      mDrawableManager = AppCompatDrawableManager.get();
      mWrapped.recycle();
      paramContext = ViewConfiguration.get(paramContext);
      mTouchSlop = paramContext.getScaledTouchSlop();
      mMinFlingVelocity = paramContext.getScaledMinimumFlingVelocity();
      refreshDrawableState();
      setChecked(isChecked());
      return;
      mTextColors = getTextColors();
      break;
      paramAttributeSet = Typeface.SANS_SERIF;
      break label344;
      paramAttributeSet = Typeface.SERIF;
      break label344;
      paramAttributeSet = Typeface.MONOSPACE;
      break label344;
      paramAttributeSet = Typeface.create(paramAttributeSet, i);
      break label359;
      paramInt = 0;
      break label373;
      bool = false;
      break label394;
      f = 0.0F;
      break label416;
      mTextPaint.setFakeBoldText(false);
      mTextPaint.setTextSkewX(0.0F);
      setSwitchTypeface(paramAttributeSet);
      break label422;
    }
  }
  
  private void cancelPositionAnimator()
  {
    if (mPositionAnimator != null)
    {
      clearAnimation();
      mPositionAnimator = null;
    }
  }
  
  private boolean getTargetCheckedState()
  {
    return mThumbPosition > 0.5F;
  }
  
  private int getThumbOffset()
  {
    if (ViewUtils.isLayoutRtl(this)) {}
    for (float f = 1.0F - mThumbPosition;; f = mThumbPosition) {
      return (int)(getThumbScrollRange() * f + 0.5F);
    }
  }
  
  private int getThumbScrollRange()
  {
    if (mTrackDrawable != null)
    {
      Rect localRect2 = mTempRect;
      mTrackDrawable.getPadding(localRect2);
      if (mThumbDrawable != null) {}
      for (Rect localRect1 = DrawableUtils.getOpticalBounds(mThumbDrawable);; localRect1 = DrawableUtils.INSETS_NONE) {
        return mSwitchWidth - mThumbWidth - left - right - left - right;
      }
    }
    return 0;
  }
  
  private Layout makeLayout(CharSequence paramCharSequence)
  {
    TextPaint localTextPaint;
    if (mSwitchTransformationMethod != null)
    {
      paramCharSequence = mSwitchTransformationMethod.getTransformation(paramCharSequence, this);
      localTextPaint = mTextPaint;
      if (paramCharSequence == null) {
        break label62;
      }
    }
    label62:
    for (int i = (int)Math.ceil(Layout.getDesiredWidth(paramCharSequence, mTextPaint));; i = 0)
    {
      return new StaticLayout(paramCharSequence, localTextPaint, i, Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, true);
      break;
    }
  }
  
  private void setThumbPosition(float paramFloat)
  {
    mThumbPosition = paramFloat;
    invalidate();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = mTempRect;
    int i8 = mSwitchLeft;
    int i4 = mSwitchTop;
    int i6 = mSwitchRight;
    int i5 = mSwitchBottom;
    int j = i8 + getThumbOffset();
    if (mThumbDrawable != null) {}
    for (Object localObject = DrawableUtils.getOpticalBounds(mThumbDrawable);; localObject = DrawableUtils.INSETS_NONE)
    {
      int i = j;
      if (mTrackDrawable != null)
      {
        mTrackDrawable.getPadding(localRect);
        int i7 = j + left;
        i = i8;
        int k = i4;
        j = i6;
        int m = i5;
        int i3 = m;
        int n = i;
        int i1 = j;
        int i2 = k;
        if (localObject != null)
        {
          if (left > left) {
            i = i8 + (left - left);
          }
          if (top > top) {
            k = i4 + (top - top);
          }
          if (right > right) {
            j = i6 - (right - right);
          }
          i3 = m;
          n = i;
          i1 = j;
          i2 = k;
          if (bottom > bottom)
          {
            i3 = i5 - (bottom - bottom);
            i2 = k;
            i1 = j;
            n = i;
          }
        }
        mTrackDrawable.setBounds(n, i2, i1, i3);
        i = i7;
      }
      if (mThumbDrawable != null)
      {
        mThumbDrawable.getPadding(localRect);
        j = i - left;
        i = mThumbWidth + i + right;
        mThumbDrawable.setBounds(j, i4, i, i5);
        localObject = getBackground();
        if (localObject != null) {
          DrawableCompat.setHotspotBounds((Drawable)localObject, j, i4, i, i5);
        }
      }
      super.draw(paramCanvas);
      return;
    }
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      super.drawableHotspotChanged(paramFloat1, paramFloat2);
    }
    if (mThumbDrawable != null) {
      DrawableCompat.setHotspot(mThumbDrawable, paramFloat1, paramFloat2);
    }
    if (mTrackDrawable != null) {
      DrawableCompat.setHotspot(mTrackDrawable, paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    if (mThumbDrawable != null) {
      mThumbDrawable.setState(arrayOfInt);
    }
    if (mTrackDrawable != null) {
      mTrackDrawable.setState(arrayOfInt);
    }
    invalidate();
  }
  
  public int getCompoundPaddingLeft()
  {
    int i;
    if (!ViewUtils.isLayoutRtl(this)) {
      i = super.getCompoundPaddingLeft();
    }
    int j;
    do
    {
      return i;
      j = super.getCompoundPaddingLeft() + mSwitchWidth;
      i = j;
    } while (TextUtils.isEmpty(getText()));
    return j + mSwitchPadding;
  }
  
  public int getCompoundPaddingRight()
  {
    int i;
    if (ViewUtils.isLayoutRtl(this)) {
      i = super.getCompoundPaddingRight();
    }
    int j;
    do
    {
      return i;
      j = super.getCompoundPaddingRight() + mSwitchWidth;
      i = j;
    } while (TextUtils.isEmpty(getText()));
    return j + mSwitchPadding;
  }
  
  public boolean getShowText()
  {
    return mShowText;
  }
  
  public boolean getSplitTrack()
  {
    return mSplitTrack;
  }
  
  public int getSwitchMinWidth()
  {
    return mSwitchMinWidth;
  }
  
  public int getSwitchPadding()
  {
    return mSwitchPadding;
  }
  
  public CharSequence getTextOff()
  {
    return mTextOff;
  }
  
  public CharSequence getTextOn()
  {
    return mTextOn;
  }
  
  public Drawable getThumbDrawable()
  {
    return mThumbDrawable;
  }
  
  public int getThumbTextPadding()
  {
    return mThumbTextPadding;
  }
  
  public Drawable getTrackDrawable()
  {
    return mTrackDrawable;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      super.jumpDrawablesToCurrentState();
      if (mThumbDrawable != null) {
        mThumbDrawable.jumpToCurrentState();
      }
      if (mTrackDrawable != null) {
        mTrackDrawable.jumpToCurrentState();
      }
      cancelPositionAnimator();
      if (!isChecked()) {
        break label59;
      }
    }
    label59:
    for (float f = 1.0F;; f = 0.0F)
    {
      setThumbPosition(f);
      return;
    }
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1 = mTempRect;
    Object localObject3 = mTrackDrawable;
    int k;
    int m;
    int n;
    int i1;
    Object localObject2;
    label151:
    int j;
    if (localObject3 != null)
    {
      ((Drawable)localObject3).getPadding((Rect)localObject1);
      k = mSwitchTop;
      m = mSwitchBottom;
      n = top;
      i1 = bottom;
      localObject2 = mThumbDrawable;
      if (localObject3 != null)
      {
        if ((!mSplitTrack) || (localObject2 == null)) {
          break label320;
        }
        Rect localRect = DrawableUtils.getOpticalBounds((Drawable)localObject2);
        ((Drawable)localObject2).copyBounds((Rect)localObject1);
        left += left;
        right -= right;
        i = paramCanvas.save();
        paramCanvas.clipRect((Rect)localObject1, Region.Op.DIFFERENCE);
        ((Drawable)localObject3).draw(paramCanvas);
        paramCanvas.restoreToCount(i);
      }
      j = paramCanvas.save();
      if (localObject2 != null) {
        ((Drawable)localObject2).draw(paramCanvas);
      }
      if (!getTargetCheckedState()) {
        break label329;
      }
      localObject1 = mOnLayout;
      label180:
      if (localObject1 != null)
      {
        localObject3 = getDrawableState();
        if (mTextColors != null) {
          mTextPaint.setColor(mTextColors.getColorForState((int[])localObject3, 0));
        }
        mTextPaint.drawableState = ((int[])localObject3);
        if (localObject2 == null) {
          break label338;
        }
        localObject2 = ((Drawable)localObject2).getBounds();
      }
    }
    label320:
    label329:
    label338:
    for (int i = left + right;; i = getWidth())
    {
      i /= 2;
      int i2 = ((Layout)localObject1).getWidth() / 2;
      k = (k + n + (m - i1)) / 2;
      m = ((Layout)localObject1).getHeight() / 2;
      paramCanvas.translate(i - i2, k - m);
      ((Layout)localObject1).draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      return;
      ((Rect)localObject1).setEmpty();
      break;
      ((Drawable)localObject3).draw(paramCanvas);
      break label151;
      localObject1 = mOffLayout;
      break label180;
    }
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName("android.widget.Switch");
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName("android.widget.Switch");
      if (!isChecked()) {
        break label57;
      }
    }
    CharSequence localCharSequence2;
    label57:
    for (CharSequence localCharSequence1 = mTextOn;; localCharSequence1 = mTextOff)
    {
      if (!TextUtils.isEmpty(localCharSequence1))
      {
        localCharSequence2 = paramAccessibilityNodeInfo.getText();
        if (!TextUtils.isEmpty(localCharSequence2)) {
          break;
        }
        paramAccessibilityNodeInfo.setText(localCharSequence1);
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localCharSequence2).append(' ').append(localCharSequence1);
    paramAccessibilityNodeInfo.setText(localStringBuilder);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = 0;
    paramInt2 = 0;
    Rect localRect1;
    if (mThumbDrawable != null)
    {
      localRect1 = mTempRect;
      if (mTrackDrawable != null)
      {
        mTrackDrawable.getPadding(localRect1);
        Rect localRect2 = DrawableUtils.getOpticalBounds(mThumbDrawable);
        paramInt1 = Math.max(0, left - left);
        paramInt2 = Math.max(0, right - right);
      }
    }
    else
    {
      if (!ViewUtils.isLayoutRtl(this)) {
        break label191;
      }
      paramInt3 = getPaddingLeft() + paramInt1;
      paramInt4 = mSwitchWidth + paramInt3 - paramInt1 - paramInt2;
      label114:
      switch (getGravity() & 0x70)
      {
      default: 
        paramInt2 = getPaddingTop();
        paramInt1 = paramInt2 + mSwitchHeight;
      }
    }
    for (;;)
    {
      mSwitchLeft = paramInt3;
      mSwitchTop = paramInt2;
      mSwitchBottom = paramInt1;
      mSwitchRight = paramInt4;
      return;
      localRect1.setEmpty();
      break;
      label191:
      paramInt4 = getWidth() - getPaddingRight() - paramInt2;
      paramInt3 = paramInt4 - mSwitchWidth + paramInt1 + paramInt2;
      break label114;
      paramInt2 = (getPaddingTop() + getHeight() - getPaddingBottom()) / 2 - mSwitchHeight / 2;
      paramInt1 = paramInt2 + mSwitchHeight;
      continue;
      paramInt1 = getHeight() - getPaddingBottom();
      paramInt2 = paramInt1 - mSwitchHeight;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (mShowText)
    {
      if (mOnLayout == null) {
        mOnLayout = makeLayout(mTextOn);
      }
      if (mOffLayout == null) {
        mOffLayout = makeLayout(mTextOff);
      }
    }
    Rect localRect = mTempRect;
    int i;
    int k;
    if (mThumbDrawable != null)
    {
      mThumbDrawable.getPadding(localRect);
      j = mThumbDrawable.getIntrinsicWidth() - left - right;
      i = mThumbDrawable.getIntrinsicHeight();
      if (!mShowText) {
        break label300;
      }
      k = Math.max(mOnLayout.getWidth(), mOffLayout.getWidth()) + mThumbTextPadding * 2;
      label130:
      mThumbWidth = Math.max(k, j);
      if (mTrackDrawable == null) {
        break label306;
      }
      mTrackDrawable.getPadding(localRect);
    }
    for (int j = mTrackDrawable.getIntrinsicHeight();; j = 0)
    {
      int i1 = left;
      int n = right;
      int m = i1;
      k = n;
      if (mThumbDrawable != null)
      {
        localRect = DrawableUtils.getOpticalBounds(mThumbDrawable);
        m = Math.max(i1, left);
        k = Math.max(n, right);
      }
      k = Math.max(mSwitchMinWidth, mThumbWidth * 2 + m + k);
      i = Math.max(j, i);
      mSwitchWidth = k;
      mSwitchHeight = i;
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredHeight() < i) {
        setMeasuredDimension(ViewCompat.getMeasuredWidthAndState(this), i);
      }
      return;
      j = 0;
      i = 0;
      break;
      label300:
      k = 0;
      break label130;
      label306:
      localRect.setEmpty();
    }
  }
  
  @TargetApi(14)
  public void onPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onPopulateAccessibilityEvent(paramAccessibilityEvent);
    if (isChecked()) {}
    for (CharSequence localCharSequence = mTextOn;; localCharSequence = mTextOff)
    {
      if (localCharSequence != null) {
        paramAccessibilityEvent.getText().add(localCharSequence);
      }
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f3 = 0.0F;
    int j = 0;
    boolean bool1 = true;
    mVelocityTracker.addMovement(paramMotionEvent);
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    }
    for (;;)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      float f1;
      int i;
      label475:
      label487:
      for (;;)
      {
        return bool1;
        f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        if (!isEnabled()) {
          break;
        }
        i = j;
        if (mThumbDrawable != null)
        {
          i = getThumbOffset();
          mThumbDrawable.getPadding(mTempRect);
          int k = mSwitchTop;
          int m = mTouchSlop;
          int n = i + mSwitchLeft - mTouchSlop;
          int i1 = mThumbWidth;
          int i2 = mTempRect.left;
          int i3 = mTempRect.right;
          int i4 = mTouchSlop;
          int i5 = mSwitchBottom;
          int i6 = mTouchSlop;
          i = j;
          if (f1 > n)
          {
            i = j;
            if (f1 < i1 + n + i2 + i3 + i4)
            {
              i = j;
              if (f2 > k - m)
              {
                i = j;
                if (f2 < i5 + i6) {
                  i = 1;
                }
              }
            }
          }
        }
        if (i == 0) {
          break;
        }
        mTouchMode = 1;
        mTouchX = f1;
        mTouchY = f2;
        break;
        switch (mTouchMode)
        {
        case 0: 
        default: 
          break;
        case 1: 
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          if ((Math.abs(f1 - mTouchX) <= mTouchSlop) && (Math.abs(f2 - mTouchY) <= mTouchSlop)) {
            break;
          }
          mTouchMode = 2;
          getParent().requestDisallowInterceptTouchEvent(true);
          mTouchX = f1;
          mTouchY = f2;
          return true;
        case 2: 
          float f4 = paramMotionEvent.getX();
          i = getThumbScrollRange();
          f1 = f4 - mTouchX;
          if (i != 0)
          {
            f1 /= i;
            f2 = f1;
            if (ViewUtils.isLayoutRtl(this)) {
              f2 = -f1;
            }
            f1 = mThumbPosition + f2;
            if (f1 >= 0.0F) {
              break label475;
            }
            f1 = f3;
          }
          for (;;)
          {
            if (f1 == mThumbPosition) {
              break label487;
            }
            mTouchX = f4;
            setThumbPosition(f1);
            return true;
            if (f1 > 0.0F)
            {
              f1 = 1.0F;
              break;
            }
            f1 = -1.0F;
            break;
            if (f1 > 1.0F) {
              f1 = 1.0F;
            }
          }
        }
      }
      if (mTouchMode == 2)
      {
        mTouchMode = 0;
        boolean bool2;
        if ((paramMotionEvent.getAction() == 1) && (isEnabled()))
        {
          i = 1;
          bool2 = isChecked();
          if (i == 0) {
            break label667;
          }
          mVelocityTracker.computeCurrentVelocity(1000);
          f1 = mVelocityTracker.getXVelocity();
          if (Math.abs(f1) <= mMinFlingVelocity) {
            break label658;
          }
          if (!ViewUtils.isLayoutRtl(this)) {
            break label640;
          }
          if (f1 >= 0.0F) {
            break label634;
          }
          bool1 = true;
        }
        for (;;)
        {
          if (bool1 != bool2) {
            playSoundEffect(0);
          }
          setChecked(bool1);
          MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
          localMotionEvent.setAction(3);
          super.onTouchEvent(localMotionEvent);
          localMotionEvent.recycle();
          super.onTouchEvent(paramMotionEvent);
          return true;
          i = 0;
          break;
          label634:
          bool1 = false;
          continue;
          label640:
          if (f1 > 0.0F)
          {
            bool1 = true;
          }
          else
          {
            bool1 = false;
            continue;
            label658:
            bool1 = getTargetCheckedState();
            continue;
            label667:
            bool1 = bool2;
          }
        }
      }
      mTouchMode = 0;
      mVelocityTracker.clear();
    }
  }
  
  public void setChecked(final boolean paramBoolean)
  {
    float f1 = 1.0F;
    super.setChecked(paramBoolean);
    paramBoolean = isChecked();
    if ((getWindowToken() != null) && (ViewCompat.isLaidOut(this)) && (isShown()))
    {
      if (mPositionAnimator != null) {
        cancelPositionAnimator();
      }
      float f2 = mThumbPosition;
      if (paramBoolean) {}
      for (;;)
      {
        mPositionAnimator = new ThumbAnimation(f2, f1, (byte)0);
        mPositionAnimator.setDuration(250L);
        mPositionAnimator.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            if (mPositionAnimator == paramAnonymousAnimation)
            {
              paramAnonymousAnimation = SwitchCompat.this;
              if (!paramBoolean) {
                break label39;
              }
            }
            label39:
            for (float f = 1.0F;; f = 0.0F)
            {
              paramAnonymousAnimation.setThumbPosition(f);
              SwitchCompat.access$102$3684b1bd(SwitchCompat.this);
              return;
            }
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        startAnimation(mPositionAnimator);
        return;
        f1 = 0.0F;
      }
    }
    cancelPositionAnimator();
    if (paramBoolean) {}
    for (;;)
    {
      setThumbPosition(f1);
      return;
      f1 = 0.0F;
    }
  }
  
  public void setShowText(boolean paramBoolean)
  {
    if (mShowText != paramBoolean)
    {
      mShowText = paramBoolean;
      requestLayout();
    }
  }
  
  public void setSplitTrack(boolean paramBoolean)
  {
    mSplitTrack = paramBoolean;
    invalidate();
  }
  
  public void setSwitchMinWidth(int paramInt)
  {
    mSwitchMinWidth = paramInt;
    requestLayout();
  }
  
  public void setSwitchPadding(int paramInt)
  {
    mSwitchPadding = paramInt;
    requestLayout();
  }
  
  public void setSwitchTypeface(Typeface paramTypeface)
  {
    if (mTextPaint.getTypeface() != paramTypeface)
    {
      mTextPaint.setTypeface(paramTypeface);
      requestLayout();
      invalidate();
    }
  }
  
  public void setTextOff(CharSequence paramCharSequence)
  {
    mTextOff = paramCharSequence;
    requestLayout();
  }
  
  public void setTextOn(CharSequence paramCharSequence)
  {
    mTextOn = paramCharSequence;
    requestLayout();
  }
  
  public void setThumbDrawable(Drawable paramDrawable)
  {
    mThumbDrawable = paramDrawable;
    requestLayout();
  }
  
  public void setThumbResource(int paramInt)
  {
    setThumbDrawable(mDrawableManager.getDrawable(getContext(), paramInt, false));
  }
  
  public void setThumbTextPadding(int paramInt)
  {
    mThumbTextPadding = paramInt;
    requestLayout();
  }
  
  public void setTrackDrawable(Drawable paramDrawable)
  {
    mTrackDrawable = paramDrawable;
    requestLayout();
  }
  
  public void setTrackResource(int paramInt)
  {
    setTrackDrawable(mDrawableManager.getDrawable(getContext(), paramInt, false));
  }
  
  public void toggle()
  {
    if (!isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == mThumbDrawable) || (paramDrawable == mTrackDrawable);
  }
  
  private final class ThumbAnimation
    extends Animation
  {
    final float mDiff;
    final float mEndPosition;
    final float mStartPosition;
    
    private ThumbAnimation(float paramFloat1, float paramFloat2)
    {
      mStartPosition = paramFloat1;
      mEndPosition = paramFloat2;
      mDiff = (paramFloat2 - paramFloat1);
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      SwitchCompat.this.setThumbPosition(mStartPosition + mDiff * paramFloat);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.SwitchCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */