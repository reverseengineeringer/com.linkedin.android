package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzqb
{
  public static final class zza
    extends zzsu
  {
    private static volatile zza[] zzaZZ;
    public Integer zzaZr = null;
    public zzqb.zzf zzbaa = null;
    public zzqb.zzf zzbab = null;
    public Boolean zzbac = null;
    
    public zza()
    {
      zzbuu = -1;
    }
    
    public static zza[] zzDP()
    {
      if (zzaZZ == null) {}
      synchronized (zzss.zzbut)
      {
        if (zzaZZ == null) {
          zzaZZ = new zza[0];
        }
        return zzaZZ;
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
          if (zzbaa == null)
          {
            if (zzbaa != null) {
              return false;
            }
          }
          else if (!zzbaa.equals(zzbaa)) {
            return false;
          }
          if (zzbab == null)
          {
            if (zzbab != null) {
              return false;
            }
          }
          else if (!zzbab.equals(zzbab)) {
            return false;
          }
          if (zzbac != null) {
            break;
          }
        } while (zzbac == null);
        return false;
      } while (zzbac.equals(zzbac));
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
      if (zzaZr == null)
      {
        i = 0;
        if (zzbaa != null) {
          break label88;
        }
        j = 0;
        if (zzbab != null) {
          break label99;
        }
        k = 0;
        label42:
        if (zzbac != null) {
          break label110;
        }
      }
      for (;;)
      {
        return (k + (j + (i + (n + 527) * 31) * 31) * 31) * 31 + m;
        i = zzaZr.hashCode();
        break;
        label88:
        j = zzbaa.hashCode();
        break label33;
        label99:
        k = zzbab.hashCode();
        break label42;
        label110:
        m = zzbac.hashCode();
      }
    }
    
    public final void writeTo(zzsn paramzzsn)
      throws IOException
    {
      if (zzaZr != null) {
        paramzzsn.zzA(1, zzaZr.intValue());
      }
      if (zzbaa != null) {
        paramzzsn.zza(2, zzbaa);
      }
      if (zzbab != null) {
        paramzzsn.zza(3, zzbab);
      }
      if (zzbac != null) {
        paramzzsn.zze(4, zzbac.booleanValue());
      }
      super.writeTo(paramzzsn);
    }
    
    protected final int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (zzaZr != null) {
        i = j + zzsn.zzC(1, zzaZr.intValue());
      }
      j = i;
      if (zzbaa != null) {
        j = i + zzsn.zzc(2, zzbaa);
      }
      i = j;
      if (zzbab != null) {
        i = j + zzsn.zzc(3, zzbab);
      }
      j = i;
      if (zzbac != null)
      {
        zzbac.booleanValue();
        j = i + (zzsn.zzmA(4) + 1);
      }
      return j;
    }
  }
  
  public static final class zzb
    extends zzsu
  {
    private static volatile zzb[] zzbad;
    public Integer count = null;
    public String name = null;
    public zzqb.zzc[] zzbae = zzqb.zzc.zzDT();
    public Long zzbaf = null;
    public Long zzbag = null;
    
    public zzb()
    {
      zzbuu = -1;
    }
    
    public static zzb[] zzDR()
    {
      if (zzbad == null) {}
      synchronized (zzss.zzbut)
      {
        if (zzbad == null) {
          zzbad = new zzb[0];
        }
        return zzbad;
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
          if (!zzss.equals(zzbae, zzbae)) {
            return false;
          }
          if (name == null)
          {
            if (name != null) {
              return false;
            }
          }
          else if (!name.equals(name)) {
            return false;
          }
          if (zzbaf == null)
          {
            if (zzbaf != null) {
              return false;
            }
          }
          else if (!zzbaf.equals(zzbaf)) {
            return false;
          }
          if (zzbag == null)
          {
            if (zzbag != null) {
              return false;
            }
          }
          else if (!zzbag.equals(zzbag)) {
            return false;
          }
          if (count != null) {
            break;
          }
        } while (count == null);
        return false;
      } while (count.equals(count));
      return false;
    }
    
    public final int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = zzss.hashCode(zzbae);
      int i;
      int j;
      label42:
      int k;
      if (name == null)
      {
        i = 0;
        if (zzbaf != null) {
          break label103;
        }
        j = 0;
        if (zzbag != null) {
          break label114;
        }
        k = 0;
        label51:
        if (count != null) {
          break label125;
        }
      }
      for (;;)
      {
        return (k + (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31) * 31 + m;
        i = name.hashCode();
        break;
        label103:
        j = zzbaf.hashCode();
        break label42;
        label114:
        k = zzbag.hashCode();
        break label51;
        label125:
        m = count.hashCode();
      }
    }
    
    public final void writeTo(zzsn paramzzsn)
      throws IOException
    {
      if ((zzbae != null) && (zzbae.length > 0))
      {
        int i = 0;
        while (i < zzbae.length)
        {
          zzqb.zzc localzzc = zzbae[i];
          if (localzzc != null) {
            paramzzsn.zza(1, localzzc);
          }
          i += 1;
        }
      }
      if (name != null) {
        paramzzsn.zzn(2, name);
      }
      if (zzbaf != null) {
        paramzzsn.zzb(3, zzbaf.longValue());
      }
      if (zzbag != null) {
        paramzzsn.zzb(4, zzbag.longValue());
      }
      if (count != null) {
        paramzzsn.zzA(5, count.intValue());
      }
      super.writeTo(paramzzsn);
    }
    
    public final zzb zzD(zzsm paramzzsm)
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
        case 10: 
          int j = zzsx.zzc(paramzzsm, 10);
          if (zzbae == null) {}
          zzqb.zzc[] arrayOfzzc;
          for (i = 0;; i = zzbae.length)
          {
            arrayOfzzc = new zzqb.zzc[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(zzbae, 0, arrayOfzzc, 0, i);
              j = i;
            }
            while (j < arrayOfzzc.length - 1)
            {
              arrayOfzzc[j] = new zzqb.zzc();
              paramzzsm.zza(arrayOfzzc[j]);
              paramzzsm.zzIX();
              j += 1;
            }
          }
          arrayOfzzc[j] = new zzqb.zzc();
          paramzzsm.zza(arrayOfzzc[j]);
          zzbae = arrayOfzzc;
          break;
        case 18: 
          name = paramzzsm.readString();
          break;
        case 24: 
          zzbaf = Long.valueOf(paramzzsm.zzJg());
          break;
        case 32: 
          zzbag = Long.valueOf(paramzzsm.zzJg());
          break;
        case 40: 
          count = Integer.valueOf(paramzzsm.zzJf());
        }
      }
    }
    
    protected final int zzz()
    {
      int i = super.zzz();
      int j = i;
      if (zzbae != null)
      {
        j = i;
        if (zzbae.length > 0)
        {
          int k = 0;
          for (;;)
          {
            j = i;
            if (k >= zzbae.length) {
              break;
            }
            zzqb.zzc localzzc = zzbae[k];
            j = i;
            if (localzzc != null) {
              j = i + zzsn.zzc(1, localzzc);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (name != null) {
        i = j + zzsn.zzo(2, name);
      }
      j = i;
      if (zzbaf != null) {
        j = i + zzsn.zzd(3, zzbaf.longValue());
      }
      i = j;
      if (zzbag != null) {
        i = j + zzsn.zzd(4, zzbag.longValue());
      }
      j = i;
      if (count != null) {
        j = i + zzsn.zzC(5, count.intValue());
      }
      return j;
    }
  }
  
  public static final class zzc
    extends zzsu
  {
    private static volatile zzc[] zzbah;
    public String name = null;
    public Float zzaZo = null;
    public String zzamJ = null;
    public Long zzbai = null;
    
    public zzc()
    {
      zzbuu = -1;
    }
    
    public static zzc[] zzDT()
    {
      if (zzbah == null) {}
      synchronized (zzss.zzbut)
      {
        if (zzbah == null) {
          zzbah = new zzc[0];
        }
        return zzbah;
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
          if (name == null)
          {
            if (name != null) {
              return false;
            }
          }
          else if (!name.equals(name)) {
            return false;
          }
          if (zzamJ == null)
          {
            if (zzamJ != null) {
              return false;
            }
          }
          else if (!zzamJ.equals(zzamJ)) {
            return false;
          }
          if (zzbai == null)
          {
            if (zzbai != null) {
              return false;
            }
          }
          else if (!zzbai.equals(zzbai)) {
            return false;
          }
          if (zzaZo != null) {
            break;
          }
        } while (zzaZo == null);
        return false;
      } while (zzaZo.equals(zzaZo));
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
      if (name == null)
      {
        i = 0;
        if (zzamJ != null) {
          break label88;
        }
        j = 0;
        if (zzbai != null) {
          break label99;
        }
        k = 0;
        label42:
        if (zzaZo != null) {
          break label110;
        }
      }
      for (;;)
      {
        return (k + (j + (i + (n + 527) * 31) * 31) * 31) * 31 + m;
        i = name.hashCode();
        break;
        label88:
        j = zzamJ.hashCode();
        break label33;
        label99:
        k = zzbai.hashCode();
        break label42;
        label110:
        m = zzaZo.hashCode();
      }
    }
    
    public final void writeTo(zzsn paramzzsn)
      throws IOException
    {
      if (name != null) {
        paramzzsn.zzn(1, name);
      }
      if (zzamJ != null) {
        paramzzsn.zzn(2, zzamJ);
      }
      if (zzbai != null) {
        paramzzsn.zzb(3, zzbai.longValue());
      }
      if (zzaZo != null) {
        paramzzsn.zzb(4, zzaZo.floatValue());
      }
      super.writeTo(paramzzsn);
    }
    
    protected final int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (name != null) {
        i = j + zzsn.zzo(1, name);
      }
      j = i;
      if (zzamJ != null) {
        j = i + zzsn.zzo(2, zzamJ);
      }
      i = j;
      if (zzbai != null) {
        i = j + zzsn.zzd(3, zzbai.longValue());
      }
      j = i;
      if (zzaZo != null)
      {
        zzaZo.floatValue();
        j = i + (zzsn.zzmA(4) + 4);
      }
      return j;
    }
  }
  
  public static final class zzd
    extends zzsu
  {
    public zzqb.zze[] zzbaj = zzqb.zze.zzDW();
    
    public zzd()
    {
      zzbuu = -1;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof zzd)) {
          return false;
        }
        paramObject = (zzd)paramObject;
      } while (zzss.equals(zzbaj, zzbaj));
      return false;
    }
    
    public final int hashCode()
    {
      return (getClass().getName().hashCode() + 527) * 31 + zzss.hashCode(zzbaj);
    }
    
    public final void writeTo(zzsn paramzzsn)
      throws IOException
    {
      if ((zzbaj != null) && (zzbaj.length > 0))
      {
        int i = 0;
        while (i < zzbaj.length)
        {
          zzqb.zze localzze = zzbaj[i];
          if (localzze != null) {
            paramzzsn.zza(1, localzze);
          }
          i += 1;
        }
      }
      super.writeTo(paramzzsn);
    }
    
    protected final int zzz()
    {
      int i = super.zzz();
      int k = i;
      if (zzbaj != null)
      {
        k = i;
        if (zzbaj.length > 0)
        {
          int j = 0;
          for (;;)
          {
            k = i;
            if (j >= zzbaj.length) {
              break;
            }
            zzqb.zze localzze = zzbaj[j];
            k = i;
            if (localzze != null) {
              k = i + zzsn.zzc(1, localzze);
            }
            j += 1;
            i = k;
          }
        }
      }
      return k;
    }
  }
  
  public static final class zze
    extends zzsu
  {
    private static volatile zze[] zzbak;
    public String appId = null;
    public String osVersion = null;
    public String zzaMV = null;
    public String zzaVt = null;
    public String zzaVu = null;
    public String zzaVx = null;
    public Boolean zzbaA = null;
    public String zzbaB = null;
    public Long zzbaC = null;
    public Integer zzbaD = null;
    public Boolean zzbaE = null;
    public zzqb.zza[] zzbaF = zzqb.zza.zzDP();
    public Integer zzbal = null;
    public zzqb.zzb[] zzbam = zzqb.zzb.zzDR();
    public zzqb.zzg[] zzban = zzqb.zzg.zzDZ();
    public Long zzbao = null;
    public Long zzbap = null;
    public Long zzbaq = null;
    public Long zzbar = null;
    public Long zzbas = null;
    public String zzbat = null;
    public String zzbau = null;
    public String zzbav = null;
    public Integer zzbaw = null;
    public Long zzbax = null;
    public Long zzbay = null;
    public String zzbaz = null;
    
    public zze()
    {
      zzbuu = -1;
    }
    
    public static zze[] zzDW()
    {
      if (zzbak == null) {}
      synchronized (zzss.zzbut)
      {
        if (zzbak == null) {
          zzbak = new zze[0];
        }
        return zzbak;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof zze)) {
          return false;
        }
        paramObject = (zze)paramObject;
        if (zzbal == null)
        {
          if (zzbal != null) {
            return false;
          }
        }
        else if (!zzbal.equals(zzbal)) {
          return false;
        }
        if (!zzss.equals(zzbam, zzbam)) {
          return false;
        }
        if (!zzss.equals(zzban, zzban)) {
          return false;
        }
        if (zzbao == null)
        {
          if (zzbao != null) {
            return false;
          }
        }
        else if (!zzbao.equals(zzbao)) {
          return false;
        }
        if (zzbap == null)
        {
          if (zzbap != null) {
            return false;
          }
        }
        else if (!zzbap.equals(zzbap)) {
          return false;
        }
        if (zzbaq == null)
        {
          if (zzbaq != null) {
            return false;
          }
        }
        else if (!zzbaq.equals(zzbaq)) {
          return false;
        }
        if (zzbar == null)
        {
          if (zzbar != null) {
            return false;
          }
        }
        else if (!zzbar.equals(zzbar)) {
          return false;
        }
        if (zzbas == null)
        {
          if (zzbas != null) {
            return false;
          }
        }
        else if (!zzbas.equals(zzbas)) {
          return false;
        }
        if (zzbat == null)
        {
          if (zzbat != null) {
            return false;
          }
        }
        else if (!zzbat.equals(zzbat)) {
          return false;
        }
        if (osVersion == null)
        {
          if (osVersion != null) {
            return false;
          }
        }
        else if (!osVersion.equals(osVersion)) {
          return false;
        }
        if (zzbau == null)
        {
          if (zzbau != null) {
            return false;
          }
        }
        else if (!zzbau.equals(zzbau)) {
          return false;
        }
        if (zzbav == null)
        {
          if (zzbav != null) {
            return false;
          }
        }
        else if (!zzbav.equals(zzbav)) {
          return false;
        }
        if (zzbaw == null)
        {
          if (zzbaw != null) {
            return false;
          }
        }
        else if (!zzbaw.equals(zzbaw)) {
          return false;
        }
        if (zzaVu == null)
        {
          if (zzaVu != null) {
            return false;
          }
        }
        else if (!zzaVu.equals(zzaVu)) {
          return false;
        }
        if (appId == null)
        {
          if (appId != null) {
            return false;
          }
        }
        else if (!appId.equals(appId)) {
          return false;
        }
        if (zzaMV == null)
        {
          if (zzaMV != null) {
            return false;
          }
        }
        else if (!zzaMV.equals(zzaMV)) {
          return false;
        }
        if (zzbax == null)
        {
          if (zzbax != null) {
            return false;
          }
        }
        else if (!zzbax.equals(zzbax)) {
          return false;
        }
        if (zzbay == null)
        {
          if (zzbay != null) {
            return false;
          }
        }
        else if (!zzbay.equals(zzbay)) {
          return false;
        }
        if (zzbaz == null)
        {
          if (zzbaz != null) {
            return false;
          }
        }
        else if (!zzbaz.equals(zzbaz)) {
          return false;
        }
        if (zzbaA == null)
        {
          if (zzbaA != null) {
            return false;
          }
        }
        else if (!zzbaA.equals(zzbaA)) {
          return false;
        }
        if (zzbaB == null)
        {
          if (zzbaB != null) {
            return false;
          }
        }
        else if (!zzbaB.equals(zzbaB)) {
          return false;
        }
        if (zzbaC == null)
        {
          if (zzbaC != null) {
            return false;
          }
        }
        else if (!zzbaC.equals(zzbaC)) {
          return false;
        }
        if (zzbaD == null)
        {
          if (zzbaD != null) {
            return false;
          }
        }
        else if (!zzbaD.equals(zzbaD)) {
          return false;
        }
        if (zzaVx == null)
        {
          if (zzaVx != null) {
            return false;
          }
        }
        else if (!zzaVx.equals(zzaVx)) {
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
        if (zzbaE == null)
        {
          if (zzbaE != null) {
            return false;
          }
        }
        else if (!zzbaE.equals(zzbaE)) {
          return false;
        }
      } while (zzss.equals(zzbaF, zzbaF));
      return false;
    }
    
    public final int hashCode()
    {
      int i19 = 0;
      int i20 = getClass().getName().hashCode();
      int i;
      int i21;
      int i22;
      int j;
      label51:
      int k;
      label60:
      int m;
      label70:
      int n;
      label80:
      int i1;
      label90:
      int i2;
      label100:
      int i3;
      label110:
      int i4;
      label120:
      int i5;
      label130:
      int i6;
      label140:
      int i7;
      label150:
      int i8;
      label160:
      int i9;
      label170:
      int i10;
      label180:
      int i11;
      label190:
      int i12;
      label200:
      int i13;
      label210:
      int i14;
      label220:
      int i15;
      label230:
      int i16;
      label240:
      int i17;
      label250:
      int i18;
      if (zzbal == null)
      {
        i = 0;
        i21 = zzss.hashCode(zzbam);
        i22 = zzss.hashCode(zzban);
        if (zzbao != null) {
          break label449;
        }
        j = 0;
        if (zzbap != null) {
          break label460;
        }
        k = 0;
        if (zzbaq != null) {
          break label471;
        }
        m = 0;
        if (zzbar != null) {
          break label483;
        }
        n = 0;
        if (zzbas != null) {
          break label495;
        }
        i1 = 0;
        if (zzbat != null) {
          break label507;
        }
        i2 = 0;
        if (osVersion != null) {
          break label519;
        }
        i3 = 0;
        if (zzbau != null) {
          break label531;
        }
        i4 = 0;
        if (zzbav != null) {
          break label543;
        }
        i5 = 0;
        if (zzbaw != null) {
          break label555;
        }
        i6 = 0;
        if (zzaVu != null) {
          break label567;
        }
        i7 = 0;
        if (appId != null) {
          break label579;
        }
        i8 = 0;
        if (zzaMV != null) {
          break label591;
        }
        i9 = 0;
        if (zzbax != null) {
          break label603;
        }
        i10 = 0;
        if (zzbay != null) {
          break label615;
        }
        i11 = 0;
        if (zzbaz != null) {
          break label627;
        }
        i12 = 0;
        if (zzbaA != null) {
          break label639;
        }
        i13 = 0;
        if (zzbaB != null) {
          break label651;
        }
        i14 = 0;
        if (zzbaC != null) {
          break label663;
        }
        i15 = 0;
        if (zzbaD != null) {
          break label675;
        }
        i16 = 0;
        if (zzaVx != null) {
          break label687;
        }
        i17 = 0;
        if (zzaVt != null) {
          break label699;
        }
        i18 = 0;
        label260:
        if (zzbaE != null) {
          break label711;
        }
      }
      for (;;)
      {
        return ((i18 + (i17 + (i16 + (i15 + (i14 + (i13 + (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (((i + (i20 + 527) * 31) * 31 + i21) * 31 + i22) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i19) * 31 + zzss.hashCode(zzbaF);
        i = zzbal.hashCode();
        break;
        label449:
        j = zzbao.hashCode();
        break label51;
        label460:
        k = zzbap.hashCode();
        break label60;
        label471:
        m = zzbaq.hashCode();
        break label70;
        label483:
        n = zzbar.hashCode();
        break label80;
        label495:
        i1 = zzbas.hashCode();
        break label90;
        label507:
        i2 = zzbat.hashCode();
        break label100;
        label519:
        i3 = osVersion.hashCode();
        break label110;
        label531:
        i4 = zzbau.hashCode();
        break label120;
        label543:
        i5 = zzbav.hashCode();
        break label130;
        label555:
        i6 = zzbaw.hashCode();
        break label140;
        label567:
        i7 = zzaVu.hashCode();
        break label150;
        label579:
        i8 = appId.hashCode();
        break label160;
        label591:
        i9 = zzaMV.hashCode();
        break label170;
        label603:
        i10 = zzbax.hashCode();
        break label180;
        label615:
        i11 = zzbay.hashCode();
        break label190;
        label627:
        i12 = zzbaz.hashCode();
        break label200;
        label639:
        i13 = zzbaA.hashCode();
        break label210;
        label651:
        i14 = zzbaB.hashCode();
        break label220;
        label663:
        i15 = zzbaC.hashCode();
        break label230;
        label675:
        i16 = zzbaD.hashCode();
        break label240;
        label687:
        i17 = zzaVx.hashCode();
        break label250;
        label699:
        i18 = zzaVt.hashCode();
        break label260;
        label711:
        i19 = zzbaE.hashCode();
      }
    }
    
    public final void writeTo(zzsn paramzzsn)
      throws IOException
    {
      int j = 0;
      if (zzbal != null) {
        paramzzsn.zzA(1, zzbal.intValue());
      }
      int i;
      Object localObject;
      if ((zzbam != null) && (zzbam.length > 0))
      {
        i = 0;
        while (i < zzbam.length)
        {
          localObject = zzbam[i];
          if (localObject != null) {
            paramzzsn.zza(2, (zzsu)localObject);
          }
          i += 1;
        }
      }
      if ((zzban != null) && (zzban.length > 0))
      {
        i = 0;
        while (i < zzban.length)
        {
          localObject = zzban[i];
          if (localObject != null) {
            paramzzsn.zza(3, (zzsu)localObject);
          }
          i += 1;
        }
      }
      if (zzbao != null) {
        paramzzsn.zzb(4, zzbao.longValue());
      }
      if (zzbap != null) {
        paramzzsn.zzb(5, zzbap.longValue());
      }
      if (zzbaq != null) {
        paramzzsn.zzb(6, zzbaq.longValue());
      }
      if (zzbas != null) {
        paramzzsn.zzb(7, zzbas.longValue());
      }
      if (zzbat != null) {
        paramzzsn.zzn(8, zzbat);
      }
      if (osVersion != null) {
        paramzzsn.zzn(9, osVersion);
      }
      if (zzbau != null) {
        paramzzsn.zzn(10, zzbau);
      }
      if (zzbav != null) {
        paramzzsn.zzn(11, zzbav);
      }
      if (zzbaw != null) {
        paramzzsn.zzA(12, zzbaw.intValue());
      }
      if (zzaVu != null) {
        paramzzsn.zzn(13, zzaVu);
      }
      if (appId != null) {
        paramzzsn.zzn(14, appId);
      }
      if (zzaMV != null) {
        paramzzsn.zzn(16, zzaMV);
      }
      if (zzbax != null) {
        paramzzsn.zzb(17, zzbax.longValue());
      }
      if (zzbay != null) {
        paramzzsn.zzb(18, zzbay.longValue());
      }
      if (zzbaz != null) {
        paramzzsn.zzn(19, zzbaz);
      }
      if (zzbaA != null) {
        paramzzsn.zze(20, zzbaA.booleanValue());
      }
      if (zzbaB != null) {
        paramzzsn.zzn(21, zzbaB);
      }
      if (zzbaC != null) {
        paramzzsn.zzb(22, zzbaC.longValue());
      }
      if (zzbaD != null) {
        paramzzsn.zzA(23, zzbaD.intValue());
      }
      if (zzaVx != null) {
        paramzzsn.zzn(24, zzaVx);
      }
      if (zzaVt != null) {
        paramzzsn.zzn(25, zzaVt);
      }
      if (zzbar != null) {
        paramzzsn.zzb(26, zzbar.longValue());
      }
      if (zzbaE != null) {
        paramzzsn.zze(28, zzbaE.booleanValue());
      }
      if ((zzbaF != null) && (zzbaF.length > 0))
      {
        i = j;
        while (i < zzbaF.length)
        {
          localObject = zzbaF[i];
          if (localObject != null) {
            paramzzsn.zza(29, (zzsu)localObject);
          }
          i += 1;
        }
      }
      super.writeTo(paramzzsn);
    }
    
    public final zze zzG(zzsm paramzzsm)
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
          zzbal = Integer.valueOf(paramzzsm.zzJf());
          break;
        case 18: 
          j = zzsx.zzc(paramzzsm, 18);
          if (zzbam == null) {}
          for (i = 0;; i = zzbam.length)
          {
            localObject = new zzqb.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(zzbam, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzqb.zzb();
              paramzzsm.zza(localObject[j]);
              paramzzsm.zzIX();
              j += 1;
            }
          }
          localObject[j] = new zzqb.zzb();
          paramzzsm.zza(localObject[j]);
          zzbam = ((zzqb.zzb[])localObject);
          break;
        case 26: 
          j = zzsx.zzc(paramzzsm, 26);
          if (zzban == null) {}
          for (i = 0;; i = zzban.length)
          {
            localObject = new zzqb.zzg[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(zzban, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzqb.zzg();
              paramzzsm.zza(localObject[j]);
              paramzzsm.zzIX();
              j += 1;
            }
          }
          localObject[j] = new zzqb.zzg();
          paramzzsm.zza(localObject[j]);
          zzban = ((zzqb.zzg[])localObject);
          break;
        case 32: 
          zzbao = Long.valueOf(paramzzsm.zzJg());
          break;
        case 40: 
          zzbap = Long.valueOf(paramzzsm.zzJg());
          break;
        case 48: 
          zzbaq = Long.valueOf(paramzzsm.zzJg());
          break;
        case 56: 
          zzbas = Long.valueOf(paramzzsm.zzJg());
          break;
        case 66: 
          zzbat = paramzzsm.readString();
          break;
        case 74: 
          osVersion = paramzzsm.readString();
          break;
        case 82: 
          zzbau = paramzzsm.readString();
          break;
        case 90: 
          zzbav = paramzzsm.readString();
          break;
        case 96: 
          zzbaw = Integer.valueOf(paramzzsm.zzJf());
          break;
        case 106: 
          zzaVu = paramzzsm.readString();
          break;
        case 114: 
          appId = paramzzsm.readString();
          break;
        case 130: 
          zzaMV = paramzzsm.readString();
          break;
        case 136: 
          zzbax = Long.valueOf(paramzzsm.zzJg());
          break;
        case 144: 
          zzbay = Long.valueOf(paramzzsm.zzJg());
          break;
        case 154: 
          zzbaz = paramzzsm.readString();
          break;
        case 160: 
          zzbaA = Boolean.valueOf(paramzzsm.zzJc());
          break;
        case 170: 
          zzbaB = paramzzsm.readString();
          break;
        case 176: 
          zzbaC = Long.valueOf(paramzzsm.zzJg());
          break;
        case 184: 
          zzbaD = Integer.valueOf(paramzzsm.zzJf());
          break;
        case 194: 
          zzaVx = paramzzsm.readString();
          break;
        case 202: 
          zzaVt = paramzzsm.readString();
          break;
        case 208: 
          zzbar = Long.valueOf(paramzzsm.zzJg());
          break;
        case 224: 
          zzbaE = Boolean.valueOf(paramzzsm.zzJc());
          break;
        case 234: 
          j = zzsx.zzc(paramzzsm, 234);
          if (zzbaF == null) {}
          for (i = 0;; i = zzbaF.length)
          {
            localObject = new zzqb.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(zzbaF, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzqb.zza();
              paramzzsm.zza(localObject[j]);
              paramzzsm.zzIX();
              j += 1;
            }
          }
          localObject[j] = new zzqb.zza();
          paramzzsm.zza(localObject[j]);
          zzbaF = ((zzqb.zza[])localObject);
        }
      }
    }
    
    protected final int zzz()
    {
      int m = 0;
      int j = super.zzz();
      int i = j;
      if (zzbal != null) {
        i = j + zzsn.zzC(1, zzbal.intValue());
      }
      j = i;
      Object localObject;
      if (zzbam != null)
      {
        j = i;
        if (zzbam.length > 0)
        {
          j = 0;
          while (j < zzbam.length)
          {
            localObject = zzbam[j];
            k = i;
            if (localObject != null) {
              k = i + zzsn.zzc(2, (zzsu)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (zzban != null)
      {
        i = j;
        if (zzban.length > 0)
        {
          i = j;
          j = 0;
          while (j < zzban.length)
          {
            localObject = zzban[j];
            k = i;
            if (localObject != null) {
              k = i + zzsn.zzc(3, (zzsu)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      j = i;
      if (zzbao != null) {
        j = i + zzsn.zzd(4, zzbao.longValue());
      }
      i = j;
      if (zzbap != null) {
        i = j + zzsn.zzd(5, zzbap.longValue());
      }
      j = i;
      if (zzbaq != null) {
        j = i + zzsn.zzd(6, zzbaq.longValue());
      }
      i = j;
      if (zzbas != null) {
        i = j + zzsn.zzd(7, zzbas.longValue());
      }
      j = i;
      if (zzbat != null) {
        j = i + zzsn.zzo(8, zzbat);
      }
      i = j;
      if (osVersion != null) {
        i = j + zzsn.zzo(9, osVersion);
      }
      j = i;
      if (zzbau != null) {
        j = i + zzsn.zzo(10, zzbau);
      }
      i = j;
      if (zzbav != null) {
        i = j + zzsn.zzo(11, zzbav);
      }
      j = i;
      if (zzbaw != null) {
        j = i + zzsn.zzC(12, zzbaw.intValue());
      }
      i = j;
      if (zzaVu != null) {
        i = j + zzsn.zzo(13, zzaVu);
      }
      j = i;
      if (appId != null) {
        j = i + zzsn.zzo(14, appId);
      }
      i = j;
      if (zzaMV != null) {
        i = j + zzsn.zzo(16, zzaMV);
      }
      j = i;
      if (zzbax != null) {
        j = i + zzsn.zzd(17, zzbax.longValue());
      }
      i = j;
      if (zzbay != null) {
        i = j + zzsn.zzd(18, zzbay.longValue());
      }
      j = i;
      if (zzbaz != null) {
        j = i + zzsn.zzo(19, zzbaz);
      }
      i = j;
      if (zzbaA != null)
      {
        zzbaA.booleanValue();
        i = j + (zzsn.zzmA(20) + 1);
      }
      j = i;
      if (zzbaB != null) {
        j = i + zzsn.zzo(21, zzbaB);
      }
      i = j;
      if (zzbaC != null) {
        i = j + zzsn.zzd(22, zzbaC.longValue());
      }
      j = i;
      if (zzbaD != null) {
        j = i + zzsn.zzC(23, zzbaD.intValue());
      }
      i = j;
      if (zzaVx != null) {
        i = j + zzsn.zzo(24, zzaVx);
      }
      j = i;
      if (zzaVt != null) {
        j = i + zzsn.zzo(25, zzaVt);
      }
      int k = j;
      if (zzbar != null) {
        k = j + zzsn.zzd(26, zzbar.longValue());
      }
      i = k;
      if (zzbaE != null)
      {
        zzbaE.booleanValue();
        i = k + (zzsn.zzmA(28) + 1);
      }
      k = i;
      if (zzbaF != null)
      {
        k = i;
        if (zzbaF.length > 0)
        {
          j = m;
          for (;;)
          {
            k = i;
            if (j >= zzbaF.length) {
              break;
            }
            localObject = zzbaF[j];
            k = i;
            if (localObject != null) {
              k = i + zzsn.zzc(29, (zzsu)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      return k;
    }
  }
  
  public static final class zzf
    extends zzsu
  {
    public long[] zzbaG = zzsx.zzbux;
    public long[] zzbaH = zzsx.zzbux;
    
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
        if (!zzss.equals(zzbaG, zzbaG)) {
          return false;
        }
      } while (zzss.equals(zzbaH, zzbaH));
      return false;
    }
    
    public final int hashCode()
    {
      return ((getClass().getName().hashCode() + 527) * 31 + zzss.hashCode(zzbaG)) * 31 + zzss.hashCode(zzbaH);
    }
    
    public final void writeTo(zzsn paramzzsn)
      throws IOException
    {
      int j = 0;
      int i;
      if ((zzbaG != null) && (zzbaG.length > 0))
      {
        i = 0;
        while (i < zzbaG.length)
        {
          paramzzsn.zza(1, zzbaG[i]);
          i += 1;
        }
      }
      if ((zzbaH != null) && (zzbaH.length > 0))
      {
        i = j;
        while (i < zzbaH.length)
        {
          paramzzsn.zza(2, zzbaH[i]);
          i += 1;
        }
      }
      super.writeTo(paramzzsn);
    }
    
    public final zzf zzH(zzsm paramzzsm)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzsm.zzIX();
        int j;
        long[] arrayOfLong;
        int k;
        switch (i)
        {
        default: 
          if (zzsx.zzb(paramzzsm, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          j = zzsx.zzc(paramzzsm, 8);
          if (zzbaG == null) {}
          for (i = 0;; i = zzbaG.length)
          {
            arrayOfLong = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(zzbaG, 0, arrayOfLong, 0, i);
              j = i;
            }
            while (j < arrayOfLong.length - 1)
            {
              arrayOfLong[j] = paramzzsm.zzJg();
              paramzzsm.zzIX();
              j += 1;
            }
          }
          arrayOfLong[j] = paramzzsm.zzJg();
          zzbaG = arrayOfLong;
          break;
        case 10: 
          k = paramzzsm.zzmq(paramzzsm.zzJf());
          i = paramzzsm.getPosition();
          j = 0;
          while (paramzzsm.zzJk() > 0)
          {
            paramzzsm.zzJg();
            j += 1;
          }
          paramzzsm.zzms(i);
          if (zzbaG == null) {}
          for (i = 0;; i = zzbaG.length)
          {
            arrayOfLong = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(zzbaG, 0, arrayOfLong, 0, i);
              j = i;
            }
            while (j < arrayOfLong.length)
            {
              arrayOfLong[j] = paramzzsm.zzJg();
              j += 1;
            }
          }
          zzbaG = arrayOfLong;
          paramzzsm.zzmr(k);
          break;
        case 16: 
          j = zzsx.zzc(paramzzsm, 16);
          if (zzbaH == null) {}
          for (i = 0;; i = zzbaH.length)
          {
            arrayOfLong = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(zzbaH, 0, arrayOfLong, 0, i);
              j = i;
            }
            while (j < arrayOfLong.length - 1)
            {
              arrayOfLong[j] = paramzzsm.zzJg();
              paramzzsm.zzIX();
              j += 1;
            }
          }
          arrayOfLong[j] = paramzzsm.zzJg();
          zzbaH = arrayOfLong;
          break;
        case 18: 
          k = paramzzsm.zzmq(paramzzsm.zzJf());
          i = paramzzsm.getPosition();
          j = 0;
          while (paramzzsm.zzJk() > 0)
          {
            paramzzsm.zzJg();
            j += 1;
          }
          paramzzsm.zzms(i);
          if (zzbaH == null) {}
          for (i = 0;; i = zzbaH.length)
          {
            arrayOfLong = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(zzbaH, 0, arrayOfLong, 0, i);
              j = i;
            }
            while (j < arrayOfLong.length)
            {
              arrayOfLong[j] = paramzzsm.zzJg();
              j += 1;
            }
          }
          zzbaH = arrayOfLong;
          paramzzsm.zzmr(k);
        }
      }
    }
    
    protected final int zzz()
    {
      int m = 0;
      int k = super.zzz();
      int j;
      if ((zzbaG != null) && (zzbaG.length > 0))
      {
        i = 0;
        j = 0;
        while (i < zzbaG.length)
        {
          j += zzsn.zzav(zzbaG[i]);
          i += 1;
        }
      }
      for (int i = k + j + zzbaG.length * 1;; i = k)
      {
        j = i;
        if (zzbaH != null)
        {
          j = i;
          if (zzbaH.length > 0)
          {
            k = 0;
            j = m;
            while (j < zzbaH.length)
            {
              k += zzsn.zzav(zzbaH[j]);
              j += 1;
            }
            j = i + k + zzbaH.length * 1;
          }
        }
        return j;
      }
    }
  }
  
  public static final class zzg
    extends zzsu
  {
    private static volatile zzg[] zzbaI;
    public String name = null;
    public Float zzaZo = null;
    public String zzamJ = null;
    public Long zzbaJ = null;
    public Long zzbai = null;
    
    public zzg()
    {
      zzbuu = -1;
    }
    
    public static zzg[] zzDZ()
    {
      if (zzbaI == null) {}
      synchronized (zzss.zzbut)
      {
        if (zzbaI == null) {
          zzbaI = new zzg[0];
        }
        return zzbaI;
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
          if (!(paramObject instanceof zzg)) {
            return false;
          }
          paramObject = (zzg)paramObject;
          if (zzbaJ == null)
          {
            if (zzbaJ != null) {
              return false;
            }
          }
          else if (!zzbaJ.equals(zzbaJ)) {
            return false;
          }
          if (name == null)
          {
            if (name != null) {
              return false;
            }
          }
          else if (!name.equals(name)) {
            return false;
          }
          if (zzamJ == null)
          {
            if (zzamJ != null) {
              return false;
            }
          }
          else if (!zzamJ.equals(zzamJ)) {
            return false;
          }
          if (zzbai == null)
          {
            if (zzbai != null) {
              return false;
            }
          }
          else if (!zzbai.equals(zzbai)) {
            return false;
          }
          if (zzaZo != null) {
            break;
          }
        } while (zzaZo == null);
        return false;
      } while (zzaZo.equals(zzaZo));
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
      if (zzbaJ == null)
      {
        i = 0;
        if (name != null) {
          break label104;
        }
        j = 0;
        if (zzamJ != null) {
          break label115;
        }
        k = 0;
        if (zzbai != null) {
          break label126;
        }
        m = 0;
        label52:
        if (zzaZo != null) {
          break label138;
        }
      }
      for (;;)
      {
        return (m + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31) * 31 + n;
        i = zzbaJ.hashCode();
        break;
        label104:
        j = name.hashCode();
        break label33;
        label115:
        k = zzamJ.hashCode();
        break label42;
        label126:
        m = zzbai.hashCode();
        break label52;
        label138:
        n = zzaZo.hashCode();
      }
    }
    
    public final void writeTo(zzsn paramzzsn)
      throws IOException
    {
      if (zzbaJ != null) {
        paramzzsn.zzb(1, zzbaJ.longValue());
      }
      if (name != null) {
        paramzzsn.zzn(2, name);
      }
      if (zzamJ != null) {
        paramzzsn.zzn(3, zzamJ);
      }
      if (zzbai != null) {
        paramzzsn.zzb(4, zzbai.longValue());
      }
      if (zzaZo != null) {
        paramzzsn.zzb(5, zzaZo.floatValue());
      }
      super.writeTo(paramzzsn);
    }
    
    protected final int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (zzbaJ != null) {
        i = j + zzsn.zzd(1, zzbaJ.longValue());
      }
      j = i;
      if (name != null) {
        j = i + zzsn.zzo(2, name);
      }
      i = j;
      if (zzamJ != null) {
        i = j + zzsn.zzo(3, zzamJ);
      }
      j = i;
      if (zzbai != null) {
        j = i + zzsn.zzd(4, zzbai.longValue());
      }
      i = j;
      if (zzaZo != null)
      {
        zzaZo.floatValue();
        i = j + (zzsn.zzmA(5) + 4);
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */