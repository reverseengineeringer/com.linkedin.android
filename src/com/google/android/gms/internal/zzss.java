package com.google.android.gms.internal;

import java.util.Arrays;

public final class zzss
{
  public static final Object zzbut = new Object();
  
  public static boolean equals(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if ((paramArrayOfLong1 == null) || (paramArrayOfLong1.length == 0)) {
      return (paramArrayOfLong2 == null) || (paramArrayOfLong2.length == 0);
    }
    return Arrays.equals(paramArrayOfLong1, paramArrayOfLong2);
  }
  
  public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    boolean bool2 = false;
    int k;
    if (paramArrayOfObject1 == null)
    {
      k = 0;
      if (paramArrayOfObject2 != null) {
        break label47;
      }
    }
    int j;
    int i;
    label47:
    for (int m = 0;; m = paramArrayOfObject2.length)
    {
      j = 0;
      i = 0;
      while ((i < k) && (paramArrayOfObject1[i] == null)) {
        i += 1;
      }
      k = paramArrayOfObject1.length;
      break;
    }
    for (;;)
    {
      if ((j < m) && (paramArrayOfObject2[j] == null))
      {
        j += 1;
      }
      else
      {
        int n;
        int i1;
        label91:
        boolean bool1;
        if (i >= k)
        {
          n = 1;
          if (j < m) {
            break label113;
          }
          i1 = 1;
          if ((n == 0) || (i1 == 0)) {
            break label119;
          }
          bool1 = true;
        }
        label113:
        label119:
        do
        {
          do
          {
            return bool1;
            n = 0;
            break;
            i1 = 0;
            break label91;
            bool1 = bool2;
          } while (n != i1);
          bool1 = bool2;
        } while (!paramArrayOfObject1[i].equals(paramArrayOfObject2[j]));
        j += 1;
        i += 1;
        break;
      }
    }
  }
  
  public static int hashCode(long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {
      return 0;
    }
    return Arrays.hashCode(paramArrayOfLong);
  }
  
  public static int hashCode(Object[] paramArrayOfObject)
  {
    int k = 0;
    if (paramArrayOfObject == null) {}
    for (int i = 0;; i = paramArrayOfObject.length)
    {
      int j = 0;
      while (j < i)
      {
        Object localObject = paramArrayOfObject[j];
        int m = k;
        if (localObject != null) {
          m = k * 31 + localObject.hashCode();
        }
        j += 1;
        k = m;
      }
    }
    return k;
  }
  
  public static void zza(zzso paramzzso1, zzso paramzzso2)
  {
    if (zzbuj != null) {
      zzbuj = zzbuj.zzJq();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzss
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */