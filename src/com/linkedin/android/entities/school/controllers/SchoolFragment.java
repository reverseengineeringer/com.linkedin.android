package com.linkedin.android.entities.school.controllers;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.entities.EntityCoordinatorBaseFragment;
import com.linkedin.android.entities.school.SchoolBundleBuilder;
import com.linkedin.android.entities.school.SchoolDataProvider;
import com.linkedin.android.entities.school.SchoolDataProvider.SchoolState;
import com.linkedin.android.entities.school.SchoolPagerAdapterV2;
import com.linkedin.android.entities.school.transformers.SchoolTransformer;
import com.linkedin.android.entities.shared.events.DataUpdatedEvent;
import com.linkedin.android.entities.viewholders.EntityTopCardViewHolder;
import com.linkedin.android.entities.viewmodels.EntityTopCardViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.school.BasicSchoolInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.school.School;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolViewEvent.Builder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.greenrobot.eventbus.Subscribe;

public final class SchoolFragment
  extends EntityCoordinatorBaseFragment
{
  private ActivityComponent activityComponent;
  private SchoolDataProvider schoolDataProvider;
  private String schoolId;
  private EntityTopCardViewHolder topCardViewHolder;
  private EntityTopCardViewModel topCardViewModel;
  
  public static SchoolFragment newInstance(SchoolBundleBuilder paramSchoolBundleBuilder)
  {
    SchoolFragment localSchoolFragment = new SchoolFragment();
    localSchoolFragment.setArguments(paramSchoolBundleBuilder.build());
    return localSchoolFragment;
  }
  
  private void refreshTopCardButtonAndText()
  {
    if ((((SchoolDataProvider.SchoolState)schoolDataProvider.state).school() == null) || (topCardViewHolder == null) || (topCardViewModel == null)) {
      return;
    }
    EntityTopCardViewModel localEntityTopCardViewModel = SchoolTransformer.toTopCard(fragmentComponent, schoolDataProvider, ((SchoolDataProvider.SchoolState)schoolDataProvider.state).school());
    Object localObject = topCardViewModel;
    if ((!TextUtils.equals(title, title)) || (!TextUtils.equals(title, subtitle2))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localEntityTopCardViewModel.bindText(topCardViewHolder);
      }
      if (topCardViewModel.isPrimaryButtonClicked != isPrimaryButtonClicked)
      {
        localObject = topCardViewHolder;
        EntityTopCardViewModel.toggleButtonClicked(ctaButton, ctaClickedButton, isPrimaryButtonClicked);
      }
      topCardViewModel = localEntityTopCardViewModel;
      return;
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    fragmentComponent.eventBus();
    Bus.subscribe(this);
    SchoolDataProvider.SchoolState localSchoolState = (SchoolDataProvider.SchoolState)schoolDataProvider.state;
    if (schoolUpdated)
    {
      refreshTopCardButtonAndText();
      schoolUpdated = false;
    }
  }
  
  protected final TrackingClosure<Void, Void> getOnErrorButtonClickClosure()
  {
    new TrackingClosure(tracker, "try_again") {};
  }
  
  public final ViewHolderCreator<EntityTopCardViewHolder> getViewHolderCreator()
  {
    return EntityTopCardViewHolder.CREATOR;
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    String str = schoolDataProvider.state).schoolRoute;
    if ((paramSet != null) && (str != null) && (paramSet.contains(str))) {
      super.onDataError(paramType, paramSet, paramDataManagerException);
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    Object localObject1 = schoolDataProvider.state).schoolRoute;
    if ((paramSet != null) && (localObject1 != null) && (paramSet.contains(localObject1)))
    {
      localObject1 = ((SchoolDataProvider.SchoolState)schoolDataProvider.state).school();
      if (localObject1 == null) {
        showErrorPage();
      }
    }
    else
    {
      return;
    }
    topCardViewModel = SchoolTransformer.toTopCard(fragmentComponent, schoolDataProvider, (School)localObject1);
    Object localObject2 = topCardViewModel;
    activityComponent.activity().getLayoutInflater();
    ((EntityTopCardViewModel)localObject2).onBindViewHolder$2e9a8560(applicationComponent.mediaCenter(), topCardViewHolder);
    setTitle(basicSchoolInfo.miniSchool.schoolName);
    FlagshipSchoolViewEvent.Builder localBuilder;
    if (DataStore.Type.NETWORK.equals(paramType))
    {
      localObject1 = ((SchoolDataProvider.SchoolState)schoolDataProvider.state).initSchoolTrackingObjectFromNetwork();
      if (localObject1 != null)
      {
        localObject2 = fragmentComponent.tracker();
        localBuilder = new FlagshipSchoolViewEvent.Builder();
        if (localObject1 != null) {
          break label234;
        }
        hasSchool = false;
      }
    }
    for (school = null;; school = ((TrackingObject)localObject1))
    {
      ((Tracker)localObject2).send(localBuilder);
      setupTabs(new SchoolPagerAdapterV2(fragmentComponent, getChildFragmentManager(), schoolDataProvider));
      super.onDataReady(paramType, paramSet, paramMap);
      return;
      label234:
      hasSchool = true;
    }
  }
  
  @Subscribe
  public final void onEvent(DataUpdatedEvent paramDataUpdatedEvent)
  {
    if ((busSubscriberId.equals(subscriberId)) && (((DataTemplate)((SchoolDataProvider.SchoolState)schoolDataProvider.state).getModel(modelKey) instanceof School)) && (isAdded())) {
      refreshTopCardButtonAndText();
    }
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    activityComponent = getActivityactivityComponent;
    schoolDataProvider = activityComponent.schoolDataProvider();
    schoolId = getArguments().getString("schoolId");
    topCardViewHolder = ((EntityTopCardViewHolder)EntityTopCardViewHolder.CREATOR.createViewHolder(topCard));
    if (((SchoolDataProvider.SchoolState)schoolDataProvider.state).school() != null) {}
    for (int i = 1; i != 0; i = 0)
    {
      onDataReady(DataStore.Type.LOCAL, Collections.singleton(schoolDataProvider.state).schoolRoute), null);
      return;
    }
    loadingSpinner.setVisibility(0);
    schoolDataProvider.fetchSchool(busSubscriberId, getRumSessionId(), schoolId, Tracker.createPageInstanceHeader(getPageInstance()));
  }
  
  public final String pageKey()
  {
    return "school";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.controllers.SchoolFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */