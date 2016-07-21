package com.linkedin.android.entities.company;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.widget.ImageView;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;

public final class CompanyBundleBuilder
  implements BundleBuilder
{
  public final Bundle bundle;
  public ImageView logoView;
  
  public CompanyBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
    if (!paramBundle.containsKey("getCompanyId")) {
      Util.safeThrow(new IllegalArgumentException("Invalid company bundle"));
    }
  }
  
  public static CompanyBundleBuilder create(MiniCompany paramMiniCompany, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("getCompanyId", entityUrn.getId());
    localBundle.putString("companyUrn", entityUrn.toString());
    localBundle.putBoolean("isShowcase", paramBoolean);
    return new CompanyBundleBuilder(localBundle);
  }
  
  public static CompanyBundleBuilder create(String paramString1, String paramString2, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("getCompanyId", paramString1);
    localBundle.putString("companyName", paramString2);
    localBundle.putBoolean("isShowcase", paramBoolean);
    return new CompanyBundleBuilder(localBundle);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final Bundle buildTransitionBundle(Activity paramActivity)
  {
    if (logoView != null) {
      return ActivityOptionsCompat.makeSceneTransitionAnimation(paramActivity, logoView, "logoTransition").toBundle();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.CompanyBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */