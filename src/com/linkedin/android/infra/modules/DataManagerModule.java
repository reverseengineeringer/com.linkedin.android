package com.linkedin.android.infra.modules;

import android.content.Context;
import com.linkedin.android.datamanager.DataManager;
import com.linkedin.android.datamanager.impl.LiNetworkDataStore;
import com.linkedin.android.datamanager.interfaces.LocalDataStore;
import com.linkedin.android.datamanager.interfaces.NetworkDataStore;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.infra.data.Cache;
import com.linkedin.android.infra.data.FlagshipCacheManager;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipDiskCache;
import com.linkedin.android.infra.data.FlagshipFission;
import com.linkedin.android.infra.data.FlagshipMemoryCache;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.buffer.ByteBufferPool;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.shared.Optional;
import com.linkedin.android.relationships.connections.ConnectionStore;
import com.linkedin.android.relationships.connections.ConnectionStoreImpl;
import com.linkedin.consistency.ConsistencyManager;
import dagger.Module;
import dagger.Provides;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;

@Module(includes={ApplicationModule.class})
public final class DataManagerModule
{
  @Provides
  public final ByteBufferPool provideByteBufferPool()
  {
    return new ByteBufferPool();
  }
  
  @Provides
  public final FissionAdapter provideCacheManager(Cache<String, ByteBuffer> paramCache, ByteBufferPool paramByteBufferPool, ConnectionStore paramConnectionStore)
  {
    return new FlagshipCacheManager(paramCache, paramByteBufferPool, paramConnectionStore);
  }
  
  @Provides
  public final ConnectionStore provideConnectionStore(Context paramContext, FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    return new ConnectionStoreImpl(paramContext, paramFlagshipSharedPreferences);
  }
  
  @Provides
  public final DataManager provideDataManager(NetworkDataStore paramNetworkDataStore, LocalDataStore paramLocalDataStore, ExecutorService paramExecutorService)
  {
    paramNetworkDataStore = new DataManager(paramNetworkDataStore, paramLocalDataStore);
    paramNetworkDataStore.setExecutorService(paramExecutorService);
    return paramNetworkDataStore;
  }
  
  @Provides
  public final Optional<FlagshipDiskCache> provideDiskCache(Context paramContext, FlagshipSharedPreferences paramFlagshipSharedPreferences, ByteBufferPool paramByteBufferPool)
  {
    return Optional.of(new FlagshipDiskCache(paramContext, paramFlagshipSharedPreferences, paramByteBufferPool));
  }
  
  @Provides
  public final FlagshipDataManager provideFlagshipDataManager(DataManager paramDataManager, ConsistencyManager paramConsistencyManager)
  {
    return new FlagshipDataManager(paramDataManager, paramConsistencyManager);
  }
  
  @Provides
  public final LocalDataStore provideLocalDataStore(FissionAdapter paramFissionAdapter)
  {
    return new FlagshipFission(paramFissionAdapter);
  }
  
  @Provides
  public final NetworkDataStore provideNetworkDataStore(Context paramContext, NetworkClient paramNetworkClient)
  {
    return new LiNetworkDataStore(paramNetworkClient, paramContext);
  }
  
  @Provides
  public final Cache<String, ByteBuffer> providesCache(Optional<FlagshipDiskCache> paramOptional)
  {
    if ((paramOptional.isPresent()) && (!getdiskCacheInitFailed)) {
      return (Cache)paramOptional.get();
    }
    return new FlagshipMemoryCache();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.modules.DataManagerModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */