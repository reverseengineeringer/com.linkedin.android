package com.linkedin.android.infra;

import com.linkedin.android.feed.actorlist.connectionsdetail.FeedConnectionUpdatesDetailFragmentFactory;
import com.linkedin.android.feed.actorlist.pymkdetail.FeedPymkUpdatesDetailFragmentFactory;
import com.linkedin.android.feed.aggregate.AggregateFragmentFactory;
import com.linkedin.android.feed.channel.ChannelFragmentFactory;
import com.linkedin.android.feed.detail.FeedUpdateDetailFragmentFactory;
import com.linkedin.android.feed.followhub.FollowHubFragmentFactory;
import com.linkedin.android.feed.followhub.FollowHubPackageFragmentFactory;
import com.linkedin.android.feed.page.feed.FeedFragmentFactory;
import com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateFactory;
import com.linkedin.android.feed.promptresponselist.FeedPromptResponseListFragmentFactory;
import com.linkedin.android.feed.shared.imageviewer.ImageViewerFragmentFactory;
import com.linkedin.android.feed.shared.videoviewer.VideoViewerFragmentFactory;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragmentFactory;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDetailFragmentFactory;
import com.linkedin.android.growth.abi.AbiLoadContactsFragmentFactory;
import com.linkedin.android.growth.abi.m2g.MainAbiM2GEmailFragmentFactory;
import com.linkedin.android.growth.abi.m2g.MainAbiM2GSmsFragmentFactory;
import com.linkedin.android.growth.abi.m2g.MainAbiM2GUnifiedSmsEmailFragmentFactory;
import com.linkedin.android.growth.abi.m2m.MainAbiM2MFragmentFactory;
import com.linkedin.android.growth.abi.splash.AbiLearnMoreFragmentFractory;
import com.linkedin.android.growth.abi.splash.MainAbiSplashFragmentFactory;
import com.linkedin.android.growth.boost.error.BoostErrorFragmentFactory;
import com.linkedin.android.growth.boost.splash.BoostSplashFragmentFactory;
import com.linkedin.android.growth.calendar.CalendarLearnMoreFragmentFactory;
import com.linkedin.android.growth.login.join.JoinFragmentFactory;
import com.linkedin.android.growth.login.login.LoginFragmentFactory;
import com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragmentFactory;
import com.linkedin.android.growth.login.phoneverification.PinVerificationFragmentFactory;
import com.linkedin.android.growth.login.prereg.PreRegFragmentFactory;
import com.linkedin.android.growth.login.sso.SSOFragmentFactory;
import com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerFeedFragmentFactory;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFragmentFactory;
import com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroDialogFragmentFactory;
import com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GEmailFragmentFactory;
import com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GSmsFragmentFactory;
import com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GUnifiedSMSEmailFragmentFactory;
import com.linkedin.android.growth.onboarding.abi.m2m.OnboardingAbiM2MFragmentFactory;
import com.linkedin.android.growth.onboarding.abi.splash.OnboardingAbiSplashFragmentFactory;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragmentFactory;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationLoadingFragmentFactory;
import com.linkedin.android.growth.onboarding.greeting.GreetingFragmentFactory;
import com.linkedin.android.growth.onboarding.jobseeker_promo.JobseekerPromoFragmentFactory;
import com.linkedin.android.growth.onboarding.photo.OnboardingPhotoCropFragmentFactory;
import com.linkedin.android.growth.onboarding.photo.PhotoFragmentFactory;
import com.linkedin.android.growth.onboarding.pymk.PymkFragmentFactory;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedFactory;
import com.linkedin.android.growth.onboarding.welcome_mat.WelcomeMatFragmentFactory;
import com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentFragmentFactory;
import com.linkedin.android.identity.me.notifications.NotificationsFragmentFactory;
import com.linkedin.android.identity.profile.ProfileViewFragmentFactory;
import com.linkedin.android.identity.shared.ProfilePhotoCropFragmentFactory;
import com.linkedin.android.infra.settings.SettingsFragmentFactory;
import com.linkedin.android.infra.shared.PhotoCropBundle;
import com.linkedin.android.infra.webviewer.SettingsWebViewerFragmentFactory;
import com.linkedin.android.infra.webviewer.WebViewerFragmentFactory;
import com.linkedin.android.messaging.MessagingFragmentFactory;
import com.linkedin.android.publishing.reader.ArticleFragmentFactory;
import com.linkedin.android.publishing.sharing.ShareFragmentFactory;
import com.linkedin.android.publishing.sharing.linkpicker.LinkPickerFragmentFactory;
import com.linkedin.android.publishing.sharing.mentionpicker.MentionPickerFragmentFactory;
import com.linkedin.android.relationships.RelationshipsFragmentFactory;
import com.linkedin.android.search.starter.SearchStarterFragmentFactory;
import com.linkedin.android.search.unifiedsearch.SearchFragmentFactory;
import javax.inject.Inject;

public final class FragmentRegistry
{
  public final AbiLearnMoreFragmentFractory abiLearnMore;
  public final AbiLoadContactsFragmentFactory abiLoadContacts;
  public final MainAbiM2GEmailFragmentFactory abiM2GEmailMain;
  public final OnboardingAbiM2GEmailFragmentFactory abiM2GEmailOnboarding;
  public final MainAbiM2GSmsFragmentFactory abiM2GSmsMain;
  public final OnboardingAbiM2GSmsFragmentFactory abiM2GSmsOnboarding;
  public final MainAbiM2GUnifiedSmsEmailFragmentFactory abiM2GUnifiedSmsEmailMain;
  public final OnboardingAbiM2GUnifiedSMSEmailFragmentFactory abiM2GUnifiedSmsEmailOnboarding;
  public final MainAbiM2MFragmentFactory abiM2MMain;
  public final OnboardingAbiM2MFragmentFactory abiM2MOnboarding;
  public final MainAbiSplashFragmentFactory abiSplashMain;
  public final OnboardingAbiSplashFragmentFactory abiSplashOnboarding;
  public final AggregateFragmentFactory aggregate;
  public final BoostErrorFragmentFactory boostError;
  public final BoostSplashFragmentFactory boostSplash;
  public final CalendarLearnMoreFragmentFactory calendarLearnMore;
  public final ChannelFragmentFactory channel;
  public final CommentDetailFragmentFactory commentDetail;
  public final FeedConnectionUpdatesDetailFragmentFactory connectionUpdates;
  public final WebViewerFragmentFactory externalArticleViewer;
  public final FeedFragmentFactory feed;
  public final FeedUpdateDetailFragmentFactory feedDetail;
  public final LikesDetailFragmentFactory feedLikesDetail;
  public final FeedPromptResponseListFragmentFactory feedPromptResponseList;
  public final FollowHubFragmentFactory followHub;
  public final FollowHubPackageFragmentFactory followHubPackage;
  public final GreetingFragmentFactory greeting;
  public final ImageViewerFragmentFactory imageViewer;
  public final ArticleFragmentFactory internalArticleViewer;
  public final JoinFragmentFactory join;
  public final LinkPickerFragmentFactory linkPicker;
  public final LoginFragmentFactory login;
  public final MentionPickerFragmentFactory mentionPicker;
  public final MessagingFragmentFactory messaging;
  public final NewToVoyagerFeedFragmentFactory newToVoyagerFeed;
  public final NewToVoyagerIntroDialogFragmentFactory newToVoyagerIntroDialog;
  public final NewToVoyagerIntroFragmentFactory newToVoyagerOrganicIntro;
  public final NotificationsFragmentFactory notifications;
  public final EmailConfirmationFragmentFactory onboardingEmailConfirmation;
  public final EmailConfirmationLoadingFragmentFactory onboardingEmailConfirmationLoading;
  public final JobseekerPromoFragmentFactory onboardingJobseekerPromo;
  public final PhotoFragmentFactory onboardingPhoto;
  public final OnboardingPhotoCropFragmentFactory onboardingPhotoCrop;
  public final PymkFragmentFactory onboardingPymk;
  public final WelcomeMatFragmentFactory onboardingWelcomeMat;
  public final PhoneConfirmationFragmentFactory phoneConfirm;
  public final PinVerificationFragmentFactory pinVerify;
  public final PreRegFragmentFactory preReg;
  public final ProfilePhotoCropFragmentFactory<PhotoCropBundle> profilePhotoCrop;
  public final ProfileViewFragmentFactory profileView;
  public final FeedPymkUpdatesDetailFragmentFactory pymkUpdates;
  public final RebuildMyFeedFactory rbmf;
  public final RelationshipsFragmentFactory relationships;
  public final SearchFragmentFactory search;
  public final SearchStarterFragmentFactory searchStarter;
  public final SettingsFragmentFactory settings;
  public final SettingsWebViewerFragmentFactory settingsWebViewer;
  public final ShareFragmentFactory share;
  public final SmsReminderConsentFragmentFactory smsReminderConsent;
  public final SSOFragmentFactory sso;
  public final UnfollowEducateFactory unfollowEducateFactory;
  public final VideoViewerFragmentFactory videoViewer;
  
  @Inject
  public FragmentRegistry(ProfilePhotoCropFragmentFactory<PhotoCropBundle> paramProfilePhotoCropFragmentFactory, SSOFragmentFactory paramSSOFragmentFactory, PreRegFragmentFactory paramPreRegFragmentFactory, NewToVoyagerIntroFragmentFactory paramNewToVoyagerIntroFragmentFactory, LoginFragmentFactory paramLoginFragmentFactory, JoinFragmentFactory paramJoinFragmentFactory, PhoneConfirmationFragmentFactory paramPhoneConfirmationFragmentFactory, PinVerificationFragmentFactory paramPinVerificationFragmentFactory, GreetingFragmentFactory paramGreetingFragmentFactory, MainAbiSplashFragmentFactory paramMainAbiSplashFragmentFactory, OnboardingAbiSplashFragmentFactory paramOnboardingAbiSplashFragmentFactory, AbiLearnMoreFragmentFractory paramAbiLearnMoreFragmentFractory, CalendarLearnMoreFragmentFactory paramCalendarLearnMoreFragmentFactory, RebuildMyFeedFactory paramRebuildMyFeedFactory, AbiLoadContactsFragmentFactory paramAbiLoadContactsFragmentFactory, PhotoFragmentFactory paramPhotoFragmentFactory, OnboardingPhotoCropFragmentFactory paramOnboardingPhotoCropFragmentFactory, EmailConfirmationLoadingFragmentFactory paramEmailConfirmationLoadingFragmentFactory, EmailConfirmationFragmentFactory paramEmailConfirmationFragmentFactory, WelcomeMatFragmentFactory paramWelcomeMatFragmentFactory, PymkFragmentFactory paramPymkFragmentFactory, JobseekerPromoFragmentFactory paramJobseekerPromoFragmentFactory, BoostSplashFragmentFactory paramBoostSplashFragmentFactory, BoostErrorFragmentFactory paramBoostErrorFragmentFactory, MainAbiM2MFragmentFactory paramMainAbiM2MFragmentFactory, OnboardingAbiM2MFragmentFactory paramOnboardingAbiM2MFragmentFactory, OnboardingAbiM2GEmailFragmentFactory paramOnboardingAbiM2GEmailFragmentFactory, MainAbiM2GEmailFragmentFactory paramMainAbiM2GEmailFragmentFactory, MainAbiM2GSmsFragmentFactory paramMainAbiM2GSmsFragmentFactory, MainAbiM2GUnifiedSmsEmailFragmentFactory paramMainAbiM2GUnifiedSmsEmailFragmentFactory, OnboardingAbiM2GSmsFragmentFactory paramOnboardingAbiM2GSmsFragmentFactory, OnboardingAbiM2GUnifiedSMSEmailFragmentFactory paramOnboardingAbiM2GUnifiedSMSEmailFragmentFactory, FeedFragmentFactory paramFeedFragmentFactory, FeedUpdateDetailFragmentFactory paramFeedUpdateDetailFragmentFactory, NewToVoyagerFeedFragmentFactory paramNewToVoyagerFeedFragmentFactory, ShareFragmentFactory paramShareFragmentFactory, ChannelFragmentFactory paramChannelFragmentFactory, AggregateFragmentFactory paramAggregateFragmentFactory, ImageViewerFragmentFactory paramImageViewerFragmentFactory, NotificationsFragmentFactory paramNotificationsFragmentFactory, SettingsFragmentFactory paramSettingsFragmentFactory, MessagingFragmentFactory paramMessagingFragmentFactory, RelationshipsFragmentFactory paramRelationshipsFragmentFactory, SearchStarterFragmentFactory paramSearchStarterFragmentFactory, SearchFragmentFactory paramSearchFragmentFactory, WebViewerFragmentFactory paramWebViewerFragmentFactory, ArticleFragmentFactory paramArticleFragmentFactory, VideoViewerFragmentFactory paramVideoViewerFragmentFactory, LikesDetailFragmentFactory paramLikesDetailFragmentFactory, LinkPickerFragmentFactory paramLinkPickerFragmentFactory, MentionPickerFragmentFactory paramMentionPickerFragmentFactory, NewToVoyagerIntroDialogFragmentFactory paramNewToVoyagerIntroDialogFragmentFactory, UnfollowEducateFactory paramUnfollowEducateFactory, SettingsWebViewerFragmentFactory paramSettingsWebViewerFragmentFactory, ProfileViewFragmentFactory paramProfileViewFragmentFactory, SmsReminderConsentFragmentFactory paramSmsReminderConsentFragmentFactory, FeedConnectionUpdatesDetailFragmentFactory paramFeedConnectionUpdatesDetailFragmentFactory, FeedPymkUpdatesDetailFragmentFactory paramFeedPymkUpdatesDetailFragmentFactory, CommentDetailFragmentFactory paramCommentDetailFragmentFactory, FeedPromptResponseListFragmentFactory paramFeedPromptResponseListFragmentFactory, FollowHubFragmentFactory paramFollowHubFragmentFactory, FollowHubPackageFragmentFactory paramFollowHubPackageFragmentFactory)
  {
    profilePhotoCrop = paramProfilePhotoCropFragmentFactory;
    sso = paramSSOFragmentFactory;
    preReg = paramPreRegFragmentFactory;
    newToVoyagerOrganicIntro = paramNewToVoyagerIntroFragmentFactory;
    login = paramLoginFragmentFactory;
    join = paramJoinFragmentFactory;
    phoneConfirm = paramPhoneConfirmationFragmentFactory;
    pinVerify = paramPinVerificationFragmentFactory;
    greeting = paramGreetingFragmentFactory;
    abiSplashMain = paramMainAbiSplashFragmentFactory;
    abiSplashOnboarding = paramOnboardingAbiSplashFragmentFactory;
    abiLearnMore = paramAbiLearnMoreFragmentFractory;
    calendarLearnMore = paramCalendarLearnMoreFragmentFactory;
    rbmf = paramRebuildMyFeedFactory;
    abiLoadContacts = paramAbiLoadContactsFragmentFactory;
    onboardingPhoto = paramPhotoFragmentFactory;
    onboardingPhotoCrop = paramOnboardingPhotoCropFragmentFactory;
    onboardingEmailConfirmationLoading = paramEmailConfirmationLoadingFragmentFactory;
    onboardingEmailConfirmation = paramEmailConfirmationFragmentFactory;
    onboardingWelcomeMat = paramWelcomeMatFragmentFactory;
    onboardingPymk = paramPymkFragmentFactory;
    onboardingJobseekerPromo = paramJobseekerPromoFragmentFactory;
    boostSplash = paramBoostSplashFragmentFactory;
    boostError = paramBoostErrorFragmentFactory;
    abiM2MMain = paramMainAbiM2MFragmentFactory;
    abiM2MOnboarding = paramOnboardingAbiM2MFragmentFactory;
    abiM2GEmailMain = paramMainAbiM2GEmailFragmentFactory;
    abiM2GEmailOnboarding = paramOnboardingAbiM2GEmailFragmentFactory;
    abiM2GSmsMain = paramMainAbiM2GSmsFragmentFactory;
    abiM2GUnifiedSmsEmailMain = paramMainAbiM2GUnifiedSmsEmailFragmentFactory;
    abiM2GSmsOnboarding = paramOnboardingAbiM2GSmsFragmentFactory;
    abiM2GUnifiedSmsEmailOnboarding = paramOnboardingAbiM2GUnifiedSMSEmailFragmentFactory;
    feed = paramFeedFragmentFactory;
    feedDetail = paramFeedUpdateDetailFragmentFactory;
    newToVoyagerFeed = paramNewToVoyagerFeedFragmentFactory;
    share = paramShareFragmentFactory;
    channel = paramChannelFragmentFactory;
    aggregate = paramAggregateFragmentFactory;
    feedLikesDetail = paramLikesDetailFragmentFactory;
    imageViewer = paramImageViewerFragmentFactory;
    notifications = paramNotificationsFragmentFactory;
    messaging = paramMessagingFragmentFactory;
    relationships = paramRelationshipsFragmentFactory;
    searchStarter = paramSearchStarterFragmentFactory;
    search = paramSearchFragmentFactory;
    externalArticleViewer = paramWebViewerFragmentFactory;
    internalArticleViewer = paramArticleFragmentFactory;
    videoViewer = paramVideoViewerFragmentFactory;
    linkPicker = paramLinkPickerFragmentFactory;
    mentionPicker = paramMentionPickerFragmentFactory;
    newToVoyagerIntroDialog = paramNewToVoyagerIntroDialogFragmentFactory;
    settings = paramSettingsFragmentFactory;
    unfollowEducateFactory = paramUnfollowEducateFactory;
    settingsWebViewer = paramSettingsWebViewerFragmentFactory;
    profileView = paramProfileViewFragmentFactory;
    smsReminderConsent = paramSmsReminderConsentFragmentFactory;
    connectionUpdates = paramFeedConnectionUpdatesDetailFragmentFactory;
    pymkUpdates = paramFeedPymkUpdatesDetailFragmentFactory;
    commentDetail = paramCommentDetailFragmentFactory;
    feedPromptResponseList = paramFeedPromptResponseListFragmentFactory;
    followHub = paramFollowHubFragmentFactory;
    followHubPackage = paramFollowHubPackageFragmentFactory;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.FragmentRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */