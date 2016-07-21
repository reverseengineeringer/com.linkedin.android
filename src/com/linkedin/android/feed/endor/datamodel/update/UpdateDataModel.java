package com.linkedin.android.feed.endor.datamodel.update;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ContentDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.JymbiiUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.PropSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public class UpdateDataModel
{
  public List<UpdateActionModel> actions;
  public final Update pegasusUpdate;
  public String permaLink;
  public final String urn;
  
  public UpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList)
  {
    urn = urn.toString();
    pegasusUpdate = paramUpdate;
    actions = paramList;
    if (pegasusUpdate.hasPermalink) {}
    for (paramUpdate = pegasusUpdate.permalink;; paramUpdate = "")
    {
      permaLink = paramUpdate;
      return;
    }
  }
  
  public static ContentDataModel getContentDataModel(UpdateDataModel paramUpdateDataModel)
  {
    if ((paramUpdateDataModel instanceof AggregatedSingleUpdateDataModel)) {
      return content;
    }
    if ((paramUpdateDataModel instanceof SingleUpdateDataModel)) {
      return SingleUpdateDataModel.getContentDataModel(paramUpdateDataModel);
    }
    if ((paramUpdateDataModel instanceof JymbiiUpdateDataModel)) {
      return jobContent;
    }
    return null;
  }
  
  public static boolean isPropUpdate(UpdateDataModel paramUpdateDataModel)
  {
    return ((paramUpdateDataModel instanceof SingleUpdateDataModel)) && ((SingleUpdateDataModel.getMostOriginalShare((SingleUpdateDataModel)paramUpdateDataModel) instanceof PropSingleUpdateDataModel));
  }
  
  public ActorDataModel getActorDataModel()
  {
    return null;
  }
  
  public boolean isReshareable()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */