package com.linkedin.android.identity.me.shared.actorlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.app.BaseActivity;

public class MeActorListActivity
  extends BaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968943);
    if (paramBundle == null) {
      getSupportFragmentManager().beginTransaction().replace(16908290, MeActorListFragment.newInstance(getIntent().getExtras())).commit();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.shared.actorlist.MeActorListActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */