package com.linkedin.android.identity.profile;

import android.net.Uri;
import android.os.Bundle;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.heathrow.HeathrowIntent;
import com.linkedin.android.growth.heathrow.HeathrowRoutingIntentBundle;
import com.linkedin.android.growth.heathrow.HeathrowSource;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager.PendingState;
import com.linkedin.android.identity.profile.view.custominvite.CustomInviteBundleBuilder;
import com.linkedin.android.identity.profile.view.custominvite.CustomInviteFragment;
import com.linkedin.android.identity.profile.view.featuredskills.details.EndorseFeaturedSkillEvent;
import com.linkedin.android.identity.profile.view.featuredskills.details.UnendorseFeaturedSkillEvent;
import com.linkedin.android.identity.profile.view.promotion.PremiumPromoUpsellEvent;
import com.linkedin.android.identity.profile.view.skills.details.EndorseSkillEvent;
import com.linkedin.android.identity.profile.view.skills.details.UnendorseSkillEvent;
import com.linkedin.android.identity.profile.view.suggestedendorsement.details.SuggestedEndorsementAcceptEvent;
import com.linkedin.android.identity.profile.view.suggestedendorsement.details.SuggestedEndorsementRejectEvent;
import com.linkedin.android.identity.profile.view.topcard.events.AcceptInvitationEvent;
import com.linkedin.android.identity.profile.view.topcard.events.CustomizeInviteEvent;
import com.linkedin.android.identity.profile.view.topcard.events.DisconnectEvent;
import com.linkedin.android.identity.profile.view.topcard.events.ProfileFollowEvent;
import com.linkedin.android.identity.profile.view.topcard.events.ProfileMessageEvent;
import com.linkedin.android.identity.profile.view.topcard.events.ProfileReportEvent;
import com.linkedin.android.identity.profile.view.topcard.events.ProfileReportResponseListener;
import com.linkedin.android.identity.profile.view.topcard.events.SendInMailEvent;
import com.linkedin.android.identity.profile.view.topcard.events.SendInvitationEvent;
import com.linkedin.android.identity.profile.view.topcard.events.ShareProfileEvent;
import com.linkedin.android.identity.profile.view.topcard.events.UnfollowEvent;
import com.linkedin.android.identity.shared.ProfileBaseFragment;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.semaphore.ReportEntityInvokerHelper;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.messaging.compose.InmailComposeBundleBuilder;
import com.linkedin.android.messaging.compose.InmailComposeIntent;
import com.linkedin.android.messaging.integration.MessagingOpenerUtils;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsementsCollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEndorsement;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEndorsement.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.actions.ProfileActions;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel;
import com.linkedin.android.premium.PremiumActivityBundleBuilder;
import com.linkedin.android.premium.PremiumActivityIntent;
import com.linkedin.android.relationships.RelationshipsSecondaryActivity;
import com.linkedin.android.relationships.shared.RelationshipsRequestHelper;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent.Type;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.invitations.FlowType;
import com.linkedin.gen.avro2pegasus.events.invitations.InvitationClickEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.invitations.InvitationTargetType;
import com.linkedin.gen.avro2pegasus.events.invitations.InvitationTrackingInfo.Builder;
import com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellImpressionEvent.Builder;
import com.linkedin.security.android.ContentSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

public abstract class ProfileActionHandlerFragment
  extends ProfileBaseFragment
{
  protected boolean reloadProfileViewData;
  
  public void doPause()
  {
    super.doPause();
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
  }
  
  public void doResume()
  {
    super.doResume();
    fragmentComponent.eventBus();
    Bus.subscribe(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    reloadProfileViewData = getArguments().getBoolean("shouldLoadProfileViewData");
  }
  
  @Subscribe
  public void onEvent(EndorseFeaturedSkillEvent paramEndorseFeaturedSkillEvent)
    throws BuilderException
  {
    long l = fragmentComponent.memberUtil().getMemberId();
    if (l == -1L) {
      return;
    }
    Object localObject1 = Urn.createFromTuple("member", new Object[] { Long.valueOf(l) });
    Object localObject2 = Urn.createFromTuple("member", new Object[] { endorseeProfileId });
    localObject1 = new NormEndorsement.Builder().setSkill(endorsedSkill.skill).setEndorserUrn((Urn)localObject1).setEndorseeUrn((Urn)localObject2).build(RecordTemplate.Flavor.RECORD);
    localObject2 = profileDataProvider;
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    paramEndorseFeaturedSkillEvent = endorseeProfileId;
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    String str3 = ProfileRoutes.buildCreateEndorsementRoute(paramEndorseFeaturedSkillEvent).toString();
    state).featuredSkillsRoute = ProfileRoutes.buildFeaturedSkillsRoute(paramEndorseFeaturedSkillEvent).toString();
    state).endorsementsRoute = ProfileRoutes.buildSkillEndorsementsRoute(paramEndorseFeaturedSkillEvent, skill.name).toString();
    ((ProfileState)state).clearModel(state).endorsementsRoute);
    ((ProfileDataProvider)localObject2).performMultiplexedFetch(str1, str2, localMap, ProfileDataProvider.newUpdateRequestBuilder().required(Request.post().url(str3).model((RecordTemplate)localObject1)).optional(Request.get().url(state).featuredSkillsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER))).optional(Request.get().url(state).endorsementsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Endorsement.BUILDER, CollectionMetadata.BUILDER))));
  }
  
  @Subscribe
  public void onEvent(UnendorseFeaturedSkillEvent paramUnendorseFeaturedSkillEvent)
  {
    ProfileDataProvider localProfileDataProvider = profileDataProvider;
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    String str3 = endorseeProfileId;
    Object localObject = endorsementId;
    paramUnendorseFeaturedSkillEvent = skillName;
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    localObject = ProfileRoutes.buildDeleteEndorsementRoute(str3, (String)localObject).toString();
    state).featuredSkillsRoute = ProfileRoutes.buildFeaturedSkillsRoute(str3).toString();
    localObject = ProfileDataProvider.newUpdateRequestBuilder().required(Request.delete().url((String)localObject)).optional(Request.get().url(state).featuredSkillsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER)));
    if (paramUnendorseFeaturedSkillEvent != null)
    {
      state).endorsementsRoute = ProfileRoutes.buildSkillEndorsementsRoute(str3, paramUnendorseFeaturedSkillEvent).toString();
      ((ProfileState)state).clearModel(state).endorsementsRoute);
      ((MultiplexRequest.Builder)localObject).optional(Request.get().url(state).endorsementsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Endorsement.BUILDER, CollectionMetadata.BUILDER)));
    }
    localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, (MultiplexRequest.Builder)localObject);
  }
  
  @Subscribe
  public void onEvent(PremiumPromoUpsellEvent paramPremiumPromoUpsellEvent)
  {
    paramPremiumPromoUpsellEvent = Urn.createFromTuple("control", new Object[] { "premium_open_profile_upsell" });
    tracker.send(new PremiumUpsellImpressionEvent.Builder().setUpsellControlUrn(paramPremiumPromoUpsellEvent.toString()));
    paramPremiumPromoUpsellEvent = new PremiumActivityBundleBuilder().setFromChannel(PremiumUpsellChannel.PROFILE).setUpsellTrackingCode(paramPremiumPromoUpsellEvent);
    startActivity(fragmentComponent.intentRegistry().chooser.newIntent(getActivity(), paramPremiumPromoUpsellEvent));
  }
  
  @Subscribe
  public void onEvent(EndorseSkillEvent paramEndorseSkillEvent)
    throws BuilderException
  {
    Object localObject1 = Urn.createFromTuple("member", new Object[] { Long.valueOf(fragmentComponent.memberUtil().getMemberId()) });
    Object localObject2 = Urn.createFromTuple("member", new Object[] { endorseeProfileId });
    localObject1 = new NormEndorsement.Builder().setSkill(endorsedSkill.skill).setEndorserUrn((Urn)localObject1).setEndorseeUrn((Urn)localObject2).build(RecordTemplate.Flavor.RECORD);
    localObject2 = profileDataProvider;
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    paramEndorseSkillEvent = endorseeProfileId;
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    String str3 = ProfileRoutes.buildCreateEndorsementRoute(paramEndorseSkillEvent).toString();
    state).endorsedSkillsRoute = ProfileRoutes.buildEndorsedSkillsRoute(paramEndorseSkillEvent).toString();
    state).endorsementsRoute = ProfileRoutes.buildSkillEndorsementsRoute(paramEndorseSkillEvent, skill.name).toString();
    ((ProfileState)state).clearModel(state).endorsementsRoute);
    ((ProfileDataProvider)localObject2).performMultiplexedFetch(str1, str2, localMap, ProfileDataProvider.newUpdateRequestBuilder().required(Request.post().url(str3).model((RecordTemplate)localObject1)).optional(Request.get().url(state).endorsedSkillsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER))).optional(Request.get().url(state).endorsementsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Endorsement.BUILDER, CollectionMetadata.BUILDER))));
  }
  
  @Subscribe
  public void onEvent(UnendorseSkillEvent paramUnendorseSkillEvent)
  {
    ProfileDataProvider localProfileDataProvider = profileDataProvider;
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    String str3 = endorseeProfileId;
    Object localObject = endorsementId;
    paramUnendorseSkillEvent = skillName;
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    localObject = ProfileRoutes.buildDeleteEndorsementRoute(str3, (String)localObject).toString();
    state).endorsedSkillsRoute = ProfileRoutes.buildEndorsedSkillsRoute(str3).toString();
    localObject = ProfileDataProvider.newUpdateRequestBuilder().required(Request.delete().url((String)localObject)).optional(Request.get().url(state).endorsedSkillsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER)));
    if (paramUnendorseSkillEvent != null)
    {
      state).endorsementsRoute = ProfileRoutes.buildSkillEndorsementsRoute(str3, paramUnendorseSkillEvent).toString();
      ((ProfileState)state).clearModel(state).endorsementsRoute);
      ((MultiplexRequest.Builder)localObject).optional(Request.get().url(state).endorsementsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Endorsement.BUILDER, CollectionMetadata.BUILDER)));
    }
    localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, (MultiplexRequest.Builder)localObject);
  }
  
  @Subscribe
  public void onEvent(SuggestedEndorsementAcceptEvent paramSuggestedEndorsementAcceptEvent)
    throws IOException
  {
    profileDataProvider.postAcceptAndRejectSuggestedEndorsement(signatures, Collections.emptyList());
  }
  
  @Subscribe
  public void onEvent(SuggestedEndorsementRejectEvent paramSuggestedEndorsementRejectEvent)
  {
    profileDataProvider.postAcceptAndRejectSuggestedEndorsement(Collections.emptyList(), signatures);
  }
  
  @Subscribe
  public void onEvent(AcceptInvitationEvent paramAcceptInvitationEvent)
  {
    if (profileId != null)
    {
      reloadProfileViewData = true;
      Object localObject1 = profileDataProvider;
      MiniProfile localMiniProfile = fromMiniProfile;
      String str1 = getRumSessionId();
      Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
      paramAcceptInvitationEvent = fragmentComponent;
      String str2 = entityUrn.getId();
      Object localObject2 = new ProfileDataProvider.3((ProfileDataProvider)localObject1, str2);
      localObject2 = RelationshipsRequestHelper.makeAcceptByInviteeRequest(str2).filter(DataManager.DataStoreFilter.NETWORK_ONLY).listener((RecordTemplateListener)localObject2);
      ((Request.Builder)localObject2).customHeaders(localMap);
      if (str1 != null) {
        ((Request.Builder)localObject2).trackingSessionId(str1);
      }
      activityComponent.dataManager().submit((Request.Builder)localObject2);
      paramAcceptInvitationEvent.eventBus();
      Bus.publish(new InvitationUpdatedEvent(str2, InvitationUpdatedEvent.Type.ACCEPT));
      profilePendingConnectionRequestManager.setPendingState(str2, ProfilePendingConnectionRequestManager.PendingState.INVITATION_ACCEPTED);
      if (!"control".equals(paramAcceptInvitationEvent.lixManager().getTreatment(Lix.LIX_HEATHROW_PROFILE_ACCEPT_INVITE)))
      {
        localObject1 = new HeathrowRoutingIntentBundle().miniProfile(localMiniProfile).heathrowSource(HeathrowSource.PROFILE_ACCEPTINVITE);
        paramAcceptInvitationEvent.activity().startActivity(intentRegistryheathrowIntent.newIntent(paramAcceptInvitationEvent.activity(), (BundleBuilder)localObject1));
        return;
      }
      RelationshipsSecondaryActivity.openConnectFlowPage(paramAcceptInvitationEvent, str2, 1);
      return;
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("Cannot accept invitation. Profile ID is null"));
  }
  
  @Subscribe
  public void onEvent(CustomizeInviteEvent paramCustomizeInviteEvent)
  {
    ProfileViewActivity localProfileViewActivity = (ProfileViewActivity)fragmentComponent.activity();
    paramCustomizeInviteEvent = profileId;
    CustomInviteBundleBuilder localCustomInviteBundleBuilder = new CustomInviteBundleBuilder();
    bundle.putString("profileId", paramCustomizeInviteEvent);
    localProfileViewActivity.startDetailFragment(CustomInviteFragment.newInstance(localCustomInviteBundleBuilder));
  }
  
  @Subscribe
  public void onEvent(DisconnectEvent paramDisconnectEvent)
  {
    if (profileId != null)
    {
      paramDisconnectEvent = profileDataProvider;
      String str1 = busSubscriberId;
      String str2 = getRumSessionId();
      String str3 = profileId;
      Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
      ProfileDataProvider.2 local2 = new ProfileDataProvider.2(paramDisconnectEvent);
      String str4 = ProfileRoutes.buildDisconnectActionRoute(str3).toString();
      state).profileActionsRoute = ProfileRoutes.buildTopCardActionsRoute(str3).toString();
      paramDisconnectEvent.performMultiplexedFetch(str1, str2, localMap, ProfileDataProvider.newUpdateRequestBuilder().required(Request.post().url(str4).model(new JsonModel(new JSONObject())).listener(local2)).optional(Request.get().url(state).profileActionsRoute).builder(ProfileActions.BUILDER)));
      profilePendingConnectionRequestManager.setPendingState(str3, ProfilePendingConnectionRequestManager.PendingState.REMOVED_CONNECTION);
      return;
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("Cannot disconnect. Profile ID null"));
  }
  
  @Subscribe
  public void onEvent(ProfileFollowEvent paramProfileFollowEvent)
  {
    if (profileId != null)
    {
      ProfileDataProvider localProfileDataProvider = profileDataProvider;
      String str1 = busSubscriberId;
      String str2 = getRumSessionId();
      String str3 = profileId;
      boolean bool = fetchNetworkInfo;
      paramProfileFollowEvent = Tracker.createPageInstanceHeader(getPageInstance());
      getContext();
      localProfileDataProvider.followMember$4543a37c(str1, str2, str3, bool, paramProfileFollowEvent);
      return;
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("Cannot follow. Profile ID null"));
  }
  
  @Subscribe
  public void onEvent(ProfileMessageEvent paramProfileMessageEvent)
  {
    MessagingOpenerUtils.openCompose(fragmentComponent.activity(), fragmentComponent.intentRegistry(), new MiniProfile[] { miniProfile }, "");
  }
  
  @Subscribe
  public void onEvent(ProfileReportEvent paramProfileReportEvent)
  {
    if (reporteeUrn != null) {
      fragmentComponent.reportEntityInvokerHelper().invokeFlow(fragmentComponent, new ProfileReportResponseListener(fragmentComponent), ContentSource.PROFILE, reporteeUrn.toString(), null, reporteeUrn.toString());
    }
  }
  
  @Subscribe
  public void onEvent(SendInMailEvent paramSendInMailEvent)
  {
    if (upsell)
    {
      InmailComposeBundleBuilder localInmailComposeBundleBuilder = new InmailComposeBundleBuilder();
      localInmailComposeBundleBuilder.setRecipientProfile(miniProfile);
      localInmailComposeBundleBuilder.setRecipientIsOpenLink(openLink);
      paramSendInMailEvent = fragmentComponent.intentRegistry().inmailComposeIntent.newIntent(fragmentComponent.activity(), localInmailComposeBundleBuilder);
      paramSendInMailEvent = new PremiumActivityBundleBuilder().setFromChannel(PremiumUpsellChannel.INMAIL).setUpsellTrackingCode(Urn.createFromTuple("control", new Object[] { "premium_inmail_upsell" })).setNextActivity(paramSendInMailEvent);
      startActivity(fragmentComponent.intentRegistry().chooser.newIntent(getActivity(), paramSendInMailEvent));
      return;
    }
    MessagingOpenerUtils.openInmailCompose(fragmentComponent.activity(), fragmentComponent.intentRegistry(), openLink, miniProfile);
  }
  
  @Subscribe
  public void onEvent(SendInvitationEvent paramSendInvitationEvent)
  {
    FragmentComponent localFragmentComponent;
    if (invitationSource == 1) {
      if (fragmentComponent.lixManager().getTreatment(Lix.LIX_DISABLE_INVITATION_CLICK_EVENT).equals("control"))
      {
        localFragmentComponent = fragmentComponent;
        localObject1 = null;
      }
    }
    try
    {
      localObject2 = new InvitationTrackingInfo.Builder().setInvitationTrackingId(trackingId).setRecipientUrn(entityUrnString).build(RecordTemplate.Flavor.RECORD);
      localObject1 = localObject2;
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        Object localObject2;
        Util.safeThrow(new RuntimeException("Failed to create invitationTrackingInfo", localBuilderException));
      }
      profileDataProvider.sendConnectInvitation(profileId, trackingId, message, fragmentComponent);
    }
    localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    Object localObject1 = new InvitationClickEvent.Builder();
    ((InvitationClickEvent.Builder)localObject1).setProduct("profile").setSubproduct("mobile-voyager-primary").setInvitationType(InvitationTargetType.MEMBER).setInvitationTrackingInfo((List)localObject2).setFlow(FlowType.INVITATION);
    localFragmentComponent.tracker().send((TrackingEventBuilder)localObject1);
    if (!"control".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.LIX_HEATHROW_PROFILE_CONNECT)))
    {
      profileDataProvider.sendConnectInvitationAsync(miniProfile, trackingId, message, fragmentComponent);
      return;
    }
  }
  
  @Subscribe
  public void onEvent(ShareProfileEvent paramShareProfileEvent)
  {
    BaseActivity localBaseActivity = fragmentComponent.activity();
    IntentRegistry localIntentRegistry = fragmentComponent.intentRegistry();
    paramShareProfileEvent = shareProfileMessage;
    MessagingOpenerUtils.openCompose(localBaseActivity, localIntentRegistry, new MiniProfile[0], paramShareProfileEvent);
  }
  
  @Subscribe
  public void onEvent(UnfollowEvent paramUnfollowEvent)
  {
    if (profileId != null)
    {
      ProfileDataProvider localProfileDataProvider = profileDataProvider;
      String str1 = busSubscriberId;
      String str2 = getRumSessionId();
      String str3 = profileId;
      boolean bool = fetchNetworkInfo;
      paramUnfollowEvent = Tracker.createPageInstanceHeader(getPageInstance());
      getContext();
      localProfileDataProvider.unFollowMember$4543a37c(str1, str2, str3, bool, paramUnfollowEvent);
      return;
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("Cannot unfollow. Profile ID null"));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.ProfileActionHandlerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */