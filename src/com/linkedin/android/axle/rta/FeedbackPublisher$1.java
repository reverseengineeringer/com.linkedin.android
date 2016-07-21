package com.linkedin.android.axle.rta;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.JsonModel;

final class FeedbackPublisher$1
  implements RecordTemplateListener<JsonModel>
{
  FeedbackPublisher$1(FeedbackPublisher paramFeedbackPublisher) {}
  
  public final void onResponse(DataStoreResponse<JsonModel> paramDataStoreResponse)
  {
    int i = statusCode;
    if (i != 201)
    {
      Log.e("Server error with status code: ", Integer.toString(i));
      return;
    }
    Log.i("Feedback sent successfully");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.FeedbackPublisher.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */