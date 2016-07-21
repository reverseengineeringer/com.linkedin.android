package org.acra.sender;

import android.content.Context;
import org.acra.collector.CrashReportData;

public abstract interface ReportSender
{
  public abstract void send(Context paramContext, CrashReportData paramCrashReportData)
    throws ReportSenderException;
}

/* Location:
 * Qualified Name:     org.acra.sender.ReportSender
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */