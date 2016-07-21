package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.internal.zzx;

public final class SupportErrorDialogFragment
  extends DialogFragment
{
  private Dialog mDialog = null;
  private DialogInterface.OnCancelListener zzafD = null;
  
  public static SupportErrorDialogFragment newInstance(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    SupportErrorDialogFragment localSupportErrorDialogFragment = new SupportErrorDialogFragment();
    paramDialog = (Dialog)zzx.zzb(paramDialog, "Cannot display null dialog");
    paramDialog.setOnCancelListener(null);
    paramDialog.setOnDismissListener(null);
    mDialog = paramDialog;
    if (paramOnCancelListener != null) {
      zzafD = paramOnCancelListener;
    }
    return localSupportErrorDialogFragment;
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
 * Qualified Name:     com.google.android.gms.common.SupportErrorDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */