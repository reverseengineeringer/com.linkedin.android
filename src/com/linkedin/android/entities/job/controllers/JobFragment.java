package com.linkedin.android.entities.job.controllers;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.android.axle.SplashPromoInflater;
import com.linkedin.android.axle.ToastPromoInflater;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.entities.EntityCoordinatorBaseFragment;
import com.linkedin.android.entities.job.JobBundleBuilder;
import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.entities.job.JobDataProvider.JobState;
import com.linkedin.android.entities.job.JobPagerAdapter;
import com.linkedin.android.entities.job.transformers.JobTransformer;
import com.linkedin.android.entities.shared.events.DataUpdatedEvent;
import com.linkedin.android.entities.shared.events.EntitiesTabSwitchEvent;
import com.linkedin.android.entities.viewholders.EntityDetailedTopCardViewHolder;
import com.linkedin.android.entities.viewmodels.EntityDetailedTopCardViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.DrawableHelper;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.ui.ViewPager;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Job;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobViewEvent.Builder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.Subscribe;

@Deprecated
public final class JobFragment
  extends EntityCoordinatorBaseFragment
{
  private ActivityComponent activityComponent;
  private boolean crossPromoShowed;
  private boolean fromPromo;
  private boolean isMemberPremium;
  private JobDataProvider jobDataProvider;
  private String jobId;
  private EntityDetailedTopCardViewHolder topCardViewHolder;
  private EntityDetailedTopCardViewModel topCardViewModel;
  
  private String crossPromoPageKey(String paramString)
  {
    return applicationComponent.tracker().trackingCodePrefix + "_" + paramString;
  }
  
  public static JobFragment newInstance(JobBundleBuilder paramJobBundleBuilder)
  {
    JobFragment localJobFragment = new JobFragment();
    localJobFragment.setArguments(paramJobBundleBuilder.build());
    return localJobFragment;
  }
  
  private void refreshTopCardButtonsAndDetail()
  {
    Object localObject = ((JobDataProvider.JobState)jobDataProvider.state).job();
    if ((localObject == null) || (topCardViewModel == null)) {
      return;
    }
    localObject = JobTransformer.toTopCard(fragmentComponent, jobDataProvider, (Job)localObject);
    ((EntityDetailedTopCardViewModel)localObject).bindPrimaryButtonClickedText(topCardViewHolder);
    ((EntityDetailedTopCardViewModel)localObject).bindPrimaryButtonText(topCardViewHolder);
    if (topCardViewModel.isSecondaryButtonClicked != isSecondaryButtonClicked) {
      ((EntityDetailedTopCardViewModel)localObject).bindSecondaryButtonText(topCardViewHolder);
    }
    if (!TextUtils.equals(topCardViewModel.detail, detail)) {
      ((EntityDetailedTopCardViewModel)localObject).bindDetailText(topCardViewHolder);
    }
    jobDataProvider.state).jobUpdated = false;
    topCardViewModel = ((EntityDetailedTopCardViewModel)localObject);
  }
  
  public final void doPause()
  {
    super.doPause();
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    Object localObject = (JobDataProvider.JobState)jobDataProvider.state;
    if (isMemberPremium != fragmentComponent.memberUtil().isPremium())
    {
      isMemberPremium = fragmentComponent.memberUtil().isPremium();
      jobNeedsRefetch = true;
    }
    if (jobNeedsRefetch)
    {
      jobDataProvider.fetchJob(busSubscriberId, getRumSessionId(), jobId, Tracker.createPageInstanceHeader(getPageInstance()));
      jobNeedsRefetch = false;
    }
    fragmentComponent.eventBus();
    Bus.subscribe(this);
    if (jobUpdated) {
      refreshTopCardButtonsAndDetail();
    }
    if (jobDataProvider.state).submittedJobApplication)
    {
      jobDataProvider.state).submittedJobApplication = false;
      localObject = (ViewGroup)getActivity().getWindow().findViewById(2131755475);
      if ((localObject != null) && (getResourcesgetConfigurationorientation == 1) && (!((JobDataProvider.JobState)jobDataProvider.state).isSplashDisplayed("job_applied")) && (!fromPromo))
      {
        jobDataProvider.state).lastSplashPromoPagekey = "job_applied";
        new SplashPromoInflater((ViewGroup)localObject, fragmentComponent).fetchPromo(crossPromoPageKey("job_applied"), null);
      }
    }
  }
  
  protected final TrackingClosure<Void, Void> getOnErrorButtonClickClosure()
  {
    new TrackingClosure(tracker, "try_again") {};
  }
  
  protected final ViewHolderCreator<EntityDetailedTopCardViewHolder> getViewHolderCreator()
  {
    return EntityDetailedTopCardViewHolder.CREATOR;
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    String str = jobDataProvider.state).jobRoute;
    if ((paramSet != null) && (str != null) && (paramSet.contains(str))) {
      super.onDataError(paramType, paramSet, paramDataManagerException);
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    Object localObject = jobDataProvider.state).jobRoute;
    if ((paramSet != null) && (localObject != null) && (paramSet.contains(localObject)))
    {
      localObject = ((JobDataProvider.JobState)jobDataProvider.state).job();
      if (localObject == null) {
        showErrorPage();
      }
    }
    label351:
    label367:
    do
    {
      do
      {
        return;
        topCardViewModel = JobTransformer.toTopCard(fragmentComponent, jobDataProvider, (Job)localObject);
        topCardViewModel.onBindViewHolder(activityComponent.activity().getLayoutInflater(), applicationComponent.mediaCenter(), topCardViewHolder);
        setTitle(miniJob.title);
        Tracker localTracker;
        FlagshipJobViewEvent.Builder localBuilder;
        if (DataStore.Type.NETWORK.equals(paramType))
        {
          localObject = ((JobDataProvider.JobState)jobDataProvider.state).initJobTrackingObjectFromNetwork();
          if (localObject != null)
          {
            localTracker = fragmentComponent.tracker();
            localBuilder = new FlagshipJobViewEvent.Builder();
            if (localObject != null) {
              break label351;
            }
            hasJob = false;
          }
        }
        for (job = null;; job = ((TrackingObject)localObject))
        {
          localTracker.send(localBuilder);
          setupTabs(new JobPagerAdapter(fragmentComponent, getChildFragmentManager(), jobDataProvider), true);
          super.onDataReady(paramType, paramSet, paramMap);
          if ((((JobDataProvider.JobState)jobDataProvider.state).job() == null) || (crossPromoShowed) || (getActivity() == null) || (getResourcesgetConfigurationorientation != 1)) {
            break;
          }
          paramType = crossPromoPageKey("job");
          paramSet = ((JobDataProvider.JobState)jobDataProvider.state).getCrossPromo(paramType);
          if (!SplashPromoInflater.isSplashPromo(paramSet)) {
            break label367;
          }
          paramMap = (ViewGroup)getActivity().getWindow().findViewById(2131755475);
          if (paramMap == null) {
            break;
          }
          crossPromoShowed = true;
          new SplashPromoInflater(paramMap, fragmentComponent).renderPromoModel(paramType, null, new PromoModel(paramSet));
          return;
          hasJob = true;
        }
      } while (!ToastPromoInflater.isToastPromo(paramSet));
      paramMap = (ViewGroup)getActivity().getWindow().findViewById(2131756510);
    } while (paramMap == null);
    paramMap.bringToFront();
    crossPromoShowed = true;
    new ToastPromoInflater(paramMap, fragmentComponent.eventBus()).renderPromoModel(paramType, null, new PromoModel(paramSet));
  }
  
  @Subscribe
  public final void onEvent(DataUpdatedEvent paramDataUpdatedEvent)
  {
    if ((busSubscriberId.equals(subscriberId)) && (((RecordTemplate)((JobDataProvider.JobState)jobDataProvider.state).getModel(modelKey) instanceof Job)) && (isAdded())) {
      refreshTopCardButtonsAndDetail();
    }
  }
  
  @Subscribe
  public final void onEvent(EntitiesTabSwitchEvent paramEntitiesTabSwitchEvent)
  {
    paramEntitiesTabSwitchEvent = tabType;
    JobPagerAdapter localJobPagerAdapter = (JobPagerAdapter)viewPager.getAdapter();
    if (localJobPagerAdapter != null) {
      viewPager.setCurrentItem(localJobPagerAdapter.getTabPosition(paramEntitiesTabSwitchEvent));
    }
  }
  
  protected final boolean onMenuClick(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131758748)
    {
      trackButtonShortPress("job_share");
      startActivity(Intent.createChooser(JobTransformer.newJobShareIntent(fragmentComponent, jobId, ((JobDataProvider.JobState)jobDataProvider.state).job()), getString(2131231044)));
      return true;
    }
    return super.onMenuClick(paramMenuItem);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    activityComponent = getActivityactivityComponent;
    jobDataProvider = activityComponent.jobDataProvider();
    jobId = getArguments().getString("getJobId");
    fromPromo = getArguments().getBoolean("fromPromo");
    topCardViewHolder = ((EntityDetailedTopCardViewHolder)EntityDetailedTopCardViewHolder.CREATOR.createViewHolder(topCard));
    isMemberPremium = fragmentComponent.memberUtil().isPremium();
    if (jobDataProvider.isDataAvailable())
    {
      onDataReady(DataStore.Type.LOCAL, Collections.singleton(jobDataProvider.state).jobRoute), null);
      return;
    }
    loadingSpinner.setVisibility(0);
    Object localObject = getArguments().getString("jobUrn");
    paramView = jobDataProvider;
    paramBundle = new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<MiniJob> paramAnonymousDataStoreResponse)
      {
        if ((error != null) || (model == null) || (jobDataProvider.isDataAvailable())) {
          return;
        }
        JobTransformer.preFillTopCard(fragmentComponent, topCardViewHolder, (MiniJob)model);
      }
    };
    localObject = Request.get().cacheKey((String)localObject);
    activityComponent.dataManager().submit(((Request.Builder)localObject).builder(MiniJob.BUILDER).listener(paramBundle).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
    paramView = (JobDataProvider.JobState)jobDataProvider.state;
    paramBundle = applicationComponent.tracker().trackingCodePrefix + "_job";
    if ((paramView.getCrossPromo(paramBundle) == null) && (!fromPromo)) {
      jobDataProvider.fetchCrossPromo(paramBundle, busSubscriberId, getRumSessionId());
    }
    jobDataProvider.fetchJob(busSubscriberId, getRumSessionId(), jobId, Tracker.createPageInstanceHeader(getPageInstance()));
  }
  
  public final String pageKey()
  {
    return "job";
  }
  
  protected final void setupToolbar()
  {
    super.setupToolbar();
    if (isAdded())
    {
      toolbar.inflateMenu(2131820547);
      MenuItem localMenuItem = toolbar.getMenu().findItem(2131758748);
      localMenuItem.setIcon(DrawableHelper.setTint(localMenuItem.getIcon(), ResourcesCompat.getColor(getResources(), 2131624058, getActivity().getTheme())));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.controllers.JobFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */