package com.linkedin.android.growth.abi;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.TimeWrapper;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import java.util.Map;
import javax.inject.Inject;

public final class AbiCacheUtils
{
  public FlagshipDataManager dataManager;
  public FlagshipSharedPreferences flagshipSharedPreferences;
  public LixManager lixManager;
  private TimeWrapper timeWrapper;
  public Tracker tracker;
  
  @Inject
  public AbiCacheUtils(FlagshipDataManager paramFlagshipDataManager, Tracker paramTracker, FlagshipSharedPreferences paramFlagshipSharedPreferences, TimeWrapper paramTimeWrapper, LixManager paramLixManager)
  {
    dataManager = paramFlagshipDataManager;
    tracker = paramTracker;
    flagshipSharedPreferences = paramFlagshipSharedPreferences;
    timeWrapper = paramTimeWrapper;
    lixManager = paramLixManager;
  }
  
  final void updatePastImportedContactsLegoCacheUpdatedTimestamp(DataStoreResponse<PageContent> paramDataStoreResponse, boolean paramBoolean)
  {
    if ((paramDataStoreResponse != null) && (error == null) && (request != null) && (paramBoolean))
    {
      paramDataStoreResponse = flagshipSharedPreferences;
      long l = System.currentTimeMillis();
      paramDataStoreResponse.getPreferences().edit().putLong("abi_past_imported_contacts_lego_cache_updated_timestamp", l).apply();
    }
  }
  
  public final void updatePastImportedContactsResultsAndItsLegoCacheUpdatedTimestamp(Map<String, DataStoreResponse> paramMap, AbiDataProvider paramAbiDataProvider, boolean paramBoolean)
  {
    DataStoreResponse localDataStoreResponse = (DataStoreResponse)paramMap.get(state).abiLegoRoute);
    paramMap = (DataStoreResponse)paramMap.get(state).contactsRoute);
    updatePastImportedContactsLegoCacheUpdatedTimestamp(localDataStoreResponse, paramBoolean);
    if ((paramMap != null) && (error == null) && (request != null) && (paramBoolean))
    {
      paramMap = flagshipSharedPreferences;
      long l = System.currentTimeMillis();
      paramMap.getPreferences().edit().putLong("lastAbiPastImportedContactsResultsCacheUpdatedTimestamp", l).apply();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiCacheUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */