package com.linkedin.android.deeplink.routes;

public final class RouteScore
  implements Comparable<RouteScore>
{
  private int numExplicitlyMatchedVariables;
  private int numImplicitlyMatchedVariables;
  private int numOverrides;
  int numStaticSegments;
  LinkingRoutes route;
  
  public RouteScore(LinkingRoutes paramLinkingRoutes)
  {
    route = paramLinkingRoutes;
  }
  
  public final RouteScore addOverride$aba91b7()
  {
    numOverrides += 1;
    return this;
  }
  
  public final RouteScore addVariable(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      numExplicitlyMatchedVariables += paramInt;
      return this;
    }
    numImplicitlyMatchedVariables += paramInt;
    return this;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof RouteScore))
    {
      paramObject = (RouteScore)paramObject;
      bool1 = bool2;
      if (numOverrides == numOverrides)
      {
        bool1 = bool2;
        if (numStaticSegments == numStaticSegments)
        {
          bool1 = bool2;
          if (numExplicitlyMatchedVariables == numExplicitlyMatchedVariables)
          {
            bool1 = bool2;
            if (numImplicitlyMatchedVariables == numImplicitlyMatchedVariables) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.routes.RouteScore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */