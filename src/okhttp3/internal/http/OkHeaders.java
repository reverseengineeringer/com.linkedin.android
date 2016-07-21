package okhttp3.internal.http;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Platform;
import okhttp3.internal.Util;

public final class OkHeaders
{
  static final String PREFIX;
  public static final String RECEIVED_MILLIS;
  public static final String RESPONSE_SOURCE = PREFIX + "-Response-Source";
  public static final String SELECTED_PROTOCOL;
  public static final String SENT_MILLIS;
  
  static
  {
    Platform.get();
    PREFIX = Platform.getPrefix();
    SENT_MILLIS = PREFIX + "-Sent-Millis";
    RECEIVED_MILLIS = PREFIX + "-Received-Millis";
    SELECTED_PROTOCOL = PREFIX + "-Selected-Protocol";
  }
  
  public static long contentLength(Headers paramHeaders)
  {
    return stringToLong(paramHeaders.get("Content-Length"));
  }
  
  public static long contentLength(Request paramRequest)
  {
    return contentLength(headers);
  }
  
  public static long contentLength(Response paramResponse)
  {
    return contentLength(headers);
  }
  
  public static boolean hasVaryAll(Response paramResponse)
  {
    return varyFields(headers).contains("*");
  }
  
  static boolean isEndToEnd(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }
  
  private static long stringToLong(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
  
  private static Set<String> varyFields(Headers paramHeaders)
  {
    Object localObject2 = Collections.emptySet();
    int i = 0;
    int k = namesAndValues.length / 2;
    while (i < k)
    {
      Object localObject3 = localObject2;
      if ("Vary".equalsIgnoreCase(paramHeaders.name(i)))
      {
        localObject3 = paramHeaders.value(i);
        Object localObject1 = localObject2;
        if (((Set)localObject2).isEmpty()) {
          localObject1 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        }
        localObject2 = ((String)localObject3).split(",");
        int m = localObject2.length;
        int j = 0;
        for (;;)
        {
          localObject3 = localObject1;
          if (j >= m) {
            break;
          }
          ((Set)localObject1).add(localObject2[j].trim());
          j += 1;
        }
      }
      i += 1;
      localObject2 = localObject3;
    }
    return (Set<String>)localObject2;
  }
  
  public static Headers varyHeaders(Response paramResponse)
  {
    Headers localHeaders = networkResponse.request.headers;
    paramResponse = varyFields(headers);
    if (paramResponse.isEmpty()) {
      return new Headers.Builder().build();
    }
    Headers.Builder localBuilder = new Headers.Builder();
    int i = 0;
    int j = namesAndValues.length / 2;
    while (i < j)
    {
      String str = localHeaders.name(i);
      if (paramResponse.contains(str)) {
        localBuilder.add(str, localHeaders.value(i));
      }
      i += 1;
    }
    return localBuilder.build();
  }
  
  public static boolean varyMatches(Response paramResponse, Headers paramHeaders, Request paramRequest)
  {
    paramResponse = varyFields(headers).iterator();
    while (paramResponse.hasNext())
    {
      String str = (String)paramResponse.next();
      if (!Util.equal(paramHeaders.values(str), headers.values(str))) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     okhttp3.internal.http.OkHeaders
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */