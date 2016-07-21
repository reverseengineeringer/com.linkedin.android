package com.linkedin.android.infra.app;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.security.ProviderInstaller.ProviderInstallListener;
import java.lang.ref.WeakReference;

final class BaseActivity$4
  implements ProviderInstaller.ProviderInstallListener
{
  BaseActivity$4(BaseActivity paramBaseActivity, WeakReference paramWeakReference) {}
  
  public final void onProviderInstallFailed$10b55c15(int paramInt)
  {
    if (GooglePlayServicesUtil.isUserRecoverableError(paramInt))
    {
      BaseActivity localBaseActivity = (BaseActivity)val$activityWeakReference.get();
      if ((localBaseActivity != null) && (localBaseActivity.canExecuteFragmentTransactions())) {
        GooglePlayServicesUtil.showErrorDialogFragment(paramInt, localBaseActivity, 1, new BaseActivity.4.1(this));
      }
      BaseActivity.access$302$138603();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.BaseActivity.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */