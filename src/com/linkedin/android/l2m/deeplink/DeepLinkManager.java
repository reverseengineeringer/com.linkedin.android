package com.linkedin.android.l2m.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.linkedin.android.deeplink.exceptions.DeeplinkException;
import com.linkedin.android.deeplink.helper.DeeplinkHelper;
import com.linkedin.android.deeplink.helper.LaunchHelper;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.identity.profile.ProfileBundleBuilder;
import com.linkedin.android.identity.profile.ProfileViewActivity;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.IntentUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.publishing.sharing.ShareBundle;
import com.linkedin.android.publishing.sharing.ShareIntent;
import com.linkedin.android.publishing.sharing.compose.ShareComposeBundle;
import com.linkedin.gen.avro2pegasus.events.mobile.LinkFailureType;
import com.linkedin.xmsg.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public final class DeepLinkManager
{
  protected Activity activity;
  protected Context context;
  protected DeeplinkHelper deeplinkHelper;
  protected IntentRegistry intentRegistry;
  protected Tracker tracker;
  
  @Inject
  DeepLinkManager(Tracker paramTracker, IntentRegistry paramIntentRegistry, DeeplinkHelper paramDeeplinkHelper)
  {
    tracker = paramTracker;
    intentRegistry = paramIntentRegistry;
    deeplinkHelper = paramDeeplinkHelper;
  }
  
  final ArrayList<Intent> getOutboundIntents(Context paramContext, Activity paramActivity, Intent paramIntent)
    throws DeeplinkException
  {
    context = paramContext;
    activity = paramActivity;
    ArrayList localArrayList = new ArrayList();
    paramActivity = paramIntent.getAction();
    new Bundle();
    Object localObject1;
    int i;
    Object localObject2;
    if ("android.intent.action.VIEW".equals(paramActivity))
    {
      localObject1 = paramIntent.getData();
      if (localObject1 != null)
      {
        paramActivity = ((Uri)localObject1).getScheme();
        localObject1 = ((Uri)localObject1).getQueryParameter("src");
        if (("linkedin".equals(paramActivity)) && ("sdk".equals(localObject1)))
        {
          i = 1;
          if (i == 0) {
            break label457;
          }
          localObject2 = new Intent(context, ProfileViewActivity.class);
          localObject1 = new ArrayList();
          String str1 = activity.getCallingPackage();
          paramActivity = paramIntent.getData().getAuthority();
          if (!"you".equals(paramActivity)) {
            break label272;
          }
          paramActivity = ProfileBundleBuilder.createSelfProfile();
          label148:
          if (str1 == null) {
            break label447;
          }
          paramActivity.setThirdPartyPackageName(str1);
          ((Intent)localObject2).putExtras(paramActivity.build());
          ((Intent)localObject2).addFlags(33554432);
          ((List)localObject1).add(localObject2);
          paramActivity = (Activity)localObject1;
          label190:
          localObject1 = localArrayList;
          if (paramActivity != null)
          {
            localArrayList.addAll(paramActivity);
            localObject1 = localArrayList;
          }
        }
      }
    }
    label272:
    label447:
    label457:
    label527:
    label639:
    label644:
    label691:
    do
    {
      if (((ArrayList)localObject1).isEmpty())
      {
        paramActivity = new HomeBundle();
        activeTab = HomeTabInfo.FEED;
        paramContext = intentRegistry.home.newIntent(paramContext, paramActivity);
        LaunchHelper.appendValuesToIntent(paramContext);
        ((ArrayList)localObject1).add(paramContext);
      }
      return (ArrayList<Intent>)localObject1;
      i = 0;
      break;
      i = 0;
      break;
      if ("profile".equals(paramActivity))
      {
        paramActivity = paramIntent.getData().getLastPathSegment();
        String str2 = paramIntent.getData().getQueryParameter("accessToken");
        if ((!StringUtils.isEmpty(paramActivity)) && (!StringUtils.isEmpty(str2)))
        {
          paramActivity = ProfileBundleBuilder.createFromExternalIdentifier("li-platform:" + paramActivity + ":" + str2 + ":1");
          break label148;
        }
        LaunchHelper.sendInboundExternalLinkFailureEvent(tracker, paramIntent.getData().toString(), LinkFailureType.URL_ROUTE_VERIFICATION_FAILURE);
        throw new DeeplinkException("Malformed third-party SDK deeplink URL: " + paramIntent.getData().toString());
      }
      LaunchHelper.sendInboundExternalLinkFailureEvent(tracker, paramIntent.getData().toString(), LinkFailureType.URL_ROUTE_VERIFICATION_FAILURE);
      throw new DeeplinkException("Malformed third-party SDK deeplink URL: " + paramIntent.getData().toString());
      throw new DeeplinkException("SDK Package Name could not be found");
      localObject2 = paramIntent.getData();
      if (localObject2 != null)
      {
        paramActivity = ((Uri)localObject2).getScheme();
        localObject1 = ((Uri)localObject2).getAuthority();
        localObject2 = ((Uri)localObject2).getQueryParameter("referrer_partner");
        if (("linkedin".equals(paramActivity)) && ("profile".equals(localObject1)) && (localObject2 != null) && (((String)localObject2).startsWith("samsung")))
        {
          i = 1;
          if (i == 0) {
            break label691;
          }
          paramActivity = paramIntent.getData();
          if (paramActivity.getPathSegments().isEmpty()) {
            break label639;
          }
        }
      }
      for (paramActivity = (String)paramActivity.getPathSegments().get(0);; paramActivity = null)
      {
        if (paramActivity == null) {
          break label644;
        }
        paramIntent = new ArrayList();
        paramActivity = ProfileBundleBuilder.createFromMemberId(paramActivity);
        localObject1 = new Intent(context, ProfileViewActivity.class);
        ((Intent)localObject1).putExtras(paramActivity.build());
        ((Intent)localObject1).addFlags(33554432);
        paramIntent.add(localObject1);
        paramActivity = paramIntent;
        break;
        i = 0;
        break label527;
        i = 0;
        break label527;
      }
      LaunchHelper.sendInboundExternalLinkFailureEvent(tracker, paramIntent.getData().toString(), LinkFailureType.URL_ROUTE_VERIFICATION_FAILURE);
      throw new DeeplinkException("Malformed Samsung Contact Sync deeplink URL: " + paramIntent.getData().toString());
      paramActivity = paramIntent.getData();
      if (paramActivity != null) {
        CrashReporter.leaveBreadcrumb("deeplink_on_route: " + LinkingRoutes.getMatchingRoute(paramActivity).name());
      }
      paramActivity = DeeplinkHelper.getIntentForUrl$53956ba3(paramContext, paramIntent);
      break label190;
      localObject1 = localArrayList;
    } while (!"android.intent.action.SEND".equals(paramActivity));
    paramActivity = paramIntent.getType();
    if (paramActivity != null) {
      if (paramActivity.startsWith("text/"))
      {
        paramActivity = ShareBundle.createFeedShare(ShareComposeBundle.createOriginalShareWithInitialText(paramIntent.getStringExtra("android.intent.extra.TEXT")));
        paramActivity = intentRegistry.share.newIntent(context, paramActivity);
        paramActivity.setFlags(268468224);
      }
    }
    for (;;)
    {
      localObject1 = localArrayList;
      if (paramActivity == paramIntent) {
        break;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(paramActivity);
      break;
      if (paramActivity.startsWith("image/"))
      {
        paramActivity = ShareBundle.createFeedShare(ShareComposeBundle.createOriginalShareWithImage((Uri)paramIntent.getParcelableExtra("android.intent.extra.STREAM")));
        paramActivity = intentRegistry.share.newIntent(context, paramActivity);
        paramActivity.setFlags(268468224);
        IntentUtils.grantReadUriPermission(paramActivity, paramIntent);
      }
      else
      {
        paramActivity = paramIntent;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.deeplink.DeepLinkManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */