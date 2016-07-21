package com.linkedin.android.infra;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.linkedin.android.infra.lix.LixManager;
import javax.inject.Inject;

public abstract class FragmentFactory<B extends BundleBuilder>
{
  @Inject
  public LixManager lixManager;
  
  public Fragment newFragment(B paramB)
  {
    Fragment localFragment = provideFragment();
    Bundle localBundle = new Bundle();
    if (paramB != null) {
      localBundle.putAll(paramB.build());
    }
    localFragment.setArguments(localBundle);
    return localFragment;
  }
  
  public abstract Fragment provideFragment();
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.FragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */