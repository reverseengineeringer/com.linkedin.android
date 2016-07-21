package com.linkedin.android.feed.mentions;

import com.linkedin.android.infra.components.FragmentComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class MentionsPresenter_Factory
  implements Factory<MentionsPresenter>
{
  private final Provider<FragmentComponent> fragmentComponentProvider;
  private final MembersInjector<MentionsPresenter> membersInjector;
  
  static
  {
    if (!MentionsPresenter_Factory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private MentionsPresenter_Factory(MembersInjector<MentionsPresenter> paramMembersInjector, Provider<FragmentComponent> paramProvider)
  {
    assert (paramMembersInjector != null);
    membersInjector = paramMembersInjector;
    assert (paramProvider != null);
    fragmentComponentProvider = paramProvider;
  }
  
  public static Factory<MentionsPresenter> create(MembersInjector<MentionsPresenter> paramMembersInjector, Provider<FragmentComponent> paramProvider)
  {
    return new MentionsPresenter_Factory(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.mentions.MentionsPresenter_Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */