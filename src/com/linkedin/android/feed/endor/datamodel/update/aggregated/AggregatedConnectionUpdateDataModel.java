package com.linkedin.android.feed.endor.datamodel.update.aggregated;

import com.linkedin.android.feed.endor.datamodel.update.actor.ConnectionUpdateDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class AggregatedConnectionUpdateDataModel
  extends AggregatedActorUpdateDataModel<ConnectionUpdateDataModel>
{
  public AggregatedConnectionUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, List<ConnectionUpdateDataModel> paramList1)
  {
    super(paramUpdate, paramList, paramList1, false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedConnectionUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */