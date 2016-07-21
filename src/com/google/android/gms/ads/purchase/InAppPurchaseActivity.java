package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzgj;
import com.google.android.gms.internal.zzin;

public class InAppPurchaseActivity
  extends Activity
{
  private zzge zzOw;
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    try
    {
      if (zzOw != null) {
        zzOw.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzin.zzd("Could not forward onActivityResult to in-app purchase manager:", localRemoteException);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    zzOw = zzgj.createInAppPurchaseManager(this);
    if (zzOw == null)
    {
      zzin.zzaK("Could not create in-app purchase manager.");
      finish();
      return;
    }
    try
    {
      zzOw.onCreate();
      return;
    }
    catch (RemoteException paramBundle)
    {
      zzin.zzd("Could not forward onCreate to in-app purchase manager:", paramBundle);
      finish();
    }
  }
  
  protected void onDestroy()
  {
    try
    {
      if (zzOw != null) {
        zzOw.onDestroy();
      }
      super.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzin.zzd("Could not forward onDestroy to in-app purchase manager:", localRemoteException);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.purchase.InAppPurchaseActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */