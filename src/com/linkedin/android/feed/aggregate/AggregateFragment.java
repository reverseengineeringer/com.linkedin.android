package com.linkedin.android.feed.aggregate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.linkedin.android.feed.FeedTrackableFragment;
import com.linkedin.android.feed.actions.ControlMenuBundleBuilder;
import com.linkedin.android.feed.actions.UpdateActionPublisher;
import com.linkedin.android.feed.actions.UpdateActionPublisher.DeleteUpdateActionListener;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedAdapter;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.FeedViewTransformer;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.events.FeedCommentUpdateEvent;
import com.linkedin.android.feed.events.UpdateActionEvent;
import com.linkedin.android.feed.events.UpdateExpandEvent;
import com.linkedin.android.feed.utils.FeedPageType;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.VoyagerShakeDelegate.ShakeDebugDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.AggregatedShareContentUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.consistency.ModelListItemChangedListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class AggregateFragment
  extends FeedTrackableFragment
  implements FeedPageType, VoyagerShakeDelegate.ShakeDebugDataProvider
{
  @Inject
  ActivityComponent activityComponent;
  private FeedAdapter aggregateAdapter;
  @Inject
  ConsistencyManager consistencyManager;
  private TrackingOnClickListener controlMenuClickListener;
  @Inject
  FlagshipDataManager dataManager;
  @Inject
  Bus eventBus;
  @Inject
  FragmentComponent fragmentComponent;
  private LinearLayoutManager layoutManager;
  @Inject
  MediaCenter mediaCenter;
  @InjectView(2131755581)
  RecyclerView recyclerView;
  @InjectView(2131755468)
  Toolbar toolbar;
  private Update update;
  private final ModelListItemChangedListener<Update> updateChangedListener = new ModelListItemChangedListener() {};
  private final FeedComponentsViewPool viewPool = new FeedComponentsViewPool();
  @Inject
  ViewPortManager viewPortManager;
  
  private void onUpdateChanged(Update paramUpdate)
  {
    if (value.aggregatedShareContentUpdateValue == null) {
      return;
    }
    ModelsTransformedCallback local3 = new ModelsTransformedCallback()
    {
      public final void onModelsTransformed(ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelsData)
      {
        if (aggregateAdapter == null) {}
        for (;;)
        {
          return;
          if (viewModels.size() > 0)
          {
            int i = 0;
            int j = viewModels.size();
            while (i < j)
            {
              aggregateAdapter.relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModels.get(i));
              i += 1;
            }
          }
        }
      }
    };
    ArrayList localArrayList = new ArrayList(value.aggregatedShareContentUpdateValue.rollup.size() + 1);
    localArrayList.add(paramUpdate);
    localArrayList.addAll(value.aggregatedShareContentUpdateValue.rollup);
    FeedViewTransformer.toViewModels(fragmentComponent, viewPool, localArrayList, FeedDataModelMetadata.DEFAULT, local3);
  }
  
  public final void doEnter()
  {
    super.doEnter();
    if (aggregateAdapter != null) {
      aggregateAdapter.onScreen = true;
    }
  }
  
  public final void doLeave()
  {
    super.doLeave();
    if (aggregateAdapter != null) {
      aggregateAdapter.onLeave();
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    viewPortManager.untrackAll();
  }
  
  public final String enterPageKey()
  {
    return "feed_aggregation_updates";
  }
  
  public final int feedType()
  {
    return 4;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final String loadMorePageKey()
  {
    return "feed_aggregation_updates";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    Bus.subscribe(this);
    aggregateAdapter = new FeedAdapter(getContext(), applicationComponent, this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968706, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    aggregateAdapter = null;
    Bus.unsubscribe(this);
    fragmentComponent.updateChangeCoordinator().removeListener(updateChangedListener);
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    if (recyclerView != null) {
      recyclerView.setAdapter(null);
    }
    if (layoutManager != null)
    {
      layoutManager.mRecycleChildrenOnDetach = true;
      layoutManager = null;
    }
    super.onDestroyView();
  }
  
  @Subscribe
  public void onEvent(FeedCommentUpdateEvent paramFeedCommentUpdateEvent)
  {
    onUpdateChanged(newUpdate);
  }
  
  @Subscribe
  public void onEvent(UpdateActionEvent paramUpdateActionEvent)
  {
    final Update localUpdate = update;
    final UpdateActionModel localUpdateActionModel = updateAction;
    final FragmentComponent localFragmentComponent = fragmentComponent;
    final Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    if (1 == type)
    {
      UpdateActionPublisher.showDeleteConfirmationDialog$79962340(localFragmentComponent, new UpdateActionPublisher.DeleteUpdateActionListener()
      {
        public final void onDeleteUpdateAction()
        {
          AggregateFragment.access$200(AggregateFragment.this, localUpdateurn.toString());
          UpdateActionPublisher.publishUpdateAction(localMap, localFragmentComponent, localUpdateurn.toString(), localUpdateActionModel, localUpdate);
        }
      });
      return;
    }
    if ((3 == type) || (UpdateActionModel.isUnfollowAction(type)) || (21 == type) || (22 == type))
    {
      ModelTransformedCallback local4 = new ModelTransformedCallback()
      {
        public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelData)
        {
          if (aggregateAdapter != null) {
            aggregateAdapter.relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModel, inputModel).urn.toString());
          }
        }
      };
      fragmentComponent.updateChangeCoordinator().setCollapsed(update.urn, updateAction);
      FeedViewTransformer.toCollapsedViewModel(fragmentComponent, viewPool, update, updateAction, local4);
    }
    if (((3 == type) && (urn.equals(update.urn))) || (21 == type) || (22 == type))
    {
      paramUpdateActionEvent = new Intent();
      paramUpdateActionEvent.putExtras(ControlMenuBundleBuilder.create(urn.toString(), type, localUpdate, actorId, actorName, mentionedEntityUrn, self, groupName).build());
      localFragmentComponent.activity().setResult(-1, paramUpdateActionEvent);
      localFragmentComponent.activity().finish();
    }
    UpdateActionPublisher.publishUpdateAction(localMap, localFragmentComponent, urn.toString(), localUpdateActionModel, localUpdate);
  }
  
  @Subscribe
  public void onEvent(UpdateExpandEvent paramUpdateExpandEvent)
  {
    ModelTransformedCallback local6 = new ModelTransformedCallback()
    {
      public final void onModelTransformed(ModelData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelData)
      {
        if (aggregateAdapter != null) {
          aggregateAdapter.relayoutUpdateIfNecessary((FeedUpdateViewModel)viewModel, inputModel).urn.toString());
        }
      }
    };
    if (update.urn != null)
    {
      fragmentComponent.updateChangeCoordinator().setExpanded(update.urn);
      FeedViewTransformer.toViewModel(fragmentComponent, viewPool, update, FeedDataModelMetadata.DEFAULT, local6);
    }
  }
  
  public void onViewCreated(final View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ButterKnife.inject(this, paramView);
    if ((BaseActivity)getActivity() == null) {}
    do
    {
      return;
      toolbar.inflateMenu(2131820544);
      toolbar.setNavigationOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          NavigationUtils.onUpPressed(getActivity(), false);
        }
      });
      viewPortManager.container = recyclerView;
      if (aggregateAdapter != null) {
        aggregateAdapter.setViewPortManager(viewPortManager);
      }
      paramView = new RecyclerViewPortListener(viewPortManager);
      recyclerView.addOnScrollListener(paramView);
      layoutManager = new LinearLayoutManager(getActivity());
      recyclerView.setLayoutManager(layoutManager);
      recyclerView.setAdapter(aggregateAdapter);
      paramView = getArguments();
    } while (paramView == null);
    if (paramView == null) {
      paramView = null;
    }
    while (paramView != null) {
      if (value.aggregatedShareContentUpdateValue != null)
      {
        update = paramView;
        fragmentComponent.updateChangeCoordinator().listenForUpdates(paramView, updateChangedListener);
        paramBundle = new ModelsTransformedCallback()
        {
          public final void onModelsTransformed(ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> paramAnonymousModelsData)
          {
            if ((aggregateAdapter != null) && (viewModels.size() > 0))
            {
              AggregateFragment.access$300(AggregateFragment.this, (FeedUpdateViewModel)viewModels.get(0), paramView);
              aggregateAdapter.appendValues(viewModels.subList(1, viewModels.size()));
            }
          }
        };
        ArrayList localArrayList = new ArrayList(value.aggregatedShareContentUpdateValue.rollup.size() + 1);
        localArrayList.add(paramView);
        localArrayList.addAll(value.aggregatedShareContentUpdateValue.rollup);
        FeedViewTransformer.toViewModels(fragmentComponent, viewPool, localArrayList, FeedDataModelMetadata.DEFAULT, paramBundle);
        return;
        paramView = (Update)RecordParceler.quietUnparcel(Update.BUILDER, "update", paramView);
      }
      else
      {
        getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("Can't show the Aggregate feed with this update! " + PegasusPatchGenerator.modelToJSONString(paramView)));
        return;
      }
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("No update provided to aggregate fragment!"));
  }
  
  public final String pageKey()
  {
    return "feed_aggregation";
  }
  
  public final String provideDebugData()
  {
    if (update != null) {
      return "Feed Aggregate Activity Urn: " + update.urn.toString();
    }
    return null;
  }
  
  public final String refreshPageKey()
  {
    return "feed_aggregation_updates";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.aggregate.AggregateFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */