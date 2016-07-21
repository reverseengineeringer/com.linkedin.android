package com.linkedin.android.relationships.addConnections;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.relationships.RelationshipsSecondaryActivity;
import com.linkedin.android.relationships.RelationshipsSecondaryBundleBuilder;
import javax.inject.Inject;

public final class AddConnectionsIntent
  extends IntentFactory<RelationshipsSecondaryBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramContext = provideIntent(paramContext);
    paramArrayMap = new RelationshipsSecondaryBundleBuilder();
    paramArrayMap.setAction("ADD_CONNECTIONS");
    paramContext.putExtras(paramArrayMap.build());
    return paramContext;
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, RelationshipsSecondaryActivity.class).setFlags(536936448);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.addConnections.AddConnectionsIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */