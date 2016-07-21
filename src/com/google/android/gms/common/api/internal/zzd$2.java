package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

final class zzd$2
  implements zzp.zza
{
  zzd$2(zzd paramzzd) {}
  
  public final void zzc(int paramInt, boolean paramBoolean)
  {
    zzahh.zzXG.lock();
    try
    {
      if (zzahh.zzahf)
      {
        zzahh.zzahf = false;
        zzd.zza(zzahh, paramInt, paramBoolean);
        return;
      }
      zzahh.zzahf = true;
      zzahh.zzagX.onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      zzahh.zzXG.unlock();
    }
  }
  
  public final void zzd(ConnectionResult paramConnectionResult)
  {
    zzahh.zzXG.lock();
    try
    {
      zzahh.zzahe = paramConnectionResult;
      zzd.zzb(zzahh);
      return;
    }
    finally
    {
      zzahh.zzXG.unlock();
    }
  }
  
  public final void zzi(Bundle paramBundle)
  {
    zzahh.zzXG.lock();
    try
    {
      zzahh.zzahe = ConnectionResult.zzafB;
      zzd.zzb(zzahh);
      return;
    }
    finally
    {
      zzahh.zzXG.unlock();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzd.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */