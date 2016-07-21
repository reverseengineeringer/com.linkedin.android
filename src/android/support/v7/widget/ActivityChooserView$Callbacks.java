package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.support.v4.view.ActionProvider;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.PopupWindow.OnDismissListener;
import java.util.List;

final class ActivityChooserView$Callbacks
  implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  public final void onClick(View paramView)
  {
    if (paramView == ActivityChooserView.access$700(this$0))
    {
      this$0.dismissPopup();
      paramView = access$000this$0).mDataModel.getDefaultActivity();
      int i = access$000this$0).mDataModel.getActivityIndex(paramView);
      paramView = access$000this$0).mDataModel.chooseActivity(i);
      if (paramView != null)
      {
        paramView.addFlags(524288);
        this$0.getContext().startActivity(paramView);
      }
      return;
    }
    if (paramView == ActivityChooserView.access$800(this$0))
    {
      ActivityChooserView.access$602(this$0, false);
      ActivityChooserView.access$500(this$0, ActivityChooserView.access$900(this$0));
      return;
    }
    throw new IllegalArgumentException();
  }
  
  public final void onDismiss()
  {
    if (ActivityChooserView.access$1000(this$0) != null) {
      ActivityChooserView.access$1000(this$0).onDismiss();
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
      ActivityChooserView.access$500(this$0, Integer.MAX_VALUE);
    }
    do
    {
      return;
      this$0.dismissPopup();
      if (!ActivityChooserView.access$600(this$0)) {
        break;
      }
    } while (paramInt <= 0);
    paramView = access$000this$0).mDataModel;
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
    if (access$000this$0).mShowDefaultActivity) {}
    for (;;)
    {
      ??? = access$000this$0).mDataModel.chooseActivity(paramInt);
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
    if (paramView == ActivityChooserView.access$700(this$0))
    {
      if (ActivityChooserView.access$000(this$0).getCount() > 0)
      {
        ActivityChooserView.access$602(this$0, true);
        ActivityChooserView.access$500(this$0, ActivityChooserView.access$900(this$0));
      }
      return true;
    }
    throw new IllegalArgumentException();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ActivityChooserView.Callbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */