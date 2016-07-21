package com.google.android.gms.internal;

import java.io.IOException;

public final class zzqa$zzc
  extends zzsu
{
  private static volatile zzc[] zzaZY;
  public String key = null;
  public String value = null;
  
  public zzqa$zzc()
  {
    zzbuu = -1;
  }
  
  public static zzc[] zzDN()
  {
    if (zzaZY == null) {}
    synchronized (zzss.zzbut)
    {
      if (zzaZY == null) {
        zzaZY = new zzc[0];
      }
      return zzaZY;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      do
      {
        return true;
        if (!(paramObject instanceof zzc)) {
          return false;
        }
        paramObject = (zzc)paramObject;
        if (key == null)
        {
          if (key != null) {
            return false;
          }
        }
        else if (!key.equals(key)) {
          return false;
        }
        if (value != null) {
          break;
        }
      } while (value == null);
      return false;
    } while (value.equals(value));
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int k = getClass().getName().hashCode();
    int i;
    if (key == null)
    {
      i = 0;
      if (value != null) {
        break label56;
      }
    }
    for (;;)
    {
      return (i + (k + 527) * 31) * 31 + j;
      i = key.hashCode();
      break;
      label56:
      j = value.hashCode();
    }
  }
  
  public final void writeTo(zzsn paramzzsn)
    throws IOException
  {
    if (key != null) {
      paramzzsn.zzn(1, key);
    }
    if (value != null) {
      paramzzsn.zzn(2, value);
    }
    super.writeTo(paramzzsn);
  }
  
  protected final int zzz()
  {
    int j = super.zzz();
    int i = j;
    if (key != null) {
      i = j + zzsn.zzo(1, key);
    }
    j = i;
    if (value != null) {
      j = i + zzsn.zzo(2, value);
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqa.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */