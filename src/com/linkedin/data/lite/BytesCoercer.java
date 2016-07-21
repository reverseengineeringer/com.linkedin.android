package com.linkedin.data.lite;

public final class BytesCoercer
{
  public static BytesCoercer INSTANCE = new BytesCoercer();
  
  public static Bytes coerceFromCustomType(String paramString)
  {
    return new Bytes(BytesUtil.stringToBytes(paramString));
  }
  
  public static String coerceToCustomType(Bytes paramBytes)
  {
    return BytesUtil.bytesToString(_bytes);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.BytesCoercer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */