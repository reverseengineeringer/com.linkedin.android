package com.linkedin.android.infra.components;

import android.content.Context;
import android.os.Handler;
import com.linkedin.CrossPromoLib.api.CrossPromoManager;
import com.linkedin.android.appwidget.AppWidgetKeyValueStore;
import com.linkedin.android.axle.rta.RateTheApp;
import com.linkedin.android.deeplink.helper.DeeplinkHelper;
import com.linkedin.android.developer.OAuthNetworkHelper;
import com.linkedin.android.feed.endor.datamodel.transformer.service.TransformerExecutor;
import com.linkedin.android.feed.page.feed.newupdatespill.CheckForNewUpdatesRunnable;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.feed.shared.liking.LikePublisher;
import com.linkedin.android.feed.tracking.SponsoredUpdateTracker;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher;
import com.linkedin.android.feed.utils.FeedKeyValueStore;
import com.linkedin.android.feed.utils.FeedModule;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.growth.abi.AbiAutoSyncManager;
import com.linkedin.android.growth.abi.AbiCacheUtils;
import com.linkedin.android.growth.abi.AbiContactsReader;
import com.linkedin.android.growth.calendar.sync.CalendarSyncManager;
import com.linkedin.android.growth.utils.ProgressBarUtil;
import com.linkedin.android.growth.utils.ThirdPartySdkManager;
import com.linkedin.android.home.HomeCachedLix;
import com.linkedin.android.identity.me.shared.paging.MeDedupProxy;
import com.linkedin.android.identity.me.shared.util.ViewPagerManager;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.imageloader.interfaces.ImageLoader;
import com.linkedin.android.imageloader.interfaces.ImageLoaderCache;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.animations.AnimationProxy;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.LaunchUtils;
import com.linkedin.android.infra.app.NavigationManager;
import com.linkedin.android.infra.data.FlagshipCacheManager;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.TitanDataMigrationManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.gms.GeoLocator;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.infra.mediaupload.MediaUploader;
import com.linkedin.android.infra.modules.ApplicationModule;
import com.linkedin.android.infra.modules.DataManagerModule;
import com.linkedin.android.infra.modules.UtilModule;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.ConfigurationManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.ImageQualityManager;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.network.PlaceholderImageCache;
import com.linkedin.android.infra.realtime.RealTimeManager;
import com.linkedin.android.infra.semaphore.ReportEntityInvokerHelper;
import com.linkedin.android.infra.shared.AppUpgradeUtils;
import com.linkedin.android.infra.shared.CalendarTaskUtil;
import com.linkedin.android.infra.shared.InternetConnectionMonitor;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Optional;
import com.linkedin.android.infra.shared.PhotoUtils;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.TimeWrapper;
import com.linkedin.android.infra.tos.TermsOfServiceInterface;
import com.linkedin.android.infra.ui.ViewPagerObserver;
import com.linkedin.android.infra.ui.cardtoast.CardToastManager;
import com.linkedin.android.infra.viewport.ViewportTrackingConfiguration;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewLoadProxy;
import com.linkedin.android.l2m.badge.Badger;
import com.linkedin.android.l2m.deeplink.CommTracker;
import com.linkedin.android.l2m.deeplink.DeepLinkManager;
import com.linkedin.android.l2m.notification.NotificationDisplayUtils;
import com.linkedin.android.l2m.notification.NotificationUtils;
import com.linkedin.android.liauthlib.network.HttpStack;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.messaging.integration.AssetLoaderNetworkClient;
import com.linkedin.android.messaging.integration.FlagshipAssetManager;
import com.linkedin.android.networking.cookies.CookieUtil;
import com.linkedin.android.paymentslibrary.api.PaymentService;
import com.linkedin.android.publishing.sharing.compose.FeedSharePublisher;
import com.linkedin.android.publishing.sharing.compose.GroupSharePublisher;
import com.linkedin.android.relationships.connections.ConnectionStore;
import com.linkedin.android.relationships.connections.ConnectionsFetchingManager;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.tracking.v2.network.LiTrackingNetworkStack;
import com.linkedin.android.webrouter.core.WebRouter;
import com.linkedin.consistency.ConsistencyManager;
import com.squareup.leakcanary.RefWatcher;
import dagger.Component;
import java.util.concurrent.ExecutorService;

@Component(modules={ApplicationModule.class, DataManagerModule.class, UtilModule.class, FeedModule.class})
public abstract interface ApplicationComponent
{
  public abstract AbiAutoSyncManager abiAutoSyncManager();
  
  public abstract AbiCacheUtils abiCacheUtils();
  
  public abstract AbiContactsReader abiContactsReader();
  
  public abstract AnimationProxy animationProxy();
  
  public abstract FlagshipApplication app();
  
  public abstract Context appContext();
  
  public abstract AppUpgradeUtils appUpgradeUtils();
  
  public abstract AppWidgetKeyValueStore appwidgetValues();
  
  public abstract AssetLoaderNetworkClient assetLoaderNetworkClient();
  
  public abstract Auth auth();
  
  public abstract HttpStack authHttpStack();
  
  public abstract Badger badger();
  
  public abstract CalendarSyncManager calendarSyncManager();
  
  public abstract CalendarTaskUtil calendarTaskUtil();
  
  public abstract CardToastManager cardToastManager();
  
  public abstract CommTracker commTracker();
  
  public abstract CommentPublisher commentPublisher();
  
  public abstract ConfigurationManager configurationManager();
  
  public abstract ConnectionStore connectionStore();
  
  public abstract ConnectionsFetchingManager connectionsFetchingManager();
  
  public abstract ConsistencyManager consistencyManager();
  
  public abstract CookieUtil cookieUtil();
  
  public abstract CrossPromoManager crossPromoManager();
  
  public abstract FlagshipDataManager dataManager();
  
  public abstract DeepLinkManager deepLinkManager();
  
  public abstract DelayedExecution delayedExecution();
  
  public abstract int deviceClass();
  
  public abstract Bus eventBus();
  
  public abstract ExecutorService executorService();
  
  public abstract FeedKeyValueStore feedValues();
  
  public abstract FlagshipAssetManager flagshipAssetManager();
  
  public abstract FlagshipCacheManager flagshipCacheManager();
  
  public abstract FlagshipSharedPreferences flagshipSharedPreferences();
  
  public abstract FollowPublisher followPublisher();
  
  public abstract FragmentRegistry fragmentRegistry();
  
  public abstract GeoLocator geoLocator();
  
  public abstract GroupSharePublisher groupsSharePublisher();
  
  public abstract HomeCachedLix homeCachedLix();
  
  public abstract I18NManager i18NManager();
  
  public abstract ImageLoader imageLoader();
  
  public abstract ImageLoaderCache imageLoaderCache();
  
  public abstract ImageQualityManager imageQualityManager();
  
  public abstract IntentRegistry intentRegistry();
  
  public abstract InternetConnectionMonitor internetConnectionMonitor();
  
  public abstract LaunchUtils launchUtils();
  
  public abstract LikePublisher likePublisher();
  
  public abstract LixManager lixManager();
  
  public abstract com.linkedin.android.infra.shared.LongClickUtil longClickUtil();
  
  public abstract Handler mainHandler();
  
  public abstract MeDedupProxy meDedupProxy();
  
  public abstract MediaCenter mediaCenter();
  
  public abstract MediaUploader mediaUploader();
  
  public abstract MemberUtil memberUtil();
  
  public abstract com.linkedin.messengerlib.utils.LongClickUtil messengerLongClickUtil();
  
  public abstract NavigationManager navigationManager();
  
  public abstract NetworkClient networkClient();
  
  public abstract CheckForNewUpdatesRunnable newUpdatesChecker();
  
  public abstract NotificationDisplayUtils notificationDisplayUtils();
  
  public abstract NotificationUtils notificationUtils();
  
  public abstract OAuthNetworkHelper oAuthNetworkHelper();
  
  public abstract PaymentService paymentService();
  
  public abstract Tracker perfTracker();
  
  public abstract PhotoUtils photoUtils();
  
  public abstract PlaceholderImageCache placeholderImageCache();
  
  public abstract PreAuthLixManager preAuthLixManager();
  
  public abstract ProfilePendingConnectionRequestManager profilePendingConnectionRequestManager();
  
  public abstract ProfileUtil profileUtil();
  
  public abstract ProgressBarUtil progressBarUtil();
  
  public abstract DeeplinkHelper provideDeeplinkHelper();
  
  public abstract RateTheApp rateTheApp();
  
  public abstract RealTimeManager realTimeManager();
  
  public abstract Optional<RefWatcher> refWatcher();
  
  public abstract ReportEntityInvokerHelper reportEntityInvokerHelper();
  
  public abstract SearchUtils searchUtils();
  
  public abstract FeedSharePublisher sharePublisher();
  
  public abstract SnackbarUtil snackbarUtil();
  
  public abstract SponsoredUpdateTracker sponsoredUpdateTracker();
  
  public abstract TermsOfServiceInterface termsOfService();
  
  public abstract ThirdPartySdkManager thirdPartySdkManager();
  
  public abstract TimeWrapper timeWrapper();
  
  public abstract TitanDataMigrationManager titanDataMigrationManager();
  
  public abstract Tracker tracker();
  
  public abstract LiTrackingNetworkStack trackingNetworkStack();
  
  public abstract TransformerExecutor transformerExecutor();
  
  public abstract UpdateChangeCoordinator updateChangeCoordinator();
  
  public abstract ViewPagerManager viewPagerManager();
  
  public abstract ViewPagerObserver viewPagerObserver();
  
  public abstract ViewportTrackingConfiguration viewportConfig();
  
  public abstract ViewPortManager viewportManager();
  
  public abstract WebRouter webRouter();
  
  public abstract WebRouterUtil webRouterUtil();
  
  public abstract WebViewLoadProxy webViewLoadProxy();
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.components.ApplicationComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */