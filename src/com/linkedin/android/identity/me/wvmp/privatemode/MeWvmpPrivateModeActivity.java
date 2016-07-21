package com.linkedin.android.identity.me.wvmp.privatemode;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.app.BaseActivity;

public class MeWvmpPrivateModeActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968929);
    if (getSupportFragmentManager().findFragmentById(2131756509) == null)
    {
      paramBundle = MeWvmpPrivateModeFragment.newInstance();
      getSupportFragmentManager().beginTransaction().add(2131756509, paramBundle).commit();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.wvmp.privatemode.MeWvmpPrivateModeActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */