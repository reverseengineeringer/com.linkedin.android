package com.linkedin.android.artdeco.components;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.linkedin.android.artdeco.R.color;
import com.linkedin.android.artdeco.R.dimen;
import com.linkedin.android.artdeco.R.styleable;

public class HorizontalViewPagerCarousel
  extends View
{
  private static final int FILL_COLOR_ID = R.color.ad_black_70;
  private static final int INVERSE_FILL_COLOR_ID = R.color.ad_white_solid;
  private static final int SELECTED_SIZE_DP = R.dimen.ad_horizontal_view_pager_carousel_dot_selected_size;
  private static final int SEPARATOR_SPACING_ID = R.dimen.ad_item_spacing_2;
  private static final int UNSELECTED_SIZE_DP = R.dimen.ad_horizontal_view_pager_carousel_dot_unselected_size;
  private PagerAdapter adapter;
  private int fillColor = getResources().getColor(FILL_COLOR_ID);
  private int maximumNumberOfPages = Integer.MAX_VALUE;
  private int pageCount;
  private final DataSetObserver pageCountObserver = new DataSetObserver()
  {
    public final void onChanged()
    {
      HorizontalViewPagerCarousel localHorizontalViewPagerCarousel = HorizontalViewPagerCarousel.this;
      if (adapter == null) {}
      for (int i = 0;; i = adapter.getCount())
      {
        localHorizontalViewPagerCarousel.setPageCount(i);
        return;
      }
    }
  };
  private final ViewPager.OnPageChangeListener pageListener = new ViewPager.OnPageChangeListener()
  {
    public final void onPageScrollStateChanged(int paramAnonymousInt) {}
    
    public final void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
    
    public final void onPageSelected(int paramAnonymousInt)
    {
      HorizontalViewPagerCarousel.this.setSelectedPosition(paramAnonymousInt);
    }
  };
  private ViewPager pager;
  private final Paint paint = new Paint(1);
  private final float selectedDiameter = getResources().getDimension(SELECTED_SIZE_DP);
  private int selectedPosition;
  private final float spacing = getResources().getDimension(SEPARATOR_SPACING_ID);
  private final float unselectedDiameter = getResources().getDimension(UNSELECTED_SIZE_DP);
  
  public HorizontalViewPagerCarousel(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null, 0);
  }
  
  public HorizontalViewPagerCarousel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HorizontalViewPagerCarousel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet, paramInt);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    if (isInEditMode()) {
      return;
    }
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.HorizontalViewPagerCarousel, paramInt, 0);
      boolean bool = paramContext.getBoolean(R.styleable.HorizontalViewPagerCarousel_ad_invert_color, false);
      paramAttributeSet = getResources();
      if (!bool) {
        break label71;
      }
    }
    label71:
    for (paramInt = INVERSE_FILL_COLOR_ID;; paramInt = FILL_COLOR_ID)
    {
      fillColor = paramAttributeSet.getColor(paramInt);
      paramContext.recycle();
      paint.setStyle(Paint.Style.FILL);
      return;
    }
  }
  
  private void setPageCount(int paramInt)
  {
    if (pageCount != paramInt)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      pageCount = i;
      if (pageCount > maximumNumberOfPages) {
        pageCount = maximumNumberOfPages;
      }
      requestLayout();
    }
  }
  
  private void setPagerAdapter(PagerAdapter paramPagerAdapter)
  {
    if (adapter == paramPagerAdapter) {
      return;
    }
    if (adapter != null) {
      adapter.unregisterDataSetObserver(pageCountObserver);
    }
    adapter = paramPagerAdapter;
    if (paramPagerAdapter != null) {
      paramPagerAdapter.registerDataSetObserver(pageCountObserver);
    }
    if (paramPagerAdapter == null) {}
    for (int i = 0;; i = paramPagerAdapter.getCount())
    {
      setPageCount(i);
      return;
    }
  }
  
  private void setSelectedPosition(int paramInt)
  {
    if (selectedPosition != paramInt)
    {
      selectedPosition = paramInt;
      if (selectedPosition >= maximumNumberOfPages) {
        selectedPosition = (maximumNumberOfPages - 1);
      }
      invalidate();
    }
  }
  
  public final void clearViewPager()
  {
    if (adapter != null)
    {
      adapter.unregisterDataSetObserver(pageCountObserver);
      adapter = null;
    }
    if (pager != null)
    {
      pager.removeOnPageChangeListener(pageListener);
      pager = null;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = 0;
    float f2;
    if (i < pageCount)
    {
      f2 = i;
      if (ViewCompat.getLayoutDirection(this) != 1) {
        break label187;
      }
    }
    label187:
    for (float f1 = pageCount - f2 - 1.0F;; f1 = f2)
    {
      float f3 = f1 * (spacing + unselectedDiameter) + ViewCompat.getPaddingStart(this) + unselectedDiameter / 2.0F;
      f1 = f3;
      if (selectedDiameter > unselectedDiameter) {
        f1 = f3 + Math.abs(unselectedDiameter - selectedDiameter) / 2.0F;
      }
      float f4 = Math.max(unselectedDiameter, selectedDiameter);
      f3 = getPaddingTop();
      f4 /= 2.0F;
      if (f2 == selectedPosition) {}
      for (f2 = selectedDiameter;; f2 = unselectedDiameter)
      {
        f2 /= 2.0F;
        paint.setColor(fillColor);
        paramCanvas.drawCircle(f1, f4 + f3, f2, paint);
        i += 1;
        break;
      }
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = getSuggestedMinimumWidth();
    int i = getSuggestedMinimumHeight();
    float f2 = pageCount * unselectedDiameter;
    float f1 = f2;
    if (selectedDiameter > unselectedDiameter) {
      f1 = f2 + Math.abs(unselectedDiameter - selectedDiameter) / 2.0F * 2.0F;
    }
    j = Math.max((int)Math.ceil(f1 + ((pageCount - 1) * spacing + (getPaddingLeft() + getPaddingRight()))), j);
    i = Math.max((int)Math.ceil(getPaddingTop() + getPaddingBottom() + Math.max(unselectedDiameter, selectedDiameter)), i);
    int m = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (m == 1073741824) {
      if (k != 1073741824) {
        break label199;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      if (m == Integer.MIN_VALUE)
      {
        paramInt1 = Math.min(j, paramInt1);
        break;
      }
      paramInt1 = j;
      break;
      label199:
      if (k == Integer.MIN_VALUE) {
        paramInt2 = Math.min(i, paramInt2);
      } else {
        paramInt2 = i;
      }
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      Object localObject = (Bundle)paramParcelable;
      setSelectedPosition(((Bundle)localObject).getInt("selectedPosition"));
      localObject = ((Bundle)localObject).getParcelable("superState");
      if (localObject != null)
      {
        super.onRestoreInstanceState((Parcelable)localObject);
        return;
      }
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("superState", super.onSaveInstanceState());
    localBundle.putInt("selectedPosition", selectedPosition);
    return localBundle;
  }
  
  public void setInvert(boolean paramBoolean)
  {
    Resources localResources = getResources();
    if (paramBoolean) {}
    for (int i = INVERSE_FILL_COLOR_ID;; i = FILL_COLOR_ID)
    {
      i = localResources.getColor(i);
      if (fillColor != i)
      {
        fillColor = i;
        invalidate();
      }
      return;
    }
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    setViewPager(paramViewPager, Integer.MAX_VALUE);
  }
  
  public final void setViewPager(ViewPager paramViewPager, int paramInt)
  {
    if (paramViewPager == pager) {
      return;
    }
    if (pager != null) {
      pager.removeOnPageChangeListener(pageListener);
    }
    pager = paramViewPager;
    if (paramViewPager != null) {
      paramViewPager.addOnPageChangeListener(pageListener);
    }
    maximumNumberOfPages = paramInt;
    if (paramViewPager == null)
    {
      paramInt = 0;
      setSelectedPosition(paramInt);
      if (paramViewPager != null) {
        break label80;
      }
    }
    label80:
    for (paramViewPager = null;; paramViewPager = paramViewPager.getAdapter())
    {
      setPagerAdapter(paramViewPager);
      return;
      paramInt = paramViewPager.getCurrentItem();
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */