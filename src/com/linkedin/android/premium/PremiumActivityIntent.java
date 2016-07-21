package com.linkedin.android.premium;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.pegasus.gen.common.Urn;
import javax.inject.Inject;

public final class PremiumActivityIntent
  extends IntentFactory<PremiumActivityBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramContext = provideIntent(paramContext);
    paramArrayMap = new PremiumActivityBundleBuilder();
    paramString = Uri.parse(paramString);
    paramArrayMap.setFromChannel(PremiumActionUtils.getFromChannel(paramString));
    paramArrayMap.setSuggestedFamily(PremiumActionUtils.getSuggestedFamily(paramString));
    paramArrayMap.setCampaignUrn(PremiumActionUtils.getCampaignUrn(paramString));
    paramArrayMap.setUpsellTrackingCode(Urn.createFromTuple("control", new Object[] { "premium_deeplink_upsell" }));
    paramContext.putExtras(paramArrayMap.build());
    return paramContext;
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, PremiumActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.PremiumActivityIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */