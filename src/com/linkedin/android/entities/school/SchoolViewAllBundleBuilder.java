package com.linkedin.android.entities.school;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class SchoolViewAllBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  private SchoolViewAllBundleBuilder(int paramInt)
  {
    bundle.putSerializable("pageType", Integer.valueOf(paramInt));
  }
  
  public static SchoolViewAllBundleBuilder create(int paramInt)
  {
    return new SchoolViewAllBundleBuilder(paramInt);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.SchoolViewAllBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */