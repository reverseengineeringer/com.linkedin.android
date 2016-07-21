package com.google.android.gms.measurement.internal;

abstract class zzz
  extends zzy
{
  private boolean zzQk;
  private boolean zzQl;
  boolean zzaYC;
  
  zzz(zzw paramzzw)
  {
    super(paramzzw);
    paramzzw = zzaTV;
    zzaYq += 1;
  }
  
  final boolean isInitialized()
  {
    return (zzQk) && (!zzQl);
  }
  
  public final void zza()
  {
    if (zzQk) {
      throw new IllegalStateException("Can't initialize twice");
    }
    zziJ();
    zzw localzzw = zzaTV;
    zzaYr += 1;
    zzQk = true;
  }
  
  protected abstract void zziJ();
  
  protected final void zzjv()
  {
    if (!isInitialized()) {
      throw new IllegalStateException("Not initialized");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */