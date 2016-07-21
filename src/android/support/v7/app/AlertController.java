package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.OnScrollChangeListener;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.styleable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.ref.WeakReference;

final class AlertController
{
  ListAdapter mAdapter;
  int mAlertDialogLayout;
  final View.OnClickListener mButtonHandler = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView == mButtonPositive) && (mButtonPositiveMessage != null)) {
        paramAnonymousView = Message.obtain(mButtonPositiveMessage);
      }
      for (;;)
      {
        if (paramAnonymousView != null) {
          paramAnonymousView.sendToTarget();
        }
        mHandler.obtainMessage(1, mDialog).sendToTarget();
        return;
        if ((paramAnonymousView == mButtonNegative) && (mButtonNegativeMessage != null)) {
          paramAnonymousView = Message.obtain(mButtonNegativeMessage);
        } else if ((paramAnonymousView == mButtonNeutral) && (mButtonNeutralMessage != null)) {
          paramAnonymousView = Message.obtain(mButtonNeutralMessage);
        } else {
          paramAnonymousView = null;
        }
      }
    }
  };
  Button mButtonNegative;
  Message mButtonNegativeMessage;
  CharSequence mButtonNegativeText;
  Button mButtonNeutral;
  Message mButtonNeutralMessage;
  CharSequence mButtonNeutralText;
  int mButtonPanelLayoutHint = 0;
  int mButtonPanelSideLayout;
  Button mButtonPositive;
  Message mButtonPositiveMessage;
  CharSequence mButtonPositiveText;
  int mCheckedItem = -1;
  final Context mContext;
  View mCustomTitleView;
  final AppCompatDialog mDialog;
  Handler mHandler;
  Drawable mIcon;
  int mIconId = 0;
  ImageView mIconView;
  int mListItemLayout;
  int mListLayout;
  ListView mListView;
  CharSequence mMessage;
  TextView mMessageView;
  int mMultiChoiceItemLayout;
  NestedScrollView mScrollView;
  int mSingleChoiceItemLayout;
  CharSequence mTitle;
  TextView mTitleView;
  View mView;
  int mViewLayoutResId;
  int mViewSpacingBottom;
  int mViewSpacingLeft;
  int mViewSpacingRight;
  boolean mViewSpacingSpecified = false;
  int mViewSpacingTop;
  final Window mWindow;
  
  public AlertController(Context paramContext, AppCompatDialog paramAppCompatDialog, Window paramWindow)
  {
    mContext = paramContext;
    mDialog = paramAppCompatDialog;
    mWindow = paramWindow;
    mHandler = new ButtonHandler(paramAppCompatDialog);
    paramContext = paramContext.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
    mAlertDialogLayout = paramContext.getResourceId(R.styleable.AlertDialog_android_layout, 0);
    mButtonPanelSideLayout = paramContext.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
    mListLayout = paramContext.getResourceId(R.styleable.AlertDialog_listLayout, 0);
    mMultiChoiceItemLayout = paramContext.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
    mSingleChoiceItemLayout = paramContext.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
    mListItemLayout = paramContext.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
    paramContext.recycle();
    paramAppCompatDialog.supportRequestWindowFeature(1);
  }
  
  static boolean canTextInput(View paramView)
  {
    if (paramView.onCheckIsTextEditor()) {
      return true;
    }
    if (!(paramView instanceof ViewGroup)) {
      return false;
    }
    paramView = (ViewGroup)paramView;
    int i = paramView.getChildCount();
    while (i > 0)
    {
      int j = i - 1;
      i = j;
      if (canTextInput(paramView.getChildAt(j))) {
        return true;
      }
    }
    return false;
  }
  
  static ViewGroup resolvePanel(View paramView1, View paramView2)
  {
    if (paramView1 == null)
    {
      paramView1 = paramView2;
      if ((paramView2 instanceof ViewStub)) {
        paramView1 = ((ViewStub)paramView2).inflate();
      }
      return (ViewGroup)paramView1;
    }
    if (paramView2 != null)
    {
      ViewParent localViewParent = paramView2.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView2);
      }
    }
    paramView2 = paramView1;
    if ((paramView1 instanceof ViewStub)) {
      paramView2 = ((ViewStub)paramView1).inflate();
    }
    return (ViewGroup)paramView2;
  }
  
  public final void setButton(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage)
  {
    if (paramOnClickListener != null) {
      paramMessage = mHandler.obtainMessage(paramInt, paramOnClickListener);
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Button does not exist");
    case -1: 
      mButtonPositiveText = paramCharSequence;
      mButtonPositiveMessage = paramMessage;
      return;
    case -2: 
      mButtonNegativeText = paramCharSequence;
      mButtonNegativeMessage = paramMessage;
      return;
    }
    mButtonNeutralText = paramCharSequence;
    mButtonNeutralMessage = paramMessage;
  }
  
  public final void setIcon(int paramInt)
  {
    mIcon = null;
    mIconId = paramInt;
    if (mIconView != null)
    {
      if (paramInt != 0)
      {
        mIconView.setVisibility(0);
        mIconView.setImageResource(mIconId);
      }
    }
    else {
      return;
    }
    mIconView.setVisibility(8);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    mTitle = paramCharSequence;
    if (mTitleView != null) {
      mTitleView.setText(paramCharSequence);
    }
  }
  
  public static final class AlertParams
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
    
    public AlertParams(Context paramContext)
    {
      mContext = paramContext;
      mCancelable = true;
      mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }
  }
  
  private static final class ButtonHandler
    extends Handler
  {
    private WeakReference<DialogInterface> mDialog;
    
    public ButtonHandler(DialogInterface paramDialogInterface)
    {
      mDialog = new WeakReference(paramDialogInterface);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (what)
      {
      case 0: 
      default: 
        return;
      case -3: 
      case -2: 
      case -1: 
        ((DialogInterface.OnClickListener)obj).onClick((DialogInterface)mDialog.get(), what);
        return;
      }
      ((DialogInterface)obj).dismiss();
    }
  }
  
  private static final class CheckedItemAdapter
    extends ArrayAdapter<CharSequence>
  {
    public CheckedItemAdapter(Context paramContext, int paramInt, CharSequence[] paramArrayOfCharSequence)
    {
      super(paramInt, 16908308, paramArrayOfCharSequence);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final boolean hasStableIds()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AlertController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */