package com.linkedin.android.relationships;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import butterknife.ButterKnife;
import com.linkedin.android.growth.heathrow.HeathrowRoutingFragment;
import com.linkedin.android.growth.heathrow.HeathrowRoutingIntentBundle;
import com.linkedin.android.growth.heathrow.HeathrowSource;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop;
import com.linkedin.android.relationships.addConnections.AddConnectionsFragment;
import com.linkedin.android.relationships.connectFlow.ConnectFlowBundleBuilder;
import com.linkedin.android.relationships.connectFlow.ConnectFlowFragment;
import com.linkedin.android.relationships.invitations.PendingInvitationListFragment;
import com.linkedin.android.relationships.invitations.PendingInvitationListFragmentBundleBuilder;
import com.linkedin.android.relationships.invitationsConnectionsShared.InvitationsConnectionsBundleBuilder;
import com.linkedin.android.relationships.invitationsConnectionsShared.InvitationsConnectionsBundleBuilder.Actions;
import com.linkedin.android.relationships.invitationsConnectionsShared.InvitationsConnectionsFragment;
import com.linkedin.android.relationships.meetings.MeetingDetailsFragment;
import com.linkedin.android.relationships.meetings.MeetingDetailsFragmentBundleBuilder;

public class RelationshipsSecondaryActivity
  extends BaseActivity
{
  public static RelationshipsSecondaryBundleBuilder buildConnectFlowBundle$360e8a96$4ab50998(String paramString)
  {
    paramString = new ConnectFlowBundleBuilder(paramString, 1);
    RelationshipsSecondaryBundleBuilder localRelationshipsSecondaryBundleBuilder = new RelationshipsSecondaryBundleBuilder();
    localRelationshipsSecondaryBundleBuilder.setAction("CONNECT_FLOW");
    localRelationshipsSecondaryBundleBuilder.setFragmentBundle(paramString.build());
    return localRelationshipsSecondaryBundleBuilder;
  }
  
  public static RelationshipsSecondaryBundleBuilder buildHeathrowBundle(String paramString, HeathrowSource paramHeathrowSource)
  {
    paramString = new HeathrowRoutingIntentBundle().profileIdString(paramString).heathrowSource(paramHeathrowSource);
    paramHeathrowSource = new RelationshipsSecondaryBundleBuilder();
    paramHeathrowSource.setAction("HEATHROW");
    paramHeathrowSource.setFragmentBundle(paramString.build());
    return paramHeathrowSource;
  }
  
  public static RelationshipsSecondaryBundleBuilder buildInvitationsConnectionsBundle$17754a57()
  {
    RelationshipsSecondaryBundleBuilder localRelationshipsSecondaryBundleBuilder = new RelationshipsSecondaryBundleBuilder();
    localRelationshipsSecondaryBundleBuilder.setAction("INVITATIONS_CONNECTIONS");
    return localRelationshipsSecondaryBundleBuilder;
  }
  
  public static RelationshipsSecondaryBundleBuilder buildPendingInvitationsBundle()
  {
    RelationshipsSecondaryBundleBuilder localRelationshipsSecondaryBundleBuilder = new RelationshipsSecondaryBundleBuilder();
    localRelationshipsSecondaryBundleBuilder.setAction("PENDING_INVITATIONS");
    return localRelationshipsSecondaryBundleBuilder;
  }
  
  public static void openAddConnectionsPage(FragmentComponent paramFragmentComponent)
  {
    openAddConnectionsPage(paramFragmentComponent, false);
  }
  
  public static void openAddConnectionsPage(FragmentComponent paramFragmentComponent, boolean paramBoolean)
  {
    RelationshipsSecondaryBundleBuilder localRelationshipsSecondaryBundleBuilder = new RelationshipsSecondaryBundleBuilder();
    localRelationshipsSecondaryBundleBuilder.setAction("ADD_CONNECTIONS");
    bundle.putBoolean("FROM_DEEPLINK", paramBoolean);
    startActivity(paramFragmentComponent, localRelationshipsSecondaryBundleBuilder);
  }
  
  public static void openConnectFlowPage(FragmentComponent paramFragmentComponent, String paramString, int paramInt)
  {
    paramString = new ConnectFlowBundleBuilder(paramString, paramInt);
    RelationshipsSecondaryBundleBuilder localRelationshipsSecondaryBundleBuilder = new RelationshipsSecondaryBundleBuilder();
    localRelationshipsSecondaryBundleBuilder.setAction("CONNECT_FLOW");
    localRelationshipsSecondaryBundleBuilder.setFragmentBundle(paramString.build());
    startActivity(paramFragmentComponent, localRelationshipsSecondaryBundleBuilder);
  }
  
  public static void openConnectionsPage(FragmentComponent paramFragmentComponent)
  {
    InvitationsConnectionsBundleBuilder localInvitationsConnectionsBundleBuilder = new InvitationsConnectionsBundleBuilder();
    fragmentAction = InvitationsConnectionsBundleBuilder.Actions.CONNECTIONS;
    RelationshipsSecondaryBundleBuilder localRelationshipsSecondaryBundleBuilder = new RelationshipsSecondaryBundleBuilder();
    localRelationshipsSecondaryBundleBuilder.setAction("CONNECTIONS");
    localRelationshipsSecondaryBundleBuilder.setFragmentBundle(localInvitationsConnectionsBundleBuilder.build());
    startActivity(paramFragmentComponent, localRelationshipsSecondaryBundleBuilder);
  }
  
  public static void openInvitationsPage(FragmentComponent paramFragmentComponent, int paramInt)
  {
    if ("enabled".equals(paramFragmentComponent.lixManager().getTreatment(Lix.MYNETWORK_INVITATIONS_V2)))
    {
      localObject = new PendingInvitationListFragmentBundleBuilder();
      bundle.putInt("unseen_count", paramInt);
      localRelationshipsSecondaryBundleBuilder = new RelationshipsSecondaryBundleBuilder();
      localRelationshipsSecondaryBundleBuilder.setAction("PENDING_INVITATIONS");
      localRelationshipsSecondaryBundleBuilder.setFragmentBundle(((PendingInvitationListFragmentBundleBuilder)localObject).build());
      startActivity(paramFragmentComponent, localRelationshipsSecondaryBundleBuilder);
      return;
    }
    Object localObject = new InvitationsConnectionsBundleBuilder();
    fragmentAction = InvitationsConnectionsBundleBuilder.Actions.INVITATIONS;
    invitationUnseenCount = paramInt;
    RelationshipsSecondaryBundleBuilder localRelationshipsSecondaryBundleBuilder = new RelationshipsSecondaryBundleBuilder();
    localRelationshipsSecondaryBundleBuilder.setAction("INVITATIONS");
    localRelationshipsSecondaryBundleBuilder.setFragmentBundle(((InvitationsConnectionsBundleBuilder)localObject).build());
    startActivity(paramFragmentComponent, localRelationshipsSecondaryBundleBuilder);
  }
  
  public static void openMeetingDetailsPage(FragmentComponent paramFragmentComponent, String paramString, Prop paramProp)
  {
    MeetingDetailsFragmentBundleBuilder localMeetingDetailsFragmentBundleBuilder = new MeetingDetailsFragmentBundleBuilder();
    meetingId = paramString;
    prop = paramProp;
    paramString = new RelationshipsSecondaryBundleBuilder();
    paramString.setAction("MEETING_DETAILS");
    paramString.setFragmentBundle(localMeetingDetailsFragmentBundleBuilder.build());
    startActivity(paramFragmentComponent, paramString);
  }
  
  private static void startActivity(FragmentComponent paramFragmentComponent, RelationshipsSecondaryBundleBuilder paramRelationshipsSecondaryBundleBuilder)
  {
    paramRelationshipsSecondaryBundleBuilder = intentRegistryrelationshipsSecondaryIntent.newIntent(paramFragmentComponent.activity(), paramRelationshipsSecondaryBundleBuilder);
    paramFragmentComponent.activity().startActivity(paramRelationshipsSecondaryBundleBuilder);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130969342);
    ButterKnife.inject(this);
    if (paramBundle != null) {}
    for (;;)
    {
      return;
      paramBundle = getIntent().getExtras();
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      String str = localBundle.getString("KEY_ACTION");
      paramBundle = null;
      if ("INVITATIONS_CONNECTIONS".equals(str)) {
        paramBundle = new InvitationsConnectionsFragment();
      }
      while (paramBundle != null)
      {
        paramBundle.setArguments(localBundle.getBundle("KEY_BUNDLE"));
        getSupportFragmentManager().beginTransaction().replace(2131758296, paramBundle).commit();
        return;
        if ("CONNECT_FLOW".equals(str)) {
          paramBundle = new ConnectFlowFragment();
        } else if ("ADD_CONNECTIONS".equals(str)) {
          paramBundle = new AddConnectionsFragment();
        } else if ("CONNECTIONS".equals(str)) {
          paramBundle = new InvitationsConnectionsFragment();
        } else if ("INVITATIONS".equals(str)) {
          paramBundle = new InvitationsConnectionsFragment();
        } else if ("HEATHROW".equals(str)) {
          paramBundle = new HeathrowRoutingFragment();
        } else if ("MEETING_DETAILS".equals(str)) {
          paramBundle = new MeetingDetailsFragment();
        } else if ("PENDING_INVITATIONS".equals(str)) {
          paramBundle = new PendingInvitationListFragment();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.RelationshipsSecondaryActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */