package com.linkedin.android.growth.takeover;

import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.pegasus.gen.voyager.common.Takeover;

public abstract class TakeoverLauncher
{
  public Takeover takeover;
  
  public TakeoverLauncher(Takeover paramTakeover)
  {
    takeover = paramTakeover;
  }
  
  public abstract void launch(BaseActivity paramBaseActivity, IntentRegistry paramIntentRegistry);
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.takeover.TakeoverLauncher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */