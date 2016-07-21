package com.linkedin.android.growth.onboarding.location;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider.OnboardingState;
import com.linkedin.android.growth.onboarding.base.OnboardingProfileEditFragment;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.gms.GeoLocator;
import com.linkedin.android.infra.gms.GeoLocatorListener;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.KitKatUtils;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.pegasus.gen.voyager.common.Country;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.json.JSONObject;

public class LocationFragment
  extends OnboardingProfileEditFragment
  implements LocationPickerListener
{
  private static final String LOCATION_PICKER_TAG = LocationPickerFragment.class.getSimpleName();
  public static final String TAG = LocationFragment.class.getSimpleName();
  @Inject
  ContentResolver contentResolver;
  @Inject
  GeoLocator geoLocator;
  @Inject
  I18NManager i18nManager;
  LocationPickerFragment locationPickerFragment;
  @Inject
  SnackbarUtil snackbar;
  
  /* Error */
  private JSONObject createLocationDiff()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 46	com/linkedin/android/growth/onboarding/location/LocationFragment:getDataProvider	()Lcom/linkedin/android/growth/onboarding/OnboardingDataProvider;
    //   4: invokevirtual 52	com/linkedin/android/growth/onboarding/OnboardingDataProvider:isProfileAvailable	()Z
    //   7: ifeq +198 -> 205
    //   10: aconst_null
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 54	com/linkedin/android/growth/onboarding/location/LocationFragment:locationPickerFragment	Lcom/linkedin/android/growth/onboarding/location/LocationPickerFragment;
    //   16: invokevirtual 57	com/linkedin/android/growth/onboarding/location/LocationPickerFragment:isCountrySet	()Z
    //   19: ifeq +14 -> 33
    //   22: aload_0
    //   23: getfield 54	com/linkedin/android/growth/onboarding/location/LocationFragment:locationPickerFragment	Lcom/linkedin/android/growth/onboarding/location/LocationPickerFragment;
    //   26: getfield 61	com/linkedin/android/growth/onboarding/location/LocationPickerFragment:country	Lcom/linkedin/android/pegasus/gen/voyager/common/Country;
    //   29: getfield 66	com/linkedin/android/pegasus/gen/voyager/common/Country:countryCode	Ljava/lang/String;
    //   32: astore_2
    //   33: aconst_null
    //   34: astore_1
    //   35: aload_0
    //   36: getfield 54	com/linkedin/android/growth/onboarding/location/LocationFragment:locationPickerFragment	Lcom/linkedin/android/growth/onboarding/location/LocationPickerFragment;
    //   39: invokevirtual 69	com/linkedin/android/growth/onboarding/location/LocationPickerFragment:isPostalCodeSet	()Z
    //   42: ifeq +107 -> 149
    //   45: aload_0
    //   46: getfield 54	com/linkedin/android/growth/onboarding/location/LocationFragment:locationPickerFragment	Lcom/linkedin/android/growth/onboarding/location/LocationPickerFragment;
    //   49: astore_1
    //   50: aload_1
    //   51: getfield 73	com/linkedin/android/growth/onboarding/location/LocationPickerFragment:postalCodeInput	Landroid/widget/EditText;
    //   54: ifnull +89 -> 143
    //   57: aload_1
    //   58: getfield 73	com/linkedin/android/growth/onboarding/location/LocationPickerFragment:postalCodeInput	Landroid/widget/EditText;
    //   61: invokevirtual 79	android/widget/EditText:getText	()Landroid/text/Editable;
    //   64: invokevirtual 84	java/lang/Object:toString	()Ljava/lang/String;
    //   67: astore_1
    //   68: new 86	com/linkedin/android/pegasus/gen/voyager/common/NormBasicLocation$Builder
    //   71: dup
    //   72: invokespecial 87	com/linkedin/android/pegasus/gen/voyager/common/NormBasicLocation$Builder:<init>	()V
    //   75: aload_2
    //   76: invokevirtual 91	com/linkedin/android/pegasus/gen/voyager/common/NormBasicLocation$Builder:setCountryCode	(Ljava/lang/String;)Lcom/linkedin/android/pegasus/gen/voyager/common/NormBasicLocation$Builder;
    //   79: aload_1
    //   80: invokevirtual 94	com/linkedin/android/pegasus/gen/voyager/common/NormBasicLocation$Builder:setPostalCode	(Ljava/lang/String;)Lcom/linkedin/android/pegasus/gen/voyager/common/NormBasicLocation$Builder;
    //   83: getstatic 100	com/linkedin/data/lite/RecordTemplate$Flavor:RECORD	Lcom/linkedin/data/lite/RecordTemplate$Flavor;
    //   86: invokevirtual 104	com/linkedin/android/pegasus/gen/voyager/common/NormBasicLocation$Builder:build	(Lcom/linkedin/data/lite/RecordTemplate$Flavor;)Lcom/linkedin/android/pegasus/gen/voyager/common/NormBasicLocation;
    //   89: astore_1
    //   90: aload_0
    //   91: invokevirtual 46	com/linkedin/android/growth/onboarding/location/LocationFragment:getDataProvider	()Lcom/linkedin/android/growth/onboarding/OnboardingDataProvider;
    //   94: invokevirtual 108	com/linkedin/android/growth/onboarding/OnboardingDataProvider:getProfile	()Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/Profile;
    //   97: invokestatic 114	com/linkedin/android/identity/profile/ProfileModelUtils:toNormProfile	(Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/Profile;)Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/NormProfile;
    //   100: astore_2
    //   101: aload_0
    //   102: aload_2
    //   103: new 116	com/linkedin/android/pegasus/gen/voyager/identity/profile/NormProfile$Builder
    //   106: dup
    //   107: aload_2
    //   108: invokespecial 119	com/linkedin/android/pegasus/gen/voyager/identity/profile/NormProfile$Builder:<init>	(Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/NormProfile;)V
    //   111: new 121	com/linkedin/android/pegasus/gen/voyager/identity/profile/ProfileLocation$Builder
    //   114: dup
    //   115: invokespecial 122	com/linkedin/android/pegasus/gen/voyager/identity/profile/ProfileLocation$Builder:<init>	()V
    //   118: aload_1
    //   119: invokevirtual 126	com/linkedin/android/pegasus/gen/voyager/identity/profile/ProfileLocation$Builder:setBasicLocation	(Lcom/linkedin/android/pegasus/gen/voyager/common/NormBasicLocation;)Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/ProfileLocation$Builder;
    //   122: getstatic 100	com/linkedin/data/lite/RecordTemplate$Flavor:RECORD	Lcom/linkedin/data/lite/RecordTemplate$Flavor;
    //   125: invokevirtual 129	com/linkedin/android/pegasus/gen/voyager/identity/profile/ProfileLocation$Builder:build	(Lcom/linkedin/data/lite/RecordTemplate$Flavor;)Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/ProfileLocation;
    //   128: invokevirtual 133	com/linkedin/android/pegasus/gen/voyager/identity/profile/NormProfile$Builder:setLocation	(Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/ProfileLocation;)Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/NormProfile$Builder;
    //   131: getstatic 100	com/linkedin/data/lite/RecordTemplate$Flavor:RECORD	Lcom/linkedin/data/lite/RecordTemplate$Flavor;
    //   134: invokevirtual 136	com/linkedin/android/pegasus/gen/voyager/identity/profile/NormProfile$Builder:build	(Lcom/linkedin/data/lite/RecordTemplate$Flavor;)Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/NormProfile;
    //   137: invokevirtual 140	com/linkedin/android/growth/onboarding/location/LocationFragment:createProfileDiff	(Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/NormProfile;Lcom/linkedin/android/pegasus/gen/voyager/identity/profile/NormProfile;)Lorg/json/JSONObject;
    //   140: astore_1
    //   141: aload_1
    //   142: areturn
    //   143: ldc -114
    //   145: astore_1
    //   146: goto -78 -> 68
    //   149: aload_0
    //   150: getfield 54	com/linkedin/android/growth/onboarding/location/LocationFragment:locationPickerFragment	Lcom/linkedin/android/growth/onboarding/location/LocationPickerFragment;
    //   153: invokevirtual 145	com/linkedin/android/growth/onboarding/location/LocationPickerFragment:isCitySet	()Z
    //   156: ifeq -88 -> 68
    //   159: aload_0
    //   160: getfield 54	com/linkedin/android/growth/onboarding/location/LocationFragment:locationPickerFragment	Lcom/linkedin/android/growth/onboarding/location/LocationPickerFragment;
    //   163: getfield 149	com/linkedin/android/growth/onboarding/location/LocationPickerFragment:city	Lcom/linkedin/android/pegasus/gen/voyager/common/City;
    //   166: getfield 154	com/linkedin/android/pegasus/gen/voyager/common/City:centralizedPostalCode	Ljava/lang/String;
    //   169: astore_1
    //   170: goto -102 -> 68
    //   173: astore_1
    //   174: new 156	java/lang/IllegalArgumentException
    //   177: dup
    //   178: ldc -98
    //   180: aload_1
    //   181: invokespecial 161	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: invokestatic 167	com/linkedin/android/infra/shared/Util:safeThrow$7a8b4789	(Ljava/lang/RuntimeException;)V
    //   187: aconst_null
    //   188: areturn
    //   189: astore_1
    //   190: new 156	java/lang/IllegalArgumentException
    //   193: dup
    //   194: ldc -87
    //   196: aload_1
    //   197: invokespecial 161	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: invokestatic 167	com/linkedin/android/infra/shared/Util:safeThrow$7a8b4789	(Ljava/lang/RuntimeException;)V
    //   203: aconst_null
    //   204: areturn
    //   205: new 171	java/lang/IllegalStateException
    //   208: dup
    //   209: ldc -83
    //   211: invokespecial 176	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   214: invokestatic 167	com/linkedin/android/infra/shared/Util:safeThrow$7a8b4789	(Ljava/lang/RuntimeException;)V
    //   217: aload_0
    //   218: invokevirtual 46	com/linkedin/android/growth/onboarding/location/LocationFragment:getDataProvider	()Lcom/linkedin/android/growth/onboarding/OnboardingDataProvider;
    //   221: ldc -114
    //   223: aconst_null
    //   224: aload_0
    //   225: invokevirtual 180	com/linkedin/android/growth/onboarding/base/OnboardingProfileEditFragment:getPageInstance	()Lcom/linkedin/android/tracking/v2/event/PageInstance;
    //   228: invokestatic 186	com/linkedin/android/litrackinglib/metric/Tracker:createPageInstanceHeader	(Lcom/linkedin/android/tracking/v2/event/PageInstance;)Ljava/util/Map;
    //   231: invokevirtual 190	com/linkedin/android/growth/onboarding/OnboardingDataProvider:fetchProfile	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   234: aconst_null
    //   235: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	LocationFragment
    //   34	136	1	localObject1	Object
    //   173	8	1	localBuilderException1	com.linkedin.data.lite.BuilderException
    //   189	8	1	localBuilderException2	com.linkedin.data.lite.BuilderException
    //   11	97	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	33	173	com/linkedin/data/lite/BuilderException
    //   35	68	173	com/linkedin/data/lite/BuilderException
    //   68	90	173	com/linkedin/data/lite/BuilderException
    //   149	170	173	com/linkedin/data/lite/BuilderException
    //   90	141	189	com/linkedin/data/lite/BuilderException
  }
  
  private GeoLocatorListener createLocationListener()
  {
    return new LocationFragment.1(this);
  }
  
  private void toggleContinueButtonEnabled()
  {
    continueButton.setEnabled(verifyAllInputsFilled());
  }
  
  public final void doPause()
  {
    super.doPause();
    geoLocator.stop();
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 0)
    {
      if (geoLocator == null) {
        geoLocator = getActivityactivityComponent.geoLocator();
      }
      if (!KitKatUtils.isLocationDisabled(contentResolver)) {
        geoLocator.start(createLocationListener());
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968838, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if ((paramSet != null) && (paramSet.contains(getDataProviderstate).editProfileRoute))) {
      onPostFailed();
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramSet != null) && (paramSet.contains(getDataProviderstate).editProfileRoute))) {
      onPostSuccess();
    }
  }
  
  protected final void onInputError()
  {
    if (!locationPickerFragment.isCountrySet()) {
      showMissingFieldSnackBar(getString(2131231560));
    }
    do
    {
      return;
      if ((ProfileUtil.isPostalCodeRequired(locationPickerFragment.country.countryCode)) && (!locationPickerFragment.isPostalCodeSet()))
      {
        showMissingFieldSnackBar(getString(2131231564));
        return;
      }
      if ((ProfileUtil.isOnboardingThreeStepCountry(locationPickerFragment.country.countryCode)) && (!locationPickerFragment.isStateSet()))
      {
        showMissingFieldSnackBar(getString(2131231570));
        return;
      }
    } while ((!ProfileUtil.isOnboardingThreeStepCountry(locationPickerFragment.country.countryCode)) || (locationPickerFragment.isCitySet()));
    showMissingFieldSnackBar(getString(2131231559));
  }
  
  public final void onLocationPickerSubmit()
  {
    verifyInputsAndPostData();
  }
  
  public final void onLocationPickerUpdate()
  {
    toggleContinueButtonEnabled();
  }
  
  protected final void onPostFailed()
  {
    Snackbar localSnackbar = snackbar.make(2131231509, 0);
    if (localSnackbar != null) {
      localSnackbar.show();
    }
  }
  
  protected final void onPostSuccess()
  {
    Snackbar localSnackbar = snackbar.make(2131231573, 0);
    if (localSnackbar != null) {
      localSnackbar.show();
    }
    legoWidget.finishCurrentFragment();
  }
  
  public final void onRequestPermissionsResult(Set<String> paramSet1, Set<String> paramSet2)
  {
    super.onRequestPermissionsResult(paramSet1, paramSet2);
    if (paramSet2.isEmpty()) {
      geoLocator.start(createLocationListener());
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    skipButton.setEnabled(true);
    skipButton.setVisibility(0);
    if ((paramBundle == null) && (locationPickerFragment == null))
    {
      locationPickerFragment = new LocationPickerFragment();
      getChildFragmentManager().beginTransaction().replace(2131756108, locationPickerFragment, LOCATION_PICKER_TAG).commit();
    }
    for (;;)
    {
      toggleContinueButtonEnabled();
      return;
      locationPickerFragment = ((LocationPickerFragment)getChildFragmentManager().findFragmentByTag(LOCATION_PICKER_TAG));
    }
  }
  
  public final String pageKey()
  {
    return "onboarding_location";
  }
  
  protected final void postData()
  {
    JSONObject localJSONObject = createLocationDiff();
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
  
  protected final boolean verifyAllInputsFilled()
  {
    Country localCountry = locationPickerFragment.country;
    if (localCountry != null)
    {
      if (ProfileUtil.isOnboardingThreeStepCountry(countryCode)) {
        if ((!locationPickerFragment.isCountrySet()) || (!locationPickerFragment.isStateSet()) || (!locationPickerFragment.isCitySet())) {}
      }
      while ((locationPickerFragment.isCountrySet()) && ((!ProfileUtil.isPostalCodeRequired(countryCode)) || (locationPickerFragment.isPostalCodeSet())))
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.location.LocationFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */