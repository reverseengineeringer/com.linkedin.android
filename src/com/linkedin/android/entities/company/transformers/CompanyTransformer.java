package com.linkedin.android.entities.company.transformers;

import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.appindexing.Action;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.entities.company.CompanyDataProvider.CompanyState;
import com.linkedin.android.entities.company.CompanyViewAllBundleBuilder;
import com.linkedin.android.entities.company.controllers.CompanyViewAllFragment;
import com.linkedin.android.entities.viewholders.EntityDetailedTopCardViewHolder;
import com.linkedin.android.entities.viewmodels.EntityDetailedTopCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.CareerBrandingCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.CareerBrandingCardViewModel.CareerBrandingMediaType;
import com.linkedin.android.entities.viewmodels.cards.EntityBaseCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.EntityListCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.MultiHeadlineCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.ParagraphCardViewModel;
import com.linkedin.android.feed.endor.ui.component.insight.FeedInsightTransformer;
import com.linkedin.android.growth.seo.appindexing.GoogleAppIndexingManager;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.DateUtils;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo.ItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniJobsCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Section.Items;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CareerAbout;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CareerImage;
import com.linkedin.android.pegasus.gen.voyager.entities.company.Company;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyDetails;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItem;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItem.Item;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanyItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.CompanyRecruitReason;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor.Reason;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension.Builder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition.Builder;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyImpressionItem.Builder;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipCompanyItemImpressionEvent.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CompanyTransformer
{
  private static final String TAG = CompanyTransformer.class.getSimpleName();
  
  public static Action buildAppIndexingPageViewAction(FragmentComponent paramFragmentComponent, Company paramCompany)
  {
    Object localObject = basicCompanyInfo.miniCompany;
    localObject = new Uri.Builder().scheme("https").authority("www.linkedin.com").appendEncodedPath("company").appendEncodedPath(entityUrn.getId()).build();
    String str = paramFragmentComponent.i18NManager().getString(2131230869, new Object[] { basicCompanyInfo.miniCompany.name });
    if (description == null) {}
    for (paramFragmentComponent = "";; paramFragmentComponent = description) {
      return GoogleAppIndexingManager.getAction((Uri)localObject, str, paramFragmentComponent);
    }
  }
  
  public static Closure<ImpressionData, TrackingEventBuilder> newCompanyImpressionTrackingClosure(String paramString1, final TrackingObject paramTrackingObject, final String paramString2, final List<String> paramList)
  {
    new Closure()
    {
      private TrackingEventBuilder apply(ImpressionData paramAnonymousImpressionData)
      {
        try
        {
          FlagshipCompanyImpressionItem.Builder localBuilder = new FlagshipCompanyImpressionItem.Builder().setItemTrackingId(val$itemTrackingId).setVisibleTime(Long.valueOf(timeViewed)).setListPosition(new ListPosition.Builder().setIndex(Integer.valueOf(position)).build(RecordTemplate.Flavor.RECORD)).setSize(new EntityDimension.Builder().setHeight(Integer.valueOf(height)).setWidth(Integer.valueOf(width)).build(RecordTemplate.Flavor.RECORD));
          if (paramList == null) {}
          for (Object localObject = new ArrayList();; localObject = paramList)
          {
            localObject = localBuilder.setUrns((List)localObject).build();
            com.linkedin.android.logger.Log.d("CompanyImpression", "onTrackImpression() - pos: " + position + " card: " + paramString2);
            return new FlagshipCompanyItemImpressionEvent.Builder().setCompany(paramTrackingObject).setItems(Collections.singletonList(localObject));
          }
          return null;
        }
        catch (BuilderException paramAnonymousImpressionData)
        {
          Util.safeThrow(new RuntimeException(paramAnonymousImpressionData));
        }
      }
    };
  }
  
  public static Closure<ImpressionData, TrackingEventBuilder> newCompanyImpressionTrackingClosure$637dce18(Map<String, List<String>> paramMap, final TrackingObject paramTrackingObject)
  {
    new Closure()
    {
      private TrackingEventBuilder apply(ImpressionData paramAnonymousImpressionData)
      {
        ArrayList localArrayList;
        try
        {
          localArrayList = new ArrayList();
          Iterator localIterator = val$itemTrackingMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (String)localIterator.next();
            List localList = (List)val$itemTrackingMap.get(localObject);
            FlagshipCompanyImpressionItem.Builder localBuilder = new FlagshipCompanyImpressionItem.Builder().setItemTrackingId((String)localObject).setVisibleTime(Long.valueOf(timeViewed)).setListPosition(new ListPosition.Builder().setIndex(Integer.valueOf(position)).build(RecordTemplate.Flavor.RECORD)).setSize(new EntityDimension.Builder().setHeight(Integer.valueOf(height)).setWidth(Integer.valueOf(width)).build(RecordTemplate.Flavor.RECORD));
            localObject = localList;
            if (localList == null) {
              localObject = new ArrayList();
            }
            localArrayList.add(localBuilder.setUrns((List)localObject).build());
          }
          com.linkedin.android.logger.Log.d("CompanyImpression", "onTrackImpression() - pos: " + position + " card: " + val$header);
        }
        catch (BuilderException paramAnonymousImpressionData)
        {
          Util.safeThrow(new RuntimeException(paramAnonymousImpressionData));
          return null;
        }
        paramAnonymousImpressionData = new FlagshipCompanyItemImpressionEvent.Builder().setCompany(paramTrackingObject).setItems(localArrayList);
        return paramAnonymousImpressionData;
      }
    };
  }
  
  private static TrackingOnClickListener newInsightClickListener(final FragmentComponent paramFragmentComponent, int paramInt, String paramString)
  {
    paramFragmentComponent = EntityTransformer.createViewAllClosure(paramFragmentComponent, CompanyViewAllFragment.newInstance(CompanyViewAllBundleBuilder.create(paramInt, null)), paramString);
    new TrackingOnClickListener(tracker, controlName, new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        paramFragmentComponent.apply(null);
      }
    };
  }
  
  public static void preFillTopCard(FragmentComponent paramFragmentComponent, EntityDetailedTopCardViewHolder paramEntityDetailedTopCardViewHolder, MiniCompany paramMiniCompany)
  {
    new ImageModel(logo, GhostImageUtils.getCompany(2131492964, paramMiniCompany), Util.retrieveRumSessionId(paramFragmentComponent)).setImageView(paramFragmentComponent.mediaCenter(), iconView);
    ViewUtils.setTextAndUpdateVisibility(titleView, name);
  }
  
  public static List<ViewModel> toCardViewModels(FragmentComponent paramFragmentComponent, CompanyDataProvider paramCompanyDataProvider, List<Section.Items> paramList)
  {
    Company localCompany1 = ((CompanyDataProvider.CompanyState)state).company();
    ArrayList localArrayList = new ArrayList();
    if ((localCompany1 == null) || (CollectionUtils.isEmpty(paramList))) {
      return localArrayList;
    }
    Iterator localIterator = paramList.iterator();
    CompanyItem localCompanyItem;
    while (localIterator.hasNext())
    {
      localCompanyItem = nextcompanyItemValue;
      switch (itemInfo.itemType.companyItemTypeValue)
      {
      default: 
        com.linkedin.android.logger.Log.d(TAG, "Unsupported company card: " + itemInfo.itemType.companyItemTypeValue.name());
        localObject1 = null;
        CollectionUtils.addItemIfNonNull(localArrayList, localObject1);
      }
    }
    Object localObject1 = item.descriptionValue;
    paramList = new ParagraphCardViewModel();
    header = paramFragmentComponent.i18NManager().getString(2131230862);
    body = text;
    maxLinesCollapsed = paramFragmentComponent.activity().getResources().getInteger(2131558439);
    onExpandButtonClick = TrackingClosure.createEmptyTrackingClosure(paramFragmentComponent.tracker(), "see_more");
    for (;;)
    {
      Object localObject2 = state).companyTrackingObject;
      localObject1 = paramList;
      if (localObject2 == null) {
        break;
      }
      trackingEventBuilderClosure = newCompanyImpressionTrackingClosure(itemInfo.trackingId, (TrackingObject)localObject2, header, trackingUrns);
      localObject1 = paramList;
      break;
      paramList = CompanyCardsTransformer.toRecentUpdatesCard(paramFragmentComponent, paramCompanyDataProvider, localCompany1, item.updateCollectionValue);
      continue;
      paramList = CompanyCardsTransformer.toAllJobsCard(paramFragmentComponent, paramCompanyDataProvider, item.miniJobsCollectionValue);
      continue;
      localObject1 = item.companyDetailsValue;
      paramList = new MultiHeadlineCardViewModel();
      multiHeadlineCardMaxPairsCollapsed = paramFragmentComponent.activity().getResources().getInteger(2131558424);
      header = paramFragmentComponent.i18NManager().getString(2131230865);
      if (websiteUrl != null) {
        items.add(EntityTransformer.toLinkableDetailItem(paramFragmentComponent, paramFragmentComponent.i18NManager().getString(2131231067), websiteUrl, websiteUrl, basicCompanyInfo.miniCompany.name));
      }
      if (!CollectionUtils.isEmpty(industries)) {
        items.add(EntityTransformer.toNonLinkableDetailItem(paramFragmentComponent.i18NManager().getString(2131230871), TextUtils.join(", ", industries)));
      }
      if (employeeCountRange != null) {
        items.add(EntityTransformer.toNonLinkableDetailItem(paramFragmentComponent.i18NManager().getString(2131230878), employeeCountRange));
      }
      if (headquarters != null) {
        items.add(EntityTransformer.toNonLinkableDetailItem(paramFragmentComponent.i18NManager().getString(2131230870), headquarters));
      }
      if (companyType != null) {
        items.add(EntityTransformer.toNonLinkableDetailItem(paramFragmentComponent.i18NManager().getString(2131230882), companyType));
      }
      if (foundedDate != null) {
        items.add(EntityTransformer.toNonLinkableDetailItem(paramFragmentComponent.i18NManager().getString(2131230868), paramFragmentComponent.i18NManager().getString(2131233749, new Object[] { Long.valueOf(DateUtils.getTimeStampInMillis(foundedDate)) })));
      }
      if (!CollectionUtils.isEmpty(specialties)) {
        items.add(EntityTransformer.toNonLinkableDetailItem(paramFragmentComponent.i18NManager().getString(2131230879), TextUtils.join(", ", specialties)));
      }
      onExpandButtonClick = TrackingClosure.createEmptyTrackingClosure(paramFragmentComponent.tracker(), "see_more");
      continue;
      paramList = CompanyCardsTransformer.toImmediateConnectionsCard(paramFragmentComponent, paramCompanyDataProvider, item.miniProfilesCollectionValue);
      continue;
      paramList = CompanyCardsTransformer.toCompanyEmployeesCard(paramFragmentComponent, paramCompanyDataProvider, localCompany1, item.miniProfilesCollectionValue);
      continue;
      paramList = CompanyCardsTransformer.toIntroducerCard(paramFragmentComponent, paramCompanyDataProvider, item.inCommonPersonCollectionValue, basicCompanyInfo.miniCompany.name, true);
      continue;
      Object localObject3 = item.miniJobsCollectionValue;
      if (items.size() == 1)
      {
        paramList = new EntityListCardViewModel();
        localObject1 = paramFragmentComponent.i18NManager();
        localObject2 = paramFragmentComponent.activity().getResources();
        Company localCompany2 = ((CompanyDataProvider.CompanyState)state).company();
        localObject3 = (MiniJob)items.get(0);
        header = ((I18NManager)localObject1).getString(2131230874, new Object[] { basicCompanyInfo.miniCompany.name });
        items.add(EntityTransformer.toJobItem(paramFragmentComponent, (MiniJob)localObject3, null));
        entityListCardMaxRows = ((Resources)localObject2).getInteger(2131558434);
        trackingUrns = new ArrayList();
        EntityUtils.addObjectUrnIfNonNull(trackingUrns, objectUrn);
      }
      for (;;)
      {
        break;
        paramList = CompanyCardsTransformer.toJobsThatMatchYourSkillsTilesCard(paramFragmentComponent, paramCompanyDataProvider, (MiniJobsCollection)localObject3);
      }
      paramList = CompanyCardsTransformer.toShowcasesCard(paramFragmentComponent, paramCompanyDataProvider, item.showcasesValue);
      continue;
      paramList = CompanyCardsTransformer.toBrowseMapListCard(paramFragmentComponent, item.similarCompaniesValue);
      continue;
      localObject2 = item.careerAboutValue;
      localObject1 = new CareerBrandingCardViewModel();
      title = careersTitle;
      subtitle = careersSubtitle;
      mediaType = CareerBrandingCardViewModel.CareerBrandingMediaType.IMAGE;
      if (image == null) {}
      for (paramList = null;; paramList = image.image)
      {
        image = new ImageModel(paramList, 2130837812, Util.retrieveRumSessionId(paramFragmentComponent));
        paragraphCardViewModel = CompanyItemsTransformer.toCareerBrandingParagraph(paramFragmentComponent, title, text);
        paramList = (List<Section.Items>)localObject1;
        break;
      }
      paramList = CompanyCardsTransformer.toCareerAboutCard(paramFragmentComponent, localCompany1, item.careerAbout2Value);
      continue;
      paramList = CompanyCardsTransformer.toCareerResourcesCard(paramFragmentComponent, localCompany1, item.careerResourcesValue);
      continue;
      paramList = CompanyCardsTransformer.toCareerEmployeeQuoteCard(paramFragmentComponent, item.careerEmployeeQuotesValue);
      continue;
      paramList = CompanyCardsTransformer.toCommonCompaniesAlumniCard(paramFragmentComponent, paramCompanyDataProvider, item.inCommonCompanyCollectionValue);
    }
  }
  
  public static EntityDetailedTopCardViewModel transformTopCard(final FragmentComponent paramFragmentComponent, final CompanyDataProvider paramCompanyDataProvider, final Company paramCompany)
  {
    final Map localMap = Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance());
    BasicCompanyInfo localBasicCompanyInfo = basicCompanyInfo;
    final MiniCompany localMiniCompany = miniCompany;
    EntityDetailedTopCardViewModel localEntityDetailedTopCardViewModel = new EntityDetailedTopCardViewModel();
    title = name;
    if ((industries != null) && (!industries.isEmpty())) {
      subtitle1 = TextUtils.join(", ", industries);
    }
    subtitle2 = EntityUtils.formatLocationAndFollowers(paramFragmentComponent, hasHeadquarters, hasFollowerCount, headquarters, followingInfo.followerCount);
    topCardTopScrimWeight = paramFragmentComponent.activity().getResources().getFraction(2131689472, 1, 1);
    Object localObject1 = Util.retrieveRumSessionId(paramFragmentComponent);
    heroImage = new ImageModel(heroImage, 2130837793, (String)localObject1);
    icon = new ImageModel(logo, GhostImageUtils.getCompany(2131492964, localMiniCompany), (String)localObject1);
    Object localObject2;
    if (CollectionUtils.isNonEmpty(flavors))
    {
      EntitiesFlavor localEntitiesFlavor = (EntitiesFlavor)flavors.get(0);
      localObject2 = reason;
      localObject1 = null;
      if (inNetworkReasonValue != null)
      {
        localObject1 = newInsightClickListener(paramFragmentComponent, 1, "company_insight_connections");
        paramCompanyDataProvider.setupImmediateConnectionsHelper(null);
        insight = FeedInsightTransformer.toInsightViewModel(localEntitiesFlavor, paramFragmentComponent, (TrackingOnClickListener)localObject1, 5);
      }
    }
    else
    {
      localObject1 = paramFragmentComponent.i18NManager();
      primaryButtonDefaultText = ((I18NManager)localObject1).getString(2131230858);
      primaryButtonClickedText = ((I18NManager)localObject1).getString(2131230859);
      primaryButtonDefaultIcon = EntityUtils.createButtonIcon(paramFragmentComponent, 2130838246, 2130837652);
      primaryButtonClickedIcon = EntityUtils.createButtonIcon(paramFragmentComponent, 2130837935, 2130837641);
      primaryButtonIconPadding = ((int)paramFragmentComponent.activity().getResources().getDimension(2131492989));
      isPrimaryButtonClicked = followingInfo.following;
      onPrimaryButtonClick = new TrackingClosure(paramFragmentComponent.tracker(), "company_follow_toggle") {};
      if ((hasJobsCount) && (jobsCount > 0)) {
        if (!EntityUtils.isLixEnabled(paramFragmentComponent.lixManager(), Lix.ENTITIES_COMPANY_SEE_JOBS_TEXT)) {
          break label576;
        }
      }
    }
    label576:
    for (paramCompany = ((I18NManager)localObject1).getString(2131230996);; paramCompany = ((I18NManager)localObject1).getString(2131231038))
    {
      secondaryButtonDefaultText = paramCompany;
      secondaryButtonClickedText = paramCompany;
      onSecondaryButtonClick = EntityTransformer.createViewAllClosure(paramFragmentComponent, CompanyViewAllFragment.newInstance(CompanyViewAllBundleBuilder.create(0, null)), "view_all_jobs_top_card");
      paramCompanyDataProvider.setupAllJobsHelper(null);
      return localEntityDetailedTopCardViewModel;
      if (companyRecruitReasonValue == null) {
        break;
      }
      localObject1 = newInsightClickListener(paramFragmentComponent, 7, "company_insight_company");
      CompanyDataProvider.CompanyState localCompanyState = (CompanyDataProvider.CompanyState)state;
      localObject2 = companyRecruitReasonValue.currentCompany.entityUrn.getId();
      Object localObject3 = localCompanyState.company();
      if (localObject3 == null)
      {
        android.util.Log.e(CompanyDataProvider.access$1500(), "Company object in DataProvider is null!");
        break;
      }
      localObject3 = basicCompanyInfo.miniCompany.entityUrn.getId();
      companyRecruitsRoute = Routes.COMPANY.buildRouteForId((String)localObject3).buildUpon().appendEncodedPath("companyRecruits").appendQueryParameter("viewerCurrentCompanyId", (String)localObject2).build().toString();
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.transformers.CompanyTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */