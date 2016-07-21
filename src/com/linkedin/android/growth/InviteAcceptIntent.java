package com.linkedin.android.growth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.growth.heathrow.HeathrowRoutingActivity;
import com.linkedin.android.growth.heathrow.HeathrowRoutingIntentBundle;
import com.linkedin.android.growth.heathrow.HeathrowSource;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.l2m.deeplink.DeepLinkHelperBundleBuilder;
import javax.inject.Inject;

public final class InviteAcceptIntent
  extends IntentFactory<HeathrowRoutingIntentBundle>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    Intent localIntent = provideIntent(paramContext);
    if (paramArrayMap != null)
    {
      boolean bool = false;
      if ((paramContext instanceof Activity)) {
        bool = DeepLinkHelperBundleBuilder.isPushNotification(((Activity)paramContext).getIntent().getExtras());
      }
      if (bool) {}
      for (paramContext = HeathrowSource.PUSH_ACCEPT_INVITE; paramLinkingRoutes == LinkingRoutes.INVITE_ACCEPT; paramContext = HeathrowSource.EMAIL_DEEPLINK_ACCEPTINVITE)
      {
        paramString = (String)paramArrayMap.get("invitationId");
        paramArrayMap = (String)paramArrayMap.get("sharedKey");
        localIntent.putExtras(new HeathrowRoutingIntentBundle().heathrowSource(paramContext).withInvitationToAcceptData(paramString, paramArrayMap).build());
        return localIntent;
      }
      if (paramLinkingRoutes == LinkingRoutes.COMM_INVITE_ACCEPT)
      {
        paramString = Uri.parse(paramString);
        paramArrayMap = paramString.getQueryParameter("invitationId");
        paramString = paramString.getQueryParameter("sharedKey");
        localIntent.putExtras(new HeathrowRoutingIntentBundle().heathrowSource(paramContext).withInvitationToAcceptData(paramArrayMap, paramString).build());
        return localIntent;
      }
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Illegal route to InviteAccept"));
      return localIntent;
    }
    Util.safeThrow$7a8b4789(new IllegalArgumentException("arrayMap should not be null"));
    return localIntent;
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, HeathrowRoutingActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.InviteAcceptIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */