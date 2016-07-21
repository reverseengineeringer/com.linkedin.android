package com.linkedin.android.identity.guidededit.infra.shared;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.View.MeasureSpec;
import com.linkedin.android.logger.Log;
import java.lang.reflect.Field;

@Deprecated
public class WrapContentLinearLayoutManager
  extends LinearLayoutManager
{
  private static final String TAG = WrapContentLinearLayoutManager.class.getSimpleName();
  private static boolean canMakeInsetsDirty = true;
  private static Field insetsDirtyField;
  private final int[] childDimensions = new int[2];
  private int childSize = 100;
  private boolean hasChildSize;
  private int maxHeight = Integer.MAX_VALUE;
  private int maxNumOfItems;
  private int overScrollMode = 0;
  private final Rect tmpRect = new Rect();
  private final RecyclerView view;
  
  public WrapContentLinearLayoutManager(Context paramContext)
  {
    super(paramContext);
    view = null;
  }
  
  public WrapContentLinearLayoutManager(Context paramContext, int paramInt)
  {
    this(paramContext, Integer.MAX_VALUE, paramInt);
  }
  
  public WrapContentLinearLayoutManager(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    mAutoMeasure = false;
    view = null;
    maxNumOfItems = paramInt1;
    maxHeight = paramInt2;
  }
  
  public WrapContentLinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt, paramBoolean);
    view = null;
  }
  
  public WrapContentLinearLayoutManager(RecyclerView paramRecyclerView)
  {
    super(paramRecyclerView.getContext());
    view = paramRecyclerView;
    overScrollMode = ViewCompat.getOverScrollMode(paramRecyclerView);
  }
  
  public WrapContentLinearLayoutManager(RecyclerView paramRecyclerView, int paramInt, boolean paramBoolean)
  {
    super(paramRecyclerView.getContext(), paramInt, paramBoolean);
    view = paramRecyclerView;
    overScrollMode = ViewCompat.getOverScrollMode(paramRecyclerView);
  }
  
  private static void makeInsetsDirty(RecyclerView.LayoutParams paramLayoutParams)
  {
    if (!canMakeInsetsDirty) {
      return;
    }
    try
    {
      if (insetsDirtyField == null)
      {
        Field localField = RecyclerView.LayoutParams.class.getDeclaredField("mInsetsDirty");
        insetsDirtyField = localField;
        localField.setAccessible(true);
      }
      insetsDirtyField.set(paramLayoutParams, Boolean.valueOf(true));
      return;
    }
    catch (NoSuchFieldException paramLayoutParams)
    {
      Log.e(TAG, "NoSuchFieldException parsing MiniProfile", paramLayoutParams);
      canMakeInsetsDirty = false;
      return;
    }
    catch (IllegalAccessException paramLayoutParams)
    {
      Log.e(TAG, "IllegalAccessException parsing MiniProfile", paramLayoutParams);
      canMakeInsetsDirty = false;
    }
  }
  
  private void measureChild(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    try
    {
      View localView = paramRecycler.getViewForPosition(paramInt1);
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
      paramInt1 = getPaddingLeft();
      int i = getPaddingRight();
      int j = getPaddingTop();
      int k = getPaddingBottom();
      int m = leftMargin;
      int n = rightMargin;
      int i1 = topMargin;
      int i2 = bottomMargin;
      makeInsetsDirty(localLayoutParams);
      calculateItemDecorationsForChild(localView, tmpRect);
      int i3 = getRightDecorationWidth(localView);
      int i4 = getLeftDecorationWidth(localView);
      int i5 = getTopDecorationHeight(localView);
      int i6 = getBottomDecorationHeight(localView);
      localView.measure(getChildMeasureSpec(paramInt2, paramInt1 + i + (m + n) + (i3 + i4), width, canScrollHorizontally()), getChildMeasureSpec(paramInt3, j + k + (i1 + i2) + (i5 + i6), height, canScrollVertically()));
      paramArrayOfInt[0] = (getDecoratedMeasuredWidth(localView) + leftMargin + rightMargin);
      paramArrayOfInt[1] = (getDecoratedMeasuredHeight(localView) + bottomMargin + topMargin);
      makeInsetsDirty(localLayoutParams);
      paramRecycler.recycleView(localView);
      return;
    }
    catch (IndexOutOfBoundsException paramRecycler) {}
  }
  
  public final void onMeasure(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    int i5 = View.MeasureSpec.getSize(paramInt1);
    int i6 = View.MeasureSpec.getSize(paramInt2);
    int k;
    int m;
    label42:
    int i2;
    label52:
    int n;
    label62:
    int i8;
    if (j != 0)
    {
      k = 1;
      if (i == 0) {
        break label95;
      }
      m = 1;
      if (j != 1073741824) {
        break label101;
      }
      i2 = 1;
      if (i != 1073741824) {
        break label107;
      }
      n = 1;
      i8 = View.MeasureSpec.makeMeasureSpec(0, 0);
      if ((i2 == 0) || (n == 0)) {
        break label113;
      }
      super.onMeasure(paramRecycler, paramState, paramInt1, paramInt2);
    }
    label95:
    label101:
    label107:
    label113:
    int i1;
    label142:
    int i7;
    int i3;
    label175:
    int i4;
    label178:
    label280:
    label288:
    label297:
    do
    {
      return;
      k = 0;
      break;
      m = 0;
      break label42;
      i2 = 0;
      break label52;
      n = 0;
      break label62;
      if (mOrientation != 1) {
        break label378;
      }
      i1 = 1;
      if ((childDimensions[0] == 0) && (childDimensions[1] == 0)) {
        break label384;
      }
      paramInt2 = 0;
      paramInt1 = 0;
      i7 = paramState.getItemCount();
      if ((maxNumOfItems <= 0) || (maxNumOfItems >= i7)) {
        break label431;
      }
      i3 = maxNumOfItems;
      i4 = 0;
      i = paramInt1;
      j = paramInt2;
      if (i4 < i3)
      {
        if (i1 == 0) {
          break label438;
        }
        if ((!hasChildSize) && (i4 < i7)) {
          measureChild(paramRecycler, i4, i5, i8, childDimensions);
        }
        paramInt1 += childDimensions[1];
        if (i4 == 0) {
          paramInt2 = childDimensions[0];
        }
        j = paramInt1;
        i = paramInt2;
        if (m == 0) {
          break label523;
        }
        j = paramInt1;
        i = paramInt2;
        if (paramInt1 < i6) {
          break label523;
        }
        j = paramInt2;
        i = paramInt1;
      }
      if (i2 == 0) {
        break label539;
      }
      paramInt1 = i5;
      if (n == 0) {
        break label572;
      }
      paramInt2 = i6;
      setMeasuredDimension(paramInt1, Math.min(paramInt2, maxHeight));
    } while ((view == null) || (overScrollMode != 1));
    if (((i1 != 0) && ((m == 0) || (paramInt2 < i6))) || ((i1 == 0) && ((k == 0) || (paramInt1 < i5))))
    {
      paramInt1 = 1;
      label361:
      paramRecycler = view;
      if (paramInt1 == 0) {
        break label612;
      }
    }
    label378:
    label384:
    label431:
    label438:
    label523:
    label539:
    label572:
    label612:
    for (paramInt1 = 2;; paramInt1 = 0)
    {
      ViewCompat.setOverScrollMode(paramRecycler, paramInt1);
      return;
      i1 = 0;
      break;
      if (i1 != 0)
      {
        childDimensions[0] = i5;
        childDimensions[1] = childSize;
        break label142;
      }
      childDimensions[0] = childSize;
      childDimensions[1] = i6;
      break label142;
      i3 = i7;
      break label175;
      if ((!hasChildSize) && (i4 < i7)) {
        measureChild(paramRecycler, i4, i8, i6, childDimensions);
      }
      paramInt2 += childDimensions[0];
      if (i4 == 0) {
        paramInt1 = childDimensions[1];
      }
      j = paramInt1;
      i = paramInt2;
      if (k != 0)
      {
        i = paramInt1;
        j = paramInt2;
        if (paramInt2 >= i5) {
          break label280;
        }
        i = paramInt2;
        j = paramInt1;
      }
      i4 += 1;
      paramInt1 = j;
      paramInt2 = i;
      break label178;
      paramInt2 = j + (getPaddingLeft() + getPaddingRight());
      paramInt1 = paramInt2;
      if (k == 0) {
        break label288;
      }
      paramInt1 = Math.min(paramInt2, i5);
      break label288;
      i += getPaddingTop() + getPaddingBottom();
      paramInt2 = i;
      if (m == 0) {
        break label297;
      }
      paramInt2 = Math.min(i, i6);
      break label297;
      paramInt1 = 0;
      break label361;
    }
  }
  
  public final void setOrientation(int paramInt)
  {
    if ((childDimensions != null) && (mOrientation != paramInt))
    {
      childDimensions[0] = 0;
      childDimensions[1] = 0;
    }
    super.setOrientation(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.infra.shared.WrapContentLinearLayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */