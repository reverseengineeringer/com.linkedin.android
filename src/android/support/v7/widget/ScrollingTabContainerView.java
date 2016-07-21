package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.dimen;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.ActionBarPolicy;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public final class ScrollingTabContainerView
  extends HorizontalScrollView
  implements AdapterView.OnItemSelectedListener
{
  private static final Interpolator sAlphaInterpolator = new DecelerateInterpolator();
  private boolean mAllowCollapse;
  private int mContentHeight;
  int mMaxTabWidth;
  private int mSelectedTabIndex;
  int mStackedTabMaxWidth;
  private LinearLayoutCompat mTabLayout;
  Runnable mTabSelector;
  private Spinner mTabSpinner;
  
  private boolean isCollapsed()
  {
    return (mTabSpinner != null) && (mTabSpinner.getParent() == this);
  }
  
  private boolean performExpand()
  {
    if (!isCollapsed()) {
      return false;
    }
    removeView(mTabSpinner);
    addView(mTabLayout, new ViewGroup.LayoutParams(-2, -1));
    setTabSelected(mTabSpinner.getSelectedItemPosition());
    return false;
  }
  
  public final void animateToTab(int paramInt)
  {
    final View localView = mTabLayout.getChildAt(paramInt);
    if (mTabSelector != null) {
      removeCallbacks(mTabSelector);
    }
    mTabSelector = new Runnable()
    {
      public final void run()
      {
        int i = localView.getLeft();
        int j = (getWidth() - localView.getWidth()) / 2;
        smoothScrollTo(i - j, 0);
        mTabSelector = null;
      }
    };
    post(mTabSelector);
  }
  
  public final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (mTabSelector != null) {
      post(mTabSelector);
    }
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      super.onConfigurationChanged(paramConfiguration);
    }
    paramConfiguration = ActionBarPolicy.get(getContext());
    TypedArray localTypedArray = mContext.obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
    int j = localTypedArray.getLayoutDimension(R.styleable.ActionBar_height, 0);
    Resources localResources = mContext.getResources();
    int i = j;
    if (!paramConfiguration.hasEmbeddedTabs()) {
      i = Math.min(j, localResources.getDimensionPixelSize(R.dimen.abc_action_bar_stacked_max_height));
    }
    localTypedArray.recycle();
    setContentHeight(i);
    mStackedTabMaxWidth = mContext.getResources().getDimensionPixelSize(R.dimen.abc_action_bar_stacked_tab_max_width);
  }
  
  public final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (mTabSelector != null) {
      removeCallbacks(mTabSelector);
    }
  }
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    mTab.select();
  }
  
  public final void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    int i = View.MeasureSpec.getMode(paramInt1);
    boolean bool;
    if (i == 1073741824)
    {
      bool = true;
      setFillViewport(bool);
      int j = mTabLayout.getChildCount();
      if ((j <= 1) || ((i != 1073741824) && (i != Integer.MIN_VALUE))) {
        break label328;
      }
      if (j <= 2) {
        break label315;
      }
      mMaxTabWidth = ((int)(View.MeasureSpec.getSize(paramInt1) * 0.4F));
      label68:
      mMaxTabWidth = Math.min(mMaxTabWidth, mStackedTabMaxWidth);
      label83:
      i = View.MeasureSpec.makeMeasureSpec(mContentHeight, 1073741824);
      if ((bool) || (!mAllowCollapse)) {
        break label336;
      }
      label105:
      if (paramInt2 == 0) {
        break label349;
      }
      mTabLayout.measure(0, i);
      if (mTabLayout.getMeasuredWidth() <= View.MeasureSpec.getSize(paramInt1)) {
        break label341;
      }
      if (!isCollapsed())
      {
        if (mTabSpinner == null)
        {
          AppCompatSpinner localAppCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
          localAppCompatSpinner.setLayoutParams(new LinearLayoutCompat.LayoutParams(-2, -1));
          localAppCompatSpinner.setOnItemSelectedListener(this);
          mTabSpinner = localAppCompatSpinner;
        }
        removeView(mTabLayout);
        addView(mTabSpinner, new ViewGroup.LayoutParams(-2, -1));
        if (mTabSpinner.getAdapter() == null) {
          mTabSpinner.setAdapter(new TabAdapter((byte)0));
        }
        if (mTabSelector != null)
        {
          removeCallbacks(mTabSelector);
          mTabSelector = null;
        }
        mTabSpinner.setSelection(mSelectedTabIndex);
      }
    }
    for (;;)
    {
      paramInt2 = getMeasuredWidth();
      super.onMeasure(paramInt1, i);
      paramInt1 = getMeasuredWidth();
      if ((bool) && (paramInt2 != paramInt1)) {
        setTabSelected(mSelectedTabIndex);
      }
      return;
      bool = false;
      break;
      label315:
      mMaxTabWidth = (View.MeasureSpec.getSize(paramInt1) / 2);
      break label68;
      label328:
      mMaxTabWidth = -1;
      break label83;
      label336:
      paramInt2 = 0;
      break label105;
      label341:
      performExpand();
      continue;
      label349:
      performExpand();
    }
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public final void setAllowCollapse(boolean paramBoolean)
  {
    mAllowCollapse = paramBoolean;
  }
  
  public final void setContentHeight(int paramInt)
  {
    mContentHeight = paramInt;
    requestLayout();
  }
  
  public final void setTabSelected(int paramInt)
  {
    mSelectedTabIndex = paramInt;
    int j = mTabLayout.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = mTabLayout.getChildAt(i);
      if (i == paramInt) {}
      for (boolean bool = true;; bool = false)
      {
        localView.setSelected(bool);
        if (bool) {
          animateToTab(paramInt);
        }
        i += 1;
        break;
      }
    }
    if ((mTabSpinner != null) && (paramInt >= 0)) {
      mTabSpinner.setSelection(paramInt);
    }
  }
  
  private final class TabAdapter
    extends BaseAdapter
  {
    private TabAdapter() {}
    
    public final int getCount()
    {
      return mTabLayout.getChildCount();
    }
    
    public final Object getItem(int paramInt)
    {
      return mTabLayout.getChildAt(paramInt)).mTab;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        return ScrollingTabContainerView.access$300$468af5da(ScrollingTabContainerView.this, (ActionBar.Tab)getItem(paramInt));
      }
      paramViewGroup = (ScrollingTabContainerView.TabView)paramView;
      mTab = ((ActionBar.Tab)getItem(paramInt));
      paramViewGroup.update();
      return paramView;
    }
  }
  
  private final class TabView
    extends LinearLayoutCompat
    implements View.OnLongClickListener
  {
    private final int[] BG_ATTRS = { 16842964 };
    private View mCustomView;
    private ImageView mIconView;
    ActionBar.Tab mTab;
    private TextView mTextView;
    
    public TabView(Context paramContext, ActionBar.Tab paramTab)
    {
      super(null, R.attr.actionBarTabStyle);
      mTab = paramTab;
      this$1 = TintTypedArray.obtainStyledAttributes$89ace2b(paramContext, null, BG_ATTRS, R.attr.actionBarTabStyle);
      if (hasValue(0)) {
        setBackgroundDrawable(getDrawable(0));
      }
      mWrapped.recycle();
      setGravity(8388627);
      update();
    }
    
    public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.Tab.class.getName());
    }
    
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      if (Build.VERSION.SDK_INT >= 14) {
        paramAccessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
      }
    }
    
    public final boolean onLongClick(View paramView)
    {
      paramView = new int[2];
      getLocationOnScreen(paramView);
      Object localObject = getContext();
      int i = getWidth();
      int j = getHeight();
      int k = getResourcesgetDisplayMetricswidthPixels;
      localObject = Toast.makeText((Context)localObject, mTab.getContentDescription(), 0);
      ((Toast)localObject).setGravity(49, paramView[0] + i / 2 - k / 2, j);
      ((Toast)localObject).show();
      return true;
    }
    
    public final void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if ((mMaxTabWidth > 0) && (getMeasuredWidth() > mMaxTabWidth)) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(mMaxTabWidth, 1073741824), paramInt2);
      }
    }
    
    public final void setSelected(boolean paramBoolean)
    {
      if (isSelected() != paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean)) {
          sendAccessibilityEvent(4);
        }
        return;
      }
    }
    
    public final void update()
    {
      Object localObject1 = mTab;
      Object localObject2 = ((ActionBar.Tab)localObject1).getCustomView();
      if (localObject2 != null)
      {
        localObject1 = ((View)localObject2).getParent();
        if (localObject1 != this)
        {
          if (localObject1 != null) {
            ((ViewGroup)localObject1).removeView((View)localObject2);
          }
          addView((View)localObject2);
        }
        mCustomView = ((View)localObject2);
        if (mTextView != null) {
          mTextView.setVisibility(8);
        }
        if (mIconView != null)
        {
          mIconView.setVisibility(8);
          mIconView.setImageDrawable(null);
        }
        return;
      }
      if (mCustomView != null)
      {
        removeView(mCustomView);
        mCustomView = null;
      }
      Object localObject3 = ((ActionBar.Tab)localObject1).getIcon();
      localObject2 = ((ActionBar.Tab)localObject1).getText();
      int i;
      if (localObject3 != null)
      {
        Object localObject4;
        if (mIconView == null)
        {
          localObject4 = new ImageView(getContext());
          LinearLayoutCompat.LayoutParams localLayoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
          gravity = 16;
          ((ImageView)localObject4).setLayoutParams(localLayoutParams);
          addView((View)localObject4, 0);
          mIconView = ((ImageView)localObject4);
        }
        mIconView.setImageDrawable((Drawable)localObject3);
        mIconView.setVisibility(0);
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label365;
        }
        i = 1;
        label209:
        if (i == 0) {
          break label370;
        }
        if (mTextView == null)
        {
          localObject3 = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
          ((TextView)localObject3).setEllipsize(TextUtils.TruncateAt.END);
          localObject4 = new LinearLayoutCompat.LayoutParams(-2, -2);
          gravity = 16;
          ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
          addView((View)localObject3);
          mTextView = ((TextView)localObject3);
        }
        mTextView.setText((CharSequence)localObject2);
        mTextView.setVisibility(0);
      }
      for (;;)
      {
        if (mIconView != null) {
          mIconView.setContentDescription(((ActionBar.Tab)localObject1).getContentDescription());
        }
        if ((i != 0) || (TextUtils.isEmpty(((ActionBar.Tab)localObject1).getContentDescription()))) {
          break label397;
        }
        setOnLongClickListener(this);
        return;
        if (mIconView == null) {
          break;
        }
        mIconView.setVisibility(8);
        mIconView.setImageDrawable(null);
        break;
        label365:
        i = 0;
        break label209;
        label370:
        if (mTextView != null)
        {
          mTextView.setVisibility(8);
          mTextView.setText(null);
        }
      }
      label397:
      setOnLongClickListener(null);
      setLongClickable(false);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ScrollingTabContainerView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */