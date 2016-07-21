package com.linkedin.android.entities.company.controllers;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.linkedin.android.axle.PromoListener;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.entities.EntityCoordinatorBaseFragment;
import com.linkedin.android.entities.EntityPagerAdapter;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.company.CompanyBundleBuilder;
import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.entities.company.CompanyDataProvider.CompanyState;
import com.linkedin.android.entities.company.CompanyPagerAdapterV2;
import com.linkedin.android.entities.company.transformers.CompanyTransformer;
import com.linkedin.android.entities.shared.events.DataUpdatedEvent;
import com.linkedin.android.entities.viewholders.EntityDetailedTopCardViewHolder;
import com.linkedin.android.entities.viewmodels.EntityDetailedTopCardViewModel;
import com.linkedin.android.growth.seo.appindexing.GoogleAppIndexingManager;
import com.linkedin.android.infra.FragmentReferencingPagerAdapter;
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
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.ViewPager;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.company.Company;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyViewEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipShowcaseViewEvent.Builder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.Subscribe;

public class CompanyFragment
  extends EntityCoordinatorBaseFragment
{
  private static final String TAG = CompanyFragment.class.getSimpleName();
  private ActivityComponent activityComponent;
  private Action appIndexPageViewAction;
  private CompanyDataProvider companyDataProvider;
  private String companyId;
  private String companyName;
  private GoogleApiClient googleApiClient;
  private boolean isShowcase;
  private EntityDetailedTopCardViewHolder topCardViewHolder;
  private EntityDetailedTopCardViewModel topCardViewModel;
  
  private void fetchCompany(Map<String, String> paramMap)
  {
    CompanyDataProvider localCompanyDataProvider;
    String str1;
    String str2;
    Object localObject;
    if (companyId != null)
    {
      localCompanyDataProvider = companyDataProvider;
      str1 = busSubscriberId;
      str2 = getRumSessionId();
      localCompanyDataProvider.initRoutesGivenCompanyId(companyId);
      localObject = state).companyRoute;
      if (localObject != null) {
        localCompanyDataProvider.performFetch(Company.BUILDER, (String)localObject, str1, str2, paramMap);
      }
      return;
    }
    if (companyName != null)
    {
      localCompanyDataProvider = companyDataProvider;
      str1 = busSubscriberId;
      str2 = getRumSessionId();
      localObject = companyName;
      localObject = Routes.COMPANY.buildUponRoot().buildUpon().appendQueryParameter("q", "name").appendQueryParameter("name", (String)localObject).build();
      state).findCompanyByNameRoute = CompanyDataProvider.buildWithSupportedItems((Uri)localObject).toString();
      localCompanyDataProvider.performFetch(CollectionTemplate.of(Company.BUILDER), state).findCompanyByNameRoute, str1, str2, paramMap);
      return;
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("Company Id AND Universal Name are both null!!"));
  }
  
  public static CompanyFragment newInstance(CompanyBundleBuilder paramCompanyBundleBuilder)
  {
    CompanyFragment localCompanyFragment = new CompanyFragment();
    localCompanyFragment.setArguments(paramCompanyBundleBuilder.build());
    return localCompanyFragment;
  }
  
  private void refreshTopCardButtonAndText()
  {
    Object localObject1 = ((CompanyDataProvider.CompanyState)companyDataProvider.state).company();
    if ((localObject1 == null) || (topCardViewHolder == null) || (topCardViewModel == null)) {
      return;
    }
    localObject1 = CompanyTransformer.transformTopCard(fragmentComponent, companyDataProvider, (Company)localObject1);
    Object localObject2 = topCardViewModel;
    if ((!TextUtils.equals(title, title)) || (!TextUtils.equals(subtitle1, subtitle1)) || (!TextUtils.equals(subtitle2, subtitle2))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((EntityDetailedTopCardViewModel)localObject1).bindText(topCardViewHolder);
      }
      if (topCardViewModel.isPrimaryButtonClicked != isPrimaryButtonClicked)
      {
        localObject2 = topCardViewHolder;
        ((EntityDetailedTopCardViewModel)localObject1).togglePrimaryButtonClicked(primaryButton, primaryButtonClicked, isPrimaryButtonClicked);
      }
      topCardViewModel = ((EntityDetailedTopCardViewModel)localObject1);
      return;
    }
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
    fragmentComponent.eventBus();
    Bus.subscribe(this);
    CompanyDataProvider.CompanyState localCompanyState = (CompanyDataProvider.CompanyState)companyDataProvider.state;
    if (companyUpdated)
    {
      refreshTopCardButtonAndText();
      companyUpdated = false;
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
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (EntityUtils.isLixEnabled(fragmentComponent.lixManager(), Lix.ENTITIES_COMPANY_APP_INDEXING)) {
      googleApiClient = new GoogleApiClient.Builder(getActivity()).addApi(AppIndex.API).build();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    isShowcase = getArguments().getBoolean("isShowcase", false);
    super.onCreate(paramBundle);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    String str = companyDataProvider.state).companyRoute;
    if ((paramSet != null) && (str != null) && (paramSet.contains(str))) {
      super.onDataError(paramType, paramSet, paramDataManagerException);
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if (paramSet == null) {
      return;
    }
    Object localObject1 = companyDataProvider.state).companyRoute;
    Object localObject2 = companyDataProvider.state).findCompanyByNameRoute;
    int i;
    int j;
    if ((localObject1 != null) && (paramSet.contains(localObject1)))
    {
      i = 1;
      if ((localObject2 == null) || (!paramSet.contains(localObject2))) {
        break label122;
      }
      j = 1;
    }
    label122:
    Object localObject3;
    Object localObject4;
    for (;;)
    {
      if ((i != 0) || (j != 0))
      {
        localObject2 = ((CompanyDataProvider.CompanyState)companyDataProvider.state).company();
        if ((localObject2 == null) || (_cachedId == null))
        {
          showErrorPage();
          return;
          i = 0;
          break;
          j = 0;
          continue;
        }
        if (j != 0)
        {
          companyId = entityUrn.getId();
          companyDataProvider.initRoutesGivenCompanyId(companyId);
        }
        topCardViewModel = CompanyTransformer.transformTopCard(fragmentComponent, companyDataProvider, (Company)localObject2);
        topCardViewModel.onBindViewHolder(activityComponent.activity().getLayoutInflater(), applicationComponent.mediaCenter(), topCardViewHolder);
        setTitle(basicCompanyInfo.miniCompany.name);
        if (DataStore.Type.NETWORK.equals(paramType))
        {
          localObject1 = ((CompanyDataProvider.CompanyState)companyDataProvider.state).initCompanyTrackingObjectFromNetwork();
          if (localObject1 != null)
          {
            if (!basicCompanyInfo.miniCompany.showcase) {
              break label458;
            }
            localObject3 = tracker;
            localObject4 = new FlagshipShowcaseViewEvent.Builder();
            if (localObject1 != null) {
              break label442;
            }
            hasShowcase = false;
            showcase = null;
            ((Tracker)localObject3).send((TrackingEventBuilder)localObject4);
          }
        }
        localObject3 = new CompanyPagerAdapterV2(fragmentComponent, getChildFragmentManager(), companyDataProvider, isShowcase);
        setupTabs((FragmentReferencingPagerAdapter)localObject3, true);
        localObject4 = viewPager;
        i = getArguments().getInt("landingTabType", -1);
        localObject1 = EntityPagerAdapter.TabType.values();
        if ((i >= 0) && (i < localObject1.length)) {
          break label516;
        }
      }
    }
    label442:
    label458:
    label516:
    for (localObject1 = null;; localObject1 = localObject1[i])
    {
      if (localObject1 != null)
      {
        i = ((EntityPagerAdapter)localObject3).getTabPosition((EntityPagerAdapter.TabType)localObject1);
        if (i != -1) {
          ((ViewPager)localObject4).setCurrentItem(i, false);
        }
      }
      if (googleApiClient != null)
      {
        appIndexPageViewAction = CompanyTransformer.buildAppIndexingPageViewAction(fragmentComponent, (Company)localObject2);
        GoogleAppIndexingManager.startAppIndexing(googleApiClient, appIndexPageViewAction);
      }
      super.onDataReady(paramType, paramSet, paramMap);
      return;
      hasShowcase = true;
      showcase = ((TrackingObject)localObject1);
      break;
      localObject3 = tracker;
      localObject4 = new FlagshipCompanyViewEvent.Builder();
      if (localObject1 == null) {
        hasCompany = false;
      }
      for (company = null;; company = ((TrackingObject)localObject1))
      {
        ((Tracker)localObject3).send((TrackingEventBuilder)localObject4);
        break;
        hasCompany = true;
      }
    }
  }
  
  @Subscribe
  public void onEvent(DataUpdatedEvent paramDataUpdatedEvent)
  {
    if ((busSubscriberId.equals(subscriberId)) && (((RecordTemplate)((CompanyDataProvider.CompanyState)companyDataProvider.state).getModel(modelKey) instanceof Company)) && (isAdded())) {
      refreshTopCardButtonAndText();
    }
  }
  
  public void onStop()
  {
    if ((googleApiClient == null) || (appIndexPageViewAction == null)) {}
    for (;;)
    {
      super.onStop();
      return;
      GoogleAppIndexingManager.stopAppIndexing(googleApiClient, appIndexPageViewAction);
      appIndexPageViewAction = null;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = Tracker.createPageInstanceHeader(getPageInstance());
    activityComponent = getActivityactivityComponent;
    companyDataProvider = activityComponent.companyDataProvider();
    companyId = getArguments().getString("getCompanyId");
    companyName = getArguments().getString("companyName");
    Object localObject1 = getArguments().getString("companyUrn");
    topCardViewHolder = ((EntityDetailedTopCardViewHolder)EntityDetailedTopCardViewHolder.CREATOR.createViewHolder(topCard));
    ViewCompat.setTransitionName(topCardViewHolder.iconView, "logoTransition");
    if (companyDataProvider.isDataAvailable())
    {
      onDataReady(DataStore.Type.LOCAL, Collections.singleton(companyDataProvider.state).companyRoute), null);
      return;
    }
    loadingSpinner.setVisibility(0);
    paramBundle = companyDataProvider;
    Object localObject2 = new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<MiniCompany> paramAnonymousDataStoreResponse)
      {
        if ((error != null) || (model == null) || (companyDataProvider.isDataAvailable())) {
          return;
        }
        CompanyTransformer.preFillTopCard(fragmentComponent, topCardViewHolder, (MiniCompany)model);
      }
    };
    localObject1 = Request.get().cacheKey((String)localObject1).builder(MiniCompany.BUILDER).listener((RecordTemplateListener)localObject2).filter(DataManager.DataStoreFilter.LOCAL_ONLY);
    activityComponent.dataManager().submit((Request.Builder)localObject1);
    localObject1 = (CompanyDataProvider.CompanyState)companyDataProvider.state;
    paramBundle = applicationComponent.tracker().trackingCodePrefix + "_" + pageKey();
    if (((CompanyDataProvider.CompanyState)localObject1).getCrossPromo(paramBundle) == null)
    {
      localObject1 = companyDataProvider;
      Object localObject3 = busSubscriberId;
      localObject2 = getRumSessionId();
      localObject3 = new PromoListener((DataProvider)localObject1, (String)localObject3, (String)localObject2);
      paramBundle = Request.get().url(CompanyDataProvider.crossPromoPath(paramBundle)).builder(Promo.BUILDER).listener((RecordTemplateListener)localObject3).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
      paramBundle.trackingSessionId((String)localObject2);
      activityComponent.dataManager().submit(paramBundle);
    }
    fetchCompany(paramView);
  }
  
  public final String pageKey()
  {
    if (isShowcase) {
      return "showcase";
    }
    return "company";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.controllers.CompanyFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */