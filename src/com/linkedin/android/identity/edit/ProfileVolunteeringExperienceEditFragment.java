package com.linkedin.android.identity.edit;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.SwitchCompat;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.identity.edit.volunteerexperiences.VolunteerExperienceTransformer;
import com.linkedin.android.identity.edit.volunteerexperiences.VolunteerExperienceViewHolder;
import com.linkedin.android.identity.edit.volunteerexperiences.VolunteerExperienceViewModel;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.shared.CustomArrayAdapter;
import com.linkedin.android.identity.shared.DateRangePresenter;
import com.linkedin.android.identity.shared.DateRangePresenter.Builder;
import com.linkedin.android.identity.shared.DateRangePresenter.OnDateSetListener;
import com.linkedin.android.identity.shared.ProfileTypeaheadResult;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.identity.shared.SizeLimitWatcher;
import com.linkedin.android.identity.shared.multilistenerwidget.MultiListenerButton;
import com.linkedin.android.identity.shared.multilistenerwidget.MultiListenerSpinner;
import com.linkedin.android.identity.shared.ui.LogoEditTextTarget;
import com.linkedin.android.identity.shared.validators.forms.BaseFormValidator;
import com.linkedin.android.identity.shared.validators.forms.VolunteerExperienceValidator;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.GhostImage;
import com.linkedin.android.infra.shared.GhostImageUtils;
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
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.identity.VolunteerCause;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormVolunteerExperience;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormVolunteerExperience.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.VolunteerExperience;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.VolunteerExperienceCompany;
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

public class ProfileVolunteeringExperienceEditFragment
  extends ProfileEditBaseFragment
  implements ProfileEditBaseFragment.TypeaheadListener
{
  private static final String TAG = ProfileVolunteeringExperienceEditFragment.class.getSimpleName();
  private CustomArrayAdapter<CharSequence> causeArrayAdapter;
  @InjectView(2131758191)
  TextInputLayout companyEditLayout;
  private LogoEditTextTarget companyEditTarget;
  @Inject
  FlagshipDataManager dataManager;
  @InjectView(2131757517)
  TextView dateErrorTextView;
  private final DateRangePresenter.OnDateSetListener dateSetListener = new ProfileVolunteeringExperienceEditFragment.1(this);
  @InjectView(2131758200)
  TextView deleteLink;
  @InjectView(2131758196)
  TextInputLayout descriptionEditLayout;
  @InjectView(2131757514)
  TextInputLayout endDateEditLayout;
  @InjectView(2131758190)
  LinearLayout formLayout;
  @InjectView(2131758189)
  ScrollView formScrollView;
  @Inject
  IntentRegistry intentRegistry;
  private ArrayAdapter<CharSequence> monthArrayAdapter;
  private NormVolunteerExperience originalVolunteerExperience;
  @Inject
  ProfileUtil profileUtil;
  @InjectView(2131758193)
  TextInputLayout roleEditLayout;
  @InjectView(2131757512)
  TextInputLayout startDateEditLayout;
  private VolunteerExperienceValidator validator;
  private VolunteerExperienceViewHolder viewHolder;
  private VolunteerExperienceViewModel viewModel;
  private VolunteerExperience volunteerExperience;
  private DateRangePresenter volunteerExperienceDateRange;
  
  public static ProfileVolunteeringExperienceEditFragment newInstance(ProfileVolunteeringExperienceEditBundleBuilder paramProfileVolunteeringExperienceEditBundleBuilder)
  {
    ProfileVolunteeringExperienceEditFragment localProfileVolunteeringExperienceEditFragment = new ProfileVolunteeringExperienceEditFragment();
    localProfileVolunteeringExperienceEditFragment.setArguments(paramProfileVolunteeringExperienceEditBundleBuilder.build());
    return localProfileVolunteeringExperienceEditFragment;
  }
  
  private static NormVolunteerExperience normalizeVolunteerExperience(VolunteerExperience paramVolunteerExperience)
    throws BuilderException
  {
    NormVolunteerExperience.Builder localBuilder = new NormVolunteerExperience.Builder().setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { entityUrn.getLastId() })).setRole(role).setCause(cause).setTimePeriod(timePeriod).setDescription(description).setCompanyName(companyName);
    if (hasCompanyUrn) {
      localBuilder.setCompanyUrn(companyUrn);
    }
    return localBuilder.build(RecordTemplate.Flavor.RECORD);
  }
  
  private void populateFields(NormVolunteerExperience.Builder paramBuilder)
    throws BuilderException
  {
    Object localObject;
    if (volunteerExperience == null)
    {
      localObject = ProfileUtil.getMockUrn();
      paramBuilder.setEntityUrn((Urn)localObject);
      paramBuilder.setCompanyName(companyEditTarget.getText());
      localObject = (ProfileTypeaheadResult)viewHolder.companyEdit.getTag();
      if ((localObject != null) && (((ProfileTypeaheadResult)localObject).getMiniCompany() != null))
      {
        localObject = ((ProfileTypeaheadResult)localObject).getMiniCompany();
        paramBuilder.setCompanyName(name);
        paramBuilder.setCompanyUrn(entityUrn);
      }
      int i = viewHolder.causeSpinner.getSelectedItemPosition();
      if ((i > 0) && (i < VolunteerCause.values().length)) {
        paramBuilder.setCause(VolunteerCause.values()[i]);
      }
      if (viewHolder.roleEdit.getText() != null) {
        paramBuilder.setRole(viewHolder.roleEdit.getText().toString());
      }
      String str = viewHolder.descriptionEdit.getText().toString();
      if ((volunteerExperience != null) || (str.length() <= 0))
      {
        if (volunteerExperience != null)
        {
          if (!volunteerExperience.hasDescription) {
            break label340;
          }
          localObject = volunteerExperience.description;
          label196:
          if (str.equals(localObject)) {}
        }
      }
      else {
        paramBuilder.setDescription(str);
      }
      if ((!volunteerExperienceDateRange.hasStartDate()) && (!volunteerExperienceDateRange.hasEndDate())) {
        break label386;
      }
      localObject = new DateRange.Builder();
      if (volunteerExperienceDateRange.hasStartDate()) {
        ((DateRange.Builder)localObject).setStartDate(volunteerExperienceDateRange.getStartDate());
      }
      if ((volunteerExperienceDateRange.isSingleDate()) || (!volunteerExperienceDateRange.hasEndDate())) {
        break label347;
      }
      ((DateRange.Builder)localObject).setEndDate(volunteerExperienceDateRange.getEndDate());
    }
    for (;;)
    {
      if (volunteerExperienceDateRange.isSingleDate()) {
        ((DateRange.Builder)localObject).setEndDate(volunteerExperienceDateRange.getStartDate());
      }
      paramBuilder.setTimePeriod(((DateRange.Builder)localObject).build(RecordTemplate.Flavor.RECORD));
      return;
      localObject = volunteerExperience.entityUrn;
      break;
      label340:
      localObject = "";
      break label196;
      label347:
      if ((volunteerExperience != null) && (volunteerExperience.hasTimePeriod) && (volunteerExperience.timePeriod.hasEndDate)) {
        ((DateRange.Builder)localObject).setEndDate(null);
      }
    }
    label386:
    paramBuilder.setTimePeriod(null);
  }
  
  private void setFormData(VolunteerExperience paramVolunteerExperience)
  {
    Object localObject = i18NManager;
    DateRangePresenter localDateRangePresenter = volunteerExperienceDateRange;
    VolunteerExperienceViewModel localVolunteerExperienceViewModel = new VolunteerExperienceViewModel();
    i18NManager = ((I18NManager)localObject);
    boolean bool;
    if (paramVolunteerExperience != null)
    {
      company = ProfileUtil.truncate(companyName, 100);
      role = ProfileUtil.truncate(role, 100);
      description = description;
      if (hasCause) {
        cause = cause;
      }
      if (hasTimePeriod)
      {
        localObject = timePeriod;
        startDate = startDate;
        if (!startDate.equals(endDate))
        {
          if (hasEndDate) {
            endDate = endDate;
          }
          if (hasEndDate) {
            break label237;
          }
          bool = true;
          currentlyVolunteer = bool;
        }
      }
      if ((hasCompany) && (company.miniCompany.hasLogo)) {
        companyLogo = company.miniCompany.logo;
      }
      VolunteerExperienceTransformer.initDateRangePresenter(paramVolunteerExperience, localDateRangePresenter);
    }
    for (;;)
    {
      viewModel = localVolunteerExperienceViewModel;
      paramVolunteerExperience = viewModel;
      ((BaseActivity)getActivity()).getLayoutInflater();
      paramVolunteerExperience.onBindViewHolder$4a69ef11(applicationComponent.mediaCenter(), viewHolder);
      return;
      label237:
      bool = false;
      break;
      VolunteerExperienceTransformer.initDateRangePresenter(null, localDateRangePresenter);
    }
  }
  
  protected final void addTrackedListeners()
  {
    viewHolder.companyEdit.setOnFocusChangeListener(new ProfileVolunteeringExperienceEditFragment.2(this));
    viewHolder.roleEdit.setOnFocusChangeListener(new ProfileVolunteeringExperienceEditFragment.3(this));
    viewHolder.companyEdit.setOnClickListener(new ProfileVolunteeringExperienceEditFragment.4(this, tracker, "edit_volunteer_exp_org_name", new TrackingEventBuilder[0]));
    viewHolder.roleEdit.setOnClickListener(new ProfileVolunteeringExperienceEditFragment.5(this, tracker, "edit_volunteer_exp_role", new TrackingEventBuilder[0]));
    viewHolder.currentVolunteerCheckBox.setOnClickListener(new TrackingOnClickListener(tracker, "edit_volunteer_exp_date_toggle", new TrackingEventBuilder[0]));
    viewHolder.switchDate.setOnClickListener(new TrackingOnClickListener(tracker, "edit_volunteer_exp_switch_date_type", new TrackingEventBuilder[0]));
    viewHolder.causeSpinner.setOnItemSelectedListener(new TrackingOnItemSelectedListener(tracker, "edit_volunteer_exp_cause", new TrackingEventBuilder[0]));
    viewHolder.causeSpinner.setFocusableInTouchMode(true);
    viewHolder.causeSpinner.setOnFocusChangeListener(new ProfileVolunteeringExperienceEditFragment.6(this));
    deleteLink.setOnClickListener(new ProfileVolunteeringExperienceEditFragment.7(this, tracker, "delete", new TrackingEventBuilder[0]));
  }
  
  public final void doPause()
  {
    super.doPause();
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(volunteerExperienceDateRange.receiver);
  }
  
  public final void doResume()
  {
    super.doResume();
    IntentFilter localIntentFilter = new IntentFilter("datePicked");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(volunteerExperienceDateRange.receiver, localIntentFilter);
  }
  
  public final String getCancelTrackingControlName()
  {
    return "dismiss";
  }
  
  protected final int getContentViewId()
  {
    return 2131758189;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969319;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131232594;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final String getTitle()
  {
    int i;
    if (Util.isEnglish(getContext())) {
      if (volunteerExperience == null) {
        i = 2131232238;
      }
    }
    for (;;)
    {
      return i18NManager.getString(i);
      i = 2131232588;
      continue;
      i = 2131232743;
    }
  }
  
  public final void handleTypeaheadResult(ProfileTypeaheadResult paramProfileTypeaheadResult)
  {
    switch (ProfileVolunteeringExperienceEditFragment.8.$SwitchMap$com$linkedin$android$identity$shared$ProfileTypeahead[typeahead.ordinal()])
    {
    default: 
    case 1: 
      do
      {
        return;
        viewHolder.companyEdit.setText(text);
        viewHolder.companyEdit.setTag(paramProfileTypeaheadResult);
      } while (companyEditTarget == null);
      MediaCenter localMediaCenter = mediaCenter;
      if (paramProfileTypeaheadResult.getMiniCompany() != null) {}
      for (paramProfileTypeaheadResult = getMiniCompanylogo;; paramProfileTypeaheadResult = null)
      {
        localMediaCenter.load(paramProfileTypeaheadResult).into(companyEditTarget);
        return;
      }
    }
    viewHolder.roleEdit.setText(text);
    viewHolder.roleEdit.setTag(paramProfileTypeaheadResult);
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
      Object localObject = new NormVolunteerExperience.Builder();
      populateFields((NormVolunteerExperience.Builder)localObject);
      localObject = ((NormVolunteerExperience.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      if (originalVolunteerExperience == null)
      {
        NormVolunteerExperience.Builder localBuilder = new NormVolunteerExperience.Builder();
        populateFields(localBuilder);
        if (!localBuilder.build(RecordTemplate.Flavor.RECORD).equals(localObject)) {
          return true;
        }
      }
      else
      {
        boolean bool = originalVolunteerExperience.equals(localObject);
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
    if (volunteerExperience != null)
    {
      localObject = new NormVolunteerExperience.Builder(normalizeVolunteerExperience(volunteerExperience));
      populateFields((NormVolunteerExperience.Builder)localObject);
      localObject = ((NormVolunteerExperience.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      return validator.isValid((NormVolunteerExperience)localObject);
    }
    Object localObject = new NormVolunteerExperience.Builder();
    populateFields((NormVolunteerExperience.Builder)localObject);
    localObject = ((NormVolunteerExperience.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
    return validator.isValid((NormVolunteerExperience)localObject);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    monthArrayAdapter = ProfileUtil.getMonthArrayAdapter(getActivity());
  }
  
  protected final void optimisticLockingUpdateForm()
  {
    Object localObject = getDataProvider().getVolunteerExperiences();
    if (localObject != null)
    {
      localObject = elements;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          VolunteerExperience localVolunteerExperience = (VolunteerExperience)((Iterator)localObject).next();
          if ((volunteerExperience != null) && (volunteerExperience.entityUrn.equals(entityUrn))) {
            setFormData(localVolunteerExperience);
          }
        }
      }
    }
  }
  
  public final String pageKey()
  {
    if (volunteerExperience == null) {
      return "profile_self_add_volunteer_exp";
    }
    return "profile_self_edit_volunteer_exp";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    volunteerExperience = ProfileVolunteeringExperienceEditBundleBuilder.getVolunteerExperience(getArguments());
    super.setFragmentData(paramBundle);
    viewHolder = ((VolunteerExperienceViewHolder)VolunteerExperienceViewHolder.CREATOR.createViewHolder(formScrollView));
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (volunteerExperience != null)
    {
      deleteLink.setVisibility(0);
      bool1 = bool2;
      if (volunteerExperience.hasTimePeriod) {
        bool1 = volunteerExperience.timePeriod.startDate.equals(volunteerExperience.timePeriod.endDate);
      }
    }
    paramBundle = deleteLink;
    if (volunteerExperience == null) {}
    FragmentActivity localFragmentActivity;
    ArrayList localArrayList;
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      viewHolder.descriptionEdit.addTextChangedListener(new SizeLimitWatcher(viewHolder.descriptionEdit, viewHolder.descriptionExceedLimit, viewHolder.descriptionChars, 2000, 20, i18NManager));
      paramBundle = GhostImageUtils.getUnstructuredCompany(2131492964).getDrawable(getContext());
      companyEditTarget = new LogoEditTextTarget(getActivity(), viewHolder.companyEdit, paramBundle, paramBundle);
      viewHolder.companyEditTarget = companyEditTarget;
      paramBundle = new DateRangePresenter.Builder();
      fieldName = "volunteeringExperienceDates";
      startDateTrackingControlName = "edit_volunteer_exp_start_date";
      endDateTrackingControlName = "edit_volunteer_exp_end_date";
      activity = ((BaseActivity)getActivity());
      dateSetListener = dateSetListener;
      paramBundle = paramBundle.showMonth(Boolean.valueOf(true));
      startDate = viewHolder.startDateEdit;
      endDate = viewHolder.endDateEdit;
      endDateLayout = endDateEditLayout;
      isPresent = viewHolder.currentVolunteerCheckBox;
      toPresentText = viewHolder.toPresentText;
      dateSwitch = viewHolder.switchDate;
      paramBundle = paramBundle.isSingleDate(Boolean.valueOf(bool1));
      switchToSingleResourceId = 2131232580;
      switchToRangeResourceId = 2131232579;
      singleDateResourceId = 2131232562;
      paramBundle = paramBundle.selectStartYear$721a06ed();
      selectEndFutureYear = 0;
      volunteerExperienceDateRange = paramBundle.allowEmptyYear(Boolean.valueOf(true)).allowEmptyMonth(Boolean.valueOf(true)).build();
      paramBundle = new VolunteerExperienceValidator();
      organizationTextLayout = companyEditLayout;
      roleTextLayout = roleEditLayout;
      descriptionTextLayout = descriptionEditLayout;
      validator = paramBundle;
      validator.setActivity(getActivity()).setI18NManager(i18NManager).setFormScrollView(formScrollView).setProfileUtil(profileUtil).setDateErrorTextView(dateErrorTextView);
      paramBundle = profileUtil;
      localFragmentActivity = getActivity();
      localArrayList = new ArrayList();
      localArrayList.add(i18NManager.getString(2131232590));
      VolunteerCause[] arrayOfVolunteerCause = VolunteerCause.values();
      int j = arrayOfVolunteerCause.length;
      i = 0;
      while (i < j)
      {
        VolunteerCause localVolunteerCause = arrayOfVolunteerCause[i];
        if (!VolunteerCause.$UNKNOWN.equals(localVolunteerCause)) {
          localArrayList.add(i18NManager.getString(ProfileUtil.getVolunteerCauseResourceId(localFragmentActivity, localVolunteerCause)));
        }
        i += 1;
      }
    }
    paramBundle = new CustomArrayAdapter(localFragmentActivity, localArrayList);
    paramBundle.setDropDownViewResource(17367049);
    causeArrayAdapter = paramBundle;
    viewHolder.causeSpinner.setAdapter(causeArrayAdapter);
    viewHolder.causeSpinner.setSelection(0, false);
    setFormData(volunteerExperience);
    volunteerExperienceDateRange.init();
    addEditTextWatchList(new EditText[] { viewHolder.companyEdit, viewHolder.roleEdit, viewHolder.descriptionEdit });
    addMultilineEditTextOnFocusChangeWatchList(new EditText[] { viewHolder.descriptionEdit });
    addSpinnerWatchList(new Spinner[] { viewHolder.causeSpinner });
    paramBundle = new NormVolunteerExperience.Builder();
    populateFields(paramBundle);
    originalVolunteerExperience = paramBundle.build(RecordTemplate.Flavor.RECORD);
  }
  
  protected final void updateProfileData()
    throws BuilderException
  {
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    if (volunteerExperience != null) {
      try
      {
        localObject = new NormVolunteerExperience.Builder(normalizeVolunteerExperience(volunteerExperience));
        populateFields((NormVolunteerExperience.Builder)localObject);
        localObject = ((NormVolunteerExperience.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
        localObject = PegasusPatchGenerator.INSTANCE.diff(volunteerExperience, (RecordTemplate)localObject);
        if ((localObject != null) && (((JSONObject)localObject).length() > 0))
        {
          setDidUpdate$1385ff();
          localObject = new JsonModel((JSONObject)localObject);
          localProfileDataProvider = getDataProvider();
          str1 = busSubscriberId;
          str2 = getRumSessionId();
          str3 = getProfileId();
          str4 = ProfileRoutes.buildEditEntityRoute("normVolunteerExperiences", str3, volunteerExperience.entityUrn.getLastId(), getDataProvider().getProfileVersionTag()).toString();
          state).volunteerExperiencesRoute = ProfileRoutes.buildVolunteerExperiencesRoute(str3).toString();
          state).allVolunteerExperiencesRoute = state).volunteerExperiencesRoute;
          localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, localProfileDataProvider.getPostRequestBuilder(str4, str3, (RecordTemplate)localObject, Request.get().url(state).volunteerExperiencesRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(VolunteerExperience.BUILDER, CollectionMetadata.BUILDER)), true));
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
    Object localObject = new NormVolunteerExperience.Builder();
    populateFields((NormVolunteerExperience.Builder)localObject);
    localObject = ((NormVolunteerExperience.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
    setDidCreate$1385ff();
    ProfileDataProvider localProfileDataProvider = getDataProvider();
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    String str3 = getProfileId();
    String str4 = ProfileRoutes.buildAddEntityRoute("normVolunteerExperiences", str3, getDataProvider().getProfileVersionTag()).toString();
    state).volunteerExperiencesRoute = ProfileRoutes.buildVolunteerExperiencesRoute(str3).toString();
    state).allVolunteerExperiencesRoute = state).volunteerExperiencesRoute;
    localProfileDataProvider.performMultiplexedFetch(str1, str2, localJSONException, localProfileDataProvider.getPostRequestBuilder(str4, str3, (RecordTemplate)localObject, Request.get().url(state).volunteerExperiencesRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(VolunteerExperience.BUILDER, CollectionMetadata.BUILDER)), true));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileVolunteeringExperienceEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */