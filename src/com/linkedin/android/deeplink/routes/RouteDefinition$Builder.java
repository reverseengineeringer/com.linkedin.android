package com.linkedin.android.deeplink.routes;

import java.util.ArrayList;
import java.util.List;

public final class RouteDefinition$Builder
{
  String authorityOverride;
  String optionalPrefix;
  String schemeOverride;
  List<RoutePart> segments = new ArrayList();
  
  public final RouteDefinition build()
  {
    return new RouteDefinition(schemeOverride, authorityOverride, optionalPrefix, segments);
  }
  
  public final Builder segment(String paramString)
  {
    segments.add(new RoutePart(paramString, true));
    return this;
  }
  
  public final Builder variable(String paramString)
  {
    segments.add(new RoutePart(paramString, false));
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.routes.RouteDefinition.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */