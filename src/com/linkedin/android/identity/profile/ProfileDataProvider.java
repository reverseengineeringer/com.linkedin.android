package com.linkedin.android.identity.profile;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataRequestWrapper.Builder;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.growth.heathrow.HeathrowIntent;
import com.linkedin.android.growth.heathrow.HeathrowRoutingIntentBundle;
import com.linkedin.android.growth.heathrow.HeathrowSource;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditSource;
import com.linkedin.android.identity.profile.view.OptimisticModelMockUtil;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager.PendingState;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.Country;
import com.linkedin.android.pegasus.gen.voyager.common.MySettings;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Header;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.BrowsemapMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Certification;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.CertificationView;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Course;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.CourseView;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Education;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EducationView;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsementsCollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.FollowableEntity;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Honor;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.HonorView;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Language;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducation;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEndorsement;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPosition;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Organization;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PatentView;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Position;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionView;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Post;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileNetworkInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Project;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProjectView;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Publication;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PublicationView;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Recommendation;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.SuggestedEndorsement;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.SuggestedEndorsementsMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.TestScore;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.TestScoreView;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.VolunteerExperience;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.VolunteerExperienceView;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.WWUAd;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.InvitationPending.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileAction;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileAction.Action;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileAction.Action.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileAction.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileActions;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileActions.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.promotions.ProfilePromotion;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMediaItems;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.Highlight;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MemberConnection;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent.Type;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.VoidRecord;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ProfileDataProvider
  extends DataProvider<ProfileState, DataProvider.DataProviderListener>
{
  @Inject
  public Auth auth;
  @Inject
  public LixManager lixManager;
  @Inject
  MemberUtil memberUtil;
  public String profileId;
  @Inject
  ProfilePendingConnectionRequestManager profilePendingConnectionRequestManager;
  public boolean profileViewApiEnabled;
  
  @Inject
  public ProfileDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  private void addProfileOnlyRequests(String paramString, MultiplexRequest.Builder paramBuilder)
  {
    if (auth.isAuthenticated())
    {
      state).mySettingsRoute = ProfileRoutes.buildMySettingsRoute().toString();
      state).skillsRoute = ProfileRoutes.buildSkillsRoute(paramString).toString();
      paramBuilder.optional(Request.get().url(state).mySettingsRoute).builder(MySettings.BUILDER));
    }
    for (;;)
    {
      paramBuilder.optional(Request.get().url(state).skillsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Skill.BUILDER, CollectionMetadata.BUILDER)));
      if (!profileViewApiEnabled) {
        break;
      }
      state).profileViewRoute = ProfileRoutes.buildProfileViewRoute(paramString).toString();
      paramBuilder.required(Request.get().url(state).profileViewRoute).builder(ProfileView.BUILDER));
      return;
      state).skillsRoute = ProfileRoutes.buildPublicProfileSkillsRoute(paramString).toString();
    }
    state).profileRoute = ProfileRoutes.buildProfileRoute(paramString).toString();
    state).primaryLocaleRoute = ProfileRoutes.buildPrimaryLocaleRoute(paramString).toString();
    state).certificationsRoute = ProfileRoutes.buildCertificationsRoute(paramString).toString();
    state).coursesRoute = ProfileRoutes.buildCoursesRoute(paramString).toString();
    state).honorsRoute = ProfileRoutes.buildHonorsRoute(paramString).toString();
    state).patentsRoute = ProfileRoutes.buildPatentsRoute(paramString).toString();
    state).projectsRoute = ProfileRoutes.buildProjectsRoute(paramString).toString();
    state).publicationsRoute = ProfileRoutes.buildPublicationsRoute(paramString).toString();
    state).testScoresRoute = ProfileRoutes.buildTestScoresRoute(paramString).toString();
    state).languagesRoute = ProfileRoutes.buildLanguagesRoute(paramString).toString();
    state).positionsRoute = ProfileRoutes.buildPositionsRoute(paramString).toString();
    state).educationsRoute = ProfileRoutes.buildEducationsRoute(paramString).toString();
    state).volunteerExperiencesRoute = ProfileRoutes.buildVolunteerExperiencesRoute(paramString).toString();
    state).organizationsRoute = ProfileRoutes.buildOrganizationsRoute(paramString).toString();
    paramBuilder.required(Request.get().url(state).profileRoute).builder(Profile.BUILDER)).optional(Request.get().url(state).primaryLocaleRoute).builder(com.linkedin.android.pegasus.gen.common.Locale.BUILDER)).optional(Request.get().url(state).certificationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Certification.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).coursesRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Course.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).honorsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Honor.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).patentsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Patent.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).projectsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Project.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).publicationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Publication.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).testScoresRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(TestScore.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).languagesRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Language.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).positionsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Position.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).educationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Education.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).volunteerExperiencesRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(VolunteerExperience.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).organizationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Organization.BUILDER, CollectionMetadata.BUILDER)));
  }
  
  private void fetchEducation(MultiplexRequest.Builder paramBuilder)
  {
    state).educationsRoute = ProfileRoutes.buildEducationsRoute(profileId).toString();
    state).allEducationsRoute = state).educationsRoute;
    paramBuilder.optional(Request.get().url(state).educationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Education.BUILDER, CollectionMetadata.BUILDER)));
  }
  
  private void fetchPosition(MultiplexRequest.Builder paramBuilder)
  {
    state).positionsRoute = ProfileRoutes.buildPositionsRoute(profileId).toString();
    state).allPositionsRoute = state).positionsRoute;
    paramBuilder.optional(Request.get().url(state).positionsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Position.BUILDER, CollectionMetadata.BUILDER)));
  }
  
  private void fetchProfile(MultiplexRequest.Builder paramBuilder)
  {
    state).profileViewRoute = ProfileRoutes.buildProfileViewRoute(profileId).toString();
    state).profileRoute = ProfileRoutes.buildProfileRoute(profileId).toString();
    if (profileViewApiEnabled)
    {
      paramBuilder.optional(Request.get().url(state).profileViewRoute).builder(ProfileView.BUILDER));
      return;
    }
    paramBuilder.optional(Request.get().url(ProfileRoutes.buildProfileRoute(profileId).toString()).builder(Profile.BUILDER));
  }
  
  private void fireSendInvitationRequest(String paramString1, String paramString2, String paramString3, FragmentComponent paramFragmentComponent, RecordTemplateListener<VoidRecord> paramRecordTemplateListener)
  {
    try
    {
      Object localObject = new InviteeProfile.Builder().setProfileId(paramString1).build(RecordTemplate.Flavor.RECORD);
      localObject = new NormInvitation.Invitee.Builder().setInviteeProfileValue((InviteeProfile)localObject).build();
      paramString2 = new NormInvitation.Builder().setInvitee((NormInvitation.Invitee)localObject).setTrackingId(paramString2);
      if (paramString3 != null) {
        paramString2.setMessage(paramString3);
      }
      paramString2 = PegasusPatchGenerator.modelToJSON(paramString2.build(RecordTemplate.Flavor.RECORD));
      paramString3 = Routes.NORM_INVITATIONS.buildUponRoot().buildUpon().build().toString();
      paramString2 = Request.post().url(paramString3).model(new JsonModel(paramString2)).listener(paramRecordTemplateListener).filter(DataManager.DataStoreFilter.NETWORK_ONLY).customHeaders(Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance()));
      activityComponent.dataManager().submit(paramString2);
      paramFragmentComponent.eventBus();
      Bus.publish(new InvitationUpdatedEvent(paramString1, InvitationUpdatedEvent.Type.SENT));
      profilePendingConnectionRequestManager.setPendingState(paramString1, ProfilePendingConnectionRequestManager.PendingState.INVITATION_SENT);
      return;
    }
    catch (BuilderException paramString1)
    {
      Util.safeThrow(new RuntimeException("Failed to create normInvitation", paramString1));
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;) {}
    }
  }
  
  private MultiplexRequest.Builder getDeleteRequestBuilder(String paramString1, String paramString2, DataRequestWrapper.Builder<?> paramBuilder, boolean paramBoolean)
  {
    state).profileViewRoute = ProfileRoutes.buildProfileViewRoute(paramString2).toString();
    state).profileRoute = ProfileRoutes.buildProfileRoute(paramString2).toString();
    paramString1 = newUpdateRequestBuilder().required(Request.delete().url(paramString1));
    if (profileViewApiEnabled)
    {
      paramString1.optional(Request.get().url(state).profileViewRoute).builder(ProfileView.BUILDER));
      if (paramBoolean) {
        paramString1.optional(paramBuilder);
      }
      return paramString1;
    }
    paramString1.optional(Request.get().url(state).profileRoute).builder(Profile.BUILDER)).optional(paramBuilder);
    return paramString1;
  }
  
  private static int getDisconnectActionIndex(ProfileActions paramProfileActions)
  {
    int i = 0;
    while (i < overflowActions.size())
    {
      if (overflowActions.get(i)).action.disconnectValue != null) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static MultiplexRequest.Builder newUpdateRequestBuilder()
  {
    MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.sequential();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    return localBuilder.filter(DataManager.DataStoreFilter.ALL);
  }
  
  private void setModifiedNetworkInfoModel(String paramString, ProfileNetworkInfo paramProfileNetworkInfo)
  {
    if (paramProfileNetworkInfo != null)
    {
      ProfileState localProfileState = (ProfileState)state;
      localProfileState.setModel(networkInfoRoute, paramProfileNetworkInfo, paramString);
    }
  }
  
  public final void clearProfile(String paramString)
  {
    ProfileState localProfileState = (ProfileState)state;
    localProfileState.setModel(profileRoute, null, paramString);
  }
  
  public final void deleteEducation(String paramString1, String paramString2, String paramString3, Education paramEducation, String paramString4, Map<String, String> paramMap)
  {
    paramEducation = ProfileRoutes.buildDeleteEntityRoute("normEducations", paramString3, entityUrn.getLastId(), paramString4).toString();
    state).educationsRoute = ProfileRoutes.buildEducationsRoute(paramString3).toString();
    state).allEducationsRoute = state).educationsRoute;
    performMultiplexedFetch(paramString1, paramString2, paramMap, getDeleteRequestBuilder(paramEducation, paramString3, Request.get().url(state).educationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Education.BUILDER, CollectionMetadata.BUILDER))));
  }
  
  public final void deleteEndorsedSkill(String paramString1, String paramString2, String paramString3, EndorsedSkill paramEndorsedSkill, String paramString4, Map<String, String> paramMap)
  {
    paramEndorsedSkill = ProfileRoutes.buildDeleteEntityRoute("normSkills", paramString3, entityUrn.getLastId(), paramString4).toString();
    state).endorsedSkillsForEditRoute = ProfileRoutes.buildEndorsedSkillsRouteForEdit(paramString3).toString();
    performMultiplexedFetch(paramString1, paramString2, paramMap, getDeleteRequestBuilder(paramEndorsedSkill, paramString3, Request.get().url(state).endorsedSkillsForEditRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER)), true));
  }
  
  public final void deleteEndorsementDetail(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, String> paramMap)
  {
    paramString4 = ProfileRoutes.buildDeleteEndorsementRoute(paramString3, paramString4).toString();
    state).allEndorsedSkillsRoute = ProfileRoutes.buildEndorsedSkillsRouteWithCount$68d17de5(paramString3).toString();
    state).endorsementsRoute = ProfileRoutes.buildSkillEndorsementsRoute(paramString3, paramString5).toString();
    ((ProfileState)state).clearModel(state).endorsementsRoute);
    performMultiplexedFetch(paramString1, paramString2, paramMap, newUpdateRequestBuilder().required(Request.delete().url(paramString4)).optional(Request.get().url(state).allEndorsedSkillsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER))).optional(Request.get().url(state).endorsementsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Endorsement.BUILDER, CollectionMetadata.BUILDER))));
  }
  
  public final void deleteEndorsementDetailFeaturedSkill(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, String> paramMap)
  {
    paramString4 = ProfileRoutes.buildDeleteEndorsementRoute(paramString3, paramString4).toString();
    state).allFeaturedSkillsRoute = ProfileRoutes.buildFeaturedSkillsRouteWithCount$68d17de5(paramString3).toString();
    state).endorsementsRoute = ProfileRoutes.buildSkillEndorsementsRoute(paramString3, paramString5).toString();
    ((ProfileState)state).clearModel(state).endorsementsRoute);
    performMultiplexedFetch(paramString1, paramString2, paramMap, newUpdateRequestBuilder().required(Request.delete().url(paramString4)).optional(Request.get().url(state).allFeaturedSkillsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER))).optional(Request.get().url(state).endorsementsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Endorsement.BUILDER, CollectionMetadata.BUILDER))));
  }
  
  public final void deleteFeaturedSkill(String paramString1, String paramString2, String paramString3, EndorsedSkill paramEndorsedSkill, String paramString4, Map<String, String> paramMap)
  {
    paramEndorsedSkill = ProfileRoutes.buildDeleteEntityRoute("normSkills", paramString3, entityUrn.getLastId(), paramString4).toString();
    state).featuredSkillsForEditRoute = ProfileRoutes.buildFeaturedSkillsRouteForEdit(paramString3).toString();
    performMultiplexedFetch(paramString1, paramString2, paramMap, getDeleteRequestBuilder(paramEndorsedSkill, paramString3, Request.get().url(state).featuredSkillsForEditRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER)), true));
  }
  
  public final void deletePosition(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Map<String, String> paramMap)
  {
    paramString4 = ProfileRoutes.buildDeleteEntityRoute("normPositions", paramString3, paramString4, paramString5).toString();
    state).positionsRoute = ProfileRoutes.buildPositionsRoute(paramString3).toString();
    state).allPositionsRoute = state).positionsRoute;
    performMultiplexedFetch(paramString1, paramString2, paramMap, getDeleteRequestBuilder(paramString4, paramString3, Request.get().url(state).positionsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Position.BUILDER, CollectionMetadata.BUILDER))));
  }
  
  public final void fetchContactInfoData(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    state).profileViewRoute = ProfileRoutes.buildProfileViewRoute(paramString3).toString();
    state).profileRoute = ProfileRoutes.buildProfileRoute(paramString3).toString();
    state).networkInfoRoute = ProfileRoutes.buildNetworkInfoRoute(paramString3).toString();
    state).contactInfoRoute = ProfileRoutes.buildContactInfoRoute(paramString3).toString();
    paramString3 = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    paramString3 = paramString3.required(Request.get().url(state).contactInfoRoute).builder(ProfileContactInfo.BUILDER)).optional(Request.get().url(state).networkInfoRoute).builder(ProfileNetworkInfo.BUILDER));
    if (profileViewApiEnabled) {
      paramString3.required(Request.get().url(state).profileViewRoute).builder(ProfileView.BUILDER));
    }
    for (;;)
    {
      performMultiplexedFetch(paramString1, paramString2, paramMap, paramString3);
      return;
      paramString3.required(Request.get().url(state).profileRoute).builder(Profile.BUILDER));
    }
  }
  
  public final void fetchData(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, DataManager.DataStoreFilter paramDataStoreFilter)
  {
    profileId = paramString1;
    state).isProfileViewCallInProgress = true;
    MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    paramDataStoreFilter = localBuilder.filter(paramDataStoreFilter);
    int i;
    if (auth.isAuthenticated())
    {
      state).networkInfoRoute = ProfileRoutes.buildNetworkInfoRoute(paramString1).toString();
      state).recsGivenRoute = ProfileRoutes.buildRecommendationsGivenRoute(paramString1).toString();
      state).memberBadgesRoute = ProfileRoutes.buildMemberBadgesRoute(paramString1).toString();
      state).endorsedSkillsRoute = ProfileRoutes.buildEndorsedSkillsRoute(paramString1).toString();
      state).featuredSkillsRoute = ProfileRoutes.buildFeaturedSkillsRoute(paramString1).toString();
      state).highlightsRoute = ProfileRoutes.buildHighlightsRoute(paramString1).toString();
      state).suggestedEndorsementsRoute = ProfileRoutes.buildSuggestedEndorsementsRoute(paramString1).toString();
      state).postsRoute = ProfileRoutes.buildPostsRouteWithCount$68d17de5(paramString1).toString();
      state).recentActivityRoute = FeedRouteUtils.getProfileRecentActivityFeedUpdatesRoute(paramString1, 5);
      state).profileActionsRoute = ProfileRoutes.buildTopCardActionsRoute(paramString1).toString();
      state).workWithUsRoute = ProfileRoutes.buildWorkWithUsRoute(paramString1).toString();
      state).allConnectionsRoute = ProfileRoutes.buildAllConnectionsRoute$68d17de5(paramString1).toString();
      state).commonConnectionsRoute = ProfileRoutes.buildMutualConnectionsRoute$68d17de5(paramString1).toString();
      state).contactInfoRoute = ProfileRoutes.buildContactInfoRoute(paramString1).toString();
      state).interestsRoute = ProfileRoutes.buildInterestsRoute(paramString1).toString();
      state).groupsRoute = ProfileRoutes.buildGroupsEntityRoute(paramString1, 3).toString();
      state).profilePromotionsRoute = ProfileRoutes.buildProfilePromotionsRoute(paramString1).toString();
      state).guidedEditCategoriesRoute = Routes.GUIDED_EDIT_FLOWS.buildUponRoot().buildUpon().appendQueryParameter("q", "findRelevantCategories").appendQueryParameter("vieweeMemberIdentity", profileId).build().toString();
      paramDataStoreFilter.optional(Request.get().url(state).guidedEditCategoriesRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(GuidedEditCategory.BUILDER, CollectionMetadata.BUILDER)));
      if (isSelfView())
      {
        state).meHeaderRoute = Routes.ME_FEED_HEADER.buildUponRoot().buildUpon().build().toString();
        paramDataStoreFilter.optional(Request.get().url(state).meHeaderRoute).builder(Header.BUILDER));
      }
      paramDataStoreFilter.optional(Request.get().url(state).networkInfoRoute).builder(ProfileNetworkInfo.BUILDER)).optional(Request.get().url(state).recsGivenRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Recommendation.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).memberBadgesRoute).builder(MemberBadges.BUILDER)).optional(Request.get().url(state).highlightsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Highlight.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).profileActionsRoute).builder(ProfileActions.BUILDER)).optional(Request.get().url(state).recentActivityRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Update.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).postsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Post.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).workWithUsRoute).builder(WWUAd.BUILDER));
      if (!"control".equals(lixManager.getTreatment(Lix.LIX_PROFILE_VIEW_ALL_CONNECTIONS_LOCATION)))
      {
        i = 1;
        if (i != 0) {
          paramDataStoreFilter.optional(Request.get().url(state).allConnectionsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(MemberConnection.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).commonConnectionsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(MemberConnection.BUILDER, CollectionMetadata.BUILDER)));
        }
        if (lixManager.getTreatment(Lix.LIX_PROFILE_VIEW_CONTACT_INFO).equals("enabled")) {
          paramDataStoreFilter.optional(Request.get().url(state).contactInfoRoute).builder(ProfileContactInfo.BUILDER));
        }
        if (!"enabled".equals(lixManager.getTreatment(Lix.LIX_PROFILE_VIEW_ENABLE_INTERESTS_CARD))) {
          break label1280;
        }
        paramDataStoreFilter.optional(Request.get().url(state).interestsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(FollowableEntity.BUILDER, CollectionMetadata.BUILDER)));
        label937:
        if ((!"enabled".equals(lixManager.getTreatment(Lix.PROFILE_ENABLE_PROMOTIONS))) && (!"enabled".equals(lixManager.getTreatment(Lix.PROFILE_PREMIUM_UPSELL_PROMO)))) {
          break label1321;
        }
        i = 1;
        label982:
        if (i != 0) {
          paramDataStoreFilter.optional(Request.get().url(state).profilePromotionsRoute).filter(DataManager.DataStoreFilter.NETWORK_ONLY).builder(new CollectionTemplate.CollectionTemplateJsonParser(ProfilePromotion.BUILDER, CollectionMetadata.BUILDER)));
        }
        if (lixManager.getTreatment(Lix.LIX_PROFILE_VIEW_SUGGESTED_ENDORSEMENT_CARD).equals("enabled")) {
          paramDataStoreFilter.optional(Request.get().url(state).suggestedEndorsementsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(SuggestedEndorsement.BUILDER, SuggestedEndorsementsMetadata.BUILDER)));
        }
        if (!lixManager.getTreatment(Lix.LIX_PROFILE_VIEW_FEATURED_SKILLS_CARD).equals("enabled")) {
          break label1327;
        }
        paramDataStoreFilter.optional(Request.get().url(state).featuredSkillsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER)));
      }
    }
    for (;;)
    {
      state).recsReceivedRoute = ProfileRoutes.buildRecommendationsReceivedRoute(paramString1).toString();
      state).browseMapRoute = ProfileRoutes.buildBrowseMapRoute(paramString1).toString();
      paramDataStoreFilter.optional(Request.get().url(state).recsReceivedRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Recommendation.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).browseMapRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(BrowsemapMiniProfile.BUILDER, CollectionMetadata.BUILDER)));
      addProfileOnlyRequests(paramString1, paramDataStoreFilter);
      performMultiplexedFetch(paramString2, paramString3, paramMap, paramDataStoreFilter);
      return;
      i = 0;
      break;
      label1280:
      paramDataStoreFilter.optional(Request.get().url(state).groupsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(FollowableEntity.BUILDER, CollectionMetadata.BUILDER)));
      break label937;
      label1321:
      i = 0;
      break label982;
      label1327:
      paramDataStoreFilter.optional(Request.get().url(state).endorsedSkillsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER)));
      continue;
      state).sameNameRoute = ProfileRoutes.buildSameNameRoute(paramString1).toString();
      paramDataStoreFilter.optional(Request.get().url(state).sameNameRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(MiniProfile.BUILDER, CollectionMetadata.BUILDER)));
    }
  }
  
  public final void fetchGuidedEditCategories(String paramString1, String paramString2, Map<String, String> paramMap, String paramString3, GuidedEditSource paramGuidedEditSource)
  {
    paramGuidedEditSource = Routes.GUIDED_EDIT_FLOWS.buildUponRoot().buildUpon().appendQueryParameter("q", "findRelevantCategories").appendQueryParameter("contextType", paramGuidedEditSource.name().toLowerCase(java.util.Locale.US));
    if (paramString3 != null) {
      paramGuidedEditSource.appendQueryParameter("vieweeMemberIdentity", paramString3);
    }
    state).guidedEditCategoriesRoute = paramGuidedEditSource.build().toString();
    paramString3 = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    paramString3 = paramString3.filter(DataManager.DataStoreFilter.NETWORK_ONLY);
    paramString3.optional(Request.get().url(state).guidedEditCategoriesRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(GuidedEditCategory.BUILDER, CollectionMetadata.BUILDER)));
    performMultiplexedFetch(paramString1, paramString2, paramMap, paramString3);
  }
  
  public final void fetchMoreEndorsements$1adbc258(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap, int paramInt)
  {
    state).endorsementsRoute = ProfileRoutes.buildSkillEndorsementsRouteWithStartCount$b410f02$359c5360(paramString3, paramString4, paramInt).toString();
    ((ProfileState)state).clearModel(state).endorsementsRoute);
    paramString3 = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    performMultiplexedFetch(paramString1, paramString2, paramMap, paramString3.filter(DataManager.DataStoreFilter.NETWORK_ONLY).required(Request.get().url(state).endorsementsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Endorsement.BUILDER, CollectionMetadata.BUILDER))));
  }
  
  public final void fetchProfileOnlyData(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    addProfileOnlyRequests(paramString3, localBuilder);
    state).allCertificationsRoute = ProfileRoutes.buildCertificationsRoute(paramString3).toString();
    state).allCoursesRoute = ProfileRoutes.buildCoursesRoute(paramString3).toString();
    state).allHonorsRoute = ProfileRoutes.buildHonorsRoute(paramString3).toString();
    state).allPatentsRoute = ProfileRoutes.buildPatentsRoute(paramString3).toString();
    state).allProjectsRoute = ProfileRoutes.buildProjectsRoute(paramString3).toString();
    state).allPublicationsRoute = ProfileRoutes.buildPublicationsRoute(paramString3).toString();
    state).allTestScoresRoute = ProfileRoutes.buildTestScoresRoute(paramString3).toString();
    state).languagesRoute = ProfileRoutes.buildLanguagesRoute(paramString3).toString();
    state).allPositionsRoute = ProfileRoutes.buildPositionsRoute(paramString3).toString();
    state).allEducationsRoute = ProfileRoutes.buildEducationsRoute(paramString3).toString();
    state).allVolunteerExperiencesRoute = ProfileRoutes.buildVolunteerExperiencesRoute(paramString3).toString();
    state).organizationsRoute = ProfileRoutes.buildOrganizationsRoute(paramString3).toString();
    localBuilder.optional(Request.get().url(state).allCertificationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Certification.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).allCoursesRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Course.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).allHonorsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Honor.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).allProjectsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Patent.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).allProjectsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Project.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).allPublicationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Publication.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).allTestScoresRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(TestScore.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).languagesRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Language.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).allPositionsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Position.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).allEducationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Education.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).allVolunteerExperiencesRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(VolunteerExperience.BUILDER, CollectionMetadata.BUILDER))).optional(Request.get().url(state).organizationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Organization.BUILDER, CollectionMetadata.BUILDER)));
    performMultiplexedFetch(paramString1, paramString2, paramMap, localBuilder);
  }
  
  public final void followInfluencer(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    ProfileDataProvider.7 local7 = new ProfileDataProvider.7(this);
    paramString3 = ProfileRoutes.buildFollowActionRoute(paramString3).toString();
    performMultiplexedFetch(paramString1, paramString2, paramMap, newUpdateRequestBuilder().required(Request.post().url(paramString3).model(new JsonModel(new JSONObject())).listener(local7)));
  }
  
  public final void followMember$4543a37c(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Map<String, String> paramMap)
  {
    Object localObject = new ProfileDataProvider.4(this);
    String str = ProfileRoutes.buildFollowActionRoute(paramString3).toString();
    state).profileActionsRoute = ProfileRoutes.buildTopCardActionsRoute(paramString3).toString();
    state).networkInfoRoute = ProfileRoutes.buildNetworkInfoRoute(paramString3).toString();
    localObject = newUpdateRequestBuilder().required(Request.post().url(str).model(new JsonModel(new JSONObject())).listener((RecordTemplateListener)localObject)).optional(Request.get().url(state).profileActionsRoute).builder(ProfileActions.BUILDER));
    if (paramBoolean) {
      ((MultiplexRequest.Builder)localObject).optional(Request.get().url(state).networkInfoRoute).builder(ProfileNetworkInfo.BUILDER));
    }
    for (;;)
    {
      performMultiplexedFetch(paramString1, paramString2, paramMap, (MultiplexRequest.Builder)localObject);
      return;
      if (getNetworkInfoModel() != null) {
        try
        {
          setModifiedNetworkInfoModel(paramString1, OptimisticModelMockUtil.toggleFollowingInfo(getNetworkInfoModel(), paramString3));
        }
        catch (BuilderException paramString3)
        {
          Util.safeThrow$7a8b4789(new RuntimeException("Cannot toggle profile network info"));
        }
      }
    }
  }
  
  public final ProfileActions getActions()
  {
    int i1 = 0;
    verifyDataAvailable("getActions");
    Object localObject1 = (ProfileState)state;
    localObject1 = (ProfileActions)((ProfileState)localObject1).getModel(profileActionsRoute);
    Object localObject2;
    int i;
    int j;
    label140:
    label187:
    label234:
    int n;
    label265:
    label459:
    int k;
    int m;
    if (localObject1 != null)
    {
      localObject2 = profilePendingConnectionRequestManager.getPendingState(profileId);
      if ((localObject2 == ProfilePendingConnectionRequestManager.PendingState.INVITATION_SENT) || (localObject2 == ProfilePendingConnectionRequestManager.PendingState.INVITATION_ACCEPTED) || (localObject2 == ProfilePendingConnectionRequestManager.PendingState.REMOVED_CONNECTION))
      {
        try
        {
          if ((localObject2 != ProfilePendingConnectionRequestManager.PendingState.INVITATION_SENT) || (!hasPrimaryAction) || (primaryAction.action.connectValue == null)) {
            break label801;
          }
          i = 1;
          if ((localObject2 != ProfilePendingConnectionRequestManager.PendingState.INVITATION_SENT) || (!hasSecondaryAction) || (secondaryAction.action.connectValue == null)) {
            break label806;
          }
          j = 1;
          if ((localObject2 != ProfilePendingConnectionRequestManager.PendingState.INVITATION_ACCEPTED) || (!hasPrimaryAction)) {
            break label811;
          }
          if (primaryAction.action.connectValue != null) {
            break label765;
          }
          if (primaryAction.action.acceptValue == null) {
            break label811;
          }
        }
        catch (BuilderException localBuilderException)
        {
          Object localObject3;
          Object localObject4;
          label604:
          Util.safeThrow(new RuntimeException("Error while overriding connect action", localBuilderException));
          return (ProfileActions)localObject1;
        }
        if ((localObject2 != ProfilePendingConnectionRequestManager.PendingState.INVITATION_ACCEPTED) || (!hasSecondaryAction)) {
          break label816;
        }
        if (secondaryAction.action.connectValue == null)
        {
          if (secondaryAction.action.acceptValue == null) {
            break label816;
          }
          break label770;
          if ((localObject2 != ProfilePendingConnectionRequestManager.PendingState.REMOVED_CONNECTION) || (!hasOverflowActions) || (getDisconnectActionIndex((ProfileActions)localObject1) == -1)) {
            break label822;
          }
          n = 1;
          break label776;
          localObject2 = new ProfileActions.Builder((ProfileActions)localObject1);
          if ((i == 0) && (j == 0)) {
            break label828;
          }
          if (i != 0)
          {
            localObject3 = new ProfileAction.Action.Builder(primaryAction.action);
            ((ProfileAction.Action.Builder)localObject3).setConnectValue$e34ab();
            new InvitationPending.Builder();
            ((ProfileAction.Action.Builder)localObject3).setInvitationPendingValue(InvitationPending.Builder.build(RecordTemplate.Flavor.RECORD));
            localObject4 = new ProfileAction.Builder(primaryAction);
            ((ProfileAction.Builder)localObject4).setAction(((ProfileAction.Action.Builder)localObject3).build());
            ((ProfileActions.Builder)localObject2).setPrimaryAction(((ProfileAction.Builder)localObject4).build(RecordTemplate.Flavor.RECORD));
          }
          if (j == 0) {
            break label828;
          }
          localObject3 = new ProfileAction.Action.Builder(secondaryAction.action);
          ((ProfileAction.Action.Builder)localObject3).setConnectValue$e34ab();
          new InvitationPending.Builder();
          ((ProfileAction.Action.Builder)localObject3).setInvitationPendingValue(InvitationPending.Builder.build(RecordTemplate.Flavor.RECORD));
          localObject4 = new ProfileAction.Builder(secondaryAction);
          ((ProfileAction.Builder)localObject4).setAction(((ProfileAction.Action.Builder)localObject3).build());
          ((ProfileActions.Builder)localObject2).setSecondaryAction(((ProfileAction.Builder)localObject4).build(RecordTemplate.Flavor.RECORD));
          break label828;
          if (k != 0)
          {
            localObject3 = new ProfileAction.Action.Builder(primaryAction.action);
            ((ProfileAction.Action.Builder)localObject3).setConnectValue$e34ab();
            ((ProfileAction.Action.Builder)localObject3).setAcceptValue$76e4df49();
            localObject4 = new ProfileAction.Builder(primaryAction);
            ((ProfileAction.Builder)localObject4).setAction(((ProfileAction.Action.Builder)localObject3).build());
            ((ProfileActions.Builder)localObject2).setPrimaryAction(((ProfileAction.Builder)localObject4).build(RecordTemplate.Flavor.RECORD));
          }
          if (m != 0)
          {
            localObject3 = new ProfileAction.Action.Builder(secondaryAction.action);
            ((ProfileAction.Action.Builder)localObject3).setConnectValue$e34ab();
            ((ProfileAction.Action.Builder)localObject3).setAcceptValue$76e4df49();
            localObject4 = new ProfileAction.Builder(secondaryAction);
            ((ProfileAction.Builder)localObject4).setAction(((ProfileAction.Action.Builder)localObject3).build());
            ((ProfileActions.Builder)localObject2).setSecondaryAction(((ProfileAction.Builder)localObject4).build(RecordTemplate.Flavor.RECORD));
          }
          if ((n != 0) && (overflowActions != null))
          {
            localObject3 = new ArrayList(overflowActions.size());
            j = getDisconnectActionIndex((ProfileActions)localObject1);
            i = i1;
          }
        }
      }
    }
    for (;;)
    {
      if (i < overflowActions.size())
      {
        localObject4 = (ProfileAction)overflowActions.get(i);
        if (i != j) {
          ((List)localObject3).add(localObject4);
        }
      }
      else
      {
        if (((List)localObject3).equals(Collections.emptyList())) {
          hasOverflowActions = false;
        }
        for (overflowActions = Collections.emptyList();; overflowActions = ((List)localObject3))
        {
          return ((ProfileActions.Builder)localObject2).build(RecordTemplate.Flavor.RECORD);
          hasOverflowActions = true;
        }
        label765:
        k = 1;
        break label187;
        label770:
        m = 1;
        break label234;
        for (;;)
        {
          label776:
          if ((i != 0) || (j != 0) || (k != 0) || (m != 0) || (n != 0)) {
            break label826;
          }
          return (ProfileActions)localObject1;
          label801:
          i = 0;
          break;
          label806:
          j = 0;
          break label140;
          label811:
          k = 0;
          break label187;
          label816:
          m = 0;
          break label234;
          label822:
          n = 0;
        }
        label826:
        break label265;
        label828:
        if (k != 0) {
          break label459;
        }
        if (m == 0) {
          break label604;
        }
        break label459;
      }
      i += 1;
    }
  }
  
  public final CollectionTemplate<EndorsedSkill, EndorsementsCollectionMetadata> getAllEndorsedSkills()
  {
    verifyDataAvailable("getEndorsedSkills");
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(allEndorsedSkillsRoute);
  }
  
  public final CollectionTemplate<EndorsedSkill, EndorsementsCollectionMetadata> getAllFeaturedSkills()
  {
    verifyDataAvailable("getFeaturedSkills");
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(allFeaturedSkillsRoute);
  }
  
  public final CollectionTemplate<Certification, CollectionMetadata> getCertifications()
  {
    verifyDataAvailable("getCertifications");
    if (profileViewApiEnabled)
    {
      localObject = ((ProfileState)state).profileView();
      if (localObject != null) {
        return new CollectionTemplate(certificationView.elements, null, certificationView.paging, null, null, true, false, true);
      }
      return null;
    }
    Object localObject = (ProfileState)state;
    return (CollectionTemplate)((ProfileState)localObject).getModel(certificationsRoute);
  }
  
  public final ProfileContactInfo getContactInfo()
  {
    verifyDataAvailable("getContactInfo");
    ProfileState localProfileState = (ProfileState)state;
    return (ProfileContactInfo)localProfileState.getModel(contactInfoRoute);
  }
  
  public final void getCountries(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    state).countriesRoute = Routes.COUNTRY.buildUponRoot().toString();
    paramString1 = newModelListener(paramString1, paramString2);
    paramString1 = Request.get().url(state).countriesRoute).customHeaders(paramMap).builder(new CollectionTemplate.CollectionTemplateJsonParser(Country.BUILDER, CollectionMetadata.BUILDER)).listener(paramString1).filter(DataManager.DataStoreFilter.ALL);
    activityComponent.dataManager().submit(paramString1);
  }
  
  public final CollectionTemplate<Course, CollectionMetadata> getCourses()
  {
    verifyDataAvailable("getCourses");
    if (profileViewApiEnabled)
    {
      localObject = ((ProfileState)state).profileView();
      if (localObject != null) {
        return new CollectionTemplate(courseView.elements, null, courseView.paging, null, null, true, false, true);
      }
      return null;
    }
    Object localObject = (ProfileState)state;
    return (CollectionTemplate)((ProfileState)localObject).getModel(coursesRoute);
  }
  
  public final String getCroppedImageUploadSignature()
  {
    return state).croppedImageUploadSignature;
  }
  
  public final MultiplexRequest.Builder getDeleteRequestBuilder(String paramString1, String paramString2, DataRequestWrapper.Builder<?> paramBuilder)
  {
    return getDeleteRequestBuilder(paramString1, paramString2, paramBuilder, false);
  }
  
  public final CollectionTemplate<Education, CollectionMetadata> getEducations()
  {
    verifyDataAvailable("getEducations");
    if (profileViewApiEnabled)
    {
      localObject = ((ProfileState)state).profileView();
      if (localObject != null) {
        return new CollectionTemplate(educationView.elements, null, educationView.paging, null, null, true, false, true);
      }
      return null;
    }
    Object localObject = (ProfileState)state;
    return (CollectionTemplate)((ProfileState)localObject).getModel(educationsRoute);
  }
  
  public final CollectionTemplate<Education, CollectionMetadata> getEducationsForBackgroundDetail()
  {
    if (profileViewApiEnabled) {
      return ((ProfileState)state).allEducations();
    }
    return getEducations();
  }
  
  public final CollectionTemplate<EndorsedSkill, EndorsementsCollectionMetadata> getEndorsedSkills()
  {
    verifyDataAvailable("getEndorsedSkills");
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(endorsedSkillsRoute);
  }
  
  public final CollectionTemplate<EndorsedSkill, EndorsementsCollectionMetadata> getEndorsedSkillsForEdit()
  {
    verifyDataAvailable("getEndorsedSkillsForEdit");
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(endorsedSkillsForEditRoute);
  }
  
  public final CollectionTemplate<EndorsedSkill, EndorsementsCollectionMetadata> getFeaturedSkills()
  {
    verifyDataAvailable("getFeaturedSkills");
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(featuredSkillsRoute);
  }
  
  public final CollectionTemplate<EndorsedSkill, EndorsementsCollectionMetadata> getFeaturedSkillsForEdit()
  {
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(featuredSkillsForEditRoute);
  }
  
  public final CollectionTemplate<FollowableEntity, CollectionMetadata> getFollowedChannels()
  {
    verifyDataAvailable("channels");
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(followedChannelsRoute);
  }
  
  public final CollectionTemplate<FollowableEntity, CollectionMetadata> getFollowedCompanies()
  {
    verifyDataAvailable("companies");
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(followedCompaniesRoute);
  }
  
  public final CollectionTemplate<FollowableEntity, CollectionMetadata> getFollowedInfluencers()
  {
    verifyDataAvailable("influencers");
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(folowedInfluencersRoute);
  }
  
  public final CollectionTemplate<FollowableEntity, CollectionMetadata> getFollowedSchools()
  {
    verifyDataAvailable("schools");
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(followedSchoolsRoute);
  }
  
  public final CollectionTemplate<FollowableEntity, CollectionMetadata> getGroups()
  {
    verifyDataAvailable("getGroups");
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(groupsRoute);
  }
  
  public final CollectionTemplate<GuidedEditCategory, CollectionMetadata> getGuidedEditCategories()
  {
    verifyDataAvailable("getGuidedEditCategories");
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(guidedEditCategoriesRoute);
  }
  
  public final CollectionTemplate<Honor, CollectionMetadata> getHonors()
  {
    verifyDataAvailable("getHonors");
    if (profileViewApiEnabled)
    {
      localObject = ((ProfileState)state).profileView();
      if (localObject != null) {
        return new CollectionTemplate(honorView.elements, null, honorView.paging, null, null, true, false, true);
      }
      return null;
    }
    Object localObject = (ProfileState)state;
    return (CollectionTemplate)((ProfileState)localObject).getModel(honorsRoute);
  }
  
  public final String getMasterImageUploadSignature()
  {
    return state).masterImageUploadSignature;
  }
  
  public final Header getMeHeader()
  {
    verifyDataAvailable("getMeHeader");
    if (((ProfileState)state).meHeader() != null) {
      return ((ProfileState)state).meHeader();
    }
    return null;
  }
  
  public final MemberBadges getMemberBadges()
  {
    verifyDataAvailable("getMemberBadges");
    ProfileState localProfileState = (ProfileState)state;
    return (MemberBadges)localProfileState.getModel(memberBadgesRoute);
  }
  
  public final NormProfile getModifiedNormProfileModel()
  {
    return state).modifiedNormProfile;
  }
  
  public final ProfileNetworkInfo getNetworkInfoModel()
  {
    verifyDataAvailable("getNetworkInfoModel");
    ProfileState localProfileState = (ProfileState)state;
    return (ProfileNetworkInfo)localProfileState.getModel(networkInfoRoute);
  }
  
  public final CollectionTemplate<Patent, CollectionMetadata> getPatents()
  {
    verifyDataAvailable("getPatents");
    if (profileViewApiEnabled)
    {
      localObject = ((ProfileState)state).profileView();
      if (localObject != null) {
        return new CollectionTemplate(patentView.elements, null, patentView.paging, null, null, true, false, true);
      }
      return null;
    }
    Object localObject = (ProfileState)state;
    return (CollectionTemplate)((ProfileState)localObject).getModel(patentsRoute);
  }
  
  public final CollectionTemplate<Position, CollectionMetadata> getPositions()
  {
    verifyDataAvailable("getPositions");
    if (profileViewApiEnabled)
    {
      localObject = ((ProfileState)state).profileView();
      if (localObject != null) {
        return new CollectionTemplate(positionView.elements, null, positionView.paging, null, null, true, false, true);
      }
      return null;
    }
    Object localObject = (ProfileState)state;
    return (CollectionTemplate)((ProfileState)localObject).getModel(positionsRoute);
  }
  
  public final CollectionTemplate<Position, CollectionMetadata> getPositionsForBackgroundDetail()
  {
    if (profileViewApiEnabled) {
      return ((ProfileState)state).allPositions();
    }
    return getPositions();
  }
  
  public final MultiplexRequest.Builder getPostRequestBuilder(String paramString1, String paramString2, RecordTemplate paramRecordTemplate, DataRequestWrapper.Builder<?> paramBuilder)
  {
    return getPostRequestBuilder(paramString1, paramString2, paramRecordTemplate, paramBuilder, false);
  }
  
  public final MultiplexRequest.Builder getPostRequestBuilder(String paramString1, String paramString2, RecordTemplate paramRecordTemplate, DataRequestWrapper.Builder<?> paramBuilder, boolean paramBoolean)
  {
    state).profileViewRoute = ProfileRoutes.buildProfileViewRoute(paramString2).toString();
    state).profileRoute = ProfileRoutes.buildProfileRoute(paramString2).toString();
    paramString1 = newUpdateRequestBuilder().required(Request.post().url(paramString1).model(paramRecordTemplate));
    if (profileViewApiEnabled)
    {
      paramString1.optional(Request.get().url(state).profileViewRoute).builder(ProfileView.BUILDER));
      if (paramBoolean) {
        paramString1.optional(paramBuilder);
      }
      return paramString1;
    }
    paramString1.optional(Request.get().url(state).profileRoute).builder(Profile.BUILDER)).optional(paramBuilder);
    return paramString1;
  }
  
  public final Profile getProfileModel()
  {
    verifyDataAvailable("getProfileModel");
    if (profileViewApiEnabled)
    {
      ProfileView localProfileView = ((ProfileState)state).profileView();
      if (localProfileView != null) {
        return profile;
      }
      return null;
    }
    return ((ProfileState)state).profile();
  }
  
  public final CollectionTemplate<ProfilePromotion, CollectionMetadata> getProfilePromotions()
  {
    verifyDataAvailable("getProfilePromotions");
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(profilePromotionsRoute);
  }
  
  public final String getProfileVersionTag()
  {
    if (profileViewApiEnabled) {
      return state).profileView().profile.versionTag;
    }
    return state).profile().versionTag;
  }
  
  public final CollectionTemplate<Project, CollectionMetadata> getProjects()
  {
    verifyDataAvailable("getProjects");
    if (profileViewApiEnabled)
    {
      localObject = ((ProfileState)state).profileView();
      if (localObject != null) {
        return new CollectionTemplate(projectView.elements, null, projectView.paging, null, null, true, false, true);
      }
      return null;
    }
    Object localObject = (ProfileState)state;
    return (CollectionTemplate)((ProfileState)localObject).getModel(projectsRoute);
  }
  
  public final CollectionTemplate<Publication, CollectionMetadata> getPublications()
  {
    if (profileViewApiEnabled)
    {
      localObject = ((ProfileState)state).profileView();
      if (localObject != null) {
        return new CollectionTemplate(publicationView.elements, null, publicationView.paging, null, null, true, false, true);
      }
      return null;
    }
    Object localObject = (ProfileState)state;
    return (CollectionTemplate)((ProfileState)localObject).getModel(publicationsRoute);
  }
  
  public final CollectionTemplate<Recommendation, CollectionMetadata> getRecommendationsGiven()
  {
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(recsGivenRoute);
  }
  
  public final CollectionTemplate<Recommendation, CollectionMetadata> getRecommendationsReceived()
  {
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(recsReceivedRoute);
  }
  
  public final CollectionTemplate<Endorsement, CollectionMetadata> getSkillEndorsements()
  {
    verifyDataAvailable("getSkillEndorsements");
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(endorsementsRoute);
  }
  
  public final CollectionTemplate<Skill, CollectionMetadata> getSkills()
  {
    verifyDataAvailable("getSkills");
    ProfileState localProfileState = (ProfileState)state;
    return (CollectionTemplate)localProfileState.getModel(skillsRoute);
  }
  
  public final CollectionTemplate<TestScore, CollectionMetadata> getTestScores()
  {
    verifyDataAvailable("getTestScores");
    if (profileViewApiEnabled)
    {
      localObject = ((ProfileState)state).profileView();
      if (localObject != null) {
        return new CollectionTemplate(testScoreView.elements, null, testScoreView.paging, null, null, true, false, true);
      }
      return null;
    }
    Object localObject = (ProfileState)state;
    return (CollectionTemplate)((ProfileState)localObject).getModel(testScoresRoute);
  }
  
  public final CollectionTemplate<VolunteerExperience, CollectionMetadata> getVolunteerExperiences()
  {
    verifyDataAvailable("getVolunteerExperiences");
    if (profileViewApiEnabled)
    {
      localObject = ((ProfileState)state).profileView();
      if (localObject != null) {
        return new CollectionTemplate(volunteerExperienceView.elements, null, volunteerExperienceView.paging, null, null, true, false, true);
      }
      return null;
    }
    Object localObject = (ProfileState)state;
    return (CollectionTemplate)((ProfileState)localObject).getModel(volunteerExperiencesRoute);
  }
  
  public final boolean isDataAvailable()
  {
    if (profileViewApiEnabled) {
      return ((ProfileState)state).profileView() != null;
    }
    return ((ProfileState)state).profile() != null;
  }
  
  public final boolean isSelfView()
  {
    return (profileId != null) && ((memberUtil.isSelf(profileId)) || ("me".equals(profileId)));
  }
  
  public final void loadProfileFromCache(String paramString1, String paramString2, String paramString3)
  {
    MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    localBuilder = localBuilder.filter(DataManager.DataStoreFilter.LOCAL_ONLY);
    addProfileOnlyRequests(paramString3, localBuilder);
    performMultiplexedFetch(paramString1, paramString2, null, localBuilder);
  }
  
  public final void postAcceptAndRejectSuggestedEndorsement(List<String> paramList1, List<String> paramList2)
  {
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray;
    if (!paramList1.isEmpty())
    {
      localJSONArray = new JSONArray();
      try
      {
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext()) {
          localJSONArray.put((String)paramList1.next());
        }
        if (paramList2.isEmpty()) {
          break label140;
        }
      }
      catch (JSONException paramList1)
      {
        Util.safeThrow$7a8b4789(new RuntimeException("Error putting accepted suggested endorsement signatures into JSONObject before posting", paramList1));
      }
    }
    else
    {
      paramList1 = new JSONArray();
      try
      {
        paramList2 = paramList2.iterator();
        while (paramList2.hasNext())
        {
          paramList1.put((String)paramList2.next());
          continue;
          paramList1 = Request.post().url(ProfileRoutes.buildSuggestedEndorsementsAcceptAndRejectRoute().toString()).model(new JsonModel(localJSONObject));
        }
      }
      catch (JSONException paramList1)
      {
        Util.safeThrow$7a8b4789(new RuntimeException("Error putting rejected suggested endorsement signatures into JSONObject before posting", paramList1));
      }
    }
    for (;;)
    {
      label140:
      activityComponent.dataManager().submit(paramList1);
      return;
      localJSONObject.put("acceptSignatures", localJSONArray);
      break;
      localJSONObject.put("dismissSignatures", paramList1);
    }
  }
  
  public final void postAddEducation(String paramString1, String paramString2, String paramString3, NormEducation paramNormEducation, String paramString4, Map<String, String> paramMap)
  {
    paramString4 = ProfileRoutes.buildAddEntityRoute("normEducations", paramString3, paramString4).toString();
    state).educationsRoute = ProfileRoutes.buildEducationsRoute(paramString3).toString();
    state).allEducationsRoute = state).educationsRoute;
    performMultiplexedFetch(paramString1, paramString2, paramMap, getPostRequestBuilder(paramString4, paramString3, paramNormEducation, Request.get().url(state).educationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Education.BUILDER, CollectionMetadata.BUILDER)), true));
  }
  
  public final void postAddEndorsementDetail(String paramString1, String paramString2, String paramString3, NormEndorsement paramNormEndorsement, Map<String, String> paramMap)
  {
    String str = ProfileRoutes.buildCreateEndorsementRoute(paramString3).toString();
    state).allEndorsedSkillsRoute = ProfileRoutes.buildEndorsedSkillsRouteWithCount$68d17de5(paramString3).toString();
    state).endorsementsRoute = ProfileRoutes.buildSkillEndorsementsRoute(paramString3, skill.name).toString();
    ((ProfileState)state).clearModel(state).endorsementsRoute);
    performMultiplexedFetch(paramString1, paramString2, paramMap, newUpdateRequestBuilder().required(Request.post().url(str).model(paramNormEndorsement)).optional(Request.get().url(state).allEndorsedSkillsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER))).optional(Request.get().url(state).endorsementsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Endorsement.BUILDER, CollectionMetadata.BUILDER))));
  }
  
  public final void postAddEndorsementDetailFeaturedSkill(String paramString1, String paramString2, String paramString3, NormEndorsement paramNormEndorsement, Map<String, String> paramMap)
  {
    String str = ProfileRoutes.buildCreateEndorsementRoute(paramString3).toString();
    state).allFeaturedSkillsRoute = ProfileRoutes.buildFeaturedSkillsRouteWithCount$68d17de5(paramString3).toString();
    state).endorsementsRoute = ProfileRoutes.buildSkillEndorsementsRoute(paramString3, skill.name).toString();
    ((ProfileState)state).clearModel(state).endorsementsRoute);
    performMultiplexedFetch(paramString1, paramString2, paramMap, newUpdateRequestBuilder().required(Request.post().url(str).model(paramNormEndorsement)).optional(Request.get().url(state).allFeaturedSkillsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER))).optional(Request.get().url(state).endorsementsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Endorsement.BUILDER, CollectionMetadata.BUILDER))));
  }
  
  public final void postAddPosition(String paramString1, String paramString2, String paramString3, NormPosition paramNormPosition, String paramString4, Map<String, String> paramMap)
  {
    paramString4 = ProfileRoutes.buildAddEntityRoute("normPositions", paramString3, paramString4).toString();
    state).positionsRoute = ProfileRoutes.buildPositionsRoute(paramString3).toString();
    state).allPositionsRoute = state).positionsRoute;
    performMultiplexedFetch(paramString1, paramString2, paramMap, getPostRequestBuilder(paramString4, paramString3, paramNormPosition, Request.get().url(state).positionsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Position.BUILDER, CollectionMetadata.BUILDER)), true));
  }
  
  public final void postPartialUpdateTopCard(String paramString1, String paramString2, String paramString3, JsonModel paramJsonModel, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, Map<String, String> paramMap)
  {
    paramString3 = ProfileRoutes.buildEditTopCardPartialUpdateRoute(paramString3, paramString4, paramString5, paramString6, paramString7, paramString8).toString();
    paramString3 = newUpdateRequestBuilder().required(Request.post().url(paramString3).model(paramJsonModel));
    fetchProfile(paramString3);
    fetchEducation(paramString3);
    fetchPosition(paramString3);
    performMultiplexedFetch(paramString1, paramString2, paramMap, paramString3);
  }
  
  public final void postUpdateEducation(String paramString1, String paramString2, String paramString3, JsonModel paramJsonModel, String paramString4, String paramString5, Map<String, String> paramMap)
  {
    paramString4 = ProfileRoutes.buildEditEntityRoute("normEducations", paramString3, paramString4, paramString5).toString();
    state).educationsRoute = ProfileRoutes.buildEducationsRoute(paramString3).toString();
    state).allEducationsRoute = state).educationsRoute;
    performMultiplexedFetch(paramString1, paramString2, paramMap, getPostRequestBuilder(paramString4, paramString3, paramJsonModel, Request.get().url(state).educationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Education.BUILDER, CollectionMetadata.BUILDER)), true));
  }
  
  public final void postUpdatePosition(String paramString1, String paramString2, String paramString3, JsonModel paramJsonModel, String paramString4, String paramString5, Map<String, String> paramMap)
  {
    paramString4 = ProfileRoutes.buildEditEntityRoute("normPositions", paramString3, paramString4, paramString5).toString();
    state).positionsRoute = ProfileRoutes.buildPositionsRoute(paramString3).toString();
    state).allPositionsRoute = state).positionsRoute;
    performMultiplexedFetch(paramString1, paramString2, paramMap, getPostRequestBuilder(paramString4, paramString3, paramJsonModel, Request.get().url(state).positionsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Position.BUILDER, CollectionMetadata.BUILDER)), true));
  }
  
  public final void postUpdateProfilePicture(String paramString1, String paramString2, String paramString3, NormProfile paramNormProfile1, NormProfile paramNormProfile2, String paramString4, Map<String, String> paramMap)
  {
    if (!"control".equals(activityComponent.lixManager().getTreatment(Lix.PROFILE_EDIT_TOPCARD_PARTIAL_UPDATE))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      try
      {
        paramNormProfile1 = PegasusPatchGenerator.INSTANCE.diff(paramNormProfile1, paramNormProfile2);
        if ((paramNormProfile1 == null) || (paramNormProfile1.length() <= 0)) {
          break label217;
        }
        postPartialUpdateTopCard(paramString1, paramString2, paramString3, new JsonModel(paramNormProfile1), paramString4, null, null, getMasterImageUploadSignature(), getCroppedImageUploadSignature(), paramMap);
        return;
      }
      catch (JSONException paramString1)
      {
        Util.safeThrow(new RuntimeException("Failed to generate diff for update: " + paramString1.getMessage()));
      }
      paramNormProfile1 = new JSONObject();
      paramNormProfile2 = PegasusPatchGenerator.modelToJSON(paramNormProfile2);
      if (paramNormProfile2 != null) {
        paramNormProfile1.put("updatedProfile", paramNormProfile2);
      }
      if (paramNormProfile1.length() > 0)
      {
        paramNormProfile1.put("versionTag", paramString4);
        paramNormProfile1.put("masterProfilePhotoSignature", getMasterImageUploadSignature());
        paramNormProfile1.put("croppedProfilePhotoSignature", getCroppedImageUploadSignature());
        postUpdateTopCard(paramString1, paramString2, paramString3, new JsonModel(paramNormProfile1), paramMap);
        return;
      }
      label217:
      return;
    }
  }
  
  public final void postUpdateTopCard(String paramString1, String paramString2, String paramString3, JsonModel paramJsonModel, Map<String, String> paramMap)
  {
    paramString3 = ProfileRoutes.buildEditTopCardRoute(paramString3).toString();
    paramString3 = newUpdateRequestBuilder().required(Request.post().url(paramString3).model(paramJsonModel));
    fetchProfile(paramString3);
    fetchEducation(paramString3);
    fetchPosition(paramString3);
    performMultiplexedFetch(paramString1, paramString2, paramMap, paramString3);
  }
  
  public final void postUpdateWithTreasuries(String paramString1, String paramString2, String paramString3, JsonModel paramJsonModel, List<TreasuryMedia> paramList1, Map<String, JsonModel> paramMap, List<TreasuryMedia> paramList2, Urn paramUrn, String paramString4, int paramInt, Map<String, String> paramMap1)
    throws JSONException
  {
    if (paramInt == 2) {}
    for (String str = "normPositions";; str = "normEducations")
    {
      str = ProfileRoutes.buildEditEntityRoute(str, paramString3, paramUrn.getLastId(), paramString4).toString();
      paramString4 = newUpdateRequestBuilder();
      if ((jsonObject.length() > 0) && (str != null)) {
        paramString4.required(Request.post().url(str).model(paramJsonModel));
      }
      paramJsonModel = paramList1.iterator();
      while (paramJsonModel.hasNext())
      {
        paramList1 = (TreasuryMedia)paramJsonModel.next();
        str = ProfileRoutes.buildTreasuryCreateRouteForEntity(paramString3, paramUrn).toString();
        paramString4.required(Request.post().url(str).model(paramList1));
      }
    }
    paramJsonModel = paramMap.keySet().iterator();
    while (paramJsonModel.hasNext())
    {
      paramList1 = (String)paramJsonModel.next();
      paramUrn = ProfileRoutes.buildTreasuryEditRouteForEntity(paramString3, paramList1).toString();
      paramString4.required(Request.post().url(paramUrn).model((RecordTemplate)paramMap.get(paramList1)));
    }
    paramJsonModel = paramList2.iterator();
    while (paramJsonModel.hasNext())
    {
      paramList1 = ProfileRoutes.buildTreasuryEditRouteForEntity(paramString3, nextentityUrn.getLastId()).toString();
      paramString4.required(Request.delete().url(paramList1));
    }
    fetchProfile(paramString4);
    if (paramInt == 2)
    {
      fetchPosition(paramString4);
      state).positionSectionTreasuryMedia = ProfileRoutes.buildTreasuryMediaItemsRouteForPosition(paramString3).toString();
      paramString4.optional(Request.get().url(state).positionSectionTreasuryMedia).builder(new CollectionTemplate.CollectionTemplateJsonParser(TreasuryMediaItems.BUILDER, CollectionMetadata.BUILDER)));
    }
    for (;;)
    {
      performMultiplexedFetch(paramString1, paramString2, paramMap1, paramString4);
      return;
      if (paramInt == 3)
      {
        fetchEducation(paramString4);
        state).educationSectionTreasuryMedia = ProfileRoutes.buildTreasuryMediaItemsRouteForEducation(paramString3).toString();
        paramString4.optional(Request.get().url(state).educationSectionTreasuryMedia).builder(new CollectionTemplate.CollectionTemplateJsonParser(TreasuryMediaItems.BUILDER, CollectionMetadata.BUILDER)));
      }
    }
  }
  
  public final void sendConnectInvitation(String paramString1, String paramString2, String paramString3, FragmentComponent paramFragmentComponent)
  {
    fireSendInvitationRequest(paramString1, paramString2, paramString3, paramFragmentComponent, new ProfileDataProvider.1(this, paramString1, paramFragmentComponent));
  }
  
  public final void sendConnectInvitationAsync(MiniProfile paramMiniProfile, String paramString1, String paramString2, FragmentComponent paramFragmentComponent)
  {
    fireSendInvitationRequest(entityUrn.getId(), paramString1, paramString2, paramFragmentComponent, null);
    paramMiniProfile = new HeathrowRoutingIntentBundle().miniProfile(paramMiniProfile).heathrowSource(HeathrowSource.PROFILE_CONNECT);
    paramFragmentComponent.activity().startActivity(intentRegistryheathrowIntent.newIntent(paramFragmentComponent.activity(), paramMiniProfile));
  }
  
  public final void setCroppedImageId(String paramString)
  {
    state).croppedImageId = paramString;
  }
  
  public final void setCroppedImageUploadSignature(String paramString)
  {
    state).croppedImageUploadSignature = paramString;
  }
  
  public final void setMasterImageId(String paramString)
  {
    state).masterImageId = paramString;
  }
  
  public final void setMasterImageUploadSignature(String paramString)
  {
    state).masterImageUploadSignature = paramString;
  }
  
  public final void setModifiedNormProfileModel(NormProfile paramNormProfile)
  {
    state).modifiedNormProfile = paramNormProfile;
  }
  
  public final void unFollowInfluencer(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    ProfileDataProvider.6 local6 = new ProfileDataProvider.6(this);
    paramString3 = ProfileRoutes.buildUnfollowActionRoute(paramString3).toString();
    performMultiplexedFetch(paramString1, paramString2, paramMap, newUpdateRequestBuilder().required(Request.post().url(paramString3).model(new JsonModel(new JSONObject())).listener(local6)));
  }
  
  public final void unFollowMember$4543a37c(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Map<String, String> paramMap)
  {
    Object localObject = new ProfileDataProvider.5(this);
    String str = ProfileRoutes.buildUnfollowActionRoute(paramString3).toString();
    state).profileActionsRoute = ProfileRoutes.buildTopCardActionsRoute(paramString3).toString();
    state).networkInfoRoute = ProfileRoutes.buildNetworkInfoRoute(paramString3).toString();
    localObject = newUpdateRequestBuilder().required(Request.post().url(str).model(new JsonModel(new JSONObject())).listener((RecordTemplateListener)localObject)).optional(Request.get().url(state).profileActionsRoute).builder(ProfileActions.BUILDER));
    if (paramBoolean) {
      ((MultiplexRequest.Builder)localObject).optional(Request.get().url(state).networkInfoRoute).builder(ProfileNetworkInfo.BUILDER));
    }
    for (;;)
    {
      performMultiplexedFetch(paramString1, paramString2, paramMap, (MultiplexRequest.Builder)localObject);
      return;
      if (getNetworkInfoModel() != null) {
        try
        {
          setModifiedNetworkInfoModel(paramString1, OptimisticModelMockUtil.toggleFollowingInfo(getNetworkInfoModel(), paramString3));
        }
        catch (BuilderException paramString3)
        {
          Util.safeThrow$7a8b4789(new RuntimeException("Cannot toggle profile network info"));
        }
      }
    }
  }
  
  public final void verifyDataAvailable(String paramString)
  {
    if (!isDataAvailable()) {
      Util.safeThrow(new RuntimeException(paramString + " should not be called before data is available"));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.ProfileDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */