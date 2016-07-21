package com.linkedin.gen.avro2pegasus.events.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ListPosition$Builder
  implements RecordTemplateBuilder<ListPosition>
{
  private boolean hasIndex = false;
  private int index = 0;
  
  public final ListPosition build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ListPosition.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ListPosition(index, hasIndex);
    } while (hasIndex);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.common.ListPosition", "index");
  }
  
  public final Builder setIndex(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasIndex = false;
      index = 0;
      return this;
    }
    hasIndex = true;
    index = paramInteger.intValue();
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.common.ListPosition.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */