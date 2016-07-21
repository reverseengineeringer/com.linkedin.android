package org.acra;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.acra.collector.CrashReportData;
import org.acra.log.ACRALog;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

final class SendWorker
  extends Thread
{
  private final boolean approvePendingReports;
  private final Context context;
  private final CrashReportFileNameParser fileNameParser = new CrashReportFileNameParser();
  private final List<ReportSender> reportSenders;
  private final boolean sendOnlySilentReports;
  
  public SendWorker(Context paramContext, List<ReportSender> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    context = paramContext;
    reportSenders = paramList;
    sendOnlySilentReports = paramBoolean1;
    approvePendingReports = paramBoolean2;
  }
  
  private void checkAndSendReports(Context paramContext, boolean paramBoolean)
  {
    ACRA.log.d(ACRA.LOG_TAG, "#checkAndSendReports - start");
    String[] arrayOfString = new CrashReportFinder(paramContext).getCrashReportFiles();
    Arrays.sort(arrayOfString);
    int j = 0;
    int m = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      String str;
      int k;
      if (i < m)
      {
        str = arrayOfString[i];
        if (paramBoolean)
        {
          k = j;
          if (!str.contains(ACRAConstants.SILENT_SUFFIX)) {}
        }
        else
        {
          if (j >= 5) {
            break label187;
          }
          ACRA.log.i(ACRA.LOG_TAG, "Sending file " + str);
        }
      }
      try
      {
        sendCrashReport(new CrashReportPersister(paramContext).load(str));
        deleteFile(paramContext, str);
        k = j + 1;
        i += 1;
        j = k;
      }
      catch (RuntimeException localRuntimeException)
      {
        ACRA.log.e(ACRA.LOG_TAG, "Failed to send crash reports for " + str, localRuntimeException);
        deleteFile(paramContext, str);
        ACRA.log.d(ACRA.LOG_TAG, "#checkAndSendReports - finish");
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ACRA.log.e(ACRA.LOG_TAG, "Failed to load crash report for " + str, localIOException);
          deleteFile(paramContext, str);
        }
      }
      catch (ReportSenderException localReportSenderException)
      {
        for (;;)
        {
          label187:
          ACRA.log.e(ACRA.LOG_TAG, "Failed to send crash report for " + str, localReportSenderException);
        }
      }
    }
  }
  
  private static void deleteFile(Context paramContext, String paramString)
  {
    if (!paramContext.deleteFile(paramString)) {
      ACRA.log.w(ACRA.LOG_TAG, "Could not delete error report : " + paramString);
    }
  }
  
  private void sendCrashReport(CrashReportData paramCrashReportData)
    throws ReportSenderException
  {
    if ((!ACRA.isDebuggable()) || (ACRA.getConfig().sendReportsInDevMode()))
    {
      int i = 0;
      Object localObject = null;
      String str = null;
      Iterator localIterator = reportSenders.iterator();
      while (localIterator.hasNext())
      {
        ReportSender localReportSender = (ReportSender)localIterator.next();
        try
        {
          ACRA.log.d(ACRA.LOG_TAG, "Sending report using " + localReportSender.getClass().getName());
          localReportSender.send(context, paramCrashReportData);
          ACRA.log.d(ACRA.LOG_TAG, "Sent report using " + localReportSender.getClass().getName());
          i = 1;
        }
        catch (ReportSenderException localReportSenderException)
        {
          str = localReportSender.getClass().getName();
        }
      }
      if (localReportSenderException != null)
      {
        if (i == 0) {
          throw localReportSenderException;
        }
        ACRA.log.w(ACRA.LOG_TAG, "ReportSender of class " + str + " failed but other senders completed their task. ACRA will not send this report again.");
      }
    }
  }
  
  public final void run()
  {
    if (approvePendingReports)
    {
      ACRA.log.d(ACRA.LOG_TAG, "Mark all pending reports as approved.");
      String[] arrayOfString = new CrashReportFinder(context).getCrashReportFiles();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfString[i];
        if (!CrashReportFileNameParser.isApproved((String)localObject))
        {
          File localFile = new File(context.getFilesDir(), (String)localObject);
          localObject = ((String)localObject).replace(".stacktrace", "-approved.stacktrace");
          localObject = new File(context.getFilesDir(), (String)localObject);
          if (!localFile.renameTo((File)localObject)) {
            ACRA.log.e(ACRA.LOG_TAG, "Could not rename approved report from " + localFile + " to " + localObject);
          }
        }
        i += 1;
      }
    }
    checkAndSendReports(context, sendOnlySilentReports);
  }
}

/* Location:
 * Qualified Name:     org.acra.SendWorker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */