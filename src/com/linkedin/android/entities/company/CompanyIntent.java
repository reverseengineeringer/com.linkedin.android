package com.linkedin.android.entities.company;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.entities.company.controllers.CompanyActivity;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.shared.Util;
import javax.inject.Inject;

public final class CompanyIntent
  extends IntentFactory<CompanyBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramString = provideIntent(paramContext);
    if ((paramArrayMap == null) || (TextUtils.isEmpty((CharSequence)paramArrayMap.get("companyIdOrName"))))
    {
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Company Id or Name not available!"));
      return paramString;
    }
    paramArrayMap = (String)paramArrayMap.get("companyIdOrName");
    if (TextUtils.isDigitsOnly(paramArrayMap)) {}
    for (paramContext = paramArrayMap;; paramContext = null)
    {
      paramString.putExtras(CompanyBundleBuilder.create(paramContext, paramArrayMap, false).build());
      return paramString;
    }
  }
  
  public final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, CompanyActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.CompanyIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */