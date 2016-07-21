package com.google.android.gms.internal;

import android.view.View;
import java.util.List;

final class zzbf$1
  implements Runnable
{
  zzbf$1(zzbf paramzzbf, View paramView) {}
  
  public final void run()
  {
    zzbf localzzbf = zztg;
    ??? = zztf;
    try
    {
      zzbc localzzbc = new zzbc(zzsK, zztd, zzsM, zzte);
      ??? = localzzbf.zza((View)???, localzzbc);
      localzzbc.zzcD();
      if ((zztm == 0) && (zztn == 0)) {
        return;
      }
      if (((zztn != 0) || (zzsQ != 0)) && ((zztn != 0) || (!zzta.zza(localzzbc))))
      {
        zzbd localzzbd = zzta;
        synchronized (zzpV)
        {
          if (zzsX.size() >= 10)
          {
            zzin.zzaI("Queue is full, current size = " + zzsX.size());
            zzsX.remove(0);
          }
          int i = zzsW;
          zzsW = (i + 1);
          zzsR = i;
          zzsX.add(localzzbc);
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      zzin.zzb("Exception in fetchContentOnUIThread", localException);
      zztb.zza(localException, true);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbf.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */