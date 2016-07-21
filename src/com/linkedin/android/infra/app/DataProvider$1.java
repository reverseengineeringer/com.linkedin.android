package com.linkedin.android.infra.app;

import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.CollectionDataEvent;
import com.linkedin.android.infra.events.DataErrorEvent;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import java.util.Collections;

final class DataProvider$1
  implements RecordTemplateListener<CollectionTemplate<E, M>>
{
  DataProvider$1(DataProvider paramDataProvider, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public final void onResponse(DataStoreResponse<CollectionTemplate<E, M>> paramDataStoreResponse)
  {
    if (!this$0.hasReferencingFragments()) {
      return;
    }
    if (error != null)
    {
      this$0.state.setError(val$collectionRoute, error);
      this$0.activityComponent.eventBus();
      Bus.publish(new DataErrorEvent(val$subscriberId, val$rumSessionId, Collections.singleton(request.url), type, error));
      return;
    }
    this$0.state.setModel(val$collectionRoute, model, val$subscriberId);
    CollectionTemplate localCollectionTemplate = (CollectionTemplate)model;
    paramDataStoreResponse = new CollectionDataEvent(val$subscriberId, val$rumSessionId, val$collectionRoute, type, localCollectionTemplate, val$requestState);
    this$0.activityComponent.eventBus();
    Bus.publish(paramDataStoreResponse);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.DataProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */