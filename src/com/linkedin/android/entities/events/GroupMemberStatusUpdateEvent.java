package com.linkedin.android.entities.events;

import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipStatus;

public final class GroupMemberStatusUpdateEvent
{
  public final boolean isResponsePending;
  public final GroupMembershipStatus memberStatus;
  public final boolean reloadPageOnResponse;
  
  public GroupMemberStatusUpdateEvent(GroupMembershipStatus paramGroupMembershipStatus, boolean paramBoolean1, boolean paramBoolean2)
  {
    memberStatus = paramGroupMembershipStatus;
    isResponsePending = paramBoolean1;
    reloadPageOnResponse = paramBoolean2;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.events.GroupMemberStatusUpdateEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */