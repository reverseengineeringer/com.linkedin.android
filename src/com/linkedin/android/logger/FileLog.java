package com.linkedin.android.logger;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class FileLog
{
  private static final LogFormat LOG_FORMAT;
  private static final String TAG = FileLog.class.getSimpleName();
  private static volatile FileLogWorker fileLogWorker;
  private static volatile boolean fileLoggingEnabled;
  private static volatile BlockingQueue<LogRecord> itemsToLog;
  private static String logDirectory;
  private static FileHandler logFile = null;
  private static String logFilenamePrefix;
  private static int maximumFileSize = 1048576;
  private static int maximumNumberOfFiles = 5;
  
  static
  {
    LOG_FORMAT = new LogFormat((byte)0);
    logDirectory = null;
    logFilenamePrefix = null;
  }
  
  public static void enableFileLogging(Context paramContext, boolean paramBoolean)
  {
    if (fileLoggingEnabled == paramBoolean) {
      return;
    }
    if (fileLogWorker != null)
    {
      localObject = fileLogWorker;
      isRunning = false;
      ((FileLogWorker)localObject).interrupt();
      fileLogWorker = null;
    }
    Object localObject = paramContext.getFilesDir();
    if (localObject == null)
    {
      localObject = null;
      label42:
      if (localObject == null) {
        paramBoolean = false;
      }
      if (!paramBoolean) {
        break label168;
      }
      logFilenamePrefix = getApplicationInfoname;
      logDirectory = (String)localObject + "/" + logFilenamePrefix;
    }
    for (;;)
    {
      if (itemsToLog != null) {
        itemsToLog.clear();
      }
      if (!paramBoolean) {
        break;
      }
      fileLoggingEnabled = paramBoolean;
      itemsToLog = new ArrayBlockingQueue(20);
      paramContext = new FileLogWorker((byte)0);
      fileLogWorker = paramContext;
      paramContext.start();
      return;
      localObject = ((File)localObject).getAbsolutePath() + "/logs";
      break label42;
      label168:
      if (logFile != null)
      {
        logFile.close();
        logFile = null;
      }
    }
  }
  
  public static File getLastLogFile()
  {
    Object localObject2 = null;
    int i = 0;
    Object localObject1 = new File(logDirectory);
    if (!((File)localObject1).isDirectory()) {}
    File[] arrayOfFile;
    do
    {
      return (File)localObject2;
      arrayOfFile = ((File)localObject1).listFiles(new FilenameFilter()
      {
        public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          return paramAnonymousString.endsWith(".log");
        }
      });
    } while (arrayOfFile.length <= 0);
    localObject1 = arrayOfFile[0];
    int j = arrayOfFile.length;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= j) {
        break;
      }
      File localFile = arrayOfFile[i];
      localObject2 = localObject1;
      if (localFile.lastModified() > ((File)localObject1).lastModified()) {
        localObject2 = localFile;
      }
      i += 1;
      localObject1 = localObject2;
    }
  }
  
  public static boolean isEnabled()
  {
    return fileLoggingEnabled;
  }
  
  static void logToFile(String paramString1, String paramString2)
  {
    if ((fileLoggingEnabled) && (itemsToLog != null)) {}
    try
    {
      itemsToLog.put(new LogRecord(Level.ALL, paramString1 + ": " + paramString2));
      return;
    }
    catch (InterruptedException paramString1)
    {
      Log.e(TAG, "Exception when file logging", paramString1);
    }
  }
  
  private static final class FileLogWorker
    extends Thread
  {
    boolean isRunning;
    
    public final void run()
    {
      isRunning = true;
      try
      {
        while (isRunning) {
          if (FileLog.itemsToLog != null) {
            FileLog.access$300((LogRecord)FileLog.itemsToLog.take());
          }
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        Log.d(FileLog.TAG, "Interrupted when running", localInterruptedException);
      }
    }
  }
  
  private static final class LogFormat
    extends Formatter
  {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss Z", Locale.US);
    
    public final String format(LogRecord paramLogRecord)
    {
      return simpleDateFormat.format(new Date()) + ": " + paramLogRecord.getMessage() + "\n";
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.logger.FileLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */