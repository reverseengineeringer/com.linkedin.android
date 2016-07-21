package com.linkedin.android.pegasus.gen.common;

import java.net.URISyntaxException;

public final class UrnCoercer
{
  public static UrnCoercer INSTANCE = new UrnCoercer();
  
  public static String coerceFromCustomType(Urn paramUrn)
  {
    if (paramUrn != null) {
      return paramUrn.toString();
    }
    return null;
  }
  
  public static Urn coerceToCustomType(String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = new Urn(paramString);
      return paramString;
    }
    catch (URISyntaxException paramString)
    {
      throw new IllegalArgumentException(paramString);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.common.UrnCoercer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */