package com.linkedin.android.feed.endor.datamodel.update.aggregated;

import com.linkedin.android.feed.endor.datamodel.update.actor.FollowRecommendationUpdateDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class AggregatedFollowRecommendationUpdateDataModel
  extends AggregatedActorUpdateDataModel<FollowRecommendationUpdateDataModel>
{
  public AttributedText recommendationText;
  
  public AggregatedFollowRecommendationUpdateDataModel(Update paramUpdate, AttributedText paramAttributedText, List<UpdateActionModel> paramList, List<FollowRecommendationUpdateDataModel> paramList1, boolean paramBoolean)
  {
    super(paramUpdate, paramList, paramList1, paramBoolean);
    recommendationText = paramAttributedText;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedFollowRecommendationUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */