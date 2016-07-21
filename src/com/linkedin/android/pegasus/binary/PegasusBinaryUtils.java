package com.linkedin.android.pegasus.binary;

public final class PegasusBinaryUtils
{
  public static int getEncodedLength(String paramString)
  {
    int i = 0;
    int k = paramString.length();
    int j = 0;
    if (j < k)
    {
      int m = paramString.charAt(j);
      if ((m != 0) && (m <= 127)) {
        i += 1;
      }
      for (;;)
      {
        j += 1;
        break;
        if (m <= 2047) {
          i += 2;
        } else {
          i += 3;
        }
      }
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.binary.PegasusBinaryUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */