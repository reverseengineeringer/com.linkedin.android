package com.crashlytics.android;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.beta.Beta;
import com.crashlytics.android.core.CrashlyticsCore;
import com.crashlytics.android.core.CrashlyticsCore.Builder;
import com.crashlytics.android.core.CrashlyticsExecutorServiceWrapper;
import com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler;
import com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.6;
import com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.7;
import com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.8;
import com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.9;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.KitGroup;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class Crashlytics
  extends Kit<Void>
  implements KitGroup
{
  public final Answers answers;
  public final Beta beta;
  public final CrashlyticsCore core;
  public final Collection<? extends Kit> kits;
  
  public Crashlytics()
  {
    this(new Answers(), new Beta(), new CrashlyticsCore());
  }
  
  public Crashlytics(Answers paramAnswers, Beta paramBeta, CrashlyticsCore paramCrashlyticsCore)
  {
    answers = paramAnswers;
    beta = paramBeta;
    core = paramCrashlyticsCore;
    kits = Collections.unmodifiableCollection(Arrays.asList(new Kit[] { paramAnswers, paramBeta, paramCrashlyticsCore }));
  }
  
  private static void checkInitialized()
  {
    if (getInstance() == null) {
      throw new IllegalStateException("Crashlytics must be initialized by calling Fabric.with(Context) prior to calling Crashlytics.getInstance()");
    }
  }
  
  public static Crashlytics getInstance()
  {
    return (Crashlytics)Fabric.getKit(Crashlytics.class);
  }
  
  public static void log(String paramString)
  {
    checkInitialized();
    Object localObject = getInstancecore;
    if ((!disabled) && (CrashlyticsCore.ensureFabricWithCalled("prior to logging messages.")))
    {
      long l1 = System.currentTimeMillis();
      long l2 = startTime;
      localObject = handler;
      paramString = CrashlyticsCore.formatLogMessage$6a35bb62("CrashlyticsCore", paramString);
      executorServiceWrapper.executeAsync(new CrashlyticsUncaughtExceptionHandler.6((CrashlyticsUncaughtExceptionHandler)localObject, l1 - l2, paramString));
    }
  }
  
  public static void logException(Throwable paramThrowable)
  {
    checkInitialized();
    Object localObject = getInstancecore;
    if ((!disabled) && (CrashlyticsCore.ensureFabricWithCalled("prior to logging exceptions.")))
    {
      if (paramThrowable == null) {
        Fabric.getLogger().log(5, "CrashlyticsCore", "Crashlytics is ignoring a request to log a null exception.");
      }
    }
    else {
      return;
    }
    localObject = handler;
    Thread localThread = Thread.currentThread();
    Date localDate = new Date();
    executorServiceWrapper.executeAsync(new CrashlyticsUncaughtExceptionHandler.7((CrashlyticsUncaughtExceptionHandler)localObject, localDate, localThread, paramThrowable));
  }
  
  public static void setString(String paramString1, String paramString2)
  {
    checkInitialized();
    CrashlyticsCore localCrashlyticsCore = getInstancecore;
    if (!disabled)
    {
      if (paramString1 == null)
      {
        paramString1 = context;
        if ((paramString1 != null) && (CommonUtils.isAppDebuggable(paramString1))) {
          throw new IllegalArgumentException("Custom attribute key must not be null.");
        }
        Fabric.getLogger().e("CrashlyticsCore", "Attempting to set custom attribute with null key, ignoring.", null);
      }
    }
    else {
      return;
    }
    String str = CrashlyticsCore.sanitizeAttribute(paramString1);
    if ((attributes.size() >= 64) && (!attributes.containsKey(str)))
    {
      Fabric.getLogger().d("CrashlyticsCore", "Exceeded maximum number of custom attributes (64)");
      return;
    }
    if (paramString2 == null) {}
    for (paramString1 = "";; paramString1 = CrashlyticsCore.sanitizeAttribute(paramString2))
    {
      attributes.put(str, paramString1);
      paramString1 = handler;
      paramString2 = attributes;
      executorServiceWrapper.executeAsync(new CrashlyticsUncaughtExceptionHandler.9(paramString1, paramString2));
      return;
    }
  }
  
  public static void setUserIdentifier(String paramString)
  {
    checkInitialized();
    Object localObject = getInstancecore;
    if (!disabled)
    {
      userId = CrashlyticsCore.sanitizeAttribute(paramString);
      paramString = handler;
      String str1 = userId;
      String str2 = userName;
      localObject = userEmail;
      executorServiceWrapper.executeAsync(new CrashlyticsUncaughtExceptionHandler.8(paramString, str1, str2, (String)localObject));
    }
  }
  
  public final String getIdentifier()
  {
    return "com.crashlytics.sdk.android:crashlytics";
  }
  
  public final Collection<? extends Kit> getKits()
  {
    return kits;
  }
  
  public final String getVersion()
  {
    return "2.5.5.97";
  }
  
  public static final class Builder
  {
    public Answers answers;
    public Beta beta;
    public CrashlyticsCore core;
    public CrashlyticsCore.Builder coreBuilder;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.Crashlytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */