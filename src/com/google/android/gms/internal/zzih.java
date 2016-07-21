package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.zze;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

@zzhb
public final class zzih
{
  private Context mContext;
  private boolean zzJA = true;
  private boolean zzJz = true;
  private final LinkedList<Thread> zzLA = new LinkedList();
  Boolean zzLB = null;
  private boolean zzLC = false;
  private boolean zzLD = false;
  private final String zzLq = zzir.zzhs();
  private final zzii zzLr = new zzii(zzLq);
  private BigInteger zzLs = BigInteger.ONE;
  private final HashSet<Object> zzLt = new HashSet();
  private final HashMap<String, Object> zzLu = new HashMap();
  private boolean zzLv = false;
  private int zzLw = 0;
  private zzbv zzLx = null;
  private zzbf zzLy = null;
  private VersionInfoParcel zzpT;
  final Object zzpV = new Object();
  private boolean zzqA = false;
  private zzbe zzsZ = null;
  private zzbd zzta = null;
  private final zzha zztb = null;
  private String zzzN;
  
  public final void zzb(Throwable paramThrowable, boolean paramBoolean)
  {
    new zzha(mContext, zzpT).zza(paramThrowable, paramBoolean);
  }
  
  public final String zzd(int paramInt, String paramString)
  {
    if (zzpT.zzNb) {}
    for (Resources localResources = mContext.getResources(); localResources == null; localResources = zze.getRemoteResource(mContext)) {
      return paramString;
    }
    return localResources.getString(paramInt);
  }
  
  public final zzbv zzhb()
  {
    synchronized (zzpV)
    {
      zzbv localzzbv = zzLx;
      return localzzbv;
    }
  }
  
  public final String zzhe()
  {
    synchronized (zzpV)
    {
      String str = zzzN;
      return str;
    }
  }
  
  public final Boolean zzhg()
  {
    synchronized (zzpV)
    {
      Boolean localBoolean = zzLB;
      return localBoolean;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzih
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */