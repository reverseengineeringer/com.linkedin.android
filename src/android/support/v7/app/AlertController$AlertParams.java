package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public final class AlertController$AlertParams
{
  public ListAdapter mAdapter;
  public boolean mCancelable;
  public int mCheckedItem = -1;
  public boolean[] mCheckedItems;
  public final Context mContext;
  public Cursor mCursor;
  public View mCustomTitleView;
  public Drawable mIcon;
  public int mIconAttrId = 0;
  public int mIconId = 0;
  public final LayoutInflater mInflater;
  public String mIsCheckedColumn;
  public boolean mIsMultiChoice;
  public boolean mIsSingleChoice;
  public CharSequence[] mItems;
  public String mLabelColumn;
  public CharSequence mMessage;
  public DialogInterface.OnClickListener mNegativeButtonListener;
  public CharSequence mNegativeButtonText;
  public DialogInterface.OnClickListener mNeutralButtonListener;
  public CharSequence mNeutralButtonText;
  public DialogInterface.OnCancelListener mOnCancelListener;
  public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
  public DialogInterface.OnClickListener mOnClickListener;
  public DialogInterface.OnDismissListener mOnDismissListener;
  public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
  public DialogInterface.OnKeyListener mOnKeyListener;
  public DialogInterface.OnClickListener mPositiveButtonListener;
  public CharSequence mPositiveButtonText;
  public boolean mRecycleOnMeasure = true;
  public CharSequence mTitle;
  public View mView;
  public int mViewLayoutResId;
  public int mViewSpacingBottom;
  public int mViewSpacingLeft;
  public int mViewSpacingRight;
  public boolean mViewSpacingSpecified = false;
  public int mViewSpacingTop;
  
  public AlertController$AlertParams(Context paramContext)
  {
    mContext = paramContext;
    mCancelable = true;
    mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AlertController.AlertParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */