package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class EventCreate$Builder
  implements RecordTemplateBuilder<EventCreate>
{
  private boolean hasValue = false;
  private EventCreate.Value value = null;
  
  public final EventCreate build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (EventCreate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new EventCreate(value, hasValue);
    } while (hasValue);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreate", "value");
  }
  
  public final Builder setValue(EventCreate.Value paramValue)
  {
    if (paramValue == null)
    {
      hasValue = false;
      value = null;
      return this;
    }
    hasValue = true;
    value = paramValue;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreate.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */