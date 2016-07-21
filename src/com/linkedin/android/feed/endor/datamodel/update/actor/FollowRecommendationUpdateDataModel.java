package com.linkedin.android.feed.endor.datamodel.update.actor;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.MemberActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.recommended.RecommendedActorDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class FollowRecommendationUpdateDataModel
  extends ActorUpdateDataModel
{
  public AttributedText recommendationText;
  public RecommendedActorDataModel recommendedActor;
  
  public FollowRecommendationUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, RecommendedActorDataModel paramRecommendedActorDataModel, AttributedText paramAttributedText)
  {
    super(paramUpdate, paramList, actor);
    recommendedActor = paramRecommendedActorDataModel;
    recommendationText = paramAttributedText;
  }
  
  public final int getAction()
  {
    return 2;
  }
  
  public final CharSequence getActorSecondaryHeadline(I18NManager paramI18NManager)
  {
    if (((primaryActor instanceof MemberActorDataModel)) && (primaryActor.followerCount > 0)) {
      return paramI18NManager.getString(2131233269, new Object[] { Integer.valueOf(primaryActor.followerCount) });
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.actor.FollowRecommendationUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */