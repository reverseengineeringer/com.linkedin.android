package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView
  extends AbsActionBarView
{
  public View mClose;
  private int mCloseItemLayout;
  private View mCustomView;
  private CharSequence mSubtitle;
  private int mSubtitleStyleRes;
  private TextView mSubtitleView;
  private CharSequence mTitle;
  private LinearLayout mTitleLayout;
  public boolean mTitleOptional;
  private int mTitleStyleRes;
  private TextView mTitleView;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.actionModeStyle);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = TintTypedArray.obtainStyledAttributes$89ace2b(paramContext, paramAttributeSet, R.styleable.ActionMode, paramInt);
    setBackgroundDrawable(paramContext.getDrawable(R.styleable.ActionMode_background));
    mTitleStyleRes = paramContext.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
    mSubtitleStyleRes = paramContext.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
    mContentHeight = paramContext.getLayoutDimension(R.styleable.ActionMode_height, 0);
    mCloseItemLayout = paramContext.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
    mWrapped.recycle();
  }
  
  private void initTitle()
  {
    int m = 8;
    if (mTitleLayout == null)
    {
      LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
      mTitleLayout = ((LinearLayout)getChildAt(getChildCount() - 1));
      mTitleView = ((TextView)mTitleLayout.findViewById(R.id.action_bar_title));
      mSubtitleView = ((TextView)mTitleLayout.findViewById(R.id.action_bar_subtitle));
      if (mTitleStyleRes != 0) {
        mTitleView.setTextAppearance(getContext(), mTitleStyleRes);
      }
      if (mSubtitleStyleRes != 0) {
        mSubtitleView.setTextAppearance(getContext(), mSubtitleStyleRes);
      }
    }
    mTitleView.setText(mTitle);
    mSubtitleView.setText(mSubtitle);
    int i;
    int j;
    label167:
    Object localObject;
    if (!TextUtils.isEmpty(mTitle))
    {
      i = 1;
      if (TextUtils.isEmpty(mSubtitle)) {
        break label234;
      }
      j = 1;
      localObject = mSubtitleView;
      if (j == 0) {
        break label239;
      }
    }
    label234:
    label239:
    for (int k = 0;; k = 8)
    {
      ((TextView)localObject).setVisibility(k);
      localObject = mTitleLayout;
      if (i == 0)
      {
        i = m;
        if (j == 0) {}
      }
      else
      {
        i = 0;
      }
      ((LinearLayout)localObject).setVisibility(i);
      if (mTitleLayout.getParent() == null) {
        addView(mTitleLayout);
      }
      return;
      i = 0;
      break;
      j = 0;
      break label167;
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle()
  {
    return mSubtitle;
  }
  
  public CharSequence getTitle()
  {
    return mTitle;
  }
  
  public final void initForMode(final ActionMode paramActionMode)
  {
    if (mClose == null)
    {
      mClose = LayoutInflater.from(getContext()).inflate(mCloseItemLayout, this, false);
      addView(mClose);
    }
    for (;;)
    {
      mClose.findViewById(R.id.action_mode_close_button).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramActionMode.finish();
        }
      });
      paramActionMode = (MenuBuilder)paramActionMode.getMenu();
      if (mActionMenuPresenter != null) {
        mActionMenuPresenter.dismissPopupMenus();
      }
      mActionMenuPresenter = new ActionMenuPresenter(getContext());
      mActionMenuPresenter.setReserveOverflow$1385ff();
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
      paramActionMode.addMenuPresenter(mActionMenuPresenter, mPopupContext);
      mMenuView = ((ActionMenuView)mActionMenuPresenter.getMenuView(this));
      mMenuView.setBackgroundDrawable(null);
      addView(mMenuView, localLayoutParams);
      return;
      if (mClose.getParent() == null) {
        addView(mClose);
      }
    }
  }
  
  public final void killMode()
  {
    removeAllViews();
    mCustomView = null;
    mMenuView = null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (mActionMenuPresenter != null)
    {
      mActionMenuPresenter.hideOverflowMenu();
      mActionMenuPresenter.hideSubMenus();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramAccessibilityEvent.setSource(this);
        paramAccessibilityEvent.setClassName(getClass().getName());
        paramAccessibilityEvent.setPackageName(getContext().getPackageName());
        paramAccessibilityEvent.setContentDescription(mTitle);
      }
    }
    else {
      return;
    }
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramBoolean = ViewUtils.isLayoutRtl(this);
    int i;
    int j;
    int k;
    Object localObject;
    if (paramBoolean)
    {
      i = paramInt3 - paramInt1 - getPaddingRight();
      j = getPaddingTop();
      k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
      paramInt2 = i;
      if (mClose != null)
      {
        paramInt2 = i;
        if (mClose.getVisibility() != 8)
        {
          localObject = (ViewGroup.MarginLayoutParams)mClose.getLayoutParams();
          if (!paramBoolean) {
            break label254;
          }
          paramInt2 = rightMargin;
          label89:
          if (!paramBoolean) {
            break label263;
          }
          paramInt4 = leftMargin;
          label100:
          paramInt2 = next(i, paramInt2, paramBoolean);
          paramInt2 = next(positionChild(mClose, paramInt2, j, k, paramBoolean) + paramInt2, paramInt4, paramBoolean);
        }
      }
      paramInt4 = paramInt2;
      if (mTitleLayout != null)
      {
        paramInt4 = paramInt2;
        if (mCustomView == null)
        {
          paramInt4 = paramInt2;
          if (mTitleLayout.getVisibility() != 8) {
            paramInt4 = paramInt2 + positionChild(mTitleLayout, paramInt2, j, k, paramBoolean);
          }
        }
      }
      if (mCustomView != null) {
        positionChild(mCustomView, paramInt4, j, k, paramBoolean);
      }
      if (!paramBoolean) {
        break label273;
      }
      paramInt1 = getPaddingLeft();
      label213:
      if (mMenuView != null)
      {
        localObject = mMenuView;
        if (paramBoolean) {
          break label286;
        }
      }
    }
    label254:
    label263:
    label273:
    label286:
    for (paramBoolean = true;; paramBoolean = false)
    {
      positionChild((View)localObject, paramInt1, j, k, paramBoolean);
      return;
      i = getPaddingLeft();
      break;
      paramInt2 = leftMargin;
      break label89;
      paramInt4 = rightMargin;
      break label100;
      paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
      break label213;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
    }
    int m = View.MeasureSpec.getSize(paramInt1);
    int i;
    int n;
    int k;
    int j;
    if (mContentHeight > 0)
    {
      i = mContentHeight;
      n = getPaddingTop() + getPaddingBottom();
      paramInt1 = m - getPaddingLeft() - getPaddingRight();
      k = i - n;
      j = View.MeasureSpec.makeMeasureSpec(k, Integer.MIN_VALUE);
      paramInt2 = paramInt1;
      Object localObject;
      if (mClose != null)
      {
        paramInt1 = measureChildView$1bb94239(mClose, paramInt1, j);
        localObject = (ViewGroup.MarginLayoutParams)mClose.getLayoutParams();
        paramInt2 = paramInt1 - (leftMargin + rightMargin);
      }
      paramInt1 = paramInt2;
      if (mMenuView != null)
      {
        paramInt1 = paramInt2;
        if (mMenuView.getParent() == this) {
          paramInt1 = measureChildView$1bb94239(mMenuView, paramInt2, j);
        }
      }
      paramInt2 = paramInt1;
      if (mTitleLayout != null)
      {
        paramInt2 = paramInt1;
        if (mCustomView == null)
        {
          if (!mTitleOptional) {
            break label490;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
          mTitleLayout.measure(paramInt2, j);
          int i1 = mTitleLayout.getMeasuredWidth();
          if (i1 > paramInt1) {
            break label478;
          }
          j = 1;
          label281:
          paramInt2 = paramInt1;
          if (j != 0) {
            paramInt2 = paramInt1 - i1;
          }
          localObject = mTitleLayout;
          if (j == 0) {
            break label484;
          }
          paramInt1 = 0;
          label306:
          ((LinearLayout)localObject).setVisibility(paramInt1);
        }
      }
      label312:
      if (mCustomView != null)
      {
        localObject = mCustomView.getLayoutParams();
        if (width == -2) {
          break label504;
        }
        paramInt1 = 1073741824;
        label342:
        if (width < 0) {
          break label511;
        }
        paramInt2 = Math.min(width, paramInt2);
        label360:
        if (height == -2) {
          break label514;
        }
        j = 1073741824;
        label375:
        if (height < 0) {
          break label522;
        }
        k = Math.min(height, k);
      }
    }
    label478:
    label484:
    label490:
    label504:
    label511:
    label514:
    label522:
    for (;;)
    {
      mCustomView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2, paramInt1), View.MeasureSpec.makeMeasureSpec(k, j));
      if (mContentHeight > 0) {
        break label533;
      }
      paramInt2 = 0;
      k = getChildCount();
      paramInt1 = 0;
      while (paramInt1 < k)
      {
        j = getChildAt(paramInt1).getMeasuredHeight() + n;
        i = paramInt2;
        if (j > paramInt2) {
          i = j;
        }
        paramInt1 += 1;
        paramInt2 = i;
      }
      i = View.MeasureSpec.getSize(paramInt2);
      break;
      j = 0;
      break label281;
      paramInt1 = 8;
      break label306;
      paramInt2 = measureChildView$1bb94239(mTitleLayout, paramInt1, j);
      break label312;
      paramInt1 = Integer.MIN_VALUE;
      break label342;
      break label360;
      j = Integer.MIN_VALUE;
      break label375;
    }
    setMeasuredDimension(m, paramInt2);
    return;
    label533:
    setMeasuredDimension(m, i);
  }
  
  public void setContentHeight(int paramInt)
  {
    mContentHeight = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    if (mCustomView != null) {
      removeView(mCustomView);
    }
    mCustomView = paramView;
    if ((paramView != null) && (mTitleLayout != null))
    {
      removeView(mTitleLayout);
      mTitleLayout = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    mSubtitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    mTitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != mTitleOptional) {
      requestLayout();
    }
    mTitleOptional = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public final boolean showOverflowMenu()
  {
    if (mActionMenuPresenter != null) {
      return mActionMenuPresenter.showOverflowMenu();
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionBarContextView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */