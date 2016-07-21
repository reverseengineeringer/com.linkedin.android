package com.linkedin.android.feed.actions;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.logger.Log;
import com.linkedin.data.lite.VoidRecord;

final class UpdateActionPublisher$1
  implements RecordTemplateListener<VoidRecord>
{
  public final void onResponse(DataStoreResponse<VoidRecord> paramDataStoreResponse)
  {
    if (error != null) {
      Log.e("UpdateActionPublisher", "update action post failure", error);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.UpdateActionPublisher.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */