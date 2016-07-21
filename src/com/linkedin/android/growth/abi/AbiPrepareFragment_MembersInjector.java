package com.linkedin.android.growth.abi;

import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.shared.SnackbarUtil;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class AbiPrepareFragment_MembersInjector
  implements MembersInjector<AbiPrepareFragment>
{
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<SnackbarUtil> snackbarProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  
  static
  {
    if (!AbiPrepareFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private AbiPrepareFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<FlagshipDataManager> paramProvider, Provider<SnackbarUtil> paramProvider1)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    dataManagerProvider = paramProvider;
    assert (paramProvider1 != null);
    snackbarProvider = paramProvider1;
  }
  
  public static MembersInjector<AbiPrepareFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<FlagshipDataManager> paramProvider, Provider<SnackbarUtil> paramProvider1)
  {
    return new AbiPrepareFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiPrepareFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */