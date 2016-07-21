package com.linkedin.android.entities.company;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class CompanyUpdatesBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle;
  
  public CompanyUpdatesBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.CompanyUpdatesBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */