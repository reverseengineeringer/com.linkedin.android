package com.crashlytics.android.core;

import java.io.UnsupportedEncodingException;

final class ByteString
{
  public static final ByteString EMPTY = new ByteString(new byte[0]);
  final byte[] bytes;
  private volatile int hash = 0;
  
  private ByteString(byte[] paramArrayOfByte)
  {
    bytes = paramArrayOfByte;
  }
  
  public static ByteString copyFrom$3d5b0678(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
    return new ByteString(arrayOfByte);
  }
  
  public static ByteString copyFromUtf8(String paramString)
  {
    try
    {
      paramString = new ByteString(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported.", paramString);
    }
  }
  
  public final void copyTo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(bytes, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof ByteString)) {
        return false;
      }
      Object localObject = (ByteString)paramObject;
      int j = bytes.length;
      if (j != bytes.length) {
        return false;
      }
      paramObject = bytes;
      localObject = bytes;
      int i = 0;
      while (i < j)
      {
        if (paramObject[i] != localObject[i]) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public final int hashCode()
  {
    int i = hash;
    int j = i;
    if (i == 0)
    {
      byte[] arrayOfByte = bytes;
      int k = bytes.length;
      i = k;
      j = 0;
      while (j < k)
      {
        i = i * 31 + arrayOfByte[j];
        j += 1;
      }
      j = i;
      if (i == 0) {
        j = 1;
      }
      hash = j;
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.ByteString
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */