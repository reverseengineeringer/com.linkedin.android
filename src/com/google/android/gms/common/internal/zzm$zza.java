package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;

final class zzm$zza
{
  private final String zzSU;
  private final ComponentName zzamc;
  
  public zzm$zza(ComponentName paramComponentName)
  {
    zzSU = null;
    zzamc = ((ComponentName)zzx.zzz(paramComponentName));
  }
  
  public zzm$zza(String paramString)
  {
    zzSU = zzx.zzcM(paramString);
    zzamc = null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zza)) {
        return false;
      }
      paramObject = (zza)paramObject;
    } while ((zzw.equal(zzSU, zzSU)) && (zzw.equal(zzamc, zzamc)));
    return false;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { zzSU, zzamc });
  }
  
  public final String toString()
  {
    if (zzSU == null) {
      return zzamc.flattenToString();
    }
    return zzSU;
  }
  
  public final Intent zzqS()
  {
    if (zzSU != null) {
      return new Intent(zzSU).setPackage("com.google.android.gms");
    }
    return new Intent().setComponent(zzamc);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzm.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */