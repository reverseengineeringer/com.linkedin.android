package org.acra;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.IOException;
import org.acra.collector.CrashReportData;
import org.acra.log.ACRALog;
import org.acra.util.ToastSender;

public class CrashReportDialog
  extends BaseCrashReportDialog
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener
{
  AlertDialog mDialog;
  private EditText userCommentView;
  private EditText userEmailView;
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject;
    String str;
    if (paramInt == -1)
    {
      label74:
      CrashReportPersister localCrashReportPersister;
      if (userCommentView != null)
      {
        paramDialogInterface = userCommentView.getText().toString();
        localObject = ACRA.getACRASharedPreferences();
        if (userEmailView == null) {
          break label242;
        }
        str = userEmailView.getText().toString();
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putString("acra.user.email", str);
        ((SharedPreferences.Editor)localObject).commit();
        localCrashReportPersister = new CrashReportPersister(getApplicationContext());
      }
      try
      {
        ACRA.log.d(ACRA.LOG_TAG, "Add user comment to " + mReportFileName);
        CrashReportData localCrashReportData = localCrashReportPersister.load(mReportFileName);
        ReportField localReportField = ReportField.USER_COMMENT;
        localObject = paramDialogInterface;
        if (paramDialogInterface == null) {
          localObject = "";
        }
        localCrashReportData.put(localReportField, localObject);
        localObject = ReportField.USER_EMAIL;
        paramDialogInterface = str;
        if (str == null) {
          paramDialogInterface = "";
        }
        localCrashReportData.put((Enum)localObject, paramDialogInterface);
        localCrashReportPersister.store(localCrashReportData, mReportFileName);
      }
      catch (IOException paramDialogInterface)
      {
        for (;;)
        {
          ACRA.log.w(ACRA.LOG_TAG, "User comment not added: ", paramDialogInterface);
        }
      }
      ACRA.log.v(ACRA.LOG_TAG, "About to start SenderWorker from CrashReportDialog");
      ACRA.getErrorReporter().startSendingReports(false, true);
      paramInt = ACRA.getConfig().resDialogOkToast();
      if (paramInt != 0) {
        ToastSender.sendToast$3047fd93(getApplicationContext(), paramInt);
      }
    }
    for (;;)
    {
      finish();
      return;
      paramDialogInterface = "";
      break;
      label242:
      str = ((SharedPreferences)localObject).getString("acra.user.email", "");
      break label74;
      ACRA.getErrorReporter().deletePendingNonApprovedReports(false);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    int i = ACRA.getConfig().resDialogTitle();
    if (i != 0) {
      localBuilder.setTitle(i);
    }
    i = ACRA.getConfig().resDialogIcon();
    if (i != 0) {
      localBuilder.setIcon(i);
    }
    LinearLayout localLinearLayout1 = new LinearLayout(this);
    localLinearLayout1.setOrientation(1);
    localLinearLayout1.setPadding(10, 10, 10, 10);
    localLinearLayout1.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    localLinearLayout1.setFocusable(true);
    localLinearLayout1.setFocusableInTouchMode(true);
    Object localObject = new ScrollView(this);
    localLinearLayout1.addView((View)localObject, new LinearLayout.LayoutParams(-1, -1, 1.0F));
    LinearLayout localLinearLayout2 = new LinearLayout(this);
    localLinearLayout2.setOrientation(1);
    ((ScrollView)localObject).addView(localLinearLayout2);
    localObject = new TextView(this);
    i = ACRA.getConfig().resDialogText();
    if (i != 0) {
      ((TextView)localObject).setText(getText(i));
    }
    localLinearLayout2.addView((View)localObject);
    i = ACRA.getConfig().resDialogCommentPrompt();
    if (i != 0)
    {
      localObject = new TextView(this);
      ((TextView)localObject).setText(getText(i));
      ((TextView)localObject).setPadding(((TextView)localObject).getPaddingLeft(), 10, ((TextView)localObject).getPaddingRight(), ((TextView)localObject).getPaddingBottom());
      localLinearLayout2.addView((View)localObject, new LinearLayout.LayoutParams(-1, -2));
      userCommentView = new EditText(this);
      userCommentView.setLines(2);
      if (paramBundle != null)
      {
        localObject = paramBundle.getString("comment");
        if (localObject != null) {
          userCommentView.setText((CharSequence)localObject);
        }
      }
      localLinearLayout2.addView(userCommentView);
    }
    i = ACRA.getConfig().resDialogEmailPrompt();
    if (i != 0)
    {
      localObject = new TextView(this);
      ((TextView)localObject).setText(getText(i));
      ((TextView)localObject).setPadding(((TextView)localObject).getPaddingLeft(), 10, ((TextView)localObject).getPaddingRight(), ((TextView)localObject).getPaddingBottom());
      localLinearLayout2.addView((View)localObject);
      userEmailView = new EditText(this);
      userEmailView.setSingleLine();
      userEmailView.setInputType(33);
      localObject = null;
      if (paramBundle != null) {
        localObject = paramBundle.getString("email");
      }
      if (localObject == null) {
        break label495;
      }
      userEmailView.setText((CharSequence)localObject);
    }
    for (;;)
    {
      localLinearLayout2.addView(userEmailView);
      localBuilder.setView(localLinearLayout1);
      localBuilder.setPositiveButton(getText(ACRA.getConfig().resDialogPositiveButtonText()), this);
      localBuilder.setNegativeButton(getText(ACRA.getConfig().resDialogNegativeButtonText()), this);
      mDialog = localBuilder.create();
      mDialog.setCanceledOnTouchOutside(false);
      mDialog.setOnDismissListener(this);
      mDialog.show();
      return;
      label495:
      paramBundle = ACRA.getACRASharedPreferences();
      userEmailView.setText(paramBundle.getString("acra.user.email", ""));
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    finish();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if ((userCommentView != null) && (userCommentView.getText() != null)) {
      paramBundle.putString("comment", userCommentView.getText().toString());
    }
    if ((userEmailView != null) && (userEmailView.getText() != null)) {
      paramBundle.putString("email", userEmailView.getText().toString());
    }
  }
}

/* Location:
 * Qualified Name:     org.acra.CrashReportDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */