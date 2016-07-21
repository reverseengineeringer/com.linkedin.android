package com.google.android.gms.internal;

import java.io.IOException;

public final class zzpz$zzf
  extends zzsu
{
  public Integer zzaZN = null;
  public String zzaZO = null;
  public Boolean zzaZP = null;
  public String[] zzaZQ = zzsx.zzbuB;
  
  public zzpz$zzf()
  {
    zzbuu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzf)) {
        return false;
      }
      paramObject = (zzf)paramObject;
      if (zzaZN == null)
      {
        if (zzaZN != null) {
          return false;
        }
      }
      else if (!zzaZN.equals(zzaZN)) {
        return false;
      }
      if (zzaZO == null)
      {
        if (zzaZO != null) {
          return false;
        }
      }
      else if (!zzaZO.equals(zzaZO)) {
        return false;
      }
      if (zzaZP == null)
      {
        if (zzaZP != null) {
          return false;
        }
      }
      else if (!zzaZP.equals(zzaZP)) {
        return false;
      }
    } while (zzss.equals(zzaZQ, zzaZQ));
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int i;
    int j;
    if (zzaZN == null)
    {
      i = 0;
      if (zzaZO != null) {
        break label83;
      }
      j = 0;
      label32:
      if (zzaZP != null) {
        break label94;
      }
    }
    for (;;)
    {
      return ((j + (i + (m + 527) * 31) * 31) * 31 + k) * 31 + zzss.hashCode(zzaZQ);
      i = zzaZN.intValue();
      break;
      label83:
      j = zzaZO.hashCode();
      break label32;
      label94:
      k = zzaZP.hashCode();
    }
  }
  
  public final void writeTo(zzsn paramzzsn)
    throws IOException
  {
    if (zzaZN != null) {
      paramzzsn.zzA(1, zzaZN.intValue());
    }
    if (zzaZO != null) {
      paramzzsn.zzn(2, zzaZO);
    }
    if (zzaZP != null) {
      paramzzsn.zze(3, zzaZP.booleanValue());
    }
    if ((zzaZQ != null) && (zzaZQ.length > 0))
    {
      int i = 0;
      while (i < zzaZQ.length)
      {
        String str = zzaZQ[i];
        if (str != null) {
          paramzzsn.zzn(4, str);
        }
        i += 1;
      }
    }
    super.writeTo(paramzzsn);
  }
  
  protected final int zzz()
  {
    int n = 0;
    int j = super.zzz();
    int i = j;
    if (zzaZN != null) {
      i = j + zzsn.zzC(1, zzaZN.intValue());
    }
    j = i;
    if (zzaZO != null) {
      j = i + zzsn.zzo(2, zzaZO);
    }
    i = j;
    if (zzaZP != null)
    {
      zzaZP.booleanValue();
      i = j + (zzsn.zzmA(3) + 1);
    }
    j = i;
    if (zzaZQ != null)
    {
      j = i;
      if (zzaZQ.length > 0)
      {
        int k = 0;
        int m = 0;
        j = n;
        while (j < zzaZQ.length)
        {
          String str = zzaZQ[j];
          int i1 = k;
          n = m;
          if (str != null)
          {
            n = m + 1;
            i1 = k + zzsn.zzgO(str);
          }
          j += 1;
          k = i1;
          m = n;
        }
        j = i + k + m * 1;
      }
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpz.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */