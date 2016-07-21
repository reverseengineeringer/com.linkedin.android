package com.linkedin.android.litrackinglib.network;

import com.linkedin.android.logger.FeatureLog;
import java.util.HashMap;

final class MetricQueueIntentService$2
  implements Runnable
{
  MetricQueueIntentService$2(MetricQueueIntentService paramMetricQueueIntentService, String paramString1, String paramString2, HashMap paramHashMap) {}
  
  public final void run()
  {
    FeatureLog.d("MetricQueueIntentService", "Executing task. instance: " + this, "Tracking");
    MetricQueueIntentService.access$400$545e8359(this$0, val$serverUrl, val$networkClientClass, val$userHeaders);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.litrackinglib.network.MetricQueueIntentService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */