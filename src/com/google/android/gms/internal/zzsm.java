package com.google.android.gms.internal;

import java.io.IOException;

public final class zzsm
{
  final byte[] buffer;
  int zzbtZ;
  private int zzbua;
  private int zzbub;
  private int zzbuc;
  private int zzbud;
  private int zzbue = Integer.MAX_VALUE;
  private int zzbuf;
  private int zzbug = 64;
  private int zzbuh = 67108864;
  
  private zzsm(byte[] paramArrayOfByte, int paramInt)
  {
    buffer = paramArrayOfByte;
    zzbtZ = 0;
    zzbua = (paramInt + 0);
    zzbuc = 0;
  }
  
  public static zzsm zzD(byte[] paramArrayOfByte)
  {
    return new zzsm(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  private void zzJj()
  {
    zzbua += zzbub;
    int i = zzbua;
    if (i > zzbue)
    {
      zzbub = (i - zzbue);
      zzbua -= zzbub;
      return;
    }
    zzbub = 0;
  }
  
  private byte zzJm()
    throws IOException
  {
    if (zzbuc == zzbua) {
      throw zzst.zzJs();
    }
    byte[] arrayOfByte = buffer;
    int i = zzbuc;
    zzbuc = (i + 1);
    return arrayOfByte[i];
  }
  
  private void zzmn(int paramInt)
    throws zzst
  {
    if (zzbud != paramInt) {
      throw zzst.zzJw();
    }
  }
  
  private void zzmu(int paramInt)
    throws IOException
  {
    if (paramInt < 0) {
      throw zzst.zzJt();
    }
    if (zzbuc + paramInt > zzbue)
    {
      zzmu(zzbue - zzbuc);
      throw zzst.zzJs();
    }
    if (paramInt <= zzbua - zzbuc)
    {
      zzbuc += paramInt;
      return;
    }
    throw zzst.zzJs();
  }
  
  public final int getPosition()
  {
    return zzbuc - zzbtZ;
  }
  
  public final String readString()
    throws IOException
  {
    int i = zzJf();
    Object localObject;
    if ((i <= zzbua - zzbuc) && (i > 0))
    {
      localObject = new String(buffer, zzbuc, i, "UTF-8");
      zzbuc = (i + zzbuc);
      return (String)localObject;
    }
    if (i < 0) {
      throw zzst.zzJt();
    }
    if (zzbuc + i > zzbue)
    {
      zzmu(zzbue - zzbuc);
      throw zzst.zzJs();
    }
    if (i <= zzbua - zzbuc)
    {
      localObject = new byte[i];
      System.arraycopy(buffer, zzbuc, localObject, 0, i);
      zzbuc = (i + zzbuc);
      return new String((byte[])localObject, "UTF-8");
    }
    throw zzst.zzJs();
  }
  
  public final int zzIX()
    throws IOException
  {
    if (zzbuc == zzbua) {}
    for (int i = 1; i != 0; i = 0)
    {
      zzbud = 0;
      return 0;
    }
    zzbud = zzJf();
    if (zzbud == 0) {
      throw zzst.zzJv();
    }
    return zzbud;
  }
  
  public final boolean zzJc()
    throws IOException
  {
    return zzJf() != 0;
  }
  
  public final int zzJf()
    throws IOException
  {
    int i = zzJm();
    if (i >= 0) {}
    int k;
    do
    {
      return i;
      i &= 0x7F;
      j = zzJm();
      if (j >= 0) {
        return i | j << 7;
      }
      i |= (j & 0x7F) << 7;
      j = zzJm();
      if (j >= 0) {
        return i | j << 14;
      }
      i |= (j & 0x7F) << 14;
      k = zzJm();
      if (k >= 0) {
        return i | k << 21;
      }
      j = zzJm();
      k = i | (k & 0x7F) << 21 | j << 28;
      i = k;
    } while (j >= 0);
    int j = 0;
    for (;;)
    {
      if (j >= 5) {
        break label133;
      }
      i = k;
      if (zzJm() >= 0) {
        break;
      }
      j += 1;
    }
    label133:
    throw zzst.zzJu();
  }
  
  public final long zzJg()
    throws IOException
  {
    int i = 0;
    long l = 0L;
    while (i < 64)
    {
      int j = zzJm();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0) {
        return l;
      }
      i += 7;
    }
    throw zzst.zzJu();
  }
  
  public final int zzJh()
    throws IOException
  {
    return zzJm() & 0xFF | (zzJm() & 0xFF) << 8 | (zzJm() & 0xFF) << 16 | (zzJm() & 0xFF) << 24;
  }
  
  public final long zzJi()
    throws IOException
  {
    int i = zzJm();
    int j = zzJm();
    int k = zzJm();
    int m = zzJm();
    int n = zzJm();
    int i1 = zzJm();
    int i2 = zzJm();
    int i3 = zzJm();
    long l = i;
    return (j & 0xFF) << 8 | l & 0xFF | (k & 0xFF) << 16 | (m & 0xFF) << 24 | (n & 0xFF) << 32 | (i1 & 0xFF) << 40 | (i2 & 0xFF) << 48 | (i3 & 0xFF) << 56;
  }
  
  public final int zzJk()
  {
    if (zzbue == Integer.MAX_VALUE) {
      return -1;
    }
    int i = zzbuc;
    return zzbue - i;
  }
  
  public final void zza(zzsu paramzzsu)
    throws IOException
  {
    int i = zzJf();
    if (zzbuf >= zzbug) {
      throw zzst.zzJy();
    }
    i = zzmq(i);
    zzbuf += 1;
    paramzzsu.mergeFrom(this);
    zzmn(0);
    zzbuf -= 1;
    zzmr(i);
  }
  
  public final boolean zzmo(int paramInt)
    throws IOException
  {
    switch (zzsx.zzmI(paramInt))
    {
    default: 
      throw zzst.zzJx();
    case 0: 
      zzJf();
      return true;
    case 1: 
      zzJi();
      return true;
    case 2: 
      zzmu(zzJf());
      return true;
    case 3: 
      int i;
      do
      {
        i = zzIX();
      } while ((i != 0) && (zzmo(i)));
      zzmn(zzsx.zzF(zzsx.zzmJ(paramInt), 4));
      return true;
    case 4: 
      return false;
    }
    zzJh();
    return true;
  }
  
  public final int zzmq(int paramInt)
    throws zzst
  {
    if (paramInt < 0) {
      throw zzst.zzJt();
    }
    paramInt = zzbuc + paramInt;
    int i = zzbue;
    if (paramInt > i) {
      throw zzst.zzJs();
    }
    zzbue = paramInt;
    zzJj();
    return i;
  }
  
  public final void zzmr(int paramInt)
  {
    zzbue = paramInt;
    zzJj();
  }
  
  public final void zzms(int paramInt)
  {
    if (paramInt > zzbuc - zzbtZ) {
      throw new IllegalArgumentException("Position " + paramInt + " is beyond current " + (zzbuc - zzbtZ));
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad position " + paramInt);
    }
    zzbuc = (zzbtZ + paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */