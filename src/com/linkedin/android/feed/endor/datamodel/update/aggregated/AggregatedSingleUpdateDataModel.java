package com.linkedin.android.feed.endor.datamodel.update.aggregated;

import com.linkedin.android.feed.endor.datamodel.content.ContentDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class AggregatedSingleUpdateDataModel
  extends AggregatedUpdateDataModel<SingleUpdateDataModel>
{
  public ContentDataModel content;
  
  public AggregatedSingleUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, List<SingleUpdateDataModel> paramList1, ContentDataModel paramContentDataModel)
  {
    super(paramUpdate, paramList, paramList1);
    content = paramContentDataModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedSingleUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */