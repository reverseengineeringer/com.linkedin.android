package com.crashlytics.android.core;

final class LogFileManager$NoopLogStore
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

/* Location:
 * Qualified Name:     com.crashlytics.android.core.LogFileManager.NoopLogStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */