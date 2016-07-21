package com.linkedin.android.growth.takeover;

import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroBundle;
import com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroIntent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.pegasus.gen.voyager.common.Takeover;

public final class NewToVoyagerTakeover
  extends TakeoverLauncher
{
  public NewToVoyagerTakeover(Takeover paramTakeover)
  {
    super(paramTakeover);
  }
  
  public final void launch(BaseActivity paramBaseActivity, IntentRegistry paramIntentRegistry)
  {
    paramBaseActivity.startActivity(newToVoyagerOrganicIntro.newIntent(paramBaseActivity, new NewToVoyagerIntroBundle(takeover)));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.takeover.NewToVoyagerTakeover
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */