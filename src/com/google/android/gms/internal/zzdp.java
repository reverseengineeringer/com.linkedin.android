package com.google.android.gms.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.zzr;
import java.util.List;

@zzhb
public final class zzdp
  extends zzim
{
  final zzjp zzpD;
  final zzdr zzzJ;
  private final String zzzK;
  
  zzdp(zzjp paramzzjp, zzdr paramzzdr, String paramString)
  {
    zzpD = paramzzjp;
    zzzJ = paramzzdr;
    zzzK = paramString;
    zzbRzzzM.add(this);
  }
  
  public final void zzbr()
  {
    zzir.zzMc.post(new Runnable()
    {
      public final void run()
      {
        zzdq localzzdq = zzr.zzbR();
        zzdp localzzdp = zzdp.this;
        zzzM.remove(localzzdp);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzdp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */