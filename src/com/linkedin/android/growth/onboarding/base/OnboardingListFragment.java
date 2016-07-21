package com.linkedin.android.growth.onboarding.base;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import butterknife.InjectView;
import butterknife.Optional;
import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.performance.RUMHelper;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.perftimer.RUMTiming;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public abstract class OnboardingListFragment<M extends FissileDataModel<M>, T extends ViewModel>
  extends LegoFragment
{
  public ViewModelArrayAdapter<T> adapter;
  @InjectView(2131756106)
  @Optional
  public Button addAllButton;
  @Inject
  FlagshipDataManager dataManager;
  @Inject
  Bus eventBus;
  public boolean fromCache;
  @InjectView(2131756107)
  public Button nextButton;
  @InjectView(2131755940)
  public RecyclerView recyclerView;
  
  public final void doPause()
  {
    super.doPause();
    Bus.unsubscribe(this);
    fromCache = false;
  }
  
  public final void doResume()
  {
    super.doResume();
    Bus.subscribe(this);
  }
  
  public final OnboardingDataProvider getDataProvider()
  {
    return fragmentComponent.activity().activityComponent.onboardingDataProvider();
  }
  
  public abstract void initialize();
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    paramView = new LinearLayoutManager(recyclerView.getContext());
    adapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), null);
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(paramView);
    if ((!fromCache) && (rumSessionId != null)) {
      RUMTiming.renderStart(rumSessionId, false);
    }
    initialize();
    if ((!fromCache) && (rumSessionId != null)) {
      RUMHelper.callRenderEndOnNextLoop(rumSessionId, false);
    }
  }
  
  public final List<T> transformModelCollection(List<M> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = Util.safeGet(paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (FissileDataModel)paramList.next();
      if (localObject == null) {
        break;
      }
      localObject = transformToViewModel((FissileDataModel)localObject);
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public abstract T transformToViewModel(M paramM);
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.base.OnboardingListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */