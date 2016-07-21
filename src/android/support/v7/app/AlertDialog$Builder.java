package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public final class AlertDialog$Builder
{
  public final AlertController.AlertParams P;
  private int mTheme;
  
  public AlertDialog$Builder(Context paramContext)
  {
    this(paramContext, AlertDialog.resolveDialogTheme(paramContext, 0));
  }
  
  public AlertDialog$Builder(Context paramContext, int paramInt)
  {
    P = new AlertController.AlertParams(new ContextThemeWrapper(paramContext, AlertDialog.resolveDialogTheme(paramContext, paramInt)));
    mTheme = paramInt;
  }
  
  public final AlertDialog create()
  {
    AlertDialog localAlertDialog = new AlertDialog(P.mContext, mTheme);
    AlertController.AlertParams localAlertParams = P;
    AlertController localAlertController = AlertDialog.access$000(localAlertDialog);
    Object localObject;
    ListView localListView;
    label255:
    label296:
    label328:
    int i;
    if (mCustomTitleView != null)
    {
      mCustomTitleView = mCustomTitleView;
      if (mMessage != null)
      {
        localObject = mMessage;
        mMessage = ((CharSequence)localObject);
        if (mMessageView != null) {
          mMessageView.setText((CharSequence)localObject);
        }
      }
      if (mPositiveButtonText != null) {
        localAlertController.setButton(-1, mPositiveButtonText, mPositiveButtonListener, null);
      }
      if (mNegativeButtonText != null) {
        localAlertController.setButton(-2, mNegativeButtonText, mNegativeButtonListener, null);
      }
      if (mNeutralButtonText != null) {
        localAlertController.setButton(-3, mNeutralButtonText, mNeutralButtonListener, null);
      }
      if ((mItems != null) || (mCursor != null) || (mAdapter != null))
      {
        localListView = (ListView)mInflater.inflate(mListLayout, null);
        if (!mIsMultiChoice) {
          break label693;
        }
        if (mCursor != null) {
          break label665;
        }
        localObject = new AlertController.AlertParams.1(localAlertParams, mContext, mMultiChoiceItemLayout, mItems, localListView);
        mAdapter = ((ListAdapter)localObject);
        mCheckedItem = mCheckedItem;
        if (mOnClickListener == null) {
          break label809;
        }
        localListView.setOnItemClickListener(new AlertController.AlertParams.3(localAlertParams, localAlertController));
        if (mOnItemSelectedListener != null) {
          localListView.setOnItemSelectedListener(mOnItemSelectedListener);
        }
        if (!mIsSingleChoice) {
          break label838;
        }
        localListView.setChoiceMode(1);
        mListView = localListView;
      }
      if (mView == null) {
        break label880;
      }
      if (!mViewSpacingSpecified) {
        break label855;
      }
      localObject = mView;
      i = mViewSpacingLeft;
      int j = mViewSpacingTop;
      int k = mViewSpacingRight;
      int m = mViewSpacingBottom;
      mView = ((View)localObject);
      mViewLayoutResId = 0;
      mViewSpacingSpecified = true;
      mViewSpacingLeft = i;
      mViewSpacingTop = j;
      mViewSpacingRight = k;
      mViewSpacingBottom = m;
    }
    for (;;)
    {
      localAlertDialog.setCancelable(P.mCancelable);
      if (P.mCancelable) {
        localAlertDialog.setCanceledOnTouchOutside(true);
      }
      localAlertDialog.setOnCancelListener(P.mOnCancelListener);
      localAlertDialog.setOnDismissListener(P.mOnDismissListener);
      if (P.mOnKeyListener != null) {
        localAlertDialog.setOnKeyListener(P.mOnKeyListener);
      }
      return localAlertDialog;
      if (mTitle != null) {
        localAlertController.setTitle(mTitle);
      }
      if (mIcon != null)
      {
        localObject = mIcon;
        mIcon = ((Drawable)localObject);
        mIconId = 0;
        if (mIconView != null)
        {
          if (localObject == null) {
            break label652;
          }
          mIconView.setVisibility(0);
          mIconView.setImageDrawable((Drawable)localObject);
        }
      }
      for (;;)
      {
        if (mIconId != 0) {
          localAlertController.setIcon(mIconId);
        }
        if (mIconAttrId == 0) {
          break;
        }
        i = mIconAttrId;
        localObject = new TypedValue();
        mContext.getTheme().resolveAttribute(i, (TypedValue)localObject, true);
        localAlertController.setIcon(resourceId);
        break;
        label652:
        mIconView.setVisibility(8);
      }
      label665:
      localObject = new AlertController.AlertParams.2(localAlertParams, mContext, mCursor, localListView, localAlertController);
      break label255;
      label693:
      if (mIsSingleChoice) {}
      for (i = mSingleChoiceItemLayout;; i = mListItemLayout)
      {
        if (mCursor == null) {
          break label768;
        }
        localObject = new SimpleCursorAdapter(mContext, i, mCursor, new String[] { mLabelColumn }, new int[] { 16908308 });
        break;
      }
      label768:
      if (mAdapter != null)
      {
        localObject = mAdapter;
        break label255;
      }
      localObject = new AlertController.CheckedItemAdapter(mContext, i, mItems);
      break label255;
      label809:
      if (mOnCheckboxClickListener == null) {
        break label296;
      }
      localListView.setOnItemClickListener(new AlertController.AlertParams.4(localAlertParams, localListView, localAlertController));
      break label296;
      label838:
      if (!mIsMultiChoice) {
        break label328;
      }
      localListView.setChoiceMode(2);
      break label328;
      label855:
      mView = mView;
      mViewLayoutResId = 0;
      mViewSpacingSpecified = false;
      continue;
      label880:
      if (mViewLayoutResId != 0)
      {
        i = mViewLayoutResId;
        mView = null;
        mViewLayoutResId = i;
        mViewSpacingSpecified = false;
      }
    }
  }
  
  public final Builder setAdapter(ListAdapter paramListAdapter, DialogInterface.OnClickListener paramOnClickListener)
  {
    P.mAdapter = paramListAdapter;
    P.mOnClickListener = paramOnClickListener;
    return this;
  }
  
  public final Builder setCancelable(boolean paramBoolean)
  {
    P.mCancelable = paramBoolean;
    return this;
  }
  
  public final Builder setIcon$38a3bc68()
  {
    P.mIconId = 17301543;
    return this;
  }
  
  public final Builder setItems(CharSequence[] paramArrayOfCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    P.mItems = paramArrayOfCharSequence;
    P.mOnClickListener = paramOnClickListener;
    return this;
  }
  
  public final Builder setMessage(int paramInt)
  {
    P.mMessage = P.mContext.getText(paramInt);
    return this;
  }
  
  public final Builder setMessage(CharSequence paramCharSequence)
  {
    P.mMessage = paramCharSequence;
    return this;
  }
  
  public final Builder setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    P.mNegativeButtonText = P.mContext.getText(paramInt);
    P.mNegativeButtonListener = paramOnClickListener;
    return this;
  }
  
  public final Builder setNegativeButton(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    P.mNegativeButtonText = paramCharSequence;
    P.mNegativeButtonListener = paramOnClickListener;
    return this;
  }
  
  public final Builder setNeutralButton$2cf0b439()
  {
    P.mNeutralButtonText = P.mContext.getText(17039370);
    P.mNeutralButtonListener = null;
    return this;
  }
  
  public final Builder setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener)
  {
    P.mOnDismissListener = paramOnDismissListener;
    return this;
  }
  
  public final Builder setOnKeyListener(DialogInterface.OnKeyListener paramOnKeyListener)
  {
    P.mOnKeyListener = paramOnKeyListener;
    return this;
  }
  
  public final Builder setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    P.mPositiveButtonText = P.mContext.getText(paramInt);
    P.mPositiveButtonListener = paramOnClickListener;
    return this;
  }
  
  public final Builder setPositiveButton(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    P.mPositiveButtonText = paramCharSequence;
    P.mPositiveButtonListener = paramOnClickListener;
    return this;
  }
  
  public final Builder setSingleChoiceItems(CharSequence[] paramArrayOfCharSequence, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    P.mItems = paramArrayOfCharSequence;
    P.mOnClickListener = paramOnClickListener;
    P.mCheckedItem = paramInt;
    P.mIsSingleChoice = true;
    return this;
  }
  
  public final Builder setTitle(int paramInt)
  {
    P.mTitle = P.mContext.getText(paramInt);
    return this;
  }
  
  public final Builder setTitle(CharSequence paramCharSequence)
  {
    P.mTitle = paramCharSequence;
    return this;
  }
  
  public final Builder setView(View paramView)
  {
    P.mView = paramView;
    P.mViewLayoutResId = 0;
    P.mViewSpacingSpecified = false;
    return this;
  }
  
  public final AlertDialog show()
  {
    AlertDialog localAlertDialog = create();
    localAlertDialog.show();
    return localAlertDialog;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AlertDialog.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */