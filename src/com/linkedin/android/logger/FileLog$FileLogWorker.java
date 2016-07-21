package com.linkedin.android.logger;

import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.logging.LogRecord;

final class FileLog$FileLogWorker
  extends Thread
{
  boolean isRunning;
  
  public final void run()
  {
    isRunning = true;
    try
    {
      while (isRunning) {
        if (FileLog.access$200() != null) {
          FileLog.access$300((LogRecord)FileLog.access$200().take());
        }
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Log.d(FileLog.access$400(), "Interrupted when running", localInterruptedException);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.logger.FileLog.FileLogWorker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */