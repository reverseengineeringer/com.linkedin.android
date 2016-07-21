package com.linkedin.android.messaging.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.RemoteInput;
import android.support.v4.app.RemoteInput.Builder;
import android.widget.Toast;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipCacheManager;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.l2m.notification.NotificationCacheUtils;
import com.linkedin.android.l2m.notification.NotificationDisplayUtils;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.messaging.integration.ConversationFetcher;
import com.linkedin.android.messaging.integration.MessagingRequestTracking;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreateResponse;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.gen.avro2pegasus.events.MessageType;
import com.linkedin.gen.avro2pegasus.events.messages.MessageActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.messages.MessageId;
import com.linkedin.gen.avro2pegasus.events.messages.MessageId.Builder;
import com.linkedin.gen.avro2pegasus.events.messages.actionType;
import com.linkedin.messengerlib.MessengerLibApi.SendMessageResponse;
import com.linkedin.messengerlib.consumers.DataManager;
import com.linkedin.messengerlib.event.PendingEvent;
import com.linkedin.messengerlib.event.PendingEvent.Factory;
import com.linkedin.messengerlib.utils.I18NManager;
import com.linkedin.messengerlib.utils.MessageSenderUtil;
import java.io.IOException;
import java.util.Collections;
import java.util.UUID;

public class ReplyIntentService
  extends IntentService
{
  private static final String TAG = ReplyIntentService.class.getSimpleName();
  private ApplicationComponent appComponent;
  private FlagshipCacheManager cacheManager;
  private FlagshipDataManager dataManager;
  private Handler handler = new Handler(Looper.getMainLooper());
  private I18NManager i18NManager;
  private MemberUtil memberUtil;
  private DataManager messagingDataManager;
  private FlagshipSharedPreferences sharedPreferences;
  private Tracker tracker;
  
  public ReplyIntentService()
  {
    super(TAG);
  }
  
  public static Intent buildIntent(Context paramContext, Bundle paramBundle, String paramString)
  {
    paramBundle.putString("notification_type", paramString);
    paramContext = new Intent(paramContext, ReplyIntentService.class);
    paramContext.putExtra("reply_Key", paramBundle);
    return paramContext;
  }
  
  public static RemoteInput buildRemoteInput(String paramString)
  {
    RemoteInput.Builder localBuilder = new RemoteInput.Builder("key_text_reply");
    mLabel = paramString;
    return new RemoteInput(mResultKey, mLabel, mChoices, mAllowFreeFormInput, mExtras, (byte)0);
  }
  
  public void onCreate()
  {
    super.onCreate();
    appComponent = ((FlagshipApplication)getApplicationContext()).getAppComponent();
    dataManager = appComponent.dataManager();
    cacheManager = appComponent.flagshipCacheManager();
    memberUtil = appComponent.memberUtil();
    sharedPreferences = appComponent.flagshipSharedPreferences();
    i18NManager = new I18NManager(getApplicationContext());
    messagingDataManager = new DataManager(getApplicationContext(), i18NManager);
    tracker = appComponent.tracker();
  }
  
  protected void onHandleIntent(final Intent paramIntent)
  {
    final Object localObject1 = null;
    final Object localObject2 = paramIntent.getBundleExtra("reply_Key");
    Object localObject3 = RemoteInput.getResultsFromIntent(paramIntent);
    paramIntent = (Intent)localObject1;
    if (localObject3 != null) {
      paramIntent = ((Bundle)localObject3).getCharSequence("key_text_reply");
    }
    localObject3 = (Uri)((Bundle)localObject2).getParcelable("uri");
    int i;
    if (localObject2 == null) {
      i = -1;
    }
    for (;;)
    {
      localObject1 = "push_notification_inline_reply_" + ((Bundle)localObject2).getString("notification_type");
      localObject1 = new PageInstance(tracker, (String)localObject1, UUID.randomUUID());
      appComponent.notificationDisplayUtils().cancel(i);
      NotificationCacheUtils.deleteNotificationFromCache(cacheManager, i);
      try
      {
        localObject2 = new MessageId.Builder().setFlockMessageUrn(((Bundle)localObject2).getString("push_flock_message_urn")).setDeliveryId(sharedPreferences.getNotificationToken()).setExternalIds(Collections.emptyList()).build();
        handler.post(new Runnable()
        {
          public final void run()
          {
            tracker.send(new MessageActionEvent.Builder().setActionType(actionType.TAP).setMessageType(MessageType.PUSHNOTIFICATION).setMessageId(localObject2), localObject1);
          }
        });
        if ((localObject3 == null) || (paramIntent == null)) {}
      }
      catch (BuilderException localBuilderException)
      {
        for (;;)
        {
          try
          {
            localObject2 = ((Uri)localObject3).getLastPathSegment();
            paramIntent = PendingEvent.Factory.newMessageEvent(null, paramIntent.toString(), null);
            localObject1 = new MessagingRequestTracking((PageInstance)localObject1, "messaging");
            localObject3 = new ConversationFetcher((MessagingRequestTracking)localObject1);
            try
            {
              ((ConversationFetcher)localObject3).sendMessageGeneral(null, dataManager, (String)localObject2, paramIntent.newEventCreate(), new MessengerLibApi.SendMessageResponse()
              {
                public final void onError(Exception paramAnonymousException)
                {
                  Log.e(ReplyIntentService.TAG, "Error sending a reply");
                  paramAnonymousException = i18NManager.getString(2131233482);
                  Toast.makeText(getApplicationContext(), paramAnonymousException, 0).show();
                }
                
                public final void onResponse(EventCreateResponse paramAnonymousEventCreateResponse)
                {
                  MessageSenderUtil.saveConversationToDb(paramIntent, paramAnonymousEventCreateResponse, memberUtil.getMiniProfile(), null, messagingDataManager.conversationDataManager);
                  paramAnonymousEventCreateResponse = i18NManager.getString(2131233483);
                  Toast.makeText(getApplicationContext(), paramAnonymousEventCreateResponse, 0).show();
                }
              }, RUMHelper.pageInit(pageKey));
              return;
            }
            catch (IOException paramIntent)
            {
              Log.e(TAG, "Failed to create a new event.");
              return;
            }
            i = ((Bundle)localObject2).getInt("notificationId");
          }
          catch (BuilderException paramIntent)
          {
            Log.e(TAG, "Failed to build a new message.");
          }
          localBuilderException = localBuilderException;
          Log.e(TAG, "Failed to build a new messageId.");
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.service.ReplyIntentService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */