package com.linkedin.android.pegasus.gen.voyager.identity.shared;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class MiniProfile$Builder
  implements RecordTemplateBuilder<MiniProfile>
{
  private Image backgroundImage = null;
  private Urn entityUrn = null;
  private String firstName = null;
  private boolean hasBackgroundImage = false;
  private boolean hasEntityUrn = false;
  private boolean hasFirstName = false;
  private boolean hasLastName = false;
  public boolean hasObjectUrn = false;
  private boolean hasOccupation = false;
  private boolean hasPicture = false;
  private boolean hasPublicIdentifier = false;
  public boolean hasTrackingId = false;
  private String lastName = null;
  public Urn objectUrn = null;
  private String occupation = null;
  private Image picture = null;
  private String publicIdentifier = null;
  public String trackingId = null;
  
  public final MiniProfile build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MiniProfile.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MiniProfile(trackingId, objectUrn, entityUrn, firstName, lastName, occupation, backgroundImage, picture, publicIdentifier, hasTrackingId, hasObjectUrn, hasEntityUrn, hasFirstName, hasLastName, hasOccupation, hasBackgroundImage, hasPicture, hasPublicIdentifier);
      if (!hasEntityUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile", "entityUrn");
      }
      if (!hasFirstName) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile", "firstName");
      }
    } while (hasPublicIdentifier);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile", "publicIdentifier");
  }
  
  public final Builder setBackgroundImage(Image paramImage)
  {
    if (paramImage == null)
    {
      hasBackgroundImage = false;
      backgroundImage = null;
      return this;
    }
    hasBackgroundImage = true;
    backgroundImage = paramImage;
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
  
  public final Builder setOccupation(String paramString)
  {
    if (paramString == null)
    {
      hasOccupation = false;
      occupation = null;
      return this;
    }
    hasOccupation = true;
    occupation = paramString;
    return this;
  }
  
  public final Builder setPicture(Image paramImage)
  {
    if (paramImage == null)
    {
      hasPicture = false;
      picture = null;
      return this;
    }
    hasPicture = true;
    picture = paramImage;
    return this;
  }
  
  public final Builder setPublicIdentifier(String paramString)
  {
    if (paramString == null)
    {
      hasPublicIdentifier = false;
      publicIdentifier = null;
      return this;
    }
    hasPublicIdentifier = true;
    publicIdentifier = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */