package com.linkedin.android.entities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.linkedin.android.entities.company.CompanyDataProvider.CompanyState;
import com.linkedin.android.entities.company.controllers.CompanyFragment;
import com.linkedin.android.entities.job.JobDataProvider.JobState;
import com.linkedin.android.entities.job.controllers.JobFragment;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.app.TrackableFragment.EnterTooEarlyException;
import com.linkedin.android.infra.app.ViewPagerFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import javax.inject.Inject;

public abstract class EntityBaseTabFragment
  extends ViewPagerFragment
{
  public static final String TAG = EntityBaseTabFragment.class.getSimpleName();
  private ActivityComponent activityComponent;
  @Inject
  Bus eventBus;
  public boolean isLoadedFromNetwork;
  private boolean isToastPromoToDisplay;
  protected RecyclerViewPortListener listener;
  protected LinearLayoutManager recyclerLayoutManager;
  @InjectView(2131755476)
  public RecyclerView recyclerView;
  private RecyclerView.OnScrollListener scrollListener = new RecyclerView.OnScrollListener()
  {
    public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
      if ((paramAnonymousInt2 > 0) && (!isToastPromoToDisplay) && (!EntityBaseTabFragment.this.isPromoDisplayed())) {
        EntityBaseTabFragment.access$200(EntityBaseTabFragment.this);
      }
    }
  };
  protected boolean useImpressionTracking;
  protected ViewPortManager viewPortManager;
  
  private boolean isPromoDisplayed()
  {
    return (ViewGroup)getActivity().getWindow().findViewById(2131758658) != null;
  }
  
  public String crossPromoPageKey()
  {
    return null;
  }
  
  public void doEnter()
    throws TrackableFragment.EnterTooEarlyException
  {
    super.doEnter();
    toggleImpressionTracking(true);
  }
  
  public final void doLeave()
  {
    super.doLeave();
    toggleImpressionTracking(false);
  }
  
  public final void initImpressionTracking(ViewModelArrayAdapter paramViewModelArrayAdapter)
  {
    useImpressionTracking = true;
    viewPortManager = applicationComponent.viewportManager();
    viewPortManager.container = recyclerView;
    paramViewModelArrayAdapter.setViewPortManager(viewPortManager);
    listener = new RecyclerViewPortListener(viewPortManager);
    toggleImpressionTracking(true);
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968680, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    recyclerLayoutManager = null;
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ButterKnife.inject(this, paramView);
    fragmentComponent.inject(this);
    activityComponent = getActivityactivityComponent;
    recyclerLayoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(recyclerLayoutManager);
    applicationComponent.crossPromoManager();
    paramView = getParentFragment();
    boolean bool;
    if ((isToastPromoToDisplay) || (isPromoDisplayed()))
    {
      paramBundle = (ViewGroup)getActivity().getWindow().findViewById(2131756510);
      bool = false;
      if (!(paramView instanceof JobFragment)) {
        break label200;
      }
    }
    label199:
    label200:
    label242:
    do
    {
      bool = getActivityactivityComponent.jobDataProvider().state).fromSubEntityPage;
      break label199;
      if (bool)
      {
        paramBundle.setVisibility(8);
        paramBundle.removeAllViews();
      }
      for (;;)
      {
        if (!(paramView instanceof CompanyFragment)) {
          break label242;
        }
        if (!getActivityactivityComponent.companyDataProvider().state).toastDisplayed) {
          recyclerView.addOnScrollListener(scrollListener);
        }
        return;
        if (!(paramView instanceof CompanyFragment)) {
          break;
        }
        bool = getActivityactivityComponent.companyDataProvider().state).fromSubEntityPage;
        break;
        paramBundle.bringToFront();
      }
    } while ((!(paramView instanceof JobFragment)) || (getActivityactivityComponent.jobDataProvider().state).toastDisplayed));
    recyclerView.addOnScrollListener(scrollListener);
  }
  
  public final void scrollRecyclerToPosition$13462e()
  {
    if (recyclerLayoutManager != null) {
      recyclerLayoutManager.scrollToPosition(0);
    }
  }
  
  public final boolean shouldTrack()
  {
    return isLoadedFromNetwork;
  }
  
  protected final void toggleImpressionTracking(boolean paramBoolean)
  {
    if ((useImpressionTracking) && (viewPortManager != null) && (recyclerView != null))
    {
      if (paramBoolean)
      {
        viewPortManager.trackAll(tracker);
        recyclerView.addOnScrollListener(listener);
      }
    }
    else {
      return;
    }
    viewPortManager.untrackAll();
    recyclerView.removeOnScrollListener(listener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityBaseTabFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */