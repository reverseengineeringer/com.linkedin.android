package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zznj
{
  private static final Method zzaol = ;
  private static final Method zzaom = zzsq();
  private static final Method zzaon = zzsr();
  private static final Method zzaoo = zzss();
  private static final Method zzaop = zzst();
  
  private static int zza(WorkSource paramWorkSource)
  {
    if (zzaon != null) {
      try
      {
        int i = ((Integer)zzaon.invoke(paramWorkSource, new Object[0])).intValue();
        return i;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    return 0;
  }
  
  private static String zza(WorkSource paramWorkSource, int paramInt)
  {
    if (zzaop != null) {
      try
      {
        paramWorkSource = (String)zzaop.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        return paramWorkSource;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    return null;
  }
  
  public static boolean zzaA(Context paramContext)
  {
    if (paramContext == null) {}
    PackageManager localPackageManager;
    do
    {
      return false;
      localPackageManager = paramContext.getPackageManager();
    } while ((localPackageManager == null) || (localPackageManager.checkPermission("android.permission.UPDATE_DEVICE_STATS", paramContext.getPackageName()) != 0));
    return true;
  }
  
  public static List<String> zzb(WorkSource paramWorkSource)
  {
    int j = 0;
    if (paramWorkSource == null) {}
    Object localObject;
    for (int i = 0; i == 0; i = zza(paramWorkSource))
    {
      localObject = Collections.EMPTY_LIST;
      return (List<String>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      localObject = localArrayList;
      if (j >= i) {
        break;
      }
      localObject = zza(paramWorkSource, j);
      if (!zzni.zzcV((String)localObject)) {
        localArrayList.add(localObject);
      }
      j += 1;
    }
  }
  
  private static WorkSource zzf(int paramInt, String paramString)
  {
    WorkSource localWorkSource = new WorkSource();
    if (zzaom != null)
    {
      str = paramString;
      if (paramString == null) {
        str = "";
      }
    }
    while (zzaol == null) {
      try
      {
        String str;
        zzaom.invoke(localWorkSource, new Object[] { Integer.valueOf(paramInt), str });
        return localWorkSource;
      }
      catch (Exception paramString)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramString);
        return localWorkSource;
      }
    }
    try
    {
      zzaol.invoke(localWorkSource, new Object[] { Integer.valueOf(paramInt) });
      return localWorkSource;
    }
    catch (Exception paramString)
    {
      Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramString);
    }
    return localWorkSource;
  }
  
  public static WorkSource zzl(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramContext.getPackageManager() == null)) {
      return null;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramString, 0);
      if (paramContext == null)
      {
        Log.e("WorkSourceUtil", "Could not get applicationInfo from package: " + paramString);
        return null;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.e("WorkSourceUtil", "Could not find package: " + paramString);
      return null;
    }
    return zzf(uid, paramString);
  }
  
  private static Method zzsp()
  {
    try
    {
      Method localMethod = WorkSource.class.getMethod("add", new Class[] { Integer.TYPE });
      return localMethod;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static Method zzsq()
  {
    Method localMethod = null;
    if (zzne.zzcp(18)) {}
    try
    {
      localMethod = WorkSource.class.getMethod("add", new Class[] { Integer.TYPE, String.class });
      return localMethod;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static Method zzsr()
  {
    try
    {
      Method localMethod = WorkSource.class.getMethod("size", new Class[0]);
      return localMethod;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static Method zzss()
  {
    try
    {
      Method localMethod = WorkSource.class.getMethod("get", new Class[] { Integer.TYPE });
      return localMethod;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static Method zzst()
  {
    Method localMethod = null;
    if (zzne.zzcp(18)) {}
    try
    {
      localMethod = WorkSource.class.getMethod("getName", new Class[] { Integer.TYPE });
      return localMethod;
    }
    catch (Exception localException) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zznj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */