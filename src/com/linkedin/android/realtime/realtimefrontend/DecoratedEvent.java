package com.linkedin.android.realtime.realtimefrontend;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.common.UrnCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.RecordTemplate;

public final class DecoratedEvent
  implements RecordTemplate<DecoratedEvent>
{
  private volatile int _cachedHashCode = -1;
  public final boolean hasPayload;
  public final boolean hasTopic;
  public final DataTemplate payload;
  public final Urn topic;
  
  DecoratedEvent(Urn paramUrn, DataTemplate paramDataTemplate, boolean paramBoolean1, boolean paramBoolean2)
  {
    topic = paramUrn;
    payload = paramDataTemplate;
    hasTopic = paramBoolean1;
    hasPayload = paramBoolean2;
  }
  
  public final DecoratedEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTopic)
    {
      paramDataProcessor.startRecordField$505cff1c("topic");
      localObject = UrnCoercer.INSTANCE;
      paramDataProcessor.processString(UrnCoercer.coerceFromCustomType(topic));
    }
    Object localObject = null;
    boolean bool = false;
    if (hasPayload)
    {
      paramDataProcessor.startRecordField$505cff1c("payload");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label116;
      }
      localObject = payload.accept(paramDataProcessor);
      if (localObject == null) {
        break label130;
      }
    }
    label116:
    label130:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label135;
      }
      return new DecoratedEvent(topic, (DataTemplate)localObject, hasTopic, bool);
      localObject = paramDataProcessor.processDataTemplate(payload);
      break;
    }
    label135:
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
      paramObject = (DecoratedEvent)paramObject;
      if (topic != null)
      {
        if (topic.equals(topic)) {}
      }
      else {
        while (topic != null) {
          return false;
        }
      }
      if (payload == null) {
        break;
      }
    } while (payload.equals(payload));
    for (;;)
    {
      return false;
      if (payload == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (topic != null) {}
    for (int i = topic.hashCode();; i = 0)
    {
      if (payload != null) {
        j = payload.hashCode();
      }
      i = (i + 527) * 31 + j;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.realtime.realtimefrontend.DecoratedEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */