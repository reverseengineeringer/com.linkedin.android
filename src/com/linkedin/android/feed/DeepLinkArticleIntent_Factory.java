package com.linkedin.android.feed;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class DeepLinkArticleIntent_Factory
  implements Factory<DeepLinkArticleIntent>
{
  private final MembersInjector<DeepLinkArticleIntent> membersInjector;
  
  static
  {
    if (!DeepLinkArticleIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private DeepLinkArticleIntent_Factory(MembersInjector<DeepLinkArticleIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<DeepLinkArticleIntent> create(MembersInjector<DeepLinkArticleIntent> paramMembersInjector)
  {
    return new DeepLinkArticleIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.DeepLinkArticleIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */