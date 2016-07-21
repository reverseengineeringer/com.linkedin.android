package com.linkedin.android.feed.updates.common.comment.detail;

import com.linkedin.android.infra.components.ActivityComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class CommentDetailDataProvider_Factory
  implements Factory<CommentDetailDataProvider>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final MembersInjector<CommentDetailDataProvider> membersInjector;
  
  static
  {
    if (!CommentDetailDataProvider_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private CommentDetailDataProvider_Factory(MembersInjector<CommentDetailDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
  }
  
  public static Factory<CommentDetailDataProvider> create(MembersInjector<CommentDetailDataProvider> paramMembersInjector, Provider<ActivityComponent> paramProvider)
  {
    return new CommentDetailDataProvider_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailDataProvider_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */