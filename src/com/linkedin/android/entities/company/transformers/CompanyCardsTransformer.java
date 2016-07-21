package com.linkedin.android.entities.company.transformers;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.entities.company.CompanyDataProvider.CompanyState;
import com.linkedin.android.entities.company.CompanyUpdatesBundleBuilder;
import com.linkedin.android.entities.company.CompanyViewAllBundleBuilder;
import com.linkedin.android.entities.company.controllers.CompanyUpdatesFragment;
import com.linkedin.android.entities.company.controllers.CompanyViewAllFragment;
import com.linkedin.android.entities.shared.WebViewerOnClickListener;
import com.linkedin.android.entities.viewmodels.cards.CareerBrandingCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.CareerBrandingCardViewModel.CareerBrandingMediaType;
import com.linkedin.android.entities.viewmodels.cards.EntityFeedUpdateWrapperCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.EntityListCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.EntitySingleCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.MultiTileCardViewModel;
import com.linkedin.android.entities.viewmodels.items.EmployeeQuoteItemViewModel;
import com.linkedin.android.entities.viewmodels.items.EntityItemViewModel;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.FeedViewTransformer;
import com.linkedin.android.feed.endor.ui.component.basicbutton.FeedBasicButtonViewModel;
import com.linkedin.android.feed.endor.ui.component.header.FeedHeaderLayout;
import com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewModel;
import com.linkedin.android.feed.endor.ui.component.seeall.FeedSeeAllLayout;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniJobsCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniProfilesCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.UpdateCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CareerAbout2;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CareerEmployeeQuotes;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CareerImage;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CareerResources;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CareerRichMedia;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CareerRichMedia.Content;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CareerSlide;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CareerVideo;
import com.linkedin.android.pegasus.gen.voyager.entities.company.Company;
import com.linkedin.android.pegasus.gen.voyager.entities.company.EmployeeQuote;
import com.linkedin.android.pegasus.gen.voyager.entities.company.NextCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.company.Showcases;
import com.linkedin.android.pegasus.gen.voyager.entities.company.SimilarCompanies;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompanyCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPersonCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistance;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CompanyCardsTransformer
{
  public static void addHeaderAndFooterToCompanyUpdateCard(final FragmentComponent paramFragmentComponent, final Company paramCompany, FeedUpdateViewModel paramFeedUpdateViewModel)
  {
    paramFeedUpdateViewModel = paramFeedUpdateViewModel.getComponents();
    paramFeedUpdateViewModel.add(0, new FeedHeaderViewModel(new FeedHeaderLayout(), paramFragmentComponent.i18NManager().getString(2131230876), null));
    FeedBasicButtonViewModel localFeedBasicButtonViewModel = new FeedBasicButtonViewModel(new FeedSeeAllLayout());
    text = paramFragmentComponent.i18NManager().getString(2131230877);
    clickListener = new TrackingOnClickListener(paramFragmentComponent.tracker(), "see_all", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        paramAnonymousView = paramFragmentComponent.activity().getPageFragmentTransaction();
        String str = paramCompanybasicCompanyInfo.miniCompany.entityUrn.getId();
        Bundle localBundle = new Bundle();
        localBundle.putString("companyId", str);
        paramAnonymousView.replace(2131756509, CompanyUpdatesFragment.newInstance(new CompanyUpdatesBundleBuilder(localBundle))).addToBackStack(null).commit();
      }
    };
    paramFeedUpdateViewModel.add(localFeedBasicButtonViewModel);
  }
  
  private static void setupRichMediaInCareerBrandingCard(FragmentComponent paramFragmentComponent, Company paramCompany, CareerRichMedia paramCareerRichMedia, CareerBrandingCardViewModel paramCareerBrandingCardViewModel)
  {
    if (content.careerImageValue != null)
    {
      image = new ImageModel(content.careerImageValue.image, 2130837812, Util.retrieveRumSessionId(paramFragmentComponent));
      mediaType = CareerBrandingCardViewModel.CareerBrandingMediaType.IMAGE;
    }
    do
    {
      return;
      if (content.careerVideoValue != null)
      {
        youTubeCode = content.careerVideoValue.videoCode;
        mediaType = CareerBrandingCardViewModel.CareerBrandingMediaType.YOUTUBE_VIDEO;
        clickListener = new WebViewerOnClickListener("https://www.youtube.com/watch?v=" + content.careerVideoValue.videoCode, basicCompanyInfo.miniCompany.name, paramFragmentComponent, "open_video", new TrackingEventBuilder[0]);
        return;
      }
    } while (content.careerSlideValue == null);
    slideShareCode = content.careerSlideValue.code;
    mediaType = CareerBrandingCardViewModel.CareerBrandingMediaType.SLIDESHARE;
    clickListener = new WebViewerOnClickListener("https://www.slideshare.net/slideshow/embed_code/" + content.careerSlideValue.code, basicCompanyInfo.miniCompany.name, paramFragmentComponent, "open_slideshare", new TrackingEventBuilder[0]);
  }
  
  public static EntityListCardViewModel toAllJobsCard(FragmentComponent paramFragmentComponent, CompanyDataProvider paramCompanyDataProvider, MiniJobsCollection paramMiniJobsCollection)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    header = paramFragmentComponent.i18NManager().getString(2131230855, new Object[] { state).company().basicCompanyInfo.miniCompany.name });
    entityListCardMaxRows = paramFragmentComponent.activity().getResources().getInteger(2131558432);
    int j = items.size();
    trackingUrns = new ArrayList();
    int i = 0;
    while ((i < j) && (i < entityListCardMaxRows))
    {
      MiniJob localMiniJob = (MiniJob)items.get(i);
      items.add(EntityTransformer.toJobItem(paramFragmentComponent, localMiniJob, null));
      EntityUtils.addObjectUrnIfNonNull(trackingUrns, objectUrn);
      i += 1;
    }
    if (j > entityListCardMaxRows)
    {
      viewAllText = paramFragmentComponent.i18NManager().getString(2131231035);
      viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, CompanyViewAllFragment.newInstance(CompanyViewAllBundleBuilder.create(0, null)), "see_all");
      paramCompanyDataProvider.setupAllJobsHelper(paramMiniJobsCollection);
    }
    return localEntityListCardViewModel;
  }
  
  public static EntityListCardViewModel toBrowseMapListCard(FragmentComponent paramFragmentComponent, SimilarCompanies paramSimilarCompanies)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    Object localObject1 = paramFragmentComponent.i18NManager();
    Object localObject2 = paramFragmentComponent.activity().getResources();
    header = ((I18NManager)localObject1).getString(2131231050);
    entityListCardMaxRows = ((Resources)localObject2).getInteger(2131558420);
    int j = companies.size();
    trackingUrns = new ArrayList();
    int i = 0;
    while ((i < j) && (i < entityListCardMaxRows))
    {
      localObject1 = (NextCompany)companies.get(i);
      localObject2 = items;
      EntityItemViewModel localEntityItemViewModel = new EntityItemViewModel();
      MiniCompany localMiniCompany = miniCompany;
      title = name;
      image = new ImageModel(logo, GhostImageUtils.getCompany(2131492963, localMiniCompany), Util.retrieveRumSessionId(paramFragmentComponent));
      subtitle = location;
      onRowClick = new CompanyItemsTransformer.1(paramFragmentComponent.tracker(), "company_link", localMiniCompany, paramFragmentComponent);
      ((List)localObject2).add(localEntityItemViewModel);
      EntityUtils.addObjectUrnIfNonNull(trackingUrns, miniCompany.objectUrn);
      i += 1;
    }
    isBrowseMap = true;
    return localEntityListCardViewModel;
  }
  
  public static CareerBrandingCardViewModel toCareerAboutCard(FragmentComponent paramFragmentComponent, Company paramCompany, CareerAbout2 paramCareerAbout2)
  {
    CareerBrandingCardViewModel localCareerBrandingCardViewModel = new CareerBrandingCardViewModel();
    webViewLoadProxy = paramFragmentComponent.webViewLoadProxy();
    if (hasMedia) {
      setupRichMediaInCareerBrandingCard(paramFragmentComponent, paramCompany, media, localCareerBrandingCardViewModel);
    }
    if (hasText) {
      paragraphCardViewModel = CompanyItemsTransformer.toCareerBrandingParagraph(paramFragmentComponent, title, text);
    }
    while (!hasLinks) {
      return localCareerBrandingCardViewModel;
    }
    entityListCardViewModel = CompanyItemsTransformer.toCareerBrandingLinks(paramFragmentComponent, links);
    return localCareerBrandingCardViewModel;
  }
  
  public static EntityListCardViewModel toCareerEmployeeQuoteCard(FragmentComponent paramFragmentComponent, CareerEmployeeQuotes paramCareerEmployeeQuotes)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    header = title;
    Iterator localIterator = quotes.iterator();
    while (localIterator.hasNext())
    {
      EmployeeQuote localEmployeeQuote = (EmployeeQuote)localIterator.next();
      EmployeeQuoteItemViewModel localEmployeeQuoteItemViewModel = new EmployeeQuoteItemViewModel();
      body = paramFragmentComponent.i18NManager().getString(2131231015, new Object[] { quote });
      employee = EntityTransformer.toConnectionItem(paramFragmentComponent, activityactivityComponent, member.miniProfile, member.distance);
      items.add(localEmployeeQuoteItemViewModel);
    }
    useTextDivider = true;
    entityListCardMaxRows = quotes.size();
    return localEntityListCardViewModel;
  }
  
  public static CareerBrandingCardViewModel toCareerResourcesCard(FragmentComponent paramFragmentComponent, Company paramCompany, CareerResources paramCareerResources)
  {
    CareerBrandingCardViewModel localCareerBrandingCardViewModel = new CareerBrandingCardViewModel();
    webViewLoadProxy = paramFragmentComponent.webViewLoadProxy();
    if (hasMedia) {
      setupRichMediaInCareerBrandingCard(paramFragmentComponent, paramCompany, media, localCareerBrandingCardViewModel);
    }
    if (hasLinks) {
      entityListCardViewModel = CompanyItemsTransformer.toCareerBrandingLinks(paramFragmentComponent, links);
    }
    return localCareerBrandingCardViewModel;
  }
  
  public static EntityListCardViewModel toCommonCompaniesAlumniCard(FragmentComponent paramFragmentComponent, CompanyDataProvider paramCompanyDataProvider, InCommonCompanyCollection paramInCommonCompanyCollection)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    Object localObject = paramFragmentComponent.i18NManager();
    ActivityComponent localActivityComponent = activityactivityComponent;
    Resources localResources = paramFragmentComponent.activity().getResources();
    int j = items.size();
    header = ((I18NManager)localObject).getString(2131230863, new Object[] { state).company().basicCompanyInfo.miniCompany.name });
    entityListCardMaxRows = localResources.getInteger(2131558432);
    trackingUrns = new ArrayList();
    int i = 0;
    while ((i < entityListCardMaxRows) && (i < j))
    {
      localObject = items.get(i)).member;
      EntityItemViewModel localEntityItemViewModel = EntityTransformer.toConnectionItem(paramFragmentComponent, localActivityComponent, (EntitiesMiniProfile)localObject, null);
      items.add(localEntityItemViewModel);
      EntityUtils.addObjectUrnIfNonNull(trackingUrns, miniProfile.objectUrn);
      i += 1;
    }
    if (j > entityListCardMaxRows)
    {
      viewAllText = localResources.getString(2131231036);
      viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, CompanyViewAllFragment.newInstance(CompanyViewAllBundleBuilder.create(8, null)), "see_all");
      if (state).commonCompaniesAlumniHelper != null) {}
    }
    try
    {
      paramFragmentComponent = EntityUtils.createDefaultCollection(items, pagingInfo);
      state).commonCompaniesAlumniHelper = new CollectionTemplateHelper(activityComponent.dataManager(), null, paramFragmentComponent, InCommonCompany.BUILDER, CollectionMetadata.BUILDER);
      return localEntityListCardViewModel;
    }
    catch (BuilderException paramFragmentComponent)
    {
      activityComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException(paramFragmentComponent));
    }
    return localEntityListCardViewModel;
  }
  
  public static EntityListCardViewModel toCompanyEmployeesCard(FragmentComponent paramFragmentComponent, CompanyDataProvider paramCompanyDataProvider, Company paramCompany, MiniProfilesCollection paramMiniProfilesCollection)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    Object localObject = paramFragmentComponent.i18NManager();
    ActivityComponent localActivityComponent = activityactivityComponent;
    Resources localResources = paramFragmentComponent.activity().getResources();
    paramCompany = basicCompanyInfo.miniCompany.name;
    List localList = items;
    int i = localList.size();
    int j;
    if ((i <= 0) || (!EntityUtils.isImmediateConnection((EntitiesMiniProfile)localList.get(0))))
    {
      i = 0;
      if (i != 0) {
        break label308;
      }
      paramCompany = ((I18NManager)localObject).getString(2131230892, new Object[] { paramCompany });
      header = paramCompany;
      entityListCardMaxRows = localResources.getInteger(2131558432);
      trackingUrns = new ArrayList();
      j = items.size();
      boolean bool = EntityUtils.isLixEnabled(paramFragmentComponent.lixManager(), Lix.ENTITIES_COMPANIES_OUT_OF_NETWORK_COMPANY_EMPLOYEES);
      i = 0;
      label170:
      if ((i >= entityListCardMaxRows) || (i >= j)) {
        break label392;
      }
      localObject = (EntitiesMiniProfile)items.get(i);
      if (!bool) {
        break label372;
      }
    }
    label302:
    label308:
    label372:
    for (paramCompany = EntityTransformer.toConnectionItem(paramFragmentComponent, localActivityComponent, (EntitiesMiniProfile)localObject, null);; paramCompany = EntityTransformer.toConnectionItem(paramFragmentComponent, localActivityComponent, miniProfile, distance))
    {
      items.add(paramCompany);
      EntityUtils.addObjectUrnIfNonNull(trackingUrns, miniProfile.objectUrn);
      i += 1;
      break label170;
      i -= 1;
      for (;;)
      {
        if (i < 0) {
          break label302;
        }
        if (EntityUtils.isImmediateConnection((EntitiesMiniProfile)localList.get(i)))
        {
          i += 1;
          break;
        }
        i -= 1;
      }
      i = 0;
      break;
      if ((i >= pagingInfo.count) && (i < pagingInfo.total)) {}
      for (j = 2131230894;; j = 2131230893)
      {
        paramCompany = ((I18NManager)localObject).getString(j, new Object[] { paramCompany, Integer.valueOf(i) });
        break;
      }
    }
    label392:
    if ((j > entityListCardMaxRows) || (j < pagingInfo.total))
    {
      viewAllText = localResources.getString(2131230854);
      viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, CompanyViewAllFragment.newInstance(CompanyViewAllBundleBuilder.create(6, null)), "see_all");
      if (state).employeesHelper != null) {}
    }
    try
    {
      paramFragmentComponent = EntityUtils.createDefaultCollection(items, pagingInfo);
      state).employeesHelper = new CollectionTemplateHelper(activityComponent.dataManager(), null, paramFragmentComponent, EntitiesMiniProfile.BUILDER, CollectionMetadata.BUILDER);
      return localEntityListCardViewModel;
    }
    catch (BuilderException paramFragmentComponent)
    {
      activityComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException(paramFragmentComponent));
    }
    return localEntityListCardViewModel;
  }
  
  public static EntityListCardViewModel toImmediateConnectionsCard(FragmentComponent paramFragmentComponent, CompanyDataProvider paramCompanyDataProvider, MiniProfilesCollection paramMiniProfilesCollection)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    Object localObject = paramFragmentComponent.i18NManager();
    ActivityComponent localActivityComponent = activityactivityComponent;
    Resources localResources = paramFragmentComponent.activity().getResources();
    int j = items.size();
    header = ((I18NManager)localObject).getString(2131230883, new Object[] { Integer.valueOf(pagingInfo.total), state).company().basicCompanyInfo.miniCompany.name });
    entityListCardMaxRows = localResources.getInteger(2131558432);
    trackingUrns = new ArrayList();
    int i = 0;
    while ((i < entityListCardMaxRows) && (i < j))
    {
      localObject = (EntitiesMiniProfile)items.get(i);
      EntityItemViewModel localEntityItemViewModel = EntityTransformer.toConnectionItem(paramFragmentComponent, localActivityComponent, miniProfile, distance);
      items.add(localEntityItemViewModel);
      EntityUtils.addObjectUrnIfNonNull(trackingUrns, miniProfile.objectUrn);
      i += 1;
    }
    if (j > entityListCardMaxRows)
    {
      viewAllText = localResources.getString(2131231000);
      viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, CompanyViewAllFragment.newInstance(CompanyViewAllBundleBuilder.create(1, null)), "see_all");
      paramCompanyDataProvider.setupImmediateConnectionsHelper(paramMiniProfilesCollection);
    }
    return localEntityListCardViewModel;
  }
  
  public static EntitySingleCardViewModel toIntroducerCard(final FragmentComponent paramFragmentComponent, final CompanyDataProvider paramCompanyDataProvider, InCommonPersonCollection paramInCommonPersonCollection, final String paramString, boolean paramBoolean)
  {
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    final ActivityComponent localActivityComponent = activityactivityComponent;
    EntitySingleCardViewModel localEntitySingleCardViewModel = new EntitySingleCardViewModel();
    final InCommonPerson localInCommonPerson = (InCommonPerson)items.get(0);
    final Object localObject;
    if (paramBoolean)
    {
      if (items.size() <= 1) {
        break label389;
      }
      localObject = localI18NManager.getString(2131230938, new Object[] { paramString });
    }
    for (;;)
    {
      header = ((String)localObject);
      itemViewModel = EntityTransformer.toConnectionItem(paramFragmentComponent, localActivityComponent, member.miniProfile, member.distance);
      if (CollectionUtils.isNonEmpty(people))
      {
        localObject = (MiniProfile)people.get(0);
        peopleInCommonImage1 = new ImageModel(picture, GhostImageUtils.getPerson(2131492960, (MiniProfile)localObject), Util.retrieveRumSessionId(paramFragmentComponent));
        if (people.size() == 1)
        {
          peopleInCommonCaption = localI18NManager.getSpannedString(2131230942, new Object[] { I18NManager.getName(member.miniProfile), I18NManager.getName((MiniProfile)localObject), paramString });
          onPeopleInCommonClick = new TrackingClosure(paramFragmentComponent.tracker(), "in_common_link") {};
        }
      }
      else if (items.size() > 1)
      {
        viewAllText = localI18NManager.getString(2131231037);
        viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, CompanyViewAllFragment.newInstance(CompanyViewAllBundleBuilder.create(4, null)), "see_all");
        if (state).introducersHelper != null) {}
      }
      try
      {
        paramFragmentComponent = EntityUtils.createDefaultCollection(items, pagingInfo);
        state).introducersHelper = new CollectionTemplateHelper(activityComponent.dataManager(), null, paramFragmentComponent, InCommonPerson.BUILDER, CollectionMetadata.BUILDER);
        trackingUrns = new ArrayList();
        EntityUtils.addObjectUrnIfNonNull(trackingUrns, member.miniProfile.objectUrn);
        return localEntitySingleCardViewModel;
        label389:
        localObject = localI18NManager.getString(2131230939, new Object[] { I18NManager.getName(member.miniProfile), paramString });
        continue;
        peopleInCommonCaption = localI18NManager.getSpannedString(2131230941, new Object[] { I18NManager.getName(member.miniProfile), I18NManager.getName((MiniProfile)localObject), Integer.valueOf(people.size() - 1), paramString });
        paramString = CompanyViewAllFragment.newInstance(CompanyViewAllBundleBuilder.create(5, localI18NManager.getString(2131230940, new Object[] { I18NManager.getName(member.miniProfile) })));
        onPeopleInCommonClick = new TrackingClosure(paramFragmentComponent.tracker(), "in_common_link") {};
      }
      catch (BuilderException paramFragmentComponent)
      {
        for (;;)
        {
          activityComponent.context();
          Util.safeThrow$7a8b4789(new RuntimeException(paramFragmentComponent));
        }
      }
    }
  }
  
  static MultiTileCardViewModel toJobsThatMatchYourSkillsTilesCard(FragmentComponent paramFragmentComponent, CompanyDataProvider paramCompanyDataProvider, MiniJobsCollection paramMiniJobsCollection)
  {
    MultiTileCardViewModel localMultiTileCardViewModel = new MultiTileCardViewModel();
    Object localObject1 = paramFragmentComponent.i18NManager();
    Resources localResources = paramFragmentComponent.activity().getResources();
    Object localObject2 = ((CompanyDataProvider.CompanyState)state).company();
    List localList = items;
    int j = pagingInfo.total;
    localObject2 = basicCompanyInfo.miniCompany.name;
    if (j >= 20) {}
    for (localObject1 = ((I18NManager)localObject1).getString(2131230872, new Object[] { Integer.valueOf(20), localObject2 });; localObject1 = ((I18NManager)localObject1).getString(2131230873, new Object[] { Integer.valueOf(j), localObject2 }))
    {
      header = ((String)localObject1);
      maxTilesWhenCollapsed = localResources.getInteger(2131558436);
      trackingUrns = new ArrayList();
      int i = 0;
      while ((i < j) && (i < maxTilesWhenCollapsed))
      {
        localObject1 = (MiniJob)localList.get(i);
        tiles.add(CompanyItemsTransformer.toJobTile(paramFragmentComponent, (MiniJob)localObject1));
        EntityUtils.addObjectUrnIfNonNull(trackingUrns, objectUrn);
        i += 1;
      }
    }
    if (localList.size() > maxTilesWhenCollapsed)
    {
      viewAllText = paramFragmentComponent.i18NManager().getString(2131231039);
      viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, CompanyViewAllFragment.newInstance(CompanyViewAllBundleBuilder.create(3, null)), "see_all");
      if (state).matchedJobsHelper != null) {}
    }
    try
    {
      paramFragmentComponent = EntityUtils.createDefaultCollection(items, pagingInfo);
      state).matchedJobsHelper = new CollectionTemplateHelper(activityComponent.dataManager(), null, paramFragmentComponent, MiniJob.BUILDER, CollectionMetadata.BUILDER);
      return localMultiTileCardViewModel;
    }
    catch (BuilderException paramFragmentComponent)
    {
      activityComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException(paramFragmentComponent));
    }
    return localMultiTileCardViewModel;
  }
  
  public static EntityFeedUpdateWrapperCardViewModel toRecentUpdatesCard(FragmentComponent paramFragmentComponent, CompanyDataProvider paramCompanyDataProvider, Company paramCompany, UpdateCollection paramUpdateCollection)
  {
    EntityFeedUpdateWrapperCardViewModel localEntityFeedUpdateWrapperCardViewModel = new EntityFeedUpdateWrapperCardViewModel();
    FeedUpdateViewModel localFeedUpdateViewModel = (FeedUpdateViewModel)toViewModelFeedComponentsViewPoolitems.get(0), FeedDataModelMetadata.DEFAULT).viewModel;
    addHeaderAndFooterToCompanyUpdateCard(paramFragmentComponent, paramCompany, localFeedUpdateViewModel);
    paramFragmentComponent = items.get(0)).urn;
    if (paramFragmentComponent != null) {
      trackingUrns = Collections.singletonList(paramFragmentComponent.toString());
    }
    if (state).allUpdatesHelper == null) {}
    try
    {
      paramFragmentComponent = EntityUtils.createDefaultCollection(items, pagingInfo);
      state).allUpdatesHelper = new CollectionTemplateHelper(activityComponent.dataManager(), null, paramFragmentComponent, Update.BUILDER, CollectionMetadata.BUILDER);
      feedUpdateViewModel = localFeedUpdateViewModel;
      return localEntityFeedUpdateWrapperCardViewModel;
    }
    catch (BuilderException paramFragmentComponent)
    {
      for (;;)
      {
        activityComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException(paramFragmentComponent));
      }
    }
  }
  
  public static EntityListCardViewModel toShowcasesCard(FragmentComponent paramFragmentComponent, CompanyDataProvider paramCompanyDataProvider, Showcases paramShowcases)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    Resources localResources = paramFragmentComponent.activity().getResources();
    int j = showcases.size();
    Object localObject = ((CompanyDataProvider.CompanyState)state).company();
    if (j == 1) {}
    for (localObject = localI18NManager.getString(2131231048, new Object[] { basicCompanyInfo.miniCompany.name });; localObject = localI18NManager.getString(2131231047, new Object[] { basicCompanyInfo.miniCompany.name }))
    {
      header = ((String)localObject);
      entityListCardMaxRows = localResources.getInteger(2131558432);
      trackingUrns = new ArrayList();
      int i = 0;
      while ((i < entityListCardMaxRows) && (i < j))
      {
        localObject = (BasicCompanyInfo)showcases.get(i);
        items.add(CompanyItemsTransformer.toShowcaseItem(paramFragmentComponent, (BasicCompanyInfo)localObject, null));
        EntityUtils.addObjectUrnIfNonNull(trackingUrns, miniCompany.objectUrn);
        i += 1;
      }
    }
    if (j > entityListCardMaxRows)
    {
      viewAllText = localI18NManager.getString(2131231035);
      viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, CompanyViewAllFragment.newInstance(CompanyViewAllBundleBuilder.create(2, null)), "see_all");
      state).showcases = paramShowcases;
    }
    return localEntityListCardViewModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.transformers.CompanyCardsTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */