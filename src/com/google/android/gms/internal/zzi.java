package com.google.android.gms.internal;

import java.util.Map;

public final class zzi
{
  public final byte[] data;
  public final int statusCode;
  public final Map<String, String> zzA;
  public final boolean zzB;
  public final long zzC;
  
  public zzi(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    statusCode = paramInt;
    data = paramArrayOfByte;
    zzA = paramMap;
    zzB = paramBoolean;
    zzC = paramLong;
  }
  
  public zzi(byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this(200, paramArrayOfByte, paramMap, false, 0L);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */