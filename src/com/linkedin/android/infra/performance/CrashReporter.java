package com.linkedin.android.infra.performance;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.Crashlytics.Builder;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.beta.Beta;
import com.crashlytics.android.core.CrashlyticsCore;
import com.crashlytics.android.core.CrashlyticsCore.Builder;
import com.linkedin.android.infra.VoyagerShakeDelegate;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixDefinition;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.common.Me;
import com.linkedin.android.perf.commons.HurlStack;
import com.linkedin.android.perf.crashreport.CrashReportSender;
import com.linkedin.android.perf.crashreport.CrashReportSender.ApplicationBuildType;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class CrashReporter
{
  private static final String TAG = CrashReporter.class.getSimpleName();
  private static boolean isCrashlyticsEnabled;
  private static boolean isEkgEnabled = true;
  private static boolean isMemberIdLoggingEnabled;
  private static boolean isVmShutDownInProgress;
  private static FlagshipSharedPreferences preferences;
  
  public static void initCrashReporting(FlagshipApplication paramFlagshipApplication)
  {
    ApplicationComponent localApplicationComponent = paramFlagshipApplication.getAppComponent();
    preferences = localApplicationComponent.flagshipSharedPreferences();
    Object localObject1 = localApplicationComponent.lixManager();
    Object localObject2 = ((LixManager)localObject1).getTreatment(Lix.INFRA_CRASH_REPORT);
    String str = ((LixManager)localObject1).getTreatment(Lix.INFRA_CRASH_REPORT_MEMBERID);
    ((LixManager)localObject1).addTreatmentListener(Lix.INFRA_CRASH_REPORT_MEMBERID, new CrashReporter.1());
    setIsMemberIdLoggingEnabled(str);
    Log.d(TAG, "Received treatment " + (String)localObject2);
    int i = -1;
    switch (((String)localObject2).hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        isEkgEnabled = true;
        isCrashlyticsEnabled = false;
      }
      break;
    }
    for (;;)
    {
      Log.d(TAG, "Is EKG enabled " + isEkgEnabled);
      Log.d(TAG, "Is Crashlytics enabled " + isCrashlyticsEnabled);
      Log.d(TAG, "Is Logging memberId enabled " + isMemberIdLoggingEnabled);
      if (!isCrashlyticsEnabled) {
        break label538;
      }
      localObject1 = new CrashlyticsCore.Builder().build();
      localObject2 = new Crashlytics.Builder();
      if (core == null) {
        break label399;
      }
      throw new IllegalStateException("CrashlyticsCore Kit already set.");
      if (!((String)localObject2).equals("all")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject2).equals("ekg")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject2).equals("crashlytics")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject2).equals("control")) {
        break;
      }
      i = 3;
      break;
      isEkgEnabled = true;
      isCrashlyticsEnabled = true;
      continue;
      isEkgEnabled = true;
      isCrashlyticsEnabled = false;
      continue;
      isEkgEnabled = false;
      isCrashlyticsEnabled = true;
      continue;
      isEkgEnabled = false;
      isCrashlyticsEnabled = false;
    }
    label399:
    core = ((CrashlyticsCore)localObject1);
    if (coreBuilder != null)
    {
      if (core != null) {
        throw new IllegalStateException("Must not use Deprecated methods delay(), disabled(), listener(), pinningInfoProvider() with core()");
      }
      core = coreBuilder.build();
    }
    if (answers == null) {
      answers = new Answers();
    }
    if (beta == null) {
      beta = new Beta();
    }
    if (core == null) {
      core = new CrashlyticsCore();
    }
    Fabric.with(paramFlagshipApplication, new Kit[] { new Crashlytics(answers, beta, core) });
    label538:
    if (isEkgEnabled) {
      CrashReportSender.initializeCrashReporting$c3c3b8(paramFlagshipApplication, new HurlStack(), CrashReportSender.ApplicationBuildType.PRODUCTION);
    }
    leaveBreadcrumb("app_launch");
    setDeviceLocale(getResourcesgetConfigurationlocale);
    if (isCrashlyticsInitializedAndEnabled()) {
      Crashlytics.setString("MP_VERSION", "0.21.208");
    }
    Thread.setDefaultUncaughtExceptionHandler(new CrashReporter.FlagshipUncaughtExceptionHandler(localApplicationComponent.flagshipSharedPreferences()));
  }
  
  private static boolean isCrashlyticsInitializedAndEnabled()
  {
    return (isCrashlyticsEnabled) && (Crashlytics.getInstance() != null);
  }
  
  public static boolean isVmShutDownInProgress()
  {
    return isVmShutDownInProgress;
  }
  
  public static void leaveBreadcrumb(String paramString)
  {
    VoyagerShakeDelegate.pushPageKey(paramString);
    if (isCrashlyticsInitializedAndEnabled()) {
      Crashlytics.log(paramString);
    }
    if (isEkgEnabled) {
      CrashReportSender.trackBreadCrumb(paramString, Long.valueOf(System.currentTimeMillis()));
    }
  }
  
  public static void logComponentInfo(String paramString, Intent paramIntent)
  {
    Object localObject1 = paramString;
    Object localObject2 = localObject1;
    if (paramIntent != null) {
      localObject2 = (String)localObject1 + " Intent: " + paramIntent.toString();
    }
    Log.i((String)localObject2);
    if (preferences == null) {
      return;
    }
    paramIntent = preferences;
    localObject1 = new ArrayList(Arrays.asList(TextUtils.split(paramIntent.getPreferences().getString("coldStartComponentInfo", ""), ";")));
    if (((List)localObject1).size() > 30) {
      ((List)localObject1).remove(0);
    }
    ((List)localObject1).add(paramString);
    paramString = TextUtils.join(";", (Iterable)localObject1);
    paramIntent.getPreferences().edit().putString("coldStartComponentInfo", paramString).commit();
  }
  
  public static void onTrimMemory$13462e()
  {
    if (isEkgEnabled) {
      CrashReportSender.onTRIMMemoryWarning$13462e();
    }
  }
  
  public static void reportNonFatal(Throwable paramThrowable)
  {
    if (isCrashlyticsInitializedAndEnabled()) {
      Crashlytics.logException(paramThrowable);
    }
    if (isEkgEnabled) {
      CrashReportSender.sendCaughtException(paramThrowable);
    }
  }
  
  public static void setDeviceLocale(Locale paramLocale)
  {
    if (isCrashlyticsInitializedAndEnabled()) {
      Crashlytics.setString("Locale", paramLocale.toString());
    }
  }
  
  private static void setIsMemberIdLoggingEnabled(String paramString)
  {
    if ("enabled".equals(paramString)) {
      isMemberIdLoggingEnabled = true;
    }
  }
  
  public static <T extends LixDefinition> void setLixTreatments(SimpleArrayMap<T, String> paramSimpleArrayMap)
  {
    int j;
    if (isCrashlyticsInitializedAndEnabled())
    {
      i = 0;
      j = paramSimpleArrayMap.size();
      while (i < j)
      {
        Crashlytics.setString(((LixDefinition)paramSimpleArrayMap.keyAt(i)).getName(), (String)paramSimpleArrayMap.valueAt(i));
        i += 1;
      }
    }
    if ((isEkgEnabled) && (CrashReportSender.isInitialized())) {}
    for (int i = 1; i != 0; i = 0)
    {
      i = 0;
      j = paramSimpleArrayMap.size();
      while (i < j)
      {
        CrashReportSender.setMobileLixTreatmentRecords(((LixDefinition)paramSimpleArrayMap.keyAt(i)).getName(), (String)paramSimpleArrayMap.valueAt(i));
        i += 1;
      }
    }
  }
  
  public static void setUserInfo(Me paramMe)
  {
    if ((isCrashlyticsEnabled) && (isMemberIdLoggingEnabled)) {
      Crashlytics.setUserIdentifier(String.valueOf(plainId));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.performance.CrashReporter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */