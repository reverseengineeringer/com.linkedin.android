package android.support.v7.widget;

import android.support.v7.app.ActionBar.Tab;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

final class ScrollingTabContainerView$TabAdapter
  extends BaseAdapter
{
  private ScrollingTabContainerView$TabAdapter(ScrollingTabContainerView paramScrollingTabContainerView) {}
  
  public final int getCount()
  {
    return ScrollingTabContainerView.access$200(this$0).getChildCount();
  }
  
  public final Object getItem(int paramInt)
  {
    return access$200this$0).getChildAt(paramInt)).mTab;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      return ScrollingTabContainerView.access$300$468af5da(this$0, (ActionBar.Tab)getItem(paramInt));
    }
    paramViewGroup = (ScrollingTabContainerView.TabView)paramView;
    mTab = ((ActionBar.Tab)getItem(paramInt));
    paramViewGroup.update();
    return paramView;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ScrollingTabContainerView.TabAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */