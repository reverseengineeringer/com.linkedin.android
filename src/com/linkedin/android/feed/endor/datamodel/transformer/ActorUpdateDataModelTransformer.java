package com.linkedin.android.feed.endor.datamodel.transformer;

import com.linkedin.android.feed.endor.datamodel.actor.ChannelActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.recommended.RecommendedChannelActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.recommended.RecommendedCompanyActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.recommended.RecommendedMemberActorDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.ConnectionUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.FollowRecommendationUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.PymkUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.PymkUpdateDataModel.PymkRecommendationBuilder;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.feed.ConnectionUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.FollowRecommendationUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.PymkUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedChannel;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedEntity;
import com.linkedin.android.pegasus.gen.voyager.feed.packageRecommendations.RecommendedMember;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import java.util.List;

public final class ActorUpdateDataModelTransformer
{
  public static ConnectionUpdateDataModel toDataModel(FragmentComponent paramFragmentComponent, Update paramUpdate, ConnectionUpdate paramConnectionUpdate)
    throws UpdateException
  {
    return new ConnectionUpdateDataModel(paramUpdate, UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, null, null), ActorDataTransformer.toDataModel(paramFragmentComponent, actor), ActorDataTransformer.toDataModel(paramFragmentComponent, newConnection));
  }
  
  public static FollowRecommendationUpdateDataModel toDataModel(FragmentComponent paramFragmentComponent, Update paramUpdate, FollowRecommendationUpdate paramFollowRecommendationUpdate)
    throws UpdateException
  {
    List localList = UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, null);
    Object localObject = recommendation;
    if (localObject != null) {
      if (recommendedChannelValue != null)
      {
        localObject = recommendedChannelValue;
        Channel localChannel = channel;
        paramFragmentComponent.i18NManager();
        paramFragmentComponent = new RecommendedChannelActorDataModel(new ChannelActorDataModel(localChannel, name, followingInfo, Util.retrieveRumSessionId(paramFragmentComponent)), reason, trackingId);
      }
    }
    while (paramFragmentComponent == null)
    {
      throw new UpdateException("unknown or unhandled recommended actor");
      if (recommendedCompanyValue != null)
      {
        localObject = recommendedCompanyValue;
        paramFragmentComponent = new RecommendedCompanyActorDataModel(ActorDataTransformer.getCompanyActorDataModel(paramFragmentComponent, miniCompany, followingInfo, true, null, null), reason);
      }
      else if (recommendedMemberValue != null)
      {
        localObject = recommendedMemberValue;
        paramFragmentComponent = new RecommendedMemberActorDataModel(ActorDataTransformer.getMemberActorDataModel(paramFragmentComponent, miniProfile, null, followingInfo, true, influencer, null, -1), reason);
      }
      else
      {
        paramFragmentComponent = null;
      }
    }
    return new FollowRecommendationUpdateDataModel(paramUpdate, localList, paramFragmentComponent, recommendationText);
  }
  
  public static PymkUpdateDataModel toDataModel(FragmentComponent paramFragmentComponent, Update paramUpdate, PymkUpdate paramPymkUpdate)
    throws UpdateException
  {
    if ((urn == null) || (tracking == null)) {
      throw new UpdateException("PymkUpdate must have a valid urn and tracking id");
    }
    return new PymkUpdateDataModel(paramUpdate, UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, null, null), ActorDataTransformer.toDataModel(paramFragmentComponent, actor), new PymkUpdateDataModel.PymkRecommendationBuilder(urn, tracking.trackingId));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.ActorUpdateDataModelTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */