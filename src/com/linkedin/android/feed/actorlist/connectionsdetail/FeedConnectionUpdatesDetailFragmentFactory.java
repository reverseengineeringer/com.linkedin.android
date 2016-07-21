package com.linkedin.android.feed.actorlist.connectionsdetail;

import android.support.v4.app.Fragment;
import com.linkedin.android.feed.actorlist.FeedActorListBundleBuilder;
import com.linkedin.android.infra.FragmentFactory;
import javax.inject.Inject;

public final class FeedConnectionUpdatesDetailFragmentFactory
  extends FragmentFactory<FeedActorListBundleBuilder>
{
  public final Fragment provideFragment()
  {
    return new FeedConnectionUpdatesDetailFragment();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actorlist.connectionsdetail.FeedConnectionUpdatesDetailFragmentFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */