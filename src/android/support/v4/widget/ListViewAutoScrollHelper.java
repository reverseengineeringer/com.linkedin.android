package android.support.v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.ListView;

public final class ListViewAutoScrollHelper
  extends AutoScrollHelper
{
  private final ListView mTarget;
  
  public ListViewAutoScrollHelper(ListView paramListView)
  {
    super(paramListView);
    mTarget = paramListView;
  }
  
  public final boolean canTargetScrollVertically(int paramInt)
  {
    ListView localListView = mTarget;
    int i = localListView.getCount();
    if (i == 0) {}
    int j;
    int k;
    do
    {
      return false;
      j = localListView.getChildCount();
      k = localListView.getFirstVisiblePosition();
      if (paramInt <= 0) {
        break;
      }
    } while ((k + j >= i) && (localListView.getChildAt(j - 1).getBottom() <= localListView.getHeight()));
    do
    {
      return true;
      if (paramInt >= 0) {
        break;
      }
    } while ((k > 0) || (localListView.getChildAt(0).getTop() < 0));
    return false;
  }
  
  public final void scrollTargetBy$255f295(int paramInt)
  {
    ListView localListView = mTarget;
    if (Build.VERSION.SDK_INT >= 19) {
      localListView.scrollListBy(paramInt);
    }
    int i;
    View localView;
    do
    {
      do
      {
        return;
        i = localListView.getFirstVisiblePosition();
      } while (i == -1);
      localView = localListView.getChildAt(0);
    } while (localView == null);
    localListView.setSelectionFromTop(i, localView.getTop() - paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.ListViewAutoScrollHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */