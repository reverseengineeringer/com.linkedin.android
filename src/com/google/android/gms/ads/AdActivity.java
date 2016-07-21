package com.google.android.gms.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzfu;
import com.google.android.gms.internal.zzfv;

public class AdActivity
  extends Activity
{
  private zzfv zzoA;
  
  private void zzaD()
  {
    if (zzoA != null) {}
    try
    {
      zzoA.zzaD();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward setContentViewSet to ad overlay:", localRemoteException);
    }
  }
  
  public void onBackPressed()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    try
    {
      if (zzoA != null) {
        bool1 = zzoA.zzfn();
      }
      if (bool1) {
        super.onBackPressed();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzb.zzd("Could not forward onBackPressed to ad overlay:", localRemoteException);
        bool1 = bool2;
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    zzoA = zzfu.createAdOverlay(this);
    if (zzoA == null)
    {
      zzb.zzaK("Could not create ad overlay.");
      finish();
      return;
    }
    try
    {
      zzoA.onCreate(paramBundle);
      return;
    }
    catch (RemoteException paramBundle)
    {
      zzb.zzd("Could not forward onCreate to ad overlay:", paramBundle);
      finish();
    }
  }
  
  protected void onDestroy()
  {
    try
    {
      if (zzoA != null) {
        zzoA.onDestroy();
      }
      super.onDestroy();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzb.zzd("Could not forward onDestroy to ad overlay:", localRemoteException);
      }
    }
  }
  
  protected void onPause()
  {
    try
    {
      if (zzoA != null) {
        zzoA.onPause();
      }
      super.onPause();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzb.zzd("Could not forward onPause to ad overlay:", localRemoteException);
        finish();
      }
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    try
    {
      if (zzoA != null) {
        zzoA.onRestart();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward onRestart to ad overlay:", localRemoteException);
      finish();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    try
    {
      if (zzoA != null) {
        zzoA.onResume();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward onResume to ad overlay:", localRemoteException);
      finish();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    try
    {
      if (zzoA != null) {
        zzoA.onSaveInstanceState(paramBundle);
      }
      super.onSaveInstanceState(paramBundle);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzb.zzd("Could not forward onSaveInstanceState to ad overlay:", localRemoteException);
        finish();
      }
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    try
    {
      if (zzoA != null) {
        zzoA.onStart();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward onStart to ad overlay:", localRemoteException);
      finish();
    }
  }
  
  protected void onStop()
  {
    try
    {
      if (zzoA != null) {
        zzoA.onStop();
      }
      super.onStop();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzb.zzd("Could not forward onStop to ad overlay:", localRemoteException);
        finish();
      }
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    zzaD();
  }
  
  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
    zzaD();
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
    zzaD();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.AdActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */