package com.google.android.gms.common.stats;

public abstract class zzf
{
  public abstract int getEventType();
  
  public abstract long getTimeMillis();
  
  public String toString()
  {
    return getTimeMillis() + "\t" + getEventType() + "\t" + zzrL() + zzrO();
  }
  
  public abstract long zzrL();
  
  public abstract String zzrO();
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.stats.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */