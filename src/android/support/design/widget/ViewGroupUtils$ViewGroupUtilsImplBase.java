package android.support.design.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

class ViewGroupUtils$ViewGroupUtilsImplBase
  implements ViewGroupUtils.ViewGroupUtilsImpl
{
  public void offsetDescendantRect(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    paramViewGroup.offsetDescendantRectToMyCoords(paramView, paramRect);
    paramRect.offset(paramView.getScrollX(), paramView.getScrollY());
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.ViewGroupUtils.ViewGroupUtilsImplBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */