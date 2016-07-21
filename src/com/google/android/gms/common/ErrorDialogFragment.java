package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

@TargetApi(11)
public final class ErrorDialogFragment
  extends DialogFragment
{
  private Dialog mDialog = null;
  private DialogInterface.OnCancelListener zzafD = null;
  
  public static ErrorDialogFragment newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    ErrorDialogFragment localErrorDialogFragment = new ErrorDialogFragment();
    paramDialog = (Dialog)zzx.zzb(paramDialog, "Cannot display null dialog");
    paramDialog.setOnCancelListener(null);
    paramDialog.setOnDismissListener(null);
    mDialog = paramDialog;
    if (paramOnCancelListener != null) {
      zzafD = paramOnCancelListener;
    }
    return localErrorDialogFragment;
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (zzafD != null) {
      zzafD.onCancel(paramDialogInterface);
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    if (mDialog == null) {
      setShowsDialog(false);
    }
    return mDialog;
  }
  
  public final void show(FragmentManager paramFragmentManager, String paramString)
  {
    super.show(paramFragmentManager, paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.ErrorDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */