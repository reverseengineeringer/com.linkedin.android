package com.linkedin.android.feed.updates.common.likes.detail;

import android.support.v4.app.Fragment;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class LikesDetailFragmentFactory
  extends FragmentFactory<LikesDetailBundleBuilder>
{
  public final Fragment provideFragment()
  {
    return new LikesDetailFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDetailFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */