package android.support.v7.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

final class AlertController$AlertParams$1
  extends ArrayAdapter<CharSequence>
{
  AlertController$AlertParams$1(AlertController.AlertParams paramAlertParams, Context paramContext, int paramInt, CharSequence[] paramArrayOfCharSequence, ListView paramListView)
  {
    super(paramContext, paramInt, 16908308, paramArrayOfCharSequence);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    if ((this$0.mCheckedItems != null) && (this$0.mCheckedItems[paramInt] != 0)) {
      val$listView.setItemChecked(paramInt, true);
    }
    return paramView;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AlertController.AlertParams.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */