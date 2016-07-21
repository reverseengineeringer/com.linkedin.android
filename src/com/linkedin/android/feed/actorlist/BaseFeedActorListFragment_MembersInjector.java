package com.linkedin.android.feed.actorlist;

import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class BaseFeedActorListFragment_MembersInjector
  implements MembersInjector<BaseFeedActorListFragment>
{
  private final Provider<Bus> eventBusProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  private final Provider<ViewPortManager> viewPortManagerProvider;
  
  static
  {
    if (!BaseFeedActorListFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private BaseFeedActorListFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<Bus> paramProvider, Provider<ViewPortManager> paramProvider1)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    eventBusProvider = paramProvider;
    assert (paramProvider1 != null);
    viewPortManagerProvider = paramProvider1;
  }
  
  public static MembersInjector<BaseFeedActorListFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<Bus> paramProvider, Provider<ViewPortManager> paramProvider1)
  {
    return new BaseFeedActorListFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actorlist.BaseFeedActorListFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */