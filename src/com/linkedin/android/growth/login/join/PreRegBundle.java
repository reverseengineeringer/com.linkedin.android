package com.linkedin.android.growth.login.join;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class PreRegBundle
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public PreRegBundle(int paramInt)
  {
    bundle.putInt("bottomPadding", paramInt);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.PreRegBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */