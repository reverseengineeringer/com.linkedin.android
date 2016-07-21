package com.linkedin.android.growth.boost;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.growth.boost.error.BoostErrorFragment;
import com.linkedin.android.infra.app.BaseActivity;

public class BoostActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968929);
    getSupportFragmentManager().beginTransaction().add(2131756509, new BoostErrorFragment()).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.BoostActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */