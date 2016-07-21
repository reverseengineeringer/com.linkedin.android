package com.linkedin.android.entities.jymbii;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class JymbiiBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle;
  
  JymbiiBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static JymbiiBundleBuilder create()
  {
    return new JymbiiBundleBuilder(new Bundle());
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.jymbii.JymbiiBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */