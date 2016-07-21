package com.linkedin.android.identity.edit.newSections;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class ProfileNewSectionBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final ProfileNewSectionBundleBuilder setDefaultExpandCategory(ParentViewModel.Category paramCategory)
  {
    bundle.putSerializable("defaultExpandCategory", paramCategory);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.newSections.ProfileNewSectionBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */