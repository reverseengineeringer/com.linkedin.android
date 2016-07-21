package com.linkedin.android.growth;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.heathrow.HeathrowIntent;
import com.linkedin.android.growth.heathrow.HeathrowRoutingIntentBundle;
import com.linkedin.android.growth.heathrow.HeathrowSource;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;

final class SendInviteFragment$1
  implements RecordTemplateListener
{
  SendInviteFragment$1(SendInviteFragment paramSendInviteFragment) {}
  
  public final void onResponse(DataStoreResponse paramDataStoreResponse)
  {
    if (error != null)
    {
      SendInviteFragment.access$000(this$0);
      return;
    }
    paramDataStoreResponse = new HeathrowRoutingIntentBundle().profileIdString(SendInviteFragment.access$100(this$0)).heathrowSource(HeathrowSource.EMAIL_DEEPLINK_SEND_INVITE);
    paramDataStoreResponse = this$0.fragmentComponent.intentRegistry().heathrowIntent.newIntent(this$0.fragmentComponent.activity(), paramDataStoreResponse);
    this$0.fragmentComponent.activity().startActivity(paramDataStoreResponse);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.SendInviteFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */