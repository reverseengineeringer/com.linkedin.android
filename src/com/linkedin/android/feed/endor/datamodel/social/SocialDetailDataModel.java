package com.linkedin.android.feed.endor.datamodel.social;

import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SortOrder;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.ArrayList;
import java.util.List;

public final class SocialDetailDataModel
{
  public static final SortOrder DEFAULT_COMMENT_SORT_ORDER = SortOrder.CHRON;
  public static final SortOrder DEFAULT_LIKE_SORT_ORDER = SortOrder.CHRON;
  public List<CommentDataModel> comments;
  public SortOrder commentsOrdering;
  public boolean hasViews;
  public String[] highlightedCommentUrns;
  public List<CommentDataModel> highlightedComments;
  public Like highlightedLike;
  public String[] highlightedReplyUrns;
  public boolean liked;
  public List<LikeDataModel> likes;
  public SortOrder likesOrdering;
  public final SocialDetail pegasusSocialDetail;
  public String threadId;
  public int totalComments;
  public int totalLikes;
  public int totalShares;
  public int totalViews;
  
  public SocialDetailDataModel(SocialDetail paramSocialDetail, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2, int paramInt4, List<LikeDataModel> paramList, SortOrder paramSortOrder1, Like paramLike, List<CommentDataModel> paramList1, SortOrder paramSortOrder2, List<CommentDataModel> paramList2, String paramString)
  {
    pegasusSocialDetail = paramSocialDetail;
    totalShares = paramInt3;
    liked = paramBoolean1;
    totalLikes = paramInt1;
    likes = paramList;
    if ((paramSortOrder1 != null) && (paramSortOrder1 != SortOrder.$UNKNOWN))
    {
      likesOrdering = paramSortOrder1;
      highlightedLike = paramLike;
      totalComments = paramInt2;
      if ((paramSortOrder2 == null) || (paramSortOrder2 == SortOrder.$UNKNOWN)) {
        break label197;
      }
      label75:
      commentsOrdering = paramSortOrder2;
      comments = paramList1;
      highlightedComments = paramList2;
      threadId = paramString;
      hasViews = paramBoolean2;
      totalViews = paramInt4;
      if (CollectionUtils.isEmpty(paramList2)) {
        return;
      }
      paramSocialDetail = new ArrayList();
      paramList = new ArrayList();
      paramInt1 = 0;
      label138:
      if (paramInt1 >= paramList2.size()) {
        break label233;
      }
      paramSortOrder1 = (CommentDataModel)paramList2.get(paramInt1);
      if (parentCommentUrn != null) {
        break label205;
      }
      paramSocialDetail.add(commentUrn);
    }
    for (;;)
    {
      paramInt1 += 1;
      break label138;
      paramSortOrder1 = DEFAULT_LIKE_SORT_ORDER;
      break;
      label197:
      paramSortOrder2 = DEFAULT_COMMENT_SORT_ORDER;
      break label75;
      label205:
      paramSocialDetail.add(parentCommentUrn);
      paramList.add(commentUrn);
    }
    label233:
    highlightedCommentUrns = ((String[])paramSocialDetail.toArray(new String[paramSocialDetail.size()]));
    highlightedReplyUrns = ((String[])paramList.toArray(new String[paramList.size()]));
  }
  
  public static String[] getHighlightedCommentUrns(UpdateDataModel paramUpdateDataModel)
  {
    if ((paramUpdateDataModel instanceof SingleUpdateDataModel))
    {
      paramUpdateDataModel = socialDetail;
      if (paramUpdateDataModel != null) {}
    }
    else
    {
      return null;
    }
    return highlightedCommentUrns;
  }
  
  public static String[] getHighlightedCommentUrns(Update paramUpdate)
  {
    String[] arrayOfString2 = null;
    String[] arrayOfString1 = arrayOfString2;
    if (paramUpdate != null)
    {
      arrayOfString1 = arrayOfString2;
      if (!CollectionUtils.isEmpty(highlightedComments))
      {
        arrayOfString2 = new String[highlightedComments.size()];
        int i = 0;
        for (;;)
        {
          arrayOfString1 = arrayOfString2;
          if (i >= highlightedComments.size()) {
            break;
          }
          arrayOfString2[i] = highlightedComments.get(i)).urn.toString();
          i += 1;
        }
      }
    }
    return arrayOfString1;
  }
  
  public static String[] getHighlightedReplyUrns(UpdateDataModel paramUpdateDataModel)
  {
    if ((paramUpdateDataModel instanceof SingleUpdateDataModel))
    {
      paramUpdateDataModel = socialDetail;
      if (paramUpdateDataModel != null) {}
    }
    else
    {
      return null;
    }
    return highlightedReplyUrns;
  }
  
  public static String[] getHighlightedReplyUrns(Update paramUpdate)
  {
    Comment localComment = null;
    Object localObject = localComment;
    if (paramUpdate != null)
    {
      localObject = localComment;
      if (!CollectionUtils.isEmpty(highlightedComments))
      {
        localObject = new ArrayList();
        int i = 0;
        while (i < highlightedComments.size())
        {
          localComment = (Comment)highlightedComments.get(i);
          if (parentCommentUrn != null) {
            ((List)localObject).add(urn.toString());
          }
          i += 1;
        }
        localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
      }
    }
    return (String[])localObject;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */