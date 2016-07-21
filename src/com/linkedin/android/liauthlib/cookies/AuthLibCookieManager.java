package com.linkedin.android.liauthlib.cookies;

import android.util.Pair;
import android.webkit.CookieManager;
import java.util.List;
import java.util.Set;

public abstract interface AuthLibCookieManager
{
  public abstract boolean addCookie(String paramString);
  
  public abstract void addCookiesToCookieManager(CookieManager paramCookieManager);
  
  public abstract void clearAuthCookies();
  
  public abstract String getCookie(String paramString1, String paramString2);
  
  public abstract List<Pair<String, String>> getCookieNameValuePairs(Set<String> paramSet);
  
  public abstract List<String> getCookies();
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.cookies.AuthLibCookieManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */