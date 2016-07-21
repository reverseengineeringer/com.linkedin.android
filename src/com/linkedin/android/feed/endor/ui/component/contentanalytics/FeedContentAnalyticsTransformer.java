package com.linkedin.android.feed.endor.ui.component.contentanalytics;

import android.content.Context;
import android.view.View;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ReshareSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.divider.FeedDividerViewTransformer;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.identity.me.contentanalytics.ContentAnalyticsBundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.NavigationManager;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.identity.me.SocialUpdateType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.ArrayList;
import java.util.List;

public final class FeedContentAnalyticsTransformer
{
  public static List<FeedComponentViewModel> toEntryViewModelWithDivider(FragmentComponent paramFragmentComponent, final SingleUpdateDataModel paramSingleUpdateDataModel)
  {
    final Object localObject3 = null;
    ArrayList localArrayList = new ArrayList(2);
    final Object localObject1 = paramFragmentComponent.lixManager();
    boolean bool1 = FeedLixHelper.isEnabled((LixManager)localObject1, Lix.ME_CONTENT_ANALYTICS_FEED_POSTS_ENTRY);
    boolean bool2 = FeedLixHelper.isEnabled((LixManager)localObject1, Lix.ME_CONTENT_ANALYTICS_FEED_SHARES_ENTRY);
    Object localObject2 = localObject3;
    if (socialDetail != null)
    {
      if (socialDetail.hasViews) {
        break label93;
      }
      localObject2 = localObject3;
    }
    label93:
    label113:
    do
    {
      do
      {
        if (localObject2 != null)
        {
          localArrayList.add(FeedDividerViewTransformer.getDefaultViewModel());
          localArrayList.add(localObject2);
        }
        return localArrayList;
        if ((!paramSingleUpdateDataModel.isPublisherActor(paramFragmentComponent)) || ((paramSingleUpdateDataModel instanceof ReshareSingleUpdateDataModel))) {
          break label273;
        }
        localObject1 = SocialUpdateType.POST;
        if (localObject1 != SocialUpdateType.POST) {
          break;
        }
        localObject2 = localObject3;
      } while (!bool1);
      if (localObject1 != SocialUpdateType.SHARE) {
        break;
      }
      localObject2 = localObject3;
    } while (!bool2);
    localObject2 = new FeedContentAnalyticsEntryViewModel(new FeedContentAnalyticsEntryLayout(paramFragmentComponent.context().getResources()));
    localObject3 = paramFragmentComponent.i18NManager();
    if (localObject1 == SocialUpdateType.POST) {}
    for (text = ((I18NManager)localObject3).getString(2131231802, new Object[] { Integer.valueOf(socialDetail.totalViews) });; text = ((I18NManager)localObject3).getString(2131231808, new Object[] { Integer.valueOf(socialDetail.totalViews) }))
    {
      localObject3 = paramFragmentComponent.navigationManager();
      final IntentRegistry localIntentRegistry = paramFragmentComponent.intentRegistry();
      paramSingleUpdateDataModel = pegasusUpdate.urn;
      clickListener = new TrackingOnClickListener(paramFragmentComponent.tracker(), "", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          paramAnonymousView = new ContentAnalyticsBundleBuilder(paramSingleUpdateDataModel, localObject1);
          localObject3.navigate(localIntentRegistrycontentAnalytics, paramAnonymousView);
        }
      };
      break;
      label273:
      localObject1 = SocialUpdateType.SHARE;
      break label113;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.contentanalytics.FeedContentAnalyticsTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */