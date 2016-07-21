package com.linkedin.android.pegasus.gen.voyager.identity.profile.actions;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ProfileActions$Builder
  implements RecordTemplateBuilder<ProfileActions>
{
  private List<ProfileAction> actions = null;
  private Urn entityUrn = null;
  private boolean hasActions = false;
  private boolean hasEntityUrn = false;
  public boolean hasOverflowActions = false;
  private boolean hasPrimaryAction = false;
  private boolean hasSecondaryAction = false;
  public List<ProfileAction> overflowActions = null;
  private ProfileAction primaryAction = null;
  private ProfileAction secondaryAction = null;
  
  public ProfileActions$Builder() {}
  
  public ProfileActions$Builder(ProfileActions paramProfileActions)
  {
    entityUrn = entityUrn;
    primaryAction = primaryAction;
    secondaryAction = secondaryAction;
    overflowActions = overflowActions;
    actions = actions;
    hasEntityUrn = hasEntityUrn;
    hasPrimaryAction = hasPrimaryAction;
    hasSecondaryAction = hasSecondaryAction;
    hasOverflowActions = hasOverflowActions;
    hasActions = hasActions;
  }
  
  public final ProfileActions build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ProfileActions.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (overflowActions != null)
    {
      paramFlavor = overflowActions.iterator();
      do
      {
        if (!paramFlavor.hasNext()) {
          break;
        }
      } while ((ProfileAction)paramFlavor.next() != null);
      throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileActions", "overflowActions");
      if (!hasOverflowActions) {
        overflowActions = Collections.emptyList();
      }
      if (!hasActions) {
        actions = Collections.emptyList();
      }
    }
    if (actions != null)
    {
      paramFlavor = actions.iterator();
      while (paramFlavor.hasNext()) {
        if ((ProfileAction)paramFlavor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileActions", "actions");
        }
      }
    }
    return new ProfileActions(entityUrn, primaryAction, secondaryAction, overflowActions, actions, hasEntityUrn, hasPrimaryAction, hasSecondaryAction, hasOverflowActions, hasActions);
  }
  
  public final Builder setPrimaryAction(ProfileAction paramProfileAction)
  {
    if (paramProfileAction == null)
    {
      hasPrimaryAction = false;
      primaryAction = null;
      return this;
    }
    hasPrimaryAction = true;
    primaryAction = paramProfileAction;
    return this;
  }
  
  public final Builder setSecondaryAction(ProfileAction paramProfileAction)
  {
    if (paramProfileAction == null)
    {
      hasSecondaryAction = false;
      secondaryAction = null;
      return this;
    }
    hasSecondaryAction = true;
    secondaryAction = paramProfileAction;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileActions.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */