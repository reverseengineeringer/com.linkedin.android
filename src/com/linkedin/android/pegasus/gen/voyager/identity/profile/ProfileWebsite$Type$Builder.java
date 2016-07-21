package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.UnionMemberCountException;

public final class ProfileWebsite$Type$Builder
{
  private CustomWebsite customWebsiteValue = null;
  private boolean hasCustomWebsiteValue = false;
  private boolean hasStandardWebsiteValue = false;
  private StandardWebsite standardWebsiteValue = null;
  
  public final ProfileWebsite.Type build()
    throws BuilderException
  {
    int i = 0;
    if (hasStandardWebsiteValue) {
      i = 0 + 1;
    }
    int j = i;
    if (hasCustomWebsiteValue) {
      j = i + 1;
    }
    if (j > 1) {
      throw new UnionMemberCountException("Type", 2);
    }
    return new ProfileWebsite.Type(standardWebsiteValue, customWebsiteValue, hasStandardWebsiteValue, hasCustomWebsiteValue);
  }
  
  public final Builder setCustomWebsiteValue(CustomWebsite paramCustomWebsite)
  {
    if (paramCustomWebsite == null)
    {
      hasCustomWebsiteValue = false;
      customWebsiteValue = null;
      return this;
    }
    hasCustomWebsiteValue = true;
    customWebsiteValue = paramCustomWebsite;
    return this;
  }
  
  public final Builder setStandardWebsiteValue(StandardWebsite paramStandardWebsite)
  {
    if (paramStandardWebsite == null)
    {
      hasStandardWebsiteValue = false;
      standardWebsiteValue = null;
      return this;
    }
    hasStandardWebsiteValue = true;
    standardWebsiteValue = paramStandardWebsite;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileWebsite.Type.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */