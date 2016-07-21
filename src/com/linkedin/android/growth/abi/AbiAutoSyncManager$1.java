package com.linkedin.android.growth.abi;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.shared.TimeWrapper;
import com.linkedin.data.lite.VoidRecord;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationDiscardReason;

final class AbiAutoSyncManager$1
  implements RecordTemplateListener<VoidRecord>
{
  AbiAutoSyncManager$1(AbiAutoSyncManager paramAbiAutoSyncManager, String paramString) {}
  
  public final void onResponse(DataStoreResponse<VoidRecord> paramDataStoreResponse)
  {
    if (error == null)
    {
      paramDataStoreResponse = this$0.flagshipSharedPreferences;
      TimeWrapper localTimeWrapper = this$0.timeWrapper;
      paramDataStoreResponse.setAbiLastSyncTimestamp(System.currentTimeMillis());
      this$0.flagshipSharedPreferences.setAbiLastUploadedMaxContactId(this$0.flagshipSharedPreferences.getAbiLastReadMaxContactId());
      return;
    }
    OwlTrackingUtils.trackAbookImportInvitationImpressionDiscardEvent(this$0.tracker, this$0.lixManager, val$abookImportTransactionId, AbookImportInvitationDiscardReason.BACKGROUND_CONTACTS_UPLOAD);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiAutoSyncManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */