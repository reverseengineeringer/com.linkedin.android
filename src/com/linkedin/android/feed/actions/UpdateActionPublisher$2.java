package com.linkedin.android.feed.actions;

import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfo;

final class UpdateActionPublisher$2
  implements RecordTemplateListener<ActionResponse<GroupMembershipInfo>>
{
  UpdateActionPublisher$2(FlagshipDataManager paramFlagshipDataManager) {}
  
  public final void onResponse(DataStoreResponse<ActionResponse<GroupMembershipInfo>> paramDataStoreResponse)
  {
    if (error != null) {
      Log.e("UpdateActionPublisher", "update action post failure", error);
    }
    if (model != null)
    {
      paramDataStoreResponse = (GroupMembershipInfo)model).value;
      val$dataManager.submit(Request.put().cacheKey(entityUrn.toString()).model(paramDataStoreResponse).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.UpdateActionPublisher.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */