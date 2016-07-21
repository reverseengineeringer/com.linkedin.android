package com.linkedin.android.feed.detail;

import com.linkedin.android.feed.mentions.MentionsPresenter;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class FeedUpdateDetailFragment_MembersInjector
  implements MembersInjector<FeedUpdateDetailFragment>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final Provider<DelayedExecution> delayedExecutionProvider;
  private final Provider<FragmentComponent> fragmentComponentProvider;
  private final Provider<MentionsPresenter> mentionsPresenterProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  private final Provider<ViewPortManager> viewPortManagerProvider;
  
  static
  {
    if (!FeedUpdateDetailFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedUpdateDetailFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<ActivityComponent> paramProvider, Provider<FragmentComponent> paramProvider1, Provider<MentionsPresenter> paramProvider2, Provider<DelayedExecution> paramProvider3, Provider<ViewPortManager> paramProvider4)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    activityComponentProvider = paramProvider;
    assert (paramProvider1 != null);
    fragmentComponentProvider = paramProvider1;
    assert (paramProvider2 != null);
    mentionsPresenterProvider = paramProvider2;
    assert (paramProvider3 != null);
    delayedExecutionProvider = paramProvider3;
    assert (paramProvider4 != null);
    viewPortManagerProvider = paramProvider4;
  }
  
  public static MembersInjector<FeedUpdateDetailFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<ActivityComponent> paramProvider, Provider<FragmentComponent> paramProvider1, Provider<MentionsPresenter> paramProvider2, Provider<DelayedExecution> paramProvider3, Provider<ViewPortManager> paramProvider4)
  {
    return new FeedUpdateDetailFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */