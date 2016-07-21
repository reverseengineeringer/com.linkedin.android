package com.linkedin.android.growth.onboarding.position_education;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.login.LoginIntent;
import com.linkedin.android.growth.login.LoginIntentBundle;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider.OnboardingState;
import com.linkedin.android.growth.onboarding.base.OnboardingProfileEditFragment;
import com.linkedin.android.identity.profile.ProfileModelUtils;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.shared.DateRangePresenter;
import com.linkedin.android.identity.shared.DateRangePresenter.Builder;
import com.linkedin.android.identity.shared.DateRangePresenter.OnDateSetListener;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.CrossActivitySnackbarCallbacks;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.CustomTextInputLayout;
import com.linkedin.android.liauthlib.LiAuth.LogoutReason;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponse;
import com.linkedin.android.pegasus.gen.actionresponse.ActionResponseBuilder;
import com.linkedin.android.pegasus.gen.common.Date.Builder;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange.Builder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.growth.profile.UnderageResponse;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducation;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducation.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.VersionTag;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadType;
import com.linkedin.android.search.SearchBundleBuilder;
import com.linkedin.android.search.SearchIntent;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.Calendar;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public class EducationFragment
  extends OnboardingProfileEditFragment
{
  private static final Urn EDUCATION_URN = Urn.createFromTuple("education", new Object[] { Integer.valueOf(-1) });
  com.linkedin.android.pegasus.gen.common.Date birthDate;
  @InjectView(2131756093)
  EditText birthDateInput;
  @InjectView(2131756094)
  TextView birthDateLabel;
  final BroadcastReceiver birthDateReceiver = new EducationFragment.2(this);
  final DateRangePresenter.OnDateSetListener dateSetListener = new EducationFragment.1(this);
  DateRangePresenter educationDateRange;
  @InjectView(2131756087)
  CustomTextInputLayout endYearContainer;
  @InjectView(2131756088)
  EditText endYearInput;
  @InjectView(2131756089)
  TextView endYearLabel;
  @Inject
  IntentRegistry intentRegistry;
  @InjectView(2131756090)
  ViewGroup over18Selector;
  @InjectView(2131756091)
  SwitchCompat over18Toggle;
  PositionLegoWidget positionLegoWidget;
  @InjectView(2131756083)
  TextView schoolLabel;
  @InjectView(2131756081)
  CustomTextInputLayout schoolNameContainer;
  @InjectView(2131756082)
  EditText schoolNameInput;
  @Inject
  SnackbarUtil snackbar;
  @InjectView(2131756084)
  CustomTextInputLayout startYearContainer;
  @InjectView(2131756085)
  EditText startYearInput;
  @InjectView(2131756086)
  TextView startYearLabel;
  @InjectView(2131756107)
  Button switchToPosition;
  @InjectView(2131756080)
  TextView title;
  MiniSchool typeaheadSchool;
  
  private JSONObject createBirthDateAndHeadlineDiff()
  {
    if (getDataProvider().isProfileAvailable()) {
      try
      {
        Object localObject1 = schoolNameInput.getText().toString();
        Object localObject2 = Integer.getInteger(endYearInput.getText().toString());
        if (localObject2 != null)
        {
          int i = ((Integer)localObject2).intValue();
          localObject2 = Calendar.getInstance();
          ((Calendar)localObject2).set(i, 4, 1);
          if (!Calendar.getInstance().getTime().before(((Calendar)localObject2).getTime())) {
            break label142;
          }
        }
        label142:
        for (localObject1 = i18NManager.getString(2131231517, new Object[] { localObject1 });; localObject1 = i18NManager.getString(2131231516, new Object[] { localObject1 }))
        {
          localObject2 = ProfileModelUtils.toNormProfile(getDataProvider().getProfile());
          localObject1 = new NormProfile.Builder((NormProfile)localObject2).setHeadline((String)localObject1);
          if (birthDate != null) {
            ((NormProfile.Builder)localObject1).setBirthDate(birthDate);
          }
          return createProfileDiff((NormProfile)localObject2, ((NormProfile.Builder)localObject1).build(RecordTemplate.Flavor.RECORD));
        }
        Util.safeThrow$7a8b4789(new IllegalStateException("Profile is not available"));
      }
      catch (BuilderException localBuilderException)
      {
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed NormProfile validation", localBuilderException));
        return null;
      }
    }
    getDataProvider().fetchProfile("", null, Tracker.createPageInstanceHeader(getPageInstance()));
    return null;
  }
  
  private static NormEducation createNormEducation(String paramString1, String paramString2, String paramString3, Urn paramUrn)
  {
    try
    {
      paramString2 = new Date.Builder().setYear(Integer.valueOf(Integer.parseInt(paramString2))).build(RecordTemplate.Flavor.RECORD);
      paramString3 = new Date.Builder().setYear(Integer.valueOf(Integer.parseInt(paramString3))).build(RecordTemplate.Flavor.RECORD);
      paramString2 = new DateRange.Builder().setStartDate(paramString2).setEndDate(paramString3).build(RecordTemplate.Flavor.RECORD);
      paramString1 = new NormEducation.Builder().setEntityUrn(EDUCATION_URN).setSchoolName(paramString1).setTimePeriod(paramString2);
      if (paramUrn != null) {
        paramString1.setSchoolUrn(paramUrn);
      }
      return null;
    }
    catch (BuilderException paramString1)
    {
      try
      {
        paramString1 = paramString1.build(RecordTemplate.Flavor.RECORD);
        return paramString1;
      }
      catch (BuilderException paramString1)
      {
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed NormEducation validation", paramString1));
      }
      paramString1 = paramString1;
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed Date validation", paramString1));
      return null;
    }
  }
  
  private JSONObject createUnderageRequestObject()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("birthDate", PegasusPatchGenerator.modelToJSON(birthDate));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create underage request object", localJSONException));
    }
    return null;
  }
  
  private void postUpdateBirthDateAndHeadline()
  {
    JSONObject localJSONObject = createBirthDateAndHeadlineDiff();
    if (localJSONObject != null)
    {
      if (localJSONObject.length() > 0)
      {
        postUpdateProfile(localJSONObject, null);
        return;
      }
      onPostSuccess();
      return;
    }
    onPostFailed();
  }
  
  public final void doPause()
  {
    super.doPause();
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(educationDateRange.receiver);
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(birthDateReceiver);
  }
  
  public final void doResume()
  {
    super.doResume();
    updateOver18SelectorVisibility();
    updateBirthDateInputVisibility();
    updateContinueButtonState();
    IntentFilter localIntentFilter = new IntentFilter("datePicked");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(educationDateRange.receiver, localIntentFilter);
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(birthDateReceiver, localIntentFilter);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  @OnClick({2131756082})
  public void launchEducationTypeahead(TextView paramTextView)
  {
    startActivityForResult(intentRegistry.search.newIntent(getActivity(), SearchBundleBuilder.create().setPickerMode$6c621e23().setTypeaheadType(TypeaheadType.SCHOOL).setQueryString(paramTextView.getText().toString()).setCustomTypeaheadPageKey("onboarding_education_typeahead").setCustomTypeaheadClickTrackingName("typeahead_result").setCustomTypeaheadSearchBarCancelTrackingName("cancel").setCustomTrackingName("done").setSearchBarHintText(getLocalizedString(2131231521))), 1);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    String str1;
    String str2;
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      str1 = "";
      MiniSchool localMiniSchool = SearchBundleBuilder.getSchool(paramIntent.getExtras());
      str2 = SearchBundleBuilder.getText(paramIntent.getExtras());
      if (localMiniSchool == null) {
        break label86;
      }
      typeaheadSchool = localMiniSchool;
      paramIntent = typeaheadSchool.schoolName;
    }
    for (;;)
    {
      schoolNameInput.setText(paramIntent);
      schoolNameInput.setSelection(paramIntent.length());
      updateOver18SelectorVisibility();
      updateContinueButtonState();
      return;
      label86:
      paramIntent = str1;
      if (str2 != null)
      {
        typeaheadSchool = null;
        paramIntent = str2;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      String str = paramBundle.getString("miniSchool");
      if (!TextUtils.isEmpty(str)) {
        restoreModelFromCache(str, MiniSchool.BUILDER, new EducationFragment.3(this));
      }
      paramBundle = paramBundle.getString("date");
      if (!TextUtils.isEmpty(paramBundle)) {
        restoreModelFromCache(paramBundle, com.linkedin.android.pegasus.gen.common.Date.BUILDER, new EducationFragment.4(this));
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968832, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if ((paramSet != null) && ((paramSet.contains(getDataProviderstate).editProfileRoute)) || (paramSet.contains(getDataProviderstate).addEducationRoute)) || (paramSet.contains(getDataProviderstate).updateUnderageRoute)))) {
      onPostFailed();
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramSet != null) && (paramSet.contains(getDataProviderstate).addEducationRoute))) {
      if (birthDate != null)
      {
        paramType = createUnderageRequestObject();
        if (paramType != null)
        {
          paramSet = getDataProvider();
          Object localObject = busSubscriberId;
          paramMap = Tracker.createPageInstanceHeader(getPageInstance());
          localObject = paramSet.newModelListener((String)localObject, null);
          paramSet.performPost$27fd812e(new JsonModel(paramType), state).updateUnderageRoute, (RecordTemplateListener)localObject, new ActionResponseBuilder(UnderageResponse.BUILDER), paramMap);
        }
      }
    }
    label284:
    label289:
    do
    {
      for (;;)
      {
        return;
        onPostFailed();
        return;
        postUpdateBirthDateAndHeadline();
        return;
        if ((paramSet == null) || (!paramSet.contains(getDataProviderstate).updateUnderageRoute))) {
          break label289;
        }
        if (((OnboardingDataProvider.OnboardingState)getDataProviderstate).underageResponse() != null) {}
        for (int i = 1; i != 0; i = 0)
        {
          if (!getDataProviderstate).underageResponse().value).underage) {
            break label284;
          }
          applicationComponent.app().registerActivityLifecycleCallbacks(new CrossActivitySnackbarCallbacks(applicationComponent.app(), 2131231526));
          paramType = intentRegistry.login;
          paramSet = getActivity();
          paramMap = new LoginIntentBundle().isLogout(LiAuth.LogoutReason.USER_INITIATED);
          bundle.putBoolean("underageLogout", true);
          startActivity(paramType.newIntent(paramSet, paramMap));
          getActivity().supportFinishAfterTransition();
          return;
        }
      }
      postUpdateBirthDateAndHeadline();
      return;
    } while ((paramSet == null) || (!paramSet.contains(getDataProviderstate).editProfileRoute)));
    onPostSuccess();
  }
  
  protected final void onInputError() {}
  
  protected final void onPostFailed()
  {
    Snackbar localSnackbar = snackbar.make(2131231509, 0);
    if (localSnackbar != null) {
      localSnackbar.show();
    }
  }
  
  protected final void onPostSuccess()
  {
    Snackbar localSnackbar = snackbar.make(2131231527, 0);
    if (localSnackbar != null) {
      localSnackbar.show();
    }
    legoWidget.finishCurrentFragment();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    String str;
    if (typeaheadSchool != null)
    {
      str = typeaheadSchool.entityUrn.toString();
      paramBundle.putString("miniSchool", str);
      getDataProvider().saveDataModelToCache(str, typeaheadSchool);
    }
    if (birthDate != null)
    {
      str = birthDate.day + birthDate.month + birthDate.year;
      paramBundle.putString("date", str);
      getDataProvider().saveDataModelToCache(str, birthDate);
    }
  }
  
  @OnCheckedChanged({2131756091})
  public void onUnderageSelectorToggled()
  {
    new ControlInteractionEvent(tracker, "birth_date_toggle", ControlType.TOGGLE, InteractionType.SHORT_PRESS).send();
    updateOver18SelectorVisibility();
    if (over18Toggle.isChecked()) {
      over18Toggle.setText(2131231520);
    }
    for (;;)
    {
      updateBirthDateInputVisibility();
      updateContinueButtonState();
      return;
      over18Toggle.setText(2131231518);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    positionLegoWidget = ((PositionLegoWidget)legoWidget);
    paramView = new DateRangePresenter.Builder();
    fieldName = "onboardingDates";
    activity = ((BaseActivity)getActivity());
    dateSetListener = dateSetListener;
    startDate = startYearInput;
    endDate = endYearInput;
    paramView = paramView.selectStartYear$721a06ed();
    selectEndFutureYear = 10;
    educationDateRange = paramView.build();
    educationDateRange.init();
    startYearInput.setOnClickListener(new TrackingOnClickListener(tracker, "start_year", new TrackingEventBuilder[0]));
    endYearInput.setOnClickListener(new TrackingOnClickListener(tracker, "end_year", new TrackingEventBuilder[0]));
    birthDateInput.setOnClickListener(new EducationFragment.5(this, tracker, "birth_date_field", new TrackingEventBuilder[0]));
    switchToPosition.setText(2131231524);
    switchToPosition.setOnClickListener(new EducationFragment.6(this, tracker, "position", new TrackingEventBuilder[0]));
    JellyBeanMr1Utils.setLabelFor(schoolLabel, 2131756082);
    JellyBeanMr1Utils.setLabelFor(startYearLabel, 2131756085);
    JellyBeanMr1Utils.setLabelFor(endYearLabel, 2131756088);
    JellyBeanMr1Utils.setLabelFor(birthDateLabel, 2131756093);
  }
  
  public final String pageKey()
  {
    return "onboarding_education";
  }
  
  protected final void postData()
  {
    if (getDataProvider().isVersionTagAvailable())
    {
      Object localObject2 = schoolNameInput.getText().toString();
      String str1 = startYearInput.getText().toString();
      Object localObject3 = endYearInput.getText().toString();
      if (typeaheadSchool != null) {}
      for (Object localObject1 = typeaheadSchool.entityUrn;; localObject1 = null)
      {
        localObject1 = createNormEducation((String)localObject2, str1, (String)localObject3, (Urn)localObject1);
        if (localObject1 == null) {
          break label269;
        }
        localObject2 = getDataProvider();
        str1 = busSubscriberId;
        Object localObject4 = getDataProvider().getVersionTag();
        localObject3 = Tracker.createPageInstanceHeader(getPageInstance());
        String str2 = activityComponent.memberUtil().getProfileId();
        if (str2 == null) {
          break;
        }
        state).addEducationRoute = ProfileRoutes.buildAddEntityRoute("normEducations", str2, versionTag).toString();
        state).versionTagRoute = ProfileRoutes.buildVersionTagRoute(str2, "versionTag").toString();
        localObject4 = MultiplexRequest.Builder.sequential();
        multiplexerUrl = Routes.MUX.buildUponRoot().toString();
        ((OnboardingDataProvider)localObject2).performMultiplexedFetch(str1, null, (Map)localObject3, ((MultiplexRequest.Builder)localObject4).filter(DataManager.DataStoreFilter.NETWORK_ONLY).required(Request.post().url(state).addEducationRoute).model((RecordTemplate)localObject1)).required(Request.get().url(state).versionTagRoute).builder(VersionTag.BUILDER)));
        return;
      }
      Util.safeThrow$7a8b4789(new RuntimeException("Profile id is null"));
      return;
      label269:
      onPostFailed();
      return;
    }
    Util.safeThrow$7a8b4789(new IllegalStateException("Version tag is not available"));
    getDataProvider().fetchVersionTag$5ea691a4("", Tracker.createPageInstanceHeader(getPageInstance()));
    onPostFailed();
  }
  
  final void updateBirthDateInputVisibility()
  {
    if ((over18Selector.getVisibility() == 0) && (!over18Toggle.isChecked()))
    {
      birthDateInput.setVisibility(0);
      return;
    }
    birthDate = null;
    birthDateInput.setText("");
    birthDateInput.setVisibility(8);
  }
  
  final void updateContinueButtonState()
  {
    continueButton.setEnabled(verifyAllInputsFilled());
  }
  
  final void updateOver18SelectorVisibility()
  {
    if ((!TextUtils.isEmpty(schoolNameInput.getText())) && (typeaheadSchool == null))
    {
      over18Selector.setVisibility(0);
      return;
    }
    over18Selector.setVisibility(8);
  }
  
  protected final void updateViewWhenLixEnabled()
  {
    if ("enabled".equals(lixManager.getTreatment(Lix.LIX_GROWTH_ENGLISH_INDIA_LOCALIZATION)))
    {
      title.setText(2131233836);
      schoolNameContainer.setHint(2131233834);
      startYearContainer.setHint(2131233835);
      endYearContainer.setHint(2131233833);
    }
  }
  
  protected final boolean verifyAllInputsFilled()
  {
    if ((TextUtils.isEmpty(schoolNameInput.getText())) || (TextUtils.isEmpty(startYearInput.getText())) || (TextUtils.isEmpty(endYearInput.getText()))) {}
    while ((Integer.parseInt(endYearInput.getText().toString()) < Integer.parseInt(startYearInput.getText().toString())) || ((typeaheadSchool == null) && (!over18Toggle.isChecked()) && (birthDate == null))) {
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.position_education.EducationFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */