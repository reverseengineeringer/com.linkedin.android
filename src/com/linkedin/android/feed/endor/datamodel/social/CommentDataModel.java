package com.linkedin.android.feed.endor.datamodel.social;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.viewmodels.models.CommentActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import java.util.List;

public final class CommentDataModel
{
  public List<CommentActionModel> actions;
  public ActorDataModel actor;
  public AnnotatedText comment;
  public String commentUrn;
  public final long createdTime;
  public String parentCommentUrn;
  public Comment pegasusComment;
  public SocialDetailDataModel socialDetail;
  
  public CommentDataModel(String paramString1, Comment paramComment, String paramString2, ActorDataModel paramActorDataModel, AnnotatedText paramAnnotatedText, long paramLong, List<CommentActionModel> paramList, SocialDetailDataModel paramSocialDetailDataModel)
  {
    actor = paramActorDataModel;
    comment = paramAnnotatedText;
    commentUrn = paramString1;
    pegasusComment = paramComment;
    parentCommentUrn = paramString2;
    createdTime = paramLong;
    actions = paramList;
    socialDetail = paramSocialDetailDataModel;
  }
  
  public final int getLikeCount()
  {
    if (socialDetail != null) {
      return socialDetail.totalLikes;
    }
    return 0;
  }
  
  public final int getReplyCount()
  {
    if (socialDetail != null) {
      return socialDetail.totalComments;
    }
    return 0;
  }
  
  public final boolean isLiked()
  {
    if (socialDetail != null) {
      return socialDetail.liked;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.social.CommentDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */