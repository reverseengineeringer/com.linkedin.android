package com.linkedin.android.growth.utils;

import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.gen.avro2pegasus.events.relevance.ErrorType;
import com.linkedin.gen.avro2pegasus.events.relevance.Route;
import com.linkedin.gen.avro2pegasus.events.relevance.SuggestedRouteActionEvent.Builder;

public final class RelevanceTrackingUtils
{
  public static void trackSuggestedRouteActionEvent(String paramString, Tracker paramTracker, LixManager paramLixManager, Route paramRoute, ErrorType paramErrorType)
  {
    if (!"control".equals(paramLixManager.getTreatment(Lix.LIX_HEATHROW_SUGGESTED_ROUTE_TRACKING)))
    {
      paramLixManager = new SuggestedRouteActionEvent.Builder();
      if (paramString != null) {
        break label74;
      }
      hasTrackingId = false;
      trackingId = null;
      if (paramRoute != null) {
        break label87;
      }
      hasRouteServed = false;
      routeServed = null;
      label53:
      if (paramErrorType != null) {
        break label100;
      }
      hasError = false;
    }
    for (error = null;; error = paramErrorType)
    {
      paramTracker.send(paramLixManager);
      return;
      label74:
      hasTrackingId = true;
      trackingId = paramString;
      break;
      label87:
      hasRouteServed = true;
      routeServed = paramRoute;
      break label53;
      label100:
      hasError = true;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.utils.RelevanceTrackingUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */