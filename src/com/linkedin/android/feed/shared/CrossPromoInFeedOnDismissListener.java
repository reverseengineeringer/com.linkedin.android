package com.linkedin.android.feed.shared;

import android.content.Context;
import android.content.DialogInterface;
import com.linkedin.android.axle.tracking.LegoTrackingUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingDialogOnDismissListener;
import com.linkedin.data.lite.BuilderException;

public final class CrossPromoInFeedOnDismissListener
  extends TrackingDialogOnDismissListener
{
  Context context;
  FlagshipDataManager dataManager;
  String legoTrackingId;
  String legoTrackingToken;
  
  public CrossPromoInFeedOnDismissListener(Tracker paramTracker, String paramString1, String paramString2, String paramString3, FragmentComponent paramFragmentComponent, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString1, paramVarArgs);
    dataManager = paramFragmentComponent.dataManager();
    context = paramFragmentComponent.appContext();
    legoTrackingId = paramString2;
    legoTrackingToken = paramString3;
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (legoTrackingId != null) {}
    try
    {
      LegoTrackingUtils.sendLegoWidgetActionEvent(dataManager, legoTrackingId, legoTrackingToken, ActionCategory.DISMISS);
      return;
    }
    catch (BuilderException paramDialogInterface)
    {
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create dismiss lego action event"));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.CrossPromoInFeedOnDismissListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */