package com.linkedin.android.feed.endor.datamodel.update.single;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ContentDataModel;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class ViralSingleUpdateDataModel
  extends SingleUpdateDataModel
{
  public AttributedText header;
  public SingleUpdateDataModel originalUpdate;
  public int viralType;
  
  public ViralSingleUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, int paramInt1, long paramLong, ActorDataModel paramActorDataModel, ContentDataModel paramContentDataModel, SocialDetailDataModel paramSocialDetailDataModel, SingleUpdateDataModel paramSingleUpdateDataModel, int paramInt2, AttributedText paramAttributedText)
  {
    super(paramUpdate, paramList, paramInt1, paramLong, paramActorDataModel, paramContentDataModel, paramSocialDetailDataModel);
    originalUpdate = paramSingleUpdateDataModel;
    viralType = paramInt2;
    header = paramAttributedText;
  }
  
  public final ActorDataModel getActorDataModel()
  {
    return originalUpdate.primaryActor;
  }
  
  public final boolean isReshareable()
  {
    return originalUpdate.isReshareable();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.single.ViralSingleUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */