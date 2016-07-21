package com.linkedin.gen.avro2pegasus.events.feed;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.messages.MessageId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class FeedHighlightedUpdateEvent
  implements RecordTemplate<FeedHighlightedUpdateEvent>
{
  public static final FeedHighlightedUpdateEventBuilder BUILDER = FeedHighlightedUpdateEventBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHeader;
  public final boolean hasHighlightedUpdateSource;
  public final boolean hasHighlightedUpdates;
  public final boolean hasMobileHeader;
  public final boolean hasModuleKey;
  public final boolean hasRequestHeader;
  public final boolean hasSourceTrackingId;
  public final EventHeader header;
  public final highlightedUpdateSource highlightedUpdateSource;
  public final List<TrackingObject> highlightedUpdates;
  public final MobileHeader mobileHeader;
  public final String moduleKey;
  public final UserRequestHeader requestHeader;
  public final MessageId sourceTrackingId;
  
  FeedHighlightedUpdateEvent(EventHeader paramEventHeader, UserRequestHeader paramUserRequestHeader, MobileHeader paramMobileHeader, String paramString, MessageId paramMessageId, highlightedUpdateSource paramhighlightedUpdateSource, List<TrackingObject> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    header = paramEventHeader;
    requestHeader = paramUserRequestHeader;
    mobileHeader = paramMobileHeader;
    moduleKey = paramString;
    sourceTrackingId = paramMessageId;
    highlightedUpdateSource = paramhighlightedUpdateSource;
    if (paramList == null) {}
    for (paramEventHeader = null;; paramEventHeader = Collections.unmodifiableList(paramList))
    {
      highlightedUpdates = paramEventHeader;
      hasHeader = paramBoolean1;
      hasRequestHeader = paramBoolean2;
      hasMobileHeader = paramBoolean3;
      hasModuleKey = paramBoolean4;
      hasSourceTrackingId = paramBoolean5;
      hasHighlightedUpdateSource = paramBoolean6;
      hasHighlightedUpdates = paramBoolean7;
      _cachedId = null;
      return;
    }
  }
  
  private FeedHighlightedUpdateEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label96:
    label108:
    Object localObject4;
    boolean bool3;
    label148:
    label160:
    Object localObject5;
    boolean bool4;
    label225:
    label237:
    int i;
    if (hasHeader)
    {
      paramDataProcessor.startRecordField$505cff1c("header");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = header.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label428;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasRequestHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("requestHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label437;
        }
        localObject1 = requestHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label455;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasMobileHeader)
      {
        paramDataProcessor.startRecordField$505cff1c("mobileHeader");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label465;
        }
        localObject1 = mobileHeader.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label483;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      if (hasModuleKey)
      {
        paramDataProcessor.startRecordField$505cff1c("moduleKey");
        paramDataProcessor.processString(moduleKey);
      }
      localObject5 = null;
      bool4 = false;
      if (hasSourceTrackingId)
      {
        paramDataProcessor.startRecordField$505cff1c("sourceTrackingId");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label493;
        }
        localObject1 = sourceTrackingId.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label511;
        }
        bool4 = true;
        localObject5 = localObject1;
      }
      if (hasHighlightedUpdateSource)
      {
        paramDataProcessor.startRecordField$505cff1c("highlightedUpdateSource");
        paramDataProcessor.processEnum(highlightedUpdateSource);
      }
      localObject1 = null;
      localTrackingObject = null;
      bool5 = false;
      if (!hasHighlightedUpdates) {
        break label551;
      }
      paramDataProcessor.startRecordField$505cff1c("highlightedUpdates");
      highlightedUpdates.size();
      paramDataProcessor.startArray$13462e();
      localObject1 = localTrackingObject;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject1 = new ArrayList();
      }
      i = 0;
      Iterator localIterator = highlightedUpdates.iterator();
      label337:
      if (!localIterator.hasNext()) {
        break label537;
      }
      localTrackingObject = (TrackingObject)localIterator.next();
      paramDataProcessor.processArrayItem(i);
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label521;
      }
    }
    label428:
    label437:
    label455:
    label465:
    label483:
    label493:
    label511:
    label521:
    for (TrackingObject localTrackingObject = localTrackingObject.accept(paramDataProcessor);; localTrackingObject = (TrackingObject)paramDataProcessor.processDataTemplate(localTrackingObject))
    {
      if ((localObject1 != null) && (localTrackingObject != null)) {
        ((List)localObject1).add(localTrackingObject);
      }
      i += 1;
      break label337;
      localObject1 = (EventHeader)paramDataProcessor.processDataTemplate(header);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (UserRequestHeader)paramDataProcessor.processDataTemplate(requestHeader);
      break label96;
      bool2 = false;
      localObject3 = localObject1;
      break label108;
      localObject1 = (MobileHeader)paramDataProcessor.processDataTemplate(mobileHeader);
      break label148;
      bool3 = false;
      localObject4 = localObject1;
      break label160;
      localObject1 = (MessageId)paramDataProcessor.processDataTemplate(sourceTrackingId);
      break label225;
      bool4 = false;
      localObject5 = localObject1;
      break label237;
    }
    label537:
    paramDataProcessor.endArray();
    if (localObject1 != null) {}
    for (boolean bool5 = true;; bool5 = false)
    {
      label551:
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label751;
      }
      try
      {
        if (hasHeader) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "header");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasRequestHeader) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "requestHeader");
    }
    if (!hasHighlightedUpdateSource) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "highlightedUpdateSource");
    }
    if (!hasHighlightedUpdates) {
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "highlightedUpdates");
    }
    if (highlightedUpdates != null)
    {
      paramDataProcessor = highlightedUpdates.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((TrackingObject)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "highlightedUpdates");
        }
      }
    }
    return new FeedHighlightedUpdateEvent((EventHeader)localObject2, (UserRequestHeader)localObject3, (MobileHeader)localObject4, moduleKey, (MessageId)localObject5, highlightedUpdateSource, (List)localObject1, bool1, bool2, bool3, hasModuleKey, bool4, hasHighlightedUpdateSource, bool5);
    label751:
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
      paramObject = (FeedHighlightedUpdateEvent)paramObject;
      if (header != null)
      {
        if (header.equals(header)) {}
      }
      else {
        while (header != null) {
          return false;
        }
      }
      if (requestHeader != null)
      {
        if (requestHeader.equals(requestHeader)) {}
      }
      else {
        while (requestHeader != null) {
          return false;
        }
      }
      if (mobileHeader != null)
      {
        if (mobileHeader.equals(mobileHeader)) {}
      }
      else {
        while (mobileHeader != null) {
          return false;
        }
      }
      if (moduleKey != null)
      {
        if (moduleKey.equals(moduleKey)) {}
      }
      else {
        while (moduleKey != null) {
          return false;
        }
      }
      if (sourceTrackingId != null)
      {
        if (sourceTrackingId.equals(sourceTrackingId)) {}
      }
      else {
        while (sourceTrackingId != null) {
          return false;
        }
      }
      if (highlightedUpdateSource != null)
      {
        if (highlightedUpdateSource.equals(highlightedUpdateSource)) {}
      }
      else {
        while (highlightedUpdateSource != null) {
          return false;
        }
      }
      if (highlightedUpdates == null) {
        break;
      }
    } while (highlightedUpdates.equals(highlightedUpdates));
    for (;;)
    {
      return false;
      if (highlightedUpdates == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i2 = 0;
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
    if (header != null)
    {
      i = header.hashCode();
      if (requestHeader == null) {
        break label178;
      }
      j = requestHeader.hashCode();
      if (mobileHeader == null) {
        break label183;
      }
      k = mobileHeader.hashCode();
      if (moduleKey == null) {
        break label188;
      }
      m = moduleKey.hashCode();
      if (sourceTrackingId == null) {
        break label194;
      }
      n = sourceTrackingId.hashCode();
      label92:
      if (highlightedUpdateSource == null) {
        break label200;
      }
    }
    label178:
    label183:
    label188:
    label194:
    label200:
    for (int i1 = highlightedUpdateSource.hashCode();; i1 = 0)
    {
      if (highlightedUpdates != null) {
        i2 = highlightedUpdates.hashCode();
      }
      i = (i1 + (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31) * 31 + i2;
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
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements TrackingEventBuilder, RecordTemplateBuilder<FeedHighlightedUpdateEvent>
  {
    private boolean hasHeader = false;
    public boolean hasHighlightedUpdateSource = false;
    public boolean hasHighlightedUpdates = false;
    private boolean hasMobileHeader = false;
    public boolean hasModuleKey = false;
    private boolean hasRequestHeader = false;
    public boolean hasSourceTrackingId = false;
    private EventHeader header = null;
    public highlightedUpdateSource highlightedUpdateSource = null;
    public List<TrackingObject> highlightedUpdates = null;
    private MobileHeader mobileHeader = null;
    public String moduleKey = null;
    private UserRequestHeader requestHeader = null;
    public MessageId sourceTrackingId = null;
    
    private FeedHighlightedUpdateEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (FeedHighlightedUpdateEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (highlightedUpdates != null)
      {
        paramFlavor = highlightedUpdates.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((TrackingObject)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "highlightedUpdates");
              if (!hasHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "header");
              }
              if (!hasRequestHeader) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "requestHeader");
              }
              if (!hasHighlightedUpdateSource) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "highlightedUpdateSource");
              }
              if (hasHighlightedUpdates) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent", "highlightedUpdates");
            }
          }
        }
      }
      return new FeedHighlightedUpdateEvent(header, requestHeader, mobileHeader, moduleKey, sourceTrackingId, highlightedUpdateSource, highlightedUpdates, hasHeader, hasRequestHeader, hasMobileHeader, hasModuleKey, hasSourceTrackingId, hasHighlightedUpdateSource, hasHighlightedUpdates);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.feed.FeedHighlightedUpdateEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */