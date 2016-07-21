package com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.JobContentDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class JymbiiUpdateDataModel
  extends UpdateDataModel
{
  public ActorDataModel companyActor;
  public long createdTimestamp;
  public List<EntitiesFlavor> insights;
  public JobContentDataModel jobContent;
  public int sponsoredTemplateType;
  
  public JymbiiUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, ActorDataModel paramActorDataModel, JobContentDataModel paramJobContentDataModel, int paramInt, long paramLong, List<EntitiesFlavor> paramList1)
  {
    super(paramUpdate, paramList);
    companyActor = paramActorDataModel;
    jobContent = paramJobContentDataModel;
    sponsoredTemplateType = paramInt;
    createdTimestamp = paramLong;
    insights = paramList1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.JymbiiUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */