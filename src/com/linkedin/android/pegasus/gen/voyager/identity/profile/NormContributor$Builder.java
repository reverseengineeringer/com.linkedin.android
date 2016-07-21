package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class NormContributor$Builder
  implements RecordTemplateBuilder<NormContributor>
{
  private Urn entityUrn = null;
  private boolean hasEntityUrn = false;
  private boolean hasName = false;
  private boolean hasProfileUrn = false;
  private String name = null;
  private Urn profileUrn = null;
  
  public final NormContributor build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    int[] arrayOfInt = NormContributor.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
    paramFlavor.ordinal();
    return new NormContributor(entityUrn, name, profileUrn, hasEntityUrn, hasName, hasProfileUrn);
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
  
  public final Builder setProfileUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasProfileUrn = false;
      profileUrn = null;
      return this;
    }
    hasProfileUrn = true;
    profileUrn = paramUrn;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormContributor.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */