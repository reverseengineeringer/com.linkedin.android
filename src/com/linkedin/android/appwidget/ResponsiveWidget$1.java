package com.linkedin.android.appwidget;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexCompletionCallback;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.components.ApplicationComponent;
import java.util.Map;

final class ResponsiveWidget$1
  implements MultiplexCompletionCallback
{
  ResponsiveWidget$1(Context paramContext, AppWidgetManager paramAppWidgetManager, ApplicationComponent paramApplicationComponent, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void onRequestComplete(Map<String, DataStoreResponse> paramMap, DataManagerException paramDataManagerException, DataStore.Type paramType)
  {
    ResponsiveWidget.access$100(val$context, val$manager, val$applicationComponent, val$widgetId, new AppWidgetKeyValueStore.WidgetDataModel(ResponsiveWidget.access$000((DataStoreResponse)paramMap.get(val$feedUrl)), ResponsiveWidget.access$000((DataStoreResponse)paramMap.get(val$relationshipsUrl)), ResponsiveWidget.access$000((DataStoreResponse)paramMap.get(val$messagingUrl)), ResponsiveWidget.access$000((DataStoreResponse)paramMap.get(val$notificationsUrl))));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.appwidget.ResponsiveWidget.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */