package com.google.android.exoplayer.util;

import android.os.Trace;

public final class TraceUtil
{
  public static void beginSection(String paramString)
  {
    if (Util.SDK_INT >= 18) {
      Trace.beginSection(paramString);
    }
  }
  
  public static void endSection()
  {
    if (Util.SDK_INT >= 18) {
      Trace.endSection();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.TraceUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */