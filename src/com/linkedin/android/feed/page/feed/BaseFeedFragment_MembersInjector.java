package com.linkedin.android.feed.page.feed;

import com.linkedin.android.feed.FeedTrackableFragment;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class BaseFeedFragment_MembersInjector
  implements MembersInjector<BaseFeedFragment>
{
  private final MembersInjector<FeedTrackableFragment> supertypeInjector;
  private final Provider<ViewPortManager> viewPortManagerProvider;
  
  static
  {
    if (!BaseFeedFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private BaseFeedFragment_MembersInjector(MembersInjector<FeedTrackableFragment> paramMembersInjector, Provider<ViewPortManager> paramProvider)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    viewPortManagerProvider = paramProvider;
  }
  
  public static MembersInjector<BaseFeedFragment> create(MembersInjector<FeedTrackableFragment> paramMembersInjector, Provider<ViewPortManager> paramProvider)
  {
    return new BaseFeedFragment_MembersInjector(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.BaseFeedFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */