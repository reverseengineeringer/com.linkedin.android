package com.linkedin.gen.avro2pegasus.common.badge;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class TabBadgeDetails$Builder
  implements RecordTemplateBuilder<TabBadgeDetails>
{
  public int feedTabBadgeCount = 0;
  public boolean hasFeedTabBadgeCount = false;
  private boolean hasJobsTabBadgeCount = false;
  public boolean hasMeTabBadgeCount = false;
  public boolean hasMessagingTabBadgeCount = false;
  public boolean hasMyNetworkTabBadgeCount = false;
  public boolean hasNotificationTabBadgeCount = false;
  private int jobsTabBadgeCount = 0;
  public int meTabBadgeCount = 0;
  public int messagingTabBadgeCount = 0;
  public int myNetworkTabBadgeCount = 0;
  public int notificationTabBadgeCount = 0;
  
  public final TabBadgeDetails build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (TabBadgeDetails.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new TabBadgeDetails(feedTabBadgeCount, myNetworkTabBadgeCount, messagingTabBadgeCount, notificationTabBadgeCount, meTabBadgeCount, jobsTabBadgeCount, hasFeedTabBadgeCount, hasMyNetworkTabBadgeCount, hasMessagingTabBadgeCount, hasNotificationTabBadgeCount, hasMeTabBadgeCount, hasJobsTabBadgeCount);
      if (!hasFeedTabBadgeCount) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails", "feedTabBadgeCount");
      }
      if (!hasMyNetworkTabBadgeCount) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails", "myNetworkTabBadgeCount");
      }
      if (!hasMessagingTabBadgeCount) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails", "messagingTabBadgeCount");
      }
      if (!hasNotificationTabBadgeCount) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails", "notificationTabBadgeCount");
      }
    } while (hasMeTabBadgeCount);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails", "meTabBadgeCount");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */