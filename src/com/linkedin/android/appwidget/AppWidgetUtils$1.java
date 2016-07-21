package com.linkedin.android.appwidget;

import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexCompletionCallback;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import java.util.Map;

final class AppWidgetUtils$1
  implements MultiplexCompletionCallback
{
  AppWidgetUtils$1(MultiplexRequest.Builder paramBuilder, ApplicationComponent paramApplicationComponent, MultiplexCompletionCallback paramMultiplexCompletionCallback) {}
  
  public final void onRequestComplete(Map<String, DataStoreResponse> paramMap, DataManagerException paramDataManagerException, DataStore.Type paramType)
  {
    if ((paramType == DataStore.Type.LOCAL) && ((paramDataManagerException != null) || (paramMap.isEmpty())))
    {
      val$builder.filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      val$applicationComponent.dataManager().submit(val$builder.build());
      return;
    }
    val$callback.onRequestComplete(paramMap, paramDataManagerException, paramType);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.appwidget.AppWidgetUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */