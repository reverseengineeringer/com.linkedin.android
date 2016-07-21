package com.linkedin.gen.avro2pegasus.common.guidededit;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class GuidedEditEducationsField$Builder
  implements RecordTemplateBuilder<GuidedEditEducationsField>
{
  public List<String> educations = null;
  public boolean hasEducations = false;
  
  public final GuidedEditEducationsField build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (GuidedEditEducationsField.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (educations != null)
    {
      paramFlavor = educations.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((String)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditEducationsField", "educations");
            if (hasEducations) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditEducationsField", "educations");
          }
        }
      }
    }
    return new GuidedEditEducationsField(educations, hasEducations);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditEducationsField.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */