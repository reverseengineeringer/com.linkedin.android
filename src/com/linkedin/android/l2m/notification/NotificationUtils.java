package com.linkedin.android.l2m.notification;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationUtils
{
  static final String TAG = NotificationUtils.class.getSimpleName();
  FlagshipDataManager dataManager;
  private String deregisterRoute;
  String registerRoute;
  public FlagshipSharedPreferences sharedPreferences;
  Tracker tracker;
  
  @Inject
  public NotificationUtils(FlagshipDataManager paramFlagshipDataManager, FlagshipSharedPreferences paramFlagshipSharedPreferences, Tracker paramTracker)
  {
    dataManager = paramFlagshipDataManager;
    sharedPreferences = paramFlagshipSharedPreferences;
    tracker = paramTracker;
    registerRoute = Routes.PUSH_REGISTRATION.buildUponRoot().buildUpon().appendQueryParameter("action", "register").build().toString();
    deregisterRoute = Routes.PUSH_REGISTRATION.buildUponRoot().buildUpon().appendQueryParameter("action", "deregister").build().toString();
  }
  
  static JsonModel getPostBody(String paramString)
  {
    try
    {
      paramString = new JSONArray("[\"" + paramString + "\"]");
      paramString = new JSONObject().put("pushNotificationTokens", paramString);
      paramString.put("pushNotificationEnabled", true);
      paramString = new JsonModel(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      Util.safeThrow(new RuntimeException(paramString));
    }
    return null;
  }
  
  public static void registerNotification(Context paramContext)
  {
    paramContext.startService(new Intent(paramContext, RegistrationIntentService.class));
  }
  
  public final void sendTokenForDeregister(String paramString, RecordTemplateListener<JsonModel> paramRecordTemplateListener)
  {
    paramString = getPostBody(paramString);
    if (paramString != null) {
      dataManager.submit(Request.post().url(deregisterRoute).customHeaders(Tracker.createPageInstanceHeader(tracker.generateBackgroundPageInstance())).model(paramString).listener(paramRecordTemplateListener).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.NotificationUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */