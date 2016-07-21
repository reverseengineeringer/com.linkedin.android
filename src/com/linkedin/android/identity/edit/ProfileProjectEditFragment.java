package com.linkedin.android.identity.edit;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.identity.edit.projects.ProjectTransformer.1;
import com.linkedin.android.identity.edit.projects.ProjectTransformer.2;
import com.linkedin.android.identity.edit.projects.ProjectTransformer.3;
import com.linkedin.android.identity.edit.projects.ProjectTransformer.4;
import com.linkedin.android.identity.edit.projects.ProjectViewHolder;
import com.linkedin.android.identity.edit.projects.ProjectViewModel;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.shared.DateRangePresenter;
import com.linkedin.android.identity.shared.DateRangePresenter.Builder;
import com.linkedin.android.identity.shared.DateRangePresenter.OnDateSetListener;
import com.linkedin.android.identity.shared.OccupationArrayAdapter;
import com.linkedin.android.identity.shared.ProfileTypeahead;
import com.linkedin.android.identity.shared.ProfileTypeaheadResult;
import com.linkedin.android.identity.shared.ProfileUrnUtil;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.identity.shared.SizeLimitWatcher;
import com.linkedin.android.identity.shared.multilistenerwidget.MultiListenerSpinner;
import com.linkedin.android.identity.shared.validators.forms.BaseFormValidator;
import com.linkedin.android.identity.shared.validators.forms.ProjectValidator;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Contributor;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Education;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormContributor.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProject;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProject.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Position;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Project;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.android.tracking.v2.listeners.TrackingOnItemSelectedListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileProjectEditFragment
  extends ProfileEditBaseFragment
  implements ProfileEditBaseFragment.TypeaheadListener
{
  private static final String TAG = ProfileProjectEditFragment.class.getSimpleName();
  @InjectView(2131757517)
  TextView dateErrorTextView;
  private final DateRangePresenter.OnDateSetListener dateSetListener = new ProfileProjectEditFragment.1(this);
  @InjectView(2131757759)
  TextView deleteLink;
  @InjectView(2131757757)
  TextInputLayout descriptionEditLayout;
  private List<Education> educations;
  @InjectView(2131757514)
  TextInputLayout endDateEditLayout;
  @InjectView(2131757748)
  LinearLayout formLayout;
  @InjectView(2131757747)
  ScrollView formScrollView;
  private ArrayList<ProfileEditContributor> modifiedMembers;
  @InjectView(2131757749)
  TextInputLayout nameEditLayout;
  private OccupationArrayAdapter occupationArrayAdapter;
  private NormProject originalProject;
  private List<Position> positions;
  @Inject
  ProfileUtil profileUtil;
  private Project project;
  private DateRangePresenter projectDateRange;
  @InjectView(2131757504)
  MultiListenerSpinner selectOccupationSpinner;
  @InjectView(2131757512)
  TextInputLayout startDateEditLayout;
  @InjectView(2131757755)
  TextInputLayout urlEditLayout;
  private ProjectValidator validator;
  private ProjectViewHolder viewHolder;
  private ProjectViewModel viewModel;
  
  private NormProject getNormFormProject()
    throws BuilderException
  {
    if (project != null)
    {
      localBuilder = new NormProject.Builder(normalizeProject(project));
      populateFields(localBuilder);
      return localBuilder.build(RecordTemplate.Flavor.RECORD);
    }
    NormProject.Builder localBuilder = new NormProject.Builder();
    populateFields(localBuilder);
    return localBuilder.build(RecordTemplate.Flavor.RECORD);
  }
  
  public static ProfileProjectEditFragment newInstance(ProfileProjectEditBundleBuilder paramProfileProjectEditBundleBuilder)
  {
    ProfileProjectEditFragment localProfileProjectEditFragment = new ProfileProjectEditFragment();
    localProfileProjectEditFragment.setArguments(paramProfileProjectEditBundleBuilder.build());
    return localProfileProjectEditFragment;
  }
  
  private NormProject normalizeProject(Project paramProject)
    throws BuilderException
  {
    NormProject.Builder localBuilder = new NormProject.Builder();
    ArrayList localArrayList = new ArrayList(members.size());
    Iterator localIterator = members.iterator();
    while (localIterator.hasNext())
    {
      Contributor localContributor = (Contributor)localIterator.next();
      localArrayList.add(new NormContributor.Builder().setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { entityUrn.getLastId() })).setName(profileUtil.getDisplayNameString(localContributor)).build(RecordTemplate.Flavor.RECORD));
    }
    if (localArrayList.size() > 0) {
      localBuilder.setMembers(localArrayList);
    }
    if (hasOccupation) {
      localBuilder.setOccupation(occupation);
    }
    return localBuilder.setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { entityUrn.getLastId() })).setTitle(title).setTimePeriod(timePeriod).setUrl(url).setDescription(description).setOccupation(occupation).build(RecordTemplate.Flavor.RECORD);
  }
  
  private void populateFields(NormProject.Builder paramBuilder)
    throws BuilderException
  {
    if (project == null) {}
    for (Object localObject = ProfileUtil.getMockUrn();; localObject = project.entityUrn)
    {
      paramBuilder.setEntityUrn((Urn)localObject);
      paramBuilder.setTitle(viewHolder.name.getText().toString());
      localObject = viewHolder.description.getText().toString();
      if (((project == null) && (((String)localObject).length() > 0)) || (project != null)) {
        paramBuilder.setDescription((String)localObject);
      }
      int i = viewHolder.occupationSpinner.getSelectedItemPosition();
      if ((educations != null) && (positions != null) && (i > 0) && (i <= educations.size() + positions.size())) {
        paramBuilder.setOccupation(occupationArrayAdapter.getOccupationUrn(i));
      }
      localObject = viewHolder.url.getText().toString();
      if (((project == null) && (((String)localObject).length() > 0)) || (project != null)) {
        paramBuilder.setUrl((String)localObject);
      }
      if ((viewModel == null) || (viewModel.members == null) || (viewModel.members.size() <= 0)) {
        break label324;
      }
      localObject = new ArrayList();
      Iterator localIterator = viewModel.members.iterator();
      while (localIterator.hasNext())
      {
        ProfileEditContributor localProfileEditContributor = (ProfileEditContributor)localIterator.next();
        ((List)localObject).add(new NormContributor.Builder().setEntityUrn(ProfileEditContributor.asUrn(entityUrn)).setProfileUrn(ProfileEditContributor.asUrn(profileUrn)).setName(name).build(RecordTemplate.Flavor.RECORD));
      }
    }
    paramBuilder.setMembers((List)localObject);
    label324:
    if ((projectDateRange.hasStartDate()) || (projectDateRange.hasEndDate()))
    {
      localObject = new DateRange.Builder();
      if (projectDateRange.hasStartDate()) {
        ((DateRange.Builder)localObject).setStartDate(projectDateRange.getStartDate());
      }
      if ((!projectDateRange.isSingleDate()) && (projectDateRange.hasEndDate())) {
        ((DateRange.Builder)localObject).setEndDate(projectDateRange.getEndDate());
      }
      for (;;)
      {
        if (projectDateRange.isSingleDate()) {
          ((DateRange.Builder)localObject).setEndDate(projectDateRange.getStartDate());
        }
        paramBuilder.setTimePeriod(((DateRange.Builder)localObject).build(RecordTemplate.Flavor.RECORD));
        return;
        if ((project != null) && (project.hasTimePeriod) && (project.timePeriod.hasEndDate)) {
          ((DateRange.Builder)localObject).setEndDate(null);
        }
      }
    }
    paramBuilder.setTimePeriod(null);
  }
  
  private void setFormData(Project paramProject)
    throws BuilderException
  {
    int m = -1;
    Object localObject1 = modifiedMembers;
    Object localObject4 = fragmentComponent;
    I18NManager localI18NManager = i18NManager;
    Object localObject2 = profileUtil;
    Object localObject3 = memberUtil;
    DateRangePresenter localDateRangePresenter = projectDateRange;
    ProjectViewModel localProjectViewModel = new ProjectViewModel();
    fragmentComponent = ((FragmentComponent)localObject4);
    i18NManager = localI18NManager;
    profileUtil = ((ProfileUtil)localObject2);
    onAddMemberClicked = new ProjectTransformer.1(((FragmentComponent)localObject4).tracker(), "add_team_member", new TrackingEventBuilder[0], (FragmentComponent)localObject4, localI18NManager);
    onDateToggleClicked = new TrackingOnClickListener(((FragmentComponent)localObject4).tracker(), "ongoing_toggle", new TrackingEventBuilder[0]);
    onDateTypeSwitched = new TrackingOnClickListener(((FragmentComponent)localObject4).tracker(), "toggle_date_type", new TrackingEventBuilder[0]);
    onUrlTouched = new ProjectTransformer.2((FragmentComponent)localObject4);
    onDescriptionTouched = new ProjectTransformer.3((FragmentComponent)localObject4);
    onNameTouched = new ProjectTransformer.4((FragmentComponent)localObject4);
    onAssociationSelected = new TrackingOnItemSelectedListener(((FragmentComponent)localObject4).tracker(), "project_association", new TrackingEventBuilder[0]);
    boolean bool;
    label363:
    int i;
    label402:
    int j;
    label422:
    int k;
    label453:
    int n;
    if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
      if (paramProject != null)
      {
        entityUrn = entityUrn;
        name = title;
        url = url;
        description = description;
        members = ProfileEditUtils.toContributorViewModel(members, localI18NManager, (FragmentComponent)localObject4);
        if (hasTimePeriod)
        {
          localObject1 = timePeriod;
          startDate = startDate;
          if (!startDate.equals(endDate))
          {
            if (hasEndDate) {
              endDate = endDate;
            }
            if (hasEndDate) {
              break label650;
            }
            bool = true;
            currentProject = bool;
          }
        }
        if ((paramProject == null) || (!hasTimePeriod)) {
          break label807;
        }
        localObject1 = timePeriod;
        if (!startDate.hasMonth) {
          break label802;
        }
        i = startDate.month - 1;
        if (!startDate.hasYear) {
          break label797;
        }
        j = startDate.year;
        if (!hasEndDate) {
          break label787;
        }
        if (!endDate.hasMonth) {
          break label781;
        }
        k = endDate.month - 1;
        if (!endDate.hasYear) {
          break label759;
        }
        n = endDate.year;
        m = k;
        k = j;
        j = i;
        i = n;
      }
    }
    for (;;)
    {
      initialStartYear = Integer.valueOf(k);
      initialStartMonth = Integer.valueOf(j);
      initialEndYear = Integer.valueOf(i);
      initialEndMonth = Integer.valueOf(m);
      viewModel = localProjectViewModel;
      viewModel.onContributorsChangedListener = new ProfileProjectEditFragment.2(this);
      if (paramProject != null) {
        viewModel.onDeleteProjectClicked = new ProfileProjectEditFragment.3(this, tracker, "delete", new TrackingEventBuilder[0], paramProject);
      }
      paramProject = viewModel;
      ((BaseActivity)getActivity()).getLayoutInflater();
      applicationComponent.mediaCenter();
      paramProject.onBindViewHolder$72e41091(viewHolder);
      paramProject = viewModel;
      getActivity();
      paramProject.onBindContributors$346c2e9c(fragmentComponent, ((BaseActivity)getActivity()).getLayoutInflater(), viewHolder, viewModel.members);
      return;
      label650:
      bool = false;
      break;
      localObject1 = null;
      localObject3 = ((MemberUtil)localObject3).getMiniProfile();
      if (localObject3 != null)
      {
        localObject1 = ((ProfileUtil)localObject2).getDisplayNameString((MiniProfile)localObject3);
        localObject4 = entityUrn.getLastId();
        localObject2 = new ProfileEditContributor(((ProfileUtil)localObject2).getMockCompoundUrn("fs_contributor", "-1"), ProfileUrnUtil.createMiniProfileUrn((String)localObject4), (String)localObject1, ProfileEditUtils.getImageUri((MiniProfile)localObject3));
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(localObject2);
      }
      members = ((ArrayList)localObject1);
      break label363;
      members = ((ArrayList)localObject1);
      break label363;
      label759:
      m = j;
      j = i;
      i = -1;
      n = k;
      k = m;
      m = n;
      continue;
      label781:
      k = -1;
      break label453;
      label787:
      k = j;
      j = i;
      i = -1;
      continue;
      label797:
      j = -1;
      break label422;
      label802:
      i = -1;
      break label402;
      label807:
      i = -1;
      j = -1;
      k = -1;
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(projectDateRange.receiver);
  }
  
  public final void doResume()
  {
    super.doResume();
    IntentFilter localIntentFilter = new IntentFilter("datePicked");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(projectDateRange.receiver, localIntentFilter);
  }
  
  public final String getCancelTrackingControlName()
  {
    return "dismiss";
  }
  
  protected final int getContentViewId()
  {
    return 2131757747;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969227;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131232526;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final String getTitle()
  {
    int i;
    if (Util.isEnglish(getContext())) {
      if (project == null) {
        i = 2131232236;
      }
    }
    for (;;)
    {
      return i18NManager.getString(i);
      i = 2131232521;
      continue;
      i = 2131232665;
    }
  }
  
  public final void handleTypeaheadResult(ProfileTypeaheadResult paramProfileTypeaheadResult)
  {
    if ((typeahead != ProfileTypeahead.TYPEAHEAD_PICKER_PEOPLE) || (ProfileEditUtils.isExistingContributor(paramProfileTypeaheadResult, viewModel.members))) {
      return;
    }
    Object localObject = ProfileEditUtils.toProfileEditContributor(paramProfileTypeaheadResult, profileUtil);
    if (((ProfileEditContributor)localObject).isValid())
    {
      viewModel.members.add(localObject);
      paramProfileTypeaheadResult = new ArrayList();
      paramProfileTypeaheadResult.add(localObject);
      localObject = viewModel;
      getActivity();
      ((ProjectViewModel)localObject).onBindContributors$346c2e9c(fragmentComponent, ((BaseActivity)getActivity()).getLayoutInflater(), viewHolder, paramProfileTypeaheadResult);
    }
    setEditSaveMenuItemEnabled(isFormModified());
  }
  
  protected final void initializeFields()
    throws BuilderException
  {
    educations = getEducations();
    positions = getPositions();
    occupationArrayAdapter = new OccupationArrayAdapter(getActivity());
    occupationArrayAdapter.setOccupations(educations, positions, profileUtil, getString(2131232559), getString(2131232560));
    selectOccupationSpinner.setAdapter(occupationArrayAdapter);
    MultiListenerSpinner localMultiListenerSpinner = selectOccupationSpinner;
    if ((project != null) && (project.occupation != null)) {}
    for (int i = occupationArrayAdapter.getSelectedUrn(project.occupation);; i = 0)
    {
      localMultiListenerSpinner.setSelection(i);
      formLayout.requestFocus();
      return;
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final boolean isFormModified()
  {
    try
    {
      Object localObject = new NormProject.Builder();
      populateFields((NormProject.Builder)localObject);
      localObject = ((NormProject.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      if (originalProject == null)
      {
        NormProject.Builder localBuilder = new NormProject.Builder();
        populateFields(localBuilder);
        if (!localBuilder.build(RecordTemplate.Flavor.RECORD).equals(localObject)) {
          return true;
        }
      }
      else
      {
        boolean bool = originalProject.equals(localObject);
        return !bool;
      }
    }
    catch (BuilderException localBuilderException)
    {
      Log.d(TAG, "Failed to populate fields: " + localBuilderException.getMessage());
      return true;
    }
    return false;
  }
  
  protected final boolean isFormValid()
    throws BuilderException
  {
    if (validator == null) {
      return false;
    }
    if (project != null)
    {
      localObject = new NormProject.Builder(normalizeProject(project));
      populateFields((NormProject.Builder)localObject);
      localObject = ((NormProject.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      return validator.isValid((NormProject)localObject);
    }
    Object localObject = new NormProject.Builder();
    populateFields((NormProject.Builder)localObject);
    localObject = ((NormProject.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
    return validator.isValid((NormProject)localObject);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    if (paramBundle != null) {
      modifiedMembers = paramBundle.getParcelableArrayList("members");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelableArrayList("members", viewModel.members);
  }
  
  protected final void optimisticLockingUpdateForm()
  {
    Object localObject = getDataProvider().getProjects();
    if (localObject != null)
    {
      localObject = elements;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Project localProject = (Project)((Iterator)localObject).next();
          if ((project != null) && (project.entityUrn.equals(entityUrn))) {
            try
            {
              setFormData(localProject);
            }
            catch (BuilderException localBuilderException)
            {
              Log.d(TAG, "Failed to set form data: " + localBuilderException.getMessage());
            }
          }
        }
      }
    }
  }
  
  public final String pageKey()
  {
    if (project == null) {
      return "profile_self_add_project";
    }
    return "profile_self_edit_project";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    project = ProfileProjectEditBundleBuilder.getProject(getArguments());
    super.setFragmentData(paramBundle);
    viewHolder = ((ProjectViewHolder)ProjectViewHolder.CREATOR.createViewHolder(formScrollView));
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (project != null)
    {
      deleteLink.setVisibility(0);
      bool1 = bool2;
      if (project.hasTimePeriod) {
        bool1 = project.timePeriod.startDate.equals(project.timePeriod.endDate);
      }
    }
    paramBundle = deleteLink;
    if (project == null) {}
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      ProfileUtil.setLimit(viewHolder.name, 255);
      ProfileUtil.setLimit(viewHolder.url, 262);
      viewHolder.description.addTextChangedListener(new SizeLimitWatcher(viewHolder.description, viewHolder.descriptionExceedLimit, viewHolder.descriptionChars, 2000, 20, i18NManager));
      paramBundle = new DateRangePresenter.Builder();
      fieldName = "projectDates";
      startDateTrackingControlName = "project_start_date";
      endDateTrackingControlName = "project_end_date";
      activity = ((BaseActivity)getActivity());
      dateSetListener = dateSetListener;
      paramBundle = paramBundle.showMonth(Boolean.valueOf(true));
      startDate = viewHolder.startDateEdit;
      endDate = viewHolder.endDateEdit;
      endDateLayout = endDateEditLayout;
      isPresent = viewHolder.currentProjectSwitch;
      toPresentText = viewHolder.toPresentText;
      dateSwitch = viewHolder.switchDate;
      paramBundle = paramBundle.isSingleDate(Boolean.valueOf(bool1));
      switchToSingleResourceId = 2131232580;
      switchToRangeResourceId = 2131232579;
      singleDateResourceId = 2131232562;
      paramBundle = paramBundle.selectStartYear$721a06ed();
      selectEndFutureYear = 0;
      projectDateRange = paramBundle.allowEmptyYear(Boolean.valueOf(true)).allowEmptyMonth(Boolean.valueOf(true)).build();
      paramBundle = new ProjectValidator();
      nameTextLayout = nameEditLayout;
      urlTextLayout = urlEditLayout;
      descriptionTextLayout = descriptionEditLayout;
      validator = paramBundle;
      validator.setActivity(getActivity()).setI18NManager(i18NManager).setFormScrollView(formScrollView).setProfileUtil(profileUtil).setDateErrorTextView(dateErrorTextView);
      setFormData(project);
      projectDateRange.init();
      addEditTextWatchList(new EditText[] { viewHolder.name, viewHolder.url, viewHolder.description });
      addMultilineEditTextOnFocusChangeWatchList(new EditText[] { viewHolder.description });
      addSpinnerWatchList(new Spinner[] { selectOccupationSpinner });
      originalProject = getNormFormProject();
      return;
    }
  }
  
  protected final void updateProfileData()
    throws BuilderException
  {
    Object localObject = getNormFormProject();
    if (project != null) {
      try
      {
        localObject = PegasusPatchGenerator.INSTANCE.diff(project, (RecordTemplate)localObject);
        if ((localObject != null) && (((JSONObject)localObject).length() > 0))
        {
          setDidUpdate$1385ff();
          localObject = new JsonModel((JSONObject)localObject);
          localProfileDataProvider = getDataProvider();
          str1 = busSubscriberId;
          str2 = getRumSessionId();
          str3 = getProfileId();
          str4 = project.entityUrn.getLastId();
          String str5 = getDataProvider().getProfileVersionTag();
          localMap = Tracker.createPageInstanceHeader(getPageInstance());
          str4 = ProfileRoutes.buildEditEntityRoute("normProjects", str3, str4, str5).toString();
          state).projectsRoute = ProfileRoutes.buildProjectsRoute(str3).toString();
          state).allProjectsRoute = state).projectsRoute;
          localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, localProfileDataProvider.getPostRequestBuilder(str4, str3, (RecordTemplate)localObject, Request.get().url(state).projectsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Project.BUILDER, CollectionMetadata.BUILDER))));
          return;
        }
        goBackToPreviousFragment();
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.d(TAG, "Failed to generate diff: " + localJSONException.getMessage());
        return;
      }
    }
    setDidCreate$1385ff();
    ProfileDataProvider localProfileDataProvider = getDataProvider();
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    String str3 = getProfileId();
    String str4 = getDataProvider().getProfileVersionTag();
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    str4 = ProfileRoutes.buildAddEntityRoute("normProjects", str3, str4).toString();
    state).projectsRoute = ProfileRoutes.buildProjectsRoute(str3).toString();
    state).allProjectsRoute = state).projectsRoute;
    localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, localProfileDataProvider.getPostRequestBuilder(str4, str3, localJSONException, Request.get().url(state).projectsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Project.BUILDER, CollectionMetadata.BUILDER)), true));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileProjectEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */