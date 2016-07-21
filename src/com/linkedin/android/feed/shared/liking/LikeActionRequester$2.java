package com.linkedin.android.feed.shared.liking;

import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.data.DeleteModelListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.VoidRecord;
import java.util.Map;

final class LikeActionRequester$2
  extends DeleteModelListener
{
  LikeActionRequester$2(LikeActionRequester paramLikeActionRequester, RecordTemplate paramRecordTemplate, FlagshipDataManager paramFlagshipDataManager, Map paramMap)
  {
    super(paramRecordTemplate, paramFlagshipDataManager);
  }
  
  public final void onResponse(DataStoreResponse<VoidRecord> paramDataStoreResponse)
  {
    super.onResponse(paramDataStoreResponse);
    int i;
    LikeActionRequester localLikeActionRequester;
    if (type == DataStore.Type.NETWORK)
    {
      int j = statusCode;
      i = j;
      if (error != null)
      {
        i = j;
        if (error.errorResponse != null) {
          i = error.errorResponse.code();
        }
      }
      localLikeActionRequester = this$0;
      if (error != null) {
        break label83;
      }
    }
    label83:
    for (boolean bool = true;; bool = false)
    {
      LikeActionRequester.access$100(localLikeActionRequester, bool, i, val$trackingHeader);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.liking.LikeActionRequester.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */