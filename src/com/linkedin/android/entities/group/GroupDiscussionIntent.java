package com.linkedin.android.entities.group;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.feed.detail.FeedUpdateDetailActivity;
import com.linkedin.android.feed.detail.FeedUpdateDetailBundleBuilder;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.shared.Util;
import javax.inject.Inject;

public final class GroupDiscussionIntent
  extends IntentFactory<GroupBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramContext = provideIntent(paramContext);
    if (paramArrayMap != null)
    {
      paramArrayMap = (String)paramArrayMap.get("groupDiscussionId");
      paramContext.putExtras(FeedUpdateDetailBundleBuilder.create$69efdd29("groupPost:" + paramArrayMap, 9).build());
      return paramContext;
    }
    Util.safeThrow$7a8b4789(new IllegalArgumentException("arrayMap should not be null"));
    return paramContext;
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, FeedUpdateDetailActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.GroupDiscussionIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */