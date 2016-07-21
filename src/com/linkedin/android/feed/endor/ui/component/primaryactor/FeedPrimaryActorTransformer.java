package com.linkedin.android.feed.endor.ui.component.primaryactor;

import com.linkedin.CrossPromoLib.utils.Utils;
import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.AppActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.CompanyActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.MemberActorDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.ActorUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.FollowRecommendationUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ChannelSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.LyndaSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.MentionedInNewsUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ReshareSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ViralSingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.endor.ui.component.primaryactor.layouts.FeedListPrimaryActorLayout;
import com.linkedin.android.feed.endor.ui.component.primaryactor.layouts.FeedPrimaryActorLayout;
import com.linkedin.android.feed.endor.ui.component.primaryactor.layouts.FeedPropPrimaryActorLayout;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.infra.shared.DateUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.spans.EntityUrnClickableSpan;
import com.linkedin.android.infra.ui.spans.EntityUrnClickableSpan.EntityUrnClickListener;
import com.linkedin.android.pegasus.gen.voyager.common.GraphDistance;
import com.linkedin.android.pegasus.gen.voyager.feed.AppActor;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import java.util.List;

public final class FeedPrimaryActorTransformer
{
  private static CharSequence getReshareActorSubHeadline(FragmentComponent paramFragmentComponent, final SingleUpdateDataModel paramSingleUpdateDataModel)
  {
    if (((paramSingleUpdateDataModel instanceof ReshareSingleUpdateDataModel)) && (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_RESHARE_SUB_HEADLINE)) && (header != null))
    {
      EntityUrnClickableSpan.EntityUrnClickListener local1 = new EntityUrnClickableSpan.EntityUrnClickListener()
      {
        public final void onEntityUrnClicked(EntityUrnClickableSpan paramAnonymousEntityUrnClickableSpan)
        {
          FeedTracking.trackEntityUrnClick(val$fragmentComponent, "update_subheadline_actor", paramAnonymousEntityUrnClickableSpan.getActionType(), paramSingleUpdateDataModelpegasusUpdate);
        }
      };
      return AttributedTextUtils.getAttributedString(header, paramFragmentComponent.context(), null, local1);
    }
    return null;
  }
  
  private static void setConnectClickListener(FragmentComponent paramFragmentComponent, FeedPrimaryActorViewModel paramFeedPrimaryActorViewModel, UpdateDataModel paramUpdateDataModel, MemberActorDataModel paramMemberActorDataModel)
  {
    actionButtonOnClickListener = FeedTracking.newConnectInvitationClickListener(paramFragmentComponent, pegasusUpdate, (MiniProfile)metadata);
  }
  
  private static void setFollowClickListener(FragmentComponent paramFragmentComponent, FeedPrimaryActorViewModel paramFeedPrimaryActorViewModel, UpdateDataModel paramUpdateDataModel, ActorDataModel paramActorDataModel)
  {
    if ((id == null) || (followingInfo == null))
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Cannot follow actor: " + paramActorDataModel.toString()));
    }
    do
    {
      return;
      if ((paramActorDataModel instanceof CompanyActorDataModel))
      {
        actionButtonOnClickListener = FeedTracking.newFollowCompanyClickListener(paramFragmentComponent, pegasusUpdate, id, followingInfo);
        return;
      }
    } while (!(paramActorDataModel instanceof MemberActorDataModel));
    actionButtonOnClickListener = FeedTracking.newFollowMemberClickListener(paramFragmentComponent, pegasusUpdate, id, followingInfo);
  }
  
  private static void setupActorInCommon(FragmentComponent paramFragmentComponent, ActorDataModel paramActorDataModel, FeedPrimaryActorViewModel paramFeedPrimaryActorViewModel, Update paramUpdate)
  {
    actorId = id;
    actorName = formattedName;
    actorImage = paramActorDataModel.makeFormattedImage(2131492962, Util.retrieveRumSessionId(paramFragmentComponent));
    actorPictureClickListener = FeedTracking.actorClickListener(paramActorDataModel, paramFragmentComponent, "actor_picture", paramUpdate);
    actorClickListener = FeedTracking.actorClickListener(paramActorDataModel, paramFragmentComponent, "actor", paramUpdate);
  }
  
  public static FeedPrimaryActorViewModel toViewModel(UpdateDataModel paramUpdateDataModel, FragmentComponent paramFragmentComponent, boolean paramBoolean)
  {
    if (((paramUpdateDataModel instanceof ChannelSingleUpdateDataModel)) || ((paramUpdateDataModel instanceof MentionedInNewsUpdateDataModel)) || ((paramUpdateDataModel instanceof LyndaSingleUpdateDataModel))) {
      localObject = null;
    }
    ActorDataModel localActorDataModel;
    label87:
    FeedPrimaryActorViewModel localFeedPrimaryActorViewModel;
    label179:
    label240:
    label259:
    label300:
    label341:
    label362:
    label588:
    label597:
    label602:
    label608:
    label614:
    label620:
    label681:
    label744:
    label903:
    label905:
    label1032:
    label1056:
    label1061:
    do
    {
      return (FeedPrimaryActorViewModel)localObject;
      if (((paramUpdateDataModel instanceof ViralSingleUpdateDataModel)) && ((originalUpdate instanceof MentionedInNewsUpdateDataModel))) {
        return null;
      }
      localActorDataModel = paramUpdateDataModel.getActorDataModel();
      if (localActorDataModel == null) {
        return null;
      }
      SingleUpdateDataModel localSingleUpdateDataModel;
      int k;
      int j;
      if (FeedViewTransformerHelpers.isImageViewerPage(paramFragmentComponent))
      {
        localObject = new FeedPrimaryActorLayout(type, false, true, false, false);
        localFeedPrimaryActorViewModel = new FeedPrimaryActorViewModel((FeedPrimaryActorLayout)localObject);
        if (!(paramUpdateDataModel instanceof SingleUpdateDataModel)) {
          break label1061;
        }
        localSingleUpdateDataModel = (SingleUpdateDataModel)paramUpdateDataModel;
        setupActorInCommon(paramFragmentComponent, localActorDataModel, localFeedPrimaryActorViewModel, pegasusUpdate);
        if (!(localActorDataModel instanceof MemberActorDataModel)) {
          break label681;
        }
        localObject = (MemberActorDataModel)localActorDataModel;
        actorHeadline = getReshareActorSubHeadline(paramFragmentComponent, localSingleUpdateDataModel);
        if (actorHeadline == null)
        {
          if (!localSingleUpdateDataModel.isPublisherActor(paramFragmentComponent)) {
            break label588;
          }
          paramUpdateDataModel = paramFragmentComponent.i18NManager().getString(2131231273);
          actorHeadline = paramUpdateDataModel;
        }
        isInfluencer = isInfluencer;
        if ((!showFollowAction) || (memberDistance != GraphDistance.DISTANCE_2) || (connectionStatus != 2) || (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_SHOW_CONNECT_FOR_2ND_DEGREE))) {
          break label597;
        }
        i = 1;
        if ((following) || (isSelf)) {
          break label602;
        }
        k = 1;
        if ((!FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent)) || (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_ALWAYS_SHOW_FOLLOW_ON_DETAIL)) || (k == 0) || (memberDistance == GraphDistance.DISTANCE_1)) {
          break label608;
        }
        j = 1;
        if ((k == 0) || (!showFollowAction) || (!isInfluencer) || (FeedTracking.isSponsored(pegasusUpdate, paramFragmentComponent.lixManager()))) {
          break label614;
        }
        k = 1;
        if ((!FeedViewTransformerHelpers.isImageViewerPage(paramFragmentComponent)) && (id != null)) {
          break label620;
        }
        buttonType = 0;
        if ((FeedViewTransformerHelpers.isImageViewerPage(paramFragmentComponent)) || (createdTimestamp < 0L) || (FeedTracking.isSponsored(pegasusUpdate, paramFragmentComponent.lixManager()))) {
          break label1056;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          secondaryHeadline = DateUtils.getTimestampText(createdTimestamp, paramFragmentComponent.i18NManager());
          secondaryHeadlineContentDescription = DateUtils.getTimeAgoContentDescription(createdTimestamp, paramFragmentComponent.i18NManager());
        }
        localObject = localFeedPrimaryActorViewModel;
        if (FeedViewTransformerHelpers.isPropDetailPage(paramFragmentComponent)) {
          break;
        }
        localObject = localFeedPrimaryActorViewModel;
        if (actions.isEmpty()) {
          break;
        }
        controlMenuClickListener = FeedTracking.newControlMenuClickListener(pegasusUpdate, actions, paramFragmentComponent);
        return localFeedPrimaryActorViewModel;
        if (UpdateDataModel.isPropUpdate(paramUpdateDataModel))
        {
          localObject = new FeedPropPrimaryActorLayout(type);
          break label87;
        }
        if ((paramUpdateDataModel instanceof ActorUpdateDataModel))
        {
          localObject = new FeedListPrimaryActorLayout(type, paramBoolean);
          break label87;
        }
        if (FeedViewTransformerHelpers.isPromptResponseListPage(paramFragmentComponent))
        {
          localObject = new FeedPrimaryActorLayout(type, true, true, false, false);
          break label87;
        }
        localObject = new FeedPrimaryActorLayout(type, true, false, false, false);
        break label87;
        paramUpdateDataModel = occupation;
        break label179;
        i = 0;
        break label240;
        k = 0;
        break label259;
        j = 0;
        break label300;
        k = 0;
        break label341;
        if (i != 0)
        {
          buttonType = 3;
          setConnectClickListener(paramFragmentComponent, localFeedPrimaryActorViewModel, localSingleUpdateDataModel, (MemberActorDataModel)localObject);
          break label362;
        }
        if ((k != 0) || (j != 0))
        {
          buttonType = 1;
          setFollowClickListener(paramFragmentComponent, localFeedPrimaryActorViewModel, localSingleUpdateDataModel, (ActorDataModel)localObject);
          break label362;
        }
        buttonType = 0;
        break label362;
        if ((localActorDataModel instanceof CompanyActorDataModel))
        {
          paramUpdateDataModel = (CompanyActorDataModel)localActorDataModel;
          paramBoolean = FeedTracking.isSponsored(pegasusUpdate, paramFragmentComponent.lixManager());
          localObject = getReshareActorSubHeadline(paramFragmentComponent, localSingleUpdateDataModel);
          if (1 == sponsoredTemplateType)
          {
            actorHeadline = paramFragmentComponent.i18NManager().getString(2131231304);
            if ((!showFollowAction) || (following) || (FeedViewTransformerHelpers.isImageViewerPage(paramFragmentComponent)) || (FeedViewTransformerHelpers.isCompanyTab(paramFragmentComponent))) {
              break label903;
            }
            if ((!paramBoolean) || (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_SPONSORED_FOLLOW_BUTTON))) {
              break label905;
            }
          }
          for (buttonType = 6;; buttonType = 1)
          {
            setFollowClickListener(paramFragmentComponent, localFeedPrimaryActorViewModel, localSingleUpdateDataModel, paramUpdateDataModel);
            break;
            if (localObject != null)
            {
              actorHeadline = ((CharSequence)localObject);
              break label744;
            }
            if ((paramBoolean) && (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_SPONSORED_ACTOR_SUB_HEADLINE)))
            {
              actorHeadline = paramFragmentComponent.i18NManager().getString(2131231303);
              break label744;
            }
            if (followerCount <= 0) {
              break label744;
            }
            actorHeadline = paramFragmentComponent.i18NManager().getString(2131230900, new Object[] { Integer.valueOf(followerCount) });
            break label744;
            break;
          }
        }
        if ((localActorDataModel instanceof AppActorDataModel))
        {
          paramUpdateDataModel = pegasusUpdate;
          localObject = (AppActorDataModel)localActorDataModel;
          actorHeadline = formattedHeadline;
          if (metadata).showActionButton) {
            if (!Utils.isAppInstalled(paramFragmentComponent.appContext(), metadata).appId)) {
              break label1032;
            }
          }
          for (buttonType = 8;; buttonType = 7)
          {
            actorImage = formattedImage;
            paramUpdateDataModel = FeedTracking.crossPromoUpdateClickListener$71752738(paramUpdateDataModel, paramFragmentComponent, appUrl, id, "actor");
            actorPictureClickListener = paramUpdateDataModel;
            actorClickListener = paramUpdateDataModel;
            break;
          }
        }
        actorHeadline = getReshareActorSubHeadline(paramFragmentComponent, localSingleUpdateDataModel);
        break label362;
      }
      localObject = localFeedPrimaryActorViewModel;
    } while (!(paramUpdateDataModel instanceof ActorUpdateDataModel));
    paramUpdateDataModel = (ActorUpdateDataModel)paramUpdateDataModel;
    Object localObject = paramFragmentComponent.i18NManager();
    setupActorInCommon(paramFragmentComponent, localActorDataModel, localFeedPrimaryActorViewModel, pegasusUpdate);
    actorHeadline = primaryActor.formattedHeadline;
    secondaryHeadline = paramUpdateDataModel.getActorSecondaryHeadline((I18NManager)localObject);
    isInfluencer = paramUpdateDataModel.isInfluencerActor();
    if ((paramUpdateDataModel instanceof FollowRecommendationUpdateDataModel)) {
      actorImage = localActorDataModel.makeFormattedImage(2131492963, Util.retrieveRumSessionId(paramFragmentComponent));
    }
    switch (paramUpdateDataModel.getAction())
    {
    default: 
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Unhandled actor update action"));
      return localFeedPrimaryActorViewModel;
    case 1: 
      localObject = primaryActor;
      if (!(localObject instanceof MemberActorDataModel))
      {
        paramFragmentComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException("Cannot setup connect action on a non-member actor"));
        return localFeedPrimaryActorViewModel;
      }
      localObject = (MemberActorDataModel)localObject;
      buttonType = 3;
      setConnectClickListener(paramFragmentComponent, localFeedPrimaryActorViewModel, paramUpdateDataModel, (MemberActorDataModel)localObject);
      return localFeedPrimaryActorViewModel;
    case 4: 
      if (!(primaryActor instanceof MemberActorDataModel))
      {
        paramFragmentComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException("Cannot setup connect invitation sent action on a non-member actor"));
        return localFeedPrimaryActorViewModel;
      }
      buttonType = 5;
      return localFeedPrimaryActorViewModel;
    case 2: 
      localObject = primaryActor;
      if ((showFollowAction) && (!following))
      {
        buttonType = 1;
        setFollowClickListener(paramFragmentComponent, localFeedPrimaryActorViewModel, paramUpdateDataModel, (ActorDataModel)localObject);
        return localFeedPrimaryActorViewModel;
      }
      buttonType = 0;
      return localFeedPrimaryActorViewModel;
    }
    localObject = primaryActor;
    if (!(localObject instanceof MemberActorDataModel))
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Cannot setup connect action on a non-member actor"));
      return localFeedPrimaryActorViewModel;
    }
    localObject = (MemberActorDataModel)localObject;
    buttonType = 4;
    actionButtonOnClickListener = FeedTracking.actorClickListener((ActorDataModel)localObject, paramFragmentComponent, "view_profile", pegasusUpdate);
    return localFeedPrimaryActorViewModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */