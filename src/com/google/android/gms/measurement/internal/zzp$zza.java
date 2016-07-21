package com.google.android.gms.measurement.internal;

public final class zzp$zza
{
  private final int mPriority;
  private final boolean zzaWN;
  private final boolean zzaWO;
  
  zzp$zza(zzp paramzzp, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    mPriority = paramInt;
    zzaWN = paramBoolean1;
    zzaWO = paramBoolean2;
  }
  
  public final void zzd(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zzaWM.zza(mPriority, zzaWN, zzaWO, paramString, paramObject1, paramObject2, paramObject3);
  }
  
  public final void zze(String paramString, Object paramObject1, Object paramObject2)
  {
    zzaWM.zza(mPriority, zzaWN, zzaWO, paramString, paramObject1, paramObject2, null);
  }
  
  public final void zzfg(String paramString)
  {
    zzaWM.zza(mPriority, zzaWN, zzaWO, paramString, null, null, null);
  }
  
  public final void zzj(String paramString, Object paramObject)
  {
    zzaWM.zza(mPriority, zzaWN, zzaWO, paramString, paramObject, null, null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzp.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */