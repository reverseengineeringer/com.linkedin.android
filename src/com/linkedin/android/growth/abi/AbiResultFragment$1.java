package com.linkedin.android.growth.abi;

import android.view.View;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.List;

final class AbiResultFragment$1
  extends TrackingOnClickListener
{
  AbiResultFragment$1(AbiResultFragment paramAbiResultFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = this$0;
    List localList = this$0.contacts.memberContacts;
    paramView.trackLegoWidgetSecondaryAction(localList.size(), "connect");
    hasAnyContactBeenInvited = true;
    abiDataProvider.batchSendMemberInvitations$235b8adf(localList, Tracker.createPageInstanceHeader(paramView.getPageInstance()), contactsTrackingId);
    this$0.goNext();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiResultFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */