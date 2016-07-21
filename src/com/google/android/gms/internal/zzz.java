package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public final class zzz
  implements zzy
{
  private final zza zzaE = null;
  private final SSLSocketFactory zzaF = null;
  
  public zzz()
  {
    this((byte)0);
  }
  
  private zzz(byte paramByte)
  {
    this('\000');
  }
  
  private zzz(char paramChar) {}
  
  private static HttpEntity zza(HttpURLConnection paramHttpURLConnection)
  {
    BasicHttpEntity localBasicHttpEntity = new BasicHttpEntity();
    try
    {
      InputStream localInputStream1 = paramHttpURLConnection.getInputStream();
      localBasicHttpEntity.setContent(localInputStream1);
      localBasicHttpEntity.setContentLength(paramHttpURLConnection.getContentLength());
      localBasicHttpEntity.setContentEncoding(paramHttpURLConnection.getContentEncoding());
      localBasicHttpEntity.setContentType(paramHttpURLConnection.getContentType());
      return localBasicHttpEntity;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        InputStream localInputStream2 = paramHttpURLConnection.getErrorStream();
      }
    }
  }
  
  public final HttpResponse zza(zzk<?> paramzzk, Map<String, String> paramMap)
    throws IOException, zza
  {
    Object localObject = zzF;
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramzzk.getHeaders());
    localHashMap.putAll(paramMap);
    String str;
    if (zzaE != null)
    {
      str = zzaE.zzh$16915f7f();
      paramMap = str;
      if (str == null) {
        throw new IOException("URL blocked by rewriter: " + (String)localObject);
      }
    }
    else
    {
      paramMap = (Map<String, String>)localObject;
    }
    localObject = new URL(paramMap);
    paramMap = (HttpURLConnection)((URL)localObject).openConnection();
    int i = paramzzk.zzt();
    paramMap.setConnectTimeout(i);
    paramMap.setReadTimeout(i);
    paramMap.setUseCaches(false);
    paramMap.setDoInput(true);
    if (("https".equals(((URL)localObject).getProtocol())) && (zzaF != null)) {
      ((HttpsURLConnection)paramMap).setSSLSocketFactory(zzaF);
    }
    localObject = localHashMap.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      str = (String)((Iterator)localObject).next();
      paramMap.addRequestProperty(str, (String)localHashMap.get(str));
    }
    switch (zzE)
    {
    default: 
      throw new IllegalStateException("Unknown method type.");
    case 0: 
      paramMap.setRequestMethod("GET");
    }
    for (;;)
    {
      paramzzk = new ProtocolVersion("HTTP", 1, 1);
      if (paramMap.getResponseCode() != -1) {
        break;
      }
      throw new IOException("Could not retrieve response code from HttpUrlConnection.");
      paramMap.setRequestMethod("DELETE");
      continue;
      paramMap.setRequestMethod("POST");
      continue;
      paramMap.setRequestMethod("PUT");
      continue;
      paramMap.setRequestMethod("HEAD");
      continue;
      paramMap.setRequestMethod("OPTIONS");
      continue;
      paramMap.setRequestMethod("TRACE");
      continue;
      paramMap.setRequestMethod("PATCH");
    }
    paramzzk = new BasicHttpResponse(new BasicStatusLine(paramzzk, paramMap.getResponseCode(), paramMap.getResponseMessage()));
    paramzzk.setEntity(zza(paramMap));
    paramMap = paramMap.getHeaderFields().entrySet().iterator();
    while (paramMap.hasNext())
    {
      localObject = (Map.Entry)paramMap.next();
      if (((Map.Entry)localObject).getKey() != null) {
        paramzzk.addHeader(new BasicHeader((String)((Map.Entry)localObject).getKey(), (String)((List)((Map.Entry)localObject).getValue()).get(0)));
      }
    }
    return paramzzk;
  }
  
  public static abstract interface zza
  {
    public abstract String zzh$16915f7f();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */