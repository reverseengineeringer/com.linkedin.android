package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.GoogleApiClient.zza;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzrn;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class zzh$zzb
  extends zzh.zzf
{
  private final Map<Api.zzb, GoogleApiClient.zza> zzahE;
  
  public zzh$zzb(Map<Api.zzb, GoogleApiClient.zza> paramMap)
  {
    super(paramMap, (byte)0);
    Map localMap;
    zzahE = localMap;
  }
  
  public final void zzpt()
  {
    int i = zzahC.zzags.isGooglePlayServicesAvailable(zzahC.mContext);
    final Object localObject;
    if (i != 0)
    {
      localObject = new ConnectionResult(i, null);
      zzahC.zzahj.zza(new zzl.zza(zzahC)
      {
        public final void zzpt()
        {
          zzahC.zzg(localObject);
        }
      });
    }
    for (;;)
    {
      return;
      if (zzahC.zzahu) {
        zzahC.zzahs.connect();
      }
      localObject = zzahE.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Api.zzb localzzb = (Api.zzb)((Iterator)localObject).next();
        localzzb.zza((GoogleApiClient.zza)zzahE.get(localzzb));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzh.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */