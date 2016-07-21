package com.linkedin.android.feed.utils;

import com.linkedin.android.entities.utils.FollowingInfoUtils;
import com.linkedin.android.infra.data.OptimisticWrite;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata.Builder;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo.Builder;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.ArticleType;
import com.linkedin.android.pegasus.gen.voyager.feed.Comments;
import com.linkedin.android.pegasus.gen.voyager.feed.Comments.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Like.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Likes.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.MemberActor.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Reshare.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareArticle.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareAudience;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareImage.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareText.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdateContent.Content;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdateContent.Content.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialActor;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialActor.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.PreviewImage.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FeedModelGenUtils
{
  public static UrlPreviewData convertArticleToUrlPreviewData(ShareArticle paramShareArticle)
  {
    Object localObject1 = null;
    for (;;)
    {
      Object localObject2;
      Urn localUrn;
      try
      {
        if (image != null)
        {
          localObject1 = new PreviewImage.Builder();
          localObject2 = image;
          if (localObject2 == null)
          {
            hasMediaProxyImage = false;
            mediaProxyImage = null;
            localObject2 = image;
            if (localObject2 != null) {
              break label255;
            }
            hasOriginalImage = false;
            originalImage = null;
            localObject1 = Collections.singletonList(((PreviewImage.Builder)localObject1).build(RecordTemplate.Flavor.RECORD));
          }
        }
        else
        {
          localObject2 = new UrlPreviewData.Builder();
          localUrn = urn;
          if (localUrn != null) {
            break label268;
          }
          hasUrn = false;
          urn = null;
          if ((localObject1 != null) && (!((List)localObject1).equals(Collections.emptyList()))) {
            break label281;
          }
          hasPreviewImages = false;
          previewImages = Collections.emptyList();
          localObject2 = ((UrlPreviewData.Builder)localObject2).setUrl(url);
          if (resolvedUrl != null) {
            break label294;
          }
          localObject1 = url;
          if (localObject1 != null) {
            break label302;
          }
          hasResolvedUrl = false;
          resolvedUrl = null;
          localObject1 = title;
          if (localObject1 != null) {
            break label315;
          }
          hasTitle = false;
          title = null;
          localObject1 = description;
          if (localObject1 != null) {
            break label328;
          }
          hasDescription = false;
          description = null;
          if (subtitle == null) {
            break label354;
          }
          paramShareArticle = subtitle;
          if (paramShareArticle != null) {
            break label341;
          }
          hasSource = false;
          source = null;
          return ((UrlPreviewData.Builder)localObject2).build(RecordTemplate.Flavor.RECORD);
        }
        hasMediaProxyImage = true;
        mediaProxyImage = ((Image)localObject2);
        continue;
        hasOriginalImage = true;
      }
      catch (BuilderException paramShareArticle)
      {
        Util.safeThrow$7a8b4789(new RuntimeException(paramShareArticle));
        return null;
      }
      label255:
      originalImage = ((Image)localObject2);
      continue;
      label268:
      hasUrn = true;
      urn = localUrn;
      continue;
      label281:
      hasPreviewImages = true;
      previewImages = ((List)localObject1);
      continue;
      label294:
      localObject1 = resolvedUrl;
      continue;
      label302:
      hasResolvedUrl = true;
      resolvedUrl = ((String)localObject1);
      continue;
      label315:
      hasTitle = true;
      title = ((String)localObject1);
      continue;
      label328:
      hasDescription = true;
      description = ((String)localObject1);
      continue;
      label341:
      hasSource = true;
      source = paramShareArticle;
      continue;
      label354:
      paramShareArticle = "";
    }
  }
  
  public static SocialDetail createFakeSocialDetailWithMyLike(MiniProfile paramMiniProfile, SocialActivityCounts paramSocialActivityCounts, String paramString)
  {
    if (paramSocialActivityCounts == null) {
      return null;
    }
    try
    {
      paramMiniProfile = CommentModelUtils.makeMeSocialActor(paramMiniProfile);
      Object localObject = OptimisticWrite.generateTemporaryUrn("like");
      paramMiniProfile = new Like.Builder().setUrn((Urn)localObject).setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { ((Urn)localObject).getId() })).setActor(paramMiniProfile).build(RecordTemplate.Flavor.RECORD);
      localObject = new ArrayList();
      ((List)localObject).add(paramMiniProfile);
      paramMiniProfile = new Likes.Builder().setElements((List)localObject).setPaging(CommentModelUtils.generateEmptyCollectionMetadata()).build();
      localObject = new Comments.Builder().setElements(new ArrayList()).setPaging(CommentModelUtils.generateEmptyCollectionMetadata()).build();
      paramMiniProfile = new SocialDetail.Builder().setEntityUrn(Urn.createFromTuple("socialDetail", new Object[] { entityUrn.getId() })).setTotalSocialActivityCounts(paramSocialActivityCounts).setLikes(paramMiniProfile).setComments((Comments)localObject).setThreadId(paramString).build(RecordTemplate.Flavor.RECORD);
      return paramMiniProfile;
    }
    catch (BuilderException paramMiniProfile)
    {
      Log.e(paramMiniProfile.getMessage());
    }
    return null;
  }
  
  private static ShareUpdate editShareUpdateText(ShareUpdate paramShareUpdate, AnnotatedText paramAnnotatedText)
  {
    ShareUpdateContent.Content localContent = null;
    ShareUpdateContent.Content.Builder localBuilder = new ShareUpdateContent.Content.Builder();
    try
    {
      if (content.shareTextValue != null) {
        localContent = localBuilder.setShareTextValue(new ShareText.Builder().setText(paramAnnotatedText).build(RecordTemplate.Flavor.RECORD)).build();
      }
      while (localContent == null)
      {
        Util.safeThrow$7a8b4789(new RuntimeException("Trying to edit contents of an unsupported content type. Supported content types are: text, images, articles"));
        return null;
        if (content.shareArticleValue != null) {
          localContent = localBuilder.setShareArticleValue(new ShareArticle.Builder(content.shareArticleValue).setText(paramAnnotatedText).build(RecordTemplate.Flavor.RECORD)).build();
        } else if (content.shareImageValue != null) {
          localContent = localBuilder.setShareImageValue(new ShareImage.Builder(content.shareImageValue).setText(paramAnnotatedText).build(RecordTemplate.Flavor.RECORD)).build();
        }
      }
      paramShareUpdate = new ShareUpdate.Builder(paramShareUpdate).setContent(localContent);
      paramAnnotatedText = Boolean.valueOf(true);
      if (paramAnnotatedText == null) {
        hasEdited = false;
      }
      for (edited = false;; edited = paramAnnotatedText.booleanValue())
      {
        return paramShareUpdate.build();
        hasEdited = true;
      }
      return null;
    }
    catch (BuilderException paramShareUpdate)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Edit share failed - could not build ShareUpdate model."));
    }
  }
  
  public static Update editUpdateText(Update paramUpdate, AnnotatedText paramAnnotatedText)
  {
    try
    {
      if (value.shareUpdateValue != null)
      {
        paramAnnotatedText = editShareUpdateText(value.shareUpdateValue, paramAnnotatedText);
        paramAnnotatedText = new Update.Value.Builder().setShareUpdateValue(paramAnnotatedText).build();
        return new Update.Builder(paramUpdate).setValue(paramAnnotatedText).build(RecordTemplate.Flavor.RECORD);
      }
      if (value.reshareValue != null)
      {
        Reshare.Builder localBuilder = new Reshare.Builder(value.reshareValue);
        Boolean localBoolean = Boolean.valueOf(true);
        if (localBoolean == null) {
          hasEdited = false;
        }
        for (edited = false;; edited = localBoolean.booleanValue())
        {
          paramAnnotatedText = localBuilder.setText(paramAnnotatedText).build(RecordTemplate.Flavor.RECORD);
          paramAnnotatedText = new Update.Value.Builder().setReshareValue(paramAnnotatedText).build();
          return new Update.Builder(paramUpdate).setValue(paramAnnotatedText).build(RecordTemplate.Flavor.RECORD);
          hasEdited = true;
        }
      }
      return null;
    }
    catch (BuilderException paramUpdate)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Failed to edit text in Update model"));
    }
  }
  
  private static CollectionMetadata generateEmptyCollectionMetadata()
  {
    try
    {
      CollectionMetadata localCollectionMetadata = new CollectionMetadata.Builder().setStart(Integer.valueOf(0)).setCount(Integer.valueOf(0)).setTotal(Integer.valueOf(0)).setLinks(Collections.emptyList()).build(RecordTemplate.Flavor.RECORD);
      return localCollectionMetadata;
    }
    catch (BuilderException localBuilderException)
    {
      Util.safeThrow(new RuntimeException(localBuilderException));
    }
    return null;
  }
  
  public static SocialDetail generateEmptySocialDetail(Urn paramUrn, String paramString)
  {
    try
    {
      String str = paramUrn.getId();
      paramUrn = new SocialDetail.Builder().setUrn(paramUrn).setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { str })).setTotalShares(Integer.valueOf(0)).setLiked(Boolean.valueOf(false)).setLikes(new Likes.Builder().setElements(Collections.emptyList()).setPaging(generateEmptyCollectionMetadata()).build(RecordTemplate.Flavor.RECORD)).setComments(new Comments.Builder().setElements(Collections.emptyList()).setPaging(generateEmptyCollectionMetadata()).build(RecordTemplate.Flavor.RECORD)).setThreadId(paramString).setTotalSocialActivityCounts(new SocialActivityCounts.Builder().setEntityUrn(Urn.createFromTuple("fs_socialActivityCounts", new Object[] { paramUrn })).setNumComments(Long.valueOf(0L)).setNumLikes(Long.valueOf(0L)).setLiked(Boolean.valueOf(false)).build(RecordTemplate.Flavor.RECORD)).build(RecordTemplate.Flavor.RECORD);
      return paramUrn;
    }
    catch (BuilderException paramUrn)
    {
      Util.safeThrow(new RuntimeException(paramUrn));
    }
    return null;
  }
  
  public static Update generateReshareUpdate(Update paramUpdate, AnnotatedText paramAnnotatedText, MiniProfile paramMiniProfile)
  {
    return generateReshareUpdate(paramUpdate, paramAnnotatedText, paramMiniProfile, ShareAudience.PUBLIC);
  }
  
  private static Update generateReshareUpdate(Update paramUpdate, AnnotatedText paramAnnotatedText, MiniProfile paramMiniProfile, ShareAudience paramShareAudience)
  {
    for (;;)
    {
      Reshare.Builder localBuilder;
      try
      {
        Urn localUrn = OptimisticWrite.generateTemporaryUrn("activity");
        localBuilder = new Reshare.Builder();
        if (localUrn == null)
        {
          hasUrn = false;
          urn = null;
          if (paramUpdate == null)
          {
            hasOriginalUpdate = false;
            originalUpdate = null;
            if (paramShareAudience != null) {
              break label280;
            }
            hasShareAudience = false;
            shareAudience = null;
            paramUpdate = Collections.emptyList();
            if ((paramUpdate != null) && (!paramUpdate.equals(Collections.emptyList()))) {
              break label295;
            }
            hasActions = false;
            actions = Collections.emptyList();
            paramUpdate = generateSocialMemberActor(paramMiniProfile);
            if (paramUpdate != null) {
              break label310;
            }
            hasActor = false;
            actor = null;
            paramUpdate = Long.valueOf(System.currentTimeMillis());
            if (paramUpdate != null) {
              break label325;
            }
            hasCreatedTime = false;
            createdTime = 0L;
            paramUpdate = localBuilder.setText(paramAnnotatedText).build(RecordTemplate.Flavor.RECORD);
            paramUpdate = new Update.Value.Builder().setReshareValue(paramUpdate).build();
            return new Update.Builder().setUrn(localUrn).setSocialDetail(generateEmptySocialDetail(localUrn, localUrn.toString())).setValue(paramUpdate).setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { localUrn.getId() })).setIsSponsored(Boolean.valueOf(false)).build(RecordTemplate.Flavor.RECORD);
          }
        }
        else
        {
          hasUrn = true;
          urn = localUrn;
          continue;
        }
        hasOriginalUpdate = true;
      }
      catch (BuilderException paramUpdate)
      {
        Util.safeThrow(new RuntimeException(paramUpdate));
        return null;
      }
      originalUpdate = paramUpdate;
      continue;
      label280:
      hasShareAudience = true;
      shareAudience = paramShareAudience;
      continue;
      label295:
      hasActions = true;
      actions = paramUpdate;
      continue;
      label310:
      hasActor = true;
      actor = paramUpdate;
      continue;
      label325:
      hasCreatedTime = true;
      createdTime = paramUpdate.longValue();
    }
  }
  
  public static ShareUpdateContent.Content generateShareArticle(Urn paramUrn, AnnotatedText paramAnnotatedText, Image paramImage, ArticleType paramArticleType, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    for (;;)
    {
      ShareArticle.Builder localBuilder1;
      try
      {
        ShareUpdateContent.Content.Builder localBuilder = new ShareUpdateContent.Content.Builder();
        localBuilder1 = new ShareArticle.Builder();
        if (paramUrn == null)
        {
          hasUrn = false;
          urn = null;
          if (paramString1 == null)
          {
            hasTitle = false;
            title = null;
            if (paramString2 != null) {
              break label213;
            }
            hasSubtitle = false;
            subtitle = null;
            if (paramString3 != null) {
              break label229;
            }
            hasUrl = false;
            url = null;
            if (paramString4 != null) {
              break label245;
            }
            hasResolvedUrl = false;
            resolvedUrl = null;
            paramUrn = localBuilder1.setText(paramAnnotatedText);
            if (paramImage != null) {
              break label261;
            }
            hasImage = false;
            image = null;
            if (paramArticleType != null) {
              break label274;
            }
            hasArticleType = false;
            articleType = null;
            if (paramString5 != null) {
              break label287;
            }
            hasDescription = false;
            description = null;
            return localBuilder.setShareArticleValue(paramUrn.build(RecordTemplate.Flavor.RECORD)).build();
          }
        }
        else
        {
          hasUrn = true;
          urn = paramUrn;
          continue;
        }
        hasTitle = true;
      }
      catch (BuilderException paramUrn)
      {
        Util.safeThrow(new RuntimeException(paramUrn));
        return null;
      }
      title = paramString1;
      continue;
      label213:
      hasSubtitle = true;
      subtitle = paramString2;
      continue;
      label229:
      hasUrl = true;
      url = paramString3;
      continue;
      label245:
      hasResolvedUrl = true;
      resolvedUrl = paramString4;
      continue;
      label261:
      hasImage = true;
      image = paramImage;
      continue;
      label274:
      hasArticleType = true;
      articleType = paramArticleType;
      continue;
      label287:
      hasDescription = true;
      description = paramString5;
    }
  }
  
  public static ShareUpdateContent.Content generateShareImage(AnnotatedText paramAnnotatedText, Image paramImage, String paramString1, String paramString2)
  {
    try
    {
      paramAnnotatedText = new ShareUpdateContent.Content.Builder().setShareImageValue(new ShareImage.Builder().setText(paramAnnotatedText).setContentType(paramString1).setImage(paramImage).setFileId(paramString2).build(RecordTemplate.Flavor.RECORD)).build();
      return paramAnnotatedText;
    }
    catch (BuilderException paramAnnotatedText)
    {
      Util.safeThrow(new RuntimeException(paramAnnotatedText));
    }
    return null;
  }
  
  public static ShareUpdateContent.Content generateShareText(AnnotatedText paramAnnotatedText)
  {
    try
    {
      paramAnnotatedText = new ShareUpdateContent.Content.Builder().setShareTextValue(new ShareText.Builder().setText(paramAnnotatedText).build(RecordTemplate.Flavor.RECORD)).build();
      return paramAnnotatedText;
    }
    catch (BuilderException paramAnnotatedText)
    {
      Util.safeThrow(new RuntimeException(paramAnnotatedText));
    }
    return null;
  }
  
  public static Update generateShareUpdate(ShareUpdateContent.Content paramContent, MiniProfile paramMiniProfile, ShareAudience paramShareAudience)
  {
    for (;;)
    {
      try
      {
        Urn localUrn = OptimisticWrite.generateTemporaryUrn("activity");
        String str = localUrn.getId();
        ShareUpdate.Builder localBuilder = new ShareUpdate.Builder();
        if (localUrn == null)
        {
          hasUrn = false;
          urn = null;
          paramContent = localBuilder.setContent(paramContent);
          if (paramShareAudience == null)
          {
            hasShareAudience = false;
            shareAudience = null;
            paramShareAudience = Collections.emptyList();
            if ((paramShareAudience != null) && (!paramShareAudience.equals(Collections.emptyList()))) {
              break label251;
            }
            hasActions = false;
            actions = Collections.emptyList();
            paramMiniProfile = generateSocialMemberActor(paramMiniProfile);
            if (paramMiniProfile != null) {
              break label264;
            }
            hasActor = false;
            actor = null;
            paramMiniProfile = Long.valueOf(System.currentTimeMillis());
            if (paramMiniProfile != null) {
              break label277;
            }
            hasCreatedTime = false;
            createdTime = 0L;
            paramContent = paramContent.build(RecordTemplate.Flavor.RECORD);
            paramContent = new Update.Value.Builder().setShareUpdateValue(paramContent).build();
            return new Update.Builder().setUrn(localUrn).setSocialDetail(generateEmptySocialDetail(localUrn, str)).setValue(paramContent).setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { str })).setIsSponsored(Boolean.valueOf(false)).build(RecordTemplate.Flavor.RECORD);
          }
        }
        else
        {
          hasUrn = true;
          urn = localUrn;
          continue;
        }
        hasShareAudience = true;
      }
      catch (BuilderException paramContent)
      {
        Util.safeThrow(new RuntimeException(paramContent));
        return null;
      }
      shareAudience = paramShareAudience;
      continue;
      label251:
      hasActions = true;
      actions = paramShareAudience;
      continue;
      label264:
      hasActor = true;
      actor = paramMiniProfile;
      continue;
      label277:
      hasCreatedTime = true;
      createdTime = paramMiniProfile.longValue();
    }
  }
  
  public static SocialActor generateSocialMemberActor(MiniProfile paramMiniProfile)
  {
    try
    {
      Object localObject = FollowingInfoUtils.createFollowingMemberInfoUrn(new Object[] { entityUrn.getId() });
      localObject = new FollowingInfo.Builder().setEntityUrn((Urn)localObject).setFollowing(Boolean.valueOf(false)).setFollowerCount(Integer.valueOf(0)).build(RecordTemplate.Flavor.RECORD);
      Urn localUrn = Urn.createFromTuple("member", new Object[] { entityUrn.getId() });
      paramMiniProfile = new MemberActor.Builder().setUrn(localUrn).setMiniProfile(paramMiniProfile).setFollowingInfo((FollowingInfo)localObject).setShowFollowAction(Boolean.valueOf(false)).build(RecordTemplate.Flavor.RECORD);
      paramMiniProfile = new SocialActor.Builder().setMemberActorValue(paramMiniProfile).build();
      return paramMiniProfile;
    }
    catch (BuilderException paramMiniProfile)
    {
      Util.safeThrow(new RuntimeException(paramMiniProfile));
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedModelGenUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */