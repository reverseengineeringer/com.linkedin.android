package com.linkedin.android.identity.me.wvmpV2;

import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.identity.me.wvmpV2.list.WvmpCtaSendInvitationEvent;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager.PendingState;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.relationships.shared.RelationshipsRoutesHelper;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent.Type;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import org.greenrobot.eventbus.Subscribe;

final class WvmpFragment$3
{
  WvmpFragment$3(WvmpFragment paramWvmpFragment) {}
  
  @Subscribe
  public final void onEvent(WvmpCtaSendInvitationEvent paramWvmpCtaSendInvitationEvent)
  {
    if ((BaseActivity)this$0.getActivity() == null) {
      return;
    }
    WvmpDataProvider localWvmpDataProvider = this$0.getActivity()).activityComponent.wvmpDataProvider();
    Object localObject2 = miniProfile;
    paramWvmpCtaSendInvitationEvent = activityComponent.profilePendingConnectionRequestManager();
    Object localObject1 = new WvmpDataProvider.1(localWvmpDataProvider, paramWvmpCtaSendInvitationEvent, (MiniProfile)localObject2);
    try
    {
      String str = entityUrn.getId();
      Object localObject3 = new InviteeProfile.Builder().setProfileId(str).build(RecordTemplate.Flavor.RECORD);
      localObject3 = new NormInvitation.Invitee.Builder().setInviteeProfileValue((InviteeProfile)localObject3).build();
      localObject2 = new NormInvitation.Builder().setInvitee((NormInvitation.Invitee)localObject3).setTrackingId(trackingId).build(RecordTemplate.Flavor.RECORD);
      localObject1 = Request.post().url(RelationshipsRoutesHelper.makeSendGrowthInvitationRoute()).model((RecordTemplate)localObject2).filter(DataManager.DataStoreFilter.NETWORK_ONLY).listener((RecordTemplateListener)localObject1).customHeaders(null);
      activityComponent.dataManager().submit((Request.Builder)localObject1);
      activityComponent.eventBus();
      Bus.publish(new InvitationUpdatedEvent(str, InvitationUpdatedEvent.Type.SENT));
      paramWvmpCtaSendInvitationEvent.setPendingState(str, ProfilePendingConnectionRequestManager.PendingState.INVITATION_SENT);
      return;
    }
    catch (BuilderException paramWvmpCtaSendInvitationEvent)
    {
      activityComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Unable to send invite", paramWvmpCtaSendInvitationEvent));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.wvmpV2.WvmpFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */