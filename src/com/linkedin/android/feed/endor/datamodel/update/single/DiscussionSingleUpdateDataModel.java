package com.linkedin.android.feed.endor.datamodel.update.single;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentDataModel;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.DiscussionSource;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class DiscussionSingleUpdateDataModel
  extends SingleUpdateDataModel
{
  public final GroupDiscussionContentDataModel content;
  public final DiscussionSource discussionSource;
  public final boolean isActive;
  public final boolean isFeatured;
  
  public DiscussionSingleUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, int paramInt, long paramLong, ActorDataModel paramActorDataModel, GroupDiscussionContentDataModel paramGroupDiscussionContentDataModel, SocialDetailDataModel paramSocialDetailDataModel, boolean paramBoolean1, boolean paramBoolean2, DiscussionSource paramDiscussionSource)
  {
    super(paramUpdate, paramList, paramInt, paramLong, paramActorDataModel, paramGroupDiscussionContentDataModel, paramSocialDetailDataModel);
    content = paramGroupDiscussionContentDataModel;
    isFeatured = paramBoolean1;
    discussionSource = paramDiscussionSource;
    isActive = paramBoolean2;
  }
  
  public static boolean isClosedDiscussion(UpdateDataModel paramUpdateDataModel)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramUpdateDataModel instanceof DiscussionSingleUpdateDataModel))
    {
      bool1 = bool2;
      if (!isActive) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean isReshareable()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.single.DiscussionSingleUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */