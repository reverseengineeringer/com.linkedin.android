package com.linkedin.android.feed.mentions;

import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.search.typeahead.TypeaheadTransformer;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class MentionsPresenter_MembersInjector
  implements MembersInjector<MentionsPresenter>
{
  private final Provider<FlagshipDataManager> dataManagerProvider;
  private final Provider<DelayedExecution> delayedExecutionProvider;
  private final Provider<TypeaheadTransformer> typeaheadTransformerProvider;
  
  static
  {
    if (!MentionsPresenter_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private MentionsPresenter_MembersInjector(Provider<FlagshipDataManager> paramProvider, Provider<DelayedExecution> paramProvider1, Provider<TypeaheadTransformer> paramProvider2)
  {
    assert (paramProvider != null);
    dataManagerProvider = paramProvider;
    assert (paramProvider1 != null);
    delayedExecutionProvider = paramProvider1;
    assert (paramProvider2 != null);
    typeaheadTransformerProvider = paramProvider2;
  }
  
  public static MembersInjector<MentionsPresenter> create(Provider<FlagshipDataManager> paramProvider, Provider<DelayedExecution> paramProvider1, Provider<TypeaheadTransformer> paramProvider2)
  {
    return new MentionsPresenter_MembersInjector(paramProvider, paramProvider1, paramProvider2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.mentions.MentionsPresenter_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */