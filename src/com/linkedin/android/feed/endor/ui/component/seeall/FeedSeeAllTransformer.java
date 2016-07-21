package com.linkedin.android.feed.endor.ui.component.seeall;

import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.ConnectionUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.FollowRecommendationUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.PymkUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedConnectionUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedFollowRecommendationUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedPymkUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.AggregatedJymbiiUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.JymbiiUpdateDataModel;
import com.linkedin.android.feed.endor.ui.component.basicbutton.FeedBasicButtonViewModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import java.util.List;

public final class FeedSeeAllTransformer
{
  public static FeedBasicButtonViewModel toViewModel(UpdateDataModel paramUpdateDataModel, FragmentComponent paramFragmentComponent)
  {
    if (!(paramUpdateDataModel instanceof AggregatedUpdateDataModel)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return null;
              if ((paramUpdateDataModel instanceof AggregatedSingleUpdateDataModel))
              {
                paramUpdateDataModel = (AggregatedSingleUpdateDataModel)paramUpdateDataModel;
                localFeedBasicButtonViewModel = new FeedBasicButtonViewModel(new FeedSeeAllLayout());
                text = paramFragmentComponent.i18NManager().getString(2131231080);
                clickListener = FeedTracking.newAggregateUpdateClickListener(pegasusUpdate, paramFragmentComponent);
                return localFeedBasicButtonViewModel;
              }
              if (!(paramUpdateDataModel instanceof AggregatedConnectionUpdateDataModel)) {
                break;
              }
              paramUpdateDataModel = (AggregatedConnectionUpdateDataModel)paramUpdateDataModel;
            } while (updates.isEmpty());
            localFeedBasicButtonViewModel = new FeedBasicButtonViewModel(new FeedSeeAllLayout());
            text = paramFragmentComponent.i18NManager().getString(2131231080);
            clickListener = FeedTracking.newSeeAllConnectionUpdatesClickListener(paramFragmentComponent, updates.get(0)).pegasusUpdate, pegasusUpdate.value.aggregatedConnectionUpdateValue, false);
            return localFeedBasicButtonViewModel;
            if (!(paramUpdateDataModel instanceof AggregatedPymkUpdateDataModel)) {
              break;
            }
            paramUpdateDataModel = (AggregatedPymkUpdateDataModel)paramUpdateDataModel;
          } while (updates.isEmpty());
          localFeedBasicButtonViewModel = new FeedBasicButtonViewModel(new FeedSeeAllLayout());
          text = paramFragmentComponent.i18NManager().getString(2131231081);
          clickListener = FeedTracking.newSeeAllPymkUpdatesClickListener(paramFragmentComponent, updates.get(0)).pegasusUpdate, pegasusUpdate.value.aggregatedPymkUpdateValue, false);
          return localFeedBasicButtonViewModel;
          if (!(paramUpdateDataModel instanceof AggregatedJymbiiUpdateDataModel)) {
            break;
          }
          paramUpdateDataModel = (AggregatedJymbiiUpdateDataModel)paramUpdateDataModel;
        } while ((updates.isEmpty()) || (isSponsored));
        localFeedBasicButtonViewModel = new FeedBasicButtonViewModel(new FeedSeeAllLayout());
        text = paramFragmentComponent.i18NManager().getString(2131231081);
        clickListener = FeedTracking.newJymbiiSeeMoreClickListener(paramFragmentComponent, updates.get(0)).pegasusUpdate, false);
        return localFeedBasicButtonViewModel;
      } while (!(paramUpdateDataModel instanceof AggregatedFollowRecommendationUpdateDataModel));
      paramUpdateDataModel = (AggregatedFollowRecommendationUpdateDataModel)paramUpdateDataModel;
    } while (updates.isEmpty());
    FeedBasicButtonViewModel localFeedBasicButtonViewModel = new FeedBasicButtonViewModel(new FeedSeeAllLayout());
    text = paramFragmentComponent.i18NManager().getString(2131231081);
    clickListener = FeedTracking.newSeeMoreFollowRecommendationClickListener(paramFragmentComponent, updates.get(0)).pegasusUpdate, false);
    return localFeedBasicButtonViewModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.seeall.FeedSeeAllTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */