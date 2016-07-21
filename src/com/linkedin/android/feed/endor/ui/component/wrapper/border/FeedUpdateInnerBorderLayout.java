package com.linkedin.android.feed.endor.ui.component.wrapper.border;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout.Borders;

public final class FeedUpdateInnerBorderLayout
  extends FeedComponentLayout<FeedUpdateInnerBorderViewHolder>
{
  private final FeedComponentLayout.Borders borders;
  private int bottomBorderPadding = -1;
  private int bottomBorderSize = -1;
  private boolean hasCalculatedPixels;
  private int leftBorderPadding = -1;
  private int leftBorderSize = -1;
  private int rightBorderPadding = -1;
  private int rightBorderSize = -1;
  private int topBorderPadding = -1;
  private int topBorderSize = -1;
  
  public FeedUpdateInnerBorderLayout(FeedComponentLayout.Borders paramBorders)
  {
    borders = paramBorders;
  }
  
  private static int getDp(DisplayMetrics paramDisplayMetrics, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramDisplayMetrics);
  }
  
  public final void applyBorders(FeedUpdateInnerBorderViewHolder paramFeedUpdateInnerBorderViewHolder)
  {
    if (!hasCalculatedPixels)
    {
      DisplayMetrics localDisplayMetrics = itemView.getResources().getDisplayMetrics();
      leftBorderSize = getDp(localDisplayMetrics, borders.left & 0xFFFF);
      leftBorderPadding = getDp(localDisplayMetrics, borders.left >>> 16);
      rightBorderSize = getDp(localDisplayMetrics, borders.right & 0xFFFF);
      rightBorderPadding = getDp(localDisplayMetrics, borders.right >>> 16);
      topBorderSize = getDp(localDisplayMetrics, borders.top & 0xFFFF);
      topBorderPadding = getDp(localDisplayMetrics, borders.top >>> 16);
      bottomBorderSize = getDp(localDisplayMetrics, borders.bottom & 0xFFFF);
      bottomBorderPadding = getDp(localDisplayMetrics, borders.bottom >>> 16);
      hasCalculatedPixels = true;
    }
    ((ViewGroup.MarginLayoutParams)itemView.getLayoutParams()).setMargins(leftBorderPadding, topBorderPadding, rightBorderPadding, bottomBorderPadding);
    ((ViewGroup.MarginLayoutParams)wrapperArea.getLayoutParams()).setMargins(leftBorderSize, topBorderSize, rightBorderSize, bottomBorderSize);
    if (leftBorderSize == 0)
    {
      leftBorder.setVisibility(8);
      if (rightBorderSize != 0) {
        break label357;
      }
      rightBorder.setVisibility(8);
      label257:
      if (topBorderSize != 0) {
        break label382;
      }
      topBorder.setVisibility(8);
      label273:
      if (bottomBorderSize != 0) {
        break label407;
      }
      bottomBorder.setVisibility(8);
    }
    for (;;)
    {
      itemView.requestLayout();
      wrapperArea.requestLayout();
      leftBorder.requestLayout();
      rightBorder.requestLayout();
      topBorder.requestLayout();
      bottomBorder.requestLayout();
      return;
      leftBorder.setVisibility(0);
      leftBorder.getLayoutParams().width = leftBorderSize;
      break;
      label357:
      rightBorder.setVisibility(0);
      rightBorder.getLayoutParams().width = rightBorderSize;
      break label257;
      label382:
      topBorder.setVisibility(0);
      topBorder.getLayoutParams().height = topBorderSize;
      break label273;
      label407:
      bottomBorder.setVisibility(0);
      bottomBorder.getLayoutParams().height = bottomBorderSize;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!getClass().equals(paramObject.getClass()))) {}
    do
    {
      return false;
      paramObject = (FeedUpdateInnerBorderLayout)paramObject;
    } while ((this != paramObject) && (!borders.equals(borders)));
    return true;
  }
  
  public final int hashCode()
  {
    return borders.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.wrapper.border.FeedUpdateInnerBorderLayout
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */