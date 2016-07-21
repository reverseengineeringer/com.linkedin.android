package com.linkedin.android.entities.school.transformers;

import android.content.res.Resources;
import android.text.Html;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.school.SchoolDataProvider;
import com.linkedin.android.entities.school.SchoolDataProvider.SchoolState;
import com.linkedin.android.entities.school.SchoolViewAllBundleBuilder;
import com.linkedin.android.entities.school.controllers.SchoolViewAllFragment;
import com.linkedin.android.entities.viewmodels.cards.EntityListCardViewModel;
import com.linkedin.android.entities.viewmodels.items.EntityItemViewModel;
import com.linkedin.android.entities.viewmodels.items.RankItemViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniProfilesCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.school.NextSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.school.NextSchoolsCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolRankings;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class SchoolCardsTransformer
{
  public static EntityListCardViewModel toFirstDegreeStudentsAndAlumniCard(FragmentComponent paramFragmentComponent, SchoolDataProvider paramSchoolDataProvider, MiniProfilesCollection paramMiniProfilesCollection)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    Resources localResources = paramFragmentComponent.activity().getResources();
    ActivityComponent localActivityComponent = activityactivityComponent;
    header = localResources.getString(2131231053);
    entityListCardMaxRows = localResources.getInteger(2131558432);
    List localList = items;
    int j = localList.size();
    trackingUrns = new ArrayList();
    int i = 0;
    while ((i < j) && (i < entityListCardMaxRows))
    {
      EntitiesMiniProfile localEntitiesMiniProfile = (EntitiesMiniProfile)localList.get(i);
      items.add(EntityTransformer.toConnectionItem(paramFragmentComponent, localActivityComponent, miniProfile, distance));
      EntityUtils.addObjectUrnIfNonNull(trackingUrns, miniProfile.objectUrn);
      i += 1;
    }
    if (j > entityListCardMaxRows)
    {
      viewAllText = localResources.getString(2131231000);
      viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, SchoolViewAllFragment.newInstance(SchoolViewAllBundleBuilder.create(0)), "see_all");
      if (state).firstDegreeHelper != null) {}
    }
    try
    {
      paramFragmentComponent = EntityUtils.createDefaultCollection(items, pagingInfo);
      state).firstDegreeHelper = new CollectionTemplateHelper(activityComponent.dataManager(), null, paramFragmentComponent, EntitiesMiniProfile.BUILDER, CollectionMetadata.BUILDER);
      return localEntityListCardViewModel;
    }
    catch (BuilderException paramFragmentComponent)
    {
      activityComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException(paramFragmentComponent));
    }
    return localEntityListCardViewModel;
  }
  
  public static EntityListCardViewModel toRankingsCard(FragmentComponent paramFragmentComponent, SchoolRankings paramSchoolRankings)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    Object localObject = paramFragmentComponent.activity().getResources();
    paramFragmentComponent = paramFragmentComponent.i18NManager();
    header = ((Resources)localObject).getString(2131230933);
    viewAllText = ((Resources)localObject).getString(2131231001);
    entityListCardMaxRows = ((Resources)localObject).getInteger(2131558433);
    paramSchoolRankings = rankings.iterator();
    while (paramSchoolRankings.hasNext())
    {
      localObject = (SchoolRanking)paramSchoolRankings.next();
      List localList = items;
      RankItemViewModel localRankItemViewModel = new RankItemViewModel();
      rank = Long.toString(ranking);
      description = Html.fromHtml(paramFragmentComponent.getString(2131231027, new Object[] { category }));
      caption = degreeLevel;
      localList.add(localRankItemViewModel);
    }
    return localEntityListCardViewModel;
  }
  
  public static EntityListCardViewModel toSimilarSchoolBrowseMapList(FragmentComponent paramFragmentComponent, NextSchoolsCollection paramNextSchoolsCollection)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    Object localObject = paramFragmentComponent.activity().getResources();
    header = paramFragmentComponent.i18NManager().getString(2131231051);
    entityListCardMaxRows = ((Resources)localObject).getInteger(2131558420);
    paramNextSchoolsCollection = items;
    int j = paramNextSchoolsCollection.size();
    trackingUrns = new ArrayList();
    int i = 0;
    while ((i < j) && (i < entityListCardMaxRows))
    {
      localObject = (NextSchool)paramNextSchoolsCollection.get(i);
      List localList = items;
      EntityItemViewModel localEntityItemViewModel = new EntityItemViewModel();
      MiniSchool localMiniSchool = miniSchool;
      image = new ImageModel(logo, GhostImageUtils.getSchool(2131492963, localMiniSchool), Util.retrieveRumSessionId(paramFragmentComponent));
      title = schoolName;
      subtitle = location;
      onRowClick = new SchoolItemsTransformer.1(paramFragmentComponent.tracker(), "school_link", localMiniSchool, paramFragmentComponent);
      localList.add(localEntityItemViewModel);
      EntityUtils.addObjectUrnIfNonNull(trackingUrns, miniSchool.objectUrn);
      i += 1;
    }
    isBrowseMap = true;
    return localEntityListCardViewModel;
  }
  
  public static EntityListCardViewModel toStudentsAndAlumniCard(FragmentComponent paramFragmentComponent, SchoolDataProvider paramSchoolDataProvider, String paramString, MiniProfilesCollection paramMiniProfilesCollection)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    List localList1 = items;
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    Resources localResources = paramFragmentComponent.activity().getResources();
    List localList2 = items;
    int j = localList2.size();
    if (pagingInfo.hasTotal) {}
    for (int i = pagingInfo.total;; i = j)
    {
      header = localI18NManager.getString(2131231028, new Object[] { Integer.valueOf(i), paramString });
      entityListCardMaxRows = localResources.getInteger(2131558432);
      trackingUrns = new ArrayList();
      i = 0;
      while ((i < j) && (i < entityListCardMaxRows))
      {
        paramString = (EntitiesMiniProfile)localList2.get(i);
        localList1.add(EntityTransformer.toPersonItem(paramFragmentComponent, miniProfile, false, null));
        EntityUtils.addObjectUrnIfNonNull(trackingUrns, miniProfile.objectUrn);
        i += 1;
      }
    }
    if (j > entityListCardMaxRows)
    {
      viewAllText = localI18NManager.getString(2131231000);
      viewAllClosure = EntityTransformer.createViewAllClosure(paramFragmentComponent, SchoolViewAllFragment.newInstance(SchoolViewAllBundleBuilder.create(1)), "see_all");
      if (state).nonFirstDegreeHelper != null) {}
    }
    try
    {
      paramFragmentComponent = EntityUtils.createDefaultCollection(items, pagingInfo);
      state).nonFirstDegreeHelper = new CollectionTemplateHelper(activityComponent.dataManager(), null, paramFragmentComponent, EntitiesMiniProfile.BUILDER, CollectionMetadata.BUILDER);
      return localEntityListCardViewModel;
    }
    catch (BuilderException paramFragmentComponent)
    {
      activityComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException(paramFragmentComponent));
    }
    return localEntityListCardViewModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.transformers.SchoolCardsTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */