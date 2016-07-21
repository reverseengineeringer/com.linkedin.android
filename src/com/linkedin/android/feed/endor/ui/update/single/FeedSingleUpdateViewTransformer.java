package com.linkedin.android.feed.endor.ui.update.single;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.NativeVideoContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.PropContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentDataModel;
import com.linkedin.android.feed.endor.datamodel.social.CommentDataModel;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.CrossPromoSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.DiscussionSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.PromptResponseSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.PropSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ReshareSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ViralSingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextLayout;
import com.linkedin.android.feed.endor.ui.component.basictext.FeedBasicTextViewModel;
import com.linkedin.android.feed.endor.ui.component.commentary.FeedCommentaryTransformer;
import com.linkedin.android.feed.endor.ui.component.contentanalytics.FeedContentAnalyticsTransformer;
import com.linkedin.android.feed.endor.ui.component.contentdetail.FeedContentDetailTransformer;
import com.linkedin.android.feed.endor.ui.component.detailheader.FeedDetailSectionHeaderTransformer;
import com.linkedin.android.feed.endor.ui.component.discussiontitle.FeedDiscussionTitleTransformer;
import com.linkedin.android.feed.endor.ui.component.divider.FeedDividerViewTransformer;
import com.linkedin.android.feed.endor.ui.component.group.FeedClosedDiscussionTextLayout;
import com.linkedin.android.feed.endor.ui.component.groupheader.FeedGroupHeaderViewModel;
import com.linkedin.android.feed.endor.ui.component.header.FeedHeaderLayout;
import com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewModel;
import com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewTransformer;
import com.linkedin.android.feed.endor.ui.component.highlightedcomment.FeedHighlightedCommentLayout;
import com.linkedin.android.feed.endor.ui.component.highlightedcomment.FeedHighlightedCommentViewModel;
import com.linkedin.android.feed.endor.ui.component.insight.FeedInsightTransformer;
import com.linkedin.android.feed.endor.ui.component.likesrollup.FeedLikesRollupTransformer;
import com.linkedin.android.feed.endor.ui.component.nativevideo.FeedNativeVideoLayout;
import com.linkedin.android.feed.endor.ui.component.nativevideo.FeedNativeVideoViewModel;
import com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorTransformer;
import com.linkedin.android.feed.endor.ui.component.promptresponseheader.FeedPromptResponseHeaderViewTransformer;
import com.linkedin.android.feed.endor.ui.component.propcontent.FeedPropContentLayout;
import com.linkedin.android.feed.endor.ui.component.richmedia.FeedRichMediaTransformer;
import com.linkedin.android.feed.endor.ui.component.socialbar.variants.socialactionsbar.FeedSocialActionsBarTransformer;
import com.linkedin.android.feed.endor.ui.component.socialsummary.FeedSocialSummaryTransformer;
import com.linkedin.android.feed.endor.ui.transformer.FeedTransformerUtils;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.FeedI18NUtils;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedTextUtils;
import com.linkedin.android.feed.utils.FeedUpdateUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.spans.ArtDecoTextAppearanceSpan;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropType;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import java.util.ArrayList;
import java.util.List;

public final class FeedSingleUpdateViewTransformer
  extends FeedTransformerUtils
{
  public static FeedSingleUpdateViewModel toViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, SingleUpdateDataModel paramSingleUpdateDataModel, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ArrayList localArrayList = new ArrayList();
    label66:
    label331:
    label349:
    Object localObject2;
    label483:
    label515:
    label557:
    label561:
    label624:
    label632:
    int i;
    if (FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent))
    {
      if (!(content instanceof GroupDiscussionContentDataModel))
      {
        localObject1 = null;
        safeAdd(localArrayList, localObject1);
      }
    }
    else
    {
      if (!FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent))
      {
        safeAdd(localArrayList, FeedHeaderViewTransformer.toViewModel(paramFragmentComponent, paramSingleUpdateDataModel));
        if (sponsoredTemplateType == 3) {
          break label896;
        }
        localObject1 = null;
        safeAdd(localArrayList, localObject1);
      }
      if (FeedViewTransformerHelpers.isPromptResponseListPage(paramFragmentComponent)) {
        safeAdd(localArrayList, FeedDividerViewTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent));
      }
      if (!(paramSingleUpdateDataModel instanceof ReshareSingleUpdateDataModel)) {
        safeAdd(localArrayList, FeedPromptResponseHeaderViewTransformer.toViewModel(paramFragmentComponent, paramSingleUpdateDataModel));
      }
      safeAdd(localArrayList, FeedPrimaryActorTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent, false));
      safeAdd(localArrayList, FeedInsightTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent));
      if (UpdateDataModel.isPropUpdate(paramSingleUpdateDataModel)) {
        safeAdd(localArrayList, FeedDividerViewTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent));
      }
      safeAdd(localArrayList, FeedDiscussionTitleTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent));
      safeAdd(localArrayList, FeedCommentaryTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent));
      if ((paramBoolean1) && (!FeedViewTransformerHelpers.isAggregateFeedPage(paramFragmentComponent)) && (!FeedViewTransformerHelpers.isPromptResponseListPage(paramFragmentComponent)))
      {
        localObject1 = SingleUpdateDataModel.getMostOriginalShare(paramSingleUpdateDataModel);
        if ((!FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent)) && (!FeedViewTransformerHelpers.isSharePreview(paramFragmentComponent)) && ((paramSingleUpdateDataModel instanceof ReshareSingleUpdateDataModel)) && ((localObject1 instanceof PromptResponseSingleUpdateDataModel))) {
          safeAdd(localArrayList, FeedPromptResponseHeaderViewTransformer.toViewModel(paramFragmentComponent, paramSingleUpdateDataModel));
        }
        safeAdd(localArrayList, FeedContentDetailTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent, 2, false));
        safeAdd(localArrayList, FeedContentDetailTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent, 3, false));
        safeAdd(localArrayList, FeedRichMediaTransformer.toViewModel(paramFragmentComponent, paramSingleUpdateDataModel));
        safeAdd(localArrayList, FeedContentDetailTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent, 1, false));
        safeAdd(localArrayList, FeedContentDetailTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent, 6, false));
        safeAdd(localArrayList, FeedContentDetailTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent, 5, false));
      }
      if ((FeedViewTransformerHelpers.isPromptResponseListPage(paramFragmentComponent)) && ((paramSingleUpdateDataModel instanceof PromptResponseSingleUpdateDataModel))) {
        break label1059;
      }
      localObject1 = null;
      safeAdd(localArrayList, localObject1);
      if (UpdateDataModel.isPropUpdate(paramSingleUpdateDataModel)) {
        break label1153;
      }
      localObject1 = null;
      safeAdd(localArrayList, localObject1);
      localObject2 = paramFragmentComponent.context();
      if ((!FeedTracking.isSponsored(pegasusUpdate, paramFragmentComponent.lixManager())) || (FeedTracking.getSponsoredRenderFormatInt(pegasusUpdate.tracking) != 2) || (FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent)) || (localObject2 == null) || (!(paramSingleUpdateDataModel instanceof SingleUpdateDataModel))) {
        break label1631;
      }
      localObject1 = (SingleUpdateDataModel)paramSingleUpdateDataModel;
      localObject2 = new FeedBasicTextViewModel(new FeedBasicTextLayout(((Context)localObject2).getResources(), 2131361842));
      if (primaryActor == null) {
        break label1553;
      }
      text = FeedI18NUtils.translateActorString$4fa0acfe(paramFragmentComponent.i18NManager(), 2131231302, primaryActor.formattedName, primaryActor.i18nActorType);
      contentDescription = paramFragmentComponent.i18NManager().getString(2131231096);
      if (!(paramSingleUpdateDataModel instanceof ViralSingleUpdateDataModel)) {
        break label1593;
      }
      localObject1 = urn;
      if (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_USE_VIRAL_UPDATE_IN_DETAIL)) {
        break label1599;
      }
      clickListener = FeedTracking.newUpdateClickListener(pegasusUpdate, paramFragmentComponent, 0, true, SocialDetailDataModel.getHighlightedCommentUrns(paramSingleUpdateDataModel), SocialDetailDataModel.getHighlightedReplyUrns(paramSingleUpdateDataModel), "social_count", "viewUpdateDetail");
      localObject1 = localObject2;
      safeAdd(localArrayList, localObject1);
      safeAdd(localArrayList, FeedSocialSummaryTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent));
      if (!FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent))
      {
        if (!DiscussionSingleUpdateDataModel.isClosedDiscussion(paramSingleUpdateDataModel)) {
          break label1748;
        }
        safeAdd(localArrayList, FeedDividerViewTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent));
        if ((paramFragmentComponent.context() != null) && ((paramSingleUpdateDataModel instanceof DiscussionSingleUpdateDataModel))) {
          break label1637;
        }
        localObject1 = null;
        safeAdd(localArrayList, localObject1);
      }
      if (FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent))
      {
        safeAdd(localArrayList, FeedSocialActionsBarTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent));
        safeAdd$7e084170(localArrayList, FeedContentAnalyticsTransformer.toEntryViewModelWithDivider(paramFragmentComponent, paramSingleUpdateDataModel));
        safeAdd(localArrayList, FeedDividerViewTransformer.getDefaultViewModel());
        safeAdd(localArrayList, FeedDetailSectionHeaderTransformer.toViewModel(paramFragmentComponent, paramSingleUpdateDataModel, 2131231255));
        safeAdd(localArrayList, FeedLikesRollupTransformer.toViewModel(paramFragmentComponent, paramSingleUpdateDataModel));
        safeAdd(localArrayList, FeedDetailSectionHeaderTransformer.toViewModel(paramFragmentComponent, paramSingleUpdateDataModel, 2131231154));
      }
      if (FeedViewTransformerHelpers.getFeedType(paramFragmentComponent) != 17) {
        break label2695;
      }
      i = 1;
      label721:
      if (i != 0) {
        safeAdd$7e084170(localArrayList, FeedContentAnalyticsTransformer.toEntryViewModelWithDivider(paramFragmentComponent, paramSingleUpdateDataModel));
      }
      if (((SingleUpdateDataModel.getMostOriginalShare(paramSingleUpdateDataModel) instanceof DiscussionSingleUpdateDataModel)) || (actions.isEmpty())) {
        break label2701;
      }
    }
    label896:
    label1008:
    label1059:
    label1153:
    label1197:
    label1312:
    label1413:
    label1475:
    label1490:
    label1521:
    label1553:
    label1593:
    label1599:
    label1631:
    label1637:
    label1748:
    label1862:
    label1898:
    label1924:
    label2148:
    label2224:
    label2252:
    label2571:
    label2577:
    label2582:
    label2588:
    label2628:
    label2647:
    label2655:
    label2695:
    label2701:
    for (Object localObject1 = FeedTracking.newControlMenuClickListener(pegasusUpdate, actions, paramFragmentComponent);; localObject1 = null)
    {
      if (!(paramSingleUpdateDataModel instanceof CrossPromoSingleUpdateDataModel)) {
        break label2707;
      }
      return new CrossPromoInFeedSingleUpdateViewModel(pegasusUpdate, paramFragmentComponent, paramFeedComponentsViewPool, localArrayList, (TrackingOnClickListener)localObject1);
      localObject2 = content).group;
      localObject1 = new FeedGroupHeaderViewModel(new FeedComponentLayout());
      groupHeaderName = groupName;
      groupHeaderIcon = new ImageModel(logo, GhostImageUtils.getGroup(2131492963, (MiniGroup)localObject2), Util.retrieveRumSessionId(paramFragmentComponent));
      groupHeaderClickListener = FeedTracking.newGroupClickListener$260eace((MiniGroup)localObject2, paramFragmentComponent, "group_top_bar", pegasusUpdate.tracking, pegasusUpdate.urn);
      break;
      localObject1 = paramFragmentComponent.i18NManager();
      i = sponsoredTemplateType;
      switch (i)
      {
      default: 
        Log.e("Sponsored Update Tracking", "Unsupported sponsored template type " + i);
        localObject1 = null;
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label1008;
        }
        localObject1 = null;
        break;
        localObject1 = ((I18NManager)localObject1).getString(2131231305);
        continue;
        localObject1 = ((I18NManager)localObject1).getString(2131231304);
      }
      localObject1 = new FeedHeaderViewModel(new FeedHeaderLayout(), (CharSequence)localObject1, null);
      if (!actions.isEmpty()) {
        controlMenuListener = FeedTracking.newControlMenuClickListener(pegasusUpdate, actions, paramFragmentComponent);
      }
      break label66;
      localObject2 = (NativeVideoContentDataModel)content;
      localObject1 = new FeedNativeVideoViewModel(new FeedNativeVideoLayout(width, height), paramFragmentComponent);
      metadata = videoPlayMetadata;
      localObject2 = pegasusUpdate;
      if (tracking != null) {
        actionEvent = FeedTracking.createFeedActionEvent(ActionCategory.PLAY, "object", "playVideo", tracking, urn, paramFragmentComponent);
      }
      break label331;
      Object localObject4 = paramFragmentComponent.context();
      if (localObject4 == null)
      {
        localObject1 = null;
        break label349;
      }
      Object localObject5 = (PropSingleUpdateDataModel)SingleUpdateDataModel.getMostOriginalShare(paramSingleUpdateDataModel);
      Object localObject3;
      Object localObject6;
      if ((paramSingleUpdateDataModel instanceof ViralSingleUpdateDataModel))
      {
        localObject1 = urn;
        localObject2 = (PropContentDataModel)content;
        localObject3 = new FeedBasicTextViewModel(new FeedPropContentLayout(((Context)localObject4).getResources()));
        localObject6 = new SpannableStringBuilder();
        Object localObject7 = AttributedTextUtils.getAttributedString(text, (Context)localObject4);
        SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
        localSpannableStringBuilder.append((CharSequence)localObject7);
        localSpannableStringBuilder.setSpan(new ArtDecoTextAppearanceSpan((Context)localObject4, 2131361805), 0, ((CharSequence)localObject7).length(), 33);
        ((SpannableStringBuilder)localObject6).append(localSpannableStringBuilder);
        if (subtext != null) {
          break label1475;
        }
        localObject2 = null;
        if (localObject2 != null)
        {
          ((SpannableStringBuilder)localObject6).append("\n");
          localObject7 = new SpannableStringBuilder();
          ((SpannableStringBuilder)localObject7).append((CharSequence)localObject2);
          ((SpannableStringBuilder)localObject7).setSpan(new ArtDecoTextAppearanceSpan((Context)localObject4, 2131361851), 0, ((CharSequence)localObject2).length(), 33);
          ((SpannableStringBuilder)localObject6).append((CharSequence)localObject7);
        }
        text = ((CharSequence)localObject6);
        if (propType != PropType.WORK_ANNIVERSARY) {
          break label1490;
        }
        contentDescription = paramFragmentComponent.i18NManager().getString(2131231109);
        if (!FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent)) {
          if (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_USE_VIRAL_UPDATE_IN_DETAIL)) {
            break label1521;
          }
        }
      }
      for (clickListener = FeedTracking.newUpdateClickListener(pegasusUpdate, paramFragmentComponent, 0, true, SocialDetailDataModel.getHighlightedCommentUrns(paramSingleUpdateDataModel), SocialDetailDataModel.getHighlightedReplyUrns(paramSingleUpdateDataModel), "object", null);; clickListener = FeedTracking.newUpdateClickListener(FeedUpdateUtils.getOriginalPegasusUpdate(paramSingleUpdateDataModel), (String)localObject1, paramFragmentComponent, 0, true, SocialDetailDataModel.getHighlightedCommentUrns(paramSingleUpdateDataModel), SocialDetailDataModel.getHighlightedReplyUrns(paramSingleUpdateDataModel), "object", null))
      {
        localObject1 = localObject3;
        break;
        localObject1 = null;
        break label1197;
        localObject2 = AttributedTextUtils.getAttributedString(subtext, (Context)localObject4);
        break label1312;
        if (propType != PropType.JOB_CHANGE) {
          break label1413;
        }
        contentDescription = paramFragmentComponent.i18NManager().getString(2131231108);
        break label1413;
      }
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Sponsored update should not be missing an actor!"));
      text = paramFragmentComponent.i18NManager().getString(2131231304);
      break label483;
      localObject1 = null;
      break label515;
      clickListener = FeedTracking.newUpdateClickListener(FeedUpdateUtils.getOriginalPegasusUpdate(paramSingleUpdateDataModel), (String)localObject1, paramFragmentComponent, 0, true, SocialDetailDataModel.getHighlightedCommentUrns(paramSingleUpdateDataModel), SocialDetailDataModel.getHighlightedReplyUrns(paramSingleUpdateDataModel), "social_count", "viewUpdateDetail");
      break label557;
      localObject1 = null;
      break label561;
      localObject1 = null;
      if (!FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent)) {
        localObject1 = FeedTracking.newUpdateClickListener(pegasusUpdate, paramFragmentComponent, 0, true, SocialDetailDataModel.getHighlightedCommentUrns(paramSingleUpdateDataModel), SocialDetailDataModel.getHighlightedReplyUrns(paramSingleUpdateDataModel), "discussion_closed", "viewUpdateDetail");
      }
      localObject2 = new FeedBasicTextViewModel(new FeedClosedDiscussionTextLayout(paramFragmentComponent.context().getResources()));
      text = paramFragmentComponent.context().getString(2131231161);
      clickListener = ((TrackingOnClickListener)localObject1);
      contentDescription = paramFragmentComponent.context().getString(2131231089);
      localObject1 = localObject2;
      break label624;
      safeAdd(localArrayList, FeedSocialActionsBarTransformer.toViewModel(paramSingleUpdateDataModel, paramFragmentComponent));
      if ((socialDetail == null) || (CollectionUtils.isEmpty(socialDetail.highlightedComments)))
      {
        localObject1 = null;
        safeAdd(localArrayList, localObject1);
        break label632;
      }
      boolean bool1 = FeedTracking.isSponsored(pegasusUpdate, paramFragmentComponent.lixManager());
      localObject4 = (CommentDataModel)socialDetail.highlightedComments.get(0);
      int j;
      if ((FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_HIGHLIGHT_LIKE_ON_COMMENT)) && (socialDetail != null) && (!(SingleUpdateDataModel.getMostOriginalShare(paramSingleUpdateDataModel) instanceof DiscussionSingleUpdateDataModel)))
      {
        j = 1;
        if ((!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_HIGHLIGHT_REPLY_ON_COMMENT)) || (socialDetail == null) || ((SingleUpdateDataModel.getMostOriginalShare(paramSingleUpdateDataModel) instanceof DiscussionSingleUpdateDataModel))) {
          break label2571;
        }
        i = 1;
        boolean bool2 = FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_COMMENT_ACTIONS_NO_ICONS);
        if ((j == 0) && (i == 0)) {
          break label2577;
        }
        paramBoolean1 = true;
        localObject2 = new FeedHighlightedCommentViewModel(new FeedHighlightedCommentLayout(paramBoolean1), bool2);
        commenterImageModel = actor.formattedImage;
        localObject1 = actor;
        localObject6 = pegasusUpdate;
        localObject5 = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(formattedName))
        {
          ((SpannableStringBuilder)localObject5).append(formattedName);
          ((SpannableStringBuilder)localObject5).setSpan(new ArtDecoTextAppearanceSpan(paramFragmentComponent.context(), 2131361852), 0, formattedName.length(), 33);
          ((SpannableStringBuilder)localObject5).append(" ");
        }
        localObject3 = FeedTextUtils.getSpannableTextFromAnnotatedText$6851e591(comment, (Update)localObject6, paramFragmentComponent);
        localObject1 = localObject3;
        if (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_HASHTAGS)) {
          localObject1 = FeedTextUtils.getTextWithHashtagSpans(paramFragmentComponent, (CharSequence)localObject3, (Update)localObject6, pegasusComment);
        }
        ((SpannableStringBuilder)localObject5).append((CharSequence)localObject1);
        highlightedActorAndCommentText = ((Spanned)localObject5);
        if (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_COMMENTS_TRACKING)) {
          trackingBuilder = FeedTracking.generateTrackingCommentBuilder(pegasusUpdate, (CommentDataModel)localObject4);
        }
        if (!(paramSingleUpdateDataModel instanceof ViralSingleUpdateDataModel)) {
          break label2582;
        }
        localObject1 = urn;
        if ((!bool1) || (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_SPONSORED_COMMENT_SEE_MORE_DETAIL_PAGE))) {
          break label2628;
        }
        disableExpandOnEllipsisClick = true;
        if (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_USE_VIRAL_UPDATE_IN_DETAIL)) {
          break label2588;
        }
        highlightedSectionEllipsisTextClickListener = FeedTracking.newUpdateClickListener(pegasusUpdate, paramFragmentComponent, 2, true, socialDetail.highlightedCommentUrns, socialDetail.highlightedReplyUrns, "expand", "expandCommentText");
        if (j != 0)
        {
          isLiked = ((CommentDataModel)localObject4).isLiked();
          if (!isLiked) {
            break label2647;
          }
          j = 2131231086;
          likeContentDescription = FeedI18NUtils.translateActorString(paramFragmentComponent.i18NManager(), j, actor.formattedName, actor.i18nActorType, null, null);
          likeCount = ((CommentDataModel)localObject4).getLikeCount();
          likeCountText = paramFragmentComponent.i18NManager().getString(2131231300, new Object[] { Integer.valueOf(((CommentDataModel)localObject4).getLikeCount()) });
          commentLikeClickListener = FeedTracking.newCommentLikeClickListener(pegasusUpdate, pegasusComment, socialDetail.pegasusSocialDetail, paramFragmentComponent);
          likeCountClickListener = FeedTracking.newCommentViewLikesClickListener(pegasusUpdate, pegasusComment, socialDetail.pegasusSocialDetail, paramFragmentComponent);
        }
        if (i != 0)
        {
          replyContentDescription = FeedI18NUtils.translateActorString(paramFragmentComponent.i18NManager(), 2131231085, actor.formattedName, actor.i18nActorType, null, null);
          replyCount = ((CommentDataModel)localObject4).getReplyCount();
          replyCountText = paramFragmentComponent.i18NManager().getString(2131231301, new Object[] { Integer.valueOf(((CommentDataModel)localObject4).getReplyCount()) });
          commentReplyClickListener = FeedTracking.newCommentReplyClickListener(pegasusUpdate, pegasusComment, null, paramFragmentComponent);
          replyCountClickListener = FeedTracking.newCommentViewRepliesClickListener(pegasusUpdate, pegasusComment, paramFragmentComponent);
        }
        if (!FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent)) {
          if (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_USE_VIRAL_UPDATE_IN_DETAIL)) {
            break label2655;
          }
        }
      }
      for (feedUpdateOnClickListener = FeedTracking.newUpdateClickListener(pegasusUpdate, paramFragmentComponent, 2, true, socialDetail.highlightedCommentUrns, socialDetail.highlightedReplyUrns, "highlight", "viewComment");; feedUpdateOnClickListener = FeedTracking.newUpdateClickListener(FeedUpdateUtils.getOriginalPegasusUpdate(paramSingleUpdateDataModel), (String)localObject1, paramFragmentComponent, 2, true, socialDetail.highlightedCommentUrns, socialDetail.highlightedReplyUrns, "highlight", "viewComment"))
      {
        localObject1 = localObject2;
        break;
        j = 0;
        break label1862;
        i = 0;
        break label1898;
        paramBoolean1 = false;
        break label1924;
        localObject1 = null;
        break label2148;
        highlightedSectionEllipsisTextClickListener = FeedTracking.newUpdateClickListener(FeedUpdateUtils.getOriginalPegasusUpdate(paramSingleUpdateDataModel), (String)localObject1, paramFragmentComponent, 2, true, socialDetail.highlightedCommentUrns, socialDetail.highlightedReplyUrns, "expand", "expandCommentText");
        break label2224;
        highlightedSectionEllipsisTextClickListener = FeedTracking.newEllipsisTextListener(paramFragmentComponent, pegasusUpdate, "expandCommentText");
        break label2224;
        j = 2131231084;
        break label2252;
      }
      i = 0;
      break label721;
    }
    label2707:
    paramFeedComponentsViewPool = new FeedSingleUpdateViewModel(pegasusUpdate, paramFragmentComponent, paramFeedComponentsViewPool, localArrayList, (TrackingOnClickListener)localObject1);
    isNested = paramBoolean2;
    isLastUpdate = paramBoolean3;
    invertColors = FeedViewTransformerHelpers.isPromptResponseListPage(paramFragmentComponent);
    return paramFeedComponentsViewPool;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */