package com.linkedin.gen.avro2pegasus.events.prop;

import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import com.linkedin.gen.avro2pegasus.events.EventHeader;
import com.linkedin.gen.avro2pegasus.events.MobileHeader;
import com.linkedin.gen.avro2pegasus.events.UserRequestHeader;
import java.util.Iterator;
import java.util.List;

public final class PropImpressionEvent$Builder
  implements TrackingEventBuilder, RecordTemplateBuilder<PropImpressionEvent>
{
  private List<Entity> entities = null;
  private boolean hasEntities = false;
  private boolean hasHeader = false;
  private boolean hasMobileHeader = false;
  private boolean hasModuleKey = false;
  private boolean hasRequestHeader = false;
  private EventHeader header = null;
  private MobileHeader mobileHeader = null;
  private String moduleKey = null;
  private UserRequestHeader requestHeader = null;
  
  private PropImpressionEvent build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PropImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (entities != null)
    {
      paramFlavor = entities.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((Entity)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "entities");
            if (!hasHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "header");
            }
            if (!hasRequestHeader) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "requestHeader");
            }
            if (!hasModuleKey) {
              throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "moduleKey");
            }
            if (hasEntities) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent", "entities");
          }
        }
      }
    }
    return new PropImpressionEvent(header, requestHeader, mobileHeader, moduleKey, entities, hasHeader, hasRequestHeader, hasMobileHeader, hasModuleKey, hasEntities);
  }
  
  public final Builder setEntities(List<Entity> paramList)
  {
    hasEntities = true;
    entities = paramList;
    return this;
  }
  
  public final Builder setModuleKey(String paramString)
  {
    hasModuleKey = true;
    moduleKey = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */