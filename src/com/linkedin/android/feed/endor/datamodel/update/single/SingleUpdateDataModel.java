package com.linkedin.android.feed.endor.datamodel.update.single;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ArticleContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ContentDataModel;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.pegasus.gen.voyager.feed.Reshare;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import java.util.List;

public class SingleUpdateDataModel
  extends UpdateDataModel
{
  public ContentDataModel content;
  public long createdTimestamp;
  public CharSequence detailTitle;
  public boolean isEdited;
  public ActorDataModel primaryActor;
  public SocialDetailDataModel socialDetail;
  public int sponsoredTemplateType;
  
  public SingleUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, int paramInt, long paramLong, ActorDataModel paramActorDataModel, ContentDataModel paramContentDataModel, SocialDetailDataModel paramSocialDetailDataModel)
  {
    this(paramUpdate, paramList, paramInt, paramLong, paramActorDataModel, paramContentDataModel, paramSocialDetailDataModel, null);
  }
  
  public SingleUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, int paramInt, long paramLong, ActorDataModel paramActorDataModel, ContentDataModel paramContentDataModel, SocialDetailDataModel paramSocialDetailDataModel, CharSequence paramCharSequence)
  {
    super(paramUpdate, paramList);
    sponsoredTemplateType = paramInt;
    createdTimestamp = paramLong;
    primaryActor = paramActorDataModel;
    content = paramContentDataModel;
    socialDetail = paramSocialDetailDataModel;
    detailTitle = paramCharSequence;
    boolean bool;
    if (value.reshareValue != null) {
      bool = value.reshareValue.edited;
    }
    for (;;)
    {
      isEdited = bool;
      return;
      if (value.shareUpdateValue != null) {
        bool = value.shareUpdateValue.edited;
      } else {
        bool = false;
      }
    }
  }
  
  public static ContentDataModel getContentDataModel(UpdateDataModel paramUpdateDataModel)
  {
    for (;;)
    {
      if (!(paramUpdateDataModel instanceof SingleUpdateDataModel)) {
        return null;
      }
      if ((paramUpdateDataModel instanceof ViralSingleUpdateDataModel))
      {
        paramUpdateDataModel = originalUpdate;
      }
      else
      {
        if (!(paramUpdateDataModel instanceof ReshareSingleUpdateDataModel)) {
          break;
        }
        paramUpdateDataModel = originalUpdate;
      }
    }
    return content;
  }
  
  public static SingleUpdateDataModel getMostOriginalShare(SingleUpdateDataModel paramSingleUpdateDataModel)
  {
    for (;;)
    {
      if ((paramSingleUpdateDataModel instanceof ViralSingleUpdateDataModel))
      {
        paramSingleUpdateDataModel = originalUpdate;
      }
      else
      {
        if (!(paramSingleUpdateDataModel instanceof ReshareSingleUpdateDataModel)) {
          break;
        }
        paramSingleUpdateDataModel = originalUpdate;
      }
    }
    return paramSingleUpdateDataModel;
  }
  
  public ActorDataModel getActorDataModel()
  {
    return primaryActor;
  }
  
  public final boolean isPublisherActor(FragmentComponent paramFragmentComponent)
  {
    if (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_PUBLISHER_POST_AUTHOR_ATTRIBUTION)) {}
    ActorDataModel localActorDataModel;
    do
    {
      do
      {
        return false;
        paramFragmentComponent = getContentDataModel(this);
      } while (!(paramFragmentComponent instanceof ArticleContentDataModel));
      paramFragmentComponent = (ArticleContentDataModel)paramFragmentComponent;
      localActorDataModel = getActorDataModel();
    } while ((localActorDataModel == null) || (id == null) || (author == null) || (!id.equals(author.id)));
    return true;
  }
  
  public boolean isReshareable()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */