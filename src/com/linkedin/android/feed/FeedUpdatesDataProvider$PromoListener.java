package com.linkedin.android.feed;

import android.support.v4.util.ArrayMap;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DataErrorEvent;
import com.linkedin.android.infra.events.DataReceivedEvent;
import com.linkedin.crosspromo.fe.api.android.Promo;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class FeedUpdatesDataProvider$PromoListener
  implements RecordTemplateListener<Promo>
{
  private final WeakReference<FeedUpdatesDataProvider> provider;
  private final String rumSessionId;
  private final String subscriberId;
  
  private FeedUpdatesDataProvider$PromoListener(FeedUpdatesDataProvider paramFeedUpdatesDataProvider, String paramString1, String paramString2)
  {
    provider = new WeakReference(paramFeedUpdatesDataProvider);
    subscriberId = paramString1;
    rumSessionId = paramString2;
  }
  
  public final void onResponse(DataStoreResponse<Promo> paramDataStoreResponse)
  {
    FeedUpdatesDataProvider localFeedUpdatesDataProvider = (FeedUpdatesDataProvider)provider.get();
    if (localFeedUpdatesDataProvider == null) {}
    do
    {
      return;
      if (error != null)
      {
        ((FeedUpdatesDataProvider.State)state).setError(request.url, error);
        paramDataStoreResponse = new DataErrorEvent(subscriberId, rumSessionId, Collections.singleton(request.url), type, error);
        activityComponent.eventBus();
        Bus.publish(paramDataStoreResponse);
        return;
      }
    } while (model == null);
    Object localObject = (FeedUpdatesDataProvider.State)state;
    String str = request.url;
    ((FeedUpdatesDataProvider.State)localObject).setModel(str, model, subscriberId);
    ((FeedUpdatesDataProvider.State)localObject).getCrossPromoDismissed(str).set(false);
    ((FeedUpdatesDataProvider.State)localObject).getCrossPromoImpressed(str).set(false);
    localObject = new ArrayMap();
    ((Map)localObject).put(request.url, paramDataStoreResponse);
    paramDataStoreResponse = new DataReceivedEvent(subscriberId, rumSessionId, ((Map)localObject).keySet(), type, (Map)localObject);
    activityComponent.eventBus();
    Bus.publish(paramDataStoreResponse);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.FeedUpdatesDataProvider.PromoListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */