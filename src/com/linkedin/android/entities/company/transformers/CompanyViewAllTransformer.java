package com.linkedin.android.entities.company.transformers;

import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.entities.viewmodels.cards.EntitySingleCardViewModel;
import com.linkedin.android.entities.viewmodels.items.RowTilesViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo.Builder;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.company.Showcases;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPersonCollection.Builder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniProfileWithDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class CompanyViewAllTransformer
{
  private static PagingInfo defaultPagingInfo;
  
  static
  {
    try
    {
      PagingInfo.Builder localBuilder = new PagingInfo.Builder();
      Integer localInteger = Integer.valueOf(0);
      if (localInteger == null)
      {
        hasStart = false;
        start = 0;
        localInteger = Integer.valueOf(10);
        if (localInteger != null) {
          break label74;
        }
        hasCount = false;
      }
      for (count = 0;; count = localInteger.intValue())
      {
        defaultPagingInfo = localBuilder.build(RecordTemplate.Flavor.RECORD);
        return;
        hasStart = true;
        start = localInteger.intValue();
        break;
        label74:
        hasCount = true;
      }
      return;
    }
    catch (BuilderException localBuilderException) {}
  }
  
  public static List<ViewModel> toViewAllCommonCompaniesAlumniList(FragmentComponent paramFragmentComponent, CollectionTemplate<InCommonCompany, CollectionMetadata> paramCollectionTemplate, TrackingObject paramTrackingObject)
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
      EntitiesMiniProfile localEntitiesMiniProfile = nextmember;
      paramCollectionTemplate = null;
      if (paramTrackingObject != null)
      {
        paramCollectionTemplate = miniProfile;
        paramCollectionTemplate = CompanyTransformer.newCompanyImpressionTrackingClosure(trackingId, paramTrackingObject, firstName, Collections.singletonList(objectUrn.toString()));
      }
      localArrayList.add(EntityTransformer.toConnectionItem(paramFragmentComponent, activityactivityComponent, localEntitiesMiniProfile, paramCollectionTemplate));
    }
  }
  
  public static List<ViewModel> toViewAllImmediateConnectionsList(FragmentComponent paramFragmentComponent, CollectionTemplate<EntitiesMiniProfile, CollectionMetadata> paramCollectionTemplate, TrackingObject paramTrackingObject)
  {
    if (CollectionUtils.isEmpty(paramCollectionTemplate)) {
      paramCollectionTemplate = null;
    }
    ArrayList localArrayList;
    boolean bool;
    Iterator localIterator;
    do
    {
      return paramCollectionTemplate;
      localArrayList = new ArrayList();
      bool = EntityUtils.isLixEnabled(paramFragmentComponent.lixManager(), Lix.ENTITIES_COMPANIES_OUT_OF_NETWORK_COMPANY_EMPLOYEES);
      localIterator = elements.iterator();
      paramCollectionTemplate = localArrayList;
    } while (!localIterator.hasNext());
    EntitiesMiniProfile localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
    paramCollectionTemplate = null;
    MiniProfile localMiniProfile = miniProfile;
    if (paramTrackingObject != null) {
      paramCollectionTemplate = CompanyTransformer.newCompanyImpressionTrackingClosure(trackingId, paramTrackingObject, firstName, Collections.singletonList(objectUrn.toString()));
    }
    if (bool) {}
    for (paramCollectionTemplate = EntityTransformer.toConnectionItem(paramFragmentComponent, activityactivityComponent, localEntitiesMiniProfile, paramCollectionTemplate);; paramCollectionTemplate = EntityTransformer.toConnectionItem(paramFragmentComponent, activityactivityComponent, localMiniProfile, distance, paramCollectionTemplate))
    {
      localArrayList.add(paramCollectionTemplate);
      break;
    }
  }
  
  public static List<ViewModel> toViewAllIntroducerInCommonsList(FragmentComponent paramFragmentComponent, List<MiniProfile> paramList, TrackingObject paramTrackingObject)
  {
    if (CollectionUtils.isEmpty(paramList))
    {
      paramList = null;
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      MiniProfile localMiniProfile = (MiniProfile)localIterator.next();
      paramList = null;
      if (paramTrackingObject != null) {
        paramList = CompanyTransformer.newCompanyImpressionTrackingClosure(trackingId, paramTrackingObject, firstName, Collections.singletonList(objectUrn.toString()));
      }
      localArrayList.add(EntityTransformer.toPersonItem(paramFragmentComponent, localMiniProfile, false, paramList));
    }
  }
  
  public static List<ViewModel> toViewAllIntroducersList(FragmentComponent paramFragmentComponent, CompanyDataProvider paramCompanyDataProvider, CollectionTemplate<InCommonPerson, CollectionMetadata> paramCollectionTemplate, String paramString, TrackingObject paramTrackingObject)
  {
    ArrayList localArrayList = null;
    if (CollectionUtils.isEmpty(paramCollectionTemplate)) {
      paramCollectionTemplate = localArrayList;
    }
    Iterator localIterator;
    do
    {
      return paramCollectionTemplate;
      localArrayList = new ArrayList();
      localIterator = elements.iterator();
      paramCollectionTemplate = localArrayList;
    } while (!localIterator.hasNext());
    paramCollectionTemplate = (InCommonPerson)localIterator.next();
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        localObject1 = new InCommonPersonCollection.Builder();
        localObject2 = Collections.singletonList(paramCollectionTemplate);
        if (localObject2 != null) {
          break label200;
        }
        hasItems = false;
        items = null;
        localObject2 = defaultPagingInfo;
        if (localObject2 != null) {
          break label216;
        }
        hasPagingInfo = false;
        pagingInfo = null;
        localObject1 = CompanyCardsTransformer.toIntroducerCard(paramFragmentComponent, paramCompanyDataProvider, ((InCommonPersonCollection.Builder)localObject1).build(RecordTemplate.Flavor.RECORD), paramString, false);
        if (paramTrackingObject != null) {
          trackingEventBuilderClosure = CompanyTransformer.newCompanyImpressionTrackingClosure(member.miniProfile.trackingId, paramTrackingObject, header, trackingUrns);
        }
        localArrayList.add(localObject1);
      }
      catch (BuilderException paramCollectionTemplate)
      {
        paramFragmentComponent.context();
        Util.safeThrow$7a8b4789(new RuntimeException(paramCollectionTemplate));
      }
      break;
      label200:
      hasItems = true;
      items = ((List)localObject2);
      continue;
      label216:
      hasPagingInfo = true;
      pagingInfo = ((PagingInfo)localObject2);
    }
  }
  
  public static List<ViewModel> toViewAllJobsList(FragmentComponent paramFragmentComponent, CollectionTemplate<MiniJob, CollectionMetadata> paramCollectionTemplate, TrackingObject paramTrackingObject)
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
      MiniJob localMiniJob = (MiniJob)localIterator.next();
      paramCollectionTemplate = null;
      if (paramTrackingObject != null) {
        paramCollectionTemplate = CompanyTransformer.newCompanyImpressionTrackingClosure(trackingId, paramTrackingObject, title, Collections.singletonList(objectUrn.toString()));
      }
      localArrayList.add(EntityTransformer.toJobItem(paramFragmentComponent, localMiniJob, paramCollectionTemplate));
    }
  }
  
  public static List<ViewModel> toViewAllJobsThatMatchedYourSkillsList(FragmentComponent paramFragmentComponent, CollectionTemplate<MiniJob, CollectionMetadata> paramCollectionTemplate, TrackingObject paramTrackingObject)
  {
    Object localObject;
    if (CollectionUtils.isEmpty(paramCollectionTemplate))
    {
      localObject = null;
      return (List<ViewModel>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      localObject = localArrayList;
      if (i >= elements.size()) {
        break;
      }
      localObject = new RowTilesViewModel();
      MiniJob localMiniJob = (MiniJob)elements.get(i);
      tileLeft = CompanyItemsTransformer.toJobTile(paramFragmentComponent, localMiniJob);
      if (i + 1 < elements.size()) {
        tileRight = CompanyItemsTransformer.toJobTile(paramFragmentComponent, (MiniJob)elements.get(i + 1));
      }
      if (paramTrackingObject != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put(trackingId, Collections.singletonList(objectUrn.toString()));
        if (tileRight != null)
        {
          localMiniJob = (MiniJob)elements.get(i + 1);
          localHashMap.put(trackingId, Collections.singletonList(objectUrn.toString()));
        }
        trackingEventBuilderClosure = CompanyTransformer.newCompanyImpressionTrackingClosure$637dce18(localHashMap, paramTrackingObject);
      }
      localArrayList.add(localObject);
      i += 2;
    }
  }
  
  public static List<ViewModel> toViewAllShowcasesList(FragmentComponent paramFragmentComponent, Showcases paramShowcases, TrackingObject paramTrackingObject)
  {
    if ((paramShowcases != null) && (CollectionUtils.isEmpty(showcases)))
    {
      paramShowcases = null;
      return paramShowcases;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = showcases.iterator();
    for (;;)
    {
      paramShowcases = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      BasicCompanyInfo localBasicCompanyInfo = (BasicCompanyInfo)localIterator.next();
      paramShowcases = null;
      if (paramTrackingObject != null) {
        paramShowcases = CompanyTransformer.newCompanyImpressionTrackingClosure(miniCompany.trackingId, paramTrackingObject, miniCompany.name, Collections.singletonList(miniCompany.objectUrn.toString()));
      }
      localArrayList.add(CompanyItemsTransformer.toShowcaseItem(paramFragmentComponent, localBasicCompanyInfo, paramShowcases));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.transformers.CompanyViewAllTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */