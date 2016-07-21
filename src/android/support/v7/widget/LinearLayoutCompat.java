package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class LinearLayoutCompat
  extends ViewGroup
{
  public static final int HORIZONTAL = 0;
  private static final int INDEX_BOTTOM = 2;
  private static final int INDEX_CENTER_VERTICAL = 0;
  private static final int INDEX_FILL = 3;
  private static final int INDEX_TOP = 1;
  public static final int SHOW_DIVIDER_BEGINNING = 1;
  public static final int SHOW_DIVIDER_END = 4;
  public static final int SHOW_DIVIDER_MIDDLE = 2;
  public static final int SHOW_DIVIDER_NONE = 0;
  public static final int VERTICAL = 1;
  private static final int VERTICAL_GRAVITY_COUNT = 4;
  private boolean mBaselineAligned = true;
  private int mBaselineAlignedChildIndex = -1;
  private int mBaselineChildTop = 0;
  private Drawable mDivider;
  private int mDividerHeight;
  private int mDividerPadding;
  private int mDividerWidth;
  private int mGravity = 8388659;
  private int[] mMaxAscent;
  private int[] mMaxDescent;
  private int mOrientation;
  private int mShowDividers;
  private int mTotalLength;
  private boolean mUseLargestChild;
  private float mWeightSum;
  
  public LinearLayoutCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LinearLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = TintTypedArray.obtainStyledAttributes$89ace2b(paramContext, paramAttributeSet, R.styleable.LinearLayoutCompat, paramInt);
    paramInt = paramContext.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
    if (paramInt >= 0) {
      setOrientation(paramInt);
    }
    paramInt = paramContext.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
    if (paramInt >= 0) {
      setGravity(paramInt);
    }
    boolean bool = paramContext.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
    if (!bool) {
      setBaselineAligned(bool);
    }
    paramInt = R.styleable.LinearLayoutCompat_android_weightSum;
    mWeightSum = mWrapped.getFloat(paramInt, -1.0F);
    mBaselineAlignedChildIndex = paramContext.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
    mUseLargestChild = paramContext.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
    setDividerDrawable(paramContext.getDrawable(R.styleable.LinearLayoutCompat_divider));
    mShowDividers = paramContext.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
    mDividerPadding = paramContext.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
    mWrapped.recycle();
  }
  
  private void forceUniformHeight(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
    int i = 0;
    while (i < paramInt1)
    {
      View localView = getVirtualChildAt(i);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (height == -1)
        {
          int k = width;
          width = localView.getMeasuredWidth();
          measureChildWithMargins(localView, paramInt2, 0, j, 0);
          width = k;
        }
      }
      i += 1;
    }
  }
  
  private void forceUniformWidth(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
    int i = 0;
    while (i < paramInt1)
    {
      View localView = getVirtualChildAt(i);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (width == -1)
        {
          int k = height;
          height = localView.getMeasuredHeight();
          measureChildWithMargins(localView, j, 0, paramInt2, 0);
          height = k;
        }
      }
      i += 1;
    }
  }
  
  private void setChildFrame(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.layout(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  void drawDividersHorizontal(Canvas paramCanvas)
  {
    int k = getVirtualChildCount();
    boolean bool = ViewUtils.isLayoutRtl(this);
    int i = 0;
    View localView;
    LayoutParams localLayoutParams;
    if (i < k)
    {
      localView = getVirtualChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (hasDividerBeforeChildAt(i)))
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!bool) {
          break label90;
        }
      }
      label90:
      for (int j = localView.getRight() + rightMargin;; j = localView.getLeft() - leftMargin - mDividerWidth)
      {
        drawVerticalDivider(paramCanvas, j);
        i += 1;
        break;
      }
    }
    if (hasDividerBeforeChildAt(k))
    {
      localView = getVirtualChildAt(k - 1);
      if (localView != null) {
        break label169;
      }
      if (!bool) {
        break label151;
      }
      i = getPaddingLeft();
    }
    for (;;)
    {
      drawVerticalDivider(paramCanvas, i);
      return;
      label151:
      i = getWidth() - getPaddingRight() - mDividerWidth;
      continue;
      label169:
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if (bool) {
        i = localView.getLeft() - leftMargin - mDividerWidth;
      } else {
        i = localView.getRight() + rightMargin;
      }
    }
  }
  
  void drawDividersVertical(Canvas paramCanvas)
  {
    int j = getVirtualChildCount();
    int i = 0;
    View localView;
    LayoutParams localLayoutParams;
    while (i < j)
    {
      localView = getVirtualChildAt(i);
      if ((localView != null) && (localView.getVisibility() != 8) && (hasDividerBeforeChildAt(i)))
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        drawHorizontalDivider(paramCanvas, localView.getTop() - topMargin - mDividerHeight);
      }
      i += 1;
    }
    if (hasDividerBeforeChildAt(j))
    {
      localView = getVirtualChildAt(j - 1);
      if (localView != null) {
        break label124;
      }
    }
    for (i = getHeight() - getPaddingBottom() - mDividerHeight;; i = localView.getBottom() + bottomMargin)
    {
      drawHorizontalDivider(paramCanvas, i);
      return;
      label124:
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
    }
  }
  
  void drawHorizontalDivider(Canvas paramCanvas, int paramInt)
  {
    mDivider.setBounds(getPaddingLeft() + mDividerPadding, paramInt, getWidth() - getPaddingRight() - mDividerPadding, mDividerHeight + paramInt);
    mDivider.draw(paramCanvas);
  }
  
  void drawVerticalDivider(Canvas paramCanvas, int paramInt)
  {
    mDivider.setBounds(paramInt, getPaddingTop() + mDividerPadding, mDividerWidth + paramInt, getHeight() - getPaddingBottom() - mDividerPadding);
    mDivider.draw(paramCanvas);
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    if (mOrientation == 0) {
      return new LayoutParams(-2, -2);
    }
    if (mOrientation == 1) {
      return new LayoutParams(-1, -2);
    }
    return null;
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getBaseline()
  {
    int i = -1;
    if (mBaselineAlignedChildIndex < 0) {
      i = super.getBaseline();
    }
    View localView;
    int k;
    do
    {
      return i;
      if (getChildCount() <= mBaselineAlignedChildIndex) {
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
      }
      localView = getChildAt(mBaselineAlignedChildIndex);
      k = localView.getBaseline();
      if (k != -1) {
        break;
      }
    } while (mBaselineAlignedChildIndex == 0);
    throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
    int j = mBaselineChildTop;
    i = j;
    if (mOrientation == 1)
    {
      int m = mGravity & 0x70;
      i = j;
      if (m != 48) {
        switch (m)
        {
        default: 
          i = j;
        }
      }
    }
    for (;;)
    {
      return getLayoutParamstopMargin + i + k;
      i = getBottom() - getTop() - getPaddingBottom() - mTotalLength;
      continue;
      i = j + (getBottom() - getTop() - getPaddingTop() - getPaddingBottom() - mTotalLength) / 2;
    }
  }
  
  public int getBaselineAlignedChildIndex()
  {
    return mBaselineAlignedChildIndex;
  }
  
  int getChildrenSkipCount(View paramView, int paramInt)
  {
    return 0;
  }
  
  public Drawable getDividerDrawable()
  {
    return mDivider;
  }
  
  public int getDividerPadding()
  {
    return mDividerPadding;
  }
  
  public int getDividerWidth()
  {
    return mDividerWidth;
  }
  
  int getLocationOffset(View paramView)
  {
    return 0;
  }
  
  int getNextLocationOffset(View paramView)
  {
    return 0;
  }
  
  public int getOrientation()
  {
    return mOrientation;
  }
  
  public int getShowDividers()
  {
    return mShowDividers;
  }
  
  View getVirtualChildAt(int paramInt)
  {
    return getChildAt(paramInt);
  }
  
  int getVirtualChildCount()
  {
    return getChildCount();
  }
  
  public float getWeightSum()
  {
    return mWeightSum;
  }
  
  protected boolean hasDividerBeforeChildAt(int paramInt)
  {
    boolean bool1 = true;
    if (paramInt == 0) {
      if ((mShowDividers & 0x1) == 0) {}
    }
    do
    {
      return bool1;
      return false;
      if (paramInt != getChildCount()) {
        break;
      }
    } while ((mShowDividers & 0x4) != 0);
    return false;
    if ((mShowDividers & 0x2) != 0)
    {
      boolean bool2 = false;
      paramInt -= 1;
      for (;;)
      {
        bool1 = bool2;
        if (paramInt < 0) {
          break;
        }
        if (getChildAt(paramInt).getVisibility() != 8) {
          return true;
        }
        paramInt -= 1;
      }
    }
    return false;
  }
  
  public boolean isBaselineAligned()
  {
    return mBaselineAligned;
  }
  
  public boolean isMeasureWithLargestChildEnabled()
  {
    return mUseLargestChild;
  }
  
  void layoutHorizontal(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool1 = ViewUtils.isLayoutRtl(this);
    int k = getPaddingTop();
    int n = paramInt4 - paramInt2;
    int i1 = getPaddingBottom();
    int i2 = getPaddingBottom();
    int i3 = getVirtualChildCount();
    paramInt2 = mGravity;
    int i4 = mGravity;
    boolean bool2 = mBaselineAligned;
    int[] arrayOfInt1 = mMaxAscent;
    int[] arrayOfInt2 = mMaxDescent;
    label133:
    int i5;
    View localView;
    switch (GravityCompat.getAbsoluteGravity(paramInt2 & 0x800007, ViewCompat.getLayoutDirection(this)))
    {
    default: 
      paramInt1 = getPaddingLeft();
      int i = 0;
      paramInt4 = 1;
      if (bool1)
      {
        i = i3 - 1;
        paramInt4 = -1;
      }
      paramInt2 = 0;
      paramInt3 = paramInt1;
      if (paramInt2 >= i3) {
        return;
      }
      i5 = i + paramInt4 * paramInt2;
      localView = getVirtualChildAt(i5);
      if (localView == null)
      {
        paramInt1 = paramInt3 + measureNullChild(i5);
        j = paramInt2;
      }
      break;
    }
    do
    {
      paramInt2 = j + 1;
      paramInt3 = paramInt1;
      break label133;
      paramInt1 = getPaddingLeft() + paramInt3 - paramInt1 - mTotalLength;
      break;
      paramInt1 = getPaddingLeft() + (paramInt3 - paramInt1 - mTotalLength) / 2;
      break;
      paramInt1 = paramInt3;
      j = paramInt2;
    } while (localView.getVisibility() == 8);
    int i6 = localView.getMeasuredWidth();
    int i7 = localView.getMeasuredHeight();
    paramInt1 = -1;
    LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
    int j = paramInt1;
    if (bool2)
    {
      j = paramInt1;
      if (height != -1) {
        j = localView.getBaseline();
      }
    }
    int m = gravity;
    paramInt1 = m;
    if (m < 0) {
      paramInt1 = i4 & 0x70;
    }
    switch (paramInt1 & 0x70)
    {
    default: 
      paramInt1 = k;
    }
    for (;;)
    {
      j = paramInt3;
      if (hasDividerBeforeChildAt(i5)) {
        j = paramInt3 + mDividerWidth;
      }
      paramInt3 = j + leftMargin;
      setChildFrame(localView, paramInt3 + getLocationOffset(localView), paramInt1, i6, i7);
      paramInt1 = paramInt3 + (rightMargin + i6 + getNextLocationOffset(localView));
      j = paramInt2 + getChildrenSkipCount(localView, i5);
      break;
      m = k + topMargin;
      paramInt1 = m;
      if (j != -1)
      {
        paramInt1 = m + (arrayOfInt1[1] - j);
        continue;
        paramInt1 = (n - k - i2 - i7) / 2 + k + topMargin - bottomMargin;
        continue;
        m = n - i1 - i7 - bottomMargin;
        paramInt1 = m;
        if (j != -1)
        {
          paramInt1 = localView.getMeasuredHeight();
          paramInt1 = m - (arrayOfInt2[2] - (paramInt1 - j));
        }
      }
    }
  }
  
  void layoutVertical(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getPaddingLeft();
    int j = paramInt3 - paramInt1;
    int k = getPaddingRight();
    int m = getPaddingRight();
    int n = getVirtualChildCount();
    paramInt1 = mGravity;
    int i1 = mGravity;
    label79:
    View localView;
    switch (paramInt1 & 0x70)
    {
    default: 
      paramInt1 = getPaddingTop();
      paramInt2 = 0;
      if (paramInt2 >= n) {
        return;
      }
      localView = getVirtualChildAt(paramInt2);
      if (localView == null)
      {
        paramInt3 = paramInt1 + measureNullChild(paramInt2);
        paramInt4 = paramInt2;
      }
      break;
    }
    do
    {
      paramInt2 = paramInt4 + 1;
      paramInt1 = paramInt3;
      break label79;
      paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - mTotalLength;
      break;
      paramInt1 = getPaddingTop() + (paramInt4 - paramInt2 - mTotalLength) / 2;
      break;
      paramInt3 = paramInt1;
      paramInt4 = paramInt2;
    } while (localView.getVisibility() == 8);
    int i2 = localView.getMeasuredWidth();
    int i3 = localView.getMeasuredHeight();
    LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
    paramInt4 = gravity;
    paramInt3 = paramInt4;
    if (paramInt4 < 0) {
      paramInt3 = i1 & 0x800007;
    }
    switch (GravityCompat.getAbsoluteGravity(paramInt3, ViewCompat.getLayoutDirection(this)) & 0x7)
    {
    default: 
      paramInt3 = i + leftMargin;
    }
    for (;;)
    {
      paramInt4 = paramInt1;
      if (hasDividerBeforeChildAt(paramInt2)) {
        paramInt4 = paramInt1 + mDividerHeight;
      }
      paramInt1 = paramInt4 + topMargin;
      setChildFrame(localView, paramInt3, paramInt1 + getLocationOffset(localView), i2, i3);
      paramInt3 = paramInt1 + (bottomMargin + i3 + getNextLocationOffset(localView));
      paramInt4 = paramInt2 + getChildrenSkipCount(localView, paramInt2);
      break;
      paramInt3 = (j - i - m - i2) / 2 + i + leftMargin - rightMargin;
      continue;
      paramInt3 = j - k - i2 - rightMargin;
    }
  }
  
  void measureChildBeforeLayout(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    measureChildWithMargins(paramView, paramInt2, paramInt3, paramInt4, paramInt5);
  }
  
  void measureHorizontal(int paramInt1, int paramInt2)
  {
    mTotalLength = 0;
    int i1 = 0;
    int j = 0;
    int m = 0;
    int i3 = 0;
    int i = 1;
    float f1 = 0.0F;
    int i14 = getVirtualChildCount();
    int i16 = View.MeasureSpec.getMode(paramInt1);
    int i15 = View.MeasureSpec.getMode(paramInt2);
    int k = 0;
    int i2 = 0;
    if ((mMaxAscent == null) || (mMaxDescent == null))
    {
      mMaxAscent = new int[4];
      mMaxDescent = new int[4];
    }
    Object localObject = mMaxAscent;
    int[] arrayOfInt = mMaxDescent;
    localObject[3] = -1;
    localObject[2] = -1;
    localObject[1] = -1;
    localObject[0] = -1;
    arrayOfInt[3] = -1;
    arrayOfInt[2] = -1;
    arrayOfInt[1] = -1;
    arrayOfInt[0] = -1;
    boolean bool1 = mBaselineAligned;
    boolean bool2 = mUseLargestChild;
    if (i16 == 1073741824) {}
    int n;
    int i4;
    View localView;
    for (int i13 = 1;; i13 = 0)
    {
      n = Integer.MIN_VALUE;
      i4 = 0;
      for (;;)
      {
        if (i4 >= i14) {
          break label941;
        }
        localView = getVirtualChildAt(i4);
        if (localView != null) {
          break;
        }
        mTotalLength += measureNullChild(i4);
        i4 += 1;
      }
    }
    int i12 = i;
    int i10 = m;
    int i11 = j;
    int i5 = n;
    int i9 = k;
    int i8 = i1;
    int i6 = i2;
    float f2 = f1;
    int i7 = i3;
    LayoutParams localLayoutParams;
    if (localView.getVisibility() != 8)
    {
      if (hasDividerBeforeChildAt(i4)) {
        mTotalLength += mDividerWidth;
      }
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      f2 = f1 + weight;
      if ((i16 != 1073741824) || (width != 0) || (weight <= 0.0F)) {
        break label681;
      }
      if (i13 == 0) {
        break label639;
      }
      mTotalLength += leftMargin + rightMargin;
      label342:
      if (!bool1) {
        break label671;
      }
      i5 = View.MeasureSpec.makeMeasureSpec(0, 0);
      localView.measure(i5, i5);
      i6 = i2;
      i5 = n;
      label371:
      i7 = 0;
      n = k;
      i2 = i7;
      if (i15 != 1073741824)
      {
        n = k;
        i2 = i7;
        if (height == -1)
        {
          n = 1;
          i2 = 1;
        }
      }
      k = topMargin + bottomMargin;
      i7 = localView.getMeasuredHeight() + k;
      i11 = ViewUtils.combineMeasuredStates(j, ViewCompat.getMeasuredState(localView));
      if (bool1)
      {
        i8 = localView.getBaseline();
        if (i8 != -1)
        {
          if (gravity >= 0) {
            break label882;
          }
          j = mGravity;
          label479:
          j = ((j & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
          localObject[j] = Math.max(localObject[j], i8);
          arrayOfInt[j] = Math.max(arrayOfInt[j], i7 - i8);
        }
      }
      i8 = Math.max(i1, i7);
      if ((i == 0) || (height != -1)) {
        break label892;
      }
      i = 1;
      label552:
      if (weight <= 0.0F) {
        break label905;
      }
      if (i2 == 0) {
        break label898;
      }
    }
    for (;;)
    {
      i7 = Math.max(i3, k);
      i9 = n;
      i10 = m;
      i12 = i;
      i4 += getChildrenSkipCount(localView, i4);
      i = i12;
      m = i10;
      j = i11;
      n = i5;
      k = i9;
      i1 = i8;
      i2 = i6;
      f1 = f2;
      i3 = i7;
      break;
      label639:
      i5 = mTotalLength;
      mTotalLength = Math.max(i5, leftMargin + i5 + rightMargin);
      break label342;
      label671:
      i6 = 1;
      i5 = n;
      break label371;
      label681:
      i6 = Integer.MIN_VALUE;
      i5 = i6;
      if (width == 0)
      {
        i5 = i6;
        if (weight > 0.0F)
        {
          i5 = 0;
          width = -2;
        }
      }
      if (f2 == 0.0F)
      {
        i6 = mTotalLength;
        label735:
        measureChildBeforeLayout(localView, i4, paramInt1, i6, paramInt2, 0);
        if (i5 != Integer.MIN_VALUE) {
          width = i5;
        }
        i7 = localView.getMeasuredWidth();
        if (i13 == 0) {
          break label840;
        }
      }
      for (mTotalLength += leftMargin + i7 + rightMargin + getNextLocationOffset(localView);; mTotalLength = Math.max(i5, i5 + i7 + leftMargin + rightMargin + getNextLocationOffset(localView)))
      {
        i5 = n;
        i6 = i2;
        if (!bool2) {
          break;
        }
        i5 = Math.max(i7, n);
        i6 = i2;
        break;
        i6 = 0;
        break label735;
        label840:
        i5 = mTotalLength;
      }
      label882:
      j = gravity;
      break label479;
      label892:
      i = 0;
      break label552;
      label898:
      k = i7;
    }
    label905:
    if (i2 != 0) {}
    for (;;)
    {
      i10 = Math.max(m, k);
      i12 = i;
      i9 = n;
      i7 = i3;
      break;
      k = i7;
    }
    label941:
    if ((mTotalLength > 0) && (hasDividerBeforeChildAt(i14))) {
      mTotalLength += mDividerWidth;
    }
    if ((localObject[1] == -1) && (localObject[0] == -1) && (localObject[2] == -1))
    {
      i4 = i1;
      if (localObject[3] == -1) {}
    }
    else
    {
      i4 = Math.max(i1, Math.max(localObject[3], Math.max(localObject[0], Math.max(localObject[1], localObject[2]))) + Math.max(arrayOfInt[3], Math.max(arrayOfInt[0], Math.max(arrayOfInt[1], arrayOfInt[2]))));
    }
    if ((bool2) && ((i16 == Integer.MIN_VALUE) || (i16 == 0)))
    {
      mTotalLength = 0;
      i1 = 0;
      if (i1 < i14)
      {
        localView = getVirtualChildAt(i1);
        if (localView == null) {
          mTotalLength += measureNullChild(i1);
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (localView.getVisibility() == 8)
          {
            i1 += getChildrenSkipCount(localView, i1);
          }
          else
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            if (i13 != 0)
            {
              mTotalLength += leftMargin + n + rightMargin + getNextLocationOffset(localView);
            }
            else
            {
              i5 = mTotalLength;
              mTotalLength = Math.max(i5, i5 + n + leftMargin + rightMargin + getNextLocationOffset(localView));
            }
          }
        }
      }
    }
    mTotalLength += getPaddingLeft() + getPaddingRight();
    i10 = ViewCompat.resolveSizeAndState(Math.max(mTotalLength, getSuggestedMinimumWidth()), paramInt1, 0);
    i5 = (0xFFFFFF & i10) - mTotalLength;
    if ((i2 != 0) || ((i5 != 0) && (f1 > 0.0F)))
    {
      label1388:
      float f3;
      if (mWeightSum > 0.0F)
      {
        f1 = mWeightSum;
        localObject[3] = -1;
        localObject[2] = -1;
        localObject[1] = -1;
        localObject[0] = -1;
        arrayOfInt[3] = -1;
        arrayOfInt[2] = -1;
        arrayOfInt[1] = -1;
        arrayOfInt[0] = -1;
        i1 = -1;
        mTotalLength = 0;
        i4 = 0;
        i3 = i5;
        n = m;
        if (i4 >= i14) {
          break label2028;
        }
        localView = getVirtualChildAt(i4);
        i5 = i;
        i6 = n;
        i7 = j;
        i8 = i3;
        i9 = i1;
        f3 = f1;
        if (localView != null)
        {
          i5 = i;
          i6 = n;
          i7 = j;
          i8 = i3;
          i9 = i1;
          f3 = f1;
          if (localView.getVisibility() != 8)
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            f3 = weight;
            i2 = j;
            m = i3;
            f2 = f1;
            if (f3 > 0.0F)
            {
              m = (int)(i3 * f3 / f1);
              f2 = f1 - f3;
              i2 = i3 - m;
              i5 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + topMargin + bottomMargin, height);
              if ((width == 0) && (i16 == 1073741824)) {
                break label1940;
              }
              i3 = localView.getMeasuredWidth() + m;
              m = i3;
              if (i3 < 0) {
                m = 0;
              }
              label1592:
              localView.measure(View.MeasureSpec.makeMeasureSpec(m, 1073741824), i5);
              j = ViewUtils.combineMeasuredStates(j, ViewCompat.getMeasuredState(localView) & 0xFF000000);
              m = i2;
              i2 = j;
            }
            if (i13 == 0) {
              break label1954;
            }
            mTotalLength += localView.getMeasuredWidth() + leftMargin + rightMargin + getNextLocationOffset(localView);
            label1668:
            if ((i15 == 1073741824) || (height != -1)) {
              break label1999;
            }
            j = 1;
            label1687:
            i5 = topMargin + bottomMargin;
            i3 = localView.getMeasuredHeight() + i5;
            i1 = Math.max(i1, i3);
            if (j == 0) {
              break label2005;
            }
            j = i5;
            label1728:
            n = Math.max(n, j);
            if ((i == 0) || (height != -1)) {
              break label2012;
            }
            i = 1;
            label1754:
            i5 = i;
            i6 = n;
            i7 = i2;
            i8 = m;
            i9 = i1;
            f3 = f2;
            if (bool1)
            {
              i11 = localView.getBaseline();
              i5 = i;
              i6 = n;
              i7 = i2;
              i8 = m;
              i9 = i1;
              f3 = f2;
              if (i11 != -1) {
                if (gravity >= 0) {
                  break label2018;
                }
              }
            }
          }
        }
      }
      label1940:
      label1954:
      label1999:
      label2005:
      label2012:
      label2018:
      for (j = mGravity;; j = gravity)
      {
        j = ((j & 0x70) >> 4 & 0xFFFFFFFE) >> 1;
        localObject[j] = Math.max(localObject[j], i11);
        arrayOfInt[j] = Math.max(arrayOfInt[j], i3 - i11);
        f3 = f2;
        i9 = i1;
        i8 = m;
        i7 = i2;
        i6 = n;
        i5 = i;
        i4 += 1;
        i = i5;
        n = i6;
        j = i7;
        i3 = i8;
        i1 = i9;
        f1 = f3;
        break label1388;
        break;
        if (m > 0) {
          break label1592;
        }
        m = 0;
        break label1592;
        j = mTotalLength;
        mTotalLength = Math.max(j, localView.getMeasuredWidth() + j + leftMargin + rightMargin + getNextLocationOffset(localView));
        break label1668;
        j = 0;
        break label1687;
        j = i3;
        break label1728;
        i = 0;
        break label1754;
      }
      label2028:
      mTotalLength += getPaddingLeft() + getPaddingRight();
      if ((localObject[1] == -1) && (localObject[0] == -1) && (localObject[2] == -1))
      {
        i5 = i;
        i2 = n;
        i3 = j;
        m = i1;
        if (localObject[3] == -1) {}
      }
      else
      {
        m = Math.max(i1, Math.max(localObject[3], Math.max(localObject[0], Math.max(localObject[1], localObject[2]))) + Math.max(arrayOfInt[3], Math.max(arrayOfInt[0], Math.max(arrayOfInt[1], arrayOfInt[2]))));
        i3 = j;
        i2 = n;
        i5 = i;
      }
    }
    do
    {
      do
      {
        i = m;
        if (i5 == 0)
        {
          i = m;
          if (i15 != 1073741824) {
            i = i2;
          }
        }
        setMeasuredDimension(0xFF000000 & i3 | i10, ViewCompat.resolveSizeAndState(Math.max(getPaddingTop() + getPaddingBottom() + i, getSuggestedMinimumHeight()), paramInt2, i3 << 16));
        if (k != 0) {
          forceUniformHeight(i14, paramInt1);
        }
        return;
        i6 = Math.max(m, i3);
        i5 = i;
        i2 = i6;
        i3 = j;
        m = i4;
      } while (!bool2);
      i5 = i;
      i2 = i6;
      i3 = j;
      m = i4;
    } while (i16 == 1073741824);
    i1 = 0;
    for (;;)
    {
      i5 = i;
      i2 = i6;
      i3 = j;
      m = i4;
      if (i1 >= i14) {
        break;
      }
      localObject = getVirtualChildAt(i1);
      if ((localObject != null) && (((View)localObject).getVisibility() != 8) && (getLayoutParamsweight > 0.0F)) {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(n, 1073741824), View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredHeight(), 1073741824));
      }
      i1 += 1;
    }
  }
  
  int measureNullChild(int paramInt)
  {
    return 0;
  }
  
  void measureVertical(int paramInt1, int paramInt2)
  {
    mTotalLength = 0;
    int k = 0;
    int j = 0;
    int n = 0;
    int i3 = 0;
    int i = 1;
    float f1 = 0.0F;
    int i13 = getVirtualChildCount();
    int i14 = View.MeasureSpec.getMode(paramInt1);
    int i15 = View.MeasureSpec.getMode(paramInt2);
    int m = 0;
    int i2 = 0;
    int i16 = mBaselineAlignedChildIndex;
    boolean bool = mUseLargestChild;
    int i1 = Integer.MIN_VALUE;
    int i4 = 0;
    View localView;
    int i6;
    float f2;
    int i7;
    LayoutParams localLayoutParams;
    while (i4 < i13)
    {
      localView = getVirtualChildAt(i4);
      if (localView == null)
      {
        mTotalLength += measureNullChild(i4);
        i4 += 1;
      }
      else
      {
        int i12 = i;
        int i10 = n;
        int i11 = j;
        i5 = i1;
        int i9 = m;
        i8 = k;
        i6 = i2;
        f2 = f1;
        i7 = i3;
        if (localView.getVisibility() != 8)
        {
          if (hasDividerBeforeChildAt(i4)) {
            mTotalLength += mDividerHeight;
          }
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          f2 = f1 + weight;
          if ((i15 == 1073741824) && (height == 0) && (weight > 0.0F))
          {
            i2 = mTotalLength;
            mTotalLength = Math.max(i2, topMargin + i2 + bottomMargin);
            i6 = 1;
            i5 = i1;
            if ((i16 >= 0) && (i16 == i4 + 1)) {
              mBaselineChildTop = mTotalLength;
            }
            if ((i4 < i16) && (weight > 0.0F)) {
              throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
            }
          }
          else
          {
            i6 = Integer.MIN_VALUE;
            i5 = i6;
            if (height == 0)
            {
              i5 = i6;
              if (weight > 0.0F)
              {
                i5 = 0;
                height = -2;
              }
            }
            if (f2 == 0.0F) {}
            for (i6 = mTotalLength;; i6 = 0)
            {
              measureChildBeforeLayout(localView, i4, paramInt1, 0, paramInt2, i6);
              if (i5 != Integer.MIN_VALUE) {
                height = i5;
              }
              i7 = localView.getMeasuredHeight();
              i5 = mTotalLength;
              mTotalLength = Math.max(i5, i5 + i7 + topMargin + bottomMargin + getNextLocationOffset(localView));
              i5 = i1;
              i6 = i2;
              if (!bool) {
                break;
              }
              i5 = Math.max(i7, i1);
              i6 = i2;
              break;
            }
          }
          i7 = 0;
          i1 = m;
          i2 = i7;
          if (i14 != 1073741824)
          {
            i1 = m;
            i2 = i7;
            if (width == -1)
            {
              i1 = 1;
              i2 = 1;
            }
          }
          m = leftMargin + rightMargin;
          i7 = localView.getMeasuredWidth() + m;
          i8 = Math.max(k, i7);
          i11 = ViewUtils.combineMeasuredStates(j, ViewCompat.getMeasuredState(localView));
          if ((i == 0) || (width != -1)) {
            break label659;
          }
          i = 1;
          label572:
          if (weight <= 0.0F) {
            break label672;
          }
          if (i2 == 0) {
            break label665;
          }
        }
        for (;;)
        {
          i7 = Math.max(i3, m);
          i9 = i1;
          i10 = n;
          i12 = i;
          i4 += getChildrenSkipCount(localView, i4);
          i = i12;
          n = i10;
          j = i11;
          i1 = i5;
          m = i9;
          k = i8;
          i2 = i6;
          f1 = f2;
          i3 = i7;
          break;
          label659:
          i = 0;
          break label572;
          label665:
          m = i7;
        }
        label672:
        if (i2 != 0) {}
        for (;;)
        {
          i10 = Math.max(n, m);
          i12 = i;
          i9 = i1;
          i7 = i3;
          break;
          m = i7;
        }
      }
    }
    if ((mTotalLength > 0) && (hasDividerBeforeChildAt(i13))) {
      mTotalLength += mDividerHeight;
    }
    if ((bool) && ((i15 == Integer.MIN_VALUE) || (i15 == 0)))
    {
      mTotalLength = 0;
      i4 = 0;
      if (i4 < i13)
      {
        localView = getVirtualChildAt(i4);
        if (localView == null) {
          mTotalLength += measureNullChild(i4);
        }
        for (;;)
        {
          i4 += 1;
          break;
          if (localView.getVisibility() == 8)
          {
            i4 += getChildrenSkipCount(localView, i4);
          }
          else
          {
            localLayoutParams = (LayoutParams)localView.getLayoutParams();
            i5 = mTotalLength;
            mTotalLength = Math.max(i5, i5 + i1 + topMargin + bottomMargin + getNextLocationOffset(localView));
          }
        }
      }
    }
    mTotalLength += getPaddingTop() + getPaddingBottom();
    int i8 = ViewCompat.resolveSizeAndState(Math.max(mTotalLength, getSuggestedMinimumHeight()), paramInt2, 0);
    int i5 = (0xFFFFFF & i8) - mTotalLength;
    if ((i2 != 0) || ((i5 != 0) && (f1 > 0.0F)))
    {
      if (mWeightSum > 0.0F)
      {
        f1 = mWeightSum;
        mTotalLength = 0;
        i4 = 0;
        i3 = i5;
        label976:
        if (i4 >= i13) {
          break label1382;
        }
        localView = getVirtualChildAt(i4);
        i7 = i;
        i6 = n;
        i1 = j;
        i2 = i3;
        i5 = k;
        f2 = f1;
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          float f3 = weight;
          i1 = j;
          i2 = i3;
          f2 = f1;
          if (f3 > 0.0F)
          {
            i1 = (int)(i3 * f3 / f1);
            f2 = f1 - f3;
            i2 = i3 - i1;
            i5 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + leftMargin + rightMargin, width);
            if ((height == 0) && (i15 == 1073741824)) {
              break label1349;
            }
            i3 = localView.getMeasuredHeight() + i1;
            i1 = i3;
            if (i3 < 0) {
              i1 = 0;
            }
            label1152:
            localView.measure(i5, View.MeasureSpec.makeMeasureSpec(i1, 1073741824));
            i1 = ViewUtils.combineMeasuredStates(j, ViewCompat.getMeasuredState(localView) & 0xFF00);
          }
          i3 = leftMargin + rightMargin;
          i6 = localView.getMeasuredWidth() + i3;
          i5 = Math.max(k, i6);
          if ((i14 == 1073741824) || (width != -1)) {
            break label1363;
          }
          j = 1;
          label1233:
          if (j == 0) {
            break label1369;
          }
          j = i3;
          label1242:
          i6 = Math.max(n, j);
          if ((i == 0) || (width != -1)) {
            break label1376;
          }
        }
      }
      label1349:
      label1363:
      label1369:
      label1376:
      for (i = 1;; i = 0)
      {
        j = mTotalLength;
        mTotalLength = Math.max(j, localView.getMeasuredHeight() + j + topMargin + bottomMargin + getNextLocationOffset(localView));
        i7 = i;
        i4 += 1;
        i = i7;
        n = i6;
        j = i1;
        i3 = i2;
        k = i5;
        f1 = f2;
        break label976;
        break;
        if (i1 > 0) {
          break label1152;
        }
        i1 = 0;
        break label1152;
        j = 0;
        break label1233;
        j = i6;
        break label1242;
      }
      label1382:
      mTotalLength += getPaddingTop() + getPaddingBottom();
      i2 = k;
      i3 = j;
      i4 = i;
    }
    do
    {
      do
      {
        i = i2;
        if (i4 == 0)
        {
          i = i2;
          if (i14 != 1073741824) {
            i = n;
          }
        }
        setMeasuredDimension(ViewCompat.resolveSizeAndState(Math.max(getPaddingLeft() + getPaddingRight() + i, getSuggestedMinimumWidth()), paramInt1, i3), i8);
        if (m != 0) {
          forceUniformWidth(i13, paramInt2);
        }
        return;
        i6 = Math.max(n, i3);
        i4 = i;
        n = i6;
        i3 = j;
        i2 = k;
      } while (!bool);
      i4 = i;
      n = i6;
      i3 = j;
      i2 = k;
    } while (i15 == 1073741824);
    i5 = 0;
    for (;;)
    {
      i4 = i;
      n = i6;
      i3 = j;
      i2 = k;
      if (i5 >= i13) {
        break;
      }
      localView = getVirtualChildAt(i5);
      if ((localView != null) && (localView.getVisibility() != 8) && (getLayoutParamsweight > 0.0F)) {
        localView.measure(View.MeasureSpec.makeMeasureSpec(localView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i1, 1073741824));
      }
      i5 += 1;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (mDivider == null) {
      return;
    }
    if (mOrientation == 1)
    {
      drawDividersVertical(paramCanvas);
      return;
    }
    drawDividersHorizontal(paramCanvas);
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (mOrientation == 1)
    {
      layoutVertical(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    layoutHorizontal(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (mOrientation == 1)
    {
      measureVertical(paramInt1, paramInt2);
      return;
    }
    measureHorizontal(paramInt1, paramInt2);
  }
  
  public void setBaselineAligned(boolean paramBoolean)
  {
    mBaselineAligned = paramBoolean;
  }
  
  public void setBaselineAlignedChildIndex(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getChildCount())) {
      throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }
    mBaselineAlignedChildIndex = paramInt;
  }
  
  public void setDividerDrawable(Drawable paramDrawable)
  {
    boolean bool = false;
    if (paramDrawable == mDivider) {
      return;
    }
    mDivider = paramDrawable;
    if (paramDrawable != null) {
      mDividerWidth = paramDrawable.getIntrinsicWidth();
    }
    for (mDividerHeight = paramDrawable.getIntrinsicHeight();; mDividerHeight = 0)
    {
      if (paramDrawable == null) {
        bool = true;
      }
      setWillNotDraw(bool);
      requestLayout();
      return;
      mDividerWidth = 0;
    }
  }
  
  public void setDividerPadding(int paramInt)
  {
    mDividerPadding = paramInt;
  }
  
  public void setGravity(int paramInt)
  {
    if (mGravity != paramInt)
    {
      int i = paramInt;
      if ((0x800007 & paramInt) == 0) {
        i = paramInt | 0x800003;
      }
      paramInt = i;
      if ((i & 0x70) == 0) {
        paramInt = i | 0x30;
      }
      mGravity = paramInt;
      requestLayout();
    }
  }
  
  public void setHorizontalGravity(int paramInt)
  {
    paramInt &= 0x800007;
    if ((mGravity & 0x800007) != paramInt)
    {
      mGravity = (mGravity & 0xFF7FFFF8 | paramInt);
      requestLayout();
    }
  }
  
  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    mUseLargestChild = paramBoolean;
  }
  
  public void setOrientation(int paramInt)
  {
    if (mOrientation != paramInt)
    {
      mOrientation = paramInt;
      requestLayout();
    }
  }
  
  public void setShowDividers(int paramInt)
  {
    if (paramInt != mShowDividers) {
      requestLayout();
    }
    mShowDividers = paramInt;
  }
  
  public void setVerticalGravity(int paramInt)
  {
    paramInt &= 0x70;
    if ((mGravity & 0x70) != paramInt)
    {
      mGravity = (mGravity & 0xFFFFFF8F | paramInt);
      requestLayout();
    }
  }
  
  public void setWeightSum(float paramFloat)
  {
    mWeightSum = Math.max(0.0F, paramFloat);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int gravity = -1;
    public float weight;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      weight = 0.0F;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LinearLayoutCompat_Layout);
      weight = paramContext.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0F);
      gravity = paramContext.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.LinearLayoutCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */