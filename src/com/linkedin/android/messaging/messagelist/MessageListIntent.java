package com.linkedin.android.messaging.messagelist;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import javax.inject.Inject;

public final class MessageListIntent
  extends IntentFactory<MessageListBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramString = new MessageListBundleBuilder();
    if (paramArrayMap != null) {
      paramString.setConversationRemoteId((String)paramArrayMap.get("threadId"));
    }
    return provideIntent(paramContext).putExtras(paramString.build());
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, MessageListActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.messagelist.MessageListIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */