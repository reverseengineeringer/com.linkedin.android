package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class NormProfile$Builder
  implements RecordTemplateBuilder<NormProfile>
{
  public String address = null;
  private BackgroundImage backgroundImage = null;
  private Date birthDate = null;
  public String contactInstructions = null;
  private Urn entityUrn = null;
  private String firstName = null;
  public boolean hasAddress = false;
  private boolean hasBackgroundImage = false;
  private boolean hasBirthDate = false;
  public boolean hasContactInstructions = false;
  private boolean hasEntityUrn = false;
  private boolean hasFirstName = false;
  private boolean hasHeadline = false;
  private boolean hasIndustryName = false;
  private boolean hasIndustryUrn = false;
  public boolean hasInterests = false;
  private boolean hasLastName = false;
  private boolean hasLocation = false;
  public boolean hasMaidenName = false;
  private boolean hasPhoneticFirstName = false;
  private boolean hasPhoneticLastName = false;
  private boolean hasPictureInfo = false;
  private boolean hasSummary = false;
  private String headline = null;
  private String industryName = null;
  private Urn industryUrn = null;
  public String interests = null;
  private String lastName = null;
  private ProfileLocation location = null;
  public String maidenName = null;
  private String phoneticFirstName = null;
  private String phoneticLastName = null;
  private Picture pictureInfo = null;
  private String summary = null;
  
  public NormProfile$Builder() {}
  
  public NormProfile$Builder(NormProfile paramNormProfile)
  {
    entityUrn = entityUrn;
    firstName = firstName;
    lastName = lastName;
    maidenName = maidenName;
    headline = headline;
    industryName = industryName;
    industryUrn = industryUrn;
    location = location;
    backgroundImage = backgroundImage;
    pictureInfo = pictureInfo;
    phoneticFirstName = phoneticFirstName;
    phoneticLastName = phoneticLastName;
    contactInstructions = contactInstructions;
    interests = interests;
    address = address;
    birthDate = birthDate;
    summary = summary;
    hasEntityUrn = hasEntityUrn;
    hasFirstName = hasFirstName;
    hasLastName = hasLastName;
    hasMaidenName = hasMaidenName;
    hasHeadline = hasHeadline;
    hasIndustryName = hasIndustryName;
    hasIndustryUrn = hasIndustryUrn;
    hasLocation = hasLocation;
    hasBackgroundImage = hasBackgroundImage;
    hasPictureInfo = hasPictureInfo;
    hasPhoneticFirstName = hasPhoneticFirstName;
    hasPhoneticLastName = hasPhoneticLastName;
    hasContactInstructions = hasContactInstructions;
    hasInterests = hasInterests;
    hasAddress = hasAddress;
    hasBirthDate = hasBirthDate;
    hasSummary = hasSummary;
  }
  
  public final NormProfile build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (NormProfile.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new NormProfile(entityUrn, firstName, lastName, maidenName, headline, industryName, industryUrn, location, backgroundImage, pictureInfo, phoneticFirstName, phoneticLastName, contactInstructions, interests, address, birthDate, summary, hasEntityUrn, hasFirstName, hasLastName, hasMaidenName, hasHeadline, hasIndustryName, hasIndustryUrn, hasLocation, hasBackgroundImage, hasPictureInfo, hasPhoneticFirstName, hasPhoneticLastName, hasContactInstructions, hasInterests, hasAddress, hasBirthDate, hasSummary);
    } while (hasFirstName);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile", "firstName");
  }
  
  public final Builder setBackgroundImage(BackgroundImage paramBackgroundImage)
  {
    if (paramBackgroundImage == null)
    {
      hasBackgroundImage = false;
      backgroundImage = null;
      return this;
    }
    hasBackgroundImage = true;
    backgroundImage = paramBackgroundImage;
    return this;
  }
  
  public final Builder setBirthDate(Date paramDate)
  {
    if (paramDate == null)
    {
      hasBirthDate = false;
      birthDate = null;
      return this;
    }
    hasBirthDate = true;
    birthDate = paramDate;
    return this;
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
  
  public final Builder setFirstName(String paramString)
  {
    if (paramString == null)
    {
      hasFirstName = false;
      firstName = null;
      return this;
    }
    hasFirstName = true;
    firstName = paramString;
    return this;
  }
  
  public final Builder setHeadline(String paramString)
  {
    if (paramString == null)
    {
      hasHeadline = false;
      headline = null;
      return this;
    }
    hasHeadline = true;
    headline = paramString;
    return this;
  }
  
  public final Builder setIndustryName(String paramString)
  {
    if (paramString == null)
    {
      hasIndustryName = false;
      industryName = null;
      return this;
    }
    hasIndustryName = true;
    industryName = paramString;
    return this;
  }
  
  public final Builder setIndustryUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasIndustryUrn = false;
      industryUrn = null;
      return this;
    }
    hasIndustryUrn = true;
    industryUrn = paramUrn;
    return this;
  }
  
  public final Builder setLastName(String paramString)
  {
    if (paramString == null)
    {
      hasLastName = false;
      lastName = null;
      return this;
    }
    hasLastName = true;
    lastName = paramString;
    return this;
  }
  
  public final Builder setLocation(ProfileLocation paramProfileLocation)
  {
    if (paramProfileLocation == null)
    {
      hasLocation = false;
      location = null;
      return this;
    }
    hasLocation = true;
    location = paramProfileLocation;
    return this;
  }
  
  public final Builder setPhoneticFirstName(String paramString)
  {
    if (paramString == null)
    {
      hasPhoneticFirstName = false;
      phoneticFirstName = null;
      return this;
    }
    hasPhoneticFirstName = true;
    phoneticFirstName = paramString;
    return this;
  }
  
  public final Builder setPhoneticLastName(String paramString)
  {
    if (paramString == null)
    {
      hasPhoneticLastName = false;
      phoneticLastName = null;
      return this;
    }
    hasPhoneticLastName = true;
    phoneticLastName = paramString;
    return this;
  }
  
  public final Builder setPictureInfo(Picture paramPicture)
  {
    if (paramPicture == null)
    {
      hasPictureInfo = false;
      pictureInfo = null;
      return this;
    }
    hasPictureInfo = true;
    pictureInfo = paramPicture;
    return this;
  }
  
  public final Builder setSummary(String paramString)
  {
    if (paramString == null)
    {
      hasSummary = false;
      summary = null;
      return this;
    }
    hasSummary = true;
    summary = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */