package com.linkedin.android.identity.edit;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.SwitchCompat;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.edit.certification.CertificationTransformer;
import com.linkedin.android.identity.edit.certification.CertificationViewHolder;
import com.linkedin.android.identity.edit.certification.CertificationViewModel;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.shared.DateRangePresenter;
import com.linkedin.android.identity.shared.DateRangePresenter.Builder;
import com.linkedin.android.identity.shared.DateRangePresenter.OnDateSetListener;
import com.linkedin.android.identity.shared.ProfileTypeaheadResult;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.identity.shared.ui.LogoEditTextTarget;
import com.linkedin.android.identity.shared.validators.forms.BaseFormValidator;
import com.linkedin.android.identity.shared.validators.forms.CertificationValidator;
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
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange.Builder;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Certification;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormCertification;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormCertification.Builder;
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

public class ProfileCertificationEditFragment
  extends ProfileEditBaseFragment
  implements ProfileEditBaseFragment.TypeaheadListener
{
  private static final String TAG = ProfileCertificationEditFragment.class.getSimpleName();
  @InjectView(2131757365)
  TextInputLayout authorityEditLayout;
  private LogoEditTextTarget authorityEditTarget;
  private Certification certification;
  private DateRangePresenter certificationDateRange;
  @Inject
  FlagshipDataManager dataManager;
  @InjectView(2131757374)
  TextView dateErrorTextView;
  private final DateRangePresenter.OnDateSetListener dateSetListener = new ProfileCertificationEditFragment.1(this);
  @InjectView(2131757379)
  TextView deleteLink;
  @InjectView(2131757371)
  TextInputLayout endDateEditLayout;
  @InjectView(2131757362)
  LinearLayout formLayout;
  @InjectView(2131757361)
  ScrollView formScrollView;
  @Inject
  IntentRegistry intentRegistry;
  @InjectView(2131757367)
  TextInputLayout licenseNumberEditLayout;
  @InjectView(2131757363)
  TextInputLayout nameEditLayout;
  @Inject
  NetworkClient networkClient;
  private NormCertification originalCertification;
  @Inject
  ProfileUtil profileUtil;
  private boolean resetDataAfterSave;
  @InjectView(2131757369)
  TextInputLayout startDateEditLayout;
  @Inject
  StringUtils stringUtils;
  @InjectView(2131757377)
  TextInputLayout urlEditLayout;
  private CertificationValidator validator;
  private CertificationViewHolder viewHolder;
  private CertificationViewModel viewModel;
  
  public static ProfileCertificationEditFragment newInstance(ProfileCertificationEditBundleBuilder paramProfileCertificationEditBundleBuilder)
  {
    ProfileCertificationEditFragment localProfileCertificationEditFragment = new ProfileCertificationEditFragment();
    localProfileCertificationEditFragment.setArguments(paramProfileCertificationEditBundleBuilder.build());
    return localProfileCertificationEditFragment;
  }
  
  private static NormCertification normalizeCertification(Certification paramCertification)
    throws BuilderException
  {
    NormCertification.Builder localBuilder = new NormCertification.Builder();
    localBuilder.setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { entityUrn.getLastId() }));
    localBuilder.setName(name);
    if (hasTimePeriod) {
      localBuilder.setTimePeriod(timePeriod);
    }
    if (hasLicenseNumber) {
      localBuilder.setLicenseNumber(licenseNumber);
    }
    if (hasAuthority) {
      localBuilder.setAuthority(authority);
    }
    if (hasCompany) {
      localBuilder.setCompanyUrn(company.entityUrn);
    }
    if (hasUrl) {
      localBuilder.setUrl(url);
    }
    return localBuilder.build(RecordTemplate.Flavor.RECORD);
  }
  
  private void populateFields(NormCertification.Builder paramBuilder)
    throws BuilderException
  {
    Object localObject;
    if (certification == null)
    {
      localObject = ProfileUtil.getMockUrn();
      paramBuilder.setEntityUrn((Urn)localObject);
      if (authorityEditTarget != null)
      {
        if (!authorityEditTarget.getText().isEmpty()) {
          break label297;
        }
        localObject = null;
        label39:
        paramBuilder.setAuthority((String)localObject);
      }
      localObject = (ProfileTypeaheadResult)viewHolder.authorityEdit.getTag();
      if ((localObject != null) && (((ProfileTypeaheadResult)localObject).getMiniCompany() != null)) {
        paramBuilder.setCompanyUrn(getMiniCompanyentityUrn);
      }
      localObject = "";
      if (viewHolder.nameEdit.getText() != null) {
        localObject = viewHolder.nameEdit.getText().toString();
      }
      paramBuilder.setName((String)localObject);
      localObject = viewHolder.licenseNumberEdit.getText().toString();
      if (((certification == null) && (((String)localObject).length() > 0)) || (certification != null)) {
        paramBuilder.setLicenseNumber((String)localObject);
      }
      localObject = viewHolder.urlEdit.getText().toString();
      if (((certification == null) && (((String)localObject).length() > 0)) || (certification != null)) {
        paramBuilder.setUrl((String)localObject);
      }
      if ((!certificationDateRange.hasStartDate()) && (!certificationDateRange.hasEndDate())) {
        break label347;
      }
      localObject = new DateRange.Builder();
      if (certificationDateRange.hasStartDate()) {
        ((DateRange.Builder)localObject).setStartDate(certificationDateRange.getStartDate());
      }
      if (!certificationDateRange.hasEndDate()) {
        break label308;
      }
      ((DateRange.Builder)localObject).setEndDate(certificationDateRange.getEndDate());
    }
    for (;;)
    {
      paramBuilder.setTimePeriod(((DateRange.Builder)localObject).build(RecordTemplate.Flavor.RECORD));
      return;
      localObject = certification.entityUrn;
      break;
      label297:
      localObject = authorityEditTarget.getText();
      break label39;
      label308:
      if ((certification != null) && (certification.hasTimePeriod) && (certification.timePeriod.hasEndDate)) {
        ((DateRange.Builder)localObject).setEndDate(null);
      }
    }
    label347:
    paramBuilder.setTimePeriod(null);
  }
  
  private void setFormData(Certification paramCertification)
  {
    Object localObject = i18NManager;
    DateRangePresenter localDateRangePresenter = certificationDateRange;
    FragmentComponent localFragmentComponent = fragmentComponent;
    CertificationViewModel localCertificationViewModel = new CertificationViewModel();
    i18NManager = ((I18NManager)localObject);
    boolean bool;
    if (paramCertification != null) {
      if (hasAuthority)
      {
        authority = ProfileUtil.truncate(authority, 100);
        name = ProfileUtil.truncate(name, 255);
        licenseNumber = ProfileUtil.truncate(licenseNumber, 80);
        url = url;
        if ((hasCompany) && (company.hasLogo)) {
          authorityLogo = new ImageModel(company.logo, GhostImageUtils.getUnstructuredCompany(2131492960), Util.retrieveRumSessionId(localFragmentComponent));
        }
        if (hasTimePeriod)
        {
          localObject = timePeriod;
          startDate = startDate;
          if (hasEndDate) {
            endDate = endDate;
          }
          if (hasEndDate) {
            break label273;
          }
          bool = true;
          label194:
          neverExpires = bool;
        }
        CertificationTransformer.initDateRange(paramCertification, localDateRangePresenter);
      }
    }
    for (;;)
    {
      viewModel = localCertificationViewModel;
      paramCertification = viewModel;
      ((BaseActivity)getActivity()).getLayoutInflater();
      applicationComponent.mediaCenter();
      paramCertification.onBindViewHolder$3051d80a(viewHolder);
      return;
      if (!hasCompany) {
        break;
      }
      authority = ProfileUtil.truncate(company.name, 100);
      break;
      label273:
      bool = false;
      break label194;
      CertificationTransformer.initDateRange(null, localDateRangePresenter);
    }
  }
  
  protected final void addTrackedListeners()
  {
    viewHolder.authorityEdit.setOnFocusChangeListener(new ProfileCertificationEditFragment.2(this));
    viewHolder.authorityEdit.setOnClickListener(new ProfileCertificationEditFragment.3(this, tracker, "certification_authority", new TrackingEventBuilder[0]));
    deleteLink.setOnClickListener(new ProfileCertificationEditFragment.4(this, tracker, "delete", new TrackingEventBuilder[0]));
    viewHolder.neverExpiresCheckBox.setOnClickListener(new TrackingOnClickListener(tracker, "expiration_toggle", new TrackingEventBuilder[0]));
  }
  
  public final void doPause()
  {
    super.doPause();
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(certificationDateRange.receiver);
  }
  
  public final void doResume()
  {
    super.doResume();
    IntentFilter localIntentFilter = new IntentFilter("datePicked");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(certificationDateRange.receiver, localIntentFilter);
  }
  
  public final String getCancelTrackingControlName()
  {
    return "dismiss";
  }
  
  protected final int getContentViewId()
  {
    return 2131757361;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969170;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131232322;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final String getTitle()
  {
    int i;
    if (Util.isEnglish(getContext())) {
      if (certification == null) {
        i = 2131232229;
      }
    }
    for (;;)
    {
      return i18NManager.getString(i);
      i = 2131232319;
      continue;
      i = 2131232266;
    }
  }
  
  public final void handleTypeaheadResult(ProfileTypeaheadResult paramProfileTypeaheadResult)
  {
    switch (ProfileCertificationEditFragment.5.$SwitchMap$com$linkedin$android$identity$shared$ProfileTypeahead[typeahead.ordinal()])
    {
    }
    do
    {
      return;
      viewHolder.authorityEdit.setText(text);
      viewHolder.authorityEdit.setTag(paramProfileTypeaheadResult);
    } while (authorityEditTarget == null);
    MediaCenter localMediaCenter = mediaCenter;
    if ((paramProfileTypeaheadResult.getMiniCompany() != null) && (getMiniCompanyhasLogo)) {}
    for (paramProfileTypeaheadResult = getMiniCompanylogo;; paramProfileTypeaheadResult = null)
    {
      localMediaCenter.load(paramProfileTypeaheadResult).into(authorityEditTarget);
      return;
    }
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
      Object localObject = new NormCertification.Builder();
      populateFields((NormCertification.Builder)localObject);
      localObject = ((NormCertification.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      if (originalCertification == null)
      {
        NormCertification.Builder localBuilder = new NormCertification.Builder();
        populateFields(localBuilder);
        if (!localBuilder.build(RecordTemplate.Flavor.RECORD).equals(localObject)) {
          return true;
        }
      }
      else
      {
        boolean bool = originalCertification.equals(localObject);
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
    if (certification != null)
    {
      localObject = new NormCertification.Builder(normalizeCertification(certification));
      populateFields((NormCertification.Builder)localObject);
      localObject = ((NormCertification.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      return validator.isValid((NormCertification)localObject);
    }
    Object localObject = new NormCertification.Builder();
    populateFields((NormCertification.Builder)localObject);
    localObject = ((NormCertification.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
    return validator.isValid((NormCertification)localObject);
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
    Object localObject = getDataProvider().getCertifications();
    if (localObject != null)
    {
      localObject = elements;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Certification localCertification = (Certification)((Iterator)localObject).next();
          if ((certification != null) && (certification.entityUrn.equals(entityUrn))) {
            setFormData(localCertification);
          }
        }
      }
    }
  }
  
  public final String pageKey()
  {
    if (certification == null) {
      return "profile_self_add_certification";
    }
    return "profile_self_edit_certification";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    Bundle localBundle = getArguments();
    certification = ProfileCertificationEditBundleBuilder.getCertification(localBundle);
    super.setFragmentData(paramBundle);
    boolean bool;
    if (localBundle == null)
    {
      bool = false;
      resetDataAfterSave = bool;
      viewHolder = ((CertificationViewHolder)CertificationViewHolder.CREATOR.createViewHolder(formScrollView));
      paramBundle = deleteLink;
      if (certification != null) {
        break label462;
      }
    }
    label462:
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      ProfileUtil.setLimit(viewHolder.nameEdit, 255);
      ProfileUtil.setLimit(viewHolder.licenseNumberEdit, 80);
      ProfileUtil.setLimit(viewHolder.urlEdit, 100);
      paramBundle = GhostImageUtils.getUnstructuredCompany(2131492960).getDrawable(getContext());
      authorityEditTarget = new LogoEditTextTarget(getActivity(), viewHolder.authorityEdit, paramBundle, paramBundle);
      viewHolder.authorityEditTarget = authorityEditTarget;
      paramBundle = new DateRangePresenter.Builder();
      fieldName = "certificationDates";
      startDateTrackingControlName = "certification_start_date";
      endDateTrackingControlName = "certification_end_date";
      activity = ((BaseActivity)getActivity());
      dateSetListener = dateSetListener;
      paramBundle = paramBundle.showMonth(Boolean.valueOf(true));
      startDate = viewHolder.startDateEdit;
      endDate = viewHolder.endDateEdit;
      endDateLayout = endDateEditLayout;
      isPresent = viewHolder.neverExpiresCheckBox;
      toPresentText = viewHolder.toPresentText;
      paramBundle = paramBundle.selectStartYear$721a06ed();
      selectEndFutureYear = 50;
      certificationDateRange = paramBundle.build();
      paramBundle = new CertificationValidator();
      licenseNumberTextLayout = licenseNumberEditLayout;
      nameTextLayout = nameEditLayout;
      urlTextLayout = urlEditLayout;
      validator = paramBundle;
      validator.setActivity(getActivity()).setI18NManager(i18NManager).setFormScrollView(formScrollView).setProfileUtil(profileUtil).setDateErrorTextView(dateErrorTextView);
      setFormData(certification);
      certificationDateRange.init();
      addEditTextWatchList(new EditText[] { viewHolder.nameEdit, viewHolder.authorityEdit, viewHolder.licenseNumberEdit, viewHolder.urlEdit });
      paramBundle = new NormCertification.Builder();
      populateFields(paramBundle);
      originalCertification = paramBundle.build(RecordTemplate.Flavor.RECORD);
      return;
      bool = localBundle.getBoolean("resetDataAfterSave");
      break;
    }
  }
  
  protected final void updateProfileData()
    throws BuilderException
  {
    if (certification != null) {
      try
      {
        Object localObject1 = new NormCertification.Builder(normalizeCertification(certification));
        populateFields((NormCertification.Builder)localObject1);
        localObject1 = ((NormCertification.Builder)localObject1).build(RecordTemplate.Flavor.RECORD);
        localObject1 = PegasusPatchGenerator.INSTANCE.diff(certification, (RecordTemplate)localObject1);
        if ((localObject1 != null) && (((JSONObject)localObject1).length() > 0))
        {
          setDidUpdate$1385ff();
          localObject1 = new JsonModel((JSONObject)localObject1);
          localProfileDataProvider = getDataProvider();
          str1 = busSubscriberId;
          str2 = getRumSessionId();
          str3 = getProfileId();
          str4 = certification.entityUrn.getLastId();
          String str5 = getDataProvider().getProfileVersionTag();
          localMap = Tracker.createPageInstanceHeader(getPageInstance());
          str4 = ProfileRoutes.buildEditEntityRoute("normCertifications", str3, str4, str5).toString();
          state).certificationsRoute = ProfileRoutes.buildCertificationsRoute(str3).toString();
          state).allCertificationsRoute = state).certificationsRoute;
          localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, localProfileDataProvider.getPostRequestBuilder(str4, str3, (RecordTemplate)localObject1, Request.get().url(state).certificationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Certification.BUILDER, CollectionMetadata.BUILDER))));
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
    Object localObject2 = new NormCertification.Builder();
    populateFields((NormCertification.Builder)localObject2);
    localObject2 = ((NormCertification.Builder)localObject2).build(RecordTemplate.Flavor.RECORD);
    setDidCreate$1385ff();
    ProfileDataProvider localProfileDataProvider = getDataProvider();
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    String str3 = getProfileId();
    String str4 = getDataProvider().getProfileVersionTag();
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    str4 = ProfileRoutes.buildAddEntityRoute("normCertifications", str3, str4).toString();
    state).certificationsRoute = ProfileRoutes.buildCertificationsRoute(str3).toString();
    state).allCertificationsRoute = state).certificationsRoute;
    localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, localProfileDataProvider.getPostRequestBuilder(str4, str3, (RecordTemplate)localObject2, Request.get().url(state).certificationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Certification.BUILDER, CollectionMetadata.BUILDER))));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileCertificationEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */