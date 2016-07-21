package com.linkedin.android.growth.boost;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostUpgradeResult;

final class BoostUtil$1
  implements RecordTemplateListener<ActionResponse<BoostUpgradeResult>>
{
  BoostUtil$1(FlagshipSharedPreferences paramFlagshipSharedPreferences) {}
  
  public final void onResponse(DataStoreResponse<ActionResponse<BoostUpgradeResult>> paramDataStoreResponse)
  {
    paramDataStoreResponse = (ActionResponse)model;
    if ((paramDataStoreResponse != null) && (value != null))
    {
      FlagshipSharedPreferences localFlagshipSharedPreferences = val$preferences;
      boolean bool = value).upgradeFulfilled;
      localFlagshipSharedPreferences.getPreferences().edit().putBoolean("boostUpgradeStatus", bool).apply();
      return;
    }
    Log.e(BoostUtil.access$000(), "Error getting BoostUpgradeStatus from voyager api");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.BoostUtil.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */