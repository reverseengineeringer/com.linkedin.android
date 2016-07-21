package com.linkedin.android.feed.endor.datamodel.update.single;

import com.linkedin.android.feed.endor.datamodel.actor.AppActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ContentDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class CrossPromoSingleUpdateDataModel
  extends SingleUpdateDataModel
{
  public CharSequence headerText;
  public AppActorDataModel primaryActor;
  
  public CrossPromoSingleUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, int paramInt, AppActorDataModel paramAppActorDataModel, ContentDataModel paramContentDataModel, CharSequence paramCharSequence)
  {
    super(paramUpdate, paramList, paramInt, -1L, paramAppActorDataModel, paramContentDataModel, null);
    headerText = paramCharSequence;
    primaryActor = paramAppActorDataModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.single.CrossPromoSingleUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */