package com.linkedin.gen.avro2pegasus.events.identity;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Contributor$Builder
  implements RecordTemplateBuilder<Contributor>
{
  public boolean hasMemberUrn = false;
  private boolean hasName = false;
  public String memberUrn = null;
  private String name = null;
  
  public final Contributor build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Contributor.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new Contributor(name, memberUrn, hasName, hasMemberUrn);
    } while (hasName);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.identity.Contributor", "name");
  }
  
  public final Builder setName(String paramString)
  {
    if (paramString == null)
    {
      hasName = false;
      name = null;
      return this;
    }
    hasName = true;
    name = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.identity.Contributor.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */