package com.linkedin.android.entities.job;

import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DataErrorEvent;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.JobApplyingInfo;
import java.util.Collections;

public final class JobDataProvider$1
  implements RecordTemplateListener<ActionResponse<JobApplyingInfo>>
{
  public JobDataProvider$1(JobDataProvider paramJobDataProvider, String paramString) {}
  
  public final void onResponse(DataStoreResponse<ActionResponse<JobApplyingInfo>> paramDataStoreResponse)
  {
    if ((!this$0.activityComponent.activity().isSafeToExecuteTransaction()) || (type == DataStore.Type.LOCAL)) {
      return;
    }
    if (error != null)
    {
      this$0.activityComponent.eventBus();
      Bus.publish(new DataErrorEvent(val$subscriberId, null, Collections.singleton(request.url), type, error));
      Toast.makeText(this$0.activityComponent.context(), 2131230896, 1).show();
      return;
    }
    if (model != null)
    {
      paramDataStoreResponse = (JobApplyingInfo)model).value;
      this$0.activityComponent.dataManager().submit(Request.put().cacheKey(entityUrn.toString()).model(paramDataStoreResponse).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
    }
    this$0.activityComponent.activity().getSupportFragmentManager().popBackStack();
    Toast.makeText(this$0.activityComponent.context(), 2131230953, 1).show();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.JobDataProvider.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */