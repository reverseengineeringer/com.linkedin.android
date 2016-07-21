package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.Settings.LazyHolder;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.File;

final class CrashlyticsUncaughtExceptionHandler$SendSessionRunnable
  implements Runnable
{
  private final CrashlyticsCore crashlyticsCore;
  private final File fileToSend;
  
  public CrashlyticsUncaughtExceptionHandler$SendSessionRunnable(CrashlyticsCore paramCrashlyticsCore, File paramFile)
  {
    crashlyticsCore = paramCrashlyticsCore;
    fileToSend = paramFile;
  }
  
  public final void run()
  {
    if (!CommonUtils.canTryConnection(crashlyticsCore.context)) {}
    Object localObject;
    do
    {
      return;
      Fabric.getLogger().d("CrashlyticsCore", "Attempting to send crash report at time of crash...");
      localObject = Settings.LazyHolder.access$100().awaitSettingsData();
      localObject = crashlyticsCore.getCreateReportSpiCall((SettingsData)localObject);
    } while (localObject == null);
    new ReportUploader((CreateReportSpiCall)localObject).forceUpload(new SessionReport(fileToSend, CrashlyticsUncaughtExceptionHandler.access$1300()));
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.SendSessionRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */