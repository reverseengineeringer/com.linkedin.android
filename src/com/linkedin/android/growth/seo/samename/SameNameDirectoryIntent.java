package com.linkedin.android.growth.seo.samename;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.xmsg.util.StringUtils;
import javax.inject.Inject;

public final class SameNameDirectoryIntent
  extends IntentFactory<SameNameDirectoryBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    paramContext = provideIntent(paramContext);
    paramLinkingRoutes = new SameNameDirectoryBundleBuilder();
    String str;
    if (paramArrayMap != null)
    {
      str = (String)paramArrayMap.get("firstName");
      if ((!StringUtils.isNotBlank(str)) || (str.equals("+"))) {
        break label133;
      }
      paramLinkingRoutes.setFirstName(str);
      str = (String)paramArrayMap.get("lastName");
      if ((!StringUtils.isNotBlank(str)) || (str.equals("+"))) {
        break label163;
      }
      paramLinkingRoutes.setLastName(str);
    }
    for (;;)
    {
      paramArrayMap = (String)paramArrayMap.get("region");
      if (StringUtils.isNotBlank(paramArrayMap)) {
        bundle.putString("region", paramArrayMap);
      }
      paramContext.putExtras(paramLinkingRoutes.build());
      return paramContext;
      label133:
      str = Uri.parse(paramString).getQueryParameter("first");
      if (!StringUtils.isNotBlank(str)) {
        break;
      }
      paramLinkingRoutes.setFirstName(str);
      break;
      label163:
      paramString = Uri.parse(paramString).getQueryParameter("last");
      if (StringUtils.isNotBlank(paramString)) {
        paramLinkingRoutes.setLastName(paramString);
      }
    }
  }
  
  public final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, SameNameDirectoryActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.seo.samename.SameNameDirectoryIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */