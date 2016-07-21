package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.design.R.color;
import android.support.design.R.string;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityNodeInfoImpl;
import android.support.v4.widget.Space;
import android.support.v7.widget.AppCompatDrawableManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.List;

public class TextInputLayout
  extends LinearLayout
{
  private static final int ANIMATION_DURATION = 200;
  private static final int INVALID_MAX_LENGTH = -1;
  private static final String LOG_TAG = "TextInputLayout";
  private ValueAnimatorCompat mAnimator;
  private final CollapsingTextHelper mCollapsingTextHelper = new CollapsingTextHelper(this);
  private boolean mCounterEnabled;
  private int mCounterMaxLength;
  private int mCounterOverflowTextAppearance;
  private boolean mCounterOverflowed;
  private int mCounterTextAppearance;
  private TextView mCounterView;
  private ColorStateList mDefaultTextColor;
  private EditText mEditText;
  private CharSequence mError;
  private boolean mErrorEnabled;
  private boolean mErrorShown;
  private int mErrorTextAppearance;
  private TextView mErrorView;
  private ColorStateList mFocusedTextColor;
  private boolean mHasReconstructedEditTextBackground;
  private CharSequence mHint;
  private boolean mHintAnimationEnabled;
  private boolean mHintEnabled;
  private LinearLayout mIndicatorArea;
  private int mIndicatorsAdded;
  private Paint mTmpPaint;
  
  public TextInputLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextInputLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    ThemeUtils.checkAppCompatTheme(paramContext);
    setOrientation(1);
    setWillNotDraw(false);
    setAddStatesFromChildren(true);
    mCollapsingTextHelper.setTextSizeInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    mCollapsingTextHelper.setPositionInterpolator(new AccelerateInterpolator());
    mCollapsingTextHelper.setCollapsedTextGravity(8388659);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TextInputLayout, paramInt, R.style.Widget_Design_TextInputLayout);
    mHintEnabled = paramContext.getBoolean(R.styleable.TextInputLayout_hintEnabled, true);
    setHint(paramContext.getText(R.styleable.TextInputLayout_android_hint));
    mHintAnimationEnabled = paramContext.getBoolean(R.styleable.TextInputLayout_hintAnimationEnabled, true);
    if (paramContext.hasValue(R.styleable.TextInputLayout_android_textColorHint))
    {
      paramAttributeSet = paramContext.getColorStateList(R.styleable.TextInputLayout_android_textColorHint);
      mFocusedTextColor = paramAttributeSet;
      mDefaultTextColor = paramAttributeSet;
    }
    if (paramContext.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
      setHintTextAppearance(paramContext.getResourceId(R.styleable.TextInputLayout_hintTextAppearance, 0));
    }
    mErrorTextAppearance = paramContext.getResourceId(R.styleable.TextInputLayout_errorTextAppearance, 0);
    boolean bool1 = paramContext.getBoolean(R.styleable.TextInputLayout_errorEnabled, false);
    boolean bool2 = paramContext.getBoolean(R.styleable.TextInputLayout_counterEnabled, false);
    setCounterMaxLength(paramContext.getInt(R.styleable.TextInputLayout_counterMaxLength, -1));
    mCounterTextAppearance = paramContext.getResourceId(R.styleable.TextInputLayout_counterTextAppearance, 0);
    mCounterOverflowTextAppearance = paramContext.getResourceId(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
    paramContext.recycle();
    setErrorEnabled(bool1);
    setCounterEnabled(bool2);
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    ViewCompat.setAccessibilityDelegate(this, new TextInputAccessibilityDelegate(null));
  }
  
  private void addIndicator(TextView paramTextView, int paramInt)
  {
    if (mIndicatorArea == null)
    {
      mIndicatorArea = new LinearLayout(getContext());
      mIndicatorArea.setOrientation(0);
      addView(mIndicatorArea, -1, -2);
      Space localSpace = new Space(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, 0, 1.0F);
      mIndicatorArea.addView(localSpace, localLayoutParams);
      if (mEditText != null) {
        adjustIndicatorPadding();
      }
    }
    mIndicatorArea.setVisibility(0);
    mIndicatorArea.addView(paramTextView, paramInt);
    mIndicatorsAdded += 1;
  }
  
  private void adjustIndicatorPadding()
  {
    ViewCompat.setPaddingRelative(mIndicatorArea, ViewCompat.getPaddingStart(mEditText), 0, ViewCompat.getPaddingEnd(mEditText), mEditText.getPaddingBottom());
  }
  
  private void animateToExpansionFraction(float paramFloat)
  {
    if (mCollapsingTextHelper.getExpansionFraction() == paramFloat) {
      return;
    }
    if (mAnimator == null)
    {
      mAnimator = ViewUtils.createAnimator();
      mAnimator.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
      mAnimator.setDuration(200);
      mAnimator.setUpdateListener(new ValueAnimatorCompat.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimatorCompat paramAnonymousValueAnimatorCompat)
        {
          mCollapsingTextHelper.setExpansionFraction(paramAnonymousValueAnimatorCompat.getAnimatedFloatValue());
        }
      });
    }
    mAnimator.setFloatValues(mCollapsingTextHelper.getExpansionFraction(), paramFloat);
    mAnimator.start();
  }
  
  private static boolean arrayContains(int[] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static void clearColorFilter(Drawable paramDrawable)
  {
    for (;;)
    {
      paramDrawable.clearColorFilter();
      if ((Build.VERSION.SDK_INT != 21) && (Build.VERSION.SDK_INT != 22)) {
        return;
      }
      if ((paramDrawable instanceof InsetDrawable))
      {
        paramDrawable = ((InsetDrawable)paramDrawable).getDrawable();
      }
      else
      {
        if (!(paramDrawable instanceof DrawableWrapper)) {
          break;
        }
        paramDrawable = ((DrawableWrapper)paramDrawable).getWrappedDrawable();
      }
    }
    if ((paramDrawable instanceof DrawableContainer))
    {
      paramDrawable = (DrawableContainer.DrawableContainerState)((DrawableContainer)paramDrawable).getConstantState();
      if (paramDrawable != null)
      {
        int i = 0;
        int j = paramDrawable.getChildCount();
        while (i < j)
        {
          clearColorFilter(paramDrawable.getChild(i));
          i += 1;
        }
      }
    }
  }
  
  private void collapseHint(boolean paramBoolean)
  {
    if ((mAnimator != null) && (mAnimator.isRunning())) {
      mAnimator.cancel();
    }
    if ((paramBoolean) && (mHintAnimationEnabled))
    {
      animateToExpansionFraction(1.0F);
      return;
    }
    mCollapsingTextHelper.setExpansionFraction(1.0F);
  }
  
  private void ensureBackgroundDrawableStateWorkaround()
  {
    int i = Build.VERSION.SDK_INT;
    if ((i != 21) && (i != 22)) {}
    Drawable localDrawable2;
    do
    {
      Drawable localDrawable1;
      do
      {
        return;
        localDrawable1 = mEditText.getBackground();
      } while ((localDrawable1 == null) || (mHasReconstructedEditTextBackground));
      localDrawable2 = localDrawable1.getConstantState().newDrawable();
      if ((localDrawable1 instanceof DrawableContainer)) {
        mHasReconstructedEditTextBackground = DrawableUtils.setContainerConstantState((DrawableContainer)localDrawable1, localDrawable2.getConstantState());
      }
    } while (mHasReconstructedEditTextBackground);
    mEditText.setBackgroundDrawable(localDrawable2);
    mHasReconstructedEditTextBackground = true;
  }
  
  private void expandHint(boolean paramBoolean)
  {
    if ((mAnimator != null) && (mAnimator.isRunning())) {
      mAnimator.cancel();
    }
    if ((paramBoolean) && (mHintAnimationEnabled))
    {
      animateToExpansionFraction(0.0F);
      return;
    }
    mCollapsingTextHelper.setExpansionFraction(0.0F);
  }
  
  private void removeIndicator(TextView paramTextView)
  {
    if (mIndicatorArea != null)
    {
      mIndicatorArea.removeView(paramTextView);
      int i = mIndicatorsAdded - 1;
      mIndicatorsAdded = i;
      if (i == 0) {
        mIndicatorArea.setVisibility(8);
      }
    }
  }
  
  private void setEditText(EditText paramEditText)
  {
    if (mEditText != null) {
      throw new IllegalArgumentException("We already have an EditText, can only have one");
    }
    if (!(paramEditText instanceof TextInputEditText)) {
      Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
    }
    mEditText = paramEditText;
    mCollapsingTextHelper.setTypefaces(mEditText.getTypeface());
    mCollapsingTextHelper.setExpandedTextSize(mEditText.getTextSize());
    int i = mEditText.getGravity();
    mCollapsingTextHelper.setCollapsedTextGravity(0x800007 & i | 0x30);
    mCollapsingTextHelper.setExpandedTextGravity(i);
    mEditText.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        TextInputLayout.this.updateLabelState(true);
        if (mCounterEnabled) {
          TextInputLayout.this.updateCounter(paramAnonymousEditable.length());
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    if (mDefaultTextColor == null) {
      mDefaultTextColor = mEditText.getHintTextColors();
    }
    if ((mHintEnabled) && (TextUtils.isEmpty(mHint)))
    {
      setHint(mEditText.getHint());
      mEditText.setHint(null);
    }
    if (mCounterView != null) {
      updateCounter(mEditText.getText().length());
    }
    if (mIndicatorArea != null) {
      adjustIndicatorPadding();
    }
    updateLabelState(false);
  }
  
  private void setHintInternal(CharSequence paramCharSequence)
  {
    mHint = paramCharSequence;
    mCollapsingTextHelper.setText(paramCharSequence);
  }
  
  private void updateCounter(int paramInt)
  {
    boolean bool2 = mCounterOverflowed;
    if (mCounterMaxLength == -1)
    {
      mCounterView.setText(String.valueOf(paramInt));
      mCounterOverflowed = false;
      if ((mEditText != null) && (bool2 != mCounterOverflowed))
      {
        updateLabelState(false);
        updateEditTextBackground();
      }
      return;
    }
    boolean bool1;
    label66:
    TextView localTextView;
    Context localContext;
    if (paramInt > mCounterMaxLength)
    {
      bool1 = true;
      mCounterOverflowed = bool1;
      if (bool2 != mCounterOverflowed)
      {
        localTextView = mCounterView;
        localContext = getContext();
        if (!mCounterOverflowed) {
          break label158;
        }
      }
    }
    label158:
    for (int i = mCounterOverflowTextAppearance;; i = mCounterTextAppearance)
    {
      localTextView.setTextAppearance(localContext, i);
      mCounterView.setText(getContext().getString(R.string.character_counter_pattern, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(mCounterMaxLength) }));
      break;
      bool1 = false;
      break label66;
    }
  }
  
  private void updateEditTextBackground()
  {
    ensureBackgroundDrawableStateWorkaround();
    Drawable localDrawable2 = mEditText.getBackground();
    if (localDrawable2 == null) {
      return;
    }
    Drawable localDrawable1 = localDrawable2;
    if (android.support.v7.widget.DrawableUtils.canSafelyMutateDrawable(localDrawable2)) {
      localDrawable1 = localDrawable2.mutate();
    }
    if ((mErrorShown) && (mErrorView != null))
    {
      localDrawable1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(mErrorView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    if ((mCounterOverflowed) && (mCounterView != null))
    {
      localDrawable1.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(mCounterView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
      return;
    }
    clearColorFilter(localDrawable1);
    mEditText.refreshDrawableState();
  }
  
  private LinearLayout.LayoutParams updateEditTextMargin(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LinearLayout.LayoutParams)) {}
    for (paramLayoutParams = (LinearLayout.LayoutParams)paramLayoutParams; mHintEnabled; paramLayoutParams = new LinearLayout.LayoutParams(paramLayoutParams))
    {
      if (mTmpPaint == null) {
        mTmpPaint = new Paint();
      }
      mTmpPaint.setTypeface(mCollapsingTextHelper.getCollapsedTypeface());
      mTmpPaint.setTextSize(mCollapsingTextHelper.getCollapsedTextSize());
      topMargin = ((int)-mTmpPaint.ascent());
      return paramLayoutParams;
    }
    topMargin = 0;
    return paramLayoutParams;
  }
  
  private void updateLabelState(boolean paramBoolean)
  {
    int i;
    boolean bool;
    int j;
    if ((mEditText != null) && (!TextUtils.isEmpty(mEditText.getText())))
    {
      i = 1;
      bool = arrayContains(getDrawableState(), 16842908);
      if (TextUtils.isEmpty(getError())) {
        break label119;
      }
      j = 1;
      label46:
      if (mDefaultTextColor != null) {
        mCollapsingTextHelper.setExpandedTextColor(mDefaultTextColor.getDefaultColor());
      }
      if ((!mCounterOverflowed) || (mCounterView == null)) {
        break label124;
      }
      mCollapsingTextHelper.setCollapsedTextColor(mCounterView.getCurrentTextColor());
    }
    for (;;)
    {
      if ((i == 0) && (!bool) && (j == 0)) {
        break label177;
      }
      collapseHint(paramBoolean);
      return;
      i = 0;
      break;
      label119:
      j = 0;
      break label46;
      label124:
      if ((bool) && (mFocusedTextColor != null)) {
        mCollapsingTextHelper.setCollapsedTextColor(mFocusedTextColor.getDefaultColor());
      } else if (mDefaultTextColor != null) {
        mCollapsingTextHelper.setCollapsedTextColor(mDefaultTextColor.getDefaultColor());
      }
    }
    label177:
    expandHint(paramBoolean);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof EditText))
    {
      setEditText((EditText)paramView);
      super.addView(paramView, 0, updateEditTextMargin(paramLayoutParams));
      return;
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (mHintEnabled) {
      mCollapsingTextHelper.draw(paramCanvas);
    }
  }
  
  public int getCounterMaxLength()
  {
    return mCounterMaxLength;
  }
  
  public EditText getEditText()
  {
    return mEditText;
  }
  
  public CharSequence getError()
  {
    if (mErrorEnabled) {
      return mError;
    }
    return null;
  }
  
  public CharSequence getHint()
  {
    if (mHintEnabled) {
      return mHint;
    }
    return null;
  }
  
  public Typeface getTypeface()
  {
    return mCollapsingTextHelper.getCollapsedTypeface();
  }
  
  public boolean isCounterEnabled()
  {
    return mCounterEnabled;
  }
  
  public boolean isErrorEnabled()
  {
    return mErrorEnabled;
  }
  
  public boolean isHintAnimationEnabled()
  {
    return mHintAnimationEnabled;
  }
  
  public boolean isHintEnabled()
  {
    return mHintEnabled;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((mHintEnabled) && (mEditText != null))
    {
      paramInt1 = mEditText.getLeft() + mEditText.getCompoundPaddingLeft();
      paramInt3 = mEditText.getRight() - mEditText.getCompoundPaddingRight();
      mCollapsingTextHelper.setExpandedBounds(paramInt1, mEditText.getTop() + mEditText.getCompoundPaddingTop(), paramInt3, mEditText.getBottom() - mEditText.getCompoundPaddingBottom());
      mCollapsingTextHelper.setCollapsedBounds(paramInt1, getPaddingTop(), paramInt3, paramInt4 - paramInt2 - getPaddingBottom());
      mCollapsingTextHelper.recalculate();
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    setError(error);
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (mErrorShown) {
      error = getError();
    }
    return localSavedState;
  }
  
  public void refreshDrawableState()
  {
    super.refreshDrawableState();
    updateLabelState(ViewCompat.isLaidOut(this));
  }
  
  public void setCounterEnabled(boolean paramBoolean)
  {
    if (mCounterEnabled != paramBoolean)
    {
      if (!paramBoolean) {
        break label131;
      }
      mCounterView = new TextView(getContext());
      mCounterView.setMaxLines(1);
    }
    for (;;)
    {
      try
      {
        mCounterView.setTextAppearance(getContext(), mCounterTextAppearance);
        addIndicator(mCounterView, -1);
        if (mEditText == null)
        {
          updateCounter(0);
          mCounterEnabled = paramBoolean;
          return;
        }
      }
      catch (Exception localException)
      {
        mCounterView.setTextAppearance(getContext(), R.style.TextAppearance_AppCompat_Caption);
        mCounterView.setTextColor(ContextCompat.getColor(getContext(), R.color.design_textinput_error_color_light));
        continue;
        updateCounter(mEditText.getText().length());
        continue;
      }
      label131:
      removeIndicator(mCounterView);
      mCounterView = null;
    }
  }
  
  public void setCounterMaxLength(int paramInt)
  {
    if (mCounterMaxLength != paramInt)
    {
      if (paramInt <= 0) {
        break label39;
      }
      mCounterMaxLength = paramInt;
      if (mCounterEnabled) {
        if (mEditText != null) {
          break label47;
        }
      }
    }
    label39:
    label47:
    for (paramInt = 0;; paramInt = mEditText.getText().length())
    {
      updateCounter(paramInt);
      return;
      mCounterMaxLength = -1;
      break;
    }
  }
  
  public void setError(final CharSequence paramCharSequence)
  {
    if (TextUtils.equals(mError, paramCharSequence)) {}
    do
    {
      return;
      mError = paramCharSequence;
      if (mErrorEnabled) {
        break;
      }
    } while (TextUtils.isEmpty(paramCharSequence));
    setErrorEnabled(true);
    boolean bool2 = ViewCompat.isLaidOut(this);
    boolean bool1;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      bool1 = true;
      mErrorShown = bool1;
      ViewCompat.animate(mErrorView).cancel();
      if (!mErrorShown) {
        break label164;
      }
      mErrorView.setText(paramCharSequence);
      mErrorView.setVisibility(0);
      if (bool2)
      {
        if (ViewCompat.getAlpha(mErrorView) == 1.0F) {
          ViewCompat.setAlpha(mErrorView, 0.0F);
        }
        ViewCompat.animate(mErrorView).alpha(1.0F).setDuration(200L).setInterpolator(AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR).setListener(new ViewPropertyAnimatorListenerAdapter()
        {
          public void onAnimationStart(View paramAnonymousView)
          {
            paramAnonymousView.setVisibility(0);
          }
        }).start();
      }
    }
    for (;;)
    {
      updateEditTextBackground();
      updateLabelState(true);
      return;
      bool1 = false;
      break;
      label164:
      if (mErrorView.getVisibility() == 0) {
        if (bool2) {
          ViewCompat.animate(mErrorView).alpha(0.0F).setDuration(200L).setInterpolator(AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR).setListener(new ViewPropertyAnimatorListenerAdapter()
          {
            public void onAnimationEnd(View paramAnonymousView)
            {
              mErrorView.setText(paramCharSequence);
              paramAnonymousView.setVisibility(4);
            }
          }).start();
        } else {
          mErrorView.setVisibility(4);
        }
      }
    }
  }
  
  public void setErrorEnabled(boolean paramBoolean)
  {
    if (mErrorEnabled != paramBoolean)
    {
      if (mErrorView != null) {
        ViewCompat.animate(mErrorView).cancel();
      }
      if (!paramBoolean) {
        break label124;
      }
    }
    for (mErrorView = new TextView(getContext());; mErrorView = null)
    {
      try
      {
        mErrorView.setTextAppearance(getContext(), mErrorTextAppearance);
        mErrorView.setVisibility(4);
        ViewCompat.setAccessibilityLiveRegion$5359dc9a(mErrorView);
        addIndicator(mErrorView, 0);
        mErrorEnabled = paramBoolean;
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          mErrorView.setTextAppearance(getContext(), R.style.TextAppearance_AppCompat_Caption);
          mErrorView.setTextColor(ContextCompat.getColor(getContext(), R.color.design_textinput_error_color_light));
        }
      }
      label124:
      mErrorShown = false;
      updateEditTextBackground();
      removeIndicator(mErrorView);
    }
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    if (mHintEnabled)
    {
      setHintInternal(paramCharSequence);
      sendAccessibilityEvent(2048);
    }
  }
  
  public void setHintAnimationEnabled(boolean paramBoolean)
  {
    mHintAnimationEnabled = paramBoolean;
  }
  
  public void setHintEnabled(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean != mHintEnabled)
    {
      mHintEnabled = paramBoolean;
      localObject = mEditText.getHint();
      if (mHintEnabled) {
        break label89;
      }
      if ((!TextUtils.isEmpty(mHint)) && (TextUtils.isEmpty((CharSequence)localObject))) {
        mEditText.setHint(mHint);
      }
      setHintInternal(null);
    }
    for (;;)
    {
      if (mEditText != null)
      {
        localObject = updateEditTextMargin(mEditText.getLayoutParams());
        mEditText.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      label89:
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (TextUtils.isEmpty(mHint)) {
          setHint((CharSequence)localObject);
        }
        mEditText.setHint(null);
      }
    }
  }
  
  public void setHintTextAppearance(int paramInt)
  {
    mCollapsingTextHelper.setCollapsedTextAppearance(paramInt);
    mFocusedTextColor = ColorStateList.valueOf(mCollapsingTextHelper.getCollapsedTextColor());
    if (mEditText != null)
    {
      updateLabelState(false);
      LinearLayout.LayoutParams localLayoutParams = updateEditTextMargin(mEditText.getLayoutParams());
      mEditText.setLayoutParams(localLayoutParams);
      mEditText.requestLayout();
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    mCollapsingTextHelper.setTypefaces(paramTypeface);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public final TextInputLayout.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new TextInputLayout.SavedState(paramAnonymousParcel);
      }
      
      public final TextInputLayout.SavedState[] newArray(int paramAnonymousInt)
      {
        return new TextInputLayout.SavedState[paramAnonymousInt];
      }
    };
    CharSequence error;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      error = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + error + "}";
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      TextUtils.writeToParcel(error, paramParcel, paramInt);
    }
  }
  
  private class TextInputAccessibilityDelegate
    extends AccessibilityDelegateCompat
  {
    private TextInputAccessibilityDelegate() {}
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      paramAccessibilityNodeInfoCompat.setClassName(TextInputLayout.class.getSimpleName());
      paramView = mCollapsingTextHelper.getText();
      if (!TextUtils.isEmpty(paramView)) {
        AccessibilityNodeInfoCompat.IMPL.setText(mInfo, paramView);
      }
      if (mEditText != null)
      {
        paramView = mEditText;
        AccessibilityNodeInfoCompat.IMPL.setLabelFor(mInfo, paramView);
      }
      if (mErrorView != null) {}
      for (paramView = mErrorView.getText();; paramView = null)
      {
        if (!TextUtils.isEmpty(paramView))
        {
          AccessibilityNodeInfoCompat.IMPL.setContentInvalid$4cfd3ce3(mInfo);
          AccessibilityNodeInfoCompat.IMPL.setError(mInfo, paramView);
        }
        return;
      }
    }
    
    public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
      paramView = mCollapsingTextHelper.getText();
      if (!TextUtils.isEmpty(paramView)) {
        paramAccessibilityEvent.getText().add(paramView);
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.TextInputLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */