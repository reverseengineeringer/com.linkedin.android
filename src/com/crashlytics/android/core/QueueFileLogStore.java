package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.QueueFile;
import io.fabric.sdk.android.services.common.QueueFile.ElementReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

final class QueueFileLogStore
  implements FileLogStore
{
  private QueueFile logFile;
  private final int maxLogSize;
  private final File workingFile;
  
  public QueueFileLogStore(File paramFile)
  {
    workingFile = paramFile;
    maxLogSize = 65536;
  }
  
  private void openLogFile()
  {
    if (logFile == null) {}
    try
    {
      logFile = new QueueFile(workingFile);
      return;
    }
    catch (IOException localIOException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Could not open log file: " + workingFile, localIOException);
    }
  }
  
  public final void closeLogFile()
  {
    CommonUtils.closeOrLog(logFile, "There was a problem closing the Crashlytics log file.");
    logFile = null;
  }
  
  public final void deleteLogFile()
  {
    closeLogFile();
    workingFile.delete();
  }
  
  public final ByteString getLogAsByteString()
  {
    if (!workingFile.exists()) {}
    do
    {
      return null;
      openLogFile();
    } while (logFile == null);
    final int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 0;
    final byte[] arrayOfByte = new byte[logFile.usedBytes()];
    try
    {
      logFile.forEach(new QueueFile.ElementReader()
      {
        public final void read(InputStream paramAnonymousInputStream, int paramAnonymousInt)
          throws IOException
        {
          try
          {
            paramAnonymousInputStream.read(arrayOfByte, arrayOfInt[0], paramAnonymousInt);
            int[] arrayOfInt = arrayOfInt;
            arrayOfInt[0] += paramAnonymousInt;
            return;
          }
          finally
          {
            paramAnonymousInputStream.close();
          }
        }
      });
      return ByteString.copyFrom$3d5b0678(arrayOfByte, arrayOfInt[0]);
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Fabric.getLogger().e("CrashlyticsCore", "A problem occurred while reading the Crashlytics log file.", localIOException);
      }
    }
  }
  
  public final void writeToLog(long paramLong, String paramString)
  {
    openLogFile();
    if (logFile != null)
    {
      if (paramString != null) {
        break label171;
      }
      paramString = "null";
    }
    label171:
    for (;;)
    {
      try
      {
        int i = maxLogSize / 4;
        String str = paramString;
        if (paramString.length() > i) {
          str = "..." + paramString.substring(paramString.length() - i);
        }
        paramString = str.replaceAll("\r", " ").replaceAll("\n", " ");
        paramString = String.format(Locale.US, "%d %s%n", new Object[] { Long.valueOf(paramLong), paramString }).getBytes("UTF-8");
        logFile.add$1cf967a4(paramString, paramString.length);
        if ((!logFile.isEmpty()) && (logFile.usedBytes() > maxLogSize)) {
          logFile.remove();
        } else {
          return;
        }
      }
      catch (IOException paramString)
      {
        Fabric.getLogger().e("CrashlyticsCore", "There was a problem writing to the Crashlytics log.", paramString);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.QueueFileLogStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */