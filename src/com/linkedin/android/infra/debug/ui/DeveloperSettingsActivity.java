package com.linkedin.android.infra.debug.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import butterknife.ButterKnife;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.debug.models.DeveloperSettingType;
import com.linkedin.android.infra.shared.Util;
import javax.inject.Inject;

public class DeveloperSettingsActivity
  extends BaseActivity
{
  @Inject
  FlagshipSharedPreferences sharedPreferences;
  
  private void replaceFragment(Fragment paramFragment, String paramString)
  {
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    localFragmentTransaction.replace(2131756531, paramFragment, paramString);
    localFragmentTransaction.commit();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    int i = 0;
    super.onCreate(paramBundle);
    setContentView(2130968933);
    ButterKnife.inject(this);
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      paramBundle.setTitle(sharedPreferences.getBaseUrl());
      paramBundle.setNavigationMode$13462e();
      paramBundle.setDisplayShowTitleEnabled(true);
      paramBundle.setDisplayHomeAsUpEnabled(true);
    }
    paramBundle = getIntent().getExtras();
    if (paramBundle == null) {}
    String str;
    for (;;)
    {
      paramBundle = DeveloperSettingType.findType(i);
      str = paramBundle.name();
      switch (paramBundle)
      {
      default: 
        Util.safeThrow(new RuntimeException("You must set a DeveloperSettingType in the bundle"));
        finish();
        return;
        i = paramBundle.getInt("settingType", 0);
      }
    }
    replaceFragment(new SharedPreferenceDebugFragment(), str);
    return;
    replaceFragment(new CookieDebugFragment(), str);
    return;
    replaceFragment(new LixDebugFragment(), str);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finish();
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.debug.ui.DeveloperSettingsActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */