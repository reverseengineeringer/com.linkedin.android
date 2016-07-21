package com.linkedin.android.deeplink.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.linkedin.android.deeplink.exceptions.DeeplinkException;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.gen.avro2pegasus.events.mobile.InboundExternalLinkFailureEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.mobile.LinkFailureType;
import java.util.ArrayList;
import java.util.List;

public class LaunchHelper
{
  private static final String TAG = LaunchHelper.class.getName();
  
  public static Intent appendValuesToIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    paramIntent.putExtra("isDeeplink", true);
    paramIntent.addFlags(32768);
    paramIntent.addFlags(268435456);
    paramIntent.addFlags(67108864);
    return paramIntent;
  }
  
  public static List<Intent> getIntentFromDeeplink(Context paramContext, Intent paramIntent)
    throws DeeplinkException
  {
    Tracker localTracker = getInstancetracker;
    String str1 = "";
    if (paramIntent == null)
    {
      Log.e(TAG, "Inbound intent for deeplinking empty");
      sendInboundExternalLinkFailureEvent(localTracker, "", LinkFailureType.INVALID_INBOUND_DATA);
      paramIntent = null;
      return paramIntent;
    }
    Object localObject = paramIntent.getData();
    ArrayList localArrayList = new ArrayList();
    if (localObject != null) {
      str1 = ((Uri)localObject).toString();
    }
    String str2 = paramIntent.getAction();
    Uri localUri = paramIntent.getData();
    if (str2 == null)
    {
      Log.e(TAG, "Inboundintent action is empty");
      i = 0;
    }
    while (i == 0)
    {
      sendInboundExternalLinkFailureEvent(localTracker, str1, LinkFailureType.INVALID_INBOUND_DATA);
      Log.e(TAG, "Intent is not valid");
      return null;
      if (!"android.intent.action.VIEW".equals(str2))
      {
        Log.e(TAG, "Inboundintent action should equal Intent.ACTION_VIEW");
        i = 0;
      }
      else if (localUri == null)
      {
        Log.e(TAG, "Inboundintent data should not be empty");
        i = 0;
      }
      else
      {
        i = 1;
      }
    }
    int i = str1.indexOf("?");
    boolean bool;
    if (i != -1)
    {
      localObject = Uri.parse(str1.substring(0, i));
      bool = paramIntent.getBooleanExtra("skipBackstacks", false);
      paramIntent = LinkingRoutes.getMatchingRoute((Uri)localObject);
      if (paramIntent != null) {
        break label265;
      }
      sendInboundExternalLinkFailureEvent(localTracker, str1, LinkFailureType.URL_ROUTE_VERIFICATION_FAILURE);
      Log.e(TAG, "There is no such route in LinkingRoutes");
    }
    for (paramContext = localArrayList;; paramContext = DeeplinkHelper.getInstance().getAllRegisteredDeeplinkIntents(paramContext, paramIntent, (ArrayMap)localObject, str1, bool))
    {
      if (paramContext.size() != 0) {
        break label316;
      }
      sendInboundExternalLinkFailureEvent(localTracker, str1, LinkFailureType.FAILED_TO_BUILD_LINK);
      Log.e(TAG, "Intent couldn't be built for the url provided");
      return null;
      break;
      label265:
      localObject = paramIntent.getMap((Uri)localObject);
      if (localObject == null)
      {
        sendInboundExternalLinkFailureEvent(localTracker, str1, LinkFailureType.URL_ROUTE_VERIFICATION_FAILURE);
        Log.e(TAG, "urlParams was null, indicating a failure to validate the path in getMap()");
        return null;
      }
    }
    label316:
    i = 0;
    for (;;)
    {
      paramIntent = paramContext;
      if (i >= paramContext.size()) {
        break;
      }
      paramContext.set(i, appendValuesToIntent((Intent)paramContext.get(i)));
      i += 1;
    }
  }
  
  public static void sendInboundExternalLinkFailureEvent(Tracker paramTracker, String paramString, LinkFailureType paramLinkFailureType)
  {
    InboundExternalLinkFailureEvent.Builder localBuilder = new InboundExternalLinkFailureEvent.Builder();
    if (paramString == null)
    {
      hasIntendedDestinationUrl = false;
      intendedDestinationUrl = null;
      if (paramLinkFailureType != null) {
        break label55;
      }
      hasFailureType = false;
    }
    for (failureType = null;; failureType = paramLinkFailureType)
    {
      paramTracker.send(localBuilder);
      return;
      hasIntendedDestinationUrl = true;
      intendedDestinationUrl = paramString;
      break;
      label55:
      hasFailureType = true;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.helper.LaunchHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */