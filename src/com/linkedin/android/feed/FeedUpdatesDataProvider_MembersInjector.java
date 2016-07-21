package com.linkedin.android.feed;

import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.infra.app.CollectionDataProvider;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class FeedUpdatesDataProvider_MembersInjector
  implements MembersInjector<FeedUpdatesDataProvider>
{
  private final Provider<ProfilePendingConnectionRequestManager> profilePendingConnectionRequestManagerProvider;
  private final MembersInjector<CollectionDataProvider<FeedUpdatesDataProvider.State, CollectionDataProvider.CollectionDataProviderListener<CollectionTemplate<Update, Metadata>>>> supertypeInjector;
  
  static
  {
    if (!FeedUpdatesDataProvider_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private FeedUpdatesDataProvider_MembersInjector(MembersInjector<CollectionDataProvider<FeedUpdatesDataProvider.State, CollectionDataProvider.CollectionDataProviderListener<CollectionTemplate<Update, Metadata>>>> paramMembersInjector, Provider<ProfilePendingConnectionRequestManager> paramProvider)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    profilePendingConnectionRequestManagerProvider = paramProvider;
  }
  
  public static MembersInjector<FeedUpdatesDataProvider> create(MembersInjector<CollectionDataProvider<FeedUpdatesDataProvider.State, CollectionDataProvider.CollectionDataProviderListener<CollectionTemplate<Update, Metadata>>>> paramMembersInjector, Provider<ProfilePendingConnectionRequestManager> paramProvider)
  {
    return new FeedUpdatesDataProvider_MembersInjector(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.FeedUpdatesDataProvider_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */