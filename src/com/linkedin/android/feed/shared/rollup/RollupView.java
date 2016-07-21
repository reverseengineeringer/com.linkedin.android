package com.linkedin.android.feed.shared.rollup;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.linkedin.android.R.styleable;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;
import com.linkedin.android.infra.shared.JellyBeanUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import java.util.ArrayList;
import java.util.List;

public class RollupView
  extends RecyclerView
{
  public ViewModelArrayAdapter<ViewModel> adapter;
  private int currentOrientation;
  private int itemPadding;
  private int itemSize;
  public int maxNumColumns = -1;
  public int rollupTotalCount;
  public final List<ViewModel> unellipsizedViewModels = new ArrayList();
  
  public RollupView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.RollupView, 0, 0);
    itemSize = paramAttributeSet.getDimensionPixelSize(0, ViewUtils.convertDpToPx(paramContext, 32));
    itemPadding = paramAttributeSet.getDimensionPixelSize(1, ViewUtils.convertDpToPx(paramContext, 8));
    paramAttributeSet.recycle();
    setOverScrollMode(2);
    addItemDecoration(new RollupViewItemPaddingDecoration(paramContext, itemPadding, (byte)0));
    setLayoutManager(new RollupViewLayoutManager(itemSize, itemPadding, (byte)0));
    setAdapter(new ViewModelArrayAdapter(paramContext, Util.getAppComponent(paramContext).mediaCenter(), new ArrayList()));
    currentOrientation = getResourcesgetConfigurationorientation;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (currentOrientation != orientation)
    {
      final ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      localViewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public final void onGlobalLayout()
        {
          int i = getWidth();
          if (val$oldWidth != i)
          {
            RollupView localRollupView = RollupView.this;
            List localList = RollupViewModelUtils.ellipsize(unellipsizedViewModels, maxNumColumns, rollupTotalCount);
            if (adapter != null)
            {
              adapter.setValues(localList);
              adapter.notifyDataSetChanged();
            }
            JellyBeanUtils.removeOnGlobalLayoutListener(localViewTreeObserver, this);
          }
        }
      });
      currentOrientation = orientation;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    if ((paramAdapter instanceof ViewModelArrayAdapter))
    {
      adapter = ((ViewModelArrayAdapter)paramAdapter);
      super.setAdapter(paramAdapter);
    }
    while (paramAdapter == null) {
      return;
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("Adapter must be a ViewModelArrayAdapter"));
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof RollupViewLayoutManager)) {
      super.setLayoutManager(paramLayoutManager);
    }
    while (paramLayoutManager == null) {
      return;
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("Layout manager must be a RollupViewLayoutManager"));
  }
  
  private static final class RollupViewItemPaddingDecoration
    extends RecyclerView.ItemDecoration
  {
    private Context context;
    private int inset;
    
    private RollupViewItemPaddingDecoration(Context paramContext, int paramInt)
    {
      context = paramContext;
      inset = paramInt;
    }
    
    public final void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      boolean bool = JellyBeanMr1Utils.isRTL(context);
      int i;
      if (bool)
      {
        i = 0;
        if (!bool) {
          break label53;
        }
      }
      label53:
      for (int j = inset;; j = 0)
      {
        if (RecyclerView.getChildAdapterPosition(paramView) != 0) {
          break label59;
        }
        paramRect.set(0, 0, 0, 0);
        return;
        i = inset;
        break;
      }
      label59:
      paramRect.set(i, 0, j, 0);
    }
  }
  
  private final class RollupViewLayoutManager
    extends RecyclerView.LayoutManager
  {
    private final int itemPadding;
    private final int itemSize;
    
    private RollupViewLayoutManager(int paramInt1, int paramInt2)
    {
      itemSize = paramInt1;
      itemPadding = paramInt2;
    }
    
    public final boolean canScrollHorizontally()
    {
      return false;
    }
    
    public final boolean canScrollVertically()
    {
      return false;
    }
    
    public final RecyclerView.LayoutParams generateDefaultLayoutParams()
    {
      return new RecyclerView.LayoutParams(-2, -2);
    }
    
    public final void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      detachAndScrapAttachedViews(paramRecycler);
      int m = Math.min(getItemCount(), maxNumColumns);
      int k;
      if (ViewCompat.getLayoutDirection(mRecyclerView) == 1)
      {
        i = mWidth - getPaddingRight();
        j = 0;
        while (j < m)
        {
          paramState = paramRecycler.getViewForPosition(j);
          addViewInt(paramState, -1, false);
          measureChild$17e143a3(paramState);
          k = i - getDecoratedMeasuredWidth(paramState);
          layoutDecorated(paramState, k, 0, i, paramState.getMeasuredHeight());
          j += 1;
          i = k;
        }
      }
      int i = getPaddingLeft();
      int j = 0;
      while (j < m)
      {
        paramState = paramRecycler.getViewForPosition(j);
        addViewInt(paramState, -1, false);
        measureChild$17e143a3(paramState);
        k = i + getDecoratedMeasuredWidth(paramState);
        layoutDecorated(paramState, i, 0, k, paramState.getMeasuredHeight());
        j += 1;
        i = k;
      }
    }
    
    public final void onMeasure(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
    {
      super.onMeasure(paramRecycler, paramState, paramInt1, paramInt2);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      paramInt2 = getPaddingLeft();
      int i = getPaddingRight();
      int j = itemSize;
      int k = itemPadding;
      RollupView.access$202(RollupView.this, (paramInt1 - (paramInt2 + i) - itemSize) / (j + k) + 1);
    }
    
    public final void smoothScrollToPosition$7d69765f(RecyclerView paramRecyclerView, int paramInt) {}
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.rollup.RollupView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */