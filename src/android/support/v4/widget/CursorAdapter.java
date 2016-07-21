package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class CursorAdapter
  extends BaseAdapter
  implements CursorFilter.CursorFilterClient, Filterable
{
  protected boolean mAutoRequery = true;
  protected ChangeObserver mChangeObserver;
  public Context mContext;
  public Cursor mCursor = null;
  protected CursorFilter mCursorFilter;
  protected DataSetObserver mDataSetObserver;
  protected boolean mDataValid = false;
  protected FilterQueryProvider mFilterQueryProvider;
  protected int mRowIDColumn;
  
  public CursorAdapter(Context paramContext)
  {
    mContext = paramContext;
    mRowIDColumn = -1;
    mChangeObserver = new ChangeObserver();
    mDataSetObserver = new MyDataSetObserver((byte)0);
  }
  
  public abstract void bindView$4693bf34(View paramView, Cursor paramCursor);
  
  public void changeCursor(Cursor paramCursor)
  {
    if (paramCursor == mCursor) {
      paramCursor = null;
    }
    for (;;)
    {
      if (paramCursor != null) {
        paramCursor.close();
      }
      return;
      Cursor localCursor = mCursor;
      if (localCursor != null)
      {
        if (mChangeObserver != null) {
          localCursor.unregisterContentObserver(mChangeObserver);
        }
        if (mDataSetObserver != null) {
          localCursor.unregisterDataSetObserver(mDataSetObserver);
        }
      }
      mCursor = paramCursor;
      if (paramCursor != null)
      {
        if (mChangeObserver != null) {
          paramCursor.registerContentObserver(mChangeObserver);
        }
        if (mDataSetObserver != null) {
          paramCursor.registerDataSetObserver(mDataSetObserver);
        }
        mRowIDColumn = paramCursor.getColumnIndexOrThrow("_id");
        mDataValid = true;
        notifyDataSetChanged();
        paramCursor = localCursor;
      }
      else
      {
        mRowIDColumn = -1;
        mDataValid = false;
        notifyDataSetInvalidated();
        paramCursor = localCursor;
      }
    }
  }
  
  public CharSequence convertToString(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return "";
    }
    return paramCursor.toString();
  }
  
  public int getCount()
  {
    if ((mDataValid) && (mCursor != null)) {
      return mCursor.getCount();
    }
    return 0;
  }
  
  public final Cursor getCursor()
  {
    return mCursor;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (mDataValid)
    {
      mCursor.moveToPosition(paramInt);
      if (paramView == null) {
        paramView = newDropDownView(mContext, mCursor, paramViewGroup);
      }
      for (;;)
      {
        bindView$4693bf34(paramView, mCursor);
        return paramView;
      }
    }
    return null;
  }
  
  public Filter getFilter()
  {
    if (mCursorFilter == null) {
      mCursorFilter = new CursorFilter(this);
    }
    return mCursorFilter;
  }
  
  public Object getItem(int paramInt)
  {
    if ((mDataValid) && (mCursor != null))
    {
      mCursor.moveToPosition(paramInt);
      return mCursor;
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (mDataValid)
    {
      l1 = l2;
      if (mCursor != null)
      {
        l1 = l2;
        if (mCursor.moveToPosition(paramInt)) {
          l1 = mCursor.getLong(mRowIDColumn);
        }
      }
    }
    return l1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!mDataValid) {
      throw new IllegalStateException("this should only be called when the cursor is valid");
    }
    if (!mCursor.moveToPosition(paramInt)) {
      throw new IllegalStateException("couldn't move cursor to position " + paramInt);
    }
    if (paramView == null) {
      paramView = newView(mContext, mCursor, paramViewGroup);
    }
    for (;;)
    {
      bindView$4693bf34(paramView, mCursor);
      return paramView;
    }
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public View newDropDownView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return newView(paramContext, paramCursor, paramViewGroup);
  }
  
  public abstract View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  protected final void onContentChanged()
  {
    if ((mAutoRequery) && (mCursor != null) && (!mCursor.isClosed())) {
      mDataValid = mCursor.requery();
    }
  }
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence)
  {
    if (mFilterQueryProvider != null) {
      return mFilterQueryProvider.runQuery(paramCharSequence);
    }
    return mCursor;
  }
  
  private final class ChangeObserver
    extends ContentObserver
  {
    public ChangeObserver()
    {
      super();
    }
    
    public final boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public final void onChange(boolean paramBoolean)
    {
      onContentChanged();
    }
  }
  
  private final class MyDataSetObserver
    extends DataSetObserver
  {
    private MyDataSetObserver() {}
    
    public final void onChanged()
    {
      mDataValid = true;
      notifyDataSetChanged();
    }
    
    public final void onInvalidated()
    {
      mDataValid = false;
      notifyDataSetInvalidated();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.CursorAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */