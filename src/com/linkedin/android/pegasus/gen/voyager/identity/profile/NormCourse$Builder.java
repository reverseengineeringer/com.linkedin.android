package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class NormCourse$Builder
  implements RecordTemplateBuilder<NormCourse>
{
  private Urn entityUrn = null;
  private boolean hasEntityUrn = false;
  private boolean hasName = false;
  private boolean hasNumber = false;
  private boolean hasOccupation = false;
  private String name = null;
  private String number = null;
  private Urn occupation = null;
  
  public NormCourse$Builder() {}
  
  public NormCourse$Builder(NormCourse paramNormCourse)
  {
    entityUrn = entityUrn;
    name = name;
    number = number;
    occupation = occupation;
    hasEntityUrn = hasEntityUrn;
    hasName = hasName;
    hasNumber = hasNumber;
    hasOccupation = hasOccupation;
  }
  
  public final NormCourse build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (NormCourse.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new NormCourse(entityUrn, name, number, occupation, hasEntityUrn, hasName, hasNumber, hasOccupation);
    } while (hasName);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormCourse", "name");
  }
  
  public final Builder setEntityUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasEntityUrn = false;
      entityUrn = null;
      return this;
    }
    hasEntityUrn = true;
    entityUrn = paramUrn;
    return this;
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
  
  public final Builder setNumber(String paramString)
  {
    if (paramString == null)
    {
      hasNumber = false;
      number = null;
      return this;
    }
    hasNumber = true;
    number = paramString;
    return this;
  }
  
  public final Builder setOccupation(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasOccupation = false;
      occupation = null;
      return this;
    }
    hasOccupation = true;
    occupation = paramUrn;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormCourse.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */