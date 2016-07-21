package com.linkedin.android.growth.abi.m2m;

import android.view.View;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class AbiMemberContactViewModel$1
  extends TrackingOnClickListener
{
  AbiMemberContactViewModel$1(AbiMemberContactViewModel paramAbiMemberContactViewModel, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, AbiMemberContactViewHolder paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this$0.onItemClickClosure.apply(null);
    AbiMemberContactViewModel.setupInviteClickedButton(val$holder);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.m2m.AbiMemberContactViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */