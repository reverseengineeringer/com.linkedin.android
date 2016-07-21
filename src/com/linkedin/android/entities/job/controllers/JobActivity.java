package com.linkedin.android.entities.job.controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.entities.EntityBaseActivity;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.job.JobBundleBuilder;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.lix.Lix;

public class JobActivity
  extends EntityBaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    activityComponent.inject(this);
    if (paramBundle == null) {
      if (!EntityUtils.isLixEnabled(activityComponent.lixManager(), Lix.ENTITIES_JOBS_USE_FRONTEND_DECO_API)) {
        break label69;
      }
    }
    label69:
    for (paramBundle = JobFragmentV2.newInstance(JobBundleBuilder.create(getIntent().getExtras()));; paramBundle = JobFragment.newInstance(JobBundleBuilder.create(getIntent().getExtras())))
    {
      getSupportFragmentManager().beginTransaction().add(2131756509, paramBundle).commit();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.controllers.JobActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */