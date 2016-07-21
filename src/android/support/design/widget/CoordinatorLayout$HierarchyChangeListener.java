package android.support.design.widget;

import android.view.View;
import android.view.ViewGroup.OnHierarchyChangeListener;

class CoordinatorLayout$HierarchyChangeListener
  implements ViewGroup.OnHierarchyChangeListener
{
  private CoordinatorLayout$HierarchyChangeListener(CoordinatorLayout paramCoordinatorLayout) {}
  
  public void onChildViewAdded(View paramView1, View paramView2)
  {
    if (CoordinatorLayout.access$300(this$0) != null) {
      CoordinatorLayout.access$300(this$0).onChildViewAdded(paramView1, paramView2);
    }
  }
  
  public void onChildViewRemoved(View paramView1, View paramView2)
  {
    this$0.dispatchDependentViewRemoved(paramView2);
    if (CoordinatorLayout.access$300(this$0) != null) {
      CoordinatorLayout.access$300(this$0).onChildViewRemoved(paramView1, paramView2);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.HierarchyChangeListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */