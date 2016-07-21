package com.linkedin.android.growth.login.prereg;

import com.linkedin.android.growth.login.login.LoginManager;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.litrackinglib.metric.Tracker;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PreRegFragment_MembersInjector
  implements MembersInjector<PreRegFragment>
{
  private final Provider<LoginManager> loginManagerProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  private final Provider<Tracker> trackerProvider;
  
  static
  {
    if (!PreRegFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private PreRegFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<LoginManager> paramProvider, Provider<Tracker> paramProvider1)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    loginManagerProvider = paramProvider;
    assert (paramProvider1 != null);
    trackerProvider = paramProvider1;
  }
  
  public static MembersInjector<PreRegFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<LoginManager> paramProvider, Provider<Tracker> paramProvider1)
  {
    return new PreRegFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.PreRegFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */