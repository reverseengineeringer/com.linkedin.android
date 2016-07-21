package com.linkedin.android.feed.endor.datamodel.update.single;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ContentDataModel;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Prompt;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class PromptResponseSingleUpdateDataModel
  extends SingleUpdateDataModel
{
  public Prompt prompt;
  
  public PromptResponseSingleUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, int paramInt, long paramLong, ActorDataModel paramActorDataModel, ContentDataModel paramContentDataModel, SocialDetailDataModel paramSocialDetailDataModel, Prompt paramPrompt)
  {
    super(paramUpdate, paramList, paramInt, paramLong, paramActorDataModel, paramContentDataModel, paramSocialDetailDataModel);
    prompt = paramPrompt;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.single.PromptResponseSingleUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */