package com.linkedin.android.growth.onboarding.position_education;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider.OnboardingState;
import com.linkedin.android.growth.onboarding.base.OnboardingProfileEditFragment;
import com.linkedin.android.identity.profile.ProfileModelUtils;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.CustomTextInputLayout;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Industry;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPosition;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPosition.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.VersionTag;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadType;
import com.linkedin.android.search.SearchBundleBuilder;
import com.linkedin.android.search.SearchIntent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

public class PositionFragment
  extends OnboardingProfileEditFragment
{
  private static final Urn POSITION_URN = Urn.createFromTuple("position", new Object[] { Integer.valueOf(-1) });
  @InjectView(2131756140)
  EditText companyInput;
  @InjectView(2131756141)
  TextView companyLabel;
  @Inject
  Bus eventBus;
  @Inject
  FlagshipDataManager flagshipDataManager;
  Industry industry;
  @InjectView(2131756142)
  ViewGroup industryContainer;
  @InjectView(2131756144)
  EditText industryInput;
  @InjectView(2131756145)
  TextView industryLabel;
  @Inject
  IntentRegistry intentRegistry;
  private boolean isPaused;
  @InjectView(2131756136)
  CustomTextInputLayout jobTitleContainer;
  @InjectView(2131756137)
  EditText jobTitleInput;
  @InjectView(2131756138)
  TextView jobTitleLabel;
  @Inject
  MemberUtil memberUtil;
  private PositionLegoWidget positionLegoWidget;
  @Inject
  ProfileUtil profileUtil;
  @Inject
  FragmentRegistry registry;
  @InjectView(2131756134)
  ScrollView scrollView;
  @Inject
  SnackbarUtil snackbar;
  @InjectView(2131756107)
  Button switchToEducation;
  MiniCompany typeaheadCompany;
  
  private JSONObject createIndustryAndHeadlineDiff()
  {
    if (getDataProvider().isProfileAvailable()) {
      try
      {
        Object localObject1 = jobTitleInput.getText().toString();
        Object localObject2 = companyInput.getText().toString();
        localObject2 = i18NManager.getString(2131231593, new Object[] { localObject1, localObject2 });
        localObject1 = ProfileModelUtils.toNormProfile(getDataProvider().getProfile());
        localObject2 = new NormProfile.Builder((NormProfile)localObject1).setHeadline((String)localObject2);
        if (industry != null) {
          ((NormProfile.Builder)localObject2).setIndustryName(industry.localizedName).setIndustryUrn(industry.entityUrn);
        }
        localObject1 = createProfileDiff((NormProfile)localObject1, ((NormProfile.Builder)localObject2).build(RecordTemplate.Flavor.RECORD));
        return (JSONObject)localObject1;
      }
      catch (BuilderException localBuilderException)
      {
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed NormProfile validation", localBuilderException));
        return null;
      }
    }
    Util.safeThrow$7a8b4789(new IllegalStateException("Profile is not available"));
    getDataProvider().fetchProfile("", null, Tracker.createPageInstanceHeader(getPageInstance()));
    return null;
  }
  
  private static NormPosition createNormPosition(String paramString1, String paramString2, Urn paramUrn)
  {
    paramString1 = new NormPosition.Builder().setEntityUrn(POSITION_URN).setCompanyName(paramString1).setTitle(paramString2);
    if (paramUrn != null) {
      paramString1.setCompanyUrn(paramUrn);
    }
    try
    {
      paramString1 = paramString1.build(RecordTemplate.Flavor.RECORD);
      return paramString1;
    }
    catch (BuilderException paramString1)
    {
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed NormPosition validation", paramString1));
    }
    return null;
  }
  
  private void toggleIndustryVisibility()
  {
    if ((!TextUtils.isEmpty(companyInput.getText())) && (typeaheadCompany == null))
    {
      industryContainer.setVisibility(0);
      scrollView.post(new PositionFragment.6(this));
      return;
    }
    industryContainer.setVisibility(8);
  }
  
  public final void doPause()
  {
    super.doPause();
    Bus.unsubscribe(this);
    isPaused = true;
  }
  
  public final void doResume()
  {
    super.doResume();
    Bus.subscribe(this);
    toggleIndustryVisibility();
    if (isPaused)
    {
      KeyboardUtil.hideKeyboard(jobTitleInput);
      isPaused = false;
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  @OnClick({2131756140})
  public void launchCompanyTypeahead(TextView paramTextView)
  {
    paramTextView = SearchBundleBuilder.create().setPickerMode$6c621e23().setTypeaheadType(TypeaheadType.COMPANY).setQueryString(paramTextView.getText().toString()).setCustomTypeaheadPageKey("onboarding_company_typeahead").setCustomTypeaheadClickTrackingName("typeahead_result").setCustomTypeaheadSearchBarCancelTrackingName("cancel").setCustomTrackingName("done").setSearchBarHintText(getLocalizedString(2131231592));
    startActivityForResult(intentRegistry.search.newIntent(getActivity(), paramTextView), 1);
  }
  
  @OnClick({2131756137})
  public void launchTitleTypeahead(TextView paramTextView)
  {
    paramTextView = SearchBundleBuilder.create().setPickerMode$6c621e23().setTypeaheadType(TypeaheadType.TITLE).setQueryString(paramTextView.getText().toString()).setCustomTypeaheadPageKey("onboarding_title_typeahead").setCustomTypeaheadClickTrackingName("typeahead_result").setCustomTypeaheadSearchBarCancelTrackingName("cancel").setCustomTrackingName("done").setSearchBarHintText(getLocalizedString(2131231596));
    startActivityForResult(intentRegistry.search.newIntent(getActivity(), paramTextView), 2);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    String str1;
    Object localObject;
    String str2;
    if (paramInt1 == 1)
    {
      industry = null;
      industryInput.setText("");
      str1 = "";
      localObject = str1;
      if (paramIntent != null)
      {
        localObject = SearchBundleBuilder.getCompany(paramIntent.getExtras());
        str2 = SearchBundleBuilder.getText(paramIntent.getExtras());
        if (localObject == null) {
          break label170;
        }
        typeaheadCompany = ((MiniCompany)localObject);
        localObject = typeaheadCompany.name;
      }
    }
    for (;;)
    {
      companyInput.setText((CharSequence)localObject);
      companyInput.setSelection(((String)localObject).length());
      toggleIndustryVisibility();
      if (paramInt1 == 2)
      {
        str1 = "";
        localObject = str1;
        if (paramIntent != null)
        {
          paramIntent = SearchBundleBuilder.getText(paramIntent.getExtras());
          localObject = str1;
          if (paramIntent != null) {
            localObject = paramIntent;
          }
        }
        jobTitleInput.setText((CharSequence)localObject);
        jobTitleInput.setSelection(((String)localObject).length());
      }
      continueButton.setEnabled(verifyAllInputsFilled());
      return;
      label170:
      localObject = str1;
      if (str2 != null)
      {
        typeaheadCompany = null;
        localObject = str2;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      String str = paramBundle.getString("miniCompany");
      if (!TextUtils.isEmpty(str)) {
        restoreModelFromCache(str, MiniCompany.BUILDER, new PositionFragment.1(this));
      }
      paramBundle = paramBundle.getString("industry");
      if (!TextUtils.isEmpty(paramBundle)) {
        restoreModelFromCache(paramBundle, Industry.BUILDER, new PositionFragment.2(this));
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968845, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if ((paramSet != null) && ((paramSet.contains(getDataProviderstate).editProfileRoute)) || (paramSet.contains(getDataProviderstate).addPositionRoute)))) {
      onPostFailed();
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramSet != null) && (paramSet.contains(getDataProviderstate).addPositionRoute)))
    {
      paramType = createIndustryAndHeadlineDiff();
      if (paramType != null) {
        if (paramType.length() > 0) {
          postUpdateProfile(paramType, null);
        }
      }
    }
    while ((paramSet == null) || (!paramSet.contains(getDataProviderstate).editProfileRoute)))
    {
      return;
      onPostSuccess();
      return;
      onPostFailed();
      return;
    }
    onPostSuccess();
  }
  
  @Subscribe
  public void onEvent(Industry paramIndustry)
  {
    industry = paramIndustry;
    industryInput.setText(localizedName);
    continueButton.setEnabled(verifyAllInputsFilled());
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
    Snackbar localSnackbar = snackbar.make(2131231600, 0);
    if (localSnackbar != null) {
      localSnackbar.show();
    }
    legoWidget.finishCurrentFragment();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    String str;
    if (typeaheadCompany != null)
    {
      str = typeaheadCompany.entityUrn.toString();
      paramBundle.putString("miniCompany", str);
      getDataProvider().saveDataModelToCache(str, typeaheadCompany);
    }
    if (industry != null)
    {
      str = industry.entityUrn.toString();
      paramBundle.putString("industry", str);
      getDataProvider().saveDataModelToCache(str, industry);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    positionLegoWidget = ((PositionLegoWidget)legoWidget);
    industryInput.setOnClickListener(new PositionFragment.3(this, tracker, "industry_field", new TrackingEventBuilder[0]));
    switchToEducation.setText(2131231598);
    switchToEducation.setOnClickListener(new PositionFragment.4(this, tracker, "student", new TrackingEventBuilder[0]));
    JellyBeanMr1Utils.setLabelFor(jobTitleLabel, 2131756137);
    JellyBeanMr1Utils.setLabelFor(companyLabel, 2131756140);
    JellyBeanMr1Utils.setLabelFor(industryLabel, 2131756144);
  }
  
  public final String pageKey()
  {
    return "onboarding_position";
  }
  
  protected final void postData()
  {
    if (getDataProvider().isVersionTagAvailable())
    {
      Object localObject2 = companyInput.getText().toString();
      String str1 = jobTitleInput.getText().toString();
      if (typeaheadCompany != null) {}
      for (Object localObject1 = typeaheadCompany.entityUrn;; localObject1 = null)
      {
        localObject1 = createNormPosition((String)localObject2, str1, (Urn)localObject1);
        if (localObject1 == null) {
          break label255;
        }
        localObject2 = getDataProvider();
        str1 = busSubscriberId;
        Object localObject3 = getDataProvider().getVersionTag();
        Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
        String str2 = activityComponent.memberUtil().getProfileId();
        if (str2 == null) {
          break;
        }
        state).addPositionRoute = ProfileRoutes.buildAddEntityRoute("normPositions", str2, versionTag).toString();
        state).versionTagRoute = ProfileRoutes.buildVersionTagRoute(str2, "versionTag").toString();
        localObject3 = MultiplexRequest.Builder.sequential();
        multiplexerUrl = Routes.MUX.buildUponRoot().toString();
        ((OnboardingDataProvider)localObject2).performMultiplexedFetch(str1, null, localMap, ((MultiplexRequest.Builder)localObject3).filter(DataManager.DataStoreFilter.NETWORK_ONLY).required(Request.post().url(state).addPositionRoute).model((RecordTemplate)localObject1)).required(Request.get().url(state).versionTagRoute).builder(VersionTag.BUILDER)));
        return;
      }
      Util.safeThrow$7a8b4789(new RuntimeException("Profile id is null"));
      return;
      label255:
      onPostFailed();
      return;
    }
    Util.safeThrow$7a8b4789(new IllegalStateException("Version tag is not available"));
    getDataProvider().fetchVersionTag$5ea691a4("", Tracker.createPageInstanceHeader(getPageInstance()));
    onPostFailed();
  }
  
  protected final void updateViewWhenLixEnabled()
  {
    if ("enabled".equals(lixManager.getTreatment(Lix.LIX_GROWTH_ENGLISH_INDIA_LOCALIZATION))) {
      jobTitleContainer.setHint(2131233837);
    }
  }
  
  protected final boolean verifyAllInputsFilled()
  {
    if ((TextUtils.isEmpty(companyInput.getText())) || (TextUtils.isEmpty(jobTitleInput.getText()))) {}
    while ((typeaheadCompany == null) && (industry == null)) {
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.position_education.PositionFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */