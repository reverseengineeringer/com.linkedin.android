package com.linkedin.android.infra.shared;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.View;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Util
{
  private static final String TAG = Util.class.getSimpleName();
  
  public static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static Urn createUrnFromNSS(String paramString)
    throws URISyntaxException
  {
    return Urn.createFromString("urn:li:" + paramString);
  }
  
  @SuppressLint({"InflateParams"})
  public static void debugDialog$67c6b14e(String paramString1, String paramString2)
  {
    String str1 = TAG;
    String str2 = paramString1.concat("\n");
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    Log.d(str1, str2.concat(paramString1));
  }
  
  public static <T> T ensureNonNull$d953a71(T paramT, String paramString)
  {
    if (paramT == null) {
      safeThrow$7a8b4789(new RuntimeException(paramString));
    }
    return paramT;
  }
  
  public static ApplicationComponent getAppComponent(Context paramContext)
  {
    return ((FlagshipApplication)paramContext.getApplicationContext()).getAppComponent();
  }
  
  public static String getCanonicalName(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    return paramObject.getClass().getCanonicalName();
  }
  
  public static boolean isEnglish(Context paramContext)
  {
    paramContext = getResourcesgetConfigurationlocale;
    return Locale.ENGLISH.getLanguage().equals(paramContext.getLanguage());
  }
  
  public static String retrieveRumSessionId(FragmentComponent paramFragmentComponent)
  {
    paramFragmentComponent = paramFragmentComponent.fragment();
    if ((paramFragmentComponent instanceof TrackableFragment)) {
      return ((TrackableFragment)paramFragmentComponent).getRumSessionId();
    }
    return null;
  }
  
  public static boolean safeEquals(Object paramObject1, Object paramObject2)
  {
    return ((paramObject1 == null) && (paramObject2 == null)) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static <T> List<T> safeGet(List<T> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    return (List<T>)localObject;
  }
  
  @Deprecated
  public static void safeThrow(RuntimeException paramRuntimeException)
  {
    safeThrow$7a8b4789(paramRuntimeException);
  }
  
  @SuppressLint({"InflateParams"})
  public static void safeThrow$7a8b4789(RuntimeException paramRuntimeException)
  {
    Log.e(TAG, "Safe thrown exception:", paramRuntimeException);
  }
  
  public static String safeToString(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    return paramObject.toString();
  }
  
  public static void setComponentEnabled(Context paramContext, Class<?> paramClass, boolean paramBoolean)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localPackageManager.setComponentEnabledSetting(new ComponentName(paramContext, paramClass), i, 1);
      return;
    }
  }
  
  public static boolean shouldWrapInWeakReference(Object paramObject)
  {
    return ((paramObject instanceof Context)) || ((paramObject instanceof Fragment)) || ((paramObject instanceof View));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.Util
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */