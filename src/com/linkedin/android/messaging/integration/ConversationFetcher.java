package com.linkedin.android.messaging.integration;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.app.Fragment;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponseBuilder;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.voyager.messaging.Conversation;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreate;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreateResponse;
import com.linkedin.messengerlib.MessengerLibApi.ConversationSetAttributeStateResponse;
import com.linkedin.messengerlib.MessengerLibApi.SendMessageResponse;
import com.linkedin.messengerlib.MessengerRecordTemplateListener;
import org.json.JSONException;
import org.json.JSONObject;

public class ConversationFetcher
{
  static final String TAG = ConversationFetcher.class.getSimpleName();
  final MessagingRequestTracking requestTracking;
  
  public ConversationFetcher(MessagingRequestTracking paramMessagingRequestTracking)
  {
    requestTracking = paramMessagingRequestTracking;
  }
  
  public final void getConversation(FragmentComponent paramFragmentComponent, RecordTemplateListener<Conversation> paramRecordTemplateListener, String paramString)
  {
    paramString = Routes.MESSAGING_ROOT.buildUponRoot().buildUpon().appendPath("conversations").appendPath(paramString).build().toString();
    Fragment localFragment = paramFragmentComponent.fragment();
    if (localFragment != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramRecordTemplateListener = new MessengerRecordTemplateListener(paramRecordTemplateListener, localFragment, bool);
      paramRecordTemplateListener = Request.get().url(paramString).builder(Conversation.BUILDER).listener(paramRecordTemplateListener).filter(DataManager.DataStoreFilter.NETWORK_ONLY).shouldUpdateCache(false);
      paramRecordTemplateListener.customHeaders(requestTracking.pageInstanceHeader);
      paramFragmentComponent.dataManager().submit(paramRecordTemplateListener);
      return;
    }
  }
  
  final void performPartialUpdateOnConversation(FragmentComponent paramFragmentComponent, String paramString, JSONObject paramJSONObject, MessengerLibApi.ConversationSetAttributeStateResponse paramConversationSetAttributeStateResponse)
  {
    paramString = Routes.MESSAGING_ROOT.buildUponRoot().buildUpon().appendPath("conversations").appendPath(paramString).build().toString();
    Object localObject = new ConversationFetcher.6(this, paramConversationSetAttributeStateResponse);
    Fragment localFragment = paramFragmentComponent.fragment();
    paramConversationSetAttributeStateResponse = RUMHelper.pageInit(requestTracking.pageKey);
    if (localFragment != null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new MessagingModelRumListenerWrapper(paramConversationSetAttributeStateResponse, new MessengerRecordTemplateListener((RecordTemplateListener)localObject, localFragment, bool));
      paramString = Request.post().url(paramString).model(new JsonModel(paramJSONObject)).listener((RecordTemplateListener)localObject).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      paramString.trackingSessionId(paramConversationSetAttributeStateResponse);
      paramString.customHeaders(requestTracking.pageInstanceHeader);
      paramFragmentComponent.dataManager().submit(paramString);
      return;
    }
  }
  
  public final void sendMessageGeneral(FragmentComponent paramFragmentComponent, FlagshipDataManager paramFlagshipDataManager, String paramString1, EventCreate paramEventCreate, MessengerLibApi.SendMessageResponse paramSendMessageResponse, String paramString2)
  {
    paramString1 = Routes.MESSAGING.buildUponRoot().buildUpon().appendPath(paramString1).appendPath("events").appendQueryParameter("action", "create").toString();
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("eventCreate", PegasusPatchGenerator.modelToJSON(paramEventCreate));
        paramEventCreate = new ConversationFetcher.13(this, paramSendMessageResponse);
        if (paramFragmentComponent == null)
        {
          paramFragmentComponent = null;
          if (paramFragmentComponent == null) {
            break label182;
          }
          bool = true;
          paramFragmentComponent = new MessagingModelRumListenerWrapper(paramString2, new MessengerRecordTemplateListener(paramEventCreate, paramFragmentComponent, bool));
          paramFragmentComponent = Request.post().url(paramString1).model(new JsonModel(localJSONObject)).builder(new ActionResponseBuilder(EventCreateResponse.BUILDER)).listener(paramFragmentComponent).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
          paramFragmentComponent.trackingSessionId(paramString2);
          paramFragmentComponent.customHeaders(requestTracking.pageInstanceHeader);
          paramFlagshipDataManager.submit(paramFragmentComponent);
          return;
        }
      }
      catch (JSONException paramFragmentComponent)
      {
        paramFragmentComponent.printStackTrace();
        return;
      }
      paramFragmentComponent = paramFragmentComponent.fragment();
      continue;
      label182:
      boolean bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.integration.ConversationFetcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */