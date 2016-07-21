package org.acra;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Process;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import org.acra.collector.Compatibility;
import org.acra.collector.ConfigurationCollector;
import org.acra.collector.CrashReportDataFactory;
import org.acra.jraf.android.util.activitylifecyclecallbackscompat.ActivityLifecycleCallbacksWrapper;
import org.acra.log.ACRALog;
import org.acra.sender.ReportSender;

public class ErrorReporter
  implements Thread.UncaughtExceptionHandler
{
  private static final ExceptionHandlerInitializer NULL_EXCEPTION_HANDLER_INITIALIZER = new ErrorReporter.1();
  private static int mNotificationCounter = 0;
  public final CrashReportDataFactory crashReportDataFactory;
  boolean enabled = false;
  private volatile ExceptionHandlerInitializer exceptionHandlerInitializer = NULL_EXCEPTION_HANDLER_INITIALIZER;
  private final CrashReportFileNameParser fileNameParser = new CrashReportFileNameParser();
  private WeakReference<Activity> lastActivityCreated = new WeakReference(null);
  final Application mContext;
  private final Thread.UncaughtExceptionHandler mDfltExceptionHandler;
  private final List<ReportSender> mReportSenders = new ArrayList();
  final SharedPreferences prefs;
  private boolean toastWaitEnded = true;
  
  ErrorReporter(Application paramApplication, SharedPreferences paramSharedPreferences, boolean paramBoolean)
  {
    mContext = paramApplication;
    prefs = paramSharedPreferences;
    enabled = paramBoolean;
    if (ACRA.getConfig().getReportFields().contains(ReportField.INITIAL_CONFIGURATION)) {}
    for (String str = ConfigurationCollector.collectConfiguration(mContext);; str = null)
    {
      GregorianCalendar localGregorianCalendar = new GregorianCalendar();
      if (Compatibility.getAPILevel() >= 14) {
        paramApplication.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacksWrapper(new ErrorReporter.2(this)));
      }
      crashReportDataFactory = new CrashReportDataFactory(mContext, paramSharedPreferences, localGregorianCalendar, str);
      mDfltExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(this);
      return;
    }
  }
  
  static boolean containsOnlySilentOrApprovedReports(String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (!CrashReportFileNameParser.isApproved(paramArrayOfString[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private Intent createCrashReportDialogIntent(String paramString, ErrorReporter.ReportBuilder paramReportBuilder)
  {
    ACRA.log.d(ACRA.LOG_TAG, "Creating DialogIntent for " + paramString + " exception=" + mException);
    Intent localIntent = new Intent(mContext, ACRA.getConfig().reportDialogClass());
    localIntent.putExtra("REPORT_FILE_NAME", paramString);
    localIntent.putExtra("REPORT_EXCEPTION", mException);
    return localIntent;
  }
  
  private void endApplication(Thread paramThread, Throwable paramThrowable)
  {
    int j = 1;
    int i;
    if ((ACRA.getConfig().mode() == ReportingInteractionMode.SILENT) || ((ACRA.getConfig().mode() == ReportingInteractionMode.TOAST) && (ACRA.getConfig().forceCloseDialogAfterToast())))
    {
      i = 1;
      if (paramThread == null) {
        break label90;
      }
    }
    for (;;)
    {
      if ((j == 0) || (i == 0) || (mDfltExceptionHandler == null)) {
        break label96;
      }
      ACRA.log.d(ACRA.LOG_TAG, "Handing Exception on to default ExceptionHandler");
      mDfltExceptionHandler.uncaughtException(paramThread, paramThrowable);
      return;
      i = 0;
      break;
      label90:
      j = 0;
    }
    label96:
    ACRA.log.e(ACRA.LOG_TAG, mContext.getPackageName() + " fatal error : " + paramThrowable.getMessage(), paramThrowable);
    paramThread = (Activity)lastActivityCreated.get();
    if (paramThread != null)
    {
      ACRA.log.i(ACRA.LOG_TAG, "Finishing the last Activity prior to killing the Process");
      paramThread.finish();
      ACRA.log.i(ACRA.LOG_TAG, "Finished " + paramThread.getClass());
      lastActivityCreated.clear();
    }
    Process.killProcess(Process.myPid());
    System.exit(10);
  }
  
  @Deprecated
  public void addCustomData(String paramString1, String paramString2)
  {
    crashReportDataFactory.putCustomData(paramString1, paramString2);
  }
  
  final void deletePendingNonApprovedReports(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      deletePendingReports$49601cee(false, i);
      return;
    }
  }
  
  final void deletePendingReports$49601cee(boolean paramBoolean, int paramInt)
  {
    String[] arrayOfString = new CrashReportFinder(mContext).getCrashReportFiles();
    Arrays.sort(arrayOfString);
    int i = 0;
    while (i < arrayOfString.length - paramInt)
    {
      String str = arrayOfString[i];
      boolean bool = CrashReportFileNameParser.isApproved(str);
      if (((bool) && (paramBoolean)) || (!bool))
      {
        File localFile = new File(mContext.getFilesDir(), str);
        ACRA.log.d(ACRA.LOG_TAG, "Deleting file " + str);
        if (!localFile.delete()) {
          ACRA.log.e(ACRA.LOG_TAG, "Could not delete report : " + localFile);
        }
      }
      i += 1;
    }
  }
  
  public void handleSilentException(Throwable paramThrowable)
  {
    if (enabled)
    {
      ErrorReporter.ReportBuilder localReportBuilder = reportBuilder();
      mException = paramThrowable;
      mForceSilent = true;
      localReportBuilder.send();
      ACRA.log.d(ACRA.LOG_TAG, "ACRA sent Silent report.");
      return;
    }
    ACRA.log.d(ACRA.LOG_TAG, "ACRA is disabled. Silent report not sent.");
  }
  
  public final void removeAllReportSenders()
  {
    mReportSenders.clear();
  }
  
  public final ErrorReporter.ReportBuilder reportBuilder()
  {
    return new ErrorReporter.ReportBuilder(this);
  }
  
  public final void setReportSender(ReportSender paramReportSender)
  {
    removeAllReportSenders();
    mReportSenders.add(paramReportSender);
  }
  
  final SendWorker startSendingReports(boolean paramBoolean1, boolean paramBoolean2)
  {
    SendWorker localSendWorker = new SendWorker(mContext, mReportSenders, paramBoolean1, paramBoolean2);
    localSendWorker.start();
    return localSendWorker;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      if (!enabled)
      {
        if (mDfltExceptionHandler != null)
        {
          ACRA.log.e(ACRA.LOG_TAG, "ACRA is disabled for " + mContext.getPackageName() + " - forwarding uncaught Exception on to default ExceptionHandler");
          mDfltExceptionHandler.uncaughtException(paramThread, paramThrowable);
          return;
        }
        ACRA.log.e(ACRA.LOG_TAG, "ACRA is disabled for " + mContext.getPackageName() + " - no default ExceptionHandler");
        ACRA.log.e(ACRA.LOG_TAG, "ACRA caught a " + paramThrowable.getClass().getSimpleName() + " for " + mContext.getPackageName(), paramThrowable);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (mDfltExceptionHandler != null)
      {
        mDfltExceptionHandler.uncaughtException(paramThread, paramThrowable);
        return;
        ACRA.log.e(ACRA.LOG_TAG, "ACRA caught a " + paramThrowable.getClass().getSimpleName() + " for " + mContext.getPackageName(), paramThrowable);
        ACRA.log.d(ACRA.LOG_TAG, "Building report");
        ErrorReporter.ReportBuilder localReportBuilder = reportBuilder();
        mUncaughtExceptionThread = paramThread;
        mException = paramThrowable;
        mEndsApplication = true;
        localReportBuilder.send();
      }
    }
  }
}

/* Location:
 * Qualified Name:     org.acra.ErrorReporter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */