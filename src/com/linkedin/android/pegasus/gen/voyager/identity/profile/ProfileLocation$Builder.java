package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.NormBasicLocation;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ProfileLocation$Builder
  implements RecordTemplateBuilder<ProfileLocation>
{
  private NormBasicLocation basicLocation = null;
  private boolean hasBasicLocation = false;
  private boolean hasPreferredGeoPlace = false;
  private Urn preferredGeoPlace = null;
  
  public ProfileLocation$Builder() {}
  
  public ProfileLocation$Builder(ProfileLocation paramProfileLocation)
  {
    basicLocation = basicLocation;
    preferredGeoPlace = preferredGeoPlace;
    hasBasicLocation = hasBasicLocation;
    hasPreferredGeoPlace = hasPreferredGeoPlace;
  }
  
  public final ProfileLocation build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ProfileLocation.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ProfileLocation(basicLocation, preferredGeoPlace, hasBasicLocation, hasPreferredGeoPlace);
    } while (hasBasicLocation);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileLocation", "basicLocation");
  }
  
  public final Builder setBasicLocation(NormBasicLocation paramNormBasicLocation)
  {
    if (paramNormBasicLocation == null)
    {
      hasBasicLocation = false;
      basicLocation = null;
      return this;
    }
    hasBasicLocation = true;
    basicLocation = paramNormBasicLocation;
    return this;
  }
  
  public final Builder setPreferredGeoPlace(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasPreferredGeoPlace = false;
      preferredGeoPlace = null;
      return this;
    }
    hasPreferredGeoPlace = true;
    preferredGeoPlace = paramUrn;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileLocation.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */