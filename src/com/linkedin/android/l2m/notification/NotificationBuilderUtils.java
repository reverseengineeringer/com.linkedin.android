package com.linkedin.android.l2m.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Action;
import android.support.v4.app.NotificationCompat.Action.Builder;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.RemoteInput;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.helper.LinkUrlBuilder;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.data.FlagshipCacheManager;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.l2m.deeplink.DeepLinkHelperBundleBuilder;
import com.linkedin.android.messaging.service.ReplyIntentService;
import com.linkedin.messengerlib.ui.compose.ComposeBundleBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class NotificationBuilderUtils
{
  public static NotificationCompat.Builder buildNotification(Context paramContext, NotificationPayload paramNotificationPayload, IntentRegistry paramIntentRegistry, LixManager paramLixManager, MediaCenter paramMediaCenter, FlagshipCacheManager paramFlagshipCacheManager, I18NManager paramI18NManager)
  {
    int j = NotificationListenerService.getFlags(paramNotificationPayload);
    int k = NotificationIdUtils.computeNotificationId(paramNotificationPayload);
    paramFlagshipCacheManager = NotificationCacheUtils.fetchCachedNotificationsFromId(String.valueOf(k), paramFlagshipCacheManager);
    Object localObject;
    int i;
    if (!paramFlagshipCacheManager.isEmpty())
    {
      localObject = get0notificationType;
      i = -1;
    }
    switch (((String)localObject).hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        paramFlagshipCacheManager = new NotificationBuilderUtils.1(paramFlagshipCacheManager);
        label107:
        paramI18NManager = PendingIntentBuilder.buildDefaultPendingIntent(paramContext, paramNotificationPayload, deepLinkHelperIntent);
        localObject = PendingIntent.getBroadcast(paramContext, -1, DismissNotificationReceiver.buildIntent(paramContext, k), 268435456);
        NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext).setStyle(paramFlagshipCacheManager.buildStyle());
        mNotification.defaults = j;
        if ((j & 0x4) != 0)
        {
          Notification localNotification = mNotification;
          flags |= 0x1;
        }
        localBuilder = localBuilder.setSmallIcon(2130838687);
        mLargeIcon = NotificationListenerService.getLargeIcon(paramNotificationPayload, paramMediaCenter);
        paramMediaCenter = localBuilder.setContentTitle(paramFlagshipCacheManager.buildContentTitle()).setContentText(paramFlagshipCacheManager.buildContentText());
        mColor = NotificationListenerService.getNotificationAccentColor(paramContext);
        paramMediaCenter = paramMediaCenter.setAutoCancel$7abcb88d();
        mContentIntent = paramI18NManager;
        paramMediaCenter = paramMediaCenter.setDeleteIntent((PendingIntent)localObject);
        if (FlagshipApplication.IS_BACKGROUND.get())
        {
          i = 0;
          label277:
          mPriority = i;
          paramIntentRegistry = deepLinkHelperIntent;
          j = NotificationIdUtils.computeNotificationId(paramNotificationPayload);
          paramFlagshipCacheManager = notificationType;
          i = -1;
          switch (paramFlagshipCacheManager.hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              label344:
              label372:
              paramContext = Collections.emptyList();
            }
            break;
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        paramNotificationPayload = (NotificationCompat.Action)paramContext.next();
        mActions.add(paramNotificationPayload);
      }
      if (!((String)localObject).equals("NewMessage")) {
        break;
      }
      i = 0;
      break;
      paramFlagshipCacheManager = new MessagingNotificationContent(paramFlagshipCacheManager, paramI18NManager);
      break label107;
      i = 1;
      break label277;
      if (!paramFlagshipCacheManager.equals("NewInvite")) {
        break label344;
      }
      i = 0;
      break label344;
      if (!paramFlagshipCacheManager.equals("AcceptInvite")) {
        break label344;
      }
      i = 1;
      break label344;
      if (!paramFlagshipCacheManager.equals("NewMessage")) {
        break label344;
      }
      i = 2;
      break label344;
      paramLixManager = invitationId;
      paramFlagshipCacheManager = invitationSharedKey;
      paramI18NManager = new ArrayMap();
      paramI18NManager.put("invitationId", paramLixManager);
      paramI18NManager.put("sharedKey", paramFlagshipCacheManager);
      paramLixManager = PendingIntentBuilder.buildPendingIntent(paramContext, paramNotificationPayload, paramIntentRegistry, PendingIntentBuilder.getBundleBuilder(paramNotificationPayload, null, LinkUrlBuilder.buildLink$5bb0daed(LinkingRoutes.INVITE_ACCEPT, paramI18NManager), null).setNotificationId(j));
      paramFlagshipCacheManager = actorProfileId;
      paramI18NManager = new ArrayMap();
      paramI18NManager.put("memberId", paramFlagshipCacheManager);
      paramIntentRegistry = PendingIntentBuilder.buildPendingIntent(paramContext, paramNotificationPayload, paramIntentRegistry, PendingIntentBuilder.getBundleBuilder(paramNotificationPayload, null, LinkUrlBuilder.buildLink$5bb0daed(LinkingRoutes.PROFILE, paramI18NManager), null).setNotificationId(j));
      paramNotificationPayload = new ArrayList();
      paramNotificationPayload.add(new NotificationCompat.Action(2130837935, paramContext.getString(2131233446), paramLixManager));
      paramNotificationPayload.add(new NotificationCompat.Action(2130838228, paramContext.getString(2131233447), paramIntentRegistry));
      paramContext = paramNotificationPayload;
      continue;
      if (!"enabled".equals(paramLixManager.getTreatment(Lix.MESSAGING_ENABLE_COMPOSE_FROM_ACCEPT_INVITE_NOTIFICATION))) {
        break label372;
      }
      paramIntentRegistry = PendingIntentBuilder.buildPendingIntent(paramContext, paramNotificationPayload, paramIntentRegistry, PendingIntentBuilder.getBundleBuilder(paramNotificationPayload, null, LinkUrlBuilder.getMessageComposeLink(actorUrn), new ComposeBundleBuilder().setRecipientMemberId(actorUrn).build()).setNotificationId(j));
      paramNotificationPayload = new ArrayList();
      paramNotificationPayload.add(new NotificationCompat.Action(2130838125, paramContext.getString(2131233459), paramIntentRegistry));
      paramContext = paramNotificationPayload;
    }
    paramIntentRegistry = new ArrayList();
    if (("enabled".equals(paramLixManager.getTreatment(Lix.MESSAGING_ENABLE_NOTIFICATION_INLINE_REPLY))) && (Build.VERSION.SDK_INT > 23))
    {
      paramFlagshipCacheManager = paramContext.getString(2131233481);
      paramLixManager = ReplyIntentService.buildRemoteInput(paramFlagshipCacheManager);
      paramI18NManager = ReplyIntentService.buildIntent(paramContext, PendingIntentBuilder.getBundleBuilder(paramNotificationPayload, Uri.parse(uri), null, null).setNotificationId(j).build(), notificationType);
      paramNotificationPayload = new NotificationCompat.Action.Builder(paramFlagshipCacheManager, PendingIntent.getService(paramContext, uniqueId.hashCode(), paramI18NManager, 1073741824));
      if (mRemoteInputs == null) {
        mRemoteInputs = new ArrayList();
      }
      mRemoteInputs.add(paramLixManager);
      if (mRemoteInputs == null) {
        break label976;
      }
    }
    label976:
    for (paramContext = (RemoteInput[])mRemoteInputs.toArray(new RemoteInput[mRemoteInputs.size()]);; paramContext = null)
    {
      paramIntentRegistry.add(new NotificationCompat.Action(mIcon, mTitle, mIntent, mExtras, paramContext, (byte)0));
      paramContext = paramIntentRegistry;
      break;
    }
    return paramMediaCenter;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.NotificationBuilderUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */