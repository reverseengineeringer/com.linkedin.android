package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ActionProvider;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.string;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.List;

public final class ActivityChooserView
  extends ViewGroup
{
  private final LinearLayoutCompat mActivityChooserContent;
  private final ActivityChooserViewAdapter mAdapter;
  private final Callbacks mCallbacks;
  private int mDefaultActionButtonContentDescription;
  private final FrameLayout mDefaultActivityButton;
  private final FrameLayout mExpandActivityOverflowButton;
  private final ImageView mExpandActivityOverflowButtonImage;
  private int mInitialActivityCount;
  private boolean mIsAttachedToWindow;
  private boolean mIsSelectingDefaultActivity;
  private final int mListPopupMaxWidth;
  private ListPopupWindow mListPopupWindow;
  private final DataSetObserver mModelDataSetOberver;
  private PopupWindow.OnDismissListener mOnDismissListener;
  private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
  ActionProvider mProvider;
  
  private ListPopupWindow getListPopupWindow()
  {
    if (mListPopupWindow == null)
    {
      mListPopupWindow = new ListPopupWindow(getContext());
      mListPopupWindow.setAdapter(mAdapter);
      mListPopupWindow.mDropDownAnchorView = this;
      mListPopupWindow.setModal$1385ff();
      mListPopupWindow.mItemClickListener = mCallbacks;
      mListPopupWindow.setOnDismissListener(mCallbacks);
    }
    return mListPopupWindow;
  }
  
  private boolean isShowingPopup()
  {
    return getListPopupWindowmPopup.isShowing();
  }
  
  private void showPopupUnchecked(int paramInt)
  {
    if (mAdapter.mDataModel == null) {
      throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }
    getViewTreeObserver().addOnGlobalLayoutListener(mOnGlobalLayoutListener);
    boolean bool;
    int i;
    label62:
    label93:
    ListPopupWindow localListPopupWindow;
    if (mDefaultActivityButton.getVisibility() == 0)
    {
      bool = true;
      int j = mAdapter.mDataModel.getActivityCount();
      if (!bool) {
        break label196;
      }
      i = 1;
      if ((paramInt == Integer.MAX_VALUE) || (j <= paramInt + i)) {
        break label201;
      }
      mAdapter.setShowFooterView(true);
      mAdapter.setMaxActivityCount(paramInt - 1);
      localListPopupWindow = getListPopupWindow();
      if (!mPopup.isShowing())
      {
        if ((!mIsSelectingDefaultActivity) && (bool)) {
          break label220;
        }
        mAdapter.setShowDefaultActivity(true, bool);
      }
    }
    for (;;)
    {
      localListPopupWindow.setContentWidth(Math.min(mAdapter.measureContentWidth(), mListPopupMaxWidth));
      localListPopupWindow.show();
      if (mProvider != null) {
        mProvider.subUiVisibilityChanged(true);
      }
      mDropDownList.setContentDescription(getContext().getString(R.string.abc_activitychooserview_choose_application));
      return;
      bool = false;
      break;
      label196:
      i = 0;
      break label62;
      label201:
      mAdapter.setShowFooterView(false);
      mAdapter.setMaxActivityCount(paramInt);
      break label93;
      label220:
      mAdapter.setShowDefaultActivity(false, false);
    }
  }
  
  public final boolean dismissPopup()
  {
    if (getListPopupWindowmPopup.isShowing())
    {
      getListPopupWindow().dismiss();
      ViewTreeObserver localViewTreeObserver = getViewTreeObserver();
      if (localViewTreeObserver.isAlive()) {
        localViewTreeObserver.removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
      }
    }
    return true;
  }
  
  public final ActivityChooserModel getDataModel()
  {
    return mAdapter.mDataModel;
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ActivityChooserModel localActivityChooserModel = mAdapter.mDataModel;
    if (localActivityChooserModel != null) {
      localActivityChooserModel.registerObserver(mModelDataSetOberver);
    }
    mIsAttachedToWindow = true;
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    Object localObject = mAdapter.mDataModel;
    if (localObject != null) {
      ((ActivityChooserModel)localObject).unregisterObserver(mModelDataSetOberver);
    }
    localObject = getViewTreeObserver();
    if (((ViewTreeObserver)localObject).isAlive()) {
      ((ViewTreeObserver)localObject).removeGlobalOnLayoutListener(mOnGlobalLayoutListener);
    }
    if (isShowingPopup()) {
      dismissPopup();
    }
    mIsAttachedToWindow = false;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    mActivityChooserContent.layout(0, 0, paramInt3 - paramInt1, paramInt4 - paramInt2);
    if (!isShowingPopup()) {
      dismissPopup();
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    LinearLayoutCompat localLinearLayoutCompat = mActivityChooserContent;
    int i = paramInt2;
    if (mDefaultActivityButton.getVisibility() != 0) {
      i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 1073741824);
    }
    measureChild(localLinearLayoutCompat, paramInt1, i);
    setMeasuredDimension(localLinearLayoutCompat.getMeasuredWidth(), localLinearLayoutCompat.getMeasuredHeight());
  }
  
  public final void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel)
  {
    ActivityChooserViewAdapter localActivityChooserViewAdapter = mAdapter;
    ActivityChooserModel localActivityChooserModel = this$0.mAdapter.mDataModel;
    if ((localActivityChooserModel != null) && (this$0.isShown())) {
      localActivityChooserModel.unregisterObserver(this$0.mModelDataSetOberver);
    }
    mDataModel = paramActivityChooserModel;
    if ((paramActivityChooserModel != null) && (this$0.isShown())) {
      paramActivityChooserModel.registerObserver(this$0.mModelDataSetOberver);
    }
    localActivityChooserViewAdapter.notifyDataSetChanged();
    if (getListPopupWindowmPopup.isShowing())
    {
      dismissPopup();
      if ((!getListPopupWindowmPopup.isShowing()) && (mIsAttachedToWindow)) {}
    }
    else
    {
      return;
    }
    mIsSelectingDefaultActivity = false;
    showPopupUnchecked(mInitialActivityCount);
  }
  
  public final void setDefaultActionButtonContentDescription(int paramInt)
  {
    mDefaultActionButtonContentDescription = paramInt;
  }
  
  public final void setExpandActivityOverflowButtonContentDescription(int paramInt)
  {
    String str = getContext().getString(paramInt);
    mExpandActivityOverflowButtonImage.setContentDescription(str);
  }
  
  public final void setExpandActivityOverflowButtonDrawable(Drawable paramDrawable)
  {
    mExpandActivityOverflowButtonImage.setImageDrawable(paramDrawable);
  }
  
  public final void setInitialActivityCount(int paramInt)
  {
    mInitialActivityCount = paramInt;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    mOnDismissListener = paramOnDismissListener;
  }
  
  public final void setProvider(ActionProvider paramActionProvider)
  {
    mProvider = paramActionProvider;
  }
  
  private final class ActivityChooserViewAdapter
    extends BaseAdapter
  {
    ActivityChooserModel mDataModel;
    private boolean mHighlightDefaultActivity;
    private int mMaxActivityCount;
    boolean mShowDefaultActivity;
    private boolean mShowFooterView;
    
    public final int getCount()
    {
      int j = mDataModel.getActivityCount();
      int i = j;
      if (!mShowDefaultActivity)
      {
        i = j;
        if (mDataModel.getDefaultActivity() != null) {
          i = j - 1;
        }
      }
      j = Math.min(i, mMaxActivityCount);
      i = j;
      if (mShowFooterView) {
        i = j + 1;
      }
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      switch (getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        return null;
      }
      int i = paramInt;
      if (!mShowDefaultActivity)
      {
        i = paramInt;
        if (mDataModel.getDefaultActivity() != null) {
          i = paramInt + 1;
        }
      }
      return mDataModel.getActivity(i);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      if ((mShowFooterView) && (paramInt == getCount() - 1)) {
        return 1;
      }
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView;
      switch (getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        if (paramView != null)
        {
          localView = paramView;
          if (paramView.getId() == 1) {}
        }
        else
        {
          localView = LayoutInflater.from(this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, paramViewGroup, false);
          localView.setId(1);
          ((TextView)localView.findViewById(R.id.title)).setText(this$0.getContext().getString(R.string.abc_activity_chooser_view_see_all));
        }
        return localView;
      }
      if (paramView != null)
      {
        localView = paramView;
        if (paramView.getId() == R.id.list_item) {}
      }
      else
      {
        localView = LayoutInflater.from(this$0.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, paramViewGroup, false);
      }
      paramView = this$0.getContext().getPackageManager();
      paramViewGroup = (ImageView)localView.findViewById(R.id.icon);
      ResolveInfo localResolveInfo = (ResolveInfo)getItem(paramInt);
      paramViewGroup.setImageDrawable(localResolveInfo.loadIcon(paramView));
      ((TextView)localView.findViewById(R.id.title)).setText(localResolveInfo.loadLabel(paramView));
      if ((mShowDefaultActivity) && (paramInt == 0) && (mHighlightDefaultActivity)) {
        ViewCompat.setActivated(localView, true);
      }
      for (;;)
      {
        return localView;
        ViewCompat.setActivated(localView, false);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 3;
    }
    
    public final int measureContentWidth()
    {
      int k = mMaxActivityCount;
      mMaxActivityCount = Integer.MAX_VALUE;
      int j = 0;
      View localView = null;
      int m = View.MeasureSpec.makeMeasureSpec(0, 0);
      int n = View.MeasureSpec.makeMeasureSpec(0, 0);
      int i1 = getCount();
      int i = 0;
      while (i < i1)
      {
        localView = getView(i, localView, null);
        localView.measure(m, n);
        j = Math.max(j, localView.getMeasuredWidth());
        i += 1;
      }
      mMaxActivityCount = k;
      return j;
    }
    
    public final void setMaxActivityCount(int paramInt)
    {
      if (mMaxActivityCount != paramInt)
      {
        mMaxActivityCount = paramInt;
        notifyDataSetChanged();
      }
    }
    
    public final void setShowDefaultActivity(boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((mShowDefaultActivity != paramBoolean1) || (mHighlightDefaultActivity != paramBoolean2))
      {
        mShowDefaultActivity = paramBoolean1;
        mHighlightDefaultActivity = paramBoolean2;
        notifyDataSetChanged();
      }
    }
    
    public final void setShowFooterView(boolean paramBoolean)
    {
      if (mShowFooterView != paramBoolean)
      {
        mShowFooterView = paramBoolean;
        notifyDataSetChanged();
      }
    }
  }
  
  private final class Callbacks
    implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
  {
    public final void onClick(View paramView)
    {
      if (paramView == this$0.mDefaultActivityButton)
      {
        this$0.dismissPopup();
        paramView = this$0.mAdapter.mDataModel.getDefaultActivity();
        int i = this$0.mAdapter.mDataModel.getActivityIndex(paramView);
        paramView = this$0.mAdapter.mDataModel.chooseActivity(i);
        if (paramView != null)
        {
          paramView.addFlags(524288);
          this$0.getContext().startActivity(paramView);
        }
        return;
      }
      if (paramView == this$0.mExpandActivityOverflowButton)
      {
        ActivityChooserView.access$602(this$0, false);
        this$0.showPopupUnchecked(this$0.mInitialActivityCount);
        return;
      }
      throw new IllegalArgumentException();
    }
    
    public final void onDismiss()
    {
      if (this$0.mOnDismissListener != null) {
        this$0.mOnDismissListener.onDismiss();
      }
      if (this$0.mProvider != null) {
        this$0.mProvider.subUiVisibilityChanged(false);
      }
    }
    
    public final void onItemClick(AdapterView<?> arg1, View paramView, int paramInt, long paramLong)
    {
      switch (((ActivityChooserView.ActivityChooserViewAdapter)???.getAdapter()).getItemViewType(paramInt))
      {
      default: 
        throw new IllegalArgumentException();
      case 1: 
        this$0.showPopupUnchecked(Integer.MAX_VALUE);
      }
      do
      {
        return;
        this$0.dismissPopup();
        if (!this$0.mIsSelectingDefaultActivity) {
          break;
        }
      } while (paramInt <= 0);
      paramView = this$0.mAdapter.mDataModel;
      for (;;)
      {
        synchronized (mInstanceLock)
        {
          paramView.ensureConsistentState();
          ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo1 = (ActivityChooserModel.ActivityResolveInfo)mActivities.get(paramInt);
          ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo2 = (ActivityChooserModel.ActivityResolveInfo)mActivities.get(0);
          if (localActivityResolveInfo2 != null)
          {
            f = weight - weight + 5.0F;
            paramView.addHisoricalRecord(new ActivityChooserModel.HistoricalRecord(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
            return;
          }
        }
        float f = 1.0F;
      }
      if (this$0.mAdapter.mShowDefaultActivity) {}
      for (;;)
      {
        ??? = this$0.mAdapter.mDataModel.chooseActivity(paramInt);
        if (??? == null) {
          break;
        }
        ???.addFlags(524288);
        this$0.getContext().startActivity(???);
        return;
        paramInt += 1;
      }
    }
    
    public final boolean onLongClick(View paramView)
    {
      if (paramView == this$0.mDefaultActivityButton)
      {
        if (this$0.mAdapter.getCount() > 0)
        {
          ActivityChooserView.access$602(this$0, true);
          this$0.showPopupUnchecked(this$0.mInitialActivityCount);
        }
        return true;
      }
      throw new IllegalArgumentException();
    }
  }
  
  public static class InnerLayout
    extends LinearLayoutCompat
  {
    private static final int[] TINT_ATTRS = { 16842964 };
    
    public InnerLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, TINT_ATTRS);
      setBackgroundDrawable(paramContext.getDrawable(0));
      mWrapped.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActivityChooserView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */