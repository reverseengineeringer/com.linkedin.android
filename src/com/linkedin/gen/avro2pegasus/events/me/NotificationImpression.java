package com.linkedin.gen.avro2pegasus.events.me;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;

public final class NotificationImpression
  implements RecordTemplate<NotificationImpression>
{
  public static final NotificationImpressionBuilder BUILDER = NotificationImpressionBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final long duration;
  public final boolean hasDuration;
  public final boolean hasInsight;
  public final boolean hasListPosition;
  public final boolean hasNotification;
  public final boolean hasSize;
  public final boolean hasVisibleTime;
  public final TrackingObject insight;
  public final ListPosition listPosition;
  public final TrackingObject notification;
  public final EntityDimension size;
  public final long visibleTime;
  
  NotificationImpression(TrackingObject paramTrackingObject1, ListPosition paramListPosition, long paramLong1, long paramLong2, EntityDimension paramEntityDimension, TrackingObject paramTrackingObject2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    notification = paramTrackingObject1;
    listPosition = paramListPosition;
    visibleTime = paramLong1;
    duration = paramLong2;
    size = paramEntityDimension;
    insight = paramTrackingObject2;
    hasNotification = paramBoolean1;
    hasListPosition = paramBoolean2;
    hasVisibleTime = paramBoolean3;
    hasDuration = paramBoolean4;
    hasSize = paramBoolean5;
    hasInsight = paramBoolean6;
    _cachedId = null;
  }
  
  public final NotificationImpression accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    if (hasNotification)
    {
      paramDataProcessor.startRecordField$505cff1c("notification");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = notification.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label318;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasListPosition)
      {
        paramDataProcessor.startRecordField$505cff1c("listPosition");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label327;
        }
        localObject1 = listPosition.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label345;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      if (hasVisibleTime)
      {
        paramDataProcessor.startRecordField$505cff1c("visibleTime");
        paramDataProcessor.processLong(visibleTime);
      }
      if (hasDuration)
      {
        paramDataProcessor.startRecordField$505cff1c("duration");
        paramDataProcessor.processLong(duration);
      }
      localObject4 = null;
      bool3 = false;
      if (hasSize)
      {
        paramDataProcessor.startRecordField$505cff1c("size");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label354;
        }
        localObject1 = size.accept(paramDataProcessor);
        label196:
        if (localObject1 == null) {
          break label372;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label208:
      localObject1 = null;
      bool4 = false;
      if (hasInsight)
      {
        paramDataProcessor.startRecordField$505cff1c("insight");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label382;
        }
        localObject1 = insight.accept(paramDataProcessor);
        label248:
        if (localObject1 == null) {
          break label400;
        }
      }
    }
    label318:
    label327:
    label345:
    label354:
    label372:
    label382:
    label400:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label501;
      }
      try
      {
        if (hasNotification) {
          break label406;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.NotificationImpression", "notification");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(notification);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (ListPosition)paramDataProcessor.processDataTemplate(listPosition);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (EntityDimension)paramDataProcessor.processDataTemplate(size);
      break label196;
      bool3 = false;
      localObject4 = localObject1;
      break label208;
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(insight);
      break label248;
    }
    label406:
    if (!hasVisibleTime) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.NotificationImpression", "visibleTime");
    }
    if (!hasDuration) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.NotificationImpression", "duration");
    }
    if (!hasSize) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.NotificationImpression", "size");
    }
    return new NotificationImpression((TrackingObject)localObject2, (ListPosition)localObject3, visibleTime, duration, (EntityDimension)localObject4, (TrackingObject)localObject1, bool1, bool2, hasVisibleTime, hasDuration, bool3, bool4);
    label501:
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
      paramObject = (NotificationImpression)paramObject;
      if (notification != null)
      {
        if (notification.equals(notification)) {}
      }
      else {
        while (notification != null) {
          return false;
        }
      }
      if (listPosition != null)
      {
        if (listPosition.equals(listPosition)) {}
      }
      else {
        while (listPosition != null) {
          return false;
        }
      }
      if (visibleTime != visibleTime) {
        return false;
      }
      if (duration != duration) {
        return false;
      }
      if (size != null)
      {
        if (size.equals(size)) {}
      }
      else {
        while (size != null) {
          return false;
        }
      }
      if (insight == null) {
        break;
      }
    } while (insight.equals(insight));
    for (;;)
    {
      return false;
      if (insight == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int n;
    int i1;
    if (notification != null)
    {
      i = notification.hashCode();
      if (listPosition == null) {
        break label152;
      }
      j = listPosition.hashCode();
      n = (int)(visibleTime ^ visibleTime >>> 32);
      i1 = (int)(duration ^ duration >>> 32);
      if (size == null) {
        break label157;
      }
    }
    label152:
    label157:
    for (int k = size.hashCode();; k = 0)
    {
      if (insight != null) {
        m = insight.hashCode();
      }
      i = (k + (((j + (i + 527) * 31) * 31 + n) * 31 + i1) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<NotificationImpression>
  {
    public long duration = 0L;
    public boolean hasDuration = false;
    public boolean hasInsight = false;
    public boolean hasListPosition = false;
    public boolean hasNotification = false;
    public boolean hasSize = false;
    public boolean hasVisibleTime = false;
    public TrackingObject insight = null;
    public ListPosition listPosition = null;
    public TrackingObject notification = null;
    public EntityDimension size = null;
    public long visibleTime = 0L;
    
    public final NotificationImpression build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (NotificationImpression.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new NotificationImpression(notification, listPosition, visibleTime, duration, size, insight, hasNotification, hasListPosition, hasVisibleTime, hasDuration, hasSize, hasInsight);
        if (!hasNotification) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.NotificationImpression", "notification");
        }
        if (!hasVisibleTime) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.NotificationImpression", "visibleTime");
        }
        if (!hasDuration) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.NotificationImpression", "duration");
        }
      } while (hasSize);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.me.NotificationImpression", "size");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.me.NotificationImpression
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */