package com.linkedin.android.entities.group.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.entities.EntityBaseActivity;
import com.linkedin.android.entities.group.GroupBundleBuilder;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;

public class GroupActivity
  extends EntityBaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    activityComponent.inject(this);
    if (paramBundle == null)
    {
      paramBundle = GroupFragment.newInstance(new GroupBundleBuilder(getIntent().getExtras()));
      getSupportFragmentManager().beginTransaction().add(2131756509, paramBundle).commit();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.controllers.GroupActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */