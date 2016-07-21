package com.linkedin.android.identity.shared;

import android.os.Bundle;
import android.view.View;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.shared.MemberUtil;

public abstract class ProfileBaseFragment
  extends PageFragment
{
  public String externalIdentifier;
  public ProfileDataProvider profileDataProvider;
  public String profileId;
  public String publicIdentifier;
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getActivityactivityComponent;
    profileDataProvider = paramView.profileDataProvider();
    paramBundle = getArguments();
    if (paramBundle.getBoolean("selfProfile")) {
      if (!applicationComponent.auth().isAuthenticated()) {
        return;
      }
    }
    for (profileId = paramView.memberUtil().getProfileId();; profileId = paramBundle.getString("profileId"))
    {
      publicIdentifier = paramBundle.getString("publicIdentifier");
      externalIdentifier = paramBundle.getString("externalIdentifier");
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.shared.ProfileBaseFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */