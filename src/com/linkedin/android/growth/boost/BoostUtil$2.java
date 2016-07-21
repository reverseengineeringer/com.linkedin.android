package com.linkedin.android.growth.boost;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.premium.boost.BoostEligibility;

final class BoostUtil$2
  implements RecordTemplateListener<BoostEligibility>
{
  BoostUtil$2(FlagshipSharedPreferences paramFlagshipSharedPreferences, Bus paramBus) {}
  
  public final void onResponse(DataStoreResponse<BoostEligibility> paramDataStoreResponse)
  {
    if (model != null)
    {
      paramDataStoreResponse = (BoostEligibility)model;
      val$flagshipSharedPreferences.setBoostEligibilityModelString(PegasusPatchGenerator.modelToJSONString(paramDataStoreResponse));
      Bus.publish(new BoostEligibilityFetchedEvent());
      return;
    }
    Log.e(BoostUtil.access$000(), "Error getting BoostEligibilityStatus model string from voyager api");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.BoostUtil.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */