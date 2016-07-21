package com.linkedin.android.feed.endor.datamodel.update.aggregated;

import com.linkedin.android.feed.endor.datamodel.update.actor.ActorUpdateDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public class AggregatedActorUpdateDataModel<T extends ActorUpdateDataModel>
  extends AggregatedUpdateDataModel<T>
{
  public AggregatedActorUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, List<T> paramList1, boolean paramBoolean)
  {
    super(paramUpdate, paramList, paramList1, paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedActorUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */