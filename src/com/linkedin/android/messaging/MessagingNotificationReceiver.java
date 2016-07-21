package com.linkedin.android.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import java.util.concurrent.ExecutorService;

public class MessagingNotificationReceiver
  extends BroadcastReceiver
{
  private static final String TAG = MessagingNotificationReceiver.class.getCanonicalName();
  
  /* Error */
  private static void showNotification(FlagshipApplication paramFlagshipApplication, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 35	com/linkedin/android/infra/app/FlagshipApplication:getAppComponent	()Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   4: invokeinterface 41 1 0
    //   9: astore 6
    //   11: aload_0
    //   12: invokevirtual 35	com/linkedin/android/infra/app/FlagshipApplication:getAppComponent	()Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   15: invokeinterface 45 1 0
    //   20: astore 7
    //   22: aload_0
    //   23: invokevirtual 35	com/linkedin/android/infra/app/FlagshipApplication:getAppComponent	()Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   26: invokeinterface 49 1 0
    //   31: astore 8
    //   33: aload_0
    //   34: invokevirtual 35	com/linkedin/android/infra/app/FlagshipApplication:getAppComponent	()Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   37: invokeinterface 53 1 0
    //   42: astore 9
    //   44: aload_0
    //   45: invokevirtual 35	com/linkedin/android/infra/app/FlagshipApplication:getAppComponent	()Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   48: invokeinterface 57 1 0
    //   53: astore 10
    //   55: aload_0
    //   56: invokevirtual 35	com/linkedin/android/infra/app/FlagshipApplication:getAppComponent	()Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   59: invokeinterface 61 1 0
    //   64: invokevirtual 67	com/linkedin/android/infra/shared/MemberUtil:getMemberId	()J
    //   67: lstore_3
    //   68: new 69	org/json/JSONObject
    //   71: dup
    //   72: aload_1
    //   73: invokespecial 72	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   76: invokestatic 78	com/linkedin/android/l2m/notification/NotificationPayload:newInstance	(Lorg/json/JSONObject;)Lcom/linkedin/android/l2m/notification/NotificationPayload;
    //   79: astore 11
    //   81: aload 11
    //   83: ifnonnull +4 -> 87
    //   86: return
    //   87: aload 11
    //   89: lload_3
    //   90: invokestatic 84	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   93: aload 10
    //   95: invokestatic 88	com/linkedin/android/l2m/notification/NotificationPayload:isValid	(Lcom/linkedin/android/l2m/notification/NotificationPayload;Ljava/lang/String;Lcom/linkedin/android/infra/lix/LixManager;)Z
    //   98: ifeq +167 -> 265
    //   101: ldc 90
    //   103: aload 10
    //   105: getstatic 96	com/linkedin/android/infra/lix/Lix:MESSAGING_ENABLE_MESSAGE_NOTIFICATION_DEDUPING	Lcom/linkedin/android/infra/lix/Lix;
    //   108: invokeinterface 102 2 0
    //   113: invokevirtual 106	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   116: ifeq +98 -> 214
    //   119: new 108	com/linkedin/messengerlib/consumers/DataManager
    //   122: dup
    //   123: aload_0
    //   124: invokevirtual 112	com/linkedin/android/infra/app/FlagshipApplication:getApplicationContext	()Landroid/content/Context;
    //   127: new 114	com/linkedin/messengerlib/utils/I18NManager
    //   130: dup
    //   131: aload_0
    //   132: invokespecial 117	com/linkedin/messengerlib/utils/I18NManager:<init>	(Landroid/content/Context;)V
    //   135: invokespecial 120	com/linkedin/messengerlib/consumers/DataManager:<init>	(Landroid/content/Context;Lcom/linkedin/messengerlib/utils/I18NManager;)V
    //   138: astore 5
    //   140: aconst_null
    //   141: astore_1
    //   142: aload 5
    //   144: getfield 124	com/linkedin/messengerlib/consumers/DataManager:eventsDataManager	Lcom/linkedin/messengerlib/consumers/EventsDataManager;
    //   147: aload 11
    //   149: getfield 127	com/linkedin/android/l2m/notification/NotificationPayload:notificationUrn	Ljava/lang/String;
    //   152: invokevirtual 133	com/linkedin/messengerlib/consumers/EventsDataManager:getEventForEventRemoteId	(Ljava/lang/String;)Landroid/database/Cursor;
    //   155: astore 5
    //   157: aload 5
    //   159: ifnull +43 -> 202
    //   162: aload 5
    //   164: astore_1
    //   165: aload 5
    //   167: invokeinterface 139 1 0
    //   172: istore_2
    //   173: iload_2
    //   174: ifle +28 -> 202
    //   177: aload 5
    //   179: ifnull +86 -> 265
    //   182: aload 5
    //   184: invokeinterface 142 1 0
    //   189: return
    //   190: astore_0
    //   191: getstatic 18	com/linkedin/android/messaging/MessagingNotificationReceiver:TAG	Ljava/lang/String;
    //   194: ldc -112
    //   196: aload_0
    //   197: invokestatic 150	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   200: pop
    //   201: return
    //   202: aload 5
    //   204: ifnull +10 -> 214
    //   207: aload 5
    //   209: invokeinterface 142 1 0
    //   214: aload 11
    //   216: invokestatic 156	com/linkedin/android/l2m/notification/NotificationIdUtils:computeNotificationId	(Lcom/linkedin/android/l2m/notification/NotificationPayload;)I
    //   219: istore_2
    //   220: aload_0
    //   221: aload 11
    //   223: aload 9
    //   225: aload 6
    //   227: aload 7
    //   229: aload 8
    //   231: aload 10
    //   233: invokestatic 162	com/linkedin/android/l2m/notification/NotificationListenerService:buildMessagingNotification	(Landroid/content/Context;Lcom/linkedin/android/l2m/notification/NotificationPayload;Lcom/linkedin/android/infra/IntentRegistry;Lcom/linkedin/android/infra/data/FlagshipCacheManager;Lcom/linkedin/android/infra/network/I18NManager;Lcom/linkedin/android/infra/network/MediaCenter;Lcom/linkedin/android/infra/lix/LixManager;)Landroid/app/Notification;
    //   236: astore_1
    //   237: aload_0
    //   238: invokevirtual 35	com/linkedin/android/infra/app/FlagshipApplication:getAppComponent	()Lcom/linkedin/android/infra/components/ApplicationComponent;
    //   241: invokeinterface 166 1 0
    //   246: iload_2
    //   247: aload_1
    //   248: invokevirtual 172	com/linkedin/android/l2m/notification/NotificationDisplayUtils:display	(ILandroid/app/Notification;)V
    //   251: return
    //   252: astore_0
    //   253: aload_1
    //   254: ifnull +9 -> 263
    //   257: aload_1
    //   258: invokeinterface 142 1 0
    //   263: aload_0
    //   264: athrow
    //   265: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramFlagshipApplication	FlagshipApplication
    //   0	266	1	paramString	String
    //   172	75	2	i	int
    //   67	23	3	l	long
    //   138	70	5	localObject	Object
    //   9	217	6	localFlagshipCacheManager	com.linkedin.android.infra.data.FlagshipCacheManager
    //   20	208	7	localI18NManager	com.linkedin.android.infra.network.I18NManager
    //   31	199	8	localMediaCenter	com.linkedin.android.infra.network.MediaCenter
    //   42	182	9	localIntentRegistry	com.linkedin.android.infra.IntentRegistry
    //   53	179	10	localLixManager	LixManager
    //   79	143	11	localNotificationPayload	com.linkedin.android.l2m.notification.NotificationPayload
    // Exception table:
    //   from	to	target	type
    //   68	81	190	org/json/JSONException
    //   87	140	190	org/json/JSONException
    //   182	189	190	org/json/JSONException
    //   207	214	190	org/json/JSONException
    //   214	251	190	org/json/JSONException
    //   257	263	190	org/json/JSONException
    //   263	265	190	org/json/JSONException
    //   142	157	252	finally
    //   165	173	252	finally
  }
  
  public void onReceive(final Context paramContext, final Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("notificationPayload");
    if (paramIntent == null)
    {
      Log.d(TAG, "Does not contain notificationPayload");
      return;
    }
    paramContext = (FlagshipApplication)paramContext.getApplicationContext();
    if ("enabled".equals(paramContext.getAppComponent().lixManager().getTreatment(Lix.MESSAGING_ENABLE_ASYNC_NOTIFICATION_BUILDING)))
    {
      paramContext.getAppComponent().executorService().submit(new Runnable()
      {
        public final void run()
        {
          MessagingNotificationReceiver.showNotification(paramContext, paramIntent);
        }
      });
      return;
    }
    showNotification(paramContext, paramIntent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.MessagingNotificationReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */