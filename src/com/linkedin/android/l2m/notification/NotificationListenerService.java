package com.linkedin.android.l2m.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import com.google.android.gms.gcm.GcmListenerService;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipCacheManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.HiddenPushReceivedEvent;
import com.linkedin.android.infra.events.PushNotificationReceivedEvent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Optional;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.messaging.MessagingNotificationReceiver;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.messages.MessageId;
import com.linkedin.gen.avro2pegasus.events.messages.MessageId.Builder;
import com.linkedin.gen.avro2pegasus.events.messages.MessageReceivedEvent.Builder;
import com.linkedin.messengerlib.consumers.DataManager;
import com.linkedin.messengerlib.consumers.EventsDataManager;
import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class NotificationListenerService
  extends GcmListenerService
{
  private static final String TAG = NotificationListenerService.class.getSimpleName();
  private static Handler uiHandler = new Handler(Looper.getMainLooper());
  private FlagshipCacheManager cacheManager;
  private Bus eventBus;
  private com.linkedin.android.infra.network.I18NManager i18nManager;
  private IntentRegistry intentRegistry;
  private LixManager lixManager;
  private MediaCenter mediaCenter;
  private NotificationDisplayUtils notificationDisplayUtils;
  private FlagshipSharedPreferences sharedPreferences;
  private Tracker tracker;
  
  public static Notification buildMessagingNotification(Context paramContext, NotificationPayload paramNotificationPayload, IntentRegistry paramIntentRegistry, FlagshipCacheManager paramFlagshipCacheManager, com.linkedin.android.infra.network.I18NManager paramI18NManager, MediaCenter paramMediaCenter, LixManager paramLixManager)
  {
    return NotificationBuilderUtils.buildNotification(paramContext, paramNotificationPayload, paramIntentRegistry, paramLixManager, paramMediaCenter, paramFlagshipCacheManager, paramI18NManager).build();
  }
  
  public static int getFlags(NotificationPayload paramNotificationPayload)
  {
    int j = -1;
    if ((!TextUtils.isEmpty(silentPush)) && (Boolean.parseBoolean(silentPush))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        j = -4;
      }
      return j;
    }
  }
  
  public static Bitmap getLargeIcon(final NotificationPayload paramNotificationPayload, MediaCenter paramMediaCenter)
  {
    final ArrayBlockingQueue localArrayBlockingQueue = new ArrayBlockingQueue(1);
    final String str = RUMHelper.pageInit(getPageKey(paramNotificationPayload));
    uiHandler.post(new Runnable()
    {
      public final void run()
      {
        val$mediaCenter.loadUrl(paramNotificationPayloadactorPictureUrl, str).into(new NotificationListenerService.2.1(this));
      }
    });
    try
    {
      paramNotificationPayload = (Optional)localArrayBlockingQueue.poll(5L, TimeUnit.SECONDS);
      if (paramNotificationPayload != null)
      {
        if (value != null) {}
        for (paramNotificationPayload = value;; paramNotificationPayload = null)
        {
          paramNotificationPayload = (Bitmap)paramNotificationPayload;
          return paramNotificationPayload;
        }
      }
      return null;
    }
    catch (InterruptedException paramNotificationPayload)
    {
      Log.e(TAG, "Exception while loading notification bitmap", paramNotificationPayload);
    }
    return null;
  }
  
  public static int getNotificationAccentColor(Context paramContext)
  {
    return ContextCompat.getColor(paramContext, 2131624108);
  }
  
  private static String getPageKey(NotificationPayload paramNotificationPayload)
  {
    return "push_notification_landing_" + notificationType;
  }
  
  private boolean isDuplicateMessagingNotification(NotificationPayload paramNotificationPayload)
  {
    DataManager localDataManager;
    NotificationPayload localNotificationPayload;
    if ("enabled".equalsIgnoreCase(lixManager.getTreatment(Lix.MESSAGING_ENABLE_MESSAGE_NOTIFICATION_DEDUPING)))
    {
      localDataManager = new DataManager(getApplicationContext(), new com.linkedin.messengerlib.utils.I18NManager(getApplicationContext()));
      localNotificationPayload = null;
    }
    try
    {
      paramNotificationPayload = eventsDataManager.getEventForEventRemoteId(notificationUrn);
      if (paramNotificationPayload != null)
      {
        localNotificationPayload = paramNotificationPayload;
        int i = paramNotificationPayload.getCount();
        if (i > 0) {
          return true;
        }
      }
      return false;
    }
    finally
    {
      if (localNotificationPayload != null) {
        localNotificationPayload.close();
      }
    }
  }
  
  private boolean trySyncConversation(NotificationPayload paramNotificationPayload)
  {
    String str1 = notificationUrn;
    String str2 = NotificationIdUtils.getMessagingNotificationId(paramNotificationPayload);
    bool = false;
    if (!TextUtils.isEmpty(str2))
    {
      bool = true;
      try
      {
        Intent localIntent = new Intent("com.linkedin.messengerlib.SYNC_INTENT");
        localIntent.putExtra("syncIntentEventRemoteId", str1);
        localIntent.putExtra("syncIntentConversationRemoteId", str2);
        localIntent.setPackage(getApplicationContext().getPackageName());
        if ("enabled".equals(lixManager.getTreatment(Lix.MESSAGING_ENABLE_SMART_NOTIFICATIONS))) {
          localIntent.putExtra("notificationPayload", paramNotificationPayload.toJsonObject().toString());
        }
        for (;;)
        {
          sendOrderedBroadcast(localIntent, null);
          return true;
          int i = NotificationIdUtils.computeNotificationId(paramNotificationPayload);
          paramNotificationPayload = buildMessagingNotification(this, paramNotificationPayload, intentRegistry, cacheManager, i18nManager, mediaCenter, lixManager);
          notificationDisplayUtils.display(i, paramNotificationPayload);
        }
        return bool;
      }
      catch (NullPointerException paramNotificationPayload) {}
    }
  }
  
  public void onCreate()
  {
    CrashReporter.logComponentInfo("Starting service: " + NotificationListenerService.class.getSimpleName(), null);
    super.onCreate();
    ApplicationComponent localApplicationComponent = ((FlagshipApplication)getApplication()).getAppComponent();
    intentRegistry = localApplicationComponent.intentRegistry();
    tracker = localApplicationComponent.tracker();
    sharedPreferences = localApplicationComponent.flagshipSharedPreferences();
    mediaCenter = localApplicationComponent.mediaCenter();
    cacheManager = localApplicationComponent.flagshipCacheManager();
    lixManager = localApplicationComponent.lixManager();
    eventBus = localApplicationComponent.eventBus();
    i18nManager = localApplicationComponent.i18NManager();
    notificationDisplayUtils = localApplicationComponent.notificationDisplayUtils();
    if ("enabled".equals(lixManager.getTreatment(Lix.MESSAGING_ENABLE_SMART_NOTIFICATIONS))) {
      Util.setComponentEnabled(this, MessagingNotificationReceiver.class, true);
    }
    Util.setComponentEnabled(this, DismissNotificationReceiver.class, true);
  }
  
  public void onMessageReceived(String paramString, final Bundle paramBundle)
  {
    Log.d(TAG, "Message from: " + paramString);
    paramBundle = NotificationPayload.newInstance(paramBundle);
    if ((paramBundle == null) || (!NotificationPayload.isValid(paramBundle, String.valueOf(((FlagshipApplication)getApplication()).getAppComponent().memberUtil().getMemberId()), lixManager)))
    {
      Log.e(TAG, "Failed to validate NotificationPayload");
      paramString = "'missing notificationType because payload is NULL'";
      if (paramBundle != null) {
        paramString = notificationType;
      }
      CrashReporter.reportNonFatal(new Throwable("Failed to validate NotificationPayload with notificationType: " + paramString));
    }
    int i;
    do
    {
      return;
      uiHandler.post(new Runnable()
      {
        public final void run()
        {
          try
          {
            Object localObject = NotificationListenerService.getPageKey(paramBundle);
            PageInstance localPageInstance = new PageInstance(tracker, (String)localObject, UUID.randomUUID());
            new PageViewEvent(tracker, (String)localObject, true, localPageInstance).send();
            localObject = tracker;
            MessageReceivedEvent.Builder localBuilder = new MessageReceivedEvent.Builder();
            MessageId localMessageId = new MessageId.Builder().setFlockMessageUrn(paramBundleuniqueId).setDeliveryId(sharedPreferences.getNotificationToken()).setExternalIds(Collections.emptyList()).build(RecordTemplate.Flavor.RECORD);
            hasMessageId = true;
            messageId = localMessageId;
            ((Tracker)localObject).send(localBuilder, localPageInstance);
            return;
          }
          catch (BuilderException localBuilderException)
          {
            Log.e(NotificationListenerService.TAG, "Failed to send MessageReceivedEvent tracking for payload: " + paramBundle.toString());
          }
        }
      });
      if (!paramBundle.isUserVisible())
      {
        if ("clearCache".equals(notificationType)) {
          cacheManager.clear();
        }
        eventBus.publishInMainThread(new HiddenPushReceivedEvent(notificationType, badgeCount));
        return;
      }
      i = NotificationIdUtils.computeNotificationId(paramBundle);
      PendingIntentBuilder.buildDefaultPendingIntent(this, paramBundle, intentRegistry.deepLinkHelperIntent);
      NotificationCacheUtils.updateCachedNotification(paramBundle, cacheManager);
      if (!notificationType.equals("NewMessage")) {
        break;
      }
    } while (isDuplicateMessagingNotification(paramBundle));
    trySyncConversation(paramBundle);
    for (;;)
    {
      eventBus.publishInMainThread(new PushNotificationReceivedEvent(badgeCount));
      return;
      paramString = NotificationBuilderUtils.buildNotification(getApplicationContext(), paramBundle, intentRegistry, lixManager, mediaCenter, cacheManager, i18nManager).build();
      notificationDisplayUtils.display(i, paramString);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.NotificationListenerService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */