package com.fasterxml.jackson.core.io;

import java.math.BigDecimal;

public final class NumberInput
{
  static final String MAX_LONG_STR = "9223372036854775807";
  static final String MIN_LONG_STR_NO_SIGN = "-9223372036854775808".substring(1);
  
  private static NumberFormatException _badBD(String paramString)
  {
    return new NumberFormatException("Value \"" + paramString + "\" can not be represented as BigDecimal");
  }
  
  public static boolean inLongRange(char[] paramArrayOfChar, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str;
    int i;
    if (paramBoolean)
    {
      str = MIN_LONG_STR_NO_SIGN;
      i = str.length();
      if (paramInt2 >= i) {
        break label32;
      }
    }
    label32:
    label79:
    for (;;)
    {
      return true;
      str = MAX_LONG_STR;
      break;
      if (paramInt2 > i) {
        return false;
      }
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 >= i) {
          break label79;
        }
        int j = paramArrayOfChar[(paramInt1 + paramInt2)] - str.charAt(paramInt2);
        if (j != 0)
        {
          if (j < 0) {
            break;
          }
          return false;
        }
        paramInt2 += 1;
      }
    }
  }
  
  public static double parseAsDouble$505d11f3(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 0.0D;
      paramString = paramString.trim();
    } while (paramString.length() == 0);
    try
    {
      double d = parseDouble(paramString);
      return d;
    }
    catch (NumberFormatException paramString) {}
    return 0.0D;
  }
  
  public static int parseAsInt$505cff29(String paramString)
  {
    if (paramString == null) {}
    String str;
    int k;
    do
    {
      return 0;
      str = paramString.trim();
      k = str.length();
    } while (k == 0);
    int m = 0;
    int i = m;
    int j = k;
    paramString = str;
    int n;
    if (k > 0)
    {
      n = str.charAt(0);
      if (n != 43) {
        break label108;
      }
      paramString = str.substring(1);
      j = paramString.length();
      i = m;
    }
    while (i < j)
    {
      k = paramString.charAt(i);
      if ((k > 57) || (k < 48)) {}
      try
      {
        double d = parseDouble(paramString);
        return (int)d;
      }
      catch (NumberFormatException paramString)
      {
        try
        {
          label108:
          i = Integer.parseInt(paramString);
          return i;
        }
        catch (NumberFormatException paramString) {}
        paramString = paramString;
        return 0;
      }
      i = m;
      j = k;
      paramString = str;
      if (n == 45)
      {
        i = 0 + 1;
        j = k;
        paramString = str;
        continue;
        i += 1;
      }
    }
    return 0;
  }
  
  public static long parseAsLong$505cfb67(String paramString)
  {
    if (paramString == null) {}
    String str;
    int k;
    do
    {
      return 0L;
      str = paramString.trim();
      k = str.length();
    } while (k == 0);
    int m = 0;
    int i = m;
    int j = k;
    paramString = str;
    int n;
    if (k > 0)
    {
      n = str.charAt(0);
      if (n != 43) {
        break label108;
      }
      paramString = str.substring(1);
      j = paramString.length();
      i = m;
    }
    while (i < j)
    {
      k = paramString.charAt(i);
      if ((k > 57) || (k < 48)) {}
      try
      {
        double d = parseDouble(paramString);
        return d;
      }
      catch (NumberFormatException paramString)
      {
        try
        {
          label108:
          long l = Long.parseLong(paramString);
          return l;
        }
        catch (NumberFormatException paramString) {}
        paramString = paramString;
        return 0L;
      }
      i = m;
      j = k;
      paramString = str;
      if (n == 45)
      {
        i = 0 + 1;
        j = k;
        paramString = str;
        continue;
        i += 1;
      }
    }
    return 0L;
  }
  
  public static BigDecimal parseBigDecimal(String paramString)
    throws NumberFormatException
  {
    try
    {
      BigDecimal localBigDecimal = new BigDecimal(paramString);
      return localBigDecimal;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw _badBD(paramString);
    }
  }
  
  public static BigDecimal parseBigDecimal(char[] paramArrayOfChar)
    throws NumberFormatException
  {
    return parseBigDecimal(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public static BigDecimal parseBigDecimal(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws NumberFormatException
  {
    try
    {
      BigDecimal localBigDecimal = new BigDecimal(paramArrayOfChar, paramInt1, paramInt2);
      return localBigDecimal;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw _badBD(new String(paramArrayOfChar, paramInt1, paramInt2));
    }
  }
  
  public static double parseDouble(String paramString)
    throws NumberFormatException
  {
    if ("2.2250738585072012e-308".equals(paramString)) {
      return Double.MIN_VALUE;
    }
    return Double.parseDouble(paramString);
  }
  
  public static int parseInt(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int m = paramArrayOfChar[paramInt1] - '0';
    int i = m;
    int k = paramInt1;
    int j = paramInt2;
    if (paramInt2 > 4)
    {
      i = paramInt1 + 1;
      paramInt1 = paramArrayOfChar[i];
      j = i + 1;
      i = paramArrayOfChar[j];
      k = j + 1;
      j = paramArrayOfChar[k];
      int n = k + 1;
      paramInt1 = (((m * 10 + (paramInt1 - 48)) * 10 + (i - 48)) * 10 + (j - 48)) * 10 + (paramArrayOfChar[n] - '0');
      paramInt2 -= 4;
      i = paramInt1;
      k = n;
      j = paramInt2;
      if (paramInt2 > 4)
      {
        i = n + 1;
        paramInt2 = paramArrayOfChar[i];
        j = i + 1;
        i = paramArrayOfChar[j];
        j += 1;
        return (((paramInt1 * 10 + (paramInt2 - 48)) * 10 + (i - 48)) * 10 + (paramArrayOfChar[j] - '0')) * 10 + (paramArrayOfChar[(j + 1)] - '0');
      }
    }
    paramInt1 = i;
    if (j > 1)
    {
      k += 1;
      paramInt2 = i * 10 + (paramArrayOfChar[k] - '0');
      paramInt1 = paramInt2;
      if (j > 2)
      {
        i = k + 1;
        paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
        paramInt1 = paramInt2;
        if (j > 3) {
          paramInt1 = paramInt2 * 10 + (paramArrayOfChar[(i + 1)] - '0');
        }
      }
    }
    return paramInt1;
  }
  
  public static long parseLong(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramInt2 -= 9;
    return parseInt(paramArrayOfChar, paramInt1, paramInt2) * 1000000000L + parseInt(paramArrayOfChar, paramInt1 + paramInt2, 9);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.io.NumberInput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */