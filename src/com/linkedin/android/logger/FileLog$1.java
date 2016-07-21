package com.linkedin.android.logger;

import java.io.File;
import java.io.FilenameFilter;

final class FileLog$1
  implements FilenameFilter
{
  public final boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".log");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.logger.FileLog.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */