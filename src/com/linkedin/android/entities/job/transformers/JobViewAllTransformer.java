package com.linkedin.android.entities.job.transformers;

import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.viewmodels.cards.EntityBaseCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.ParagraphCardViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo.ItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.job.GroupedJobItem;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobItem;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobItem.Item;
import com.linkedin.android.pegasus.gen.voyager.entities.job.JobItemType;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SchoolRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class JobViewAllTransformer
{
  public static List<ViewModel> toJobSummaryCards(FragmentComponent paramFragmentComponent, GroupedJobItem paramGroupedJobItem, TrackingObject paramTrackingObject)
  {
    if (paramGroupedJobItem == null) {}
    Object localObject1;
    do
    {
      return null;
      localObject1 = mainItem;
    } while (itemInfo.itemType.jobItemTypeValue != JobItemType.DESCRIPTION);
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = item.descriptionValue;
    localObject2 = JobCardsTransformer.toJobDescriptionCard(paramFragmentComponent, paramFragmentComponent.jobDataProvider(), (Description)localObject2, false);
    maxLinesCollapsed = Integer.MAX_VALUE;
    JobTransformer.setJobImpressionTrackingEventClosure((EntityBaseCardViewModel)localObject2, itemInfo.trackingId, paramTrackingObject);
    localArrayList.add(localObject2);
    if (additionalItems != null)
    {
      localObject1 = additionalItems.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (JobItem)((Iterator)localObject1).next();
        JobItemType localJobItemType = itemInfo.itemType.jobItemTypeValue;
        paramGroupedJobItem = null;
        if (localJobItemType == JobItemType.SKILLS_AND_EXPERIENCE)
        {
          paramGroupedJobItem = item.skillsAndExperienceValue;
          if (paramGroupedJobItem == null) {
            paramGroupedJobItem = null;
          }
        }
        for (;;)
        {
          JobTransformer.setJobImpressionTrackingEventClosure(paramGroupedJobItem, itemInfo.trackingId, paramTrackingObject);
          CollectionUtils.addItemIfNonNull(localArrayList, paramGroupedJobItem);
          break;
          paramGroupedJobItem = JobCardsTransformer.toSkillsAndExperienceCard(paramFragmentComponent, paramGroupedJobItem, false);
          continue;
          if (localJobItemType == JobItemType.DETAILS)
          {
            paramGroupedJobItem = JobCardsTransformer.toJobDetailsCard(paramFragmentComponent, item.jobDetailsValue);
            if (paramGroupedJobItem != null)
            {
              isExpanded = true;
              onExpandButtonClick = null;
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public static List<ViewModel> toViewAllEmployeesAtCompany(FragmentComponent paramFragmentComponent, CollectionTemplate<EntitiesMiniProfile, CollectionMetadata> paramCollectionTemplate, TrackingObject paramTrackingObject)
  {
    if (CollectionUtils.isEmpty(paramCollectionTemplate))
    {
      paramCollectionTemplate = null;
      return paramCollectionTemplate;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = elements.iterator();
    for (;;)
    {
      paramCollectionTemplate = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      EntitiesMiniProfile localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
      paramCollectionTemplate = null;
      MiniProfile localMiniProfile = miniProfile;
      if (paramTrackingObject != null) {
        paramCollectionTemplate = JobTransformer.newJobImpressionTrackingClosure(trackingId, paramTrackingObject, firstName, Collections.singletonList(objectUrn.toString()));
      }
      localArrayList.add(EntityTransformer.toConnectionItem(paramFragmentComponent, activityactivityComponent, localEntitiesMiniProfile, paramCollectionTemplate));
    }
  }
  
  public static List<ViewModel> toViewAllTopCompanies(FragmentComponent paramFragmentComponent, List<CompanyRanking> paramList, TrackingObject paramTrackingObject)
  {
    Object localObject;
    if (CollectionUtils.isEmpty(paramList))
    {
      localObject = null;
      return (List<ViewModel>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= paramList.size()) {
        break;
      }
      CompanyRanking localCompanyRanking = (CompanyRanking)paramList.get(i);
      localObject = null;
      if (paramTrackingObject != null)
      {
        localObject = miniCompany;
        localObject = JobTransformer.newJobImpressionTrackingClosure(trackingId, paramTrackingObject, name, Collections.singletonList(objectUrn.toString()));
      }
      localArrayList.add(JobItemsTransformer.toCompanyRankingItem(paramFragmentComponent, localCompanyRanking, (Closure)localObject));
      i += 1;
    }
  }
  
  public static List<ViewModel> toViewAllTopSchools(FragmentComponent paramFragmentComponent, List<SchoolRanking> paramList, TrackingObject paramTrackingObject)
  {
    Object localObject;
    if (CollectionUtils.isEmpty(paramList))
    {
      localObject = null;
      return (List<ViewModel>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= paramList.size()) {
        break;
      }
      SchoolRanking localSchoolRanking = (SchoolRanking)paramList.get(i);
      localObject = null;
      if (paramTrackingObject != null)
      {
        localObject = miniSchool;
        localObject = JobTransformer.newJobImpressionTrackingClosure(trackingId, paramTrackingObject, schoolName, Collections.singletonList(objectUrn.toString()));
      }
      localArrayList.add(JobItemsTransformer.toSchoolRankingItem(paramFragmentComponent, localSchoolRanking, (Closure)localObject));
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.transformers.JobViewAllTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */