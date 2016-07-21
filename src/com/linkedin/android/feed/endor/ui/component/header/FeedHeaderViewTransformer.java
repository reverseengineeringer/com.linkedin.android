package com.linkedin.android.feed.endor.ui.component.header;

import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import com.linkedin.android.artdeco.ArtDeco;
import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.discussion.GroupDiscussionContentDataModel;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.ConnectionUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.FollowRecommendationUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.PymkUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedConnectionUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedFollowRecommendationUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedPymkUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.AggregatedJymbiiUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.JymbiiUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ChannelSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.CrossPromoSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.DiscussionSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.LyndaSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.MentionedInNewsUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.PropSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ViralSingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.FeedI18NUtils;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.infra.ui.spans.EntityClickableSpan;
import com.linkedin.android.infra.ui.spans.EntityUrnClickableSpan;
import com.linkedin.android.infra.ui.spans.EntityUrnClickableSpan.EntityUrnClickListener;
import com.linkedin.android.infra.ui.spans.TrackingClickableSpan;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.DiscussionSource;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.List;
import java.util.Map;

public final class FeedHeaderViewTransformer
{
  public static FeedHeaderViewModel toViewModel(FragmentComponent paramFragmentComponent, UpdateDataModel paramUpdateDataModel)
  {
    final Object localObject1 = null;
    Object localObject2;
    final Object localObject4;
    label121:
    label141:
    Object localObject5;
    Object localObject3;
    EntityClickableSpan localEntityClickableSpan;
    boolean bool;
    if ((paramUpdateDataModel instanceof SingleUpdateDataModel))
    {
      localObject2 = (SingleUpdateDataModel)paramUpdateDataModel;
      localObject1 = null;
      if ((localObject2 instanceof ViralSingleUpdateDataModel))
      {
        localObject4 = (ViralSingleUpdateDataModel)localObject2;
        if (!FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent))
        {
          if (header != null)
          {
            localObject1 = new EntityUrnClickableSpan.EntityUrnClickListener()
            {
              public final void onEntityUrnClicked(EntityUrnClickableSpan paramAnonymousEntityUrnClickableSpan)
              {
                FeedTracking.trackEntityUrnClick(val$fragmentComponent, "update_topbar_actor", paramAnonymousEntityUrnClickableSpan.getActionType(), localObject4pegasusUpdate);
              }
            };
            localObject1 = AttributedTextUtils.getAttributedString(header, paramFragmentComponent.context(), null, (EntityUrnClickableSpan.EntityUrnClickListener)localObject1);
          }
          while (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_USE_VIRAL_UPDATE_IN_DETAIL))
          {
            localObject2 = FeedTracking.newUpdateClickListener(pegasusUpdate, paramFragmentComponent, 0, true, SocialDetailDataModel.getHighlightedCommentUrns((UpdateDataModel)localObject4), SocialDetailDataModel.getHighlightedReplyUrns((UpdateDataModel)localObject4), "update_topbar", null);
            localObject1 = new FeedHeaderViewModel(new FeedHeaderLayout(), (CharSequence)localObject1, (TrackingOnClickListener)localObject2);
            if ((localObject1 != null) && (!actions.isEmpty())) {
              controlMenuListener = FeedTracking.newControlMenuClickListener(pegasusUpdate, actions, paramFragmentComponent);
            }
            return (FeedHeaderViewModel)localObject1;
            localObject5 = primaryActor;
            if (localObject5 == null)
            {
              localObject1 = null;
            }
            else
            {
              localObject3 = new SpannableStringBuilder();
              localObject2 = SingleUpdateDataModel.getContentDataModel((UpdateDataModel)localObject4);
              localEntityClickableSpan = EntityClickableSpan.getTopbarSpan((ActorDataModel)localObject5, pegasusUpdate, paramFragmentComponent);
              bool = localObject2 instanceof GroupDiscussionContentDataModel;
              localObject1 = null;
              if (!bool) {
                break label1815;
              }
              localObject2 = group;
              localObject1 = FeedI18NUtils.createGroupObjectMap$38243ca5(groupName);
            }
          }
        }
      }
    }
    for (;;)
    {
      int i;
      if (viralType == 1)
      {
        i = 2131231325;
        if (bool) {
          i = 2131231208;
        }
        ((SpannableStringBuilder)localObject3).append(FeedI18NUtils.translateActorString(paramFragmentComponent.i18NManager(), i, formattedName, i18nActorType, localEntityClickableSpan, (Map)localObject1));
      }
      for (;;)
      {
        if (!bool) {
          break label397;
        }
        localObject1 = FeedTracking.newGroupSpan((MiniGroup)localObject2, paramFragmentComponent, "update_topbar_actor", pegasusUpdate);
        paramFragmentComponent.i18NManager();
        localObject1 = FeedI18NUtils.attachGroupSpan$2e4942b((CharSequence)localObject3, (TrackingClickableSpan)localObject1);
        break;
        if (viralType == 2)
        {
          i = 2131231324;
          if (bool) {
            i = 2131231207;
          }
          ((SpannableStringBuilder)localObject3).append(FeedI18NUtils.translateActorString(paramFragmentComponent.i18NManager(), i, formattedName, i18nActorType, localEntityClickableSpan, (Map)localObject1));
        }
      }
      label397:
      localObject1 = localObject3;
      break;
      localObject2 = FeedTracking.newUpdateClickListener(originalUpdate.pegasusUpdate, urn, paramFragmentComponent, 0, true, SocialDetailDataModel.getHighlightedCommentUrns((UpdateDataModel)localObject4), SocialDetailDataModel.getHighlightedReplyUrns((UpdateDataModel)localObject4), "update_topbar", null);
      break label121;
      localObject1 = null;
      break label141;
      if ((localObject2 instanceof ChannelSingleUpdateDataModel))
      {
        localObject2 = (ChannelSingleUpdateDataModel)localObject2;
        if (!FeedViewTransformerHelpers.isChannelFeedPage(paramFragmentComponent))
        {
          localObject1 = headerText;
          localObject2 = FeedTracking.newUpdateClickListener(pegasusUpdate, paramFragmentComponent, 0, true, SocialDetailDataModel.getHighlightedCommentUrns((UpdateDataModel)localObject2), SocialDetailDataModel.getHighlightedReplyUrns((UpdateDataModel)localObject2), "update_topbar", null);
        }
        for (localObject1 = new FeedHeaderViewModel(new FeedHeaderLayout(), (CharSequence)localObject1, (TrackingOnClickListener)localObject2);; localObject1 = new FeedHeaderViewModel(new FeedHeaderLayout(), null, null)) {
          break;
        }
      }
      if ((localObject2 instanceof MentionedInNewsUpdateDataModel))
      {
        localObject1 = (MentionedInNewsUpdateDataModel)localObject2;
        localObject2 = new EntityUrnClickableSpan.EntityUrnClickListener()
        {
          public final void onEntityUrnClicked(EntityUrnClickableSpan paramAnonymousEntityUrnClickableSpan)
          {
            FeedTracking.trackEntityUrnClick(val$fragmentComponent, "update_topbar_actor", paramAnonymousEntityUrnClickableSpan.getActionType(), localObject1pegasusUpdate);
          }
        };
        localObject2 = AttributedTextUtils.getAttributedString(headerText, paramFragmentComponent.context(), null, (EntityUrnClickableSpan.EntityUrnClickListener)localObject2);
        localObject1 = FeedTracking.newUpdateClickListener(pegasusUpdate, paramFragmentComponent, 0, true, SocialDetailDataModel.getHighlightedCommentUrns((UpdateDataModel)localObject1), SocialDetailDataModel.getHighlightedReplyUrns((UpdateDataModel)localObject1), "update_topbar", null);
        localObject1 = new FeedHeaderViewModel(new FeedHeaderLayout(), (CharSequence)localObject2, (TrackingOnClickListener)localObject1);
      }
      for (;;)
      {
        break;
        if ((localObject2 instanceof DiscussionSingleUpdateDataModel))
        {
          localObject4 = (DiscussionSingleUpdateDataModel)localObject2;
          localObject2 = FeedTracking.newUpdateClickListener(pegasusUpdate, paramFragmentComponent, 0, true, SocialDetailDataModel.getHighlightedCommentUrns((UpdateDataModel)localObject4), SocialDetailDataModel.getHighlightedReplyUrns((UpdateDataModel)localObject4), "update_topbar", "viewUpdateDetail");
          if (FeedViewTransformerHelpers.isFeedPage(paramFragmentComponent)) {
            if (discussionSource == DiscussionSource.RECOMMENDED)
            {
              i = 1;
              label703:
              localObject5 = content;
              localObject3 = new SpannableStringBuilder();
              localObject1 = FeedI18NUtils.createGroupObjectMap$38243ca5(group.groupName);
              if (i == 0) {
                break label821;
              }
              localObject1 = paramFragmentComponent.i18NManager().getString(2131231266, (Map)localObject1);
              label751:
              ((SpannableStringBuilder)localObject3).append((CharSequence)localObject1);
              localObject1 = FeedTracking.newGroupSpan(group, paramFragmentComponent, "update_topbar_actor", pegasusUpdate);
              paramFragmentComponent.i18NManager();
              localObject1 = FeedI18NUtils.attachGroupSpan$2e4942b((CharSequence)localObject3, (TrackingClickableSpan)localObject1);
              localObject1 = new FeedHeaderViewModel(new FeedHeaderLayout(), (CharSequence)localObject1, (TrackingOnClickListener)localObject2);
            }
          }
          for (;;)
          {
            break;
            i = 0;
            break label703;
            label821:
            localObject1 = paramFragmentComponent.i18NManager().getString(2131231265, (Map)localObject1);
            break label751;
            if ((FeedViewTransformerHelpers.isGroupTab(paramFragmentComponent)) && (isFeatured))
            {
              localObject1 = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject1).append(paramFragmentComponent.i18NManager().getString(2131230914));
              if (!ArtDeco.isCJK()) {
                ((SpannableStringBuilder)localObject1).setSpan(new StyleSpan(1), 0, ((SpannableStringBuilder)localObject1).length(), 33);
              }
              localObject1 = new FeedHeaderViewModel(new FeedHeaderLayout(), (CharSequence)localObject1, (TrackingOnClickListener)localObject2);
            }
            else
            {
              localObject1 = null;
            }
          }
        }
        if ((localObject2 instanceof PropSingleUpdateDataModel))
        {
          localObject2 = (PropSingleUpdateDataModel)localObject2;
          if (!FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent))
          {
            localObject1 = headerText;
            localObject2 = FeedTracking.newUpdateClickListener(pegasusUpdate, paramFragmentComponent, 0, true, SocialDetailDataModel.getHighlightedCommentUrns((UpdateDataModel)localObject2), SocialDetailDataModel.getHighlightedReplyUrns((UpdateDataModel)localObject2), "update_topbar", null);
          }
          for (localObject1 = new FeedHeaderViewModel(new FeedHeaderLayout(), (CharSequence)localObject1, (TrackingOnClickListener)localObject2);; localObject1 = null) {
            break;
          }
        }
        if ((localObject2 instanceof CrossPromoSingleUpdateDataModel))
        {
          localObject1 = (CrossPromoSingleUpdateDataModel)localObject2;
          if (headerText.length() > 0) {}
          for (localObject1 = new FeedHeaderViewModel(new FeedHeaderLayout(), headerText, null);; localObject1 = null) {
            break;
          }
        }
        if (!(localObject2 instanceof LyndaSingleUpdateDataModel)) {
          break;
        }
        localObject1 = (LyndaSingleUpdateDataModel)localObject2;
        if (headerText.length() > 0) {
          localObject1 = new FeedHeaderViewModel(new FeedHeaderLayout(), headerText, null);
        } else {
          localObject1 = null;
        }
      }
      if (!(paramUpdateDataModel instanceof AggregatedUpdateDataModel)) {
        break label141;
      }
      localObject2 = (AggregatedUpdateDataModel)paramUpdateDataModel;
      localObject1 = null;
      if ((localObject2 instanceof AggregatedSingleUpdateDataModel))
      {
        localObject1 = (AggregatedSingleUpdateDataModel)localObject2;
        if (!FeedViewTransformerHelpers.isAggregateFeedPage(paramFragmentComponent))
        {
          localObject1 = FeedTracking.newAggregateUpdateClickListener(pegasusUpdate, paramFragmentComponent);
          localObject1 = new FeedHeaderViewModel(new FeedHeaderLayout(), paramFragmentComponent.i18NManager().getString(2131231079), (TrackingOnClickListener)localObject1);
        }
      }
      label1421:
      label1531:
      label1562:
      label1595:
      do
      {
        for (;;)
        {
          break;
          localObject1 = null;
          continue;
          if ((localObject2 instanceof AggregatedJymbiiUpdateDataModel))
          {
            localObject2 = (AggregatedJymbiiUpdateDataModel)localObject2;
            if (updates.isEmpty())
            {
              localObject1 = null;
            }
            else
            {
              localObject1 = null;
              if (!isSponsored) {
                localObject1 = FeedTracking.newJymbiiSeeMoreClickListener(paramFragmentComponent, updates.get(0)).pegasusUpdate, true);
              }
              localObject3 = new FeedHeaderLayout();
              if ((updates.size() > 0) && (updates.get(0)).sponsoredTemplateType == 3)) {}
              for (localObject2 = paramFragmentComponent.i18NManager().getString(2131231318);; localObject2 = paramFragmentComponent.i18NManager().getString(2131231320))
              {
                localObject1 = new FeedHeaderViewModel((FeedHeaderLayout)localObject3, (CharSequence)localObject2, (TrackingOnClickListener)localObject1);
                break;
              }
            }
          }
          else
          {
            if (!(localObject2 instanceof AggregatedFollowRecommendationUpdateDataModel)) {
              break label1531;
            }
            localObject2 = (AggregatedFollowRecommendationUpdateDataModel)localObject2;
            if (!updates.isEmpty()) {
              break label1421;
            }
            localObject1 = null;
          }
        }
        localObject1 = null;
        if (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_FOLLOW_RECOMMENDATION_SEE_MORE)) {
          localObject1 = FeedTracking.newSeeMoreFollowRecommendationClickListener(paramFragmentComponent, updates.get(0)).pegasusUpdate, true);
        }
        localObject3 = new FeedHeaderLayout();
        if (recommendationText != null) {}
        for (localObject2 = AttributedTextUtils.getAttributedString(recommendationText, paramFragmentComponent.context());; localObject2 = paramFragmentComponent.i18NManager().getString(2131231315))
        {
          localObject1 = new FeedHeaderViewModel((FeedHeaderLayout)localObject3, (CharSequence)localObject2, (TrackingOnClickListener)localObject1);
          break;
        }
        if ((localObject2 instanceof AggregatedConnectionUpdateDataModel))
        {
          localObject2 = (AggregatedConnectionUpdateDataModel)localObject2;
          if (updates.isEmpty())
          {
            localObject1 = null;
            if (localObject1 != null) {
              break label1595;
            }
          }
          for (localObject1 = null;; localObject1 = new FeedHeaderViewModel(new FeedHeaderLayout(), paramFragmentComponent.i18NManager().getString(2131231163, new Object[] { Integer.valueOf(updates.size()) }), (TrackingOnClickListener)localObject1))
          {
            break;
            localObject1 = updates.get(0)).pegasusUpdate;
            break label1562;
            localObject1 = FeedTracking.newSeeAllConnectionUpdatesClickListener(paramFragmentComponent, updates.get(0)).pegasusUpdate, pegasusUpdate.value.aggregatedConnectionUpdateValue, true);
          }
        }
      } while (!(localObject2 instanceof AggregatedPymkUpdateDataModel));
      localObject2 = (AggregatedPymkUpdateDataModel)localObject2;
      if (updates.isEmpty())
      {
        localObject1 = null;
        label1714:
        if (localObject1 != null) {
          break label1747;
        }
      }
      for (localObject1 = null;; localObject1 = new FeedHeaderViewModel(new FeedHeaderLayout(), paramFragmentComponent.i18NManager().getString(2131231274), (TrackingOnClickListener)localObject1))
      {
        break;
        localObject1 = updates.get(0)).pegasusUpdate;
        break label1714;
        label1747:
        localObject1 = FeedTracking.newSeeAllPymkUpdatesClickListener(paramFragmentComponent, updates.get(0)).pegasusUpdate, pegasusUpdate.value.aggregatedPymkUpdateValue, true);
      }
      label1815:
      localObject2 = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */