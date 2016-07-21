package com.linkedin.android.feed.page.feed.newupdatespill;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.shared.RepeatInForegroundRunnable;
import com.linkedin.android.feed.utils.FeedKeyValueStore;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedRouteUtils;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.PageInstance;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public final class CheckForNewUpdatesRunnable
  extends RepeatInForegroundRunnable
{
  private static final long LIX_FEED_REALTIME_REFRESH_RATE_DEFAULT = TimeUnit.MINUTES.toMillis(2L);
  private final FlagshipDataManager dataManager;
  private final FeedKeyValueStore feedValues;
  private CollectionTemplate<Update, Metadata> lastFeed;
  private final LixManager lixManager;
  private PageInstance pageInstance;
  private final FlagshipSharedPreferences sharedPrefs;
  private final Tracker tracker;
  
  public CheckForNewUpdatesRunnable(FlagshipDataManager paramFlagshipDataManager, DelayedExecution paramDelayedExecution, Tracker paramTracker, FlagshipSharedPreferences paramFlagshipSharedPreferences, FeedKeyValueStore paramFeedKeyValueStore, Bus paramBus, LixManager paramLixManager)
  {
    super("CheckForNewUpdatesRunnable", paramDelayedExecution, paramBus, FeedLixHelper.parseLong(paramLixManager, Lix.FEED_REALTIME_REFRESH_RATE, LIX_FEED_REALTIME_REFRESH_RATE_DEFAULT, 1000L));
    dataManager = paramFlagshipDataManager;
    sharedPrefs = paramFlagshipSharedPreferences;
    feedValues = paramFeedKeyValueStore;
    tracker = paramTracker;
    lixManager = paramLixManager;
    FeatureLog.i("CheckForNewUpdatesRunnable", "Initialized CheckForNewUpdatesRunnable, polling time: " + String.valueOf(interval), "Realtime Feed Updates");
  }
  
  public final void doRun()
  {
    FeatureLog.i("CheckForNewUpdatesRunnable", "running", "Realtime Feed Updates");
    if (feedValues.mostRecentFeedTime() == -1L)
    {
      FeatureLog.i("CheckForNewUpdatesRunnable", "skipping request: queryAfterTime has not been set", "Realtime Feed Updates");
      return;
    }
    RecordTemplateListener local1 = new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<CollectionTemplate<Update, Metadata>> paramAnonymousDataStoreResponse)
      {
        FeatureLog.i("CheckForNewUpdatesRunnable", "network response", "Realtime Feed Updates");
        if (stopped)
        {
          FeatureLog.i("CheckForNewUpdatesRunnable", "dropping network response because already stopped", "Realtime Feed Updates");
          return;
        }
        if (model == null)
        {
          CheckForNewUpdatesRunnable.access$002$280e73ff(CheckForNewUpdatesRunnable.this);
          FeatureLog.i("CheckForNewUpdatesRunnable", "got null response", "Realtime Feed Updates");
          return;
        }
        CheckForNewUpdatesRunnable.access$100(CheckForNewUpdatesRunnable.this, (CollectionTemplate)model);
      }
    };
    Request.Builder localBuilder = Request.get();
    Object localObject2 = lixManager;
    Object localObject1 = sharedPrefs.getLastActiveTab();
    long l = feedValues.mostRecentFeedTime();
    localObject2 = Routes.FEED.buildUponRoot().buildUpon().appendQueryParameter("q", "findRecentFeed").appendQueryParameter("count", FeedRouteUtils.getFeedPageSize((LixManager)localObject2)).appendQueryParameter("moduleKey", "home-feed:phone").appendQueryParameter("queryAfterTime", Long.toString(l));
    if (localObject1 == HomeTabInfo.SEARCH) {
      localObject1 = "search";
    }
    for (;;)
    {
      localObject1 = localBuilder.url(((Uri.Builder)localObject2).appendQueryParameter("tabType", (String)localObject1).build().toString()).customHeaders(Tracker.createPageInstanceHeader(getCurrentPageInstance())).builder(new CollectionTemplate.CollectionTemplateJsonParser(Update.BUILDER, Metadata.BUILDER)).listener(local1).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      FeatureLog.i("CheckForNewUpdatesRunnable", "submitting request", "Realtime Feed Updates");
      dataManager.submit((Request.Builder)localObject1);
      return;
      if (localObject1 == HomeTabInfo.RELATIONSHIPS) {
        localObject1 = "relationships";
      } else if (localObject1 == HomeTabInfo.MESSAGING) {
        localObject1 = "messaging";
      } else if (localObject1 == HomeTabInfo.ME) {
        localObject1 = "me";
      } else if (localObject1 == HomeTabInfo.NOTIFICATIONS) {
        localObject1 = "notifications";
      } else if (localObject1 == HomeTabInfo.FEED) {
        localObject1 = "feed";
      } else {
        localObject1 = null;
      }
    }
  }
  
  public final CollectionTemplate<Update, Metadata> getAndClearLastFeed()
  {
    CollectionTemplate localCollectionTemplate = lastFeed;
    lastFeed = null;
    return localCollectionTemplate;
  }
  
  public final PageInstance getCurrentPageInstance()
  {
    try
    {
      if (pageInstance == null) {
        pageInstance = new PageInstance(tracker, "feed_pill", UUID.randomUUID());
      }
      PageInstance localPageInstance = pageInstance;
      return localPageInstance;
    }
    finally {}
  }
  
  final void resetCurrentPageInstance()
  {
    try
    {
      pageInstance = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void restart(boolean paramBoolean)
  {
    resetCurrentPageInstance();
    super.restart(paramBoolean);
  }
  
  protected final void stop(boolean paramBoolean)
  {
    super.stop(paramBoolean);
    if (paramBoolean) {
      FeatureLog.i("CheckForNewUpdatesRunnable", "stopping due to backgrounding event", "Realtime Feed Updates");
    }
    do
    {
      return;
      FeatureLog.i("CheckForNewUpdatesRunnable", "stopping due to stop event", "Realtime Feed Updates");
    } while ((lastFeed == null) || (CollectionUtils.isEmpty(lastFeed.elements)));
    FeatureLog.i("CheckForNewUpdatesRunnable", "broadcasting new updates event", "Realtime Feed Updates");
    Bus.publish(new NewUpdatesEvent(this));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.newupdatespill.CheckForNewUpdatesRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */