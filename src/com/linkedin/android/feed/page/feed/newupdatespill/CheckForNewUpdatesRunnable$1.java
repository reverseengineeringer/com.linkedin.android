package com.linkedin.android.feed.page.feed.newupdatespill;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.shared.RepeatInForegroundRunnable;
import com.linkedin.android.logger.FeatureLog;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class CheckForNewUpdatesRunnable$1
  implements RecordTemplateListener<CollectionTemplate<Update, Metadata>>
{
  CheckForNewUpdatesRunnable$1(CheckForNewUpdatesRunnable paramCheckForNewUpdatesRunnable) {}
  
  public final void onResponse(DataStoreResponse<CollectionTemplate<Update, Metadata>> paramDataStoreResponse)
  {
    FeatureLog.i("CheckForNewUpdatesRunnable", "network response", "Realtime Feed Updates");
    if (this$0.stopped)
    {
      FeatureLog.i("CheckForNewUpdatesRunnable", "dropping network response because already stopped", "Realtime Feed Updates");
      return;
    }
    if (model == null)
    {
      CheckForNewUpdatesRunnable.access$002$280e73ff(this$0);
      FeatureLog.i("CheckForNewUpdatesRunnable", "got null response", "Realtime Feed Updates");
      return;
    }
    CheckForNewUpdatesRunnable.access$100(this$0, (CollectionTemplate)model);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.newupdatespill.CheckForNewUpdatesRunnable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */