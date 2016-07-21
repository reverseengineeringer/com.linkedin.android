package com.linkedin.android.entities.group.transformers;

import android.view.View;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class GroupTransformer$1
  extends TrackingOnClickListener
{
  public GroupTransformer$1(Tracker paramTracker, String paramString1, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent, String paramString2, String paramVarArgs)
  {
    super(paramTracker, paramString1, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    GroupTransformer.access$000(val$fragmentComponent, val$groupName, val$groupId);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.transformers.GroupTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */