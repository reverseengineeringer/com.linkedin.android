package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.zzbp;
import com.google.android.gms.internal.zzbs;
import com.google.android.gms.internal.zzbt;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class zze
{
  private boolean zzpA;
  private boolean zzpB;
  
  public zze()
  {
    zzbp localzzbp = zzbt.zzvI;
    zzpB = ((Boolean)zzr.zzbL().zzd(localzzbp)).booleanValue();
  }
  
  public zze(byte paramByte)
  {
    zzpB = false;
  }
  
  public final boolean zzbh()
  {
    return (!zzpB) || (zzpA);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */