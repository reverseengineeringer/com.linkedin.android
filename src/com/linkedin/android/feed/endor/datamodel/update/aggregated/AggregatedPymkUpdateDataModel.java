package com.linkedin.android.feed.endor.datamodel.update.aggregated;

import com.linkedin.android.feed.endor.datamodel.update.actor.PymkUpdateDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class AggregatedPymkUpdateDataModel
  extends AggregatedActorUpdateDataModel<PymkUpdateDataModel>
{
  public AggregatedPymkUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, List<PymkUpdateDataModel> paramList1)
  {
    super(paramUpdate, paramList, paramList1, true);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedPymkUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */