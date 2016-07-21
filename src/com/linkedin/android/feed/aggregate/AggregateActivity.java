package com.linkedin.android.feed.aggregate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.app.BaseActivity;

public class AggregateActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968943);
    if (getSupportFragmentManager().findFragmentById(16908290) == null)
    {
      paramBundle = new AggregateFragment();
      paramBundle.setArguments(getIntent().getExtras());
      getSupportFragmentManager().beginTransaction().add(16908290, paramBundle).commit();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.aggregate.AggregateActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */