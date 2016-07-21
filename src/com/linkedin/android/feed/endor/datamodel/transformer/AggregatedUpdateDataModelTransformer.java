package com.linkedin.android.feed.endor.datamodel.transformer;

import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedConnectionUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedFollowRecommendationUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedPymkUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.AggregatedJymbiiUpdateDataModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedConnectionUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedFollowRecommendationUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedJymbiiUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedPymkUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.ConnectionUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.FollowRecommendationUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.PymkUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AggregatedUpdateDataModelTransformer
{
  public static AggregatedConnectionUpdateDataModel toDataModel(FragmentComponent paramFragmentComponent, Update paramUpdate, AggregatedConnectionUpdate paramAggregatedConnectionUpdate)
    throws UpdateException
  {
    List localList = UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, null);
    ArrayList localArrayList = new ArrayList(connectionUpdates.size());
    int i = 0;
    while (i < connectionUpdates.size())
    {
      Update localUpdate = (Update)connectionUpdates.get(i);
      ConnectionUpdate localConnectionUpdate = value.connectionUpdateValue;
      if (localConnectionUpdate != null) {
        localArrayList.add(ActorUpdateDataModelTransformer.toDataModel(paramFragmentComponent, localUpdate, localConnectionUpdate));
      }
      i += 1;
    }
    return new AggregatedConnectionUpdateDataModel(paramUpdate, localList, localArrayList);
  }
  
  public static AggregatedConnectionUpdateDataModel toDataModel(FragmentComponent paramFragmentComponent, Update paramUpdate, ConnectionUpdate paramConnectionUpdate)
    throws UpdateException
  {
    return new AggregatedConnectionUpdateDataModel(paramUpdate, UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, null, null), Collections.singletonList(ActorUpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate, paramConnectionUpdate)));
  }
  
  public static AggregatedFollowRecommendationUpdateDataModel toDataModel(FragmentComponent paramFragmentComponent, Update paramUpdate, AggregatedFollowRecommendationUpdate paramAggregatedFollowRecommendationUpdate, FeedDataModelMetadata paramFeedDataModelMetadata)
    throws UpdateException
  {
    List localList1 = UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, null);
    ArrayList localArrayList = new ArrayList(followRecommendationUpdates.size());
    List localList2 = followRecommendationUpdates;
    int i = 0;
    while (i < localList2.size())
    {
      Update localUpdate = (Update)localList2.get(i);
      FollowRecommendationUpdate localFollowRecommendationUpdate = value.followRecommendationUpdateValue;
      if (localFollowRecommendationUpdate != null) {
        localArrayList.add(ActorUpdateDataModelTransformer.toDataModel(paramFragmentComponent, localUpdate, localFollowRecommendationUpdate));
      }
      i += 1;
    }
    return new AggregatedFollowRecommendationUpdateDataModel(paramUpdate, recommendationText, localList1, localArrayList, isHorizontalCarouselUpdate);
  }
  
  public static AggregatedFollowRecommendationUpdateDataModel toDataModel(FragmentComponent paramFragmentComponent, Update paramUpdate, FollowRecommendationUpdate paramFollowRecommendationUpdate)
    throws UpdateException
  {
    List localList = UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, null);
    paramFragmentComponent = Collections.singletonList(ActorUpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate, paramFollowRecommendationUpdate));
    return new AggregatedFollowRecommendationUpdateDataModel(paramUpdate, recommendationText, localList, paramFragmentComponent, false);
  }
  
  public static AggregatedPymkUpdateDataModel toDataModel(FragmentComponent paramFragmentComponent, Update paramUpdate, AggregatedPymkUpdate paramAggregatedPymkUpdate)
    throws UpdateException
  {
    List localList = UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, null);
    ArrayList localArrayList = new ArrayList(pymkUpdates.size());
    int i = 0;
    while (i < pymkUpdates.size())
    {
      Update localUpdate = (Update)pymkUpdates.get(i);
      PymkUpdate localPymkUpdate = value.pymkUpdateValue;
      if (localPymkUpdate != null) {
        localArrayList.add(ActorUpdateDataModelTransformer.toDataModel(paramFragmentComponent, localUpdate, localPymkUpdate));
      }
      i += 1;
    }
    return new AggregatedPymkUpdateDataModel(paramUpdate, localList, localArrayList);
  }
  
  public static AggregatedJymbiiUpdateDataModel toDataModel(FragmentComponent paramFragmentComponent, Update paramUpdate, AggregatedJymbiiUpdate paramAggregatedJymbiiUpdate)
    throws UpdateException
  {
    List localList = UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, null);
    ArrayList localArrayList = new ArrayList(jymbiiUpdates.size());
    int i = 0;
    while (i < jymbiiUpdates.size())
    {
      localArrayList.add(JymbiiUpdateDataModelTransformer.toDataModel(paramFragmentComponent, (Update)jymbiiUpdates.get(i)));
      i += 1;
    }
    return new AggregatedJymbiiUpdateDataModel(paramUpdate, localList, localArrayList, isSponsored);
  }
  
  public static AggregatedJymbiiUpdateDataModel toDataModel(FragmentComponent paramFragmentComponent, Update paramUpdate, JymbiiUpdate paramJymbiiUpdate)
    throws UpdateException
  {
    return new AggregatedJymbiiUpdateDataModel(paramUpdate, UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, null), Collections.singletonList(JymbiiUpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate)), isSponsored);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.AggregatedUpdateDataModelTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */