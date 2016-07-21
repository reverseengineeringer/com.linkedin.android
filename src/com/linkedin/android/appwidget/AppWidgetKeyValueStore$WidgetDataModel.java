package com.linkedin.android.appwidget;

public final class AppWidgetKeyValueStore$WidgetDataModel
{
  public final boolean feedBadge;
  public final long meBadge;
  public final long messagesBadge;
  public final long networkBadge;
  public final long notifications;
  
  public AppWidgetKeyValueStore$WidgetDataModel(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
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

/* Location:
 * Qualified Name:     com.linkedin.android.appwidget.AppWidgetKeyValueStore.WidgetDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */