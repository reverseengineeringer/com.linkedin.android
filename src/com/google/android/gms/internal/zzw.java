package com.google.android.gms.internal;

import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.params.HttpConnectionParams;

public final class zzw
  implements zzy
{
  protected final HttpClient zzaD;
  
  public zzw(HttpClient paramHttpClient)
  {
    zzaD = paramHttpClient;
  }
  
  private static void zza(HttpUriRequest paramHttpUriRequest, Map<String, String> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramHttpUriRequest.setHeader(str, (String)paramMap.get(str));
    }
  }
  
  public final HttpResponse zza(zzk<?> paramzzk, Map<String, String> paramMap)
    throws IOException, zza
  {
    Object localObject;
    switch (zzE)
    {
    default: 
      throw new IllegalStateException("Unknown request method.");
    case -1: 
      localObject = new HttpGet(zzF);
    }
    for (;;)
    {
      zza((HttpUriRequest)localObject, paramMap);
      zza((HttpUriRequest)localObject, paramzzk.getHeaders());
      paramMap = ((HttpUriRequest)localObject).getParams();
      int i = paramzzk.zzt();
      HttpConnectionParams.setConnectionTimeout(paramMap, 5000);
      HttpConnectionParams.setSoTimeout(paramMap, i);
      return zzaD.execute((HttpUriRequest)localObject);
      localObject = new HttpGet(zzF);
      continue;
      localObject = new HttpDelete(zzF);
      continue;
      localObject = new HttpPost(zzF);
      ((HttpPost)localObject).addHeader("Content-Type", zzk.zzp());
      continue;
      localObject = new HttpPut(zzF);
      ((HttpPut)localObject).addHeader("Content-Type", zzk.zzp());
      continue;
      localObject = new HttpHead(zzF);
      continue;
      localObject = new HttpOptions(zzF);
      continue;
      localObject = new HttpTrace(zzF);
      continue;
      localObject = new zza(zzF);
      ((zza)localObject).addHeader("Content-Type", zzk.zzp());
    }
  }
  
  public static final class zza
    extends HttpEntityEnclosingRequestBase
  {
    public zza() {}
    
    public zza(String paramString)
    {
      setURI(URI.create(paramString));
    }
    
    public final String getMethod()
    {
      return "PATCH";
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */