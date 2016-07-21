package com.google.android.gms.internal;

import android.text.TextUtils;

@zzhb
public abstract class zzby
{
  @zzhb
  public static final zzby zzxs = new zzby()
  {
    public final String zzb(String paramAnonymousString1, String paramAnonymousString2)
    {
      return paramAnonymousString2;
    }
  };
  @zzhb
  public static final zzby zzxt = new zzby()
  {
    public final String zzb(String paramAnonymousString1, String paramAnonymousString2)
    {
      if (paramAnonymousString1 != null) {
        return paramAnonymousString1;
      }
      return paramAnonymousString2;
    }
  };
  @zzhb
  public static final zzby zzxu = new zzby()
  {
    private static String zzM(String paramAnonymousString)
    {
      if (TextUtils.isEmpty(paramAnonymousString)) {}
      int i;
      int j;
      do
      {
        return paramAnonymousString;
        i = 0;
        int k = paramAnonymousString.length();
        for (;;)
        {
          j = k;
          if (i >= paramAnonymousString.length()) {
            break;
          }
          j = k;
          if (paramAnonymousString.charAt(i) != ',') {
            break;
          }
          i += 1;
        }
        while ((j > 0) && (paramAnonymousString.charAt(j - 1) == ',')) {
          j -= 1;
        }
      } while ((i == 0) && (j == paramAnonymousString.length()));
      return paramAnonymousString.substring(i, j);
    }
    
    public final String zzb(String paramAnonymousString1, String paramAnonymousString2)
    {
      paramAnonymousString1 = zzM(paramAnonymousString1);
      paramAnonymousString2 = zzM(paramAnonymousString2);
      if (TextUtils.isEmpty(paramAnonymousString1)) {
        return paramAnonymousString2;
      }
      if (TextUtils.isEmpty(paramAnonymousString2)) {
        return paramAnonymousString1;
      }
      return paramAnonymousString1 + "," + paramAnonymousString2;
    }
  };
  
  public abstract String zzb(String paramString1, String paramString2);
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzby
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */