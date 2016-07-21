package com.linkedin.android.entities.group;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponseBuilder;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.group.BasicGroupInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.group.Group;
import com.linkedin.android.pegasus.gen.voyager.entities.group.NextGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistance;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject.Builder;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONObject;

public class GroupDataProvider
  extends DataProvider<GroupState, DataProvider.DataProviderListener>
{
  private static final String TAG = GroupDataProvider.class.getSimpleName();
  
  @Inject
  public GroupDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public static String buildActionRouteForGroup(String paramString1, String paramString2)
  {
    return Routes.GROUP.buildRouteForId(paramString1).buildUpon().appendQueryParameter("action", paramString2).build().toString();
  }
  
  public static String getRecentUpdatesRoute(String paramString)
  {
    return Routes.GROUP.buildRouteForId(paramString).buildUpon().appendPath("discussions").appendQueryParameter("q", "recentDiscussions").build().toString();
  }
  
  public final void fetchData(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, DataManager.DataStoreFilter paramDataStoreFilter)
  {
    Uri localUri = Routes.GROUP.buildRouteForId(paramString3);
    state).groupRoute = localUri.toString();
    state).adminsRoute = Uri.withAppendedPath(localUri, "admins").toString();
    state).membersRoute = Uri.withAppendedPath(localUri, "members").toString();
    state).managersChoiceDiscussionsRoute = localUri.buildUpon().appendPath("discussions").appendQueryParameter("q", "managersChoice").build().toString();
    state).recentDiscussionsRoute = getRecentUpdatesRoute(paramString3);
    state).similarGroupsRoute = localUri.buildUpon().appendPath("nextGroup").appendQueryParameter("q", "groupsYouMayLike").build().toString();
    paramString3 = MultiplexRequest.Builder.parallel().filter(paramDataStoreFilter);
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    performMultiplexedFetch(paramString1, paramString2, paramMap, paramString3.required(Request.get().url(state).groupRoute).builder(Group.BUILDER)).optional(Request.get().url(state).adminsRoute).builder(CollectionTemplate.of(MiniProfileWithDistance.BUILDER))).optional(Request.get().url(state).membersRoute).builder(CollectionTemplate.of(MiniProfileWithDistance.BUILDER))).optional(Request.get().url(state).managersChoiceDiscussionsRoute).builder(CollectionTemplate.of(Update.BUILDER))).optional(Request.get().url(state).recentDiscussionsRoute).builder(CollectionTemplate.of(Update.BUILDER))).optional(Request.get().url(state).similarGroupsRoute).builder(CollectionTemplate.of(NextGroup.BUILDER))));
  }
  
  public final void fetchInitialGroupUpdates(String paramString1, String paramString2, Map<String, String> paramMap, String paramString3)
  {
    RecordTemplateListener localRecordTemplateListener = collectionCompletionCallback(paramString1, paramString2, paramString3, 2);
    CollectionTemplateHelper localCollectionTemplateHelper = state).allUpdatesHelper;
    paramString1 = localCollectionTemplateHelper;
    if (localCollectionTemplateHelper == null)
    {
      paramString1 = new CollectionTemplateHelper(activityComponent.dataManager(), null, Update.BUILDER, CollectionMetadata.BUILDER);
      state).allUpdatesHelper = paramString1;
    }
    paramString1.fetchInitialData(paramMap, 2, paramString3, localRecordTemplateListener, paramString2);
  }
  
  public final void sendRequestWithToastOnSuccess$676845c5(String paramString, Map<String, String> paramMap, final Group paramGroup, final int paramInt, final boolean paramBoolean)
  {
    activityComponent.dataManager().submit(Request.post().url(paramString).model(new JsonModel(new JSONObject())).builder(new ActionResponseBuilder(GroupMembershipInfo.BUILDER)).customHeaders(paramMap).listener(new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<ActionResponse<GroupMembershipInfo>> paramAnonymousDataStoreResponse)
      {
        GroupDataProvider.access$600(GroupDataProvider.this, paramAnonymousDataStoreResponse, paramGroup, paramInt, val$failedToastStringId, paramBoolean);
      }
    }).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
  }
  
  public static final class GroupState
    extends DataProvider.State
  {
    String adminsRoute;
    public CollectionTemplateHelper<Update, CollectionMetadata> allUpdatesHelper;
    public String groupRoute;
    public TrackingObject groupTrackingObject;
    String managersChoiceDiscussionsRoute;
    public CollectionTemplateHelper<MiniProfileWithDistance, CollectionMetadata> membersHelper;
    public String membersRoute;
    String recentDiscussionsRoute;
    String similarGroupsRoute;
    
    public GroupState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
    }
    
    public final CollectionTemplate<MiniProfileWithDistance, CollectionMetadata> admins()
    {
      return (CollectionTemplate)getModel(adminsRoute);
    }
    
    public final Group group()
    {
      return (Group)getModel(groupRoute);
    }
    
    public final TrackingObject initGroupTrackingObjectFromNetwork()
    {
      Object localObject = group();
      if (localObject != null)
      {
        localObject = basicGroupInfo.miniGroup;
        if ((objectUrn != null) && (trackingId != null)) {
          break label91;
        }
        Log.e(GroupDataProvider.TAG, "Unable to create TrackingObject for MiniGroup, id = " + _cachedId + ", objectUrn = " + objectUrn + ", trackingId = " + trackingId);
        groupTrackingObject = null;
      }
      for (;;)
      {
        return groupTrackingObject;
        try
        {
          label91:
          groupTrackingObject = new TrackingObject.Builder().setObjectUrn(objectUrn.toString()).setTrackingId(trackingId).build(RecordTemplate.Flavor.RECORD);
        }
        catch (BuilderException localBuilderException)
        {
          Log.e(GroupDataProvider.TAG, "Unable to create TrackingObject for MiniGroup, id = " + _cachedId + ", objectUrn = " + objectUrn + ", trackingId = " + trackingId);
        }
      }
    }
    
    public final CollectionTemplate<Update, CollectionMetadata> managersChoiceDiscussions()
    {
      return (CollectionTemplate)getModel(managersChoiceDiscussionsRoute);
    }
    
    public final CollectionTemplate<MiniProfileWithDistance, CollectionMetadata> members()
    {
      return (CollectionTemplate)getModel(membersRoute);
    }
    
    public final CollectionTemplate<Update, CollectionMetadata> recentDiscussions()
    {
      CollectionTemplate localCollectionTemplate = (CollectionTemplate)getModel(recentDiscussionsRoute);
      if (localCollectionTemplate == null) {
        return null;
      }
      return CollectionTemplate.of(localCollectionTemplate);
    }
    
    public final CollectionTemplate<NextGroup, CollectionMetadata> similarGroups()
    {
      return (CollectionTemplate)getModel(similarGroupsRoute);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.GroupDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */