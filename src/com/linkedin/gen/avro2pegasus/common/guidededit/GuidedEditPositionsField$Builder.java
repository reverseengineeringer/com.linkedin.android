package com.linkedin.gen.avro2pegasus.common.guidededit;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class GuidedEditPositionsField$Builder
  implements RecordTemplateBuilder<GuidedEditPositionsField>
{
  public boolean hasPositions = false;
  public List<String> positions = null;
  
  public final GuidedEditPositionsField build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (GuidedEditPositionsField.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (positions != null)
    {
      paramFlavor = positions.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((String)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditPositionsField", "positions");
            if (hasPositions) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditPositionsField", "positions");
          }
        }
      }
    }
    return new GuidedEditPositionsField(positions, hasPositions);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditPositionsField.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */