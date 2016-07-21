package com.linkedin.android.growth.abi;

import com.linkedin.android.growth.lego.LegoManager;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AbiActivity_MembersInjector
  implements MembersInjector<AbiActivity>
{
  private final Provider<AbiLegoWidgetSwitch> abiFragmentSwitchProvider;
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<FlagshipSharedPreferences> flagshipSharedPreferencesProvider;
  private final Provider<LegoManager> legoManagerProvider;
  private final MembersInjector<BaseActivity> supertypeInjector;
  
  static
  {
    if (!AbiActivity_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AbiActivity_MembersInjector(MembersInjector<BaseActivity> paramMembersInjector, Provider<AbiLegoWidgetSwitch> paramProvider, Provider<FlagshipDataManager> paramProvider1, Provider<LegoManager> paramProvider2, Provider<FlagshipSharedPreferences> paramProvider3)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    abiFragmentSwitchProvider = paramProvider;
    assert (paramProvider1 != null);
    dataManagerProvider = paramProvider1;
    assert (paramProvider2 != null);
    legoManagerProvider = paramProvider2;
    assert (paramProvider3 != null);
    flagshipSharedPreferencesProvider = paramProvider3;
  }
  
  public static MembersInjector<AbiActivity> create(MembersInjector<BaseActivity> paramMembersInjector, Provider<AbiLegoWidgetSwitch> paramProvider, Provider<FlagshipDataManager> paramProvider1, Provider<LegoManager> paramProvider2, Provider<FlagshipSharedPreferences> paramProvider3)
  {
    return new AbiActivity_MembersInjector(paramMembersInjector, paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiActivity_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */