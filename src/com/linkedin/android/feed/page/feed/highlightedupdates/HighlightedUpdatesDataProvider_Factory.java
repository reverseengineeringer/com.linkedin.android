package com.linkedin.android.feed.page.feed.highlightedupdates;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class HighlightedUpdatesDataProvider_Factory
  implements Factory<HighlightedUpdatesDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<HighlightedUpdatesDataProvider> membersInjector;
  
  static
  {
    if (!HighlightedUpdatesDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private HighlightedUpdatesDataProvider_Factory(MembersInjector<HighlightedUpdatesDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<HighlightedUpdatesDataProvider> create(MembersInjector<HighlightedUpdatesDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new HighlightedUpdatesDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.highlightedupdates.HighlightedUpdatesDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */