package com.linkedin.android.identity.me.shared.profilehost;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.identity.edit.ProfileEditBaseFragment;
import com.linkedin.android.identity.edit.ProfileEditFragmentUtils;
import com.linkedin.android.identity.edit.ProfileEditListener;
import com.linkedin.android.identity.profile.view.connections.ConnectionsContainerFragment;
import com.linkedin.android.identity.profile.view.connections.ConnectionsContainerFragmentBundleBuilder;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.network.I18NManager;

public class MeProfileHostActivity
  extends BaseActivity
  implements ProfileEditListener
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968929);
    int j;
    I18NManager localI18NManager;
    int i;
    if (paramBundle == null)
    {
      paramBundle = getIntent();
      j = paramBundle.getExtras().getInt("profile_mode", 0);
      localI18NManager = activityComponent.i18NManager();
      if (paramBundle.getExtras().getString("profile_id") != null) {
        break label89;
      }
      i = 1;
    }
    while (i != 0) {
      switch (j)
      {
      default: 
        finish();
        return;
        i = 0;
        break;
      case 0: 
        ProfileEditFragmentUtils.startEditBasicProfile(this);
        return;
      case 1: 
        label89:
        ProfileEditFragmentUtils.startEditSkills(this, true);
        return;
      }
    }
    String str = paramBundle.getExtras().getString("profile_id");
    switch (j)
    {
    }
    do
    {
      finish();
      return;
      i = paramBundle.getExtras().getInt("num_connections", -1);
    } while (i < 0);
    paramBundle = ConnectionsContainerFragment.newInstance(ConnectionsContainerFragmentBundleBuilder.create(str, localI18NManager.getString(2131233092), 1, 1, 0, i));
    getSupportFragmentManager().beginTransaction().add(2131756509, paramBundle).commit();
  }
  
  public final void onExitEdit()
  {
    finish();
  }
  
  public final void startEditFragment(ProfileEditBaseFragment paramProfileEditBaseFragment)
  {
    getSupportFragmentManager().beginTransaction().add(2131756509, paramProfileEditBaseFragment).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.shared.profilehost.MeProfileHostActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */