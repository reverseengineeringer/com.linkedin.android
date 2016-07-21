package com.linkedin.android.feed.actorlist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.feed.endor.datamodel.transformer.ActorUpdateDataModelTransformer;
import com.linkedin.android.feed.endor.datamodel.transformer.UpdateException;
import com.linkedin.android.feed.endor.datamodel.update.actor.ConnectionUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.actor.PymkUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.miniheader.FeedMiniHeaderTransformer;
import com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorTransformer;
import com.linkedin.android.feed.endor.ui.component.primaryactor.FeedPrimaryActorViewModel;
import com.linkedin.android.feed.endor.ui.update.actor.FeedActorUpdateDetailViewModel;
import com.linkedin.android.feed.endor.ui.update.actor.FeedActorUpdateDetailViewTransformer;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedPageType;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.VoyagerShakeDelegate.ShakeDebugDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.NavigationUtils;
import com.linkedin.android.infra.ui.DividerItemDecoration;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public abstract class BaseFeedActorListFragment
  extends PageFragment
  implements FeedPageType, VoyagerShakeDelegate.ShakeDebugDataProvider
{
  protected FeedActorListAdapter adapter;
  @Inject
  Bus eventBus;
  public FragmentComponent fragmentComponent;
  protected LinearLayoutManager layoutManager;
  public List<Update> pegasusModels;
  @InjectView(2131755579)
  protected RecyclerView recyclerView;
  @InjectView(2131755468)
  protected Toolbar toolbar;
  protected final FeedComponentsViewPool viewPool = new FeedComponentsViewPool();
  @Inject
  ViewPortManager viewPortManager;
  
  private FeedActorUpdateDetailViewModel transformUpdate(Update paramUpdate)
  {
    FragmentComponent localFragmentComponent;
    FeedComponentsViewPool localFeedComponentsViewPool;
    Object localObject;
    try
    {
      localFragmentComponent = fragmentComponent;
      if (value.connectionUpdateValue != null) {
        paramUpdate = ActorUpdateDataModelTransformer.toDataModel(localFragmentComponent, paramUpdate, value.connectionUpdateValue);
      }
      for (;;)
      {
        localFragmentComponent = fragmentComponent;
        localFeedComponentsViewPool = viewPool;
        if (!(paramUpdate instanceof ConnectionUpdateDataModel)) {
          break label178;
        }
        paramUpdate = (ConnectionUpdateDataModel)paramUpdate;
        localObject = new ArrayList();
        FeedActorUpdateDetailViewTransformer.safeAdd((List)localObject, FeedMiniHeaderTransformer.toViewModel(localFragmentComponent, paramUpdate));
        FeedActorUpdateDetailViewTransformer.safeAdd((List)localObject, FeedPrimaryActorTransformer.toViewModel(paramUpdate, localFragmentComponent, false));
        if (((List)localObject).isEmpty()) {
          break label230;
        }
        return new FeedActorUpdateDetailViewModel(pegasusUpdate, localFeedComponentsViewPool, localFragmentComponent, (List)localObject, null);
        if (value.pymkUpdateValue != null)
        {
          paramUpdate = ActorUpdateDataModelTransformer.toDataModel(localFragmentComponent, paramUpdate, value.pymkUpdateValue);
        }
        else
        {
          if (value.followRecommendationUpdateValue == null) {
            break;
          }
          paramUpdate = ActorUpdateDataModelTransformer.toDataModel(localFragmentComponent, paramUpdate, value.followRecommendationUpdateValue);
        }
      }
      throw new UpdateException("Unknown actor update type!");
    }
    catch (UpdateException paramUpdate)
    {
      paramUpdate.printStackTrace();
      return null;
    }
    label178:
    if ((paramUpdate instanceof PymkUpdateDataModel))
    {
      paramUpdate = (PymkUpdateDataModel)paramUpdate;
      localObject = FeedPrimaryActorTransformer.toViewModel(paramUpdate, localFragmentComponent, false);
      if (localObject != null) {}
      for (paramUpdate = new FeedActorUpdateDetailViewModel(pegasusUpdate, localFeedComponentsViewPool, localFragmentComponent, (FeedComponentViewModel)localObject, pymkRecommendationBuilder);; paramUpdate = null) {
        return paramUpdate;
      }
    }
    label230:
    return null;
  }
  
  public final void doEnter()
  {
    super.doEnter();
    if (viewPortManager != null) {
      viewPortManager.trackAll(tracker);
    }
  }
  
  public final void doLeave()
  {
    super.doLeave();
    if (viewPortManager != null) {
      viewPortManager.untrackAll();
    }
  }
  
  public abstract void getDataModelsFromBundle(Bundle paramBundle);
  
  public int getDividerStartMargin()
  {
    return 2131493587;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent = fragmentComponent;
    fragmentComponent.inject(this);
    Bus.subscribe(this);
    paramBundle = getArguments();
    if (paramBundle != null) {
      getDataModelsFromBundle(paramBundle);
    }
    adapter = new FeedActorListAdapter(fragmentComponent);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return getActivity().getLayoutInflater().inflate(2130968705, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    if (recyclerView != null)
    {
      recyclerView.setAdapter(null);
      recyclerView.clearOnScrollListeners();
    }
    if (layoutManager != null)
    {
      layoutManager.mRecycleChildrenOnDetach = true;
      layoutManager = null;
    }
    Bus.unsubscribe(this);
    super.onDestroyView();
  }
  
  @Subscribe
  public void onEvent(InvitationUpdatedEvent paramInvitationUpdatedEvent)
  {
    Object localObject = adapter;
    paramInvitationUpdatedEvent = profileId;
    int i = 0;
    FeedActorUpdateDetailViewModel localFeedActorUpdateDetailViewModel;
    int j;
    if (i < values.size())
    {
      localFeedActorUpdateDetailViewModel = (FeedActorUpdateDetailViewModel)values.get(i);
      List localList = components;
      j = 0;
      label52:
      if (j < localList.size())
      {
        FeedComponentViewModel localFeedComponentViewModel = (FeedComponentViewModel)localList.get(j);
        if ((!(localFeedComponentViewModel instanceof FeedPrimaryActorViewModel)) || (!TextUtils.equals(paramInvitationUpdatedEvent, actorId))) {}
      }
    }
    for (paramInvitationUpdatedEvent = new Pair(localFeedActorUpdateDetailViewModel, Integer.valueOf(i));; paramInvitationUpdatedEvent = new Pair(null, Integer.valueOf(-1)))
    {
      localObject = (FeedActorUpdateDetailViewModel)first;
      i = ((Integer)second).intValue();
      if ((localObject != null) && (i != -1))
      {
        paramInvitationUpdatedEvent = transformUpdate((Update)pegasusModels.get(i));
        if (paramInvitationUpdatedEvent != null) {
          adapter.changeViewModel((ViewModel)localObject, paramInvitationUpdatedEvent);
        }
      }
      return;
      j += 1;
      break label52;
      i += 1;
      break;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if ((BaseActivity)getActivity() != null)
    {
      toolbar.setTitle(getTitle());
      toolbar.setNavigationOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = getActivity();
          Object localObject = BaseFeedActorListFragment.this;
          HomeIntent localHomeIntent = fragmentComponent.intentRegistry().home;
          localObject = ((BaseFeedActorListFragment)localObject).getActivity();
          HomeBundle localHomeBundle = new HomeBundle();
          activeTab = HomeTabInfo.FEED;
          NavigationUtils.navigateUp(paramAnonymousView, localHomeIntent.newIntent((Context)localObject, localHomeBundle), false);
        }
      });
    }
    layoutManager = new LinearLayoutManager((BaseActivity)getActivity());
    paramView = new DividerItemDecoration();
    paramView.setDivider(getResources(), 2130837654);
    paramView.setStartMargin(getResources(), getDividerStartMargin());
    recyclerView.addItemDecoration(paramView);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);
    recyclerView.setVerticalScrollBarEnabled(FeedLixHelper.showScrollbars(fragmentComponent.lixManager()));
    viewPortManager.container = recyclerView;
    recyclerView.addOnScrollListener(new RecyclerViewPortListener(viewPortManager));
    adapter.setViewPortManager(viewPortManager);
    if (pegasusModels != null)
    {
      paramView = pegasusModels;
      paramBundle = new ArrayList(paramView.size());
      int i = 0;
      while (i < paramView.size())
      {
        FeedActorUpdateDetailViewModel localFeedActorUpdateDetailViewModel = transformUpdate((Update)paramView.get(i));
        if (localFeedActorUpdateDetailViewModel != null) {
          paramBundle.add(localFeedActorUpdateDetailViewModel);
        }
        i += 1;
      }
      adapter.setValues(paramBundle);
    }
  }
  
  public final String provideDebugData()
  {
    if (layoutManager == null) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    int i = layoutManager.findFirstVisibleItemPosition();
    int j = layoutManager.findLastVisibleItemPosition();
    if ((i != -1) && (j != -1))
    {
      ArrayList localArrayList2 = new ArrayList();
      while ((i <= j) && (i < pegasusModels.size()))
      {
        Update localUpdate = (Update)pegasusModels.get(i);
        if (entityUrn != null) {
          localArrayList2.add(entityUrn.getId());
        }
        i += 1;
      }
      localArrayList1.add("Actor Update Ids:" + TextUtils.join(", ", localArrayList2));
    }
    return TextUtils.join("\n", localArrayList1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actorlist.BaseFeedActorListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */