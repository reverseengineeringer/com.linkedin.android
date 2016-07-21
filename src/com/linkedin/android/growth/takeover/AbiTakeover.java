package com.linkedin.android.growth.takeover;

import android.net.Uri;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.growth.abi.AbiCacheUtils;
import com.linkedin.android.growth.abi.AbiDataProvider;
import com.linkedin.android.growth.abi.AbiDataProvider.AbiState;
import com.linkedin.android.growth.abi.AbiIntent;
import com.linkedin.android.growth.abi.AbiIntentBundle;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.Takeover;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection;
import java.util.Map;

public final class AbiTakeover
  extends TakeoverLauncher
{
  final AbiCacheUtils abiCacheUtils;
  private FlagshipSharedPreferences flagshipSharedPreferences;
  private MemberUtil memberUtil;
  private Tracker tracker;
  
  public AbiTakeover(Takeover paramTakeover, ActivityComponent paramActivityComponent)
  {
    super(paramTakeover);
    tracker = paramActivityComponent.tracker();
    flagshipSharedPreferences = paramActivityComponent.flagshipSharedPreferences();
    memberUtil = paramActivityComponent.memberUtil();
    abiCacheUtils = paramActivityComponent.abiCacheUtils();
  }
  
  static void startAbiActivity(BaseActivity paramBaseActivity, IntentRegistry paramIntentRegistry, AbiIntentBundle paramAbiIntentBundle)
  {
    paramBaseActivity.startActivity(abi.newIntent(paramBaseActivity, paramAbiIntentBundle));
  }
  
  public final void launch(BaseActivity paramBaseActivity, IntentRegistry paramIntentRegistry)
  {
    AbiDataProvider localAbiDataProvider;
    Map localMap;
    if ((!"control".equalsIgnoreCase(applicationComponent.lixManager().getTreatment(Lix.GROWTH_ABI_RESULT_LANDING_VALUE_PROP))) && (flagshipSharedPreferences.isAbiAutoSync(memberUtil.getProfileId())))
    {
      localAbiDataProvider = activityComponent.abiDataProvider();
      paramIntentRegistry = new AbiTakeover.2(this, localAbiDataProvider, paramBaseActivity, paramIntentRegistry, new AbiIntentBundle().legoTrackingToken(takeover.legoTrackingToken).abiSource("mobile-voyager-takeover-resultsLanding").forceLaunchPastImportedContacts());
      DataManager.DataStoreFilter localDataStoreFilter = DataManager.DataStoreFilter.NETWORK_ONLY;
      localMap = Tracker.createPageInstanceHeader(tracker.generateBackgroundPageInstance());
      paramBaseActivity = localAbiDataProvider.buildMuxRequestForPastImportedContactsAndItsLegoFlow(paramBaseActivity, localDataStoreFilter);
      completionCallback = paramIntentRegistry;
      customHeaders = localMap;
      activityComponent.dataManager().submit(paramBaseActivity.build());
      return;
    }
    if ("socialProof".equalsIgnoreCase(applicationComponent.lixManager().getTreatment(Lix.LIX_ABI_TAKEOVER_TYPE)))
    {
      localAbiDataProvider = activityComponent.abiDataProvider();
      paramBaseActivity = new AbiTakeover.1(this, paramBaseActivity, paramIntentRegistry, new AbiIntentBundle().legoTrackingToken(takeover.legoTrackingToken).abiSource("mobile-voyager-takeover-social-proof").forceLaunchAbiSplash());
      paramIntentRegistry = DataManager.DataStoreFilter.NETWORK_ONLY;
      localMap = Tracker.createPageInstanceHeader(tracker.generateBackgroundPageInstance());
      state).connectionsRoute = Routes.CONNECTIONS.buildPagedRouteUponRoot(0, 20).toString();
      paramBaseActivity = Request.get().url(state).connectionsRoute).builder(CollectionTemplate.of(Connection.BUILDER)).listener(paramBaseActivity).filter(paramIntentRegistry).customHeaders(localMap);
      activityComponent.dataManager().submit(paramBaseActivity);
      return;
    }
    startAbiActivity(paramBaseActivity, paramIntentRegistry, new AbiIntentBundle().legoTrackingToken(takeover.legoTrackingToken).abiSource("mobile-voyager-takeover").forceLaunchAbiSplash());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.takeover.AbiTakeover
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */