package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ResourceCursorAdapter
  extends CursorAdapter
{
  private int mDropDownLayout;
  private LayoutInflater mInflater;
  private int mLayout;
  
  public ResourceCursorAdapter(Context paramContext, int paramInt)
  {
    super(paramContext);
    mDropDownLayout = paramInt;
    mLayout = paramInt;
    mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  public final View newDropDownView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return mInflater.inflate(mDropDownLayout, paramViewGroup, false);
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
  {
    return mInflater.inflate(mLayout, paramViewGroup, false);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.ResourceCursorAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */