package com.linkedin.android.deeplink.routes;

public final class RoutePart
{
  RoutePartTypes partType;
  public String staticSegment;
  String variableName;
  
  RoutePart(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      partType = RoutePartTypes.STATIC_SEGMENT;
      staticSegment = paramString;
      return;
    }
    partType = RoutePartTypes.VARIABLE;
    variableName = paramString;
  }
  
  public static enum RoutePartTypes
  {
    STATIC_SEGMENT,  VARIABLE;
    
    private RoutePartTypes() {}
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.routes.RoutePart
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */