package com.linkedin.android.entities.company;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class CompanyViewAllBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle;
  
  private CompanyViewAllBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public static CompanyViewAllBundleBuilder create(int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("pageType", paramInt);
    localBundle.putString("pageTitle", paramString);
    return new CompanyViewAllBundleBuilder(localBundle);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.CompanyViewAllBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */