package com.linkedin.android.growth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.network.Auth;
import javax.inject.Inject;

public class SendInviteActivity
  extends BaseActivity
{
  @Inject
  Auth auth;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    activityComponent.inject(this);
    setContentView(2130968929);
    if (auth.isAuthenticated())
    {
      paramBundle = SendInviteFragment.newInstance(new SendInviteBundleBuilder(getIntent().getExtras()));
      getSupportFragmentManager().beginTransaction().add(2131756509, paramBundle).commit();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.SendInviteActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */