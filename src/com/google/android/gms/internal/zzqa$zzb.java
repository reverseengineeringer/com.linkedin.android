package com.google.android.gms.internal;

import java.io.IOException;

public final class zzqa$zzb
  extends zzsu
{
  public String zzaVt = null;
  public Long zzaZT = null;
  public Integer zzaZU = null;
  public zzqa.zzc[] zzaZV = zzqa.zzc.zzDN();
  public zzqa.zza[] zzaZW = zzqa.zza.zzDK();
  public zzpz.zza[] zzaZX = zzpz.zza.zzDA();
  
  public zzqa$zzb()
  {
    zzbuu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzb)) {
        return false;
      }
      paramObject = (zzb)paramObject;
      if (zzaZT == null)
      {
        if (zzaZT != null) {
          return false;
        }
      }
      else if (!zzaZT.equals(zzaZT)) {
        return false;
      }
      if (zzaVt == null)
      {
        if (zzaVt != null) {
          return false;
        }
      }
      else if (!zzaVt.equals(zzaVt)) {
        return false;
      }
      if (zzaZU == null)
      {
        if (zzaZU != null) {
          return false;
        }
      }
      else if (!zzaZU.equals(zzaZU)) {
        return false;
      }
      if (!zzss.equals(zzaZV, zzaZV)) {
        return false;
      }
      if (!zzss.equals(zzaZW, zzaZW)) {
        return false;
      }
    } while (zzss.equals(zzaZX, zzaZX));
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int i;
    int j;
    if (zzaZT == null)
    {
      i = 0;
      if (zzaVt != null) {
        break label105;
      }
      j = 0;
      label32:
      if (zzaZU != null) {
        break label116;
      }
    }
    for (;;)
    {
      return ((((j + (i + (m + 527) * 31) * 31) * 31 + k) * 31 + zzss.hashCode(zzaZV)) * 31 + zzss.hashCode(zzaZW)) * 31 + zzss.hashCode(zzaZX);
      i = zzaZT.hashCode();
      break;
      label105:
      j = zzaVt.hashCode();
      break label32;
      label116:
      k = zzaZU.hashCode();
    }
  }
  
  public final void writeTo(zzsn paramzzsn)
    throws IOException
  {
    int j = 0;
    if (zzaZT != null) {
      paramzzsn.zzb(1, zzaZT.longValue());
    }
    if (zzaVt != null) {
      paramzzsn.zzn(2, zzaVt);
    }
    if (zzaZU != null) {
      paramzzsn.zzA(3, zzaZU.intValue());
    }
    int i;
    Object localObject;
    if ((zzaZV != null) && (zzaZV.length > 0))
    {
      i = 0;
      while (i < zzaZV.length)
      {
        localObject = zzaZV[i];
        if (localObject != null) {
          paramzzsn.zza(4, (zzsu)localObject);
        }
        i += 1;
      }
    }
    if ((zzaZW != null) && (zzaZW.length > 0))
    {
      i = 0;
      while (i < zzaZW.length)
      {
        localObject = zzaZW[i];
        if (localObject != null) {
          paramzzsn.zza(5, (zzsu)localObject);
        }
        i += 1;
      }
    }
    if ((zzaZX != null) && (zzaZX.length > 0))
    {
      i = j;
      while (i < zzaZX.length)
      {
        localObject = zzaZX[i];
        if (localObject != null) {
          paramzzsn.zza(6, (zzsu)localObject);
        }
        i += 1;
      }
    }
    super.writeTo(paramzzsn);
  }
  
  public final zzb zzA(zzsm paramzzsm)
    throws IOException
  {
    for (;;)
    {
      int i = paramzzsm.zzIX();
      int j;
      Object localObject;
      switch (i)
      {
      default: 
        if (zzsx.zzb(paramzzsm, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        zzaZT = Long.valueOf(paramzzsm.zzJg());
        break;
      case 18: 
        zzaVt = paramzzsm.readString();
        break;
      case 24: 
        zzaZU = Integer.valueOf(paramzzsm.zzJf());
        break;
      case 34: 
        j = zzsx.zzc(paramzzsm, 34);
        if (zzaZV == null) {}
        for (i = 0;; i = zzaZV.length)
        {
          localObject = new zzqa.zzc[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzaZV, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzqa.zzc();
            paramzzsm.zza(localObject[j]);
            paramzzsm.zzIX();
            j += 1;
          }
        }
        localObject[j] = new zzqa.zzc();
        paramzzsm.zza(localObject[j]);
        zzaZV = ((zzqa.zzc[])localObject);
        break;
      case 42: 
        j = zzsx.zzc(paramzzsm, 42);
        if (zzaZW == null) {}
        for (i = 0;; i = zzaZW.length)
        {
          localObject = new zzqa.zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzaZW, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzqa.zza();
            paramzzsm.zza(localObject[j]);
            paramzzsm.zzIX();
            j += 1;
          }
        }
        localObject[j] = new zzqa.zza();
        paramzzsm.zza(localObject[j]);
        zzaZW = ((zzqa.zza[])localObject);
        break;
      case 50: 
        j = zzsx.zzc(paramzzsm, 50);
        if (zzaZX == null) {}
        for (i = 0;; i = zzaZX.length)
        {
          localObject = new zzpz.zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(zzaZX, 0, localObject, 0, i);
            j = i;
          }
          while (j < localObject.length - 1)
          {
            localObject[j] = new zzpz.zza();
            paramzzsm.zza(localObject[j]);
            paramzzsm.zzIX();
            j += 1;
          }
        }
        localObject[j] = new zzpz.zza();
        paramzzsm.zza(localObject[j]);
        zzaZX = ((zzpz.zza[])localObject);
      }
    }
  }
  
  protected final int zzz()
  {
    int m = 0;
    int j = super.zzz();
    int i = j;
    if (zzaZT != null) {
      i = j + zzsn.zzd(1, zzaZT.longValue());
    }
    j = i;
    if (zzaVt != null) {
      j = i + zzsn.zzo(2, zzaVt);
    }
    i = j;
    if (zzaZU != null) {
      i = j + zzsn.zzC(3, zzaZU.intValue());
    }
    j = i;
    Object localObject;
    if (zzaZV != null)
    {
      j = i;
      if (zzaZV.length > 0)
      {
        j = 0;
        while (j < zzaZV.length)
        {
          localObject = zzaZV[j];
          k = i;
          if (localObject != null) {
            k = i + zzsn.zzc(4, (zzsu)localObject);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (zzaZW != null)
    {
      i = j;
      if (zzaZW.length > 0)
      {
        i = j;
        j = 0;
        while (j < zzaZW.length)
        {
          localObject = zzaZW[j];
          k = i;
          if (localObject != null) {
            k = i + zzsn.zzc(5, (zzsu)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    int k = i;
    if (zzaZX != null)
    {
      k = i;
      if (zzaZX.length > 0)
      {
        j = m;
        for (;;)
        {
          k = i;
          if (j >= zzaZX.length) {
            break;
          }
          localObject = zzaZX[j];
          k = i;
          if (localObject != null) {
            k = i + zzsn.zzc(6, (zzsu)localObject);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqa.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */