package com.linkedin.android.networking.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.linkedin.android.networking.cookies.CookieUtil;
import okhttp3.Headers;
import okhttp3.Request.Builder;

public class HeaderUtil
{
  private static final String TAG = HeaderUtil.class.getName();
  
  public static String getCDNProvider(Headers paramHeaders)
  {
    String str = null;
    if (paramHeaders != null) {
      str = paramHeaders.get("X-CDN");
    }
    return str;
  }
  
  public static long getContentLength(Headers paramHeaders)
  {
    long l1 = -1L;
    if (paramHeaders != null)
    {
      long l2 = tryParseLong(paramHeaders.get("Content-Length"));
      l1 = l2;
      if (l2 <= 0L) {
        l1 = tryParseLong(paramHeaders.get("X-Li-Content-Length"));
      }
    }
    return l1;
  }
  
  public static String getPop(Headers paramHeaders)
  {
    String str = null;
    if (paramHeaders != null) {
      str = paramHeaders.get("X-Li-Pop");
    }
    return str;
  }
  
  public static long getServerTime(Headers paramHeaders)
  {
    long l2 = -1L;
    long l1 = l2;
    if (paramHeaders != null)
    {
      paramHeaders = paramHeaders.get("X-LI-Server-Time");
      l1 = l2;
      if (!TextUtils.isEmpty(paramHeaders)) {
        l1 = Long.parseLong(paramHeaders);
      }
    }
    return l1;
  }
  
  public static String getTreeId(Headers paramHeaders)
  {
    if (paramHeaders != null)
    {
      paramHeaders = paramHeaders.get("X-LI-UUID");
      if (!TextUtils.isEmpty(paramHeaders)) {
        return paramHeaders;
      }
    }
    return null;
  }
  
  public static void setAcceptEncodingHeader(Request.Builder paramBuilder, String paramString)
  {
    paramBuilder.header("Accept-Encoding", paramString);
  }
  
  public static void setCsrfHeader(Request.Builder paramBuilder, CookieUtil paramCookieUtil, String paramString)
  {
    paramCookieUtil = paramCookieUtil.getJsessionIdOrSetIfNull(paramString);
    if (!TextUtils.isEmpty(paramCookieUtil)) {
      paramBuilder.header("Csrf-Token", paramCookieUtil);
    }
  }
  
  public static void setDefaultHeaders$515aa7a8(Request.Builder paramBuilder, Context paramContext, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
  {
    paramBuilder.header("X-UDID", Installation.id(paramContext));
    paramBuilder.header("X-LI-Track", XLiTrackHeader.xlitrack$3b5e4777(paramContext, paramString1, paramString2, paramBoolean, paramString3, paramString4));
  }
  
  public static void setLangHeader(Request.Builder paramBuilder, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramBuilder.header("X-LI-Lang", paramString);
      paramBuilder.header("Accept-Language", paramString.replace('_', '-'));
    }
  }
  
  private static long tryParseLong(String paramString)
  {
    long l = -1L;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      Log.e(TAG, "Unable to parse long.", paramString);
    }
    return -1L;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.util.HeaderUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */