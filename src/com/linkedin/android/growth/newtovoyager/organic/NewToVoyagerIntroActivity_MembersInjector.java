package com.linkedin.android.growth.newtovoyager.organic;

import android.support.v4.app.FragmentManager;
import com.linkedin.android.infra.app.BaseActivity;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class NewToVoyagerIntroActivity_MembersInjector
  implements MembersInjector<NewToVoyagerIntroActivity>
{
  private final Provider<FragmentManager> fragmentManagerProvider;
  private final MembersInjector<BaseActivity> supertypeInjector;
  
  static
  {
    if (!NewToVoyagerIntroActivity_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private NewToVoyagerIntroActivity_MembersInjector(MembersInjector<BaseActivity> paramMembersInjector, Provider<FragmentManager> paramProvider)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    fragmentManagerProvider = paramProvider;
  }
  
  public static MembersInjector<NewToVoyagerIntroActivity> create(MembersInjector<BaseActivity> paramMembersInjector, Provider<FragmentManager> paramProvider)
  {
    return new NewToVoyagerIntroActivity_MembersInjector(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroActivity_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */