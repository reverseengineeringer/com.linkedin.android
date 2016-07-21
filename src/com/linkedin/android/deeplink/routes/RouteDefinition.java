package com.linkedin.android.deeplink.routes;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RouteDefinition
{
  public static final String TAG = RouteDefinition.class.getSimpleName();
  String authorityOverride;
  String optionalPrefix;
  String schemeOverride;
  public List<RoutePart> segments;
  
  public RouteDefinition(String paramString1, String paramString2, String paramString3, List<RoutePart> paramList)
  {
    schemeOverride = paramString1;
    authorityOverride = paramString2;
    optionalPrefix = paramString3;
    segments = paramList;
  }
  
  public final String getRoutePattern$2e47ea6f(ArrayMap<String, String> paramArrayMap)
  {
    Object localObject1 = "";
    Object localObject2 = segments.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      RoutePart localRoutePart = (RoutePart)((Iterator)localObject2).next();
      switch (partType)
      {
      default: 
        Log.e(TAG, String.format("Unsupported RoutePartType in getRoutePattern(): %s", new Object[] { partType }));
        break;
      case ???: 
        localObject1 = (String)localObject1 + "/" + staticSegment;
        break;
      case ???: 
        if (paramArrayMap == null) {
          localObject1 = (String)localObject1 + "/.*";
        } else {
          localObject1 = (String)localObject1 + "/" + (String)paramArrayMap.get(variableName);
        }
        break;
      }
    }
    localObject2 = localObject1;
    if (optionalPrefix != null) {
      localObject2 = "/" + optionalPrefix + (String)localObject1;
    }
    paramArrayMap = (ArrayMap<String, String>)localObject2;
    if (authorityOverride != null)
    {
      localObject1 = authorityOverride + (String)localObject2;
      paramArrayMap = (ArrayMap<String, String>)localObject1;
      if (schemeOverride == null)
      {
        schemeOverride = "https";
        paramArrayMap = (ArrayMap<String, String>)localObject1;
      }
    }
    localObject1 = paramArrayMap;
    if (schemeOverride != null) {
      localObject1 = schemeOverride + "://" + paramArrayMap;
    }
    return (String)localObject1;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.routes.RouteDefinition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */