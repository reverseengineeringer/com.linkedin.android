package com.linkedin.android.infra.components;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import com.linkedin.CrossPromoLib.api.CrossPromoManager;
import com.linkedin.android.ConfirmEmailAddress.DeepLinkEmailManagementController;
import com.linkedin.android.ConfirmEmailAddress.EmailManagementController;
import com.linkedin.android.appwidget.AppWidgetKeyValueStore;
import com.linkedin.android.authenticator.LaunchActivity;
import com.linkedin.android.authenticator.LaunchActivity_MembersInjector;
import com.linkedin.android.axle.rta.RateTheApp;
import com.linkedin.android.deeplink.helper.DeeplinkHelper;
import com.linkedin.android.developer.OAuthNetworkHelper;
import com.linkedin.android.entities.EntityBaseActivity;
import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.entities.company.CompanyDataProvider_Factory;
import com.linkedin.android.entities.company.controllers.CompanyActivity;
import com.linkedin.android.entities.group.GroupDataProvider;
import com.linkedin.android.entities.group.GroupDataProvider_Factory;
import com.linkedin.android.entities.group.controllers.GroupActivity;
import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.entities.job.JobDataProvider_Factory;
import com.linkedin.android.entities.job.controllers.JobActivity;
import com.linkedin.android.entities.jymbii.JymbiiActivity;
import com.linkedin.android.entities.jymbii.JymbiiDataProvider;
import com.linkedin.android.entities.jymbii.JymbiiDataProvider_Factory;
import com.linkedin.android.entities.school.SchoolDataProvider;
import com.linkedin.android.entities.school.SchoolDataProvider_Factory;
import com.linkedin.android.entities.school.controllers.SchoolActivity;
import com.linkedin.android.feed.FeedUpdatesDataProvider;
import com.linkedin.android.feed.FeedUpdatesDataProvider_Factory;
import com.linkedin.android.feed.FeedUpdatesDataProvider_MembersInjector;
import com.linkedin.android.feed.channel.ChannelUpdatesDataProvider;
import com.linkedin.android.feed.channel.ChannelUpdatesDataProvider_Factory;
import com.linkedin.android.feed.detail.FeedUpdateDetailDataProvider;
import com.linkedin.android.feed.detail.FeedUpdateDetailDataProvider_Factory;
import com.linkedin.android.feed.endor.datamodel.transformer.service.TransformerExecutor;
import com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdatesDataProvider;
import com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdatesDataProvider_Factory;
import com.linkedin.android.feed.page.feed.newupdatespill.CheckForNewUpdatesRunnable;
import com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateDataProvider;
import com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateDataProvider_Factory;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.feed.shared.liking.LikePublisher;
import com.linkedin.android.feed.tracking.SponsoredUpdateTracker;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailDataProvider;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailDataProvider_Factory;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDataProvider;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDataProvider_Factory;
import com.linkedin.android.feed.utils.FeedKeyValueStore;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.growth.SendInviteActivity;
import com.linkedin.android.growth.SendInviteActivity_MembersInjector;
import com.linkedin.android.growth.abi.AbiActivity;
import com.linkedin.android.growth.abi.AbiActivity_MembersInjector;
import com.linkedin.android.growth.abi.AbiAutoSyncManager;
import com.linkedin.android.growth.abi.AbiCacheUtils;
import com.linkedin.android.growth.abi.AbiContactsReader;
import com.linkedin.android.growth.abi.AbiDataProvider;
import com.linkedin.android.growth.abi.AbiDataProvider_Factory;
import com.linkedin.android.growth.abi.AbiLegoWidgetSwitch;
import com.linkedin.android.growth.abi.AbiLegoWidgetSwitch_Factory;
import com.linkedin.android.growth.calendar.sync.CalendarSyncManager;
import com.linkedin.android.growth.heathrow.HeathrowFlowDataProvider;
import com.linkedin.android.growth.heathrow.HeathrowFlowDataProvider_Factory;
import com.linkedin.android.growth.lego.LegoManager;
import com.linkedin.android.growth.login.LoginActivity;
import com.linkedin.android.growth.login.LoginActivity_MembersInjector;
import com.linkedin.android.growth.login.LoginUtils;
import com.linkedin.android.growth.login.LoginUtils_Factory;
import com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager;
import com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager_Factory;
import com.linkedin.android.growth.login.login.LoginManager;
import com.linkedin.android.growth.login.login.LoginManager_Factory;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.growth.login.sso.SSOManager;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroActivity;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroActivity_MembersInjector;
import com.linkedin.android.growth.onboarding.OnboardingActivity;
import com.linkedin.android.growth.onboarding.OnboardingActivity_MembersInjector;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider_Factory;
import com.linkedin.android.growth.onboarding.OnboardingLegoWidgetSwitch;
import com.linkedin.android.growth.onboarding.OnboardingLegoWidgetSwitch_Factory;
import com.linkedin.android.growth.onboarding.OnboardingLegoWidgetSwitch_MembersInjector;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedActivity;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedDataProvider;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedDataProvider_Factory;
import com.linkedin.android.growth.seo.samename.SameNameDirectoryActivity;
import com.linkedin.android.growth.seo.samename.SameNameDirectoryDataProvider;
import com.linkedin.android.growth.seo.samename.SameNameDirectoryDataProvider_Factory;
import com.linkedin.android.growth.takeover.NewToVoyagerTransactionalLaunchManager;
import com.linkedin.android.growth.takeover.NewToVoyagerTransactionalLaunchManager_Factory;
import com.linkedin.android.growth.takeover.TakeoverManager;
import com.linkedin.android.growth.takeover.TakeoverManager_Factory;
import com.linkedin.android.growth.utils.ProgressBarUtil;
import com.linkedin.android.growth.utils.ThirdPartySdkManager;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.home.HomeActivity_MembersInjector;
import com.linkedin.android.home.HomeCachedLix;
import com.linkedin.android.home.HomeFragmentDataProvider;
import com.linkedin.android.home.HomeFragmentDataProvider_Factory;
import com.linkedin.android.identity.guidededit.GuidedEditActivity;
import com.linkedin.android.identity.guidededit.GuidedEditDataProvider;
import com.linkedin.android.identity.guidededit.GuidedEditDataProvider_Factory;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider_Factory;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsedSkillsDataProvider;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsedSkillsDataProvider_Factory;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementActivity;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementsEndorserDataProvider;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementsEndorserDataProvider_Factory;
import com.linkedin.android.identity.me.contentanalytics.ContentAnalyticsDataProvider;
import com.linkedin.android.identity.me.contentanalytics.ContentAnalyticsDataProvider_Factory;
import com.linkedin.android.identity.me.notifications.NotificationsDataProvider;
import com.linkedin.android.identity.me.notifications.NotificationsDataProvider_Factory;
import com.linkedin.android.identity.me.notifications.cards.dataproviders.MeCardDataProvider;
import com.linkedin.android.identity.me.notifications.cards.dataproviders.MeCardDataProvider_Factory;
import com.linkedin.android.identity.me.shared.paging.MeDedupProxy;
import com.linkedin.android.identity.me.shared.util.ViewPagerManager;
import com.linkedin.android.identity.me.wvmp.MeWvmpDataProvider;
import com.linkedin.android.identity.me.wvmp.MeWvmpDataProvider_Factory;
import com.linkedin.android.identity.me.wvmpV2.WvmpDataProvider;
import com.linkedin.android.identity.me.wvmpV2.WvmpDataProvider_Factory;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileDataProvider_Factory;
import com.linkedin.android.identity.profile.ProfileDataProvider_MembersInjector;
import com.linkedin.android.identity.profile.ProfileViewActivity;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.identity.profile.view.recentactivity.detail.ProfileActivityFeedDataProvider;
import com.linkedin.android.identity.profile.view.recentactivity.detail.ProfileActivityFeedDataProvider_Factory;
import com.linkedin.android.identity.profile.view.recentactivity.detail.ProfileSharesFeedDataProvider;
import com.linkedin.android.identity.profile.view.recentactivity.detail.ProfileSharesFeedDataProvider_Factory;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.imageloader.interfaces.ImageLoader;
import com.linkedin.android.imageloader.interfaces.ImageLoaderCache;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.animations.AnimationProxy;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseActivity_MembersInjector;
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
import com.linkedin.android.infra.modules.ActivityModule;
import com.linkedin.android.infra.modules.ActivityModule_BaseActivityFactory;
import com.linkedin.android.infra.modules.ActivityModule_ContentResolverFactory;
import com.linkedin.android.infra.modules.ActivityModule_DeepLinkEmailManagementControllerFactory;
import com.linkedin.android.infra.modules.ActivityModule_EmailManagementControllerFactory;
import com.linkedin.android.infra.modules.ActivityModule_LegoManagerFactory;
import com.linkedin.android.infra.modules.ActivityModule_ProvideContextFactory;
import com.linkedin.android.infra.modules.ActivityModule_SmartLockManagerFactory;
import com.linkedin.android.infra.modules.ActivityModule_SsoManagerFactory;
import com.linkedin.android.infra.modules.ActivityModule_SupportFragmentManagerFactory;
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
import com.linkedin.android.l2m.deeplink.DeepLinkHelperActivity;
import com.linkedin.android.l2m.deeplink.DeepLinkHelperActivity_MembersInjector;
import com.linkedin.android.l2m.deeplink.DeepLinkManager;
import com.linkedin.android.l2m.notification.NotificationDisplayUtils;
import com.linkedin.android.l2m.notification.NotificationUtils;
import com.linkedin.android.liauthlib.network.HttpStack;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.messaging.BaseMessengerActivity;
import com.linkedin.android.messaging.integration.AssetLoaderNetworkClient;
import com.linkedin.android.messaging.integration.FlagshipAssetManager;
import com.linkedin.android.messaging.messagelist.MessageListActivity;
import com.linkedin.android.messaging.messagelist.MessageListActivity_MembersInjector;
import com.linkedin.android.messaging.reconnect.ReconnectActivity;
import com.linkedin.android.networking.cookies.CookieUtil;
import com.linkedin.android.paymentslibrary.api.PaymentService;
import com.linkedin.android.premium.PremiumActivity;
import com.linkedin.android.premium.PremiumDataProvider;
import com.linkedin.android.premium.PremiumDataProvider_Factory;
import com.linkedin.android.publishing.reader.ArticleActivity;
import com.linkedin.android.publishing.reader.PublishingDataProvider;
import com.linkedin.android.publishing.reader.PublishingDataProvider_Factory;
import com.linkedin.android.publishing.sharing.compose.FeedSharePublisher;
import com.linkedin.android.publishing.sharing.compose.GroupSharePublisher;
import com.linkedin.android.relationships.RelationshipsDataProvider;
import com.linkedin.android.relationships.RelationshipsDataProvider_Factory;
import com.linkedin.android.relationships.RelationshipsDataProvider_MembersInjector;
import com.linkedin.android.relationships.RelationshipsSecondaryActivity;
import com.linkedin.android.relationships.addConnections.PymkDataProvider;
import com.linkedin.android.relationships.addConnections.PymkDataProvider_Factory;
import com.linkedin.android.relationships.addConnections.PymkDataProvider_MembersInjector;
import com.linkedin.android.relationships.connectFlow.ConnectFlowDataProvider;
import com.linkedin.android.relationships.connectFlow.ConnectFlowDataProvider_Factory;
import com.linkedin.android.relationships.connections.ConnectionStore;
import com.linkedin.android.relationships.connections.ConnectionsFetchingManager;
import com.linkedin.android.relationships.connections.ConnectionsV2DataProvider;
import com.linkedin.android.relationships.connections.ConnectionsV2DataProvider_Factory;
import com.linkedin.android.relationships.invitations.InvitationsDataProvider;
import com.linkedin.android.relationships.invitations.InvitationsDataProvider_Factory;
import com.linkedin.android.relationships.invitations.InvitationsDataProvider_MembersInjector;
import com.linkedin.android.relationships.invitations.PendingInvitationDataProvider;
import com.linkedin.android.relationships.invitations.PendingInvitationDataProvider_Factory;
import com.linkedin.android.relationships.invitations.PendingInvitationDataProvider_MembersInjector;
import com.linkedin.android.relationships.meetings.MeetingDetailsDataProvider;
import com.linkedin.android.relationships.meetings.MeetingDetailsDataProvider_Factory;
import com.linkedin.android.search.SearchActivity;
import com.linkedin.android.search.SearchActivity_MembersInjector;
import com.linkedin.android.search.SearchDataProvider;
import com.linkedin.android.search.SearchDataProvider_Factory;
import com.linkedin.android.search.facet.SearchFacetTransformer;
import com.linkedin.android.search.facet.SearchFacetTransformer_Factory;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.tracking.v2.network.LiTrackingNetworkStack;
import com.linkedin.android.webrouter.core.WebRouter;
import com.linkedin.consistency.ConsistencyManager;
import com.squareup.leakcanary.RefWatcher;
import dagger.MembersInjector;
import dagger.internal.InstanceFactory;
import dagger.internal.MembersInjectors.NoOpMembersInjector;
import dagger.internal.ScopedProvider;
import java.util.concurrent.ExecutorService;
import javax.inject.Provider;

public final class DaggerActivityComponent
  implements ActivityComponent
{
  private MembersInjector<AbiActivity> abiActivityMembersInjector;
  private Provider<AbiAutoSyncManager> abiAutoSyncManagerProvider;
  private Provider<AbiCacheUtils> abiCacheUtilsProvider;
  private Provider<AbiContactsReader> abiContactsReaderProvider;
  private Provider<AbiDataProvider> abiDataProvider;
  private Provider<AbiLegoWidgetSwitch> abiLegoWidgetSwitchProvider;
  private Provider<ActivityComponent> activityComponentProvider;
  private Provider<AnimationProxy> animationProxyProvider;
  private Provider<Context> appContextProvider;
  private Provider<FlagshipApplication> appProvider;
  private Provider<AppUpgradeUtils> appUpgradeUtilsProvider;
  private Provider<AppWidgetKeyValueStore> appwidgetValuesProvider;
  private MembersInjector<ArticleActivity> articleActivityMembersInjector;
  private Provider<AssetLoaderNetworkClient> assetLoaderNetworkClientProvider;
  private Provider<HttpStack> authHttpStackProvider;
  private Provider<Auth> authProvider;
  private Provider<Badger> badgerProvider;
  private MembersInjector<BaseActivity> baseActivityMembersInjector;
  private Provider<BaseActivity> baseActivityProvider;
  private MembersInjector<BaseMessengerActivity> baseMessengerActivityMembersInjector;
  private Provider<CalendarSyncManager> calendarSyncManagerProvider;
  private Provider<CalendarTaskUtil> calendarTaskUtilProvider;
  private Provider<CardToastManager> cardToastManagerProvider;
  private Provider<ChannelUpdatesDataProvider> channelUpdatesDataProvider;
  private MembersInjector<ChannelUpdatesDataProvider> channelUpdatesDataProviderMembersInjector;
  private Provider<CommTracker> commTrackerProvider;
  private Provider<CommentDetailDataProvider> commentDetailDataProvider;
  private Provider<CommentPublisher> commentPublisherProvider;
  private MembersInjector<CompanyActivity> companyActivityMembersInjector;
  private Provider<CompanyDataProvider> companyDataProvider;
  private Provider<ConfigurationManager> configurationManagerProvider;
  private Provider<ConnectFlowDataProvider> connectFlowDataProvider;
  private Provider<ConnectionStore> connectionStoreProvider;
  private Provider<ConnectionsFetchingManager> connectionsFetchingManagerProvider;
  private Provider<ConnectionsV2DataProvider> connectionsV2DataProvider;
  private Provider<ConsistencyManager> consistencyManagerProvider;
  private Provider<ContentAnalyticsDataProvider> contentAnalyticsDataProvider;
  private Provider<ContentResolver> contentResolverProvider;
  private Provider<CookieUtil> cookieUtilProvider;
  private Provider<CrossPromoManager> crossPromoManagerProvider;
  private Provider<FlagshipDataManager> dataManagerProvider;
  private Provider<DeepLinkEmailManagementController> deepLinkEmailManagementControllerProvider;
  private MembersInjector<DeepLinkHelperActivity> deepLinkHelperActivityMembersInjector;
  private Provider<DeepLinkManager> deepLinkManagerProvider;
  private Provider<DelayedExecution> delayedExecutionProvider;
  private Provider<Integer> deviceClassProvider;
  private Provider<EmailManagementController> emailManagementControllerProvider;
  private MembersInjector<EntityBaseActivity> entityBaseActivityMembersInjector;
  private Provider<Bus> eventBusProvider;
  private Provider<ExecutorService> executorServiceProvider;
  private Provider<FeedUpdateDetailDataProvider> feedUpdateDetailDataProvider;
  private Provider<FeedUpdatesDataProvider> feedUpdatesDataProvider;
  private MembersInjector<FeedUpdatesDataProvider> feedUpdatesDataProviderMembersInjector;
  private Provider<FeedKeyValueStore> feedValuesProvider;
  private Provider<FlagshipAssetManager> flagshipAssetManagerProvider;
  private Provider<FlagshipCacheManager> flagshipCacheManagerProvider;
  private Provider<FlagshipSharedPreferences> flagshipSharedPreferencesProvider;
  private Provider<FollowPublisher> followPublisherProvider;
  private Provider<FragmentRegistry> fragmentRegistryProvider;
  private Provider<GeoLocator> geoLocatorProvider;
  private Provider<GoogleIdTokenManager> googleIdTokenManagerProvider;
  private MembersInjector<GroupActivity> groupActivityMembersInjector;
  private Provider<GroupDataProvider> groupDataProvider;
  private Provider<GroupSharePublisher> groupsSharePublisherProvider;
  private MembersInjector<GuidedEditActivity> guidedEditActivityMembersInjector;
  private Provider<GuidedEditDataProvider> guidedEditDataProvider;
  private Provider<HeathrowFlowDataProvider> heathrowFlowDataProvider;
  private Provider<HighlightedUpdatesDataProvider> highlightedUpdatesDataProvider;
  private MembersInjector<HomeActivity> homeActivityMembersInjector;
  private Provider<HomeCachedLix> homeCachedLixProvider;
  private Provider<HomeFragmentDataProvider> homeFragmentDataProvider;
  private Provider<I18NManager> i18NManagerProvider;
  private Provider<ImageLoaderCache> imageLoaderCacheProvider;
  private Provider<ImageLoader> imageLoaderProvider;
  private Provider<ImageQualityManager> imageQualityManagerProvider;
  private Provider<IntentRegistry> intentRegistryProvider;
  private Provider<InternetConnectionMonitor> internetConnectionMonitorProvider;
  private Provider<InvitationsDataProvider> invitationsDataProvider;
  private MembersInjector<InvitationsDataProvider> invitationsDataProviderMembersInjector;
  private MembersInjector<JobActivity> jobActivityMembersInjector;
  private Provider<JobDataProvider> jobDataProvider;
  private MembersInjector<JymbiiActivity> jymbiiActivityMembersInjector;
  private Provider<JymbiiDataProvider> jymbiiDataProvider;
  private MembersInjector<LaunchActivity> launchActivityMembersInjector;
  private Provider<LaunchUtils> launchUtilsProvider;
  private Provider<LegoManager> legoManagerProvider;
  private Provider<LegoTrackingDataProvider> legoTrackingDataProvider;
  private Provider<LikePublisher> likePublisherProvider;
  private Provider<LikesDataProvider> likesDataProvider;
  private Provider<LixManager> lixManagerProvider;
  private MembersInjector<LoginActivity> loginActivityMembersInjector;
  private Provider<LoginManager> loginManagerProvider;
  private Provider<LoginUtils> loginUtilsProvider;
  private Provider<com.linkedin.android.infra.shared.LongClickUtil> longClickUtilProvider;
  private Provider<Handler> mainHandlerProvider;
  private Provider<MeCardDataProvider> meCardDataProvider;
  private Provider<MeDedupProxy> meDedupProxyProvider;
  private Provider<MeWvmpDataProvider> meWvmpDataProvider;
  private Provider<MediaCenter> mediaCenterProvider;
  private Provider<MediaUploader> mediaUploaderProvider;
  private Provider<MeetingDetailsDataProvider> meetingDetailsDataProvider;
  private Provider<MemberUtil> memberUtilProvider;
  private MembersInjector<MessageListActivity> messageListActivityMembersInjector;
  private Provider<com.linkedin.messengerlib.utils.LongClickUtil> messengerLongClickUtilProvider;
  private Provider<NavigationManager> navigationManagerProvider;
  private Provider<NetworkClient> networkClientProvider;
  private MembersInjector<NewToVoyagerIntroActivity> newToVoyagerIntroActivityMembersInjector;
  private Provider<NewToVoyagerTransactionalLaunchManager> newToVoyagerTransactionalLaunchManagerProvider;
  private Provider<CheckForNewUpdatesRunnable> newUpdatesCheckerProvider;
  private Provider<NotificationDisplayUtils> notificationDisplayUtilsProvider;
  private Provider<NotificationUtils> notificationUtilsProvider;
  private Provider<NotificationsDataProvider> notificationsDataProvider;
  private Provider<OAuthNetworkHelper> oAuthNetworkHelperProvider;
  private MembersInjector<OnboardingActivity> onboardingActivityMembersInjector;
  private Provider<OnboardingDataProvider> onboardingDataProvider;
  private MembersInjector<OnboardingLegoWidgetSwitch> onboardingLegoWidgetSwitchMembersInjector;
  private Provider<OnboardingLegoWidgetSwitch> onboardingLegoWidgetSwitchProvider;
  private Provider<PaymentService> paymentServiceProvider;
  private Provider<PendingEndorsedSkillsDataProvider> pendingEndorsedSkillsDataProvider;
  private MembersInjector<PendingEndorsementActivity> pendingEndorsementActivityMembersInjector;
  private Provider<PendingEndorsementsEndorserDataProvider> pendingEndorsementsEndorserDataProvider;
  private Provider<PendingInvitationDataProvider> pendingInvitationDataProvider;
  private MembersInjector<PendingInvitationDataProvider> pendingInvitationDataProviderMembersInjector;
  private Provider<Tracker> perfTrackerProvider;
  private Provider<PhotoUtils> photoUtilsProvider;
  private Provider<PlaceholderImageCache> placeholderImageCacheProvider;
  private Provider<PreAuthLixManager> preAuthLixManagerProvider;
  private MembersInjector<PremiumActivity> premiumActivityMembersInjector;
  private Provider<PremiumDataProvider> premiumDataProvider;
  private Provider<ProfileActivityFeedDataProvider> profileActivityFeedDataProvider;
  private MembersInjector<ProfileActivityFeedDataProvider> profileActivityFeedDataProviderMembersInjector;
  private Provider<ProfileDataProvider> profileDataProvider;
  private MembersInjector<ProfileDataProvider> profileDataProviderMembersInjector;
  private Provider<ProfilePendingConnectionRequestManager> profilePendingConnectionRequestManagerProvider;
  private Provider<ProfileSharesFeedDataProvider> profileSharesFeedDataProvider;
  private MembersInjector<ProfileSharesFeedDataProvider> profileSharesFeedDataProviderMembersInjector;
  private Provider<ProfileUtil> profileUtilProvider;
  private MembersInjector<ProfileViewActivity> profileViewActivityMembersInjector;
  private Provider<ProgressBarUtil> progressBarUtilProvider;
  private Provider<Context> provideContextProvider;
  private Provider<DeeplinkHelper> provideDeeplinkHelperProvider;
  private Provider<PublishingDataProvider> publishingDataProvider;
  private Provider<PymkDataProvider> pymkDataProvider;
  private MembersInjector<PymkDataProvider> pymkDataProviderMembersInjector;
  private Provider<RateTheApp> rateTheAppProvider;
  private Provider<RealTimeManager> realTimeManagerProvider;
  private MembersInjector<RebuildMyFeedActivity> rebuildMyFeedActivityMembersInjector;
  private Provider<RebuildMyFeedDataProvider> rebuildMyFeedDataProvider;
  private MembersInjector<ReconnectActivity> reconnectActivityMembersInjector;
  private Provider<Optional<RefWatcher>> refWatcherProvider;
  private Provider<RelationshipsDataProvider> relationshipsDataProvider;
  private MembersInjector<RelationshipsDataProvider> relationshipsDataProviderMembersInjector;
  private MembersInjector<RelationshipsSecondaryActivity> relationshipsSecondaryActivityMembersInjector;
  private Provider<ReportEntityInvokerHelper> reportEntityInvokerHelperProvider;
  private MembersInjector<SameNameDirectoryActivity> sameNameDirectoryActivityMembersInjector;
  private Provider<SameNameDirectoryDataProvider> sameNameDirectoryDataProvider;
  private MembersInjector<SchoolActivity> schoolActivityMembersInjector;
  private Provider<SchoolDataProvider> schoolDataProvider;
  private MembersInjector<SearchActivity> searchActivityMembersInjector;
  private Provider<SearchDataProvider> searchDataProvider;
  private Provider<SearchFacetTransformer> searchFacetTransformerProvider;
  private Provider<SearchUtils> searchUtilsProvider;
  private MembersInjector<SendInviteActivity> sendInviteActivityMembersInjector;
  private Provider<FeedSharePublisher> sharePublisherProvider;
  private Provider<SmartLockManager> smartLockManagerProvider;
  private Provider<SnackbarUtil> snackbarUtilProvider;
  private Provider<SponsoredUpdateTracker> sponsoredUpdateTrackerProvider;
  private Provider<SSOManager> ssoManagerProvider;
  private Provider<FragmentManager> supportFragmentManagerProvider;
  private Provider<TakeoverManager> takeoverManagerProvider;
  private Provider<TermsOfServiceInterface> termsOfServiceProvider;
  private Provider<ThirdPartySdkManager> thirdPartySdkManagerProvider;
  private Provider<TimeWrapper> timeWrapperProvider;
  private Provider<TitanDataMigrationManager> titanDataMigrationManagerProvider;
  private Provider<Tracker> trackerProvider;
  private Provider<LiTrackingNetworkStack> trackingNetworkStackProvider;
  private Provider<TransformerExecutor> transformerExecutorProvider;
  private Provider<UnfollowEducateDataProvider> unfollowEducateDataProvider;
  private Provider<UpdateChangeCoordinator> updateChangeCoordinatorProvider;
  private Provider<ViewPagerManager> viewPagerManagerProvider;
  private Provider<ViewPagerObserver> viewPagerObserverProvider;
  private Provider<ViewportTrackingConfiguration> viewportConfigProvider;
  private Provider<ViewPortManager> viewportManagerProvider;
  private Provider<WebRouter> webRouterProvider;
  private Provider<WebRouterUtil> webRouterUtilProvider;
  private Provider<WebViewLoadProxy> webViewLoadProxyProvider;
  private Provider<WvmpDataProvider> wvmpDataProvider;
  
  static
  {
    if (!DaggerActivityComponent.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private DaggerActivityComponent(Builder paramBuilder)
  {
    assert (paramBuilder != null);
    appContextProvider = new DaggerActivityComponent.1(this, paramBuilder);
    appProvider = new DaggerActivityComponent.2(this, paramBuilder);
    authProvider = new DaggerActivityComponent.3(this, paramBuilder);
    launchUtilsProvider = new DaggerActivityComponent.4(this, paramBuilder);
    authHttpStackProvider = new DaggerActivityComponent.5(this, paramBuilder);
    trackingNetworkStackProvider = new DaggerActivityComponent.6(this, paramBuilder);
    navigationManagerProvider = new DaggerActivityComponent.7(this, paramBuilder);
    mainHandlerProvider = new DaggerActivityComponent.8(this, paramBuilder);
    executorServiceProvider = new DaggerActivityComponent.9(this, paramBuilder);
    placeholderImageCacheProvider = new DaggerActivityComponent.10(this, paramBuilder);
    imageLoaderCacheProvider = new DaggerActivityComponent.11(this, paramBuilder);
    imageLoaderProvider = new DaggerActivityComponent.12(this, paramBuilder);
    mediaCenterProvider = new DaggerActivityComponent.13(this, paramBuilder);
    dataManagerProvider = new DaggerActivityComponent.14(this, paramBuilder);
    flagshipCacheManagerProvider = new DaggerActivityComponent.15(this, paramBuilder);
    flagshipAssetManagerProvider = new DaggerActivityComponent.16(this, paramBuilder);
    assetLoaderNetworkClientProvider = new DaggerActivityComponent.17(this, paramBuilder);
    connectionStoreProvider = new DaggerActivityComponent.18(this, paramBuilder);
    consistencyManagerProvider = new DaggerActivityComponent.19(this, paramBuilder);
    mediaUploaderProvider = new DaggerActivityComponent.20(this, paramBuilder);
    flagshipSharedPreferencesProvider = new DaggerActivityComponent.21(this, paramBuilder);
    networkClientProvider = new DaggerActivityComponent.22(this, paramBuilder);
    cookieUtilProvider = new DaggerActivityComponent.23(this, paramBuilder);
    i18NManagerProvider = new DaggerActivityComponent.24(this, paramBuilder);
    configurationManagerProvider = new DaggerActivityComponent.25(this, paramBuilder);
    intentRegistryProvider = new DaggerActivityComponent.26(this, paramBuilder);
    viewPagerObserverProvider = new DaggerActivityComponent.27(this, paramBuilder);
    realTimeManagerProvider = new DaggerActivityComponent.28(this, paramBuilder);
    provideDeeplinkHelperProvider = new DaggerActivityComponent.29(this, paramBuilder);
    fragmentRegistryProvider = new DaggerActivityComponent.30(this, paramBuilder);
    imageQualityManagerProvider = new DaggerActivityComponent.31(this, paramBuilder);
    profileUtilProvider = new DaggerActivityComponent.32(this, paramBuilder);
    memberUtilProvider = new DaggerActivityComponent.33(this, paramBuilder);
    photoUtilsProvider = new DaggerActivityComponent.34(this, paramBuilder);
    snackbarUtilProvider = new DaggerActivityComponent.35(this, paramBuilder);
    cardToastManagerProvider = new DaggerActivityComponent.36(this, paramBuilder);
    internetConnectionMonitorProvider = new DaggerActivityComponent.37(this, paramBuilder);
    thirdPartySdkManagerProvider = new DaggerActivityComponent.38(this, paramBuilder);
    connectionsFetchingManagerProvider = new DaggerActivityComponent.39(this, paramBuilder);
    abiAutoSyncManagerProvider = new DaggerActivityComponent.40(this, paramBuilder);
    timeWrapperProvider = new DaggerActivityComponent.41(this, paramBuilder);
    eventBusProvider = new DaggerActivityComponent.42(this, paramBuilder);
    commentPublisherProvider = new DaggerActivityComponent.43(this, paramBuilder);
    sharePublisherProvider = new DaggerActivityComponent.44(this, paramBuilder);
    groupsSharePublisherProvider = new DaggerActivityComponent.45(this, paramBuilder);
    followPublisherProvider = new DaggerActivityComponent.46(this, paramBuilder);
    likePublisherProvider = new DaggerActivityComponent.47(this, paramBuilder);
    updateChangeCoordinatorProvider = new DaggerActivityComponent.48(this, paramBuilder);
    sponsoredUpdateTrackerProvider = new DaggerActivityComponent.49(this, paramBuilder);
    transformerExecutorProvider = new DaggerActivityComponent.50(this, paramBuilder);
    reportEntityInvokerHelperProvider = new DaggerActivityComponent.51(this, paramBuilder);
    feedValuesProvider = new DaggerActivityComponent.52(this, paramBuilder);
    appwidgetValuesProvider = new DaggerActivityComponent.53(this, paramBuilder);
    newUpdatesCheckerProvider = new DaggerActivityComponent.54(this, paramBuilder);
    trackerProvider = new DaggerActivityComponent.55(this, paramBuilder);
    perfTrackerProvider = new DaggerActivityComponent.56(this, paramBuilder);
    refWatcherProvider = new DaggerActivityComponent.57(this, paramBuilder);
    delayedExecutionProvider = new DaggerActivityComponent.58(this, paramBuilder);
    viewportManagerProvider = new DaggerActivityComponent.59(this, paramBuilder);
    viewPagerManagerProvider = new DaggerActivityComponent.60(this, paramBuilder);
    viewportConfigProvider = new DaggerActivityComponent.61(this, paramBuilder);
    crossPromoManagerProvider = new DaggerActivityComponent.62(this, paramBuilder);
    geoLocatorProvider = new DaggerActivityComponent.63(this, paramBuilder);
    paymentServiceProvider = new DaggerActivityComponent.64(this, paramBuilder);
    notificationUtilsProvider = new DaggerActivityComponent.65(this, paramBuilder);
    notificationDisplayUtilsProvider = new DaggerActivityComponent.66(this, paramBuilder);
    searchUtilsProvider = new DaggerActivityComponent.67(this, paramBuilder);
    preAuthLixManagerProvider = new DaggerActivityComponent.68(this, paramBuilder);
    lixManagerProvider = new DaggerActivityComponent.69(this, paramBuilder);
    webRouterProvider = new DaggerActivityComponent.70(this, paramBuilder);
    webViewLoadProxyProvider = new DaggerActivityComponent.71(this, paramBuilder);
    calendarSyncManagerProvider = new DaggerActivityComponent.72(this, paramBuilder);
    calendarTaskUtilProvider = new DaggerActivityComponent.73(this, paramBuilder);
    animationProxyProvider = new DaggerActivityComponent.74(this, paramBuilder);
    termsOfServiceProvider = new DaggerActivityComponent.75(this, paramBuilder);
    titanDataMigrationManagerProvider = new DaggerActivityComponent.76(this, paramBuilder);
    appUpgradeUtilsProvider = new DaggerActivityComponent.77(this, paramBuilder);
    profilePendingConnectionRequestManagerProvider = new DaggerActivityComponent.78(this, paramBuilder);
    deviceClassProvider = new DaggerActivityComponent.79(this, paramBuilder);
    meDedupProxyProvider = new DaggerActivityComponent.80(this, paramBuilder);
    oAuthNetworkHelperProvider = new DaggerActivityComponent.81(this, paramBuilder);
    commTrackerProvider = new DaggerActivityComponent.82(this, paramBuilder);
    rateTheAppProvider = new DaggerActivityComponent.83(this, paramBuilder);
    homeCachedLixProvider = new DaggerActivityComponent.84(this, paramBuilder);
    longClickUtilProvider = new DaggerActivityComponent.85(this, paramBuilder);
    messengerLongClickUtilProvider = new DaggerActivityComponent.86(this, paramBuilder);
    badgerProvider = new DaggerActivityComponent.87(this, paramBuilder);
    webRouterUtilProvider = new DaggerActivityComponent.88(this, paramBuilder);
    abiContactsReaderProvider = new DaggerActivityComponent.89(this, paramBuilder);
    abiCacheUtilsProvider = new DaggerActivityComponent.90(this, paramBuilder);
    deepLinkManagerProvider = new DaggerActivityComponent.91(this, paramBuilder);
    progressBarUtilProvider = new DaggerActivityComponent.92(this, paramBuilder);
    baseActivityProvider = ScopedProvider.create(ActivityModule_BaseActivityFactory.create(activityModule));
    provideContextProvider = ScopedProvider.create(ActivityModule_ProvideContextFactory.create(activityModule));
    legoManagerProvider = ScopedProvider.create(ActivityModule_LegoManagerFactory.create(activityModule));
    smartLockManagerProvider = ScopedProvider.create(ActivityModule_SmartLockManagerFactory.create(activityModule));
    ssoManagerProvider = ScopedProvider.create(ActivityModule_SsoManagerFactory.create(activityModule, flagshipSharedPreferencesProvider));
    googleIdTokenManagerProvider = ScopedProvider.create(GoogleIdTokenManager_Factory.create(baseActivityProvider, trackerProvider));
    loginUtilsProvider = LoginUtils_Factory.create(launchUtilsProvider, lixManagerProvider, authProvider);
    emailManagementControllerProvider = ScopedProvider.create(ActivityModule_EmailManagementControllerFactory.create(activityModule));
    deepLinkEmailManagementControllerProvider = ScopedProvider.create(ActivityModule_DeepLinkEmailManagementControllerFactory.create(activityModule));
    contentResolverProvider = ScopedProvider.create(ActivityModule_ContentResolverFactory.create(activityModule));
    supportFragmentManagerProvider = ScopedProvider.create(ActivityModule_SupportFragmentManagerFactory.create(activityModule));
    takeoverManagerProvider = TakeoverManager_Factory.create(eventBusProvider, dataManagerProvider, trackerProvider, flagshipSharedPreferencesProvider, memberUtilProvider, abiCacheUtilsProvider);
    newToVoyagerTransactionalLaunchManagerProvider = NewToVoyagerTransactionalLaunchManager_Factory.create(eventBusProvider, dataManagerProvider);
    baseActivityMembersInjector = BaseActivity_MembersInjector.create(MembersInjectors.NoOpMembersInjector.INSTANCE, intentRegistryProvider, fragmentRegistryProvider, i18NManagerProvider, eventBusProvider, authProvider, trackerProvider, animationProxyProvider, appUpgradeUtilsProvider, takeoverManagerProvider, newToVoyagerTransactionalLaunchManagerProvider);
    launchActivityMembersInjector = LaunchActivity_MembersInjector.create(baseActivityMembersInjector, authProvider, launchUtilsProvider, takeoverManagerProvider, flagshipSharedPreferencesProvider, dataManagerProvider, eventBusProvider);
    loginManagerProvider = LoginManager_Factory.create(authProvider, loginUtilsProvider, baseActivityProvider, takeoverManagerProvider, networkClientProvider);
    loginActivityMembersInjector = LoginActivity_MembersInjector.create(baseActivityMembersInjector, authProvider, loginUtilsProvider, loginManagerProvider, preAuthLixManagerProvider, launchUtilsProvider, fragmentRegistryProvider, supportFragmentManagerProvider, smartLockManagerProvider, googleIdTokenManagerProvider, ssoManagerProvider, notificationUtilsProvider, flagshipSharedPreferencesProvider, takeoverManagerProvider, dataManagerProvider, eventBusProvider, snackbarUtilProvider, trackerProvider);
    newToVoyagerIntroActivityMembersInjector = NewToVoyagerIntroActivity_MembersInjector.create(baseActivityMembersInjector, supportFragmentManagerProvider);
    onboardingLegoWidgetSwitchMembersInjector = OnboardingLegoWidgetSwitch_MembersInjector.create(MembersInjectors.NoOpMembersInjector.INSTANCE, fragmentRegistryProvider, flagshipSharedPreferencesProvider);
    onboardingLegoWidgetSwitchProvider = OnboardingLegoWidgetSwitch_Factory.create(onboardingLegoWidgetSwitchMembersInjector, provideContextProvider, intentRegistryProvider);
    activityComponentProvider = InstanceFactory.create(this);
    onboardingDataProvider = ScopedProvider.create(OnboardingDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    onboardingActivityMembersInjector = OnboardingActivity_MembersInjector.create(baseActivityMembersInjector, legoManagerProvider, onboardingLegoWidgetSwitchProvider, onboardingDataProvider, trackerProvider, fragmentRegistryProvider, memberUtilProvider, i18NManagerProvider);
    abiLegoWidgetSwitchProvider = AbiLegoWidgetSwitch_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    abiActivityMembersInjector = AbiActivity_MembersInjector.create(baseActivityMembersInjector, abiLegoWidgetSwitchProvider, dataManagerProvider, legoManagerProvider, flagshipSharedPreferencesProvider);
    premiumActivityMembersInjector = baseActivityMembersInjector;
    entityBaseActivityMembersInjector = baseActivityMembersInjector;
    companyActivityMembersInjector = entityBaseActivityMembersInjector;
    schoolActivityMembersInjector = entityBaseActivityMembersInjector;
    jobActivityMembersInjector = entityBaseActivityMembersInjector;
    groupActivityMembersInjector = entityBaseActivityMembersInjector;
    homeActivityMembersInjector = HomeActivity_MembersInjector.create(baseActivityMembersInjector, flagshipSharedPreferencesProvider, homeCachedLixProvider);
    pendingEndorsementActivityMembersInjector = baseActivityMembersInjector;
    guidedEditActivityMembersInjector = baseActivityMembersInjector;
    profileViewActivityMembersInjector = baseActivityMembersInjector;
    relationshipsSecondaryActivityMembersInjector = baseActivityMembersInjector;
    jymbiiActivityMembersInjector = baseActivityMembersInjector;
    baseMessengerActivityMembersInjector = baseActivityMembersInjector;
    messageListActivityMembersInjector = MessageListActivity_MembersInjector.create(baseMessengerActivityMembersInjector, trackerProvider);
    deepLinkHelperActivityMembersInjector = DeepLinkHelperActivity_MembersInjector.create(baseActivityMembersInjector, provideDeeplinkHelperProvider, newToVoyagerTransactionalLaunchManagerProvider, deepLinkManagerProvider, lixManagerProvider);
    searchFacetTransformerProvider = SearchFacetTransformer_Factory.create(activityComponentProvider);
    searchActivityMembersInjector = SearchActivity_MembersInjector.create(baseActivityMembersInjector, searchFacetTransformerProvider, lixManagerProvider);
    rebuildMyFeedActivityMembersInjector = baseActivityMembersInjector;
    sameNameDirectoryActivityMembersInjector = baseActivityMembersInjector;
    sendInviteActivityMembersInjector = SendInviteActivity_MembersInjector.create(baseActivityMembersInjector, authProvider);
    articleActivityMembersInjector = baseActivityMembersInjector;
    reconnectActivityMembersInjector = baseMessengerActivityMembersInjector;
    connectionsV2DataProvider = ScopedProvider.create(ConnectionsV2DataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    likesDataProvider = ScopedProvider.create(LikesDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    feedUpdatesDataProviderMembersInjector = FeedUpdatesDataProvider_MembersInjector.create(MembersInjectors.NoOpMembersInjector.INSTANCE, profilePendingConnectionRequestManagerProvider);
    feedUpdatesDataProvider = ScopedProvider.create(FeedUpdatesDataProvider_Factory.create(feedUpdatesDataProviderMembersInjector, activityComponentProvider));
    highlightedUpdatesDataProvider = HighlightedUpdatesDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider);
    channelUpdatesDataProviderMembersInjector = feedUpdatesDataProviderMembersInjector;
    channelUpdatesDataProvider = ScopedProvider.create(ChannelUpdatesDataProvider_Factory.create(channelUpdatesDataProviderMembersInjector, activityComponentProvider));
    profileSharesFeedDataProviderMembersInjector = feedUpdatesDataProviderMembersInjector;
    profileSharesFeedDataProvider = ScopedProvider.create(ProfileSharesFeedDataProvider_Factory.create(profileSharesFeedDataProviderMembersInjector, activityComponentProvider));
    profileActivityFeedDataProviderMembersInjector = feedUpdatesDataProviderMembersInjector;
    profileActivityFeedDataProvider = ScopedProvider.create(ProfileActivityFeedDataProvider_Factory.create(profileActivityFeedDataProviderMembersInjector, activityComponentProvider));
    premiumDataProvider = ScopedProvider.create(PremiumDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    feedUpdateDetailDataProvider = ScopedProvider.create(FeedUpdateDetailDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    commentDetailDataProvider = ScopedProvider.create(CommentDetailDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    companyDataProvider = ScopedProvider.create(CompanyDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    jobDataProvider = ScopedProvider.create(JobDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    schoolDataProvider = ScopedProvider.create(SchoolDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    profileDataProviderMembersInjector = ProfileDataProvider_MembersInjector.create(MembersInjectors.NoOpMembersInjector.INSTANCE, memberUtilProvider, profilePendingConnectionRequestManagerProvider, lixManagerProvider, authProvider);
    profileDataProvider = ScopedProvider.create(ProfileDataProvider_Factory.create(profileDataProviderMembersInjector, activityComponentProvider));
    notificationsDataProvider = ScopedProvider.create(NotificationsDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    meWvmpDataProvider = ScopedProvider.create(MeWvmpDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    wvmpDataProvider = ScopedProvider.create(WvmpDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    meCardDataProvider = ScopedProvider.create(MeCardDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    contentAnalyticsDataProvider = ScopedProvider.create(ContentAnalyticsDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    searchDataProvider = ScopedProvider.create(SearchDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider, searchUtilsProvider));
    homeFragmentDataProvider = ScopedProvider.create(HomeFragmentDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    relationshipsDataProviderMembersInjector = RelationshipsDataProvider_MembersInjector.create(MembersInjectors.NoOpMembersInjector.INSTANCE, profilePendingConnectionRequestManagerProvider);
    relationshipsDataProvider = ScopedProvider.create(RelationshipsDataProvider_Factory.create(relationshipsDataProviderMembersInjector, activityComponentProvider));
    invitationsDataProviderMembersInjector = InvitationsDataProvider_MembersInjector.create(MembersInjectors.NoOpMembersInjector.INSTANCE, profilePendingConnectionRequestManagerProvider);
    invitationsDataProvider = ScopedProvider.create(InvitationsDataProvider_Factory.create(invitationsDataProviderMembersInjector, activityComponentProvider));
    pymkDataProviderMembersInjector = PymkDataProvider_MembersInjector.create(MembersInjectors.NoOpMembersInjector.INSTANCE, profilePendingConnectionRequestManagerProvider);
    pymkDataProvider = ScopedProvider.create(PymkDataProvider_Factory.create(pymkDataProviderMembersInjector, activityComponentProvider));
    connectFlowDataProvider = ScopedProvider.create(ConnectFlowDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider, profilePendingConnectionRequestManagerProvider));
    groupDataProvider = ScopedProvider.create(GroupDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    guidedEditDataProvider = ScopedProvider.create(GuidedEditDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    pendingEndorsedSkillsDataProvider = ScopedProvider.create(PendingEndorsedSkillsDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    pendingEndorsementsEndorserDataProvider = ScopedProvider.create(PendingEndorsementsEndorserDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    abiDataProvider = ScopedProvider.create(AbiDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    legoTrackingDataProvider = ScopedProvider.create(LegoTrackingDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    heathrowFlowDataProvider = ScopedProvider.create(HeathrowFlowDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    jymbiiDataProvider = ScopedProvider.create(JymbiiDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    rebuildMyFeedDataProvider = ScopedProvider.create(RebuildMyFeedDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    unfollowEducateDataProvider = ScopedProvider.create(UnfollowEducateDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    sameNameDirectoryDataProvider = ScopedProvider.create(SameNameDirectoryDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    publishingDataProvider = ScopedProvider.create(PublishingDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider));
    meetingDetailsDataProvider = MeetingDetailsDataProvider_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, activityComponentProvider);
    pendingInvitationDataProviderMembersInjector = PendingInvitationDataProvider_MembersInjector.create(MembersInjectors.NoOpMembersInjector.INSTANCE, profilePendingConnectionRequestManagerProvider);
    pendingInvitationDataProvider = ScopedProvider.create(PendingInvitationDataProvider_Factory.create(pendingInvitationDataProviderMembersInjector, activityComponentProvider));
  }
  
  public static Builder builder()
  {
    return new Builder((byte)0);
  }
  
  public final AbiAutoSyncManager abiAutoSyncManager()
  {
    return (AbiAutoSyncManager)abiAutoSyncManagerProvider.get();
  }
  
  public final AbiCacheUtils abiCacheUtils()
  {
    return (AbiCacheUtils)abiCacheUtilsProvider.get();
  }
  
  public final AbiContactsReader abiContactsReader()
  {
    return (AbiContactsReader)abiContactsReaderProvider.get();
  }
  
  public final AbiDataProvider abiDataProvider()
  {
    return (AbiDataProvider)abiDataProvider.get();
  }
  
  public final BaseActivity activity()
  {
    return (BaseActivity)baseActivityProvider.get();
  }
  
  public final AnimationProxy animationProxy()
  {
    return (AnimationProxy)animationProxyProvider.get();
  }
  
  public final FlagshipApplication app()
  {
    return (FlagshipApplication)appProvider.get();
  }
  
  public final Context appContext()
  {
    return (Context)appContextProvider.get();
  }
  
  public final AppUpgradeUtils appUpgradeUtils()
  {
    return (AppUpgradeUtils)appUpgradeUtilsProvider.get();
  }
  
  public final AppWidgetKeyValueStore appwidgetValues()
  {
    return (AppWidgetKeyValueStore)appwidgetValuesProvider.get();
  }
  
  public final PublishingDataProvider articleDataProvider()
  {
    return (PublishingDataProvider)publishingDataProvider.get();
  }
  
  public final AssetLoaderNetworkClient assetLoaderNetworkClient()
  {
    return (AssetLoaderNetworkClient)assetLoaderNetworkClientProvider.get();
  }
  
  public final Auth auth()
  {
    return (Auth)authProvider.get();
  }
  
  public final HttpStack authHttpStack()
  {
    return (HttpStack)authHttpStackProvider.get();
  }
  
  public final Badger badger()
  {
    return (Badger)badgerProvider.get();
  }
  
  public final CalendarSyncManager calendarSyncManager()
  {
    return (CalendarSyncManager)calendarSyncManagerProvider.get();
  }
  
  public final CalendarTaskUtil calendarTaskUtil()
  {
    return (CalendarTaskUtil)calendarTaskUtilProvider.get();
  }
  
  public final CardToastManager cardToastManager()
  {
    return (CardToastManager)cardToastManagerProvider.get();
  }
  
  public final ChannelUpdatesDataProvider channelUpdatesDataProvider()
  {
    return (ChannelUpdatesDataProvider)channelUpdatesDataProvider.get();
  }
  
  public final CommTracker commTracker()
  {
    return (CommTracker)commTrackerProvider.get();
  }
  
  public final CommentDetailDataProvider commentDetailDataProvider()
  {
    return (CommentDetailDataProvider)commentDetailDataProvider.get();
  }
  
  public final CommentPublisher commentPublisher()
  {
    return (CommentPublisher)commentPublisherProvider.get();
  }
  
  public final CompanyDataProvider companyDataProvider()
  {
    return (CompanyDataProvider)companyDataProvider.get();
  }
  
  public final ConfigurationManager configurationManager()
  {
    return (ConfigurationManager)configurationManagerProvider.get();
  }
  
  public final ConnectFlowDataProvider connectFlowDataProvider()
  {
    return (ConnectFlowDataProvider)connectFlowDataProvider.get();
  }
  
  public final ConnectionStore connectionStore()
  {
    return (ConnectionStore)connectionStoreProvider.get();
  }
  
  public final ConnectionsFetchingManager connectionsFetchingManager()
  {
    return (ConnectionsFetchingManager)connectionsFetchingManagerProvider.get();
  }
  
  public final ConnectionsV2DataProvider connectionsV2DataProvider()
  {
    return (ConnectionsV2DataProvider)connectionsV2DataProvider.get();
  }
  
  public final ConsistencyManager consistencyManager()
  {
    return (ConsistencyManager)consistencyManagerProvider.get();
  }
  
  public final ContentAnalyticsDataProvider contentAnalyticsDataProvider()
  {
    return (ContentAnalyticsDataProvider)contentAnalyticsDataProvider.get();
  }
  
  public final ContentResolver contentResolver()
  {
    return (ContentResolver)contentResolverProvider.get();
  }
  
  public final Context context()
  {
    return (Context)provideContextProvider.get();
  }
  
  public final CookieUtil cookieUtil()
  {
    return (CookieUtil)cookieUtilProvider.get();
  }
  
  public final CrossPromoManager crossPromoManager()
  {
    return (CrossPromoManager)crossPromoManagerProvider.get();
  }
  
  public final FlagshipDataManager dataManager()
  {
    return (FlagshipDataManager)dataManagerProvider.get();
  }
  
  public final DeepLinkEmailManagementController deepLinkEmailManagementController()
  {
    return (DeepLinkEmailManagementController)deepLinkEmailManagementControllerProvider.get();
  }
  
  public final DeepLinkManager deepLinkManager()
  {
    return (DeepLinkManager)deepLinkManagerProvider.get();
  }
  
  public final DelayedExecution delayedExecution()
  {
    return (DelayedExecution)delayedExecutionProvider.get();
  }
  
  public final int deviceClass()
  {
    return ((Integer)deviceClassProvider.get()).intValue();
  }
  
  public final EmailManagementController emailManagementController()
  {
    return (EmailManagementController)emailManagementControllerProvider.get();
  }
  
  public final Bus eventBus()
  {
    return (Bus)eventBusProvider.get();
  }
  
  public final ExecutorService executorService()
  {
    return (ExecutorService)executorServiceProvider.get();
  }
  
  public final FeedUpdateDetailDataProvider feedUpdateDetailProvider()
  {
    return (FeedUpdateDetailDataProvider)feedUpdateDetailDataProvider.get();
  }
  
  public final FeedUpdatesDataProvider feedUpdatesDataProvider()
  {
    return (FeedUpdatesDataProvider)feedUpdatesDataProvider.get();
  }
  
  public final FeedKeyValueStore feedValues()
  {
    return (FeedKeyValueStore)feedValuesProvider.get();
  }
  
  public final FlagshipAssetManager flagshipAssetManager()
  {
    return (FlagshipAssetManager)flagshipAssetManagerProvider.get();
  }
  
  public final FlagshipCacheManager flagshipCacheManager()
  {
    return (FlagshipCacheManager)flagshipCacheManagerProvider.get();
  }
  
  public final FlagshipSharedPreferences flagshipSharedPreferences()
  {
    return (FlagshipSharedPreferences)flagshipSharedPreferencesProvider.get();
  }
  
  public final FollowPublisher followPublisher()
  {
    return (FollowPublisher)followPublisherProvider.get();
  }
  
  public final FragmentManager fragmentManager()
  {
    return (FragmentManager)supportFragmentManagerProvider.get();
  }
  
  public final FragmentRegistry fragmentRegistry()
  {
    return (FragmentRegistry)fragmentRegistryProvider.get();
  }
  
  public final GeoLocator geoLocator()
  {
    return (GeoLocator)geoLocatorProvider.get();
  }
  
  public final GoogleIdTokenManager googleIdTokenManager()
  {
    return (GoogleIdTokenManager)googleIdTokenManagerProvider.get();
  }
  
  public final GroupDataProvider groupDataProvider()
  {
    return (GroupDataProvider)groupDataProvider.get();
  }
  
  public final GroupSharePublisher groupsSharePublisher()
  {
    return (GroupSharePublisher)groupsSharePublisherProvider.get();
  }
  
  public final GuidedEditDataProvider guidedEditDataProvider()
  {
    return (GuidedEditDataProvider)guidedEditDataProvider.get();
  }
  
  public final HeathrowFlowDataProvider heathrowFlowDataProvider()
  {
    return (HeathrowFlowDataProvider)heathrowFlowDataProvider.get();
  }
  
  public final HighlightedUpdatesDataProvider highlightedUpdatesDataProvider()
  {
    return (HighlightedUpdatesDataProvider)highlightedUpdatesDataProvider.get();
  }
  
  public final HomeCachedLix homeCachedLix()
  {
    return (HomeCachedLix)homeCachedLixProvider.get();
  }
  
  public final HomeFragmentDataProvider homeFragmentDataProvider()
  {
    return (HomeFragmentDataProvider)homeFragmentDataProvider.get();
  }
  
  public final I18NManager i18NManager()
  {
    return (I18NManager)i18NManagerProvider.get();
  }
  
  public final ImageLoader imageLoader()
  {
    return (ImageLoader)imageLoaderProvider.get();
  }
  
  public final ImageLoaderCache imageLoaderCache()
  {
    return (ImageLoaderCache)imageLoaderCacheProvider.get();
  }
  
  public final ImageQualityManager imageQualityManager()
  {
    return (ImageQualityManager)imageQualityManagerProvider.get();
  }
  
  public final void inject(LaunchActivity paramLaunchActivity)
  {
    launchActivityMembersInjector.injectMembers(paramLaunchActivity);
  }
  
  public final void inject(CompanyActivity paramCompanyActivity)
  {
    companyActivityMembersInjector.injectMembers(paramCompanyActivity);
  }
  
  public final void inject(GroupActivity paramGroupActivity)
  {
    groupActivityMembersInjector.injectMembers(paramGroupActivity);
  }
  
  public final void inject(JobActivity paramJobActivity)
  {
    jobActivityMembersInjector.injectMembers(paramJobActivity);
  }
  
  public final void inject(JymbiiActivity paramJymbiiActivity)
  {
    jymbiiActivityMembersInjector.injectMembers(paramJymbiiActivity);
  }
  
  public final void inject(SchoolActivity paramSchoolActivity)
  {
    schoolActivityMembersInjector.injectMembers(paramSchoolActivity);
  }
  
  public final void inject(SendInviteActivity paramSendInviteActivity)
  {
    sendInviteActivityMembersInjector.injectMembers(paramSendInviteActivity);
  }
  
  public final void inject(AbiActivity paramAbiActivity)
  {
    abiActivityMembersInjector.injectMembers(paramAbiActivity);
  }
  
  public final void inject(LoginActivity paramLoginActivity)
  {
    loginActivityMembersInjector.injectMembers(paramLoginActivity);
  }
  
  public final void inject(NewToVoyagerIntroActivity paramNewToVoyagerIntroActivity)
  {
    newToVoyagerIntroActivityMembersInjector.injectMembers(paramNewToVoyagerIntroActivity);
  }
  
  public final void inject(OnboardingActivity paramOnboardingActivity)
  {
    onboardingActivityMembersInjector.injectMembers(paramOnboardingActivity);
  }
  
  public final void inject(HomeActivity paramHomeActivity)
  {
    homeActivityMembersInjector.injectMembers(paramHomeActivity);
  }
  
  public final void inject(GuidedEditActivity paramGuidedEditActivity)
  {
    guidedEditActivityMembersInjector.injectMembers(paramGuidedEditActivity);
  }
  
  public final void inject(PendingEndorsementActivity paramPendingEndorsementActivity)
  {
    pendingEndorsementActivityMembersInjector.injectMembers(paramPendingEndorsementActivity);
  }
  
  public final void inject(BaseActivity paramBaseActivity)
  {
    baseActivityMembersInjector.injectMembers(paramBaseActivity);
  }
  
  public final void inject(DeepLinkHelperActivity paramDeepLinkHelperActivity)
  {
    deepLinkHelperActivityMembersInjector.injectMembers(paramDeepLinkHelperActivity);
  }
  
  public final void inject(MessageListActivity paramMessageListActivity)
  {
    messageListActivityMembersInjector.injectMembers(paramMessageListActivity);
  }
  
  public final void inject(ReconnectActivity paramReconnectActivity)
  {
    reconnectActivityMembersInjector.injectMembers(paramReconnectActivity);
  }
  
  public final void inject(SearchActivity paramSearchActivity)
  {
    searchActivityMembersInjector.injectMembers(paramSearchActivity);
  }
  
  public final IntentRegistry intentRegistry()
  {
    return (IntentRegistry)intentRegistryProvider.get();
  }
  
  public final InternetConnectionMonitor internetConnectionMonitor()
  {
    return (InternetConnectionMonitor)internetConnectionMonitorProvider.get();
  }
  
  public final InvitationsDataProvider invitationsDataProvider()
  {
    return (InvitationsDataProvider)invitationsDataProvider.get();
  }
  
  public final JobDataProvider jobDataProvider()
  {
    return (JobDataProvider)jobDataProvider.get();
  }
  
  public final JymbiiDataProvider jymbiiDataProvider()
  {
    return (JymbiiDataProvider)jymbiiDataProvider.get();
  }
  
  public final LaunchUtils launchUtils()
  {
    return (LaunchUtils)launchUtilsProvider.get();
  }
  
  public final LegoManager legoManager()
  {
    return (LegoManager)legoManagerProvider.get();
  }
  
  public final LegoTrackingDataProvider legoTrackingDataProvider()
  {
    return (LegoTrackingDataProvider)legoTrackingDataProvider.get();
  }
  
  public final LikePublisher likePublisher()
  {
    return (LikePublisher)likePublisherProvider.get();
  }
  
  public final LikesDataProvider likesDataProvider()
  {
    return (LikesDataProvider)likesDataProvider.get();
  }
  
  public final LixManager lixManager()
  {
    return (LixManager)lixManagerProvider.get();
  }
  
  public final LoginUtils loginUtils()
  {
    return (LoginUtils)loginUtilsProvider.get();
  }
  
  public final com.linkedin.android.infra.shared.LongClickUtil longClickUtil()
  {
    return (com.linkedin.android.infra.shared.LongClickUtil)longClickUtilProvider.get();
  }
  
  public final Handler mainHandler()
  {
    return (Handler)mainHandlerProvider.get();
  }
  
  public final MeCardDataProvider meCardDataProvider()
  {
    return (MeCardDataProvider)meCardDataProvider.get();
  }
  
  public final MeDedupProxy meDedupProxy()
  {
    return (MeDedupProxy)meDedupProxyProvider.get();
  }
  
  public final MeWvmpDataProvider meWvmpDataProvider()
  {
    return (MeWvmpDataProvider)meWvmpDataProvider.get();
  }
  
  public final MediaCenter mediaCenter()
  {
    return (MediaCenter)mediaCenterProvider.get();
  }
  
  public final MediaUploader mediaUploader()
  {
    return (MediaUploader)mediaUploaderProvider.get();
  }
  
  public final MeetingDetailsDataProvider meetingDetailsDataProvider()
  {
    return (MeetingDetailsDataProvider)meetingDetailsDataProvider.get();
  }
  
  public final MemberUtil memberUtil()
  {
    return (MemberUtil)memberUtilProvider.get();
  }
  
  public final com.linkedin.messengerlib.utils.LongClickUtil messengerLongClickUtil()
  {
    return (com.linkedin.messengerlib.utils.LongClickUtil)messengerLongClickUtilProvider.get();
  }
  
  public final NavigationManager navigationManager()
  {
    return (NavigationManager)navigationManagerProvider.get();
  }
  
  public final NetworkClient networkClient()
  {
    return (NetworkClient)networkClientProvider.get();
  }
  
  public final CheckForNewUpdatesRunnable newUpdatesChecker()
  {
    return (CheckForNewUpdatesRunnable)newUpdatesCheckerProvider.get();
  }
  
  public final NotificationDisplayUtils notificationDisplayUtils()
  {
    return (NotificationDisplayUtils)notificationDisplayUtilsProvider.get();
  }
  
  public final NotificationUtils notificationUtils()
  {
    return (NotificationUtils)notificationUtilsProvider.get();
  }
  
  public final NotificationsDataProvider notificationsDataProvider()
  {
    return (NotificationsDataProvider)notificationsDataProvider.get();
  }
  
  public final OAuthNetworkHelper oAuthNetworkHelper()
  {
    return (OAuthNetworkHelper)oAuthNetworkHelperProvider.get();
  }
  
  public final OnboardingDataProvider onboardingDataProvider()
  {
    return (OnboardingDataProvider)onboardingDataProvider.get();
  }
  
  public final PaymentService paymentService()
  {
    return (PaymentService)paymentServiceProvider.get();
  }
  
  public final PendingEndorsedSkillsDataProvider pendingEndorsedSkillsDataProvider()
  {
    return (PendingEndorsedSkillsDataProvider)pendingEndorsedSkillsDataProvider.get();
  }
  
  public final PendingEndorsementsEndorserDataProvider pendingEndorsementsEndorserDataProvider()
  {
    return (PendingEndorsementsEndorserDataProvider)pendingEndorsementsEndorserDataProvider.get();
  }
  
  public final PendingInvitationDataProvider pendingInvitationsDataProvider()
  {
    return (PendingInvitationDataProvider)pendingInvitationDataProvider.get();
  }
  
  public final Tracker perfTracker()
  {
    return (Tracker)perfTrackerProvider.get();
  }
  
  public final PhotoUtils photoUtils()
  {
    return (PhotoUtils)photoUtilsProvider.get();
  }
  
  public final PlaceholderImageCache placeholderImageCache()
  {
    return (PlaceholderImageCache)placeholderImageCacheProvider.get();
  }
  
  public final PreAuthLixManager preAuthLixManager()
  {
    return (PreAuthLixManager)preAuthLixManagerProvider.get();
  }
  
  public final PremiumDataProvider premiumDataProvider()
  {
    return (PremiumDataProvider)premiumDataProvider.get();
  }
  
  public final ProfileActivityFeedDataProvider profileActivityFeedDataProvider()
  {
    return (ProfileActivityFeedDataProvider)profileActivityFeedDataProvider.get();
  }
  
  public final ProfileDataProvider profileDataProvider()
  {
    return (ProfileDataProvider)profileDataProvider.get();
  }
  
  public final ProfilePendingConnectionRequestManager profilePendingConnectionRequestManager()
  {
    return (ProfilePendingConnectionRequestManager)profilePendingConnectionRequestManagerProvider.get();
  }
  
  public final ProfileSharesFeedDataProvider profileSharesFeedDataProvider()
  {
    return (ProfileSharesFeedDataProvider)profileSharesFeedDataProvider.get();
  }
  
  public final ProfileUtil profileUtil()
  {
    return (ProfileUtil)profileUtilProvider.get();
  }
  
  public final ProgressBarUtil progressBarUtil()
  {
    return (ProgressBarUtil)progressBarUtilProvider.get();
  }
  
  public final DeeplinkHelper provideDeeplinkHelper()
  {
    return (DeeplinkHelper)provideDeeplinkHelperProvider.get();
  }
  
  public final PymkDataProvider pymkDataProvider()
  {
    return (PymkDataProvider)pymkDataProvider.get();
  }
  
  public final RateTheApp rateTheApp()
  {
    return (RateTheApp)rateTheAppProvider.get();
  }
  
  public final RealTimeManager realTimeManager()
  {
    return (RealTimeManager)realTimeManagerProvider.get();
  }
  
  public final RebuildMyFeedDataProvider rebuildMyFeedDataProvider()
  {
    return (RebuildMyFeedDataProvider)rebuildMyFeedDataProvider.get();
  }
  
  public final Optional<RefWatcher> refWatcher()
  {
    return (Optional)refWatcherProvider.get();
  }
  
  public final RelationshipsDataProvider relationshipsDataProvider()
  {
    return (RelationshipsDataProvider)relationshipsDataProvider.get();
  }
  
  public final ReportEntityInvokerHelper reportEntityInvokerHelper()
  {
    return (ReportEntityInvokerHelper)reportEntityInvokerHelperProvider.get();
  }
  
  public final SameNameDirectoryDataProvider sameNameDirectoryDataProvider()
  {
    return (SameNameDirectoryDataProvider)sameNameDirectoryDataProvider.get();
  }
  
  public final SchoolDataProvider schoolDataProvider()
  {
    return (SchoolDataProvider)schoolDataProvider.get();
  }
  
  public final SearchDataProvider searchDataProvider()
  {
    return (SearchDataProvider)searchDataProvider.get();
  }
  
  public final SearchUtils searchUtils()
  {
    return (SearchUtils)searchUtilsProvider.get();
  }
  
  public final FeedSharePublisher sharePublisher()
  {
    return (FeedSharePublisher)sharePublisherProvider.get();
  }
  
  public final SmartLockManager smartLockManager()
  {
    return (SmartLockManager)smartLockManagerProvider.get();
  }
  
  public final SnackbarUtil snackbarUtil()
  {
    return (SnackbarUtil)snackbarUtilProvider.get();
  }
  
  public final SponsoredUpdateTracker sponsoredUpdateTracker()
  {
    return (SponsoredUpdateTracker)sponsoredUpdateTrackerProvider.get();
  }
  
  public final SSOManager ssoManager()
  {
    return (SSOManager)ssoManagerProvider.get();
  }
  
  public final TermsOfServiceInterface termsOfService()
  {
    return (TermsOfServiceInterface)termsOfServiceProvider.get();
  }
  
  public final ThirdPartySdkManager thirdPartySdkManager()
  {
    return (ThirdPartySdkManager)thirdPartySdkManagerProvider.get();
  }
  
  public final TimeWrapper timeWrapper()
  {
    return (TimeWrapper)timeWrapperProvider.get();
  }
  
  public final TitanDataMigrationManager titanDataMigrationManager()
  {
    return (TitanDataMigrationManager)titanDataMigrationManagerProvider.get();
  }
  
  public final Tracker tracker()
  {
    return (Tracker)trackerProvider.get();
  }
  
  public final LiTrackingNetworkStack trackingNetworkStack()
  {
    return (LiTrackingNetworkStack)trackingNetworkStackProvider.get();
  }
  
  public final TransformerExecutor transformerExecutor()
  {
    return (TransformerExecutor)transformerExecutorProvider.get();
  }
  
  public final UnfollowEducateDataProvider unfollowEducateDataProvider()
  {
    return (UnfollowEducateDataProvider)unfollowEducateDataProvider.get();
  }
  
  public final UpdateChangeCoordinator updateChangeCoordinator()
  {
    return (UpdateChangeCoordinator)updateChangeCoordinatorProvider.get();
  }
  
  public final ViewPagerManager viewPagerManager()
  {
    return (ViewPagerManager)viewPagerManagerProvider.get();
  }
  
  public final ViewPagerObserver viewPagerObserver()
  {
    return (ViewPagerObserver)viewPagerObserverProvider.get();
  }
  
  public final ViewportTrackingConfiguration viewportConfig()
  {
    return (ViewportTrackingConfiguration)viewportConfigProvider.get();
  }
  
  public final ViewPortManager viewportManager()
  {
    return (ViewPortManager)viewportManagerProvider.get();
  }
  
  public final WebRouter webRouter()
  {
    return (WebRouter)webRouterProvider.get();
  }
  
  public final WebRouterUtil webRouterUtil()
  {
    return (WebRouterUtil)webRouterUtilProvider.get();
  }
  
  public final WebViewLoadProxy webViewLoadProxy()
  {
    return (WebViewLoadProxy)webViewLoadProxyProvider.get();
  }
  
  public final WvmpDataProvider wvmpDataProvider()
  {
    return (WvmpDataProvider)wvmpDataProvider.get();
  }
  
  public static final class Builder
  {
    public ActivityModule activityModule;
    public ApplicationComponent applicationComponent;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.components.DaggerActivityComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */