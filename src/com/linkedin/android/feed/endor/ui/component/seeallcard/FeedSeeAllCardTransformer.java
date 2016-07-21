package com.linkedin.android.feed.endor.ui.component.seeallcard;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.ActorUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedActorUpdateDataModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import java.util.ArrayList;
import java.util.List;

public final class FeedSeeAllCardTransformer
{
  public static FeedSeeAllCardViewModel toViewModel(FragmentComponent paramFragmentComponent, UpdateDataModel paramUpdateDataModel)
  {
    if (!(paramUpdateDataModel instanceof AggregatedActorUpdateDataModel)) {}
    do
    {
      return null;
      paramUpdateDataModel = (AggregatedActorUpdateDataModel)paramUpdateDataModel;
    } while (updates.size() <= 6);
    int i = updates.size() - 5;
    int j;
    if (i > 4)
    {
      j = i - 3;
      i = 3;
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      int k = 5;
      while (k < i + 5)
      {
        localArrayList.add(updates.get(k)).primaryActor.formattedImage);
        k += 1;
      }
      FeedSeeAllCardViewModel localFeedSeeAllCardViewModel = new FeedSeeAllCardViewModel(new FeedSeeAllCardLayout());
      images = localArrayList;
      rollupCount = j;
      if (pegasusUpdate.value.aggregatedPymkUpdateValue != null) {
        seeAllOnClickListener = FeedTracking.newSeeAllPymkUpdatesClickListener(paramFragmentComponent, updates.get(0)).pegasusUpdate, pegasusUpdate.value.aggregatedPymkUpdateValue, false);
      }
      return localFeedSeeAllCardViewModel;
      j = -1;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.seeallcard.FeedSeeAllCardTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */