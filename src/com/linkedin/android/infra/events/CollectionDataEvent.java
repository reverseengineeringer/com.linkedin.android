package com.linkedin.android.infra.events;

import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;

public final class CollectionDataEvent
{
  public CollectionTemplate changedCollectionModel;
  public final String collectionRoute;
  public int requestState;
  public final String rumSessionId;
  public final String subscriberId;
  public final DataStore.Type type;
  
  public CollectionDataEvent(String paramString1, String paramString2, String paramString3, DataStore.Type paramType, CollectionTemplate paramCollectionTemplate, int paramInt)
  {
    subscriberId = paramString1;
    rumSessionId = paramString2;
    collectionRoute = paramString3;
    type = paramType;
    changedCollectionModel = paramCollectionTemplate;
    requestState = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.events.CollectionDataEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */