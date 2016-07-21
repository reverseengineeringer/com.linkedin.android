package com.linkedin.android.identity.edit;

import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.edit.editComponents.DatesViewModel;
import com.linkedin.android.identity.edit.editComponents.EditComponentTransformer;
import com.linkedin.android.identity.edit.editComponents.EditComponentTransformer.6;
import com.linkedin.android.identity.edit.editComponents.EditComponentTransformer.9;
import com.linkedin.android.identity.edit.editComponents.MultilineFieldViewModel;
import com.linkedin.android.identity.edit.editComponents.SingleLineFieldViewModel;
import com.linkedin.android.identity.edit.editComponents.TypeaheadFieldViewModel;
import com.linkedin.android.identity.edit.treasury.TreasuryTransformer;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.shared.DateRangePresenter.Builder;
import com.linkedin.android.identity.shared.ProfileTypeaheadResult;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Education;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Education.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducation;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducation.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadType;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileEducationEditFragmentV2
  extends ProfileEditBaseFragment
  implements ProfileEditBaseFragment.TypeaheadListener
{
  private static final String TAG = ProfileEducationEditFragmentV2.class.getSimpleName();
  private MultilineFieldViewModel activityViewModel;
  private List<TreasuryMedia> addedTreasuryMedias = new ArrayList();
  private ViewModelArrayAdapter<ViewModel> arrayAdapter;
  @Inject
  FlagshipDataManager dataManager;
  private DatesViewModel datesViewModel;
  private TypeaheadFieldViewModel degreeViewModel;
  private List<TreasuryMedia> deletedTreasuryMedias = new ArrayList();
  private MultilineFieldViewModel descriptionViewModel;
  private Education education;
  @Inject
  Bus eventBus;
  private TypeaheadFieldViewModel fosViewModel;
  private SingleLineFieldViewModel gradeViewModel;
  @Inject
  IntentRegistry intentRegistry;
  private boolean isTreasuryModified;
  private NormEducation originalEducation;
  @Inject
  ProfileUtil profileUtil;
  @InjectView(2131757584)
  RecyclerView recyclerView;
  private boolean resetDataAfterSave;
  private TypeaheadFieldViewModel schoolViewModel;
  private Education tempEducation;
  private List<TreasuryMedia> tempTreasuryMedias;
  private List<TreasuryMedia> treasuryMedias;
  private Map<String, JsonModel> updatedTreasuryMedias = new HashMap();
  
  private NormEducation getCurrentEducation()
    throws BuilderException
  {
    Education.Builder localBuilder = new Education.Builder();
    populateFields(localBuilder);
    return normalizeEducation(localBuilder.build(RecordTemplate.Flavor.RECORD));
  }
  
  private static NormEducation getOriginalEducation(Education paramEducation)
    throws BuilderException
  {
    if (paramEducation != null) {
      paramEducation = new Education.Builder(paramEducation);
    }
    for (;;)
    {
      return normalizeEducation(paramEducation.build(RecordTemplate.Flavor.RECORD));
      paramEducation = new Education.Builder();
      paramEducation.setEntityUrn(ProfileUtil.getDummyMockUrn());
    }
  }
  
  private List<ViewModel> getViewModels()
  {
    Object localObject4 = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = tempEducation;
    Object localObject5 = fragmentComponent;
    Object localObject2;
    if (localObject3 == null)
    {
      localObject1 = null;
      if (localObject3 != null) {
        break label700;
      }
      localObject2 = null;
      label38:
      if ((localObject3 == null) || (!hasSchool)) {
        break label709;
      }
      localObject3 = school;
      label58:
      schoolViewModel = EditComponentTransformer.toTypeaheadFieldViewModel((String)localObject1, (Urn)localObject2, (MiniSchool)localObject3, null, TypeaheadType.SCHOOL, (FragmentComponent)localObject5);
      localObject2 = tempEducation;
      localObject3 = fragmentComponent;
      if (localObject2 != null) {
        break label715;
      }
      localObject1 = null;
      label92:
      if (localObject2 != null) {
        break label723;
      }
      localObject2 = null;
      label98:
      degreeViewModel = EditComponentTransformer.toTypeaheadFieldViewModel((String)localObject1, (Urn)localObject2, null, null, TypeaheadType.DEGREE, (FragmentComponent)localObject3);
      localObject2 = tempEducation;
      localObject3 = fragmentComponent;
      if (localObject2 != null) {
        break label731;
      }
      localObject1 = null;
      label131:
      if (localObject2 != null) {
        break label739;
      }
      localObject2 = null;
      label137:
      fosViewModel = EditComponentTransformer.toTypeaheadFieldViewModel((String)localObject1, (Urn)localObject2, null, null, TypeaheadType.FIELD_OF_STUDY, (FragmentComponent)localObject3);
      localObject1 = tempEducation;
      localObject2 = fragmentComponent;
      if (localObject1 != null) {
        break label747;
      }
      localObject1 = null;
      label169:
      localObject3 = new DatesViewModel();
      i18NManager = ((FragmentComponent)localObject2).i18NManager();
      supportToPresent = false;
      showMonth = false;
      startDateHint = ((FragmentComponent)localObject2).i18NManager().getString(2131232390);
      endDateHint = ((FragmentComponent)localObject2).i18NManager().getString(2131232400);
      if (localObject1 != null)
      {
        startDate = startDate;
        if (hasEndDate) {
          endDate = endDate;
        }
      }
      onFieldEdited = new EditComponentTransformer.9((FragmentComponent)localObject2);
      localObject1 = new DateRangePresenter.Builder();
      fieldName = "educationDates";
      startDateTrackingControlName = "edit_education_start_date";
      endDateTrackingControlName = "edit_education_end_date";
      activity = ((FragmentComponent)localObject2).activity();
      localObject1 = ((DateRangePresenter.Builder)localObject1).showMonth(Boolean.valueOf(false)).selectStartYear$721a06ed();
      selectEndFutureYear = 7;
      dateRangePresenterBuilder = ((DateRangePresenter.Builder)localObject1).allowEmptyYear(Boolean.valueOf(true));
      localBroadcastManager = LocalBroadcastManager.getInstance(((FragmentComponent)localObject2).activity());
      datesViewModel = ((DatesViewModel)localObject3);
      localObject1 = tempEducation;
      localObject2 = fragmentComponent;
      if (localObject1 != null) {
        break label755;
      }
      localObject1 = null;
      label378:
      localObject3 = ((FragmentComponent)localObject2).i18NManager().getString(2131232391);
      localObject5 = new SingleLineFieldViewModel();
      hint = ((String)localObject3);
      text = ((String)localObject1);
      i18NManager = ((FragmentComponent)localObject2).i18NManager();
      onFieldEdited = new EditComponentTransformer.6((FragmentComponent)localObject2);
      gradeViewModel = ((SingleLineFieldViewModel)localObject5);
      localObject1 = tempEducation;
      localObject2 = fragmentComponent;
      if (localObject1 != null) {
        break label763;
      }
      localObject1 = null;
      label460:
      activityViewModel = EditComponentTransformer.toMultilineFieldViewModel$166cb2ec((String)localObject1, 500, ((FragmentComponent)localObject2).i18NManager().getString(2131232384), (FragmentComponent)localObject2);
      localObject1 = tempEducation;
      localObject2 = fragmentComponent;
      if (localObject1 != null) {
        break label771;
      }
    }
    label700:
    label709:
    label715:
    label723:
    label731:
    label739:
    label747:
    label755:
    label763:
    label771:
    for (Object localObject1 = localObject4;; localObject1 = description)
    {
      descriptionViewModel = EditComponentTransformer.toMultilineFieldViewModel$166cb2ec((String)localObject1, 1000, ((FragmentComponent)localObject2).i18NManager().getString(2131232389), (FragmentComponent)localObject2);
      localArrayList.addAll(Arrays.asList(new ViewModel[] { schoolViewModel, degreeViewModel, fosViewModel, datesViewModel, gradeViewModel, activityViewModel, descriptionViewModel }));
      if ((education == null) || (!"enabled".equals(fragmentComponent.lixManager().getTreatment(Lix.PROFILE_EDIT_EDUCATION_TREASURY)))) {
        break label779;
      }
      localArrayList.add(TreasuryTransformer.toTreasuryCreateViewModel(fragmentComponent));
      localObject1 = tempTreasuryMedias.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TreasuryMedia)((Iterator)localObject1).next();
        localArrayList.add(TreasuryTransformer.toTreasuryPreviewEditViewModel(fragmentComponent, profileViewListener, (TreasuryMedia)localObject2));
      }
      localObject1 = schoolName;
      break;
      localObject2 = schoolUrn;
      break label38;
      localObject3 = null;
      break label58;
      localObject1 = degreeName;
      break label92;
      localObject2 = degreeUrn;
      break label98;
      localObject1 = fieldOfStudy;
      break label131;
      localObject2 = fieldOfStudyUrn;
      break label137;
      localObject1 = timePeriod;
      break label169;
      localObject1 = grade;
      break label378;
      localObject1 = activities;
      break label460;
    }
    label779:
    if (education == null) {}
    for (boolean bool = true;; bool = false)
    {
      localArrayList.add(EditComponentTransformer.toDeleteButtonViewModel(bool, 3, fragmentComponent));
      return localArrayList;
    }
  }
  
  public static ProfileEducationEditFragmentV2 newInstance(ProfileEducationEditBundleBuilder paramProfileEducationEditBundleBuilder)
  {
    ProfileEducationEditFragmentV2 localProfileEducationEditFragmentV2 = new ProfileEducationEditFragmentV2();
    localProfileEducationEditFragmentV2.setArguments(paramProfileEducationEditBundleBuilder.build());
    return localProfileEducationEditFragmentV2;
  }
  
  private static NormEducation normalizeEducation(Education paramEducation)
    throws BuilderException
  {
    NormEducation.Builder localBuilder = new NormEducation.Builder();
    localBuilder.setEntityUrn(entityUrn);
    localBuilder.setTimePeriod(timePeriod);
    localBuilder.setDescription(description);
    localBuilder.setSchoolUrn(schoolUrn);
    localBuilder.setSchoolName(schoolName);
    localBuilder.setDegreeUrn(degreeUrn);
    localBuilder.setDegreeName(degreeName);
    localBuilder.setFieldOfStudy(fieldOfStudy);
    localBuilder.setFieldOfStudyUrn(fieldOfStudyUrn);
    localBuilder.setActivities(activities);
    localBuilder.setGrade(grade);
    return localBuilder.build(RecordTemplate.Flavor.RECORD);
  }
  
  private void populateFields(Education.Builder paramBuilder)
    throws BuilderException
  {
    Object localObject;
    if (education == null)
    {
      localObject = ProfileUtil.getDummyMockUrn();
      paramBuilder.setEntityUrn((Urn)localObject);
      localObject = schoolViewModel.getText();
      if (localObject != null) {
        break label280;
      }
      hasSchoolName = false;
      schoolName = null;
      label39:
      localObject = schoolViewModel.urn;
      if (localObject != null) {
        break label293;
      }
      hasSchoolUrn = false;
      schoolUrn = null;
      label61:
      localObject = schoolViewModel.miniSchool;
      if (localObject != null) {
        break label306;
      }
      hasSchool = false;
      school = null;
      label83:
      localObject = degreeViewModel.getText();
      if (localObject != null) {
        break label319;
      }
      hasDegreeName = false;
      degreeName = null;
      label105:
      localObject = degreeViewModel.urn;
      if (localObject != null) {
        break label332;
      }
      hasDegreeUrn = false;
      degreeUrn = null;
      label127:
      localObject = fosViewModel.getText();
      if (localObject != null) {
        break label345;
      }
      hasFieldOfStudy = false;
      fieldOfStudy = null;
      label149:
      localObject = fosViewModel.urn;
      if (localObject != null) {
        break label358;
      }
      hasFieldOfStudyUrn = false;
      fieldOfStudyUrn = null;
      label171:
      localObject = descriptionViewModel.getText();
      if (localObject != null) {
        break label371;
      }
      hasDescription = false;
      description = null;
      label193:
      localObject = gradeViewModel;
      if (!TextUtils.isEmpty(text)) {
        break label384;
      }
      localObject = null;
      label210:
      if (localObject != null) {
        break label392;
      }
      hasGrade = false;
      grade = null;
      label224:
      localObject = activityViewModel.getText();
      if (localObject != null) {
        break label405;
      }
      hasActivities = false;
    }
    for (activities = null;; activities = ((String)localObject))
    {
      localObject = datesViewModel.getDateRange();
      if (localObject != null) {
        break label418;
      }
      hasTimePeriod = false;
      timePeriod = null;
      return;
      localObject = education.entityUrn;
      break;
      label280:
      hasSchoolName = true;
      schoolName = ((String)localObject);
      break label39;
      label293:
      hasSchoolUrn = true;
      schoolUrn = ((Urn)localObject);
      break label61;
      label306:
      hasSchool = true;
      school = ((MiniSchool)localObject);
      break label83;
      label319:
      hasDegreeName = true;
      degreeName = ((String)localObject);
      break label105;
      label332:
      hasDegreeUrn = true;
      degreeUrn = ((Urn)localObject);
      break label127;
      label345:
      hasFieldOfStudy = true;
      fieldOfStudy = ((String)localObject);
      break label149;
      label358:
      hasFieldOfStudyUrn = true;
      fieldOfStudyUrn = ((Urn)localObject);
      break label171;
      label371:
      hasDescription = true;
      description = ((String)localObject);
      break label193;
      label384:
      localObject = text;
      break label210;
      label392:
      hasGrade = true;
      grade = ((String)localObject);
      break label224;
      label405:
      hasActivities = true;
    }
    label418:
    hasTimePeriod = true;
    timePeriod = ((DateRange)localObject);
  }
  
  public final void doPause()
  {
    super.doPause();
    try
    {
      Education.Builder localBuilder = new Education.Builder();
      populateFields(localBuilder);
      getDataProviderstate).modifiedEducation = localBuilder.build(RecordTemplate.Flavor.RECORD);
      getDataProviderstate).modifiedTreasuryList = tempTreasuryMedias;
      getDataProviderstate).isTreasuryAdded = false;
      return;
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        getContext();
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to build a correct Education model"));
      }
    }
  }
  
  public final void doResume()
  {
    super.doResume();
    if (getDataProviderstate).isTreasuryAdded) {
      recyclerView.scrollToPosition(arrayAdapter.getItemCount() - 2);
    }
  }
  
  public final String getCancelTrackingControlName()
  {
    return "dismiss";
  }
  
  protected final int getContentViewId()
  {
    return -1;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969200;
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
    switch (ProfileEducationEditFragmentV2.2.$SwitchMap$com$linkedin$android$identity$shared$ProfileTypeahead[typeahead.ordinal()])
    {
    }
    for (;;)
    {
      setEditSaveMenuItemEnabled(isFormModified());
      return;
      schoolViewModel.applyTypeaheadResult(paramProfileTypeaheadResult);
      continue;
      degreeViewModel.applyTypeaheadResult(paramProfileTypeaheadResult);
      continue;
      fosViewModel.applyTypeaheadResult(paramProfileTypeaheadResult);
    }
  }
  
  protected final void initializeFields() {}
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final boolean isFormModified()
  {
    try
    {
      boolean bool;
      if (getCurrentEducation().equals(originalEducation)) {
        bool = isTreasuryModified;
      }
      return bool;
    }
    catch (BuilderException localBuilderException)
    {
      Log.d(TAG, "Failed to populate fields: " + localBuilderException.getMessage());
      goBackToPreviousFragment();
    }
    return true;
  }
  
  protected final boolean isFormValid()
    throws BuilderException
  {
    boolean bool1 = schoolViewModel.isValid$495862a3(2131232392);
    boolean bool2 = datesViewModel.isValid$3a567496(false, true, true);
    boolean bool3 = activityViewModel.isValid$25dace8(500);
    boolean bool4 = descriptionViewModel.isValid$25dace8(1000);
    if (!bool1) {
      recyclerView.scrollToPosition(arrayAdapter.getIndex(schoolViewModel));
    }
    while ((bool1) && (bool2) && (bool3) && (bool4))
    {
      return true;
      if (!bool2) {
        recyclerView.scrollToPosition(arrayAdapter.getIndex(datesViewModel));
      } else if (!bool3) {
        recyclerView.scrollToPosition(arrayAdapter.getIndex(activityViewModel));
      } else if (!bool4) {
        recyclerView.scrollToPosition(arrayAdapter.getIndex(descriptionViewModel));
      }
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    Bus.subscribe(this);
    if (paramBundle != null)
    {
      tempEducation = ProfileEducationEditBundleBuilder.getEducation(paramBundle);
      tempTreasuryMedias = ProfileEducationEditBundleBuilder.getTreasuryMediaList(paramBundle);
      return;
    }
    getDataProviderstate).modifiedEducation = null;
    getDataProviderstate).modifiedTreasuryList = null;
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if (resetDataAfterSave) {
      getDataProvider().clearProfile(busSubscriberId);
    }
    super.onDataReady(paramType, paramSet, paramMap);
  }
  
  public void onDestroy()
  {
    Bus.unsubscribe(this);
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    if (recyclerView != null) {
      recyclerView.setAdapter(null);
    }
    super.onDestroyView();
  }
  
  @Subscribe
  public void onEvent(ProfileEditEvent paramProfileEditEvent)
  {
    switch (type)
    {
    default: 
      return;
    case 0: 
      setEditSaveMenuItemEnabled(isFormModified());
      return;
    }
    showConfirmDeleteDialog(2131232271, new ProfileEducationEditFragmentV2.1(this));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    try
    {
      Education.Builder localBuilder = new Education.Builder();
      populateFields(localBuilder);
      ProfileEducationEditBundleBuilder localProfileEducationEditBundleBuilder = new ProfileEducationEditBundleBuilder();
      bundle = paramBundle;
      localProfileEducationEditBundleBuilder.setEducation(localBuilder.build(RecordTemplate.Flavor.RECORD)).setTreasuryMediaList(tempTreasuryMedias);
      return;
    }
    catch (BuilderException paramBundle)
    {
      getContext();
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to build a correct Education model"));
    }
  }
  
  protected final void optimisticLockingUpdateForm()
  {
    Object localObject = getDataProvider().getEducations();
    if (localObject != null)
    {
      localObject = elements;
      if (localObject != null) {
        localObject = ((List)localObject).iterator();
      }
    }
    for (;;)
    {
      Education localEducation;
      if (((Iterator)localObject).hasNext())
      {
        localEducation = (Education)((Iterator)localObject).next();
        if ((education == null) || (!education.entityUrn.equals(entityUrn))) {}
      }
      else
      {
        try
        {
          originalEducation = getOriginalEducation(localEducation);
          education = localEducation;
          arrayAdapter.setValues(getViewModels());
          return;
        }
        catch (BuilderException localBuilderException)
        {
          Log.d(TAG, "Failed to build original position: " + localBuilderException.getMessage());
          goBackToPreviousFragment();
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
    treasuryMedias = ProfileEducationEditBundleBuilder.getTreasuryMediaList(localBundle);
    if (treasuryMedias == null) {
      treasuryMedias = new ArrayList();
    }
    super.setFragmentData(paramBundle);
    resetDataAfterSave = ProfileEducationEditBundleBuilder.getResetDataAfterSave(localBundle);
    originalEducation = getOriginalEducation(education);
    if (getDataProviderstate).modifiedEducation != null)
    {
      tempEducation = getDataProviderstate).modifiedEducation;
      if (getDataProviderstate).modifiedTreasuryList == null) {
        break label246;
      }
      tempTreasuryMedias = getDataProviderstate).modifiedTreasuryList;
      label129:
      if (treasuryMedias.equals(tempTreasuryMedias)) {
        break label271;
      }
    }
    label246:
    label271:
    for (boolean bool = true;; bool = false)
    {
      isTreasuryModified = bool;
      paramBundle = new LinearLayoutManager(getActivity());
      recyclerView.setLayoutManager(paramBundle);
      arrayAdapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), null);
      recyclerView.setAdapter(arrayAdapter);
      arrayAdapter.setValues(getViewModels());
      setEditSaveMenuItemEnabled(isFormModified());
      return;
      if (tempEducation != null) {
        break;
      }
      tempEducation = education;
      break;
      if (tempTreasuryMedias != null) {
        break label129;
      }
      tempTreasuryMedias = new ArrayList(treasuryMedias);
      break label129;
    }
  }
  
  protected final void updateProfileData()
    throws BuilderException
  {
    Object localObject1 = getCurrentEducation();
    JsonModel localJsonModel;
    if (education != null)
    {
      HashMap localHashMap;
      Object localObject2;
      Object localObject3;
      for (;;)
      {
        try
        {
          localObject1 = PegasusPatchGenerator.INSTANCE.diff(education, (RecordTemplate)localObject1);
          if (((JSONObject)localObject1).length() > 0) {
            setDidUpdate$1385ff();
          }
          if (!"enabled".equals(fragmentComponent.lixManager().getTreatment(Lix.PROFILE_EDIT_EDUCATION_TREASURY))) {
            break label446;
          }
          localHashMap = new HashMap();
          localIterator = tempTreasuryMedias.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (TreasuryMedia)localIterator.next();
          localObject3 = entityUrn.getLastId();
          if (((String)localObject3).equals("-1")) {
            addedTreasuryMedias.add(localObject2);
          } else {
            localHashMap.put(localObject3, localObject2);
          }
        }
        catch (JSONException localJSONException1)
        {
          Log.d(TAG, "Failed to generate diff for update: " + localJSONException1.getMessage());
          goBackToPreviousFragment();
          return;
        }
      }
      Iterator localIterator = treasuryMedias.iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (TreasuryMedia)localIterator.next();
        localObject2 = entityUrn.getLastId();
        if (!localHashMap.containsKey(localObject2)) {
          deletedTreasuryMedias.add(localObject3);
        } else {
          try
          {
            localObject3 = PegasusPatchGenerator.INSTANCE.diff((RecordTemplate)localObject3, (RecordTemplate)localHashMap.get(localObject2));
            if (((JSONObject)localObject3).length() > 0) {
              updatedTreasuryMedias.put(localObject2, new JsonModel((JSONObject)localObject3));
            }
          }
          catch (JSONException localJSONException2)
          {
            Log.d(TAG, "Failed to generate diff for update: " + localJSONException2.getMessage());
          }
        }
      }
      if ((localJSONException1.length() > 0) || (addedTreasuryMedias.size() > 0) || (updatedTreasuryMedias.size() > 0) || (deletedTreasuryMedias.size() > 0))
      {
        localJsonModel = new JsonModel(localJSONException1);
        getDataProvider().postUpdateWithTreasuries(busSubscriberId, getRumSessionId(), getProfileId(), localJsonModel, addedTreasuryMedias, updatedTreasuryMedias, deletedTreasuryMedias, education.entityUrn, getDataProvider().getProfileVersionTag(), 3, Tracker.createPageInstanceHeader(getPageInstance()));
        return;
      }
      goBackToPreviousFragment();
      return;
      label446:
      if (localJsonModel.length() > 0)
      {
        localJsonModel = new JsonModel(localJsonModel);
        getDataProvider().postUpdateEducation(busSubscriberId, getRumSessionId(), getProfileId(), localJsonModel, education.entityUrn.getLastId(), getDataProvider().getProfileVersionTag(), Tracker.createPageInstanceHeader(getPageInstance()));
        return;
      }
      goBackToPreviousFragment();
      return;
    }
    setDidCreate$1385ff();
    getDataProvider().postAddEducation(busSubscriberId, getRumSessionId(), getProfileId(), localJsonModel, getDataProvider().getProfileVersionTag(), Tracker.createPageInstanceHeader(getPageInstance()));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileEducationEditFragmentV2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */