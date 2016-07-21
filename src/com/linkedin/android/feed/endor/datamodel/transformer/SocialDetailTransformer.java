package com.linkedin.android.feed.endor.datamodel.transformer;

import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.social.CommentDataModel;
import com.linkedin.android.feed.endor.datamodel.social.LikeDataModel;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.endor.datamodel.transformer.service.CommentActionDataModelTransformer;
import com.linkedin.android.feed.utils.FeedUpdateUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.CommentAction;
import com.linkedin.android.pegasus.gen.voyager.feed.Comments;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;
import com.linkedin.android.pegasus.gen.voyager.feed.Likes;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SocialDetailTransformer
{
  public static CommentDataModel toDataModel(FragmentComponent paramFragmentComponent, Comment paramComment)
    throws UpdateException
  {
    boolean bool2 = true;
    String str = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = actions;
    Object localObject2;
    boolean bool1;
    if ((localObject1 != null) && (((List)localObject1).contains(CommentAction.REPORT)))
    {
      localObject2 = paramFragmentComponent.i18NManager();
      CommentAction localCommentAction = CommentAction.REPORT;
      if (parentCommentUrn != null)
      {
        bool1 = true;
        localArrayList.add(CommentActionDataModelTransformer.toDataModel((I18NManager)localObject2, localCommentAction, bool1));
      }
    }
    else
    {
      if ((canDelete) || ((localObject1 != null) && (((List)localObject1).contains(CommentAction.DELETE))))
      {
        localObject1 = paramFragmentComponent.i18NManager();
        localObject2 = CommentAction.DELETE;
        if (parentCommentUrn == null) {
          break label223;
        }
        bool1 = bool2;
        label123:
        localArrayList.add(CommentActionDataModelTransformer.toDataModel((I18NManager)localObject1, (CommentAction)localObject2, bool1));
      }
      if (socialDetail == null) {
        break label228;
      }
    }
    label223:
    label228:
    for (localObject1 = toDataModel(paramFragmentComponent, socialDetail, Collections.emptyList(), null);; localObject1 = null)
    {
      localObject2 = urn.toString();
      if (parentCommentUrn != null) {
        str = parentCommentUrn.toString();
      }
      return new CommentDataModel((String)localObject2, paramComment, str, ActorDataTransformer.toDataModel(paramFragmentComponent, commenter), comment, createdTime, localArrayList, (SocialDetailDataModel)localObject1);
      bool1 = false;
      break;
      bool1 = false;
      break label123;
    }
  }
  
  public static SocialDetailDataModel toDataModel(FragmentComponent paramFragmentComponent, SocialDetail paramSocialDetail, List<Comment> paramList, Like paramLike)
    throws UpdateException
  {
    boolean bool1 = totalSocialActivityCounts.liked;
    int j = (int)totalSocialActivityCounts.numComments;
    int k = (int)totalSocialActivityCounts.numLikes;
    boolean bool2 = totalSocialActivityCounts.hasNumViews;
    if (bool2) {}
    for (int i = (int)totalSocialActivityCounts.numViews;; i = 0)
    {
      List localList1 = transformLikes(paramFragmentComponent, likes.elements, paramLike, new HashSet());
      List localList2 = transformComments(paramFragmentComponent, comments.elements);
      List localList3 = transformComments(paramFragmentComponent, paramList);
      paramFragmentComponent = null;
      if (likes.metadata != null) {
        paramFragmentComponent = likes.metadata.sort;
      }
      paramList = null;
      if (comments.metadata != null) {
        paramList = comments.metadata.sort;
      }
      return new SocialDetailDataModel(paramSocialDetail, bool1, k, j, totalShares, bool2, i, localList1, paramFragmentComponent, paramLike, localList2, paramList, localList3, threadId);
    }
  }
  
  public static SocialDetailDataModel toDataModel(FragmentComponent paramFragmentComponent, Update paramUpdate, SocialDetail paramSocialDetail, FeedDataModelMetadata paramFeedDataModelMetadata)
    throws UpdateException
  {
    if (paramSocialDetail == null) {
      return null;
    }
    return toDataModel(paramFragmentComponent, paramSocialDetail, highlightedComments, highlightedLike);
  }
  
  private static List<CommentDataModel> transformComments(FragmentComponent paramFragmentComponent, List<Comment> paramList)
    throws UpdateException
  {
    Object localObject;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      localObject = Collections.emptyList();
      return (List<CommentDataModel>)localObject;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= paramList.size()) {
        break;
      }
      localArrayList.add(toDataModel(paramFragmentComponent, (Comment)paramList.get(i)));
      i += 1;
    }
  }
  
  private static LikeDataModel transformLike(FragmentComponent paramFragmentComponent, Like paramLike, Set<String> paramSet)
  {
    if (paramLike == null) {}
    String str;
    do
    {
      return null;
      str = FeedUpdateUtils.getSocialActorId(actor);
    } while ((str == null) || (paramSet.contains(str)));
    paramSet.add(str);
    try
    {
      paramLike = new LikeDataModel(ActorDataTransformer.toDataModel(paramFragmentComponent, actor), threadId, createdAt);
      return paramLike;
    }
    catch (UpdateException paramLike)
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException(paramLike));
    }
    return null;
  }
  
  public static List<LikeDataModel> transformLikes(FragmentComponent paramFragmentComponent, List<Like> paramList, Like paramLike, Set<String> paramSet)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramLike = transformLike(paramFragmentComponent, paramLike, paramSet);
    if (paramLike != null) {
      localArrayList.add(paramLike);
    }
    int i = 0;
    while (i < paramList.size())
    {
      paramLike = transformLike(paramFragmentComponent, (Like)paramList.get(i), paramSet);
      if (paramLike != null) {
        localArrayList.add(paramLike);
      }
      i += 1;
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.SocialDetailTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */