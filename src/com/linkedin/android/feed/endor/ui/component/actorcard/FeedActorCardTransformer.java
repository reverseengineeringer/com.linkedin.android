package com.linkedin.android.feed.endor.ui.component.actorcard;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.CompanyActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.MemberActorDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.ActorUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.FollowRecommendationUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.PymkUpdateDataModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import java.util.Collections;

public final class FeedActorCardTransformer
{
  public static FeedActorCardViewModel toViewModel(UpdateDataModel paramUpdateDataModel, FragmentComponent paramFragmentComponent)
  {
    if (!(paramUpdateDataModel instanceof ActorUpdateDataModel)) {
      paramUpdateDataModel = null;
    }
    Object localObject;
    FeedActorCardViewModel localFeedActorCardViewModel;
    ActorUpdateDataModel localActorUpdateDataModel;
    label470:
    do
    {
      return paramUpdateDataModel;
      localObject = primaryActor;
      localFeedActorCardViewModel = new FeedActorCardViewModel(paramFragmentComponent, new FeedActorCardLayout(type), pegasusUpdate);
      localActorUpdateDataModel = (ActorUpdateDataModel)paramUpdateDataModel;
      paramUpdateDataModel = paramFragmentComponent.i18NManager();
      Update localUpdate = pegasusUpdate;
      actorId = id;
      actorName = formattedName;
      actorImage = ((ActorDataModel)localObject).makeFormattedImage(2131492962, Util.retrieveRumSessionId(paramFragmentComponent));
      actorPictureClickListener = FeedTracking.actorClickListener((ActorDataModel)localObject, paramFragmentComponent, "actor_picture", localUpdate);
      actorClickListener = FeedTracking.actorClickListener((ActorDataModel)localObject, paramFragmentComponent, "actor", localUpdate);
      actorHeadline = primaryActor.formattedHeadline;
      secondaryHeadline = localActorUpdateDataModel.getActorSecondaryHeadline(paramUpdateDataModel);
      isInfluencer = localActorUpdateDataModel.isInfluencerActor();
      if ((localActorUpdateDataModel instanceof FollowRecommendationUpdateDataModel)) {
        actorImage = ((ActorDataModel)localObject).makeFormattedImage(2131492963, Util.retrieveRumSessionId(paramFragmentComponent));
      }
      if ((localActorUpdateDataModel instanceof PymkUpdateDataModel))
      {
        paramUpdateDataModel = pymkRecommendationBuilder;
        localObject = FeedTracking.getPymkUsage(paramFragmentComponent);
        pymkRecommendationBuilders = Collections.singletonList(paramUpdateDataModel);
        pymkUsage = ((String)localObject);
      }
      switch (localActorUpdateDataModel.getAction())
      {
      default: 
        paramFragmentComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException("Unhandled actor update action"));
        return localFeedActorCardViewModel;
      case 1: 
        paramUpdateDataModel = primaryActor;
        if (!(paramUpdateDataModel instanceof MemberActorDataModel))
        {
          paramFragmentComponent.context();
          Util.safeThrow$7a8b4789(new RuntimeException("Cannot setup connect action on a non-member actor"));
          return localFeedActorCardViewModel;
        }
        paramUpdateDataModel = (MemberActorDataModel)paramUpdateDataModel;
        buttonType = 3;
        actionButtonOnClickListener = FeedTracking.newConnectInvitationClickListener(paramFragmentComponent, pegasusUpdate, (MiniProfile)metadata);
        return localFeedActorCardViewModel;
      case 4: 
        if (!(primaryActor instanceof MemberActorDataModel))
        {
          paramFragmentComponent.context();
          Util.safeThrow$7a8b4789(new RuntimeException("Cannot setup connect invitation sent action on a non-member actor"));
          return localFeedActorCardViewModel;
        }
        buttonType = 5;
        return localFeedActorCardViewModel;
      case 2: 
        localObject = primaryActor;
        if (showFollowAction) {}
        for (int i = 1;; i = 0)
        {
          buttonType = i;
          paramUpdateDataModel = localFeedActorCardViewModel;
          if (!showFollowAction) {
            break;
          }
          if ((id != null) && (followingInfo != null)) {
            break label470;
          }
          paramFragmentComponent.context();
          Util.safeThrow$7a8b4789(new RuntimeException("Cannot follow actor: " + localObject.toString()));
          return localFeedActorCardViewModel;
        }
        if ((localObject instanceof CompanyActorDataModel))
        {
          actionButtonOnClickListener = FeedTracking.newFollowCompanyClickListener(paramFragmentComponent, pegasusUpdate, id, followingInfo);
          return localFeedActorCardViewModel;
        }
        paramUpdateDataModel = localFeedActorCardViewModel;
      }
    } while (!(localObject instanceof MemberActorDataModel));
    actionButtonOnClickListener = FeedTracking.newFollowMemberClickListener(paramFragmentComponent, pegasusUpdate, id, followingInfo);
    return localFeedActorCardViewModel;
    paramUpdateDataModel = primaryActor;
    if (!(paramUpdateDataModel instanceof MemberActorDataModel))
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Cannot setup connect action on a non-member actor"));
      return localFeedActorCardViewModel;
    }
    paramUpdateDataModel = (MemberActorDataModel)paramUpdateDataModel;
    buttonType = 4;
    actionButtonOnClickListener = FeedTracking.actorClickListener(paramUpdateDataModel, paramFragmentComponent, "view_profile", pegasusUpdate);
    return localFeedActorCardViewModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.actorcard.FeedActorCardTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */