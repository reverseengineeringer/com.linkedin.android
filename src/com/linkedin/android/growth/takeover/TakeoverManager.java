package com.linkedin.android.growth.takeover;

import android.net.Uri;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.abi.AbiCacheUtils;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.Takeover;
import com.linkedin.android.pegasus.gen.voyager.common.TakeoverType;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.pegasus.gen.voyager.growth.onboarding.OnboardingLaunchResult;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public final class TakeoverManager
{
  private static final String ONBOARDING_LAUNCH_ROUTE = Routes.ONBOARDING_LAUNCH.buildUponRoot().toString();
  private static final String TAKEOVERS_ROUTE = Routes.TAKEOVERS.buildUponRoot().toString();
  private final AbiCacheUtils abiCacheUtils;
  public final FlagshipDataManager dataManager;
  private final Bus eventBus;
  private final FlagshipSharedPreferences flagshipSharedPreferences;
  private final MemberUtil memberUtil;
  private final Tracker tracker;
  
  @Inject
  public TakeoverManager(Bus paramBus, FlagshipDataManager paramFlagshipDataManager, Tracker paramTracker, FlagshipSharedPreferences paramFlagshipSharedPreferences, MemberUtil paramMemberUtil, AbiCacheUtils paramAbiCacheUtils)
  {
    eventBus = paramBus;
    dataManager = paramFlagshipDataManager;
    tracker = paramTracker;
    flagshipSharedPreferences = paramFlagshipSharedPreferences;
    memberUtil = paramMemberUtil;
    abiCacheUtils = paramAbiCacheUtils;
  }
  
  public final void loadTakeovers()
  {
    Object localObject = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    localObject = ((MultiplexRequest.Builder)localObject).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
    completionCallback = new TakeoverManager.2(this);
    customHeaders = Tracker.createPageInstanceHeader(tracker.generateBackgroundPageInstance());
    localObject = ((MultiplexRequest.Builder)localObject).required(Request.get().url(ONBOARDING_LAUNCH_ROUTE).builder(OnboardingLaunchResult.BUILDER)).required(Request.get().url(TAKEOVERS_ROUTE).builder(CollectionTemplate.of(Takeover.BUILDER))).build();
    dataManager.submit((MultiplexRequest)localObject);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.takeover.TakeoverManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */