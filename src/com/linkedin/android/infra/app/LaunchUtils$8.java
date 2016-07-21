package com.linkedin.android.infra.app;

import android.content.Context;
import com.linkedin.android.growth.contactsync.ContactSyncAdapter;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.lix.LixManager.TreatmentListener;
import com.linkedin.android.infra.network.Auth;

final class LaunchUtils$8
  implements LixManager.TreatmentListener
{
  LaunchUtils$8(Context paramContext, FlagshipSharedPreferences paramFlagshipSharedPreferences, LixManager paramLixManager, Auth paramAuth) {}
  
  public final void onChange(String paramString)
  {
    ContactSyncAdapter.adjustSyncFrequency(val$context, val$sharedPreferences, val$lixManager, val$auth);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.LaunchUtils.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */