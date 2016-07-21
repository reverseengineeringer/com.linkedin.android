package com.linkedin.android.axle;

import android.support.v4.util.ArrayMap;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DataErrorEvent;
import com.linkedin.android.infra.events.DataReceivedEvent;
import com.linkedin.crosspromo.fe.api.android.Promo;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;

public final class PromoListener
  implements RecordTemplateListener<Promo>
{
  private final WeakReference<DataProvider> provider;
  private final String rumSessionId;
  private final String subscriberId;
  
  public PromoListener(DataProvider paramDataProvider, String paramString1, String paramString2)
  {
    provider = new WeakReference(paramDataProvider);
    subscriberId = paramString1;
    rumSessionId = paramString2;
  }
  
  public final void onResponse(DataStoreResponse<Promo> paramDataStoreResponse)
  {
    DataProvider localDataProvider = (DataProvider)provider.get();
    if (localDataProvider == null) {}
    do
    {
      return;
      if (error != null)
      {
        state.setError(request.url, error);
        paramDataStoreResponse = new DataErrorEvent(subscriberId, rumSessionId, Collections.singleton(request.url), type, error);
        activityComponent.eventBus();
        Bus.publish(paramDataStoreResponse);
        return;
      }
    } while (model == null);
    state.setModel(request.url, model, subscriberId);
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put(request.url, paramDataStoreResponse);
    paramDataStoreResponse = new DataReceivedEvent(subscriberId, rumSessionId, localArrayMap.keySet(), type, localArrayMap);
    activityComponent.eventBus();
    Bus.publish(paramDataStoreResponse);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.PromoListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */