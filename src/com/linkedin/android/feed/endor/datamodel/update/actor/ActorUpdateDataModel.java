package com.linkedin.android.feed.endor.datamodel.update.actor;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.MemberActorDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public class ActorUpdateDataModel
  extends UpdateDataModel
{
  public ActorDataModel primaryActor;
  
  public ActorUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, ActorDataModel paramActorDataModel)
  {
    super(paramUpdate, paramList);
    primaryActor = paramActorDataModel;
  }
  
  public int getAction()
  {
    return 0;
  }
  
  public final ActorDataModel getActorDataModel()
  {
    return primaryActor;
  }
  
  public CharSequence getActorSecondaryHeadline(I18NManager paramI18NManager)
  {
    return null;
  }
  
  public final boolean isInfluencerActor()
  {
    return ((primaryActor instanceof MemberActorDataModel)) && (primaryActor).isInfluencer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.actor.ActorUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */