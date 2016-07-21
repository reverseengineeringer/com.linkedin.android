package com.linkedin.android.relationships;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class RelationshipsFragmentFactory
  extends FragmentFactory<RelationshipsBundleBuilder>
{
  public final Fragment provideFragment()
  {
    return new RelationshipsFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.RelationshipsFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */