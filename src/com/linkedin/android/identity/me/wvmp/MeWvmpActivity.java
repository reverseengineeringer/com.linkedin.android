package com.linkedin.android.identity.me.wvmp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.identity.me.shared.actions.MeActionBundleBuilder;
import com.linkedin.android.identity.me.shared.actions.MeActionBundleBuilder.Action;
import com.linkedin.android.identity.me.shared.actions.events.MePostExecuteActionEvent;
import com.linkedin.android.identity.me.wvmpV2.WvmpFragment;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import java.util.Collections;

public class MeWvmpActivity
  extends BaseActivity
{
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 51) && (paramInt2 == -1))
    {
      activityComponent.eventBus();
      MePostExecuteActionEvent.replaceCardClickPostExecuteActions$14130d1(Collections.singletonList(MeActionBundleBuilder.create(MeActionBundleBuilder.Action.UPDATE_CACHED_CARD)));
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968929);
    if (getSupportFragmentManager().findFragmentById(2131756509) == null) {
      if (!"enabled".equals(activityComponent.lixManager().getTreatment(Lix.ME_WVMP_V2))) {
        break label70;
      }
    }
    label70:
    for (paramBundle = WvmpFragment.newInstance();; paramBundle = MeWvmpFragment.newInstance())
    {
      getSupportFragmentManager().beginTransaction().add(2131756509, paramBundle).commit();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.wvmp.MeWvmpActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */