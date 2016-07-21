package com.linkedin.android.entities.job.transformers;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.entities.job.JobDataProvider.JobState;
import com.linkedin.android.entities.job.controllers.ApplyJobViaLinkedInFragment;
import com.linkedin.android.entities.viewmodels.EntityDetailedTopCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.MultiHeadlineCardViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.TrackingUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.JobApplyingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.JobSavingInfo;
import com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails;
import com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails.ApplyMethod;
import com.linkedin.android.pegasus.gen.voyager.jobs.OffsiteApply;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipJobActionEvent.Builder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JobTransformerV2
{
  private static final String TAG = JobTransformerV2.class.getSimpleName();
  
  private static void fireJobActionTrackingEvent(JobDataProvider paramJobDataProvider, FragmentComponent paramFragmentComponent, ActionCategory paramActionCategory, String paramString)
  {
    paramJobDataProvider = state).jobTrackingObject;
    if (paramJobDataProvider == null) {
      return;
    }
    paramString = TrackingUtils.constructFullTrackingControlUrn("job", paramString);
    paramFragmentComponent.tracker().send(new FlagshipJobActionEvent.Builder().setActionCategory(paramActionCategory).setControlUrn(paramString).setSubItemUrn(objectUrn).setJob(paramJobDataProvider));
  }
  
  private static String getTimeFromPostDateAndNumberOfViews(I18NManager paramI18NManager, JobDetails paramJobDetails, long paramLong, boolean paramBoolean)
  {
    if ((hasListedAt) && (hasViews)) {
      return paramI18NManager.getString(2131230987, new Object[] { EntityTransformer.toPostedTimeAgoString$3d933973(paramI18NManager, paramI18NManager.getString(2131230971), listedAt, paramLong, paramBoolean), Long.valueOf(views) });
    }
    if (hasListedAt) {
      return EntityTransformer.toPostedTimeAgoString$3d933973(paramI18NManager, paramI18NManager.getString(2131230971), listedAt, paramLong, paramBoolean);
    }
    if (hasViews) {
      return paramI18NManager.getString(2131230972, new Object[] { Long.valueOf(views) });
    }
    return null;
  }
  
  public static Intent newJobShareIntent$6ee61e77(FragmentComponent paramFragmentComponent, String paramString)
  {
    paramString = "https://www.linkedin.com/jobs2/view/" + paramString;
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.SUBJECT", paramFragmentComponent.i18NManager().getString(2131231045));
    localIntent.putExtra("android.intent.extra.TEXT", paramFragmentComponent.i18NManager().getString(2131231046, new Object[] { "", paramString }));
    return localIntent;
  }
  
  private static boolean onJobApplyTap(JobDetails paramJobDetails, JobDataProvider paramJobDataProvider, FragmentComponent paramFragmentComponent)
  {
    String str;
    if (applyMethod.hasSimpleOnsiteApplyValue)
    {
      str = "job_apply_profile";
      fireJobActionTrackingEvent(paramJobDataProvider, paramFragmentComponent, ActionCategory.APPLY, str);
      if (!applyMethod.hasSimpleOnsiteApplyValue) {
        break label73;
      }
      paramJobDetails = new ApplyJobViaLinkedInFragment();
      paramFragmentComponent.activity().getModalFragmentTransaction().replace(2131756509, paramJobDetails).addToBackStack(null).commit();
    }
    for (;;)
    {
      return false;
      str = "job_apply_website";
      break;
      label73:
      if (applyMethod.hasOffsiteApplyValue) {
        paramJobDataProvider = "";
      }
      try
      {
        str = new URL(applyMethod.offsiteApplyValue.companyApplyUrl).getHost();
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
      paramJobDataProvider = WebViewerBundle.create(applyMethod.offsiteApplyValue.companyApplyUrl, paramFragmentComponent.i18NManager().getString(2131230950), paramJobDataProvider, -1).setUsage$37eab3ba();
      paramFragmentComponent.webRouterUtil().launchWebViewer(paramJobDataProvider, paramFragmentComponent, WebRouterUtil.shouldForceIgnoreDeeplink(applyMethod.offsiteApplyValue.companyApplyUrl));
    }
  }
  
  public static List<ViewModel> toCardViewModels(FragmentComponent paramFragmentComponent, JobDataProvider paramJobDataProvider)
  {
    JobDetails localJobDetails = ((JobDataProvider.JobState)state).jobDetails();
    ArrayList localArrayList = new ArrayList();
    if (localJobDetails == null) {
      return localArrayList;
    }
    CollectionUtils.addItemIfNonNull(localArrayList, JobCardsTransformerV2.toJobDescriptionCard(paramFragmentComponent, localJobDetails));
    paramJobDataProvider = new MultiHeadlineCardViewModel();
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    header = localI18NManager.getString(2131230958);
    multiHeadlineCardMaxPairsCollapsed = paramFragmentComponent.activity().getResources().getInteger(2131558424);
    if (hasFormattedEmploymentStatus) {
      items.add(EntityTransformer.toNonLinkableDetailItem(localI18NManager.getString(2131230961), formattedEmploymentStatus));
    }
    if (CollectionUtils.isNonEmpty(formattedIndustries)) {
      items.add(EntityTransformer.toNonLinkableDetailItem(localI18NManager.getString(2131230967), TextUtils.join(", ", formattedIndustries)));
    }
    if (CollectionUtils.isNonEmpty(formattedJobFunctions)) {
      items.add(EntityTransformer.toNonLinkableDetailItem(localI18NManager.getString(2131230963), TextUtils.join(", ", formattedJobFunctions)));
    }
    onExpandButtonClick = TrackingClosure.createEmptyTrackingClosure(paramFragmentComponent.tracker(), "see_more");
    paramFragmentComponent = paramJobDataProvider;
    if (items.isEmpty()) {
      paramFragmentComponent = null;
    }
    CollectionUtils.addItemIfNonNull(localArrayList, paramFragmentComponent);
    return localArrayList;
  }
  
  public static EntityDetailedTopCardViewModel toTopCard(final FragmentComponent paramFragmentComponent, final JobDataProvider paramJobDataProvider, final JobDetails paramJobDetails)
  {
    EntityDetailedTopCardViewModel localEntityDetailedTopCardViewModel = new EntityDetailedTopCardViewModel();
    topCardTopScrimWeight = paramFragmentComponent.activity().getResources().getFraction(2131689472, 1, 1);
    coverImageColor = Integer.valueOf(-16711936);
    title = title;
    subtitle1 = EntityUtils.formatCompanyNameAndLocation(paramFragmentComponent, null, formattedLocation);
    subtitle2 = getTimeFromPostDateAndNumberOfViews(paramFragmentComponent.i18NManager(), paramJobDetails, System.currentTimeMillis(), false);
    subtitle2ContentDescription = getTimeFromPostDateAndNumberOfViews(paramFragmentComponent.i18NManager(), paramJobDetails, System.currentTimeMillis(), true);
    if (hasClosedAt)
    {
      detail = paramFragmentComponent.i18NManager().getString(2131230861);
      if (!hasClosedAt)
      {
        secondaryButtonDefaultText = paramFragmentComponent.i18NManager().getString(2131231018);
        secondaryButtonClickedText = paramFragmentComponent.i18NManager().getString(2131231019);
        isSecondaryButtonClicked = savingInfo.saved;
        localObject = Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance());
        onSecondaryButtonClick = new TrackingClosure(paramFragmentComponent.tracker(), "job_save_toggle") {};
        if (applyMethod.hasSimpleOnsiteApplyValue)
        {
          primaryButtonDefaultIcon = EntityUtils.createButtonIcon(paramFragmentComponent, 2130838557, 2130837652);
          primaryButtonIconPadding = ((int)paramFragmentComponent.activity().getResources().getDimension(2131492989));
        }
        if (!applyingInfo.applied) {
          primaryButtonDefaultText = paramFragmentComponent.i18NManager().getString(2131230947);
        }
        isPrimaryButtonClicked = applyingInfo.applied;
        if (!applyMethod.hasSimpleOnsiteApplyValue) {
          break label387;
        }
      }
    }
    label387:
    for (final Object localObject = "job_apply_profile";; localObject = "job_apply_website")
    {
      onPrimaryButtonClick = new TrackingClosure(paramFragmentComponent.tracker(), (String)localObject) {};
      return localEntityDetailedTopCardViewModel;
      if (!applyingInfo.hasAppliedAt) {
        break;
      }
      detail = paramFragmentComponent.i18NManager().getString(2131230946, new Object[] { Long.valueOf(applyingInfo.appliedAt) });
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.transformers.JobTransformerV2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */