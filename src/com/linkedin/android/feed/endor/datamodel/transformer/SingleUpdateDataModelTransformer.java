package com.linkedin.android.feed.endor.datamodel.transformer;

import android.os.Build.VERSION;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.AppActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.ChannelActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.AnnotatedTextContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ArticleContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.EmptyContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.NativeVideoContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.PropContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.TextContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentArticleDataModel;
import com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentImageDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ChannelSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.CrossPromoSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.DiscussionSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.LyndaSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.MentionedInNewsUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.PromptResponseSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.PropSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ReshareSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ViralSingleUpdateDataModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedTextUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.AppActor;
import com.linkedin.android.pegasus.gen.voyager.feed.ArticleUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.ArticleUpdate.Content;
import com.linkedin.android.pegasus.gen.voyager.feed.ChannelActor;
import com.linkedin.android.pegasus.gen.voyager.feed.ChannelUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate.Content;
import com.linkedin.android.pegasus.gen.voyager.feed.DiscussionBase;
import com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdateContent.Content;
import com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithArticle;
import com.linkedin.android.pegasus.gen.voyager.feed.DiscussionWithImage;
import com.linkedin.android.pegasus.gen.voyager.feed.LyndaUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.MentionedInNewsUpdate.MentionedActor;
import com.linkedin.android.pegasus.gen.voyager.feed.PromptResponse;
import com.linkedin.android.pegasus.gen.voyager.feed.PromptResponse.Actor;
import com.linkedin.android.pegasus.gen.voyager.feed.PromptResponse.Content;
import com.linkedin.android.pegasus.gen.voyager.feed.PromptResponseUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.PropUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Reshare;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareNativeVideo;
import com.linkedin.android.pegasus.gen.voyager.feed.ShareUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate.ViralType;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropType;
import java.util.List;

public final class SingleUpdateDataModelTransformer
{
  public static SingleUpdateDataModel toDataModel(FragmentComponent paramFragmentComponent, Update paramUpdate, FeedDataModelMetadata paramFeedDataModelMetadata)
    throws UpdateException
  {
    int j = FeedTracking.getSponsoredRenderFormatInt(tracking);
    if (value.aggregatedJymbiiUpdateValue != null) {
      throw new UpdateException("use the AggregatedUpdateDataModelTransformer for this update!");
    }
    if (value.aggregatedShareContentUpdateValue != null) {
      throw new UpdateException("use the AggregatedUpdateDataModelTransformer for this update!");
    }
    if (value.articleUpdateValue != null) {
      throw new UpdateException("We should never get this, blame Caitlin!!");
    }
    Object localObject2;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    if (value.channelUpdateValue != null)
    {
      localObject2 = value.channelUpdateValue;
      if ((articleUpdate != null) && (articleUpdate.value.articleUpdateValue != null))
      {
        localObject1 = articleUpdate.value.articleUpdateValue.content;
        if (shareArticleValue != null) {
          localObject1 = ShareUpdateContentTransformer.toDataModel(paramFragmentComponent, shareArticleValue);
        }
      }
      for (;;)
      {
        localObject3 = actor;
        localObject4 = channel;
        paramFragmentComponent.i18NManager();
        localObject3 = new ChannelActorDataModel((Channel)localObject4, channel.name, channel.followingInfo, Util.retrieveRumSessionId(paramFragmentComponent));
        return new ChannelSingleUpdateDataModel(paramUpdate, UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, (ActorDataModel)localObject3), j, createdTime, (ChannelActorDataModel)localObject3, (AnnotatedTextContentDataModel)localObject1, SocialDetailTransformer.toDataModel(paramFragmentComponent, paramUpdate, socialDetail, paramFeedDataModelMetadata), FeedTextUtils.getSpannableTextFromAnnotatedText(header, paramUpdate, paramFragmentComponent, false, false, true));
        if (shareVideoValue != null)
        {
          localObject1 = ShareUpdateContentTransformer.toDataModel(shareVideoValue);
        }
        else
        {
          throw new UpdateException("unknown article update content");
          localObject1 = ShareUpdateContentTransformer.toDataModel(paramFragmentComponent, content);
        }
      }
    }
    long l;
    if (value.discussionUpdateValue != null)
    {
      localObject2 = value.discussionUpdateValue;
      localObject3 = ActorDataTransformer.toDataModel(paramFragmentComponent, actor);
      localObject4 = UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, (ActorDataModel)localObject3);
      l = createdTime;
      Object localObject5 = content;
      localObject1 = miniGroup;
      if (discussionBaseValue != null)
      {
        localObject5 = discussionBaseValue;
        localObject1 = new GroupDiscussionContentDataModel(body, title, (MiniGroup)localObject1);
      }
      for (;;)
      {
        return new DiscussionSingleUpdateDataModel(paramUpdate, (List)localObject4, j, l, (ActorDataModel)localObject3, (GroupDiscussionContentDataModel)localObject1, SocialDetailTransformer.toDataModel(paramFragmentComponent, paramUpdate, socialDetail, paramFeedDataModelMetadata), featured, active, discussionSource);
        if (discussionWithArticleValue != null)
        {
          localObject5 = discussionWithArticleValue;
          localObject1 = new GroupDiscussionContentArticleDataModel(body, title, contentId, contentUrl, contentTitle, contentSource, contentDescription, contentImage, (MiniGroup)localObject1);
        }
        else
        {
          if (discussionWithImageValue == null) {
            break;
          }
          localObject5 = discussionWithImageValue;
          localObject1 = new GroupDiscussionContentImageDataModel(body, title, contentId, contentUrl, contentImage, (MiniGroup)localObject1);
        }
      }
      throw new UpdateException("unknown discussion update content");
    }
    if (value.jymbiiUpdateValue != null) {
      throw new UpdateException("use the AggregatedUpdateDataModelTransformer for this update");
    }
    if (value.mentionedInNewsUpdateValue != null)
    {
      localObject2 = value.mentionedInNewsUpdateValue;
      localObject3 = ShareUpdateContentTransformer.toDataModel(paramFragmentComponent, article);
      localObject1 = mentionedActor;
      if (memberActorValue != null) {
        localObject1 = ActorDataTransformer.toDataModel(paramFragmentComponent, memberActorValue, null);
      }
      for (;;)
      {
        return new MentionedInNewsUpdateDataModel(paramUpdate, UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, (ActorDataModel)localObject1), j, (ActorDataModel)localObject1, (ArticleContentDataModel)localObject3, SocialDetailTransformer.toDataModel(paramFragmentComponent, paramUpdate, socialDetail, paramFeedDataModelMetadata), header);
        if (influencerActorValue != null)
        {
          localObject1 = ActorDataTransformer.toDataModel(paramFragmentComponent, influencerActorValue, null);
        }
        else
        {
          if (companyActorValue == null) {
            break;
          }
          localObject1 = ActorDataTransformer.toDataModel(paramFragmentComponent, companyActorValue);
        }
      }
      throw new UpdateException("unknown mentioned actor");
    }
    if (value.reshareValue != null)
    {
      localObject2 = value.reshareValue;
      localObject1 = toDataModel(paramFragmentComponent, originalUpdate, paramFeedDataModelMetadata);
      if ((!"enabled".equals(paramFragmentComponent.lixManager().getTreatment(Lix.FEED_RESHARE_ON_RESHARE_WRITES))) || (!(localObject1 instanceof ReshareSingleUpdateDataModel))) {
        break label1821;
      }
      localObject1 = originalUpdate;
    }
    label1110:
    label1306:
    label1664:
    label1821:
    for (;;)
    {
      localObject3 = ActorDataTransformer.toDataModel(paramFragmentComponent, actor);
      return new ReshareSingleUpdateDataModel(paramUpdate, UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, (ActorDataModel)localObject3), j, createdTime, (ActorDataModel)localObject3, new AnnotatedTextContentDataModel(text), SocialDetailTransformer.toDataModel(paramFragmentComponent, paramUpdate, socialDetail, paramFeedDataModelMetadata), (SingleUpdateDataModel)localObject1, header);
      if (value.shareUpdateValue != null)
      {
        localObject1 = value.shareUpdateValue;
        localObject2 = ActorDataTransformer.toDataModel(paramFragmentComponent, actor);
        return new SingleUpdateDataModel(paramUpdate, UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, (ActorDataModel)localObject2), j, createdTime, (ActorDataModel)localObject2, ShareUpdateContentTransformer.toDataModel(paramFragmentComponent, content), SocialDetailTransformer.toDataModel(paramFragmentComponent, paramUpdate, socialDetail, paramFeedDataModelMetadata));
      }
      if (value.viralUpdateValue != null)
      {
        localObject1 = value.viralUpdateValue;
        int i = 0;
        if (viralType.viralLikeTypeValue != null)
        {
          i = 1;
          localObject2 = toDataModel(paramFragmentComponent, originalUpdate, paramFeedDataModelMetadata);
          localObject3 = ActorDataTransformer.toDataModel(paramFragmentComponent, actor);
          if (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_USE_VIRAL_UPDATE_IN_DETAIL)) {
            break label1110;
          }
        }
        for (paramFeedDataModelMetadata = SocialDetailTransformer.toDataModel(paramFragmentComponent, paramUpdate, socialDetail, paramFeedDataModelMetadata);; paramFeedDataModelMetadata = SocialDetailTransformer.toDataModel(paramFragmentComponent, paramUpdate, originalUpdate.socialDetail, paramFeedDataModelMetadata))
        {
          return new ViralSingleUpdateDataModel(paramUpdate, UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, (ActorDataModel)localObject3), j, createdTimestamp, (ActorDataModel)localObject3, content, paramFeedDataModelMetadata, (SingleUpdateDataModel)localObject2, i, header);
          if (viralType.viralCommentTypeValue == null) {
            break;
          }
          i = 2;
          break;
        }
      }
      if (value.propUpdateValue != null)
      {
        localObject2 = value.propUpdateValue;
        localObject3 = ActorDataTransformer.toDataModel(paramFragmentComponent, actor);
        localObject1 = null;
        if (type == PropType.JOB_CHANGE)
        {
          localObject1 = paramFragmentComponent.i18NManager().getString(2131231269);
          localObject4 = UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, (ActorDataModel)localObject3);
          if (!hasCreatedAt) {
            break label1306;
          }
        }
        for (l = createdAt;; l = -1L)
        {
          return new PropSingleUpdateDataModel(paramUpdate, (List)localObject4, j, l, (ActorDataModel)localObject3, new PropContentDataModel(text, subtext), SocialDetailTransformer.toDataModel(paramFragmentComponent, paramUpdate, socialDetail, paramFeedDataModelMetadata), FeedTextUtils.getSpannableTextFromAnnotatedText(header, paramUpdate, paramFragmentComponent, false, false, true), type, (CharSequence)localObject1);
          if (type != PropType.WORK_ANNIVERSARY) {
            break;
          }
          localObject1 = paramFragmentComponent.i18NManager().getString(2131231270);
          break;
        }
      }
      if (value.connectionUpdateValue != null) {
        throw new UpdateException("We don't support single ConnectionUpdate! It should come in AggregatedConnectionUpdate.");
      }
      if (value.crossPromoUpdateValue != null)
      {
        localObject1 = value.crossPromoUpdateValue;
        paramFeedDataModelMetadata = actor;
        localObject2 = Util.retrieveRumSessionId(paramFragmentComponent);
        localObject2 = new AppActorDataModel(paramFeedDataModelMetadata, appId, appName, subtitle, appName, appIcon, storeUrl, (String)localObject2);
        localObject3 = UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, (ActorDataModel)localObject2);
        if (content != null)
        {
          paramFeedDataModelMetadata = content;
          if (shareArticleValue != null) {
            paramFeedDataModelMetadata = ShareUpdateContentTransformer.toDataModel(paramFragmentComponent, shareArticleValue);
          }
        }
        for (;;)
        {
          return new CrossPromoSingleUpdateDataModel(paramUpdate, (List)localObject3, j, (AppActorDataModel)localObject2, paramFeedDataModelMetadata, FeedTextUtils.getSpannableTextFromAnnotatedText$6851e591(header, paramUpdate, paramFragmentComponent));
          if (shareJobValue != null)
          {
            paramFeedDataModelMetadata = ShareUpdateContentTransformer.toDataModel(paramFragmentComponent, shareJobValue);
          }
          else
          {
            throw new UpdateException("unknown cross promo update content");
            if (text != null) {
              paramFeedDataModelMetadata = new TextContentDataModel(text);
            } else {
              paramFeedDataModelMetadata = EmptyContentDataModel.DEFAULT;
            }
          }
        }
      }
      if (value.promptResponseUpdateValue != null)
      {
        localObject2 = value.promptResponseUpdateValue;
        localObject1 = response.actor;
        if (memberActorValue != null) {}
        for (localObject1 = ActorDataTransformer.toDataModel(paramFragmentComponent, memberActorValue, null);; localObject1 = ActorDataTransformer.toDataModel(paramFragmentComponent, influencerActorValue, null))
        {
          localObject3 = UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, (ActorDataModel)localObject1);
          l = createdAt;
          localObject4 = response.content;
          if (shareNativeVideoValue != null) {
            break label1664;
          }
          throw new UpdateException("Unknown prompt response update content");
          if (influencerActorValue == null) {
            break;
          }
        }
        throw new UpdateException("Unknown prompt response actor");
        localObject4 = shareNativeVideoValue;
        if ((Build.VERSION.SDK_INT < 16) && (url == null)) {
          throw new UpdateException("low-end device has a prompt response update with no watch page url");
        }
        return new PromptResponseSingleUpdateDataModel(paramUpdate, (List)localObject3, j, l, (ActorDataModel)localObject1, new NativeVideoContentDataModel(url, videoPlayMetadata, text), SocialDetailTransformer.toDataModel(paramFragmentComponent, paramUpdate, socialDetail, paramFeedDataModelMetadata), prompt);
      }
      if (value.lyndaUpdateValue != null)
      {
        paramFeedDataModelMetadata = value.lyndaUpdateValue;
        return new LyndaSingleUpdateDataModel(paramUpdate, UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, null), j, ShareUpdateContentTransformer.toDataModel(content), AttributedTextUtils.getAttributedString(header, paramFragmentComponent.context()));
      }
      throw new UpdateException("Unknown update type!");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.SingleUpdateDataModelTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */