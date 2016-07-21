package org.acra;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.preference.PreferenceManager;
import org.acra.annotation.ReportsCrashes;
import org.acra.log.ACRALog;
import org.acra.log.AndroidLogDelegate;
import org.acra.sender.EmailIntentSender;
import org.acra.sender.HttpSender;
import org.acra.util.PackageManagerWrapper;
import org.acra.util.ToastSender;

public class ACRA
{
  public static final boolean DEV_LOGGING = false;
  public static final String LOG_TAG = ACRA.class.getSimpleName();
  public static final String PREF_ALWAYS_ACCEPT = "acra.alwaysaccept";
  public static final String PREF_DISABLE_ACRA = "acra.disable";
  public static final String PREF_ENABLE_ACRA = "acra.enable";
  public static final String PREF_ENABLE_DEVICE_ID = "acra.deviceid.enable";
  public static final String PREF_ENABLE_SYSTEM_LOGS = "acra.syslog.enable";
  public static final String PREF_LAST_VERSION_NR = "acra.lastVersionNr";
  public static final String PREF_USER_EMAIL_ADDRESS = "acra.user.email";
  private static ACRAConfiguration configProxy;
  private static ErrorReporter errorReporterSingleton;
  public static ACRALog log = new AndroidLogDelegate();
  private static Application mApplication;
  private static SharedPreferences.OnSharedPreferenceChangeListener mPrefListener;
  
  static void checkCrashResources(ReportsCrashes paramReportsCrashes)
    throws ACRAConfigurationException
  {
    switch (paramReportsCrashes.mode())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramReportsCrashes.resToastText() != 0);
        throw new ACRAConfigurationException("TOAST mode: you have to define the resToastText parameter in your application @ReportsCrashes() annotation.");
        if ((paramReportsCrashes.resNotifTickerText() == 0) || (paramReportsCrashes.resNotifTitle() == 0) || (paramReportsCrashes.resNotifText() == 0)) {
          throw new ACRAConfigurationException("NOTIFICATION mode: you have to define at least the resNotifTickerText, resNotifTitle, resNotifText parameters in your application @ReportsCrashes() annotation.");
        }
      } while ((!CrashReportDialog.class.equals(paramReportsCrashes.reportDialogClass())) || (paramReportsCrashes.resDialogText() != 0));
      throw new ACRAConfigurationException("NOTIFICATION mode: using the (default) CrashReportDialog requires you have to define the resDialogText parameter in your application @ReportsCrashes() annotation.");
    } while ((!CrashReportDialog.class.equals(paramReportsCrashes.reportDialogClass())) || (paramReportsCrashes.resDialogText() != 0));
    throw new ACRAConfigurationException("DIALOG mode: using the (default) CrashReportDialog requires you to define the resDialogText parameter in your application @ReportsCrashes() annotation.");
  }
  
  public static SharedPreferences getACRASharedPreferences()
  {
    ACRAConfiguration localACRAConfiguration = getConfig();
    if (!"".equals(localACRAConfiguration.sharedPreferencesName())) {
      return mApplication.getSharedPreferences(localACRAConfiguration.sharedPreferencesName(), localACRAConfiguration.sharedPreferencesMode());
    }
    return PreferenceManager.getDefaultSharedPreferences(mApplication);
  }
  
  static Application getApplication()
  {
    return mApplication;
  }
  
  public static ACRAConfiguration getConfig()
  {
    if (configProxy == null)
    {
      if (mApplication == null) {
        log.w(LOG_TAG, "Calling ACRA.getConfig() before ACRA.init() gives you an empty configuration instance. You might prefer calling ACRA.getNewDefaultConfig(Application) to get an instance with default values taken from a @ReportsCrashes annotation.");
      }
      configProxy = getNewDefaultConfig(mApplication);
    }
    return configProxy;
  }
  
  public static ErrorReporter getErrorReporter()
  {
    if (errorReporterSingleton == null) {
      throw new IllegalStateException("Cannot access ErrorReporter before ACRA#init");
    }
    return errorReporterSingleton;
  }
  
  public static ACRAConfiguration getNewDefaultConfig(Application paramApplication)
  {
    if (paramApplication != null) {
      return new ACRAConfiguration((ReportsCrashes)paramApplication.getClass().getAnnotation(ReportsCrashes.class));
    }
    return new ACRAConfiguration(null);
  }
  
  public static void init(Application paramApplication)
  {
    ReportsCrashes localReportsCrashes = (ReportsCrashes)paramApplication.getClass().getAnnotation(ReportsCrashes.class);
    if (localReportsCrashes == null)
    {
      log.e(LOG_TAG, "ACRA#init called but no ReportsCrashes annotation on Application " + paramApplication.getPackageName());
      return;
    }
    init(paramApplication, new ACRAConfiguration(localReportsCrashes));
  }
  
  public static void init(Application paramApplication, ACRAConfiguration paramACRAConfiguration)
  {
    init(paramApplication, paramACRAConfiguration, true);
  }
  
  public static void init(Application paramApplication, ACRAConfiguration paramACRAConfiguration, boolean paramBoolean)
  {
    i = 1;
    if (mApplication != null)
    {
      log.w(LOG_TAG, "ACRA#init called more than once. Won't do anything more.");
      return;
    }
    mApplication = paramApplication;
    if (paramACRAConfiguration == null)
    {
      log.e(LOG_TAG, "ACRA#init called but no ACRAConfiguration provided");
      return;
    }
    configProxy = paramACRAConfiguration;
    paramApplication = getACRASharedPreferences();
    for (;;)
    {
      try
      {
        checkCrashResources(paramACRAConfiguration);
        log.d(LOG_TAG, "ACRA is enabled for " + mApplication.getPackageName() + ", initializing...");
        if (shouldDisableACRA(paramApplication)) {
          continue;
        }
        bool = true;
        paramACRAConfiguration = new ErrorReporter(mApplication, paramApplication, bool);
        localObject1 = getConfig();
        localObject2 = getApplication();
        paramACRAConfiguration.removeAllReportSenders();
        if ("".equals(((ReportsCrashes)localObject1).mailTo())) {
          continue;
        }
        log.w(LOG_TAG, ((Application)localObject2).getPackageName() + " reports will be sent by email (if accepted by user).");
        paramACRAConfiguration.setReportSender(new EmailIntentSender((Context)localObject2));
      }
      catch (ACRAConfigurationException paramACRAConfiguration)
      {
        boolean bool;
        Object localObject1;
        Object localObject2;
        long l;
        log.w(LOG_TAG, "Error : ", paramACRAConfiguration);
        continue;
        if ((((ReportsCrashes)localObject1).formUri() == null) || ("".equals(((ReportsCrashes)localObject1).formUri()))) {
          continue;
        }
        paramACRAConfiguration.setReportSender(new HttpSender(getConfig().httpMethod(), getConfig().reportType()));
        continue;
        i = 0;
        continue;
      }
      errorReporterSingleton = paramACRAConfiguration;
      if (paramBoolean)
      {
        if (getConfig().deleteOldUnsentReportsOnApplicationStart())
        {
          l = prefs.getInt("acra.lastVersionNr", 0);
          localObject1 = new PackageManagerWrapper(mContext).getPackageInfo();
          if (localObject1 != null)
          {
            if (versionCode <= l) {
              continue;
            }
            if (i != 0) {
              paramACRAConfiguration.deletePendingReports$49601cee(true, 0);
            }
            localObject2 = prefs.edit();
            ((SharedPreferences.Editor)localObject2).putInt("acra.lastVersionNr", versionCode);
            ((SharedPreferences.Editor)localObject2).commit();
          }
        }
        localObject1 = getConfig().mode();
        if (((localObject1 == ReportingInteractionMode.NOTIFICATION) || (localObject1 == ReportingInteractionMode.DIALOG)) && (getConfig().deleteUnapprovedReportsOnApplicationStart())) {
          paramACRAConfiguration.deletePendingNonApprovedReports(true);
        }
        localObject2 = new CrashReportFinder(mContext).getCrashReportFiles();
        if ((localObject2 != null) && (localObject2.length > 0))
        {
          paramBoolean = ErrorReporter.containsOnlySilentOrApprovedReports((String[])localObject2);
          if ((localObject1 == ReportingInteractionMode.SILENT) || (localObject1 == ReportingInteractionMode.TOAST) || ((paramBoolean) && ((localObject1 == ReportingInteractionMode.NOTIFICATION) || (localObject1 == ReportingInteractionMode.DIALOG))))
          {
            if ((localObject1 == ReportingInteractionMode.TOAST) && (!paramBoolean)) {
              ToastSender.sendToast$3047fd93(mContext, getConfig().resToastText());
            }
            log.v(LOG_TAG, "About to start ReportSenderWorker from #checkReportOnApplicationStart");
            paramACRAConfiguration.startSendingReports(false, false);
          }
        }
      }
      mPrefListener = new SharedPreferences.OnSharedPreferenceChangeListener()
      {
        public final void onSharedPreferenceChanged(SharedPreferences paramAnonymousSharedPreferences, String paramAnonymousString)
        {
          boolean bool;
          ACRALog localACRALog;
          String str;
          StringBuilder localStringBuilder;
          if (("acra.disable".equals(paramAnonymousString)) || ("acra.enable".equals(paramAnonymousString)))
          {
            if (ACRA.shouldDisableACRA(paramAnonymousSharedPreferences)) {
              break label99;
            }
            bool = true;
            paramAnonymousString = ACRA.getErrorReporter();
            localACRALog = ACRA.log;
            str = ACRA.LOG_TAG;
            localStringBuilder = new StringBuilder("ACRA is ");
            if (!bool) {
              break label104;
            }
          }
          label99:
          label104:
          for (paramAnonymousSharedPreferences = "enabled";; paramAnonymousSharedPreferences = "disabled")
          {
            localACRALog.i(str, paramAnonymousSharedPreferences + " for " + mContext.getPackageName());
            enabled = bool;
            return;
            bool = false;
            break;
          }
        }
      };
      paramApplication.registerOnSharedPreferenceChangeListener(mPrefListener);
      return;
      bool = false;
      continue;
      if (new PackageManagerWrapper((Context)localObject2).hasPermission("android.permission.INTERNET")) {
        continue;
      }
      log.e(LOG_TAG, ((Application)localObject2).getPackageName() + " should be granted permission android.permission.INTERNET if you want your crash reports to be sent. If you don't want to add this permission to your application you can also enable sending reports by email. If this is your will then provide your email address in @ReportsCrashes(mailTo=\"your.account@domain.com\"");
    }
  }
  
  static boolean isDebuggable()
  {
    boolean bool = false;
    PackageManager localPackageManager = mApplication.getPackageManager();
    try
    {
      int i = getApplicationInfomApplicationgetPackageName0flags;
      if ((i & 0x2) > 0) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  public static void setLog(ACRALog paramACRALog)
  {
    if (paramACRALog == null) {
      throw new NullPointerException("ACRALog cannot be null");
    }
    log = paramACRALog;
  }
  
  private static boolean shouldDisableACRA(SharedPreferences paramSharedPreferences)
  {
    boolean bool = true;
    try
    {
      if (!paramSharedPreferences.getBoolean("acra.enable", true)) {}
      for (;;)
      {
        bool = paramSharedPreferences.getBoolean("acra.disable", bool);
        return bool;
        bool = false;
      }
      return false;
    }
    catch (Exception paramSharedPreferences) {}
  }
}

/* Location:
 * Qualified Name:     org.acra.ACRA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */