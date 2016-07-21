package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ProfileWebsite$Builder
  implements RecordTemplateBuilder<ProfileWebsite>
{
  private boolean hasType = false;
  private boolean hasUrl = false;
  private ProfileWebsite.Type type = null;
  private String url = null;
  
  public final ProfileWebsite build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ProfileWebsite.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ProfileWebsite(type, url, hasType, hasUrl);
    } while (hasType);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileWebsite", "type");
  }
  
  public final Builder setType(ProfileWebsite.Type paramType)
  {
    if (paramType == null)
    {
      hasType = false;
      type = null;
      return this;
    }
    hasType = true;
    type = paramType;
    return this;
  }
  
  public final Builder setUrl(String paramString)
  {
    if (paramString == null)
    {
      hasUrl = false;
      url = null;
      return this;
    }
    hasUrl = true;
    url = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileWebsite.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */