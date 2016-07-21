package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.ByteBuffer;

public final class zzpm$zzd
  extends zzso<zzd>
{
  public boolean zzaMv = false;
  public long zzaMw = 0L;
  public double zzaMx = 0.0D;
  public zzpm.zzc zzaMy = null;
  public String zzamJ = "";
  
  public zzpm$zzd()
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

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpm.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */