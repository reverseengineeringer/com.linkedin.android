package com.linkedin.android.infra.events;

import android.os.Handler;
import android.os.Looper;
import javax.inject.Inject;

public final class DelayedExecution
{
  protected final Handler handler = new Handler(Looper.getMainLooper());
  
  public final void postDelayedExecution(Runnable paramRunnable, long paramLong)
  {
    handler.postDelayed(paramRunnable, paramLong);
  }
  
  public final void postDelayedExecutionOptional(Runnable paramRunnable, long paramLong)
  {
    handler.postDelayed(paramRunnable, paramLong);
  }
  
  public final void postExecution(Runnable paramRunnable)
  {
    handler.post(paramRunnable);
  }
  
  public final void postTrackingDelayedExecution(Runnable paramRunnable)
  {
    handler.removeCallbacks(paramRunnable);
    postDelayedExecution(paramRunnable, 500L);
  }
  
  public final void stopAllDelayedExecution()
  {
    handler.removeCallbacksAndMessages(null);
  }
  
  public final void stopDelayedExecution(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      handler.removeCallbacks(paramRunnable);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.events.DelayedExecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */