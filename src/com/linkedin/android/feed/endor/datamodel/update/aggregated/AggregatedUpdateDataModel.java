package com.linkedin.android.feed.endor.datamodel.update.aggregated;

import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public class AggregatedUpdateDataModel<T extends UpdateDataModel>
  extends UpdateDataModel
{
  public final boolean isHorizontal;
  public List<T> updates;
  
  public AggregatedUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, List<T> paramList1)
  {
    this(paramUpdate, paramList, paramList1, false);
  }
  
  public AggregatedUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, List<T> paramList1, boolean paramBoolean)
  {
    super(paramUpdate, paramList);
    updates = paramList1;
    isHorizontal = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */