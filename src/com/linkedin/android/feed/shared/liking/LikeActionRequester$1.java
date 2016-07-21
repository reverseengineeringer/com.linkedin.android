package com.linkedin.android.feed.shared.liking;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.pegasus.gen.voyager.feed.Like;
import java.util.Map;

final class LikeActionRequester$1
  implements RecordTemplateListener<Like>
{
  LikeActionRequester$1(LikeActionRequester paramLikeActionRequester, Map paramMap) {}
  
  public final void onResponse(DataStoreResponse<Like> paramDataStoreResponse)
  {
    int j = statusCode;
    int i = j;
    if (error != null)
    {
      i = j;
      if (error.errorResponse != null) {
        i = error.errorResponse.code();
      }
    }
    LikeActionRequester localLikeActionRequester = this$0;
    if (error == null) {}
    for (boolean bool = true;; bool = false)
    {
      LikeActionRequester.access$000(localLikeActionRequester, bool, i, val$trackingHeader);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.liking.LikeActionRequester.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */