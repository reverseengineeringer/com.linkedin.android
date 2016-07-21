package com.google.android.gms.internal;

import java.util.Arrays;

final class zzsw
{
  final int tag;
  final byte[] zzbuv;
  
  zzsw(int paramInt, byte[] paramArrayOfByte)
  {
    tag = paramInt;
    zzbuv = paramArrayOfByte;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzsw)) {
        return false;
      }
      paramObject = (zzsw)paramObject;
    } while ((tag == tag) && (Arrays.equals(zzbuv, zzbuv)));
    return false;
  }
  
  public final int hashCode()
  {
    return (tag + 527) * 31 + Arrays.hashCode(zzbuv);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzsw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */