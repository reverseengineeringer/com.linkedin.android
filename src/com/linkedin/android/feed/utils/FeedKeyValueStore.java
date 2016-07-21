package com.linkedin.android.feed.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.linkedin.android.infra.data.BaseSharedPreferences;
import java.util.concurrent.ExecutorService;

public final class FeedKeyValueStore
  extends BaseSharedPreferences
{
  public FeedKeyValueStore(Context paramContext, ExecutorService paramExecutorService)
  {
    super(paramContext, paramExecutorService, "FeedKeyValueStore");
  }
  
  public final boolean isChronFeedUsed()
  {
    return getPreferences().getBoolean("isChronFeedUsed", false);
  }
  
  public final long mostRecentFeedTime()
  {
    return getPreferences().getLong("mostRecentFeedTime", -1L);
  }
  
  public final void setMostRecentFeedTime(long paramLong)
  {
    getPreferences().edit().putLong("mostRecentFeedTime", paramLong).apply();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedKeyValueStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */