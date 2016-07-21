package com.linkedin.android.relationships.invitations;

import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.util.Pair;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager.PendingState;
import com.linkedin.android.infra.app.CollectionDataProvider;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.collections.CollectionTemplateHelper.CollectionTemplateHelperListener;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.TrackingUtils;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation;
import com.linkedin.android.relationships.shared.RelationshipsRequestHelper;
import com.linkedin.android.relationships.shared.RelationshipsRoutesHelper;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent.Type;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONObject;

public class InvitationsDataProvider
  extends CollectionDataProvider<InvitationsDataProvider.State, CollectionDataProvider.CollectionDataProviderListener<CollectionTemplate<Invitation, CollectionMetadata>>>
  implements CollectionTemplateHelper.CollectionTemplateHelperListener<Invitation>
{
  private static final String TAG = InvitationsDataProvider.class.getName();
  @Inject
  public ProfilePendingConnectionRequestManager profilePendingConnectionRequestManager;
  
  @Inject
  public InvitationsDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  private void deleteInvitationFromCache(Invitation paramInvitation)
  {
    paramInvitation = Request.delete().cacheKey(_cachedId).filter(DataManager.DataStoreFilter.LOCAL_ONLY);
    activityComponent.dataManager().submit(paramInvitation);
  }
  
  private RecordTemplateListener<CollectionTemplate<Invitation, CollectionMetadata>> modelListener(CollectionTemplateHelper paramCollectionTemplateHelper, boolean paramBoolean, String paramString)
  {
    return new InvitationsDataProvider.1(this, paramCollectionTemplateHelper, paramBoolean, paramString);
  }
  
  public final void acceptInvite(Invitation paramInvitation, RecordTemplateListener paramRecordTemplateListener)
  {
    if (fromMember == null)
    {
      Log.e(TAG, "Cannot accept invitation, must have a fromMember field");
      return;
    }
    String str = fromMember.entityUrn.getId();
    paramRecordTemplateListener = createWrapperModelListener(str, paramRecordTemplateListener);
    paramRecordTemplateListener = RelationshipsRequestHelper.makeAcceptInviteRequest(entityUrn.getId(), sharedSecret).filter(DataManager.DataStoreFilter.NETWORK_ONLY).listener(paramRecordTemplateListener);
    activityComponent.dataManager().submit(paramRecordTemplateListener);
    deleteInvitationFromCache(paramInvitation);
    activityComponent.eventBus();
    Bus.publish(new InvitationUpdatedEvent(str, InvitationUpdatedEvent.Type.ACCEPT));
    profilePendingConnectionRequestManager.setPendingState(str, ProfilePendingConnectionRequestManager.PendingState.INVITATION_ACCEPTED);
  }
  
  public final void clearUnseenCount()
  {
    Request.Builder localBuilder = Request.post().url(Routes.RELATIONSHIPS_INVITATIONS_SUMMARY.buildUponRoot().buildUpon().appendQueryParameter("action", "clearUnseenCount").build().toString()).filter(DataManager.DataStoreFilter.NETWORK_ONLY).model(new JsonModel(new JSONObject()));
    activityComponent.dataManager().submit(localBuilder);
  }
  
  public final RecordTemplateListener createWrapperModelListener(String paramString, RecordTemplateListener paramRecordTemplateListener)
  {
    return new InvitationsDataProvider.2(this, paramString, paramRecordTemplateListener);
  }
  
  public final void fetchInvitations(Map<String, String> paramMap, String paramString1, boolean paramBoolean, String paramString2)
  {
    if (paramBoolean)
    {
      state).collectionHelper = new CollectionTemplateHelper(activityComponent.dataManager(), this, Invitation.BUILDER, CollectionMetadata.BUILDER);
      paramString1 = RelationshipsRoutesHelper.makeInvitationsPagingRoute(paramString1, 0, 20);
      state).collectionHelper.fetchInitialData(paramMap, 2, paramString1, modelListener(state).collectionHelper, false, paramString2), paramString2);
      return;
    }
    if ((state).collectionHelper != null) && (state).collectionHelper.getCollectionTemplate() != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.e(TAG, "Must do initial fetch first for invitations list before fetching next page");
      return;
    }
    paramString1 = RelationshipsRoutesHelper.makeInvitationsPagingRoute(paramString1, ((Integer)state).collectionHelper.getNextPage().first).intValue(), ((Integer)state).collectionHelper.getNextPage().second).intValue());
    state).collectionHelper.fetchInitialData(paramMap, 2, paramString1, modelListener(state).collectionHelper, true, paramString2), paramString2);
  }
  
  public final void ignoreInvite(Invitation paramInvitation, RecordTemplateListener paramRecordTemplateListener)
  {
    if (fromMember == null)
    {
      Log.e(TAG, "Cannot ignore invitation, must have a fromMember field");
      return;
    }
    deleteInvitationFromCache(paramInvitation);
    ignoreInvite(entityUrn.getId(), sharedSecret, fromMember.entityUrn.getId(), paramRecordTemplateListener);
  }
  
  public final void ignoreInvite(String paramString1, String paramString2, String paramString3, RecordTemplateListener paramRecordTemplateListener)
  {
    paramRecordTemplateListener = createWrapperModelListener(paramString3, paramRecordTemplateListener);
    paramString1 = RelationshipsRequestHelper.makeIgnoreInviteRequest(paramString1, paramString2).filter(DataManager.DataStoreFilter.NETWORK_ONLY).listener(paramRecordTemplateListener);
    activityComponent.dataManager().submit(paramString1);
    activityComponent.eventBus();
    Bus.publish(new InvitationUpdatedEvent(paramString3, InvitationUpdatedEvent.Type.IGNORE));
    profilePendingConnectionRequestManager.setPendingState(paramString3, ProfilePendingConnectionRequestManager.PendingState.INVITATION_IGNORED);
  }
  
  public final void onFetchingData()
  {
    Iterator localIterator = dataListeners.iterator();
    while (localIterator.hasNext()) {
      ((CollectionDataProvider.CollectionDataProviderListener)localIterator.next()).onFetching();
    }
  }
  
  public final void onFinishedFetchingData()
  {
    Iterator localIterator = dataListeners.iterator();
    while (localIterator.hasNext()) {
      ((CollectionDataProvider.CollectionDataProviderListener)localIterator.next()).onFinishedFetching();
    }
  }
  
  public final void sendInvite(MiniProfile paramMiniProfile, RecordTemplateListener paramRecordTemplateListener)
  {
    String str = entityUrn.getId();
    paramMiniProfile = trackingId;
    try
    {
      Object localObject = new InviteeProfile.Builder().setProfileId(str).build(RecordTemplate.Flavor.RECORD);
      localObject = new NormInvitation.Invitee.Builder().setInviteeProfileValue((InviteeProfile)localObject).build();
      localObject = new NormInvitation.Builder().setInvitee((NormInvitation.Invitee)localObject);
      if (paramMiniProfile != null) {}
      for (;;)
      {
        paramMiniProfile = ((NormInvitation.Builder)localObject).setTrackingId(paramMiniProfile).build(RecordTemplate.Flavor.RECORD);
        paramRecordTemplateListener = createWrapperModelListener(str, paramRecordTemplateListener);
        paramMiniProfile = Request.post().url(RelationshipsRoutesHelper.makeSendGrowthInvitationRoute()).model(paramMiniProfile).filter(DataManager.DataStoreFilter.NETWORK_ONLY).listener(paramRecordTemplateListener);
        activityComponent.dataManager().submit(paramMiniProfile);
        activityComponent.eventBus();
        Bus.publish(new InvitationUpdatedEvent(str, InvitationUpdatedEvent.Type.SENT));
        profilePendingConnectionRequestManager.setPendingState(str, ProfilePendingConnectionRequestManager.PendingState.INVITATION_SENT);
        return;
        paramMiniProfile = TrackingUtils.generateBase64EncodedTrackingId();
      }
      return;
    }
    catch (BuilderException paramMiniProfile)
    {
      Log.e("Error sending invite", paramMiniProfile);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.invitations.InvitationsDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */