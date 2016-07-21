package com.linkedin.android.networking.cookies;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.CookieJar;

public class CookieUtil
{
  public static final Set<String> SAVED_COOKIES;
  public static final String TAG = CookieUtil.class.getName();
  private static final Random random = new SecureRandom();
  private final CookieJar cookieJar;
  private final CookieManager cookieManager;
  
  static
  {
    HashSet localHashSet = new HashSet();
    SAVED_COOKIES = localHashSet;
    localHashSet.add("bscookie");
    SAVED_COOKIES.add("host_override");
    SAVED_COOKIES.add("JSESSIONID");
    SAVED_COOKIES.add("lror");
  }
  
  public CookieUtil(Context paramContext)
  {
    cookieManager = new CookieManager(PersistentCookieStore.getInstance(paramContext), CookiePolicy.ACCEPT_ORIGINAL_SERVER);
    cookieJar = new LinkedInCookieJar(cookieManager);
  }
  
  public static String buildDomainName(String paramString)
  {
    return "." + paramString;
  }
  
  public static HttpCookie createHttpCookie(URI paramURI, String paramString1, String paramString2, int paramInt)
  {
    paramString1 = new HttpCookie(paramString1, paramString2);
    paramString1.setMaxAge(TimeUnit.DAYS.toSeconds(paramInt));
    paramString1.setDomain(paramURI.getHost());
    paramString1.setPath("/");
    paramString1.setVersion(0);
    return paramString1;
  }
  
  public static URI uriForString(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new URI(paramString);
      return paramString;
    }
    catch (URISyntaxException paramString) {}
    return null;
  }
  
  public final CookieJar cookieJar()
  {
    try
    {
      CookieJar localCookieJar = cookieJar;
      return localCookieJar;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final CookieManager cookieManager()
  {
    try
    {
      CookieHandler.setDefault(cookieManager);
      CookieManager localCookieManager = cookieManager;
      return localCookieManager;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String getCookieValue(String paramString1, String paramString2)
  {
    paramString1 = getCookieWithName(paramString1, paramString2);
    if (paramString1 != null) {
      return paramString1.getValue();
    }
    return null;
  }
  
  public final HttpCookie getCookieWithName(String paramString1, String paramString2)
  {
    paramString2 = uriForString(paramString2);
    if (paramString2 != null)
    {
      paramString2 = cookieManager().getCookieStore().get(paramString2).iterator();
      while (paramString2.hasNext())
      {
        HttpCookie localHttpCookie = (HttpCookie)paramString2.next();
        if ((localHttpCookie.getName() != null) && (localHttpCookie.getName().equals(paramString1))) {
          return localHttpCookie;
        }
      }
    }
    return null;
  }
  
  public final String getJsessionIdOrSetIfNull(String paramString)
  {
    Object localObject2 = getCookieValue("JSESSIONID", paramString);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramString = uriForString(paramString);
      long l2 = Math.abs(random.nextLong());
      long l1 = l2;
      if (l2 == Long.MIN_VALUE) {
        l1 = Long.MAX_VALUE;
      }
      localObject1 = "ajax:" + String.format("%019d", new Object[] { Long.valueOf(l1) });
      localObject2 = new HttpCookie("JSESSIONID", (String)localObject1);
      ((HttpCookie)localObject2).setMaxAge(TimeUnit.DAYS.toSeconds(100L));
      if (paramString != null) {
        ((HttpCookie)localObject2).setDomain(buildDomainName(paramString.getHost()));
      }
      ((HttpCookie)localObject2).setPath("/");
      ((HttpCookie)localObject2).setVersion(0);
      cookieManager().getCookieStore().add(paramString, (HttpCookie)localObject2);
    }
    return (String)localObject1;
  }
  
  public final Map<String, String> getLixOverrideKeyValues(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap();
    paramString = getCookieValue("lror", paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        if (arrayOfString.length == 2) {
          localArrayMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
    return localArrayMap;
  }
  
  public final void removeCookie(URI paramURI, HttpCookie paramHttpCookie)
  {
    if ((paramURI != null) && (paramHttpCookie != null)) {
      cookieManager().getCookieStore().remove(paramURI, paramHttpCookie);
    }
  }
  
  public final void resetLixOverrideCookie(String paramString, Map<String, String> paramMap)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMap == null)) {}
    do
    {
      return;
      if (paramMap.size() != 0) {
        break;
      }
      paramMap = getCookieWithName("lror", paramString);
    } while (paramMap == null);
    cookieManager().getCookieStore().remove(uriForString(paramString), paramMap);
    return;
    HttpCookie localHttpCookie = createHttpCookie(uriForString(paramString), "lror", "", 10);
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      localStringBuilder.append(str + "=" + (String)localObject + "&");
    }
    localHttpCookie.setValue(localStringBuilder.toString());
    cookieManager().getCookieStore().add(uriForString(paramString), localHttpCookie);
  }
  
  public final void setLixOverride(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return;
    }
    Map localMap = getLixOverrideKeyValues(paramString1);
    localMap.put(paramString2, paramString3);
    resetLixOverrideCookie(paramString1, localMap);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.cookies.CookieUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */