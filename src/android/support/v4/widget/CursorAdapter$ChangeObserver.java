package android.support.v4.widget;

import android.database.ContentObserver;
import android.os.Handler;

final class CursorAdapter$ChangeObserver
  extends ContentObserver
{
  public CursorAdapter$ChangeObserver(CursorAdapter paramCursorAdapter)
  {
    super(new Handler());
  }
  
  public final boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public final void onChange(boolean paramBoolean)
  {
    this$0.onContentChanged();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.CursorAdapter.ChangeObserver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */