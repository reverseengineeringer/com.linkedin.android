package com.linkedin.android.growth.newtovoyager.organic;

import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.app.PageFragment;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class NewToVoyagerIntroFragment_MembersInjector
  implements MembersInjector<NewToVoyagerIntroFragment>
{
  private final Provider<LegoTrackingDataProvider> legoTrackingDataProvider;
  private final MembersInjector<PageFragment> supertypeInjector;
  
  static
  {
    if (!NewToVoyagerIntroFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private NewToVoyagerIntroFragment_MembersInjector(MembersInjector<PageFragment> paramMembersInjector, Provider<LegoTrackingDataProvider> paramProvider)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    legoTrackingDataProvider = paramProvider;
  }
  
  public static MembersInjector<NewToVoyagerIntroFragment> create(MembersInjector<PageFragment> paramMembersInjector, Provider<LegoTrackingDataProvider> paramProvider)
  {
    return new NewToVoyagerIntroFragment_MembersInjector(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */