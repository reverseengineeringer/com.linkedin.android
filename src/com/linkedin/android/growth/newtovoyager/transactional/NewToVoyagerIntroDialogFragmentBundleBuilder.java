package com.linkedin.android.growth.newtovoyager.transactional;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class NewToVoyagerIntroDialogFragmentBundleBuilder
  implements BundleBuilder
{
  protected final Bundle bundle = new Bundle();
  
  public NewToVoyagerIntroDialogFragmentBundleBuilder(String paramString)
  {
    bundle.putString("legoTrackingTokenKey", paramString);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroDialogFragmentBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */