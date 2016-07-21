package com.linkedin.android.feed.page.feed.newupdatespill;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.FeedViewTransformer;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.shared.RepeatInForegroundRunnable.StopEvent;
import com.linkedin.android.feed.utils.FeedKeyValueStore;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.feed.viewmodels.models.FeedItemViewModel;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.home.badging.BadgeUpdateEvent;
import com.linkedin.android.infra.RepeatingRunnable;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.SamsungUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.consistency.ModelListItemChangedListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.Subscribe;

public final class NewUpdatesManager
{
  private static final long LIX_FEED_NEW_SESSION_LENGTH_DEFAULT = TimeUnit.MINUTES.toMillis(30L);
  private boolean appendHardRefreshNextPill;
  public final boolean fastNetwork;
  public final long feedStartTimestamp;
  private final FeedKeyValueStore feedValues;
  public final WeakReference<FragmentComponent> fragmentComponentReference;
  public final boolean newFeedSession;
  public final long newSessionThreshold;
  protected final List<FeedItemViewModel> newUpdates = new ArrayList();
  public CollectionTemplate<Update, Metadata> newUpdatesCollection;
  private final ModelListItemChangedListener<Update> updateChangedListener = new ModelListItemChangedListener() {};
  private final WeakReference<FeedComponentsViewPool> viewPoolReference;
  
  public NewUpdatesManager(Context paramContext, FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool)
  {
    fragmentComponentReference = new WeakReference(paramFragmentComponent);
    viewPoolReference = new WeakReference(paramFeedComponentsViewPool);
    feedValues = paramFragmentComponent.feedValues();
    FeatureLog.registerFeature("Realtime Feed Updates");
    FeatureLog.i("NewUpdatesManager", "Initializing NewUpdatesManager", "Realtime Feed Updates");
    Object localObject = paramFragmentComponent.lixManager();
    paramFeedComponentsViewPool = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    localObject = ((LixManager)localObject).getTreatment(Lix.FEED_REALTIME_NETWORKSPEED);
    if (((String)localObject).equals("force_fast"))
    {
      FeatureLog.i("NewUpdatesManager", "fast network lix override", "Realtime Feed Updates");
      bool1 = true;
      fastNetwork = bool1;
      FeatureLog.i("NewUpdatesManager", "fast network: " + String.valueOf(fastNetwork), "Realtime Feed Updates");
      newSessionThreshold = FeedLixHelper.parseLong(paramFragmentComponent.lixManager(), Lix.FEED_NEW_SESSION_LENGTH, LIX_FEED_NEW_SESSION_LENGTH_DEFAULT, 60000L);
      FeatureLog.i("NewUpdatesManager", "new session threshold: " + String.valueOf(newSessionThreshold), "Realtime Feed Updates");
      paramFragmentComponent.timeWrapper();
      feedStartTimestamp = System.currentTimeMillis();
      long l = paramFragmentComponent.flagshipSharedPreferences().getAppLastBackgroundTimeStamp();
      if (feedStartTimestamp - l < newSessionThreshold) {
        break label554;
      }
    }
    label456:
    label514:
    label520:
    label537:
    label552:
    label554:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      newFeedSession = bool1;
      FeatureLog.i("NewUpdatesManager", "new session: " + String.valueOf(newFeedSession), "Realtime Feed Updates");
      paramFragmentComponent.eventBus();
      Bus.subscribe(this);
      paramFragmentComponent.eventBus();
      Bus.publish(new RepeatInForegroundRunnable.StopEvent("Realtime Feed Updates"));
      FeatureLog.i("NewUpdatesManager", "Initialized NewUpdatesManager", "Realtime Feed Updates");
      return;
      if (((String)localObject).equals("force_slow")) {
        FeatureLog.i("NewUpdatesManager", "slow network lix override", "Realtime Feed Updates");
      }
      for (;;)
      {
        bool1 = false;
        break;
        if ((paramFeedComponentsViewPool == null) || (paramFeedComponentsViewPool.getState() != NetworkInfo.State.CONNECTED))
        {
          FeatureLog.i("NewUpdatesManager", "no active network", "Realtime Feed Updates");
        }
        else
        {
          if (paramFeedComponentsViewPool.getType() == 1)
          {
            if (ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_WIFI_STATE") != 0) {
              break label520;
            }
            FeatureLog.i("NewUpdatesManager", "checking detailed wifi speed", "Realtime Feed Updates");
            paramFeedComponentsViewPool = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
            if ((paramFeedComponentsViewPool == null) || (paramFeedComponentsViewPool.getLinkSpeed() < 20L)) {
              break label514;
            }
            i = 1;
            if (i != 0) {}
          }
          else
          {
            paramContext = (TelephonyManager)paramContext.getSystemService("phone");
            if ((SamsungUtils.getDataState(paramContext) != 2) || (paramContext.getNetworkType() != 13)) {
              break label537;
            }
            FeatureLog.i("NewUpdatesManager", "connected to LTE", "Realtime Feed Updates");
          }
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label552;
            }
            bool1 = true;
            break;
            i = 0;
            break label456;
            FeatureLog.i("NewUpdatesManager", "assuming wifi is fast", "Realtime Feed Updates");
            i = 1;
            break label456;
            FeatureLog.i("NewUpdatesManager", "no LTE data connected", "Realtime Feed Updates");
          }
        }
      }
    }
  }
  
  public static void initializeNewUpdatesChecking(Context paramContext)
  {
    paramContext = ((FlagshipApplication)paramContext.getApplicationContext()).getAppComponent();
    long l1 = paramContext.flagshipSharedPreferences().getAppLastBackgroundTimeStamp();
    long l2 = FeedLixHelper.parseLong(paramContext.lixManager(), Lix.FEED_NEW_SESSION_LENGTH, LIX_FEED_NEW_SESSION_LENGTH_DEFAULT, 60000L);
    if (System.currentTimeMillis() - l1 > l2) {}
    for (int i = 1; i != 0; i = 0)
    {
      FeatureLog.i("NewUpdatesManager", "App Startup new session, showing badge", "Realtime Feed Updates");
      paramContext.eventBus();
      Bus.publishStickyEvent(BadgeUpdateEvent.createWithShouldUpdateOuterBadge(HomeTabInfo.FEED, Long.valueOf(1L)));
      return;
    }
    FeatureLog.i("NewUpdatesManager", "App Startup same session, starting new updates check", "Realtime Feed Updates");
    paramContext.newUpdatesChecker().run();
  }
  
  public final List<FeedItemViewModel> getAndClearNewUpdates()
  {
    updateMostRecentFeedTime();
    ArrayList localArrayList = new ArrayList(newUpdates);
    newUpdates.clear();
    return localArrayList;
  }
  
  public final int getAndResetPillBehavior()
  {
    int i = 2;
    if ((newUpdatesCollection != null) && (newUpdatesCollection.metadata != null) && (newUpdatesCollection.metadata).newRelevanceFeed)) {
      return 3;
    }
    if ((appendHardRefreshNextPill) && (!newUpdates.isEmpty())) {
      i = 1;
    }
    for (;;)
    {
      appendHardRefreshNextPill = false;
      FeatureLog.i("NewUpdatesManager", "gave [" + i + "] pill behavior, and resetting appendHardRefreshNextPill", "Realtime Feed Updates");
      return i;
      if (newUpdates.size() > 0) {
        i = 0;
      }
    }
  }
  
  public final int getInitialFetchFilter()
  {
    int i;
    if ((newFeedSession) && (fastNetwork)) {
      i = 3;
    }
    for (;;)
    {
      FeatureLog.i("NewUpdatesManager", "gave [" + i + "] initial fetch filter", "Realtime Feed Updates");
      return i;
      if (!newFeedSession) {
        i = 4;
      } else {
        i = 2;
      }
    }
  }
  
  @Subscribe
  public final void onEvent(NewUpdatesEvent paramNewUpdatesEvent)
  {
    FeatureLog.i("NewUpdatesManager", "new updates event", "Realtime Feed Updates");
    if ((appendHardRefreshNextPill) && (!newUpdates.isEmpty()))
    {
      FeatureLog.i("NewUpdatesManager", "ignoring due to appendHardRefreshNextPill", "Realtime Feed Updates");
      return;
    }
    transformAndStoreFeed(newUpdatesChecker.getAndClearLastFeed());
  }
  
  public final void setNewUpdatesCollection$12f66db9(CollectionTemplate<Update, Metadata> paramCollectionTemplate, List<? extends FeedItemViewModel> paramList)
  {
    FeatureLog.i("NewUpdatesManager", "got [" + paramList.size() + "] fresh network updates to put in pill", "Realtime Feed Updates");
    newUpdates.clear();
    newUpdates.addAll(paramList);
    appendHardRefreshNextPill = true;
    newUpdatesCollection = paramCollectionTemplate;
  }
  
  public final boolean shouldShowNewUpdatesPill()
  {
    return newUpdates.size() > 0;
  }
  
  protected final void storeNewUpdates(FragmentComponent paramFragmentComponent, CollectionTemplate<Update, Metadata> paramCollectionTemplate, List<Update> paramList, List<FeedUpdateViewModel> paramList1)
  {
    newUpdates.clear();
    paramFragmentComponent.updateChangeCoordinator().removeListener(updateChangedListener);
    newUpdates.addAll(paramList1);
    FeatureLog.i("NewUpdatesManager", "listening for changes to the new feed", "Realtime Feed Updates");
    paramFragmentComponent.updateChangeCoordinator().listenForUpdates(paramList, updateChangedListener);
    newUpdatesCollection = paramCollectionTemplate;
    FeatureLog.i("NewUpdatesManager", "firing show update pill event", "Realtime Feed Updates");
    paramFragmentComponent.eventBus();
    Bus.publish(new FeedNewUpdatesPillEvent(2));
  }
  
  public final void transformAndStoreFeed(final CollectionTemplate<Update, Metadata> paramCollectionTemplate)
  {
    FeatureLog.i("NewUpdatesManager", "transforming and storing feed", "Realtime Feed Updates");
    final FragmentComponent localFragmentComponent = (FragmentComponent)fragmentComponentReference.get();
    FeedComponentsViewPool localFeedComponentsViewPool = (FeedComponentsViewPool)viewPoolReference.get();
    if ((localFragmentComponent == null) || (localFeedComponentsViewPool == null)) {
      return;
    }
    if ((paramCollectionTemplate == null) || (CollectionUtils.isEmpty(elements)))
    {
      FeatureLog.i("NewUpdatesManager", "no updates to transform", "Realtime Feed Updates");
      newUpdates.clear();
      return;
    }
    ModelsTransformedCallback local2 = new ModelsTransformedCallback()
    {
      public final void onModelsTransformed(ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelsData)
      {
        FeatureLog.i("NewUpdatesManager", "updates transformed", "Realtime Feed Updates");
        storeNewUpdates(localFragmentComponent, paramCollectionTemplate, inputModels, viewModels);
      }
    };
    FeatureLog.i("NewUpdatesManager", "transforming feed", "Realtime Feed Updates");
    FeedViewTransformer.toViewModels(localFragmentComponent, localFeedComponentsViewPool, elements, FeedDataModelMetadata.DEFAULT, local2);
  }
  
  public final void updateMostRecentFeedTime()
  {
    if ((newUpdatesCollection != null) && (newUpdatesCollection.metadata != null)) {
      feedValues.setMostRecentFeedTime(newUpdatesCollection.metadata).queryAfterTime);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.newupdatespill.NewUpdatesManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */