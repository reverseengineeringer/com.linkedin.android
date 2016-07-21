package com.linkedin.android.infra.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.axle.InstallReferrerReceiver;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.deeplink.helper.DeferredDeeplinkHelper;
import com.linkedin.android.feed.endor.datamodel.transformer.service.TransformerExecutor;
import com.linkedin.android.feed.endor.datamodel.transformer.service.TransformerExecutor.1;
import com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesManager;
import com.linkedin.android.growth.abi.AbiAutoSyncManager;
import com.linkedin.android.growth.abi.AbiCacheUtils;
import com.linkedin.android.growth.abi.AbiCacheUtils.1;
import com.linkedin.android.growth.calendar.sync.CalendarSyncManager;
import com.linkedin.android.growth.contactsync.ContactSyncAdapter;
import com.linkedin.android.growth.newtovoyager.NewToVoyagerManager;
import com.linkedin.android.growth.newtovoyager.NewToVoyagerManager.1;
import com.linkedin.android.growth.utils.GrowthLixHelper;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixDefinition;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.lix.LixManager.TreatmentListener;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.ConfigurationManager;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.realtime.RealTimeManager;
import com.linkedin.android.infra.realtime.RealtimeTopic;
import com.linkedin.android.infra.realtime.TopicRegistry;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.l2m.badge.OuterBadge;
import com.linkedin.android.l2m.notification.NotificationUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.FileLog;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.realtime.RealTimeConfiguration;
import com.linkedin.android.realtime.RealTimeConfiguration.Builder;
import com.linkedin.android.realtime.RealTimeConfiguration.DefaultBackoffImpl;
import com.linkedin.android.realtime.impls.RealTimeLongPollImpl;
import com.linkedin.android.realtime.interfaces.RealTimeInterface;
import com.linkedin.android.realtime.interfaces.SubscriberInterface;
import com.linkedin.data.lite.DataTemplateBuilder;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class LaunchUtils
{
  private static final long ADVERTISER_ID_SYNC_INTERVAL_ON_FAILURE = TimeUnit.HOURS.toMillis(5L);
  private static final long ADVERTISER_ID_SYNC_INTERVAL_ON_SUCCESS = TimeUnit.DAYS.toMillis(3L);
  static final String TAG = LaunchUtils.class.getSimpleName();
  private final AbiAutoSyncManager abiAutoSyncManager;
  private final AbiCacheUtils abiCacheUtils;
  private final CalendarSyncManager calendarSyncManager;
  final ConfigurationManager configurationManager;
  private final DeferredDeeplinkHelper deferredDeeplinkHelper;
  final ExecutorService executorService;
  final LixManager lixManager;
  final MemberUtil memberUtil;
  final NetworkClient networkClient;
  private final NewToVoyagerManager newToVoyagerManager;
  private final NotificationUtils notificationUtils;
  private final OuterBadge outerBadge;
  final PreAuthLixManager preAuthLixManager;
  final FlagshipSharedPreferences sharedPreferences;
  
  public LaunchUtils(LixManager paramLixManager, NetworkClient paramNetworkClient, ExecutorService paramExecutorService, ConfigurationManager paramConfigurationManager, NotificationUtils paramNotificationUtils, MemberUtil paramMemberUtil, NewToVoyagerManager paramNewToVoyagerManager, FlagshipSharedPreferences paramFlagshipSharedPreferences, PreAuthLixManager paramPreAuthLixManager, AbiAutoSyncManager paramAbiAutoSyncManager, DeferredDeeplinkHelper paramDeferredDeeplinkHelper, OuterBadge paramOuterBadge, CalendarSyncManager paramCalendarSyncManager, AbiCacheUtils paramAbiCacheUtils)
  {
    lixManager = paramLixManager;
    networkClient = paramNetworkClient;
    executorService = paramExecutorService;
    configurationManager = paramConfigurationManager;
    notificationUtils = paramNotificationUtils;
    memberUtil = paramMemberUtil;
    newToVoyagerManager = paramNewToVoyagerManager;
    sharedPreferences = paramFlagshipSharedPreferences;
    preAuthLixManager = paramPreAuthLixManager;
    abiAutoSyncManager = paramAbiAutoSyncManager;
    deferredDeeplinkHelper = paramDeferredDeeplinkHelper;
    outerBadge = paramOuterBadge;
    calendarSyncManager = paramCalendarSyncManager;
    abiCacheUtils = paramAbiCacheUtils;
  }
  
  public final void onAppEnteredForeground(FlagshipApplication paramFlagshipApplication, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    preAuthLixManager.triggerSync();
    if (paramBoolean1)
    {
      lixManager.triggerSync();
      abiAutoSyncManager.doAbiAutoSync(paramFlagshipApplication);
      Object localObject1 = calendarSyncManager;
      if ((flagshipSharedPreferences.getCalendarSyncEnabled()) && (!PermissionRequester.hasPermission(paramFlagshipApplication, "android.permission.READ_CALENDAR"))) {
        ((CalendarSyncManager)localObject1).disableCalendarSync();
      }
      localObject1 = paramFlagshipApplication.getAppComponent();
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if ("enabled".equalsIgnoreCase(lixManager.getTreatment(Lix.GROWTH_ABI_INSTANT_RESULTS)))
      {
        localObject2 = abiCacheUtils;
        i = GrowthLixHelper.parseInt(lixManager, Lix.GROWTH_ABI_PAST_IMPORTED_CONTACTS_LEGO_CACHE_EXPIRATION_HOURS, 24, "value_");
        long l = flagshipSharedPreferences.getPreferences().getLong("abi_past_imported_contacts_lego_cache_updated_timestamp", 0L);
        if (System.currentTimeMillis() - l >= TimeUnit.HOURS.toMillis(i))
        {
          localObject3 = DataManager.DataStoreFilter.NETWORK_ONLY;
          localObject4 = new AbiCacheUtils.1((AbiCacheUtils)localObject2);
          localObject3 = Request.get().url(Routes.ABI_PAST_IMPORTED_CONTACTS_FLOW.buildUponRoot().buildUpon().toString()).builder(PageContent.BUILDER).listener((RecordTemplateListener)localObject4).customHeaders(Tracker.createPageInstanceHeader(tracker.generateBackgroundPageInstance())).filter((DataManager.DataStoreFilter)localObject3);
          dataManager.submit((Request.Builder)localObject3);
        }
      }
      if (paramBoolean2)
      {
        NewUpdatesManager.initializeNewUpdatesChecking(paramFlagshipApplication);
        ((ApplicationComponent)localObject1).followPublisher();
        ((ApplicationComponent)localObject1).likePublisher();
        paramFlagshipApplication = ((ApplicationComponent)localObject1).transformerExecutor();
        if (paramFlagshipApplication.getTaskCount() <= 0L) {
          paramFlagshipApplication.execute(new TransformerExecutor.1(paramFlagshipApplication));
        }
      }
      paramFlagshipApplication = sharedPreferences.getNewToVoyagerLegoTrackingToken();
      if ((paramFlagshipApplication == null) || (paramFlagshipApplication.length() > 0)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          paramFlagshipApplication = newToVoyagerManager;
          dataManager.submit(Request.get().url(Routes.NEW_TO_VOYAGER.buildUponRoot().toString()).builder(PageContent.BUILDER).listener(new NewToVoyagerManager.1(paramFlagshipApplication)).customHeaders(Tracker.createPageInstanceHeader(tracker.generateBackgroundPageInstance())).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
        }
        paramFlagshipApplication = ((ApplicationComponent)localObject1).realTimeManager();
        if (!"enabled".equalsIgnoreCase(lixManager.getTreatment(Lix.INFRA_USE_REAL_TIME_LIB))) {
          break;
        }
        if (realTime == null)
        {
          localObject1 = new RealTimeConfiguration.Builder();
          applicationContext = context;
          networkClient = networkClient;
          if (backoffInterface == null) {
            backoffInterface = new RealTimeConfiguration.DefaultBackoffImpl((byte)0);
          }
          realTime = new RealTimeLongPollImpl(new RealTimeConfiguration(customURI, applicationContext, networkClient, backoffInterface, maxRetries, longPollTimeoutSeconds, shouldParseUnknownTopicPayloadsAsJson, (byte)0));
        }
        realTime.setCallbackInterface(realTimeCallbackInterface);
        realTime.connect();
        localObject1 = topicRegistry.topics;
        i = j;
        while (i < ((List)localObject1).size())
        {
          Object localObject5 = (RealtimeTopic)((List)localObject1).get(i);
          localObject2 = topicUrn;
          localObject3 = builder;
          localObject4 = dataEventHandler;
          localObject5 = lix;
          if ((realTime != null) && ("enabled".equalsIgnoreCase(lixManager.getTreatment(Lix.INFRA_USE_REAL_TIME_LIB))) && ("enabled".equalsIgnoreCase(lixManager.getTreatment((LixDefinition)localObject5)))) {
            realTime.subscribe((Urn)localObject2, (DataTemplateBuilder)localObject3, (SubscriberInterface)localObject4);
          }
          i += 1;
        }
      }
    }
  }
  
  public final void onAuthenticatedAppProcessStarted(Context paramContext, LixManager paramLixManager, boolean paramBoolean)
  {
    boolean bool;
    if ((!paramBoolean) && (sharedPreferences.shouldLimitNetworkCalls()))
    {
      bool = true;
      Log.d(TAG, "onAuthenticatedAppProcessStarted(): shouldLimitNetworkCalls=" + bool);
      if (!bool) {
        break label64;
      }
      Log.d(TAG, "onAuthenticatedAppProcessStarted(): Returning after limiting network calls.");
    }
    label64:
    do
    {
      return;
      bool = false;
      break;
      preAuthLixManager.triggerSync(paramBoolean);
      paramLixManager.triggerSync(paramBoolean);
      memberUtil.loadMe();
      NotificationUtils.registerNotification(paramContext);
      InstallReferrerReceiver.trackSignedIn(paramContext);
      if (sharedPreferences.getCalendarSyncEnabled())
      {
        calendarSyncManager.doCalendarSync(paramContext);
        lixManager.addTreatmentListener(Lix.MYNETWORK_CALENDAR_WAKEUP, new LaunchUtils.7(this, paramContext));
      }
    } while (!"enabled".equals(paramLixManager.getTreatment(Lix.AXLE_DEFERRED_DEEPLINKING)));
    deferredDeeplinkHelper.doBindService(new LaunchUtils.6(this, paramContext));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.LaunchUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */