package com.linkedin.android.relationships;

import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow;
import com.linkedin.android.relationships.pymk.PymkHelper;
import com.linkedin.android.relationships.shared.RelationshipsRoutesHelper;
import java.util.Map;
import javax.inject.Inject;

public final class RelationshipsDataProvider
  extends DataProvider<RelationshipsDataProvider.State, DataProvider.DataProviderListener>
{
  @Inject
  ProfilePendingConnectionRequestManager profilePendingConnectionRequestManager;
  
  @Inject
  public RelationshipsDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public final void fetchMorePymkData$162717c4(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap)
  {
    state).morePeopleYouMayKnowRoute = RelationshipsRoutesHelper.makePeopleYouMayKnowRoute$782597e1("p-flagship3-people-prop", paramInt);
    paramString1 = newModelListener(paramString1, paramString2);
    paramString1 = Request.get().url(state).morePeopleYouMayKnowRoute).customHeaders(paramMap).builder(CollectionTemplate.of(PeopleYouMayKnow.BUILDER)).shouldUpdateCache(false).listener(paramString1).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
    paramString1.trackingSessionId(paramString2);
    activityComponent.dataManager().submit(paramString1);
  }
  
  public final CollectionTemplate<PeopleYouMayKnow, CollectionMetadata> getMorePeopleYouMayKnow()
  {
    ProfilePendingConnectionRequestManager localProfilePendingConnectionRequestManager = profilePendingConnectionRequestManager;
    RelationshipsDataProvider.State localState = (RelationshipsDataProvider.State)state;
    return PymkHelper.filterPendingInvitesPeopleYouMayKnow(localProfilePendingConnectionRequestManager, (CollectionTemplate)localState.getModel(morePeopleYouMayKnowRoute));
  }
  
  public final CollectionTemplate<PeopleYouMayKnow, CollectionMetadata> getPeopleYouMayKnow()
  {
    ProfilePendingConnectionRequestManager localProfilePendingConnectionRequestManager = profilePendingConnectionRequestManager;
    RelationshipsDataProvider.State localState = (RelationshipsDataProvider.State)state;
    return PymkHelper.filterPendingInvitesPeopleYouMayKnow(localProfilePendingConnectionRequestManager, (CollectionTemplate)localState.getModel(peopleYouMayKnowRoute));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.RelationshipsDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */