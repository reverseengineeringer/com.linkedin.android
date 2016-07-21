package com.linkedin.android.feed.updates.common.comment.detail;

import com.linkedin.android.feed.mentions.MentionsPresenter;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class CommentDetailFragment_MembersInjector
  implements MembersInjector<CommentDetailFragment>
{
  private final Provider<ActivityComponent> activityComponentProvider;
  private final Provider<FragmentComponent> fragmentComponentProvider;
  private final Provider<KeyboardUtil> keyboardUtilProvider;
  private final Provider<MentionsPresenter> mentionsPresenterProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  private final Provider<ViewPortManager> viewPortManagerProvider;
  
  static
  {
    if (!CommentDetailFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private CommentDetailFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<ActivityComponent> paramProvider, Provider<FragmentComponent> paramProvider1, Provider<MentionsPresenter> paramProvider2, Provider<KeyboardUtil> paramProvider3, Provider<ViewPortManager> paramProvider4)
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
    keyboardUtilProvider = paramProvider3;
    assert (paramProvider4 != null);
    viewPortManagerProvider = paramProvider4;
  }
  
  public static MembersInjector<CommentDetailFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<ActivityComponent> paramProvider, Provider<FragmentComponent> paramProvider1, Provider<MentionsPresenter> paramProvider2, Provider<KeyboardUtil> paramProvider3, Provider<ViewPortManager> paramProvider4)
  {
    return new CommentDetailFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */