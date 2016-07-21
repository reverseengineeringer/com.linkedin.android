package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzpz
{
  public static final class zza
    extends zzsu
  {
    private static volatile zza[] zzaZq;
    public Integer zzaZr = null;
    public zzpz.zze[] zzaZs = zzpz.zze.zzDH();
    public zzpz.zzb[] zzaZt = zzpz.zzb.zzDC();
    
    public zza()
    {
      zzbuu = -1;
    }
    
    public static zza[] zzDA()
    {
      if (zzaZq == null) {}
      synchronized (zzss.zzbut)
      {
        if (zzaZq == null) {
          zzaZq = new zza[0];
        }
        return zzaZq;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof zza)) {
          return false;
        }
        paramObject = (zza)paramObject;
        if (zzaZr == null)
        {
          if (zzaZr != null) {
            return false;
          }
        }
        else if (!zzaZr.equals(zzaZr)) {
          return false;
        }
        if (!zzss.equals(zzaZs, zzaZs)) {
          return false;
        }
      } while (zzss.equals(zzaZt, zzaZt));
      return false;
    }
    
    public final int hashCode()
    {
      int j = getClass().getName().hashCode();
      if (zzaZr == null) {}
      for (int i = 0;; i = zzaZr.hashCode()) {
        return ((i + (j + 527) * 31) * 31 + zzss.hashCode(zzaZs)) * 31 + zzss.hashCode(zzaZt);
      }
    }
    
    public final void writeTo(zzsn paramzzsn)
      throws IOException
    {
      int j = 0;
      if (zzaZr != null) {
        paramzzsn.zzA(1, zzaZr.intValue());
      }
      int i;
      Object localObject;
      if ((zzaZs != null) && (zzaZs.length > 0))
      {
        i = 0;
        while (i < zzaZs.length)
        {
          localObject = zzaZs[i];
          if (localObject != null) {
            paramzzsn.zza(2, (zzsu)localObject);
          }
          i += 1;
        }
      }
      if ((zzaZt != null) && (zzaZt.length > 0))
      {
        i = j;
        while (i < zzaZt.length)
        {
          localObject = zzaZt[i];
          if (localObject != null) {
            paramzzsn.zza(3, (zzsu)localObject);
          }
          i += 1;
        }
      }
      super.writeTo(paramzzsn);
    }
    
    protected final int zzz()
    {
      int m = 0;
      int i = super.zzz();
      int j = i;
      if (zzaZr != null) {
        j = i + zzsn.zzC(1, zzaZr.intValue());
      }
      i = j;
      Object localObject;
      if (zzaZs != null)
      {
        i = j;
        if (zzaZs.length > 0)
        {
          i = j;
          j = 0;
          while (j < zzaZs.length)
          {
            localObject = zzaZs[j];
            k = i;
            if (localObject != null) {
              k = i + zzsn.zzc(2, (zzsu)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      int k = i;
      if (zzaZt != null)
      {
        k = i;
        if (zzaZt.length > 0)
        {
          j = m;
          for (;;)
          {
            k = i;
            if (j >= zzaZt.length) {
              break;
            }
            localObject = zzaZt[j];
            k = i;
            if (localObject != null) {
              k = i + zzsn.zzc(3, (zzsu)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      return k;
    }
  }
  
  public static final class zzb
    extends zzsu
  {
    private static volatile zzb[] zzaZu;
    public Integer zzaZv = null;
    public String zzaZw = null;
    public zzpz.zzc[] zzaZx = zzpz.zzc.zzDE();
    public Boolean zzaZy = null;
    public zzpz.zzd zzaZz = null;
    
    public zzb()
    {
      zzbuu = -1;
    }
    
    public static zzb[] zzDC()
    {
      if (zzaZu == null) {}
      synchronized (zzss.zzbut)
      {
        if (zzaZu == null) {
          zzaZu = new zzb[0];
        }
        return zzaZu;
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
          if (!(paramObject instanceof zzb)) {
            return false;
          }
          paramObject = (zzb)paramObject;
          if (zzaZv == null)
          {
            if (zzaZv != null) {
              return false;
            }
          }
          else if (!zzaZv.equals(zzaZv)) {
            return false;
          }
          if (zzaZw == null)
          {
            if (zzaZw != null) {
              return false;
            }
          }
          else if (!zzaZw.equals(zzaZw)) {
            return false;
          }
          if (!zzss.equals(zzaZx, zzaZx)) {
            return false;
          }
          if (zzaZy == null)
          {
            if (zzaZy != null) {
              return false;
            }
          }
          else if (!zzaZy.equals(zzaZy)) {
            return false;
          }
          if (zzaZz != null) {
            break;
          }
        } while (zzaZz == null);
        return false;
      } while (zzaZz.equals(zzaZz));
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int j;
      label33:
      int i1;
      int k;
      if (zzaZv == null)
      {
        i = 0;
        if (zzaZw != null) {
          break label103;
        }
        j = 0;
        i1 = zzss.hashCode(zzaZx);
        if (zzaZy != null) {
          break label114;
        }
        k = 0;
        label51:
        if (zzaZz != null) {
          break label125;
        }
      }
      for (;;)
      {
        return (k + ((j + (i + (n + 527) * 31) * 31) * 31 + i1) * 31) * 31 + m;
        i = zzaZv.hashCode();
        break;
        label103:
        j = zzaZw.hashCode();
        break label33;
        label114:
        k = zzaZy.hashCode();
        break label51;
        label125:
        m = zzaZz.hashCode();
      }
    }
    
    public final void writeTo(zzsn paramzzsn)
      throws IOException
    {
      if (zzaZv != null) {
        paramzzsn.zzA(1, zzaZv.intValue());
      }
      if (zzaZw != null) {
        paramzzsn.zzn(2, zzaZw);
      }
      if ((zzaZx != null) && (zzaZx.length > 0))
      {
        int i = 0;
        while (i < zzaZx.length)
        {
          zzpz.zzc localzzc = zzaZx[i];
          if (localzzc != null) {
            paramzzsn.zza(3, localzzc);
          }
          i += 1;
        }
      }
      if (zzaZy != null) {
        paramzzsn.zze(4, zzaZy.booleanValue());
      }
      if (zzaZz != null) {
        paramzzsn.zza(5, zzaZz);
      }
      super.writeTo(paramzzsn);
    }
    
    public final zzb zzu(zzsm paramzzsm)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzsm.zzIX();
        switch (i)
        {
        default: 
          if (zzsx.zzb(paramzzsm, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          zzaZv = Integer.valueOf(paramzzsm.zzJf());
          break;
        case 18: 
          zzaZw = paramzzsm.readString();
          break;
        case 26: 
          int j = zzsx.zzc(paramzzsm, 26);
          if (zzaZx == null) {}
          zzpz.zzc[] arrayOfzzc;
          for (i = 0;; i = zzaZx.length)
          {
            arrayOfzzc = new zzpz.zzc[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(zzaZx, 0, arrayOfzzc, 0, i);
              j = i;
            }
            while (j < arrayOfzzc.length - 1)
            {
              arrayOfzzc[j] = new zzpz.zzc();
              paramzzsm.zza(arrayOfzzc[j]);
              paramzzsm.zzIX();
              j += 1;
            }
          }
          arrayOfzzc[j] = new zzpz.zzc();
          paramzzsm.zza(arrayOfzzc[j]);
          zzaZx = arrayOfzzc;
          break;
        case 32: 
          zzaZy = Boolean.valueOf(paramzzsm.zzJc());
          break;
        case 42: 
          if (zzaZz == null) {
            zzaZz = new zzpz.zzd();
          }
          paramzzsm.zza(zzaZz);
        }
      }
    }
    
    protected final int zzz()
    {
      int i = super.zzz();
      int j = i;
      if (zzaZv != null) {
        j = i + zzsn.zzC(1, zzaZv.intValue());
      }
      i = j;
      if (zzaZw != null) {
        i = j + zzsn.zzo(2, zzaZw);
      }
      j = i;
      if (zzaZx != null)
      {
        j = i;
        if (zzaZx.length > 0)
        {
          j = 0;
          while (j < zzaZx.length)
          {
            zzpz.zzc localzzc = zzaZx[j];
            int k = i;
            if (localzzc != null) {
              k = i + zzsn.zzc(3, localzzc);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (zzaZy != null)
      {
        zzaZy.booleanValue();
        i = j + (zzsn.zzmA(4) + 1);
      }
      j = i;
      if (zzaZz != null) {
        j = i + zzsn.zzc(5, zzaZz);
      }
      return j;
    }
  }
  
  public static final class zzc
    extends zzsu
  {
    private static volatile zzc[] zzaZA;
    public zzpz.zzf zzaZB = null;
    public zzpz.zzd zzaZC = null;
    public Boolean zzaZD = null;
    public String zzaZE = null;
    
    public zzc()
    {
      zzbuu = -1;
    }
    
    public static zzc[] zzDE()
    {
      if (zzaZA == null) {}
      synchronized (zzss.zzbut)
      {
        if (zzaZA == null) {
          zzaZA = new zzc[0];
        }
        return zzaZA;
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
          if (zzaZB == null)
          {
            if (zzaZB != null) {
              return false;
            }
          }
          else if (!zzaZB.equals(zzaZB)) {
            return false;
          }
          if (zzaZC == null)
          {
            if (zzaZC != null) {
              return false;
            }
          }
          else if (!zzaZC.equals(zzaZC)) {
            return false;
          }
          if (zzaZD == null)
          {
            if (zzaZD != null) {
              return false;
            }
          }
          else if (!zzaZD.equals(zzaZD)) {
            return false;
          }
          if (zzaZE != null) {
            break;
          }
        } while (zzaZE == null);
        return false;
      } while (zzaZE.equals(zzaZE));
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int j;
      label33:
      int k;
      if (zzaZB == null)
      {
        i = 0;
        if (zzaZC != null) {
          break label88;
        }
        j = 0;
        if (zzaZD != null) {
          break label99;
        }
        k = 0;
        label42:
        if (zzaZE != null) {
          break label110;
        }
      }
      for (;;)
      {
        return (k + (j + (i + (n + 527) * 31) * 31) * 31) * 31 + m;
        i = zzaZB.hashCode();
        break;
        label88:
        j = zzaZC.hashCode();
        break label33;
        label99:
        k = zzaZD.hashCode();
        break label42;
        label110:
        m = zzaZE.hashCode();
      }
    }
    
    public final void writeTo(zzsn paramzzsn)
      throws IOException
    {
      if (zzaZB != null) {
        paramzzsn.zza(1, zzaZB);
      }
      if (zzaZC != null) {
        paramzzsn.zza(2, zzaZC);
      }
      if (zzaZD != null) {
        paramzzsn.zze(3, zzaZD.booleanValue());
      }
      if (zzaZE != null) {
        paramzzsn.zzn(4, zzaZE);
      }
      super.writeTo(paramzzsn);
    }
    
    protected final int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (zzaZB != null) {
        i = j + zzsn.zzc(1, zzaZB);
      }
      j = i;
      if (zzaZC != null) {
        j = i + zzsn.zzc(2, zzaZC);
      }
      i = j;
      if (zzaZD != null)
      {
        zzaZD.booleanValue();
        i = j + (zzsn.zzmA(3) + 1);
      }
      j = i;
      if (zzaZE != null) {
        j = i + zzsn.zzo(4, zzaZE);
      }
      return j;
    }
  }
  
  public static final class zzd
    extends zzsu
  {
    public Integer zzaZF = null;
    public Boolean zzaZG = null;
    public String zzaZH = null;
    public String zzaZI = null;
    public String zzaZJ = null;
    
    public zzd()
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
  
  public static final class zze
    extends zzsu
  {
    private static volatile zze[] zzaZK;
    public String zzaZL = null;
    public zzpz.zzc zzaZM = null;
    public Integer zzaZv = null;
    
    public zze()
    {
      zzbuu = -1;
    }
    
    public static zze[] zzDH()
    {
      if (zzaZK == null) {}
      synchronized (zzss.zzbut)
      {
        if (zzaZK == null) {
          zzaZK = new zze[0];
        }
        return zzaZK;
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
          if (!(paramObject instanceof zze)) {
            return false;
          }
          paramObject = (zze)paramObject;
          if (zzaZv == null)
          {
            if (zzaZv != null) {
              return false;
            }
          }
          else if (!zzaZv.equals(zzaZv)) {
            return false;
          }
          if (zzaZL == null)
          {
            if (zzaZL != null) {
              return false;
            }
          }
          else if (!zzaZL.equals(zzaZL)) {
            return false;
          }
          if (zzaZM != null) {
            break;
          }
        } while (zzaZM == null);
        return false;
      } while (zzaZM.equals(zzaZM));
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      int m = getClass().getName().hashCode();
      int i;
      int j;
      if (zzaZv == null)
      {
        i = 0;
        if (zzaZL != null) {
          break label72;
        }
        j = 0;
        label32:
        if (zzaZM != null) {
          break label83;
        }
      }
      for (;;)
      {
        return (j + (i + (m + 527) * 31) * 31) * 31 + k;
        i = zzaZv.hashCode();
        break;
        label72:
        j = zzaZL.hashCode();
        break label32;
        label83:
        k = zzaZM.hashCode();
      }
    }
    
    public final void writeTo(zzsn paramzzsn)
      throws IOException
    {
      if (zzaZv != null) {
        paramzzsn.zzA(1, zzaZv.intValue());
      }
      if (zzaZL != null) {
        paramzzsn.zzn(2, zzaZL);
      }
      if (zzaZM != null) {
        paramzzsn.zza(3, zzaZM);
      }
      super.writeTo(paramzzsn);
    }
    
    public final zze zzx(zzsm paramzzsm)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzsm.zzIX();
        switch (i)
        {
        default: 
          if (zzsx.zzb(paramzzsm, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          zzaZv = Integer.valueOf(paramzzsm.zzJf());
          break;
        case 18: 
          zzaZL = paramzzsm.readString();
          break;
        case 26: 
          if (zzaZM == null) {
            zzaZM = new zzpz.zzc();
          }
          paramzzsm.zza(zzaZM);
        }
      }
    }
    
    protected final int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (zzaZv != null) {
        i = j + zzsn.zzC(1, zzaZv.intValue());
      }
      j = i;
      if (zzaZL != null) {
        j = i + zzsn.zzo(2, zzaZL);
      }
      i = j;
      if (zzaZM != null) {
        i = j + zzsn.zzc(3, zzaZM);
      }
      return i;
    }
  }
  
  public static final class zzf
    extends zzsu
  {
    public Integer zzaZN = null;
    public String zzaZO = null;
    public Boolean zzaZP = null;
    public String[] zzaZQ = zzsx.zzbuB;
    
    public zzf()
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
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */