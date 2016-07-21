package com.linkedin.android.identity.me.contentanalytics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.app.BaseActivity;

public class ContentAnalyticsActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968929);
    if (getSupportFragmentManager().findFragmentById(2131756509) == null)
    {
      paramBundle = ContentAnalyticsFragment.newInstance(getIntent().getExtras());
      getSupportFragmentManager().beginTransaction().add(2131756509, paramBundle).commit();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.contentanalytics.ContentAnalyticsActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */