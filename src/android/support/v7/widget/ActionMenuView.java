package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView
  extends LinearLayoutCompat
  implements MenuBuilder.ItemInvoker, MenuView
{
  private MenuPresenter.Callback mActionMenuPresenterCallback;
  private boolean mFormatItems;
  private int mFormatItemsWidth;
  private int mGeneratedItemPadding;
  MenuBuilder mMenu;
  private MenuBuilder.Callback mMenuBuilderCallback;
  private int mMinCellSize;
  private OnMenuItemClickListener mOnMenuItemClickListener;
  private Context mPopupContext;
  private int mPopupTheme;
  ActionMenuPresenter mPresenter;
  boolean mReserveOverflow;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f = getResourcesgetDisplayMetricsdensity;
    mMinCellSize = ((int)(56.0F * f));
    mGeneratedItemPadding = ((int)(4.0F * f));
    mPopupContext = paramContext;
    mPopupTheme = 0;
  }
  
  private static LayoutParams generateDefaultLayoutParams()
  {
    LayoutParams localLayoutParams = new LayoutParams();
    gravity = 16;
    return localLayoutParams;
  }
  
  private LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected static LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof LayoutParams)) {}
      for (paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);; paramLayoutParams = new LayoutParams(paramLayoutParams))
      {
        if (gravity <= 0) {
          gravity = 16;
        }
        return paramLayoutParams;
      }
    }
    return generateDefaultLayoutParams();
  }
  
  public static LayoutParams generateOverflowButtonLayoutParams()
  {
    LayoutParams localLayoutParams = generateDefaultLayoutParams();
    isOverflowButton = true;
    return localLayoutParams;
  }
  
  private boolean hasSupportDividerBeforeChildAt(int paramInt)
  {
    boolean bool2;
    if (paramInt == 0) {
      bool2 = false;
    }
    View localView2;
    boolean bool1;
    do
    {
      do
      {
        return bool2;
        View localView1 = getChildAt(paramInt - 1);
        localView2 = getChildAt(paramInt);
        bool2 = false;
        bool1 = bool2;
        if (paramInt < getChildCount())
        {
          bool1 = bool2;
          if ((localView1 instanceof ActionMenuChildView)) {
            bool1 = ((ActionMenuChildView)localView1).needsDividerAfter() | false;
          }
        }
        bool2 = bool1;
      } while (paramInt <= 0);
      bool2 = bool1;
    } while (!(localView2 instanceof ActionMenuChildView));
    return bool1 | ((ActionMenuChildView)localView2).needsDividerBefore();
  }
  
  static int measureChildForCells(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int j = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView))
    {
      localActionMenuItemView = (ActionMenuItemView)paramView;
      if ((localActionMenuItemView == null) || (!localActionMenuItemView.hasText())) {
        break label182;
      }
      paramInt4 = 1;
      label54:
      int i = 0;
      paramInt3 = i;
      if (paramInt2 > 0) {
        if (paramInt4 != 0)
        {
          paramInt3 = i;
          if (paramInt2 < 2) {}
        }
        else
        {
          paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, Integer.MIN_VALUE), j);
          i = paramView.getMeasuredWidth();
          paramInt3 = i / paramInt1;
          paramInt2 = paramInt3;
          if (i % paramInt1 != 0) {
            paramInt2 = paramInt3 + 1;
          }
          paramInt3 = paramInt2;
          if (paramInt4 != 0)
          {
            paramInt3 = paramInt2;
            if (paramInt2 < 2) {
              paramInt3 = 2;
            }
          }
        }
      }
      if ((isOverflowButton) || (paramInt4 == 0)) {
        break label188;
      }
    }
    label182:
    label188:
    for (boolean bool = true;; bool = false)
    {
      expandable = bool;
      cellsUsed = paramInt3;
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt3 * paramInt1, 1073741824), j);
      return paramInt3;
      localActionMenuItemView = null;
      break;
      paramInt4 = 0;
      break label54;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public final void dismissPopupMenus()
  {
    if (mPresenter != null) {
      mPresenter.dismissPopupMenus();
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  public Menu getMenu()
  {
    ActionMenuPresenter localActionMenuPresenter;
    if (mMenu == null)
    {
      localObject = getContext();
      mMenu = new MenuBuilder((Context)localObject);
      mMenu.setCallback(new MenuBuilderCallback((byte)0));
      mPresenter = new ActionMenuPresenter((Context)localObject);
      mPresenter.setReserveOverflow$1385ff();
      localActionMenuPresenter = mPresenter;
      if (mActionMenuPresenterCallback == null) {
        break label109;
      }
    }
    label109:
    for (Object localObject = mActionMenuPresenterCallback;; localObject = new ActionMenuPresenterCallback((byte)0))
    {
      mCallback = ((MenuPresenter.Callback)localObject);
      mMenu.addMenuPresenter(mPresenter, mPopupContext);
      mPresenter.setMenuView(this);
      return mMenu;
    }
  }
  
  public Drawable getOverflowIcon()
  {
    getMenu();
    ActionMenuPresenter localActionMenuPresenter = mPresenter;
    if (mOverflowButton != null) {
      return mOverflowButton.getDrawable();
    }
    if (mPendingOverflowIconSet) {
      return mPendingOverflowIcon;
    }
    return null;
  }
  
  public int getPopupTheme()
  {
    return mPopupTheme;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public final void initialize(MenuBuilder paramMenuBuilder)
  {
    mMenu = paramMenuBuilder;
  }
  
  public final boolean invokeItem(MenuItemImpl paramMenuItemImpl)
  {
    return mMenu.performItemAction(paramMenuItemImpl, null, 0);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    if (mPresenter != null)
    {
      mPresenter.updateMenuView(false);
      if (mPresenter.isOverflowMenuShowing())
      {
        mPresenter.hideOverflowMenu();
        mPresenter.showOverflowMenu();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    dismissPopupMenus();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!mFormatItems) {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    for (;;)
    {
      return;
      int i2 = getChildCount();
      int i1 = (paramInt4 - paramInt2) / 2;
      int i3 = getDividerWidth();
      paramInt4 = 0;
      int i = paramInt3 - paramInt1 - getPaddingRight() - getPaddingLeft();
      int k = 0;
      paramBoolean = ViewUtils.isLayoutRtl(this);
      int j = 0;
      View localView;
      LayoutParams localLayoutParams;
      if (j < i2)
      {
        localView = getChildAt(j);
        int m = k;
        int n = paramInt4;
        paramInt2 = i;
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (!isOverflowButton) {
            break label260;
          }
          k = localView.getMeasuredWidth();
          paramInt2 = k;
          if (hasSupportDividerBeforeChildAt(j)) {
            paramInt2 = k + i3;
          }
          n = localView.getMeasuredHeight();
          if (!paramBoolean) {
            break label234;
          }
          k = getPaddingLeft() + leftMargin;
          m = k + paramInt2;
          label177:
          int i4 = i1 - n / 2;
          localView.layout(k, i4, m, i4 + n);
          paramInt2 = i - paramInt2;
          m = 1;
          n = paramInt4;
        }
        for (;;)
        {
          j += 1;
          k = m;
          paramInt4 = n;
          i = paramInt2;
          break;
          label234:
          m = getWidth() - getPaddingRight() - rightMargin;
          k = m - paramInt2;
          break label177;
          label260:
          paramInt2 = i - (localView.getMeasuredWidth() + leftMargin + rightMargin);
          hasSupportDividerBeforeChildAt(j);
          n = paramInt4 + 1;
          m = k;
        }
      }
      if ((i2 == 1) && (k == 0))
      {
        localView = getChildAt(0);
        paramInt2 = localView.getMeasuredWidth();
        paramInt4 = localView.getMeasuredHeight();
        paramInt1 = (paramInt3 - paramInt1) / 2 - paramInt2 / 2;
        paramInt3 = i1 - paramInt4 / 2;
        localView.layout(paramInt1, paramInt3, paramInt1 + paramInt2, paramInt3 + paramInt4);
        return;
      }
      if (k != 0)
      {
        paramInt1 = 0;
        label376:
        paramInt1 = paramInt4 - paramInt1;
        if (paramInt1 <= 0) {
          break label538;
        }
      }
      label538:
      for (paramInt1 = i / paramInt1;; paramInt1 = 0)
      {
        paramInt4 = Math.max(0, paramInt1);
        if (!paramBoolean) {
          break label543;
        }
        paramInt2 = getWidth() - getPaddingRight();
        paramInt1 = 0;
        while (paramInt1 < i2)
        {
          localView = getChildAt(paramInt1);
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          paramInt3 = paramInt2;
          if (localView.getVisibility() != 8)
          {
            paramInt3 = paramInt2;
            if (!isOverflowButton)
            {
              paramInt2 -= rightMargin;
              paramInt3 = localView.getMeasuredWidth();
              i = localView.getMeasuredHeight();
              j = i1 - i / 2;
              localView.layout(paramInt2 - paramInt3, j, paramInt2, j + i);
              paramInt3 = paramInt2 - (leftMargin + paramInt3 + paramInt4);
            }
          }
          paramInt1 += 1;
          paramInt2 = paramInt3;
        }
        break;
        paramInt1 = 1;
        break label376;
      }
      label543:
      paramInt2 = getPaddingLeft();
      paramInt1 = 0;
      while (paramInt1 < i2)
      {
        localView = getChildAt(paramInt1);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        paramInt3 = paramInt2;
        if (localView.getVisibility() != 8)
        {
          paramInt3 = paramInt2;
          if (!isOverflowButton)
          {
            paramInt2 += leftMargin;
            paramInt3 = localView.getMeasuredWidth();
            i = localView.getMeasuredHeight();
            j = i1 - i / 2;
            localView.layout(paramInt2, j, paramInt2 + paramInt3, j + i);
            paramInt3 = paramInt2 + (rightMargin + paramInt3 + paramInt4);
          }
        }
        paramInt1 += 1;
        paramInt2 = paramInt3;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool2 = mFormatItems;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {}
    int i;
    int j;
    int i7;
    int i6;
    int i4;
    int i8;
    int i9;
    for (boolean bool1 = true;; bool1 = false)
    {
      mFormatItems = bool1;
      if (bool2 != mFormatItems) {
        mFormatItemsWidth = 0;
      }
      i = View.MeasureSpec.getSize(paramInt1);
      if ((mFormatItems) && (mMenu != null) && (i != mFormatItemsWidth))
      {
        mFormatItemsWidth = i;
        mMenu.onItemsChanged(true);
      }
      j = getChildCount();
      if ((!mFormatItems) || (j <= 0)) {
        break label1304;
      }
      i7 = View.MeasureSpec.getMode(paramInt2);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      i6 = View.MeasureSpec.getSize(paramInt2);
      i = getPaddingLeft();
      j = getPaddingRight();
      i4 = getPaddingTop() + getPaddingBottom();
      i8 = getChildMeasureSpec(paramInt2, i4, -2);
      i9 = paramInt1 - (i + j);
      paramInt1 = i9 / mMinCellSize;
      paramInt2 = mMinCellSize;
      if (paramInt1 != 0) {
        break;
      }
      setMeasuredDimension(i9, 0);
      return;
    }
    int i10 = mMinCellSize + i9 % paramInt2 / paramInt1;
    paramInt2 = 0;
    int n = 0;
    int m = 0;
    int i1 = 0;
    int k = 0;
    long l1 = 0L;
    int i11 = getChildCount();
    int i2 = 0;
    Object localObject;
    LayoutParams localLayoutParams;
    label351:
    label369:
    int i3;
    label407:
    label418:
    long l2;
    if (i2 < i11)
    {
      localObject = getChildAt(i2);
      if (((View)localObject).getVisibility() == 8) {
        break label1438;
      }
      bool1 = localObject instanceof ActionMenuItemView;
      i1 += 1;
      if (bool1) {
        ((View)localObject).setPadding(mGeneratedItemPadding, 0, mGeneratedItemPadding, 0);
      }
      localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
      expanded = false;
      extraPixels = 0;
      cellsUsed = 0;
      expandable = false;
      leftMargin = 0;
      rightMargin = 0;
      if ((bool1) && (((ActionMenuItemView)localObject).hasText()))
      {
        bool1 = true;
        preventEdgeOffset = bool1;
        if (!isOverflowButton) {
          break label512;
        }
        i = 1;
        i3 = measureChildForCells((View)localObject, i10, i, i8, i4);
        n = Math.max(n, i3);
        if (!expandable) {
          break label1431;
        }
        i = m + 1;
        if (!isOverflowButton) {
          break label1424;
        }
        j = 1;
        paramInt1 -= i3;
        m = Math.max(paramInt2, ((View)localObject).getMeasuredHeight());
        if (i3 != 1) {
          break label1386;
        }
        l2 = 1 << i2;
        paramInt2 = m;
        k = paramInt1;
        m = i;
        i3 = j;
        l1 = l2 | l1;
        paramInt1 = i1;
        j = k;
        i = paramInt2;
        k = i3;
        paramInt2 = n;
      }
    }
    for (;;)
    {
      i2 += 1;
      i1 = paramInt1;
      paramInt1 = j;
      n = paramInt2;
      paramInt2 = i;
      break;
      bool1 = false;
      break label351;
      label512:
      i = paramInt1;
      break label369;
      long l3;
      if ((k != 0) && (i1 == 2))
      {
        i3 = 1;
        i = 0;
        i2 = paramInt1;
        paramInt1 = i;
        l3 = l1;
        if (m <= 0) {
          break label863;
        }
        l3 = l1;
        if (i2 <= 0) {
          break label863;
        }
        i = Integer.MAX_VALUE;
        l2 = 0L;
        j = 0;
        i4 = 0;
        label573:
        if (i4 >= i11) {
          break label697;
        }
        localObject = (LayoutParams)getChildAt(i4).getLayoutParams();
        if (!expandable) {
          break label1371;
        }
        if (cellsUsed >= i) {
          break label660;
        }
        j = cellsUsed;
        l2 = 1 << i4;
        i = 1;
      }
      for (;;)
      {
        int i5 = i4 + 1;
        i4 = j;
        j = i;
        i = i4;
        i4 = i5;
        break label573;
        i3 = 0;
        break;
        label660:
        if (cellsUsed == i)
        {
          l2 |= 1 << i4;
          i5 = j + 1;
          j = i;
          i = i5;
          continue;
          label697:
          l1 |= l2;
          l3 = l1;
          if (j <= i2)
          {
            j = 0;
            paramInt1 = i2;
            label721:
            if (j < i11)
            {
              localObject = getChildAt(j);
              localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
              if ((1 << j & l2) == 0L)
              {
                if (cellsUsed != i + 1) {
                  break label1368;
                }
                l1 |= 1 << j;
              }
            }
          }
          label863:
          label1029:
          label1032:
          label1140:
          label1208:
          label1211:
          label1214:
          label1304:
          label1362:
          label1368:
          for (;;)
          {
            j += 1;
            break label721;
            if ((i3 != 0) && (preventEdgeOffset) && (paramInt1 == 1)) {
              ((View)localObject).setPadding(mGeneratedItemPadding + i10, 0, mGeneratedItemPadding, 0);
            }
            cellsUsed += 1;
            expanded = true;
            paramInt1 -= 1;
            continue;
            i = 1;
            i2 = paramInt1;
            paramInt1 = i;
            break;
            float f2;
            float f1;
            if ((k == 0) && (i1 == 1))
            {
              i = 1;
              if ((i2 <= 0) || (l3 == 0L) || ((i2 >= i1 - 1) && (i == 0) && (n <= 1))) {
                break label1211;
              }
              float f3 = Long.bitCount(l3);
              f2 = f3;
              if (i != 0) {
                break label1362;
              }
              f1 = f3;
              if ((1L & l3) != 0L)
              {
                f1 = f3;
                if (!getChildAt0getLayoutParamspreventEdgeOffset) {
                  f1 = f3 - 0.5F;
                }
              }
              f2 = f1;
              if ((1 << i11 - 1 & l3) == 0L) {
                break label1362;
              }
              f2 = f1;
              if (getChildAt1getLayoutParamspreventEdgeOffset) {
                break label1362;
              }
            }
            for (f1 -= 0.5F;; f1 = f2)
            {
              if (f1 > 0.0F)
              {
                i = (int)(i2 * i10 / f1);
                j = 0;
                k = paramInt1;
                if (j >= i11) {
                  break label1214;
                }
                if ((1 << j & l3) == 0L) {
                  break label1208;
                }
                localObject = getChildAt(j);
                localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
                if (!(localObject instanceof ActionMenuItemView)) {
                  break label1140;
                }
                extraPixels = i;
                expanded = true;
                if ((j == 0) && (!preventEdgeOffset)) {
                  leftMargin = (-i / 2);
                }
                paramInt1 = 1;
              }
              for (;;)
              {
                j += 1;
                break label1032;
                i = 0;
                break;
                i = 0;
                break label1029;
                if (isOverflowButton)
                {
                  extraPixels = i;
                  expanded = true;
                  rightMargin = (-i / 2);
                  paramInt1 = 1;
                }
                else
                {
                  if (j != 0) {
                    leftMargin = (i / 2);
                  }
                  if (j != i11 - 1) {
                    rightMargin = (i / 2);
                  }
                }
              }
              k = paramInt1;
              if (k != 0)
              {
                paramInt1 = 0;
                while (paramInt1 < i11)
                {
                  localObject = getChildAt(paramInt1);
                  localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
                  if (expanded)
                  {
                    i = cellsUsed;
                    ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(extraPixels + i * i10, 1073741824), i8);
                  }
                  paramInt1 += 1;
                }
              }
              if (i7 != 1073741824) {}
              for (;;)
              {
                setMeasuredDimension(i9, paramInt2);
                return;
                i = 0;
                while (i < j)
                {
                  localObject = (LayoutParams)getChildAt(i).getLayoutParams();
                  rightMargin = 0;
                  leftMargin = 0;
                  i += 1;
                }
                super.onMeasure(paramInt1, paramInt2);
                return;
                paramInt2 = i6;
              }
            }
          }
        }
        else
        {
          label1371:
          i5 = i;
          i = j;
          j = i5;
        }
      }
      label1386:
      paramInt2 = i1;
      k = n;
      n = m;
      i1 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = k;
      m = i;
      k = j;
      i = n;
      j = i1;
      continue;
      label1424:
      j = k;
      break label418;
      label1431:
      i = m;
      break label407;
      label1438:
      i = paramInt2;
      j = paramInt1;
      paramInt2 = n;
      paramInt1 = i1;
    }
  }
  
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    mPresenter.mExpandedActionViewsExclusive = paramBoolean;
  }
  
  public final void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    mActionMenuPresenterCallback = paramCallback;
    mMenuBuilderCallback = paramCallback1;
  }
  
  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    mOnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    getMenu();
    ActionMenuPresenter localActionMenuPresenter = mPresenter;
    if (mOverflowButton != null)
    {
      mOverflowButton.setImageDrawable(paramDrawable);
      return;
    }
    mPendingOverflowIconSet = true;
    mPendingOverflowIcon = paramDrawable;
  }
  
  public void setOverflowReserved(boolean paramBoolean)
  {
    mReserveOverflow = paramBoolean;
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (mPopupTheme != paramInt)
    {
      mPopupTheme = paramInt;
      if (paramInt == 0) {
        mPopupContext = getContext();
      }
    }
    else
    {
      return;
    }
    mPopupContext = new ContextThemeWrapper(getContext(), paramInt);
  }
  
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    mPresenter = paramActionMenuPresenter;
    mPresenter.setMenuView(this);
  }
  
  public static abstract interface ActionMenuChildView
  {
    public abstract boolean needsDividerAfter();
    
    public abstract boolean needsDividerBefore();
  }
  
  private final class ActionMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    private ActionMenuPresenterCallback() {}
    
    public final void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
    
    public final boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      return false;
    }
  }
  
  public static class LayoutParams
    extends LinearLayoutCompat.LayoutParams
  {
    @ViewDebug.ExportedProperty
    public int cellsUsed;
    @ViewDebug.ExportedProperty
    public boolean expandable;
    boolean expanded;
    @ViewDebug.ExportedProperty
    public int extraPixels;
    @ViewDebug.ExportedProperty
    public boolean isOverflowButton;
    @ViewDebug.ExportedProperty
    public boolean preventEdgeOffset;
    
    public LayoutParams()
    {
      super(-2);
      isOverflowButton = false;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      isOverflowButton = isOverflowButton;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  private final class MenuBuilderCallback
    implements MenuBuilder.Callback
  {
    private MenuBuilderCallback() {}
    
    public final boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
    {
      return (mOnMenuItemClickListener != null) && (mOnMenuItemClickListener.onMenuItemClick(paramMenuItem));
    }
    
    public final void onMenuModeChange(MenuBuilder paramMenuBuilder)
    {
      if (mMenuBuilderCallback != null) {
        mMenuBuilderCallback.onMenuModeChange(paramMenuBuilder);
      }
    }
  }
  
  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActionMenuView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */