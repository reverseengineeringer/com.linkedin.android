package com.linkedin.android.entities.school.controllers;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.linkedin.android.entities.EntityBaseTabFragment;
import com.linkedin.android.entities.EntityPagerAdapter.TabType;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.school.SchoolDataProvider;
import com.linkedin.android.entities.school.SchoolDataProvider.SchoolState;
import com.linkedin.android.entities.school.SchoolTabBundleBuilder;
import com.linkedin.android.entities.school.transformers.SchoolTransformer;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Section;
import com.linkedin.android.pegasus.gen.voyager.entities.school.BasicSchoolInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.school.School;
import com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolSections;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import java.util.Collection;
import java.util.List;

public final class SchoolTabFragment
  extends EntityBaseTabFragment
{
  public static SchoolTabFragment newInstance(SchoolTabBundleBuilder paramSchoolTabBundleBuilder)
  {
    SchoolTabFragment localSchoolTabFragment = new SchoolTabFragment();
    localSchoolTabFragment.setArguments(paramSchoolTabBundleBuilder.build());
    return localSchoolTabFragment;
  }
  
  protected final DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.schoolDataProvider();
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    FragmentComponent localFragmentComponent = null;
    Object localObject1 = null;
    super.onActivityCreated(paramBundle);
    if ((BaseActivity)getActivity() == null) {}
    SchoolDataProvider localSchoolDataProvider;
    School localSchool;
    do
    {
      return;
      localSchoolDataProvider = getActivityactivityComponent.schoolDataProvider();
      if (state).schoolTrackingObject != null) {}
      for (boolean bool = true;; bool = false)
      {
        isLoadedFromNetwork = bool;
        localObject2 = SchoolTabBundleBuilder.getTabType(getArguments());
        getArguments().getBoolean("degradedHighlights", false);
        localSchool = ((SchoolDataProvider.SchoolState)state).school();
        if (localSchool != null) {
          break;
        }
        Log.e(TAG, "School data model should not be null!");
        return;
      }
      paramBundle = null;
      switch (localObject2)
      {
      default: 
        Util.safeThrow(new RuntimeException("SchoolTabFragment does not support this tab type: " + localObject2));
        paramBundle = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), paramBundle);
        recyclerView.setAdapter(paramBundle);
      }
    } while (!isLoadedFromNetwork);
    initImpressionTracking(paramBundle);
    return;
    localObject1 = fragmentComponent;
    paramBundle = ((SchoolDataProvider.SchoolState)state).school();
    if ((paramBundle == null) || (sections == null) || (sections.highlights == null)) {}
    for (paramBundle = null;; paramBundle = sections.highlights.items)
    {
      paramBundle = SchoolTransformer.toCardViewModels((FragmentComponent)localObject1, localSchoolDataProvider, paramBundle);
      break;
    }
    localFragmentComponent = fragmentComponent;
    Object localObject2 = ((SchoolDataProvider.SchoolState)state).school();
    paramBundle = (Bundle)localObject1;
    if (localObject2 != null)
    {
      paramBundle = (Bundle)localObject1;
      if (sections != null) {
        if (sections.details != null) {
          break label405;
        }
      }
    }
    label405:
    for (paramBundle = (Bundle)localObject1;; paramBundle = sections.details.items)
    {
      localObject1 = SchoolTransformer.toCardViewModels(localFragmentComponent, localSchoolDataProvider, paramBundle);
      paramBundle = (Bundle)localObject1;
      if (!CollectionUtils.isEmpty((Collection)localObject1)) {
        break;
      }
      paramBundle = fragmentComponent.i18NManager().getString(2131231025, new Object[] { basicSchoolInfo.miniSchool.schoolName });
      ((List)localObject1).add(EntityTransformer.noCardsEmptyState(fragmentComponent, paramBundle, 2130838585));
      paramBundle = (Bundle)localObject1;
      break;
    }
    localObject1 = fragmentComponent;
    localObject2 = ((SchoolDataProvider.SchoolState)state).school();
    paramBundle = localFragmentComponent;
    if (localObject2 != null)
    {
      paramBundle = localFragmentComponent;
      if (sections != null) {
        if (sections.people != null) {
          break label543;
        }
      }
    }
    label543:
    for (paramBundle = localFragmentComponent;; paramBundle = sections.people.items)
    {
      localObject1 = SchoolTransformer.toCardViewModels((FragmentComponent)localObject1, localSchoolDataProvider, paramBundle);
      paramBundle = (Bundle)localObject1;
      if (!CollectionUtils.isEmpty((Collection)localObject1)) {
        break;
      }
      paramBundle = fragmentComponent.i18NManager().getString(2131231026, new Object[] { basicSchoolInfo.miniSchool.schoolName });
      ((List)localObject1).add(EntityTransformer.noCardsEmptyState(fragmentComponent, paramBundle, 2130838477));
      paramBundle = (Bundle)localObject1;
      break;
    }
  }
  
  public final String pageKey()
  {
    EntityPagerAdapter.TabType localTabType = SchoolTabBundleBuilder.getTabType(getArguments());
    switch (localTabType)
    {
    default: 
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Unable to determine page key for tab type " + localTabType));
      return "";
    case ???: 
      return "school_highlights";
    case ???: 
      return "school_details";
    }
    return "school_people";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.controllers.SchoolTabFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */