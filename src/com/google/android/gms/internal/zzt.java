package com.google.android.gms.internal;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

public final class zzt
  implements zzf
{
  protected static final boolean DEBUG = zzs.DEBUG;
  private static int zzao = 3000;
  private static int zzap = 4096;
  protected final zzy zzaq;
  protected final zzu zzar;
  
  public zzt(zzy paramzzy)
  {
    this(paramzzy, new zzu(zzap));
  }
  
  private zzt(zzy paramzzy, zzu paramzzu)
  {
    zzaq = paramzzy;
    zzar = paramzzu;
  }
  
  private static Map<String, String> zza(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    int i = 0;
    while (i < paramArrayOfHeader.length)
    {
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
      i += 1;
    }
    return localTreeMap;
  }
  
  private static void zza(String paramString, zzk<?> paramzzk, zzr paramzzr)
    throws zzr
  {
    zzo localzzo = zzO;
    int i = paramzzk.zzt();
    try
    {
      localzzo.zza(paramzzr);
      paramzzk.zzc(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    }
    catch (zzr paramzzr)
    {
      paramzzk.zzc(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw paramzzr;
    }
  }
  
  private byte[] zza(HttpEntity paramHttpEntity)
    throws IOException, zzp
  {
    zzaa localzzaa = new zzaa(zzar, (int)paramHttpEntity.getContentLength());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject4;
    try
    {
      localObject4 = paramHttpEntity.getContent();
      if (localObject4 == null)
      {
        localObject1 = localObject2;
        throw new zzp();
      }
    }
    finally {}
    try
    {
      paramHttpEntity.consumeContent();
      zzar.zza((byte[])localObject1);
      localzzaa.close();
      throw ((Throwable)localObject3);
      localObject1 = localObject3;
      byte[] arrayOfByte = zzar.zzb(1024);
      for (;;)
      {
        localObject1 = arrayOfByte;
        int i = ((InputStream)localObject4).read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localObject1 = arrayOfByte;
        localzzaa.write(arrayOfByte, 0, i);
      }
      localObject1 = arrayOfByte;
      localObject4 = localzzaa.toByteArray();
      try
      {
        paramHttpEntity.consumeContent();
        zzar.zza(arrayOfByte);
        localzzaa.close();
        return (byte[])localObject4;
      }
      catch (IOException paramHttpEntity)
      {
        for (;;)
        {
          zzs.zza("Error occured when calling consumingContent", new Object[0]);
        }
      }
    }
    catch (IOException paramHttpEntity)
    {
      for (;;)
      {
        zzs.zza("Error occured when calling consumingContent", new Object[0]);
      }
    }
  }
  
  public final zzi zza(zzk<?> paramzzk)
    throws zzr
  {
    long l1 = SystemClock.elapsedRealtime();
    for (;;)
    {
      Map localMap = null;
      localObject6 = Collections.emptyMap();
      try
      {
        Object localObject1 = new HashMap();
        Object localObject4 = zzP;
        if (localObject4 != null)
        {
          if (zzb != null) {
            ((Map)localObject1).put("If-None-Match", zzb);
          }
          if (zzd > 0L) {
            ((Map)localObject1).put("If-Modified-Since", DateUtils.formatDate(new Date(zzd)));
          }
        }
        localObject4 = zzaq.zza(paramzzk, (Map)localObject1);
        localObject1 = localObject6;
        for (;;)
        {
          int i;
          Object localObject3;
          Object localObject5;
          try
          {
            localStatusLine = ((HttpResponse)localObject4).getStatusLine();
            localObject1 = localObject6;
            i = localStatusLine.getStatusCode();
            localObject1 = localObject6;
            localMap = zza(((HttpResponse)localObject4).getAllHeaders());
            if (i == 304)
            {
              localObject1 = localMap;
              localObject6 = zzP;
              if (localObject6 == null)
              {
                localObject1 = localMap;
                return new zzi(304, null, localMap, true, SystemClock.elapsedRealtime() - l1);
              }
              localObject1 = localMap;
              zzg.putAll(localMap);
              localObject1 = localMap;
              return new zzi(304, data, zzg, true, SystemClock.elapsedRealtime() - l1);
            }
            localObject1 = localMap;
            if (((HttpResponse)localObject4).getEntity() != null)
            {
              localObject1 = localMap;
              localObject6 = zza(((HttpResponse)localObject4).getEntity());
              localObject1 = localObject6;
            }
          }
          catch (IOException localIOException3)
          {
            long l2;
            Object localObject2;
            StatusLine localStatusLine = null;
            localObject6 = localIOException1;
            localObject5 = localIOException3;
            continue;
          }
          try
          {
            l2 = SystemClock.elapsedRealtime() - l1;
            if ((!DEBUG) && (l2 <= zzao)) {
              break label671;
            }
            if (localObject1 == null) {
              continue;
            }
            localObject6 = Integer.valueOf(localObject1.length);
            zzs.zzb("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramzzk, Long.valueOf(l2), localObject6, Integer.valueOf(localStatusLine.getStatusCode()), Integer.valueOf(zzO.zze()) });
          }
          catch (IOException localIOException2)
          {
            localObject6 = localObject5;
            localObject5 = localIOException2;
            Object localObject7 = localObject3;
            localObject3 = localIOException3;
            continue;
            if (i < 200) {
              continue;
            }
            if (i <= 299) {
              continue;
            }
          }
        }
        throw new IOException();
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        for (;;)
        {
          zza("socket", paramzzk, new zzq());
          break;
          localObject2 = localMap;
          localObject6 = new byte[0];
          localObject2 = localObject6;
          continue;
          localObject6 = "null";
        }
        localObject6 = new zzi(i, (byte[])localObject2, localMap, false, SystemClock.elapsedRealtime() - l1);
        return (zzi)localObject6;
      }
      catch (ConnectTimeoutException localConnectTimeoutException)
      {
        zza("connection", paramzzk, new zzq());
      }
      catch (MalformedURLException localMalformedURLException)
      {
        throw new RuntimeException("Bad URL " + zzF, localMalformedURLException);
      }
      catch (IOException localIOException1)
      {
        localStatusLine = null;
        localObject3 = localObject6;
        localObject6 = localMap;
        if (localObject6 != null)
        {
          i = ((HttpResponse)localObject6).getStatusLine().getStatusCode();
          zzs.zzc("Unexpected response code %d for %s", new Object[] { Integer.valueOf(i), zzF });
          if (localStatusLine == null) {
            break label625;
          }
          localObject3 = new zzi(i, localStatusLine, (Map)localObject3, false, SystemClock.elapsedRealtime() - l1);
          if ((i == 401) || (i == 403)) {
            zza("auth", paramzzk, new zza((zzi)localObject3));
          }
        }
        else
        {
          throw new zzj(localIOException1);
        }
      }
    }
    throw new zzp((zzi)localObject3);
    label625:
    throw new zzh((byte)0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */