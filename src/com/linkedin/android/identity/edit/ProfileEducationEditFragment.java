package com.linkedin.android.identity.edit;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.edit.educations.EducationViewHolder;
import com.linkedin.android.identity.edit.educations.EducationViewModel;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.shared.DateRangePresenter;
import com.linkedin.android.identity.shared.DateRangePresenter.Builder;
import com.linkedin.android.identity.shared.DateRangePresenter.OnDateSetListener;
import com.linkedin.android.identity.shared.ProfileTypeaheadResult;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.identity.shared.SizeLimitWatcher;
import com.linkedin.android.identity.shared.ui.LogoEditTextTarget;
import com.linkedin.android.identity.shared.validators.forms.BaseFormValidator;
import com.linkedin.android.identity.shared.validators.forms.EducationValidator;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.GhostImage;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.StringUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange.Builder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Education;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducation;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducation.Builder;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileEducationEditFragment
  extends ProfileEditBaseFragment
  implements ProfileEditBaseFragment.TypeaheadListener
{
  private static final String TAG = ProfileEducationEditFragment.class.getSimpleName();
  @InjectView(2131757617)
  TextView activityChars;
  @InjectView(2131757613)
  TextInputLayout activityEditLayout;
  @InjectView(2131757616)
  TextView activityExceedLimit;
  @Inject
  FlagshipDataManager dataManager;
  @InjectView(2131757610)
  TextView dateErrorTextView;
  private final DateRangePresenter.OnDateSetListener dateSetListener = new ProfileEducationEditFragment.1(this);
  @InjectView(2131757624)
  TextView deleteLink;
  @InjectView(2131757619)
  TextInputLayout descriptionEditLayout;
  private Education education;
  private DateRangePresenter educationDateRange;
  @InjectView(2131757608)
  TextInputLayout endDateEditLayout;
  @InjectView(2131757597)
  LinearLayout formLayout;
  @InjectView(2131757596)
  ScrollView formScrollView;
  @Inject
  IntentRegistry intentRegistry;
  @Inject
  NetworkClient networkClient;
  private NormEducation originalEducation;
  @Inject
  ProfileUtil profileUtil;
  private boolean resetDataAfterSave;
  @InjectView(2131757598)
  TextInputLayout schoolEditLayout;
  private LogoEditTextTarget schoolEditTarget;
  @InjectView(2131757606)
  TextInputLayout startDateEditLayout;
  @Inject
  StringUtils stringUtils;
  private EducationValidator validator;
  private EducationViewHolder viewHolder;
  private EducationViewModel viewModel;
  
  public static ProfileEducationEditFragment newInstance(ProfileEducationEditBundleBuilder paramProfileEducationEditBundleBuilder)
  {
    ProfileEducationEditFragment localProfileEducationEditFragment = new ProfileEducationEditFragment();
    localProfileEducationEditFragment.setArguments(paramProfileEducationEditBundleBuilder.build());
    return localProfileEducationEditFragment;
  }
  
  public static NormEducation normalizeEducation(Education paramEducation)
    throws BuilderException
  {
    NormEducation.Builder localBuilder = new NormEducation.Builder();
    if ((paramEducation != null) && (hasEntityUrn) && (entityUrn != null)) {
      localBuilder.setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { entityUrn.getLastId() }));
    }
    if (hasTimePeriod) {
      localBuilder.setTimePeriod(timePeriod);
    }
    if (hasDescription) {
      localBuilder.setDescription(description);
    }
    if (hasSchoolUrn) {
      localBuilder.setSchoolUrn(schoolUrn);
    }
    if (hasSchoolName) {
      localBuilder.setSchoolName(schoolName);
    }
    if (hasDegreeUrn) {
      localBuilder.setDegreeUrn(degreeUrn);
    }
    if (hasDegreeName) {
      localBuilder.setDegreeName(degreeName);
    }
    if (hasFieldOfStudy) {
      localBuilder.setFieldOfStudy(fieldOfStudy);
    }
    if (hasFieldOfStudyUrn) {
      localBuilder.setFieldOfStudyUrn(fieldOfStudyUrn);
    }
    if (hasActivities) {
      localBuilder.setActivities(activities);
    }
    if (hasGrade) {
      localBuilder.setGrade(grade);
    }
    return localBuilder.build(RecordTemplate.Flavor.RECORD);
  }
  
  private void populateFields(NormEducation.Builder paramBuilder)
    throws BuilderException
  {
    Object localObject;
    if (education == null)
    {
      localObject = ProfileUtil.getMockUrn();
      paramBuilder.setEntityUrn((Urn)localObject);
      if (schoolEditTarget != null)
      {
        if (!schoolEditTarget.getText().isEmpty()) {
          break label439;
        }
        localObject = null;
        label39:
        paramBuilder.setSchoolName((String)localObject);
      }
      localObject = (ProfileTypeaheadResult)viewHolder.schoolEdit.getTag();
      if ((localObject == null) || (((ProfileTypeaheadResult)localObject).getMiniSchool() == null)) {
        break label450;
      }
      localObject = ((ProfileTypeaheadResult)localObject).getMiniSchool();
      paramBuilder.setSchoolUrn(entityUrn);
      paramBuilder.setSchoolName(schoolName);
      String str = viewHolder.degreeEdit.getText().toString();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = null;
      }
      paramBuilder.setDegreeName((String)localObject);
      localObject = (ProfileTypeaheadResult)viewHolder.degreeEdit.getTag();
      if (localObject == null) {
        break label479;
      }
      localObject = urn;
      if (localObject != null) {
        paramBuilder.setDegreeUrn((Urn)localObject);
      }
      str = viewHolder.studyFieldEdit.getText().toString();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = null;
      }
      paramBuilder.setFieldOfStudy((String)localObject);
      localObject = (ProfileTypeaheadResult)viewHolder.studyFieldEdit.getTag();
      if (localObject == null) {
        break label508;
      }
      localObject = urn;
      if (localObject != null) {
        paramBuilder.setFieldOfStudyUrn((Urn)localObject);
      }
      if (viewHolder.descriptionEdit.getText() != null)
      {
        localObject = viewHolder.descriptionEdit.getText().toString();
        if (((String)localObject).length() <= 0) {
          break label537;
        }
        label255:
        paramBuilder.setDescription((String)localObject);
      }
      localObject = viewHolder.gradeEdit.getText().toString();
      if (((education == null) && (((String)localObject).length() > 0)) || (education != null)) {
        paramBuilder.setGrade((String)localObject);
      }
      localObject = viewHolder.activitiesEdit.getText().toString();
      if (((education == null) && (((String)localObject).length() > 0)) || (education != null)) {
        paramBuilder.setActivities((String)localObject);
      }
      if ((!educationDateRange.hasStartDate()) && (!educationDateRange.hasEndDate())) {
        break label581;
      }
      localObject = new DateRange.Builder();
      if (educationDateRange.hasStartDate()) {
        ((DateRange.Builder)localObject).setStartDate(educationDateRange.getStartDate());
      }
      if (!educationDateRange.hasEndDate()) {
        break label542;
      }
      ((DateRange.Builder)localObject).setEndDate(educationDateRange.getEndDate());
    }
    for (;;)
    {
      paramBuilder.setTimePeriod(((DateRange.Builder)localObject).build(RecordTemplate.Flavor.RECORD));
      return;
      localObject = education.entityUrn;
      break;
      label439:
      localObject = schoolEditTarget.getText();
      break label39;
      label450:
      if (education != null) {}
      for (localObject = education.schoolUrn;; localObject = null)
      {
        paramBuilder.setSchoolUrn((Urn)localObject);
        break;
      }
      label479:
      if (education != null) {}
      for (localObject = education.degreeUrn;; localObject = null)
      {
        paramBuilder.setDegreeUrn((Urn)localObject);
        break;
      }
      label508:
      if (education != null) {}
      for (localObject = education.fieldOfStudyUrn;; localObject = null)
      {
        paramBuilder.setFieldOfStudyUrn((Urn)localObject);
        break;
      }
      label537:
      localObject = null;
      break label255;
      label542:
      if ((education != null) && (education.hasTimePeriod) && (education.timePeriod.hasEndDate)) {
        ((DateRange.Builder)localObject).setEndDate(null);
      }
    }
    label581:
    paramBuilder.setTimePeriod(null);
  }
  
  private void setFormData(Education paramEducation)
  {
    int m = -1;
    Object localObject = i18NManager;
    DateRangePresenter localDateRangePresenter = educationDateRange;
    FragmentComponent localFragmentComponent = fragmentComponent;
    EducationViewModel localEducationViewModel = new EducationViewModel();
    i18NManager = ((I18NManager)localObject);
    int i;
    int j;
    int k;
    if (paramEducation != null)
    {
      if (hasSchoolName) {
        school = ProfileUtil.truncate(schoolName, 100);
      }
      degree = ProfileUtil.truncate(degreeName, 100);
      studyField = ProfileUtil.truncate(fieldOfStudy, 100);
      description = description;
      if ((hasSchool) && (school.hasLogo)) {
        schoolLogo = new ImageModel(school.logo, GhostImageUtils.getUnstructuredSchool(2131492960), Util.retrieveRumSessionId(localFragmentComponent));
      }
      if (hasTimePeriod)
      {
        localObject = timePeriod;
        startDate = startDate;
        if (hasEndDate) {
          endDate = endDate;
        }
      }
      grade = grade;
      activities = activities;
      if (hasTimePeriod)
      {
        paramEducation = timePeriod;
        if ((hasStartDate) && (startDate.hasYear))
        {
          i = startDate.year;
          j = i;
          k = m;
          if (hasEndDate)
          {
            j = i;
            k = m;
            if (endDate.hasYear)
            {
              k = endDate.year;
              j = i;
            }
          }
        }
      }
    }
    for (;;)
    {
      initialStartYear = Integer.valueOf(j);
      initialEndYear = Integer.valueOf(k);
      viewModel = localEducationViewModel;
      paramEducation = viewModel;
      ((BaseActivity)getActivity()).getLayoutInflater();
      paramEducation.onBindViewHolder$469d1c71(applicationComponent.mediaCenter(), viewHolder);
      return;
      i = -1;
      break;
      j = -1;
      k = m;
    }
  }
  
  protected final void addTrackedListeners()
  {
    viewHolder.schoolEdit.setOnFocusChangeListener(new ProfileEducationEditFragment.2(this));
    viewHolder.degreeEdit.setOnFocusChangeListener(new ProfileEducationEditFragment.3(this));
    viewHolder.studyFieldEdit.setOnFocusChangeListener(new ProfileEducationEditFragment.4(this));
    viewHolder.schoolEdit.setOnClickListener(new ProfileEducationEditFragment.5(this, tracker, "edit_education_school_name", new TrackingEventBuilder[0]));
    viewHolder.degreeEdit.setOnClickListener(new ProfileEducationEditFragment.6(this, tracker, "edit_education_degree", new TrackingEventBuilder[0]));
    viewHolder.studyFieldEdit.setOnClickListener(new ProfileEducationEditFragment.7(this, tracker, "edit_education_field_of_study", new TrackingEventBuilder[0]));
    deleteLink.setOnClickListener(new ProfileEducationEditFragment.8(this, tracker, "delete", new TrackingEventBuilder[0]));
  }
  
  public final void doPause()
  {
    super.doPause();
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(educationDateRange.receiver);
  }
  
  public final void doResume()
  {
    super.doResume();
    IntentFilter localIntentFilter = new IntentFilter("datePicked");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(educationDateRange.receiver, localIntentFilter);
  }
  
  public final String getCancelTrackingControlName()
  {
    return "dismiss";
  }
  
  protected final int getContentViewId()
  {
    return 2131757596;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969205;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131232388;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final String getTitle()
  {
    int i;
    if (Util.isEnglish(getContext())) {
      if (education == null) {
        i = 2131232231;
      }
    }
    for (;;)
    {
      return i18NManager.getString(i);
      i = 2131232383;
      continue;
      i = 2131232249;
    }
  }
  
  public final void handleTypeaheadResult(ProfileTypeaheadResult paramProfileTypeaheadResult)
  {
    switch (ProfileEducationEditFragment.9.$SwitchMap$com$linkedin$android$identity$shared$ProfileTypeahead[typeahead.ordinal()])
    {
    default: 
    case 1: 
      do
      {
        return;
        viewHolder.schoolEdit.setText(text);
        viewHolder.schoolEdit.setTag(paramProfileTypeaheadResult);
      } while (schoolEditTarget == null);
      MediaCenter localMediaCenter = mediaCenter;
      if ((paramProfileTypeaheadResult.getMiniSchool() != null) && (getMiniSchoolhasLogo)) {}
      for (paramProfileTypeaheadResult = getMiniSchoollogo;; paramProfileTypeaheadResult = null)
      {
        localMediaCenter.load(paramProfileTypeaheadResult).into(schoolEditTarget);
        return;
      }
    case 2: 
      viewHolder.degreeEdit.setText(text);
      viewHolder.degreeEdit.setTag(paramProfileTypeaheadResult);
      return;
    }
    viewHolder.studyFieldEdit.setText(text);
    viewHolder.studyFieldEdit.setTag(paramProfileTypeaheadResult);
  }
  
  protected final void initializeFields()
    throws BuilderException
  {
    formLayout.requestFocus();
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final boolean isFormModified()
  {
    try
    {
      Object localObject = new NormEducation.Builder();
      populateFields((NormEducation.Builder)localObject);
      localObject = ((NormEducation.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      if (originalEducation == null)
      {
        NormEducation.Builder localBuilder = new NormEducation.Builder();
        populateFields(localBuilder);
        if (!localBuilder.build(RecordTemplate.Flavor.RECORD).equals(localObject)) {
          return true;
        }
      }
      else
      {
        boolean bool = originalEducation.equals(localObject);
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
    if (education != null)
    {
      localObject = new NormEducation.Builder(normalizeEducation(education));
      populateFields((NormEducation.Builder)localObject);
      localObject = ((NormEducation.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      return validator.isValid((NormEducation)localObject);
    }
    Object localObject = new NormEducation.Builder();
    populateFields((NormEducation.Builder)localObject);
    localObject = ((NormEducation.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
    return validator.isValid((NormEducation)localObject);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if (resetDataAfterSave) {
      getDataProvider().clearProfile(busSubscriberId);
    }
    super.onDataReady(paramType, paramSet, paramMap);
  }
  
  protected final void optimisticLockingUpdateForm()
  {
    Object localObject = getDataProvider().getEducations();
    if (localObject != null)
    {
      localObject = elements;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Education localEducation = (Education)((Iterator)localObject).next();
          if ((education != null) && (education.entityUrn.equals(entityUrn))) {
            setFormData(localEducation);
          }
        }
      }
    }
  }
  
  public final String pageKey()
  {
    if (education == null) {
      return "profile_self_add_education";
    }
    return "profile_self_edit_education";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    Bundle localBundle = getArguments();
    education = ProfileEducationEditBundleBuilder.getEducation(localBundle);
    super.setFragmentData(paramBundle);
    resetDataAfterSave = ProfileEducationEditBundleBuilder.getResetDataAfterSave(localBundle);
    viewHolder = ((EducationViewHolder)EducationViewHolder.CREATOR.createViewHolder(formScrollView));
    paramBundle = deleteLink;
    if (education == null) {}
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      ProfileUtil.setLimit(viewHolder.schoolEdit, 100);
      ProfileUtil.setLimit(viewHolder.degreeEdit, 100);
      ProfileUtil.setLimit(viewHolder.studyFieldEdit, 100);
      viewHolder.activitiesEdit.addTextChangedListener(new SizeLimitWatcher(viewHolder.activitiesEdit, activityExceedLimit, activityChars, 500, 20, i18NManager));
      viewHolder.descriptionEdit.addTextChangedListener(new SizeLimitWatcher(viewHolder.descriptionEdit, viewHolder.descriptionExceedLimit, viewHolder.descriptionChars, 1000, 20, i18NManager));
      paramBundle = GhostImageUtils.getUnstructuredSchool(2131492960).getDrawable(getContext());
      schoolEditTarget = new LogoEditTextTarget(getActivity(), viewHolder.schoolEdit, paramBundle, paramBundle);
      viewHolder.schoolEditTarget = schoolEditTarget;
      paramBundle = new DateRangePresenter.Builder();
      fieldName = "educationDates";
      startDateTrackingControlName = "edit_education_start_date";
      endDateTrackingControlName = "edit_education_end_date";
      activity = ((BaseActivity)getActivity());
      dateSetListener = dateSetListener;
      paramBundle = paramBundle.showMonth(Boolean.valueOf(false));
      startDate = viewHolder.startDateYearEdit;
      endDate = viewHolder.endDateYearEdit;
      endDateLayout = endDateEditLayout;
      paramBundle = paramBundle.selectStartYear$721a06ed();
      selectEndFutureYear = 7;
      educationDateRange = paramBundle.allowEmptyYear(Boolean.valueOf(true)).build();
      paramBundle = new EducationValidator();
      companyTextLayout = schoolEditLayout;
      activityTextLayout = activityEditLayout;
      descriptionTextLayout = descriptionEditLayout;
      validator = paramBundle;
      validator.setActivity(getActivity()).setI18NManager(i18NManager).setFormScrollView(formScrollView).setProfileUtil(profileUtil).setDateErrorTextView(dateErrorTextView);
      setFormData(education);
      educationDateRange.init();
      addEditTextWatchList(new EditText[] { viewHolder.schoolEdit, viewHolder.degreeEdit, viewHolder.studyFieldEdit, viewHolder.gradeEdit, viewHolder.activitiesEdit, viewHolder.descriptionEdit });
      addMultilineEditTextOnFocusChangeWatchList(new EditText[] { viewHolder.activitiesEdit, viewHolder.descriptionEdit });
      paramBundle = new NormEducation.Builder();
      populateFields(paramBundle);
      originalEducation = paramBundle.build(RecordTemplate.Flavor.RECORD);
      return;
    }
  }
  
  protected final void updateProfileData()
    throws BuilderException
  {
    if (education != null) {
      try
      {
        Object localObject1 = new NormEducation.Builder(normalizeEducation(education));
        populateFields((NormEducation.Builder)localObject1);
        localObject1 = ((NormEducation.Builder)localObject1).build(RecordTemplate.Flavor.RECORD);
        localObject1 = PegasusPatchGenerator.INSTANCE.diff(education, (RecordTemplate)localObject1);
        if ((localObject1 != null) && (((JSONObject)localObject1).length() > 0))
        {
          setDidUpdate$1385ff();
          localObject1 = new JsonModel((JSONObject)localObject1);
          getDataProvider().postUpdateEducation(busSubscriberId, getRumSessionId(), getProfileId(), (JsonModel)localObject1, education.entityUrn.getLastId(), getDataProvider().getProfileVersionTag(), Tracker.createPageInstanceHeader(getPageInstance()));
          return;
        }
        goBackToPreviousFragment();
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.d(TAG, "Failed to generate diff for update: " + localJSONException.getMessage());
        return;
      }
    }
    Object localObject2 = new NormEducation.Builder();
    populateFields((NormEducation.Builder)localObject2);
    localObject2 = ((NormEducation.Builder)localObject2).build(RecordTemplate.Flavor.RECORD);
    setDidCreate$1385ff();
    getDataProvider().postAddEducation(busSubscriberId, getRumSessionId(), getProfileId(), (NormEducation)localObject2, getDataProvider().getProfileVersionTag(), Tracker.createPageInstanceHeader(getPageInstance()));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileEducationEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */