package com.linkedin.android.entities.group.controllers;

import com.linkedin.android.entities.EntityCoordinatorBaseFragment;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.consistency.ConsistencyManager;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class GroupFragment_MembersInjector
  implements MembersInjector<GroupFragment>
{
  private final Provider<ConsistencyManager> consistencyManagerProvider;
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final MembersInjector<EntityCoordinatorBaseFragment> supertypeInjector;
  
  static
  {
    if (!GroupFragment_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private GroupFragment_MembersInjector(MembersInjector<EntityCoordinatorBaseFragment> paramMembersInjector, Provider<ConsistencyManager> paramProvider, Provider<FlagshipDataManager> paramProvider1)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    consistencyManagerProvider = paramProvider;
    assert (paramProvider1 != null);
    dataManagerProvider = paramProvider1;
  }
  
  public static MembersInjector<GroupFragment> create(MembersInjector<EntityCoordinatorBaseFragment> paramMembersInjector, Provider<ConsistencyManager> paramProvider, Provider<FlagshipDataManager> paramProvider1)
  {
    return new GroupFragment_MembersInjector(paramMembersInjector, paramProvider, paramProvider1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.controllers.GroupFragment_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */