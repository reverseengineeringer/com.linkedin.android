package com.linkedin.android.entities.group.transformers;

import com.linkedin.android.entities.group.GroupDataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.group.Group;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipStatus;
import java.util.Map;

final class GroupTransformer$3
  extends TrackingClosure<Boolean, Void>
{
  GroupTransformer$3(Tracker paramTracker, String paramString, GroupDataProvider paramGroupDataProvider, FragmentComponent paramFragmentComponent, Group paramGroup, Map paramMap, GroupMembershipStatus paramGroupMembershipStatus)
  {
    super(paramTracker, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.transformers.GroupTransformer.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */