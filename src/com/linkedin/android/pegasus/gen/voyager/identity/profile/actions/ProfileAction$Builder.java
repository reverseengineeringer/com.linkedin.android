package com.linkedin.android.pegasus.gen.voyager.identity.profile.actions;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ProfileAction$Builder
  implements RecordTemplateBuilder<ProfileAction>
{
  private ProfileAction.Action action = null;
  private boolean hasAction = false;
  private boolean hasType = false;
  private ActionType type = null;
  
  public ProfileAction$Builder() {}
  
  public ProfileAction$Builder(ProfileAction paramProfileAction)
  {
    action = action;
    type = type;
    hasAction = hasAction;
    hasType = hasType;
  }
  
  public final ProfileAction build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ProfileAction.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ProfileAction(action, type, hasAction, hasType);
    } while (hasAction);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileAction", "action");
  }
  
  public final Builder setAction(ProfileAction.Action paramAction)
  {
    if (paramAction == null)
    {
      hasAction = false;
      action = null;
      return this;
    }
    hasAction = true;
    action = paramAction;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileAction.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */