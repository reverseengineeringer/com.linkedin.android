package com.linkedin.android.growth.abi;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.abi.m2m.events.MainAbiM2MResultsRefreshEvent;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.ImportedContacts;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.MiniProfileUrns;
import java.util.List;

final class AbiDataProvider$1
  implements RecordTemplateListener<ActionResponse<MiniProfileUrns>>
{
  AbiDataProvider$1(AbiDataProvider paramAbiDataProvider) {}
  
  public final void onResponse(DataStoreResponse<ActionResponse<MiniProfileUrns>> paramDataStoreResponse)
  {
    if ((paramDataStoreResponse != null) && (error == null) && (model != null))
    {
      this$0.state).unblockedMemberContacts = AbiDataProvider.filterByUnblockedMembers((MiniProfileUrns)model).value, this$0.state).contacts.memberContacts);
      if (this$0.state).unblockedMemberContacts.size() == Util.safeGet(this$0.state).contacts.memberContacts).size()) {
        return;
      }
      this$0.activityComponent.eventBus();
      Bus.publish(new MainAbiM2MResultsRefreshEvent());
      return;
    }
    CrashReporter.reportNonFatal(new Throwable("Error fetching m2m blocking from server"));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiDataProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */