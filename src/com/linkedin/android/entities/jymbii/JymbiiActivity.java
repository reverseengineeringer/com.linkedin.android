package com.linkedin.android.entities.jymbii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;

public class JymbiiActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    activityComponent.inject(this);
    setContentView(2130968929);
    if (paramBundle == null)
    {
      paramBundle = JymbiiFragment.newInstance(new JymbiiBundleBuilder(getIntent().getExtras()));
      getSupportFragmentManager().beginTransaction().add(2131756509, paramBundle).commit();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.jymbii.JymbiiActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */