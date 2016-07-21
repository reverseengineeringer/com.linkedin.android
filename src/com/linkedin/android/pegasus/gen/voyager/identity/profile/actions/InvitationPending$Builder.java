package com.linkedin.android.pegasus.gen.voyager.identity.profile.actions;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class InvitationPending$Builder
  implements RecordTemplateBuilder<InvitationPending>
{
  public static InvitationPending build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    int[] arrayOfInt = InvitationPending.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor;
    paramFlavor.ordinal();
    return new InvitationPending();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.InvitationPending.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */