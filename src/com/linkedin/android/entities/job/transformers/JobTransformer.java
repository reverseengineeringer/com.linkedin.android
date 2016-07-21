package com.linkedin.android.entities.job.transformers;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.ImageView;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.entities.job.JobDataProvider.JobState;
import com.linkedin.android.entities.job.JobViewAllBundleBuilder;
import com.linkedin.android.entities.job.controllers.ApplyJobViaLinkedInFragment;
import com.linkedin.android.entities.job.controllers.JobViewAllFragment;
import com.linkedin.android.entities.job.viewmodels.ApplyJobViaLinkedInViewModel;
import com.linkedin.android.entities.shared.EntitiesSwitchTabOnClickListener;
import com.linkedin.android.entities.shared.PremiumUpsellOnClickListener;
import com.linkedin.android.entities.viewholders.EntityDetailedTopCardViewHolder;
import com.linkedin.android.entities.viewmodels.EntityDetailedTopCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.EntityBaseCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.EntitySingleCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.PremiumRankCardViewModel;
import com.linkedin.android.entities.viewmodels.items.EntityItemViewModel;
import com.linkedin.android.feed.endor.ui.component.insight.FeedInsightTransformer;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.settings.ui.PhoneOnlyUserDialogManager;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.TrackingUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Section.Items;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Applicant;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Job;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobItem;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobItem.Item;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.ApplicantRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyGrowthInsights;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.CompanyRecruitReason;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor.Reason;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.JobApplyingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.JobSavingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.SchoolRecruitReason;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.premium.PremiumUpsellChannel;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension.Builder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition.Builder;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobImpressionItem.Builder;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobItemImpressionEvent.Builder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JobTransformer
{
  private static final String TAG = JobTransformer.class.getSimpleName();
  
  private static void fireJobActionTrackingEvent(JobDataProvider paramJobDataProvider, FragmentComponent paramFragmentComponent, ActionCategory paramActionCategory, String paramString)
  {
    paramJobDataProvider = state).jobTrackingObject;
    if (paramJobDataProvider == null) {
      return;
    }
    paramString = TrackingUtils.constructFullTrackingControlUrn("job", paramString);
    paramFragmentComponent.tracker().send(new FlagshipJobActionEvent.Builder().setActionCategory(paramActionCategory).setControlUrn(paramString).setSubItemUrn(objectUrn).setJob(paramJobDataProvider));
  }
  
  private static String getTimeFromPostDateAndNumberOfViews(I18NManager paramI18NManager, Job paramJob, long paramLong, boolean paramBoolean)
  {
    MiniJob localMiniJob = miniJob;
    if ((hasListedAt) && (hasNumberOfViewers)) {
      return paramI18NManager.getString(2131230987, new Object[] { EntityTransformer.toPostedTimeAgoString$3d933973(paramI18NManager, paramI18NManager.getString(2131230971), listedAt, paramLong, paramBoolean), Long.valueOf(numberOfViewers) });
    }
    if (hasListedAt) {
      return EntityTransformer.toPostedTimeAgoString$3d933973(paramI18NManager, paramI18NManager.getString(2131230971), listedAt, paramLong, paramBoolean);
    }
    if (hasNumberOfViewers) {
      return paramI18NManager.getString(2131230972, new Object[] { Long.valueOf(numberOfViewers) });
    }
    return null;
  }
  
  private static TrackingOnClickListener newInsightClickListener(final FragmentComponent paramFragmentComponent, int paramInt, String paramString)
  {
    paramFragmentComponent = EntityTransformer.createViewAllClosure(paramFragmentComponent, JobViewAllFragment.newInstance(JobViewAllBundleBuilder.create(paramInt)), paramString);
    new TrackingOnClickListener(tracker, controlName, new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        paramFragmentComponent.apply(null);
      }
    };
  }
  
  public static Closure<ImpressionData, TrackingEventBuilder> newJobImpressionTrackingClosure(String paramString1, final TrackingObject paramTrackingObject, final String paramString2, final List<String> paramList)
  {
    new Closure()
    {
      private TrackingEventBuilder apply(ImpressionData paramAnonymousImpressionData)
      {
        Object localObject1;
        for (;;)
        {
          Object localObject2;
          try
          {
            localObject2 = new FlagshipJobImpressionItem.Builder();
            localObject1 = val$itemTrackingId;
            if (localObject1 == null)
            {
              hasItemTrackingId = false;
              itemTrackingId = null;
              localObject1 = Long.valueOf(timeViewed);
              if (localObject1 == null)
              {
                hasVisibleTime = false;
                visibleTime = 0L;
                localObject1 = new ListPosition.Builder().setIndex(Integer.valueOf(position)).build(RecordTemplate.Flavor.RECORD);
                hasListPosition = true;
                listPosition = ((ListPosition)localObject1);
                localObject1 = new EntityDimension.Builder().setHeight(Integer.valueOf(height)).setWidth(Integer.valueOf(width)).build(RecordTemplate.Flavor.RECORD);
                hasSize = true;
                size = ((EntityDimension)localObject1);
                if (paramList != null) {
                  break label292;
                }
                localObject1 = new ArrayList();
                if (localObject1 != null) {
                  break label300;
                }
                hasUrns = false;
                urns = null;
                localObject1 = ((FlagshipJobImpressionItem.Builder)localObject2).build(RecordTemplate.Flavor.RECORD);
                Log.d("JobImpression", "onTrackImpression() - pos: " + position + " card: " + paramString2);
                paramAnonymousImpressionData = new FlagshipJobItemImpressionEvent.Builder();
                localObject2 = paramTrackingObject;
                if (localObject2 != null) {
                  break label313;
                }
                hasJob = false;
                job = null;
                localObject1 = Collections.singletonList(localObject1);
                if (localObject1 != null) {
                  break;
                }
                hasItems = false;
                items = null;
                return paramAnonymousImpressionData;
              }
            }
            else
            {
              hasItemTrackingId = true;
              itemTrackingId = ((String)localObject1);
              continue;
            }
            hasVisibleTime = true;
          }
          catch (BuilderException paramAnonymousImpressionData)
          {
            Util.safeThrow(new RuntimeException(paramAnonymousImpressionData));
            return null;
          }
          visibleTime = ((Long)localObject1).longValue();
          continue;
          label292:
          localObject1 = paramList;
          continue;
          label300:
          hasUrns = true;
          urns = ((List)localObject1);
          continue;
          label313:
          hasJob = true;
          job = ((TrackingObject)localObject2);
        }
        hasItems = true;
        items = ((List)localObject1);
        return paramAnonymousImpressionData;
      }
    };
  }
  
  public static Intent newJobShareIntent(FragmentComponent paramFragmentComponent, String paramString, Job paramJob)
  {
    String str = "https://www.linkedin.com/jobs2/view/" + paramString;
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.SUBJECT", paramFragmentComponent.i18NManager().getString(2131231045));
    if ((paramJob != null) && (miniCompany != null)) {}
    for (paramString = miniCompany.name;; paramString = "")
    {
      localIntent.putExtra("android.intent.extra.TEXT", paramFragmentComponent.i18NManager().getString(2131231046, new Object[] { paramString, str }));
      return localIntent;
    }
  }
  
  private static boolean onJobApplyTap(Job paramJob, JobDataProvider paramJobDataProvider, FragmentComponent paramFragmentComponent)
  {
    if (isLinkedInRouting) {}
    for (String str = "job_apply_profile";; str = "job_apply_website")
    {
      fireJobActionTrackingEvent(paramJobDataProvider, paramFragmentComponent, ActionCategory.APPLY, str);
      if (!isLinkedInRouting) {
        break label151;
      }
      if (applicant.hasEmailAddress) {
        break;
      }
      paramJob = (JobDataProvider.JobState)state;
      paramJobDataProvider = new PhoneOnlyUserDialogManager(paramFragmentComponent.activity(), paramFragmentComponent.intentRegistry(), activityactivityComponent.flagshipSharedPreferences(), paramFragmentComponent.tracker());
      onEmailClickCallback = new Closure() {};
      paramJobDataProvider.showDialog(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface) {}
      });
      return true;
    }
    paramJob = new ApplyJobViaLinkedInFragment();
    paramFragmentComponent.activity().getModalFragmentTransaction().replace(2131756509, paramJob).addToBackStack(null).commit();
    for (;;)
    {
      return false;
      label151:
      if (hasCompanyApplyUrl) {
        paramJobDataProvider = "";
      }
      try
      {
        str = new URL(companyApplyUrl).getHost();
        paramJobDataProvider = str;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          paramFragmentComponent.context();
          Util.safeThrow$7a8b4789(new RuntimeException(localMalformedURLException));
        }
      }
      paramJobDataProvider = WebViewerBundle.create(companyApplyUrl, paramFragmentComponent.i18NManager().getString(2131230950), paramJobDataProvider, -1).setUsage$37eab3ba();
      paramFragmentComponent.webRouterUtil().launchWebViewer(paramJobDataProvider, paramFragmentComponent, WebRouterUtil.shouldForceIgnoreDeeplink(companyApplyUrl));
    }
  }
  
  public static void preFillTopCard(FragmentComponent paramFragmentComponent, EntityDetailedTopCardViewHolder paramEntityDetailedTopCardViewHolder, MiniJob paramMiniJob)
  {
    new ImageModel(logo, GhostImageUtils.getJob(2131492964, paramMiniJob), Util.retrieveRumSessionId(paramFragmentComponent)).setImageView(paramFragmentComponent.mediaCenter(), iconView);
    ViewUtils.setTextAndUpdateVisibility(titleView, title);
  }
  
  public static void setJobImpressionTrackingEventClosure(EntityBaseCardViewModel paramEntityBaseCardViewModel, String paramString, TrackingObject paramTrackingObject)
  {
    if ((paramEntityBaseCardViewModel != null) && (paramTrackingObject != null)) {
      trackingEventBuilderClosure = newJobImpressionTrackingClosure(paramString, paramTrackingObject, header, trackingUrns);
    }
  }
  
  public static List<ViewModel> toCardViewModels(FragmentComponent paramFragmentComponent, JobDataProvider paramJobDataProvider, List<Section.Items> paramList)
  {
    Job localJob = ((JobDataProvider.JobState)state).job();
    ArrayList localArrayList = new ArrayList();
    if ((localJob == null) || (CollectionUtils.isEmpty(paramList))) {}
    Iterator localIterator;
    do
    {
      return localArrayList;
      localIterator = paramList.iterator();
    } while (!localIterator.hasNext());
    JobItem localJobItem = nextjobItemValue;
    paramList = item;
    switch (itemInfo.itemType.jobItemTypeValue)
    {
    default: 
      Log.e(TAG, "Unsupported job item type: " + itemInfo.itemType);
      paramList = null;
    }
    for (;;)
    {
      Object localObject1 = state).jobTrackingObject;
      setJobImpressionTrackingEventClosure(paramList, itemInfo.trackingId, (TrackingObject)localObject1);
      CollectionUtils.addItemIfNonNull(localArrayList, paramList);
      break;
      paramList = JobCardsTransformer.toApplicantRankingHelper(paramFragmentComponent, applicantRankingValue, paramFragmentComponent.i18NManager().getString(2131230945), new EntitiesSwitchTabOnClickListener(paramFragmentComponent, EntityPagerAdapter.TabType.PREMIUM, "premium_nav", new TrackingEventBuilder[0]));
      continue;
      localObject1 = applicantRankingValue;
      paramList = new PremiumRankCardViewModel();
      Object localObject2 = paramFragmentComponent.i18NManager();
      description = ((I18NManager)localObject2).getString(2131230978);
      value = ((I18NManager)localObject2).getString(Long.toString(numberOfApplicants), new Object[0]);
      linkText = ((I18NManager)localObject2).getString(2131230981);
      cardOnClickListener = new PremiumUpsellOnClickListener(paramFragmentComponent, PremiumUpsellChannel.JOBS, "premium_jobs_upsell", new TrackingEventBuilder[0]);
      noOfApplicantText = ((I18NManager)localObject2).getString(2131230856);
      premiumUpsellTrackingClosure = new JobCardsTransformer.2();
      continue;
      localObject1 = companyGrowthInsightsValue;
      if (companyName == null)
      {
        paramList = null;
      }
      else
      {
        paramList = new PremiumRankCardViewModel();
        localObject2 = paramFragmentComponent.i18NManager();
        if (companyGrowthPercent == 0)
        {
          description = ((I18NManager)localObject2).getString(2131230977, new Object[] { companyName });
          label486:
          if (companyGrowthPercent <= 0) {
            break label606;
          }
        }
        label606:
        for (value = ((I18NManager)localObject2).getString(2131231013, new Object[] { Double.valueOf(companyGrowthPercent / 100.0F) });; value = ((I18NManager)localObject2).getString(2131233038, new Object[] { Double.valueOf(companyGrowthPercent / 100.0F) }))
        {
          linkText = paramFragmentComponent.i18NManager().getString(2131230945);
          cardOnClickListener = new EntitiesSwitchTabOnClickListener(paramFragmentComponent, EntityPagerAdapter.TabType.PREMIUM, "premium_nav", new TrackingEventBuilder[0]);
          companyGrowthText = ((I18NManager)localObject2).getString(2131230860);
          break;
          description = ((I18NManager)localObject2).getString(2131230976, new Object[] { companyName });
          break label486;
        }
        localObject1 = companyGrowthInsightsValue;
        if (companyName == null)
        {
          paramList = null;
        }
        else
        {
          paramList = new PremiumRankCardViewModel();
          localObject2 = paramFragmentComponent.i18NManager();
          if (companyGrowthPercent == 0)
          {
            description = ((I18NManager)localObject2).getString(2131230980, new Object[] { companyName });
            label707:
            if (companyGrowthPercent <= 0) {
              break label834;
            }
          }
          label834:
          for (value = ((I18NManager)localObject2).getString(2131231013, new Object[] { Double.valueOf(companyGrowthPercent / 100.0F) });; value = ((I18NManager)localObject2).getString(2131233038, new Object[] { Double.valueOf(companyGrowthPercent / 100.0F) }))
          {
            linkText = ((I18NManager)localObject2).getString(2131230981);
            cardOnClickListener = new PremiumUpsellOnClickListener(paramFragmentComponent, PremiumUpsellChannel.JOBS, "premium_jobs_upsell", new TrackingEventBuilder[0]);
            companyGrowthText = ((I18NManager)localObject2).getString(2131230860);
            premiumUpsellTrackingClosure = new JobCardsTransformer.2();
            break;
            description = ((I18NManager)localObject2).getString(2131230979, new Object[] { companyName });
            break label707;
          }
          paramList = JobCardsTransformer.toJobDescriptionCard(paramFragmentComponent, paramJobDataProvider, descriptionValue, true);
          continue;
          paramList = JobCardsTransformer.toJobPosterCard(paramFragmentComponent, paramJobDataProvider, inCommonPersonValue);
          continue;
          paramList = JobCardsTransformer.toImmediateConnectionsAtCompanyCard(paramFragmentComponent, paramJobDataProvider, localJob, miniProfilesCollectionValue);
          continue;
          paramList = null;
          continue;
          paramList = null;
          continue;
          paramList = null;
          continue;
          localObject1 = basicCompanyInfoValue;
          paramList = new EntitySingleCardViewModel();
          header = paramFragmentComponent.i18NManager().getString(2131230970, new Object[] { miniCompany.name });
          localObject2 = activityactivityComponent.jobDataProvider();
          Map localMap = Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance());
          EntityItemViewModel localEntityItemViewModel = new EntityItemViewModel();
          I18NManager localI18NManager = paramFragmentComponent.i18NManager();
          String str = Util.retrieveRumSessionId(paramFragmentComponent);
          MiniCompany localMiniCompany = miniCompany;
          title = name;
          subtitle = localI18NManager.getString(2131230900, new Object[] { Integer.valueOf(followingInfo.followerCount) });
          image = new ImageModel(logo, GhostImageUtils.getCompany(2131492963, localMiniCompany), str);
          isImageOval = false;
          ctaButtonIcon = 2130838247;
          ctaClickedButtonIcon = 2130837936;
          isCtaButtonClicked = followingInfo.following;
          onRowClick = new JobItemsTransformer.1(paramFragmentComponent.tracker(), "company_link", localMiniCompany, paramFragmentComponent);
          onCtaButtonClick = new JobItemsTransformer.2(paramFragmentComponent.tracker(), "company_follow_toggle", (JobDataProvider)localObject2, localMiniCompany, (BasicCompanyInfo)localObject1, localMap);
          itemViewModel = localEntityItemViewModel;
          trackingUrns = new ArrayList();
          EntityUtils.addObjectUrnIfNonNull(trackingUrns, miniCompany.objectUrn);
          continue;
          paramList = JobCardsTransformer.toSimilarJobsBrowseMapListCard(paramFragmentComponent, nextJobCollectionValue);
          continue;
          paramList = JobCardsTransformer.toSkillsAndExperienceCard(paramFragmentComponent, skillsAndExperienceValue, true);
          continue;
          paramList = JobCardsTransformer.toJobDetailsCard(paramFragmentComponent, jobDetailsValue);
          continue;
          paramList = null;
          continue;
          paramList = JobCardsTransformer.toApplicantRankingHelper(paramFragmentComponent, applicantRankingValue, null, null);
          continue;
          paramList = JobCardsTransformer.toTopSkillsCard(paramFragmentComponent, topSkillsAnalyticsValue);
          continue;
          paramList = JobCardsTransformer.toSeniorityChartCard(paramFragmentComponent, seniorityAnalyticsValue);
          continue;
          paramList = JobCardsTransformer.toEducationChartCard(paramFragmentComponent, educationAnalyticsValue);
          continue;
          paramList = JobCardsTransformer.toHiringTrendsCard(paramFragmentComponent, companyGrowthInsightsValue);
          continue;
          paramList = JobCardsTransformer.toTopCompaniesCard(paramFragmentComponent, paramJobDataProvider, localJob, inflowCompanyRankingInsightsValue);
          continue;
          paramList = JobCardsTransformer.toTopSchoolsCard(paramFragmentComponent, paramJobDataProvider, localJob, schoolRankingInsightsValue);
          continue;
          paramList = JobCardsTransformer.toJobSummaryCard(paramFragmentComponent, paramJobDataProvider, groupedJobItemValue);
        }
      }
    }
  }
  
  public static ApplyJobViaLinkedInViewModel toLinkedInApplyScreen(final FragmentComponent paramFragmentComponent, final String paramString, final JobDataProvider paramJobDataProvider, Applicant paramApplicant)
  {
    final Map localMap = Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance());
    ApplyJobViaLinkedInViewModel localApplyJobViaLinkedInViewModel = new ApplyJobViaLinkedInViewModel();
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    MiniProfile localMiniProfile = miniProfile;
    name = localI18NManager.getString(2131233236, new Object[] { I18NManager.getName(localMiniProfile) });
    actorImageModel = new ImageModel(picture, GhostImageUtils.getPerson(2131492968, localMiniProfile), Util.retrieveRumSessionId(paramFragmentComponent));
    headline = occupation;
    location = location;
    email = emailAddress;
    if (hasPhoneNumber) {}
    for (paramApplicant = phoneNumber.number;; paramApplicant = null)
    {
      phone = paramApplicant;
      onSubmitApplicationClick = new TrackingClosure(paramFragmentComponent.tracker(), "job_apply_profile_submit") {};
      onEditProfileClick = new TrackingClosure(paramFragmentComponent.tracker(), "job_apply_profile_edit") {};
      onCloseModalClick = new Closure() {};
      return localApplyJobViaLinkedInViewModel;
    }
  }
  
  public static EntityDetailedTopCardViewModel toTopCard(final FragmentComponent paramFragmentComponent, final JobDataProvider paramJobDataProvider, final Job paramJob)
  {
    EntityDetailedTopCardViewModel localEntityDetailedTopCardViewModel = new EntityDetailedTopCardViewModel();
    final Object localObject1 = miniJob;
    topCardTopScrimWeight = paramFragmentComponent.activity().getResources().getFraction(2131689472, 1, 1);
    Object localObject2 = Util.retrieveRumSessionId(paramFragmentComponent);
    heroImage = new ImageModel(heroImage, 2130837793, (String)localObject2);
    icon = new ImageModel(logo, GhostImageUtils.getJob(2131492964, (MiniJob)localObject1), (String)localObject2);
    title = title;
    subtitle1 = EntityUtils.formatCompanyNameAndLocation(paramFragmentComponent, companyName, miniJob.location);
    subtitle2 = getTimeFromPostDateAndNumberOfViews(paramFragmentComponent.i18NManager(), paramJob, System.currentTimeMillis(), false);
    subtitle2ContentDescription = getTimeFromPostDateAndNumberOfViews(paramFragmentComponent.i18NManager(), paramJob, System.currentTimeMillis(), true);
    Object localObject3;
    if (CollectionUtils.isNonEmpty(flavors))
    {
      localObject2 = (EntitiesFlavor)flavors.get(0);
      if (!EntityUtils.isLixEnabled(paramFragmentComponent.lixManager(), Lix.ENTITIES_JOB_DETAIL_TAPPABLE_FLAVORS)) {
        break label656;
      }
      localObject3 = reason;
      localObject1 = null;
      if (inNetworkReasonValue != null)
      {
        localObject1 = newInsightClickListener(paramFragmentComponent, 0, "job_insight_connections");
        paramJobDataProvider.setupImmediateConnectionsHelper(null);
        insight = FeedInsightTransformer.toInsightViewModel((EntitiesFlavor)localObject2, paramFragmentComponent, (TrackingOnClickListener)localObject1, 3);
      }
    }
    else
    {
      if (!closed) {
        break label661;
      }
      detail = paramFragmentComponent.i18NManager().getString(2131230861);
    }
    for (;;)
    {
      if (miniCompany != null) {
        onLogoClick = new TrackingClosure(paramFragmentComponent.tracker(), "company_logo_link") {};
      }
      if (!closed)
      {
        secondaryButtonDefaultText = paramFragmentComponent.i18NManager().getString(2131231018);
        secondaryButtonClickedText = paramFragmentComponent.i18NManager().getString(2131231019);
        isSecondaryButtonClicked = savingInfo.saved;
        localObject1 = Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance());
        onSecondaryButtonClick = new TrackingClosure(paramFragmentComponent.tracker(), "job_save_toggle") {};
        if (!isLinkedInRouting) {
          break label744;
        }
        if (hasApplicant) {
          break label708;
        }
        Log.e("Job Applicant should be available when applying for a job via LinkedIn!");
        primaryButtonDefaultText = null;
      }
      return localEntityDetailedTopCardViewModel;
      if (companyRecruitReasonValue != null)
      {
        localObject1 = newInsightClickListener(paramFragmentComponent, 6, "job_insight_company");
        localJobState = (JobDataProvider.JobState)state;
        localObject3 = companyRecruitReasonValue.currentCompany.entityUrn.getId();
        str1 = jobminiJob.entityUrn.getId();
        str2 = jobminiCompany.entityUrn.getId();
        companyRecruitsRoute = Routes.JOB.buildRouteForId(str1).buildUpon().appendEncodedPath("companyRecruits").appendQueryParameter("companyId", str2).appendQueryParameter("viewerCurrentCompanyId", (String)localObject3).build().toString();
        break;
      }
      if (schoolRecruitReasonValue == null) {
        break;
      }
      localObject1 = newInsightClickListener(paramFragmentComponent, 5, "job_insight_school");
      JobDataProvider.JobState localJobState = (JobDataProvider.JobState)state;
      localObject3 = schoolRecruitReasonValue.mostRecentSchool.entityUrn.getId();
      String str1 = jobminiJob.entityUrn.getId();
      String str2 = jobminiCompany.entityUrn.getId();
      schoolRecruitsRoute = Routes.JOB.buildRouteForId(str1).buildUpon().appendEncodedPath("schoolRecruits").appendQueryParameter("companyId", str2).appendQueryParameter("viewerMostRecentSchoolId", (String)localObject3).build().toString();
      break;
      label656:
      localObject1 = null;
      break;
      label661:
      if (applyingInfo.hasAppliedAt) {
        detail = paramFragmentComponent.i18NManager().getString(2131230946, new Object[] { Long.valueOf(applyingInfo.appliedAt) });
      }
    }
    label708:
    primaryButtonDefaultIcon = EntityUtils.createButtonIcon(paramFragmentComponent, 2130838557, 2130837652);
    primaryButtonIconPadding = ((int)paramFragmentComponent.activity().getResources().getDimension(2131492989));
    label744:
    if (!applyingInfo.applied) {
      primaryButtonDefaultText = paramFragmentComponent.i18NManager().getString(2131230947);
    }
    isPrimaryButtonClicked = applyingInfo.applied;
    if (isLinkedInRouting) {}
    for (localObject1 = "job_apply_profile";; localObject1 = "job_apply_website")
    {
      onPrimaryButtonClick = new TrackingClosure(paramFragmentComponent.tracker(), (String)localObject1) {};
      return localEntityDetailedTopCardViewModel;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.transformers.JobTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */