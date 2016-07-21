package com.linkedin.android.feed.updates.common.comment.detail;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class CommentDetailFragmentFactory_Factory
  implements Factory<CommentDetailFragmentFactory>
{
  private final MembersInjector<CommentDetailFragmentFactory> membersInjector;
  
  static
  {
    if (!CommentDetailFragmentFactory_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private CommentDetailFragmentFactory_Factory(MembersInjector<CommentDetailFragmentFactory> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<CommentDetailFragmentFactory> create(MembersInjector<CommentDetailFragmentFactory> paramMembersInjector)
  {
    return new CommentDetailFragmentFactory_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragmentFactory_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */