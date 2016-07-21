package com.linkedin.android.relationships.connectFlow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.growth.heathrow.HeathrowSource;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.l2m.deeplink.DeepLinkHelperBundleBuilder;
import com.linkedin.android.relationships.RelationshipsSecondaryActivity;
import com.linkedin.android.relationships.RelationshipsSecondaryBundleBuilder;
import javax.inject.Inject;

public final class AcceptedInvitationIntent
  extends IntentFactory<RelationshipsSecondaryBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramLinkingRoutes = provideIntent(paramContext);
    paramString = "";
    if (paramArrayMap != null)
    {
      paramArrayMap = (String)paramArrayMap.get("actorId");
      if (!"enabled".equals(Util.getAppComponent(paramContext).lixManager().getTreatment(Lix.FEED_INVITE_ACCEPTED_HEATHROW))) {
        break label126;
      }
      boolean bool = false;
      if ((paramContext instanceof Activity)) {
        bool = DeepLinkHelperBundleBuilder.isPushNotification(((Activity)paramContext).getIntent().getExtras());
      }
      if (!bool) {
        break label119;
      }
      paramContext = HeathrowSource.PUSH_INVITATION_ACCEPTANCE;
    }
    label83:
    label119:
    label126:
    for (paramContext = RelationshipsSecondaryActivity.buildHeathrowBundle(paramArrayMap, paramContext);; paramContext = RelationshipsSecondaryActivity.buildConnectFlowBundle$360e8a96$4ab50998(paramArrayMap))
    {
      paramLinkingRoutes.putExtras(paramContext.build());
      return paramLinkingRoutes;
      Util.safeThrow$7a8b4789(new IllegalArgumentException("arrayMap should not be null"));
      paramArrayMap = paramString;
      break;
      paramContext = HeathrowSource.EMAIL_DEEPLINK_INVITATION_ACCEPTANCE;
      break label83;
    }
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, RelationshipsSecondaryActivity.class).setFlags(536936448);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.connectFlow.AcceptedInvitationIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */