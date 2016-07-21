package com.linkedin.android.feed.utils;

import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import com.linkedin.android.entities.utils.FollowingInfoUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata.Builder;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Comments;
import com.linkedin.android.pegasus.gen.voyager.feed.Comments.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Likes;
import com.linkedin.android.pegasus.gen.voyager.feed.Likes.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.MemberActor.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialActor;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialActor.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class CommentModelUtils
{
  public static Comments addCommentToComments(Comments paramComments, Comment paramComment)
    throws BuilderException
  {
    ArrayList localArrayList = new ArrayList(elements);
    localArrayList.add(paramComment);
    paramComment = new CollectionMetadata.Builder(paging).setCount(Integer.valueOf(paging.count + 1)).setTotal(Integer.valueOf(paging.total + 1)).build();
    return new Comments.Builder().setElements(localArrayList).setPaging(paramComment).setMetadata(metadata).build();
  }
  
  public static void displayCommentActionMessage(FragmentComponent paramFragmentComponent, int paramInt1, int paramInt2)
  {
    Object localObject = paramFragmentComponent.i18NManager().getString(paramInt1);
    localObject = paramFragmentComponent.snackbarUtil().make((CharSequence)localObject, 0);
    if (localObject != null) {
      ((Snackbar)localObject).setActionTextColor(ContextCompat.getColor(paramFragmentComponent.context(), paramInt2)).show();
    }
  }
  
  public static CollectionMetadata generateEmptyCollectionMetadata()
    throws BuilderException
  {
    return new CollectionMetadata.Builder().setCount(Integer.valueOf(0)).setStart(Integer.valueOf(0)).setTotal(Integer.valueOf(0)).setLinks(Collections.emptyList()).build(RecordTemplate.Flavor.RECORD);
  }
  
  public static SocialDetail generateEmptySocialDetail(Urn paramUrn, String paramString)
    throws BuilderException
  {
    Comments localComments = new Comments.Builder().setElements(new ArrayList()).setPaging(generateEmptyCollectionMetadata()).build();
    Likes localLikes = new Likes.Builder().setElements(new ArrayList()).setPaging(generateEmptyCollectionMetadata()).build();
    return new SocialDetail.Builder().setUrn(paramUrn).setTotalShares(Integer.valueOf(0)).setLiked(Boolean.valueOf(false)).setLikes(localLikes).setComments(localComments).setThreadId(paramString).setEntityUrn(Urn.createFromTuple("fs_socialDetail", new Object[] { paramUrn })).setTotalSocialActivityCounts(new SocialActivityCounts.Builder().setEntityUrn(Urn.createFromTuple("fs_socialActivityCounts", new Object[] { paramUrn })).setNumComments(Long.valueOf(0L)).setNumLikes(Long.valueOf(0L)).setLiked(Boolean.valueOf(false)).build(RecordTemplate.Flavor.RECORD)).build(RecordTemplate.Flavor.RECORD);
  }
  
  public static SocialActor makeMeSocialActor(MiniProfile paramMiniProfile)
    throws BuilderException
  {
    Object localObject = FollowingInfoUtils.createFollowingMemberInfoUrn(new Object[] { entityUrn.getId() });
    localObject = new FollowingInfo.Builder().setEntityUrn((Urn)localObject).setFollowing(Boolean.valueOf(false)).setFollowerCount(Integer.valueOf(0)).build(RecordTemplate.Flavor.RECORD);
    Urn localUrn = Urn.createFromTuple("member", new Object[] { entityUrn.getId() });
    paramMiniProfile = new MemberActor.Builder().setUrn(localUrn).setMiniProfile(paramMiniProfile).setFollowingInfo((FollowingInfo)localObject).setShowFollowAction(Boolean.valueOf(false)).build(RecordTemplate.Flavor.RECORD);
    return new SocialActor.Builder().setMemberActorValue(paramMiniProfile).build();
  }
  
  private static Comments removeCommentFromComments(Comments paramComments, String paramString)
    throws BuilderException
  {
    ArrayList localArrayList = new ArrayList(elements);
    int k = 0;
    int m = localArrayList.size();
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < m)
      {
        if (paramString.equals(geturn.toString()))
        {
          localArrayList.remove(i);
          j = 0 + 1;
        }
      }
      else
      {
        paramString = new CollectionMetadata.Builder(paging).setCount(Integer.valueOf(paging.count - j)).setTotal(Integer.valueOf(paging.total - j)).build();
        return new Comments.Builder().setElements(localArrayList).setPaging(paramString).setMetadata(metadata).build();
      }
      i += 1;
    }
  }
  
  public static Update removeCommentFromUpdate(Update paramUpdate, String paramString)
  {
    SocialDetail localSocialDetail = socialDetail;
    if ((localSocialDetail == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = removeCommentFromComments(comments, paramString);
      paramString = new SocialDetail.Builder(localSocialDetail).setComments(paramString).setTotalSocialActivityCounts(new SocialActivityCounts.Builder(totalSocialActivityCounts).setNumComments(Long.valueOf(paging.total)).build(RecordTemplate.Flavor.RECORD)).build(RecordTemplate.Flavor.RECORD);
      paramUpdate = new Update.Builder(paramUpdate).setSocialDetail(paramString).build(RecordTemplate.Flavor.RECORD);
      return paramUpdate;
    }
    catch (BuilderException paramUpdate) {}
    return null;
  }
  
  public static Comment removeReplyFromComment(Comment paramComment, String paramString)
  {
    SocialDetail localSocialDetail = socialDetail;
    if ((localSocialDetail == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = removeCommentFromComments(comments, paramString);
      paramString = new SocialDetail.Builder(localSocialDetail).setComments(paramString).setTotalSocialActivityCounts(new SocialActivityCounts.Builder(totalSocialActivityCounts).setNumComments(Long.valueOf(paging.total)).build(RecordTemplate.Flavor.RECORD)).build(RecordTemplate.Flavor.RECORD);
      paramComment = new Comment.Builder(paramComment).setSocialDetail(paramString).build(RecordTemplate.Flavor.RECORD);
      return paramComment;
    }
    catch (BuilderException paramComment) {}
    return null;
  }
  
  public static Update updateCommentWithinUpdate(Update paramUpdate, Comment paramComment1, Comment paramComment2)
  {
    SocialDetail localSocialDetail = socialDetail;
    if ((localSocialDetail == null) || (TextUtils.isEmpty(urn.toString())))
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Unable to update comment within update"));
      return paramUpdate;
    }
    ArrayList localArrayList = new ArrayList(comments.elements);
    int i = 0;
    int j = localArrayList.size();
    for (;;)
    {
      if (i < j)
      {
        Comment localComment = (Comment)localArrayList.get(i);
        if (!urn.equals(urn)) {
          break label170;
        }
        localArrayList.set(i, paramComment1);
      }
      try
      {
        paramComment1 = new Comments.Builder(comments).setElements(localArrayList).build();
        paramComment1 = new SocialDetail.Builder(localSocialDetail).setComments(paramComment1).build(RecordTemplate.Flavor.RECORD);
        paramUpdate = new Update.Builder(paramUpdate).setSocialDetail(paramComment1).build();
        return paramUpdate;
      }
      catch (BuilderException paramUpdate)
      {
        label170:
        Util.safeThrow$7a8b4789(new RuntimeException("Unable to update comment within update"));
      }
      i += 1;
    }
    return null;
  }
  
  public static Comment updateReplyWithinComment(Comment paramComment1, Comment paramComment2, Comment paramComment3)
  {
    SocialDetail localSocialDetail = socialDetail;
    if ((localSocialDetail == null) || (TextUtils.isEmpty(urn.toString())))
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Unable to update reply within comment"));
      return paramComment1;
    }
    ArrayList localArrayList = new ArrayList(comments.elements);
    int i = 0;
    int j = localArrayList.size();
    for (;;)
    {
      if (i < j)
      {
        Comment localComment = (Comment)localArrayList.get(i);
        if (!urn.equals(urn)) {
          break label170;
        }
        localArrayList.set(i, paramComment2);
      }
      try
      {
        paramComment2 = new Comments.Builder(comments).setElements(localArrayList).build();
        paramComment2 = new SocialDetail.Builder(localSocialDetail).setComments(paramComment2).build(RecordTemplate.Flavor.RECORD);
        paramComment1 = new Comment.Builder(paramComment1).setSocialDetail(paramComment2).build();
        return paramComment1;
      }
      catch (BuilderException paramComment1)
      {
        label170:
        Util.safeThrow$7a8b4789(new RuntimeException("Unable to update reply within comment"));
      }
      i += 1;
    }
    return null;
  }
  
  public static Comments upsertCommentToComments(Comments paramComments, Comment paramComment)
    throws BuilderException
  {
    ArrayList localArrayList = new ArrayList(elements);
    int j = 0;
    int i = 0;
    while (i < elements.size())
    {
      if (Util.safeEquals(urn, elements.get(i)).urn))
      {
        localArrayList.set(i, paramComment);
        j = 1;
      }
      i += 1;
    }
    if (j != 0) {
      return new Comments.Builder(paramComments).setElements(localArrayList).build();
    }
    return addCommentToComments(paramComments, paramComment);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.CommentModelUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */