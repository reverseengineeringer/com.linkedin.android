package com.linkedin.android.growth.abi;

import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.shared.SnackbarUtil;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AbiLoadContactsFragment_MembersInjector
  implements MembersInjector<AbiLoadContactsFragment>
{
  private final Provider<FlagshipSharedPreferences> flagshipSharedPreferencesProvider;
  private final Provider<SnackbarUtil> snackbarProvider;
  private final MembersInjector<LegoFragment> supertypeInjector;
  
  static
  {
    if (!AbiLoadContactsFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AbiLoadContactsFragment_MembersInjector(MembersInjector<LegoFragment> paramMembersInjector, Provider<FlagshipSharedPreferences> paramProvider, Provider<SnackbarUtil> paramProvider1)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    flagshipSharedPreferencesProvider = paramProvider;
    assert (paramProvider1 != null);
    snackbarProvider = paramProvider1;
  }
  
  public static MembersInjector<AbiLoadContactsFragment> create(MembersInjector<LegoFragment> paramMembersInjector, Provider<FlagshipSharedPreferences> paramProvider, Provider<SnackbarUtil> paramProvider1)
  {
    return new AbiLoadContactsFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiLoadContactsFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */