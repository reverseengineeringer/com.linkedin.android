package com.linkedin.android.l2m.notification;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.JsonModel;

final class NotificationUtils$1
  implements RecordTemplateListener<JsonModel>
{
  NotificationUtils$1(NotificationUtils paramNotificationUtils, String paramString, int paramInt) {}
  
  public final void onResponse(DataStoreResponse<JsonModel> paramDataStoreResponse)
  {
    if (error == null)
    {
      paramDataStoreResponse = NotificationUtils.access$000(this$0);
      String str = val$token;
      paramDataStoreResponse.getPreferences().edit().putString("notificationToken", str).apply();
      paramDataStoreResponse = NotificationUtils.access$000(this$0);
      int i = val$newState;
      paramDataStoreResponse.getPreferences().edit().putInt("notificationTokenState", i).apply();
      Log.d(NotificationUtils.access$100(), "GCM Token sent successfully" + val$token);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.l2m.notification.NotificationUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */