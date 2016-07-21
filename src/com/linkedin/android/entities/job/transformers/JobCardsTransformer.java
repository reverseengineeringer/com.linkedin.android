package com.linkedin.android.entities.job.transformers;

import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View.OnClickListener;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.entities.job.JobDataProvider.JobState;
import com.linkedin.android.entities.job.JobViewAllBundleBuilder;
import com.linkedin.android.entities.job.controllers.JobViewAllFragment;
import com.linkedin.android.entities.jymbii.JymbiiBundleBuilder;
import com.linkedin.android.entities.jymbii.JymbiiFragment;
import com.linkedin.android.entities.viewmodels.cards.EntityListCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.EntitySingleCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.MultiHeadlineCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.ParagraphCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.PremiumRankCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.TrendCardViewModel;
import com.linkedin.android.entities.viewmodels.items.BarItemViewModel;
import com.linkedin.android.entities.viewmodels.items.EntityItemViewModel;
import com.linkedin.android.entities.viewmodels.items.FooterItemViewModel;
import com.linkedin.android.entities.viewmodels.items.SkillItemViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.DateUtils;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo.ItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniProfilesCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson;
import com.linkedin.android.pegasus.gen.voyager.entities.job.GroupedJobItem;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Job;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobDetails;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobItem;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobItem.Item;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.job.NextJob;
import com.linkedin.android.pegasus.gen.voyager.entities.job.NextJobCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.job.SkillsAndExperience;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.ApplicantRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyGrowthInsights;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.DegreeCount;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.EducationAnalytics;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.EmployeeCount;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.FieldOfStudy;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.InflowCompanyRankingInsights;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SchoolRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SchoolRankingInsights;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityAnalytics;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SeniorityCount;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkill;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.TopSkillsAnalytics;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistance;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSkill;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.gen.avro2pegasus.events.premium.PremiumUpsellImpressionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class JobCardsTransformer
{
  static PremiumRankCardViewModel toApplicantRankingHelper(FragmentComponent paramFragmentComponent, ApplicantRanking paramApplicantRanking, String paramString, View.OnClickListener paramOnClickListener)
  {
    PremiumRankCardViewModel localPremiumRankCardViewModel = new PremiumRankCardViewModel();
    paramFragmentComponent = paramFragmentComponent.i18NManager();
    int i = percentileRank;
    long l = numberOfApplicants;
    float f = 100 - i;
    description = paramFragmentComponent.getString(2131230944, new Object[] { Double.valueOf(f / 100.0F), Long.valueOf(l) });
    value = paramFragmentComponent.getString(2131233038, new Object[] { Double.valueOf(f / 100.0F) });
    linkText = paramString;
    cardOnClickListener = paramOnClickListener;
    topRankText = paramFragmentComponent.getString(2131231062);
    return localPremiumRankCardViewModel;
  }
  
  public static EntityListCardViewModel toEducationChartCard(FragmentComponent paramFragmentComponent, EducationAnalytics paramEducationAnalytics)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    Object localObject1 = paramFragmentComponent.activity().getResources();
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    long l = 0L;
    Object localObject2 = degrees.iterator();
    while (((Iterator)localObject2).hasNext()) {
      l = Math.max(l, nextpercent);
    }
    localObject1 = ((Resources)localObject1).getIntArray(2131296259);
    int j = localObject1.length;
    int i = 0;
    while ((i < degrees.size()) && (i < j))
    {
      localObject2 = (DegreeCount)degrees.get(i);
      float f = percent / (float)l;
      int k = localObject1[i];
      List localList = items;
      BarItemViewModel localBarItemViewModel = new BarItemViewModel();
      barWeight = f;
      barColor = k;
      value = paramFragmentComponent.i18NManager().getString(2131233038, new Object[] { Double.valueOf(percent / 100.0F) });
      caption = paramFragmentComponent.i18NManager().getSpannedString(2131230955, new Object[] { degree });
      localList.add(localBarItemViewModel);
      i += 1;
    }
    header = localI18NManager.getString(2131230960);
    hideDividerAndUpdateHeaderPadding = true;
    entityListCardMaxRows = degrees.size();
    if ((hasFieldsOfStudy) && (fieldsOfStudy.size() > 0))
    {
      paramFragmentComponent = new FooterItemViewModel();
      localObject1 = fieldsOfStudy;
      paramEducationAnalytics = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramEducationAnalytics.add(nextname);
      }
      text = localI18NManager.getString(2131230959, new Object[] { TextUtils.join(", ", paramEducationAnalytics) });
      items.add(paramFragmentComponent);
      entityListCardMaxRows += 1;
    }
    return localEntityListCardViewModel;
  }
  
  public static TrendCardViewModel toHiringTrendsCard(FragmentComponent paramFragmentComponent, CompanyGrowthInsights paramCompanyGrowthInsights)
  {
    if ((miniCompany == null) || (CollectionUtils.isEmpty(growth))) {
      return null;
    }
    Object localObject3 = growth;
    Object localObject1 = paramFragmentComponent.activity().getResources();
    int i = ((Resources)localObject1).getInteger(2131558429);
    Date localDate;
    Object localObject2;
    int j;
    if (((List)localObject3).size() <= i)
    {
      localObject1 = new ArrayList((Collection)localObject3);
      Collections.reverse((List)localObject1);
      localObject3 = get0recordedOn;
      localDate = getsize1recordedOn;
      if ((localObject3 == null) || (localDate == null)) {
        return null;
      }
    }
    else
    {
      localObject2 = new ArrayList();
      j = ((Resources)localObject1).getInteger(2131558428);
      i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= ((List)localObject3).size()) {
          break;
        }
        ((List)localObject2).add(((List)localObject3).get(i));
        i += j;
      }
    }
    TrendCardViewModel localTrendCardViewModel = new TrendCardViewModel();
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    header = localI18NManager.getString(2131230965, new Object[] { miniCompany.name });
    if (CollectionUtils.isEmpty(growth))
    {
      paramFragmentComponent = null;
      insightText = paramFragmentComponent;
      if (!hasAverageTenureYears) {
        break label600;
      }
    }
    long l1;
    label600:
    for (paramFragmentComponent = localI18NManager.getString(2131230954, new Object[] { Double.valueOf(averageTenureYears) });; paramFragmentComponent = null)
    {
      footerText = paramFragmentComponent;
      l1 = 0L;
      graphYValues = new long[((List)localObject1).size()];
      graphMarkers = new int[((List)localObject1).size()];
      i = 0;
      while (i < ((List)localObject1).size())
      {
        long l2 = getcount;
        graphYValues[i] = l2;
        graphMarkers[i] = i;
        l1 = Math.max(l1, l2);
        i += 1;
      }
      localObject2 = paramFragmentComponent.i18NManager();
      l1 = growth.get(0)).count;
      if (!hasCompanyGrowthPercent)
      {
        paramFragmentComponent = ((I18NManager)localObject2).getString(2131231068, new Object[] { Long.valueOf(l1) });
        break;
      }
      double d = companyGrowthPercent / 100.0F;
      localObject2 = new SpannableStringBuilder(((I18NManager)localObject2).getString(2131230964, new Object[] { Double.valueOf(d), Long.valueOf(l1) }));
      j = TextUtils.indexOf((CharSequence)localObject2, "<span>");
      ((SpannableStringBuilder)localObject2).delete(j, "<span>".length() + j);
      int k = TextUtils.indexOf((CharSequence)localObject2, "</span>");
      ((SpannableStringBuilder)localObject2).delete(k, "</span>".length() + k);
      paramFragmentComponent = paramFragmentComponent.activity();
      if (d > 0.0D) {}
      for (i = 2131623990;; i = 2131623974)
      {
        ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(ContextCompat.getColor(paramFragmentComponent, i)), j, k, 33);
        paramFragmentComponent = (FragmentComponent)localObject2;
        break;
      }
    }
    graphHighlightRange = new Pair(Integer.valueOf(0), Integer.valueOf(((List)localObject1).size() - 1));
    graphYAxisTop = localI18NManager.getString(2131233020, new Object[] { Long.valueOf(l1) });
    graphYAxisBottom = localI18NManager.getString(2131233020, new Object[] { Integer.valueOf(0) });
    graphStartDate = localI18NManager.getString(2131230931, new Object[] { Long.valueOf(DateUtils.getTimeStampInMillis((Date)localObject3)) });
    graphEndDate = localI18NManager.getString(2131230931, new Object[] { Long.valueOf(DateUtils.getTimeStampInMillis(localDate)) });
    return localTrendCardViewModel;
  }
  
  public static EntityListCardViewModel toImmediateConnectionsAtCompanyCard(FragmentComponent paramFragmentComponent, JobDataProvider paramJobDataProvider, Job paramJob, MiniProfilesCollection paramMiniProfilesCollection)
  {
    if (companyName == null) {
      paramJob = null;
    }
    EntityListCardViewModel localEntityListCardViewModel;
    Resources localResources;
    int j;
    do
    {
      return paramJob;
      localEntityListCardViewModel = new EntityListCardViewModel();
      I18NManager localI18NManager = paramFragmentComponent.i18NManager();
      localResources = paramFragmentComponent.activity().getResources();
      ActivityComponent localActivityComponent = activityactivityComponent;
      List localList = items;
      j = pagingInfo.total;
      header = localI18NManager.getString(2131230883, new Object[] { Integer.valueOf(j), companyName });
      entityListCardMaxRows = localResources.getInteger(2131558432);
      trackingUrns = new ArrayList();
      int i = 0;
      while ((i < localList.size()) && (i < entityListCardMaxRows))
      {
        paramJob = (EntitiesMiniProfile)localList.get(i);
        items.add(EntityTransformer.toConnectionItem(paramFragmentComponent, localActivityComponent, miniProfile, distance));
        EntityUtils.addObjectUrnIfNonNull(trackingUrns, miniProfile.objectUrn);
        i += 1;
      }
      paramJob = localEntityListCardViewModel;
    } while (j <= entityListCardMaxRows);
    viewAllText = localResources.getString(2131231000);
    viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, JobViewAllFragment.newInstance(JobViewAllBundleBuilder.create(0)), "see_all");
    paramJobDataProvider.setupImmediateConnectionsHelper(paramMiniProfilesCollection);
    return localEntityListCardViewModel;
  }
  
  public static ParagraphCardViewModel toJobDescriptionCard(FragmentComponent paramFragmentComponent, JobDataProvider paramJobDataProvider, Description paramDescription, boolean paramBoolean)
  {
    ParagraphCardViewModel localParagraphCardViewModel = new ParagraphCardViewModel();
    header = paramFragmentComponent.i18NManager().getString(2131230957);
    if (attributedText != null) {}
    for (Object localObject = AttributedTextUtils.getAttributedString(attributedText, paramFragmentComponent.context(), null, null, true);; localObject = text)
    {
      body = ((CharSequence)localObject);
      seeMoreButtonText = paramFragmentComponent.i18NManager().getString(2131231017);
      maxLinesCollapsed = paramFragmentComponent.activity().getResources().getInteger(2131558438);
      expandInNewPage = true;
      if (paramBoolean)
      {
        onExpandButtonClick = EntityTransformer.createViewAllClosure(paramFragmentComponent, JobViewAllFragment.newInstance(JobViewAllBundleBuilder.create(1)), "see_all");
        state).description = paramDescription;
      }
      return localParagraphCardViewModel;
    }
  }
  
  public static MultiHeadlineCardViewModel toJobDetailsCard(FragmentComponent paramFragmentComponent, JobDetails paramJobDetails)
  {
    MultiHeadlineCardViewModel localMultiHeadlineCardViewModel = new MultiHeadlineCardViewModel();
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    header = localI18NManager.getString(2131230958);
    multiHeadlineCardMaxPairsCollapsed = paramFragmentComponent.activity().getResources().getInteger(2131558424);
    if (hasEmploymentStatus) {
      items.add(EntityTransformer.toNonLinkableDetailItem(localI18NManager.getString(2131230961), employmentStatus));
    }
    if (CollectionUtils.isNonEmpty(jobFunctions)) {
      items.add(EntityTransformer.toNonLinkableDetailItem(localI18NManager.getString(2131230963), TextUtils.join(", ", jobFunctions)));
    }
    if (CollectionUtils.isNonEmpty(industries)) {
      items.add(EntityTransformer.toNonLinkableDetailItem(localI18NManager.getString(2131230967), TextUtils.join(", ", industries)));
    }
    items.add(EntityTransformer.toNonLinkableDetailItem(localI18NManager.getString(2131230966), String.valueOf(jobId)));
    onExpandButtonClick = TrackingClosure.createEmptyTrackingClosure(paramFragmentComponent.tracker(), "see_more");
    paramFragmentComponent = localMultiHeadlineCardViewModel;
    if (items.isEmpty()) {
      paramFragmentComponent = null;
    }
    return paramFragmentComponent;
  }
  
  public static EntitySingleCardViewModel toJobPosterCard(FragmentComponent paramFragmentComponent, JobDataProvider paramJobDataProvider, InCommonPerson paramInCommonPerson)
  {
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    final ActivityComponent localActivityComponent = activityactivityComponent;
    EntitySingleCardViewModel localEntitySingleCardViewModel = new EntitySingleCardViewModel();
    header = localI18NManager.getString(2131230982);
    itemViewModel = EntityTransformer.toConnectionItem(paramFragmentComponent, localActivityComponent, member.miniProfile, member.distance);
    final MiniProfile localMiniProfile;
    if (CollectionUtils.isNonEmpty(people))
    {
      localMiniProfile = (MiniProfile)people.get(0);
      peopleInCommonImage1 = new ImageModel(picture, GhostImageUtils.getPerson(2131492960, localMiniProfile), Util.retrieveRumSessionId(paramFragmentComponent));
      if (people.size() != 1) {
        break label213;
      }
      peopleInCommonCaption = localI18NManager.getSpannedString(2131230974, new Object[] { I18NManager.getName(localMiniProfile) });
      onPeopleInCommonClick = new TrackingClosure(paramFragmentComponent.tracker(), "in_common_link") {};
    }
    for (;;)
    {
      trackingUrns = new ArrayList();
      EntityUtils.addObjectUrnIfNonNull(trackingUrns, member.miniProfile.objectUrn);
      return localEntitySingleCardViewModel;
      label213:
      peopleInCommonCaption = localI18NManager.getSpannedString(2131230973, new Object[] { I18NManager.getName(localMiniProfile), Integer.valueOf(people.size() - 1) });
      onPeopleInCommonClick = EntityTransformer.createViewAllClosure(paramFragmentComponent, JobViewAllFragment.newInstance(JobViewAllBundleBuilder.create(2)), "in_common_link");
      try
      {
        paramFragmentComponent = EntityUtils.createDefaultCollection(people, null);
        state).jobPosterInCommon = paramFragmentComponent;
      }
      catch (BuilderException paramFragmentComponent)
      {
        localActivityComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException(paramFragmentComponent));
      }
    }
  }
  
  public static ParagraphCardViewModel toJobSummaryCard(FragmentComponent paramFragmentComponent, JobDataProvider paramJobDataProvider, GroupedJobItem paramGroupedJobItem)
  {
    Object localObject = mainItem;
    if (itemInfo.itemType.jobItemTypeValue != JobItemType.DESCRIPTION) {
      return null;
    }
    localObject = toJobDescriptionCard(paramFragmentComponent, paramJobDataProvider, item.descriptionValue, false);
    hasChildCards = CollectionUtils.isNonEmpty(additionalItems);
    onExpandButtonClick = EntityTransformer.createViewAllClosure(paramFragmentComponent, JobViewAllFragment.newInstance(JobViewAllBundleBuilder.create(7)), "see_all");
    state).jobSummary = paramGroupedJobItem;
    return (ParagraphCardViewModel)localObject;
  }
  
  public static EntityListCardViewModel toSeniorityChartCard(FragmentComponent paramFragmentComponent, SeniorityAnalytics paramSeniorityAnalytics)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    Resources localResources = paramFragmentComponent.activity().getResources();
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    long l = 0L;
    Object localObject = seniorities.iterator();
    while (((Iterator)localObject).hasNext()) {
      l = Math.max(l, nextcount);
    }
    localObject = localResources.getIntArray(2131296263);
    int k = localObject.length;
    int i = 0;
    while ((i < seniorities.size()) && (i < k))
    {
      SeniorityCount localSeniorityCount = (SeniorityCount)seniorities.get(i);
      float f = (float)count / (float)l;
      int j = localObject[i];
      if (count == 0L) {
        j = localResources.getColor(2131623972);
      }
      List localList = items;
      BarItemViewModel localBarItemViewModel = new BarItemViewModel();
      barWeight = f;
      barColor = j;
      value = Long.toString(count);
      caption = paramFragmentComponent.i18NManager().getSpannedString(2131230955, new Object[] { seniority });
      localList.add(localBarItemViewModel);
      i += 1;
    }
    header = localI18NManager.getString(2131230984);
    hideDividerAndUpdateHeaderPadding = true;
    entityListCardMaxRows = seniorities.size();
    return localEntityListCardViewModel;
  }
  
  public static EntityListCardViewModel toSimilarJobsBrowseMapListCard(FragmentComponent paramFragmentComponent, NextJobCollection paramNextJobCollection)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    Object localObject = paramFragmentComponent.activity().getResources();
    header = paramFragmentComponent.i18NManager().getString(2131231009);
    entityListCardMaxRows = ((Resources)localObject).getInteger(2131558420);
    paramNextJobCollection = items;
    int j = paramNextJobCollection.size();
    trackingUrns = new ArrayList();
    int i = 0;
    if ((i < j) && (i < entityListCardMaxRows))
    {
      localObject = (NextJob)paramNextJobCollection.get(i);
      List localList = items;
      MiniJob localMiniJob = miniJob;
      EntityItemViewModel localEntityItemViewModel = EntityTransformer.toJobItem(paramFragmentComponent, localMiniJob, null);
      if ((hasCompanyName) && (hasLocation))
      {
        subtitle = paramFragmentComponent.i18NManager().getString(2131230956, new Object[] { companyName, location });
        label178:
        if (!hasListedAt) {
          break label299;
        }
        badge = DateUtils.getTimestampText(listedAt, paramFragmentComponent.i18NManager());
      }
      for (badgeContentDescription = DateUtils.getTimeAgoContentDescription(listedAt, paramFragmentComponent.i18NManager());; badgeContentDescription = null)
      {
        localList.add(localEntityItemViewModel);
        EntityUtils.addObjectUrnIfNonNull(trackingUrns, miniJob.objectUrn);
        i += 1;
        break;
        if (hasCompanyName)
        {
          subtitle = companyName;
          break label178;
        }
        if (!hasLocation) {
          break label178;
        }
        subtitle = location;
        break label178;
        label299:
        badge = null;
      }
    }
    isBrowseMap = true;
    viewAllText = paramFragmentComponent.i18NManager().getString(2131231041);
    viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, JymbiiFragment.newInstance(JymbiiBundleBuilder.create()), "see_all");
    return localEntityListCardViewModel;
  }
  
  public static ParagraphCardViewModel toSkillsAndExperienceCard(FragmentComponent paramFragmentComponent, SkillsAndExperience paramSkillsAndExperience, boolean paramBoolean)
  {
    ParagraphCardViewModel localParagraphCardViewModel = new ParagraphCardViewModel();
    header = paramFragmentComponent.i18NManager().getString(2131230985);
    body = skillsAndExperience;
    if (paramBoolean)
    {
      maxLinesCollapsed = paramFragmentComponent.activity().getResources().getInteger(2131558439);
      onExpandButtonClick = TrackingClosure.createEmptyTrackingClosure(paramFragmentComponent.tracker(), "see_more");
      return localParagraphCardViewModel;
    }
    maxLinesCollapsed = Integer.MAX_VALUE;
    return localParagraphCardViewModel;
  }
  
  public static EntityListCardViewModel toTopCompaniesCard(FragmentComponent paramFragmentComponent, JobDataProvider paramJobDataProvider, Job paramJob, InflowCompanyRankingInsights paramInflowCompanyRankingInsights)
  {
    if ((companyName == null) || (CollectionUtils.isEmpty(rankings))) {
      paramJob = null;
    }
    EntityListCardViewModel localEntityListCardViewModel;
    I18NManager localI18NManager;
    do
    {
      return paramJob;
      localEntityListCardViewModel = new EntityListCardViewModel();
      localI18NManager = paramFragmentComponent.i18NManager();
      header = localI18NManager.getString(2131230989, new Object[] { companyName });
      entityListCardMaxRows = paramFragmentComponent.activity().getResources().getInteger(2131558431);
      trackingUrns = new ArrayList();
      int i = 0;
      while ((i < rankings.size()) && (i < entityListCardMaxRows))
      {
        paramJob = (CompanyRanking)rankings.get(i);
        items.add(JobItemsTransformer.toCompanyRankingItem(paramFragmentComponent, paramJob, null));
        EntityUtils.addObjectUrnIfNonNull(trackingUrns, miniCompany.objectUrn);
        i += 1;
      }
      paramJob = localEntityListCardViewModel;
    } while (rankings.size() <= entityListCardMaxRows);
    state).companyRankings = rankings;
    viewAllText = localI18NManager.getString(2131231040);
    viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, JobViewAllFragment.newInstance(JobViewAllBundleBuilder.create(3)), "see_all");
    return localEntityListCardViewModel;
  }
  
  public static EntityListCardViewModel toTopSchoolsCard(FragmentComponent paramFragmentComponent, JobDataProvider paramJobDataProvider, Job paramJob, SchoolRankingInsights paramSchoolRankingInsights)
  {
    if ((companyName == null) || (CollectionUtils.isEmpty(rankings))) {
      paramJob = null;
    }
    EntityListCardViewModel localEntityListCardViewModel;
    I18NManager localI18NManager;
    do
    {
      return paramJob;
      localEntityListCardViewModel = new EntityListCardViewModel();
      localI18NManager = paramFragmentComponent.i18NManager();
      header = localI18NManager.getString(2131230991, new Object[] { companyName });
      entityListCardMaxRows = paramFragmentComponent.activity().getResources().getInteger(2131558432);
      trackingUrns = new ArrayList();
      int i = 0;
      while ((i < rankings.size()) && (i < entityListCardMaxRows))
      {
        paramJob = (SchoolRanking)rankings.get(i);
        items.add(JobItemsTransformer.toSchoolRankingItem(paramFragmentComponent, paramJob, null));
        EntityUtils.addObjectUrnIfNonNull(trackingUrns, miniSchool.objectUrn);
        i += 1;
      }
      paramJob = localEntityListCardViewModel;
    } while (rankings.size() <= entityListCardMaxRows);
    state).schoolRankings = rankings;
    viewAllText = localI18NManager.getString(2131231042);
    viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, JobViewAllFragment.newInstance(JobViewAllBundleBuilder.create(4)), "see_all");
    return localEntityListCardViewModel;
  }
  
  public static EntityListCardViewModel toTopSkillsCard(FragmentComponent paramFragmentComponent, TopSkillsAnalytics paramTopSkillsAnalytics)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    paramFragmentComponent = paramFragmentComponent.i18NManager();
    trackingUrns = new ArrayList();
    Iterator localIterator = topSkills.iterator();
    while (localIterator.hasNext())
    {
      TopSkill localTopSkill = (TopSkill)localIterator.next();
      List localList = items;
      SkillItemViewModel localSkillItemViewModel = new SkillItemViewModel();
      name = miniSkill.name;
      sharedSkill = sharedSkill;
      localList.add(localSkillItemViewModel);
      trackingUrns.add(miniSkill.entityUrn.toString());
    }
    header = paramFragmentComponent.getString(2131230992);
    hideDividerAndUpdateHeaderPadding = true;
    entityListCardMaxRows = topSkills.size();
    return localEntityListCardViewModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.transformers.JobCardsTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */