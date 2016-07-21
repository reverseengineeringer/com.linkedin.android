package com.linkedin.android.identity.profile.view.accomplishments.detail;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.identity.edit.ProfileEditUtils;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.profile.ProfileViewListenerImpl;
import com.linkedin.android.identity.profile.view.ProfileViewListener;
import com.linkedin.android.identity.profile.view.accomplishments.AccomplishmentType;
import com.linkedin.android.identity.shared.ProfileViewUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.DateUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.lightbox.LightboxLayout;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Certification;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Course;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Honor;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Project;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Publication;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.TestScore;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProfileAccomplishmentsFragment
  extends PageFragment
{
  private ViewModelArrayAdapter<ViewModel> adapter;
  private AccomplishmentType cardType;
  private boolean isSelf;
  @InjectView(2131757301)
  LightboxLayout lightboxLayout;
  private ProfileDataProvider profileDataProvider;
  private String profileId;
  private ProfileViewListener profileViewListener;
  @InjectView(2131757302)
  RecyclerView recyclerView;
  @InjectView(2131755468)
  Toolbar toolbar;
  
  public static ProfileAccomplishmentsFragment newInstance(ProfileAccomplishmentsBundleBuilder paramProfileAccomplishmentsBundleBuilder)
  {
    ProfileAccomplishmentsFragment localProfileAccomplishmentsFragment = new ProfileAccomplishmentsFragment();
    localProfileAccomplishmentsFragment.setArguments(paramProfileAccomplishmentsBundleBuilder.build());
    return localProfileAccomplishmentsFragment;
  }
  
  private void setToolbarTitle(int paramInt)
  {
    toolbar.setTitle(paramInt);
  }
  
  private void transformAndSetCourseViewModels(AccomplishmentDetailHeaderViewModel paramAccomplishmentDetailHeaderViewModel)
  {
    Object localObject = profileDataProvider;
    ArrayList localArrayList;
    label71:
    FragmentComponent localFragmentComponent;
    ProfileViewListener localProfileViewListener;
    AccomplishmentCourseCardViewModel localAccomplishmentCourseCardViewModel;
    if (profileViewApiEnabled)
    {
      localObject = (ProfileState)state;
      localObject = (CollectionTemplate)((ProfileState)localObject).getModel(allCoursesRoute);
      if (!CollectionUtils.isNonEmpty((CollectionTemplate)localObject)) {
        break label247;
      }
      localArrayList = new ArrayList();
      if (paramAccomplishmentDetailHeaderViewModel != null) {
        localArrayList.add(paramAccomplishmentDetailHeaderViewModel);
      }
      paramAccomplishmentDetailHeaderViewModel = elements.iterator();
      if (!paramAccomplishmentDetailHeaderViewModel.hasNext()) {
        break label237;
      }
      localObject = (Course)paramAccomplishmentDetailHeaderViewModel.next();
      localFragmentComponent = fragmentComponent;
      bool = isSelf;
      localProfileViewListener = profileViewListener;
      localAccomplishmentCourseCardViewModel = new AccomplishmentCourseCardViewModel();
      name = name;
      number = number;
      LixManager localLixManager = localFragmentComponent.lixManager();
      if ((!bool) || ("control".equals(localLixManager.getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_COURSES)))) {
        break label232;
      }
    }
    label232:
    for (boolean bool = true;; bool = false)
    {
      showEditButton = bool;
      if (showEditButton) {
        editButtonOnClickListener = new AccomplishmentsDetailTransformer.6(localFragmentComponent.tracker(), "edit_course", new TrackingEventBuilder[0], localProfileViewListener, (Course)localObject, localFragmentComponent);
      }
      localArrayList.add(localAccomplishmentCourseCardViewModel);
      break label71;
      localObject = ((ProfileDataProvider)localObject).getCourses();
      break;
    }
    label237:
    adapter.setValues(localArrayList);
    return;
    label247:
    getFragmentManager().popBackStack();
  }
  
  private void transformAndSetHonorViewModels(AccomplishmentDetailHeaderViewModel paramAccomplishmentDetailHeaderViewModel)
  {
    Object localObject = profileDataProvider;
    ArrayList localArrayList;
    label71:
    FragmentComponent localFragmentComponent;
    I18NManager localI18NManager;
    ProfileViewListener localProfileViewListener;
    AccomplishmentHonorCardViewModel localAccomplishmentHonorCardViewModel;
    if (profileViewApiEnabled)
    {
      localObject = (ProfileState)state;
      localObject = (CollectionTemplate)((ProfileState)localObject).getModel(allHonorsRoute);
      if (!CollectionUtils.isNonEmpty((CollectionTemplate)localObject)) {
        break label303;
      }
      localArrayList = new ArrayList();
      if (paramAccomplishmentDetailHeaderViewModel != null) {
        localArrayList.add(paramAccomplishmentDetailHeaderViewModel);
      }
      paramAccomplishmentDetailHeaderViewModel = elements.iterator();
      if (!paramAccomplishmentDetailHeaderViewModel.hasNext()) {
        break label293;
      }
      localObject = (Honor)paramAccomplishmentDetailHeaderViewModel.next();
      localFragmentComponent = fragmentComponent;
      localI18NManager = fragmentComponent.i18NManager();
      bool = isSelf;
      localProfileViewListener = profileViewListener;
      localAccomplishmentHonorCardViewModel = new AccomplishmentHonorCardViewModel();
      LixManager localLixManager = localFragmentComponent.lixManager();
      if ((!bool) || ("control".equals(localLixManager.getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_HONORS)))) {
        break label288;
      }
    }
    label288:
    for (boolean bool = true;; bool = false)
    {
      showEditButton = bool;
      if (showEditButton) {
        editButtonOnClickListener = new AccomplishmentsDetailTransformer.7(localFragmentComponent.tracker(), "edit_honor", new TrackingEventBuilder[0], localProfileViewListener, (Honor)localObject, localFragmentComponent);
      }
      title = title;
      description = description;
      if (hasIssueDate) {
        issueDate = localI18NManager.getString(2131232288, new Object[] { Long.valueOf(DateUtils.getTimeStampInMillis(issueDate)) });
      }
      issuer = issuer;
      localArrayList.add(localAccomplishmentHonorCardViewModel);
      break label71;
      localObject = ((ProfileDataProvider)localObject).getHonors();
      break;
    }
    label293:
    adapter.setValues(localArrayList);
    return;
    label303:
    getFragmentManager().popBackStack();
  }
  
  private void transformAndSetPatentViewModels(AccomplishmentDetailHeaderViewModel paramAccomplishmentDetailHeaderViewModel)
  {
    Object localObject = profileDataProvider;
    if (profileViewApiEnabled)
    {
      localObject = (ProfileState)state;
      localObject = (CollectionTemplate)((ProfileState)localObject).getModel(allPatentsRoute);
    }
    while (CollectionUtils.isNonEmpty((CollectionTemplate)localObject))
    {
      ArrayList localArrayList = new ArrayList();
      if (paramAccomplishmentDetailHeaderViewModel != null) {
        localArrayList.add(paramAccomplishmentDetailHeaderViewModel);
      }
      paramAccomplishmentDetailHeaderViewModel = elements.iterator();
      for (;;)
      {
        if (paramAccomplishmentDetailHeaderViewModel.hasNext())
        {
          localObject = (Patent)paramAccomplishmentDetailHeaderViewModel.next();
          localArrayList.add(AccomplishmentsDetailTransformer.toPatentCard(fragmentComponent, (Patent)localObject, isSelf, profileViewListener));
          continue;
          localObject = ((ProfileDataProvider)localObject).getPatents();
          break;
        }
      }
      adapter.setValues(localArrayList);
      return;
    }
    getFragmentManager().popBackStack();
  }
  
  private void transformAndSetProjectViewModels(AccomplishmentDetailHeaderViewModel paramAccomplishmentDetailHeaderViewModel)
  {
    Object localObject = profileDataProvider;
    if (profileViewApiEnabled)
    {
      localObject = (ProfileState)state;
      localObject = (CollectionTemplate)((ProfileState)localObject).getModel(allProjectsRoute);
    }
    while (CollectionUtils.isNonEmpty((CollectionTemplate)localObject))
    {
      ArrayList localArrayList = new ArrayList();
      if (paramAccomplishmentDetailHeaderViewModel != null) {
        localArrayList.add(paramAccomplishmentDetailHeaderViewModel);
      }
      paramAccomplishmentDetailHeaderViewModel = elements.iterator();
      for (;;)
      {
        if (paramAccomplishmentDetailHeaderViewModel.hasNext())
        {
          localObject = (Project)paramAccomplishmentDetailHeaderViewModel.next();
          localArrayList.add(AccomplishmentsDetailTransformer.toProjectCard(fragmentComponent, (Project)localObject, isSelf, profileViewListener));
          continue;
          localObject = ((ProfileDataProvider)localObject).getProjects();
          break;
        }
      }
      adapter.setValues(localArrayList);
      return;
    }
    getFragmentManager().popBackStack();
  }
  
  private void transformAndSetPublicationViewModels(AccomplishmentDetailHeaderViewModel paramAccomplishmentDetailHeaderViewModel)
  {
    Object localObject = profileDataProvider;
    if (profileViewApiEnabled)
    {
      localObject = (ProfileState)state;
      localObject = (CollectionTemplate)((ProfileState)localObject).getModel(allPublicationsRoute);
    }
    while (CollectionUtils.isNonEmpty((CollectionTemplate)localObject))
    {
      ArrayList localArrayList = new ArrayList();
      if (paramAccomplishmentDetailHeaderViewModel != null) {
        localArrayList.add(paramAccomplishmentDetailHeaderViewModel);
      }
      paramAccomplishmentDetailHeaderViewModel = elements.iterator();
      for (;;)
      {
        if (paramAccomplishmentDetailHeaderViewModel.hasNext())
        {
          localObject = (Publication)paramAccomplishmentDetailHeaderViewModel.next();
          localArrayList.add(AccomplishmentsDetailTransformer.toPublicationCard(fragmentComponent, (Publication)localObject, isSelf, profileViewListener));
          continue;
          localObject = ((ProfileDataProvider)localObject).getPublications();
          break;
        }
      }
      adapter.setValues(localArrayList);
      return;
    }
    getFragmentManager().popBackStack();
  }
  
  private void transformAndSetTestScoreViewModels(AccomplishmentDetailHeaderViewModel paramAccomplishmentDetailHeaderViewModel)
  {
    Object localObject = profileDataProvider;
    if (profileViewApiEnabled)
    {
      localObject = (ProfileState)state;
      localObject = (CollectionTemplate)((ProfileState)localObject).getModel(allTestScoresRoute);
    }
    while (CollectionUtils.isNonEmpty((CollectionTemplate)localObject))
    {
      ArrayList localArrayList = new ArrayList();
      if (paramAccomplishmentDetailHeaderViewModel != null) {
        localArrayList.add(paramAccomplishmentDetailHeaderViewModel);
      }
      paramAccomplishmentDetailHeaderViewModel = elements.iterator();
      for (;;)
      {
        if (paramAccomplishmentDetailHeaderViewModel.hasNext())
        {
          localObject = (TestScore)paramAccomplishmentDetailHeaderViewModel.next();
          I18NManager localI18NManager = fragmentComponent.i18NManager();
          AccomplishmentTestScoreCardViewModel localAccomplishmentTestScoreCardViewModel = new AccomplishmentTestScoreCardViewModel();
          name = name;
          description = description;
          if (hasScore) {
            score = localI18NManager.getString(2131232223, new Object[] { score });
          }
          if (hasDate) {
            date = localI18NManager.getString(2131232288, new Object[] { Long.valueOf(DateUtils.getTimeStampInMillis(date)) });
          }
          localArrayList.add(localAccomplishmentTestScoreCardViewModel);
          continue;
          localObject = ((ProfileDataProvider)localObject).getTestScores();
          break;
        }
      }
      adapter.setValues(localArrayList);
      return;
    }
    getFragmentManager().popBackStack();
  }
  
  private void transformAndSetViewModels()
  {
    if (isSelf)
    {
      localObject1 = null;
      switch (ProfileAccomplishmentsFragment.2.$SwitchMap$com$linkedin$android$identity$profile$view$accomplishments$AccomplishmentType[cardType.ordinal()])
      {
      default: 
        label60:
        if (localObject1 != null)
        {
          localObject2 = new AccomplishmentDetailHeaderViewModel();
          addButtonOnClickListener = ((TrackingOnClickListener)localObject1);
        }
        break;
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null) {
      switch (ProfileAccomplishmentsFragment.2.$SwitchMap$com$linkedin$android$identity$profile$view$accomplishments$AccomplishmentType[cardType.ordinal()])
      {
      default: 
        return;
        localObject1 = ProfileEditUtils.getAddCertificationClickListener(fragmentComponent, profileViewListener);
        break label60;
        localObject1 = ProfileEditUtils.getAddCourseClickListener(fragmentComponent, profileViewListener);
        break label60;
        localObject1 = ProfileEditUtils.getAddPatentClickListener(fragmentComponent, profileViewListener);
        break label60;
        localObject1 = ProfileEditUtils.getAddProjectClickListener(fragmentComponent, profileViewListener);
        break label60;
        localObject1 = ProfileEditUtils.getAddPublicationClickListener(fragmentComponent, profileViewListener);
        break label60;
        localObject1 = ProfileEditUtils.getAddHonorClickListener(fragmentComponent, profileViewListener);
        break label60;
      }
    }
    setToolbarTitle(2131232198);
    Object localObject2 = profileDataProvider;
    ArrayList localArrayList;
    label333:
    Certification localCertification;
    FragmentComponent localFragmentComponent;
    boolean bool;
    AccomplishmentCertificationCardViewModel localAccomplishmentCertificationCardViewModel;
    String str;
    label438:
    long l1;
    long l2;
    if (profileViewApiEnabled)
    {
      localObject2 = (ProfileState)state;
      localObject2 = (CollectionTemplate)((ProfileState)localObject2).getModel(allCertificationsRoute);
      if (!CollectionUtils.isNonEmpty((CollectionTemplate)localObject2)) {
        break label705;
      }
      localArrayList = new ArrayList();
      if (localObject1 != null) {
        localArrayList.add(localObject1);
      }
      localObject2 = elements.iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label695;
      }
      localCertification = (Certification)((Iterator)localObject2).next();
      localFragmentComponent = fragmentComponent;
      bool = isSelf;
      localObject1 = profileViewListener;
      localAccomplishmentCertificationCardViewModel = new AccomplishmentCertificationCardViewModel();
      str = name;
      title = str;
      licence = licenseNumber;
      LixManager localLixManager = localFragmentComponent.lixManager();
      if ((!bool) || ("control".equals(localLixManager.getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_CERTIFICATIONS)))) {
        break label653;
      }
      bool = true;
      showEditButton = bool;
      if (showEditButton) {
        editButtonOnClickListener = new AccomplishmentsDetailTransformer.4(localFragmentComponent.tracker(), "edit_certification", new TrackingEventBuilder[0], (ProfileViewListener)localObject1, localCertification, localFragmentComponent);
      }
      if (hasTimePeriod)
      {
        localObject1 = timePeriod;
        if (!hasEndDate) {
          break label658;
        }
        l1 = DateUtils.getTimeStampInMillis(startDate);
        l2 = DateUtils.getTimeStampInMillis(endDate);
      }
    }
    for (localObject1 = localFragmentComponent.i18NManager().getString(2131232289, new Object[] { Long.valueOf(l1), Long.valueOf(l2) });; localObject1 = localFragmentComponent.i18NManager().getString(2131232288, new Object[] { Long.valueOf(l1) }))
    {
      period = ((String)localObject1);
      company = authority;
      if (hasUrl)
      {
        hasLink = true;
        localObject1 = url;
        clickListener = new AccomplishmentsDetailTransformer.5(localFragmentComponent.tracker(), "web_viewer", new TrackingEventBuilder[0], (String)localObject1, str, localFragmentComponent);
      }
      localArrayList.add(localAccomplishmentCertificationCardViewModel);
      break label333;
      localObject2 = ((ProfileDataProvider)localObject2).getCertifications();
      break;
      label653:
      bool = false;
      break label438;
      label658:
      l1 = DateUtils.getTimeStampInMillis(startDate);
    }
    label695:
    adapter.setValues(localArrayList);
    return;
    label705:
    getFragmentManager().popBackStack();
    return;
    setToolbarTitle(2131232201);
    transformAndSetCourseViewModels((AccomplishmentDetailHeaderViewModel)localObject1);
    return;
    setToolbarTitle(2131232203);
    transformAndSetHonorViewModels((AccomplishmentDetailHeaderViewModel)localObject1);
    return;
    setToolbarTitle(2131232212);
    transformAndSetPatentViewModels((AccomplishmentDetailHeaderViewModel)localObject1);
    return;
    setToolbarTitle(2131232217);
    transformAndSetProjectViewModels((AccomplishmentDetailHeaderViewModel)localObject1);
    return;
    setToolbarTitle(2131232221);
    transformAndSetPublicationViewModels((AccomplishmentDetailHeaderViewModel)localObject1);
    return;
    setToolbarTitle(2131232224);
    transformAndSetTestScoreViewModels((AccomplishmentDetailHeaderViewModel)localObject1);
  }
  
  public final void doEnter()
  {
    super.doEnter();
    Object localObject = ProfileAccomplishmentsBundleBuilder.getCardType(getArguments());
    switch (ProfileAccomplishmentsFragment.2.$SwitchMap$com$linkedin$android$identity$profile$view$accomplishments$AccomplishmentType[localObject.ordinal()])
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      delayedExecution.postExecution(ProfileViewUtils.getPageViewEventRunnable(tracker, (String)localObject));
      return;
      if (isSelf)
      {
        localObject = "profile_self_view_accomplishment_details_certifications";
      }
      else
      {
        localObject = "profile_view_accomplishment_details_certifications";
        continue;
        if (isSelf)
        {
          localObject = "profile_self_view_accomplishment_details_courses";
        }
        else
        {
          localObject = "profile_view_accomplishment_details_courses";
          continue;
          if (isSelf)
          {
            localObject = "profile_self_view_accomplishment_details_honors";
          }
          else
          {
            localObject = "profile_view_accomplishment_details_honors";
            continue;
            if (isSelf)
            {
              localObject = "profile_self_view_accomplishment_details_patents";
            }
            else
            {
              localObject = "profile_view_accomplishment_details_patents";
              continue;
              if (isSelf)
              {
                localObject = "profile_self_view_accomplishment_details_projects";
              }
              else
              {
                localObject = "profile_view_accomplishment_details_projects";
                continue;
                if (isSelf)
                {
                  localObject = "profile_self_view_accomplishment_details_publications";
                }
                else
                {
                  localObject = "profile_view_accomplishment_details_publications";
                  continue;
                  if (isSelf) {
                    localObject = "profile_self_view_accomplishment_details_test_scores";
                  } else {
                    localObject = "profile_view_accomplishment_details_test_scores";
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof HomeActivity)) {
      profileViewListener = new ProfileViewListenerImpl((HomeActivity)paramActivity);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969165, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    super.onDataError(paramType, paramSet, paramDataManagerException);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    transformAndSetViewModels();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    toolbar.setNavigationOnClickListener(new ProfileAccomplishmentsFragment.1(this));
    Object localObject1 = getArguments();
    boolean bool;
    if (localObject1 != null)
    {
      paramBundle = ((Bundle)localObject1).getString("profileId");
      profileId = paramBundle;
      if ((profileId == null) || (!fragmentComponent.memberUtil().isSelf(profileId))) {
        break label120;
      }
      bool = true;
      label84:
      isSelf = bool;
      if (profileId != null) {
        break label125;
      }
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Fragment cannot be created without a profileId in the bundle"));
    }
    label120:
    label125:
    do
    {
      return;
      paramBundle = null;
      break;
      bool = false;
      break label84;
      cardType = ProfileAccomplishmentsBundleBuilder.getCardType((Bundle)localObject1);
      profileDataProvider = fragmentComponent.activity().activityComponent.profileDataProvider();
      paramView = new LinearLayoutManager(paramView.getContext());
      recyclerView.setLayoutManager(paramView);
      adapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), null);
      recyclerView.setAdapter(adapter);
    } while (profileDataProvider == null);
    if (profileDataProvider.profileViewApiEnabled)
    {
      paramView = profileDataProvider;
      Object localObject2 = profileId;
      paramBundle = cardType;
      localObject1 = getRumSessionId();
      String str = busSubscriberId;
      Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
      state).allCertificationsRoute = ProfileRoutes.buildCertificationsRoute((String)localObject2).toString();
      state).allCoursesRoute = ProfileRoutes.buildCoursesRoute((String)localObject2).toString();
      state).allHonorsRoute = ProfileRoutes.buildHonorsRoute((String)localObject2).toString();
      state).allPatentsRoute = ProfileRoutes.buildPatentsRoute((String)localObject2).toString();
      state).allProjectsRoute = ProfileRoutes.buildProjectsRoute((String)localObject2).toString();
      state).allPublicationsRoute = ProfileRoutes.buildPublicationsRoute((String)localObject2).toString();
      state).allTestScoresRoute = ProfileRoutes.buildTestScoresRoute((String)localObject2).toString();
      localObject2 = MultiplexRequest.Builder.parallel();
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      switch (com.linkedin.android.identity.profile.ProfileDataProvider.8.$SwitchMap$com$linkedin$android$identity$profile$view$accomplishments$AccomplishmentType[paramBundle.ordinal()])
      {
      default: 
        return;
      case 1: 
        ((MultiplexRequest.Builder)localObject2).required(Request.get().url(state).allCertificationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Certification.BUILDER, CollectionMetadata.BUILDER)));
      }
      for (;;)
      {
        paramView.performMultiplexedFetch(str, (String)localObject1, localMap, (MultiplexRequest.Builder)localObject2);
        return;
        ((MultiplexRequest.Builder)localObject2).required(Request.get().url(state).allCoursesRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Course.BUILDER, CollectionMetadata.BUILDER)));
        continue;
        ((MultiplexRequest.Builder)localObject2).required(Request.get().url(state).allHonorsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Honor.BUILDER, CollectionMetadata.BUILDER)));
        continue;
        ((MultiplexRequest.Builder)localObject2).required(Request.get().url(state).allProjectsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Project.BUILDER, CollectionMetadata.BUILDER)));
        continue;
        ((MultiplexRequest.Builder)localObject2).required(Request.get().url(state).allPatentsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Patent.BUILDER, CollectionMetadata.BUILDER)));
        continue;
        ((MultiplexRequest.Builder)localObject2).required(Request.get().url(state).allPublicationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Publication.BUILDER, CollectionMetadata.BUILDER)));
        continue;
        ((MultiplexRequest.Builder)localObject2).required(Request.get().url(state).allTestScoresRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(TestScore.BUILDER, CollectionMetadata.BUILDER)));
      }
    }
    transformAndSetViewModels();
  }
  
  public final String pageKey()
  {
    AccomplishmentType localAccomplishmentType = ProfileAccomplishmentsBundleBuilder.getCardType(getArguments());
    switch (ProfileAccomplishmentsFragment.2.$SwitchMap$com$linkedin$android$identity$profile$view$accomplishments$AccomplishmentType[localAccomplishmentType.ordinal()])
    {
    default: 
      return null;
    case 1: 
      return "profile_view_base_accomplishment_details_certifications";
    case 2: 
      return "profile_view_base_accomplishment_details_courses";
    case 3: 
      return "profile_view_base_accomplishment_details_honors";
    case 4: 
      return "profile_view_base_accomplishment_details_patents";
    case 5: 
      return "profile_view_base_accomplishment_details_projects";
    case 6: 
      return "profile_view_base_accomplishment_details_publications";
    }
    return "profile_view_base_accomplishment_details_test_scores";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.accomplishments.detail.ProfileAccomplishmentsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */