package com.linkedin.android.identity.edit;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;

public class ProfileSkillsEditHostActivity
  extends BaseActivity
  implements ProfileEditListener
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130969234);
    if (paramBundle != null) {
      return;
    }
    if ("enabled".equals(activityComponent.lixManager().getTreatment(Lix.LIX_PROFILE_VIEW_FEATURED_SKILLS_CARD)))
    {
      ProfileEditFragmentUtils.startEditFeaturedSkills(this, true);
      return;
    }
    ProfileEditFragmentUtils.startEditSkills(this, true);
  }
  
  public final void onExitEdit()
  {
    if (getSupportFragmentManager().getBackStackEntryCount() > 1)
    {
      getSupportFragmentManager().popBackStack();
      return;
    }
    finish();
  }
  
  public final void startEditFragment(ProfileEditBaseFragment paramProfileEditBaseFragment)
  {
    getSupportFragmentManager().beginTransaction().replace(2131757804, paramProfileEditBaseFragment).addToBackStack(null).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileSkillsEditHostActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */