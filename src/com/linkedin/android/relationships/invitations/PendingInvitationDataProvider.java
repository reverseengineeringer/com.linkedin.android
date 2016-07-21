package com.linkedin.android.relationships.invitations;

import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import javax.inject.Inject;

public final class PendingInvitationDataProvider
  extends DataProvider<PendingInvitationDataProvider.State, DataProvider.DataProviderListener>
{
  @Inject
  ProfilePendingConnectionRequestManager profilePendingConnectionRequestManager;
  
  @Inject
  public PendingInvitationDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.invitations.PendingInvitationDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */