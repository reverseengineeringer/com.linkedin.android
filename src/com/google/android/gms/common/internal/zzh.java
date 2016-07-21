package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public final class zzh
  implements DialogInterface.OnClickListener
{
  private final Activity mActivity;
  private final Intent mIntent;
  private final int zzagz;
  private final Fragment zzalg;
  
  public zzh(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    mActivity = paramActivity;
    zzalg = null;
    mIntent = paramIntent;
    zzagz = paramInt;
  }
  
  public zzh(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    mActivity = null;
    zzalg = paramFragment;
    mIntent = paramIntent;
    zzagz = paramInt;
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      if ((mIntent != null) && (zzalg != null)) {
        zzalg.startActivityForResult(mIntent, zzagz);
      }
      for (;;)
      {
        paramDialogInterface.dismiss();
        return;
        if (mIntent != null) {
          mActivity.startActivityForResult(mIntent, zzagz);
        }
      }
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface)
    {
      Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */