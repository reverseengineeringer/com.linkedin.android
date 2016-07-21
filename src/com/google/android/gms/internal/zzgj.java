package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzhb
public final class zzgj
  extends zzg<zzgf>
{
  private static final zzgj zzGa = new zzgj();
  
  private zzgj()
  {
    super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
  }
  
  public static zzge createInAppPurchaseManager(Activity paramActivity)
  {
    zzge localzzge;
    do
    {
      try
      {
        localObject = paramActivity.getIntent();
        if (!((Intent)localObject).hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
          throw new zza("InAppPurchaseManager requires the useClientJar flag in intent extras.");
        }
      }
      catch (zza paramActivity)
      {
        zzin.zzaK(paramActivity.getMessage());
        localObject = null;
        return (zzge)localObject;
      }
      if (((Intent)localObject).getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false)) {
        break;
      }
      localzzge = zzGa.zzd(paramActivity);
      Object localObject = localzzge;
    } while (localzzge != null);
    zzin.zzaI("Using AdOverlay from the client jar.");
    paramActivity = zzcUzzup.createInAppPurchaseManager(paramActivity);
    return paramActivity;
  }
  
  private zzge zzd(Activity paramActivity)
  {
    try
    {
      zzd localzzd = zze.zzC(paramActivity);
      paramActivity = zzge.zza.zzQ(((zzgf)zzaB(paramActivity)).zzf(localzzd));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      zzin.zzd("Could not create remote InAppPurchaseManager.", paramActivity);
      return null;
    }
    catch (zzg.zza paramActivity)
    {
      zzin.zzd("Could not create remote InAppPurchaseManager.", paramActivity);
    }
    return null;
  }
  
  private static final class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzgj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */