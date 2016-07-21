package com.linkedin.android.growth.takeover;

import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.pegasus.gen.voyager.common.Takeover;
import com.linkedin.android.pegasus.gen.voyager.common.TakeoverType;

public final class PhoneCollectTakeover
  extends TakeoverLauncher
{
  public PhoneCollectTakeover(Takeover paramTakeover)
  {
    super(paramTakeover);
  }
  
  public final void launch(BaseActivity paramBaseActivity, IntentRegistry paramIntentRegistry)
  {
    paramBaseActivity.startActivity(takeover.newIntent(paramBaseActivity, new TakeoverIntentBundleBuilder(takeover.legoTrackingToken, TakeoverType.PHONE_COLLECT)));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.takeover.PhoneCollectTakeover
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */