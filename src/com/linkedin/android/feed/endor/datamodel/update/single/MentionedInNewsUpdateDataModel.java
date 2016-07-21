package com.linkedin.android.feed.endor.datamodel.update.single;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ArticleContentDataModel;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class MentionedInNewsUpdateDataModel
  extends SingleUpdateDataModel
{
  public ArticleContentDataModel content;
  public AttributedText headerText;
  public ActorDataModel primaryActor;
  
  public MentionedInNewsUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, int paramInt, ActorDataModel paramActorDataModel, ArticleContentDataModel paramArticleContentDataModel, SocialDetailDataModel paramSocialDetailDataModel, AttributedText paramAttributedText)
  {
    super(paramUpdate, paramList, paramInt, -1L, paramActorDataModel, paramArticleContentDataModel, paramSocialDetailDataModel);
    headerText = paramAttributedText;
    primaryActor = paramActorDataModel;
    content = paramArticleContentDataModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.single.MentionedInNewsUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */