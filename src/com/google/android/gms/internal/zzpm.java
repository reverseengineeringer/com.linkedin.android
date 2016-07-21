package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract interface zzpm
{
  public static final class zzb
    extends zzso<zzb>
  {
    private static volatile zzb[] zzaMs;
    public String name = "";
    public zzpm.zzd zzaMt = null;
    
    public zzb()
    {
      zzbuj = null;
      zzbuu = -1;
    }
    
    public static zzb[] zzys()
    {
      if (zzaMs == null) {}
      synchronized (zzss.zzbut)
      {
        if (zzaMs == null) {
          zzaMs = new zzb[0];
        }
        return zzaMs;
      }
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
        if (name == null)
        {
          if (name != null) {
            return false;
          }
        }
        else if (!name.equals(name)) {
          return false;
        }
        if (zzaMt == null)
        {
          if (zzaMt != null) {
            return false;
          }
        }
        else if (!zzaMt.equals(zzaMt)) {
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
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int j;
      if (name == null)
      {
        i = 0;
        if (zzaMt != null) {
          break label89;
        }
        j = 0;
        label33:
        k = m;
        if (zzbuj != null) {
          if (!zzbuj.isEmpty()) {
            break label100;
          }
        }
      }
      label89:
      label100:
      for (int k = m;; k = zzbuj.hashCode())
      {
        return (j + (i + (n + 527) * 31) * 31) * 31 + k;
        i = name.hashCode();
        break;
        j = zzaMt.hashCode();
        break label33;
      }
    }
    
    public final void writeTo(zzsn paramzzsn)
      throws IOException
    {
      if (!name.equals("")) {
        paramzzsn.zzn(1, name);
      }
      if (zzaMt != null) {
        paramzzsn.zza(2, zzaMt);
      }
      super.writeTo(paramzzsn);
    }
    
    protected final int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (!name.equals("")) {
        i = j + zzsn.zzo(1, name);
      }
      j = i;
      if (zzaMt != null) {
        j = i + zzsn.zzc(2, zzaMt);
      }
      return j;
    }
  }
  
  public static final class zzc
    extends zzso<zzc>
  {
    public String type = "";
    public zzpm.zzb[] zzaMu = zzpm.zzb.zzys();
    
    public zzc()
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
  
  public static final class zzd
    extends zzso<zzd>
  {
    public boolean zzaMv = false;
    public long zzaMw = 0L;
    public double zzaMx = 0.0D;
    public zzpm.zzc zzaMy = null;
    public String zzamJ = "";
    
    public zzd()
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
        if (!(paramObject instanceof zzd)) {
          return false;
        }
        paramObject = (zzd)paramObject;
        if (zzaMv != zzaMv) {
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
        if (zzaMw != zzaMw) {
          return false;
        }
        if (Double.doubleToLongBits(zzaMx) != Double.doubleToLongBits(zzaMx)) {
          return false;
        }
        if (zzaMy == null)
        {
          if (zzaMy != null) {
            return false;
          }
        }
        else if (!zzaMy.equals(zzaMy)) {
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
      int n = 0;
      int i1 = getClass().getName().hashCode();
      int i;
      int j;
      label35:
      int i2;
      int i3;
      int k;
      if (zzaMv)
      {
        i = 1231;
        if (zzamJ != null) {
          break label151;
        }
        j = 0;
        i2 = (int)(zzaMw ^ zzaMw >>> 32);
        long l = Double.doubleToLongBits(zzaMx);
        i3 = (int)(l ^ l >>> 32);
        if (zzaMy != null) {
          break label162;
        }
        k = 0;
        label79:
        m = n;
        if (zzbuj != null) {
          if (!zzbuj.isEmpty()) {
            break label173;
          }
        }
      }
      label151:
      label162:
      label173:
      for (int m = n;; m = zzbuj.hashCode())
      {
        return (k + (((j + (i + (i1 + 527) * 31) * 31) * 31 + i2) * 31 + i3) * 31) * 31 + m;
        i = 1237;
        break;
        j = zzamJ.hashCode();
        break label35;
        k = zzaMy.hashCode();
        break label79;
      }
    }
    
    public final void writeTo(zzsn paramzzsn)
      throws IOException
    {
      if (zzaMv) {
        paramzzsn.zze(1, zzaMv);
      }
      if (!zzamJ.equals("")) {
        paramzzsn.zzn(2, zzamJ);
      }
      if (zzaMw != 0L) {
        paramzzsn.zzb(3, zzaMw);
      }
      if (Double.doubleToLongBits(zzaMx) != Double.doubleToLongBits(0.0D))
      {
        double d = zzaMx;
        paramzzsn.zzE(4, 1);
        long l = Double.doubleToLongBits(d);
        if (zzbui.remaining() < 8) {
          throw new zzsn.zza(zzbui.position(), zzbui.limit());
        }
        zzbui.putLong(l);
      }
      if (zzaMy != null) {
        paramzzsn.zza(5, zzaMy);
      }
      super.writeTo(paramzzsn);
    }
    
    protected final int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (zzaMv) {
        i = j + (zzsn.zzmA(1) + 1);
      }
      j = i;
      if (!zzamJ.equals("")) {
        j = i + zzsn.zzo(2, zzamJ);
      }
      i = j;
      if (zzaMw != 0L) {
        i = j + zzsn.zzd(3, zzaMw);
      }
      j = i;
      if (Double.doubleToLongBits(zzaMx) != Double.doubleToLongBits(0.0D)) {
        j = i + (zzsn.zzmA(4) + 8);
      }
      i = j;
      if (zzaMy != null) {
        i = j + zzsn.zzc(5, zzaMy);
      }
      return i;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */