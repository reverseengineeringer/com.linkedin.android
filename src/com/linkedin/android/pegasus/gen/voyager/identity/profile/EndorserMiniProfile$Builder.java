package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class EndorserMiniProfile$Builder
  implements RecordTemplateBuilder<EndorserMiniProfile>
{
  private MemberDistance distance = null;
  private boolean hasDistance = false;
  private boolean hasMiniProfile = false;
  private MiniProfile miniProfile = null;
  
  public final EndorserMiniProfile build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (EndorserMiniProfile.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new EndorserMiniProfile(miniProfile, distance, hasMiniProfile, hasDistance);
    } while (hasMiniProfile);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorserMiniProfile", "miniProfile");
  }
  
  public final Builder setMiniProfile(MiniProfile paramMiniProfile)
  {
    if (paramMiniProfile == null)
    {
      hasMiniProfile = false;
      miniProfile = null;
      return this;
    }
    hasMiniProfile = true;
    miniProfile = paramMiniProfile;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorserMiniProfile.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */