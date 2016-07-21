package com.linkedin.android.feed.promptresponselist;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class FeedPromptResponseListFragmentFactory_Factory
  implements Factory<FeedPromptResponseListFragmentFactory>
{
  private final MembersInjector<FeedPromptResponseListFragmentFactory> membersInjector;
  
  static
  {
    if (!FeedPromptResponseListFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedPromptResponseListFragmentFactory_Factory(MembersInjector<FeedPromptResponseListFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<FeedPromptResponseListFragmentFactory> create(MembersInjector<FeedPromptResponseListFragmentFactory> paramMembersInjector)
  {
    return new FeedPromptResponseListFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.promptresponselist.FeedPromptResponseListFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */