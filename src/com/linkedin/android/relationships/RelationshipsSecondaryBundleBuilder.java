package com.linkedin.android.relationships;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class RelationshipsSecondaryBundleBuilder
  implements BundleBuilder
{
  Bundle bundle = new Bundle();
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final void setAction(String paramString)
  {
    bundle.putString("KEY_ACTION", paramString);
  }
  
  public final void setFragmentBundle(Bundle paramBundle)
  {
    bundle.putBundle("KEY_BUNDLE", paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.RelationshipsSecondaryBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */