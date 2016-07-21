package com.linkedin.android.infra.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.support.multidex.MultiDexApplication;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.view.View;
import com.linkedin.android.artdeco.ArtDeco;
import com.linkedin.android.artdeco.R.attr;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.feed.utils.FeedModule;
import com.linkedin.android.growth.contactsync.ContactSyncAdapter;
import com.linkedin.android.imageloader.LiManagedBitmap;
import com.linkedin.android.imageloader.interfaces.ImageLoaderCache;
import com.linkedin.android.infra.TrackingOverlayService;
import com.linkedin.android.infra.VoyagerShakeDelegate;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.DaggerApplicationComponent;
import com.linkedin.android.infra.components.DaggerApplicationComponent.Builder;
import com.linkedin.android.infra.components.DaggerFragmentComponent;
import com.linkedin.android.infra.components.DaggerFragmentComponent.Builder;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Cache;
import com.linkedin.android.infra.data.FlagshipCacheManager;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.ApplicationLifecycleEvent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.infra.modules.ApplicationModule;
import com.linkedin.android.infra.modules.DataManagerModule;
import com.linkedin.android.infra.modules.FragmentModule;
import com.linkedin.android.infra.modules.UtilModule;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.ConfigurationManager;
import com.linkedin.android.infra.network.ConfigurationManager.1;
import com.linkedin.android.infra.network.PlaceholderImageCache;
import com.linkedin.android.infra.network.VoyagerPerfEKGHttpStack;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.realtime.RealTimeManager;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.liauthlib.common.LiAuthAppInterface;
import com.linkedin.android.liauthlib.network.HttpStack;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.FileLog;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.common.Configuration;
import com.linkedin.android.perftimer.PerfTimer;
import com.linkedin.android.perftimer.RUMBuilder.FOREGROUNDING_MODE;
import com.linkedin.android.perftimer.RUMTiming;
import com.linkedin.android.realtime.interfaces.RealTimeInterface;
import com.linkedin.android.shaky.Shaky;
import com.linkedin.android.tracking.v2.app.TrackingAppInterface;
import com.linkedin.android.tracking.v2.event.MobileApplicationErrorEvent;
import com.linkedin.android.tracking.v2.event.MobileApplicationSessionEvent;
import com.linkedin.android.tracking.v2.network.TrackingNetworkStack;
import com.linkedin.gen.avro2pegasus.events.mobile.ApplicationStateChangeType;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.acra.annotation.ReportsCrashes;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig.Builder;

@ReportsCrashes(formUri="http://www.linkedin.com/lite/crash-track")
public class FlagshipApplication
  extends MultiDexApplication
  implements LiAuthAppInterface, TrackingAppInterface
{
  public static final AtomicBoolean IS_BACKGROUND = new AtomicBoolean(true);
  private static final String TAG = FlagshipApplication.class.getSimpleName();
  public final VoyagerActivityCallbacks activityLifecycleCallbacks = new VoyagerActivityCallbacks(this);
  private ApplicationComponent applicationComponent;
  
  public static FragmentComponent fragmentComponent$2dbaac8a(ActivityComponent paramActivityComponent, Fragment paramFragment)
  {
    paramFragment = new FragmentModule(paramFragment);
    DaggerFragmentComponent.Builder localBuilder = DaggerFragmentComponent.builder();
    if (paramActivityComponent == null) {
      throw new NullPointerException("activityComponent");
    }
    activityComponent = paramActivityComponent;
    fragmentModule = paramFragment;
    if (fragmentModule == null) {
      throw new IllegalStateException("fragmentModule must be set");
    }
    if (activityComponent == null) {
      throw new IllegalStateException("activityComponent must be set");
    }
    return new DaggerFragmentComponent(localBuilder, (byte)0);
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    com.linkedin.messengerlib.shared.MessengerLibInit.hostApplicationId = "com.linkedin.android";
  }
  
  public final ApplicationComponent getAppComponent()
  {
    DaggerApplicationComponent.Builder localBuilder;
    try
    {
      if (applicationComponent != null) {
        break label170;
      }
      ApplicationModule localApplicationModule = new ApplicationModule(this);
      DataManagerModule localDataManagerModule = new DataManagerModule();
      UtilModule localUtilModule = new UtilModule();
      FeedModule localFeedModule = new FeedModule();
      localBuilder = DaggerApplicationComponent.builder();
      applicationModule = localApplicationModule;
      dataManagerModule = localDataManagerModule;
      utilModule = localUtilModule;
      feedModule = localFeedModule;
      if (applicationModule == null) {
        throw new IllegalStateException("applicationModule must be set");
      }
    }
    finally {}
    if (dataManagerModule == null) {
      dataManagerModule = new DataManagerModule();
    }
    if (utilModule == null) {
      utilModule = new UtilModule();
    }
    if (feedModule == null) {
      feedModule = new FeedModule();
    }
    applicationComponent = new DaggerApplicationComponent(localBuilder, (byte)0);
    label170:
    ApplicationComponent localApplicationComponent = applicationComponent;
    return localApplicationComponent;
  }
  
  public final View getCurrentContentView()
  {
    VoyagerActivityCallbacks localVoyagerActivityCallbacks = activityLifecycleCallbacks;
    if (currentActivity != null) {
      return currentActivity.findViewById(16908290);
    }
    return null;
  }
  
  public final HttpStack getHttpStack()
  {
    return getAppComponent().authHttpStack();
  }
  
  public final TrackingNetworkStack getTrackingNetworkStack()
  {
    return getAppComponent().trackingNetworkStack();
  }
  
  public void onCreate()
  {
    boolean bool2 = true;
    super.onCreate();
    Log.e(TAG, "FlagshipApplication#onCreate() called for process id " + Process.myPid());
    registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    Object localObject1 = getAppComponent();
    boolean bool1;
    if ((AppLaunchRateLimiter.shouldLimitAppLaunchNetworkCalls(((ApplicationComponent)localObject1).lixManager(), ((ApplicationComponent)localObject1).flagshipSharedPreferences())) && (((ApplicationComponent)localObject1).memberUtil().loadAndSetMeFromSharedPref())) {
      bool1 = true;
    }
    for (;;)
    {
      Log.d(TAG, "onAuthenticatedAppProcessStarted(): shouldLimitNetworkCalls=" + bool1);
      ((ApplicationComponent)localObject1).flagshipSharedPreferences().getPreferences().edit().putBoolean("addColdLaunchNetworkDoLimit", bool1).commit();
      Object localObject2 = ((ApplicationComponent)localObject1).launchUtils();
      CrashReporter.initCrashReporting(this);
      LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(new LaunchUtils.1((LaunchUtils)localObject2), new IntentFilter("com.linkedin.android.EXTERNAL_SSO_LOGOUT_ACTION"));
      Object localObject3 = getAppComponent().auth();
      com.linkedin.android.datamanager.DataManagerParserFactory.USE_FAST_JSON_PARSER = "enabled".equals(lixManager.getTreatment(Lix.FAST_JSON_PARSER));
      lixManager.addTreatmentListener(Lix.FAST_JSON_PARSER, new LaunchUtils.2((LaunchUtils)localObject2));
      com.linkedin.android.networking.LinkedInNetwork.ENABLE_BROTLI = "enabled".equals(lixManager.getTreatment(Lix.ENABLE_BROTLI));
      lixManager.addTreatmentListener(Lix.ENABLE_BROTLI, new LaunchUtils.3((LaunchUtils)localObject2));
      com.linkedin.android.tracking.v2.network.LiTrackingNetworkStack.SHOULD_GZIP_REQUEST_BODY = "enabled".equals(lixManager.getTreatment(Lix.INFRA_GZIP_TRACKING_REQUEST_BODY));
      lixManager.addTreatmentListener(Lix.INFRA_GZIP_TRACKING_REQUEST_BODY, new LaunchUtils.4((LaunchUtils)localObject2));
      PerfTimer.initialize(this, new VoyagerPerfEKGHttpStack(networkClient, this));
      com.linkedin.android.perftimer.RUMConfig.DO_NOT_SEND_RUM_BEACONS = false;
      RUMHelper.setAppContext(getApplicationContext());
      RUMHelper.setColdLaunchThreshold(lixManager);
      RUMTiming.setProcessId(UUID.randomUUID().toString());
      RUMTiming.setForegroundingMode(RUMBuilder.FOREGROUNDING_MODE.ORGANIC);
      RUMTiming.appStarted();
      Object localObject4 = lixManager;
      bool1 = "show".equals(((LixManager)localObject4).getTreatment(Lix.INFRA_FILE_LOG));
      Log.enableLogging(bool1);
      FileLog.enableFileLogging(this, bool1);
      LiManagedBitmap.setDebugRetainRelease$1385ff();
      ((LixManager)localObject4).addTreatmentListener(Lix.INFRA_FILE_LOG, new LaunchUtils.9(this));
      localObject4 = sharedPreferences;
      LixManager localLixManager = lixManager;
      ContactSyncAdapter.adjustSyncFrequency(this, (FlagshipSharedPreferences)localObject4, localLixManager, (Auth)localObject3);
      localLixManager.addTreatmentListener(Lix.MYNETWORK_CONTACT_SYNC_FREQ, new LaunchUtils.8(this, (FlagshipSharedPreferences)localObject4, localLixManager, (Auth)localObject3));
      if (Build.MANUFACTURER.toLowerCase(Locale.US).contains("samsung")) {}
      try
      {
        Class.forName("android.sec.clipboard.ClipboardUIManager").getDeclaredMethod("getInstance", new Class[] { Context.class }).invoke(null, new Object[] { getApplicationContext() });
        label555:
        int i;
        if (!ArtDeco.shouldFallback())
        {
          localObject3 = new CalligraphyConfig.Builder();
          if (!TextUtils.isEmpty("fonts/SourceSansPro-Regular.ttf"))
          {
            bool1 = bool2;
            isFontSet = bool1;
            fontAssetPath = "fonts/SourceSansPro-Regular.ttf";
            i = R.attr.fontPath;
            if (i == -1) {
              break label905;
            }
            label578:
            attrId = i;
            CalligraphyConfig.initDefault(((CalligraphyConfig.Builder)localObject3).build());
          }
        }
        else
        {
          GhostImageUtils.setLixManager(lixManager);
          localObject3 = configurationManager;
          Log.i(ConfigurationManager.TAG, "Triggering initial Configuration load");
          localObject4 = DataManager.DataStoreFilter.ALL;
          dataManager.submit(Request.get().url(Routes.CONFIGURATION.buildUponRoot().toString()).customHeaders(Tracker.createPageInstanceHeader(tracker.generateBackgroundPageInstance())).builder(Configuration.BUILDER).filter((DataManager.DataStoreFilter)localObject4).listener(new ConfigurationManager.1((ConfigurationManager)localObject3)));
          Shaky.with(this, new VoyagerShakeDelegate(this, lixManager, memberUtil, sharedPreferences));
          executorService.execute(new LaunchUtils.5((LaunchUtils)localObject2, this));
          getAppComponent().webRouter();
          if (!((ApplicationComponent)localObject1).auth().isAuthenticated()) {
            break label910;
          }
          ((LaunchUtils)localObject2).onAuthenticatedAppProcessStarted(this, ((ApplicationComponent)localObject1).lixManager(), false);
        }
        for (;;)
        {
          sendApplicationSessionEvent(ApplicationStateChangeType.APPLICATION_START);
          localObject1 = ((ApplicationComponent)localObject1).flagshipSharedPreferences();
          if (((FlagshipSharedPreferences)localObject1).wasLastExitDueToCrash())
          {
            localObject2 = getAppComponent().flagshipSharedPreferences();
            localObject3 = ((FlagshipSharedPreferences)localObject2).getLastCrashSummary();
            localObject4 = ((FlagshipSharedPreferences)localObject2).getLastCrashDetails();
            new MobileApplicationErrorEvent(getAppComponent().tracker(), com.linkedin.gen.avro2pegasus.events.ApplicationBuildType.PRODUCTION, "Voyager", "0.21.208", (String)localObject3, (String)localObject4).send();
            localObject2 = ((FlagshipSharedPreferences)localObject2).getPreferences().edit();
            ((SharedPreferences.Editor)localObject2).remove("lastCrashSummary");
            ((SharedPreferences.Editor)localObject2).remove("lastCrashDetails");
            ((SharedPreferences.Editor)localObject2).apply();
          }
          ((FlagshipSharedPreferences)localObject1).setCleanExitState(false);
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label555;
          label905:
          i = -1;
          break label578;
          label910:
          bool1 = sharedPreferences.shouldLimitNetworkCalls();
          Log.d(LaunchUtils.TAG, "onGuestAppProcessStarted(): shouldLimitNetworkCalls=" + bool1);
          if (bool1) {
            Log.d(LaunchUtils.TAG, "onGuestAppProcessStarted(): Returning after limiting network calls.");
          } else {
            preAuthLixManager.triggerSync();
          }
        }
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    boolean bool = true;
    super.onTrimMemory(paramInt);
    if ((paramInt >= 20) && (!IS_BACKGROUND.getAndSet(true)))
    {
      getAppComponent().flagshipSharedPreferences().setCleanExitState(true);
      getAppComponent().eventBus();
      Bus.publish(new ApplicationLifecycleEvent(1));
      if (getAppComponent().flagshipSharedPreferences().getBaseUrl().equals("https://www.linkedin.com")) {
        break label279;
      }
    }
    for (;;)
    {
      com.linkedin.android.perftimer.RUMConfig.SEND_RUM_BEACONS_TO_EI = bool;
      Object localObject = getAppComponent().flagshipSharedPreferences();
      long l = System.currentTimeMillis();
      ((FlagshipSharedPreferences)localObject).getPreferences().edit().putLong("appLastBackground", l).apply();
      RUMTiming.sendRUMBeacons(getAppComponent().perfTracker());
      RUMTiming.setForegroundingMode(RUMBuilder.FOREGROUNDING_MODE.ORGANIC);
      RUMTiming.appBackgrounded();
      stopService(new Intent(this, TrackingOverlayService.class));
      sendApplicationSessionEvent(ApplicationStateChangeType.APPLICATION_BACKGROUND);
      getAppComponent().tracker().flushQueue();
      localObject = getAppComponent().realTimeManager();
      if ((realTime != null) && ("enabled".equalsIgnoreCase(lixManager.getTreatment(Lix.INFRA_USE_REAL_TIME_LIB)))) {
        realTime.disconnect();
      }
      localObject = getAppComponent();
      flagshipCacheManagercache.onTrimMemory(paramInt);
      placeholderImageCachecache.evictAll();
      ((ApplicationComponent)localObject).imageLoaderCache().clear();
      CrashReporter.onTrimMemory$13462e();
      return;
      label279:
      bool = false;
    }
  }
  
  final void sendApplicationSessionEvent(ApplicationStateChangeType paramApplicationStateChangeType)
  {
    com.linkedin.gen.avro2pegasus.events.mobile.ApplicationBuildType localApplicationBuildType = com.linkedin.gen.avro2pegasus.events.mobile.ApplicationBuildType.PRODUCTION;
    new MobileApplicationSessionEvent(getAppComponent().tracker(), localApplicationBuildType, "Voyager", "0.21.208", paramApplicationStateChangeType).send();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.FlagshipApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */