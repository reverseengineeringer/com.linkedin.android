package com.linkedin.android.growth.newtovoyager.organic;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.pegasus.gen.voyager.common.Takeover;

public final class NewToVoyagerIntroBundle
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public NewToVoyagerIntroBundle(Takeover paramTakeover)
  {
    this(legoTrackingToken);
  }
  
  public NewToVoyagerIntroBundle(String paramString)
  {
    bundle.putString("legoTrackingTokenKey", paramString);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */