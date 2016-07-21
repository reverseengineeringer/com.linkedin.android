package com.linkedin.android.infra.modules;

import android.content.Context;
import com.linkedin.android.feed.shared.following.FollowPublisher;
import com.linkedin.android.identity.me.shared.util.ViewPagerManager;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.mediaupload.MediaUploader;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.semaphore.ReportEntityInvokerHelper;
import com.linkedin.android.infra.shared.InternetConnectionMonitor;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.ui.cardtoast.CardToastManager;
import com.linkedin.android.infra.viewport.ProductionViewportConfig;
import com.linkedin.android.infra.viewport.ViewportTrackingConfiguration;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.DisplayedViewDetector;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.consistency.ConsistencyManager;
import dagger.Module;
import dagger.Provides;

@Module(includes={ApplicationModule.class, DataManagerModule.class})
public final class UtilModule
{
  @Provides
  public final CardToastManager provideCardToastManager(DelayedExecution paramDelayedExecution)
  {
    return new CardToastManager(paramDelayedExecution);
  }
  
  @Provides
  public final DelayedExecution provideDelayedExecution()
  {
    return new DelayedExecution();
  }
  
  @Provides
  public final FollowPublisher provideFollowPublisher(FlagshipApplication paramFlagshipApplication, FlagshipDataManager paramFlagshipDataManager, ConsistencyManager paramConsistencyManager, Bus paramBus)
  {
    return new FollowPublisher(paramFlagshipApplication, paramFlagshipDataManager, paramConsistencyManager);
  }
  
  @Provides
  public final InternetConnectionMonitor provideInternetConnectionMonitor(Context paramContext, LixManager paramLixManager, SnackbarUtil paramSnackbarUtil, Tracker paramTracker)
  {
    return new InternetConnectionMonitor(paramContext, paramLixManager, paramSnackbarUtil, paramTracker);
  }
  
  @Provides
  public final com.linkedin.android.infra.shared.LongClickUtil provideLongClickUtil()
  {
    return new com.linkedin.android.infra.shared.LongClickUtil();
  }
  
  @Provides
  public final MediaUploader provideMediaUploader(Bus paramBus, NetworkClient paramNetworkClient, FlagshipDataManager paramFlagshipDataManager, FlagshipSharedPreferences paramFlagshipSharedPreferences, Context paramContext)
  {
    return new MediaUploader(paramBus, paramNetworkClient, paramFlagshipDataManager, paramFlagshipSharedPreferences, paramContext);
  }
  
  @Provides
  public final MemberUtil provideMemberUtil(Auth paramAuth, Bus paramBus, FlagshipDataManager paramFlagshipDataManager, ConsistencyManager paramConsistencyManager, FlagshipSharedPreferences paramFlagshipSharedPreferences, MediaCenter paramMediaCenter, Tracker paramTracker)
  {
    return new MemberUtil(paramAuth, paramBus, paramFlagshipDataManager, paramConsistencyManager, paramFlagshipSharedPreferences, paramMediaCenter, paramTracker);
  }
  
  @Provides
  public final com.linkedin.messengerlib.utils.LongClickUtil provideMessengerLongClickUtil()
  {
    return new com.linkedin.messengerlib.utils.LongClickUtil();
  }
  
  @Provides
  public final ReportEntityInvokerHelper provideReportEntityInvokerHelper()
  {
    return new ReportEntityInvokerHelper();
  }
  
  @Provides
  public final SnackbarUtil provideSnackbarUtil(Context paramContext)
  {
    return new SnackbarUtil(paramContext);
  }
  
  @Provides
  public final ViewPagerManager provideViewPagerManager(Tracker paramTracker, ViewportTrackingConfiguration paramViewportTrackingConfiguration)
  {
    paramTracker = new ViewPagerManager(paramTracker);
    impressionThreshold = 300L;
    return paramTracker;
  }
  
  @Provides
  public final ViewportTrackingConfiguration provideViewportConfig()
  {
    return new ProductionViewportConfig();
  }
  
  @Provides
  public final ViewPortManager provideViewportManager(Tracker paramTracker, ViewportTrackingConfiguration paramViewportTrackingConfiguration)
  {
    return new ViewPortManager(paramTracker, new DisplayedViewDetector()).configure(0.5F, 0.5F, 300L);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.modules.UtilModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */