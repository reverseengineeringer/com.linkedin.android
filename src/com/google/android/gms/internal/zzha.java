package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzr;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@zzhb
public final class zzha
  implements Thread.UncaughtExceptionHandler
{
  private Context mContext;
  private VersionInfoParcel zzEZ;
  private Thread.UncaughtExceptionHandler zzHe = null;
  private Thread.UncaughtExceptionHandler zzHf = null;
  
  public zzha(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    mContext = paramContext;
    zzEZ = paramVersionInfoParcel;
  }
  
  private static boolean zzat(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramString.startsWith("com.google.android.gms.ads")) {
      return true;
    }
    if (paramString.startsWith("com.google.ads")) {
      return true;
    }
    try
    {
      boolean bool = Class.forName(paramString).isAnnotationPresent(zzhb.class);
      return bool;
    }
    catch (Exception localException)
    {
      zzin.zza("Fail to check class type for class " + paramString, localException);
    }
    return false;
  }
  
  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    int i;
    if (paramThrowable != null)
    {
      int j = 0;
      int k = 0;
      for (Throwable localThrowable = paramThrowable; localThrowable != null; localThrowable = localThrowable.getCause())
      {
        StackTraceElement[] arrayOfStackTraceElement = localThrowable.getStackTrace();
        int m = arrayOfStackTraceElement.length;
        i = 0;
        while (i < m)
        {
          StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
          if (zzat(localStackTraceElement.getClassName())) {
            k = 1;
          }
          if (getClass().getName().equals(localStackTraceElement.getClassName())) {
            j = 1;
          }
          i += 1;
        }
      }
      if ((k != 0) && (j == 0))
      {
        i = 1;
        if (i == 0) {
          break label140;
        }
        if (Looper.getMainLooper().getThread() == paramThread) {
          break label134;
        }
        zza(paramThrowable, true);
      }
    }
    label134:
    label140:
    do
    {
      return;
      i = 0;
      break;
      zza(paramThrowable, false);
      if (zzHe != null)
      {
        zzHe.uncaughtException(paramThread, paramThrowable);
        return;
      }
    } while (zzHf == null);
    zzHf.uncaughtException(paramThread, paramThrowable);
  }
  
  public final void zza(Throwable paramThrowable, boolean paramBoolean)
  {
    Object localObject1 = zzbt.zzvG;
    if (!((Boolean)zzr.zzbL().zzd((zzbp)localObject1)).booleanValue()) {}
    Object localObject3;
    do
    {
      return;
      while (localObject2 == null)
      {
        localObject1 = zzbt.zzvH;
        if (!((Boolean)zzr.zzbL().zzd((zzbp)localObject1)).booleanValue()) {
          break;
        }
        localObject2 = paramThrowable;
      }
      paramThrowable = paramThrowable.getClass();
      localObject1 = new ArrayList();
      localObject3 = new StringWriter();
      ((Throwable)localObject2).printStackTrace(new PrintWriter((Writer)localObject3));
      localObject2 = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
      zzr.zzbC();
      ((ArrayList)localObject1).add(((Uri.Builder)localObject2).appendQueryParameter("device", zzir.zzht()).appendQueryParameter("js", zzEZ.afmaVersion).appendQueryParameter("appid", mContext.getApplicationContext().getPackageName()).appendQueryParameter("exceptiontype", paramThrowable.getName()).appendQueryParameter("stacktrace", ((StringWriter)localObject3).toString()).appendQueryParameter("eids", TextUtils.join(",", zzbt.zzdr())).appendQueryParameter("trapped", String.valueOf(paramBoolean)).toString());
      zzr.zzbC();
      zzir.zza(mContext, zzEZ.afmaVersion, (List)localObject1, zzr.zzbF().zzhe());
      return;
      localObject3 = new LinkedList();
      for (localObject1 = paramThrowable; localObject1 != null; localObject1 = ((Throwable)localObject1).getCause()) {
        ((LinkedList)localObject3).push(localObject1);
      }
      localObject1 = null;
      localObject2 = localObject1;
    } while (((LinkedList)localObject3).isEmpty());
    Throwable localThrowable = (Throwable)((LinkedList)localObject3).pop();
    StackTraceElement[] arrayOfStackTraceElement = localThrowable.getStackTrace();
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new StackTraceElement(localThrowable.getClass().getName(), "<filtered>", "<filtered>", 1));
    int m = arrayOfStackTraceElement.length;
    int i = 0;
    int j = 0;
    if (i < m)
    {
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
      if (zzat(localStackTraceElement.getClassName()))
      {
        j = 1;
        ((ArrayList)localObject2).add(localStackTraceElement);
      }
      for (;;)
      {
        i += 1;
        break;
        String str = localStackTraceElement.getClassName();
        if ((!TextUtils.isEmpty(str)) && ((str.startsWith("android.")) || (str.startsWith("java.")))) {}
        for (int k = 1;; k = 0)
        {
          if (k == 0) {
            break label469;
          }
          ((ArrayList)localObject2).add(localStackTraceElement);
          break;
        }
        label469:
        ((ArrayList)localObject2).add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
      }
    }
    if (j != 0) {
      if (localObject1 == null)
      {
        localObject1 = new Throwable(localThrowable.getMessage());
        label519:
        ((Throwable)localObject1).setStackTrace((StackTraceElement[])((ArrayList)localObject2).toArray(new StackTraceElement[0]));
      }
    }
    for (;;)
    {
      break;
      localObject1 = new Throwable(localThrowable.getMessage(), (Throwable)localObject1);
      break label519;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzha
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */