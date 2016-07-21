package com.linkedin.android.infra.data;

import com.linkedin.android.datamanager.DataManager;
import com.linkedin.android.datamanager.MultiplexRequest;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.performance.RUMListener;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.consistency.ConsistencyManagerListener;
import com.linkedin.data.lite.RecordTemplate;

public final class FlagshipDataManager
{
  public ConsistencyManager consistencyManager;
  DataManager dataManager;
  
  public FlagshipDataManager(DataManager paramDataManager, ConsistencyManager paramConsistencyManager)
  {
    dataManager = paramDataManager;
    consistencyManager = paramConsistencyManager;
    dataManager.setEventListener(new RUMListener());
  }
  
  private static boolean isTextEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }
  
  public final OptimisticWrite createOptimisticWrite()
  {
    return new OptimisticWrite(dataManager, consistencyManager);
  }
  
  public final void removeListener(ConsistencyManagerListener paramConsistencyManagerListener)
  {
    consistencyManager.removeListener(paramConsistencyManagerListener);
  }
  
  public final void submit(MultiplexRequest paramMultiplexRequest)
  {
    dataManager.submit(paramMultiplexRequest);
  }
  
  public final <T extends RecordTemplate<T>> void submit(Request.Builder<T> paramBuilder)
  {
    Object localObject = listener;
    int i;
    if (Util.shouldWrapInWeakReference(localObject))
    {
      localObject = new FlagshipDataManager.WeakModelListenerWrapper((RecordTemplateListener)localObject);
      localObject = new FlagshipDataManager.1(this, (RecordTemplateListener)localObject);
      dataManager.submit(paramBuilder.listener((RecordTemplateListener)localObject).build());
      localObject = method;
      i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        label92:
        switch (i)
        {
        }
        break;
      }
    }
    do
    {
      return;
      break;
      if (!((String)localObject).equals("POST")) {
        break label92;
      }
      i = 0;
      break label92;
      if (!((String)localObject).equals("PUT")) {
        break label92;
      }
      i = 1;
      break label92;
      if (!((String)localObject).equals("DELETE")) {
        break label92;
      }
      i = 2;
      break label92;
      consistencyManager.updateModel(model);
      return;
      if (!isTextEmpty(cacheKey)) {
        consistencyManager.deleteModel(cacheKey);
      }
    } while (isTextEmpty(url));
    consistencyManager.deleteModel(url);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.data.FlagshipDataManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */