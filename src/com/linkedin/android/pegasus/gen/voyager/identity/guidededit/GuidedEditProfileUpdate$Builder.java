package com.linkedin.android.pegasus.gen.voyager.identity.guidededit;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class GuidedEditProfileUpdate$Builder
  implements RecordTemplateBuilder<GuidedEditProfileUpdate>
{
  public boolean hasProfileUpdate = false;
  public GuidedEditProfileUpdate.ProfileUpdate profileUpdate = null;
  
  public final GuidedEditProfileUpdate build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (GuidedEditProfileUpdate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new GuidedEditProfileUpdate(profileUpdate, hasProfileUpdate);
    } while (hasProfileUpdate);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditProfileUpdate", "profileUpdate");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditProfileUpdate.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */