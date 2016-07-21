package com.linkedin.android.growth.samsung;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;

final class SamsungSyncConsentActivity$1
  implements View.OnClickListener
{
  SamsungSyncConsentActivity$1(SamsungSyncConsentActivity paramSamsungSyncConsentActivity) {}
  
  public final void onClick(View paramView)
  {
    this$0.getSupportFragmentManager().beginTransaction().replace(16908290, new SamsungSyncLearnMoreFragment()).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.samsung.SamsungSyncConsentActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */