package com.linkedin.android.feed;

import android.widget.Toast;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager.PendingState;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent.Type;
import com.linkedin.data.lite.VoidRecord;

public final class FeedUpdatesDataProvider$2
  implements RecordTemplateListener<VoidRecord>
{
  public FeedUpdatesDataProvider$2(FeedUpdatesDataProvider paramFeedUpdatesDataProvider, String paramString, FragmentComponent paramFragmentComponent) {}
  
  public final void onResponse(DataStoreResponse<VoidRecord> paramDataStoreResponse)
  {
    if (error != null)
    {
      this$0.profilePendingConnectionRequestManager.setPendingState(val$profileId, ProfilePendingConnectionRequestManager.PendingState.NO_PENDING_STATE);
      Toast.makeText(this$0.activityComponent.activity(), 2131230832, 0).show();
      val$fragmentComponent.eventBus();
      Bus.publish(new InvitationUpdatedEvent(val$profileId, InvitationUpdatedEvent.Type.FAILED));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.FeedUpdatesDataProvider.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */