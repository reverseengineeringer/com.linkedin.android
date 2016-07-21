package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.io.File;
import java.io.FilenameFilter;

final class CrashlyticsUncaughtExceptionHandler$12
  implements Runnable
{
  CrashlyticsUncaughtExceptionHandler$12(CrashlyticsUncaughtExceptionHandler paramCrashlyticsUncaughtExceptionHandler) {}
  
  public final void run()
  {
    CrashlyticsUncaughtExceptionHandler localCrashlyticsUncaughtExceptionHandler = this$0;
    File[] arrayOfFile = CrashlyticsUncaughtExceptionHandler.access$1200(this$0, ClsFileOutputStream.TEMP_FILENAME_FILTER);
    Object localObject1 = new File(crashlyticsCore.getSdkDirectory(), "invalidClsFiles");
    Object localObject2;
    int j;
    if (((File)localObject1).exists())
    {
      if (((File)localObject1).isDirectory())
      {
        localObject2 = ((File)localObject1).listFiles();
        j = localObject2.length;
        i = 0;
        while (i < j)
        {
          localObject2[i].delete();
          i += 1;
        }
      }
      ((File)localObject1).delete();
    }
    int k = arrayOfFile.length;
    int i = 0;
    while (i < k)
    {
      localObject1 = arrayOfFile[i];
      Fabric.getLogger().d("CrashlyticsCore", "Found invalid session part file: " + localObject1);
      localObject1 = CrashlyticsUncaughtExceptionHandler.getSessionIdFromSessionFile((File)localObject1);
      localObject2 = new CrashlyticsUncaughtExceptionHandler.13(localCrashlyticsUncaughtExceptionHandler, (String)localObject1);
      Fabric.getLogger().d("CrashlyticsCore", "Deleting all part files for invalid session: " + (String)localObject1);
      localObject1 = localCrashlyticsUncaughtExceptionHandler.listFilesMatching((FilenameFilter)localObject2);
      int m = localObject1.length;
      j = 0;
      while (j < m)
      {
        localObject2 = localObject1[j];
        Fabric.getLogger().d("CrashlyticsCore", "Deleting session file: " + localObject2);
        ((File)localObject2).delete();
        j += 1;
      }
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsUncaughtExceptionHandler.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */