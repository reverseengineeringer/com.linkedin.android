package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzhb
public final class zzfu
  extends zzg<zzfw>
{
  private static final zzfu zzFp = new zzfu();
  
  private zzfu()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }
  
  public static zzfv createAdOverlay(Activity paramActivity)
  {
    zzfv localzzfv;
    do
    {
      try
      {
        localObject = paramActivity.getIntent();
        if (!((Intent)localObject).hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
          throw new zza("Ad overlay requires the useClientJar flag in intent extras.");
        }
      }
      catch (zza paramActivity)
      {
        zzb.zzaK(paramActivity.getMessage());
        localObject = null;
        return (zzfv)localObject;
      }
      if (((Intent)localObject).getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false)) {
        break;
      }
      localzzfv = zzFp.zzc(paramActivity);
      Object localObject = localzzfv;
    } while (localzzfv != null);
    zzb.zzaI("Using AdOverlay from the client jar.");
    paramActivity = zzcUzzup.createAdOverlay(paramActivity);
    return paramActivity;
  }
  
  private zzfv zzc(Activity paramActivity)
  {
    try
    {
      zzd localzzd = zze.zzC(paramActivity);
      paramActivity = zzfv.zza.zzL(((zzfw)zzaB(paramActivity)).zze(localzzd));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      zzb.zzd("Could not create remote AdOverlay.", paramActivity);
      return null;
    }
    catch (zzg.zza paramActivity)
    {
      zzb.zzd("Could not create remote AdOverlay.", paramActivity);
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
 * Qualified Name:     com.google.android.gms.internal.zzfu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */