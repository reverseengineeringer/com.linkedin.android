package com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii;

import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedUpdateDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class AggregatedJymbiiUpdateDataModel
  extends AggregatedUpdateDataModel<JymbiiUpdateDataModel>
{
  public boolean isSponsored;
  
  public AggregatedJymbiiUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, List<JymbiiUpdateDataModel> paramList1, boolean paramBoolean)
  {
    super(paramUpdate, paramList, paramList1);
    isSponsored = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.AggregatedJymbiiUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */