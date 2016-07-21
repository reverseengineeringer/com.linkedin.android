package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzv$zza
{
  public String key;
  public long zzaB;
  public String zzb;
  public long zzc;
  public long zzd;
  public long zze;
  public long zzf;
  public Map<String, String> zzg;
  
  private zzv$zza() {}
  
  public zzv$zza(String paramString, zzb.zza paramzza)
  {
    key = paramString;
    zzaB = data.length;
    zzb = zzb;
    zzc = zzc;
    zzd = zzd;
    zze = zze;
    zzf = zzf;
    zzg = zzg;
  }
  
  public static zza zzf(InputStream paramInputStream)
    throws IOException
  {
    zza localzza = new zza();
    if (zzv.zzb(paramInputStream) != 538247942) {
      throw new IOException();
    }
    key = zzv.zzd(paramInputStream);
    zzb = zzv.zzd(paramInputStream);
    if (zzb.equals("")) {
      zzb = null;
    }
    zzc = zzv.zzc(paramInputStream);
    zzd = zzv.zzc(paramInputStream);
    zze = zzv.zzc(paramInputStream);
    zzf = zzv.zzc(paramInputStream);
    zzg = zzv.zze(paramInputStream);
    return localzza;
  }
  
  public final boolean zza(OutputStream paramOutputStream)
  {
    for (;;)
    {
      try
      {
        zzv.zza(paramOutputStream, 538247942);
        zzv.zza(paramOutputStream, key);
        if (zzb == null)
        {
          localObject = "";
          zzv.zza(paramOutputStream, (String)localObject);
          zzv.zza(paramOutputStream, zzc);
          zzv.zza(paramOutputStream, zzd);
          zzv.zza(paramOutputStream, zze);
          zzv.zza(paramOutputStream, zzf);
          localObject = zzg;
          if (localObject == null) {
            break;
          }
          zzv.zza(paramOutputStream, ((Map)localObject).size());
          localObject = ((Map)localObject).entrySet().iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label172;
          }
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          zzv.zza(paramOutputStream, (String)localEntry.getKey());
          zzv.zza(paramOutputStream, (String)localEntry.getValue());
          continue;
        }
        Object localObject = zzb;
      }
      catch (IOException paramOutputStream)
      {
        zzs.zzb("%s", new Object[] { paramOutputStream.toString() });
        return false;
      }
    }
    zzv.zza(paramOutputStream, 0);
    label172:
    paramOutputStream.flush();
    return true;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzv.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */