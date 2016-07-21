package com.linkedin.android.l2m.notification;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.linkedin.android.l2m.deeplink.DeepLinkHelperBundleBuilder;
import com.linkedin.android.l2m.deeplink.DeepLinkHelperIntent;

public final class PendingIntentBuilder
{
  public static PendingIntent buildDefaultPendingIntent(Context paramContext, NotificationPayload paramNotificationPayload, DeepLinkHelperIntent paramDeepLinkHelperIntent)
  {
    return buildPendingIntent(paramContext, paramNotificationPayload, paramDeepLinkHelperIntent, getBundleBuilder(paramNotificationPayload, Uri.parse(uri), null, null));
  }
  
  static PendingIntent buildPendingIntent(Context paramContext, NotificationPayload paramNotificationPayload, DeepLinkHelperIntent paramDeepLinkHelperIntent, DeepLinkHelperBundleBuilder paramDeepLinkHelperBundleBuilder)
  {
    paramDeepLinkHelperIntent = paramDeepLinkHelperIntent.newIntent(paramContext, paramDeepLinkHelperBundleBuilder);
    return PendingIntent.getActivity(paramContext, uniqueId.hashCode(), paramDeepLinkHelperIntent, 1073741824);
  }
  
  static DeepLinkHelperBundleBuilder getBundleBuilder(NotificationPayload paramNotificationPayload, Uri paramUri, String paramString, Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      paramBundle = null;
      paramBundle = new DeepLinkHelperBundleBuilder(paramBundle);
      String str = uniqueId;
      bundle.putBoolean("is_push", true);
      bundle.putString("push_flock_message_urn", str);
      paramNotificationPayload = notificationUrn;
      if (!TextUtils.isEmpty(paramNotificationPayload)) {
        bundle.putString("notification_urn", paramNotificationPayload);
      }
      if (paramUri == null) {
        break label92;
      }
      bundle.putParcelable("uri", paramUri);
    }
    label92:
    while (paramString == null)
    {
      return paramBundle;
      paramBundle = new Bundle(paramBundle);
      break;
    }
    bundle.putParcelable("uri", new Uri.Builder().path(paramString).build());
    return paramBundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.PendingIntentBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */