package org.acra.sender;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.ACRAConstants;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;

public final class EmailIntentSender
  implements ReportSender
{
  private final Context mContext;
  
  public EmailIntentSender(Context paramContext)
  {
    mContext = paramContext;
  }
  
  private static String buildBody(CrashReportData paramCrashReportData)
  {
    Object localObject2 = ACRA.getConfig().customReportContent();
    Object localObject1 = localObject2;
    if (localObject2.length == 0) {
      localObject1 = ACRAConstants.DEFAULT_MAIL_REPORT_FIELDS;
    }
    localObject2 = new StringBuilder();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject3 = localObject1[i];
      ((StringBuilder)localObject2).append(((ReportField)localObject3).toString()).append("=");
      ((StringBuilder)localObject2).append((String)paramCrashReportData.get(localObject3));
      ((StringBuilder)localObject2).append('\n');
      i += 1;
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  public final void send(Context paramContext, CrashReportData paramCrashReportData)
    throws ReportSenderException
  {
    paramContext = mContext.getPackageName() + " Crash Report";
    paramCrashReportData = buildBody(paramCrashReportData);
    Intent localIntent = new Intent("android.intent.action.SENDTO");
    localIntent.setData(Uri.fromParts("mailto", ACRA.getConfig().mailTo(), null));
    localIntent.addFlags(268435456);
    localIntent.putExtra("android.intent.extra.SUBJECT", paramContext);
    localIntent.putExtra("android.intent.extra.TEXT", paramCrashReportData);
    mContext.startActivity(localIntent);
  }
}

/* Location:
 * Qualified Name:     org.acra.sender.EmailIntentSender
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */