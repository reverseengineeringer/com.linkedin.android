package com.linkedin.android.growth.lego;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexCompletionCallback;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.components.ActivityComponent;
import java.util.Map;

public abstract class LegoWidgetMultiplexCompletionCallback
  implements MultiplexCompletionCallback
{
  private ActivityComponent activityComponent;
  private LegoWidget legoWidget;
  
  public LegoWidgetMultiplexCompletionCallback(ActivityComponent paramActivityComponent, LegoWidget paramLegoWidget)
  {
    activityComponent = paramActivityComponent;
    legoWidget = paramLegoWidget;
  }
  
  public abstract void onDataReady$34d43c58();
  
  public final void onRequestComplete(Map<String, DataStoreResponse> paramMap, DataManagerException paramDataManagerException, DataStore.Type paramType)
  {
    legoWidget.onDataReady$581b308(activityComponent, paramMap, paramDataManagerException);
    onDataReady$34d43c58();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoWidgetMultiplexCompletionCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */