package com.linkedin.android.feed.endor.datamodel.update.actor;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.MemberActorDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class ConnectionUpdateDataModel
  extends ActorUpdateDataModel
{
  public ActorDataModel actor;
  public MemberActorDataModel newConnection;
  
  public ConnectionUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, ActorDataModel paramActorDataModel, MemberActorDataModel paramMemberActorDataModel)
  {
    super(paramUpdate, paramList, paramMemberActorDataModel);
    actor = paramActorDataModel;
    newConnection = paramMemberActorDataModel;
  }
  
  public final int getAction()
  {
    switch (newConnection.connectionStatus)
    {
    default: 
      return 3;
    case 2: 
      return 1;
    }
    return 4;
  }
  
  public final CharSequence getActorSecondaryHeadline(I18NManager paramI18NManager)
  {
    if (newConnection.numMutualConnections > 0) {
      return paramI18NManager.getString(2131231166, new Object[] { Integer.valueOf(newConnection.numMutualConnections) });
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.actor.ConnectionUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */