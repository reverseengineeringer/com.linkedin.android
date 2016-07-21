package com.linkedin.android.relationships.invitations;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import butterknife.InjectView;
import com.linkedin.android.infra.LoadingAdapter;
import com.linkedin.android.infra.ScreenElement;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.CollectionDataProvider.CollectionDataProviderListener;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.app.ViewPagerFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.mergeAdapter.MergeAdapter;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.viewmodel.TrackableViewModelArrayAdapter;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.relationships.invitation.Invitation;
import com.linkedin.android.relationships.shared.InfiniteScrollListener;
import com.linkedin.android.relationships.shared.RelationshipsTracking;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent.Type;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public abstract class InvitationsListChildFragment
  extends ViewPagerFragment
  implements InvitationCellViewModelChangedListener
{
  private ViewModelArrayAdapter<InvitationAbiCardViewModel> abiCardAdapter;
  @Inject
  ActivityComponent activityComponent;
  @Inject
  FlagshipDataManager dataManager;
  private CollectionDataProvider.CollectionDataProviderListener<CollectionTemplate<Invitation, CollectionMetadata>> dataProviderListener;
  private ErrorPageViewModel errorPageViewModel;
  @InjectView(2131756773)
  ViewStub errorViewStub;
  @Inject
  FragmentComponent fragmentComponent;
  private InfiniteScrollListener infiniteScrollListener;
  InvitationsDataProvider invitationsDataProvider;
  private TrackableViewModelArrayAdapter<InvitationCellViewModel> invitationsListAdapter;
  private boolean isDataDisplayed;
  private boolean isFirstPageLoaded;
  @Inject
  LixManager lixManager;
  private LoadingAdapter loadingAdapter;
  int newInvitesCount;
  String query;
  @InjectView(2131758357)
  RecyclerView recyclerView;
  private List<ScreenElement> screenElements;
  
  protected static InvitationsDataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.invitationsDataProvider();
  }
  
  public final List<ScreenElement> getScreenElements()
  {
    if (screenElements == null)
    {
      screenElements = new ArrayList();
      screenElements.add(invitationsListAdapter);
    }
    return screenElements;
  }
  
  public abstract String listPageKey();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.eventBus();
    Bus.subscribe(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969361, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    if (invitationsDataProvider != null) {
      invitationsDataProvider.removeListener(dataProviderListener);
    }
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
    super.onDestroy();
  }
  
  @Subscribe
  public void onEvent(InvitationUpdatedEvent paramInvitationUpdatedEvent)
  {
    if ((type == InvitationUpdatedEvent.Type.IGNORE) || (type == InvitationUpdatedEvent.Type.ACCEPT))
    {
      int k = 0;
      int j = invitationsListAdapter.getValues().size() - 1;
      if (j >= 0)
      {
        InvitationCellViewModel localInvitationCellViewModel = (InvitationCellViewModel)invitationsListAdapter.getValues().get(j);
        int i = k;
        if (TextUtils.equals(profileId, profileId))
        {
          if (type != InvitationUpdatedEvent.Type.IGNORE) {
            break label114;
          }
          invitationsListAdapter.getValues().remove(j);
          i = 1;
        }
        for (;;)
        {
          j -= 1;
          k = i;
          break;
          label114:
          i = k;
          if (type == InvitationUpdatedEvent.Type.ACCEPT)
          {
            i = k;
            if (!isConnected)
            {
              isConnected = true;
              i = 1;
            }
          }
        }
      }
      if (k != 0) {
        invitationsListAdapter.notifyDataSetChanged();
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    errorPageViewModel = new ErrorPageViewModel(errorViewStub);
    query = getArguments().getString("key_query");
    invitationsListAdapter = new TrackableViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter());
    invitationsListAdapter.enablePageViewTracking(tracker, delayedExecution, listPageKey(), RelationshipsTracking.getListPageSize(fragmentComponent));
    loadingAdapter = new LoadingAdapter();
    if ((BaseActivity)getActivity() != null)
    {
      dataProviderListener = new InvitationsListChildFragment.2(this);
      invitationsDataProvider = getActivityactivityComponent.invitationsDataProvider();
      invitationsDataProvider.addListener(dataProviderListener);
    }
    paramView = new MergeAdapter();
    paramView.addAdapter(invitationsListAdapter);
    if (!"control".equals(fragmentComponent.lixManager().getTreatment(Lix.LIX_GROWTH_ABI_PENDING_INVITATIONS_SHOW_ABI))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        abiCardAdapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), null);
        paramView.addAdapter(abiCardAdapter);
      }
      paramView.addAdapter(loadingAdapter);
      recyclerView.setAdapter(paramView);
      recyclerView.setLayoutManager(new LinearLayoutManager((BaseActivity)getActivity()));
      infiniteScrollListener = new InvitationsListChildFragment.1(this);
      recyclerView.addOnScrollListener(infiniteScrollListener);
      return;
    }
  }
  
  public final void removeInvitation(InvitationCellViewModel paramInvitationCellViewModel)
  {
    int i = invitationsListAdapter.getValues().indexOf(paramInvitationCellViewModel);
    if (i >= 0)
    {
      invitationsListAdapter.getValues().remove(i);
      invitationsListAdapter.notifyItemRemoved(i);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.invitations.InvitationsListChildFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */