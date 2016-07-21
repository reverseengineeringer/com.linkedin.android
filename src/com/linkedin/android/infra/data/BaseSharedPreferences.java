package com.linkedin.android.infra.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.linkedin.android.logger.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class BaseSharedPreferences
{
  public final Context appContext;
  private Future<SharedPreferences> preferences;
  final String prefsName;
  
  public BaseSharedPreferences(Context paramContext, ExecutorService paramExecutorService, String paramString)
  {
    appContext = paramContext;
    prefsName = paramString;
    preferences = paramExecutorService.submit(new BaseSharedPreferences.1(this));
  }
  
  public void clear()
  {
    getPreferences().edit().clear().apply();
  }
  
  public final SharedPreferences getPreferences()
  {
    try
    {
      SharedPreferences localSharedPreferences = (SharedPreferences)preferences.get();
      return localSharedPreferences;
    }
    catch (InterruptedException localInterruptedException)
    {
      Log.e("BaseSharedPreferences", "[" + prefsName + "] Failed getting preferences from FutureTask, loading synchronously", localInterruptedException);
      return appContext.getApplicationContext().getSharedPreferences(prefsName, 0);
    }
    catch (ExecutionException localExecutionException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.data.BaseSharedPreferences
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */