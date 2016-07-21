package com.google.android.gms.internal;

import java.io.IOException;

public final class zzpm$zzc
  extends zzso<zzc>
{
  public String type = "";
  public zzpm.zzb[] zzaMu = zzpm.zzb.zzys();
  
  public zzpm$zzc()
  {
    zzbuj = null;
    zzbuu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzc)) {
        return false;
      }
      paramObject = (zzc)paramObject;
      if (type == null)
      {
        if (type != null) {
          return false;
        }
      }
      else if (!type.equals(type)) {
        return false;
      }
      if (!zzss.equals(zzaMu, zzaMu)) {
        return false;
      }
      if ((zzbuj != null) && (!zzbuj.isEmpty())) {
        break;
      }
    } while ((zzbuj == null) || (zzbuj.isEmpty()));
    return false;
    return zzbuj.equals(zzbuj);
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int i;
    int n;
    if (type == null)
    {
      i = 0;
      n = zzss.hashCode(zzaMu);
      j = k;
      if (zzbuj != null) {
        if (!zzbuj.isEmpty()) {
          break label87;
        }
      }
    }
    label87:
    for (int j = k;; j = zzbuj.hashCode())
    {
      return ((i + (m + 527) * 31) * 31 + n) * 31 + j;
      i = type.hashCode();
      break;
    }
  }
  
  public final void writeTo(zzsn paramzzsn)
    throws IOException
  {
    if (!type.equals("")) {
      paramzzsn.zzn(1, type);
    }
    if ((zzaMu != null) && (zzaMu.length > 0))
    {
      int i = 0;
      while (i < zzaMu.length)
      {
        zzpm.zzb localzzb = zzaMu[i];
        if (localzzb != null) {
          paramzzsn.zza(2, localzzb);
        }
        i += 1;
      }
    }
    super.writeTo(paramzzsn);
  }
  
  protected final int zzz()
  {
    int j = super.zzz();
    int i = j;
    if (!type.equals("")) {
      i = j + zzsn.zzo(1, type);
    }
    j = i;
    if (zzaMu != null)
    {
      j = i;
      if (zzaMu.length > 0)
      {
        j = 0;
        while (j < zzaMu.length)
        {
          zzpm.zzb localzzb = zzaMu[j];
          int k = i;
          if (localzzb != null) {
            k = i + zzsn.zzc(2, localzzb);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpm.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */