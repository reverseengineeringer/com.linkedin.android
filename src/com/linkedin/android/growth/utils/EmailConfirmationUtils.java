package com.linkedin.android.growth.utils;

import android.text.TextUtils;
import com.linkedin.android.infra.shared.Util;
import java.net.MalformedURLException;
import java.net.URL;

public final class EmailConfirmationUtils
{
  public static boolean isUrlGeneratedDuringReg(String paramString)
  {
    try
    {
      paramString = new URL(paramString).getQuery();
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = "crua".equals(paramString[i].split("=")[0]);
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (MalformedURLException paramString)
    {
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Invalid email confirmation url"));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.utils.EmailConfirmationUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */