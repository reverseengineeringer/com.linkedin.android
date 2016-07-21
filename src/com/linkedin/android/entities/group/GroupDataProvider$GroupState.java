package com.linkedin.android.entities.group;

import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.group.BasicGroupInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.group.Group;
import com.linkedin.android.pegasus.gen.voyager.entities.group.NextGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistance;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject.Builder;

public final class GroupDataProvider$GroupState
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
  
  public GroupDataProvider$GroupState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
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
      Log.e(GroupDataProvider.access$900(), "Unable to create TrackingObject for MiniGroup, id = " + _cachedId + ", objectUrn = " + objectUrn + ", trackingId = " + trackingId);
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
        Log.e(GroupDataProvider.access$900(), "Unable to create TrackingObject for MiniGroup, id = " + _cachedId + ", objectUrn = " + objectUrn + ", trackingId = " + trackingId);
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

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.GroupDataProvider.GroupState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */