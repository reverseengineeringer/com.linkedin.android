package com.google.android.exoplayer.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.exoplayer.upstream.DataSpec;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;

public final class Util
{
  public static final String DEVICE = Build.DEVICE;
  public static final String MANUFACTURER = Build.MANUFACTURER;
  public static final int SDK_INT = Build.VERSION.SDK_INT;
  private static final Pattern XS_DATE_TIME_PATTERN = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)(\\.(\\d+))?([Zz]|((\\+|\\-)(\\d\\d):(\\d\\d)))?");
  private static final Pattern XS_DURATION_PATTERN = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
  
  public static boolean areEqual(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null) {
      return paramObject2 == null;
    }
    return paramObject1.equals(paramObject2);
  }
  
  public static int binarySearchCeil$7476434d(long[] paramArrayOfLong, long paramLong, boolean paramBoolean)
  {
    int j = Arrays.binarySearch(paramArrayOfLong, paramLong);
    int i;
    if (j < 0) {
      i = j ^ 0xFFFFFFFF;
    }
    do
    {
      return i;
      i = j;
    } while (paramBoolean);
    return j + 1;
  }
  
  public static int binarySearchFloor(long[] paramArrayOfLong, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = Arrays.binarySearch(paramArrayOfLong, paramLong);
    int i;
    if (j < 0) {
      i = -(j + 2);
    }
    for (;;)
    {
      j = i;
      if (paramBoolean2) {
        j = Math.max(0, i);
      }
      return j;
      i = j;
      if (!paramBoolean1) {
        i = j - 1;
      }
    }
  }
  
  public static <T> int binarySearchFloor$8efcd4b(List<? extends Comparable<? super T>> paramList, T paramT)
  {
    int j = Collections.binarySearch(paramList, paramT);
    int i = j;
    if (j < 0) {
      i = -(j + 2);
    }
    return Math.max(0, i);
  }
  
  public static int ceilDivide(int paramInt1, int paramInt2)
  {
    return (paramInt1 + paramInt2 - 1) / paramInt2;
  }
  
  public static <T> String getCommaDelimitedSimpleClassNames(T[] paramArrayOfT)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfT.length)
    {
      localStringBuilder.append(paramArrayOfT[i].getClass().getSimpleName());
      if (i < paramArrayOfT.length - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static int getIntegerCodeForString(String paramString)
  {
    int k = paramString.length();
    if (k <= 4) {}
    int j;
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      j = 0;
      int i = 0;
      while (i < k)
      {
        j = j << 8 | paramString.charAt(i);
        i += 1;
      }
    }
    return j;
  }
  
  public static DataSpec getRemainderDataSpec(DataSpec paramDataSpec, int paramInt)
  {
    long l = -1L;
    if (paramInt == 0) {
      return paramDataSpec;
    }
    if (length == -1L) {}
    for (;;)
    {
      return new DataSpec(uri, position + paramInt, l, key, flags);
      l = length - paramInt;
    }
  }
  
  public static String getUserAgent(Context paramContext, String paramString)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = getPackageManagergetPackageInfo0versionName;
      return paramString + "/" + paramContext + " (Linux;Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/1.4.2";
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = "?";
      }
    }
  }
  
  public static void maybeTerminateInputStream(HttpURLConnection paramHttpURLConnection, long paramLong)
  {
    if ((SDK_INT != 19) && (SDK_INT != 20)) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramHttpURLConnection = paramHttpURLConnection.getInputStream();
          if (paramLong != -1L) {
            break label99;
          }
          if (paramHttpURLConnection.read() == -1) {}
        }
        catch (IOException paramHttpURLConnection)
        {
          do
          {
            Object localObject;
            return;
          } while (paramLong > 2048L);
          return;
        }
        catch (Exception paramHttpURLConnection) {}
      }
      localObject = paramHttpURLConnection.getClass().getName();
    } while ((!((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream")) && (!((String)localObject).equals("com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream")));
    localObject = paramHttpURLConnection.getClass().getSuperclass().getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
    ((Method)localObject).setAccessible(true);
    ((Method)localObject).invoke(paramHttpURLConnection, new Object[0]);
    return;
    label99:
  }
  
  public static ExecutorService newSingleThreadExecutor(String paramString)
  {
    Executors.newSingleThreadExecutor(new ThreadFactory()
    {
      public final Thread newThread(Runnable paramAnonymousRunnable)
      {
        return new Thread(paramAnonymousRunnable, val$threadName);
      }
    });
  }
  
  public static long scaleLargeTimestamp(long paramLong1, long paramLong2, long paramLong3)
  {
    if ((paramLong3 >= paramLong2) && (paramLong3 % paramLong2 == 0L)) {
      return paramLong1 / (paramLong3 / paramLong2);
    }
    if ((paramLong3 < paramLong2) && (paramLong2 % paramLong3 == 0L)) {
      return paramLong1 * (paramLong2 / paramLong3);
    }
    double d = paramLong2 / paramLong3;
    return (paramLong1 * d);
  }
  
  public static void scaleLargeTimestampsInPlace$1c88337c(long[] paramArrayOfLong, long paramLong)
  {
    int i;
    if ((paramLong >= 1000000L) && (paramLong % 1000000L == 0L))
    {
      paramLong /= 1000000L;
      i = 0;
    }
    while (i < paramArrayOfLong.length)
    {
      paramArrayOfLong[i] /= paramLong;
      i += 1;
      continue;
      if ((paramLong < 1000000L) && (1000000L % paramLong == 0L))
      {
        paramLong = 1000000L / paramLong;
        i = 0;
      }
      while (i < paramArrayOfLong.length)
      {
        paramArrayOfLong[i] *= paramLong;
        i += 1;
        continue;
        double d = 1000000.0D / paramLong;
        i = 0;
        while (i < paramArrayOfLong.length)
        {
          paramArrayOfLong[i] = ((paramArrayOfLong[i] * d));
          i += 1;
        }
      }
    }
  }
  
  public static int[] toArray(List<Integer> paramList)
  {
    int j = paramList.size();
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = ((Integer)paramList.get(i)).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static String toLowerInvariant(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.toLowerCase(Locale.US);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.Util
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */