package com.crashlytics.android.core;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import io.fabric.sdk.android.services.persistence.PreferenceStore;
import io.fabric.sdk.android.services.persistence.PreferenceStoreImpl;

final class CrashlyticsCore$7$3
  implements DialogInterface.OnClickListener
{
  CrashlyticsCore$7$3(CrashlyticsCore.7 param7) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PreferenceStoreImpl localPreferenceStoreImpl = new PreferenceStoreImpl(this$1.this$0);
    localPreferenceStoreImpl.save(localPreferenceStoreImpl.edit().putBoolean("always_send_reports_opt_in", true));
    this$1.val$latch.setOptIn(true);
    paramDialogInterface.dismiss();
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsCore.7.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */