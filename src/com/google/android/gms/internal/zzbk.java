package com.google.android.gms.internal;

import java.util.PriorityQueue;

@zzhb
public final class zzbk
{
  private static long zza(long paramLong, int paramInt)
  {
    long l;
    if (paramInt == 0) {
      l = 1L;
    }
    do
    {
      return l;
      l = paramLong;
    } while (paramInt == 1);
    if (paramInt % 2 == 0) {
      return zza(paramLong * paramLong % 1073807359L, paramInt / 2) % 1073807359L;
    }
    return zza(paramLong * paramLong % 1073807359L, paramInt / 2) % 1073807359L * paramLong % 1073807359L;
  }
  
  private static String zza(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if (paramArrayOfString.length < paramInt1 + paramInt2)
    {
      zzin.e("Unable to construct shingle");
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramInt1;
    while (i < paramInt1 + paramInt2 - 1)
    {
      localStringBuffer.append(paramArrayOfString[i]);
      localStringBuffer.append(' ');
      i += 1;
    }
    localStringBuffer.append(paramArrayOfString[(paramInt1 + paramInt2 - 1)]);
    return localStringBuffer.toString();
  }
  
  private static void zza(int paramInt1, long paramLong, String paramString, int paramInt2, PriorityQueue<zza> paramPriorityQueue)
  {
    paramString = new zza(paramLong, paramString, paramInt2);
    if ((paramPriorityQueue.size() == paramInt1) && (peekvalue > value)) {}
    do
    {
      do
      {
        return;
      } while (paramPriorityQueue.contains(paramString));
      paramPriorityQueue.add(paramString);
    } while (paramPriorityQueue.size() <= paramInt1);
    paramPriorityQueue.poll();
  }
  
  public static void zza(String[] paramArrayOfString, int paramInt1, int paramInt2, PriorityQueue<zza> paramPriorityQueue)
  {
    if (paramArrayOfString.length < paramInt2) {
      zza(paramInt1, zzb$6cdd695e(paramArrayOfString, paramArrayOfString.length), zza(paramArrayOfString, 0, paramArrayOfString.length), paramArrayOfString.length, paramPriorityQueue);
    }
    for (;;)
    {
      return;
      long l1 = zzb$6cdd695e(paramArrayOfString, paramInt2);
      zza(paramInt1, l1, zza(paramArrayOfString, 0, paramInt2), paramInt2, paramPriorityQueue);
      long l2 = zza(16785407L, paramInt2 - 1);
      int i = 1;
      while (i < paramArrayOfString.length - paramInt2 + 1)
      {
        int j = zzbi.zzx(paramArrayOfString[(i - 1)]);
        int k = zzbi.zzx(paramArrayOfString[(i + paramInt2 - 1)]);
        l1 = ((l1 + 1073807359L - (j + 2147483647L) % 1073807359L * l2 % 1073807359L) % 1073807359L * 16785407L % 1073807359L + (k + 2147483647L) % 1073807359L) % 1073807359L;
        zza(paramInt1, l1, zza(paramArrayOfString, i, paramInt2), paramArrayOfString.length, paramPriorityQueue);
        i += 1;
      }
    }
  }
  
  private static long zzb$6cdd695e(String[] paramArrayOfString, int paramInt)
  {
    long l = (zzbi.zzx(paramArrayOfString[0]) + 2147483647L) % 1073807359L;
    int i = 1;
    while (i < paramInt + 0)
    {
      l = (l * 16785407L % 1073807359L + (zzbi.zzx(paramArrayOfString[i]) + 2147483647L) % 1073807359L) % 1073807359L;
      i += 1;
    }
    return l;
  }
  
  public static final class zza
  {
    final long value;
    final String zztx;
    final int zzty;
    
    zza(long paramLong, String paramString, int paramInt)
    {
      value = paramLong;
      zztx = paramString;
      zzty = paramInt;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof zza))) {
        return false;
      }
      return (value == value) && (zzty == zzty);
    }
    
    public final int hashCode()
    {
      return (int)value;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */