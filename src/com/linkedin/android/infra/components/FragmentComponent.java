package com.linkedin.android.infra.components;

import android.support.v4.app.Fragment;
import com.linkedin.android.entities.group.controllers.GroupFragment;
import com.linkedin.android.feed.actorlist.BaseFeedActorListFragment;
import com.linkedin.android.feed.aggregate.AggregateFragment;
import com.linkedin.android.feed.channel.ChannelFragment;
import com.linkedin.android.feed.detail.FeedUpdateDetailFragment;
import com.linkedin.android.feed.page.feed.BaseFeedFragment;
import com.linkedin.android.feed.page.feed.FeedFragment;
import com.linkedin.android.feed.shared.imageviewer.ImageViewerFragment;
import com.linkedin.android.feed.shared.videoviewer.VideoViewerFragment;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragment;
import com.linkedin.android.growth.abi.AbiLoadContactsFragment;
import com.linkedin.android.growth.abi.AbiPrepareFragment;
import com.linkedin.android.growth.abi.AbiResultFragment;
import com.linkedin.android.growth.abi.splash.AbiLearnMoreFragment;
import com.linkedin.android.growth.boost.error.BoostErrorFragment;
import com.linkedin.android.growth.boost.splash.BoostSplashFragment;
import com.linkedin.android.growth.calendar.CalendarSyncSettingsFragment;
import com.linkedin.android.growth.calendar.CalendarSyncSplashFragment;
import com.linkedin.android.growth.calendar.CalendarSyncTakeoverFragment;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.lego.MultiFragmentLegoWidget;
import com.linkedin.android.growth.lego.SingleFragmentLegoWidget;
import com.linkedin.android.growth.login.join.JoinFragment;
import com.linkedin.android.growth.login.login.LoginFragment;
import com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragment;
import com.linkedin.android.growth.login.phoneverification.PinVerificationFragment;
import com.linkedin.android.growth.login.prereg.PreRegFragment;
import com.linkedin.android.growth.login.prereg.intro.PreRegIntroFragment;
import com.linkedin.android.growth.login.sso.SSOFragment;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFragment;
import com.linkedin.android.growth.onboarding.base.OnboardingProfileEditFragment;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragment;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationLoadingFragment;
import com.linkedin.android.growth.onboarding.jobseeker_promo.JobseekerPromoFragment;
import com.linkedin.android.growth.onboarding.location.LocationFragment;
import com.linkedin.android.growth.onboarding.location.LocationPickerFragment;
import com.linkedin.android.growth.onboarding.photo.PhotoFragment;
import com.linkedin.android.growth.onboarding.position_education.EducationFragment;
import com.linkedin.android.growth.onboarding.position_education.PositionFragment;
import com.linkedin.android.growth.onboarding.pymk.PymkFragment;
import com.linkedin.android.growth.onboarding.welcome_mat.WelcomeMatFragment;
import com.linkedin.android.growth.phonecollection.PhoneCollectionFragment;
import com.linkedin.android.growth.smsreminderconsent.SmsReminderConsentFragment;
import com.linkedin.android.home.HomeFragment;
import com.linkedin.android.identity.edit.ProfileBasicInfoEditFragment;
import com.linkedin.android.identity.edit.ProfileCertificationEditFragment;
import com.linkedin.android.identity.edit.ProfileContactInfoEditFragment;
import com.linkedin.android.identity.edit.ProfileCourseEditFragment;
import com.linkedin.android.identity.edit.ProfileEducationEditFragment;
import com.linkedin.android.identity.edit.ProfileEducationEditFragmentV2;
import com.linkedin.android.identity.edit.ProfileEndorsementsEditFragment;
import com.linkedin.android.identity.edit.ProfileHonorEditFragment;
import com.linkedin.android.identity.edit.ProfilePatentEditFragment;
import com.linkedin.android.identity.edit.ProfilePositionEditFragment;
import com.linkedin.android.identity.edit.ProfilePositionEditFragmentV2;
import com.linkedin.android.identity.edit.ProfileProjectEditFragment;
import com.linkedin.android.identity.edit.ProfileProjectMemberEditFragment;
import com.linkedin.android.identity.edit.ProfilePublicationEditFragment;
import com.linkedin.android.identity.edit.ProfileSkillsEditFragment;
import com.linkedin.android.identity.edit.ProfileSkillsEditFragmentV2;
import com.linkedin.android.identity.edit.ProfileVolunteeringExperienceEditFragment;
import com.linkedin.android.identity.edit.newSections.ProfileNewSectionsFragment;
import com.linkedin.android.identity.edit.treasury.ProfileTreasuryEditFragment;
import com.linkedin.android.identity.guidededit.infra.GuidedEditFlowRootFragment;
import com.linkedin.android.identity.guidededit.infra.GuidedEditTaskFragment;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsedSkillsCardFragment;
import com.linkedin.android.identity.me.notifications.NotificationsFragment;
import com.linkedin.android.identity.me.shared.actorlist.MeActorListFragment;
import com.linkedin.android.identity.me.wvmp.MeWvmpFragment;
import com.linkedin.android.identity.me.wvmpV2.WvmpFragment;
import com.linkedin.android.identity.profile.ProfileViewFragment;
import com.linkedin.android.identity.profile.view.accomplishments.detail.ProfileAccomplishmentsFragment;
import com.linkedin.android.identity.profile.view.background.detail.ProfileBackgroundFragment;
import com.linkedin.android.identity.profile.view.groups.ProfileGroupsFragment;
import com.linkedin.android.identity.profile.view.imageViewer.ProfileImageViewerFragment;
import com.linkedin.android.identity.profile.view.topcard.ProfileSummaryFragment;
import com.linkedin.android.identity.shared.ProfileEditPhotoCropFragment;
import com.linkedin.android.identity.shared.ProfilePhotoViewFragment;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.debug.ui.CookieDebugFragment;
import com.linkedin.android.infra.debug.ui.CookieEditDialogFragment;
import com.linkedin.android.infra.debug.ui.LixDebugFragment;
import com.linkedin.android.infra.debug.ui.LixOverrideDialogFragment;
import com.linkedin.android.infra.debug.ui.SharedPreferenceDebugFragment;
import com.linkedin.android.infra.modules.FragmentModule;
import com.linkedin.android.infra.settings.ui.SettingsFragment;
import com.linkedin.android.infra.shared.PhotoCropFragment;
import com.linkedin.android.infra.webviewer.WebViewerBaseFragment;
import com.linkedin.android.messaging.MessagingFragment;
import com.linkedin.android.messaging.compose.ComposeFragment;
import com.linkedin.android.messaging.compose.InmailComposeFragment;
import com.linkedin.android.messaging.conversationlist.ConversationSearchListFragment;
import com.linkedin.android.messaging.messagelist.AttachmentViewerFragment;
import com.linkedin.android.messaging.messagelist.MessageListFragment;
import com.linkedin.android.messaging.participantdetails.AddParticipantFragment;
import com.linkedin.android.messaging.participantdetails.ParticipantDetailsFragment;
import com.linkedin.android.messaging.reconnect.ReconnectFragment;
import com.linkedin.android.messaging.stickers.StickerStoreFragment;
import com.linkedin.android.premium.SubscriptionChooserFragment;
import com.linkedin.android.premium.SubscriptionChooserPageFragment;
import com.linkedin.android.premium.checkout.CheckoutFragment;
import com.linkedin.android.premium.chooser.PremiumChooserFragment;
import com.linkedin.android.premium.chooser.PremiumChooserPageFragment;
import com.linkedin.android.premium.onboarding.PremiumOnboardingCardFragment;
import com.linkedin.android.publishing.reader.SocialReaderFragment;
import com.linkedin.android.publishing.sharing.compose.BaseShareComposeFragment;
import com.linkedin.android.publishing.sharing.mentionpicker.MentionPickerFragment;
import com.linkedin.android.relationships.MyNetworkFragment;
import com.linkedin.android.relationships.RelationshipsFragment;
import com.linkedin.android.relationships.addConnections.AddConnectionsFragment;
import com.linkedin.android.relationships.connectFlow.ConnectFlowFragment;
import com.linkedin.android.relationships.connections.ConnectionListV2Fragment;
import com.linkedin.android.relationships.invitations.InvitationsListChildFragment;
import com.linkedin.android.relationships.invitations.PendingInvitationListFragment;
import com.linkedin.android.relationships.meetings.MeetingDetailsFragment;
import com.linkedin.android.search.facet.SearchFacetFragment;
import com.linkedin.android.search.starter.SearchStarterFragment;
import com.linkedin.android.search.typeahead.TypeaheadFragment;
import com.linkedin.android.search.unifiedsearch.SearchFragment;
import dagger.Component;

@Component(dependencies={ActivityComponent.class}, modules={FragmentModule.class})
public abstract interface FragmentComponent
  extends ActivityComponent
{
  public abstract Fragment fragment();
  
  public abstract void inject(GroupFragment paramGroupFragment);
  
  public abstract void inject(BaseFeedActorListFragment paramBaseFeedActorListFragment);
  
  public abstract void inject(AggregateFragment paramAggregateFragment);
  
  public abstract void inject(ChannelFragment paramChannelFragment);
  
  public abstract void inject(FeedUpdateDetailFragment paramFeedUpdateDetailFragment);
  
  public abstract void inject(BaseFeedFragment paramBaseFeedFragment);
  
  public abstract void inject(FeedFragment paramFeedFragment);
  
  public abstract void inject(ImageViewerFragment paramImageViewerFragment);
  
  public abstract void inject(VideoViewerFragment paramVideoViewerFragment);
  
  public abstract void inject(CommentDetailFragment paramCommentDetailFragment);
  
  public abstract void inject(AbiLoadContactsFragment paramAbiLoadContactsFragment);
  
  public abstract void inject(AbiPrepareFragment paramAbiPrepareFragment);
  
  public abstract void inject(AbiResultFragment paramAbiResultFragment);
  
  public abstract void inject(AbiLearnMoreFragment paramAbiLearnMoreFragment);
  
  public abstract void inject(BoostErrorFragment paramBoostErrorFragment);
  
  public abstract void inject(BoostSplashFragment paramBoostSplashFragment);
  
  public abstract void inject(CalendarSyncSettingsFragment paramCalendarSyncSettingsFragment);
  
  public abstract void inject(CalendarSyncSplashFragment paramCalendarSyncSplashFragment);
  
  public abstract void inject(CalendarSyncTakeoverFragment paramCalendarSyncTakeoverFragment);
  
  public abstract void inject(LegoWidget paramLegoWidget);
  
  public abstract void inject(MultiFragmentLegoWidget paramMultiFragmentLegoWidget);
  
  public abstract void inject(SingleFragmentLegoWidget paramSingleFragmentLegoWidget);
  
  public abstract void inject(JoinFragment paramJoinFragment);
  
  public abstract void inject(LoginFragment paramLoginFragment);
  
  public abstract void inject(PhoneConfirmationFragment paramPhoneConfirmationFragment);
  
  public abstract void inject(PinVerificationFragment paramPinVerificationFragment);
  
  public abstract void inject(PreRegFragment paramPreRegFragment);
  
  public abstract void inject(PreRegIntroFragment paramPreRegIntroFragment);
  
  public abstract void inject(SSOFragment paramSSOFragment);
  
  public abstract void inject(NewToVoyagerIntroFragment paramNewToVoyagerIntroFragment);
  
  public abstract void inject(OnboardingProfileEditFragment paramOnboardingProfileEditFragment);
  
  public abstract void inject(EmailConfirmationFragment paramEmailConfirmationFragment);
  
  public abstract void inject(EmailConfirmationLoadingFragment paramEmailConfirmationLoadingFragment);
  
  public abstract void inject(JobseekerPromoFragment paramJobseekerPromoFragment);
  
  public abstract void inject(LocationFragment paramLocationFragment);
  
  public abstract void inject(LocationPickerFragment paramLocationPickerFragment);
  
  public abstract void inject(PhotoFragment paramPhotoFragment);
  
  public abstract void inject(EducationFragment paramEducationFragment);
  
  public abstract void inject(PositionFragment paramPositionFragment);
  
  public abstract void inject(PymkFragment paramPymkFragment);
  
  public abstract void inject(WelcomeMatFragment paramWelcomeMatFragment);
  
  public abstract void inject(PhoneCollectionFragment paramPhoneCollectionFragment);
  
  public abstract void inject(SmsReminderConsentFragment paramSmsReminderConsentFragment);
  
  public abstract void inject(HomeFragment paramHomeFragment);
  
  public abstract void inject(ProfileBasicInfoEditFragment paramProfileBasicInfoEditFragment);
  
  public abstract void inject(ProfileCertificationEditFragment paramProfileCertificationEditFragment);
  
  public abstract void inject(ProfileContactInfoEditFragment paramProfileContactInfoEditFragment);
  
  public abstract void inject(ProfileCourseEditFragment paramProfileCourseEditFragment);
  
  public abstract void inject(ProfileEducationEditFragment paramProfileEducationEditFragment);
  
  public abstract void inject(ProfileEducationEditFragmentV2 paramProfileEducationEditFragmentV2);
  
  public abstract void inject(ProfileEndorsementsEditFragment paramProfileEndorsementsEditFragment);
  
  public abstract void inject(ProfileHonorEditFragment paramProfileHonorEditFragment);
  
  public abstract void inject(ProfilePatentEditFragment paramProfilePatentEditFragment);
  
  public abstract void inject(ProfilePositionEditFragment paramProfilePositionEditFragment);
  
  public abstract void inject(ProfilePositionEditFragmentV2 paramProfilePositionEditFragmentV2);
  
  public abstract void inject(ProfileProjectEditFragment paramProfileProjectEditFragment);
  
  public abstract void inject(ProfileProjectMemberEditFragment paramProfileProjectMemberEditFragment);
  
  public abstract void inject(ProfilePublicationEditFragment paramProfilePublicationEditFragment);
  
  public abstract void inject(ProfileSkillsEditFragment paramProfileSkillsEditFragment);
  
  public abstract void inject(ProfileSkillsEditFragmentV2 paramProfileSkillsEditFragmentV2);
  
  public abstract void inject(ProfileVolunteeringExperienceEditFragment paramProfileVolunteeringExperienceEditFragment);
  
  public abstract void inject(ProfileNewSectionsFragment paramProfileNewSectionsFragment);
  
  public abstract void inject(ProfileTreasuryEditFragment paramProfileTreasuryEditFragment);
  
  public abstract void inject(GuidedEditFlowRootFragment paramGuidedEditFlowRootFragment);
  
  public abstract void inject(GuidedEditTaskFragment paramGuidedEditTaskFragment);
  
  public abstract void inject(PendingEndorsedSkillsCardFragment paramPendingEndorsedSkillsCardFragment);
  
  public abstract void inject(NotificationsFragment paramNotificationsFragment);
  
  public abstract void inject(MeActorListFragment paramMeActorListFragment);
  
  public abstract void inject(MeWvmpFragment paramMeWvmpFragment);
  
  public abstract void inject(WvmpFragment paramWvmpFragment);
  
  public abstract void inject(ProfileViewFragment paramProfileViewFragment);
  
  public abstract void inject(ProfileAccomplishmentsFragment paramProfileAccomplishmentsFragment);
  
  public abstract void inject(ProfileBackgroundFragment paramProfileBackgroundFragment);
  
  public abstract void inject(ProfileGroupsFragment paramProfileGroupsFragment);
  
  public abstract void inject(ProfileImageViewerFragment paramProfileImageViewerFragment);
  
  public abstract void inject(ProfileSummaryFragment paramProfileSummaryFragment);
  
  public abstract void inject(ProfileEditPhotoCropFragment paramProfileEditPhotoCropFragment);
  
  public abstract void inject(ProfilePhotoViewFragment paramProfilePhotoViewFragment);
  
  public abstract void inject(BaseFragment paramBaseFragment);
  
  public abstract void inject(CookieDebugFragment paramCookieDebugFragment);
  
  public abstract void inject(CookieEditDialogFragment paramCookieEditDialogFragment);
  
  public abstract void inject(LixDebugFragment paramLixDebugFragment);
  
  public abstract void inject(LixOverrideDialogFragment paramLixOverrideDialogFragment);
  
  public abstract void inject(SharedPreferenceDebugFragment paramSharedPreferenceDebugFragment);
  
  public abstract void inject(SettingsFragment paramSettingsFragment);
  
  public abstract void inject(PhotoCropFragment paramPhotoCropFragment);
  
  public abstract void inject(WebViewerBaseFragment paramWebViewerBaseFragment);
  
  public abstract void inject(MessagingFragment paramMessagingFragment);
  
  public abstract void inject(ComposeFragment paramComposeFragment);
  
  public abstract void inject(InmailComposeFragment paramInmailComposeFragment);
  
  public abstract void inject(ConversationSearchListFragment paramConversationSearchListFragment);
  
  public abstract void inject(AttachmentViewerFragment paramAttachmentViewerFragment);
  
  public abstract void inject(MessageListFragment paramMessageListFragment);
  
  public abstract void inject(AddParticipantFragment paramAddParticipantFragment);
  
  public abstract void inject(ParticipantDetailsFragment paramParticipantDetailsFragment);
  
  public abstract void inject(ReconnectFragment paramReconnectFragment);
  
  public abstract void inject(StickerStoreFragment paramStickerStoreFragment);
  
  public abstract void inject(SubscriptionChooserFragment paramSubscriptionChooserFragment);
  
  public abstract void inject(SubscriptionChooserPageFragment paramSubscriptionChooserPageFragment);
  
  public abstract void inject(CheckoutFragment paramCheckoutFragment);
  
  public abstract void inject(PremiumChooserFragment paramPremiumChooserFragment);
  
  public abstract void inject(PremiumChooserPageFragment paramPremiumChooserPageFragment);
  
  public abstract void inject(PremiumOnboardingCardFragment paramPremiumOnboardingCardFragment);
  
  public abstract void inject(SocialReaderFragment paramSocialReaderFragment);
  
  public abstract void inject(BaseShareComposeFragment paramBaseShareComposeFragment);
  
  public abstract void inject(MentionPickerFragment paramMentionPickerFragment);
  
  public abstract void inject(MyNetworkFragment paramMyNetworkFragment);
  
  public abstract void inject(RelationshipsFragment paramRelationshipsFragment);
  
  public abstract void inject(AddConnectionsFragment paramAddConnectionsFragment);
  
  public abstract void inject(ConnectFlowFragment paramConnectFlowFragment);
  
  public abstract void inject(ConnectionListV2Fragment paramConnectionListV2Fragment);
  
  public abstract void inject(InvitationsListChildFragment paramInvitationsListChildFragment);
  
  public abstract void inject(PendingInvitationListFragment paramPendingInvitationListFragment);
  
  public abstract void inject(MeetingDetailsFragment paramMeetingDetailsFragment);
  
  public abstract void inject(SearchFacetFragment paramSearchFacetFragment);
  
  public abstract void inject(SearchStarterFragment paramSearchStarterFragment);
  
  public abstract void inject(TypeaheadFragment paramTypeaheadFragment);
  
  public abstract void inject(SearchFragment paramSearchFragment);
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.components.FragmentComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */