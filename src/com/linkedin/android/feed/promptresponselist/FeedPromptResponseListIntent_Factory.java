package com.linkedin.android.feed.promptresponselist;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class FeedPromptResponseListIntent_Factory
  implements Factory<FeedPromptResponseListIntent>
{
  private final MembersInjector<FeedPromptResponseListIntent> membersInjector;
  
  static
  {
    if (!FeedPromptResponseListIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedPromptResponseListIntent_Factory(MembersInjector<FeedPromptResponseListIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<FeedPromptResponseListIntent> create(MembersInjector<FeedPromptResponseListIntent> paramMembersInjector)
  {
    return new FeedPromptResponseListIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.promptresponselist.FeedPromptResponseListIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */