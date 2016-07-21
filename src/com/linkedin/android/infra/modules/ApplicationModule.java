package com.linkedin.android.infra.modules;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.linkedin.CrossPromoLib.api.CrossPromoManager;
import com.linkedin.android.axle.rta.RateTheApp;
import com.linkedin.android.datamanager.DataManager;
import com.linkedin.android.deeplink.helper.DeeplinkHelper;
import com.linkedin.android.deeplink.helper.DeferredDeeplinkHelper;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.developer.OAuthNetworkHelper;
import com.linkedin.android.feed.endor.datamodel.transformer.service.TransformerExecutor;
import com.linkedin.android.feed.page.feed.hero.crosspromo.CrossPromoImageLoader;
import com.linkedin.android.growth.abi.AbiAutoSyncManager;
import com.linkedin.android.growth.abi.AbiCacheUtils;
import com.linkedin.android.growth.abi.AbiContactsReader;
import com.linkedin.android.growth.abi.AbiContactsReaderImpl;
import com.linkedin.android.growth.calendar.sync.CalendarSyncManager;
import com.linkedin.android.growth.newtovoyager.NewToVoyagerManager;
import com.linkedin.android.growth.utils.ThirdPartySdkManager;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeCachedLix;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.identity.me.shared.paging.MeDedupProxy;
import com.linkedin.android.imageloader.LiImageDecoder;
import com.linkedin.android.imageloader.LiImageLoader;
import com.linkedin.android.imageloader.LiImageLoaderCache;
import com.linkedin.android.imageloader.interfaces.ImageLoader;
import com.linkedin.android.imageloader.interfaces.ImageLoaderCache;
import com.linkedin.android.imageloader.requests.LiImageLoaderNetworkStack;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.animations.AnimationProxy;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.LaunchUtils;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.gms.GeoLocator;
import com.linkedin.android.infra.lix.AuthenticatedLixManager;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.infra.lix.PreAuthLixManagerImpl;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.ConfigurationManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.ImageLoaderNetworkClient;
import com.linkedin.android.infra.network.ImageQualityManager;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.MediaCenterImpl;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.network.PlaceholderImageCache;
import com.linkedin.android.infra.network.VoyagerPaymentsHttpStack;
import com.linkedin.android.infra.network.VoyagerRequestFactory;
import com.linkedin.android.infra.realtime.RealTimeManager;
import com.linkedin.android.infra.realtime.TopicRegistry;
import com.linkedin.android.infra.shared.CalendarTaskUtil;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Optional;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.tos.LiTermsOfService;
import com.linkedin.android.infra.tos.TermsOfServiceInterface;
import com.linkedin.android.infra.ui.ViewPagerObserver;
import com.linkedin.android.infra.webviewer.LinkedInUrlRequestInterceptor;
import com.linkedin.android.infra.webviewer.SponsoredUpdateUrlInterceptor;
import com.linkedin.android.infra.webviewer.WebRouterNavigationCallbackFactory;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewLoadProxy;
import com.linkedin.android.l2m.badge.Badger;
import com.linkedin.android.l2m.badge.OuterBadge;
import com.linkedin.android.l2m.deeplink.CommTracker;
import com.linkedin.android.l2m.deeplink.CommTrackerImpl;
import com.linkedin.android.l2m.notification.NotificationDisplayUtils;
import com.linkedin.android.l2m.notification.NotificationUtils;
import com.linkedin.android.liauthlib.network.HttpStack;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.messaging.integration.AssetLoaderNetworkClient;
import com.linkedin.android.messaging.integration.FlagshipAssetManager;
import com.linkedin.android.messaging.integration.MessagingDataEventHandler;
import com.linkedin.android.messaging.integration.MessagingTopic;
import com.linkedin.android.network.LiNetworkingHttpStack;
import com.linkedin.android.networking.AbstractNetworkClient;
import com.linkedin.android.networking.cookies.CookieUtil;
import com.linkedin.android.networking.interfaces.InternationalizationApi;
import com.linkedin.android.networking.util.ByteArrayPool;
import com.linkedin.android.paymentslibrary.api.PaymentService;
import com.linkedin.android.paymentslibrary.api.PaymentServiceFactory;
import com.linkedin.android.paymentslibrary.internal.PaymentsServiceImpl;
import com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeEvent;
import com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeSeenReceipt;
import com.linkedin.android.pegasus.gen.voyager.messaging.realtime.RealtimeTypingIndicator;
import com.linkedin.android.perf.commons.device.DeviceClass;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.tracking.v2.network.LiTrackingNetworkStack;
import com.linkedin.android.tracking.v2.network.TrackingServer;
import com.linkedin.android.webrouter.browser.BrowserWebClient;
import com.linkedin.android.webrouter.core.RequestResolver;
import com.linkedin.android.webrouter.core.WebRouter;
import com.linkedin.android.webrouter.core.WebRouter.Builder;
import com.linkedin.android.webrouter.core.interceptors.CustomTabInterceptor;
import com.linkedin.android.webrouter.core.interceptors.DeeplinkInterceptor;
import com.linkedin.android.webrouter.core.interceptors.PreKitKatInterceptor;
import com.linkedin.android.webrouter.customtabs.CustomTabWebClient;
import com.linkedin.android.webrouter.webviewer.WebViewerWebClient;
import com.linkedin.consistency.ConsistencyManager;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Module
public final class ApplicationModule
{
  private final FlagshipApplication application;
  
  public ApplicationModule(FlagshipApplication paramFlagshipApplication)
  {
    application = paramFlagshipApplication;
  }
  
  @Provides
  public final ImageLoader imageLoader(Context paramContext, ImageLoaderNetworkClient paramImageLoaderNetworkClient, ImageLoaderCache paramImageLoaderCache)
  {
    ByteArrayPool localByteArrayPool = new ByteArrayPool();
    return new LiImageLoader(paramContext, new LiImageLoaderNetworkStack(paramImageLoaderNetworkClient), new LiImageDecoder(paramContext, localByteArrayPool), paramImageLoaderCache, localByteArrayPool);
  }
  
  @Provides
  public final ImageLoaderCache imageLoaderCache()
  {
    return new LiImageLoaderCache();
  }
  
  @Provides
  public final InternationalizationApi internationalizationApi(I18NManager paramI18NManager)
  {
    return paramI18NManager;
  }
  
  @Provides
  public final PaymentService paymentService(NetworkClient paramNetworkClient, Context paramContext)
  {
    paramNetworkClient = new VoyagerPaymentsHttpStack(paramNetworkClient, paramContext);
    new PaymentServiceFactory();
    return new PaymentsServiceImpl(paramNetworkClient);
  }
  
  @Provides
  public final PlaceholderImageCache placeholderImageCache()
  {
    return new PlaceholderImageCache();
  }
  
  @Provides
  public final AnimationProxy provideAnimationProxy()
  {
    return new AnimationProxy();
  }
  
  @Provides
  public final FlagshipApplication provideApplication()
  {
    return application;
  }
  
  @Provides
  public final Context provideApplicationContext()
  {
    return application;
  }
  
  @Provides
  public final AssetLoaderNetworkClient provideAssetLoaderNetworkClient(ApplicationComponent paramApplicationComponent, VoyagerRequestFactory paramVoyagerRequestFactory, InternationalizationApi paramInternationalizationApi)
  {
    return new AssetLoaderNetworkClient(paramApplicationComponent, paramVoyagerRequestFactory, paramInternationalizationApi);
  }
  
  @Provides
  public final Auth provideAuth(Context paramContext, FlagshipSharedPreferences paramFlagshipSharedPreferences, I18NManager paramI18NManager)
  {
    return new Auth(paramContext, paramFlagshipSharedPreferences, paramI18NManager);
  }
  
  @Provides
  public final HttpStack provideAuthHttpStack(NetworkClient paramNetworkClient, Context paramContext)
  {
    return new LiNetworkingHttpStack(paramNetworkClient, paramContext);
  }
  
  @Provides
  public final LixManager provideAuthenticatedLixManager(Context paramContext, DataManager paramDataManager, ScheduledExecutorService paramScheduledExecutorService, Tracker paramTracker)
  {
    return new AuthenticatedLixManager(paramContext, paramDataManager, paramScheduledExecutorService, paramTracker);
  }
  
  @Provides
  public final CalendarSyncManager provideCalendarSyncManager(Context paramContext, FlagshipSharedPreferences paramFlagshipSharedPreferences, CalendarTaskUtil paramCalendarTaskUtil)
  {
    return new CalendarSyncManager(paramContext, paramFlagshipSharedPreferences, paramCalendarTaskUtil);
  }
  
  @Provides
  public final CalendarTaskUtil provideCalendarTaskUtil(Context paramContext, FlagshipDataManager paramFlagshipDataManager)
  {
    return new CalendarTaskUtil(paramContext, paramFlagshipDataManager);
  }
  
  @Provides
  public final CommTracker provideCommTracker(Context paramContext, NetworkClient paramNetworkClient, FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    return new CommTrackerImpl(paramContext, paramNetworkClient, paramFlagshipSharedPreferences);
  }
  
  @Provides
  public final ConfigurationManager provideConfigurationManager(FlagshipDataManager paramFlagshipDataManager, ImageQualityManager paramImageQualityManager, Bus paramBus, Tracker paramTracker)
  {
    return new ConfigurationManager(paramFlagshipDataManager, paramImageQualityManager, paramBus, paramTracker);
  }
  
  @Provides
  public final ConsistencyManager provideConsistencyManager()
  {
    return new ConsistencyManager();
  }
  
  @Provides
  public final CookieUtil provideCookieUtil(NetworkClient paramNetworkClient)
  {
    return cookieUtil;
  }
  
  @Provides
  public final CrossPromoManager provideCrossPromoManager(Context paramContext, NetworkClient paramNetworkClient, MediaCenter paramMediaCenter)
  {
    return CrossPromoManager.create(paramContext, paramNetworkClient, new CrossPromoImageLoader(paramMediaCenter));
  }
  
  @Provides
  public final DeeplinkHelper provideDeeplinkHelper(Context paramContext, IntentRegistry paramIntentRegistry, Tracker paramTracker)
  {
    DeeplinkHelper localDeeplinkHelper = DeeplinkHelper.create(paramTracker);
    paramTracker = new HomeBundle();
    activeTab = HomeTabInfo.FEED;
    HomeBundleactiveTab = HomeTabInfo.NOTIFICATIONS;
    Object localObject3 = new HomeBundle();
    activeTab = HomeTabInfo.MESSAGING;
    Object localObject1 = new HomeBundle();
    activeTab = HomeTabInfo.RELATIONSHIPS;
    Object localObject2 = new HomeBundle();
    activeTab = HomeTabInfo.ME;
    paramTracker = new ArrayList(Collections.singletonList(home.newIntent(paramContext, paramTracker)));
    localObject2 = new ArrayList(Collections.singletonList(home.newIntent(paramContext, (BundleBuilder)localObject2)));
    localObject3 = new ArrayList(Collections.singletonList(home.newIntent(paramContext, (BundleBuilder)localObject3)));
    localObject1 = new ArrayList(Collections.singletonList(home.newIntent(paramContext, (BundleBuilder)localObject1)));
    if ("enabled".equals(Util.getAppComponent(paramContext).lixManager().getTreatment(Lix.GROWTH_REDIRECT_HEATHROW_DEEPLINK_TO_FEED))) {}
    for (paramContext = paramTracker;; paramContext = (Context)localObject1)
    {
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.HOME, home);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.SHARE, share, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.CONTACTS, profileView);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PROFILE, profileView, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_PROFILE, profileView, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.LOGIN, login);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.ONBOARDING_EMAIL, onboarding);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_ONBOARDING_EMAIL, onboarding);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.ONBOARDING_WELCOME, onboarding);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.ONBOARDING, onboarding);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.BOOST_PROMO, boostIntent);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PROFILE_PENDING_ENDORSEMENTS, pendingEndorsements, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PUBLIC_PROFILE, profileView);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_PUBLIC_PROFILE, profileView);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.SAME_NAME_DIRECTORY_PAGE, sameNameDirectoryIntent);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.SAME_NAME_DIRECTORY_PAGE_REGION, sameNameDirectoryIntent);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.SAME_NAME_DIRECTORY_PAGE_PARAMETER, sameNameDirectoryIntent);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PROFILE_EDIT, profileEditDeeplink, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_PROFILE_EDIT, profileEditDeeplink, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PROFILE_EDIT_SKILLS, profileEditDeeplink, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PROFILE_GUIDED_EDIT, guidedEdit, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PROFILE_GUIDED_EDIT_ADD_CURRENT_POSITION, guidedEdit, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PROFILE_GUIDED_EDIT_ADD_EDUCATION, guidedEdit, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PROFILE_GUIDED_EDIT_ADD_SUGGESTED_SKILLS, guidedEdit, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMPANY, company, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.SCHOOL, school, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.JOB, job, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.JOB_PUBLIC, job, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.JOB_PUBLIC_NEW, job, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.JOB_COMM, job, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.JOB_COMM_NEW, job, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.JYMBII, jymbii, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.JYMBII_PUBLIC, jymbii);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.JYMBII_COMM, jymbii, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.JSERP, search, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.M_GROUP, group, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.GROUPS, group, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.M_GROUP_DISCUSSION, groupDiscussion, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.GROUPS_DISCUSSION, groupDiscussion, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_GROUPS, group, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_GROUPS_DISCUSSION, groupDiscussion, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.SHARE, share, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.UPDATE, feedUpdateDetail, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.UPDATE_LIKES, likesDetailViewer, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.UPDATE_RESHARE, share, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.UPDATE_RMVIEW, imageViewer, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.RBMF, rebuildMyFeedIntent, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.NHOME, home);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.HP, home);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.HP_UPDATE, feedUpdateDetail, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.NHOME_UPDATES, feedUpdateDetail, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.CONNECTED, connected);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.CONNECTED_PROP, connected, (ArrayList)localObject1);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.CONNECTED_INVITE_INVITATIONS, invitations, (ArrayList)localObject1);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.CONNECTED_INVITE_INVITATIONS_PENDING, invitations, (ArrayList)localObject1);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.CONNECTED_INVITE_CONNECTIONS, connections, (ArrayList)localObject1);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.INVITE_ACCEPT, inviteAccept, paramContext);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.ACCECPTED_INVIATION, acceptedInvitation, paramContext);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_INVITE_ACCEPT, inviteAccept, paramContext);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_PEOPLE_SEND_INVITE, sendInvite, paramContext);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PEOPLE_SEND_INVITE, sendInvite, paramContext);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_PEOPLE_PYMK_HUB, invitations, (ArrayList)localObject1);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_PEOPLE_PYMK, invitations, (ArrayList)localObject1);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.MY_NETWORK_ADD_CONNECTIONS, addConnectionsIntent, (ArrayList)localObject1);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.REG_IMPORTED_CONTACTS, wylo, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.FETCH_IMPORTED_CONTACTS, wylo, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.ME, home);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.ME_PROFILE, meWvmp, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.WVMX_PROFILE, meWvmp, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_WVMX_PROFILE, meWvmp, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.MESSAGING, home);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.MESSAGING_CONVERSATION, messageListIntent, (ArrayList)localObject3);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.MESSAGING_COMPOSE, composeIntent, (ArrayList)localObject3);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.MESSAGING_COMPOSE_RECIPIENT, composeIntent, (ArrayList)localObject3);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.MESSAGING_COMPOSE_RECIPIENT_BODY, composeIntent, (ArrayList)localObject3);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_MESSAGING_CONVERSATION, messageListIntent, (ArrayList)localObject3);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_MESSAGING_COMPOSE, composeIntent, (ArrayList)localObject3);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_MESSAGING_COMPOSE_RECIPIENT, composeIntent, (ArrayList)localObject3);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_MESSAGING_COMPOSE_RECIPIENT_BODY, composeIntent, (ArrayList)localObject3);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.SETTINGS, settings, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.SETTINGS_MESSAGES, settings, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.SETTINGS_PRIVACY, settings, (ArrayList)localObject2);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PREMIUM_CHOOSER, chooser, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PULSE_ARTICLE, articleDeepLink, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PULSE_CED, articleDeepLink, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.NEWSLE, articleDeepLink, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.EXTERNAL_REDIRECT, articleDeepLink, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_EXTERNAL_REDIRECT, articleDeepLink, paramTracker);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.COMM_PYMK_PCARD, pymk);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.LAUNCHER_FLAGSHIP, home);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.TITAN_LIHOME, home);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PROFINDER_PROJECTS, profinderServiceProposalActivityIntent);
      localDeeplinkHelper.registerDeeplinkIntent(LinkingRoutes.PROFINDER_PROJECTS_PROPOSAL, profinderServiceProposalActivityIntent);
      return localDeeplinkHelper;
    }
  }
  
  @Provides
  public final DeferredDeeplinkHelper provideDeferredDeeplinkHelper(Context paramContext)
  {
    return DeferredDeeplinkHelper.create(paramContext);
  }
  
  @Provides
  public final int provideDeviceClass(Context paramContext)
  {
    return DeviceClass.get(paramContext);
  }
  
  @Provides
  public final ExecutorService provideExecutorService()
  {
    return Executors.newFixedThreadPool(4);
  }
  
  @Provides
  public final FlagshipAssetManager provideFlagshipAssetManager()
  {
    return new FlagshipAssetManager(application);
  }
  
  @Provides
  public final GeoLocator provideGeoLocator()
  {
    return new GeoLocator(application);
  }
  
  @Provides
  public final ImageLoaderNetworkClient provideImageLoaderNetworkClient(ApplicationComponent paramApplicationComponent, VoyagerRequestFactory paramVoyagerRequestFactory, InternationalizationApi paramInternationalizationApi)
  {
    return new ImageLoaderNetworkClient(paramApplicationComponent, paramVoyagerRequestFactory, paramInternationalizationApi);
  }
  
  @Provides
  public final LaunchUtils provideLaunchUtils(LixManager paramLixManager, NetworkClient paramNetworkClient, ExecutorService paramExecutorService, ConfigurationManager paramConfigurationManager, NotificationUtils paramNotificationUtils, MemberUtil paramMemberUtil, NewToVoyagerManager paramNewToVoyagerManager, FlagshipSharedPreferences paramFlagshipSharedPreferences, PreAuthLixManager paramPreAuthLixManager, AbiAutoSyncManager paramAbiAutoSyncManager, DeferredDeeplinkHelper paramDeferredDeeplinkHelper, OuterBadge paramOuterBadge, CalendarSyncManager paramCalendarSyncManager, AbiCacheUtils paramAbiCacheUtils)
  {
    return new LaunchUtils(paramLixManager, paramNetworkClient, paramExecutorService, paramConfigurationManager, paramNotificationUtils, paramMemberUtil, paramNewToVoyagerManager, paramFlagshipSharedPreferences, paramPreAuthLixManager, paramAbiAutoSyncManager, paramDeferredDeeplinkHelper, paramOuterBadge, paramCalendarSyncManager, paramAbiCacheUtils);
  }
  
  @Provides
  public final Handler provideMainHandler()
  {
    return new Handler(Looper.getMainLooper());
  }
  
  @Provides
  public final MeDedupProxy provideMeDedupProxy()
  {
    return new MeDedupProxy();
  }
  
  @Provides
  public final MediaCenter provideMediaCenter(Context paramContext, ImageLoader paramImageLoader, ImageQualityManager paramImageQualityManager, PlaceholderImageCache paramPlaceholderImageCache)
  {
    return new MediaCenterImpl(paramContext, paramImageLoader, paramImageQualityManager, paramPlaceholderImageCache);
  }
  
  @Provides
  public final NetworkClient provideNetworkClient(ApplicationComponent paramApplicationComponent, VoyagerRequestFactory paramVoyagerRequestFactory, InternationalizationApi paramInternationalizationApi)
  {
    return new NetworkClient(paramApplicationComponent, paramVoyagerRequestFactory, paramInternationalizationApi);
  }
  
  @Provides
  public final NewToVoyagerManager provideNewToVoyagerManager(FlagshipDataManager paramFlagshipDataManager, FlagshipSharedPreferences paramFlagshipSharedPreferences, Tracker paramTracker)
  {
    return new NewToVoyagerManager(paramFlagshipDataManager, paramFlagshipSharedPreferences, paramTracker);
  }
  
  @Provides
  public final NotificationDisplayUtils provideNotificationDisplayUtils(Context paramContext)
  {
    return new NotificationDisplayUtils(paramContext);
  }
  
  @Provides
  public final OAuthNetworkHelper provideOAuthNetworkHelper(Context paramContext, NetworkClient paramNetworkClient, FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    return new OAuthNetworkHelper(paramContext, paramNetworkClient, paramFlagshipSharedPreferences);
  }
  
  @Provides
  public final PreAuthLixManager providePreAuthLixManager(Context paramContext, DataManager paramDataManager, ScheduledExecutorService paramScheduledExecutorService, Tracker paramTracker)
  {
    return new PreAuthLixManagerImpl(paramContext, paramDataManager, paramScheduledExecutorService, paramTracker);
  }
  
  @Provides
  public final RateTheApp provideRateTheApp()
  {
    return new RateTheApp();
  }
  
  @Provides
  public final RealTimeManager provideRealTimeManager(Tracker paramTracker, LixManager paramLixManager, NetworkClient paramNetworkClient, Context paramContext, TopicRegistry paramTopicRegistry)
  {
    return new RealTimeManager(paramTracker, paramLixManager, paramNetworkClient, paramContext, paramTopicRegistry);
  }
  
  @Provides
  public final Optional<RefWatcher> provideRefWatcher()
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return Optional.empty();
    }
    return Optional.of(LeakCanary.install(application));
  }
  
  @Provides
  public final ScheduledExecutorService provideScheduledExecutorService()
  {
    return Executors.newScheduledThreadPool(4);
  }
  
  @Provides
  public final SearchUtils provideSearchUtils(IntentRegistry paramIntentRegistry)
  {
    return new SearchUtils(paramIntentRegistry);
  }
  
  @Provides
  public final TransformerExecutor provideSynchronousBackgroundQueue()
  {
    return new TransformerExecutor();
  }
  
  @Provides
  public final TermsOfServiceInterface provideTermsOfService()
  {
    return new LiTermsOfService();
  }
  
  @Provides
  public final ThirdPartySdkManager provideThirdPartySdkManager()
  {
    return new ThirdPartySdkManager();
  }
  
  @Provides
  public final Tracker provideTracker(FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    FlagshipApplication localFlagshipApplication = application;
    if (paramFlagshipSharedPreferences.getBaseUrl().equals("https://www.linkedin.com")) {}
    for (paramFlagshipSharedPreferences = TrackingServer.Production;; paramFlagshipSharedPreferences = TrackingServer.EI)
    {
      paramFlagshipSharedPreferences = new Tracker(localFlagshipApplication, "", "p_flagship3", paramFlagshipSharedPreferences, (byte)0);
      appId = "com.linkedin.flagship3.p_android";
      artifactoryVersion = "0.21.208";
      return paramFlagshipSharedPreferences;
    }
  }
  
  @Provides
  public final LiTrackingNetworkStack provideTrackingNetworkStack(Context paramContext, ApplicationComponent paramApplicationComponent, VoyagerRequestFactory paramVoyagerRequestFactory, InternationalizationApi paramInternationalizationApi)
  {
    return new LiTrackingNetworkStack(paramContext, new NetworkClient(paramApplicationComponent, paramVoyagerRequestFactory, paramInternationalizationApi));
  }
  
  @Provides
  public final ViewPagerObserver provideViewPagerObserver()
  {
    return new ViewPagerObserver();
  }
  
  @Provides
  public final VoyagerRequestFactory provideVoyagerRequestFactory(FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    return new VoyagerRequestFactory(paramFlagshipSharedPreferences.getBaseUrl());
  }
  
  @Provides
  public final WebRouter provideWebRouter(Context paramContext)
  {
    WebRouter.Builder localBuilder = new WebRouter.Builder(paramContext);
    localBuilder.registerWebClient(new BrowserWebClient());
    localBuilder.registerWebClient(new WebViewerWebClient());
    localBuilder.registerWebClient(new CustomTabWebClient());
    localBuilder.addRequestInterceptor(new DeeplinkInterceptor());
    localBuilder.addRequestInterceptor(new CustomTabInterceptor());
    localBuilder.addRequestInterceptor(new PreKitKatInterceptor());
    localBuilder = localBuilder.addRequestInterceptor(new LinkedInUrlRequestInterceptor()).addRequestInterceptor(new SponsoredUpdateUrlInterceptor());
    factory = new WebRouterNavigationCallbackFactory(paramContext);
    paramContext = new RequestResolver(webClients, requestInterceptors);
    paramContext = new WebRouter(app, paramContext, customTabSessionGetter, factory, (byte)0);
    WebRouter.access$202(paramContext);
    return paramContext;
  }
  
  @Provides
  public final WebRouterUtil provideWebRouterUtil()
  {
    return new WebRouterUtil();
  }
  
  @Provides
  public final WebViewLoadProxy provideWebViewLoadProxy()
  {
    return new WebViewLoadProxy();
  }
  
  @Provides
  public final Tracker providerPerfTracker()
  {
    Tracker localTracker = new Tracker(application, "", "p_flagship3", TrackingServer.Production, (byte)0);
    appId = "com.linkedin.android.Voyager";
    return localTracker;
  }
  
  @Provides
  public final AbiContactsReader providesAbiContactsReader(Context paramContext, FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    return new AbiContactsReaderImpl(paramContext, paramFlagshipSharedPreferences);
  }
  
  @Provides
  public final Badger providesBadger(FlagshipDataManager paramFlagshipDataManager, LixManager paramLixManager, HomeCachedLix paramHomeCachedLix, Bus paramBus, FlagshipSharedPreferences paramFlagshipSharedPreferences, Context paramContext, Tracker paramTracker)
  {
    return new Badger(paramFlagshipDataManager, paramLixManager, paramHomeCachedLix, paramBus, paramFlagshipSharedPreferences, paramContext, paramTracker);
  }
  
  @Provides
  public final HomeCachedLix providesHomeCachedLix(LixManager paramLixManager, FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    return new HomeCachedLix(paramLixManager, paramFlagshipSharedPreferences);
  }
  
  @Provides
  public final TopicRegistry topicRegistry(MessagingDataEventHandler paramMessagingDataEventHandler)
  {
    return new TopicRegistry(new MessagingTopic(MessagingTopic.MESSAGING_EVENT_TOPIC_URN, RealtimeEvent.BUILDER, Lix.MESSAGING_ENABLE_REALTIME_MESSAGE_EVENTS, paramMessagingDataEventHandler), new MessagingTopic(MessagingTopic.SEEN_RECEIPTS_TOPIC_URN, RealtimeSeenReceipt.BUILDER, Lix.MESSAGING_ENABLE_REALTIME_SEEN_RECEIPTS, paramMessagingDataEventHandler), new MessagingTopic(MessagingTopic.TYPING_INDICATORS_TOPIC_URN, RealtimeTypingIndicator.BUILDER, Lix.MESSAGING_ENABLE_REALTIME_TYPING_INDICATORS, paramMessagingDataEventHandler));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.modules.ApplicationModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */