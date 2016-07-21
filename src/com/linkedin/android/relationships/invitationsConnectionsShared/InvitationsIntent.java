package com.linkedin.android.relationships.invitationsConnectionsShared;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.relationships.RelationshipsSecondaryActivity;
import com.linkedin.android.relationships.RelationshipsSecondaryBundleBuilder;
import javax.inject.Inject;

public final class InvitationsIntent
  extends IntentFactory<RelationshipsSecondaryBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramArrayMap = provideIntent(paramContext);
    if ("enabled".equals(((FlagshipApplication)paramContext.getApplicationContext()).getAppComponent().lixManager().getTreatment(Lix.MYNETWORK_INVITATIONS_V2))) {
      paramContext = RelationshipsSecondaryActivity.buildPendingInvitationsBundle();
    }
    for (;;)
    {
      paramArrayMap.putExtras(paramContext.build());
      return paramArrayMap;
      paramContext = RelationshipsSecondaryActivity.buildInvitationsConnectionsBundle$17754a57();
      paramString = new InvitationsConnectionsBundleBuilder();
      activeTab = 0;
      fragmentAction = InvitationsConnectionsBundleBuilder.Actions.INVITATIONS;
      paramContext.setFragmentBundle(paramString.build());
    }
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, RelationshipsSecondaryActivity.class).setFlags(536936448);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.invitationsConnectionsShared.InvitationsIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */