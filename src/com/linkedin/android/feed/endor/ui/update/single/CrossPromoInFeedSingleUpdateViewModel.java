package com.linkedin.android.feed.endor.ui.update.single;

import android.content.Context;
import com.linkedin.CrossPromoLib.utils.Utils;
import com.linkedin.android.axle.tracking.LegoTrackingUtils;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.feed.AppActor;
import com.linkedin.android.pegasus.gen.voyager.feed.CrossPromoUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;
import java.util.List;

public final class CrossPromoInFeedSingleUpdateViewModel
  extends FeedSingleUpdateViewModel
{
  public String appId;
  public Context context;
  public FlagshipDataManager dataManager;
  public String legoTrackingId;
  public String legoTrackingToken;
  
  public CrossPromoInFeedSingleUpdateViewModel(Update paramUpdate, FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, List<FeedComponentViewModel> paramList, TrackingOnClickListener paramTrackingOnClickListener)
  {
    super(paramUpdate, paramFragmentComponent, paramFeedComponentsViewPool, paramList, paramTrackingOnClickListener);
    dataManager = paramFragmentComponent.dataManager();
    context = paramFragmentComponent.appContext();
    if (value.crossPromoUpdateValue != null)
    {
      legoTrackingId = value.crossPromoUpdateValue.legoTrackingId;
      legoTrackingToken = value.crossPromoUpdateValue.legoTrackingToken;
      appId = value.crossPromoUpdateValue.actor.appId;
    }
  }
  
  public final TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    if (legoTrackingId != null) {}
    try
    {
      LegoTrackingUtils.sendLegoTrackingImpressionEvent(dataManager, legoTrackingId, legoTrackingToken);
      if ((appId != null) && (Utils.isAppInstalled(context, appId))) {
        LegoTrackingUtils.sendLegoWidgetActionEvent(dataManager, legoTrackingId, legoTrackingToken, ActionCategory.SKIP);
      }
      return super.onTrackImpression(paramImpressionData);
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create lego event"));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.single.CrossPromoInFeedSingleUpdateViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */