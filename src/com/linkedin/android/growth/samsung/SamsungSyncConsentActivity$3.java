package com.linkedin.android.growth.samsung;

import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;

final class SamsungSyncConsentActivity$3
  implements View.OnClickListener
{
  SamsungSyncConsentActivity$3(SamsungSyncConsentActivity paramSamsungSyncConsentActivity) {}
  
  public final void onClick(View paramView)
  {
    this$0.applicationComponent.flagshipSharedPreferences().setDevTokenUserSelection(false);
    this$0.finish();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.samsung.SamsungSyncConsentActivity.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */