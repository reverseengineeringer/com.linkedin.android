package com.linkedin.android.infra.settings.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.settings.SettingsFragmentFactory;
import com.linkedin.android.infra.shared.OnBackPressedListener;

public class SettingsActivity
  extends BaseActivity
{
  public void onBackPressed()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentById(2131756509);
    if (((localFragment instanceof OnBackPressedListener)) && (((OnBackPressedListener)localFragment).onBackPressed())) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968929);
    if (paramBundle == null)
    {
      paramBundle = getSupportFragmentManager().beginTransaction();
      new SettingsFragmentFactory();
      paramBundle.add(2131756509, new SettingsFragment()).commit();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.settings.ui.SettingsActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */