package com.linkedin.android.entities.group;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.entities.group.controllers.GroupActivity;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.shared.Util;
import javax.inject.Inject;

public final class GroupIntent
  extends IntentFactory<GroupBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramContext = provideIntent(paramContext);
    if (paramArrayMap != null)
    {
      paramContext.putExtras(GroupBundleBuilder.create((String)paramArrayMap.get("groupId")).build());
      return paramContext;
    }
    Util.safeThrow$7a8b4789(new IllegalArgumentException("arrayMap should not be null"));
    return paramContext;
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, GroupActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.GroupIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */