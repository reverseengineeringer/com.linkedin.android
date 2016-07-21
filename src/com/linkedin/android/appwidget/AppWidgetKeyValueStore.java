package com.linkedin.android.appwidget;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.linkedin.android.infra.data.BaseSharedPreferences;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

public class AppWidgetKeyValueStore
  extends BaseSharedPreferences
{
  private static final String TAG = AppWidgetKeyValueStore.class.getSimpleName();
  
  public AppWidgetKeyValueStore(Context paramContext, ExecutorService paramExecutorService)
  {
    super(paramContext, paramExecutorService, "AppWidgetKeyValueStore");
  }
  
  static String columnsKey(int paramInt)
  {
    return String.format(Locale.US, "%d:columns", new Object[] { Integer.valueOf(paramInt) });
  }
  
  static String lastUpdateKey(int paramInt)
  {
    return String.format(Locale.US, "%d:lastUpdate", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static void migrateFromTitan(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.getApplicationContext();
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("LinkedInWidgetPrefs", 0);
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("AppWidgetKeyValueStore", 0).edit();
    int[] arrayOfInt = AppWidgetUtils.getActiveWidgetIds(paramContext, ResponsiveWidget.class);
    int j = arrayOfInt.length;
    while (i < j)
    {
      int k = arrayOfInt[i];
      int m = localSharedPreferences.getInt("widget_rows" + k, 1);
      int n = localSharedPreferences.getInt("widget_columns" + k, 4);
      localEditor.putInt(rowsKey(k), m).putInt(columnsKey(k), n);
      i += 1;
    }
    localEditor.apply();
    ResponsiveWidget.updateAllAppWidgets(paramContext);
  }
  
  static String rowsKey(int paramInt)
  {
    return String.format(Locale.US, "%d:rows", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public final void clear()
  {
    SharedPreferences localSharedPreferences = getPreferences();
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    int[] arrayOfInt = AppWidgetUtils.getActiveWidgetIds(appContext, ResponsiveWidget.class);
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      localEditor.putInt(rowsKey(k), localSharedPreferences.getInt(rowsKey(k), 1)).putInt(columnsKey(k), localSharedPreferences.getInt(columnsKey(k), 4));
      i += 1;
    }
    localEditor.clear().apply();
  }
  
  public static final class WidgetDataModel
  {
    public final boolean feedBadge;
    public final long meBadge;
    public final long messagesBadge;
    public final long networkBadge;
    public final long notifications;
    
    public WidgetDataModel(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      if (paramLong1 > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        feedBadge = bool;
        networkBadge = paramLong2;
        messagesBadge = paramLong3;
        notifications = paramLong4;
        meBadge = 0L;
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.appwidget.AppWidgetKeyValueStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */