package com.linkedin.android.l2m.notification;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import java.net.URISyntaxException;
import org.json.JSONException;
import org.json.JSONObject;

public class NotificationPayload
{
  private static final String TAG = NotificationPayload.class.getSimpleName();
  public final String actorName;
  public final String actorPictureLogo;
  public final String actorPictureUrl;
  public final String actorProfileId;
  public final String actorUrn;
  public final int badgeCount;
  public final String invitationCustomMessage;
  public final String invitationId;
  public final String invitationSharedKey;
  public final String memberUrn;
  public final String notificationType;
  public final String notificationUrn;
  public final String silentPush;
  public final String toastLabel;
  public final String uniqueId;
  public final String uri;
  public final String userVisible;
  
  private NotificationPayload(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, int paramInt)
  {
    notificationUrn = paramString4;
    Uri localUri = Uri.parse(paramString5);
    if (localUri.getHost() != null)
    {
      paramString4 = paramString5;
      if (localUri.getScheme() != null) {}
    }
    else
    {
      paramString4 = new Uri.Builder().encodedPath(paramString5).scheme("https").authority("www.linkedin.com").build().toString();
    }
    uri = paramString4;
    actorUrn = paramString6;
    actorName = paramString7;
    actorPictureLogo = paramString8;
    actorPictureUrl = paramString9;
    memberUrn = paramString1;
    uniqueId = paramString2;
    notificationType = paramString3;
    toastLabel = paramString10;
    silentPush = paramString11;
    userVisible = paramString12;
    badgeCount = paramInt;
    invitationId = paramString13;
    invitationSharedKey = paramString14;
    actorProfileId = paramString15;
    invitationCustomMessage = paramString16;
  }
  
  public static boolean isValid(NotificationPayload paramNotificationPayload, String paramString, LixManager paramLixManager)
  {
    int j = 1;
    boolean bool1;
    if (paramNotificationPayload == null)
    {
      Log.e(TAG, "Failed to validate NotificationPayload: payload is null");
      CrashReporter.reportNonFatal(new Throwable("Failed to validate NotificationPayload: payload is null"));
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      if (paramString == null)
      {
        Log.e(TAG, "Failed to validate NotificationPayload: memberId is null");
        CrashReporter.reportNonFatal(new Throwable("Failed to validate NotificationPayload: memberId is null"));
        return false;
      }
      int i;
      if ((paramNotificationPayload.isUserVisible()) && (TextUtils.isEmpty(uri)))
      {
        i = 0;
        if (i == 0)
        {
          Log.e(TAG, "Failed to validate NotificationPayload: invalid for notificationType");
          CrashReporter.reportNonFatal(new Throwable("Failed to validate NotificationPayload: invalid for notificationType"));
          return false;
        }
      }
      else
      {
        String str = notificationType;
        i = -1;
        switch (str.hashCode())
        {
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            i = j;
            break;
          case 0: 
            i = j;
            if (!"enabled".equals(paramLixManager.getTreatment(Lix.LIX_INVITATION_NOTIFICATION_ACTION))) {
              break;
            }
            if ((!invitationId.isEmpty()) && (!invitationSharedKey.isEmpty()))
            {
              i = j;
              if (!actorProfileId.isEmpty()) {
                break;
              }
            }
            i = 0;
            break;
            if (str.equals("NewInvite"))
            {
              i = 0;
              continue;
              if (str.equals("AcceptInvite"))
              {
                i = 1;
                continue;
                if (str.equals("NewMessage")) {
                  i = 2;
                }
              }
            }
            break;
          }
        }
      }
      try
      {
        paramLixManager = new Urn(memberUrn).getId();
        boolean bool2 = paramLixManager.equals(paramString);
        bool1 = bool2;
        if (!bool2)
        {
          Log.e(TAG, String.format("Member id from payload (%s) does not match logged in member id (%s)", new Object[] { paramLixManager, paramString }));
          CrashReporter.reportNonFatal(new Throwable("Failed to validate NotificationPayload: memberId does not match"));
          return bool2;
        }
      }
      catch (URISyntaxException paramString)
      {
        Log.e(TAG, "Failed to validate NotificationPayload: failed to parse memberId from memberUrn: " + memberUrn, paramString);
        CrashReporter.reportNonFatal(new Throwable("Failed to validate NotificationPayload: failed to parse memberId from memberUrn"));
      }
    }
    return false;
  }
  
  public static NotificationPayload newInstance(Bundle paramBundle)
  {
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString("payload"); paramBundle == null; paramBundle = null)
    {
      Log.e(TAG, "Failed to parse NotificationPayload: payload is null");
      CrashReporter.reportNonFatal(new Throwable("Failed to parse NotificationPayload: payload is null"));
      return null;
    }
    Log.i(TAG, "Notification payload is: " + paramBundle);
    try
    {
      NotificationPayload localNotificationPayload = newInstance(new JSONObject(paramBundle));
      return localNotificationPayload;
    }
    catch (JSONException localJSONException)
    {
      Log.e(TAG, "Can't get NotificationPayload instance with json: " + paramBundle, localJSONException);
      CrashReporter.reportNonFatal(new Throwable("Failed to parse NotificationPayload", localJSONException));
    }
    return null;
  }
  
  public static NotificationPayload newInstance(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = new NotificationPayload(paramJSONObject.getString("mu"), paramJSONObject.getString("u"), paramJSONObject.getString("nt"), paramJSONObject.optString("nid"), paramJSONObject.optString("uri"), paramJSONObject.optString("au"), paramJSONObject.optString("an"), paramJSONObject.optString("apl"), paramJSONObject.optString("apu"), paramJSONObject.optString("t"), paramJSONObject.optString("s"), paramJSONObject.optString("v"), paramJSONObject.optString("iid"), paramJSONObject.optString("isk"), paramJSONObject.optString("pid"), paramJSONObject.optString("icm"), paramJSONObject.optInt("badge", -1));
      return paramJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      Log.e(TAG, "Can't get NotificationPayload instance with json", paramJSONObject);
    }
    return null;
  }
  
  public final boolean isUserVisible()
  {
    return !TextUtils.isEmpty(toastLabel);
  }
  
  public final JSONObject toJsonObject()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("nid", notificationUrn);
      localJSONObject.put("uri", uri);
      localJSONObject.put("au", actorUrn);
      localJSONObject.put("an", actorName);
      localJSONObject.put("apl", actorPictureLogo);
      localJSONObject.put("apu", actorPictureUrl);
      localJSONObject.put("mu", memberUrn);
      localJSONObject.put("u", uniqueId);
      localJSONObject.put("nt", notificationType);
      localJSONObject.put("t", toastLabel);
      localJSONObject.put("s", silentPush);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Log.e(TAG, "Can't build json object", localJSONException);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.NotificationPayload
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */