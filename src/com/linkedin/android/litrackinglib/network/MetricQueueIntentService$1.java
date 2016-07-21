package com.linkedin.android.litrackinglib.network;

import android.widget.Toast;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.logger.Log;
import java.util.ArrayList;
import java.util.HashMap;

final class MetricQueueIntentService$1
  implements IResponseHandler
{
  MetricQueueIntentService$1(MetricQueueIntentService paramMetricQueueIntentService, ArrayList paramArrayList, String paramString1, String paramString2, HashMap paramHashMap) {}
  
  public final void handleResponse(IRequestData paramIRequestData, IResponseData paramIResponseData)
  {
    if (paramIResponseData != null) {}
    for (int i = paramIResponseData.getResponseStatusCode(); (i >= 200) && (i <= 299); i = 0)
    {
      MetricQueueIntentService.access$100(this$0).reset();
      return;
    }
    if (i == 400)
    {
      MetricQueueIntentService.access$100(this$0).reset();
      paramIRequestData = "Tracking FE statusCode = " + paramIResponseData.getResponseStatusCode() + "\nserverUrl = " + paramIRequestData.getRequestUrl() + "\nrequestBody = " + paramIRequestData.getPostBody() + "\nrequestHeaders = " + paramIRequestData.getRequestHeaders() + "\nresponseString = " + paramIResponseData.getResponseString() + "\nresponseHeaders = " + paramIResponseData.getResponseHeaders();
      if (MetricQueueIntentService.access$200(this$0))
      {
        Log.e("MetricQueueIntentService", paramIRequestData);
        paramIRequestData = "Tracking FE returned " + paramIResponseData.getResponseStatusCode() + ": Critical Tracking failure, please check the logs";
        Toast.makeText(this$0.getApplicationContext(), paramIRequestData, 1).show();
        return;
      }
      FeatureLog.d(getClass().getName(), paramIRequestData, "Tracking");
      return;
    }
    paramIRequestData = "Tracking FE statusCode = " + paramIResponseData.getResponseStatusCode() + "\nserverUrl = " + paramIRequestData.getRequestUrl() + "\nrequestBody = " + paramIRequestData.getPostBody() + "\nrequestHeaders = " + paramIRequestData.getRequestHeaders() + "\nresponseString = " + paramIResponseData.getResponseString() + "\nresponseHeaders = " + paramIResponseData.getResponseHeaders();
    if (MetricQueueIntentService.access$200(this$0))
    {
      Log.e("MetricQueueIntentService", paramIRequestData);
      paramIRequestData = "Tracking FE returned " + paramIResponseData.getResponseStatusCode() + ": Critical Tracking failure, please check the logs";
      Toast.makeText(this$0.getApplicationContext(), paramIRequestData, 1).show();
    }
    for (;;)
    {
      FeatureLog.d(getClass().getName(), "Metric posting failed", "Tracking");
      MetricQueueIntentService.access$300(this$0, val$metricsToSend, val$serverUrl, val$networkClientClass, val$userHeaders);
      return;
      FeatureLog.d(getClass().getName(), paramIRequestData, "Tracking");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.litrackinglib.network.MetricQueueIntentService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */