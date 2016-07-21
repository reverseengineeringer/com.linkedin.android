package com.linkedin.android.relationships.addConnections;

import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow;
import com.linkedin.android.relationships.shared.RelationshipsRoutesHelper;
import javax.inject.Inject;

public final class PymkDataProvider
  extends DataProvider<PymkDataProvider.State, DataProvider.DataProviderListener>
{
  @Inject
  public ProfilePendingConnectionRequestManager profilePendingConnectionRequestManager;
  
  @Inject
  public PymkDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public final void fetchData$379dfc29(String paramString1, String paramString2, int paramInt)
  {
    state).peopleYouMayKnowRoute = RelationshipsRoutesHelper.makePeopleYouMayKnowRoute$782597e1("p-flagship3-people-add-connections", paramInt);
    String str = state).peopleYouMayKnowRoute;
    if (paramInt == 0) {}
    for (paramInt = 2;; paramInt = 5)
    {
      paramString1 = collectionCompletionCallback(paramString1, paramString2, str, paramInt);
      paramString1 = Request.get().url(state).peopleYouMayKnowRoute).builder(CollectionTemplate.of(PeopleYouMayKnow.BUILDER)).listener(paramString1).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      if (paramString2 != null) {
        paramString1.trackingSessionId(paramString2);
      }
      activityComponent.dataManager().submit(paramString1);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.addConnections.PymkDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */