package com.linkedin.android.feed.utils;

import android.content.Context;
import com.linkedin.android.appwidget.AppWidgetKeyValueStore;
import com.linkedin.android.feed.page.feed.newupdatespill.CheckForNewUpdatesRunnable;
import com.linkedin.android.feed.shared.liking.LikePublisher;
import com.linkedin.android.feed.tracking.SponsoredUpdateTracker;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher;
import com.linkedin.android.imageloader.interfaces.ImageLoaderCache;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.mediaupload.MediaUploader;
import com.linkedin.android.infra.modules.ApplicationModule;
import com.linkedin.android.infra.modules.DataManagerModule;
import com.linkedin.android.infra.modules.UtilModule;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.publishing.sharing.compose.FeedSharePublisher;
import com.linkedin.android.publishing.sharing.compose.GroupSharePublisher;
import com.linkedin.consistency.ConsistencyManager;
import dagger.Module;
import dagger.Provides;
import java.util.concurrent.ExecutorService;

@Module(includes={ApplicationModule.class, DataManagerModule.class, UtilModule.class})
public final class FeedModule
{
  @Provides
  public final AppWidgetKeyValueStore provideAppwidgetKeyValueStore(Context paramContext, ExecutorService paramExecutorService)
  {
    return new AppWidgetKeyValueStore(paramContext, paramExecutorService);
  }
  
  @Provides
  public final CommentPublisher provideCommentPublisher(FlagshipDataManager paramFlagshipDataManager, Bus paramBus, LixManager paramLixManager)
  {
    return new CommentPublisher(paramFlagshipDataManager, paramBus, paramLixManager);
  }
  
  @Provides
  public final FeedKeyValueStore provideFeedKeyValueStore(Context paramContext, ExecutorService paramExecutorService)
  {
    return new FeedKeyValueStore(paramContext, paramExecutorService);
  }
  
  @Provides
  public final GroupSharePublisher provideGroupsSharePublisher(Context paramContext, FlagshipDataManager paramFlagshipDataManager, Bus paramBus, MediaUploader paramMediaUploader, ImageLoaderCache paramImageLoaderCache)
  {
    return new GroupSharePublisher(paramContext, paramFlagshipDataManager, paramBus, paramMediaUploader, paramImageLoaderCache);
  }
  
  @Provides
  public final LikePublisher provideLikePublisher(FlagshipApplication paramFlagshipApplication, FlagshipDataManager paramFlagshipDataManager, ConsistencyManager paramConsistencyManager, Bus paramBus, MemberUtil paramMemberUtil, LixManager paramLixManager)
  {
    return new LikePublisher(paramFlagshipApplication, paramFlagshipDataManager, paramConsistencyManager, paramBus, paramMemberUtil, paramLixManager);
  }
  
  @Provides
  public final CheckForNewUpdatesRunnable provideNewUpdatesRunnable(FlagshipDataManager paramFlagshipDataManager, DelayedExecution paramDelayedExecution, Tracker paramTracker, FlagshipSharedPreferences paramFlagshipSharedPreferences, FeedKeyValueStore paramFeedKeyValueStore, Bus paramBus, LixManager paramLixManager)
  {
    return new CheckForNewUpdatesRunnable(paramFlagshipDataManager, paramDelayedExecution, paramTracker, paramFlagshipSharedPreferences, paramFeedKeyValueStore, paramBus, paramLixManager);
  }
  
  @Provides
  public final FeedSharePublisher provideSharePublisher(Context paramContext, FlagshipDataManager paramFlagshipDataManager, Bus paramBus, MediaUploader paramMediaUploader, ImageLoaderCache paramImageLoaderCache, ConsistencyManager paramConsistencyManager)
  {
    return new FeedSharePublisher(paramContext, paramFlagshipDataManager, paramBus, paramMediaUploader, paramImageLoaderCache, paramConsistencyManager);
  }
  
  @Provides
  public final SponsoredUpdateTracker provideSponsoredUpdateTracker(Context paramContext, NetworkClient paramNetworkClient)
  {
    return new SponsoredUpdateTracker(paramContext, paramNetworkClient);
  }
  
  @Provides
  public final UpdateChangeCoordinator provideUpdateChangeCoordinator(FlagshipApplication paramFlagshipApplication, ConsistencyManager paramConsistencyManager)
  {
    return new UpdateChangeCoordinator(paramFlagshipApplication, paramConsistencyManager);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */