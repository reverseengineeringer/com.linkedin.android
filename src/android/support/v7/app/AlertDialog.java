package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public final class AlertDialog
  extends AppCompatDialog
  implements DialogInterface
{
  private AlertController mAlert = new AlertController(getContext(), this, getWindow());
  
  AlertDialog(Context paramContext, int paramInt)
  {
    super(paramContext, resolveDialogTheme(paramContext, paramInt));
  }
  
  static int resolveDialogTheme(Context paramContext, int paramInt)
  {
    if (paramInt >= 16777216) {
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(R.attr.alertDialogTheme, localTypedValue, true);
    return resourceId;
  }
  
  public final Button getButton(int paramInt)
  {
    AlertController localAlertController = mAlert;
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return mButtonPositive;
    case -2: 
      return mButtonNegative;
    }
    return mButtonNeutral;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AlertController localAlertController = mAlert;
    int i;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    label108:
    label114:
    label225:
    label360:
    label411:
    label460:
    label509:
    label515:
    label574:
    label591:
    int k;
    label607:
    int j;
    if ((mButtonPanelSideLayout != 0) && (mButtonPanelLayoutHint == 1))
    {
      i = mButtonPanelSideLayout;
      mDialog.setContentView(i);
      paramBundle = mWindow.findViewById(R.id.parentPanel);
      localObject4 = paramBundle.findViewById(R.id.topPanel);
      localObject3 = paramBundle.findViewById(R.id.contentPanel);
      localObject2 = paramBundle.findViewById(R.id.buttonPanel);
      localObject1 = (ViewGroup)paramBundle.findViewById(R.id.customPanel);
      if (mView == null) {
        break label833;
      }
      paramBundle = mView;
      if (paramBundle == null) {
        break label869;
      }
      i = 1;
      if ((i == 0) || (!AlertController.canTextInput(paramBundle))) {
        mWindow.setFlags(131072, 131072);
      }
      if (i == 0) {
        break label874;
      }
      Object localObject5 = (FrameLayout)mWindow.findViewById(R.id.custom);
      ((FrameLayout)localObject5).addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
      if (mViewSpacingSpecified) {
        ((FrameLayout)localObject5).setPadding(mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight, mViewSpacingBottom);
      }
      if (mListView != null) {
        getLayoutParamsweight = 0.0F;
      }
      paramBundle = ((ViewGroup)localObject1).findViewById(R.id.topPanel);
      View localView = ((ViewGroup)localObject1).findViewById(R.id.contentPanel);
      localObject5 = ((ViewGroup)localObject1).findViewById(R.id.buttonPanel);
      paramBundle = AlertController.resolvePanel(paramBundle, (View)localObject4);
      localObject3 = AlertController.resolvePanel(localView, (View)localObject3);
      localObject2 = AlertController.resolvePanel((View)localObject5, (View)localObject2);
      mScrollView = ((NestedScrollView)mWindow.findViewById(R.id.scrollView));
      mScrollView.setFocusable(false);
      mScrollView.setNestedScrollingEnabled(false);
      mMessageView = ((TextView)((ViewGroup)localObject3).findViewById(16908299));
      if (mMessageView != null)
      {
        if (mMessage == null) {
          break label884;
        }
        mMessageView.setText(mMessage);
      }
      i = 0;
      mButtonPositive = ((Button)((ViewGroup)localObject2).findViewById(16908313));
      mButtonPositive.setOnClickListener(mButtonHandler);
      if (!TextUtils.isEmpty(mButtonPositiveText)) {
        break label978;
      }
      mButtonPositive.setVisibility(8);
      mButtonNegative = ((Button)((ViewGroup)localObject2).findViewById(16908314));
      mButtonNegative.setOnClickListener(mButtonHandler);
      if (!TextUtils.isEmpty(mButtonNegativeText)) {
        break label1005;
      }
      mButtonNegative.setVisibility(8);
      mButtonNeutral = ((Button)((ViewGroup)localObject2).findViewById(16908315));
      mButtonNeutral.setOnClickListener(mButtonHandler);
      if (!TextUtils.isEmpty(mButtonNeutralText)) {
        break label1034;
      }
      mButtonNeutral.setVisibility(8);
      if (i == 0) {
        break label1063;
      }
      i = 1;
      if (i == 0) {
        ((ViewGroup)localObject2).setVisibility(8);
      }
      if (mCustomTitleView == null) {
        break label1068;
      }
      localObject4 = new ViewGroup.LayoutParams(-1, -2);
      paramBundle.addView(mCustomTitleView, 0, (ViewGroup.LayoutParams)localObject4);
      mWindow.findViewById(R.id.title_template).setVisibility(8);
      if ((localObject1 == null) || (((ViewGroup)localObject1).getVisibility() == 8)) {
        break label1277;
      }
      i = 1;
      if ((paramBundle == null) || (paramBundle.getVisibility() == 8)) {
        break label1282;
      }
      k = 1;
      if ((localObject2 == null) || (((ViewGroup)localObject2).getVisibility() == 8)) {
        break label1288;
      }
      j = 1;
      label624:
      if ((j == 0) && (localObject3 != null))
      {
        paramBundle = ((ViewGroup)localObject3).findViewById(R.id.textSpacerNoButtons);
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
      }
      if ((k != 0) && (mScrollView != null)) {
        mScrollView.setClipToPadding(true);
      }
      if (i == 0)
      {
        if (mListView == null) {
          break label1293;
        }
        paramBundle = mListView;
        label691:
        if (paramBundle != null)
        {
          if (k == 0) {
            break label1302;
          }
          i = 1;
          label702:
          if (j == 0) {
            break label1307;
          }
          j = 2;
          label708:
          i |= j;
          localObject1 = mWindow.findViewById(R.id.scrollIndicatorUp);
          localObject2 = mWindow.findViewById(R.id.scrollIndicatorDown);
          if (Build.VERSION.SDK_INT < 23) {
            break label1312;
          }
          ViewCompat.setScrollIndicators$17e143a3(paramBundle, i);
          if (localObject1 != null) {
            ((ViewGroup)localObject3).removeView((View)localObject1);
          }
          if (localObject2 != null) {
            ((ViewGroup)localObject3).removeView((View)localObject2);
          }
        }
      }
    }
    for (;;)
    {
      paramBundle = mListView;
      if ((paramBundle != null) && (mAdapter != null))
      {
        paramBundle.setAdapter(mAdapter);
        i = mCheckedItem;
        if (i >= 0)
        {
          paramBundle.setItemChecked(i, true);
          paramBundle.setSelection(i);
        }
      }
      return;
      i = mAlertDialogLayout;
      break;
      label833:
      if (mViewLayoutResId != 0)
      {
        paramBundle = LayoutInflater.from(mContext).inflate(mViewLayoutResId, (ViewGroup)localObject1, false);
        break label108;
      }
      paramBundle = null;
      break label108;
      label869:
      i = 0;
      break label114;
      label874:
      ((ViewGroup)localObject1).setVisibility(8);
      break label225;
      label884:
      mMessageView.setVisibility(8);
      mScrollView.removeView(mMessageView);
      if (mListView != null)
      {
        localObject4 = (ViewGroup)mScrollView.getParent();
        i = ((ViewGroup)localObject4).indexOfChild(mScrollView);
        ((ViewGroup)localObject4).removeViewAt(i);
        ((ViewGroup)localObject4).addView(mListView, i, new ViewGroup.LayoutParams(-1, -1));
        break label360;
      }
      ((ViewGroup)localObject3).setVisibility(8);
      break label360;
      label978:
      mButtonPositive.setText(mButtonPositiveText);
      mButtonPositive.setVisibility(0);
      i = 1;
      break label411;
      label1005:
      mButtonNegative.setText(mButtonNegativeText);
      mButtonNegative.setVisibility(0);
      i |= 0x2;
      break label460;
      label1034:
      mButtonNeutral.setText(mButtonNeutralText);
      mButtonNeutral.setVisibility(0);
      i |= 0x4;
      break label509;
      label1063:
      i = 0;
      break label515;
      label1068:
      mIconView = ((ImageView)mWindow.findViewById(16908294));
      if (!TextUtils.isEmpty(mTitle)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          mTitleView = ((TextView)mWindow.findViewById(R.id.alertTitle));
          mTitleView.setText(mTitle);
          if (mIconId != 0)
          {
            mIconView.setImageResource(mIconId);
            break;
            i = 0;
            continue;
          }
          if (mIcon != null)
          {
            mIconView.setImageDrawable(mIcon);
            break;
          }
          mTitleView.setPadding(mIconView.getPaddingLeft(), mIconView.getPaddingTop(), mIconView.getPaddingRight(), mIconView.getPaddingBottom());
          mIconView.setVisibility(8);
          break;
        }
      }
      mWindow.findViewById(R.id.title_template).setVisibility(8);
      mIconView.setVisibility(8);
      paramBundle.setVisibility(8);
      break label574;
      label1277:
      i = 0;
      break label591;
      label1282:
      k = 0;
      break label607;
      label1288:
      j = 0;
      break label624;
      label1293:
      paramBundle = mScrollView;
      break label691;
      label1302:
      i = 0;
      break label702;
      label1307:
      j = 0;
      break label708;
      label1312:
      paramBundle = (Bundle)localObject1;
      if (localObject1 != null)
      {
        paramBundle = (Bundle)localObject1;
        if ((i & 0x1) == 0)
        {
          ((ViewGroup)localObject3).removeView((View)localObject1);
          paramBundle = null;
        }
      }
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if ((i & 0x2) == 0)
        {
          ((ViewGroup)localObject3).removeView((View)localObject2);
          localObject1 = null;
        }
      }
      if ((paramBundle != null) || (localObject1 != null)) {
        if (mMessage != null)
        {
          mScrollView.setOnScrollChangeListener(new AlertController.2(localAlertController, paramBundle, (View)localObject1));
          mScrollView.post(new AlertController.3(localAlertController, paramBundle, (View)localObject1));
        }
        else if (mListView != null)
        {
          mListView.setOnScrollListener(new AlertController.4(localAlertController, paramBundle, (View)localObject1));
          mListView.post(new AlertController.5(localAlertController, paramBundle, (View)localObject1));
        }
        else
        {
          if (paramBundle != null) {
            ((ViewGroup)localObject3).removeView(paramBundle);
          }
          if (localObject1 != null) {
            ((ViewGroup)localObject3).removeView((View)localObject1);
          }
        }
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AlertController localAlertController = mAlert;
    if ((mScrollView != null) && (mScrollView.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AlertController localAlertController = mAlert;
    if ((mScrollView != null) && (mScrollView.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    mAlert.setTitle(paramCharSequence);
  }
  
  public static final class Builder
  {
    public final AlertController.AlertParams P;
    private int mTheme;
    
    public Builder(Context paramContext)
    {
      this(paramContext, AlertDialog.resolveDialogTheme(paramContext, 0));
    }
    
    public Builder(Context paramContext, int paramInt)
    {
      P = new AlertController.AlertParams(new ContextThemeWrapper(paramContext, AlertDialog.resolveDialogTheme(paramContext, paramInt)));
      mTheme = paramInt;
    }
    
    public final AlertDialog create()
    {
      AlertDialog localAlertDialog = new AlertDialog(P.mContext, mTheme);
      AlertController.AlertParams localAlertParams = P;
      AlertController localAlertController = mAlert;
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
}

/* Location:
 * Qualified Name:     android.support.v7.app.AlertDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */