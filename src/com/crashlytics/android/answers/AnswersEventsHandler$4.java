package com.crashlytics.android.answers;

import android.os.Build.VERSION;
import android.os.Looper;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.AdvertisingInfo;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;
import io.fabric.sdk.android.services.events.EventsStorage;
import io.fabric.sdk.android.services.events.GZIPQueueFileEventStorage;
import io.fabric.sdk.android.services.persistence.FileStore;
import java.io.File;
import java.util.Map;
import java.util.UUID;

final class AnswersEventsHandler$4
  implements Runnable
{
  AnswersEventsHandler$4(AnswersEventsHandler paramAnswersEventsHandler) {}
  
  public final void run()
  {
    try
    {
      localObject3 = this$0.metadataCollector;
      Object localObject6 = idManager.getDeviceIdentifiers();
      localObject4 = idManager.appIdentifier;
      localObject5 = idManager.getAppInstallIdentifier();
      String str1 = (String)((Map)localObject6).get(IdManager.DeviceIdentifierType.ANDROID_ID);
      String str2 = (String)((Map)localObject6).get(IdManager.DeviceIdentifierType.ANDROID_ADVERTISING_ID);
      Object localObject7 = idManager;
      localObject2 = null;
      Object localObject1 = localObject2;
      if (collectHardwareIds)
      {
        localObject7 = ((IdManager)localObject7).getAdvertisingInfo();
        localObject1 = localObject2;
        if (localObject7 != null) {
          localObject1 = Boolean.valueOf(limitAdTrackingEnabled);
        }
      }
      localObject2 = (String)((Map)localObject6).get(IdManager.DeviceIdentifierType.FONT_TOKEN);
      localObject6 = CommonUtils.resolveBuildId(context);
      localObject7 = IdManager.removeForwardSlashesIn(Build.VERSION.RELEASE) + "/" + IdManager.removeForwardSlashesIn(Build.VERSION.INCREMENTAL);
      String str3 = IdManager.getModelName();
      localObject1 = new SessionEventMetadata((String)localObject4, UUID.randomUUID().toString(), (String)localObject5, str1, str2, (Boolean)localObject1, (String)localObject2, (String)localObject6, (String)localObject7, str3, versionCode, versionName);
      localObject2 = this$0.filesManagerProvider;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
      }
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("Answers", "Failed to enable events", localException);
      return;
    }
    Object localObject3 = new SessionEventTransform();
    Object localObject4 = new SystemCurrentTimeProvider();
    Object localObject5 = fileStore.getFilesDir();
    localObject5 = new GZIPQueueFileEventStorage(context, (File)localObject5, "session_analytics.tap", "session_analytics_to_send");
    Object localObject2 = new SessionAnalyticsFilesManager(context, (SessionEventTransform)localObject3, (CurrentTimeProvider)localObject4, (EventsStorage)localObject5);
    ((SessionAnalyticsFilesManager)localObject2).registerRollOverListener(this$0);
    this$0.strategy = new EnabledSessionAnalyticsManagerStrategy(this$0.kit, this$0.context, this$0.executor, (SessionAnalyticsFilesManager)localObject2, this$0.requestFactory, localException);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersEventsHandler.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */