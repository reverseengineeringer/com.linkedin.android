package com.linkedin.data.lite;

public final class BytesUtil
{
  public static String bytesToString(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((char)((char)paramArrayOfByte[i] & 0xFF));
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static byte[] stringToBytes(String paramString)
  {
    int j = 0;
    int k = paramString.length();
    byte[] arrayOfByte = new byte[k];
    int i = 0;
    while (i < k)
    {
      int m = paramString.charAt(i);
      j = (char)(j | m);
      arrayOfByte[i] = ((byte)(m & 0xFF));
      i += 1;
    }
    if ((0xFF00 & j) != 0) {
      throw new IllegalArgumentException("'" + paramString + "' is not a valid string representation of bytes.");
    }
    return arrayOfByte;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.BytesUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */