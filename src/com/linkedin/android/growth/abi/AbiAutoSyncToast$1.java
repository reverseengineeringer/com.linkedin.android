package com.linkedin.android.growth.abi;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;

final class AbiAutoSyncToast$1
  implements View.OnClickListener
{
  AbiAutoSyncToast$1(BaseActivity paramBaseActivity, ActivityComponent paramActivityComponent, String paramString) {}
  
  public final void onClick(View paramView)
  {
    val$activity.startActivity(val$activityComponent.intentRegistry().abi.newIntent(val$activity, new AbiIntentBundle().abookImportTransactionId(val$abookImportTransactionId).abiSource("mobile-voyager-autosync-toast")));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiAutoSyncToast.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */