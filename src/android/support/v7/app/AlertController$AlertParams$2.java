package android.support.v7.app;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListView;

final class AlertController$AlertParams$2
  extends CursorAdapter
{
  private final int mIsCheckedIndex;
  private final int mLabelIndex;
  
  AlertController$AlertParams$2(AlertController.AlertParams paramAlertParams, Context paramContext, Cursor paramCursor, ListView paramListView, AlertController paramAlertController)
  {
    super(paramContext, paramCursor, false);
    paramAlertParams = getCursor();
    mLabelIndex = paramAlertParams.getColumnIndexOrThrow(this$0.mLabelColumn);
    mIsCheckedIndex = paramAlertParams.getColumnIndexOrThrow(this$0.mIsCheckedColumn);
  }
  
  public final void bindView(View paramView, Context paramContext, Cursor paramCursor)
  {
    ((CheckedTextView)paramView.findViewById(16908308)).setText(paramCursor.getString(mLabelIndex));
    paramView = val$listView;
    int i = paramCursor.getPosition();
    if (paramCursor.getInt(mIsCheckedIndex) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setItemChecked(i, bool);
      return;
    }
  }
  
  public final View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return this$0.mInflater.inflate(val$dialog.mMultiChoiceItemLayout, paramViewGroup, false);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AlertController.AlertParams.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */