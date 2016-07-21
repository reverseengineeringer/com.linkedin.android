package com.linkedin.android.growth.abi;

import android.view.View;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class AbiResultFragment$2
  extends TrackingOnClickListener
{
  AbiResultFragment$2(AbiResultFragment paramAbiResultFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    if (this$0.contacts.guestContacts != null) {
      this$0.inviteAllGuestContacts(this$0.contacts.guestContacts);
    }
    this$0.goNext();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiResultFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */