package com.linkedin.android.logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

final class FileLog$LogFormat
  extends Formatter
{
  private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss Z", Locale.US);
  
  public final String format(LogRecord paramLogRecord)
  {
    return simpleDateFormat.format(new Date()) + ": " + paramLogRecord.getMessage() + "\n";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.logger.FileLog.LogFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */