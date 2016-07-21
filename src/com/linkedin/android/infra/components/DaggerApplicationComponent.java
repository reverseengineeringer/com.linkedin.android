package com.linkedin.android.infra.components;

import android.content.Context;
import android.os.Handler;
import com.linkedin.CrossPromoLib.api.CrossPromoManager;
import com.linkedin.android.appwidget.AppWidgetKeyValueStore;
import com.linkedin.android.axle.rta.RateTheApp;
import com.linkedin.android.datamanager.DataManager;
import com.linkedin.android.datamanager.interfaces.LocalDataStore;
import com.linkedin.android.datamanager.interfaces.NetworkDataStore;
import com.linkedin.android.deeplink.helper.DeeplinkHelper;
import com.linkedin.android.deeplink.helper.DeferredDeeplinkHelper;
import com.linkedin.android.developer.OAuthNetworkHelper;
import com.linkedin.android.entities.company.CompanyIntent;
import com.linkedin.android.entities.company.CompanyIntent_Factory;
import com.linkedin.android.entities.group.GroupDiscussionIntent;
import com.linkedin.android.entities.group.GroupDiscussionIntent_Factory;
import com.linkedin.android.entities.group.GroupIntent;
import com.linkedin.android.entities.group.GroupIntent_Factory;
import com.linkedin.android.entities.job.JobIntent;
import com.linkedin.android.entities.job.JobIntent_Factory;
import com.linkedin.android.entities.jymbii.JymbiiIntent;
import com.linkedin.android.entities.jymbii.JymbiiIntent_Factory;
import com.linkedin.android.entities.school.SchoolIntent;
import com.linkedin.android.entities.school.SchoolIntent_Factory;
import com.linkedin.android.feed.DeepLinkArticleIntent;
import com.linkedin.android.feed.DeepLinkArticleIntent_Factory;
import com.linkedin.android.feed.actorlist.FeedActorListBundleBuilder;
import com.linkedin.android.feed.actorlist.FeedActorListIntent;
import com.linkedin.android.feed.actorlist.FeedActorListIntent_Factory;
import com.linkedin.android.feed.actorlist.connectionsdetail.FeedConnectionUpdatesDetailFragmentFactory;
import com.linkedin.android.feed.actorlist.connectionsdetail.FeedConnectionUpdatesDetailFragmentFactory_Factory;
import com.linkedin.android.feed.actorlist.pymkdetail.FeedPymkUpdatesDetailFragmentFactory;
import com.linkedin.android.feed.actorlist.pymkdetail.FeedPymkUpdatesDetailFragmentFactory_Factory;
import com.linkedin.android.feed.aggregate.AggregateBundle;
import com.linkedin.android.feed.aggregate.AggregateFragmentFactory;
import com.linkedin.android.feed.aggregate.AggregateFragmentFactory_Factory;
import com.linkedin.android.feed.aggregate.AggregateIntent;
import com.linkedin.android.feed.aggregate.AggregateIntent_Factory;
import com.linkedin.android.feed.channel.ChannelBundle;
import com.linkedin.android.feed.channel.ChannelFragmentFactory;
import com.linkedin.android.feed.channel.ChannelFragmentFactory_Factory;
import com.linkedin.android.feed.channel.ChannelIntent;
import com.linkedin.android.feed.channel.ChannelIntent_Factory;
import com.linkedin.android.feed.detail.FeedUpdateDetailBundleBuilder;
import com.linkedin.android.feed.detail.FeedUpdateDetailFragmentFactory;
import com.linkedin.android.feed.detail.FeedUpdateDetailFragmentFactory_Factory;
import com.linkedin.android.feed.detail.FeedUpdateDetailIntent;
import com.linkedin.android.feed.detail.FeedUpdateDetailIntent_Factory;
import com.linkedin.android.feed.endor.datamodel.transformer.service.TransformerExecutor;
import com.linkedin.android.feed.followhub.FollowHubBundleBuilder;
import com.linkedin.android.feed.followhub.FollowHubFragmentFactory;
import com.linkedin.android.feed.followhub.FollowHubFragmentFactory_Factory;
import com.linkedin.android.feed.followhub.FollowHubIntent;
import com.linkedin.android.feed.followhub.FollowHubIntent_Factory;
import com.linkedin.android.feed.followhub.FollowHubPackageBundleBuilder;
import com.linkedin.android.feed.followhub.FollowHubPackageFragmentFactory;
import com.linkedin.android.feed.followhub.FollowHubPackageFragmentFactory_Factory;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.page.feed.FeedFragmentFactory;
import com.linkedin.android.feed.page.feed.FeedFragmentFactory_Factory;
import com.linkedin.android.feed.page.feed.newupdatespill.CheckForNewUpdatesRunnable;
import com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateBundle;
import com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateFactory;
import com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateFactory_Factory;
import com.linkedin.android.feed.promptresponselist.FeedPromptResponseListFragmentFactory;
import com.linkedin.android.feed.promptresponselist.FeedPromptResponseListFragmentFactory_Factory;
import com.linkedin.android.feed.promptresponselist.FeedPromptResponseListIntent;
import com.linkedin.android.feed.promptresponselist.FeedPromptResponseListIntent_Factory;
import com.linkedin.android.feed.promptresponselist.PromptResponseListBundleBuilder;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.feed.shared.imageviewer.ImageViewerBundle;
import com.linkedin.android.feed.shared.imageviewer.ImageViewerFragmentFactory;
import com.linkedin.android.feed.shared.imageviewer.ImageViewerFragmentFactory_Factory;
import com.linkedin.android.feed.shared.imageviewer.ImageViewerIntent;
import com.linkedin.android.feed.shared.imageviewer.ImageViewerIntent_Factory;
import com.linkedin.android.feed.shared.liking.LikePublisher;
import com.linkedin.android.feed.shared.videoviewer.VideoViewerBundle;
import com.linkedin.android.feed.shared.videoviewer.VideoViewerFragmentFactory;
import com.linkedin.android.feed.shared.videoviewer.VideoViewerFragmentFactory_Factory;
import com.linkedin.android.feed.shared.videoviewer.VideoViewerIntent;
import com.linkedin.android.feed.shared.videoviewer.VideoViewerIntent_Factory;
import com.linkedin.android.feed.tracking.SponsoredUpdateTracker;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailBundleBuilder;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragmentFactory;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragmentFactory_Factory;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailIntent;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailIntent_Factory;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDetailBundleBuilder;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDetailFragmentFactory;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDetailFragmentFactory_Factory;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDetailIntent;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDetailIntent_Factory;
import com.linkedin.android.feed.utils.FeedKeyValueStore;
import com.linkedin.android.feed.utils.FeedModule;
import com.linkedin.android.feed.utils.FeedModule_ProvideAppwidgetKeyValueStoreFactory;
import com.linkedin.android.feed.utils.FeedModule_ProvideCommentPublisherFactory;
import com.linkedin.android.feed.utils.FeedModule_ProvideFeedKeyValueStoreFactory;
import com.linkedin.android.feed.utils.FeedModule_ProvideGroupsSharePublisherFactory;
import com.linkedin.android.feed.utils.FeedModule_ProvideLikePublisherFactory;
import com.linkedin.android.feed.utils.FeedModule_ProvideNewUpdatesRunnableFactory;
import com.linkedin.android.feed.utils.FeedModule_ProvideSharePublisherFactory;
import com.linkedin.android.feed.utils.FeedModule_ProvideSponsoredUpdateTrackerFactory;
import com.linkedin.android.feed.utils.FeedModule_ProvideUpdateChangeCoordinatorFactory;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.growth.InviteAcceptIntent;
import com.linkedin.android.growth.InviteAcceptIntent_Factory;
import com.linkedin.android.growth.SendInviteIntent;
import com.linkedin.android.growth.SendInviteIntent_Factory;
import com.linkedin.android.growth.abi.AbiAutoSyncManager;
import com.linkedin.android.growth.abi.AbiAutoSyncManager_Factory;
import com.linkedin.android.growth.abi.AbiAutoSyncManager_MembersInjector;
import com.linkedin.android.growth.abi.AbiCacheUtils;
import com.linkedin.android.growth.abi.AbiCacheUtils_Factory;
import com.linkedin.android.growth.abi.AbiContactsReader;
import com.linkedin.android.growth.abi.AbiIntent;
import com.linkedin.android.growth.abi.AbiIntentBundle;
import com.linkedin.android.growth.abi.AbiIntent_Factory;
import com.linkedin.android.growth.abi.AbiLoadContactsFragmentFactory;
import com.linkedin.android.growth.abi.AbiLoadContactsFragmentFactory_Factory;
import com.linkedin.android.growth.abi.WyloIntent;
import com.linkedin.android.growth.abi.WyloIntent_Factory;
import com.linkedin.android.growth.abi.m2g.MainAbiM2GEmailFragmentFactory;
import com.linkedin.android.growth.abi.m2g.MainAbiM2GEmailFragmentFactory_Factory;
import com.linkedin.android.growth.abi.m2g.MainAbiM2GSmsFragmentFactory;
import com.linkedin.android.growth.abi.m2g.MainAbiM2GSmsFragmentFactory_Factory;
import com.linkedin.android.growth.abi.m2g.MainAbiM2GUnifiedSmsEmailFragmentFactory;
import com.linkedin.android.growth.abi.m2g.MainAbiM2GUnifiedSmsEmailFragmentFactory_Factory;
import com.linkedin.android.growth.abi.m2m.MainAbiM2MFragmentFactory;
import com.linkedin.android.growth.abi.m2m.MainAbiM2MFragmentFactory_Factory;
import com.linkedin.android.growth.abi.splash.AbiLearnMoreFragmentFractory;
import com.linkedin.android.growth.abi.splash.AbiLearnMoreFragmentFractory_Factory;
import com.linkedin.android.growth.abi.splash.MainAbiSplashFragmentFactory;
import com.linkedin.android.growth.abi.splash.MainAbiSplashFragmentFactory_Factory;
import com.linkedin.android.growth.boost.BoostIntent;
import com.linkedin.android.growth.boost.BoostIntent_Factory;
import com.linkedin.android.growth.boost.error.BoostErrorFragmentFactory;
import com.linkedin.android.growth.boost.error.BoostErrorFragmentFactory_Factory;
import com.linkedin.android.growth.boost.splash.BoostSplashFragmentFactory;
import com.linkedin.android.growth.boost.splash.BoostSplashFragmentFactory_Factory;
import com.linkedin.android.growth.calendar.CalendarLearnMoreFragmentFactory;
import com.linkedin.android.growth.calendar.CalendarLearnMoreFragmentFactory_Factory;
import com.linkedin.android.growth.calendar.sync.CalendarSyncManager;
import com.linkedin.android.growth.heathrow.HeathrowIntent;
import com.linkedin.android.growth.heathrow.HeathrowIntent_Factory;
import com.linkedin.android.growth.login.LoginIntent;
import com.linkedin.android.growth.login.LoginIntent_Factory;
import com.linkedin.android.growth.login.join.JoinFragmentFactory;
import com.linkedin.android.growth.login.join.JoinFragmentFactory_Factory;
import com.linkedin.android.growth.login.login.LoginFragmentFactory;
import com.linkedin.android.growth.login.login.LoginFragmentFactory_Factory;
import com.linkedin.android.growth.login.phoneverification.PhoneConfirmationBundle;
import com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragmentFactory;
import com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragmentFactory_Factory;
import com.linkedin.android.growth.login.phoneverification.PinVerificationBundle;
import com.linkedin.android.growth.login.phoneverification.PinVerificationFragmentFactory;
import com.linkedin.android.growth.login.phoneverification.PinVerificationFragmentFactory_Factory;
import com.linkedin.android.growth.login.prereg.PreRegFragmentFactory;
import com.linkedin.android.growth.login.prereg.PreRegFragmentFactory_Factory;
import com.linkedin.android.growth.login.sso.SSOFragmentFactory;
import com.linkedin.android.growth.login.sso.SSOFragmentFactory_Factory;
import com.linkedin.android.growth.newtovoyager.NewToVoyagerManager;
import com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerFeedFragmentFactory;
import com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerFeedFragmentFactory_Factory;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroBundle;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFragmentFactory;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFragmentFactory_Factory;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroIntent;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroIntent_Factory;
import com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroDialogFragmentBundleBuilder;
import com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroDialogFragmentFactory;
import com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroDialogFragmentFactory_Factory;
import com.linkedin.android.growth.onboarding.OnboardingIntent;
import com.linkedin.android.growth.onboarding.OnboardingIntent_Factory;
import com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GEmailFragmentFactory;
import com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GEmailFragmentFactory_Factory;
import com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GSmsFragmentFactory;
import com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GSmsFragmentFactory_Factory;
import com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GUnifiedSMSEmailFragmentFactory;
import com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GUnifiedSMSEmailFragmentFactory_Factory;
import com.linkedin.android.growth.onboarding.abi.m2m.OnboardingAbiM2MFragmentFactory;
import com.linkedin.android.growth.onboarding.abi.m2m.OnboardingAbiM2MFragmentFactory_Factory;
import com.linkedin.android.growth.onboarding.abi.splash.OnboardingAbiSplashFragmentFactory;
import com.linkedin.android.growth.onboarding.abi.splash.OnboardingAbiSplashFragmentFactory_Factory;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationBundle;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragmentFactory;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragmentFactory_Factory;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationLoadingFragmentFactory;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationLoadingFragmentFactory_Factory;
import com.linkedin.android.growth.onboarding.greeting.GreetingBundle;
import com.linkedin.android.growth.onboarding.greeting.GreetingFragmentFactory;
import com.linkedin.android.growth.onboarding.greeting.GreetingFragmentFactory_Factory;
import com.linkedin.android.growth.onboarding.jobseeker_promo.JobseekerPromoFragmentFactory;
import com.linkedin.android.growth.onboarding.jobseeker_promo.JobseekerPromoFragmentFactory_Factory;
import com.linkedin.android.growth.onboarding.photo.OnboardingPhotoCropBundle;
import com.linkedin.android.growth.onboarding.photo.OnboardingPhotoCropFragmentFactory;
import com.linkedin.android.growth.onboarding.photo.OnboardingPhotoCropFragmentFactory_Factory;
import com.linkedin.android.growth.onboarding.photo.PhotoFragmentFactory;
import com.linkedin.android.growth.onboarding.photo.PhotoFragmentFactory_Factory;
import com.linkedin.android.growth.onboarding.pymk.PymkFragmentFactory;
import com.linkedin.android.growth.onboarding.pymk.PymkFragmentFactory_Factory;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedBundleBuilder;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedFactory;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedFactory_Factory;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedIntent;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedIntent_Factory;
import com.linkedin.android.growth.onboarding.welcome_mat.WelcomeMatFragmentFactory;
import com.linkedin.android.growth.onboarding.welcome_mat.WelcomeMatFragmentFactory_Factory;
import com.linkedin.android.growth.samsung.SamsungSyncConsentIntent;
import com.linkedin.android.growth.samsung.SamsungSyncConsentIntent_Factory;
import com.linkedin.android.growth.seo.samename.SameNameDirectoryIntent;
import com.linkedin.android.growth.seo.samename.SameNameDirectoryIntent_Factory;
import com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentFragmentFactory;
import com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentFragmentFactory_Factory;
import com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentIntent;
import com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentIntentBundleBuilder;
import com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentIntent_Factory;
import com.linkedin.android.growth.takeover.TakeoverIntent;
import com.linkedin.android.growth.takeover.TakeoverIntent_Factory;
import com.linkedin.android.growth.utils.ProgressBarUtil;
import com.linkedin.android.growth.utils.ProgressBarUtil_Factory;
import com.linkedin.android.growth.utils.ThirdPartySdkManager;
import com.linkedin.android.home.HomeCachedLix;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeIntent_Factory;
import com.linkedin.android.identity.edit.ProfileEditDeeplinkIntent;
import com.linkedin.android.identity.edit.ProfileEditDeeplinkIntent_Factory;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditIntent;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditIntent_Factory;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementIntent;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementIntent_Factory;
import com.linkedin.android.identity.me.contentanalytics.ContentAnalyticsIntentBuilder;
import com.linkedin.android.identity.me.contentanalytics.ContentAnalyticsIntentBuilder_Factory;
import com.linkedin.android.identity.me.notifications.NotificationsBundleBuilder;
import com.linkedin.android.identity.me.notifications.NotificationsFragmentFactory;
import com.linkedin.android.identity.me.notifications.NotificationsFragmentFactory_Factory;
import com.linkedin.android.identity.me.shared.paging.MeDedupProxy;
import com.linkedin.android.identity.me.shared.util.ViewPagerManager;
import com.linkedin.android.identity.me.wvmp.MeWvmpIntentBuilder;
import com.linkedin.android.identity.me.wvmp.MeWvmpIntentBuilder_Factory;
import com.linkedin.android.identity.me.wvmp.privatemode.MeWvmpPrivateModeIntentBuilder;
import com.linkedin.android.identity.me.wvmp.privatemode.MeWvmpPrivateModeIntentBuilder_Factory;
import com.linkedin.android.identity.profile.ProfileBundleBuilder;
import com.linkedin.android.identity.profile.ProfileViewFragmentFactory;
import com.linkedin.android.identity.profile.ProfileViewFragmentFactory_Factory;
import com.linkedin.android.identity.profile.ProfileViewIntent;
import com.linkedin.android.identity.profile.ProfileViewIntent_Factory;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager_Factory;
import com.linkedin.android.identity.shared.ProfilePhotoCropFragmentFactory;
import com.linkedin.android.identity.shared.ProfilePhotoCropFragmentFactory_Factory;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.identity.shared.ProfileUtil_Factory;
import com.linkedin.android.identity.shared.ProfileUtil_MembersInjector;
import com.linkedin.android.imageloader.interfaces.ImageLoader;
import com.linkedin.android.imageloader.interfaces.ImageLoaderCache;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentFactory;
import com.linkedin.android.infra.FragmentFactory_MembersInjector;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.FragmentRegistry_Factory;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.IntentRegistry_Factory;
import com.linkedin.android.infra.animations.AnimationProxy;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.LaunchUtils;
import com.linkedin.android.infra.app.NavigationManager;
import com.linkedin.android.infra.app.NavigationManager_Factory;
import com.linkedin.android.infra.data.Cache;
import com.linkedin.android.infra.data.FlagshipCacheManager;
import com.linkedin.android.infra.data.FlagshipCacheManager_Factory;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipDiskCache;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.FlagshipSharedPreferences_Factory;
import com.linkedin.android.infra.data.TitanDataMigrationManager;
import com.linkedin.android.infra.data.TitanDataMigrationManager_Factory;
import com.linkedin.android.infra.data.buffer.ByteBufferPool;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.Bus_Factory;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.gms.GeoLocator;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.infra.mediaupload.MediaUploader;
import com.linkedin.android.infra.modules.ApplicationModule;
import com.linkedin.android.infra.modules.ApplicationModule_ImageLoaderCacheFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ImageLoaderFactory;
import com.linkedin.android.infra.modules.ApplicationModule_InternationalizationApiFactory;
import com.linkedin.android.infra.modules.ApplicationModule_PaymentServiceFactory;
import com.linkedin.android.infra.modules.ApplicationModule_PlaceholderImageCacheFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideAnimationProxyFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideApplicationContextFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideApplicationFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideAssetLoaderNetworkClientFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideAuthFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideAuthHttpStackFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideAuthenticatedLixManagerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideCalendarSyncManagerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideCalendarTaskUtilFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideCommTrackerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideConfigurationManagerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideConsistencyManagerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideCookieUtilFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideCrossPromoManagerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideDeeplinkHelperFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideDeferredDeeplinkHelperFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideDeviceClassFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideExecutorServiceFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideFlagshipAssetManagerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideGeoLocatorFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideImageLoaderNetworkClientFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideLaunchUtilsFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideMainHandlerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideMeDedupProxyFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideMediaCenterFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideNetworkClientFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideNewToVoyagerManagerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideNotificationDisplayUtilsFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideOAuthNetworkHelperFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvidePreAuthLixManagerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideRateTheAppFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideRealTimeManagerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideRefWatcherFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideScheduledExecutorServiceFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideSearchUtilsFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideSynchronousBackgroundQueueFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideTermsOfServiceFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideThirdPartySdkManagerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideTrackerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideTrackingNetworkStackFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideViewPagerObserverFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideVoyagerRequestFactoryFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideWebRouterFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideWebRouterUtilFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvideWebViewLoadProxyFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProviderPerfTrackerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvidesAbiContactsReaderFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvidesBadgerFactory;
import com.linkedin.android.infra.modules.ApplicationModule_ProvidesHomeCachedLixFactory;
import com.linkedin.android.infra.modules.ApplicationModule_TopicRegistryFactory;
import com.linkedin.android.infra.modules.DataManagerModule;
import com.linkedin.android.infra.modules.DataManagerModule_ProvideByteBufferPoolFactory;
import com.linkedin.android.infra.modules.DataManagerModule_ProvideCacheManagerFactory;
import com.linkedin.android.infra.modules.DataManagerModule_ProvideConnectionStoreFactory;
import com.linkedin.android.infra.modules.DataManagerModule_ProvideDataManagerFactory;
import com.linkedin.android.infra.modules.DataManagerModule_ProvideDiskCacheFactory;
import com.linkedin.android.infra.modules.DataManagerModule_ProvideFlagshipDataManagerFactory;
import com.linkedin.android.infra.modules.DataManagerModule_ProvideLocalDataStoreFactory;
import com.linkedin.android.infra.modules.DataManagerModule_ProvideNetworkDataStoreFactory;
import com.linkedin.android.infra.modules.DataManagerModule_ProvidesCacheFactory;
import com.linkedin.android.infra.modules.UtilModule;
import com.linkedin.android.infra.modules.UtilModule_ProvideCardToastManagerFactory;
import com.linkedin.android.infra.modules.UtilModule_ProvideDelayedExecutionFactory;
import com.linkedin.android.infra.modules.UtilModule_ProvideFollowPublisherFactory;
import com.linkedin.android.infra.modules.UtilModule_ProvideInternetConnectionMonitorFactory;
import com.linkedin.android.infra.modules.UtilModule_ProvideLongClickUtilFactory;
import com.linkedin.android.infra.modules.UtilModule_ProvideMediaUploaderFactory;
import com.linkedin.android.infra.modules.UtilModule_ProvideMemberUtilFactory;
import com.linkedin.android.infra.modules.UtilModule_ProvideMessengerLongClickUtilFactory;
import com.linkedin.android.infra.modules.UtilModule_ProvideReportEntityInvokerHelperFactory;
import com.linkedin.android.infra.modules.UtilModule_ProvideSnackbarUtilFactory;
import com.linkedin.android.infra.modules.UtilModule_ProvideViewPagerManagerFactory;
import com.linkedin.android.infra.modules.UtilModule_ProvideViewportConfigFactory;
import com.linkedin.android.infra.modules.UtilModule_ProvideViewportManagerFactory;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.ConfigurationManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.I18NManager_Factory;
import com.linkedin.android.infra.network.ImageLoaderNetworkClient;
import com.linkedin.android.infra.network.ImageQualityManager;
import com.linkedin.android.infra.network.ImageQualityManager_Factory;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.MediaProcessorSizeComparator_Factory;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.network.PlaceholderImageCache;
import com.linkedin.android.infra.network.VoyagerRequestFactory;
import com.linkedin.android.infra.realtime.RealTimeManager;
import com.linkedin.android.infra.realtime.TopicRegistry;
import com.linkedin.android.infra.semaphore.ReportEntityInvokerHelper;
import com.linkedin.android.infra.settings.SettingsFragmentFactory;
import com.linkedin.android.infra.settings.SettingsFragmentFactory_Factory;
import com.linkedin.android.infra.settings.SettingsIntent;
import com.linkedin.android.infra.settings.SettingsIntent_Factory;
import com.linkedin.android.infra.shared.AppUpgradeUtils;
import com.linkedin.android.infra.shared.AppUpgradeUtils_Factory;
import com.linkedin.android.infra.shared.CalendarTaskUtil;
import com.linkedin.android.infra.shared.InternetConnectionMonitor;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Optional;
import com.linkedin.android.infra.shared.PhotoCropBundle;
import com.linkedin.android.infra.shared.PhotoCropFragmentFactory;
import com.linkedin.android.infra.shared.PhotoUtils;
import com.linkedin.android.infra.shared.PhotoUtils_Factory;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.TimeWrapper;
import com.linkedin.android.infra.shared.TimeWrapper_Factory;
import com.linkedin.android.infra.tos.TermsOfServiceInterface;
import com.linkedin.android.infra.ui.ViewPagerObserver;
import com.linkedin.android.infra.ui.cardtoast.CardToastManager;
import com.linkedin.android.infra.viewport.ViewportTrackingConfiguration;
import com.linkedin.android.infra.webviewer.SettingsWebViewerFragmentFactory;
import com.linkedin.android.infra.webviewer.SettingsWebViewerFragmentFactory_Factory;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewLoadProxy;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.android.infra.webviewer.WebViewerFragmentFactory;
import com.linkedin.android.infra.webviewer.WebViewerFragmentFactory_Factory;
import com.linkedin.android.infra.webviewer.WebViewerIntent;
import com.linkedin.android.infra.webviewer.WebViewerIntent_Factory;
import com.linkedin.android.l2m.badge.Badger;
import com.linkedin.android.l2m.badge.OuterBadge;
import com.linkedin.android.l2m.badge.OuterBadge_Factory;
import com.linkedin.android.l2m.deeplink.CommTracker;
import com.linkedin.android.l2m.deeplink.DeepLinkHelperIntent;
import com.linkedin.android.l2m.deeplink.DeepLinkHelperIntent_Factory;
import com.linkedin.android.l2m.deeplink.DeepLinkManager;
import com.linkedin.android.l2m.deeplink.DeepLinkManager_Factory;
import com.linkedin.android.l2m.notification.NotificationDisplayUtils;
import com.linkedin.android.l2m.notification.NotificationUtils;
import com.linkedin.android.l2m.notification.NotificationUtils_Factory;
import com.linkedin.android.liauthlib.network.HttpStack;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.messaging.MessagingBundleBuilder;
import com.linkedin.android.messaging.MessagingFragmentFactory;
import com.linkedin.android.messaging.MessagingFragmentFactory_Factory;
import com.linkedin.android.messaging.compose.ComposeIntent;
import com.linkedin.android.messaging.compose.ComposeIntent_Factory;
import com.linkedin.android.messaging.compose.InmailComposeIntent;
import com.linkedin.android.messaging.compose.InmailComposeIntent_Factory;
import com.linkedin.android.messaging.conversationlist.ConversationSearchListIntent;
import com.linkedin.android.messaging.conversationlist.ConversationSearchListIntent_Factory;
import com.linkedin.android.messaging.integration.AssetLoaderNetworkClient;
import com.linkedin.android.messaging.integration.FlagshipAssetManager;
import com.linkedin.android.messaging.integration.MessagingDataEventHandler;
import com.linkedin.android.messaging.integration.MessagingDataEventHandler_Factory;
import com.linkedin.android.messaging.messagelist.AttachmentViewerIntent;
import com.linkedin.android.messaging.messagelist.AttachmentViewerIntent_Factory;
import com.linkedin.android.messaging.messagelist.MessageListIntent;
import com.linkedin.android.messaging.messagelist.MessageListIntent_Factory;
import com.linkedin.android.messaging.participantdetails.AddParticipantIntent;
import com.linkedin.android.messaging.participantdetails.AddParticipantIntent_Factory;
import com.linkedin.android.messaging.participantdetails.ParticipantDetailsIntent;
import com.linkedin.android.messaging.participantdetails.ParticipantDetailsIntent_Factory;
import com.linkedin.android.messaging.reconnect.ReconnectIntent;
import com.linkedin.android.messaging.reconnect.ReconnectIntent_Factory;
import com.linkedin.android.messaging.stickers.StickerStoreIntent;
import com.linkedin.android.messaging.stickers.StickerStoreIntent_Factory;
import com.linkedin.android.networking.cookies.CookieUtil;
import com.linkedin.android.networking.interfaces.InternationalizationApi;
import com.linkedin.android.paymentslibrary.api.PaymentService;
import com.linkedin.android.premium.PremiumActivityIntent;
import com.linkedin.android.premium.PremiumActivityIntent_Factory;
import com.linkedin.android.premium.profinder.ProfinderServiceProposalActivityIntent;
import com.linkedin.android.premium.profinder.ProfinderServiceProposalActivityIntent_Factory;
import com.linkedin.android.premium.profinder.ProfinderServiceProposalActivityIntent_MembersInjector;
import com.linkedin.android.publishing.reader.ArticleBundle;
import com.linkedin.android.publishing.reader.ArticleFragmentFactory;
import com.linkedin.android.publishing.reader.ArticleFragmentFactory_Factory;
import com.linkedin.android.publishing.reader.ArticleIntent;
import com.linkedin.android.publishing.reader.ArticleIntent_Factory;
import com.linkedin.android.publishing.sharing.ShareBundle;
import com.linkedin.android.publishing.sharing.ShareFragmentFactory;
import com.linkedin.android.publishing.sharing.ShareFragmentFactory_Factory;
import com.linkedin.android.publishing.sharing.ShareIntent;
import com.linkedin.android.publishing.sharing.ShareIntent_Factory;
import com.linkedin.android.publishing.sharing.compose.FeedSharePublisher;
import com.linkedin.android.publishing.sharing.compose.GroupSharePublisher;
import com.linkedin.android.publishing.sharing.linkpicker.LinkPickerBundle;
import com.linkedin.android.publishing.sharing.linkpicker.LinkPickerFragmentFactory;
import com.linkedin.android.publishing.sharing.linkpicker.LinkPickerFragmentFactory_Factory;
import com.linkedin.android.publishing.sharing.linkpicker.LinkPickerIntent;
import com.linkedin.android.publishing.sharing.linkpicker.LinkPickerIntent_Factory;
import com.linkedin.android.publishing.sharing.mentionpicker.MentionPickerBundle;
import com.linkedin.android.publishing.sharing.mentionpicker.MentionPickerFragmentFactory;
import com.linkedin.android.publishing.sharing.mentionpicker.MentionPickerFragmentFactory_Factory;
import com.linkedin.android.publishing.sharing.mentionpicker.MentionPickerIntent;
import com.linkedin.android.publishing.sharing.mentionpicker.MentionPickerIntent_Factory;
import com.linkedin.android.relationships.ConnectedIntent;
import com.linkedin.android.relationships.ConnectedIntent_Factory;
import com.linkedin.android.relationships.PymkIntent;
import com.linkedin.android.relationships.PymkIntent_Factory;
import com.linkedin.android.relationships.RelationshipsBundleBuilder;
import com.linkedin.android.relationships.RelationshipsFragmentFactory;
import com.linkedin.android.relationships.RelationshipsFragmentFactory_Factory;
import com.linkedin.android.relationships.RelationshipsSecondaryIntent;
import com.linkedin.android.relationships.RelationshipsSecondaryIntent_Factory;
import com.linkedin.android.relationships.addConnections.AddConnectionsIntent;
import com.linkedin.android.relationships.addConnections.AddConnectionsIntent_Factory;
import com.linkedin.android.relationships.connectFlow.AcceptedInvitationIntent;
import com.linkedin.android.relationships.connectFlow.AcceptedInvitationIntent_Factory;
import com.linkedin.android.relationships.connections.ConnectionStore;
import com.linkedin.android.relationships.connections.ConnectionsFetchingManager;
import com.linkedin.android.relationships.connections.ConnectionsFetchingManager_Factory;
import com.linkedin.android.relationships.invitationsConnectionsShared.ConnectionsIntent;
import com.linkedin.android.relationships.invitationsConnectionsShared.ConnectionsIntent_Factory;
import com.linkedin.android.relationships.invitationsConnectionsShared.InvitationsIntent;
import com.linkedin.android.relationships.invitationsConnectionsShared.InvitationsIntent_Factory;
import com.linkedin.android.search.SearchBundleBuilder;
import com.linkedin.android.search.SearchIntent;
import com.linkedin.android.search.SearchIntent_Factory;
import com.linkedin.android.search.resourcelist.ResourceListIntent;
import com.linkedin.android.search.resourcelist.ResourceListIntent_Factory;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.search.starter.SearchStarterFragmentFactory;
import com.linkedin.android.search.starter.SearchStarterFragmentFactory_Factory;
import com.linkedin.android.search.unifiedsearch.SearchFragmentFactory;
import com.linkedin.android.search.unifiedsearch.SearchFragmentFactory_Factory;
import com.linkedin.android.tracking.v2.network.LiTrackingNetworkStack;
import com.linkedin.android.webrouter.core.WebRouter;
import com.linkedin.consistency.ConsistencyManager;
import com.squareup.leakcanary.RefWatcher;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.MembersInjectors.NoOpMembersInjector;
import dagger.internal.ScopedProvider;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Provider;

public final class DaggerApplicationComponent
  implements ApplicationComponent
{
  private MembersInjector<AbiAutoSyncManager> abiAutoSyncManagerMembersInjector;
  private Provider<AbiAutoSyncManager> abiAutoSyncManagerProvider;
  private Provider<AbiCacheUtils> abiCacheUtilsProvider;
  private Provider<AbiIntent> abiIntentProvider;
  private MembersInjector<AbiLearnMoreFragmentFractory> abiLearnMoreFragmentFractoryMembersInjector;
  private Provider<AbiLearnMoreFragmentFractory> abiLearnMoreFragmentFractoryProvider;
  private MembersInjector<AbiLoadContactsFragmentFactory> abiLoadContactsFragmentFactoryMembersInjector;
  private Provider<AbiLoadContactsFragmentFactory> abiLoadContactsFragmentFactoryProvider;
  private Provider<AcceptedInvitationIntent> acceptedInvitationIntentProvider;
  private Provider<AddConnectionsIntent> addConnectionsIntentProvider;
  private Provider<AddParticipantIntent> addParticipantIntentProvider;
  private MembersInjector<AggregateFragmentFactory> aggregateFragmentFactoryMembersInjector;
  private Provider<AggregateFragmentFactory> aggregateFragmentFactoryProvider;
  private Provider<AggregateIntent> aggregateIntentProvider;
  private Provider<AppUpgradeUtils> appUpgradeUtilsProvider;
  private Provider<ApplicationComponent> applicationComponentProvider;
  private MembersInjector<ArticleFragmentFactory> articleFragmentFactoryMembersInjector;
  private Provider<ArticleFragmentFactory> articleFragmentFactoryProvider;
  private Provider<ArticleIntent> articleIntentProvider;
  private Provider<AttachmentViewerIntent> attachmentViewerIntentProvider;
  private MembersInjector<BoostErrorFragmentFactory> boostErrorFragmentFactoryMembersInjector;
  private Provider<BoostErrorFragmentFactory> boostErrorFragmentFactoryProvider;
  private Provider<BoostIntent> boostIntentProvider;
  private MembersInjector<BoostSplashFragmentFactory> boostSplashFragmentFactoryMembersInjector;
  private Provider<BoostSplashFragmentFactory> boostSplashFragmentFactoryProvider;
  private Provider<Bus> busProvider;
  private MembersInjector<CalendarLearnMoreFragmentFactory> calendarLearnMoreFragmentFactoryMembersInjector;
  private Provider<CalendarLearnMoreFragmentFactory> calendarLearnMoreFragmentFactoryProvider;
  private MembersInjector<ChannelFragmentFactory> channelFragmentFactoryMembersInjector;
  private Provider<ChannelFragmentFactory> channelFragmentFactoryProvider;
  private Provider<ChannelIntent> channelIntentProvider;
  private MembersInjector<CommentDetailFragmentFactory> commentDetailFragmentFactoryMembersInjector;
  private Provider<CommentDetailFragmentFactory> commentDetailFragmentFactoryProvider;
  private Provider<CommentDetailIntent> commentDetailIntentProvider;
  private Provider<CompanyIntent> companyIntentProvider;
  private Provider<ComposeIntent> composeIntentProvider;
  private Provider<ConnectedIntent> connectedIntentProvider;
  private Provider<ConnectionsFetchingManager> connectionsFetchingManagerProvider;
  private Provider<ConnectionsIntent> connectionsIntentProvider;
  private Provider<ContentAnalyticsIntentBuilder> contentAnalyticsIntentBuilderProvider;
  private Provider<ConversationSearchListIntent> conversationSearchListIntentProvider;
  private Provider<DeepLinkArticleIntent> deepLinkArticleIntentProvider;
  private Provider<DeepLinkHelperIntent> deepLinkHelperIntentProvider;
  private Provider<DeepLinkManager> deepLinkManagerProvider;
  private MembersInjector<EmailConfirmationFragmentFactory> emailConfirmationFragmentFactoryMembersInjector;
  private Provider<EmailConfirmationFragmentFactory> emailConfirmationFragmentFactoryProvider;
  private MembersInjector<EmailConfirmationLoadingFragmentFactory> emailConfirmationLoadingFragmentFactoryMembersInjector;
  private Provider<EmailConfirmationLoadingFragmentFactory> emailConfirmationLoadingFragmentFactoryProvider;
  private Provider<FeedActorListIntent> feedActorListIntentProvider;
  private MembersInjector<FeedConnectionUpdatesDetailFragmentFactory> feedConnectionUpdatesDetailFragmentFactoryMembersInjector;
  private Provider<FeedConnectionUpdatesDetailFragmentFactory> feedConnectionUpdatesDetailFragmentFactoryProvider;
  private MembersInjector<FeedFragmentFactory> feedFragmentFactoryMembersInjector;
  private Provider<FeedFragmentFactory> feedFragmentFactoryProvider;
  private MembersInjector<FeedPromptResponseListFragmentFactory> feedPromptResponseListFragmentFactoryMembersInjector;
  private Provider<FeedPromptResponseListFragmentFactory> feedPromptResponseListFragmentFactoryProvider;
  private Provider<FeedPromptResponseListIntent> feedPromptResponseListIntentProvider;
  private MembersInjector<FeedPymkUpdatesDetailFragmentFactory> feedPymkUpdatesDetailFragmentFactoryMembersInjector;
  private Provider<FeedPymkUpdatesDetailFragmentFactory> feedPymkUpdatesDetailFragmentFactoryProvider;
  private MembersInjector<FeedUpdateDetailFragmentFactory> feedUpdateDetailFragmentFactoryMembersInjector;
  private Provider<FeedUpdateDetailFragmentFactory> feedUpdateDetailFragmentFactoryProvider;
  private Provider<FeedUpdateDetailIntent> feedUpdateDetailIntentProvider;
  private Provider<FlagshipCacheManager> flagshipCacheManagerProvider;
  private Provider<FlagshipSharedPreferences> flagshipSharedPreferencesProvider;
  private MembersInjector<FollowHubFragmentFactory> followHubFragmentFactoryMembersInjector;
  private Provider<FollowHubFragmentFactory> followHubFragmentFactoryProvider;
  private Provider<FollowHubIntent> followHubIntentProvider;
  private MembersInjector<FollowHubPackageFragmentFactory> followHubPackageFragmentFactoryMembersInjector;
  private Provider<FollowHubPackageFragmentFactory> followHubPackageFragmentFactoryProvider;
  private MembersInjector<FragmentFactory<PhotoCropBundle>> fragmentFactoryMembersInjector;
  private MembersInjector<FragmentFactory<DefaultBundle>> fragmentFactoryMembersInjector1;
  private MembersInjector<FragmentFactory<FeedBundleBuilder>> fragmentFactoryMembersInjector10;
  private MembersInjector<FragmentFactory<FeedUpdateDetailBundleBuilder>> fragmentFactoryMembersInjector11;
  private MembersInjector<FragmentFactory<ShareBundle>> fragmentFactoryMembersInjector12;
  private MembersInjector<FragmentFactory<ChannelBundle>> fragmentFactoryMembersInjector13;
  private MembersInjector<FragmentFactory<AggregateBundle>> fragmentFactoryMembersInjector14;
  private MembersInjector<FragmentFactory<ImageViewerBundle>> fragmentFactoryMembersInjector15;
  private MembersInjector<FragmentFactory<NotificationsBundleBuilder>> fragmentFactoryMembersInjector16;
  private MembersInjector<FragmentFactory<BundleBuilder>> fragmentFactoryMembersInjector17;
  private MembersInjector<FragmentFactory<MessagingBundleBuilder>> fragmentFactoryMembersInjector18;
  private MembersInjector<FragmentFactory<RelationshipsBundleBuilder>> fragmentFactoryMembersInjector19;
  private MembersInjector<FragmentFactory<NewToVoyagerIntroBundle>> fragmentFactoryMembersInjector2;
  private MembersInjector<FragmentFactory<SearchBundleBuilder>> fragmentFactoryMembersInjector20;
  private MembersInjector<FragmentFactory<WebViewerBundle>> fragmentFactoryMembersInjector21;
  private MembersInjector<FragmentFactory<ArticleBundle>> fragmentFactoryMembersInjector22;
  private MembersInjector<FragmentFactory<VideoViewerBundle>> fragmentFactoryMembersInjector23;
  private MembersInjector<FragmentFactory<LikesDetailBundleBuilder>> fragmentFactoryMembersInjector24;
  private MembersInjector<FragmentFactory<LinkPickerBundle>> fragmentFactoryMembersInjector25;
  private MembersInjector<FragmentFactory<MentionPickerBundle>> fragmentFactoryMembersInjector26;
  private MembersInjector<FragmentFactory<NewToVoyagerIntroDialogFragmentBundleBuilder>> fragmentFactoryMembersInjector27;
  private MembersInjector<FragmentFactory<UnfollowEducateBundle>> fragmentFactoryMembersInjector28;
  private MembersInjector<FragmentFactory<ProfileBundleBuilder>> fragmentFactoryMembersInjector29;
  private MembersInjector<FragmentFactory<PhoneConfirmationBundle>> fragmentFactoryMembersInjector3;
  private MembersInjector<FragmentFactory<SmsReminderConsentIntentBundleBuilder>> fragmentFactoryMembersInjector30;
  private MembersInjector<FragmentFactory<FeedActorListBundleBuilder>> fragmentFactoryMembersInjector31;
  private MembersInjector<FragmentFactory<CommentDetailBundleBuilder>> fragmentFactoryMembersInjector32;
  private MembersInjector<FragmentFactory<PromptResponseListBundleBuilder>> fragmentFactoryMembersInjector33;
  private MembersInjector<FragmentFactory<FollowHubBundleBuilder>> fragmentFactoryMembersInjector34;
  private MembersInjector<FragmentFactory<FollowHubPackageBundleBuilder>> fragmentFactoryMembersInjector35;
  private MembersInjector<FragmentFactory<PinVerificationBundle>> fragmentFactoryMembersInjector4;
  private MembersInjector<FragmentFactory<GreetingBundle>> fragmentFactoryMembersInjector5;
  private MembersInjector<FragmentFactory<AbiIntentBundle>> fragmentFactoryMembersInjector6;
  private MembersInjector<FragmentFactory<RebuildMyFeedBundleBuilder>> fragmentFactoryMembersInjector7;
  private MembersInjector<FragmentFactory<OnboardingPhotoCropBundle>> fragmentFactoryMembersInjector8;
  private MembersInjector<FragmentFactory<EmailConfirmationBundle>> fragmentFactoryMembersInjector9;
  private Provider<FragmentRegistry> fragmentRegistryProvider;
  private MembersInjector<GreetingFragmentFactory> greetingFragmentFactoryMembersInjector;
  private Provider<GreetingFragmentFactory> greetingFragmentFactoryProvider;
  private Provider<GroupDiscussionIntent> groupDiscussionIntentProvider;
  private Provider<GroupIntent> groupIntentProvider;
  private Provider<GuidedEditIntent> guidedEditIntentProvider;
  private Provider<HeathrowIntent> heathrowIntentProvider;
  private Provider<HomeIntent> homeIntentProvider;
  private Provider<I18NManager> i18NManagerProvider;
  private Provider<ImageLoaderCache> imageLoaderCacheProvider;
  private Provider<ImageLoader> imageLoaderProvider;
  private Provider<ImageQualityManager> imageQualityManagerProvider;
  private MembersInjector<ImageViewerFragmentFactory> imageViewerFragmentFactoryMembersInjector;
  private Provider<ImageViewerFragmentFactory> imageViewerFragmentFactoryProvider;
  private Provider<ImageViewerIntent> imageViewerIntentProvider;
  private Provider<InmailComposeIntent> inmailComposeIntentProvider;
  private Provider<IntentRegistry> intentRegistryProvider;
  private Provider<InternationalizationApi> internationalizationApiProvider;
  private Provider<InvitationsIntent> invitationsIntentProvider;
  private Provider<InviteAcceptIntent> inviteAcceptIntentProvider;
  private Provider<JobIntent> jobIntentProvider;
  private MembersInjector<JobseekerPromoFragmentFactory> jobseekerPromoFragmentFactoryMembersInjector;
  private Provider<JobseekerPromoFragmentFactory> jobseekerPromoFragmentFactoryProvider;
  private MembersInjector<JoinFragmentFactory> joinFragmentFactoryMembersInjector;
  private Provider<JoinFragmentFactory> joinFragmentFactoryProvider;
  private Provider<JymbiiIntent> jymbiiIntentProvider;
  private MembersInjector<LikesDetailFragmentFactory> likesDetailFragmentFactoryMembersInjector;
  private Provider<LikesDetailFragmentFactory> likesDetailFragmentFactoryProvider;
  private Provider<LikesDetailIntent> likesDetailIntentProvider;
  private MembersInjector<LinkPickerFragmentFactory> linkPickerFragmentFactoryMembersInjector;
  private Provider<LinkPickerFragmentFactory> linkPickerFragmentFactoryProvider;
  private Provider<LinkPickerIntent> linkPickerIntentProvider;
  private MembersInjector<LoginFragmentFactory> loginFragmentFactoryMembersInjector;
  private Provider<LoginFragmentFactory> loginFragmentFactoryProvider;
  private Provider<LoginIntent> loginIntentProvider;
  private MembersInjector<MainAbiM2GEmailFragmentFactory> mainAbiM2GEmailFragmentFactoryMembersInjector;
  private Provider<MainAbiM2GEmailFragmentFactory> mainAbiM2GEmailFragmentFactoryProvider;
  private MembersInjector<MainAbiM2GSmsFragmentFactory> mainAbiM2GSmsFragmentFactoryMembersInjector;
  private Provider<MainAbiM2GSmsFragmentFactory> mainAbiM2GSmsFragmentFactoryProvider;
  private MembersInjector<MainAbiM2GUnifiedSmsEmailFragmentFactory> mainAbiM2GUnifiedSmsEmailFragmentFactoryMembersInjector;
  private Provider<MainAbiM2GUnifiedSmsEmailFragmentFactory> mainAbiM2GUnifiedSmsEmailFragmentFactoryProvider;
  private MembersInjector<MainAbiM2MFragmentFactory> mainAbiM2MFragmentFactoryMembersInjector;
  private Provider<MainAbiM2MFragmentFactory> mainAbiM2MFragmentFactoryProvider;
  private MembersInjector<MainAbiSplashFragmentFactory> mainAbiSplashFragmentFactoryMembersInjector;
  private Provider<MainAbiSplashFragmentFactory> mainAbiSplashFragmentFactoryProvider;
  private Provider<MeWvmpIntentBuilder> meWvmpIntentBuilderProvider;
  private Provider<MeWvmpPrivateModeIntentBuilder> meWvmpPrivateModeIntentBuilderProvider;
  private MembersInjector<MentionPickerFragmentFactory> mentionPickerFragmentFactoryMembersInjector;
  private Provider<MentionPickerFragmentFactory> mentionPickerFragmentFactoryProvider;
  private Provider<MentionPickerIntent> mentionPickerIntentProvider;
  private Provider<MessageListIntent> messageListIntentProvider;
  private Provider<MessagingDataEventHandler> messagingDataEventHandlerProvider;
  private MembersInjector<MessagingFragmentFactory> messagingFragmentFactoryMembersInjector;
  private Provider<MessagingFragmentFactory> messagingFragmentFactoryProvider;
  private Provider<NavigationManager> navigationManagerProvider;
  private MembersInjector<NewToVoyagerFeedFragmentFactory> newToVoyagerFeedFragmentFactoryMembersInjector;
  private Provider<NewToVoyagerFeedFragmentFactory> newToVoyagerFeedFragmentFactoryProvider;
  private MembersInjector<NewToVoyagerIntroDialogFragmentFactory> newToVoyagerIntroDialogFragmentFactoryMembersInjector;
  private Provider<NewToVoyagerIntroDialogFragmentFactory> newToVoyagerIntroDialogFragmentFactoryProvider;
  private MembersInjector<NewToVoyagerIntroFragmentFactory> newToVoyagerIntroFragmentFactoryMembersInjector;
  private Provider<NewToVoyagerIntroFragmentFactory> newToVoyagerIntroFragmentFactoryProvider;
  private Provider<NewToVoyagerIntroIntent> newToVoyagerIntroIntentProvider;
  private Provider<NotificationUtils> notificationUtilsProvider;
  private MembersInjector<NotificationsFragmentFactory> notificationsFragmentFactoryMembersInjector;
  private Provider<NotificationsFragmentFactory> notificationsFragmentFactoryProvider;
  private MembersInjector<OnboardingAbiM2GEmailFragmentFactory> onboardingAbiM2GEmailFragmentFactoryMembersInjector;
  private Provider<OnboardingAbiM2GEmailFragmentFactory> onboardingAbiM2GEmailFragmentFactoryProvider;
  private MembersInjector<OnboardingAbiM2GSmsFragmentFactory> onboardingAbiM2GSmsFragmentFactoryMembersInjector;
  private Provider<OnboardingAbiM2GSmsFragmentFactory> onboardingAbiM2GSmsFragmentFactoryProvider;
  private MembersInjector<OnboardingAbiM2GUnifiedSMSEmailFragmentFactory> onboardingAbiM2GUnifiedSMSEmailFragmentFactoryMembersInjector;
  private Provider<OnboardingAbiM2GUnifiedSMSEmailFragmentFactory> onboardingAbiM2GUnifiedSMSEmailFragmentFactoryProvider;
  private MembersInjector<OnboardingAbiM2MFragmentFactory> onboardingAbiM2MFragmentFactoryMembersInjector;
  private Provider<OnboardingAbiM2MFragmentFactory> onboardingAbiM2MFragmentFactoryProvider;
  private MembersInjector<OnboardingAbiSplashFragmentFactory> onboardingAbiSplashFragmentFactoryMembersInjector;
  private Provider<OnboardingAbiSplashFragmentFactory> onboardingAbiSplashFragmentFactoryProvider;
  private Provider<OnboardingIntent> onboardingIntentProvider;
  private MembersInjector<OnboardingPhotoCropFragmentFactory> onboardingPhotoCropFragmentFactoryMembersInjector;
  private Provider<OnboardingPhotoCropFragmentFactory> onboardingPhotoCropFragmentFactoryProvider;
  private Provider<OuterBadge> outerBadgeProvider;
  private Provider<ParticipantDetailsIntent> participantDetailsIntentProvider;
  private Provider<PaymentService> paymentServiceProvider;
  private Provider<PendingEndorsementIntent> pendingEndorsementIntentProvider;
  private MembersInjector<PhoneConfirmationFragmentFactory> phoneConfirmationFragmentFactoryMembersInjector;
  private Provider<PhoneConfirmationFragmentFactory> phoneConfirmationFragmentFactoryProvider;
  private MembersInjector<PhotoCropFragmentFactory<OnboardingPhotoCropBundle>> photoCropFragmentFactoryMembersInjector;
  private MembersInjector<PhotoFragmentFactory> photoFragmentFactoryMembersInjector;
  private Provider<PhotoFragmentFactory> photoFragmentFactoryProvider;
  private Provider<PhotoUtils> photoUtilsProvider;
  private MembersInjector<PinVerificationFragmentFactory> pinVerificationFragmentFactoryMembersInjector;
  private Provider<PinVerificationFragmentFactory> pinVerificationFragmentFactoryProvider;
  private Provider<PlaceholderImageCache> placeholderImageCacheProvider;
  private MembersInjector<PreRegFragmentFactory> preRegFragmentFactoryMembersInjector;
  private Provider<PreRegFragmentFactory> preRegFragmentFactoryProvider;
  private Provider<PremiumActivityIntent> premiumActivityIntentProvider;
  private Provider<ProfileEditDeeplinkIntent> profileEditDeeplinkIntentProvider;
  private Provider<ProfilePendingConnectionRequestManager> profilePendingConnectionRequestManagerProvider;
  private MembersInjector<ProfilePhotoCropFragmentFactory<PhotoCropBundle>> profilePhotoCropFragmentFactoryMembersInjector;
  private Provider<ProfilePhotoCropFragmentFactory<PhotoCropBundle>> profilePhotoCropFragmentFactoryProvider;
  private MembersInjector<ProfileUtil> profileUtilMembersInjector;
  private Provider<ProfileUtil> profileUtilProvider;
  private MembersInjector<ProfileViewFragmentFactory> profileViewFragmentFactoryMembersInjector;
  private Provider<ProfileViewFragmentFactory> profileViewFragmentFactoryProvider;
  private Provider<ProfileViewIntent> profileViewIntentProvider;
  private MembersInjector<ProfinderServiceProposalActivityIntent> profinderServiceProposalActivityIntentMembersInjector;
  private Provider<ProfinderServiceProposalActivityIntent> profinderServiceProposalActivityIntentProvider;
  private Provider<AnimationProxy> provideAnimationProxyProvider;
  private Provider<Context> provideApplicationContextProvider;
  private Provider<FlagshipApplication> provideApplicationProvider;
  private Provider<AppWidgetKeyValueStore> provideAppwidgetKeyValueStoreProvider;
  private Provider<AssetLoaderNetworkClient> provideAssetLoaderNetworkClientProvider;
  private Provider<HttpStack> provideAuthHttpStackProvider;
  private Provider<Auth> provideAuthProvider;
  private Provider<LixManager> provideAuthenticatedLixManagerProvider;
  private Provider<ByteBufferPool> provideByteBufferPoolProvider;
  private Provider<FissionAdapter> provideCacheManagerProvider;
  private Provider<CalendarSyncManager> provideCalendarSyncManagerProvider;
  private Provider<CalendarTaskUtil> provideCalendarTaskUtilProvider;
  private Provider<CardToastManager> provideCardToastManagerProvider;
  private Provider<CommTracker> provideCommTrackerProvider;
  private Provider<CommentPublisher> provideCommentPublisherProvider;
  private Provider<ConfigurationManager> provideConfigurationManagerProvider;
  private Provider<ConnectionStore> provideConnectionStoreProvider;
  private Provider<ConsistencyManager> provideConsistencyManagerProvider;
  private Provider<CookieUtil> provideCookieUtilProvider;
  private Provider<CrossPromoManager> provideCrossPromoManagerProvider;
  private Provider<DataManager> provideDataManagerProvider;
  private Provider<DeeplinkHelper> provideDeeplinkHelperProvider;
  private Provider<DeferredDeeplinkHelper> provideDeferredDeeplinkHelperProvider;
  private Provider<DelayedExecution> provideDelayedExecutionProvider;
  private Provider<Integer> provideDeviceClassProvider;
  private Provider<Optional<FlagshipDiskCache>> provideDiskCacheProvider;
  private Provider<ExecutorService> provideExecutorServiceProvider;
  private Provider<FeedKeyValueStore> provideFeedKeyValueStoreProvider;
  private Provider<FlagshipAssetManager> provideFlagshipAssetManagerProvider;
  private Provider<FlagshipDataManager> provideFlagshipDataManagerProvider;
  private Provider<FollowPublisher> provideFollowPublisherProvider;
  private Provider<GeoLocator> provideGeoLocatorProvider;
  private Provider<GroupSharePublisher> provideGroupsSharePublisherProvider;
  private Provider<ImageLoaderNetworkClient> provideImageLoaderNetworkClientProvider;
  private Provider<InternetConnectionMonitor> provideInternetConnectionMonitorProvider;
  private Provider<LaunchUtils> provideLaunchUtilsProvider;
  private Provider<LikePublisher> provideLikePublisherProvider;
  private Provider<LocalDataStore> provideLocalDataStoreProvider;
  private Provider<com.linkedin.android.infra.shared.LongClickUtil> provideLongClickUtilProvider;
  private Provider<Handler> provideMainHandlerProvider;
  private Provider<MeDedupProxy> provideMeDedupProxyProvider;
  private Provider<MediaCenter> provideMediaCenterProvider;
  private Provider<MediaUploader> provideMediaUploaderProvider;
  private Provider<MemberUtil> provideMemberUtilProvider;
  private Provider<com.linkedin.messengerlib.utils.LongClickUtil> provideMessengerLongClickUtilProvider;
  private Provider<NetworkClient> provideNetworkClientProvider;
  private Provider<NetworkDataStore> provideNetworkDataStoreProvider;
  private Provider<NewToVoyagerManager> provideNewToVoyagerManagerProvider;
  private Provider<CheckForNewUpdatesRunnable> provideNewUpdatesRunnableProvider;
  private Provider<NotificationDisplayUtils> provideNotificationDisplayUtilsProvider;
  private Provider<OAuthNetworkHelper> provideOAuthNetworkHelperProvider;
  private Provider<PreAuthLixManager> providePreAuthLixManagerProvider;
  private Provider<RateTheApp> provideRateTheAppProvider;
  private Provider<RealTimeManager> provideRealTimeManagerProvider;
  private Provider<Optional<RefWatcher>> provideRefWatcherProvider;
  private Provider<ReportEntityInvokerHelper> provideReportEntityInvokerHelperProvider;
  private Provider<ScheduledExecutorService> provideScheduledExecutorServiceProvider;
  private Provider<SearchUtils> provideSearchUtilsProvider;
  private Provider<FeedSharePublisher> provideSharePublisherProvider;
  private Provider<SnackbarUtil> provideSnackbarUtilProvider;
  private Provider<SponsoredUpdateTracker> provideSponsoredUpdateTrackerProvider;
  private Provider<TransformerExecutor> provideSynchronousBackgroundQueueProvider;
  private Provider<TermsOfServiceInterface> provideTermsOfServiceProvider;
  private Provider<ThirdPartySdkManager> provideThirdPartySdkManagerProvider;
  private Provider<Tracker> provideTrackerProvider;
  private Provider<LiTrackingNetworkStack> provideTrackingNetworkStackProvider;
  private Provider<UpdateChangeCoordinator> provideUpdateChangeCoordinatorProvider;
  private Provider<ViewPagerManager> provideViewPagerManagerProvider;
  private Provider<ViewPagerObserver> provideViewPagerObserverProvider;
  private Provider<ViewportTrackingConfiguration> provideViewportConfigProvider;
  private Provider<ViewPortManager> provideViewportManagerProvider;
  private Provider<VoyagerRequestFactory> provideVoyagerRequestFactoryProvider;
  private Provider<WebRouter> provideWebRouterProvider;
  private Provider<WebRouterUtil> provideWebRouterUtilProvider;
  private Provider<WebViewLoadProxy> provideWebViewLoadProxyProvider;
  private Provider<Tracker> providerPerfTrackerProvider;
  private Provider<AbiContactsReader> providesAbiContactsReaderProvider;
  private Provider<Badger> providesBadgerProvider;
  private Provider<Cache<String, ByteBuffer>> providesCacheProvider;
  private Provider<HomeCachedLix> providesHomeCachedLixProvider;
  private MembersInjector<PymkFragmentFactory> pymkFragmentFactoryMembersInjector;
  private Provider<PymkFragmentFactory> pymkFragmentFactoryProvider;
  private Provider<PymkIntent> pymkIntentProvider;
  private MembersInjector<RebuildMyFeedFactory> rebuildMyFeedFactoryMembersInjector;
  private Provider<RebuildMyFeedFactory> rebuildMyFeedFactoryProvider;
  private Provider<RebuildMyFeedIntent> rebuildMyFeedIntentProvider;
  private Provider<ReconnectIntent> reconnectIntentProvider;
  private MembersInjector<RelationshipsFragmentFactory> relationshipsFragmentFactoryMembersInjector;
  private Provider<RelationshipsFragmentFactory> relationshipsFragmentFactoryProvider;
  private Provider<RelationshipsSecondaryIntent> relationshipsSecondaryIntentProvider;
  private Provider<ResourceListIntent> resourceListIntentProvider;
  private MembersInjector<SSOFragmentFactory> sSOFragmentFactoryMembersInjector;
  private Provider<SSOFragmentFactory> sSOFragmentFactoryProvider;
  private Provider<SameNameDirectoryIntent> sameNameDirectoryIntentProvider;
  private Provider<SamsungSyncConsentIntent> samsungSyncConsentIntentProvider;
  private Provider<SchoolIntent> schoolIntentProvider;
  private MembersInjector<SearchFragmentFactory> searchFragmentFactoryMembersInjector;
  private Provider<SearchFragmentFactory> searchFragmentFactoryProvider;
  private Provider<SearchIntent> searchIntentProvider;
  private MembersInjector<SearchStarterFragmentFactory> searchStarterFragmentFactoryMembersInjector;
  private Provider<SearchStarterFragmentFactory> searchStarterFragmentFactoryProvider;
  private Provider<SendInviteIntent> sendInviteIntentProvider;
  private MembersInjector<SettingsFragmentFactory> settingsFragmentFactoryMembersInjector;
  private Provider<SettingsFragmentFactory> settingsFragmentFactoryProvider;
  private Provider<SettingsIntent> settingsIntentProvider;
  private MembersInjector<SettingsWebViewerFragmentFactory> settingsWebViewerFragmentFactoryMembersInjector;
  private Provider<SettingsWebViewerFragmentFactory> settingsWebViewerFragmentFactoryProvider;
  private MembersInjector<ShareFragmentFactory> shareFragmentFactoryMembersInjector;
  private Provider<ShareFragmentFactory> shareFragmentFactoryProvider;
  private Provider<ShareIntent> shareIntentProvider;
  private MembersInjector<SmsReminderConsentFragmentFactory> smsReminderConsentFragmentFactoryMembersInjector;
  private Provider<SmsReminderConsentFragmentFactory> smsReminderConsentFragmentFactoryProvider;
  private Provider<SmsReminderConsentIntent> smsReminderConsentIntentProvider;
  private Provider<StickerStoreIntent> stickerStoreIntentProvider;
  private Provider<TakeoverIntent> takeoverIntentProvider;
  private Provider<TimeWrapper> timeWrapperProvider;
  private Provider<TitanDataMigrationManager> titanDataMigrationManagerProvider;
  private Provider<TopicRegistry> topicRegistryProvider;
  private MembersInjector<UnfollowEducateFactory> unfollowEducateFactoryMembersInjector;
  private Provider<UnfollowEducateFactory> unfollowEducateFactoryProvider;
  private MembersInjector<VideoViewerFragmentFactory> videoViewerFragmentFactoryMembersInjector;
  private Provider<VideoViewerFragmentFactory> videoViewerFragmentFactoryProvider;
  private Provider<VideoViewerIntent> videoViewerIntentProvider;
  private MembersInjector<WebViewerFragmentFactory> webViewerFragmentFactoryMembersInjector;
  private Provider<WebViewerFragmentFactory> webViewerFragmentFactoryProvider;
  private Provider<WebViewerIntent> webViewerIntentProvider;
  private MembersInjector<WelcomeMatFragmentFactory> welcomeMatFragmentFactoryMembersInjector;
  private Provider<WelcomeMatFragmentFactory> welcomeMatFragmentFactoryProvider;
  private Provider<WyloIntent> wyloIntentProvider;
  
  static
  {
    if (!DaggerApplicationComponent.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private DaggerApplicationComponent(Builder paramBuilder)
  {
    assert (paramBuilder != null);
    provideApplicationContextProvider = ScopedProvider.create(ApplicationModule_ProvideApplicationContextFactory.create(applicationModule));
    provideApplicationProvider = ScopedProvider.create(ApplicationModule_ProvideApplicationFactory.create(applicationModule));
    provideExecutorServiceProvider = ScopedProvider.create(ApplicationModule_ProvideExecutorServiceFactory.create(applicationModule));
    flagshipSharedPreferencesProvider = ScopedProvider.create(FlagshipSharedPreferences_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, provideApplicationContextProvider, provideExecutorServiceProvider));
    i18NManagerProvider = ScopedProvider.create(I18NManager_Factory.create(provideApplicationContextProvider));
    provideAuthProvider = ScopedProvider.create(ApplicationModule_ProvideAuthFactory.create(applicationModule, provideApplicationContextProvider, flagshipSharedPreferencesProvider, i18NManagerProvider));
    applicationComponentProvider = InstanceFactory.create(this);
    provideVoyagerRequestFactoryProvider = ScopedProvider.create(ApplicationModule_ProvideVoyagerRequestFactoryFactory.create(applicationModule, flagshipSharedPreferencesProvider));
    internationalizationApiProvider = ScopedProvider.create(ApplicationModule_InternationalizationApiFactory.create(applicationModule, i18NManagerProvider));
    provideNetworkClientProvider = ScopedProvider.create(ApplicationModule_ProvideNetworkClientFactory.create(applicationModule, applicationComponentProvider, provideVoyagerRequestFactoryProvider, internationalizationApiProvider));
    provideNetworkDataStoreProvider = ScopedProvider.create(DataManagerModule_ProvideNetworkDataStoreFactory.create(dataManagerModule, provideApplicationContextProvider, provideNetworkClientProvider));
    provideByteBufferPoolProvider = ScopedProvider.create(DataManagerModule_ProvideByteBufferPoolFactory.create(dataManagerModule));
    provideDiskCacheProvider = ScopedProvider.create(DataManagerModule_ProvideDiskCacheFactory.create(dataManagerModule, provideApplicationContextProvider, flagshipSharedPreferencesProvider, provideByteBufferPoolProvider));
    providesCacheProvider = ScopedProvider.create(DataManagerModule_ProvidesCacheFactory.create(dataManagerModule, provideDiskCacheProvider));
    provideConnectionStoreProvider = ScopedProvider.create(DataManagerModule_ProvideConnectionStoreFactory.create(dataManagerModule, provideApplicationContextProvider, flagshipSharedPreferencesProvider));
    provideCacheManagerProvider = ScopedProvider.create(DataManagerModule_ProvideCacheManagerFactory.create(dataManagerModule, providesCacheProvider, provideByteBufferPoolProvider, provideConnectionStoreProvider));
    provideLocalDataStoreProvider = ScopedProvider.create(DataManagerModule_ProvideLocalDataStoreFactory.create(dataManagerModule, provideCacheManagerProvider));
    provideDataManagerProvider = ScopedProvider.create(DataManagerModule_ProvideDataManagerFactory.create(dataManagerModule, provideNetworkDataStoreProvider, provideLocalDataStoreProvider, provideExecutorServiceProvider));
    provideScheduledExecutorServiceProvider = ScopedProvider.create(ApplicationModule_ProvideScheduledExecutorServiceFactory.create(applicationModule));
    provideTrackerProvider = ScopedProvider.create(ApplicationModule_ProvideTrackerFactory.create(applicationModule, flagshipSharedPreferencesProvider));
    provideAuthenticatedLixManagerProvider = ScopedProvider.create(ApplicationModule_ProvideAuthenticatedLixManagerFactory.create(applicationModule, provideApplicationContextProvider, provideDataManagerProvider, provideScheduledExecutorServiceProvider, provideTrackerProvider));
    provideConsistencyManagerProvider = ScopedProvider.create(ApplicationModule_ProvideConsistencyManagerFactory.create(applicationModule));
    provideFlagshipDataManagerProvider = ScopedProvider.create(DataManagerModule_ProvideFlagshipDataManagerFactory.create(dataManagerModule, provideDataManagerProvider, provideConsistencyManagerProvider));
    imageQualityManagerProvider = ScopedProvider.create(ImageQualityManager_Factory.create(MediaProcessorSizeComparator_Factory.create()));
    busProvider = ScopedProvider.create(Bus_Factory.create());
    provideConfigurationManagerProvider = ScopedProvider.create(ApplicationModule_ProvideConfigurationManagerFactory.create(applicationModule, provideFlagshipDataManagerProvider, imageQualityManagerProvider, busProvider, provideTrackerProvider));
    notificationUtilsProvider = ScopedProvider.create(NotificationUtils_Factory.create(provideFlagshipDataManagerProvider, flagshipSharedPreferencesProvider, provideTrackerProvider));
    provideImageLoaderNetworkClientProvider = ScopedProvider.create(ApplicationModule_ProvideImageLoaderNetworkClientFactory.create(applicationModule, applicationComponentProvider, provideVoyagerRequestFactoryProvider, internationalizationApiProvider));
    imageLoaderCacheProvider = ScopedProvider.create(ApplicationModule_ImageLoaderCacheFactory.create(applicationModule));
    imageLoaderProvider = ScopedProvider.create(ApplicationModule_ImageLoaderFactory.create(applicationModule, provideApplicationContextProvider, provideImageLoaderNetworkClientProvider, imageLoaderCacheProvider));
    placeholderImageCacheProvider = ScopedProvider.create(ApplicationModule_PlaceholderImageCacheFactory.create(applicationModule));
    provideMediaCenterProvider = ScopedProvider.create(ApplicationModule_ProvideMediaCenterFactory.create(applicationModule, provideApplicationContextProvider, imageLoaderProvider, imageQualityManagerProvider, placeholderImageCacheProvider));
    provideMemberUtilProvider = ScopedProvider.create(UtilModule_ProvideMemberUtilFactory.create(utilModule, provideAuthProvider, busProvider, provideFlagshipDataManagerProvider, provideConsistencyManagerProvider, flagshipSharedPreferencesProvider, provideMediaCenterProvider, provideTrackerProvider));
    provideNewToVoyagerManagerProvider = ScopedProvider.create(ApplicationModule_ProvideNewToVoyagerManagerFactory.create(applicationModule, provideFlagshipDataManagerProvider, flagshipSharedPreferencesProvider, provideTrackerProvider));
    providePreAuthLixManagerProvider = ScopedProvider.create(ApplicationModule_ProvidePreAuthLixManagerFactory.create(applicationModule, provideApplicationContextProvider, provideDataManagerProvider, provideScheduledExecutorServiceProvider, provideTrackerProvider));
    timeWrapperProvider = ScopedProvider.create(TimeWrapper_Factory.create());
    providesAbiContactsReaderProvider = ScopedProvider.create(ApplicationModule_ProvidesAbiContactsReaderFactory.create(applicationModule, provideApplicationContextProvider, flagshipSharedPreferencesProvider));
    abiAutoSyncManagerMembersInjector = AbiAutoSyncManager_MembersInjector.create(flagshipSharedPreferencesProvider, timeWrapperProvider, provideFlagshipDataManagerProvider, provideMemberUtilProvider, provideTrackerProvider, provideAuthenticatedLixManagerProvider, providesAbiContactsReaderProvider);
    abiAutoSyncManagerProvider = ScopedProvider.create(AbiAutoSyncManager_Factory.create(abiAutoSyncManagerMembersInjector, flagshipSharedPreferencesProvider, timeWrapperProvider, provideFlagshipDataManagerProvider, provideMemberUtilProvider, provideTrackerProvider, provideAuthenticatedLixManagerProvider));
    provideDeferredDeeplinkHelperProvider = ScopedProvider.create(ApplicationModule_ProvideDeferredDeeplinkHelperFactory.create(applicationModule, provideApplicationContextProvider));
    providesHomeCachedLixProvider = ScopedProvider.create(ApplicationModule_ProvidesHomeCachedLixFactory.create(applicationModule, provideAuthenticatedLixManagerProvider, flagshipSharedPreferencesProvider));
    providesBadgerProvider = ScopedProvider.create(ApplicationModule_ProvidesBadgerFactory.create(applicationModule, provideFlagshipDataManagerProvider, provideAuthenticatedLixManagerProvider, providesHomeCachedLixProvider, busProvider, flagshipSharedPreferencesProvider, provideApplicationContextProvider, provideTrackerProvider));
    outerBadgeProvider = ScopedProvider.create(OuterBadge_Factory.create(provideApplicationContextProvider, provideAuthenticatedLixManagerProvider, busProvider, providesBadgerProvider, flagshipSharedPreferencesProvider));
    provideCalendarTaskUtilProvider = ScopedProvider.create(ApplicationModule_ProvideCalendarTaskUtilFactory.create(applicationModule, provideApplicationContextProvider, provideFlagshipDataManagerProvider));
    provideCalendarSyncManagerProvider = ScopedProvider.create(ApplicationModule_ProvideCalendarSyncManagerFactory.create(applicationModule, provideApplicationContextProvider, flagshipSharedPreferencesProvider, provideCalendarTaskUtilProvider));
    abiCacheUtilsProvider = ScopedProvider.create(AbiCacheUtils_Factory.create(provideFlagshipDataManagerProvider, provideTrackerProvider, flagshipSharedPreferencesProvider, timeWrapperProvider, provideAuthenticatedLixManagerProvider));
    provideLaunchUtilsProvider = ScopedProvider.create(ApplicationModule_ProvideLaunchUtilsFactory.create(applicationModule, provideAuthenticatedLixManagerProvider, provideNetworkClientProvider, provideExecutorServiceProvider, provideConfigurationManagerProvider, notificationUtilsProvider, provideMemberUtilProvider, provideNewToVoyagerManagerProvider, flagshipSharedPreferencesProvider, providePreAuthLixManagerProvider, abiAutoSyncManagerProvider, provideDeferredDeeplinkHelperProvider, outerBadgeProvider, provideCalendarSyncManagerProvider, abiCacheUtilsProvider));
    provideAuthHttpStackProvider = ScopedProvider.create(ApplicationModule_ProvideAuthHttpStackFactory.create(applicationModule, provideNetworkClientProvider, provideApplicationContextProvider));
    provideTrackingNetworkStackProvider = ScopedProvider.create(ApplicationModule_ProvideTrackingNetworkStackFactory.create(applicationModule, provideApplicationContextProvider, applicationComponentProvider, provideVoyagerRequestFactoryProvider, internationalizationApiProvider));
    navigationManagerProvider = ScopedProvider.create(NavigationManager_Factory.create(provideApplicationProvider));
    provideMainHandlerProvider = ApplicationModule_ProvideMainHandlerFactory.create(applicationModule);
    flagshipCacheManagerProvider = ScopedProvider.create(FlagshipCacheManager_Factory.create(providesCacheProvider, provideByteBufferPoolProvider, provideConnectionStoreProvider));
    provideFlagshipAssetManagerProvider = ScopedProvider.create(ApplicationModule_ProvideFlagshipAssetManagerFactory.create(applicationModule));
    provideAssetLoaderNetworkClientProvider = ScopedProvider.create(ApplicationModule_ProvideAssetLoaderNetworkClientFactory.create(applicationModule, applicationComponentProvider, provideVoyagerRequestFactoryProvider, internationalizationApiProvider));
    provideMediaUploaderProvider = ScopedProvider.create(UtilModule_ProvideMediaUploaderFactory.create(utilModule, busProvider, provideNetworkClientProvider, provideFlagshipDataManagerProvider, flagshipSharedPreferencesProvider, provideApplicationContextProvider));
    provideCookieUtilProvider = ScopedProvider.create(ApplicationModule_ProvideCookieUtilFactory.create(applicationModule, provideNetworkClientProvider));
    loginIntentProvider = LoginIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    onboardingIntentProvider = OnboardingIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    rebuildMyFeedIntentProvider = RebuildMyFeedIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    abiIntentProvider = AbiIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    wyloIntentProvider = WyloIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    inviteAcceptIntentProvider = InviteAcceptIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    sendInviteIntentProvider = SendInviteIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    heathrowIntentProvider = HeathrowIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    smsReminderConsentIntentProvider = SmsReminderConsentIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    homeIntentProvider = HomeIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    newToVoyagerIntroIntentProvider = NewToVoyagerIntroIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    searchIntentProvider = SearchIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    premiumActivityIntentProvider = PremiumActivityIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    relationshipsSecondaryIntentProvider = RelationshipsSecondaryIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    shareIntentProvider = ShareIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    channelIntentProvider = ChannelIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    aggregateIntentProvider = AggregateIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    imageViewerIntentProvider = ImageViewerIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    linkPickerIntentProvider = LinkPickerIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    mentionPickerIntentProvider = MentionPickerIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    schoolIntentProvider = SchoolIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    companyIntentProvider = CompanyIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    profileViewIntentProvider = ProfileViewIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    webViewerIntentProvider = WebViewerIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    videoViewerIntentProvider = VideoViewerIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    jobIntentProvider = JobIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    groupIntentProvider = GroupIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    likesDetailIntentProvider = LikesDetailIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    messageListIntentProvider = MessageListIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    participantDetailsIntentProvider = ParticipantDetailsIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    addParticipantIntentProvider = AddParticipantIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    attachmentViewerIntentProvider = AttachmentViewerIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    composeIntentProvider = ComposeIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    inmailComposeIntentProvider = InmailComposeIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    stickerStoreIntentProvider = StickerStoreIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    conversationSearchListIntentProvider = ConversationSearchListIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    feedUpdateDetailIntentProvider = FeedUpdateDetailIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    commentDetailIntentProvider = CommentDetailIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    deepLinkHelperIntentProvider = DeepLinkHelperIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    connectedIntentProvider = ConnectedIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    invitationsIntentProvider = InvitationsIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    connectionsIntentProvider = ConnectionsIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    acceptedInvitationIntentProvider = AcceptedInvitationIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    addConnectionsIntentProvider = AddConnectionsIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    pendingEndorsementIntentProvider = PendingEndorsementIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    meWvmpIntentBuilderProvider = MeWvmpIntentBuilder_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    meWvmpPrivateModeIntentBuilderProvider = MeWvmpPrivateModeIntentBuilder_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    contentAnalyticsIntentBuilderProvider = ContentAnalyticsIntentBuilder_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    jymbiiIntentProvider = JymbiiIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    guidedEditIntentProvider = GuidedEditIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    groupDiscussionIntentProvider = GroupDiscussionIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    profileEditDeeplinkIntentProvider = ProfileEditDeeplinkIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    settingsIntentProvider = SettingsIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    deepLinkArticleIntentProvider = DeepLinkArticleIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    articleIntentProvider = ArticleIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    feedActorListIntentProvider = FeedActorListIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    samsungSyncConsentIntentProvider = SamsungSyncConsentIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    sameNameDirectoryIntentProvider = SameNameDirectoryIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    boostIntentProvider = BoostIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    resourceListIntentProvider = ResourceListIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    pymkIntentProvider = PymkIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    followHubIntentProvider = FollowHubIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    takeoverIntentProvider = TakeoverIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    reconnectIntentProvider = ReconnectIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    feedPromptResponseListIntentProvider = FeedPromptResponseListIntent_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE);
    profinderServiceProposalActivityIntentMembersInjector = ProfinderServiceProposalActivityIntent_MembersInjector.create(MembersInjectors.NoOpMembersInjector.INSTANCE, i18NManagerProvider);
    profinderServiceProposalActivityIntentProvider = ProfinderServiceProposalActivityIntent_Factory.create(profinderServiceProposalActivityIntentMembersInjector);
    intentRegistryProvider = ScopedProvider.create(IntentRegistry_Factory.create(loginIntentProvider, onboardingIntentProvider, rebuildMyFeedIntentProvider, abiIntentProvider, wyloIntentProvider, inviteAcceptIntentProvider, sendInviteIntentProvider, heathrowIntentProvider, smsReminderConsentIntentProvider, homeIntentProvider, newToVoyagerIntroIntentProvider, searchIntentProvider, premiumActivityIntentProvider, relationshipsSecondaryIntentProvider, shareIntentProvider, channelIntentProvider, aggregateIntentProvider, imageViewerIntentProvider, linkPickerIntentProvider, mentionPickerIntentProvider, schoolIntentProvider, companyIntentProvider, profileViewIntentProvider, webViewerIntentProvider, videoViewerIntentProvider, jobIntentProvider, groupIntentProvider, likesDetailIntentProvider, messageListIntentProvider, participantDetailsIntentProvider, addParticipantIntentProvider, attachmentViewerIntentProvider, composeIntentProvider, inmailComposeIntentProvider, stickerStoreIntentProvider, conversationSearchListIntentProvider, feedUpdateDetailIntentProvider, commentDetailIntentProvider, deepLinkHelperIntentProvider, connectedIntentProvider, invitationsIntentProvider, connectionsIntentProvider, acceptedInvitationIntentProvider, addConnectionsIntentProvider, pendingEndorsementIntentProvider, meWvmpIntentBuilderProvider, meWvmpPrivateModeIntentBuilderProvider, contentAnalyticsIntentBuilderProvider, jymbiiIntentProvider, guidedEditIntentProvider, groupDiscussionIntentProvider, profileEditDeeplinkIntentProvider, settingsIntentProvider, deepLinkArticleIntentProvider, articleIntentProvider, feedActorListIntentProvider, samsungSyncConsentIntentProvider, sameNameDirectoryIntentProvider, boostIntentProvider, resourceListIntentProvider, pymkIntentProvider, followHubIntentProvider, takeoverIntentProvider, reconnectIntentProvider, feedPromptResponseListIntentProvider, profinderServiceProposalActivityIntentProvider));
    provideViewPagerObserverProvider = ScopedProvider.create(ApplicationModule_ProvideViewPagerObserverFactory.create(applicationModule));
    messagingDataEventHandlerProvider = ScopedProvider.create(MessagingDataEventHandler_Factory.create(MembersInjectors.NoOpMembersInjector.INSTANCE, provideApplicationContextProvider, providesBadgerProvider, provideAuthenticatedLixManagerProvider));
    topicRegistryProvider = ScopedProvider.create(ApplicationModule_TopicRegistryFactory.create(applicationModule, messagingDataEventHandlerProvider));
    provideRealTimeManagerProvider = ScopedProvider.create(ApplicationModule_ProvideRealTimeManagerFactory.create(applicationModule, provideTrackerProvider, provideAuthenticatedLixManagerProvider, provideNetworkClientProvider, provideApplicationContextProvider, topicRegistryProvider));
    provideDeeplinkHelperProvider = ScopedProvider.create(ApplicationModule_ProvideDeeplinkHelperFactory.create(applicationModule, provideApplicationContextProvider, intentRegistryProvider, provideTrackerProvider));
    fragmentFactoryMembersInjector = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    profilePhotoCropFragmentFactoryMembersInjector = fragmentFactoryMembersInjector;
    profilePhotoCropFragmentFactoryProvider = ProfilePhotoCropFragmentFactory_Factory.create(profilePhotoCropFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector1 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    sSOFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    sSOFragmentFactoryProvider = SSOFragmentFactory_Factory.create(sSOFragmentFactoryMembersInjector);
    preRegFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    preRegFragmentFactoryProvider = PreRegFragmentFactory_Factory.create(preRegFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector2 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    newToVoyagerIntroFragmentFactoryMembersInjector = fragmentFactoryMembersInjector2;
    newToVoyagerIntroFragmentFactoryProvider = NewToVoyagerIntroFragmentFactory_Factory.create(newToVoyagerIntroFragmentFactoryMembersInjector);
    loginFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    loginFragmentFactoryProvider = LoginFragmentFactory_Factory.create(loginFragmentFactoryMembersInjector);
    joinFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    joinFragmentFactoryProvider = JoinFragmentFactory_Factory.create(joinFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector3 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    phoneConfirmationFragmentFactoryMembersInjector = fragmentFactoryMembersInjector3;
    phoneConfirmationFragmentFactoryProvider = PhoneConfirmationFragmentFactory_Factory.create(phoneConfirmationFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector4 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    pinVerificationFragmentFactoryMembersInjector = fragmentFactoryMembersInjector4;
    pinVerificationFragmentFactoryProvider = PinVerificationFragmentFactory_Factory.create(pinVerificationFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector5 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    greetingFragmentFactoryMembersInjector = fragmentFactoryMembersInjector5;
    greetingFragmentFactoryProvider = GreetingFragmentFactory_Factory.create(greetingFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector6 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    mainAbiSplashFragmentFactoryMembersInjector = fragmentFactoryMembersInjector6;
    mainAbiSplashFragmentFactoryProvider = MainAbiSplashFragmentFactory_Factory.create(mainAbiSplashFragmentFactoryMembersInjector);
    onboardingAbiSplashFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    onboardingAbiSplashFragmentFactoryProvider = OnboardingAbiSplashFragmentFactory_Factory.create(onboardingAbiSplashFragmentFactoryMembersInjector);
    abiLearnMoreFragmentFractoryMembersInjector = fragmentFactoryMembersInjector1;
    abiLearnMoreFragmentFractoryProvider = AbiLearnMoreFragmentFractory_Factory.create(abiLearnMoreFragmentFractoryMembersInjector);
    calendarLearnMoreFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    calendarLearnMoreFragmentFactoryProvider = CalendarLearnMoreFragmentFactory_Factory.create(calendarLearnMoreFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector7 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    rebuildMyFeedFactoryMembersInjector = fragmentFactoryMembersInjector7;
    rebuildMyFeedFactoryProvider = RebuildMyFeedFactory_Factory.create(rebuildMyFeedFactoryMembersInjector);
    abiLoadContactsFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    abiLoadContactsFragmentFactoryProvider = AbiLoadContactsFragmentFactory_Factory.create(abiLoadContactsFragmentFactoryMembersInjector);
    photoFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    photoFragmentFactoryProvider = PhotoFragmentFactory_Factory.create(photoFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector8 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    photoCropFragmentFactoryMembersInjector = fragmentFactoryMembersInjector8;
    onboardingPhotoCropFragmentFactoryMembersInjector = photoCropFragmentFactoryMembersInjector;
    onboardingPhotoCropFragmentFactoryProvider = OnboardingPhotoCropFragmentFactory_Factory.create(onboardingPhotoCropFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector9 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    emailConfirmationLoadingFragmentFactoryMembersInjector = fragmentFactoryMembersInjector9;
    emailConfirmationLoadingFragmentFactoryProvider = EmailConfirmationLoadingFragmentFactory_Factory.create(emailConfirmationLoadingFragmentFactoryMembersInjector);
    emailConfirmationFragmentFactoryMembersInjector = fragmentFactoryMembersInjector9;
    emailConfirmationFragmentFactoryProvider = EmailConfirmationFragmentFactory_Factory.create(emailConfirmationFragmentFactoryMembersInjector);
    welcomeMatFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    welcomeMatFragmentFactoryProvider = WelcomeMatFragmentFactory_Factory.create(welcomeMatFragmentFactoryMembersInjector);
    pymkFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    pymkFragmentFactoryProvider = PymkFragmentFactory_Factory.create(pymkFragmentFactoryMembersInjector);
    jobseekerPromoFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    jobseekerPromoFragmentFactoryProvider = JobseekerPromoFragmentFactory_Factory.create(jobseekerPromoFragmentFactoryMembersInjector);
    boostSplashFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    boostSplashFragmentFactoryProvider = BoostSplashFragmentFactory_Factory.create(boostSplashFragmentFactoryMembersInjector);
    boostErrorFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    boostErrorFragmentFactoryProvider = BoostErrorFragmentFactory_Factory.create(boostErrorFragmentFactoryMembersInjector);
    mainAbiM2MFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    mainAbiM2MFragmentFactoryProvider = MainAbiM2MFragmentFactory_Factory.create(mainAbiM2MFragmentFactoryMembersInjector);
    onboardingAbiM2MFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    onboardingAbiM2MFragmentFactoryProvider = OnboardingAbiM2MFragmentFactory_Factory.create(onboardingAbiM2MFragmentFactoryMembersInjector);
    onboardingAbiM2GEmailFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    onboardingAbiM2GEmailFragmentFactoryProvider = OnboardingAbiM2GEmailFragmentFactory_Factory.create(onboardingAbiM2GEmailFragmentFactoryMembersInjector);
    mainAbiM2GEmailFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    mainAbiM2GEmailFragmentFactoryProvider = MainAbiM2GEmailFragmentFactory_Factory.create(mainAbiM2GEmailFragmentFactoryMembersInjector);
    mainAbiM2GSmsFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    mainAbiM2GSmsFragmentFactoryProvider = MainAbiM2GSmsFragmentFactory_Factory.create(mainAbiM2GSmsFragmentFactoryMembersInjector);
    mainAbiM2GUnifiedSmsEmailFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    mainAbiM2GUnifiedSmsEmailFragmentFactoryProvider = MainAbiM2GUnifiedSmsEmailFragmentFactory_Factory.create(mainAbiM2GUnifiedSmsEmailFragmentFactoryMembersInjector);
    onboardingAbiM2GSmsFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    onboardingAbiM2GSmsFragmentFactoryProvider = OnboardingAbiM2GSmsFragmentFactory_Factory.create(onboardingAbiM2GSmsFragmentFactoryMembersInjector);
    onboardingAbiM2GUnifiedSMSEmailFragmentFactoryMembersInjector = fragmentFactoryMembersInjector1;
    onboardingAbiM2GUnifiedSMSEmailFragmentFactoryProvider = OnboardingAbiM2GUnifiedSMSEmailFragmentFactory_Factory.create(onboardingAbiM2GUnifiedSMSEmailFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector10 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    feedFragmentFactoryMembersInjector = fragmentFactoryMembersInjector10;
    feedFragmentFactoryProvider = FeedFragmentFactory_Factory.create(feedFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector11 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    feedUpdateDetailFragmentFactoryMembersInjector = fragmentFactoryMembersInjector11;
    feedUpdateDetailFragmentFactoryProvider = FeedUpdateDetailFragmentFactory_Factory.create(feedUpdateDetailFragmentFactoryMembersInjector);
    newToVoyagerFeedFragmentFactoryMembersInjector = fragmentFactoryMembersInjector2;
    newToVoyagerFeedFragmentFactoryProvider = NewToVoyagerFeedFragmentFactory_Factory.create(newToVoyagerFeedFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector12 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    shareFragmentFactoryMembersInjector = fragmentFactoryMembersInjector12;
    shareFragmentFactoryProvider = ShareFragmentFactory_Factory.create(shareFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector13 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    channelFragmentFactoryMembersInjector = fragmentFactoryMembersInjector13;
    channelFragmentFactoryProvider = ChannelFragmentFactory_Factory.create(channelFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector14 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    aggregateFragmentFactoryMembersInjector = fragmentFactoryMembersInjector14;
    aggregateFragmentFactoryProvider = AggregateFragmentFactory_Factory.create(aggregateFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector15 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    imageViewerFragmentFactoryMembersInjector = fragmentFactoryMembersInjector15;
    imageViewerFragmentFactoryProvider = ImageViewerFragmentFactory_Factory.create(imageViewerFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector16 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    notificationsFragmentFactoryMembersInjector = fragmentFactoryMembersInjector16;
    notificationsFragmentFactoryProvider = NotificationsFragmentFactory_Factory.create(notificationsFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector17 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    settingsFragmentFactoryMembersInjector = fragmentFactoryMembersInjector17;
    settingsFragmentFactoryProvider = SettingsFragmentFactory_Factory.create(settingsFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector18 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    messagingFragmentFactoryMembersInjector = fragmentFactoryMembersInjector18;
    messagingFragmentFactoryProvider = MessagingFragmentFactory_Factory.create(messagingFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector19 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    relationshipsFragmentFactoryMembersInjector = fragmentFactoryMembersInjector19;
    relationshipsFragmentFactoryProvider = RelationshipsFragmentFactory_Factory.create(relationshipsFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector20 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    searchStarterFragmentFactoryMembersInjector = fragmentFactoryMembersInjector20;
    searchStarterFragmentFactoryProvider = SearchStarterFragmentFactory_Factory.create(searchStarterFragmentFactoryMembersInjector);
    searchFragmentFactoryMembersInjector = fragmentFactoryMembersInjector20;
    searchFragmentFactoryProvider = SearchFragmentFactory_Factory.create(searchFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector21 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    webViewerFragmentFactoryMembersInjector = fragmentFactoryMembersInjector21;
    webViewerFragmentFactoryProvider = WebViewerFragmentFactory_Factory.create(webViewerFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector22 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    articleFragmentFactoryMembersInjector = fragmentFactoryMembersInjector22;
    articleFragmentFactoryProvider = ArticleFragmentFactory_Factory.create(articleFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector23 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    videoViewerFragmentFactoryMembersInjector = fragmentFactoryMembersInjector23;
    videoViewerFragmentFactoryProvider = VideoViewerFragmentFactory_Factory.create(videoViewerFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector24 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    likesDetailFragmentFactoryMembersInjector = fragmentFactoryMembersInjector24;
    likesDetailFragmentFactoryProvider = LikesDetailFragmentFactory_Factory.create(likesDetailFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector25 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    linkPickerFragmentFactoryMembersInjector = fragmentFactoryMembersInjector25;
    linkPickerFragmentFactoryProvider = LinkPickerFragmentFactory_Factory.create(linkPickerFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector26 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    mentionPickerFragmentFactoryMembersInjector = fragmentFactoryMembersInjector26;
    mentionPickerFragmentFactoryProvider = MentionPickerFragmentFactory_Factory.create(mentionPickerFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector27 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    newToVoyagerIntroDialogFragmentFactoryMembersInjector = fragmentFactoryMembersInjector27;
    newToVoyagerIntroDialogFragmentFactoryProvider = NewToVoyagerIntroDialogFragmentFactory_Factory.create(newToVoyagerIntroDialogFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector28 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    unfollowEducateFactoryMembersInjector = fragmentFactoryMembersInjector28;
    unfollowEducateFactoryProvider = UnfollowEducateFactory_Factory.create(unfollowEducateFactoryMembersInjector);
    settingsWebViewerFragmentFactoryMembersInjector = fragmentFactoryMembersInjector21;
    settingsWebViewerFragmentFactoryProvider = SettingsWebViewerFragmentFactory_Factory.create(settingsWebViewerFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector29 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    profileViewFragmentFactoryMembersInjector = fragmentFactoryMembersInjector29;
    profileViewFragmentFactoryProvider = ProfileViewFragmentFactory_Factory.create(profileViewFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector30 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    smsReminderConsentFragmentFactoryMembersInjector = fragmentFactoryMembersInjector30;
    smsReminderConsentFragmentFactoryProvider = SmsReminderConsentFragmentFactory_Factory.create(smsReminderConsentFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector31 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    feedConnectionUpdatesDetailFragmentFactoryMembersInjector = fragmentFactoryMembersInjector31;
    feedConnectionUpdatesDetailFragmentFactoryProvider = FeedConnectionUpdatesDetailFragmentFactory_Factory.create(feedConnectionUpdatesDetailFragmentFactoryMembersInjector);
    feedPymkUpdatesDetailFragmentFactoryMembersInjector = fragmentFactoryMembersInjector31;
    feedPymkUpdatesDetailFragmentFactoryProvider = FeedPymkUpdatesDetailFragmentFactory_Factory.create(feedPymkUpdatesDetailFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector32 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    commentDetailFragmentFactoryMembersInjector = fragmentFactoryMembersInjector32;
    commentDetailFragmentFactoryProvider = CommentDetailFragmentFactory_Factory.create(commentDetailFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector33 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    feedPromptResponseListFragmentFactoryMembersInjector = fragmentFactoryMembersInjector33;
    feedPromptResponseListFragmentFactoryProvider = FeedPromptResponseListFragmentFactory_Factory.create(feedPromptResponseListFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector34 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    followHubFragmentFactoryMembersInjector = fragmentFactoryMembersInjector34;
    followHubFragmentFactoryProvider = FollowHubFragmentFactory_Factory.create(followHubFragmentFactoryMembersInjector);
    fragmentFactoryMembersInjector35 = FragmentFactory_MembersInjector.create(provideAuthenticatedLixManagerProvider);
    followHubPackageFragmentFactoryMembersInjector = fragmentFactoryMembersInjector35;
    followHubPackageFragmentFactoryProvider = FollowHubPackageFragmentFactory_Factory.create(followHubPackageFragmentFactoryMembersInjector);
    fragmentRegistryProvider = ScopedProvider.create(FragmentRegistry_Factory.create(profilePhotoCropFragmentFactoryProvider, sSOFragmentFactoryProvider, preRegFragmentFactoryProvider, newToVoyagerIntroFragmentFactoryProvider, loginFragmentFactoryProvider, joinFragmentFactoryProvider, phoneConfirmationFragmentFactoryProvider, pinVerificationFragmentFactoryProvider, greetingFragmentFactoryProvider, mainAbiSplashFragmentFactoryProvider, onboardingAbiSplashFragmentFactoryProvider, abiLearnMoreFragmentFractoryProvider, calendarLearnMoreFragmentFactoryProvider, rebuildMyFeedFactoryProvider, abiLoadContactsFragmentFactoryProvider, photoFragmentFactoryProvider, onboardingPhotoCropFragmentFactoryProvider, emailConfirmationLoadingFragmentFactoryProvider, emailConfirmationFragmentFactoryProvider, welcomeMatFragmentFactoryProvider, pymkFragmentFactoryProvider, jobseekerPromoFragmentFactoryProvider, boostSplashFragmentFactoryProvider, boostErrorFragmentFactoryProvider, mainAbiM2MFragmentFactoryProvider, onboardingAbiM2MFragmentFactoryProvider, onboardingAbiM2GEmailFragmentFactoryProvider, mainAbiM2GEmailFragmentFactoryProvider, mainAbiM2GSmsFragmentFactoryProvider, mainAbiM2GUnifiedSmsEmailFragmentFactoryProvider, onboardingAbiM2GSmsFragmentFactoryProvider, onboardingAbiM2GUnifiedSMSEmailFragmentFactoryProvider, feedFragmentFactoryProvider, feedUpdateDetailFragmentFactoryProvider, newToVoyagerFeedFragmentFactoryProvider, shareFragmentFactoryProvider, channelFragmentFactoryProvider, aggregateFragmentFactoryProvider, imageViewerFragmentFactoryProvider, notificationsFragmentFactoryProvider, settingsFragmentFactoryProvider, messagingFragmentFactoryProvider, relationshipsFragmentFactoryProvider, searchStarterFragmentFactoryProvider, searchFragmentFactoryProvider, webViewerFragmentFactoryProvider, articleFragmentFactoryProvider, videoViewerFragmentFactoryProvider, likesDetailFragmentFactoryProvider, linkPickerFragmentFactoryProvider, mentionPickerFragmentFactoryProvider, newToVoyagerIntroDialogFragmentFactoryProvider, unfollowEducateFactoryProvider, settingsWebViewerFragmentFactoryProvider, profileViewFragmentFactoryProvider, smsReminderConsentFragmentFactoryProvider, feedConnectionUpdatesDetailFragmentFactoryProvider, feedPymkUpdatesDetailFragmentFactoryProvider, commentDetailFragmentFactoryProvider, feedPromptResponseListFragmentFactoryProvider, followHubFragmentFactoryProvider, followHubPackageFragmentFactoryProvider));
    profileUtilMembersInjector = ProfileUtil_MembersInjector.create(provideMemberUtilProvider, i18NManagerProvider);
    profileUtilProvider = ScopedProvider.create(ProfileUtil_Factory.create(profileUtilMembersInjector));
    photoUtilsProvider = ScopedProvider.create(PhotoUtils_Factory.create());
    provideSnackbarUtilProvider = ScopedProvider.create(UtilModule_ProvideSnackbarUtilFactory.create(utilModule, provideApplicationContextProvider));
    provideDelayedExecutionProvider = UtilModule_ProvideDelayedExecutionFactory.create(utilModule);
    provideCardToastManagerProvider = ScopedProvider.create(UtilModule_ProvideCardToastManagerFactory.create(utilModule, provideDelayedExecutionProvider));
    provideInternetConnectionMonitorProvider = ScopedProvider.create(UtilModule_ProvideInternetConnectionMonitorFactory.create(utilModule, provideApplicationContextProvider, provideAuthenticatedLixManagerProvider, provideSnackbarUtilProvider, provideTrackerProvider));
    provideThirdPartySdkManagerProvider = ScopedProvider.create(ApplicationModule_ProvideThirdPartySdkManagerFactory.create(applicationModule));
    connectionsFetchingManagerProvider = ScopedProvider.create(ConnectionsFetchingManager_Factory.create(provideFlagshipDataManagerProvider, flagshipSharedPreferencesProvider));
    provideCommentPublisherProvider = ScopedProvider.create(FeedModule_ProvideCommentPublisherFactory.create(feedModule, provideFlagshipDataManagerProvider, busProvider, provideAuthenticatedLixManagerProvider));
    provideSharePublisherProvider = ScopedProvider.create(FeedModule_ProvideSharePublisherFactory.create(feedModule, provideApplicationContextProvider, provideFlagshipDataManagerProvider, busProvider, provideMediaUploaderProvider, imageLoaderCacheProvider, provideConsistencyManagerProvider));
    provideGroupsSharePublisherProvider = ScopedProvider.create(FeedModule_ProvideGroupsSharePublisherFactory.create(feedModule, provideApplicationContextProvider, provideFlagshipDataManagerProvider, busProvider, provideMediaUploaderProvider, imageLoaderCacheProvider));
    provideFollowPublisherProvider = ScopedProvider.create(UtilModule_ProvideFollowPublisherFactory.create(utilModule, provideApplicationProvider, provideFlagshipDataManagerProvider, provideConsistencyManagerProvider, busProvider));
    provideLikePublisherProvider = ScopedProvider.create(FeedModule_ProvideLikePublisherFactory.create(feedModule, provideApplicationProvider, provideFlagshipDataManagerProvider, provideConsistencyManagerProvider, busProvider, provideMemberUtilProvider, provideAuthenticatedLixManagerProvider));
    provideUpdateChangeCoordinatorProvider = ScopedProvider.create(FeedModule_ProvideUpdateChangeCoordinatorFactory.create(feedModule, provideApplicationProvider, provideConsistencyManagerProvider));
    provideSponsoredUpdateTrackerProvider = ScopedProvider.create(FeedModule_ProvideSponsoredUpdateTrackerFactory.create(feedModule, provideApplicationContextProvider, provideNetworkClientProvider));
    provideSynchronousBackgroundQueueProvider = ScopedProvider.create(ApplicationModule_ProvideSynchronousBackgroundQueueFactory.create(applicationModule));
    provideReportEntityInvokerHelperProvider = ScopedProvider.create(UtilModule_ProvideReportEntityInvokerHelperFactory.create(utilModule));
    provideFeedKeyValueStoreProvider = ScopedProvider.create(FeedModule_ProvideFeedKeyValueStoreFactory.create(feedModule, provideApplicationContextProvider, provideExecutorServiceProvider));
    provideAppwidgetKeyValueStoreProvider = ScopedProvider.create(FeedModule_ProvideAppwidgetKeyValueStoreFactory.create(feedModule, provideApplicationContextProvider, provideExecutorServiceProvider));
    provideNewUpdatesRunnableProvider = ScopedProvider.create(FeedModule_ProvideNewUpdatesRunnableFactory.create(feedModule, provideFlagshipDataManagerProvider, provideDelayedExecutionProvider, provideTrackerProvider, flagshipSharedPreferencesProvider, provideFeedKeyValueStoreProvider, busProvider, provideAuthenticatedLixManagerProvider));
    providerPerfTrackerProvider = ScopedProvider.create(ApplicationModule_ProviderPerfTrackerFactory.create(applicationModule));
    provideRefWatcherProvider = ScopedProvider.create(ApplicationModule_ProvideRefWatcherFactory.create(applicationModule));
    provideViewportConfigProvider = UtilModule_ProvideViewportConfigFactory.create(utilModule);
    provideViewportManagerProvider = UtilModule_ProvideViewportManagerFactory.create(utilModule, provideTrackerProvider, provideViewportConfigProvider);
    provideViewPagerManagerProvider = UtilModule_ProvideViewPagerManagerFactory.create(utilModule, provideTrackerProvider, provideViewportConfigProvider);
    provideCrossPromoManagerProvider = ScopedProvider.create(ApplicationModule_ProvideCrossPromoManagerFactory.create(applicationModule, provideApplicationContextProvider, provideNetworkClientProvider, provideMediaCenterProvider));
    provideGeoLocatorProvider = ScopedProvider.create(ApplicationModule_ProvideGeoLocatorFactory.create(applicationModule));
    paymentServiceProvider = ScopedProvider.create(ApplicationModule_PaymentServiceFactory.create(applicationModule, provideNetworkClientProvider, provideApplicationContextProvider));
    provideNotificationDisplayUtilsProvider = ScopedProvider.create(ApplicationModule_ProvideNotificationDisplayUtilsFactory.create(applicationModule, provideApplicationContextProvider));
    provideSearchUtilsProvider = ScopedProvider.create(ApplicationModule_ProvideSearchUtilsFactory.create(applicationModule, intentRegistryProvider));
    provideWebRouterProvider = ScopedProvider.create(ApplicationModule_ProvideWebRouterFactory.create(applicationModule, provideApplicationContextProvider));
    provideWebViewLoadProxyProvider = ScopedProvider.create(ApplicationModule_ProvideWebViewLoadProxyFactory.create(applicationModule));
    provideAnimationProxyProvider = ScopedProvider.create(ApplicationModule_ProvideAnimationProxyFactory.create(applicationModule));
    provideTermsOfServiceProvider = ScopedProvider.create(ApplicationModule_ProvideTermsOfServiceFactory.create(applicationModule));
    titanDataMigrationManagerProvider = TitanDataMigrationManager_Factory.create(provideApplicationContextProvider, provideAuthProvider, flagshipSharedPreferencesProvider, provideAuthenticatedLixManagerProvider);
    appUpgradeUtilsProvider = ScopedProvider.create(AppUpgradeUtils_Factory.create(flagshipSharedPreferencesProvider));
    profilePendingConnectionRequestManagerProvider = ScopedProvider.create(ProfilePendingConnectionRequestManager_Factory.create());
    provideDeviceClassProvider = ScopedProvider.create(ApplicationModule_ProvideDeviceClassFactory.create(applicationModule, provideApplicationContextProvider));
    provideMeDedupProxyProvider = ScopedProvider.create(ApplicationModule_ProvideMeDedupProxyFactory.create(applicationModule));
    provideOAuthNetworkHelperProvider = ScopedProvider.create(ApplicationModule_ProvideOAuthNetworkHelperFactory.create(applicationModule, provideApplicationContextProvider, provideNetworkClientProvider, flagshipSharedPreferencesProvider));
    provideCommTrackerProvider = ScopedProvider.create(ApplicationModule_ProvideCommTrackerFactory.create(applicationModule, provideApplicationContextProvider, provideNetworkClientProvider, flagshipSharedPreferencesProvider));
    provideRateTheAppProvider = ScopedProvider.create(ApplicationModule_ProvideRateTheAppFactory.create(applicationModule));
    provideLongClickUtilProvider = ScopedProvider.create(UtilModule_ProvideLongClickUtilFactory.create(utilModule));
    provideMessengerLongClickUtilProvider = ScopedProvider.create(UtilModule_ProvideMessengerLongClickUtilFactory.create(utilModule));
    provideWebRouterUtilProvider = ScopedProvider.create(ApplicationModule_ProvideWebRouterUtilFactory.create(applicationModule));
    deepLinkManagerProvider = DeepLinkManager_Factory.create(provideTrackerProvider, intentRegistryProvider, provideDeeplinkHelperProvider);
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
    return (AbiContactsReader)providesAbiContactsReaderProvider.get();
  }
  
  public final AnimationProxy animationProxy()
  {
    return (AnimationProxy)provideAnimationProxyProvider.get();
  }
  
  public final FlagshipApplication app()
  {
    return (FlagshipApplication)provideApplicationProvider.get();
  }
  
  public final Context appContext()
  {
    return (Context)provideApplicationContextProvider.get();
  }
  
  public final AppUpgradeUtils appUpgradeUtils()
  {
    return (AppUpgradeUtils)appUpgradeUtilsProvider.get();
  }
  
  public final AppWidgetKeyValueStore appwidgetValues()
  {
    return (AppWidgetKeyValueStore)provideAppwidgetKeyValueStoreProvider.get();
  }
  
  public final AssetLoaderNetworkClient assetLoaderNetworkClient()
  {
    return (AssetLoaderNetworkClient)provideAssetLoaderNetworkClientProvider.get();
  }
  
  public final Auth auth()
  {
    return (Auth)provideAuthProvider.get();
  }
  
  public final HttpStack authHttpStack()
  {
    return (HttpStack)provideAuthHttpStackProvider.get();
  }
  
  public final Badger badger()
  {
    return (Badger)providesBadgerProvider.get();
  }
  
  public final CalendarSyncManager calendarSyncManager()
  {
    return (CalendarSyncManager)provideCalendarSyncManagerProvider.get();
  }
  
  public final CalendarTaskUtil calendarTaskUtil()
  {
    return (CalendarTaskUtil)provideCalendarTaskUtilProvider.get();
  }
  
  public final CardToastManager cardToastManager()
  {
    return (CardToastManager)provideCardToastManagerProvider.get();
  }
  
  public final CommTracker commTracker()
  {
    return (CommTracker)provideCommTrackerProvider.get();
  }
  
  public final CommentPublisher commentPublisher()
  {
    return (CommentPublisher)provideCommentPublisherProvider.get();
  }
  
  public final ConfigurationManager configurationManager()
  {
    return (ConfigurationManager)provideConfigurationManagerProvider.get();
  }
  
  public final ConnectionStore connectionStore()
  {
    return (ConnectionStore)provideConnectionStoreProvider.get();
  }
  
  public final ConnectionsFetchingManager connectionsFetchingManager()
  {
    return (ConnectionsFetchingManager)connectionsFetchingManagerProvider.get();
  }
  
  public final ConsistencyManager consistencyManager()
  {
    return (ConsistencyManager)provideConsistencyManagerProvider.get();
  }
  
  public final CookieUtil cookieUtil()
  {
    return (CookieUtil)provideCookieUtilProvider.get();
  }
  
  public final CrossPromoManager crossPromoManager()
  {
    return (CrossPromoManager)provideCrossPromoManagerProvider.get();
  }
  
  public final FlagshipDataManager dataManager()
  {
    return (FlagshipDataManager)provideFlagshipDataManagerProvider.get();
  }
  
  public final DeepLinkManager deepLinkManager()
  {
    return (DeepLinkManager)deepLinkManagerProvider.get();
  }
  
  public final DelayedExecution delayedExecution()
  {
    return (DelayedExecution)provideDelayedExecutionProvider.get();
  }
  
  public final int deviceClass()
  {
    return ((Integer)provideDeviceClassProvider.get()).intValue();
  }
  
  public final Bus eventBus()
  {
    return (Bus)busProvider.get();
  }
  
  public final ExecutorService executorService()
  {
    return (ExecutorService)provideExecutorServiceProvider.get();
  }
  
  public final FeedKeyValueStore feedValues()
  {
    return (FeedKeyValueStore)provideFeedKeyValueStoreProvider.get();
  }
  
  public final FlagshipAssetManager flagshipAssetManager()
  {
    return (FlagshipAssetManager)provideFlagshipAssetManagerProvider.get();
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
    return (FollowPublisher)provideFollowPublisherProvider.get();
  }
  
  public final FragmentRegistry fragmentRegistry()
  {
    return (FragmentRegistry)fragmentRegistryProvider.get();
  }
  
  public final GeoLocator geoLocator()
  {
    return (GeoLocator)provideGeoLocatorProvider.get();
  }
  
  public final GroupSharePublisher groupsSharePublisher()
  {
    return (GroupSharePublisher)provideGroupsSharePublisherProvider.get();
  }
  
  public final HomeCachedLix homeCachedLix()
  {
    return (HomeCachedLix)providesHomeCachedLixProvider.get();
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
  
  public final IntentRegistry intentRegistry()
  {
    return (IntentRegistry)intentRegistryProvider.get();
  }
  
  public final InternetConnectionMonitor internetConnectionMonitor()
  {
    return (InternetConnectionMonitor)provideInternetConnectionMonitorProvider.get();
  }
  
  public final LaunchUtils launchUtils()
  {
    return (LaunchUtils)provideLaunchUtilsProvider.get();
  }
  
  public final LikePublisher likePublisher()
  {
    return (LikePublisher)provideLikePublisherProvider.get();
  }
  
  public final LixManager lixManager()
  {
    return (LixManager)provideAuthenticatedLixManagerProvider.get();
  }
  
  public final com.linkedin.android.infra.shared.LongClickUtil longClickUtil()
  {
    return (com.linkedin.android.infra.shared.LongClickUtil)provideLongClickUtilProvider.get();
  }
  
  public final Handler mainHandler()
  {
    return (Handler)provideMainHandlerProvider.get();
  }
  
  public final MeDedupProxy meDedupProxy()
  {
    return (MeDedupProxy)provideMeDedupProxyProvider.get();
  }
  
  public final MediaCenter mediaCenter()
  {
    return (MediaCenter)provideMediaCenterProvider.get();
  }
  
  public final MediaUploader mediaUploader()
  {
    return (MediaUploader)provideMediaUploaderProvider.get();
  }
  
  public final MemberUtil memberUtil()
  {
    return (MemberUtil)provideMemberUtilProvider.get();
  }
  
  public final com.linkedin.messengerlib.utils.LongClickUtil messengerLongClickUtil()
  {
    return (com.linkedin.messengerlib.utils.LongClickUtil)provideMessengerLongClickUtilProvider.get();
  }
  
  public final NavigationManager navigationManager()
  {
    return (NavigationManager)navigationManagerProvider.get();
  }
  
  public final NetworkClient networkClient()
  {
    return (NetworkClient)provideNetworkClientProvider.get();
  }
  
  public final CheckForNewUpdatesRunnable newUpdatesChecker()
  {
    return (CheckForNewUpdatesRunnable)provideNewUpdatesRunnableProvider.get();
  }
  
  public final NotificationDisplayUtils notificationDisplayUtils()
  {
    return (NotificationDisplayUtils)provideNotificationDisplayUtilsProvider.get();
  }
  
  public final NotificationUtils notificationUtils()
  {
    return (NotificationUtils)notificationUtilsProvider.get();
  }
  
  public final OAuthNetworkHelper oAuthNetworkHelper()
  {
    return (OAuthNetworkHelper)provideOAuthNetworkHelperProvider.get();
  }
  
  public final PaymentService paymentService()
  {
    return (PaymentService)paymentServiceProvider.get();
  }
  
  public final Tracker perfTracker()
  {
    return (Tracker)providerPerfTrackerProvider.get();
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
    return (PreAuthLixManager)providePreAuthLixManagerProvider.get();
  }
  
  public final ProfilePendingConnectionRequestManager profilePendingConnectionRequestManager()
  {
    return (ProfilePendingConnectionRequestManager)profilePendingConnectionRequestManagerProvider.get();
  }
  
  public final ProfileUtil profileUtil()
  {
    return (ProfileUtil)profileUtilProvider.get();
  }
  
  public final ProgressBarUtil progressBarUtil()
  {
    return (ProgressBarUtil)ProgressBarUtil_Factory.create().get();
  }
  
  public final DeeplinkHelper provideDeeplinkHelper()
  {
    return (DeeplinkHelper)provideDeeplinkHelperProvider.get();
  }
  
  public final RateTheApp rateTheApp()
  {
    return (RateTheApp)provideRateTheAppProvider.get();
  }
  
  public final RealTimeManager realTimeManager()
  {
    return (RealTimeManager)provideRealTimeManagerProvider.get();
  }
  
  public final Optional<RefWatcher> refWatcher()
  {
    return (Optional)provideRefWatcherProvider.get();
  }
  
  public final ReportEntityInvokerHelper reportEntityInvokerHelper()
  {
    return (ReportEntityInvokerHelper)provideReportEntityInvokerHelperProvider.get();
  }
  
  public final SearchUtils searchUtils()
  {
    return (SearchUtils)provideSearchUtilsProvider.get();
  }
  
  public final FeedSharePublisher sharePublisher()
  {
    return (FeedSharePublisher)provideSharePublisherProvider.get();
  }
  
  public final SnackbarUtil snackbarUtil()
  {
    return (SnackbarUtil)provideSnackbarUtilProvider.get();
  }
  
  public final SponsoredUpdateTracker sponsoredUpdateTracker()
  {
    return (SponsoredUpdateTracker)provideSponsoredUpdateTrackerProvider.get();
  }
  
  public final TermsOfServiceInterface termsOfService()
  {
    return (TermsOfServiceInterface)provideTermsOfServiceProvider.get();
  }
  
  public final ThirdPartySdkManager thirdPartySdkManager()
  {
    return (ThirdPartySdkManager)provideThirdPartySdkManagerProvider.get();
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
    return (Tracker)provideTrackerProvider.get();
  }
  
  public final LiTrackingNetworkStack trackingNetworkStack()
  {
    return (LiTrackingNetworkStack)provideTrackingNetworkStackProvider.get();
  }
  
  public final TransformerExecutor transformerExecutor()
  {
    return (TransformerExecutor)provideSynchronousBackgroundQueueProvider.get();
  }
  
  public final UpdateChangeCoordinator updateChangeCoordinator()
  {
    return (UpdateChangeCoordinator)provideUpdateChangeCoordinatorProvider.get();
  }
  
  public final ViewPagerManager viewPagerManager()
  {
    return (ViewPagerManager)provideViewPagerManagerProvider.get();
  }
  
  public final ViewPagerObserver viewPagerObserver()
  {
    return (ViewPagerObserver)provideViewPagerObserverProvider.get();
  }
  
  public final ViewportTrackingConfiguration viewportConfig()
  {
    return (ViewportTrackingConfiguration)provideViewportConfigProvider.get();
  }
  
  public final ViewPortManager viewportManager()
  {
    return (ViewPortManager)provideViewportManagerProvider.get();
  }
  
  public final WebRouter webRouter()
  {
    return (WebRouter)provideWebRouterProvider.get();
  }
  
  public final WebRouterUtil webRouterUtil()
  {
    return (WebRouterUtil)provideWebRouterUtilProvider.get();
  }
  
  public final WebViewLoadProxy webViewLoadProxy()
  {
    return (WebViewLoadProxy)provideWebViewLoadProxyProvider.get();
  }
  
  public static final class Builder
  {
    public ApplicationModule applicationModule;
    public DataManagerModule dataManagerModule;
    public FeedModule feedModule;
    public UtilModule utilModule;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.components.DaggerApplicationComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */