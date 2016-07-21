package com.linkedin.android.entities.group;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.voyager.entities.group.Group;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfo;

final class GroupDataProvider$1
  implements RecordTemplateListener<ActionResponse<GroupMembershipInfo>>
{
  GroupDataProvider$1(GroupDataProvider paramGroupDataProvider, Group paramGroup, int paramInt, boolean paramBoolean) {}
  
  public final void onResponse(DataStoreResponse<ActionResponse<GroupMembershipInfo>> paramDataStoreResponse)
  {
    GroupDataProvider.access$600(this$0, paramDataStoreResponse, val$group, val$successToastStringId, val$failedToastStringId, val$reloadPageOnResponse);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.GroupDataProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */