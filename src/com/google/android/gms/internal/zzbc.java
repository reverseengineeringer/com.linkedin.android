package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;

@zzhb
public final class zzbc
{
  final Object zzpV = new Object();
  private final int zzsK;
  private final int zzsL;
  private final int zzsM;
  private final zzbh zzsN;
  private ArrayList<String> zzsO = new ArrayList();
  private ArrayList<String> zzsP = new ArrayList();
  int zzsQ = 0;
  int zzsR = 0;
  int zzsS = 0;
  private int zzsT;
  String zzsU = "";
  private String zzsV = "";
  
  public zzbc(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    zzsK = paramInt1;
    zzsL = paramInt2;
    zzsM = paramInt3;
    zzsN = new zzbh(paramInt4);
  }
  
  private static String zza$19d919ee(ArrayList<String> paramArrayList)
  {
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    Object localObject;
    do
    {
      return paramArrayList;
      localObject = new StringBuffer();
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        ((StringBuffer)localObject).append((String)paramArrayList.next());
        ((StringBuffer)localObject).append(' ');
      } while (((StringBuffer)localObject).length() <= 100);
      ((StringBuffer)localObject).deleteCharAt(((StringBuffer)localObject).length() - 1);
      localObject = ((StringBuffer)localObject).toString();
      paramArrayList = (ArrayList<String>)localObject;
    } while (((String)localObject).length() < 100);
    return ((String)localObject).substring(0, 100);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzbc)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (zzbc)paramObject;
    } while ((zzsU == null) || (!zzsU.equals(zzsU)));
    return true;
  }
  
  public final int hashCode()
  {
    return zzsU.hashCode();
  }
  
  public final String toString()
  {
    return "ActivityContent fetchId: " + zzsR + " score:" + zzsT + " total_length:" + zzsQ + "\n text: " + zza$19d919ee(zzsO) + "\n viewableText" + zza$19d919ee(zzsP) + "\n signture: " + zzsU + "\n viewableSignture: " + zzsV;
  }
  
  public final void zzc(String arg1, boolean paramBoolean)
  {
    zze(???, paramBoolean);
    synchronized (zzpV)
    {
      if (zzsS < 0) {
        zzin.zzaI("ActivityContent: negative number of WebViews.");
      }
      zzcD();
      return;
    }
  }
  
  public final void zzcC()
  {
    synchronized (zzpV)
    {
      zzsS += 1;
      return;
    }
  }
  
  public final void zzcD()
  {
    synchronized (zzpV)
    {
      int i = zzsQ;
      int j = zzsR;
      i = i * zzsK + j * zzsL;
      if (i > zzsT)
      {
        zzsT = i;
        zzsU = zzsN.zza(zzsO);
        zzsV = zzsN.zza(zzsP);
      }
      return;
    }
  }
  
  public final boolean zzcx()
  {
    for (;;)
    {
      synchronized (zzpV)
      {
        if (zzsS == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  final void zze(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() < zzsM)) {
      return;
    }
    synchronized (zzpV)
    {
      zzsO.add(paramString);
      zzsQ += paramString.length();
      if (paramBoolean) {
        zzsP.add(paramString);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */