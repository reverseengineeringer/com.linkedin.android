package com.linkedin.android.feed.endor.ui.update;

import android.content.Context;
import android.view.View;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.tracking.NestedTrackableViewModel;
import com.linkedin.android.feed.tracking.SponsoredUpdateTracker;
import com.linkedin.android.feed.viewmodels.models.FeedItemViewModel;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.data.OptimisticWrite;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.TrackingException;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.Mapper;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.gen.avro2pegasus.events.feed.Entity;
import com.linkedin.gen.avro2pegasus.events.feed.FeedImpressionEvent.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class FeedUpdateViewModel<VIEW_HOLDER extends BaseViewHolder>
  extends FeedItemViewModel<VIEW_HOLDER>
{
  protected Context appContext;
  public TrackingOnClickListener controlMenuClickListener;
  public final LixManager lixManager;
  public String searchId;
  public int sponsoredTemplateType;
  private final SponsoredUpdateTracker sponsoredUpdateTracker;
  public TrackingData trackingData;
  private int trackingViewId;
  public Update update;
  public String updateUrn;
  public final FeedComponentsViewPool viewPool;
  
  static
  {
    if (!FeedUpdateViewModel.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public FeedUpdateViewModel(Update paramUpdate, Context paramContext, FeedComponentsViewPool paramFeedComponentsViewPool, SponsoredUpdateTracker paramSponsoredUpdateTracker, LixManager paramLixManager)
  {
    update = paramUpdate;
    if (paramUpdate != null)
    {
      updateUrn = urn.toString();
      sponsoredTemplateType = FeedTracking.getSponsoredRenderFormatInt(tracking);
      trackingData = tracking;
    }
    if (paramContext != null) {
      appContext = paramContext.getApplicationContext();
    }
    viewPool = paramFeedComponentsViewPool;
    sponsoredUpdateTracker = paramSponsoredUpdateTracker;
    lixManager = paramLixManager;
  }
  
  public List<Entity> createTrackingEntities(ImpressionData paramImpressionData, int paramInt)
  {
    paramImpressionData = FeedTracking.createTrackingEntityForUpdate(lixManager, updateUrn, trackingData, paramImpressionData, paramInt);
    if (paramImpressionData != null) {
      return Collections.singletonList(paramImpressionData);
    }
    return null;
  }
  
  public List<List<FeedComponentViewModel>> getComponentSegmentsForBorders()
  {
    return null;
  }
  
  public List<FeedComponentViewModel> getComponents()
  {
    return new ArrayList();
  }
  
  public BaseFeedViewHolder getViewHolderForComponent(VIEW_HOLDER paramVIEW_HOLDER, FeedComponentViewModel paramFeedComponentViewModel)
  {
    return null;
  }
  
  public final boolean handlesViewModelChanges()
  {
    return true;
  }
  
  public final boolean isChangeableTo(ViewModel paramViewModel)
  {
    if (!(paramViewModel instanceof FeedUpdateViewModel)) {
      return false;
    }
    paramViewModel = (FeedUpdateViewModel)paramViewModel;
    if ((!OptimisticWrite.isTemporaryId(updateUrn)) && (OptimisticWrite.isTemporaryId(updateUrn))) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = Util.safeEquals(updateUrn, updateUrn);
      if ((!super.isChangeableTo(paramViewModel)) || ((i == 0) && (!bool))) {
        break;
      }
      return true;
    }
  }
  
  public final Mapper onBindTrackableViews(Mapper paramMapper, VIEW_HOLDER paramVIEW_HOLDER, int paramInt)
  {
    try
    {
      trackingViewId = itemView.getId();
      paramMapper.bindTrackableViews(new View[] { itemView });
      Iterator localIterator = getComponents().iterator();
      while (localIterator.hasNext())
      {
        FeedComponentViewModel localFeedComponentViewModel = (FeedComponentViewModel)localIterator.next();
        BaseFeedViewHolder localBaseFeedViewHolder = getViewHolderForComponent(paramVIEW_HOLDER, localFeedComponentViewModel);
        if (localBaseFeedViewHolder != null) {
          localFeedComponentViewModel.onBindTrackableViews(paramMapper, localBaseFeedViewHolder, paramInt);
        }
      }
    }
    catch (TrackingException localTrackingException)
    {
      for (;;)
      {
        itemView.getContext();
        Util.safeThrow$7a8b4789(new RuntimeException(localTrackingException));
      }
    }
    return paramMapper;
  }
  
  public final void onEnterViewPort(int paramInt, View paramView)
  {
    super.onEnterViewPort(paramInt, paramView);
    Iterator localIterator = getComponents().iterator();
    while (localIterator.hasNext()) {
      ((FeedComponentViewModel)localIterator.next()).onEnterViewPort(paramInt, paramView);
    }
  }
  
  public final void onLeaveViewPort(int paramInt1, int paramInt2)
  {
    super.onLeaveViewPort(paramInt1, paramInt2);
    Iterator localIterator = getComponents().iterator();
    while (localIterator.hasNext()) {
      ((FeedComponentViewModel)localIterator.next()).onLeaveViewPort(paramInt1, paramInt2);
    }
  }
  
  public void onRestoreUpdateViewState(ViewState paramViewState) {}
  
  public void onSaveUpdateViewState(ViewState paramViewState) {}
  
  public TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    int i = viewId;
    Object localObject = getComponents().iterator();
    while (((Iterator)localObject).hasNext())
    {
      FeedComponentViewModel localFeedComponentViewModel = (FeedComponentViewModel)((Iterator)localObject).next();
      if (((localFeedComponentViewModel instanceof NestedTrackableViewModel)) && (Util.contains(((NestedTrackableViewModel)localFeedComponentViewModel).getTrackableViewIds(), i))) {
        localFeedComponentViewModel.onTrackImpression(paramImpressionData);
      }
    }
    if ((viewId == trackingViewId) || (trackingViewId == 0))
    {
      paramImpressionData = createTrackingEntities(paramImpressionData, position + 1);
      if ((paramImpressionData != null) && (!paramImpressionData.isEmpty()))
      {
        paramImpressionData = new FeedImpressionEvent.Builder().setEntities(paramImpressionData);
        localObject = searchId;
        if (localObject == null)
        {
          hasSearchId = false;
          searchId = null;
          return paramImpressionData;
        }
        hasSearchId = true;
        searchId = ((String)localObject);
        return paramImpressionData;
      }
    }
    return null;
  }
  
  public final void trackImpressionIfSponsored(Map<String, String> paramMap, int paramInt)
  {
    if (FeedTracking.isSponsored(trackingData))
    {
      assert (trackingData.sponsoredTracking != null);
      sponsoredUpdateTracker.trackImpression(paramMap, trackingData, trackingData.sponsoredTracking, sponsoredTemplateType, paramInt + 1);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */