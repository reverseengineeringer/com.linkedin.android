package com.linkedin.data.lite;

import java.util.Arrays;

public final class Bytes
{
  byte[] _bytes;
  
  public Bytes(byte[] paramArrayOfByte)
  {
    _bytes = Arrays.copyOf(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof Bytes)) {
      bool = Arrays.equals(_bytes, _bytes);
    }
    return bool;
  }
  
  public final byte[] getBytes()
  {
    return Arrays.copyOf(_bytes, _bytes.length);
  }
  
  public final int hashCode()
  {
    int j = 0;
    byte[] arrayOfByte = _bytes;
    int k = arrayOfByte.length;
    int i = 0;
    while (i < k)
    {
      j ^= arrayOfByte[i];
      i += 1;
    }
    return j;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.Bytes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */