package com.linkedin.android.feed.shared.following;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.data.lite.VoidRecord;
import java.util.Map;

final class FollowToggleRequester$1
  implements RecordTemplateListener<VoidRecord>
{
  FollowToggleRequester$1(FollowToggleRequester paramFollowToggleRequester, Map paramMap) {}
  
  public final void onResponse(DataStoreResponse<VoidRecord> paramDataStoreResponse)
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
    FollowToggleRequester localFollowToggleRequester = this$0;
    if (error == null) {}
    for (boolean bool = true;; bool = false)
    {
      FollowToggleRequester.access$000(localFollowToggleRequester, bool, i, val$trackingHeader);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.following.FollowToggleRequester.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */