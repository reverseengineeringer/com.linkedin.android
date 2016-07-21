package com.linkedin.android.infra;

import android.os.Bundle;

public final class DefaultBundle
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.DefaultBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */