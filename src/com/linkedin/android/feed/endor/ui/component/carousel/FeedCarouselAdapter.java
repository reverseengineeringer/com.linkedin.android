package com.linkedin.android.feed.endor.ui.component.carousel;

import android.view.View;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.TrackingUtils;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.feed.Entity;
import com.linkedin.gen.avro2pegasus.events.feed.Entity.Builder;
import com.linkedin.gen.avro2pegasus.events.feed.FeedImpressionEvent;
import com.linkedin.gen.avro2pegasus.events.feed.FeedImpressionEvent.Builder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class FeedCarouselAdapter
  extends ViewModelArrayAdapter<FeedCarouselComponentViewModel>
{
  private final String associatedControlUrn;
  private final String controlName;
  final Set<Integer> initiallyVisibleViewPositions = new HashSet();
  boolean isInInitialLayout;
  private int numConsecutiveSwipes;
  private final String pageKey;
  final Tracker tracker;
  int verticalPos;
  final ViewPortManager viewPortManager;
  
  public FeedCarouselAdapter(FragmentComponent paramFragmentComponent, String paramString1, String paramString2)
  {
    super(paramFragmentComponent.context(), paramFragmentComponent.mediaCenter(), new ArrayList());
    tracker = paramFragmentComponent.tracker();
    associatedControlUrn = TrackingUtils.makeControlUrnFromControlName(tracker, "update_card");
    viewPortManager = paramFragmentComponent.viewportManager();
    controlName = paramString1;
    pageKey = paramString2;
    setViewPortManager(viewPortManager);
  }
  
  private FeedImpressionEvent.Builder addAssociatedControlUrn(FeedImpressionEvent.Builder paramBuilder)
  {
    try
    {
      Object localObject1 = paramBuilder.build(RecordTemplate.Flavor.PARTIAL);
      Object localObject2 = entities;
      ArrayList localArrayList = new ArrayList(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        Entity.Builder localBuilder = new Entity.Builder((Entity)((Iterator)localObject2).next());
        String str = associatedControlUrn;
        if (str == null) {
          hasAssociatedInputControlUrn = false;
        }
        for (associatedInputControlUrn = null;; associatedInputControlUrn = str)
        {
          localArrayList.add(localBuilder.build(RecordTemplate.Flavor.RECORD));
          break;
          hasAssociatedInputControlUrn = true;
        }
      }
      localObject1 = new FeedImpressionEvent.Builder((FeedImpressionEvent)localObject1).setEntities(localArrayList);
      return (FeedImpressionEvent.Builder)localObject1;
    }
    catch (BuilderException localBuilderException) {}
    return paramBuilder;
  }
  
  public final void onBindViewHolder(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    super.onBindViewHolder(paramBaseViewHolder, paramInt);
    if ((paramInt >= 0) && (paramInt < getItemCount())) {}
    for (paramBaseViewHolder = (FeedCarouselComponentViewModel)getItemAtPosition(paramInt);; paramBaseViewHolder = null)
    {
      if ((verticalPos >= 0) && (paramBaseViewHolder != null)) {
        verticalPos = verticalPos;
      }
      return;
    }
  }
  
  public final void onEnterViewPort(int paramInt, View paramView)
  {
    if (isInInitialLayout) {
      initiallyVisibleViewPositions.add(Integer.valueOf(paramInt));
    }
    super.onEnterViewPort(paramInt, paramView);
  }
  
  public final TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    TrackingEventBuilder localTrackingEventBuilder = super.onTrackImpression(paramImpressionData);
    if ((localTrackingEventBuilder instanceof FeedImpressionEvent.Builder))
    {
      int i = position;
      if (initiallyVisibleViewPositions.contains(Integer.valueOf(i))) {
        initiallyVisibleViewPositions.remove(Integer.valueOf(i));
      }
    }
    else
    {
      return localTrackingEventBuilder;
    }
    return addAssociatedControlUrn((FeedImpressionEvent.Builder)localTrackingEventBuilder);
  }
  
  public final void registerSwipe(int paramInt)
  {
    if (paramInt == 1) {
      new ControlInteractionEvent(tracker, controlName, ControlType.CAROUSEL, InteractionType.SWIPE_RIGHT).send();
    }
    for (;;)
    {
      numConsecutiveSwipes += 1;
      if ((tracker != null) && (numConsecutiveSwipes % 3 == 0)) {
        new PageViewEvent(tracker, pageKey, false).send();
      }
      return;
      if (paramInt == 2) {
        new ControlInteractionEvent(tracker, controlName, ControlType.CAROUSEL, InteractionType.SWIPE_LEFT).send();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.carousel.FeedCarouselAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */