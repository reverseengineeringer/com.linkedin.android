package com.linkedin.android.entities.school.controllers;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.EntityViewAllListBaseFragment;
import com.linkedin.android.entities.EntityViewAllListBaseFragment.DataLoadListener;
import com.linkedin.android.entities.school.SchoolDataProvider;
import com.linkedin.android.entities.school.SchoolDataProvider.SchoolState;
import com.linkedin.android.entities.school.SchoolViewAllBundleBuilder;
import com.linkedin.android.entities.school.transformers.SchoolViewAllTransformer;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.Collection;
import java.util.List;

public final class SchoolViewAllFragment
  extends EntityViewAllListBaseFragment
{
  private ActivityComponent activityComponent;
  
  public static SchoolViewAllFragment newInstance(SchoolViewAllBundleBuilder paramSchoolViewAllBundleBuilder)
  {
    SchoolViewAllFragment localSchoolViewAllFragment = new SchoolViewAllFragment();
    localSchoolViewAllFragment.setArguments(paramSchoolViewAllBundleBuilder.build());
    return localSchoolViewAllFragment;
  }
  
  protected final EntityViewAllListBaseFragment.DataLoadListener getDataLoadListener()
  {
    final TrackingObject localTrackingObject = activityComponent.schoolDataProvider().state).schoolTrackingObject;
    switch (getArguments().getInt("pageType"))
    {
    default: 
      return null;
    case 0: 
      new EntityViewAllListBaseFragment.DataLoadListener(localTrackingObject)
      {
        protected final List<ViewModel> transformModels(CollectionTemplate<EntitiesMiniProfile, CollectionMetadata> paramAnonymousCollectionTemplate)
        {
          return SchoolViewAllTransformer.toFirstDegreeStudentsAndAlumniViewAllList(fragmentComponent, activityComponent, paramAnonymousCollectionTemplate, localTrackingObject);
        }
      };
    }
    new EntityViewAllListBaseFragment.DataLoadListener(localTrackingObject)
    {
      protected final List<ViewModel> transformModels(CollectionTemplate<EntitiesMiniProfile, CollectionMetadata> paramAnonymousCollectionTemplate)
      {
        return SchoolViewAllTransformer.toStudentsAndAlumniViewAllList(fragmentComponent, paramAnonymousCollectionTemplate, localTrackingObject);
      }
    };
  }
  
  protected final TrackingClosure<Void, Void> getOnErrorButtonClickClosure()
  {
    return null;
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    activityComponent = getActivityactivityComponent;
    shouldTrackImpressions = EntityUtils.isLixEnabled(fragmentComponent.lixManager(), Lix.ENTITIES_SEE_ALL_ITEM_IMPRESSION_TRACKING);
    super.onActivityCreated(paramBundle);
  }
  
  public final String pageKey()
  {
    int i = getArguments().getInt("pageType");
    switch (i)
    {
    default: 
      Util.safeThrow(new RuntimeException("Unable to determine page key for view all page type " + i));
      return "";
    case 0: 
      return "school_connections";
    case 1: 
      return "school_alumni";
    }
    return "school_alumni";
  }
  
  protected final List<ViewModel> setupInitialRows()
  {
    Object localObject2 = null;
    SchoolDataProvider localSchoolDataProvider = activityComponent.schoolDataProvider();
    TrackingObject localTrackingObject = state).schoolTrackingObject;
    int i = getArguments().getInt("pageType");
    Object localObject4 = null;
    Object localObject1 = null;
    Object localObject3 = null;
    switch (i)
    {
    default: 
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("SchoolViewAllFragment does not support this page type: " + i));
      localObject2 = localObject4;
      if (CollectionUtils.isEmpty((Collection)localObject2)) {
        showErrorPage();
      }
      break;
    }
    while ((localObject1 == null) || (localObject3 == null))
    {
      return (List<ViewModel>)localObject2;
      toolbar.setTitle(getLocalizedString(2131231053));
      localObject3 = (SchoolDataProvider.SchoolState)state;
      localObject1 = localObject2;
      if (firstDegreeHelper != null) {
        localObject1 = firstDegreeHelper.getCollectionTemplate();
      }
      localObject2 = SchoolViewAllTransformer.toFirstDegreeStudentsAndAlumniViewAllList(fragmentComponent, activityComponent, (CollectionTemplate)localObject1, localTrackingObject);
      localObject1 = state).firstDegreeHelper;
      localObject3 = state).firstDegreeStudentsAndAlumniRoute;
      break;
      localObject1 = (SchoolDataProvider.SchoolState)state;
      if (nonFirstDegreeHelper != null) {}
      for (localObject1 = nonFirstDegreeHelper.getCollectionTemplate();; localObject1 = null)
      {
        toolbar.setTitle(getLocalizedString(2131231029));
        localObject2 = SchoolViewAllTransformer.toStudentsAndAlumniViewAllList(fragmentComponent, (CollectionTemplate)localObject1, localTrackingObject);
        localObject1 = state).nonFirstDegreeHelper;
        localObject3 = state).nonFirstDegreeStudentsAndAlumniRoute;
        break;
      }
    }
    setupLoadMoreScrollListener((CollectionTemplateHelper)localObject1, (String)localObject3);
    return (List<ViewModel>)localObject2;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.controllers.SchoolViewAllFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */