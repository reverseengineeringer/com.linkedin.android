package com.linkedin.android.networking.response;

import android.os.Handler;
import android.os.Looper;
import com.linkedin.android.networking.interfaces.ResponseDelivery;

public final class MainThreadResponseDelivery
  implements ResponseDelivery
{
  private static final Handler MAIN_THREAD_HANDLER = new Handler(Looper.getMainLooper());
  
  public final void deliver(Runnable paramRunnable)
  {
    MAIN_THREAD_HANDLER.post(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.response.MainThreadResponseDelivery
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */