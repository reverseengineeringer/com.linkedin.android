package com.linkedin.android.feed.updates.common.comment.detail;

import dagger.MembersInjector;
import dagger.internal.Factory;

public final class CommentDetailIntent_Factory
  implements Factory<CommentDetailIntent>
{
  private final MembersInjector<CommentDetailIntent> membersInjector;
  
  static
  {
    if (!CommentDetailIntent_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private CommentDetailIntent_Factory(MembersInjector<CommentDetailIntent> paramMembersInjector)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
  }
  
  public static Factory<CommentDetailIntent> create(MembersInjector<CommentDetailIntent> paramMembersInjector)
  {
    return new CommentDetailIntent_Factory(paramMembersInjector);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailIntent_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */