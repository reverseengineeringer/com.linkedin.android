package com.linkedin.android.infra.components;

import android.content.ContentResolver;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import com.linkedin.android.ConfirmEmailAddress.DeepLinkEmailManagementController;
import com.linkedin.android.ConfirmEmailAddress.EmailManagementController;
import com.linkedin.android.authenticator.LaunchActivity;
import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.entities.company.controllers.CompanyActivity;
import com.linkedin.android.entities.group.GroupDataProvider;
import com.linkedin.android.entities.group.controllers.GroupActivity;
import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.entities.job.controllers.JobActivity;
import com.linkedin.android.entities.jymbii.JymbiiActivity;
import com.linkedin.android.entities.jymbii.JymbiiDataProvider;
import com.linkedin.android.entities.school.SchoolDataProvider;
import com.linkedin.android.entities.school.controllers.SchoolActivity;
import com.linkedin.android.feed.FeedUpdatesDataProvider;
import com.linkedin.android.feed.channel.ChannelUpdatesDataProvider;
import com.linkedin.android.feed.detail.FeedUpdateDetailDataProvider;
import com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdatesDataProvider;
import com.linkedin.android.feed.page.feed.unfolloweducate.UnfollowEducateDataProvider;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailDataProvider;
import com.linkedin.android.feed.updates.common.likes.detail.LikesDataProvider;
import com.linkedin.android.growth.SendInviteActivity;
import com.linkedin.android.growth.abi.AbiActivity;
import com.linkedin.android.growth.abi.AbiDataProvider;
import com.linkedin.android.growth.heathrow.HeathrowFlowDataProvider;
import com.linkedin.android.growth.lego.LegoManager;
import com.linkedin.android.growth.login.LoginActivity;
import com.linkedin.android.growth.login.LoginUtils;
import com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.growth.login.sso.SSOManager;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroActivity;
import com.linkedin.android.growth.onboarding.OnboardingActivity;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedDataProvider;
import com.linkedin.android.growth.seo.samename.SameNameDirectoryDataProvider;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.home.HomeFragmentDataProvider;
import com.linkedin.android.identity.guidededit.GuidedEditActivity;
import com.linkedin.android.identity.guidededit.GuidedEditDataProvider;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsedSkillsDataProvider;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementActivity;
import com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementsEndorserDataProvider;
import com.linkedin.android.identity.me.contentanalytics.ContentAnalyticsDataProvider;
import com.linkedin.android.identity.me.notifications.NotificationsDataProvider;
import com.linkedin.android.identity.me.notifications.cards.dataproviders.MeCardDataProvider;
import com.linkedin.android.identity.me.wvmp.MeWvmpDataProvider;
import com.linkedin.android.identity.me.wvmpV2.WvmpDataProvider;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.view.recentactivity.detail.ProfileActivityFeedDataProvider;
import com.linkedin.android.identity.profile.view.recentactivity.detail.ProfileSharesFeedDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.modules.ActivityModule;
import com.linkedin.android.l2m.deeplink.DeepLinkHelperActivity;
import com.linkedin.android.messaging.messagelist.MessageListActivity;
import com.linkedin.android.messaging.reconnect.ReconnectActivity;
import com.linkedin.android.premium.PremiumDataProvider;
import com.linkedin.android.publishing.reader.PublishingDataProvider;
import com.linkedin.android.relationships.RelationshipsDataProvider;
import com.linkedin.android.relationships.addConnections.PymkDataProvider;
import com.linkedin.android.relationships.connectFlow.ConnectFlowDataProvider;
import com.linkedin.android.relationships.connections.ConnectionsV2DataProvider;
import com.linkedin.android.relationships.invitations.InvitationsDataProvider;
import com.linkedin.android.relationships.invitations.PendingInvitationDataProvider;
import com.linkedin.android.relationships.meetings.MeetingDetailsDataProvider;
import com.linkedin.android.search.SearchActivity;
import com.linkedin.android.search.SearchDataProvider;
import dagger.Component;

@Component(dependencies={ApplicationComponent.class}, modules={ActivityModule.class})
public abstract interface ActivityComponent
  extends ApplicationComponent
{
  public abstract AbiDataProvider abiDataProvider();
  
  public abstract BaseActivity activity();
  
  public abstract PublishingDataProvider articleDataProvider();
  
  public abstract ChannelUpdatesDataProvider channelUpdatesDataProvider();
  
  public abstract CommentDetailDataProvider commentDetailDataProvider();
  
  public abstract CompanyDataProvider companyDataProvider();
  
  public abstract ConnectFlowDataProvider connectFlowDataProvider();
  
  public abstract ConnectionsV2DataProvider connectionsV2DataProvider();
  
  public abstract ContentAnalyticsDataProvider contentAnalyticsDataProvider();
  
  public abstract ContentResolver contentResolver();
  
  public abstract Context context();
  
  public abstract DeepLinkEmailManagementController deepLinkEmailManagementController();
  
  public abstract EmailManagementController emailManagementController();
  
  public abstract FeedUpdateDetailDataProvider feedUpdateDetailProvider();
  
  public abstract FeedUpdatesDataProvider feedUpdatesDataProvider();
  
  public abstract FragmentManager fragmentManager();
  
  public abstract GoogleIdTokenManager googleIdTokenManager();
  
  public abstract GroupDataProvider groupDataProvider();
  
  public abstract GuidedEditDataProvider guidedEditDataProvider();
  
  public abstract HeathrowFlowDataProvider heathrowFlowDataProvider();
  
  public abstract HighlightedUpdatesDataProvider highlightedUpdatesDataProvider();
  
  public abstract HomeFragmentDataProvider homeFragmentDataProvider();
  
  public abstract void inject(LaunchActivity paramLaunchActivity);
  
  public abstract void inject(CompanyActivity paramCompanyActivity);
  
  public abstract void inject(GroupActivity paramGroupActivity);
  
  public abstract void inject(JobActivity paramJobActivity);
  
  public abstract void inject(JymbiiActivity paramJymbiiActivity);
  
  public abstract void inject(SchoolActivity paramSchoolActivity);
  
  public abstract void inject(SendInviteActivity paramSendInviteActivity);
  
  public abstract void inject(AbiActivity paramAbiActivity);
  
  public abstract void inject(LoginActivity paramLoginActivity);
  
  public abstract void inject(NewToVoyagerIntroActivity paramNewToVoyagerIntroActivity);
  
  public abstract void inject(OnboardingActivity paramOnboardingActivity);
  
  public abstract void inject(HomeActivity paramHomeActivity);
  
  public abstract void inject(GuidedEditActivity paramGuidedEditActivity);
  
  public abstract void inject(PendingEndorsementActivity paramPendingEndorsementActivity);
  
  public abstract void inject(BaseActivity paramBaseActivity);
  
  public abstract void inject(DeepLinkHelperActivity paramDeepLinkHelperActivity);
  
  public abstract void inject(MessageListActivity paramMessageListActivity);
  
  public abstract void inject(ReconnectActivity paramReconnectActivity);
  
  public abstract void inject(SearchActivity paramSearchActivity);
  
  public abstract InvitationsDataProvider invitationsDataProvider();
  
  public abstract JobDataProvider jobDataProvider();
  
  public abstract JymbiiDataProvider jymbiiDataProvider();
  
  public abstract LegoManager legoManager();
  
  public abstract LegoTrackingDataProvider legoTrackingDataProvider();
  
  public abstract LikesDataProvider likesDataProvider();
  
  public abstract LoginUtils loginUtils();
  
  public abstract MeCardDataProvider meCardDataProvider();
  
  public abstract MeWvmpDataProvider meWvmpDataProvider();
  
  public abstract MeetingDetailsDataProvider meetingDetailsDataProvider();
  
  public abstract NotificationsDataProvider notificationsDataProvider();
  
  public abstract OnboardingDataProvider onboardingDataProvider();
  
  public abstract PendingEndorsedSkillsDataProvider pendingEndorsedSkillsDataProvider();
  
  public abstract PendingEndorsementsEndorserDataProvider pendingEndorsementsEndorserDataProvider();
  
  public abstract PendingInvitationDataProvider pendingInvitationsDataProvider();
  
  public abstract PremiumDataProvider premiumDataProvider();
  
  public abstract ProfileActivityFeedDataProvider profileActivityFeedDataProvider();
  
  public abstract ProfileDataProvider profileDataProvider();
  
  public abstract ProfileSharesFeedDataProvider profileSharesFeedDataProvider();
  
  public abstract PymkDataProvider pymkDataProvider();
  
  public abstract RebuildMyFeedDataProvider rebuildMyFeedDataProvider();
  
  public abstract RelationshipsDataProvider relationshipsDataProvider();
  
  public abstract SameNameDirectoryDataProvider sameNameDirectoryDataProvider();
  
  public abstract SchoolDataProvider schoolDataProvider();
  
  public abstract SearchDataProvider searchDataProvider();
  
  public abstract SmartLockManager smartLockManager();
  
  public abstract SSOManager ssoManager();
  
  public abstract UnfollowEducateDataProvider unfollowEducateDataProvider();
  
  public abstract WvmpDataProvider wvmpDataProvider();
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.components.ActivityComponent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */