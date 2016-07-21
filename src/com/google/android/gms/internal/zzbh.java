package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

@zzhb
public final class zzbh
{
  private final int zztp;
  private final int zztq;
  private final int zztr;
  private final zzbg zzts = new zzbj();
  
  public zzbh(int paramInt)
  {
    zztq = paramInt;
    zztp = 6;
    zztr = 0;
  }
  
  private String zzv(String paramString)
  {
    String[] arrayOfString = paramString.split("\n");
    if (arrayOfString.length == 0) {
      return "";
    }
    paramString = new zza();
    Arrays.sort(arrayOfString, new Comparator() {});
    int i = 0;
    for (;;)
    {
      if ((i < arrayOfString.length) && (i < zztq))
      {
        if (arrayOfString[i].trim().length() != 0) {}
        try
        {
          paramString.write(zzts.zzu(arrayOfString[i]));
          i += 1;
        }
        catch (IOException localIOException)
        {
          zzin.zzb("Error while writing hash to byteStream", localIOException);
        }
      }
    }
    return paramString.toString();
  }
  
  private String zzw(String paramString)
  {
    Object localObject1 = paramString.split("\n");
    if (localObject1.length == 0) {
      return "";
    }
    paramString = new zza();
    Object localObject2 = new PriorityQueue(zztq, new Comparator() {});
    int i = 0;
    while (i < localObject1.length)
    {
      String[] arrayOfString = zzbi.zzy(localObject1[i]);
      if (arrayOfString.length != 0) {
        zzbk.zza(arrayOfString, zztq, zztp, (PriorityQueue)localObject2);
      }
      i += 1;
    }
    localObject1 = ((PriorityQueue)localObject2).iterator();
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (zzbk.zza)((Iterator)localObject1).next();
        try
        {
          paramString.write(zzts.zzu(zztx));
        }
        catch (IOException localIOException)
        {
          zzin.zzb("Error while writing hash to byteStream", localIOException);
        }
      }
    }
    return paramString.toString();
  }
  
  public final String zza(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localStringBuffer.append(((String)paramArrayList.next()).toLowerCase(Locale.US));
      localStringBuffer.append('\n');
    }
    switch (zztr)
    {
    default: 
      return "";
    case 0: 
      return zzw(localStringBuffer.toString());
    }
    return zzv(localStringBuffer.toString());
  }
  
  static final class zza
  {
    ByteArrayOutputStream zztu = new ByteArrayOutputStream(4096);
    Base64OutputStream zztv = new Base64OutputStream(zztu, 10);
    
    public final String toString()
    {
      try
      {
        zztv.close();
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          try
          {
            zztu.close();
            String str = zztu.toString();
            return str;
          }
          catch (IOException localIOException2)
          {
            zzin.zzb("HashManager: Unable to convert to Base64.", localIOException2);
            return "";
          }
          finally
          {
            zztu = null;
            zztv = null;
          }
          localIOException1 = localIOException1;
          zzin.zzb("HashManager: Unable to convert to Base64.", localIOException1);
        }
      }
    }
    
    public final void write(byte[] paramArrayOfByte)
      throws IOException
    {
      zztv.write(paramArrayOfByte);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */