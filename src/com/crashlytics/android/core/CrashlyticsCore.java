package com.crashlytics.android.core;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.AnswersEventsHandler;
import com.crashlytics.android.answers.SessionAnalyticsManager;
import com.crashlytics.android.answers.SessionEvent.Builder;
import com.crashlytics.android.answers.SessionEvent.Type;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.InitializationTask;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.Crash;
import io.fabric.sdk.android.services.common.Crash.FatalException;
import io.fabric.sdk.android.services.common.Crash.LoggedException;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.concurrency.DependsOn;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityCallable;
import io.fabric.sdk.android.services.concurrency.Task;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStore;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;
import io.fabric.sdk.android.services.settings.AppSettingsData;
import io.fabric.sdk.android.services.settings.FeaturesSettingsData;
import io.fabric.sdk.android.services.settings.PromptSettingsData;
import io.fabric.sdk.android.services.settings.SessionSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.Settings.LazyHolder;
import io.fabric.sdk.android.services.settings.Settings.SettingsAccess;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@DependsOn({CrashEventDataProvider.class})
public class CrashlyticsCore
  extends Kit<Void>
{
  String apiKey;
  public final ConcurrentHashMap<String, String> attributes;
  String buildId;
  CrashlyticsFileMarker crashMarker;
  private float delay;
  public boolean disabled;
  private CrashlyticsExecutorServiceWrapper executorServiceWrapper;
  CrashEventDataProvider externalCrashEventDataProvider;
  private FileStore fileStore;
  public CrashlyticsUncaughtExceptionHandler handler;
  private HttpRequestFactory httpRequestFactory;
  private CrashlyticsFileMarker initializationMarker;
  String installerPackageName;
  private CrashlyticsListener listener;
  private String packageName;
  private final PinningInfoProvider pinningInfo;
  private File sdkDir;
  public final long startTime;
  public String userEmail = null;
  public String userId = null;
  public String userName = null;
  String versionCode;
  String versionName;
  
  public CrashlyticsCore()
  {
    this(1.0F, null, null, false);
  }
  
  CrashlyticsCore(float paramFloat, CrashlyticsListener paramCrashlyticsListener, PinningInfoProvider paramPinningInfoProvider, boolean paramBoolean)
  {
    this(paramFloat, paramCrashlyticsListener, paramPinningInfoProvider, paramBoolean, localExecutorService);
  }
  
  private CrashlyticsCore(float paramFloat, CrashlyticsListener paramCrashlyticsListener, PinningInfoProvider paramPinningInfoProvider, boolean paramBoolean, ExecutorService paramExecutorService)
  {
    delay = paramFloat;
    if (paramCrashlyticsListener != null) {}
    for (;;)
    {
      listener = paramCrashlyticsListener;
      pinningInfo = paramPinningInfoProvider;
      disabled = paramBoolean;
      executorServiceWrapper = new CrashlyticsExecutorServiceWrapper(paramExecutorService);
      attributes = new ConcurrentHashMap();
      startTime = System.currentTimeMillis();
      return;
      paramCrashlyticsListener = new NoOpListener((byte)0);
    }
  }
  
  public static boolean ensureFabricWithCalled(String paramString)
  {
    CrashlyticsCore localCrashlyticsCore = getInstance();
    if ((localCrashlyticsCore == null) || (handler == null))
    {
      Fabric.getLogger().e("CrashlyticsCore", "Crashlytics must be initialized by calling Fabric.with(Context) " + paramString, null);
      return false;
    }
    return true;
  }
  
  private void finishInitSynchronously()
  {
    Object localObject = new PriorityCallable()
    {
      public final Priority getPriority()
      {
        return Priority.IMMEDIATE;
      }
    };
    Iterator localIterator = initializationTask.getDependencies().iterator();
    while (localIterator.hasNext()) {
      ((PriorityCallable)localObject).addDependency((Task)localIterator.next());
    }
    localObject = fabric.executorService.submit((Callable)localObject);
    Fabric.getLogger().d("CrashlyticsCore", "Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
    try
    {
      ((Future)localObject).get(4L, TimeUnit.SECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Crashlytics was interrupted during initialization.", localInterruptedException);
      return;
    }
    catch (ExecutionException localExecutionException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Problem encountered during Crashlytics initialization.", localExecutionException);
      return;
    }
    catch (TimeoutException localTimeoutException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Crashlytics timed out during initialization.", localTimeoutException);
    }
  }
  
  public static String formatLogMessage$6a35bb62(String paramString1, String paramString2)
  {
    return CommonUtils.logPriorityToString$47921032() + "/" + paramString1 + " " + paramString2;
  }
  
  public static CrashlyticsCore getInstance()
  {
    return (CrashlyticsCore)Fabric.getKit(CrashlyticsCore.class);
  }
  
  private boolean getSendDecisionFromUser(final Activity paramActivity, final PromptSettingsData paramPromptSettingsData)
  {
    final DialogStringResolver localDialogStringResolver = new DialogStringResolver(paramActivity, paramPromptSettingsData);
    final OptInLatch localOptInLatch = new OptInLatch((byte)0);
    paramActivity.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
        Object localObject1 = new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            val$latch.setOptIn(true);
            paramAnonymous2DialogInterface.dismiss();
          }
        };
        float f = paramActivitygetResourcesgetDisplayMetricsdensity;
        int i = CrashlyticsCore.access$400(f, 5);
        Object localObject2 = new TextView(paramActivity);
        ((TextView)localObject2).setAutoLinkMask(15);
        Object localObject3 = localDialogStringResolver;
        ((TextView)localObject2).setText(((DialogStringResolver)localObject3).resourceOrFallbackValue("com.crashlytics.CrashSubmissionPromptMessage", promptData.message));
        ((TextView)localObject2).setTextAppearance(paramActivity, 16973892);
        ((TextView)localObject2).setPadding(i, i, i, i);
        ((TextView)localObject2).setFocusable(false);
        localObject3 = new ScrollView(paramActivity);
        ((ScrollView)localObject3).setPadding(CrashlyticsCore.access$400(f, 14), CrashlyticsCore.access$400(f, 2), CrashlyticsCore.access$400(f, 10), CrashlyticsCore.access$400(f, 12));
        ((ScrollView)localObject3).addView((View)localObject2);
        localObject2 = localBuilder.setView((View)localObject3);
        localObject3 = localDialogStringResolver;
        localObject2 = ((AlertDialog.Builder)localObject2).setTitle(((DialogStringResolver)localObject3).resourceOrFallbackValue("com.crashlytics.CrashSubmissionPromptTitle", promptData.title)).setCancelable(false);
        localObject3 = localDialogStringResolver;
        ((AlertDialog.Builder)localObject2).setNeutralButton(((DialogStringResolver)localObject3).resourceOrFallbackValue("com.crashlytics.CrashSubmissionSendTitle", promptData.sendButtonTitle), (DialogInterface.OnClickListener)localObject1);
        if (paramPromptSettingsDatashowCancelButton)
        {
          localObject1 = new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              val$latch.setOptIn(false);
              paramAnonymous2DialogInterface.dismiss();
            }
          };
          localObject2 = localDialogStringResolver;
          localBuilder.setNegativeButton(((DialogStringResolver)localObject2).resourceOrFallbackValue("com.crashlytics.CrashSubmissionCancelTitle", promptData.cancelButtonTitle), (DialogInterface.OnClickListener)localObject1);
        }
        if (paramPromptSettingsDatashowAlwaysSendButton)
        {
          localObject1 = new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              PreferenceStoreImpl localPreferenceStoreImpl = new PreferenceStoreImpl(CrashlyticsCore.this);
              localPreferenceStoreImpl.save(localPreferenceStoreImpl.edit().putBoolean("always_send_reports_opt_in", true));
              val$latch.setOptIn(true);
              paramAnonymous2DialogInterface.dismiss();
            }
          };
          localObject2 = localDialogStringResolver;
          localBuilder.setPositiveButton(((DialogStringResolver)localObject2).resourceOrFallbackValue("com.crashlytics.CrashSubmissionAlwaysSendTitle", promptData.alwaysSendButtonTitle), (DialogInterface.OnClickListener)localObject1);
        }
        localBuilder.show();
      }
    });
    Fabric.getLogger().d("CrashlyticsCore", "Waiting for user opt-in.");
    try
    {
      latch.await();
      return send;
    }
    catch (InterruptedException paramActivity)
    {
      for (;;) {}
    }
  }
  
  static SessionSettingsData getSessionSettingsData()
  {
    SettingsData localSettingsData = Settings.LazyHolder.access$100().awaitSettingsData();
    if (localSettingsData == null) {
      return null;
    }
    return sessionData;
  }
  
  private void markInitializationComplete()
  {
    executorServiceWrapper.executeAsync(new Callable()
    {
      private Boolean call()
        throws Exception
      {
        try
        {
          boolean bool = initializationMarker.getMarkerFile().delete();
          Fabric.getLogger().d("CrashlyticsCore", "Initialization marker file removed: " + bool);
          return Boolean.valueOf(bool);
        }
        catch (Exception localException)
        {
          Fabric.getLogger().e("CrashlyticsCore", "Problem encountered deleting Crashlytics initialization marker.", localException);
        }
        return Boolean.valueOf(false);
      }
    });
  }
  
  private boolean onPreExecute(Context paramContext)
  {
    if (disabled) {
      return false;
    }
    new ApiKey();
    apiKey = ApiKey.getValue(paramContext);
    if (apiKey == null) {
      return false;
    }
    Fabric.getLogger().i("CrashlyticsCore", "Initializing Crashlytics 2.3.8.97");
    fileStore = new FileStoreImpl(this);
    crashMarker = new CrashlyticsFileMarker("crash_marker", fileStore);
    initializationMarker = new CrashlyticsFileMarker("initialization_marker", fileStore);
    try
    {
      if (pinningInfo != null)
      {
        localObject = new CrashlyticsPinningInfoProvider(pinningInfo);
        httpRequestFactory = new DefaultHttpRequestFactory(Fabric.getLogger());
        httpRequestFactory.setPinningInfoProvider((io.fabric.sdk.android.services.network.PinningInfoProvider)localObject);
        packageName = paramContext.getPackageName();
        installerPackageName = idManager.getInstallerPackageName();
        Fabric.getLogger().d("CrashlyticsCore", "Installer package name is: " + installerPackageName);
        localObject = paramContext.getPackageManager().getPackageInfo(packageName, 0);
        versionCode = Integer.toString(versionCode);
        if (versionName != null) {
          break label469;
        }
        localObject = "0.0";
        versionName = ((String)localObject);
        buildId = CommonUtils.resolveBuildId(paramContext);
        localObject = new BuildIdValidator(buildId, CommonUtils.getBooleanResourceValue(paramContext, "com.crashlytics.RequireBuildId", true));
        if ((!CommonUtils.isNullOrEmpty(buildId)) || (!requiringBuildId)) {
          break label477;
        }
        Log.e("CrashlyticsCore", ".");
        Log.e("CrashlyticsCore", ".     |  | ");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".   \\ |  | /");
        Log.e("CrashlyticsCore", ".    \\    /");
        Log.e("CrashlyticsCore", ".     \\  /");
        Log.e("CrashlyticsCore", ".      \\/");
        Log.e("CrashlyticsCore", ".");
        Log.e("CrashlyticsCore", "This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
        Log.e("CrashlyticsCore", ".");
        Log.e("CrashlyticsCore", ".      /\\");
        Log.e("CrashlyticsCore", ".     /  \\");
        Log.e("CrashlyticsCore", ".    /    \\");
        Log.e("CrashlyticsCore", ".   / |  | \\");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".     |  |");
        Log.e("CrashlyticsCore", ".");
        throw new CrashlyticsMissingDependencyException("This app relies on Crashlytics. Please sign up for access at https://fabric.io/sign_up,\ninstall an Android build tool and ask a team member to invite you to this app's organization.");
      }
    }
    catch (CrashlyticsMissingDependencyException paramContext)
    {
      for (;;)
      {
        throw new UnmetDependencyException(paramContext);
        localObject = null;
        continue;
        localObject = versionName;
      }
      if (!requiringBuildId) {
        Fabric.getLogger().d("CrashlyticsCore", "Configured not to require a build ID.");
      }
      Object localObject = new ManifestUnityVersionProvider(paramContext, packageName);
      boolean bool = ((Boolean)executorServiceWrapper.executeSyncLoggingException(new Callable() {})).booleanValue();
      Boolean localBoolean = (Boolean)executorServiceWrapper.executeSyncLoggingException(new CrashMarkerCheck(crashMarker));
      Boolean.TRUE.equals(localBoolean);
      try
      {
        Fabric.getLogger().d("CrashlyticsCore", "Installing exception handler...");
        handler = new CrashlyticsUncaughtExceptionHandler(Thread.getDefaultUncaughtExceptionHandler(), executorServiceWrapper, idManager, (UnityVersionProvider)localObject, fileStore, this);
        localObject = handler;
        executorServiceWrapper.executeAsync(new CrashlyticsUncaughtExceptionHandler.10((CrashlyticsUncaughtExceptionHandler)localObject));
        Thread.setDefaultUncaughtExceptionHandler(handler);
        Fabric.getLogger().d("CrashlyticsCore", "Successfully installed exception handler.");
        if ((bool) && (CommonUtils.canTryConnection(paramContext)))
        {
          finishInitSynchronously();
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Fabric.getLogger().e("CrashlyticsCore", "There was a problem installing the exception handler.", localException);
        }
      }
    }
    catch (Exception paramContext)
    {
      label469:
      label477:
      Fabric.getLogger().e("CrashlyticsCore", "Crashlytics was not started due to an exception during initialization", paramContext);
      return false;
    }
    return true;
  }
  
  static void recordFatalExceptionEvent(String paramString)
  {
    Object localObject1 = (Answers)Fabric.getKit(Answers.class);
    if (localObject1 != null)
    {
      paramString = new Crash.FatalException(paramString);
      if (analyticsManager != null)
      {
        localObject1 = analyticsManager;
        Object localObject2 = sessionId;
        if (Looper.myLooper() == Looper.getMainLooper()) {
          throw new IllegalStateException("onCrash called from main thread!!!");
        }
        Fabric.getLogger().d("Answers", "Logged crash");
        paramString = eventsHandler;
        localObject1 = Collections.singletonMap("sessionId", localObject2);
        localObject2 = new SessionEvent.Builder(SessionEvent.Type.CRASH);
        details = ((Map)localObject1);
        paramString.processEvent((SessionEvent.Builder)localObject2, true, false);
      }
    }
  }
  
  static void recordLoggedExceptionEvent(String paramString)
  {
    if ((Answers)Fabric.getKit(Answers.class) != null) {
      new Crash.LoggedException(paramString);
    }
  }
  
  public static String sanitizeAttribute(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      paramString = paramString.trim();
      str = paramString;
      if (paramString.length() > 1024) {
        str = paramString.substring(0, 1024);
      }
    }
    return str;
  }
  
  protected final Void doInBackground()
  {
    executorServiceWrapper.executeSyncLoggingException(new Callable() {});
    Object localObject1 = handler;
    executorServiceWrapper.executeAsync(new CrashlyticsUncaughtExceptionHandler.12((CrashlyticsUncaughtExceptionHandler)localObject1));
    try
    {
      localObject1 = Settings.LazyHolder.access$100().awaitSettingsData();
      if (localObject1 == null)
      {
        Fabric.getLogger().w("CrashlyticsCore", "Received null settings, skipping initialization!");
        return null;
      }
      if (!featuresData.collectReports)
      {
        Fabric.getLogger().d("CrashlyticsCore", "Collection of crash reports disabled in Crashlytics settings.");
        return null;
      }
      CrashlyticsUncaughtExceptionHandler localCrashlyticsUncaughtExceptionHandler = handler;
      ((Boolean)executorServiceWrapper.executeSyncLoggingException(new CrashlyticsUncaughtExceptionHandler.11(localCrashlyticsUncaughtExceptionHandler))).booleanValue();
      localObject1 = getCreateReportSpiCall((SettingsData)localObject1);
      if (localObject1 == null)
      {
        Fabric.getLogger().w("CrashlyticsCore", "Unable to create a call to upload reports.");
        return null;
      }
      new ReportUploader((CreateReportSpiCall)localObject1).uploadReports(delay);
      return null;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Crashlytics encountered a problem during asynchronous initialization.", localException);
      return null;
    }
    finally
    {
      markInitializationComplete();
    }
  }
  
  final CreateReportSpiCall getCreateReportSpiCall(SettingsData paramSettingsData)
  {
    if (paramSettingsData != null) {
      return new DefaultCreateReportSpiCall(this, CommonUtils.getStringsFileValue(context, "com.crashlytics.ApiEndpoint"), appData.reportsUrl, httpRequestFactory);
    }
    return null;
  }
  
  public final String getIdentifier()
  {
    return "com.crashlytics.sdk.android.crashlytics-core";
  }
  
  final File getSdkDirectory()
  {
    if (sdkDir == null) {
      sdkDir = new FileStoreImpl(this).getFilesDir();
    }
    return sdkDir;
  }
  
  public final String getVersion()
  {
    return "2.3.8.97";
  }
  
  protected final boolean onPreExecute()
  {
    return onPreExecute(context);
  }
  
  final boolean shouldPromptUserBeforeSendingCrashReports()
  {
    ((Boolean)Settings.LazyHolder.access$100().withSettings(new Settings.SettingsAccess() {}, Boolean.valueOf(false))).booleanValue();
  }
  
  public static final class Builder
  {
    private float delay = -1.0F;
    private boolean disabled = false;
    private CrashlyticsListener listener;
    private PinningInfoProvider pinningInfoProvider;
    
    public final CrashlyticsCore build()
    {
      if (delay < 0.0F) {
        delay = 1.0F;
      }
      return new CrashlyticsCore(delay, listener, pinningInfoProvider, disabled);
    }
  }
  
  private static final class CrashMarkerCheck
    implements Callable<Boolean>
  {
    private final CrashlyticsFileMarker crashMarker;
    
    public CrashMarkerCheck(CrashlyticsFileMarker paramCrashlyticsFileMarker)
    {
      crashMarker = paramCrashlyticsFileMarker;
    }
  }
  
  private static final class NoOpListener
    implements CrashlyticsListener
  {}
  
  private static final class OptInLatch
  {
    final CountDownLatch latch = new CountDownLatch(1);
    boolean send = false;
    
    final void setOptIn(boolean paramBoolean)
    {
      send = paramBoolean;
      latch.countDown();
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */