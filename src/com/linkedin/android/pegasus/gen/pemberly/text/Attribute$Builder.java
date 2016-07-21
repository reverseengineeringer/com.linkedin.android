package com.linkedin.android.pegasus.gen.pemberly.text;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Attribute$Builder
  implements RecordTemplateBuilder<Attribute>
{
  public boolean hasLength = false;
  public boolean hasStart = false;
  public boolean hasType = false;
  public int length = 0;
  public int start = 0;
  public AttributeType type = null;
  
  public final Attribute build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Attribute.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new Attribute(start, length, type, hasStart, hasLength, hasType);
      if (!hasStart) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.pemberly.text.Attribute", "start");
      }
      if (!hasLength) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.pemberly.text.Attribute", "length");
      }
    } while (hasType);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.pemberly.text.Attribute", "type");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.pemberly.text.Attribute.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */