package com.linkedin.android.entities.group.transformers;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.widget.ImageView;
import com.linkedin.android.entities.group.GroupUpdatesBundleBuilder;
import com.linkedin.android.entities.group.controllers.GroupUpdatesFragment;
import com.linkedin.android.entities.viewmodels.cards.EntityFeedUpdateWrapperCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.EntityListCardViewModel;
import com.linkedin.android.entities.viewmodels.items.EntityItemViewModel;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.FeedViewTransformer;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.group.BasicGroupInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.group.Group;
import com.linkedin.android.pegasus.gen.voyager.entities.group.NextGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class GroupHighlightsTransformer
{
  public static boolean canShowFeaturedDiscussionUpdate(CollectionTemplate<Update, CollectionMetadata> paramCollectionTemplate)
  {
    return (CollectionUtils.isNonEmpty(paramCollectionTemplate)) && (elements.get(0)).value.discussionUpdateValue != null);
  }
  
  private static EntityFeedUpdateWrapperCardViewModel toEntityFeedUpdateWrapperCardViewModel(FeedUpdateViewModel paramFeedUpdateViewModel, String paramString, TrackingObject paramTrackingObject)
  {
    EntityFeedUpdateWrapperCardViewModel localEntityFeedUpdateWrapperCardViewModel = new EntityFeedUpdateWrapperCardViewModel();
    feedUpdateViewModel = paramFeedUpdateViewModel;
    trackingEventBuilderClosure = GroupTransformer.newGroupImpressionTrackingClosure(paramTrackingObject, Collections.singletonList(paramString), header, "mp5huJtERPOkM8wf56WQfQ==");
    return localEntityFeedUpdateWrapperCardViewModel;
  }
  
  public static EntityFeedUpdateWrapperCardViewModel toFeaturedDiscussionUpdate(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, CollectionTemplate<Update, CollectionMetadata> paramCollectionTemplate, TrackingObject paramTrackingObject)
  {
    if (!canShowFeaturedDiscussionUpdate(paramCollectionTemplate)) {
      return null;
    }
    return toEntityFeedUpdateWrapperCardViewModel((FeedUpdateViewModel)toViewModelelements.get(0), FeedDataModelMetadata.DEFAULT).viewModel, elements.get(0)).urn.toString(), paramTrackingObject);
  }
  
  public static List<EntityFeedUpdateWrapperCardViewModel> toRecentDiscussionUpdates(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, CollectionTemplate<Update, CollectionMetadata> paramCollectionTemplate, TrackingObject paramTrackingObject)
  {
    if (!CollectionUtils.isNonEmpty(paramCollectionTemplate))
    {
      paramFragmentComponent = new ArrayList();
      return paramFragmentComponent;
    }
    List localList = elements;
    paramCollectionTemplate = localList;
    if (localList.size() > 4) {
      paramCollectionTemplate = localList.subList(0, 4);
    }
    localList = toViewModelsDEFAULTviewModels;
    paramFeedComponentsViewPool = new ArrayList();
    int i = 0;
    for (;;)
    {
      paramFragmentComponent = paramFeedComponentsViewPool;
      if (i >= paramCollectionTemplate.size()) {
        break;
      }
      paramFeedComponentsViewPool.add(toEntityFeedUpdateWrapperCardViewModel((FeedUpdateViewModel)localList.get(i), geturn.toString(), paramTrackingObject));
      i += 1;
    }
  }
  
  public static EntityListCardViewModel toSimilarGroupsBrowseMapListCard(final FragmentComponent paramFragmentComponent, CollectionTemplate<NextGroup, CollectionMetadata> paramCollectionTemplate, TrackingObject paramTrackingObject)
  {
    if (!CollectionUtils.isNonEmpty(paramCollectionTemplate)) {
      return null;
    }
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    entityListCardMaxRows = paramFragmentComponent.activity().getResources().getInteger(2131558420);
    header = paramFragmentComponent.i18NManager().getString(2131230930);
    int j = elements.size();
    ArrayMap localArrayMap = new ArrayMap();
    int i = 0;
    if ((i < j) && (i < entityListCardMaxRows))
    {
      NextGroup localNextGroup = (NextGroup)elements.get(i);
      List localList = items;
      EntityItemViewModel localEntityItemViewModel = new EntityItemViewModel();
      final MiniGroup localMiniGroup = miniGroup;
      Object localObject = paramFragmentComponent.i18NManager();
      image = new ImageModel(logo, GhostImageUtils.getGroup(2131492963, localMiniGroup), Util.retrieveRumSessionId(paramFragmentComponent));
      title = groupName;
      if (hasMemberCount) {}
      for (localObject = ((I18NManager)localObject).getString(2131230929, new Object[] { Integer.valueOf(memberCount) });; localObject = null)
      {
        subtitle = ((String)localObject);
        onRowClick = new TrackingClosure(paramFragmentComponent.tracker(), "group_link") {};
        localList.add(localEntityItemViewModel);
        localArrayMap.put(miniGroup.trackingId, Collections.singletonList(miniGroup.objectUrn.toString()));
        i += 1;
        break;
      }
    }
    if (paramTrackingObject != null) {
      trackingEventBuilderClosure = new GroupTransformer.7(localArrayMap, header, paramTrackingObject);
    }
    isBrowseMap = true;
    return localEntityListCardViewModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.transformers.GroupHighlightsTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */