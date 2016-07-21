package com.linkedin.android.feed.endor.ui.component.comment;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ArticleContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.VideoContentDataModel;
import com.linkedin.android.feed.endor.datamodel.social.CommentDataModel;
import com.linkedin.android.feed.endor.datamodel.transformer.SingleUpdateDataModelTransformer;
import com.linkedin.android.feed.endor.datamodel.transformer.SocialDetailTransformer;
import com.linkedin.android.feed.endor.datamodel.transformer.UpdateException;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.transformer.service.TransformerExecutor;
import com.linkedin.android.feed.endor.datamodel.update.single.ChannelSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.MentionedInNewsUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewModel;
import com.linkedin.android.feed.endor.ui.component.componentlist.FeedComponentListViewModel;
import com.linkedin.android.feed.endor.ui.component.divider.FeedDividerLayout;
import com.linkedin.android.feed.endor.ui.component.divider.FeedDividerViewModel;
import com.linkedin.android.feed.endor.ui.component.header.FeedHeaderLayout;
import com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewModel;
import com.linkedin.android.feed.endor.ui.transformer.FeedTransformerUtils;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.updates.common.comment.detail.CommentHeaderTitleShareSpan;
import com.linkedin.android.feed.utils.FeedI18NUtils;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedTextUtils;
import com.linkedin.android.feed.utils.FeedUpdateUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.OptimisticWrite;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.DateUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.spans.EntityClickableSpan;
import com.linkedin.android.infra.ui.spans.UrlSpan;
import com.linkedin.android.pegasus.gen.voyager.feed.ArticleType;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Comments;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.SocialActivityCounts;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class FeedCommentTransformer
  extends FeedTransformerUtils
{
  private static boolean isHighlightedComment(CommentDataModel paramCommentDataModel, FeedDataModelMetadata paramFeedDataModelMetadata)
  {
    String[] arrayOfString;
    int j;
    int i;
    if ((parentCommentUrn != null) && (highlightedReplyUrns != null))
    {
      arrayOfString = highlightedReplyUrns;
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((str != null) && (str.equals(commentUrn))) {
          return true;
        }
        i += 1;
      }
    }
    if ((parentCommentUrn == null) && (highlightedReplyUrns == null) && (highlightedCommentUrns != null))
    {
      paramFeedDataModelMetadata = highlightedCommentUrns;
      j = paramFeedDataModelMetadata.length;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label128;
        }
        arrayOfString = paramFeedDataModelMetadata[i];
        if ((arrayOfString != null) && (arrayOfString.equals(commentUrn))) {
          break;
        }
        i += 1;
      }
    }
    label128:
    return false;
  }
  
  private static FeedHeaderViewModel toCommentDetailHeaderModel(FragmentComponent paramFragmentComponent, CommentDataModel paramCommentDataModel, Comment paramComment, Update paramUpdate, FeedDataModelMetadata paramFeedDataModelMetadata)
  {
    EntityClickableSpan localEntityClickableSpan = EntityClickableSpan.getTopbarSpan(actor, paramUpdate, paramComment, paramFragmentComponent, "header_share_actor");
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      try
      {
        paramComment = SingleUpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate, paramFeedDataModelMetadata);
        SingleUpdateDataModel localSingleUpdateDataModel = SingleUpdateDataModel.getMostOriginalShare(paramComment);
        localObject1 = null;
        localObject2 = null;
        paramFeedDataModelMetadata = (FeedDataModelMetadata)localObject1;
        paramComment = (Comment)localObject2;
        if ((localSingleUpdateDataModel instanceof ChannelSingleUpdateDataModel))
        {
          localObject3 = content;
          if ((localObject3 instanceof ArticleContentDataModel))
          {
            paramComment = (ArticleContentDataModel)localObject3;
            paramFeedDataModelMetadata = title;
            paramComment = url;
          }
        }
        else
        {
          if ((localSingleUpdateDataModel instanceof MentionedInNewsUpdateDataModel))
          {
            paramComment = content;
            paramFeedDataModelMetadata = title;
            paramComment = url;
          }
          localObject1 = paramFeedDataModelMetadata;
          localObject2 = paramComment;
          if ((content instanceof ArticleContentDataModel))
          {
            localObject3 = (ArticleContentDataModel)content;
            localObject1 = paramFeedDataModelMetadata;
            localObject2 = paramComment;
            if (articleType.equals(ArticleType.PONCHO))
            {
              localObject1 = title;
              localObject2 = url;
            }
          }
          paramComment = null;
          if (localEntityClickableSpan != null)
          {
            if ((localObject1 != null) && (localObject2 != null)) {
              break label370;
            }
            paramComment = localSingleUpdateDataModel.getActorDataModel();
            if (paramComment != null) {
              break label277;
            }
            paramComment = null;
          }
          return new FeedHeaderViewModel(new FeedHeaderLayout(), paramComment, null);
        }
      }
      catch (UpdateException paramCommentDataModel)
      {
        paramFragmentComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException(paramCommentDataModel));
        return null;
      }
      paramFeedDataModelMetadata = (FeedDataModelMetadata)localObject1;
      paramComment = (Comment)localObject2;
      if ((localObject3 instanceof VideoContentDataModel))
      {
        paramComment = (VideoContentDataModel)localObject3;
        paramFeedDataModelMetadata = title;
        paramComment = url;
        continue;
        label277:
        paramUpdate = EntityClickableSpan.getTopbarSpan(paramComment, paramUpdate, pegasusComment, paramFragmentComponent, "header_share_actor");
        if (paramUpdate == null)
        {
          paramComment = null;
        }
        else
        {
          paramComment = FeedI18NUtils.createActorObjectMap(formattedName, i18nActorType, null);
          paramComment = FeedI18NUtils.attachObjectSpan$7d2fa065(FeedI18NUtils.attachActorSpan$282a9181(FeedI18NUtils.translateCommenterString(paramFragmentComponent.i18NManager(), 2131231135, actor.formattedName, actor.i18nActorType, localEntityClickableSpan, paramComment), paramUpdate), new CommentHeaderTitleShareSpan(paramFragmentComponent.context(), paramFragmentComponent.eventBus()));
          continue;
          label370:
          paramComment = new UrlSpan((String)localObject2, paramFragmentComponent, new TrackingEventBuilder[0]);
          paramUpdate = new ArrayMap(2);
          paramUpdate.put("articleTitle", localObject1);
          paramComment = FeedI18NUtils.attachObjectSpan$7d2fa065(FeedI18NUtils.translateCommenterString(paramFragmentComponent.i18NManager(), 2131231134, actor.formattedName, actor.i18nActorType, localEntityClickableSpan, paramUpdate), paramComment);
        }
      }
    }
  }
  
  private static FeedComponentViewModel toViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, CommentDataModel paramCommentDataModel, Comment paramComment1, Comment paramComment2, Update paramUpdate, FeedDataModelMetadata paramFeedDataModelMetadata)
  {
    int m;
    int j;
    label62:
    int k;
    label91:
    boolean bool1;
    label101:
    int n;
    Object localObject1;
    label132:
    label141:
    boolean bool2;
    label171:
    boolean bool3;
    label184:
    FeedCommentViewModel localFeedCommentViewModel;
    if ((!FeedUpdateUtils.isGroupDiscussionUpdate(paramUpdate)) && (socialDetail != null))
    {
      m = 1;
      if ((!FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent)) || (parentCommentUrn != null) || (socialDetail == null) || (socialDetail.totalSocialActivityCounts.numComments <= 0L) || (paramComment2 != null)) {
        break label922;
      }
      j = 1;
      if ((!FeedViewTransformerHelpers.isCommentDetailPage(paramFragmentComponent)) || (parentCommentUrn != null) || (socialDetail == null) || (paramComment2 != null)) {
        break label928;
      }
      k = 1;
      if (parentCommentUrn == null) {
        break label934;
      }
      bool1 = true;
      n = Integer.MAX_VALUE;
      if (!FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent)) {
        break label948;
      }
      localObject1 = paramFragmentComponent.context().getResources();
      if (!bool1) {
        break label940;
      }
      i = 2131558462;
      i = ((Resources)localObject1).getInteger(i);
      if ((!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_COMMENT_ACTIONS_NO_ICONS)) || (!Util.isEnglish(paramFragmentComponent.context()))) {
        break label988;
      }
      bool2 = true;
      if (!bool1) {
        break label1000;
      }
      if (m != 0) {
        break label994;
      }
      bool3 = true;
      localObject1 = new FeedReplyLayout(bool3, FeedViewTransformerHelpers.isCommentDetailPage(paramFragmentComponent), i);
      localFeedCommentViewModel = new FeedCommentViewModel(paramFragmentComponent, (FeedCommentLayout)localObject1, bool1, bool2);
      localObject1 = paramFragmentComponent.i18NManager();
      if (!bool1) {
        break label1046;
      }
      i = 2131231091;
      label235:
      containerContentDescription = ((I18NManager)localObject1).getString(i);
      if (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_COMMENTS_TRACKING)) {
        trackingBuilder = FeedTracking.generateTrackingCommentBuilder(paramUpdate, paramCommentDataModel);
      }
      commentUrn = commentUrn;
      commenterImage = actor.formattedImage;
      commenterName = actor.formattedName;
      commenterHeadline = actor.formattedHeadline;
      Object localObject2 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject2).append(FeedTextUtils.getSpannableTextFromAnnotatedText$6851e591(comment, paramUpdate, paramFragmentComponent));
      localObject1 = localObject2;
      if (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_HASHTAGS)) {
        localObject1 = FeedTextUtils.getTextWithHashtagSpans(paramFragmentComponent, (CharSequence)localObject2, paramUpdate, pegasusComment);
      }
      commentText = ((Spanned)localObject1);
      commentTime = DateUtils.getTimestampText(createdTime, paramFragmentComponent.i18NManager());
      commentTimeContentDescription = DateUtils.getTimeAgoContentDescription(createdTime, paramFragmentComponent.i18NManager());
      localObject2 = actor;
      if (parentCommentUrn == null) {
        break label1054;
      }
      localObject1 = "reply_actor";
      label437:
      commenterClickListener = FeedTracking.actorClickListener((ActorDataModel)localObject2, paramFragmentComponent, (String)localObject1, paramUpdate, paramComment1);
      if (FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent))
      {
        if (parentCommentUrn == null) {
          break label1062;
        }
        commentTextClickListener = FeedTracking.newCommentReplyTextClickListener(paramUpdate, paramComment1, paramComment2, paramFragmentComponent);
      }
      label481:
      if ((socialDetail != null) && (!FeedUpdateUtils.isGroupDiscussionUpdate(paramUpdate)))
      {
        isLiked = paramCommentDataModel.isLiked();
        if (!isLiked) {
          break label1079;
        }
        i = 2131231086;
        label518:
        likeContentDescription = FeedI18NUtils.translateActorString(paramFragmentComponent.i18NManager(), i, actor.formattedName, actor.i18nActorType, null, null);
        likeCount = paramCommentDataModel.getLikeCount();
        likeCountText = paramFragmentComponent.i18NManager().getString(2131231300, new Object[] { Integer.valueOf(paramCommentDataModel.getLikeCount()) });
        commentLikeClickListener = FeedTracking.newCommentLikeClickListener(paramUpdate, paramComment1, socialDetail, paramFragmentComponent);
        likeCountClickListener = FeedTracking.newCommentViewLikesClickListener(paramUpdate, paramComment1, socialDetail, paramFragmentComponent);
      }
      if ((socialDetail != null) && (!FeedUpdateUtils.isGroupDiscussionUpdate(paramUpdate)))
      {
        if (parentCommentUrn == null)
        {
          replyContentDescription = FeedI18NUtils.translateActorString(paramFragmentComponent.i18NManager(), 2131231085, actor.formattedName, actor.i18nActorType, null, null);
          replyCount = paramCommentDataModel.getReplyCount();
          replyCountText = paramFragmentComponent.i18NManager().getString(2131231301, new Object[] { Integer.valueOf(paramCommentDataModel.getReplyCount()) });
          replyCountClickListener = FeedTracking.newCommentViewRepliesClickListener(paramUpdate, paramComment1, paramFragmentComponent);
        }
        commentReplyClickListener = FeedTracking.newCommentReplyClickListener(paramUpdate, paramComment1, paramComment2, paramFragmentComponent);
      }
      if (parentCommentUrn == null) {
        break label1087;
      }
      i = 1;
      label755:
      if ((pendingState != 3) && ((i == 0) || (pendingState != 2)) && ((i != 0) || (pendingState != 1))) {
        break label1463;
      }
    }
    label843:
    label858:
    label898:
    label922:
    label928:
    label934:
    label940:
    label948:
    label988:
    label994:
    label1000:
    label1008:
    label1040:
    label1046:
    label1054:
    label1062:
    label1079:
    label1087:
    label1132:
    label1138:
    label1161:
    label1184:
    label1403:
    label1412:
    label1463:
    for (int i = 1;; i = 0)
    {
      localObject1 = paramFragmentComponent.context().getResources();
      if ((i != 0) || ((commentUrn != null) && (OptimisticWrite.isTemporaryId(commentUrn))))
      {
        backgroundAlpha = ((Resources)localObject1).getFraction(2131689474, 1, 1);
        if (actions.isEmpty()) {
          break label1132;
        }
        bool1 = true;
        hasActions = bool1;
        if (hasActions)
        {
          if (parentCommentUrn == null) {
            break label1161;
          }
          if (paramComment2 != null) {
            break label1138;
          }
          Util.safeThrow(new RuntimeException("ParentComment should not be null"));
        }
        if (j == 0) {
          break label1412;
        }
        if (socialDetail != null) {
          break label1184;
        }
        paramComment2 = null;
      }
      do
      {
        return paramComment2;
        m = 0;
        break;
        j = 0;
        break label62;
        k = 0;
        break label91;
        bool1 = false;
        break label101;
        i = 2131558458;
        break label132;
        i = n;
        if (!FeedViewTransformerHelpers.isCommentDetailPage(paramFragmentComponent)) {
          break label141;
        }
        i = n;
        if (!bool1) {
          break label141;
        }
        i = paramFragmentComponent.context().getResources().getInteger(2131558445);
        break label141;
        bool2 = false;
        break label171;
        bool3 = false;
        break label184;
        if (m == 0)
        {
          bool3 = true;
          if (j != 0) {
            break label1040;
          }
        }
        for (boolean bool4 = true;; bool4 = false)
        {
          localObject1 = new FeedCommentLayout(bool3, bool4, i);
          break;
          bool3 = false;
          break label1008;
        }
        i = 2131231088;
        break label235;
        localObject1 = "comment_actor";
        break label437;
        commentTextClickListener = FeedTracking.newCommentTextClickListener(paramUpdate, paramComment1, paramComment2, paramFragmentComponent);
        break label481;
        i = 2131231084;
        break label518;
        i = 0;
        break label755;
        backgroundAlpha = 1.0F;
        isHighlighted = isHighlightedComment(paramCommentDataModel, paramFeedDataModelMetadata);
        highlightFadeAnimationDuration = FeedLixHelper.parseLong(paramFragmentComponent.lixManager(), Lix.FEED_HIGHLIGHTED_COMMENT_FADE_DURATION, 0L, 1L);
        break label843;
        bool1 = false;
        break label858;
        commentLongClickListener = new FeedReplyLongClickListener(paramFragmentComponent, paramComment2, paramComment1, actions);
        break label898;
        commentLongClickListener = new FeedCommentLongClickListener(paramFragmentComponent, paramComment1, paramUpdate, actions);
        break label898;
        paramCommentDataModel = new ArrayList();
        safeAdd(paramCommentDataModel, localFeedCommentViewModel);
        paramComment2 = socialDetail.comments.elements;
        if (!paramComment2.isEmpty()) {
          safeAdd(paramCommentDataModel, toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, (Comment)paramComment2.get(paramComment2.size() - 1), paramComment1, paramUpdate, paramFeedDataModelMetadata));
        }
        if (socialDetail.totalSocialActivityCounts.numComments > 1L)
        {
          paramComment2 = paramFragmentComponent.context().getResources();
          localObject1 = new FeedBasicTextViewModel(new FeedCommentSeeAllRepliesLayout(paramComment2));
          clickListener = FeedTracking.newSeeAllRepliesClickListener(paramUpdate, paramComment1, paramFragmentComponent);
          text = paramFragmentComponent.context().getString(2131231160);
          if (pendingState != 3) {
            break label1403;
          }
        }
        for (backgroundAlpha = paramComment2.getFraction(2131689474, 1, 1);; backgroundAlpha = 1.0F)
        {
          safeAdd(paramCommentDataModel, localObject1);
          safeAdd(paramCommentDataModel, new FeedDividerViewModel(new FeedDividerLayout(paramFragmentComponent.context().getResources().getDimensionPixelSize(2131493107))));
          return new FeedComponentListViewModel(paramFeedComponentsViewPool, paramCommentDataModel);
        }
        paramComment2 = localFeedCommentViewModel;
      } while (k == 0);
      paramFragmentComponent = toCommentDetailHeaderModel(paramFragmentComponent, paramCommentDataModel, paramComment1, paramUpdate, paramFeedDataModelMetadata);
      paramCommentDataModel = new ArrayList();
      safeAdd(paramCommentDataModel, paramFragmentComponent);
      safeAdd(paramCommentDataModel, localFeedCommentViewModel);
      return new FeedComponentListViewModel(paramFeedComponentsViewPool, paramCommentDataModel);
    }
  }
  
  private static FeedComponentViewModel toViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, CommentDataModel paramCommentDataModel, Comment paramComment, Update paramUpdate, FeedDataModelMetadata paramFeedDataModelMetadata)
  {
    return toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, paramCommentDataModel, paramComment, null, paramUpdate, paramFeedDataModelMetadata);
  }
  
  public static FeedComponentViewModel toViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, Comment paramComment1, Comment paramComment2, Update paramUpdate, FeedDataModelMetadata paramFeedDataModelMetadata)
  {
    try
    {
      CommentDataModel localCommentDataModel = SocialDetailTransformer.toDataModel(paramFragmentComponent, paramComment1);
      return toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, localCommentDataModel, paramComment1, paramComment2, paramUpdate, paramFeedDataModelMetadata);
    }
    catch (UpdateException paramFeedComponentsViewPool)
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException(paramFeedComponentsViewPool));
    }
    return null;
  }
  
  public static FeedComponentViewModel toViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, Comment paramComment, Update paramUpdate, FeedDataModelMetadata paramFeedDataModelMetadata)
  {
    try
    {
      CommentDataModel localCommentDataModel = SocialDetailTransformer.toDataModel(paramFragmentComponent, paramComment);
      return toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, localCommentDataModel, paramComment, paramUpdate, paramFeedDataModelMetadata);
    }
    catch (UpdateException paramFeedComponentsViewPool)
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException(paramFeedComponentsViewPool));
    }
    return null;
  }
  
  static ModelsData<Comment, CommentDataModel, FeedComponentViewModel> toViewModels(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, List<Comment> paramList, Comment paramComment, Update paramUpdate, FeedDataModelMetadata paramFeedDataModelMetadata)
  {
    ArrayList localArrayList1 = new ArrayList(paramList.size());
    int i = 0;
    try
    {
      j = paramList.size();
      while (i < j)
      {
        localArrayList1.add(SocialDetailTransformer.toDataModel(paramFragmentComponent, (Comment)paramList.get(i)));
        i += 1;
      }
      localArrayList2 = new ArrayList(paramList.size());
    }
    catch (UpdateException paramFeedComponentsViewPool)
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException(paramFeedComponentsViewPool));
      return new ModelsData(paramList, null, Collections.emptyList());
    }
    ArrayList localArrayList2;
    i = 0;
    int j = paramList.size();
    while (i < j)
    {
      localArrayList2.add(toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, (CommentDataModel)localArrayList1.get(i), (Comment)paramList.get(i), paramComment, paramUpdate, paramFeedDataModelMetadata));
      i += 1;
    }
    return new ModelsData(paramList, localArrayList1, localArrayList2);
  }
  
  static ModelsData<Comment, CommentDataModel, FeedComponentViewModel> toViewModels(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, List<Comment> paramList, Update paramUpdate, FeedDataModelMetadata paramFeedDataModelMetadata)
  {
    ArrayList localArrayList1 = new ArrayList(paramList.size());
    int i = 0;
    try
    {
      j = paramList.size();
      while (i < j)
      {
        localArrayList1.add(SocialDetailTransformer.toDataModel(paramFragmentComponent, (Comment)paramList.get(i)));
        i += 1;
      }
      localArrayList2 = new ArrayList(paramList.size());
    }
    catch (UpdateException paramFeedComponentsViewPool)
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException(paramFeedComponentsViewPool));
      return new ModelsData(paramList, null, Collections.emptyList());
    }
    ArrayList localArrayList2;
    i = 0;
    int j = paramList.size();
    while (i < j)
    {
      localArrayList2.add(toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, (CommentDataModel)localArrayList1.get(i), (Comment)paramList.get(i), paramUpdate, paramFeedDataModelMetadata));
      i += 1;
    }
    return new ModelsData(paramList, localArrayList1, localArrayList2);
  }
  
  public static void toViewModels(FragmentComponent paramFragmentComponent, final FeedComponentsViewPool paramFeedComponentsViewPool, final List<Comment> paramList, final Comment paramComment, final Update paramUpdate, final FeedDataModelMetadata paramFeedDataModelMetadata, final ModelsTransformedCallback<Comment, CommentDataModel, FeedComponentViewModel> paramModelsTransformedCallback)
  {
    paramFragmentComponent.transformerExecutor().execute(new Runnable()
    {
      public final void run()
      {
        final ModelsData localModelsData = FeedCommentTransformer.toViewModels(val$fragmentComponent, paramFeedComponentsViewPool, paramList, paramComment, paramUpdate, paramFeedDataModelMetadata);
        val$fragmentComponent.mainHandler().post(new Runnable()
        {
          public final void run()
          {
            val$callback.onModelsTransformed(localModelsData);
          }
        });
      }
    });
  }
  
  public static void toViewModels(FragmentComponent paramFragmentComponent, final FeedComponentsViewPool paramFeedComponentsViewPool, final List<Comment> paramList, final Update paramUpdate, final FeedDataModelMetadata paramFeedDataModelMetadata, final ModelsTransformedCallback<Comment, CommentDataModel, FeedComponentViewModel> paramModelsTransformedCallback)
  {
    paramFragmentComponent.transformerExecutor().execute(new Runnable()
    {
      public final void run()
      {
        final ModelsData localModelsData = FeedCommentTransformer.toViewModels(val$fragmentComponent, paramFeedComponentsViewPool, paramList, paramUpdate, paramFeedDataModelMetadata);
        val$fragmentComponent.mainHandler().post(new Runnable()
        {
          public final void run()
          {
            val$callback.onModelsTransformed(localModelsData);
          }
        });
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.comment.FeedCommentTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */