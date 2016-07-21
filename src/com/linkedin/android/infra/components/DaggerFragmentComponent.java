package com.linkedin.android.infra.components;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.Fragment;
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
import com.linkedin.android.entities.EntityCoordinatorBaseFragment;
import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.entities.company.controllers.CompanyActivity;
import com.linkedin.android.entities.group.GroupDataProvider;
import com.linkedin.android.entities.group.controllers.GroupActivity;
import com.linkedin.android.entities.group.controllers.GroupFragment;
import com.linkedin.android.entities.group.controllers.GroupFragment_MembersInjector;
import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.entities.job.controllers.JobActivity;
import com.linkedin.android.entities.jymbii.JymbiiActivity;
import com.linkedin.android.entities.jymbii.JymbiiDataProvider;
import com.linkedin.android.entities.school.SchoolDataProvider;
import com.linkedin.android.entities.school.controllers.SchoolActivity;
import com.linkedin.android.feed.FeedTrackableFragment;
import com.linkedin.android.feed.FeedUpdatesDataProvider;
import com.linkedin.android.feed.actorlist.BaseFeedActorListFragment;
import com.linkedin.android.feed.actorlist.BaseFeedActorListFragment_MembersInjector;
import com.linkedin.android.feed.aggregate.AggregateFragment;
import com.linkedin.android.feed.aggregate.AggregateFragment_MembersInjector;
import com.linkedin.android.feed.channel.ChannelFragment;
import com.linkedin.android.feed.channel.ChannelFragment_MembersInjector;
import com.linkedin.android.feed.channel.ChannelUpdatesDataProvider;
import com.linkedin.android.feed.detail.FeedUpdateDetailDataProvider;
import com.linkedin.android.feed.detail.FeedUpdateDetailFragment;
import com.linkedin.android.feed.detail.FeedUpdateDetailFragment_MembersInjector;
import com.linkedin.android.feed.endor.datamodel.transformer.service.TransformerExecutor;
import com.linkedin.android.feed.mentions.MentionsPresenter;
import com.linkedin.android.feed.mentions.MentionsPresenter_Factory;
import com.linkedin.android.feed.mentions.MentionsPresenter_MembersInjector;
import com.linkedin.android.feed.page.feed.BaseFeedFragment;
import com.linkedin.android.feed.page.feed.BaseFeedFragment_MembersInjector;
import com.linkedin.android.feed.page.feed.FeedFragment;
import com.linkedin.android.feed.page.feed.FeedFragment_MembersInjector;
import com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdatesDataProvider;
import com.linkedin.android.feed.page.feed.newupdatespill.CheckForNewUpdatesRunnable;
import com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateDataProvider;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.feed.shared.imageviewer.ImageViewerFragment;
import com.linkedin.android.feed.shared.imageviewer.ImageViewerFragment_MembersInjector;
import com.linkedin.android.feed.shared.liking.LikePublisher;
import com.linkedin.android.feed.shared.videoviewer.VideoViewerFragment;
import com.linkedin.android.feed.shared.videoviewer.VideoViewerFragment_MembersInjector;
import com.linkedin.android.feed.tracking.SponsoredUpdateTracker;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailDataProvider;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragment;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragment_MembersInjector;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDataProvider;
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
import com.linkedin.android.growth.abi.AbiLegoWidgetSwitch;
import com.linkedin.android.growth.abi.AbiLegoWidgetSwitch_Factory;
import com.linkedin.android.growth.abi.AbiLoadContactsFragment;
import com.linkedin.android.growth.abi.AbiLoadContactsFragment_MembersInjector;
import com.linkedin.android.growth.abi.AbiPrepareFragment;
import com.linkedin.android.growth.abi.AbiPrepareFragment_MembersInjector;
import com.linkedin.android.growth.abi.AbiResultFragment;
import com.linkedin.android.growth.abi.AbiResultFragment_MembersInjector;
import com.linkedin.android.growth.abi.splash.AbiLearnMoreFragment;
import com.linkedin.android.growth.abi.splash.AbiLearnMoreFragment_MembersInjector;
import com.linkedin.android.growth.abi.splash.AbiSplashBaseFragment;
import com.linkedin.android.growth.abi.splash.AbiSplashBaseFragment_MembersInjector;
import com.linkedin.android.growth.abi.splash.MainAbiSplashFragment;
import com.linkedin.android.growth.boost.error.BoostErrorFragment;
import com.linkedin.android.growth.boost.error.BoostErrorFragment_MembersInjector;
import com.linkedin.android.growth.boost.splash.BoostSplashFragment;
import com.linkedin.android.growth.boost.splash.BoostSplashFragment_MembersInjector;
import com.linkedin.android.growth.calendar.CalendarSyncSettingsFragment;
import com.linkedin.android.growth.calendar.CalendarSyncSettingsFragment_MembersInjector;
import com.linkedin.android.growth.calendar.CalendarSyncSplashFragment;
import com.linkedin.android.growth.calendar.CalendarSyncSplashFragment_MembersInjector;
import com.linkedin.android.growth.calendar.CalendarSyncTakeoverFragment;
import com.linkedin.android.growth.calendar.CalendarSyncTakeoverFragment_MembersInjector;
import com.linkedin.android.growth.calendar.sync.CalendarSyncManager;
import com.linkedin.android.growth.heathrow.HeathrowFlowDataProvider;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.growth.lego.LegoManager;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.lego.LegoWidget_MembersInjector;
import com.linkedin.android.growth.lego.MultiFragmentLegoWidget;
import com.linkedin.android.growth.lego.SingleFragmentLegoWidget;
import com.linkedin.android.growth.login.LoginActivity;
import com.linkedin.android.growth.login.LoginActivity_MembersInjector;
import com.linkedin.android.growth.login.LoginUtils;
import com.linkedin.android.growth.login.PrefillManager;
import com.linkedin.android.growth.login.PrefillManager_Factory;
import com.linkedin.android.growth.login.fastrack.FastrackManager;
import com.linkedin.android.growth.login.fastrack.FastrackManager_Factory;
import com.linkedin.android.growth.login.fastrack.FastrackManager_MembersInjector;
import com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager;
import com.linkedin.android.growth.login.join.JoinFragment;
import com.linkedin.android.growth.login.join.JoinFragment_MembersInjector;
import com.linkedin.android.growth.login.join.JoinManager;
import com.linkedin.android.growth.login.join.JoinManager_Factory;
import com.linkedin.android.growth.login.login.LoginFragment;
import com.linkedin.android.growth.login.login.LoginFragment_MembersInjector;
import com.linkedin.android.growth.login.login.LoginManager;
import com.linkedin.android.growth.login.login.LoginManager_Factory;
import com.linkedin.android.growth.login.phoneverification.CountrySelectorManager;
import com.linkedin.android.growth.login.phoneverification.CountrySelectorManager_Factory;
import com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragment;
import com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragment_MembersInjector;
import com.linkedin.android.growth.login.phoneverification.PinVerificationFragment;
import com.linkedin.android.growth.login.phoneverification.PinVerificationFragment_MembersInjector;
import com.linkedin.android.growth.login.prereg.PreRegBaseFragment;
import com.linkedin.android.growth.login.prereg.PreRegFragment;
import com.linkedin.android.growth.login.prereg.PreRegFragment_MembersInjector;
import com.linkedin.android.growth.login.prereg.PreRegPropFragment;
import com.linkedin.android.growth.login.prereg.intro.PreRegIntroFragment;
import com.linkedin.android.growth.login.prereg.intro.PreRegIntroFragmentViewHolder;
import com.linkedin.android.growth.login.prereg.intro.PreRegIntroFragmentViewModel;
import com.linkedin.android.growth.login.prereg.intro.PreRegIntroFragment_MembersInjector;
import com.linkedin.android.growth.login.presenters.InputValidationPresenter;
import com.linkedin.android.growth.login.presenters.InputValidationPresenter_Factory;
import com.linkedin.android.growth.login.presenters.PasswordVisibilityPresenter;
import com.linkedin.android.growth.login.presenters.PasswordVisibilityPresenter_Factory;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.growth.login.sso.SSOFragment;
import com.linkedin.android.growth.login.sso.SSOManager;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroActivity;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroActivity_MembersInjector;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFragment;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFragment_MembersInjector;
import com.linkedin.android.growth.onboarding.OnboardingActivity;
import com.linkedin.android.growth.onboarding.OnboardingActivity_MembersInjector;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.growth.onboarding.OnboardingLegoWidgetSwitch;
import com.linkedin.android.growth.onboarding.OnboardingLegoWidgetSwitch_Factory;
import com.linkedin.android.growth.onboarding.OnboardingLegoWidgetSwitch_MembersInjector;
import com.linkedin.android.growth.onboarding.abi.splash.OnboardingAbiSplashFragment;
import com.linkedin.android.growth.onboarding.base.OnboardingListFragment;
import com.linkedin.android.growth.onboarding.base.OnboardingListFragment_MembersInjector;
import com.linkedin.android.growth.onboarding.base.OnboardingProfileEditFragment;
import com.linkedin.android.growth.onboarding.base.OnboardingProfileEditFragment_MembersInjector;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragment;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragment_MembersInjector;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationLoadingFragment;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationLoadingFragment_MembersInjector;
import com.linkedin.android.growth.onboarding.jobseeker_promo.JobseekerPromoFragment;
import com.linkedin.android.growth.onboarding.jobseeker_promo.JobseekerPromoFragment_MembersInjector;
import com.linkedin.android.growth.onboarding.location.LocationFragment;
import com.linkedin.android.growth.onboarding.location.LocationFragment_MembersInjector;
import com.linkedin.android.growth.onboarding.location.LocationPickerFragment;
import com.linkedin.android.growth.onboarding.location.LocationPickerFragment_MembersInjector;
import com.linkedin.android.growth.onboarding.photo.PhotoFragment;
import com.linkedin.android.growth.onboarding.photo.PhotoFragment_MembersInjector;
import com.linkedin.android.growth.onboarding.position_education.EducationFragment;
import com.linkedin.android.growth.onboarding.position_education.EducationFragment_MembersInjector;
import com.linkedin.android.growth.onboarding.position_education.IndustryPickerFragment;
import com.linkedin.android.growth.onboarding.position_education.PositionFragment;
import com.linkedin.android.growth.onboarding.position_education.PositionFragment_MembersInjector;
import com.linkedin.android.growth.onboarding.pymk.PymkFragment;
import com.linkedin.android.growth.onboarding.pymk.PymkFragment_MembersInjector;
import com.linkedin.android.growth.onboarding.pymk.PymkItemViewModel;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedActivity;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedDataProvider;
import com.linkedin.android.growth.onboarding.welcome_mat.WelcomeMatFragment;
import com.linkedin.android.growth.onboarding.welcome_mat.WelcomeMatFragment_MembersInjector;
import com.linkedin.android.growth.onboarding.welcome_mat.WelcomeMatItemViewModel;
import com.linkedin.android.growth.phonecollection.PhoneCollectionFragment;
import com.linkedin.android.growth.phonecollection.PhoneCollectionFragment_MembersInjector;
import com.linkedin.android.growth.seo.samename.SameNameDirectoryActivity;
import com.linkedin.android.growth.seo.samename.SameNameDirectoryDataProvider;
import com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentFragment;
import com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentFragment_MembersInjector;
import com.linkedin.android.growth.takeover.NewToVoyagerTransactionalLaunchManager;
import com.linkedin.android.growth.takeover.NewToVoyagerTransactionalLaunchManager_Factory;
import com.linkedin.android.growth.takeover.TakeoverManager;
import com.linkedin.android.growth.takeover.TakeoverManager_Factory;
import com.linkedin.android.growth.utils.InputValidator;
import com.linkedin.android.growth.utils.InputValidator_Factory;
import com.linkedin.android.growth.utils.ProgressBarUtil;
import com.linkedin.android.growth.utils.ThirdPartySdkManager;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.home.HomeActivity_MembersInjector;
import com.linkedin.android.home.HomeCachedLix;
import com.linkedin.android.home.HomeFragment;
import com.linkedin.android.home.HomeFragmentDataProvider;
import com.linkedin.android.home.HomeFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfileBasicInfoEditFragment;
import com.linkedin.android.identity.edit.ProfileBasicInfoEditFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfileCertificationEditFragment;
import com.linkedin.android.identity.edit.ProfileCertificationEditFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfileContactInfoEditFragment;
import com.linkedin.android.identity.edit.ProfileContactInfoEditFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfileCourseEditFragment;
import com.linkedin.android.identity.edit.ProfileCourseEditFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfileEditBaseFragment;
import com.linkedin.android.identity.edit.ProfileEditBaseFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfileEditTreasuryBaseFragment;
import com.linkedin.android.identity.edit.ProfileEducationEditFragment;
import com.linkedin.android.identity.edit.ProfileEducationEditFragmentV2;
import com.linkedin.android.identity.edit.ProfileEducationEditFragmentV2_MembersInjector;
import com.linkedin.android.identity.edit.ProfileEducationEditFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfileEndorsementsEditFragment;
import com.linkedin.android.identity.edit.ProfileEndorsementsEditFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfileHonorEditFragment;
import com.linkedin.android.identity.edit.ProfileHonorEditFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfilePatentEditFragment;
import com.linkedin.android.identity.edit.ProfilePatentEditFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfilePositionEditFragment;
import com.linkedin.android.identity.edit.ProfilePositionEditFragmentV2;
import com.linkedin.android.identity.edit.ProfilePositionEditFragmentV2_MembersInjector;
import com.linkedin.android.identity.edit.ProfilePositionEditFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfileProjectEditFragment;
import com.linkedin.android.identity.edit.ProfileProjectEditFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfileProjectMemberEditFragment;
import com.linkedin.android.identity.edit.ProfileProjectMemberEditFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfilePublicationEditFragment;
import com.linkedin.android.identity.edit.ProfilePublicationEditFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfileSkillsEditFragment;
import com.linkedin.android.identity.edit.ProfileSkillsEditFragmentV2;
import com.linkedin.android.identity.edit.ProfileSkillsEditFragmentV2_MembersInjector;
import com.linkedin.android.identity.edit.ProfileSkillsEditFragment_MembersInjector;
import com.linkedin.android.identity.edit.ProfileVolunteeringExperienceEditFragment;
import com.linkedin.android.identity.edit.ProfileVolunteeringExperienceEditFragment_MembersInjector;
import com.linkedin.android.identity.edit.newSections.ProfileNewSectionsFragment;
import com.linkedin.android.identity.edit.newSections.ProfileNewSectionsFragment_MembersInjector;
import com.linkedin.android.identity.edit.treasury.ProfileTreasuryEditFragment;
import com.linkedin.android.identity.edit.treasury.ProfileTreasuryEditFragment_MembersInjector;
import com.linkedin.android.identity.guidededit.GuidedEditActivity;
import com.linkedin.android.identity.guidededit.GuidedEditDataProvider;
import com.linkedin.android.identity.guidededit.infra.GuidedEditFlowRootFragment;
import com.linkedin.android.identity.guidededit.infra.GuidedEditFlowRootFragment_MembersInjector;
import com.linkedin.android.identity.guidededit.infra.GuidedEditTaskFragment;
import com.linkedin.android.identity.guidededit.infra.GuidedEditTaskFragment_MembersInjector;
import com.linkedin.android.identity.guidededit.infra.nullstate.GuidedEditSuggestionNullStateFragment;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsedSkillsCardFragment;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsedSkillsDataProvider;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementActivity;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementsEndorserDataProvider;
import com.linkedin.android.identity.guidededit.suggestedskills.GuidedEditSuggestedSkillsExitFragment;
import com.linkedin.android.identity.guidededit.suggestedskills.GuidedEditSuggestedSkillsFragment;
import com.linkedin.android.identity.me.contentanalytics.ContentAnalyticsDataProvider;
import com.linkedin.android.identity.me.contentanalytics.ContentAnalyticsFragment;
import com.linkedin.android.identity.me.notifications.NotificationsDataProvider;
import com.linkedin.android.identity.me.notifications.NotificationsFragment;
import com.linkedin.android.identity.me.notifications.NotificationsFragment_MembersInjector;
import com.linkedin.android.identity.me.notifications.cards.dataproviders.MeCardDataProvider;
import com.linkedin.android.identity.me.shared.actorlist.MeActorListFragment;
import com.linkedin.android.identity.me.shared.paging.MeDedupProxy;
import com.linkedin.android.identity.me.shared.util.ViewPagerManager;
import com.linkedin.android.identity.me.wvmp.MeWvmpDataProvider;
import com.linkedin.android.identity.me.wvmp.MeWvmpFragment;
import com.linkedin.android.identity.me.wvmp.MeWvmpFragment_MembersInjector;
import com.linkedin.android.identity.me.wvmpV2.WvmpDataProvider;
import com.linkedin.android.identity.me.wvmpV2.WvmpFragment;
import com.linkedin.android.identity.me.wvmpV2.WvmpFragment_MembersInjector;
import com.linkedin.android.identity.profile.ProfileActionHandlerFragment;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileViewActivity;
import com.linkedin.android.identity.profile.ProfileViewFragment;
import com.linkedin.android.identity.profile.ProfileViewFragment_MembersInjector;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.identity.profile.view.accomplishments.detail.ProfileAccomplishmentsFragment;
import com.linkedin.android.identity.profile.view.background.detail.ProfileBackgroundFragment;
import com.linkedin.android.identity.profile.view.groups.ProfileGroupsFragment;
import com.linkedin.android.identity.profile.view.groups.ProfileGroupsFragment_MembersInjector;
import com.linkedin.android.identity.profile.view.groups.ProfileViewGroupsCardEntryViewModel;
import com.linkedin.android.identity.profile.view.imageViewer.ProfileImageViewerFragment;
import com.linkedin.android.identity.profile.view.imageViewer.ProfileImageViewerFragment_MembersInjector;
import com.linkedin.android.identity.profile.view.pagedlist.PagedListFragment;
import com.linkedin.android.identity.profile.view.recentactivity.detail.ProfileActivityFeedDataProvider;
import com.linkedin.android.identity.profile.view.recentactivity.detail.ProfileFeedFragment;
import com.linkedin.android.identity.profile.view.recentactivity.detail.ProfileSharesFeedDataProvider;
import com.linkedin.android.identity.profile.view.topcard.ProfileSummaryFragment;
import com.linkedin.android.identity.shared.ProfileBaseFragment;
import com.linkedin.android.identity.shared.ProfileEditPhotoCropFragment;
import com.linkedin.android.identity.shared.ProfileEditPhotoCropFragment_MembersInjector;
import com.linkedin.android.identity.shared.ProfilePhotoViewFragment;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.imageloader.interfaces.ImageLoader;
import com.linkedin.android.imageloader.interfaces.ImageLoaderCache;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.animations.AnimationProxy;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseActivity_MembersInjector;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.BaseFragment_MembersInjector;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.LaunchUtils;
import com.linkedin.android.infra.app.NavigationManager;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.app.TrackableFragment_MembersInjector;
import com.linkedin.android.infra.app.ViewPagerFragment;
import com.linkedin.android.infra.data.FlagshipCacheManager;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.TitanDataMigrationManager;
import com.linkedin.android.infra.debug.ui.CookieDebugFragment;
import com.linkedin.android.infra.debug.ui.CookieDebugFragment_MembersInjector;
import com.linkedin.android.infra.debug.ui.CookieEditDialogFragment;
import com.linkedin.android.infra.debug.ui.CookieEditDialogFragment_MembersInjector;
import com.linkedin.android.infra.debug.ui.LixDebugFragment;
import com.linkedin.android.infra.debug.ui.LixDebugFragment_MembersInjector;
import com.linkedin.android.infra.debug.ui.LixOverrideDialogFragment;
import com.linkedin.android.infra.debug.ui.LixOverrideDialogFragment_MembersInjector;
import com.linkedin.android.infra.debug.ui.SharedPreferenceDebugFragment;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.gms.GeoLocator;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.infra.mediaupload.MediaUploader;
import com.linkedin.android.infra.modules.FragmentModule;
import com.linkedin.android.infra.modules.FragmentModule_ProvideFragmentFactory;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.ConfigurationManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.ImageQualityManager;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.network.PlaceholderImageCache;
import com.linkedin.android.infra.realtime.RealTimeManager;
import com.linkedin.android.infra.semaphore.ReportEntityInvokerHelper;
import com.linkedin.android.infra.settings.ui.PhoneOnlyUserDialogManager;
import com.linkedin.android.infra.settings.ui.PhoneOnlyUserDialogManager_Factory;
import com.linkedin.android.infra.settings.ui.SettingsFragment;
import com.linkedin.android.infra.shared.AppUpgradeUtils;
import com.linkedin.android.infra.shared.CalendarTaskUtil;
import com.linkedin.android.infra.shared.InternetConnectionMonitor;
import com.linkedin.android.infra.shared.KeyboardUtil_Factory;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Optional;
import com.linkedin.android.infra.shared.PhotoCropFragment;
import com.linkedin.android.infra.shared.PhotoCropFragment_MembersInjector;
import com.linkedin.android.infra.shared.PhotoUtils;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.StringUtils_Factory;
import com.linkedin.android.infra.shared.TimeWrapper;
import com.linkedin.android.infra.tos.TermsOfServiceInterface;
import com.linkedin.android.infra.ui.ViewPagerObserver;
import com.linkedin.android.infra.ui.cardtoast.CardToastManager;
import com.linkedin.android.infra.viewport.ViewportTrackingConfiguration;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewLoadProxy;
import com.linkedin.android.infra.webviewer.WebViewerBaseFragment;
import com.linkedin.android.infra.webviewer.WebViewerBaseFragment_MembersInjector;
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
import com.linkedin.android.messaging.MessagingFragment;
import com.linkedin.android.messaging.MessagingFragment_MembersInjector;
import com.linkedin.android.messaging.compose.ComposeFragment;
import com.linkedin.android.messaging.compose.ComposeFragment_MembersInjector;
import com.linkedin.android.messaging.compose.InmailComposeFragment;
import com.linkedin.android.messaging.compose.InmailComposeFragment_MembersInjector;
import com.linkedin.android.messaging.conversationlist.ConversationSearchListFragment;
import com.linkedin.android.messaging.conversationlist.ConversationSearchListFragment_MembersInjector;
import com.linkedin.android.messaging.integration.AssetLoaderNetworkClient;
import com.linkedin.android.messaging.integration.FlagshipAssetManager;
import com.linkedin.android.messaging.messagelist.AttachmentViewerFragment;
import com.linkedin.android.messaging.messagelist.AttachmentViewerFragment_MembersInjector;
import com.linkedin.android.messaging.messagelist.MessageListActivity;
import com.linkedin.android.messaging.messagelist.MessageListActivity_MembersInjector;
import com.linkedin.android.messaging.messagelist.MessageListFragment;
import com.linkedin.android.messaging.messagelist.MessageListFragment_MembersInjector;
import com.linkedin.android.messaging.participantdetails.AddParticipantFragment;
import com.linkedin.android.messaging.participantdetails.AddParticipantFragment_MembersInjector;
import com.linkedin.android.messaging.participantdetails.ParticipantDetailsFragment;
import com.linkedin.android.messaging.participantdetails.ParticipantDetailsFragment_MembersInjector;
import com.linkedin.android.messaging.reconnect.ReconnectActivity;
import com.linkedin.android.messaging.reconnect.ReconnectFragment;
import com.linkedin.android.messaging.reconnect.ReconnectFragment_MembersInjector;
import com.linkedin.android.messaging.stickers.BaseMessengerFragment;
import com.linkedin.android.messaging.stickers.StickerStoreFragment;
import com.linkedin.android.messaging.stickers.StickerStoreFragment_MembersInjector;
import com.linkedin.android.networking.cookies.CookieUtil;
import com.linkedin.android.paymentslibrary.api.PaymentService;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.Industry;
import com.linkedin.android.pegasus.gen.voyager.growth.goal.GoalType;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.FollowableEntity;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow;
import com.linkedin.android.premium.PremiumActivity;
import com.linkedin.android.premium.PremiumDataProvider;
import com.linkedin.android.premium.SubscriptionChooserFragment;
import com.linkedin.android.premium.SubscriptionChooserFragment_MembersInjector;
import com.linkedin.android.premium.SubscriptionChooserPageFragment;
import com.linkedin.android.premium.checkout.BaseCheckoutFragment;
import com.linkedin.android.premium.checkout.CheckoutFragment;
import com.linkedin.android.premium.checkout.CheckoutFragment_MembersInjector;
import com.linkedin.android.premium.chooser.PremiumChooserFragment;
import com.linkedin.android.premium.chooser.PremiumChooserFragment_MembersInjector;
import com.linkedin.android.premium.chooser.PremiumChooserPageFragment;
import com.linkedin.android.premium.onboarding.PremiumOnboardingCardFragment;
import com.linkedin.android.premium.onboarding.PremiumOnboardingCardFragment_MembersInjector;
import com.linkedin.android.publishing.reader.ArticleActivity;
import com.linkedin.android.publishing.reader.PublishingDataProvider;
import com.linkedin.android.publishing.reader.SocialReaderFragment;
import com.linkedin.android.publishing.reader.SocialReaderFragment_MembersInjector;
import com.linkedin.android.publishing.sharing.compose.BaseShareComposeFragment;
import com.linkedin.android.publishing.sharing.compose.BaseShareComposeFragment_MembersInjector;
import com.linkedin.android.publishing.sharing.compose.FeedSharePublisher;
import com.linkedin.android.publishing.sharing.compose.GroupSharePublisher;
import com.linkedin.android.publishing.sharing.mentionpicker.MentionPickerFragment;
import com.linkedin.android.publishing.sharing.mentionpicker.MentionPickerFragment_MembersInjector;
import com.linkedin.android.relationships.MyNetworkFragment;
import com.linkedin.android.relationships.MyNetworkFragment_MembersInjector;
import com.linkedin.android.relationships.RelationshipsDataProvider;
import com.linkedin.android.relationships.RelationshipsFragment;
import com.linkedin.android.relationships.RelationshipsFragment_MembersInjector;
import com.linkedin.android.relationships.RelationshipsSecondaryActivity;
import com.linkedin.android.relationships.RelationshipsSecondaryBaseFragment;
import com.linkedin.android.relationships.addConnections.AddConnectionsFragment;
import com.linkedin.android.relationships.addConnections.AddConnectionsFragment_MembersInjector;
import com.linkedin.android.relationships.addConnections.PymkDataProvider;
import com.linkedin.android.relationships.connectFlow.ConnectFlowDataProvider;
import com.linkedin.android.relationships.connectFlow.ConnectFlowFragment;
import com.linkedin.android.relationships.connectFlow.ConnectFlowFragment_MembersInjector;
import com.linkedin.android.relationships.connections.ConnectionListV2Fragment;
import com.linkedin.android.relationships.connections.ConnectionListV2Fragment_MembersInjector;
import com.linkedin.android.relationships.connections.ConnectionStore;
import com.linkedin.android.relationships.connections.ConnectionsFetchingManager;
import com.linkedin.android.relationships.connections.ConnectionsV2DataProvider;
import com.linkedin.android.relationships.invitations.InvitationsDataProvider;
import com.linkedin.android.relationships.invitations.InvitationsListChildFragment;
import com.linkedin.android.relationships.invitations.InvitationsListChildFragment_MembersInjector;
import com.linkedin.android.relationships.invitations.PendingInvitationDataProvider;
import com.linkedin.android.relationships.invitations.PendingInvitationListFragment;
import com.linkedin.android.relationships.invitations.PendingInvitationListFragment_MembersInjector;
import com.linkedin.android.relationships.meetings.MeetingDetailsDataProvider;
import com.linkedin.android.relationships.meetings.MeetingDetailsFragment;
import com.linkedin.android.relationships.meetings.MeetingDetailsFragment_MembersInjector;
import com.linkedin.android.search.SearchActivity;
import com.linkedin.android.search.SearchActivity_MembersInjector;
import com.linkedin.android.search.SearchDataProvider;
import com.linkedin.android.search.facet.SearchFacetFragment;
import com.linkedin.android.search.facet.SearchFacetFragment_MembersInjector;
import com.linkedin.android.search.facet.SearchFacetTransformer;
import com.linkedin.android.search.facet.SearchFacetTransformer_Factory;
import com.linkedin.android.search.resourcelist.ResourceListFragment;
import com.linkedin.android.search.searchengine.SearchEngineTransformer;
import com.linkedin.android.search.searchengine.SearchEngineTransformer_Factory;
import com.linkedin.android.search.secondaryresults.SecondaryResultsTransformer;
import com.linkedin.android.search.secondaryresults.SecondaryResultsTransformer_Factory;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.search.starter.SearchStarterFragment;
import com.linkedin.android.search.starter.SearchStarterFragment_MembersInjector;
import com.linkedin.android.search.starter.SearchStarterItemPresenter;
import com.linkedin.android.search.starter.SearchStarterItemPresenter_Factory;
import com.linkedin.android.search.typeahead.TypeAheadSearchBarPresenter_Factory;
import com.linkedin.android.search.typeahead.TypeaheadFragment;
import com.linkedin.android.search.typeahead.TypeaheadFragment_MembersInjector;
import com.linkedin.android.search.typeahead.TypeaheadItemPresenter;
import com.linkedin.android.search.typeahead.TypeaheadItemPresenter_Factory;
import com.linkedin.android.search.typeahead.TypeaheadItemPresenter_MembersInjector;
import com.linkedin.android.search.typeahead.TypeaheadSmallNoIconViewModel;
import com.linkedin.android.search.typeahead.TypeaheadTransformer;
import com.linkedin.android.search.typeahead.TypeaheadTransformer_Factory;
import com.linkedin.android.search.typeahead.TypeaheadTransformer_MembersInjector;
import com.linkedin.android.search.unifiedsearch.SearchFragment;
import com.linkedin.android.search.unifiedsearch.SearchFragmentBarPresenter;
import com.linkedin.android.search.unifiedsearch.SearchFragmentBarPresenter_Factory;
import com.linkedin.android.search.unifiedsearch.SearchFragmentBarPresenter_MembersInjector;
import com.linkedin.android.search.unifiedsearch.SearchFragmentItemPresenter;
import com.linkedin.android.search.unifiedsearch.SearchFragmentItemPresenter_Factory;
import com.linkedin.android.search.unifiedsearch.SearchFragmentItemPresenter_MembersInjector;
import com.linkedin.android.search.unifiedsearch.SearchFragment_MembersInjector;
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

public final class DaggerFragmentComponent
  implements FragmentComponent
{
  private MembersInjector<AbiActivity> abiActivityMembersInjector;
  private Provider<AbiAutoSyncManager> abiAutoSyncManagerProvider;
  private Provider<AbiCacheUtils> abiCacheUtilsProvider;
  private Provider<AbiContactsReader> abiContactsReaderProvider;
  private Provider<AbiDataProvider> abiDataProvider;
  private MembersInjector<AbiLearnMoreFragment> abiLearnMoreFragmentMembersInjector;
  private Provider<AbiLegoWidgetSwitch> abiLegoWidgetSwitchProvider;
  private MembersInjector<AbiLoadContactsFragment> abiLoadContactsFragmentMembersInjector;
  private MembersInjector<AbiPrepareFragment> abiPrepareFragmentMembersInjector;
  private MembersInjector<AbiResultFragment> abiResultFragmentMembersInjector;
  private MembersInjector<AbiSplashBaseFragment> abiSplashBaseFragmentMembersInjector;
  private Provider<ActivityComponent> activityComponentProvider;
  private Provider<BaseActivity> activityProvider;
  private MembersInjector<AddConnectionsFragment> addConnectionsFragmentMembersInjector;
  private MembersInjector<AddParticipantFragment> addParticipantFragmentMembersInjector;
  private MembersInjector<AggregateFragment> aggregateFragmentMembersInjector;
  private Provider<AnimationProxy> animationProxyProvider;
  private Provider<Context> appContextProvider;
  private Provider<FlagshipApplication> appProvider;
  private Provider<AppUpgradeUtils> appUpgradeUtilsProvider;
  private Provider<AppWidgetKeyValueStore> appwidgetValuesProvider;
  private MembersInjector<ArticleActivity> articleActivityMembersInjector;
  private Provider<PublishingDataProvider> articleDataProvider;
  private Provider<AssetLoaderNetworkClient> assetLoaderNetworkClientProvider;
  private MembersInjector<AttachmentViewerFragment> attachmentViewerFragmentMembersInjector;
  private Provider<HttpStack> authHttpStackProvider;
  private Provider<Auth> authProvider;
  private Provider<Badger> badgerProvider;
  private MembersInjector<BaseActivity> baseActivityMembersInjector;
  private MembersInjector<BaseCheckoutFragment> baseCheckoutFragmentMembersInjector;
  private MembersInjector<BaseFeedActorListFragment> baseFeedActorListFragmentMembersInjector;
  private MembersInjector<BaseFeedFragment> baseFeedFragmentMembersInjector;
  private MembersInjector<BaseFragment> baseFragmentMembersInjector;
  private MembersInjector<BaseMessengerActivity> baseMessengerActivityMembersInjector;
  private MembersInjector<BaseMessengerFragment> baseMessengerFragmentMembersInjector;
  private MembersInjector<BaseShareComposeFragment> baseShareComposeFragmentMembersInjector;
  private MembersInjector<BoostErrorFragment> boostErrorFragmentMembersInjector;
  private MembersInjector<BoostSplashFragment> boostSplashFragmentMembersInjector;
  private Provider<CalendarSyncManager> calendarSyncManagerProvider;
  private MembersInjector<CalendarSyncSettingsFragment> calendarSyncSettingsFragmentMembersInjector;
  private MembersInjector<CalendarSyncSplashFragment> calendarSyncSplashFragmentMembersInjector;
  private MembersInjector<CalendarSyncTakeoverFragment> calendarSyncTakeoverFragmentMembersInjector;
  private Provider<CalendarTaskUtil> calendarTaskUtilProvider;
  private Provider<CardToastManager> cardToastManagerProvider;
  private MembersInjector<ChannelFragment> channelFragmentMembersInjector;
  private Provider<ChannelUpdatesDataProvider> channelUpdatesDataProvider;
  private MembersInjector<CheckoutFragment> checkoutFragmentMembersInjector;
  private Provider<CommTracker> commTrackerProvider;
  private Provider<CommentDetailDataProvider> commentDetailDataProvider;
  private MembersInjector<CommentDetailFragment> commentDetailFragmentMembersInjector;
  private Provider<CommentPublisher> commentPublisherProvider;
  private MembersInjector<CompanyActivity> companyActivityMembersInjector;
  private Provider<CompanyDataProvider> companyDataProvider;
  private MembersInjector<ComposeFragment> composeFragmentMembersInjector;
  private Provider<ConfigurationManager> configurationManagerProvider;
  private Provider<ConnectFlowDataProvider> connectFlowDataProvider;
  private MembersInjector<ConnectFlowFragment> connectFlowFragmentMembersInjector;
  private MembersInjector<ConnectionListV2Fragment> connectionListV2FragmentMembersInjector;
  private Provider<ConnectionStore> connectionStoreProvider;
  private Provider<ConnectionsFetchingManager> connectionsFetchingManagerProvider;
  private Provider<ConnectionsV2DataProvider> connectionsV2DataProvider;
  private Provider<ConsistencyManager> consistencyManagerProvider;
  private Provider<ContentAnalyticsDataProvider> contentAnalyticsDataProvider;
  private MembersInjector<ContentAnalyticsFragment> contentAnalyticsFragmentMembersInjector;
  private Provider<ContentResolver> contentResolverProvider;
  private Provider<Context> contextProvider;
  private MembersInjector<ConversationSearchListFragment> conversationSearchListFragmentMembersInjector;
  private MembersInjector<CookieDebugFragment> cookieDebugFragmentMembersInjector;
  private MembersInjector<CookieEditDialogFragment> cookieEditDialogFragmentMembersInjector;
  private Provider<CookieUtil> cookieUtilProvider;
  private Provider<CountrySelectorManager> countrySelectorManagerProvider;
  private Provider<CrossPromoManager> crossPromoManagerProvider;
  private Provider<FlagshipDataManager> dataManagerProvider;
  private Provider<DeepLinkEmailManagementController> deepLinkEmailManagementControllerProvider;
  private MembersInjector<DeepLinkHelperActivity> deepLinkHelperActivityMembersInjector;
  private Provider<DeepLinkManager> deepLinkManagerProvider;
  private Provider<DelayedExecution> delayedExecutionProvider;
  private Provider<Integer> deviceClassProvider;
  private MembersInjector<EducationFragment> educationFragmentMembersInjector;
  private MembersInjector<EmailConfirmationFragment> emailConfirmationFragmentMembersInjector;
  private MembersInjector<EmailConfirmationLoadingFragment> emailConfirmationLoadingFragmentMembersInjector;
  private Provider<EmailManagementController> emailManagementControllerProvider;
  private MembersInjector<EntityBaseActivity> entityBaseActivityMembersInjector;
  private MembersInjector<EntityCoordinatorBaseFragment> entityCoordinatorBaseFragmentMembersInjector;
  private Provider<Bus> eventBusProvider;
  private Provider<ExecutorService> executorServiceProvider;
  private MembersInjector<FastrackManager> fastrackManagerMembersInjector;
  private Provider<FastrackManager> fastrackManagerProvider;
  private MembersInjector<FeedFragment> feedFragmentMembersInjector;
  private MembersInjector<FeedTrackableFragment> feedTrackableFragmentMembersInjector;
  private MembersInjector<FeedUpdateDetailFragment> feedUpdateDetailFragmentMembersInjector;
  private Provider<FeedUpdateDetailDataProvider> feedUpdateDetailProvider;
  private Provider<FeedUpdatesDataProvider> feedUpdatesDataProvider;
  private Provider<FeedKeyValueStore> feedValuesProvider;
  private Provider<FlagshipAssetManager> flagshipAssetManagerProvider;
  private Provider<FlagshipCacheManager> flagshipCacheManagerProvider;
  private Provider<FlagshipSharedPreferences> flagshipSharedPreferencesProvider;
  private Provider<FollowPublisher> followPublisherProvider;
  private Provider<FragmentComponent> fragmentComponentProvider;
  private Provider<FragmentManager> fragmentManagerProvider;
  private Provider<FragmentRegistry> fragmentRegistryProvider;
  private Provider<GeoLocator> geoLocatorProvider;
  private Provider<GoogleIdTokenManager> googleIdTokenManagerProvider;
  private MembersInjector<GroupActivity> groupActivityMembersInjector;
  private Provider<GroupDataProvider> groupDataProvider;
  private MembersInjector<GroupFragment> groupFragmentMembersInjector;
  private Provider<GroupSharePublisher> groupsSharePublisherProvider;
  private MembersInjector<GuidedEditActivity> guidedEditActivityMembersInjector;
  private Provider<GuidedEditDataProvider> guidedEditDataProvider;
  private MembersInjector<GuidedEditFlowRootFragment> guidedEditFlowRootFragmentMembersInjector;
  private MembersInjector<GuidedEditSuggestedSkillsExitFragment> guidedEditSuggestedSkillsExitFragmentMembersInjector;
  private MembersInjector<GuidedEditSuggestedSkillsFragment> guidedEditSuggestedSkillsFragmentMembersInjector;
  private MembersInjector<GuidedEditSuggestionNullStateFragment> guidedEditSuggestionNullStateFragmentMembersInjector;
  private MembersInjector<GuidedEditTaskFragment> guidedEditTaskFragmentMembersInjector;
  private Provider<HeathrowFlowDataProvider> heathrowFlowDataProvider;
  private Provider<HighlightedUpdatesDataProvider> highlightedUpdatesDataProvider;
  private MembersInjector<HomeActivity> homeActivityMembersInjector;
  private Provider<HomeCachedLix> homeCachedLixProvider;
  private Provider<HomeFragmentDataProvider> homeFragmentDataProvider;
  private MembersInjector<HomeFragment> homeFragmentMembersInjector;
  private Provider<I18NManager> i18NManagerProvider;
  private Provider<ImageLoaderCache> imageLoaderCacheProvider;
  private Provider<ImageLoader> imageLoaderProvider;
  private Provider<ImageQualityManager> imageQualityManagerProvider;
  private MembersInjector<ImageViewerFragment> imageViewerFragmentMembersInjector;
  private MembersInjector<IndustryPickerFragment> industryPickerFragmentMembersInjector;
  private MembersInjector<InmailComposeFragment> inmailComposeFragmentMembersInjector;
  private Provider<InputValidationPresenter> inputValidationPresenterProvider;
  private Provider<InputValidator> inputValidatorProvider;
  private Provider<IntentRegistry> intentRegistryProvider;
  private Provider<InternetConnectionMonitor> internetConnectionMonitorProvider;
  private Provider<InvitationsDataProvider> invitationsDataProvider;
  private MembersInjector<InvitationsListChildFragment> invitationsListChildFragmentMembersInjector;
  private MembersInjector<JobActivity> jobActivityMembersInjector;
  private Provider<JobDataProvider> jobDataProvider;
  private MembersInjector<JobseekerPromoFragment> jobseekerPromoFragmentMembersInjector;
  private MembersInjector<JoinFragment> joinFragmentMembersInjector;
  private Provider<JoinManager> joinManagerProvider;
  private MembersInjector<JymbiiActivity> jymbiiActivityMembersInjector;
  private Provider<JymbiiDataProvider> jymbiiDataProvider;
  private MembersInjector<LaunchActivity> launchActivityMembersInjector;
  private Provider<LaunchUtils> launchUtilsProvider;
  private MembersInjector<LegoFragment> legoFragmentMembersInjector;
  private Provider<LegoManager> legoManagerProvider;
  private Provider<LegoTrackingDataProvider> legoTrackingDataProvider;
  private MembersInjector<LegoWidget> legoWidgetMembersInjector;
  private Provider<LikePublisher> likePublisherProvider;
  private Provider<LikesDataProvider> likesDataProvider;
  private MembersInjector<LixDebugFragment> lixDebugFragmentMembersInjector;
  private Provider<LixManager> lixManagerProvider;
  private MembersInjector<LixOverrideDialogFragment> lixOverrideDialogFragmentMembersInjector;
  private MembersInjector<LocationFragment> locationFragmentMembersInjector;
  private MembersInjector<LocationPickerFragment> locationPickerFragmentMembersInjector;
  private MembersInjector<LoginActivity> loginActivityMembersInjector;
  private MembersInjector<LoginFragment> loginFragmentMembersInjector;
  private Provider<LoginManager> loginManagerProvider;
  private Provider<LoginUtils> loginUtilsProvider;
  private Provider<com.linkedin.android.infra.shared.LongClickUtil> longClickUtilProvider;
  private MembersInjector<MainAbiSplashFragment> mainAbiSplashFragmentMembersInjector;
  private Provider<Handler> mainHandlerProvider;
  private MembersInjector<MeActorListFragment> meActorListFragmentMembersInjector;
  private Provider<MeCardDataProvider> meCardDataProvider;
  private Provider<MeDedupProxy> meDedupProxyProvider;
  private Provider<MeWvmpDataProvider> meWvmpDataProvider;
  private MembersInjector<MeWvmpFragment> meWvmpFragmentMembersInjector;
  private Provider<MediaCenter> mediaCenterProvider;
  private Provider<MediaUploader> mediaUploaderProvider;
  private Provider<MeetingDetailsDataProvider> meetingDetailsDataProvider;
  private MembersInjector<MeetingDetailsFragment> meetingDetailsFragmentMembersInjector;
  private Provider<MemberUtil> memberUtilProvider;
  private MembersInjector<MentionPickerFragment> mentionPickerFragmentMembersInjector;
  private MembersInjector<MentionsPresenter> mentionsPresenterMembersInjector;
  private Provider<MentionsPresenter> mentionsPresenterProvider;
  private MembersInjector<MessageListActivity> messageListActivityMembersInjector;
  private MembersInjector<MessageListFragment> messageListFragmentMembersInjector;
  private MembersInjector<MessagingFragment> messagingFragmentMembersInjector;
  private Provider<com.linkedin.messengerlib.utils.LongClickUtil> messengerLongClickUtilProvider;
  private MembersInjector<MultiFragmentLegoWidget> multiFragmentLegoWidgetMembersInjector;
  private MembersInjector<MyNetworkFragment> myNetworkFragmentMembersInjector;
  private Provider<NavigationManager> navigationManagerProvider;
  private Provider<NetworkClient> networkClientProvider;
  private MembersInjector<NewToVoyagerIntroActivity> newToVoyagerIntroActivityMembersInjector;
  private MembersInjector<NewToVoyagerIntroFragment> newToVoyagerIntroFragmentMembersInjector;
  private Provider<NewToVoyagerTransactionalLaunchManager> newToVoyagerTransactionalLaunchManagerProvider;
  private Provider<CheckForNewUpdatesRunnable> newUpdatesCheckerProvider;
  private Provider<NotificationDisplayUtils> notificationDisplayUtilsProvider;
  private Provider<NotificationUtils> notificationUtilsProvider;
  private Provider<NotificationsDataProvider> notificationsDataProvider;
  private MembersInjector<NotificationsFragment> notificationsFragmentMembersInjector;
  private Provider<OAuthNetworkHelper> oAuthNetworkHelperProvider;
  private MembersInjector<OnboardingAbiSplashFragment> onboardingAbiSplashFragmentMembersInjector;
  private MembersInjector<OnboardingActivity> onboardingActivityMembersInjector;
  private Provider<OnboardingDataProvider> onboardingDataProvider;
  private MembersInjector<OnboardingLegoWidgetSwitch> onboardingLegoWidgetSwitchMembersInjector;
  private Provider<OnboardingLegoWidgetSwitch> onboardingLegoWidgetSwitchProvider;
  private MembersInjector<OnboardingListFragment<GoalType, WelcomeMatItemViewModel>> onboardingListFragmentMembersInjector;
  private MembersInjector<OnboardingListFragment<PeopleYouMayKnow, PymkItemViewModel>> onboardingListFragmentMembersInjector1;
  private MembersInjector<OnboardingProfileEditFragment> onboardingProfileEditFragmentMembersInjector;
  private MembersInjector<PageFragment> pageFragmentMembersInjector;
  private MembersInjector<PagedListFragment<FollowableEntity, CollectionMetadata, ProfileViewGroupsCardEntryViewModel>> pagedListFragmentMembersInjector;
  private MembersInjector<ParticipantDetailsFragment> participantDetailsFragmentMembersInjector;
  private Provider<PasswordVisibilityPresenter> passwordVisibilityPresenterProvider;
  private Provider<PaymentService> paymentServiceProvider;
  private MembersInjector<PendingEndorsedSkillsCardFragment> pendingEndorsedSkillsCardFragmentMembersInjector;
  private Provider<PendingEndorsedSkillsDataProvider> pendingEndorsedSkillsDataProvider;
  private MembersInjector<PendingEndorsementActivity> pendingEndorsementActivityMembersInjector;
  private Provider<PendingEndorsementsEndorserDataProvider> pendingEndorsementsEndorserDataProvider;
  private MembersInjector<PendingInvitationListFragment> pendingInvitationListFragmentMembersInjector;
  private Provider<PendingInvitationDataProvider> pendingInvitationsDataProvider;
  private Provider<Tracker> perfTrackerProvider;
  private MembersInjector<PhoneCollectionFragment> phoneCollectionFragmentMembersInjector;
  private MembersInjector<PhoneConfirmationFragment> phoneConfirmationFragmentMembersInjector;
  private Provider<PhoneOnlyUserDialogManager> phoneOnlyUserDialogManagerProvider;
  private MembersInjector<PhotoCropFragment> photoCropFragmentMembersInjector;
  private MembersInjector<PhotoFragment> photoFragmentMembersInjector;
  private Provider<PhotoUtils> photoUtilsProvider;
  private MembersInjector<PinVerificationFragment> pinVerificationFragmentMembersInjector;
  private Provider<PlaceholderImageCache> placeholderImageCacheProvider;
  private MembersInjector<PositionFragment> positionFragmentMembersInjector;
  private Provider<PreAuthLixManager> preAuthLixManagerProvider;
  private MembersInjector<PreRegBaseFragment<PreRegIntroFragmentViewHolder, PreRegIntroFragmentViewModel>> preRegBaseFragmentMembersInjector;
  private MembersInjector<PreRegFragment> preRegFragmentMembersInjector;
  private MembersInjector<PreRegIntroFragment> preRegIntroFragmentMembersInjector;
  private MembersInjector<PreRegPropFragment<PreRegIntroFragmentViewHolder, PreRegIntroFragmentViewModel>> preRegPropFragmentMembersInjector;
  private Provider<PrefillManager> prefillManagerProvider;
  private MembersInjector<PremiumActivity> premiumActivityMembersInjector;
  private MembersInjector<PremiumChooserFragment> premiumChooserFragmentMembersInjector;
  private MembersInjector<PremiumChooserPageFragment> premiumChooserPageFragmentMembersInjector;
  private Provider<PremiumDataProvider> premiumDataProvider;
  private MembersInjector<PremiumOnboardingCardFragment> premiumOnboardingCardFragmentMembersInjector;
  private MembersInjector<ProfileAccomplishmentsFragment> profileAccomplishmentsFragmentMembersInjector;
  private MembersInjector<ProfileActionHandlerFragment> profileActionHandlerFragmentMembersInjector;
  private Provider<ProfileActivityFeedDataProvider> profileActivityFeedDataProvider;
  private MembersInjector<ProfileBackgroundFragment> profileBackgroundFragmentMembersInjector;
  private MembersInjector<ProfileBaseFragment> profileBaseFragmentMembersInjector;
  private MembersInjector<ProfileBasicInfoEditFragment> profileBasicInfoEditFragmentMembersInjector;
  private MembersInjector<ProfileCertificationEditFragment> profileCertificationEditFragmentMembersInjector;
  private MembersInjector<ProfileContactInfoEditFragment> profileContactInfoEditFragmentMembersInjector;
  private MembersInjector<ProfileCourseEditFragment> profileCourseEditFragmentMembersInjector;
  private Provider<ProfileDataProvider> profileDataProvider;
  private MembersInjector<ProfileEditBaseFragment> profileEditBaseFragmentMembersInjector;
  private MembersInjector<ProfileEditPhotoCropFragment> profileEditPhotoCropFragmentMembersInjector;
  private MembersInjector<ProfileEditTreasuryBaseFragment> profileEditTreasuryBaseFragmentMembersInjector;
  private MembersInjector<ProfileEducationEditFragment> profileEducationEditFragmentMembersInjector;
  private MembersInjector<ProfileEducationEditFragmentV2> profileEducationEditFragmentV2MembersInjector;
  private MembersInjector<ProfileEndorsementsEditFragment> profileEndorsementsEditFragmentMembersInjector;
  private MembersInjector<ProfileFeedFragment> profileFeedFragmentMembersInjector;
  private MembersInjector<ProfileGroupsFragment> profileGroupsFragmentMembersInjector;
  private MembersInjector<ProfileHonorEditFragment> profileHonorEditFragmentMembersInjector;
  private MembersInjector<ProfileImageViewerFragment> profileImageViewerFragmentMembersInjector;
  private MembersInjector<ProfileNewSectionsFragment> profileNewSectionsFragmentMembersInjector;
  private MembersInjector<ProfilePatentEditFragment> profilePatentEditFragmentMembersInjector;
  private Provider<ProfilePendingConnectionRequestManager> profilePendingConnectionRequestManagerProvider;
  private MembersInjector<ProfilePhotoViewFragment> profilePhotoViewFragmentMembersInjector;
  private MembersInjector<ProfilePositionEditFragment> profilePositionEditFragmentMembersInjector;
  private MembersInjector<ProfilePositionEditFragmentV2> profilePositionEditFragmentV2MembersInjector;
  private MembersInjector<ProfileProjectEditFragment> profileProjectEditFragmentMembersInjector;
  private MembersInjector<ProfileProjectMemberEditFragment> profileProjectMemberEditFragmentMembersInjector;
  private MembersInjector<ProfilePublicationEditFragment> profilePublicationEditFragmentMembersInjector;
  private Provider<ProfileSharesFeedDataProvider> profileSharesFeedDataProvider;
  private MembersInjector<ProfileSkillsEditFragment> profileSkillsEditFragmentMembersInjector;
  private MembersInjector<ProfileSkillsEditFragmentV2> profileSkillsEditFragmentV2MembersInjector;
  private MembersInjector<ProfileSummaryFragment> profileSummaryFragmentMembersInjector;
  private MembersInjector<ProfileTreasuryEditFragment> profileTreasuryEditFragmentMembersInjector;
  private Provider<ProfileUtil> profileUtilProvider;
  private MembersInjector<ProfileViewActivity> profileViewActivityMembersInjector;
  private MembersInjector<ProfileViewFragment> profileViewFragmentMembersInjector;
  private MembersInjector<ProfileVolunteeringExperienceEditFragment> profileVolunteeringExperienceEditFragmentMembersInjector;
  private Provider<ProgressBarUtil> progressBarUtilProvider;
  private Provider<DeeplinkHelper> provideDeeplinkHelperProvider;
  private Provider<Fragment> provideFragmentProvider;
  private Provider<PymkDataProvider> pymkDataProvider;
  private MembersInjector<PymkFragment> pymkFragmentMembersInjector;
  private Provider<RateTheApp> rateTheAppProvider;
  private Provider<RealTimeManager> realTimeManagerProvider;
  private MembersInjector<RebuildMyFeedActivity> rebuildMyFeedActivityMembersInjector;
  private Provider<RebuildMyFeedDataProvider> rebuildMyFeedDataProvider;
  private MembersInjector<ReconnectActivity> reconnectActivityMembersInjector;
  private MembersInjector<ReconnectFragment> reconnectFragmentMembersInjector;
  private Provider<Optional<RefWatcher>> refWatcherProvider;
  private Provider<RelationshipsDataProvider> relationshipsDataProvider;
  private MembersInjector<RelationshipsFragment> relationshipsFragmentMembersInjector;
  private MembersInjector<RelationshipsSecondaryActivity> relationshipsSecondaryActivityMembersInjector;
  private MembersInjector<RelationshipsSecondaryBaseFragment> relationshipsSecondaryBaseFragmentMembersInjector;
  private Provider<ReportEntityInvokerHelper> reportEntityInvokerHelperProvider;
  private MembersInjector<ResourceListFragment<Industry, TypeaheadSmallNoIconViewModel>> resourceListFragmentMembersInjector;
  private MembersInjector<SSOFragment> sSOFragmentMembersInjector;
  private MembersInjector<SameNameDirectoryActivity> sameNameDirectoryActivityMembersInjector;
  private Provider<SameNameDirectoryDataProvider> sameNameDirectoryDataProvider;
  private MembersInjector<SchoolActivity> schoolActivityMembersInjector;
  private Provider<SchoolDataProvider> schoolDataProvider;
  private MembersInjector<SearchActivity> searchActivityMembersInjector;
  private Provider<SearchDataProvider> searchDataProvider;
  private Provider<SearchEngineTransformer> searchEngineTransformerProvider;
  private MembersInjector<SearchFacetFragment> searchFacetFragmentMembersInjector;
  private Provider<SearchFacetTransformer> searchFacetTransformerProvider;
  private MembersInjector<SearchFragmentBarPresenter> searchFragmentBarPresenterMembersInjector;
  private Provider<SearchFragmentBarPresenter> searchFragmentBarPresenterProvider;
  private MembersInjector<SearchFragmentItemPresenter> searchFragmentItemPresenterMembersInjector;
  private Provider<SearchFragmentItemPresenter> searchFragmentItemPresenterProvider;
  private MembersInjector<SearchFragment> searchFragmentMembersInjector;
  private MembersInjector<SearchStarterFragment> searchStarterFragmentMembersInjector;
  private Provider<SearchStarterItemPresenter> searchStarterItemPresenterProvider;
  private Provider<SearchUtils> searchUtilsProvider;
  private Provider<SecondaryResultsTransformer> secondaryResultsTransformerProvider;
  private MembersInjector<SendInviteActivity> sendInviteActivityMembersInjector;
  private MembersInjector<SettingsFragment> settingsFragmentMembersInjector;
  private Provider<FeedSharePublisher> sharePublisherProvider;
  private MembersInjector<SharedPreferenceDebugFragment> sharedPreferenceDebugFragmentMembersInjector;
  private MembersInjector<SingleFragmentLegoWidget> singleFragmentLegoWidgetMembersInjector;
  private Provider<SmartLockManager> smartLockManagerProvider;
  private MembersInjector<SmsReminderConsentFragment> smsReminderConsentFragmentMembersInjector;
  private Provider<SnackbarUtil> snackbarUtilProvider;
  private MembersInjector<SocialReaderFragment> socialReaderFragmentMembersInjector;
  private Provider<SponsoredUpdateTracker> sponsoredUpdateTrackerProvider;
  private Provider<SSOManager> ssoManagerProvider;
  private MembersInjector<StickerStoreFragment> stickerStoreFragmentMembersInjector;
  private MembersInjector<SubscriptionChooserFragment> subscriptionChooserFragmentMembersInjector;
  private MembersInjector<SubscriptionChooserPageFragment> subscriptionChooserPageFragmentMembersInjector;
  private Provider<TakeoverManager> takeoverManagerProvider;
  private Provider<TermsOfServiceInterface> termsOfServiceProvider;
  private Provider<ThirdPartySdkManager> thirdPartySdkManagerProvider;
  private Provider<TimeWrapper> timeWrapperProvider;
  private Provider<TitanDataMigrationManager> titanDataMigrationManagerProvider;
  private MembersInjector<TrackableFragment> trackableFragmentMembersInjector;
  private Provider<Tracker> trackerProvider;
  private Provider<LiTrackingNetworkStack> trackingNetworkStackProvider;
  private Provider<TransformerExecutor> transformerExecutorProvider;
  private MembersInjector<TypeaheadFragment> typeaheadFragmentMembersInjector;
  private MembersInjector<TypeaheadItemPresenter> typeaheadItemPresenterMembersInjector;
  private Provider<TypeaheadItemPresenter> typeaheadItemPresenterProvider;
  private MembersInjector<TypeaheadTransformer> typeaheadTransformerMembersInjector;
  private Provider<TypeaheadTransformer> typeaheadTransformerProvider;
  private Provider<UnfollowEducateDataProvider> unfollowEducateDataProvider;
  private Provider<UpdateChangeCoordinator> updateChangeCoordinatorProvider;
  private MembersInjector<VideoViewerFragment> videoViewerFragmentMembersInjector;
  private MembersInjector<ViewPagerFragment> viewPagerFragmentMembersInjector;
  private Provider<ViewPagerManager> viewPagerManagerProvider;
  private Provider<ViewPagerObserver> viewPagerObserverProvider;
  private Provider<ViewportTrackingConfiguration> viewportConfigProvider;
  private Provider<ViewPortManager> viewportManagerProvider;
  private Provider<WebRouter> webRouterProvider;
  private Provider<WebRouterUtil> webRouterUtilProvider;
  private Provider<WebViewLoadProxy> webViewLoadProxyProvider;
  private MembersInjector<WebViewerBaseFragment> webViewerBaseFragmentMembersInjector;
  private MembersInjector<WelcomeMatFragment> welcomeMatFragmentMembersInjector;
  private Provider<WvmpDataProvider> wvmpDataProvider;
  private MembersInjector<WvmpFragment> wvmpFragmentMembersInjector;
  
  static
  {
    if (!DaggerFragmentComponent.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private DaggerFragmentComponent(Builder paramBuilder)
  {
    assert (paramBuilder != null);
    appContextProvider = new DaggerFragmentComponent.1(this, paramBuilder);
    appProvider = new DaggerFragmentComponent.2(this, paramBuilder);
    authProvider = new DaggerFragmentComponent.3(this, paramBuilder);
    launchUtilsProvider = new DaggerFragmentComponent.4(this, paramBuilder);
    authHttpStackProvider = new DaggerFragmentComponent.5(this, paramBuilder);
    trackingNetworkStackProvider = new DaggerFragmentComponent.6(this, paramBuilder);
    navigationManagerProvider = new DaggerFragmentComponent.7(this, paramBuilder);
    mainHandlerProvider = new DaggerFragmentComponent.8(this, paramBuilder);
    executorServiceProvider = new DaggerFragmentComponent.9(this, paramBuilder);
    placeholderImageCacheProvider = new DaggerFragmentComponent.10(this, paramBuilder);
    imageLoaderCacheProvider = new DaggerFragmentComponent.11(this, paramBuilder);
    imageLoaderProvider = new DaggerFragmentComponent.12(this, paramBuilder);
    mediaCenterProvider = new DaggerFragmentComponent.13(this, paramBuilder);
    dataManagerProvider = new DaggerFragmentComponent.14(this, paramBuilder);
    flagshipCacheManagerProvider = new DaggerFragmentComponent.15(this, paramBuilder);
    flagshipAssetManagerProvider = new DaggerFragmentComponent.16(this, paramBuilder);
    assetLoaderNetworkClientProvider = new DaggerFragmentComponent.17(this, paramBuilder);
    connectionStoreProvider = new DaggerFragmentComponent.18(this, paramBuilder);
    consistencyManagerProvider = new DaggerFragmentComponent.19(this, paramBuilder);
    mediaUploaderProvider = new DaggerFragmentComponent.20(this, paramBuilder);
    flagshipSharedPreferencesProvider = new DaggerFragmentComponent.21(this, paramBuilder);
    networkClientProvider = new DaggerFragmentComponent.22(this, paramBuilder);
    cookieUtilProvider = new DaggerFragmentComponent.23(this, paramBuilder);
    i18NManagerProvider = new DaggerFragmentComponent.24(this, paramBuilder);
    configurationManagerProvider = new DaggerFragmentComponent.25(this, paramBuilder);
    intentRegistryProvider = new DaggerFragmentComponent.26(this, paramBuilder);
    viewPagerObserverProvider = new DaggerFragmentComponent.27(this, paramBuilder);
    realTimeManagerProvider = new DaggerFragmentComponent.28(this, paramBuilder);
    provideDeeplinkHelperProvider = new DaggerFragmentComponent.29(this, paramBuilder);
    fragmentRegistryProvider = new DaggerFragmentComponent.30(this, paramBuilder);
    imageQualityManagerProvider = new DaggerFragmentComponent.31(this, paramBuilder);
    profileUtilProvider = new DaggerFragmentComponent.32(this, paramBuilder);
    memberUtilProvider = new DaggerFragmentComponent.33(this, paramBuilder);
    photoUtilsProvider = new DaggerFragmentComponent.34(this, paramBuilder);
    snackbarUtilProvider = new DaggerFragmentComponent.35(this, paramBuilder);
    cardToastManagerProvider = new DaggerFragmentComponent.36(this, paramBuilder);
    internetConnectionMonitorProvider = new DaggerFragmentComponent.37(this, paramBuilder);
    thirdPartySdkManagerProvider = new DaggerFragmentComponent.38(this, paramBuilder);
    connectionsFetchingManagerProvider = new DaggerFragmentComponent.39(this, paramBuilder);
    abiAutoSyncManagerProvider = new DaggerFragmentComponent.40(this, paramBuilder);
    timeWrapperProvider = new DaggerFragmentComponent.41(this, paramBuilder);
    eventBusProvider = new DaggerFragmentComponent.42(this, paramBuilder);
    commentPublisherProvider = new DaggerFragmentComponent.43(this, paramBuilder);
    sharePublisherProvider = new DaggerFragmentComponent.44(this, paramBuilder);
    groupsSharePublisherProvider = new DaggerFragmentComponent.45(this, paramBuilder);
    followPublisherProvider = new DaggerFragmentComponent.46(this, paramBuilder);
    likePublisherProvider = new DaggerFragmentComponent.47(this, paramBuilder);
    updateChangeCoordinatorProvider = new DaggerFragmentComponent.48(this, paramBuilder);
    sponsoredUpdateTrackerProvider = new DaggerFragmentComponent.49(this, paramBuilder);
    transformerExecutorProvider = new DaggerFragmentComponent.50(this, paramBuilder);
    reportEntityInvokerHelperProvider = new DaggerFragmentComponent.51(this, paramBuilder);
    feedValuesProvider = new DaggerFragmentComponent.52(this, paramBuilder);
    appwidgetValuesProvider = new DaggerFragmentComponent.53(this, paramBuilder);
    newUpdatesCheckerProvider = new DaggerFragmentComponent.54(this, paramBuilder);
    trackerProvider = new DaggerFragmentComponent.55(this, paramBuilder);
    perfTrackerProvider = new DaggerFragmentComponent.56(this, paramBuilder);
    refWatcherProvider = new DaggerFragmentComponent.57(this, paramBuilder);
    delayedExecutionProvider = new DaggerFragmentComponent.58(this, paramBuilder);
    viewportManagerProvider = new DaggerFragmentComponent.59(this, paramBuilder);
    viewPagerManagerProvider = new DaggerFragmentComponent.60(this, paramBuilder);
    viewportConfigProvider = new DaggerFragmentComponent.61(this, paramBuilder);
    crossPromoManagerProvider = new DaggerFragmentComponent.62(this, paramBuilder);
    geoLocatorProvider = new DaggerFragmentComponent.63(this, paramBuilder);
    paymentServiceProvider = new DaggerFragmentComponent.64(this, paramBuilder);
    notificationUtilsProvider = new DaggerFragmentComponent.65(this, paramBuilder);
    notificationDisplayUtilsProvider = new DaggerFragmentComponent.66(this, paramBuilder);
    searchUtilsProvider = new DaggerFragmentComponent.67(this, paramBuilder);
    preAuthLixManagerProvider = new DaggerFragmentComponent.68(this, paramBuilder);
    lixManagerProvider = new DaggerFragmentComponent.69(this, paramBuilder);
    webRouterProvider = new DaggerFragmentComponent.70(this, paramBuilder);
    webViewLoadProxyProvider = new DaggerFragmentComponent.71(this, paramBuilder);
    calendarSyncManagerProvider = new DaggerFragmentComponent.72(this, paramBuilder);
    calendarTaskUtilProvider = new DaggerFragmentComponent.73(this, paramBuilder);
    animationProxyProvider = new DaggerFragmentComponent.74(this, paramBuilder);
    termsOfServiceProvider = new DaggerFragmentComponent.75(this, paramBuilder);
    titanDataMigrationManagerProvider = new DaggerFragmentComponent.76(this, paramBuilder);
    appUpgradeUtilsProvider = new DaggerFragmentComponent.77(this, paramBuilder);
    profilePendingConnectionRequestManagerProvider = new DaggerFragmentComponent.78(this, paramBuilder);
    deviceClassProvider = new DaggerFragmentComponent.79(this, paramBuilder);
    meDedupProxyProvider = new DaggerFragmentComponent.80(this, paramBuilder);
    oAuthNetworkHelperProvider = new DaggerFragmentComponent.81(this, paramBuilder);
    commTrackerProvider = new DaggerFragmentComponent.82(this, paramBuilder);
    rateTheAppProvider = new DaggerFragmentComponent.83(this, paramBuilder);
    homeCachedLixProvider = new DaggerFragmentComponent.84(this, paramBuilder);
    longClickUtilProvider = new DaggerFragmentComponent.85(this, paramBuilder);
    messengerLongClickUtilProvider = new DaggerFragmentComponent.86(this, paramBuilder);
    badgerProvider = new DaggerFragmentComponent.87(this, paramBuilder);
    webRouterUtilProvider = new DaggerFragmentComponent.88(this, paramBuilder);
    abiContactsReaderProvider = new DaggerFragmentComponent.89(this, paramBuilder);
    abiCacheUtilsProvider = new DaggerFragmentComponent.90(this, paramBuilder);
    deepLinkManagerProvider = new DaggerFragmentComponent.91(this, paramBuilder);
    progressBarUtilProvider = new DaggerFragmentComponent.92(this, paramBuilder);
    activityProvider = new DaggerFragmentComponent.93(this, paramBuilder);
    contextProvider = new DaggerFragmentComponent.94(this, paramBuilder);
    legoManagerProvider = new DaggerFragmentComponent.95(this, paramBuilder);
    smartLockManagerProvider = new DaggerFragmentComponent.96(this, paramBuilder);
    ssoManagerProvider = new DaggerFragmentComponent.97(this, paramBuilder);
    googleIdTokenManagerProvider = new DaggerFragmentComponent.98(this, paramBuilder);
    loginUtilsProvider = new DaggerFragmentComponent.99(this, paramBuilder);
    emailManagementControllerProvider = new DaggerFragmentComponent.100(this, paramBuilder);
    deepLinkEmailManagementControllerProvider = new DaggerFragmentComponent.101(this, paramBuilder);
    contentResolverProvider = new DaggerFragmentComponent.102(this, paramBuilder);
    fragmentManagerProvider = new DaggerFragmentComponent.103(this, paramBuilder);
    takeoverManagerProvider = TakeoverManager_Factory.create(eventBusProvider, dataManagerProvider, trackerProvider, flagshipSharedPreferencesProvider, memberUtilProvider, abiCacheUtilsProvider);
    newToVoyagerTransactionalLaunchManagerProvider = NewToVoyagerTransactionalLaunchManager_Factory.create(eventBusProvider, dataManagerProvider);
    baseActivityMembersInjector = BaseActivity_MembersInjector.create(MembersInjectors.NoOpMembersInjector.INSTANCE, intentRegistryProvider, fragmentRegistryProvider, i18NManagerProvider, eventBusProvider, authProvider, trackerProvider, animationProxyProvider, appUpgradeUtilsProvider, takeoverManagerProvider, newToVoyagerTransactionalLaunchManagerProvider);
    launchActivityMembersInjector = LaunchActivity_MembersInjector.create(baseActivityMembersInjector, authProvider, launchUtilsProvider, takeoverManagerProvider, flagshipSharedPreferencesProvider, dataManagerProvider, eventBusProvider);
    loginManagerProvider = LoginManager_Factory.create(authProvider, loginUtilsProvider, activityProvider, takeoverManagerProvider, networkClientProvider);
    loginActivityMembersInjector = LoginActivity_MembersInjector.create(baseActivityMembersInjector, authProvider, loginUtilsProvider, loginManagerProvider, preAuthLixManagerProvider, launchUtilsProvider, fragmentRegistryProvider, fragmentManagerProvider, smartLockManagerProvider, googleIdTokenManagerProvider, ssoManagerProvider, notificationUtilsProvider, flagshipSharedPreferencesProvider, takeoverManagerProvider, dataManagerProvider, eventBusProvider, snackbarUtilProvider, trackerProvider);
    newToVoyagerIntroActivityMembersInjector = NewToVoyagerIntroActivity_MembersInjector.create(baseActivityMembersInjector, fragmentManagerProvider);
    onboardingLegoWidgetSwitchMembersInjector = OnboardingLegoWidgetSwitch_MembersInjector.create(MembersInjectors.NoOpMembersInjector.INSTANCE, fragmentRegistryProvider, flagshipSharedPreferencesProvider);
    onboardingLegoWidgetSwitchProvider = OnboardingLegoWidgetSwitch_Factory.create(onboardingLegoWidgetSwitchMembersInjector, contextProvider, intentRegistryProvider);
    onboardingDataProvider = new DaggerFragmentComponent.104(this, paramBuilder);
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
    activityComponentProvider = InstanceFactory.create(activityComponent);
    searchFacetTransformerProvider = SearchFacetTransformer_Factory.create(activityComponentProvider);
    searchActivityMembersInjector = SearchActivity_MembersInjector.create(baseActivityMembersInjector, searchFacetTransformerProvider, lixManagerProvider);
    rebuildMyFeedActivityMembersInjector = baseActivityMembersInjector;
    sameNameDirectoryActivityMembersInjector = baseActivityMembersInjector;
    sendInviteActivityMembersInjector = SendInviteActivity_MembersInjector.create(baseActivityMembersInjector, authProvider);
    articleActivityMembersInjector = baseActivityMembersInjector;
    reconnectActivityMembersInjector = baseMessengerActivityMembersInjector;
    connectionsV2DataProvider = new DaggerFragmentComponent.105(this, paramBuilder);
    likesDataProvider = new DaggerFragmentComponent.106(this, paramBuilder);
    feedUpdatesDataProvider = new DaggerFragmentComponent.107(this, paramBuilder);
    highlightedUpdatesDataProvider = new DaggerFragmentComponent.108(this, paramBuilder);
    channelUpdatesDataProvider = new DaggerFragmentComponent.109(this, paramBuilder);
    profileSharesFeedDataProvider = new DaggerFragmentComponent.110(this, paramBuilder);
    profileActivityFeedDataProvider = new DaggerFragmentComponent.111(this, paramBuilder);
    premiumDataProvider = new DaggerFragmentComponent.112(this, paramBuilder);
    feedUpdateDetailProvider = new DaggerFragmentComponent.113(this, paramBuilder);
    commentDetailDataProvider = new DaggerFragmentComponent.114(this, paramBuilder);
    companyDataProvider = new DaggerFragmentComponent.115(this, paramBuilder);
    jobDataProvider = new DaggerFragmentComponent.116(this, paramBuilder);
    schoolDataProvider = new DaggerFragmentComponent.117(this, paramBuilder);
    profileDataProvider = new DaggerFragmentComponent.118(this, paramBuilder);
    notificationsDataProvider = new DaggerFragmentComponent.119(this, paramBuilder);
    meWvmpDataProvider = new DaggerFragmentComponent.120(this, paramBuilder);
    wvmpDataProvider = new DaggerFragmentComponent.121(this, paramBuilder);
    meCardDataProvider = new DaggerFragmentComponent.122(this, paramBuilder);
    contentAnalyticsDataProvider = new DaggerFragmentComponent.123(this, paramBuilder);
    searchDataProvider = new DaggerFragmentComponent.124(this, paramBuilder);
    homeFragmentDataProvider = new DaggerFragmentComponent.125(this, paramBuilder);
    relationshipsDataProvider = new DaggerFragmentComponent.126(this, paramBuilder);
    invitationsDataProvider = new DaggerFragmentComponent.127(this, paramBuilder);
    pymkDataProvider = new DaggerFragmentComponent.128(this, paramBuilder);
    connectFlowDataProvider = new DaggerFragmentComponent.129(this, paramBuilder);
    groupDataProvider = new DaggerFragmentComponent.130(this, paramBuilder);
    guidedEditDataProvider = new DaggerFragmentComponent.131(this, paramBuilder);
    pendingEndorsedSkillsDataProvider = new DaggerFragmentComponent.132(this, paramBuilder);
    pendingEndorsementsEndorserDataProvider = new DaggerFragmentComponent.133(this, paramBuilder);
    abiDataProvider = new DaggerFragmentComponent.134(this, paramBuilder);
    legoTrackingDataProvider = new DaggerFragmentComponent.135(this, paramBuilder);
    heathrowFlowDataProvider = new DaggerFragmentComponent.136(this, paramBuilder);
    jymbiiDataProvider = new DaggerFragmentComponent.137(this, paramBuilder);
    rebuildMyFeedDataProvider = new DaggerFragmentComponent.138(this, paramBuilder);
    unfollowEducateDataProvider = new DaggerFragmentComponent.139(this, paramBuilder);
    sameNameDirectoryDataProvider = new DaggerFragmentComponent.140(this, paramBuilder);
    articleDataProvider = new DaggerFragmentComponent.141(this, paramBuilder);
    meetingDetailsDataProvider = new DaggerFragmentComponent.142(this, paramBuilder);
    pendingInvitationsDataProvider = new DaggerFragmentComponent.143(this, paramBuilder);
    provideFragmentProvider = ScopedProvider.create(FragmentModule_ProvideFragmentFactory.create(fragmentModule));
    baseFragmentMembersInjector = BaseFragment_MembersInjector.create(MembersInjectors.NoOpMembersInjector.INSTANCE, i18NManagerProvider);
    trackableFragmentMembersInjector = TrackableFragment_MembersInjector.create(baseFragmentMembersInjector, trackerProvider);
    pageFragmentMembersInjector = trackableFragmentMembersInjector;
    feedTrackableFragmentMembersInjector = pageFragmentMembersInjector;
    baseFeedFragmentMembersInjector = BaseFeedFragment_MembersInjector.create(feedTrackableFragmentMembersInjector, viewportManagerProvider);
    feedFragmentMembersInjector = FeedFragment_MembersInjector.create(baseFeedFragmentMembersInjector, eventBusProvider, delayedExecutionProvider, consistencyManagerProvider, dataManagerProvider, sharePublisherProvider, followPublisherProvider, newUpdatesCheckerProvider, rateTheAppProvider);
    fragmentComponentProvider = InstanceFactory.create(this);
    typeaheadTransformerMembersInjector = TypeaheadTransformer_MembersInjector.create(intentRegistryProvider);
    typeaheadTransformerProvider = TypeaheadTransformer_Factory.create(typeaheadTransformerMembersInjector, activityComponentProvider);
    mentionsPresenterMembersInjector = MentionsPresenter_MembersInjector.create(dataManagerProvider, delayedExecutionProvider, typeaheadTransformerProvider);
    mentionsPresenterProvider = MentionsPresenter_Factory.create(mentionsPresenterMembersInjector, fragmentComponentProvider);
    feedUpdateDetailFragmentMembersInjector = FeedUpdateDetailFragment_MembersInjector.create(pageFragmentMembersInjector, activityComponentProvider, fragmentComponentProvider, mentionsPresenterProvider, delayedExecutionProvider, viewportManagerProvider);
    viewPagerFragmentMembersInjector = trackableFragmentMembersInjector;
    baseShareComposeFragmentMembersInjector = BaseShareComposeFragment_MembersInjector.create(viewPagerFragmentMembersInjector, mentionsPresenterProvider, sharePublisherProvider, dataManagerProvider);
    mentionPickerFragmentMembersInjector = MentionPickerFragment_MembersInjector.create(pageFragmentMembersInjector, mentionsPresenterProvider);
    imageViewerFragmentMembersInjector = ImageViewerFragment_MembersInjector.create(pageFragmentMembersInjector, mediaCenterProvider, activityComponentProvider, fragmentComponentProvider);
    videoViewerFragmentMembersInjector = VideoViewerFragment_MembersInjector.create(pageFragmentMembersInjector, mediaCenterProvider, activityComponentProvider);
    channelFragmentMembersInjector = ChannelFragment_MembersInjector.create(feedTrackableFragmentMembersInjector, eventBusProvider, followPublisherProvider, dataManagerProvider, viewportManagerProvider, consistencyManagerProvider, i18NManagerProvider);
    aggregateFragmentMembersInjector = AggregateFragment_MembersInjector.create(feedTrackableFragmentMembersInjector, eventBusProvider, activityComponentProvider, fragmentComponentProvider, consistencyManagerProvider, dataManagerProvider, mediaCenterProvider, viewportManagerProvider);
    baseFeedActorListFragmentMembersInjector = BaseFeedActorListFragment_MembersInjector.create(pageFragmentMembersInjector, eventBusProvider, viewportManagerProvider);
    commentDetailFragmentMembersInjector = CommentDetailFragment_MembersInjector.create(pageFragmentMembersInjector, activityComponentProvider, fragmentComponentProvider, mentionsPresenterProvider, KeyboardUtil_Factory.create(), viewportManagerProvider);
    searchStarterItemPresenterProvider = SearchStarterItemPresenter_Factory.create(typeaheadTransformerProvider, activityComponentProvider, fragmentComponentProvider);
    searchStarterFragmentMembersInjector = SearchStarterFragment_MembersInjector.create(viewPagerFragmentMembersInjector, intentRegistryProvider, activityComponentProvider, searchStarterItemPresenterProvider, searchUtilsProvider, eventBusProvider);
    typeaheadItemPresenterMembersInjector = TypeaheadItemPresenter_MembersInjector.create(KeyboardUtil_Factory.create(), trackerProvider, delayedExecutionProvider, typeaheadTransformerProvider);
    typeaheadItemPresenterProvider = TypeaheadItemPresenter_Factory.create(typeaheadItemPresenterMembersInjector, mediaCenterProvider, fragmentComponentProvider);
    typeaheadFragmentMembersInjector = TypeaheadFragment_MembersInjector.create(pageFragmentMembersInjector, TypeAheadSearchBarPresenter_Factory.create(), typeaheadItemPresenterProvider, activityComponentProvider, eventBusProvider, KeyboardUtil_Factory.create(), searchUtilsProvider, searchFacetTransformerProvider, lixManagerProvider);
    searchFragmentBarPresenterMembersInjector = SearchFragmentBarPresenter_MembersInjector.create(activityComponentProvider, KeyboardUtil_Factory.create(), searchUtilsProvider);
    searchFragmentBarPresenterProvider = SearchFragmentBarPresenter_Factory.create(searchFragmentBarPresenterMembersInjector);
    searchEngineTransformerProvider = SearchEngineTransformer_Factory.create(activityComponentProvider);
    secondaryResultsTransformerProvider = SecondaryResultsTransformer_Factory.create(activityComponentProvider);
    searchFragmentItemPresenterMembersInjector = SearchFragmentItemPresenter_MembersInjector.create(fragmentComponentProvider, searchEngineTransformerProvider, secondaryResultsTransformerProvider);
    searchFragmentItemPresenterProvider = SearchFragmentItemPresenter_Factory.create(searchFragmentItemPresenterMembersInjector, activityComponentProvider);
    searchFragmentMembersInjector = SearchFragment_MembersInjector.create(pageFragmentMembersInjector, searchFragmentBarPresenterProvider, searchFragmentItemPresenterProvider, activityComponentProvider, searchUtilsProvider, eventBusProvider, i18NManagerProvider, snackbarUtilProvider, geoLocatorProvider, lixManagerProvider);
    searchFacetFragmentMembersInjector = SearchFacetFragment_MembersInjector.create(pageFragmentMembersInjector, activityComponentProvider, eventBusProvider, searchFacetTransformerProvider, delayedExecutionProvider);
    homeFragmentMembersInjector = HomeFragment_MembersInjector.create(pageFragmentMembersInjector, eventBusProvider, homeCachedLixProvider);
    cookieDebugFragmentMembersInjector = CookieDebugFragment_MembersInjector.create(pageFragmentMembersInjector, cookieUtilProvider);
    sharedPreferenceDebugFragmentMembersInjector = pageFragmentMembersInjector;
    webViewerBaseFragmentMembersInjector = WebViewerBaseFragment_MembersInjector.create(pageFragmentMembersInjector, fragmentComponentProvider);
    photoCropFragmentMembersInjector = PhotoCropFragment_MembersInjector.create(pageFragmentMembersInjector, photoUtilsProvider, mediaUploaderProvider, mediaCenterProvider, eventBusProvider);
    cookieEditDialogFragmentMembersInjector = CookieEditDialogFragment_MembersInjector.create(MembersInjectors.NoOpMembersInjector.INSTANCE, flagshipSharedPreferencesProvider);
    preRegFragmentMembersInjector = PreRegFragment_MembersInjector.create(pageFragmentMembersInjector, loginManagerProvider, trackerProvider);
    preRegBaseFragmentMembersInjector = viewPagerFragmentMembersInjector;
    preRegPropFragmentMembersInjector = preRegBaseFragmentMembersInjector;
    preRegIntroFragmentMembersInjector = PreRegIntroFragment_MembersInjector.create(preRegPropFragmentMembersInjector, eventBusProvider, i18NManagerProvider, flagshipSharedPreferencesProvider);
    newToVoyagerIntroFragmentMembersInjector = NewToVoyagerIntroFragment_MembersInjector.create(pageFragmentMembersInjector, legoTrackingDataProvider);
    sSOFragmentMembersInjector = pageFragmentMembersInjector;
    passwordVisibilityPresenterProvider = PasswordVisibilityPresenter_Factory.create(i18NManagerProvider);
    inputValidationPresenterProvider = InputValidationPresenter_Factory.create(i18NManagerProvider);
    inputValidatorProvider = InputValidator_Factory.create(StringUtils_Factory.create(), inputValidationPresenterProvider);
    prefillManagerProvider = PrefillManager_Factory.create(contextProvider);
    fastrackManagerMembersInjector = FastrackManager_MembersInjector.create(prefillManagerProvider);
    fastrackManagerProvider = FastrackManager_Factory.create(fastrackManagerMembersInjector, authProvider);
    loginFragmentMembersInjector = LoginFragment_MembersInjector.create(pageFragmentMembersInjector, memberUtilProvider, flagshipSharedPreferencesProvider, passwordVisibilityPresenterProvider, inputValidatorProvider, loginManagerProvider, fastrackManagerProvider, preAuthLixManagerProvider, trackerProvider, snackbarUtilProvider, smartLockManagerProvider, googleIdTokenManagerProvider, prefillManagerProvider);
    joinManagerProvider = JoinManager_Factory.create(authProvider, loginUtilsProvider, activityProvider);
    joinFragmentMembersInjector = JoinFragment_MembersInjector.create(pageFragmentMembersInjector, trackerProvider, i18NManagerProvider, StringUtils_Factory.create(), passwordVisibilityPresenterProvider, inputValidatorProvider, KeyboardUtil_Factory.create(), joinManagerProvider, preAuthLixManagerProvider, snackbarUtilProvider, loginManagerProvider, smartLockManagerProvider, prefillManagerProvider, dataManagerProvider, flagshipSharedPreferencesProvider);
    countrySelectorManagerProvider = CountrySelectorManager_Factory.create(activityProvider);
    phoneConfirmationFragmentMembersInjector = PhoneConfirmationFragment_MembersInjector.create(pageFragmentMembersInjector, authProvider, countrySelectorManagerProvider, snackbarUtilProvider);
    pinVerificationFragmentMembersInjector = PinVerificationFragment_MembersInjector.create(pageFragmentMembersInjector, authProvider, joinManagerProvider, snackbarUtilProvider);
    legoWidgetMembersInjector = LegoWidget_MembersInjector.create(baseFragmentMembersInjector, fragmentRegistryProvider);
    singleFragmentLegoWidgetMembersInjector = legoWidgetMembersInjector;
    multiFragmentLegoWidgetMembersInjector = legoWidgetMembersInjector;
    legoFragmentMembersInjector = pageFragmentMembersInjector;
    onboardingProfileEditFragmentMembersInjector = OnboardingProfileEditFragment_MembersInjector.create(legoFragmentMembersInjector, snackbarUtilProvider, KeyboardUtil_Factory.create(), lixManagerProvider);
    positionFragmentMembersInjector = PositionFragment_MembersInjector.create(onboardingProfileEditFragmentMembersInjector, fragmentRegistryProvider, intentRegistryProvider, profileUtilProvider, eventBusProvider, memberUtilProvider, dataManagerProvider, snackbarUtilProvider);
    resourceListFragmentMembersInjector = pageFragmentMembersInjector;
    industryPickerFragmentMembersInjector = resourceListFragmentMembersInjector;
    educationFragmentMembersInjector = EducationFragment_MembersInjector.create(onboardingProfileEditFragmentMembersInjector, intentRegistryProvider, snackbarUtilProvider);
    locationFragmentMembersInjector = LocationFragment_MembersInjector.create(onboardingProfileEditFragmentMembersInjector, i18NManagerProvider, contentResolverProvider, geoLocatorProvider, snackbarUtilProvider);
    locationPickerFragmentMembersInjector = LocationPickerFragment_MembersInjector.create(pageFragmentMembersInjector, KeyboardUtil_Factory.create(), lixManagerProvider, profileUtilProvider);
    photoFragmentMembersInjector = PhotoFragment_MembersInjector.create(onboardingProfileEditFragmentMembersInjector, contextProvider, photoUtilsProvider, profileUtilProvider, fragmentRegistryProvider, mediaCenterProvider, memberUtilProvider, snackbarUtilProvider);
    onboardingListFragmentMembersInjector = OnboardingListFragment_MembersInjector.create(legoFragmentMembersInjector, eventBusProvider, dataManagerProvider);
    welcomeMatFragmentMembersInjector = WelcomeMatFragment_MembersInjector.create(onboardingListFragmentMembersInjector, snackbarUtilProvider);
    onboardingListFragmentMembersInjector1 = OnboardingListFragment_MembersInjector.create(legoFragmentMembersInjector, eventBusProvider, dataManagerProvider);
    pymkFragmentMembersInjector = PymkFragment_MembersInjector.create(onboardingListFragmentMembersInjector1, viewportManagerProvider, snackbarUtilProvider);
    jobseekerPromoFragmentMembersInjector = JobseekerPromoFragment_MembersInjector.create(legoFragmentMembersInjector, mediaCenterProvider);
    abiPrepareFragmentMembersInjector = AbiPrepareFragment_MembersInjector.create(pageFragmentMembersInjector, dataManagerProvider, snackbarUtilProvider);
    abiSplashBaseFragmentMembersInjector = AbiSplashBaseFragment_MembersInjector.create(legoFragmentMembersInjector, fragmentRegistryProvider, fragmentManagerProvider);
    mainAbiSplashFragmentMembersInjector = abiSplashBaseFragmentMembersInjector;
    abiLoadContactsFragmentMembersInjector = AbiLoadContactsFragment_MembersInjector.create(legoFragmentMembersInjector, flagshipSharedPreferencesProvider, snackbarUtilProvider);
    onboardingAbiSplashFragmentMembersInjector = abiSplashBaseFragmentMembersInjector;
    abiLearnMoreFragmentMembersInjector = AbiLearnMoreFragment_MembersInjector.create(pageFragmentMembersInjector, fragmentRegistryProvider, fragmentManagerProvider);
    emailConfirmationLoadingFragmentMembersInjector = EmailConfirmationLoadingFragment_MembersInjector.create(legoFragmentMembersInjector, delayedExecutionProvider, deepLinkEmailManagementControllerProvider, intentRegistryProvider, mediaCenterProvider);
    emailConfirmationFragmentMembersInjector = EmailConfirmationFragment_MembersInjector.create(legoFragmentMembersInjector, flagshipSharedPreferencesProvider, inputValidatorProvider, inputValidationPresenterProvider, delayedExecutionProvider, emailManagementControllerProvider, intentRegistryProvider);
    abiResultFragmentMembersInjector = AbiResultFragment_MembersInjector.create(legoFragmentMembersInjector, eventBusProvider);
    calendarSyncSplashFragmentMembersInjector = CalendarSyncSplashFragment_MembersInjector.create(pageFragmentMembersInjector, fragmentRegistryProvider);
    calendarSyncSettingsFragmentMembersInjector = CalendarSyncSettingsFragment_MembersInjector.create(pageFragmentMembersInjector, flagshipSharedPreferencesProvider, calendarSyncManagerProvider);
    phoneCollectionFragmentMembersInjector = PhoneCollectionFragment_MembersInjector.create(pageFragmentMembersInjector, flagshipSharedPreferencesProvider, intentRegistryProvider, legoTrackingDataProvider);
    boostSplashFragmentMembersInjector = BoostSplashFragment_MembersInjector.create(pageFragmentMembersInjector, memberUtilProvider, flagshipSharedPreferencesProvider, i18NManagerProvider);
    boostErrorFragmentMembersInjector = BoostErrorFragment_MembersInjector.create(pageFragmentMembersInjector, intentRegistryProvider);
    smsReminderConsentFragmentMembersInjector = SmsReminderConsentFragment_MembersInjector.create(pageFragmentMembersInjector, memberUtilProvider, i18NManagerProvider, lixManagerProvider, legoTrackingDataProvider);
    calendarSyncTakeoverFragmentMembersInjector = CalendarSyncTakeoverFragment_MembersInjector.create(pageFragmentMembersInjector, i18NManagerProvider, fragmentRegistryProvider, legoTrackingDataProvider, calendarSyncManagerProvider, snackbarUtilProvider);
    settingsFragmentMembersInjector = pageFragmentMembersInjector;
    notificationsFragmentMembersInjector = NotificationsFragment_MembersInjector.create(viewPagerFragmentMembersInjector, viewportManagerProvider);
    meActorListFragmentMembersInjector = pageFragmentMembersInjector;
    profileBaseFragmentMembersInjector = pageFragmentMembersInjector;
    profileActionHandlerFragmentMembersInjector = profileBaseFragmentMembersInjector;
    profileViewFragmentMembersInjector = ProfileViewFragment_MembersInjector.create(profileActionHandlerFragmentMembersInjector, dataManagerProvider, memberUtilProvider, authProvider, viewportManagerProvider, photoUtilsProvider);
    profileBackgroundFragmentMembersInjector = pageFragmentMembersInjector;
    profileAccomplishmentsFragmentMembersInjector = pageFragmentMembersInjector;
    profileSummaryFragmentMembersInjector = pageFragmentMembersInjector;
    profileEditBaseFragmentMembersInjector = ProfileEditBaseFragment_MembersInjector.create(pageFragmentMembersInjector, memberUtilProvider, KeyboardUtil_Factory.create(), mediaUploaderProvider);
    profileBasicInfoEditFragmentMembersInjector = ProfileBasicInfoEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, profileUtilProvider, photoUtilsProvider, i18NManagerProvider);
    profileSkillsEditFragmentMembersInjector = ProfileSkillsEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, intentRegistryProvider, profileUtilProvider, memberUtilProvider);
    profileSkillsEditFragmentV2MembersInjector = ProfileSkillsEditFragmentV2_MembersInjector.create(profileEditBaseFragmentMembersInjector, intentRegistryProvider, profileUtilProvider);
    profileEndorsementsEditFragmentMembersInjector = ProfileEndorsementsEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, intentRegistryProvider, profileUtilProvider, memberUtilProvider);
    profilePositionEditFragmentMembersInjector = ProfilePositionEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, dataManagerProvider, intentRegistryProvider, profileUtilProvider, StringUtils_Factory.create());
    profileEditTreasuryBaseFragmentMembersInjector = profileEditBaseFragmentMembersInjector;
    profilePositionEditFragmentV2MembersInjector = ProfilePositionEditFragmentV2_MembersInjector.create(profileEditTreasuryBaseFragmentMembersInjector, dataManagerProvider, intentRegistryProvider, profileUtilProvider, eventBusProvider);
    profileEducationEditFragmentMembersInjector = ProfileEducationEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, dataManagerProvider, intentRegistryProvider, networkClientProvider, profileUtilProvider, StringUtils_Factory.create());
    profileEducationEditFragmentV2MembersInjector = ProfileEducationEditFragmentV2_MembersInjector.create(profileEditBaseFragmentMembersInjector, dataManagerProvider, intentRegistryProvider, profileUtilProvider, eventBusProvider);
    profileTreasuryEditFragmentMembersInjector = ProfileTreasuryEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, eventBusProvider, mediaUploaderProvider);
    profileVolunteeringExperienceEditFragmentMembersInjector = ProfileVolunteeringExperienceEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, dataManagerProvider, intentRegistryProvider, profileUtilProvider);
    profilePublicationEditFragmentMembersInjector = ProfilePublicationEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, intentRegistryProvider, profileUtilProvider);
    profileCertificationEditFragmentMembersInjector = ProfileCertificationEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, dataManagerProvider, intentRegistryProvider, networkClientProvider, profileUtilProvider, StringUtils_Factory.create());
    profilePatentEditFragmentMembersInjector = ProfilePatentEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, intentRegistryProvider, profileUtilProvider);
    profileCourseEditFragmentMembersInjector = ProfileCourseEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, profileUtilProvider);
    profileHonorEditFragmentMembersInjector = ProfileHonorEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, profileUtilProvider);
    profileContactInfoEditFragmentMembersInjector = ProfileContactInfoEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, dataManagerProvider, intentRegistryProvider, profileUtilProvider, StringUtils_Factory.create());
    profileProjectEditFragmentMembersInjector = ProfileProjectEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, profileUtilProvider);
    profileProjectMemberEditFragmentMembersInjector = ProfileProjectMemberEditFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, intentRegistryProvider, fragmentComponentProvider, profileUtilProvider);
    profileNewSectionsFragmentMembersInjector = ProfileNewSectionsFragment_MembersInjector.create(pageFragmentMembersInjector, photoUtilsProvider, eventBusProvider, delayedExecutionProvider);
    guidedEditTaskFragmentMembersInjector = GuidedEditTaskFragment_MembersInjector.create(pageFragmentMembersInjector, legoTrackingDataProvider, guidedEditDataProvider, profileDataProvider);
    guidedEditFlowRootFragmentMembersInjector = GuidedEditFlowRootFragment_MembersInjector.create(pageFragmentMembersInjector, guidedEditDataProvider);
    pendingEndorsedSkillsCardFragmentMembersInjector = pageFragmentMembersInjector;
    guidedEditSuggestedSkillsFragmentMembersInjector = guidedEditTaskFragmentMembersInjector;
    guidedEditSuggestedSkillsExitFragmentMembersInjector = guidedEditTaskFragmentMembersInjector;
    guidedEditSuggestionNullStateFragmentMembersInjector = guidedEditTaskFragmentMembersInjector;
    profileEditPhotoCropFragmentMembersInjector = ProfileEditPhotoCropFragment_MembersInjector.create(profileEditBaseFragmentMembersInjector, fragmentRegistryProvider, photoUtilsProvider);
    profileImageViewerFragmentMembersInjector = ProfileImageViewerFragment_MembersInjector.create(pageFragmentMembersInjector, photoUtilsProvider);
    profilePhotoViewFragmentMembersInjector = profileEditBaseFragmentMembersInjector;
    profileFeedFragmentMembersInjector = baseFeedFragmentMembersInjector;
    meWvmpFragmentMembersInjector = MeWvmpFragment_MembersInjector.create(pageFragmentMembersInjector, viewportManagerProvider);
    wvmpFragmentMembersInjector = WvmpFragment_MembersInjector.create(pageFragmentMembersInjector, viewportManagerProvider, viewPagerManagerProvider);
    contentAnalyticsFragmentMembersInjector = pageFragmentMembersInjector;
    pagedListFragmentMembersInjector = pageFragmentMembersInjector;
    profileGroupsFragmentMembersInjector = ProfileGroupsFragment_MembersInjector.create(pagedListFragmentMembersInjector, memberUtilProvider);
    relationshipsFragmentMembersInjector = RelationshipsFragment_MembersInjector.create(viewPagerFragmentMembersInjector, activityComponentProvider, fragmentComponentProvider, viewportManagerProvider, homeFragmentDataProvider, consistencyManagerProvider, homeCachedLixProvider, lixManagerProvider);
    myNetworkFragmentMembersInjector = MyNetworkFragment_MembersInjector.create(viewPagerFragmentMembersInjector, activityComponentProvider, fragmentComponentProvider, viewportManagerProvider, homeFragmentDataProvider, invitationsDataProvider, lixManagerProvider);
    invitationsListChildFragmentMembersInjector = InvitationsListChildFragment_MembersInjector.create(viewPagerFragmentMembersInjector, activityComponentProvider, fragmentComponentProvider, dataManagerProvider, lixManagerProvider);
    connectionListV2FragmentMembersInjector = ConnectionListV2Fragment_MembersInjector.create(pageFragmentMembersInjector, activityComponentProvider, fragmentComponentProvider);
    relationshipsSecondaryBaseFragmentMembersInjector = pageFragmentMembersInjector;
    connectFlowFragmentMembersInjector = ConnectFlowFragment_MembersInjector.create(relationshipsSecondaryBaseFragmentMembersInjector, viewportManagerProvider);
    addConnectionsFragmentMembersInjector = AddConnectionsFragment_MembersInjector.create(relationshipsSecondaryBaseFragmentMembersInjector, viewportManagerProvider);
    meetingDetailsFragmentMembersInjector = MeetingDetailsFragment_MembersInjector.create(pageFragmentMembersInjector, meetingDetailsDataProvider, trackerProvider, contextProvider, mediaCenterProvider);
    pendingInvitationListFragmentMembersInjector = PendingInvitationListFragment_MembersInjector.create(relationshipsSecondaryBaseFragmentMembersInjector, snackbarUtilProvider, invitationsDataProvider, pendingInvitationsDataProvider);
    baseCheckoutFragmentMembersInjector = pageFragmentMembersInjector;
    checkoutFragmentMembersInjector = CheckoutFragment_MembersInjector.create(baseCheckoutFragmentMembersInjector, KeyboardUtil_Factory.create(), paymentServiceProvider);
    phoneOnlyUserDialogManagerProvider = PhoneOnlyUserDialogManager_Factory.create(contextProvider, intentRegistryProvider, flagshipSharedPreferencesProvider, trackerProvider);
    premiumChooserFragmentMembersInjector = PremiumChooserFragment_MembersInjector.create(pageFragmentMembersInjector, phoneOnlyUserDialogManagerProvider);
    premiumChooserPageFragmentMembersInjector = viewPagerFragmentMembersInjector;
    premiumOnboardingCardFragmentMembersInjector = PremiumOnboardingCardFragment_MembersInjector.create(pageFragmentMembersInjector, memberUtilProvider);
    subscriptionChooserFragmentMembersInjector = SubscriptionChooserFragment_MembersInjector.create(pageFragmentMembersInjector, phoneOnlyUserDialogManagerProvider);
    subscriptionChooserPageFragmentMembersInjector = viewPagerFragmentMembersInjector;
    messagingFragmentMembersInjector = MessagingFragment_MembersInjector.create(viewPagerFragmentMembersInjector, dataManagerProvider, mediaCenterProvider, memberUtilProvider, networkClientProvider, emailManagementControllerProvider, snackbarUtilProvider);
    baseMessengerFragmentMembersInjector = pageFragmentMembersInjector;
    messageListFragmentMembersInjector = MessageListFragment_MembersInjector.create(baseMessengerFragmentMembersInjector, dataManagerProvider, mediaCenterProvider, memberUtilProvider, mediaUploaderProvider, photoUtilsProvider, eventBusProvider, networkClientProvider, flagshipCacheManagerProvider);
    composeFragmentMembersInjector = ComposeFragment_MembersInjector.create(baseMessengerFragmentMembersInjector, dataManagerProvider, mediaCenterProvider, memberUtilProvider, mediaUploaderProvider, photoUtilsProvider, eventBusProvider, networkClientProvider);
    inmailComposeFragmentMembersInjector = InmailComposeFragment_MembersInjector.create(baseMessengerFragmentMembersInjector, dataManagerProvider, mediaCenterProvider, memberUtilProvider, networkClientProvider);
    participantDetailsFragmentMembersInjector = ParticipantDetailsFragment_MembersInjector.create(baseMessengerFragmentMembersInjector, dataManagerProvider, mediaCenterProvider, memberUtilProvider, networkClientProvider);
    attachmentViewerFragmentMembersInjector = AttachmentViewerFragment_MembersInjector.create(baseMessengerFragmentMembersInjector, dataManagerProvider, mediaCenterProvider, memberUtilProvider, networkClientProvider);
    addParticipantFragmentMembersInjector = AddParticipantFragment_MembersInjector.create(baseMessengerFragmentMembersInjector, dataManagerProvider, mediaCenterProvider, memberUtilProvider, networkClientProvider);
    reconnectFragmentMembersInjector = ReconnectFragment_MembersInjector.create(baseMessengerFragmentMembersInjector, dataManagerProvider, mediaCenterProvider, memberUtilProvider, networkClientProvider);
    stickerStoreFragmentMembersInjector = StickerStoreFragment_MembersInjector.create(baseMessengerFragmentMembersInjector, dataManagerProvider, mediaCenterProvider, memberUtilProvider, networkClientProvider);
    conversationSearchListFragmentMembersInjector = ConversationSearchListFragment_MembersInjector.create(baseMessengerFragmentMembersInjector, dataManagerProvider, mediaCenterProvider, mediaUploaderProvider, memberUtilProvider, photoUtilsProvider, networkClientProvider);
    entityCoordinatorBaseFragmentMembersInjector = pageFragmentMembersInjector;
    groupFragmentMembersInjector = GroupFragment_MembersInjector.create(entityCoordinatorBaseFragmentMembersInjector, consistencyManagerProvider, dataManagerProvider);
    socialReaderFragmentMembersInjector = SocialReaderFragment_MembersInjector.create(pageFragmentMembersInjector, activityComponentProvider, fragmentComponentProvider, fragmentRegistryProvider, mediaCenterProvider);
    lixOverrideDialogFragmentMembersInjector = LixOverrideDialogFragment_MembersInjector.create(MembersInjectors.NoOpMembersInjector.INSTANCE, cookieUtilProvider, flagshipSharedPreferencesProvider);
    lixDebugFragmentMembersInjector = LixDebugFragment_MembersInjector.create(pageFragmentMembersInjector, cookieUtilProvider);
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
    return (BaseActivity)activityProvider.get();
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
    return (PublishingDataProvider)articleDataProvider.get();
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
    return (Context)contextProvider.get();
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
    return (FeedUpdateDetailDataProvider)feedUpdateDetailProvider.get();
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
  
  public final Fragment fragment()
  {
    return (Fragment)provideFragmentProvider.get();
  }
  
  public final FragmentManager fragmentManager()
  {
    return (FragmentManager)fragmentManagerProvider.get();
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
  
  public final void inject(GroupFragment paramGroupFragment)
  {
    groupFragmentMembersInjector.injectMembers(paramGroupFragment);
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
  
  public final void inject(BaseFeedActorListFragment paramBaseFeedActorListFragment)
  {
    baseFeedActorListFragmentMembersInjector.injectMembers(paramBaseFeedActorListFragment);
  }
  
  public final void inject(AggregateFragment paramAggregateFragment)
  {
    aggregateFragmentMembersInjector.injectMembers(paramAggregateFragment);
  }
  
  public final void inject(ChannelFragment paramChannelFragment)
  {
    channelFragmentMembersInjector.injectMembers(paramChannelFragment);
  }
  
  public final void inject(FeedUpdateDetailFragment paramFeedUpdateDetailFragment)
  {
    feedUpdateDetailFragmentMembersInjector.injectMembers(paramFeedUpdateDetailFragment);
  }
  
  public final void inject(BaseFeedFragment paramBaseFeedFragment)
  {
    baseFeedFragmentMembersInjector.injectMembers(paramBaseFeedFragment);
  }
  
  public final void inject(FeedFragment paramFeedFragment)
  {
    feedFragmentMembersInjector.injectMembers(paramFeedFragment);
  }
  
  public final void inject(ImageViewerFragment paramImageViewerFragment)
  {
    imageViewerFragmentMembersInjector.injectMembers(paramImageViewerFragment);
  }
  
  public final void inject(VideoViewerFragment paramVideoViewerFragment)
  {
    videoViewerFragmentMembersInjector.injectMembers(paramVideoViewerFragment);
  }
  
  public final void inject(CommentDetailFragment paramCommentDetailFragment)
  {
    commentDetailFragmentMembersInjector.injectMembers(paramCommentDetailFragment);
  }
  
  public final void inject(SendInviteActivity paramSendInviteActivity)
  {
    sendInviteActivityMembersInjector.injectMembers(paramSendInviteActivity);
  }
  
  public final void inject(AbiActivity paramAbiActivity)
  {
    abiActivityMembersInjector.injectMembers(paramAbiActivity);
  }
  
  public final void inject(AbiLoadContactsFragment paramAbiLoadContactsFragment)
  {
    abiLoadContactsFragmentMembersInjector.injectMembers(paramAbiLoadContactsFragment);
  }
  
  public final void inject(AbiPrepareFragment paramAbiPrepareFragment)
  {
    abiPrepareFragmentMembersInjector.injectMembers(paramAbiPrepareFragment);
  }
  
  public final void inject(AbiResultFragment paramAbiResultFragment)
  {
    abiResultFragmentMembersInjector.injectMembers(paramAbiResultFragment);
  }
  
  public final void inject(AbiLearnMoreFragment paramAbiLearnMoreFragment)
  {
    abiLearnMoreFragmentMembersInjector.injectMembers(paramAbiLearnMoreFragment);
  }
  
  public final void inject(BoostErrorFragment paramBoostErrorFragment)
  {
    boostErrorFragmentMembersInjector.injectMembers(paramBoostErrorFragment);
  }
  
  public final void inject(BoostSplashFragment paramBoostSplashFragment)
  {
    boostSplashFragmentMembersInjector.injectMembers(paramBoostSplashFragment);
  }
  
  public final void inject(CalendarSyncSettingsFragment paramCalendarSyncSettingsFragment)
  {
    calendarSyncSettingsFragmentMembersInjector.injectMembers(paramCalendarSyncSettingsFragment);
  }
  
  public final void inject(CalendarSyncSplashFragment paramCalendarSyncSplashFragment)
  {
    calendarSyncSplashFragmentMembersInjector.injectMembers(paramCalendarSyncSplashFragment);
  }
  
  public final void inject(CalendarSyncTakeoverFragment paramCalendarSyncTakeoverFragment)
  {
    calendarSyncTakeoverFragmentMembersInjector.injectMembers(paramCalendarSyncTakeoverFragment);
  }
  
  public final void inject(LegoWidget paramLegoWidget)
  {
    legoWidgetMembersInjector.injectMembers(paramLegoWidget);
  }
  
  public final void inject(MultiFragmentLegoWidget paramMultiFragmentLegoWidget)
  {
    multiFragmentLegoWidgetMembersInjector.injectMembers(paramMultiFragmentLegoWidget);
  }
  
  public final void inject(SingleFragmentLegoWidget paramSingleFragmentLegoWidget)
  {
    singleFragmentLegoWidgetMembersInjector.injectMembers(paramSingleFragmentLegoWidget);
  }
  
  public final void inject(LoginActivity paramLoginActivity)
  {
    loginActivityMembersInjector.injectMembers(paramLoginActivity);
  }
  
  public final void inject(JoinFragment paramJoinFragment)
  {
    joinFragmentMembersInjector.injectMembers(paramJoinFragment);
  }
  
  public final void inject(LoginFragment paramLoginFragment)
  {
    loginFragmentMembersInjector.injectMembers(paramLoginFragment);
  }
  
  public final void inject(PhoneConfirmationFragment paramPhoneConfirmationFragment)
  {
    phoneConfirmationFragmentMembersInjector.injectMembers(paramPhoneConfirmationFragment);
  }
  
  public final void inject(PinVerificationFragment paramPinVerificationFragment)
  {
    pinVerificationFragmentMembersInjector.injectMembers(paramPinVerificationFragment);
  }
  
  public final void inject(PreRegFragment paramPreRegFragment)
  {
    preRegFragmentMembersInjector.injectMembers(paramPreRegFragment);
  }
  
  public final void inject(PreRegIntroFragment paramPreRegIntroFragment)
  {
    preRegIntroFragmentMembersInjector.injectMembers(paramPreRegIntroFragment);
  }
  
  public final void inject(SSOFragment paramSSOFragment)
  {
    sSOFragmentMembersInjector.injectMembers(paramSSOFragment);
  }
  
  public final void inject(NewToVoyagerIntroActivity paramNewToVoyagerIntroActivity)
  {
    newToVoyagerIntroActivityMembersInjector.injectMembers(paramNewToVoyagerIntroActivity);
  }
  
  public final void inject(NewToVoyagerIntroFragment paramNewToVoyagerIntroFragment)
  {
    newToVoyagerIntroFragmentMembersInjector.injectMembers(paramNewToVoyagerIntroFragment);
  }
  
  public final void inject(OnboardingActivity paramOnboardingActivity)
  {
    onboardingActivityMembersInjector.injectMembers(paramOnboardingActivity);
  }
  
  public final void inject(OnboardingProfileEditFragment paramOnboardingProfileEditFragment)
  {
    onboardingProfileEditFragmentMembersInjector.injectMembers(paramOnboardingProfileEditFragment);
  }
  
  public final void inject(EmailConfirmationFragment paramEmailConfirmationFragment)
  {
    emailConfirmationFragmentMembersInjector.injectMembers(paramEmailConfirmationFragment);
  }
  
  public final void inject(EmailConfirmationLoadingFragment paramEmailConfirmationLoadingFragment)
  {
    emailConfirmationLoadingFragmentMembersInjector.injectMembers(paramEmailConfirmationLoadingFragment);
  }
  
  public final void inject(JobseekerPromoFragment paramJobseekerPromoFragment)
  {
    jobseekerPromoFragmentMembersInjector.injectMembers(paramJobseekerPromoFragment);
  }
  
  public final void inject(LocationFragment paramLocationFragment)
  {
    locationFragmentMembersInjector.injectMembers(paramLocationFragment);
  }
  
  public final void inject(LocationPickerFragment paramLocationPickerFragment)
  {
    locationPickerFragmentMembersInjector.injectMembers(paramLocationPickerFragment);
  }
  
  public final void inject(PhotoFragment paramPhotoFragment)
  {
    photoFragmentMembersInjector.injectMembers(paramPhotoFragment);
  }
  
  public final void inject(EducationFragment paramEducationFragment)
  {
    educationFragmentMembersInjector.injectMembers(paramEducationFragment);
  }
  
  public final void inject(PositionFragment paramPositionFragment)
  {
    positionFragmentMembersInjector.injectMembers(paramPositionFragment);
  }
  
  public final void inject(PymkFragment paramPymkFragment)
  {
    pymkFragmentMembersInjector.injectMembers(paramPymkFragment);
  }
  
  public final void inject(WelcomeMatFragment paramWelcomeMatFragment)
  {
    welcomeMatFragmentMembersInjector.injectMembers(paramWelcomeMatFragment);
  }
  
  public final void inject(PhoneCollectionFragment paramPhoneCollectionFragment)
  {
    phoneCollectionFragmentMembersInjector.injectMembers(paramPhoneCollectionFragment);
  }
  
  public final void inject(SmsReminderConsentFragment paramSmsReminderConsentFragment)
  {
    smsReminderConsentFragmentMembersInjector.injectMembers(paramSmsReminderConsentFragment);
  }
  
  public final void inject(HomeActivity paramHomeActivity)
  {
    homeActivityMembersInjector.injectMembers(paramHomeActivity);
  }
  
  public final void inject(HomeFragment paramHomeFragment)
  {
    homeFragmentMembersInjector.injectMembers(paramHomeFragment);
  }
  
  public final void inject(ProfileBasicInfoEditFragment paramProfileBasicInfoEditFragment)
  {
    profileBasicInfoEditFragmentMembersInjector.injectMembers(paramProfileBasicInfoEditFragment);
  }
  
  public final void inject(ProfileCertificationEditFragment paramProfileCertificationEditFragment)
  {
    profileCertificationEditFragmentMembersInjector.injectMembers(paramProfileCertificationEditFragment);
  }
  
  public final void inject(ProfileContactInfoEditFragment paramProfileContactInfoEditFragment)
  {
    profileContactInfoEditFragmentMembersInjector.injectMembers(paramProfileContactInfoEditFragment);
  }
  
  public final void inject(ProfileCourseEditFragment paramProfileCourseEditFragment)
  {
    profileCourseEditFragmentMembersInjector.injectMembers(paramProfileCourseEditFragment);
  }
  
  public final void inject(ProfileEducationEditFragment paramProfileEducationEditFragment)
  {
    profileEducationEditFragmentMembersInjector.injectMembers(paramProfileEducationEditFragment);
  }
  
  public final void inject(ProfileEducationEditFragmentV2 paramProfileEducationEditFragmentV2)
  {
    profileEducationEditFragmentV2MembersInjector.injectMembers(paramProfileEducationEditFragmentV2);
  }
  
  public final void inject(ProfileEndorsementsEditFragment paramProfileEndorsementsEditFragment)
  {
    profileEndorsementsEditFragmentMembersInjector.injectMembers(paramProfileEndorsementsEditFragment);
  }
  
  public final void inject(ProfileHonorEditFragment paramProfileHonorEditFragment)
  {
    profileHonorEditFragmentMembersInjector.injectMembers(paramProfileHonorEditFragment);
  }
  
  public final void inject(ProfilePatentEditFragment paramProfilePatentEditFragment)
  {
    profilePatentEditFragmentMembersInjector.injectMembers(paramProfilePatentEditFragment);
  }
  
  public final void inject(ProfilePositionEditFragment paramProfilePositionEditFragment)
  {
    profilePositionEditFragmentMembersInjector.injectMembers(paramProfilePositionEditFragment);
  }
  
  public final void inject(ProfilePositionEditFragmentV2 paramProfilePositionEditFragmentV2)
  {
    profilePositionEditFragmentV2MembersInjector.injectMembers(paramProfilePositionEditFragmentV2);
  }
  
  public final void inject(ProfileProjectEditFragment paramProfileProjectEditFragment)
  {
    profileProjectEditFragmentMembersInjector.injectMembers(paramProfileProjectEditFragment);
  }
  
  public final void inject(ProfileProjectMemberEditFragment paramProfileProjectMemberEditFragment)
  {
    profileProjectMemberEditFragmentMembersInjector.injectMembers(paramProfileProjectMemberEditFragment);
  }
  
  public final void inject(ProfilePublicationEditFragment paramProfilePublicationEditFragment)
  {
    profilePublicationEditFragmentMembersInjector.injectMembers(paramProfilePublicationEditFragment);
  }
  
  public final void inject(ProfileSkillsEditFragment paramProfileSkillsEditFragment)
  {
    profileSkillsEditFragmentMembersInjector.injectMembers(paramProfileSkillsEditFragment);
  }
  
  public final void inject(ProfileSkillsEditFragmentV2 paramProfileSkillsEditFragmentV2)
  {
    profileSkillsEditFragmentV2MembersInjector.injectMembers(paramProfileSkillsEditFragmentV2);
  }
  
  public final void inject(ProfileVolunteeringExperienceEditFragment paramProfileVolunteeringExperienceEditFragment)
  {
    profileVolunteeringExperienceEditFragmentMembersInjector.injectMembers(paramProfileVolunteeringExperienceEditFragment);
  }
  
  public final void inject(ProfileNewSectionsFragment paramProfileNewSectionsFragment)
  {
    profileNewSectionsFragmentMembersInjector.injectMembers(paramProfileNewSectionsFragment);
  }
  
  public final void inject(ProfileTreasuryEditFragment paramProfileTreasuryEditFragment)
  {
    profileTreasuryEditFragmentMembersInjector.injectMembers(paramProfileTreasuryEditFragment);
  }
  
  public final void inject(GuidedEditActivity paramGuidedEditActivity)
  {
    guidedEditActivityMembersInjector.injectMembers(paramGuidedEditActivity);
  }
  
  public final void inject(GuidedEditFlowRootFragment paramGuidedEditFlowRootFragment)
  {
    guidedEditFlowRootFragmentMembersInjector.injectMembers(paramGuidedEditFlowRootFragment);
  }
  
  public final void inject(GuidedEditTaskFragment paramGuidedEditTaskFragment)
  {
    guidedEditTaskFragmentMembersInjector.injectMembers(paramGuidedEditTaskFragment);
  }
  
  public final void inject(PendingEndorsedSkillsCardFragment paramPendingEndorsedSkillsCardFragment)
  {
    pendingEndorsedSkillsCardFragmentMembersInjector.injectMembers(paramPendingEndorsedSkillsCardFragment);
  }
  
  public final void inject(PendingEndorsementActivity paramPendingEndorsementActivity)
  {
    pendingEndorsementActivityMembersInjector.injectMembers(paramPendingEndorsementActivity);
  }
  
  public final void inject(NotificationsFragment paramNotificationsFragment)
  {
    notificationsFragmentMembersInjector.injectMembers(paramNotificationsFragment);
  }
  
  public final void inject(MeActorListFragment paramMeActorListFragment)
  {
    meActorListFragmentMembersInjector.injectMembers(paramMeActorListFragment);
  }
  
  public final void inject(MeWvmpFragment paramMeWvmpFragment)
  {
    meWvmpFragmentMembersInjector.injectMembers(paramMeWvmpFragment);
  }
  
  public final void inject(WvmpFragment paramWvmpFragment)
  {
    wvmpFragmentMembersInjector.injectMembers(paramWvmpFragment);
  }
  
  public final void inject(ProfileViewFragment paramProfileViewFragment)
  {
    profileViewFragmentMembersInjector.injectMembers(paramProfileViewFragment);
  }
  
  public final void inject(ProfileAccomplishmentsFragment paramProfileAccomplishmentsFragment)
  {
    profileAccomplishmentsFragmentMembersInjector.injectMembers(paramProfileAccomplishmentsFragment);
  }
  
  public final void inject(ProfileBackgroundFragment paramProfileBackgroundFragment)
  {
    profileBackgroundFragmentMembersInjector.injectMembers(paramProfileBackgroundFragment);
  }
  
  public final void inject(ProfileGroupsFragment paramProfileGroupsFragment)
  {
    profileGroupsFragmentMembersInjector.injectMembers(paramProfileGroupsFragment);
  }
  
  public final void inject(ProfileImageViewerFragment paramProfileImageViewerFragment)
  {
    profileImageViewerFragmentMembersInjector.injectMembers(paramProfileImageViewerFragment);
  }
  
  public final void inject(ProfileSummaryFragment paramProfileSummaryFragment)
  {
    profileSummaryFragmentMembersInjector.injectMembers(paramProfileSummaryFragment);
  }
  
  public final void inject(ProfileEditPhotoCropFragment paramProfileEditPhotoCropFragment)
  {
    profileEditPhotoCropFragmentMembersInjector.injectMembers(paramProfileEditPhotoCropFragment);
  }
  
  public final void inject(ProfilePhotoViewFragment paramProfilePhotoViewFragment)
  {
    profilePhotoViewFragmentMembersInjector.injectMembers(paramProfilePhotoViewFragment);
  }
  
  public final void inject(BaseActivity paramBaseActivity)
  {
    baseActivityMembersInjector.injectMembers(paramBaseActivity);
  }
  
  public final void inject(BaseFragment paramBaseFragment)
  {
    baseFragmentMembersInjector.injectMembers(paramBaseFragment);
  }
  
  public final void inject(CookieDebugFragment paramCookieDebugFragment)
  {
    cookieDebugFragmentMembersInjector.injectMembers(paramCookieDebugFragment);
  }
  
  public final void inject(CookieEditDialogFragment paramCookieEditDialogFragment)
  {
    cookieEditDialogFragmentMembersInjector.injectMembers(paramCookieEditDialogFragment);
  }
  
  public final void inject(LixDebugFragment paramLixDebugFragment)
  {
    lixDebugFragmentMembersInjector.injectMembers(paramLixDebugFragment);
  }
  
  public final void inject(LixOverrideDialogFragment paramLixOverrideDialogFragment)
  {
    lixOverrideDialogFragmentMembersInjector.injectMembers(paramLixOverrideDialogFragment);
  }
  
  public final void inject(SharedPreferenceDebugFragment paramSharedPreferenceDebugFragment)
  {
    sharedPreferenceDebugFragmentMembersInjector.injectMembers(paramSharedPreferenceDebugFragment);
  }
  
  public final void inject(SettingsFragment paramSettingsFragment)
  {
    settingsFragmentMembersInjector.injectMembers(paramSettingsFragment);
  }
  
  public final void inject(PhotoCropFragment paramPhotoCropFragment)
  {
    photoCropFragmentMembersInjector.injectMembers(paramPhotoCropFragment);
  }
  
  public final void inject(WebViewerBaseFragment paramWebViewerBaseFragment)
  {
    webViewerBaseFragmentMembersInjector.injectMembers(paramWebViewerBaseFragment);
  }
  
  public final void inject(DeepLinkHelperActivity paramDeepLinkHelperActivity)
  {
    deepLinkHelperActivityMembersInjector.injectMembers(paramDeepLinkHelperActivity);
  }
  
  public final void inject(MessagingFragment paramMessagingFragment)
  {
    messagingFragmentMembersInjector.injectMembers(paramMessagingFragment);
  }
  
  public final void inject(ComposeFragment paramComposeFragment)
  {
    composeFragmentMembersInjector.injectMembers(paramComposeFragment);
  }
  
  public final void inject(InmailComposeFragment paramInmailComposeFragment)
  {
    inmailComposeFragmentMembersInjector.injectMembers(paramInmailComposeFragment);
  }
  
  public final void inject(ConversationSearchListFragment paramConversationSearchListFragment)
  {
    conversationSearchListFragmentMembersInjector.injectMembers(paramConversationSearchListFragment);
  }
  
  public final void inject(AttachmentViewerFragment paramAttachmentViewerFragment)
  {
    attachmentViewerFragmentMembersInjector.injectMembers(paramAttachmentViewerFragment);
  }
  
  public final void inject(MessageListActivity paramMessageListActivity)
  {
    messageListActivityMembersInjector.injectMembers(paramMessageListActivity);
  }
  
  public final void inject(MessageListFragment paramMessageListFragment)
  {
    messageListFragmentMembersInjector.injectMembers(paramMessageListFragment);
  }
  
  public final void inject(AddParticipantFragment paramAddParticipantFragment)
  {
    addParticipantFragmentMembersInjector.injectMembers(paramAddParticipantFragment);
  }
  
  public final void inject(ParticipantDetailsFragment paramParticipantDetailsFragment)
  {
    participantDetailsFragmentMembersInjector.injectMembers(paramParticipantDetailsFragment);
  }
  
  public final void inject(ReconnectActivity paramReconnectActivity)
  {
    reconnectActivityMembersInjector.injectMembers(paramReconnectActivity);
  }
  
  public final void inject(ReconnectFragment paramReconnectFragment)
  {
    reconnectFragmentMembersInjector.injectMembers(paramReconnectFragment);
  }
  
  public final void inject(StickerStoreFragment paramStickerStoreFragment)
  {
    stickerStoreFragmentMembersInjector.injectMembers(paramStickerStoreFragment);
  }
  
  public final void inject(SubscriptionChooserFragment paramSubscriptionChooserFragment)
  {
    subscriptionChooserFragmentMembersInjector.injectMembers(paramSubscriptionChooserFragment);
  }
  
  public final void inject(SubscriptionChooserPageFragment paramSubscriptionChooserPageFragment)
  {
    subscriptionChooserPageFragmentMembersInjector.injectMembers(paramSubscriptionChooserPageFragment);
  }
  
  public final void inject(CheckoutFragment paramCheckoutFragment)
  {
    checkoutFragmentMembersInjector.injectMembers(paramCheckoutFragment);
  }
  
  public final void inject(PremiumChooserFragment paramPremiumChooserFragment)
  {
    premiumChooserFragmentMembersInjector.injectMembers(paramPremiumChooserFragment);
  }
  
  public final void inject(PremiumChooserPageFragment paramPremiumChooserPageFragment)
  {
    premiumChooserPageFragmentMembersInjector.injectMembers(paramPremiumChooserPageFragment);
  }
  
  public final void inject(PremiumOnboardingCardFragment paramPremiumOnboardingCardFragment)
  {
    premiumOnboardingCardFragmentMembersInjector.injectMembers(paramPremiumOnboardingCardFragment);
  }
  
  public final void inject(SocialReaderFragment paramSocialReaderFragment)
  {
    socialReaderFragmentMembersInjector.injectMembers(paramSocialReaderFragment);
  }
  
  public final void inject(BaseShareComposeFragment paramBaseShareComposeFragment)
  {
    baseShareComposeFragmentMembersInjector.injectMembers(paramBaseShareComposeFragment);
  }
  
  public final void inject(MentionPickerFragment paramMentionPickerFragment)
  {
    mentionPickerFragmentMembersInjector.injectMembers(paramMentionPickerFragment);
  }
  
  public final void inject(MyNetworkFragment paramMyNetworkFragment)
  {
    myNetworkFragmentMembersInjector.injectMembers(paramMyNetworkFragment);
  }
  
  public final void inject(RelationshipsFragment paramRelationshipsFragment)
  {
    relationshipsFragmentMembersInjector.injectMembers(paramRelationshipsFragment);
  }
  
  public final void inject(AddConnectionsFragment paramAddConnectionsFragment)
  {
    addConnectionsFragmentMembersInjector.injectMembers(paramAddConnectionsFragment);
  }
  
  public final void inject(ConnectFlowFragment paramConnectFlowFragment)
  {
    connectFlowFragmentMembersInjector.injectMembers(paramConnectFlowFragment);
  }
  
  public final void inject(ConnectionListV2Fragment paramConnectionListV2Fragment)
  {
    connectionListV2FragmentMembersInjector.injectMembers(paramConnectionListV2Fragment);
  }
  
  public final void inject(InvitationsListChildFragment paramInvitationsListChildFragment)
  {
    invitationsListChildFragmentMembersInjector.injectMembers(paramInvitationsListChildFragment);
  }
  
  public final void inject(PendingInvitationListFragment paramPendingInvitationListFragment)
  {
    pendingInvitationListFragmentMembersInjector.injectMembers(paramPendingInvitationListFragment);
  }
  
  public final void inject(MeetingDetailsFragment paramMeetingDetailsFragment)
  {
    meetingDetailsFragmentMembersInjector.injectMembers(paramMeetingDetailsFragment);
  }
  
  public final void inject(SearchActivity paramSearchActivity)
  {
    searchActivityMembersInjector.injectMembers(paramSearchActivity);
  }
  
  public final void inject(SearchFacetFragment paramSearchFacetFragment)
  {
    searchFacetFragmentMembersInjector.injectMembers(paramSearchFacetFragment);
  }
  
  public final void inject(SearchStarterFragment paramSearchStarterFragment)
  {
    searchStarterFragmentMembersInjector.injectMembers(paramSearchStarterFragment);
  }
  
  public final void inject(TypeaheadFragment paramTypeaheadFragment)
  {
    typeaheadFragmentMembersInjector.injectMembers(paramTypeaheadFragment);
  }
  
  public final void inject(SearchFragment paramSearchFragment)
  {
    searchFragmentMembersInjector.injectMembers(paramSearchFragment);
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
    return (PendingInvitationDataProvider)pendingInvitationsDataProvider.get();
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
    public ActivityComponent activityComponent;
    public FragmentModule fragmentModule;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.components.DaggerFragmentComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */