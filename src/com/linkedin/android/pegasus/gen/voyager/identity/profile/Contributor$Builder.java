package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Contributor$Builder
  implements RecordTemplateBuilder<Contributor>
{
  private Urn entityUrn = null;
  private boolean hasEntityUrn = false;
  private boolean hasMember = false;
  private boolean hasName = false;
  private boolean hasProfileUrn = false;
  private MiniProfile member = null;
  private String name = null;
  private Urn profileUrn = null;
  
  public final Contributor build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    int[] arrayOfInt = Contributor.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
    paramFlavor.ordinal();
    return new Contributor(entityUrn, name, profileUrn, member, hasEntityUrn, hasName, hasProfileUrn, hasMember);
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
  
  public final Builder setMember(MiniProfile paramMiniProfile)
  {
    if (paramMiniProfile == null)
    {
      hasMember = false;
      member = null;
      return this;
    }
    hasMember = true;
    member = paramMiniProfile;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Contributor.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */