package com.linkedin.android.infra.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.CollectionDataEvent;
import com.linkedin.android.infra.events.DataErrorEvent;
import com.linkedin.android.infra.events.DataReceivedEvent;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.perftimer.RUMTiming;
import com.linkedin.android.tracking.v2.Page;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public abstract class TrackableFragment
  extends BaseFragment
  implements ScreenElement, Page
{
  private static final String TAG = TrackableFragment.class.getSimpleName();
  public String busSubscriberId;
  private boolean callEnterAfterResume;
  private final Object dataSubscriber = new Object()
  {
    @Subscribe
    public final void onEvent(CollectionDataEvent paramAnonymousCollectionDataEvent)
    {
      if (busSubscriberId.equals(subscriberId)) {
        onCollectionDataEvent(requestState, changedCollectionModel, type, collectionRoute, rumSessionId);
      }
    }
    
    @Subscribe
    public final void onEvent(DataErrorEvent paramAnonymousDataErrorEvent)
    {
      if (busSubscriberId.equals(subscriberId)) {
        onDataError(type, routes, error);
      }
    }
    
    @Subscribe
    public final void onEvent(DataReceivedEvent paramAnonymousDataReceivedEvent)
    {
      int i;
      if (busSubscriberId.equals(subscriberId))
      {
        if ((rumSessionId == null) || (rumSessionId == null) || (!rumSessionId.equals(rumSessionId))) {
          break label122;
        }
        i = 1;
        if (type == DataStore.Type.NETWORK) {
          break label127;
        }
      }
      label122:
      label127:
      for (boolean bool = true;; bool = false)
      {
        if (i != 0) {
          RUMTiming.renderStart(rumSessionId, bool, shouldAggregateMultipleRenders());
        }
        onDataReady(type, routes, responseMap);
        if (i != 0) {
          RUMHelper.callRenderEndOnNextLoop(rumSessionId, bool);
        }
        return;
        i = 0;
        break;
      }
    }
  };
  public DelayedExecution delayedExecution;
  private boolean firstTimeCallDoEnter;
  public boolean isActive;
  private long lastDoEnterTimestamp;
  Tracker perfTracker;
  public String rumSessionId;
  private boolean rumSessionIdInheritedFromParent;
  private boolean shouldSubscribeOnStartStop;
  @Inject
  public Tracker tracker;
  private BaseActivity trackingActivity;
  private UUID trackingId;
  
  private String getRumSessionIdFromParent()
  {
    if (isParentFragment()) {}
    Fragment localFragment;
    do
    {
      return null;
      localFragment = getParentFragment();
    } while ((localFragment == null) || (!(localFragment instanceof TrackableFragment)));
    return ((TrackableFragment)localFragment).getRumSessionId();
  }
  
  public final boolean didEnter()
  {
    return isActive;
  }
  
  public void doEnter()
    throws TrackableFragment.EnterTooEarlyException
  {
    boolean bool = true;
    FeatureLog.v(TAG, "doEnter() for " + pageKey(), "Trackable Fragment Lifecycle");
    if (!isResumed()) {
      throw new EnterTooEarlyException("doEnter() called before resumed! for " + pageKey());
    }
    if (tracker == null) {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    if (l - lastDoEnterTimestamp < 200L)
    {
      FeatureLog.v(TAG, "extra callback, ignoring for " + pageKey(), "Trackable Fragment Lifecycle");
      return;
    }
    if (isActive)
    {
      FeatureLog.v(TAG, "already active, ignoring for " + pageKey(), "Trackable Fragment Lifecycle");
      return;
    }
    isActive = true;
    lastDoEnterTimestamp = l;
    Object localObject1;
    Object localObject2;
    if (shouldTrack())
    {
      if (!firstTimeCallDoEnter) {
        trackingId = UUID.randomUUID();
      }
      localObject1 = tracker.getCurrentPageInstance().pageKey;
      if (isAnchorPage())
      {
        FeatureLog.v(TAG, "anchor page, setting current page instance to " + pageKey(), "Trackable Fragment Lifecycle");
        localObject2 = getPageInstance();
        tracker.currentPageInstance = ((PageInstance)localObject2);
        perfTracker.currentPageInstance = ((PageInstance)localObject2);
      }
      CrashReporter.leaveBreadcrumb(pageKey());
      if (tracker.getCurrentPageInstance().pageKey.equals(localObject1)) {
        break label412;
      }
      label281:
      if ((tracker.getCurrentPageInstance().pageKey.equals(localObject1)) && (!firstTimeCallDoEnter)) {
        break label417;
      }
      FeatureLog.v(TAG, "new page [" + bool + "] or firstTimeCallDoEnter [" + firstTimeCallDoEnter + "]", "Trackable Fragment Lifecycle");
      firePageViewEvent();
    }
    for (;;)
    {
      firstTimeCallDoEnter = false;
      if (getScreenElements() == null) {
        break;
      }
      localObject1 = getScreenElements().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ScreenElement)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ScreenElement)localObject2).onEnter();
        }
      }
      break;
      label412:
      bool = false;
      break label281;
      label417:
      Log.e(TAG, "not the first time doEnter() has been called and we're still on the same page!");
    }
  }
  
  public void doLeave()
  {
    FeatureLog.v(TAG, "doLeave() for " + pageKey(), "Trackable Fragment Lifecycle");
    isActive = false;
    if (getScreenElements() != null)
    {
      Iterator localIterator = getScreenElements().iterator();
      while (localIterator.hasNext())
      {
        ScreenElement localScreenElement = (ScreenElement)localIterator.next();
        if (localScreenElement != null) {
          localScreenElement.onLeave();
        }
      }
    }
    if (shouldTrack()) {
      firstTimeCallDoEnter = true;
    }
  }
  
  public void doPause() {}
  
  public void doResume() {}
  
  public void firePageViewEvent()
  {
    FeatureLog.v(TAG, "firing page view event for " + pageKey(), "Trackable Fragment Lifecycle");
    PageViewEvent localPageViewEvent = new PageViewEvent(tracker, this);
    BaseActivity localBaseActivity = trackingActivity;
    path = trackingPath;
    referer = trackingReferrer;
    trackingPath = null;
    trackingReferrer = null;
    localPageViewEvent.send();
  }
  
  public final PageInstance getPageInstance()
  {
    return new PageInstance(tracker, pageKey(), trackingId);
  }
  
  public final String getRumSessionId()
  {
    String str = rumSessionId;
    refreshRUMSessionId();
    return str;
  }
  
  public List<ScreenElement> getScreenElements()
  {
    return null;
  }
  
  public abstract int getTrackingMode();
  
  public abstract boolean isAnchorPage();
  
  public boolean isParentFragment()
  {
    return false;
  }
  
  public String loadMorePageKey()
  {
    return pageKey();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    FeatureLog.v(TAG, "onAttach for " + pageKey(), "Trackable Fragment Lifecycle");
    tracker = fragmentComponent.tracker();
    perfTracker = applicationComponent.perfTracker();
  }
  
  public void onCollectionDataEvent(int paramInt, CollectionTemplate paramCollectionTemplate, DataStore.Type paramType, String paramString1, String paramString2) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    FeatureLog.v(TAG, "onCreate for " + pageKey(), "Trackable Fragment Lifecycle");
    if (shouldTrackRUM())
    {
      rumSessionId = getRumSessionIdFromParent();
      if (rumSessionId == null) {
        rumSessionId = RUMHelper.pageInit(this);
      }
    }
    else
    {
      if (!isParentFragment()) {
        break label174;
      }
      paramBundle = null;
      label73:
      if ((!shouldInheritSubscriberId()) || (paramBundle == null) || (!(paramBundle instanceof TrackableFragment))) {
        break label182;
      }
    }
    label174:
    label182:
    for (busSubscriberId = busSubscriberId;; busSubscriberId = (getClass().getSimpleName() + UUID.randomUUID()))
    {
      firstTimeCallDoEnter = true;
      trackingId = UUID.randomUUID();
      delayedExecution = fragmentComponent.delayedExecution();
      trackingActivity = ((BaseActivity)getActivity());
      shouldSubscribeOnStartStop = "enabled".equals(fragmentComponent.lixManager().getTreatment(Lix.INFRA_EVENT_BUS_SUBSCRIBE_ON_START_STOP));
      return;
      rumSessionIdInheritedFromParent = true;
      break;
      paramBundle = getParentFragment();
      break label73;
    }
  }
  
  public void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException) {}
  
  public void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap) {}
  
  public final void onEnter()
  {
    FeatureLog.v(TAG, "onEnter() for " + pageKey(), "Trackable Fragment Lifecycle");
    if (isActive)
    {
      FeatureLog.v(TAG, "already active, not calling doEnter() for " + pageKey(), "Trackable Fragment Lifecycle");
      return;
    }
    if (isResumed())
    {
      callEnterAfterResume = false;
      FeatureLog.v(TAG, "already resumed, calling doEnter() for " + pageKey(), "Trackable Fragment Lifecycle");
      doEnter();
      return;
    }
    FeatureLog.v(TAG, "not yet resumed, calling doEnter() after doResume() for " + pageKey(), "Trackable Fragment Lifecycle");
    callEnterAfterResume = true;
  }
  
  public final void onLeave()
  {
    FeatureLog.v(TAG, "onLeave() for " + pageKey(), "Trackable Fragment Lifecycle");
    if (!isActive) {
      FeatureLog.v(TAG, "doLeave() not called because not active for " + pageKey(), "Trackable Fragment Lifecycle");
    }
    while (!isResumed()) {
      return;
    }
    FeatureLog.v(TAG, "doLeave() because currently resumed for " + pageKey(), "Trackable Fragment Lifecycle");
    doLeave();
  }
  
  public final void onPause()
  {
    int i = getTrackingMode();
    switch (i)
    {
    default: 
      FeatureLog.v(TAG, "doLeave() not called because of unknown tracking mode [" + i + "] for " + pageKey(), "Trackable Fragment Lifecycle");
    }
    for (;;)
    {
      FeatureLog.v(TAG, "onPause() for " + pageKey(), "Trackable Fragment Lifecycle");
      super.onPause();
      if (!shouldSubscribeOnStartStop)
      {
        fragmentComponent.eventBus();
        Bus.unsubscribe(dataSubscriber);
      }
      if ((shouldTrackRUM()) && (rumSessionIdInheritedFromParent)) {
        rumSessionId = getRumSessionIdFromParent();
      }
      FeatureLog.v(TAG, "doPause() for " + pageKey(), "Trackable Fragment Lifecycle");
      doPause();
      return;
      FeatureLog.v(TAG, "doLeave() for page " + pageKey(), "Trackable Fragment Lifecycle");
      doLeave();
      continue;
      if (isActive)
      {
        FeatureLog.v(TAG, "doLeave() because pausing while active for page " + pageKey(), "Trackable Fragment Lifecycle");
        doLeave();
      }
    }
  }
  
  public final void onResume()
  {
    FeatureLog.v(TAG, "onResume() for " + pageKey(), "Trackable Fragment Lifecycle");
    super.onResume();
    if (!shouldSubscribeOnStartStop)
    {
      fragmentComponent.eventBus();
      Bus.subscribe(dataSubscriber);
    }
    if ((shouldTrackRUM()) && (rumSessionIdInheritedFromParent)) {
      rumSessionId = getRumSessionIdFromParent();
    }
    FeatureLog.v(TAG, "doResume() for " + pageKey(), "Trackable Fragment Lifecycle");
    doResume();
    int i = getTrackingMode();
    switch (i)
    {
    default: 
      FeatureLog.v(TAG, "doEnter() not called because of unknown tracking mode [" + i + "] for " + pageKey(), "Trackable Fragment Lifecycle");
    }
    do
    {
      return;
      doEnter();
      return;
    } while (!callEnterAfterResume);
    callEnterAfterResume = false;
    FeatureLog.v(TAG, "doEnter() because of callEnterAfterResume for " + pageKey(), "Trackable Fragment Lifecycle");
    doEnter();
  }
  
  public void onStart()
  {
    super.onStart();
    if (shouldSubscribeOnStartStop)
    {
      fragmentComponent.eventBus();
      Bus.subscribe(dataSubscriber);
    }
  }
  
  public void onStop()
  {
    if (shouldSubscribeOnStartStop)
    {
      fragmentComponent.eventBus();
      Bus.unsubscribe(dataSubscriber);
    }
    super.onStop();
  }
  
  public String refreshPageKey()
  {
    return pageKey();
  }
  
  public final void refreshRUMSessionId()
  {
    if (shouldTrackRUM())
    {
      if (rumSessionIdInheritedFromParent) {
        rumSessionId = getRumSessionIdFromParent();
      }
    }
    else {
      return;
    }
    rumSessionId = RUMHelper.pageInit(this);
  }
  
  public boolean shouldAggregateMultipleRenders()
  {
    return false;
  }
  
  public boolean shouldInheritSubscriberId()
  {
    return true;
  }
  
  public boolean shouldTrack()
  {
    return true;
  }
  
  public boolean shouldTrackRUM()
  {
    return true;
  }
  
  public final void trackButtonShortPress(String paramString)
  {
    new ControlInteractionEvent(tracker, paramString, ControlType.BUTTON, InteractionType.SHORT_PRESS).send();
  }
  
  public static final class EnterTooEarlyException
    extends RuntimeException
  {
    public EnterTooEarlyException(String paramString)
    {
      super();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.TrackableFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */