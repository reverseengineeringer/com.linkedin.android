package com.linkedin.android.growth.onboarding.location;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import butterknife.OnTextChanged.Callback;
import butterknife.OnTouch;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider.OnboardingState;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.spinner.SimpleSpinnerItemViewHolder;
import com.linkedin.android.infra.spinner.SimpleSpinnerItemViewModel;
import com.linkedin.android.infra.spinner.ViewModelSpinnerAdapter;
import com.linkedin.android.infra.ui.CustomTextInputLayout;
import com.linkedin.android.infra.ui.CustomTextInputLayoutSpinner;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.BasicLocation;
import com.linkedin.android.pegasus.gen.voyager.common.City;
import com.linkedin.android.pegasus.gen.voyager.common.Country;
import com.linkedin.android.pegasus.gen.voyager.common.Country.Builder;
import com.linkedin.android.pegasus.gen.voyager.common.State;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class LocationPickerFragment
  extends PageFragment
{
  City city;
  @InjectView(2131756116)
  EditText cityInput;
  @InjectView(2131756115)
  CustomTextInputLayoutSpinner cityInputContainer;
  @InjectView(2131756117)
  TextView cityLabel;
  Country country;
  @InjectView(2131756110)
  EditText countryInput;
  @InjectView(2131756109)
  CustomTextInputLayoutSpinner countryInputContainer;
  @InjectView(2131756111)
  TextView countryLabel;
  @Inject
  KeyboardUtil keyboardUtil;
  @Inject
  LixManager lixManager;
  boolean onBackPressed;
  private LocationPickerListener parentListener;
  @InjectView(2131756118)
  CustomTextInputLayout postalCodeContainer;
  @InjectView(2131756119)
  EditText postalCodeInput;
  @InjectView(2131756120)
  TextView postalCodeLabel;
  @Inject
  ProfileUtil profileUtil;
  State state;
  @InjectView(2131756113)
  EditText stateInput;
  @InjectView(2131756112)
  CustomTextInputLayoutSpinner stateInputContainer;
  @InjectView(2131756114)
  TextView stateLabel;
  
  private void populateCitySpinner(List<City> paramList)
  {
    if (cityInputContainer == null) {}
    Spinner localSpinner;
    do
    {
      return;
      localSpinner = cityInputContainer.getSpinner();
    } while (localSpinner == null);
    ArrayList localArrayList = new ArrayList(paramList.size() + 1);
    Object localObject = new SimpleSpinnerItemViewModel();
    text = getResources().getString(2131231559);
    localArrayList.add(localObject);
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      City localCity = (City)((Iterator)localObject).next();
      SimpleSpinnerItemViewModel localSimpleSpinnerItemViewModel = new SimpleSpinnerItemViewModel();
      text = cityName;
      localArrayList.add(localSimpleSpinnerItemViewModel);
    }
    localSpinner.setAdapter(new ViewModelSpinnerAdapter(getActivity(), fragmentComponent.mediaCenter(), SimpleSpinnerItemViewHolder.CREATOR.getLayoutId(), localArrayList));
    localSpinner.post(new LocationPickerFragment.6(this, localSpinner, paramList));
  }
  
  private void populateCountrySpinner(List<Country> paramList)
  {
    if (countryInputContainer == null) {}
    Spinner localSpinner;
    do
    {
      return;
      localSpinner = countryInputContainer.getSpinner();
    } while (localSpinner == null);
    ArrayList localArrayList = new ArrayList(paramList.size() + 1);
    Object localObject = new SimpleSpinnerItemViewModel();
    text = getResources().getString(2131231560);
    localArrayList.add(localObject);
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Country localCountry = (Country)((Iterator)localObject).next();
      SimpleSpinnerItemViewModel localSimpleSpinnerItemViewModel = new SimpleSpinnerItemViewModel();
      text = countryName;
      localArrayList.add(localSimpleSpinnerItemViewModel);
    }
    localSpinner.setAdapter(new ViewModelSpinnerAdapter(getActivity(), fragmentComponent.mediaCenter(), SimpleSpinnerItemViewHolder.CREATOR.getLayoutId(), localArrayList));
    localSpinner.setOnItemSelectedListener(new LocationPickerFragment.4(this, paramList));
  }
  
  private void populateStateSpinner(List<State> paramList)
  {
    if (stateInputContainer == null) {}
    Spinner localSpinner;
    do
    {
      return;
      localSpinner = stateInputContainer.getSpinner();
    } while (localSpinner == null);
    ArrayList localArrayList = new ArrayList(paramList.size() + 1);
    Object localObject = new SimpleSpinnerItemViewModel();
    text = getResources().getString(2131231570);
    localArrayList.add(localObject);
    localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      State localState = (State)((Iterator)localObject).next();
      SimpleSpinnerItemViewModel localSimpleSpinnerItemViewModel = new SimpleSpinnerItemViewModel();
      text = stateName;
      localArrayList.add(localSimpleSpinnerItemViewModel);
    }
    localSpinner.setAdapter(new ViewModelSpinnerAdapter(getActivity(), fragmentComponent.mediaCenter(), SimpleSpinnerItemViewHolder.CREATOR.getLayoutId(), localArrayList));
    localSpinner.post(new LocationPickerFragment.5(this, localSpinner, paramList));
  }
  
  private void requestLocationPermission()
  {
    LocationFragment localLocationFragment;
    if ((parentListener instanceof LocationFragment))
    {
      localLocationFragment = (LocationFragment)parentListener;
      Fragment localFragment = localLocationFragment.getParentFragment();
      if ((localFragment instanceof LocationLegoWidget)) {
        ((LocationLegoWidget)localFragment).requestPermission("android.permission.ACCESS_FINE_LOCATION", 2131231563, 2131231562);
      }
    }
    else
    {
      return;
    }
    localLocationFragment.requestPermission("android.permission.ACCESS_FINE_LOCATION", 2131231563, 2131231562);
  }
  
  private void setPostalCodeHint(int paramInt)
  {
    if ((postalCodeInput != null) && (postalCodeLabel != null))
    {
      postalCodeInput.setHint(paramInt);
      JellyBeanMr1Utils.setLabelFor(postalCodeLabel, paramInt);
    }
  }
  
  private boolean shouldRequestLocationPermission()
  {
    if (!isCountrySet()) {}
    do
    {
      return true;
      if ((ProfileUtil.isOnboardingThreeStepCountry(country.countryCode)) && (isCountrySet())) {
        return false;
      }
    } while ((ProfileUtil.isOnboardingThreeStepCountry(country.countryCode)) || (!isCountrySet()) || (!isPostalCodeSet()));
    return false;
  }
  
  private void updateFieldVisibility(int paramInt1, int paramInt2, int paramInt3)
  {
    if (stateInputContainer != null) {
      stateInputContainer.setVisibility(paramInt1);
    }
    if (cityInputContainer != null) {
      cityInputContainer.setVisibility(paramInt2);
    }
    if (postalCodeContainer != null) {
      postalCodeContainer.setVisibility(paramInt3);
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    onBackPressed = true;
  }
  
  public final void doResume()
  {
    super.doResume();
    onBackPressed = false;
  }
  
  protected final OnboardingDataProvider getDataProvider()
  {
    return fragmentComponent.activity().activityComponent.onboardingDataProvider();
  }
  
  public final boolean hasValidTextFields()
  {
    return (countryInput != null) && (stateInput != null) && (cityInput != null) && (postalCodeInput != null);
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public final boolean isCitySet()
  {
    return (city != null) && (cityInput != null) && (!TextUtils.isEmpty(cityInput.getText()));
  }
  
  public final boolean isCountrySet()
  {
    return (country != null) && (countryInput != null) && (!TextUtils.isEmpty(countryInput.getText()));
  }
  
  public final boolean isPostalCodeSet()
  {
    return (postalCodeInput != null) && (!TextUtils.isEmpty(postalCodeInput.getText()));
  }
  
  public final boolean isStateSet()
  {
    return (state != null) && (stateInput != null) && (!TextUtils.isEmpty(stateInput.getText()));
  }
  
  @OnClick({2131756116})
  public void launchCityList()
  {
    if (cityInputContainer != null)
    {
      Spinner localSpinner = cityInputContainer.getSpinner();
      if (localSpinner != null) {
        localSpinner.performClick();
      }
    }
  }
  
  @OnClick({2131756110})
  public void launchCountryList()
  {
    if (countryInputContainer != null)
    {
      Spinner localSpinner = countryInputContainer.getSpinner();
      if (localSpinner != null) {
        localSpinner.performClick();
      }
    }
  }
  
  @OnClick({2131756113})
  public void launchStateList()
  {
    if (stateInputContainer != null)
    {
      Spinner localSpinner = stateInputContainer.getSpinner();
      if (localSpinner != null) {
        localSpinner.performClick();
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getParentFragment() instanceof LocationPickerListener))
    {
      parentListener = ((LocationPickerListener)getParentFragment());
      return;
    }
    if ((getActivity() instanceof LocationPickerListener))
    {
      parentListener = ((LocationPickerListener)getActivity());
      return;
    }
    Util.safeThrow$7a8b4789(new IllegalStateException("Parent does not support location picker"));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getString("onboarding_location_country");
      localObject2 = paramBundle.getString("onboarding_location_state");
      str = paramBundle.getString("onboarding_location_city");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = new LocationPickerFragment.1(this, (String)localObject2, str);
        getDataProvider().loadDataModelFromCache((String)localObject1, (DefaultModelListener)localObject2, Country.BUILDER);
      }
      localObject1 = new LocationPickerFragment.2(this);
      getDataProvider().loadDataModelFromCache(getDataProviderstate).countriesRoute, (DefaultModelListener)localObject1, CollectionTemplate.of(Country.BUILDER));
      onBackPressed = paramBundle.getBoolean("onboarding_location_on_back_pressed");
      return;
    }
    paramBundle = getDataProvider();
    Object localObject2 = busSubscriberId;
    String str = getRumSessionId();
    Object localObject1 = Tracker.createPageInstanceHeader(getPageInstance());
    localObject2 = paramBundle.newModelListener((String)localObject2, str);
    activityComponent.dataManager().submit(Request.get().url(state).basicLocationRoute).builder(CollectionTemplate.of(BasicLocation.BUILDER)).listener((RecordTemplateListener)localObject2).customHeaders((Map)localObject1).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968839, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (paramSet == null) {}
    do
    {
      return;
      if ((paramSet.contains(getDataProviderstate).basicLocationRoute)) && (shouldRequestLocationPermission())) {
        requestLocationPermission();
      }
      paramDataManagerException = getDataProviderstate).statesRoute;
      if ((paramType.equals(DataStore.Type.LOCAL)) && (paramSet.contains(paramDataManagerException)) && (country != null)) {
        getDataProvider().fetchStates(country.countryCode, busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), DataManager.DataStoreFilter.NETWORK_ONLY);
      }
      paramDataManagerException = getDataProviderstate).citiesRoute;
    } while ((!paramType.equals(DataStore.Type.LOCAL)) || (!paramSet.contains(paramDataManagerException)) || (country == null) || (state == null));
    getDataProvider().fetchCities(country.countryCode, state.stateCode, busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), DataManager.DataStoreFilter.NETWORK_ONLY);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramSet == null) || (paramMap == null)) {}
    for (;;)
    {
      return;
      paramType = getDataProviderstate).basicLocationRoute;
      if (paramSet.contains(paramType))
      {
        paramType = (DataStoreResponse)paramMap.get(paramType);
        if ((paramType != null) && (model).elements != null) && (!model).elements.isEmpty())) {
          paramType = (BasicLocation)model).elements.get(0);
        }
      }
      try
      {
        setCountry(new Country.Builder().setCountryCode(countryCode).setCountryName(countryName).build(RecordTemplate.Flavor.RECORD));
        if (postalCode != null) {
          setPostalCode(postalCode);
        }
        if (shouldRequestLocationPermission()) {
          requestLocationPermission();
        }
        paramType = getDataProviderstate).statesRoute;
        if (paramSet.contains(paramType))
        {
          paramType = (DataStoreResponse)paramMap.get(paramType);
          if ((paramType != null) && (model).elements != null)) {
            populateStateSpinner(model).elements);
          }
        }
        paramType = getDataProviderstate).citiesRoute;
        if (!paramSet.contains(paramType)) {
          continue;
        }
        paramType = (DataStoreResponse)paramMap.get(paramType);
        if ((paramType == null) || (model).elements == null)) {
          continue;
        }
        populateCitySpinner(model).elements);
        return;
      }
      catch (BuilderException localBuilderException)
      {
        for (;;)
        {
          Util.safeThrow$7a8b4789(new RuntimeException("Failed country validation", localBuilderException));
        }
      }
    }
  }
  
  @OnFocusChange({2131756119})
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (postalCodeInput != null)
    {
      if ((paramBoolean) && (postalCodeInput.length() > 0)) {
        postalCodeInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837933, 0);
      }
    }
    else {
      return;
    }
    postalCodeInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    ArrayList localArrayList = new ArrayList();
    String str;
    if (country != null)
    {
      str = country.countryCode;
      paramBundle.putString("onboarding_location_country", str);
      localArrayList.add(Request.post().url(str).model(country));
    }
    if (state != null)
    {
      str = state.stateCode;
      paramBundle.putString("onboarding_location_state", str);
      localArrayList.add(Request.post().url(str).model(state));
    }
    if (city != null)
    {
      str = city.cityCode;
      paramBundle.putString("onboarding_location_city", str);
      localArrayList.add(Request.post().url(str).model(city));
    }
    paramBundle.putBoolean("onboarding_location_on_back_pressed", onBackPressed);
    getDataProvider().makeParallelCacheRequest(busSubscriberId, getRumSessionId(), localArrayList);
  }
  
  @OnTextChanged(callback=OnTextChanged.Callback.AFTER_TEXT_CHANGED, value={2131756119})
  public void onTextChanged(Editable paramEditable)
  {
    if (postalCodeInput != null)
    {
      if ((postalCodeInput.hasFocus()) && (paramEditable.length() > 0)) {
        postalCodeInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130837933, 0);
      }
    }
    else {
      return;
    }
    postalCodeInput.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }
  
  @OnTouch({2131756119})
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((postalCodeInput != null) && (postalCodeInput.getCompoundDrawables()[2] != null) && (paramMotionEvent.getAction() == 1) && (paramMotionEvent.getRawX() >= postalCodeInput.getRight() - postalCodeInput.getTotalPaddingRight())) {
      postalCodeInput.setText("");
    }
    return false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    JellyBeanMr1Utils.setLabelFor(countryLabel, 2131756110);
    JellyBeanMr1Utils.setLabelFor(stateLabel, 2131756113);
    JellyBeanMr1Utils.setLabelFor(cityLabel, 2131756116);
    JellyBeanMr1Utils.setLabelFor(postalCodeLabel, 2131756119);
    ProfileUtil.setLimit(postalCodeInput, 10);
    postalCodeInput.setOnEditorActionListener(new LocationPickerFragment.3(this, tracker, "continue", new TrackingEventBuilder[0]));
    paramView = (OnboardingDataProvider.OnboardingState)getDataProviderstate;
    paramView = (CollectionTemplate)paramView.getModel(countriesRoute);
    if ((paramView != null) && (elements != null) && (!elements.isEmpty())) {}
    for (paramView = elements;; paramView = null)
    {
      if (paramView != null) {
        populateCountrySpinner(paramView);
      }
      if (onBackPressed)
      {
        if (country != null) {
          setCountry(country);
        }
        if (state != null) {
          setState(state);
        }
        if (city != null) {
          setCity(city);
        }
        publishInputChange();
        if (country != null)
        {
          paramView = getDataProvider().getStates(country.countryCode);
          if (paramView != null) {
            populateStateSpinner(paramView);
          }
        }
        if ((country != null) && (state != null))
        {
          paramView = getDataProvider().getCities(country.countryCode, state.stateCode);
          if (paramView != null) {
            populateCitySpinner(paramView);
          }
        }
      }
      return;
    }
  }
  
  public final String pageKey()
  {
    return "";
  }
  
  @OnTextChanged(callback=OnTextChanged.Callback.AFTER_TEXT_CHANGED, value={2131756110, 2131756113, 2131756116, 2131756119})
  public void publishInputChange()
  {
    if (parentListener != null) {
      parentListener.onLocationPickerUpdate();
    }
  }
  
  final void setCity(City paramCity)
  {
    city = paramCity;
    if (cityInput != null) {
      cityInput.setText(cityName);
    }
  }
  
  public final void setCountry(Country paramCountry)
  {
    country = paramCountry;
    if (countryInput != null) {
      countryInput.setText(countryName);
    }
    if (ProfileUtil.isOnboardingThreeStepCountry(country.countryCode))
    {
      paramCountry = getDataProvider().getStates(country.countryCode);
      if (paramCountry != null) {
        populateStateSpinner(paramCountry);
      }
      for (;;)
      {
        updateFieldVisibility(0, 8, 8);
        return;
        getDataProvider().fetchStates(country.countryCode, busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), DataManager.DataStoreFilter.LOCAL_ONLY);
      }
    }
    if (ProfileUtil.isPostalCodeRequired(country.countryCode))
    {
      setPostalCodeHint(2131231564);
      if ("enabled".equals(lixManager.getTreatment(Lix.GROWTH_POSTAL_CODE_ALPHANUMERIC_KEYBOARD)))
      {
        if (!ProfileUtil.isAlphanumericPostalCodeCountry(country.countryCode)) {
          break label188;
        }
        postalCodeInput.setInputType(112);
      }
    }
    for (;;)
    {
      updateFieldVisibility(8, 8, 0);
      return;
      setPostalCodeHint(2131231565);
      break;
      label188:
      postalCodeInput.setInputType(2);
    }
  }
  
  public final void setPostalCode(String paramString)
  {
    if (postalCodeInput != null) {
      postalCodeInput.setText(paramString);
    }
  }
  
  final void setState(State paramState)
  {
    state = paramState;
    if (stateInput != null) {
      stateInput.setText(stateName);
    }
    paramState = getDataProvider().getCities(country.countryCode, state.stateCode);
    if (paramState != null) {
      populateCitySpinner(paramState);
    }
    for (;;)
    {
      updateFieldVisibility(0, 0, 8);
      return;
      getDataProvider().fetchCities(country.countryCode, state.stateCode, busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), DataManager.DataStoreFilter.LOCAL_ONLY);
    }
  }
  
  public final boolean shouldTrack()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.location.LocationPickerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */