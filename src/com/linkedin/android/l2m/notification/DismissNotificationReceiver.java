package com.linkedin.android.l2m.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipCacheManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.gen.avro2pegasus.events.MessageType;
import com.linkedin.gen.avro2pegasus.events.messages.MessageActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.messages.MessageId.Builder;
import com.linkedin.gen.avro2pegasus.events.messages.actionType;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class DismissNotificationReceiver
  extends BroadcastReceiver
{
  private static final String TAG = DismissNotificationReceiver.class.getCanonicalName();
  private FlagshipCacheManager cacheManager;
  private Context context;
  private FlagshipSharedPreferences sharedPreferences;
  private Tracker tracker;
  
  public static Intent buildIntent(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, DismissNotificationReceiver.class);
    localIntent.putExtra("notificationId", paramInt);
    localIntent.setPackage(paramContext.getPackageName());
    Log.i(TAG, "Building dismissal intent for notification for ID: " + paramInt);
    return localIntent;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    context = paramContext;
    paramContext = (FlagshipApplication)paramContext.getApplicationContext();
    cacheManager = paramContext.getAppComponent().flagshipCacheManager();
    sharedPreferences = paramContext.getAppComponent().flagshipSharedPreferences();
    tracker = paramContext.getAppComponent().tracker();
    int i = paramIntent.getIntExtra("notificationId", -1);
    paramContext = NotificationCacheUtils.fetchCachedNotificationsFromId(String.valueOf(i), cacheManager).iterator();
    while (paramContext.hasNext())
    {
      paramIntent = (NotificationPayload)paramContext.next();
      try
      {
        Object localObject = "push_notification_dismiss_" + notificationType;
        localObject = new PageInstance(tracker, (String)localObject, UUID.randomUUID());
        tracker.send(new MessageActionEvent.Builder().setActionType(actionType.DISMISS).setMessageType(MessageType.PUSHNOTIFICATION).setMessageId(new MessageId.Builder().setFlockMessageUrn(uniqueId).setDeliveryId(sharedPreferences.getNotificationToken()).setExternalIds(Collections.emptyList()).build()), (PageInstance)localObject);
      }
      catch (BuilderException paramIntent)
      {
        Util.safeThrow$7a8b4789(new RuntimeException("Unable to build the MessageActionEvent for notification dismissal tracking.", paramIntent));
      }
    }
    if (i != -1)
    {
      Log.i(TAG, "Removing the notification for ID: " + i);
      NotificationCacheUtils.deleteNotificationFromCache(cacheManager, i);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.DismissNotificationReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */