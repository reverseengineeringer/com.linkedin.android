package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzsu
{
  protected volatile int zzbuu = -1;
  
  public static final byte[] toByteArray(zzsu paramzzsu)
  {
    byte[] arrayOfByte = new byte[paramzzsu.getSerializedSize()];
    int i = arrayOfByte.length;
    try
    {
      zzsn localzzsn = zzsn.zzb$46aa22ba(arrayOfByte, i);
      paramzzsu.writeTo(localzzsn);
      localzzsn.zzJo();
      return arrayOfByte;
    }
    catch (IOException paramzzsu)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", paramzzsu);
    }
  }
  
  public zzsu clone()
    throws CloneNotSupportedException
  {
    return (zzsu)super.clone();
  }
  
  public final int getCachedSize()
  {
    if (zzbuu < 0) {
      getSerializedSize();
    }
    return zzbuu;
  }
  
  public final int getSerializedSize()
  {
    int i = zzz();
    zzbuu = i;
    return i;
  }
  
  public abstract zzsu mergeFrom(zzsm paramzzsm)
    throws IOException;
  
  public String toString()
  {
    return zzsv.zzf(this);
  }
  
  public void writeTo(zzsn paramzzsn)
    throws IOException
  {}
  
  protected int zzz()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */