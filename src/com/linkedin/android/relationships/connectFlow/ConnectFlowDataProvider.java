package com.linkedin.android.relationships.connectFlow;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow;
import com.linkedin.android.relationships.pymk.PymkHelper;
import com.linkedin.android.relationships.shared.RelationshipsRoutesHelper;
import java.util.Map;
import javax.inject.Inject;

public final class ConnectFlowDataProvider
  extends DataProvider<ConnectFlowDataProvider.State, DataProvider.DataProviderListener>
{
  private ProfilePendingConnectionRequestManager profilePendingConnectionRequestManager;
  
  @Inject
  public ConnectFlowDataProvider(ActivityComponent paramActivityComponent, ProfilePendingConnectionRequestManager paramProfilePendingConnectionRequestManager)
  {
    super(paramActivityComponent);
    profilePendingConnectionRequestManager = paramProfilePendingConnectionRequestManager;
  }
  
  public final void fetchInitialData$5f5e66bf(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, String> paramMap)
  {
    state).miniProfileRoute = Routes.MINIPROFILE.buildUponRoot().buildUpon().appendPath(paramString3).build().toString();
    MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    localBuilder = localBuilder.required(Request.get().url(state).miniProfileRoute).builder(MiniProfile.BUILDER));
    state).peopleYouMayKnowRoute = RelationshipsRoutesHelper.makeContextualPeopleYouMayKnowRoute$4acf5069(paramString3, paramString4, 0);
    localBuilder.required(Request.get().url(state).peopleYouMayKnowRoute).builder(CollectionTemplate.of(PeopleYouMayKnow.BUILDER)));
    performMultiplexedFetch(paramString1, paramString2, paramMap, localBuilder);
  }
  
  public final CollectionTemplate<PeopleYouMayKnow, CollectionMetadata> getPeopleYouMayKnow()
  {
    ProfilePendingConnectionRequestManager localProfilePendingConnectionRequestManager = profilePendingConnectionRequestManager;
    ConnectFlowDataProvider.State localState = (ConnectFlowDataProvider.State)state;
    return PymkHelper.filterPendingInvitesPeopleYouMayKnow(localProfilePendingConnectionRequestManager, (CollectionTemplate)localState.getModel(peopleYouMayKnowRoute));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.connectFlow.ConnectFlowDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */