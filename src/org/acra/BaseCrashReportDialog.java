package org.acra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import org.acra.log.ACRALog;

public abstract class BaseCrashReportDialog
  extends Activity
{
  String mReportFileName;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ACRA.log.d(ACRA.LOG_TAG, "CrashReportDialog extras=" + getIntent().getExtras());
    if (getIntent().getBooleanExtra("FORCE_CANCEL", false))
    {
      ACRA.log.d(ACRA.LOG_TAG, "Forced reports deletion.");
      ACRA.getErrorReporter().deletePendingNonApprovedReports(false);
      finish();
    }
    do
    {
      return;
      mReportFileName = getIntent().getStringExtra("REPORT_FILE_NAME");
      ACRA.log.d(ACRA.LOG_TAG, "Opening CrashReportDialog for " + mReportFileName);
    } while (mReportFileName != null);
    finish();
  }
}

/* Location:
 * Qualified Name:     org.acra.BaseCrashReportDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */