package com.linkedin.android.feed.endor.datamodel.update.actor;

import com.linkedin.android.feed.endor.datamodel.actor.MemberActorDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class PymkUpdateDataModel
  extends ActorUpdateDataModel
{
  public MemberActorDataModel primaryActor;
  public PymkRecommendationBuilder pymkRecommendationBuilder;
  
  public PymkUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, MemberActorDataModel paramMemberActorDataModel, PymkRecommendationBuilder paramPymkRecommendationBuilder)
  {
    super(paramUpdate, paramList, paramMemberActorDataModel);
    primaryActor = paramMemberActorDataModel;
    pymkRecommendationBuilder = paramPymkRecommendationBuilder;
  }
  
  public final int getAction()
  {
    switch (primaryActor.connectionStatus)
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
    if (primaryActor.numMutualConnections > 0) {
      return paramI18NManager.getString(2131231166, new Object[] { Integer.valueOf(primaryActor.numMutualConnections) });
    }
    return null;
  }
  
  public static final class PymkRecommendationBuilder
  {
    public final Urn pymkUpdateUrn;
    public final String trackingId;
    
    public PymkRecommendationBuilder(Urn paramUrn, String paramString)
    {
      pymkUpdateUrn = paramUrn;
      trackingId = paramString;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.actor.PymkUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */