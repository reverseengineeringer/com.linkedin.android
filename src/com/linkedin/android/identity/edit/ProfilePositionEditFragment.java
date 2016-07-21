package com.linkedin.android.identity.edit;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.SwitchCompat;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.edit.positions.PositionTransformer;
import com.linkedin.android.identity.edit.positions.PositionViewHolder;
import com.linkedin.android.identity.edit.positions.PositionViewModel;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.shared.DateRangePresenter;
import com.linkedin.android.identity.shared.DateRangePresenter.Builder;
import com.linkedin.android.identity.shared.DateRangePresenter.OnDateSetListener;
import com.linkedin.android.identity.shared.ProfileTypeaheadResult;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.identity.shared.SizeLimitWatcher;
import com.linkedin.android.identity.shared.ui.LogoEditTextTarget;
import com.linkedin.android.identity.shared.validators.forms.BaseFormValidator;
import com.linkedin.android.identity.shared.validators.forms.PositionValidator;
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
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.GhostImage;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.StringUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange.Builder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPosition;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPosition.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Position;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompany;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
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

public class ProfilePositionEditFragment
  extends ProfileEditBaseFragment
  implements ProfileEditBaseFragment.TypeaheadListener
{
  private static final String TAG = ProfilePositionEditFragment.class.getSimpleName();
  @InjectView(2131757715)
  TextInputLayout companyEditLayout;
  private LogoEditTextTarget companyEditTarget;
  @Inject
  FlagshipDataManager dataManager;
  @InjectView(2131757724)
  TextView dateErrorTextView;
  private final DateRangePresenter.OnDateSetListener dateSetListener = new ProfilePositionEditFragment.1(this);
  @InjectView(2131757732)
  TextView deleteLink;
  @InjectView(2131757727)
  TextInputLayout descriptionEditLayout;
  @InjectView(2131757721)
  TextInputLayout endDateEditLayout;
  @InjectView(2131757712)
  LinearLayout formLayout;
  @InjectView(2131757711)
  ScrollView formScrollView;
  @Inject
  IntentRegistry intentRegistry;
  private ArrayAdapter<CharSequence> monthArrayAdapter;
  private NormPosition originalPosition;
  private Position position;
  private DateRangePresenter positionDateRange;
  @Inject
  ProfileUtil profileUtil;
  private boolean resetDataAfterSave;
  @InjectView(2131757719)
  TextInputLayout startDateEditLayout;
  @Inject
  StringUtils stringUtils;
  @InjectView(2131757713)
  TextInputLayout titleEditLayout;
  private PositionValidator validator;
  private PositionViewHolder viewHolder;
  private PositionViewModel viewModel;
  
  private NormPosition getNormFormPosition()
    throws BuilderException
  {
    if (position != null)
    {
      localBuilder = new NormPosition.Builder(normalizePosition(position));
      populateFields(localBuilder);
      return localBuilder.build(RecordTemplate.Flavor.RECORD);
    }
    NormPosition.Builder localBuilder = new NormPosition.Builder();
    populateFields(localBuilder);
    return localBuilder.build(RecordTemplate.Flavor.RECORD);
  }
  
  public static ProfilePositionEditFragment newInstance(ProfilePositionEditBundleBuilder paramProfilePositionEditBundleBuilder)
  {
    ProfilePositionEditFragment localProfilePositionEditFragment = new ProfilePositionEditFragment();
    localProfilePositionEditFragment.setArguments(paramProfilePositionEditBundleBuilder.build());
    return localProfilePositionEditFragment;
  }
  
  public static NormPosition normalizePosition(Position paramPosition)
    throws BuilderException
  {
    NormPosition.Builder localBuilder = new NormPosition.Builder();
    localBuilder.setEntityUrn(entityUrn).setTitle(title).setDescription(description).setTimePeriod(timePeriod).setRegion(region).setLocationName(locationName);
    if (hasCompanyUrn) {
      localBuilder.setCompanyUrn(companyUrn);
    }
    if (hasCompanyName) {
      localBuilder.setCompanyName(companyName);
    }
    if (hasCompanyUrn) {
      localBuilder.setCompanyUrn(companyUrn);
    }
    return localBuilder.build(RecordTemplate.Flavor.RECORD);
  }
  
  private void populateFields(NormPosition.Builder paramBuilder)
    throws BuilderException
  {
    Object localObject;
    if (position == null)
    {
      localObject = ProfileUtil.getMockUrn();
      paramBuilder.setEntityUrn((Urn)localObject);
      if (companyEditTarget != null)
      {
        if (!companyEditTarget.getText().isEmpty()) {
          break label338;
        }
        localObject = null;
        label39:
        paramBuilder.setCompanyName((String)localObject);
      }
      localObject = (ProfileTypeaheadResult)viewHolder.companyEdit.getTag();
      if ((localObject == null) || (((ProfileTypeaheadResult)localObject).getMiniCompany() == null)) {
        break label349;
      }
      paramBuilder.setCompanyUrn(getMiniCompanyentityUrn);
      String str = viewHolder.locationEdit.getText().toString();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = null;
      }
      paramBuilder.setLocationName((String)localObject);
      localObject = (ProfileTypeaheadResult)viewHolder.locationEdit.getTag();
      if (localObject == null) {
        break label378;
      }
      if (urn != null) {
        paramBuilder.setRegion(urn);
      }
      localObject = viewHolder.titleEdit.getText().toString();
      if (((position == null) && (((String)localObject).length() > 0)) || (position != null)) {
        paramBuilder.setTitle((String)localObject);
      }
      localObject = viewHolder.descriptionEdit.getText().toString();
      if (((position == null) && (((String)localObject).length() > 0)) || (position != null)) {
        paramBuilder.setDescription((String)localObject);
      }
      if ((!positionDateRange.hasStartDate()) && (!positionDateRange.hasEndDate())) {
        break label446;
      }
      localObject = new DateRange.Builder();
      if (positionDateRange.hasStartDate()) {
        ((DateRange.Builder)localObject).setStartDate(positionDateRange.getStartDate());
      }
      if ((viewHolder.currentlyWorksCheckBox.isChecked()) || (!positionDateRange.hasEndDate())) {
        break label407;
      }
      ((DateRange.Builder)localObject).setEndDate(positionDateRange.getEndDate());
    }
    for (;;)
    {
      paramBuilder.setTimePeriod(((DateRange.Builder)localObject).build(RecordTemplate.Flavor.RECORD));
      return;
      localObject = position.entityUrn;
      break;
      label338:
      localObject = companyEditTarget.getText();
      break label39;
      label349:
      if (position != null) {}
      for (localObject = position.companyUrn;; localObject = null)
      {
        paramBuilder.setCompanyUrn((Urn)localObject);
        break;
      }
      label378:
      if (position != null) {}
      for (localObject = position.region;; localObject = null)
      {
        paramBuilder.setRegion((Urn)localObject);
        break;
      }
      label407:
      if ((position != null) && (position.hasTimePeriod) && (position.timePeriod.hasEndDate)) {
        ((DateRange.Builder)localObject).setEndDate(null);
      }
    }
    label446:
    paramBuilder.setTimePeriod(null);
  }
  
  private void setFormData(Position paramPosition)
  {
    Object localObject = i18NManager;
    DateRangePresenter localDateRangePresenter = positionDateRange;
    FragmentComponent localFragmentComponent = fragmentComponent;
    PositionViewModel localPositionViewModel = new PositionViewModel();
    i18NManager = ((I18NManager)localObject);
    boolean bool;
    if (paramPosition != null)
    {
      company = ProfileUtil.truncate(companyName, 100);
      title = ProfileUtil.truncate(title, 100);
      location = ProfileUtil.truncate(locationName, 100);
      description = description;
      if ((hasCompany) && (company.miniCompany.hasLogo)) {
        companyLogo = new ImageModel(company.miniCompany.logo, GhostImageUtils.getUnstructuredCompany(2131492960), Util.retrieveRumSessionId(localFragmentComponent));
      }
      if (hasTimePeriod)
      {
        localObject = timePeriod;
        startDate = startDate;
        if (hasEndDate) {
          endDate = endDate;
        }
        if (!hasEndDate)
        {
          bool = true;
          currentlyWorks = bool;
        }
      }
      else
      {
        PositionTransformer.initDateRange(paramPosition, localDateRangePresenter);
      }
    }
    for (;;)
    {
      viewModel = localPositionViewModel;
      paramPosition = viewModel;
      ((BaseActivity)getActivity()).getLayoutInflater();
      paramPosition.onBindViewHolder$3b83a1c5(applicationComponent.mediaCenter(), viewHolder);
      return;
      bool = false;
      break;
      PositionTransformer.initDateRange(null, localDateRangePresenter);
    }
  }
  
  protected final void addTrackedListeners()
  {
    viewHolder.companyEdit.setOnFocusChangeListener(new ProfilePositionEditFragment.2(this));
    viewHolder.titleEdit.setOnFocusChangeListener(new ProfilePositionEditFragment.3(this));
    viewHolder.locationEdit.setOnFocusChangeListener(new ProfilePositionEditFragment.4(this));
    viewHolder.companyEdit.setOnClickListener(new ProfilePositionEditFragment.5(this, tracker, "edit_position_company_name", new TrackingEventBuilder[0]));
    viewHolder.titleEdit.setOnClickListener(new ProfilePositionEditFragment.6(this, tracker, "edit_position_title", new TrackingEventBuilder[0]));
    viewHolder.locationEdit.setOnClickListener(new ProfilePositionEditFragment.7(this, tracker, "edit_position_location", new TrackingEventBuilder[0]));
    viewHolder.currentlyWorksCheckBox.setOnClickListener(new TrackingOnClickListener(tracker, "edit_position_date_toggle", new TrackingEventBuilder[0]));
    deleteLink.setOnClickListener(new ProfilePositionEditFragment.8(this, tracker, "delete", new TrackingEventBuilder[0]));
  }
  
  public final void doPause()
  {
    super.doPause();
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(positionDateRange.receiver);
  }
  
  public final void doResume()
  {
    super.doResume();
    IntentFilter localIntentFilter = new IntentFilter("datePicked");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(positionDateRange.receiver, localIntentFilter);
  }
  
  public final String getCancelTrackingControlName()
  {
    return "dismiss";
  }
  
  protected final int getContentViewId()
  {
    return 2131757711;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969223;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131232509;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final String getTitle()
  {
    int i;
    if (Util.isEnglish(getContext())) {
      if (position == null) {
        i = 2131232235;
      }
    }
    for (;;)
    {
      return i18NManager.getString(i);
      i = 2131232505;
      continue;
      i = 2131232663;
    }
  }
  
  public final void handleTypeaheadResult(ProfileTypeaheadResult paramProfileTypeaheadResult)
  {
    switch (ProfilePositionEditFragment.9.$SwitchMap$com$linkedin$android$identity$shared$ProfileTypeahead[typeahead.ordinal()])
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
    case 2: 
      viewHolder.titleEdit.setText(text);
      viewHolder.titleEdit.setTag(paramProfileTypeaheadResult);
      return;
    }
    viewHolder.locationEdit.setText(text);
    viewHolder.locationEdit.setTag(paramProfileTypeaheadResult);
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
      NormPosition localNormPosition = getNormFormPosition();
      if (originalPosition == null)
      {
        NormPosition.Builder localBuilder = new NormPosition.Builder();
        populateFields(localBuilder);
        if (!localBuilder.build(RecordTemplate.Flavor.RECORD).equals(localNormPosition)) {
          return true;
        }
      }
      else
      {
        boolean bool = originalPosition.equals(localNormPosition);
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
    if (position != null)
    {
      localObject = new NormPosition.Builder(normalizePosition(position));
      populateFields((NormPosition.Builder)localObject);
      localObject = ((NormPosition.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      return validator.isValid((NormPosition)localObject);
    }
    Object localObject = new NormPosition.Builder();
    populateFields((NormPosition.Builder)localObject);
    localObject = ((NormPosition.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
    return validator.isValid((NormPosition)localObject);
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
    Object localObject = getDataProvider().getPositions();
    if (localObject != null)
    {
      localObject = elements;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Position localPosition = (Position)((Iterator)localObject).next();
          if ((position != null) && (position.entityUrn.equals(entityUrn))) {
            setFormData(localPosition);
          }
        }
      }
    }
  }
  
  public final String pageKey()
  {
    if (position == null) {
      return "profile_self_add_position";
    }
    return "profile_self_edit_position";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    Bundle localBundle = getArguments();
    position = ProfilePositionEditBundleBuilder.getPosition(localBundle);
    super.setFragmentData(paramBundle);
    resetDataAfterSave = ProfilePositionEditBundleBuilder.getResetDataAfterSave(localBundle);
    viewHolder = ((PositionViewHolder)PositionViewHolder.CREATOR.createViewHolder(formScrollView));
    paramBundle = deleteLink;
    if (position == null) {}
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      ProfileUtil.setLimit(viewHolder.companyEdit, 100);
      ProfileUtil.setLimit(viewHolder.titleEdit, 100);
      ProfileUtil.setLimit(viewHolder.locationEdit, 100);
      viewHolder.descriptionEdit.addTextChangedListener(new SizeLimitWatcher(viewHolder.descriptionEdit, viewHolder.descriptionExceedLimit, viewHolder.descriptionChars, 2000, 20, i18NManager));
      paramBundle = GhostImageUtils.getUnstructuredCompany(2131492964).getDrawable(getContext());
      companyEditTarget = new LogoEditTextTarget(getActivity(), viewHolder.companyEdit, paramBundle, paramBundle);
      viewHolder.companyEditTarget = companyEditTarget;
      paramBundle = new DateRangePresenter.Builder();
      fieldName = "positionDates";
      startDateTrackingControlName = "edit_position_start_date";
      endDateTrackingControlName = "edit_position_end_date";
      activity = ((BaseActivity)getActivity());
      dateSetListener = dateSetListener;
      paramBundle = paramBundle.showMonth(Boolean.valueOf(true));
      startDate = viewHolder.startDate;
      endDate = viewHolder.endDate;
      isPresent = viewHolder.currentlyWorksCheckBox;
      toPresentText = viewHolder.toPresentText;
      endDateLayout = endDateEditLayout;
      paramBundle = paramBundle.selectStartYear$721a06ed();
      selectEndFutureYear = 0;
      positionDateRange = paramBundle.allowEmptyYear(Boolean.valueOf(true)).allowEmptyMonth(Boolean.valueOf(true)).build();
      paramBundle = new PositionValidator();
      companyTextLayout = companyEditLayout;
      titleTextLayout = titleEditLayout;
      descriptionTextLayout = descriptionEditLayout;
      validator = paramBundle;
      validator.setActivity(getActivity()).setI18NManager(i18NManager).setFormScrollView(formScrollView).setProfileUtil(profileUtil).setDateErrorTextView(dateErrorTextView);
      monthArrayAdapter = ProfileUtil.getMonthArrayAdapter(getActivity());
      setFormData(position);
      positionDateRange.init();
      addEditTextWatchList(new EditText[] { viewHolder.companyEdit, viewHolder.titleEdit, viewHolder.locationEdit, viewHolder.descriptionEdit });
      addMultilineEditTextOnFocusChangeWatchList(new EditText[] { viewHolder.descriptionEdit });
      paramBundle = new NormPosition.Builder();
      populateFields(paramBundle);
      originalPosition = paramBundle.build(RecordTemplate.Flavor.RECORD);
      return;
    }
  }
  
  protected final void updateProfileData()
    throws BuilderException
  {
    Object localObject = getNormFormPosition();
    if (position != null) {
      try
      {
        localObject = PegasusPatchGenerator.INSTANCE.diff(position, (RecordTemplate)localObject);
        if ((localObject != null) && (((JSONObject)localObject).length() > 0))
        {
          setDidUpdate$1385ff();
          localObject = new JsonModel((JSONObject)localObject);
          getDataProvider().postUpdatePosition(busSubscriberId, getRumSessionId(), getProfileId(), (JsonModel)localObject, position.entityUrn.getLastId(), getDataProvider().getProfileVersionTag(), Tracker.createPageInstanceHeader(getPageInstance()));
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
    setDidCreate$1385ff();
    getDataProvider().postAddPosition(busSubscriberId, getRumSessionId(), getProfileId(), localJSONException, getDataProvider().getProfileVersionTag(), Tracker.createPageInstanceHeader(getPageInstance()));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfilePositionEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */