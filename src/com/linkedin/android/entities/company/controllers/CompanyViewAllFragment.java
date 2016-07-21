package com.linkedin.android.entities.company.controllers;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.EntityViewAllListBaseFragment;
import com.linkedin.android.entities.EntityViewAllListBaseFragment.DataLoadListener;
import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.entities.company.CompanyDataProvider.CompanyState;
import com.linkedin.android.entities.company.CompanyViewAllBundleBuilder;
import com.linkedin.android.entities.company.transformers.CompanyViewAllTransformer;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.DividerItemDecoration;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.company.Company;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.Collection;
import java.util.List;

public final class CompanyViewAllFragment
  extends EntityViewAllListBaseFragment
{
  private ActivityComponent activityComponent;
  
  public static CompanyViewAllFragment newInstance(CompanyViewAllBundleBuilder paramCompanyViewAllBundleBuilder)
  {
    CompanyViewAllFragment localCompanyViewAllFragment = new CompanyViewAllFragment();
    localCompanyViewAllFragment.setArguments(paramCompanyViewAllBundleBuilder.build());
    return localCompanyViewAllFragment;
  }
  
  protected final EntityViewAllListBaseFragment.DataLoadListener getDataLoadListener()
  {
    final CompanyDataProvider localCompanyDataProvider = activityComponent.companyDataProvider();
    final TrackingObject localTrackingObject = state).companyTrackingObject;
    switch (getArguments().getInt("pageType"))
    {
    case 2: 
    case 5: 
    default: 
      return null;
    case 0: 
      new EntityViewAllListBaseFragment.DataLoadListener(localTrackingObject)
      {
        protected final List<ViewModel> transformModels(CollectionTemplate<MiniJob, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramAnonymousCollectionTemplate)
        {
          return CompanyViewAllTransformer.toViewAllJobsList(fragmentComponent, paramAnonymousCollectionTemplate, localTrackingObject);
        }
      };
    case 3: 
      new EntityViewAllListBaseFragment.DataLoadListener(localTrackingObject)
      {
        protected final List<ViewModel> transformModels(CollectionTemplate<MiniJob, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramAnonymousCollectionTemplate)
        {
          return CompanyViewAllTransformer.toViewAllJobsThatMatchedYourSkillsList(fragmentComponent, paramAnonymousCollectionTemplate, localTrackingObject);
        }
      };
    case 1: 
    case 6: 
    case 7: 
      new EntityViewAllListBaseFragment.DataLoadListener(localTrackingObject)
      {
        protected final List<ViewModel> transformModels(CollectionTemplate<EntitiesMiniProfile, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramAnonymousCollectionTemplate)
        {
          return CompanyViewAllTransformer.toViewAllImmediateConnectionsList(fragmentComponent, paramAnonymousCollectionTemplate, localTrackingObject);
        }
      };
    case 4: 
      new EntityViewAllListBaseFragment.DataLoadListener(localCompanyDataProvider)
      {
        protected final List<ViewModel> transformModels(CollectionTemplate<InCommonPerson, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramAnonymousCollectionTemplate)
        {
          Object localObject = ((CompanyDataProvider.CompanyState)localCompanyDataProviderstate).company();
          if (localObject == null) {
            return null;
          }
          localObject = basicCompanyInfo.miniCompany.name;
          return CompanyViewAllTransformer.toViewAllIntroducersList(fragmentComponent, localCompanyDataProvider, paramAnonymousCollectionTemplate, (String)localObject, localTrackingObject);
        }
      };
    }
    new EntityViewAllListBaseFragment.DataLoadListener(localTrackingObject)
    {
      protected final List<ViewModel> transformModels(CollectionTemplate<InCommonCompany, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> paramAnonymousCollectionTemplate)
      {
        return CompanyViewAllTransformer.toViewAllCommonCompaniesAlumniList(fragmentComponent, paramAnonymousCollectionTemplate, localTrackingObject);
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
    activityComponent.companyDataProvider().state).fromSubEntityPage = true;
    shouldTrackImpressions = EntityUtils.isLixEnabled(fragmentComponent.lixManager(), Lix.ENTITIES_SEE_ALL_ITEM_IMPRESSION_TRACKING);
    super.onActivityCreated(paramBundle);
  }
  
  public final String pageKey()
  {
    int i = getArguments().getInt("pageType");
    switch (i)
    {
    default: 
      Util.safeThrow(new RuntimeException("Unable to determine page key for view all page type " + i));
      return "";
    case 0: 
      return "company_jobs_all";
    case 1: 
    case 6: 
      return "company_connections";
    case 2: 
      return "company_showcases";
    case 3: 
      return "company_jobs_matched";
    case 4: 
      return "company_introducers_all";
    case 5: 
      return "company_introducers_connections";
    case 7: 
      return "company_alum_at_company";
    }
    return "company_incommon_companies";
  }
  
  protected final void setupBackgroundColor()
  {
    if (getArguments().getInt("pageType") == 4)
    {
      recyclerView.setBackgroundColor(ContextCompat.getColor(getContext(), 2131623971));
      return;
    }
    super.setupBackgroundColor();
  }
  
  protected final List<ViewModel> setupInitialRows()
  {
    Object localObject3 = activityComponent.companyDataProvider();
    TrackingObject localTrackingObject = state).companyTrackingObject;
    int i = getArguments().getInt("pageType");
    Object localObject1 = null;
    Object localObject2 = null;
    String str = null;
    Company localCompany = ((CompanyDataProvider.CompanyState)state).company();
    if (localCompany == null)
    {
      showErrorPage();
      return null;
    }
    switch (i)
    {
    default: 
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("CompanyViewAllFragment does not support this page type: " + i));
      if ((localObject2 != null) && (str != null))
      {
        if (CollectionUtils.isEmpty((Collection)localObject1))
        {
          localObject3 = ((CompanyDataProvider)localObject3).collectionCompletionCallback(busSubscriberId, getRumSessionId(), str, 2);
          ((CollectionTemplateHelper)localObject2).fetchInitialData(Tracker.createPageInstanceHeader(getPageInstance()), 2, str, (RecordTemplateListener)localObject3, getRumSessionId());
        }
        setupLoadMoreScrollListener((CollectionTemplateHelper)localObject2, str);
      }
      break;
    }
    for (;;)
    {
      return (List<ViewModel>)localObject1;
      localObject1 = (CompanyDataProvider.CompanyState)state;
      if (allJobsHelper != null) {}
      for (localObject1 = allJobsHelper.getCollectionTemplate();; localObject1 = null)
      {
        toolbar.setTitle(getLocalizedString(2131230855, new Object[] { basicCompanyInfo.miniCompany.name }));
        localObject1 = CompanyViewAllTransformer.toViewAllJobsList(fragmentComponent, (CollectionTemplate)localObject1, localTrackingObject);
        localObject2 = state).allJobsHelper;
        str = state).allJobsRoute;
        break;
      }
      toolbar.setTitle(getLocalizedString(2131231010, new Object[] { basicCompanyInfo.miniCompany.name }));
      localObject2 = fragmentComponent;
      localObject1 = (CompanyDataProvider.CompanyState)state;
      if (immediateConnectionsHelper != null) {}
      for (localObject1 = immediateConnectionsHelper.getCollectionTemplate();; localObject1 = null)
      {
        localObject1 = CompanyViewAllTransformer.toViewAllImmediateConnectionsList((FragmentComponent)localObject2, (CollectionTemplate)localObject1, localTrackingObject);
        localObject2 = state).immediateConnectionsHelper;
        str = state).immediateConnectionsRoute;
        break;
      }
      toolbar.setTitle(getLocalizedString(2131231049, new Object[] { basicCompanyInfo.miniCompany.name }));
      localObject1 = CompanyViewAllTransformer.toViewAllShowcasesList(fragmentComponent, state).showcases, localTrackingObject);
      break;
      toolbar.setTitle(getLocalizedString(2131230997));
      localObject2 = fragmentComponent;
      localObject1 = (CompanyDataProvider.CompanyState)state;
      if (matchedJobsHelper != null) {}
      for (localObject1 = matchedJobsHelper.getCollectionTemplate();; localObject1 = null)
      {
        localObject1 = CompanyViewAllTransformer.toViewAllJobsThatMatchedYourSkillsList((FragmentComponent)localObject2, (CollectionTemplate)localObject1, localTrackingObject);
        localObject2 = state).matchedJobsHelper;
        str = state).matchedJobsRoute;
        break;
      }
      CollectionTemplate localCollectionTemplate = state).introducersHelper.getCollectionTemplate();
      if (paging == null) {
        break;
      }
      toolbar.setTitle(getLocalizedString(2131230943, new Object[] { Integer.valueOf(paging.total) }));
      localObject1 = basicCompanyInfo.miniCompany.name;
      localObject1 = CompanyViewAllTransformer.toViewAllIntroducersList(fragmentComponent, (CompanyDataProvider)localObject3, localCollectionTemplate, (String)localObject1, localTrackingObject);
      localObject2 = state).introducersHelper;
      str = state).introducersRoute;
      break;
      toolbar.setTitle(getArguments().getString("pageTitle"));
      localObject1 = CompanyViewAllTransformer.toViewAllIntroducerInCommonsList(fragmentComponent, state).inCommonPeople, localTrackingObject);
      break;
      toolbar.setTitle(getLocalizedString(2131230892, new Object[] { basicCompanyInfo.miniCompany.name }));
      localObject2 = fragmentComponent;
      localObject1 = (CompanyDataProvider.CompanyState)state;
      if (employeesHelper != null) {}
      for (localObject1 = employeesHelper.getCollectionTemplate();; localObject1 = null)
      {
        localObject1 = CompanyViewAllTransformer.toViewAllImmediateConnectionsList((FragmentComponent)localObject2, (CollectionTemplate)localObject1, localTrackingObject);
        localObject2 = state).employeesHelper;
        str = state).employeesRoute;
        break;
      }
      toolbar.setTitle(getLocalizedString(2131230892, new Object[] { basicCompanyInfo.miniCompany.name }));
      localObject2 = new CollectionTemplateHelper(fragmentComponent.dataManager(), null, EntitiesMiniProfile.BUILDER, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata.BUILDER);
      str = state).companyRecruitsRoute;
      break;
      toolbar.setTitle(getLocalizedString(2131230892, new Object[] { basicCompanyInfo.miniCompany.name }));
      localObject2 = fragmentComponent;
      localObject1 = (CompanyDataProvider.CompanyState)state;
      if (commonCompaniesAlumniHelper != null) {}
      for (localObject1 = commonCompaniesAlumniHelper.getCollectionTemplate();; localObject1 = null)
      {
        localObject1 = CompanyViewAllTransformer.toViewAllCommonCompaniesAlumniList((FragmentComponent)localObject2, (CollectionTemplate)localObject1, localTrackingObject);
        localObject2 = state).commonCompaniesAlumniHelper;
        str = state).commonCompaniesAlumniRoute;
        break;
      }
      if (CollectionUtils.isEmpty((Collection)localObject1)) {
        showErrorPage();
      }
    }
  }
  
  public final void setupItemDividers()
  {
    int i = getArguments().getInt("pageType");
    if (i == 3)
    {
      localDividerItemDecoration = new DividerItemDecoration(1);
      localActivityComponent = getActivityactivityComponent;
      localDividerItemDecoration.setEndMargin$7828b937(localActivityComponent.context().getResources());
      localDividerItemDecoration.setStartMargin(localActivityComponent.context().getResources(), 2131493094);
      localDividerItemDecoration.setDivider(localActivityComponent.context().getResources(), 2130837654);
      recyclerView.addItemDecoration(localDividerItemDecoration);
    }
    while (i == 4)
    {
      DividerItemDecoration localDividerItemDecoration;
      ActivityComponent localActivityComponent;
      return;
    }
    super.setupItemDividers();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.controllers.CompanyViewAllFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */