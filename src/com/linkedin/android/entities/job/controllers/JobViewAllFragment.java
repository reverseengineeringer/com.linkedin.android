package com.linkedin.android.entities.job.controllers;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.EntityViewAllListBaseFragment;
import com.linkedin.android.entities.EntityViewAllListBaseFragment.DataLoadListener;
import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.entities.job.JobDataProvider.JobState;
import com.linkedin.android.entities.job.JobViewAllBundleBuilder;
import com.linkedin.android.entities.job.transformers.JobTransformer;
import com.linkedin.android.entities.job.transformers.JobViewAllTransformer;
import com.linkedin.android.entities.viewmodels.TextViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Job;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class JobViewAllFragment
  extends EntityViewAllListBaseFragment
{
  private ActivityComponent activityComponent;
  
  public static JobViewAllFragment newInstance(JobViewAllBundleBuilder paramJobViewAllBundleBuilder)
  {
    JobViewAllFragment localJobViewAllFragment = new JobViewAllFragment();
    localJobViewAllFragment.setArguments(paramJobViewAllBundleBuilder.build());
    return localJobViewAllFragment;
  }
  
  protected final EntityViewAllListBaseFragment.DataLoadListener getDataLoadListener()
  {
    final TrackingObject localTrackingObject = activityComponent.jobDataProvider().state).jobTrackingObject;
    switch (getArguments().getInt("pageType"))
    {
    default: 
      return null;
    }
    new EntityViewAllListBaseFragment.DataLoadListener(localTrackingObject)
    {
      protected final List<ViewModel> transformModels(CollectionTemplate<EntitiesMiniProfile, CollectionMetadata> paramAnonymousCollectionTemplate)
      {
        return JobViewAllTransformer.toViewAllEmployeesAtCompany(fragmentComponent, paramAnonymousCollectionTemplate, localTrackingObject);
      }
    };
  }
  
  protected final TrackingClosure<Void, Void> getOnErrorButtonClickClosure()
  {
    return null;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    activityComponent = getActivityactivityComponent;
    activityComponent.jobDataProvider().state).fromSubEntityPage = true;
    shouldTrackImpressions = EntityUtils.isLixEnabled(fragmentComponent.lixManager(), Lix.ENTITIES_SEE_ALL_ITEM_IMPRESSION_TRACKING);
    super.onActivityCreated(paramBundle);
  }
  
  public final String pageKey()
  {
    int i = getArguments().getInt("pageType");
    switch (i)
    {
    default: 
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Unable to determine page key for view all page type " + i));
      return "";
    case 0: 
      return "job_connections";
    case 1: 
      return "job_description";
    case 2: 
      return "job_poster_incommons";
    case 3: 
      return "job_top_companies";
    case 4: 
      return "job_top_schools";
    case 6: 
      return "job_company_alumni";
    case 5: 
      return "job_school_alumni";
    }
    return "job_description";
  }
  
  protected final void setupBackgroundColor()
  {
    if (getArguments().getInt("pageType") == 7)
    {
      recyclerView.setBackgroundColor(ContextCompat.getColor(getContext(), 2131623971));
      return;
    }
    super.setupBackgroundColor();
  }
  
  protected final List<ViewModel> setupInitialRows()
  {
    JobDataProvider localJobDataProvider = activityComponent.jobDataProvider();
    Object localObject3 = state).jobTrackingObject;
    int i = getArguments().getInt("pageType");
    Object localObject1 = null;
    CollectionTemplateHelper localCollectionTemplateHelper = null;
    String str = null;
    Object localObject2 = ((JobDataProvider.JobState)state).job();
    if (localObject2 == null)
    {
      showErrorPage();
      return null;
    }
    switch (i)
    {
    default: 
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("JobViewAllFragment does not support this page type: " + i));
      if ((localCollectionTemplateHelper != null) && (str != null))
      {
        if (CollectionUtils.isEmpty((Collection)localObject1))
        {
          localObject2 = localJobDataProvider.collectionCompletionCallback(busSubscriberId, getRumSessionId(), str, 2);
          localCollectionTemplateHelper.fetchInitialData(Tracker.createPageInstanceHeader(getPageInstance()), 2, str, (RecordTemplateListener)localObject2, getRumSessionId());
        }
        setupLoadMoreScrollListener(localCollectionTemplateHelper, str);
      }
      break;
    }
    for (;;)
    {
      return (List<ViewModel>)localObject1;
      if (companyName != null) {
        toolbar.setTitle(getLocalizedString(2131231010, new Object[] { companyName }));
      }
      localObject1 = (JobDataProvider.JobState)state;
      if (immediateConnectionsHelper != null) {}
      for (localObject1 = immediateConnectionsHelper.getCollectionTemplate();; localObject1 = null)
      {
        localObject1 = JobViewAllTransformer.toViewAllEmployeesAtCompany(fragmentComponent, (CollectionTemplate)localObject1, (TrackingObject)localObject3);
        localCollectionTemplateHelper = state).immediateConnectionsHelper;
        str = state).immediateConnectionsRoute;
        break;
      }
      toolbar.setTitle(getLocalizedString(2131230957));
      localObject1 = fragmentComponent;
      localObject3 = state).description;
      if (localObject3 == null)
      {
        localObject1 = null;
        break;
      }
      localObject2 = new TextViewModel();
      if (attributedText != null) {}
      for (localObject1 = AttributedTextUtils.getAttributedString(attributedText, ((FragmentComponent)localObject1).context(), null, null, true);; localObject1 = text)
      {
        text = ((CharSequence)localObject1);
        localObject1 = Collections.singletonList(localObject2);
        break;
      }
      toolbar.setTitle(getLocalizedString(2131230975));
      FragmentComponent localFragmentComponent = fragmentComponent;
      localObject1 = state).jobPosterInCommon;
      if (CollectionUtils.isEmpty((CollectionTemplate)localObject1))
      {
        localObject1 = null;
        break;
      }
      localObject2 = new ArrayList();
      Iterator localIterator = elements.iterator();
      for (;;)
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        MiniProfile localMiniProfile = (MiniProfile)localIterator.next();
        localObject1 = null;
        if (localObject3 != null) {
          localObject1 = JobTransformer.newJobImpressionTrackingClosure(trackingId, (TrackingObject)localObject3, firstName, Collections.singletonList(objectUrn.toString()));
        }
        ((List)localObject2).add(EntityTransformer.toConnectionItem(localFragmentComponent, activityactivityComponent, localMiniProfile, 1, (Closure)localObject1));
      }
      toolbar.setTitle(getLocalizedString(2131230988));
      localObject1 = JobViewAllTransformer.toViewAllTopCompanies(fragmentComponent, state).companyRankings, (TrackingObject)localObject3);
      break;
      toolbar.setTitle(getLocalizedString(2131230990));
      localObject1 = JobViewAllTransformer.toViewAllTopSchools(fragmentComponent, state).schoolRankings, (TrackingObject)localObject3);
      break;
      if (companyName != null) {
        toolbar.setTitle(getLocalizedString(2131230892, new Object[] { companyName }));
      }
      localCollectionTemplateHelper = new CollectionTemplateHelper(fragmentComponent.dataManager(), null, EntitiesMiniProfile.BUILDER, CollectionMetadata.BUILDER);
      str = state).companyRecruitsRoute;
      break;
      if (companyName != null) {
        toolbar.setTitle(getLocalizedString(2131230892, new Object[] { companyName }));
      }
      localCollectionTemplateHelper = new CollectionTemplateHelper(fragmentComponent.dataManager(), null, EntitiesMiniProfile.BUILDER, CollectionMetadata.BUILDER);
      str = state).schoolRecruitsRoute;
      break;
      toolbar.setTitle(getLocalizedString(2131230986));
      localObject1 = JobViewAllTransformer.toJobSummaryCards(fragmentComponent, state).jobSummary, (TrackingObject)localObject3);
      break;
      if (CollectionUtils.isEmpty((Collection)localObject1)) {
        showErrorPage();
      }
    }
  }
  
  protected final void setupItemDividers()
  {
    int i = getArguments().getInt("pageType");
    if ((i != 1) && (i != 7)) {
      super.setupItemDividers();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.controllers.JobViewAllFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */