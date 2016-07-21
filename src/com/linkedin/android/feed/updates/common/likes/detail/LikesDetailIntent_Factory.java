package com.linkedin.android.feed.updates.common.likes.detail;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class LikesDetailIntent_Factory
  implements Factory<LikesDetailIntent>
{
  private final MembersInjector<LikesDetailIntent> membersInjector;
  
  static
  {
    if (!LikesDetailIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private LikesDetailIntent_Factory(MembersInjector<LikesDetailIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<LikesDetailIntent> create(MembersInjector<LikesDetailIntent> paramMembersInjector)
  {
    return new LikesDetailIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDetailIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */