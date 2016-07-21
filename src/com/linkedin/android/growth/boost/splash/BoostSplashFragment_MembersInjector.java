package com.linkedin.android.growth.boost.splash;

import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.MemberUtil;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class BoostSplashFragment_MembersInjector
  implements MembersInjector<BoostSplashFragment>
{
  private final Provider<I18NManager> i18NManagerProvider;
  private final Provider<MemberUtil> memberUtilProvider;
  private final Provider<FlagshipSharedPreferences> sharedPreferencesProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  
  static
  {
    if (!BoostSplashFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private BoostSplashFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<MemberUtil> paramProvider, Provider<FlagshipSharedPreferences> paramProvider1, Provider<I18NManager> paramProvider2)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    memberUtilProvider = paramProvider;
    assert (paramProvider1 != null);
    sharedPreferencesProvider = paramProvider1;
    assert (paramProvider2 != null);
    i18NManagerProvider = paramProvider2;
  }
  
  public static MembersInjector<BoostSplashFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<MemberUtil> paramProvider, Provider<FlagshipSharedPreferences> paramProvider1, Provider<I18NManager> paramProvider2)
  {
    return new BoostSplashFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.boost.splash.BoostSplashFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */