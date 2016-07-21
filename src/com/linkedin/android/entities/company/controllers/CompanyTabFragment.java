package com.linkedin.android.entities.company.controllers;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.linkedin.android.entities.EntityBaseTabFragment;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.entities.company.CompanyDataProvider.CompanyState;
import com.linkedin.android.entities.company.CompanyTabBundleBuilder;
import com.linkedin.android.entities.company.transformers.CompanyCardsTransformer;
import com.linkedin.android.entities.company.transformers.CompanyTransformer;
import com.linkedin.android.entities.viewmodels.cards.EntityFeedUpdateWrapperCardViewModel;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel;
import com.linkedin.android.feed.events.UpdateActionEvent;
import com.linkedin.android.feed.utils.FeedPageType;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.infra.ViewState;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.app.TrackableFragment.EnterTooEarlyException;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo.ItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Section;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Section.Items;
import com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.company.Company;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItem;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItem.Item;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanySections;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.consistency.ModelListItemChangedListener;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.companies.FlagshipCareersViewEvent.Builder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;

public final class CompanyTabFragment
  extends EntityBaseTabFragment
  implements FeedPageType
{
  private ViewModelArrayAdapter<ViewModel> arrayAdapter;
  private boolean careerTabViewed;
  private Company company;
  private final ModelListItemChangedListener<Update> updateChangedListener = new ModelListItemChangedListener() {};
  
  private void listenForUpdates(List<Section.Items> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (CollectionUtils.isEmpty(paramList))) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Section.Items localItems = (Section.Items)paramList.next();
      if (companyItemValue.itemInfo.itemType.companyItemTypeValue == CompanyItemType.RECENT_UPDATES) {
        localArrayList.addAll(companyItemValue.item.updateCollectionValue.items);
      }
    }
    fragmentComponent.updateChangeCoordinator().listenForUpdates(localArrayList, updateChangedListener);
  }
  
  public static CompanyTabFragment newInstance(CompanyTabBundleBuilder paramCompanyTabBundleBuilder)
  {
    CompanyTabFragment localCompanyTabFragment = new CompanyTabFragment();
    localCompanyTabFragment.setArguments(paramCompanyTabBundleBuilder.build());
    return localCompanyTabFragment;
  }
  
  protected final String crossPromoPageKey()
  {
    return "company";
  }
  
  public final void doEnter()
    throws TrackableFragment.EnterTooEarlyException
  {
    super.doEnter();
    TrackingObject localTrackingObject = getActivityactivityComponent.companyDataProvider().state).companyTrackingObject;
    Tracker localTracker;
    FlagshipCareersViewEvent.Builder localBuilder;
    if ((isLoadedFromNetwork) && (CompanyTabBundleBuilder.tabType(getArguments()) == EntityPagerAdapter.TabType.CAREERS) && (!careerTabViewed))
    {
      localTracker = tracker;
      localBuilder = new FlagshipCareersViewEvent.Builder();
      if (localTrackingObject != null) {
        break label94;
      }
      hasCompany = false;
    }
    for (company = null;; company = localTrackingObject)
    {
      localTracker.send(localBuilder);
      careerTabViewed = true;
      return;
      label94:
      hasCompany = true;
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
  }
  
  public final int feedType()
  {
    return 7;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    Object localObject = null;
    FragmentComponent localFragmentComponent = null;
    super.onActivityCreated(paramBundle);
    CompanyDataProvider localCompanyDataProvider;
    if ((BaseActivity)getActivity() != null)
    {
      localCompanyDataProvider = getActivityactivityComponent.companyDataProvider();
      if (state).companyTrackingObject == null) {
        break label96;
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      isLoadedFromNetwork = bool;
      paramBundle = CompanyTabBundleBuilder.tabType(getArguments());
      company = ((CompanyDataProvider.CompanyState)state).company();
      if (company != null) {
        break;
      }
      Log.e("Company data model should not be null!");
      return;
    }
    switch (paramBundle)
    {
    default: 
      getActivity();
      Util.safeThrow$7a8b4789(new RuntimeException("CompanyTabFragment does not support this tab type: " + paramBundle));
    case ???: 
      for (paramBundle = localFragmentComponent;; paramBundle = CompanyTransformer.toCardViewModels(fragmentComponent, localCompanyDataProvider, ((CompanyDataProvider.CompanyState)state).highlightsItems()))
      {
        listenForUpdates(((CompanyDataProvider.CompanyState)state).highlightsItems());
        arrayAdapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), paramBundle);
        recyclerView.setAdapter(arrayAdapter);
        if (!isLoadedFromNetwork) {
          break;
        }
        initImpressionTracking(arrayAdapter);
        return;
      }
    case ???: 
      localObject = fragmentComponent;
      paramBundle = ((CompanyDataProvider.CompanyState)state).company();
      if ((paramBundle == null) || (sections == null) || (sections.details == null)) {}
      for (paramBundle = null;; paramBundle = sections.details.items)
      {
        localObject = CompanyTransformer.toCardViewModels((FragmentComponent)localObject, localCompanyDataProvider, paramBundle);
        paramBundle = (Bundle)localObject;
        if (!CollectionUtils.isEmpty((Collection)localObject)) {
          break;
        }
        paramBundle = fragmentComponent.i18NManager().getString(2131230867, new Object[] { company.basicCompanyInfo.miniCompany.name });
        ((List)localObject).add(EntityTransformer.noCardsEmptyState(fragmentComponent, paramBundle, 2130838585));
        paramBundle = (Bundle)localObject;
        break;
      }
    }
    localFragmentComponent = fragmentComponent;
    Company localCompany = ((CompanyDataProvider.CompanyState)state).company();
    paramBundle = (Bundle)localObject;
    if (localCompany != null)
    {
      paramBundle = (Bundle)localObject;
      if (sections != null) {
        if (sections.careers != null) {
          break label518;
        }
      }
    }
    label518:
    for (paramBundle = (Bundle)localObject;; paramBundle = sections.careers.items)
    {
      localObject = CompanyTransformer.toCardViewModels(localFragmentComponent, localCompanyDataProvider, paramBundle);
      paramBundle = (Bundle)localObject;
      if (!CollectionUtils.isEmpty((Collection)localObject)) {
        break;
      }
      paramBundle = fragmentComponent.i18NManager().getString(2131230866, new Object[] { company.basicCompanyInfo.miniCompany.name });
      ((List)localObject).add(EntityTransformer.noCardsEmptyState(fragmentComponent, paramBundle, 2130838587));
      paramBundle = (Bundle)localObject;
      break;
    }
  }
  
  @Subscribe
  public final void onEvent(UpdateActionEvent paramUpdateActionEvent)
  {
    CompanyDataProvider.handleUpdateOverflowAction(fragmentComponent, paramUpdateActionEvent, Tracker.createPageInstanceHeader(getPageInstance()), isActive);
  }
  
  public final String pageKey()
  {
    EntityPagerAdapter.TabType localTabType = CompanyTabBundleBuilder.tabType(getArguments());
    boolean bool = getArguments().getBoolean("isShowcase", false);
    switch (localTabType)
    {
    default: 
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Unable to determine page key for tab type " + localTabType));
      return "";
    case ???: 
      if (bool) {
        return "showcase_highlights";
      }
      return "company_highlights";
    case ???: 
      if (bool) {
        return "showcase_details";
      }
      return "company_details";
    }
    return "company_careers";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.controllers.CompanyTabFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */