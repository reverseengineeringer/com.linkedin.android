package com.linkedin.android.feed.endor.datamodel.transformer;

import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.content.AnnotatedTextContentDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UnsupportedUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedSingleUpdateDataModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedShareContentUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import java.util.ArrayList;
import java.util.List;

public final class UpdateDataModelTransformer
{
  public static UpdateDataModel toDataModel(FragmentComponent paramFragmentComponent, Update paramUpdate, FeedDataModelMetadata paramFeedDataModelMetadata)
  {
    try
    {
      if (value.aggregatedShareContentUpdateValue != null)
      {
        paramFeedDataModelMetadata = value.aggregatedShareContentUpdateValue;
        List localList = UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, null);
        AnnotatedTextContentDataModel localAnnotatedTextContentDataModel = ShareUpdateContentTransformer.toDataModel(paramFragmentComponent, content);
        ArrayList localArrayList = new ArrayList(rollup.size());
        int i = 0;
        while (i < rollup.size())
        {
          localArrayList.add(SingleUpdateDataModelTransformer.toDataModel(paramFragmentComponent, (Update)rollup.get(i), FeedDataModelMetadata.DEFAULT));
          i += 1;
        }
        return new AggregatedSingleUpdateDataModel(paramUpdate, localList, localArrayList, localAnnotatedTextContentDataModel);
      }
      if (value.aggregatedJymbiiUpdateValue != null) {
        return AggregatedUpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate, value.aggregatedJymbiiUpdateValue);
      }
      if (value.jymbiiUpdateValue != null) {
        return AggregatedUpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate, value.jymbiiUpdateValue);
      }
      if (value.aggregatedConnectionUpdateValue != null) {
        return AggregatedUpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate, value.aggregatedConnectionUpdateValue);
      }
      if (value.connectionUpdateValue != null) {
        return AggregatedUpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate, value.connectionUpdateValue);
      }
      if (value.aggregatedFollowRecommendationUpdateValue != null) {
        return AggregatedUpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate, value.aggregatedFollowRecommendationUpdateValue, paramFeedDataModelMetadata);
      }
      if (value.followRecommendationUpdateValue != null) {
        return AggregatedUpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate, value.followRecommendationUpdateValue);
      }
      if (value.aggregatedPymkUpdateValue != null) {
        return AggregatedUpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate, value.aggregatedPymkUpdateValue);
      }
      paramFragmentComponent = SingleUpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate, paramFeedDataModelMetadata);
      return paramFragmentComponent;
    }
    catch (UpdateException paramFragmentComponent) {}
    return new UnsupportedUpdateDataModel(paramUpdate, paramFragmentComponent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.UpdateDataModelTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */