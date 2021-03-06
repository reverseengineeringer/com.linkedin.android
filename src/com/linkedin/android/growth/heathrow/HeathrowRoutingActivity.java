package com.linkedin.android.growth.heathrow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;

public class HeathrowRoutingActivity
  extends BaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    activityComponent.inject(this);
    setContentView(2130968929);
    if ((paramBundle == null) && (getIntent() != null))
    {
      paramBundle = HeathrowRoutingFragment.newInstance(new HeathrowRoutingIntentBundle(getIntent().getExtras()));
      getSupportFragmentManager().beginTransaction().add(2131756509, paramBundle).commit();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.heathrow.HeathrowRoutingActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */