package com.linkedin.gen.avro2pegasus.events.feed;

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

public final class Comment
  implements RecordTemplate<Comment>
{
  public static final CommentBuilder BUILDER = CommentBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String associatedInputControlUrn;
  public final String commenterUrn;
  public final long duration;
  public final boolean hasAssociatedInputControlUrn;
  public final boolean hasCommenterUrn;
  public final boolean hasDuration;
  public final boolean hasLevel;
  public final boolean hasListPosition;
  public final boolean hasMessage;
  public final boolean hasSize;
  public final boolean hasThreadUrn;
  public final boolean hasTotalLikes;
  public final boolean hasTotalReplies;
  public final boolean hasTrackableCommentObject;
  public final boolean hasTrackableUpdateObject;
  public final boolean hasVisibleTime;
  public final int level;
  public final ListPosition listPosition;
  public final String message;
  public final EntityDimension size;
  public final String threadUrn;
  public final long totalLikes;
  public final long totalReplies;
  public final TrackingObject trackableCommentObject;
  public final TrackingObject trackableUpdateObject;
  public final long visibleTime;
  
  Comment(TrackingObject paramTrackingObject1, TrackingObject paramTrackingObject2, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong1, long paramLong2, String paramString4, long paramLong3, long paramLong4, ListPosition paramListPosition, EntityDimension paramEntityDimension, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, boolean paramBoolean9, boolean paramBoolean10, boolean paramBoolean11, boolean paramBoolean12, boolean paramBoolean13)
  {
    trackableCommentObject = paramTrackingObject1;
    trackableUpdateObject = paramTrackingObject2;
    threadUrn = paramString1;
    commenterUrn = paramString2;
    message = paramString3;
    level = paramInt;
    visibleTime = paramLong1;
    duration = paramLong2;
    associatedInputControlUrn = paramString4;
    totalReplies = paramLong3;
    totalLikes = paramLong4;
    listPosition = paramListPosition;
    size = paramEntityDimension;
    hasTrackableCommentObject = paramBoolean1;
    hasTrackableUpdateObject = paramBoolean2;
    hasThreadUrn = paramBoolean3;
    hasCommenterUrn = paramBoolean4;
    hasMessage = paramBoolean5;
    hasLevel = paramBoolean6;
    hasVisibleTime = paramBoolean7;
    hasDuration = paramBoolean8;
    hasAssociatedInputControlUrn = paramBoolean9;
    hasTotalReplies = paramBoolean10;
    hasTotalLikes = paramBoolean11;
    hasListPosition = paramBoolean12;
    hasSize = paramBoolean13;
    _cachedId = null;
  }
  
  public final Comment accept(DataProcessor paramDataProcessor)
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
    if (hasTrackableCommentObject)
    {
      paramDataProcessor.startRecordField$505cff1c("trackableCommentObject");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = trackableCommentObject.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label493;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasTrackableUpdateObject)
      {
        paramDataProcessor.startRecordField$505cff1c("trackableUpdateObject");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label502;
        }
        localObject1 = trackableUpdateObject.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label520;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      if (hasThreadUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("threadUrn");
        paramDataProcessor.processString(threadUrn);
      }
      if (hasCommenterUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("commenterUrn");
        paramDataProcessor.processString(commenterUrn);
      }
      if (hasMessage)
      {
        paramDataProcessor.startRecordField$505cff1c("message");
        paramDataProcessor.processString(message);
      }
      if (hasLevel)
      {
        paramDataProcessor.startRecordField$505cff1c("level");
        paramDataProcessor.processInt(level);
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
      if (hasAssociatedInputControlUrn)
      {
        paramDataProcessor.startRecordField$505cff1c("associatedInputControlUrn");
        paramDataProcessor.processString(associatedInputControlUrn);
      }
      if (hasTotalReplies)
      {
        paramDataProcessor.startRecordField$505cff1c("totalReplies");
        paramDataProcessor.processLong(totalReplies);
      }
      if (hasTotalLikes)
      {
        paramDataProcessor.startRecordField$505cff1c("totalLikes");
        paramDataProcessor.processLong(totalLikes);
      }
      localObject4 = null;
      bool3 = false;
      if (hasListPosition)
      {
        paramDataProcessor.startRecordField$505cff1c("listPosition");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label529;
        }
        localObject1 = listPosition.accept(paramDataProcessor);
        label371:
        if (localObject1 == null) {
          break label547;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label383:
      localObject1 = null;
      bool4 = false;
      if (hasSize)
      {
        paramDataProcessor.startRecordField$505cff1c("size");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label557;
        }
        localObject1 = size.accept(paramDataProcessor);
        label423:
        if (localObject1 == null) {
          break label575;
        }
      }
    }
    label493:
    label502:
    label520:
    label529:
    label547:
    label557:
    label575:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label884;
      }
      try
      {
        if (hasTrackableCommentObject) {
          break label581;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "trackableCommentObject");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(trackableCommentObject);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (TrackingObject)paramDataProcessor.processDataTemplate(trackableUpdateObject);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (ListPosition)paramDataProcessor.processDataTemplate(listPosition);
      break label371;
      bool3 = false;
      localObject4 = localObject1;
      break label383;
      localObject1 = (EntityDimension)paramDataProcessor.processDataTemplate(size);
      break label423;
    }
    label581:
    if (!hasTrackableUpdateObject) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "trackableUpdateObject");
    }
    if (!hasThreadUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "threadUrn");
    }
    if (!hasCommenterUrn) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "commenterUrn");
    }
    if (!hasMessage) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "message");
    }
    if (!hasLevel) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "level");
    }
    if (!hasVisibleTime) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "visibleTime");
    }
    if (!hasDuration) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "duration");
    }
    if (!hasTotalReplies) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "totalReplies");
    }
    if (!hasTotalLikes) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "totalLikes");
    }
    if (!hasListPosition) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "listPosition");
    }
    if (!hasSize) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "size");
    }
    return new Comment((TrackingObject)localObject2, (TrackingObject)localObject3, threadUrn, commenterUrn, message, level, visibleTime, duration, associatedInputControlUrn, totalReplies, totalLikes, (ListPosition)localObject4, (EntityDimension)localObject1, bool1, bool2, hasThreadUrn, hasCommenterUrn, hasMessage, hasLevel, hasVisibleTime, hasDuration, hasAssociatedInputControlUrn, hasTotalReplies, hasTotalLikes, bool3, bool4);
    label884:
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
      paramObject = (Comment)paramObject;
      if (trackableCommentObject != null)
      {
        if (trackableCommentObject.equals(trackableCommentObject)) {}
      }
      else {
        while (trackableCommentObject != null) {
          return false;
        }
      }
      if (trackableUpdateObject != null)
      {
        if (trackableUpdateObject.equals(trackableUpdateObject)) {}
      }
      else {
        while (trackableUpdateObject != null) {
          return false;
        }
      }
      if (threadUrn != null)
      {
        if (threadUrn.equals(threadUrn)) {}
      }
      else {
        while (threadUrn != null) {
          return false;
        }
      }
      if (commenterUrn != null)
      {
        if (commenterUrn.equals(commenterUrn)) {}
      }
      else {
        while (commenterUrn != null) {
          return false;
        }
      }
      if (message != null)
      {
        if (message.equals(message)) {}
      }
      else {
        while (message != null) {
          return false;
        }
      }
      if (level != level) {
        return false;
      }
      if (visibleTime != visibleTime) {
        return false;
      }
      if (duration != duration) {
        return false;
      }
      if (associatedInputControlUrn != null)
      {
        if (associatedInputControlUrn.equals(associatedInputControlUrn)) {}
      }
      else {
        while (associatedInputControlUrn != null) {
          return false;
        }
      }
      if (totalReplies != totalReplies) {
        return false;
      }
      if (totalLikes != totalLikes) {
        return false;
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
      if (size == null) {
        break;
      }
    } while (size.equals(size));
    for (;;)
    {
      return false;
      if (size == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i3 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    label76:
    int n;
    label92:
    int i4;
    int i5;
    int i6;
    int i1;
    label144:
    int i7;
    int i8;
    if (trackableCommentObject != null)
    {
      i = trackableCommentObject.hashCode();
      if (trackableUpdateObject == null) {
        break label294;
      }
      j = trackableUpdateObject.hashCode();
      if (threadUrn == null) {
        break label299;
      }
      k = threadUrn.hashCode();
      if (commenterUrn == null) {
        break label304;
      }
      m = commenterUrn.hashCode();
      if (message == null) {
        break label310;
      }
      n = message.hashCode();
      i4 = level;
      i5 = (int)(visibleTime ^ visibleTime >>> 32);
      i6 = (int)(duration ^ duration >>> 32);
      if (associatedInputControlUrn == null) {
        break label316;
      }
      i1 = associatedInputControlUrn.hashCode();
      i7 = (int)(totalReplies ^ totalReplies >>> 32);
      i8 = (int)(totalLikes ^ totalLikes >>> 32);
      if (listPosition == null) {
        break label322;
      }
    }
    label294:
    label299:
    label304:
    label310:
    label316:
    label322:
    for (int i2 = listPosition.hashCode();; i2 = 0)
    {
      if (size != null) {
        i3 = size.hashCode();
      }
      i = (i2 + (((i1 + ((((n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i4) * 31 + i5) * 31 + i6) * 31) * 31 + i7) * 31 + i8) * 31) * 31 + i3;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
      n = 0;
      break label92;
      i1 = 0;
      break label144;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<Comment>
  {
    public String associatedInputControlUrn = null;
    public String commenterUrn = null;
    public long duration = 0L;
    public boolean hasAssociatedInputControlUrn = false;
    public boolean hasCommenterUrn = false;
    public boolean hasDuration = false;
    public boolean hasLevel = false;
    public boolean hasListPosition = false;
    public boolean hasMessage = false;
    public boolean hasSize = false;
    public boolean hasThreadUrn = false;
    public boolean hasTotalLikes = false;
    public boolean hasTotalReplies = false;
    public boolean hasTrackableCommentObject = false;
    public boolean hasTrackableUpdateObject = false;
    public boolean hasVisibleTime = false;
    public int level = 0;
    public ListPosition listPosition = null;
    public String message = null;
    public EntityDimension size = null;
    public String threadUrn = null;
    public long totalLikes = 0L;
    public long totalReplies = 0L;
    public TrackingObject trackableCommentObject = null;
    public TrackingObject trackableUpdateObject = null;
    public long visibleTime = 0L;
    
    public final Comment build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Comment.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new Comment(trackableCommentObject, trackableUpdateObject, threadUrn, commenterUrn, message, level, visibleTime, duration, associatedInputControlUrn, totalReplies, totalLikes, listPosition, size, hasTrackableCommentObject, hasTrackableUpdateObject, hasThreadUrn, hasCommenterUrn, hasMessage, hasLevel, hasVisibleTime, hasDuration, hasAssociatedInputControlUrn, hasTotalReplies, hasTotalLikes, hasListPosition, hasSize);
        if (!hasTrackableCommentObject) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "trackableCommentObject");
        }
        if (!hasTrackableUpdateObject) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "trackableUpdateObject");
        }
        if (!hasThreadUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "threadUrn");
        }
        if (!hasCommenterUrn) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "commenterUrn");
        }
        if (!hasMessage) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "message");
        }
        if (!hasLevel) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "level");
        }
        if (!hasVisibleTime) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "visibleTime");
        }
        if (!hasDuration) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "duration");
        }
        if (!hasTotalReplies) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "totalReplies");
        }
        if (!hasTotalLikes) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "totalLikes");
        }
        if (!hasListPosition) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "listPosition");
        }
      } while (hasSize);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.Comment", "size");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.feed.Comment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */