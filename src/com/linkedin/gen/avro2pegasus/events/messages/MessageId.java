package com.linkedin.gen.avro2pegasus.events.messages;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MessageId
  implements RecordTemplate<MessageId>
{
  public static final MessageIdBuilder BUILDER = MessageIdBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String deliveryId;
  public final List<String> externalIds;
  public final String flockMessageUrn;
  public final boolean hasDeliveryId;
  public final boolean hasExternalIds;
  public final boolean hasFlockMessageUrn;
  
  MessageId(String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    flockMessageUrn = paramString1;
    deliveryId = paramString2;
    if (paramList == null) {}
    for (paramString1 = null;; paramString1 = Collections.unmodifiableList(paramList))
    {
      externalIds = paramString1;
      hasFlockMessageUrn = paramBoolean1;
      hasDeliveryId = paramBoolean2;
      hasExternalIds = paramBoolean3;
      _cachedId = null;
      return;
    }
  }
  
  public final MessageId accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasFlockMessageUrn)
    {
      paramDataProcessor.startRecordField$505cff1c("flockMessageUrn");
      paramDataProcessor.processString(flockMessageUrn);
    }
    if (hasDeliveryId)
    {
      paramDataProcessor.startRecordField$505cff1c("deliveryId");
      paramDataProcessor.processString(deliveryId);
    }
    Object localObject = null;
    Iterator localIterator = null;
    boolean bool = false;
    if (hasExternalIds)
    {
      paramDataProcessor.startRecordField$505cff1c("externalIds");
      externalIds.size();
      paramDataProcessor.startArray$13462e();
      localObject = localIterator;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      localIterator = externalIds.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        paramDataProcessor.processString(str);
        if (localObject != null) {
          ((List)localObject).add(str);
        }
        i += 1;
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label244;
      }
    }
    label244:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break;
      }
      return new MessageId(flockMessageUrn, deliveryId, (List)localObject, hasFlockMessageUrn, hasDeliveryId, bool);
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
      paramObject = (MessageId)paramObject;
      if (flockMessageUrn != null)
      {
        if (flockMessageUrn.equals(flockMessageUrn)) {}
      }
      else {
        while (flockMessageUrn != null) {
          return false;
        }
      }
      if (deliveryId != null)
      {
        if (deliveryId.equals(deliveryId)) {}
      }
      else {
        while (deliveryId != null) {
          return false;
        }
      }
      if (externalIds == null) {
        break;
      }
    } while (externalIds.equals(externalIds));
    for (;;)
    {
      return false;
      if (externalIds == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (flockMessageUrn != null)
    {
      i = flockMessageUrn.hashCode();
      if (deliveryId == null) {
        break label89;
      }
    }
    label89:
    for (int j = deliveryId.hashCode();; j = 0)
    {
      if (externalIds != null) {
        k = externalIds.hashCode();
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<MessageId>
  {
    private String deliveryId = null;
    private List<String> externalIds = null;
    private String flockMessageUrn = null;
    private boolean hasDeliveryId = false;
    private boolean hasExternalIds = false;
    private boolean hasFlockMessageUrn = false;
    
    public final MessageId build()
      throws BuilderException
    {
      return build(RecordTemplate.Flavor.RECORD);
    }
    
    public final MessageId build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (MessageId.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      while (externalIds != null)
      {
        paramFlavor = externalIds.iterator();
        for (;;)
        {
          if (paramFlavor.hasNext()) {
            if ((String)paramFlavor.next() == null)
            {
              throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.messages.MessageId", "externalIds");
              if (!hasFlockMessageUrn) {
                throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messages.MessageId", "flockMessageUrn");
              }
              if (hasExternalIds) {
                break;
              }
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messages.MessageId", "externalIds");
            }
          }
        }
      }
      return new MessageId(flockMessageUrn, deliveryId, externalIds, hasFlockMessageUrn, hasDeliveryId, hasExternalIds);
    }
    
    public final Builder setDeliveryId(String paramString)
    {
      if (paramString == null)
      {
        hasDeliveryId = false;
        deliveryId = null;
        return this;
      }
      hasDeliveryId = true;
      deliveryId = paramString;
      return this;
    }
    
    public final Builder setExternalIds(List<String> paramList)
    {
      if (paramList == null)
      {
        hasExternalIds = false;
        externalIds = null;
        return this;
      }
      hasExternalIds = true;
      externalIds = paramList;
      return this;
    }
    
    public final Builder setFlockMessageUrn(String paramString)
    {
      if (paramString == null)
      {
        hasFlockMessageUrn = false;
        flockMessageUrn = null;
        return this;
      }
      hasFlockMessageUrn = true;
      flockMessageUrn = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messages.MessageId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */