package com.linkedin.android.identity.profile.view.treasury.detail;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.OnWindowFocusChangedListener;

public class TreasuryViewerActivity
  extends BaseActivity
{
  public void onBackPressed()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentById(16908290);
    if ((localFragment instanceof OnBackPressedListener)) {
      ((OnBackPressedListener)localFragment).onBackPressed();
    }
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 16)
    {
      View localView = getWindow().getDecorView();
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() | 0x100 | 0x400);
    }
    if (paramBundle != null) {
      return;
    }
    setContentView(2130969444);
    paramBundle = TreasuryViewerFragment.newInstance(getIntent().getExtras());
    getSupportFragmentManager().beginTransaction().add(16908290, paramBundle).commit();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    Fragment localFragment = getSupportFragmentManager().findFragmentById(16908290);
    if ((localFragment instanceof OnWindowFocusChangedListener)) {
      ((OnWindowFocusChangedListener)localFragment).onWindowFocusChanged$1385ff();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.treasury.detail.TreasuryViewerActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */