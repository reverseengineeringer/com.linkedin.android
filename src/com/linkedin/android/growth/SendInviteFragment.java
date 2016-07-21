package com.linkedin.android.growth;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.heathrow.HeathrowIntent;
import com.linkedin.android.growth.heathrow.HeathrowRoutingIntentBundle;
import com.linkedin.android.growth.heathrow.HeathrowSource;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager.PendingState;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.CrossActivitySnackbarCallbacks;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.TrackingUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee.Builder;
import com.linkedin.android.relationships.RelationshipsSecondaryBundleBuilder;
import com.linkedin.android.relationships.RelationshipsSecondaryIntent;
import com.linkedin.android.relationships.invitations.InvitationsDataProvider;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent.Type;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import org.json.JSONException;
import org.json.JSONObject;

public final class SendInviteFragment
  extends PageFragment
{
  private String profileId;
  private String signatureUrl;
  
  public static SendInviteFragment newInstance(SendInviteBundleBuilder paramSendInviteBundleBuilder)
  {
    SendInviteFragment localSendInviteFragment = new SendInviteFragment();
    localSendInviteFragment.setArguments(paramSendInviteBundleBuilder.build());
    return localSendInviteFragment;
  }
  
  private void startFallbackActivity()
  {
    applicationComponent.app().registerActivityLifecycleCallbacks(new CrossActivitySnackbarCallbacks(applicationComponent.app(), 2131233464));
    Object localObject = new RelationshipsSecondaryBundleBuilder();
    ((RelationshipsSecondaryBundleBuilder)localObject).setAction("ADD_CONNECTIONS");
    localObject = fragmentComponent.intentRegistry().relationshipsSecondaryIntent.newIntent(fragmentComponent.activity(), (BundleBuilder)localObject);
    fragmentComponent.activity().startActivity((Intent)localObject);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    profileId = getArguments().getString("nid");
    signatureUrl = getArguments().getString("signatureUrl");
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968968, paramViewGroup, false);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if ((profileId == null) || (signatureUrl == null))
    {
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Missing profileId or signatureUrl"));
      CrashReporter.reportNonFatal(new RuntimeException("Missing profileId or signatureUrl"));
      startFallbackActivity();
      return;
    }
    paramView = fragmentComponent.invitationsDataProvider();
    String str = profileId;
    Object localObject2 = signatureUrl;
    RecordTemplateListener local1 = new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse paramAnonymousDataStoreResponse)
      {
        if (error != null)
        {
          SendInviteFragment.this.startFallbackActivity();
          return;
        }
        paramAnonymousDataStoreResponse = new HeathrowRoutingIntentBundle().profileIdString(profileId).heathrowSource(HeathrowSource.EMAIL_DEEPLINK_SEND_INVITE);
        paramAnonymousDataStoreResponse = fragmentComponent.intentRegistry().heathrowIntent.newIntent(fragmentComponent.activity(), paramAnonymousDataStoreResponse);
        fragmentComponent.activity().startActivity(paramAnonymousDataStoreResponse);
      }
    };
    paramBundle = activityComponent;
    Object localObject1 = new JSONObject();
    try
    {
      Object localObject3 = new InviteeProfile.Builder().setProfileId(str).build(RecordTemplate.Flavor.RECORD);
      localObject3 = new NormInvitation.Invitee.Builder().setInviteeProfileValue((InviteeProfile)localObject3).build();
      ((JSONObject)localObject1).put("invitation", PegasusPatchGenerator.modelToJSON(new NormInvitation.Builder().setInvitee((NormInvitation.Invitee)localObject3).setTrackingId(TrackingUtils.generateBase64EncodedTrackingId()).build(RecordTemplate.Flavor.RECORD)));
      ((JSONObject)localObject1).put("signatureUrl", localObject2);
      localObject2 = paramView.createWrapperModelListener(str, local1);
      localObject1 = Request.post().url(Routes.NORM_INVITATIONS.buildUponRoot().buildUpon().appendQueryParameter("action", "verifyAndConnect").build().toString()).model(new JsonModel((JSONObject)localObject1)).listener((RecordTemplateListener)localObject2).filter(DataManager.DataStoreFilter.NETWORK_ONLY).customHeaders(Tracker.createPageInstanceHeader(paramBundle.tracker().getCurrentPageInstance()));
      paramBundle.dataManager().submit((Request.Builder)localObject1);
      activityComponent.eventBus();
      Bus.publish(new InvitationUpdatedEvent(str, InvitationUpdatedEvent.Type.SENT));
      profilePendingConnectionRequestManager.setPendingState(str, ProfilePendingConnectionRequestManager.PendingState.INVITATION_SENT);
      return;
    }
    catch (BuilderException paramView)
    {
      paramBundle.context();
      Util.safeThrow$7a8b4789(new RuntimeException("Failed to create normInvitation", paramView));
      return;
    }
    catch (JSONException paramView)
    {
      for (;;) {}
    }
  }
  
  public final String pageKey()
  {
    return "send_invite";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.SendInviteFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */