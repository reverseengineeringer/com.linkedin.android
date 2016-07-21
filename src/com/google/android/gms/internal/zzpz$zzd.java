package com.google.android.gms.internal;

import java.io.IOException;

public final class zzpz$zzd
  extends zzsu
{
  public Integer zzaZF = null;
  public Boolean zzaZG = null;
  public String zzaZH = null;
  public String zzaZI = null;
  public String zzaZJ = null;
  
  public zzpz$zzd()
  {
    zzbuu = -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      do
      {
        return true;
        if (!(paramObject instanceof zzd)) {
          return false;
        }
        paramObject = (zzd)paramObject;
        if (zzaZF == null)
        {
          if (zzaZF != null) {
            return false;
          }
        }
        else if (!zzaZF.equals(zzaZF)) {
          return false;
        }
        if (zzaZG == null)
        {
          if (zzaZG != null) {
            return false;
          }
        }
        else if (!zzaZG.equals(zzaZG)) {
          return false;
        }
        if (zzaZH == null)
        {
          if (zzaZH != null) {
            return false;
          }
        }
        else if (!zzaZH.equals(zzaZH)) {
          return false;
        }
        if (zzaZI == null)
        {
          if (zzaZI != null) {
            return false;
          }
        }
        else if (!zzaZI.equals(zzaZI)) {
          return false;
        }
        if (zzaZJ != null) {
          break;
        }
      } while (zzaZJ == null);
      return false;
    } while (zzaZJ.equals(zzaZJ));
    return false;
  }
  
  public final int hashCode()
  {
    int n = 0;
    int i1 = getClass().getName().hashCode();
    int i;
    int j;
    label33:
    int k;
    label42:
    int m;
    if (zzaZF == null)
    {
      i = 0;
      if (zzaZG != null) {
        break label104;
      }
      j = 0;
      if (zzaZH != null) {
        break label115;
      }
      k = 0;
      if (zzaZI != null) {
        break label126;
      }
      m = 0;
      label52:
      if (zzaZJ != null) {
        break label138;
      }
    }
    for (;;)
    {
      return (m + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31) * 31 + n;
      i = zzaZF.intValue();
      break;
      label104:
      j = zzaZG.hashCode();
      break label33;
      label115:
      k = zzaZH.hashCode();
      break label42;
      label126:
      m = zzaZI.hashCode();
      break label52;
      label138:
      n = zzaZJ.hashCode();
    }
  }
  
  public final void writeTo(zzsn paramzzsn)
    throws IOException
  {
    if (zzaZF != null) {
      paramzzsn.zzA(1, zzaZF.intValue());
    }
    if (zzaZG != null) {
      paramzzsn.zze(2, zzaZG.booleanValue());
    }
    if (zzaZH != null) {
      paramzzsn.zzn(3, zzaZH);
    }
    if (zzaZI != null) {
      paramzzsn.zzn(4, zzaZI);
    }
    if (zzaZJ != null) {
      paramzzsn.zzn(5, zzaZJ);
    }
    super.writeTo(paramzzsn);
  }
  
  protected final int zzz()
  {
    int j = super.zzz();
    int i = j;
    if (zzaZF != null) {
      i = j + zzsn.zzC(1, zzaZF.intValue());
    }
    j = i;
    if (zzaZG != null)
    {
      zzaZG.booleanValue();
      j = i + (zzsn.zzmA(2) + 1);
    }
    i = j;
    if (zzaZH != null) {
      i = j + zzsn.zzo(3, zzaZH);
    }
    j = i;
    if (zzaZI != null) {
      j = i + zzsn.zzo(4, zzaZI);
    }
    i = j;
    if (zzaZJ != null) {
      i = j + zzsn.zzo(5, zzaZJ);
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpz.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */