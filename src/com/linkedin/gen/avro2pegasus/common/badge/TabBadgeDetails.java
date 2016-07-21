package com.linkedin.gen.avro2pegasus.common.badge;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class TabBadgeDetails
  implements RecordTemplate<TabBadgeDetails>
{
  public static final TabBadgeDetailsBuilder BUILDER = TabBadgeDetailsBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final int feedTabBadgeCount;
  public final boolean hasFeedTabBadgeCount;
  public final boolean hasJobsTabBadgeCount;
  public final boolean hasMeTabBadgeCount;
  public final boolean hasMessagingTabBadgeCount;
  public final boolean hasMyNetworkTabBadgeCount;
  public final boolean hasNotificationTabBadgeCount;
  public final int jobsTabBadgeCount;
  public final int meTabBadgeCount;
  public final int messagingTabBadgeCount;
  public final int myNetworkTabBadgeCount;
  public final int notificationTabBadgeCount;
  
  TabBadgeDetails(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    feedTabBadgeCount = paramInt1;
    myNetworkTabBadgeCount = paramInt2;
    messagingTabBadgeCount = paramInt3;
    notificationTabBadgeCount = paramInt4;
    meTabBadgeCount = paramInt5;
    jobsTabBadgeCount = paramInt6;
    hasFeedTabBadgeCount = paramBoolean1;
    hasMyNetworkTabBadgeCount = paramBoolean2;
    hasMessagingTabBadgeCount = paramBoolean3;
    hasNotificationTabBadgeCount = paramBoolean4;
    hasMeTabBadgeCount = paramBoolean5;
    hasJobsTabBadgeCount = paramBoolean6;
    _cachedId = null;
  }
  
  public final TabBadgeDetails accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasFeedTabBadgeCount)
    {
      paramDataProcessor.startRecordField$505cff1c("feedTabBadgeCount");
      paramDataProcessor.processInt(feedTabBadgeCount);
    }
    if (hasMyNetworkTabBadgeCount)
    {
      paramDataProcessor.startRecordField$505cff1c("myNetworkTabBadgeCount");
      paramDataProcessor.processInt(myNetworkTabBadgeCount);
    }
    if (hasMessagingTabBadgeCount)
    {
      paramDataProcessor.startRecordField$505cff1c("messagingTabBadgeCount");
      paramDataProcessor.processInt(messagingTabBadgeCount);
    }
    if (hasNotificationTabBadgeCount)
    {
      paramDataProcessor.startRecordField$505cff1c("notificationTabBadgeCount");
      paramDataProcessor.processInt(notificationTabBadgeCount);
    }
    if (hasMeTabBadgeCount)
    {
      paramDataProcessor.startRecordField$505cff1c("meTabBadgeCount");
      paramDataProcessor.processInt(meTabBadgeCount);
    }
    if (hasJobsTabBadgeCount)
    {
      paramDataProcessor.startRecordField$505cff1c("jobsTabBadgeCount");
      paramDataProcessor.processInt(jobsTabBadgeCount);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasFeedTabBadgeCount) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails", "feedTabBadgeCount");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
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
      if (!hasMeTabBadgeCount) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails", "meTabBadgeCount");
      }
      return new TabBadgeDetails(feedTabBadgeCount, myNetworkTabBadgeCount, messagingTabBadgeCount, notificationTabBadgeCount, meTabBadgeCount, jobsTabBadgeCount, hasFeedTabBadgeCount, hasMyNetworkTabBadgeCount, hasMessagingTabBadgeCount, hasNotificationTabBadgeCount, hasMeTabBadgeCount, hasJobsTabBadgeCount);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (TabBadgeDetails)paramObject;
      if (feedTabBadgeCount != feedTabBadgeCount) {
        return false;
      }
      if (myNetworkTabBadgeCount != myNetworkTabBadgeCount) {
        return false;
      }
      if (messagingTabBadgeCount != messagingTabBadgeCount) {
        return false;
      }
      if (notificationTabBadgeCount != notificationTabBadgeCount) {
        return false;
      }
      if (meTabBadgeCount != meTabBadgeCount) {
        return false;
      }
    } while (jobsTabBadgeCount == jobsTabBadgeCount);
    return false;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i = (((((feedTabBadgeCount + 527) * 31 + myNetworkTabBadgeCount) * 31 + messagingTabBadgeCount) * 31 + notificationTabBadgeCount) * 31 + meTabBadgeCount) * 31 + jobsTabBadgeCount;
    _cachedHashCode = i;
    return i;
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.badge.TabBadgeDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */