package com.linkedin.android.growth.login.prereg.intro;

import com.linkedin.android.growth.login.prereg.PreRegPropFragment;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.I18NManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class PreRegIntroFragment_MembersInjector
  implements MembersInjector<PreRegIntroFragment>
{
  private final Provider<Bus> busProvider;
  private final Provider<I18NManager> i18NManagerProvider;
  private final Provider<FlagshipSharedPreferences> sharedPreferencesProvider;
  private final MembersInjector<PreRegPropFragment<PreRegIntroFragmentViewHolder, PreRegIntroFragmentViewModel>> supertypeInjector;
  
  static
  {
    if (!PreRegIntroFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private PreRegIntroFragment_MembersInjector(MembersInjector<PreRegPropFragment<PreRegIntroFragmentViewHolder, PreRegIntroFragmentViewModel>> paramMembersInjector, Provider<Bus> paramProvider, Provider<I18NManager> paramProvider1, Provider<FlagshipSharedPreferences> paramProvider2)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    busProvider = paramProvider;
    assert (paramProvider1 != null);
    i18NManagerProvider = paramProvider1;
    assert (paramProvider2 != null);
    sharedPreferencesProvider = paramProvider2;
  }
  
  public static MembersInjector<PreRegIntroFragment> create(MembersInjector<PreRegPropFragment<PreRegIntroFragmentViewHolder, PreRegIntroFragmentViewModel>> paramMembersInjector, Provider<Bus> paramProvider, Provider<I18NManager> paramProvider1, Provider<FlagshipSharedPreferences> paramProvider2)
  {
    return new PreRegIntroFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.intro.PreRegIntroFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */