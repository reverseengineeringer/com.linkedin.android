package com.linkedin.android.growth;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.shared.Util;
import javax.inject.Inject;

public final class SendInviteIntent
  extends IntentFactory<SendInviteBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramContext = provideIntent(paramContext);
    paramArrayMap = Uri.parse(paramString);
    try
    {
      paramArrayMap = paramArrayMap.getQueryParameter("nid");
      if (paramArrayMap != null)
      {
        paramLinkingRoutes = new Bundle();
        paramLinkingRoutes.putString("signatureUrl", paramString);
        paramLinkingRoutes.putString("nid", paramArrayMap);
        paramContext.putExtras(new SendInviteBundleBuilder(paramLinkingRoutes).build());
        return paramContext;
      }
      Util.safeThrow$7a8b4789(new IllegalArgumentException("hashedProfileId missing"));
      return paramContext;
    }
    catch (UnsupportedOperationException paramArrayMap)
    {
      Util.safeThrow$7a8b4789(new IllegalArgumentException("hashedProfileId cannot be parsed", paramArrayMap));
    }
    return paramContext;
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, SendInviteActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.SendInviteIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */