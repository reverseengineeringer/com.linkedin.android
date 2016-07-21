package com.linkedin.android.growth.abi.m2m;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

final class AbiMemberContactViewModel$2
  extends TrackingOnClickListener
{
  AbiMemberContactViewModel$2(AbiMemberContactViewModel paramAbiMemberContactViewModel, Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, AbiMemberContactViewHolder paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this$0.onItemClickClosure.apply(null);
    val$holder.invitedText.setVisibility(0);
    val$holder.connectText.setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.m2m.AbiMemberContactViewModel.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */