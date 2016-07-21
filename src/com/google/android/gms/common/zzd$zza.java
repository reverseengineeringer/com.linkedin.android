package com.google.android.gms.common;

import com.google.android.gms.common.internal.zzx;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class zzd$zza
{
  private int zzafG;
  
  protected zzd$zza(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 25) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "cert hash data has incorrect length");
      zzafG = Arrays.hashCode(paramArrayOfByte);
      return;
    }
  }
  
  protected static byte[] zzcs(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ISO-8859-1");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof zza))) {
      return false;
    }
    paramObject = (zza)paramObject;
    return Arrays.equals(getBytes(), ((zza)paramObject).getBytes());
  }
  
  abstract byte[] getBytes();
  
  public int hashCode()
  {
    return zzafG;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.zzd.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */