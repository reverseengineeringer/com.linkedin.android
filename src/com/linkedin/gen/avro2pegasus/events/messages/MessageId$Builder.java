package com.linkedin.gen.avro2pegasus.events.messages;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class MessageId$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messages.MessageId.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */