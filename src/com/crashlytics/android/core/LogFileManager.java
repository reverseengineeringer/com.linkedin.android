package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.persistence.FileStore;
import java.io.File;
import java.util.Set;

final class LogFileManager
{
  private static final NoopLogStore NOOP_LOG_STORE = new NoopLogStore((byte)0);
  private final Context context;
  FileLogStore currentLog;
  private final FileStore fileStore;
  
  public LogFileManager(Context paramContext, FileStore paramFileStore)
  {
    this(paramContext, paramFileStore, null);
  }
  
  public LogFileManager(Context paramContext, FileStore paramFileStore, String paramString)
  {
    context = paramContext;
    fileStore = paramFileStore;
    currentLog = NOOP_LOG_STORE;
    setCurrentSession(paramString);
  }
  
  private File getLogFileDir()
  {
    File localFile = new File(fileStore.getFilesDir(), "log-files");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public final void clearLog()
  {
    currentLog.deleteLogFile();
  }
  
  public final void discardOldLogFiles(Set<String> paramSet)
  {
    File[] arrayOfFile = getLogFileDir().listFiles();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        String str = localFile.getName();
        int k = str.lastIndexOf(".temp");
        if (k == -1) {}
        for (;;)
        {
          if (!paramSet.contains(str)) {
            localFile.delete();
          }
          i += 1;
          break;
          str = str.substring(20, k);
        }
      }
    }
  }
  
  public final ByteString getByteStringForLog()
  {
    return currentLog.getLogAsByteString();
  }
  
  public final void setCurrentSession(String paramString)
  {
    currentLog.closeLogFile();
    currentLog = NOOP_LOG_STORE;
    if (paramString == null) {
      return;
    }
    if (!CommonUtils.getBooleanResourceValue(context, "com.crashlytics.CollectCustomLogs", true))
    {
      Fabric.getLogger().d("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
      return;
    }
    paramString = "crashlytics-userlog-" + paramString + ".temp";
    currentLog = new QueueFileLogStore(new File(getLogFileDir(), paramString));
  }
  
  private static final class NoopLogStore
    implements FileLogStore
  {
    public final void closeLogFile() {}
    
    public final void deleteLogFile() {}
    
    public final ByteString getLogAsByteString()
    {
      return null;
    }
    
    public final void writeToLog(long paramLong, String paramString) {}
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.LogFileManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */