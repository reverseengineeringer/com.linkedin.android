package com.linkedin.android.deeplink.helper;

import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.routes.RouteDefinition;

public final class LinkUrlBuilder
{
  public static String buildLink$5bb0daed(LinkingRoutes paramLinkingRoutes, ArrayMap<String, String> paramArrayMap)
  {
    return routeDefinition.getRoutePattern$2e47ea6f(paramArrayMap);
  }
  
  public static String getMessageComposeLink(String paramString)
  {
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.put("recipientId", paramString);
    return buildLink$5bb0daed(LinkingRoutes.COMM_MESSAGING_COMPOSE_RECIPIENT, localArrayMap);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.helper.LinkUrlBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */