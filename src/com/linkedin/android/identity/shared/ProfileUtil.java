package com.linkedin.android.identity.shared;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.MediaFilter;
import com.linkedin.android.infra.shared.DateUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.City;
import com.linkedin.android.pegasus.gen.voyager.common.Country;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.State;
import com.linkedin.android.pegasus.gen.voyager.identity.VolunteerCause;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Contributor;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Education;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.IMProvider;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PhoneNumberType;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Position;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.WebsiteCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public final class ProfileUtil
{
  private static final IMProvider[] IM_PROVIDERS_UI_INDEXED_ARRAY;
  private static final PhoneNumberType[] PHONE_NUMBER_TYPES_SPINNER_INDEXED_ARRAY;
  private static final WebsiteCategory[] WEBSITE_CATEGORIES_SPINNER_VALUE_ARRAY;
  @Inject
  public I18NManager i18NManager;
  @Inject
  MemberUtil memberUtil;
  
  static
  {
    int k = 0;
    Object localObject1 = new WebsiteCategory[WebsiteCategory.values().length];
    WEBSITE_CATEGORIES_SPINNER_VALUE_ARRAY = (WebsiteCategory[])localObject1;
    localObject1[0] = WebsiteCategory.$UNKNOWN;
    localObject1 = WebsiteCategory.values();
    int n = localObject1.length;
    int j = 0;
    int i = 1;
    Object localObject2;
    Object localObject3;
    int m;
    if (j < n)
    {
      localObject2 = localObject1[j];
      if (localObject2 == WebsiteCategory.$UNKNOWN) {
        break label244;
      }
      localObject3 = WEBSITE_CATEGORIES_SPINNER_VALUE_ARRAY;
      m = i + 1;
      localObject3[i] = localObject2;
      i = m;
    }
    label238:
    label241:
    label244:
    for (;;)
    {
      j += 1;
      break;
      localObject1 = new IMProvider[IMProvider.values().length];
      IM_PROVIDERS_UI_INDEXED_ARRAY = (IMProvider[])localObject1;
      localObject1[0] = IMProvider.$UNKNOWN;
      localObject1 = IMProvider.values();
      n = localObject1.length;
      j = 0;
      i = 1;
      if (j < n)
      {
        localObject2 = localObject1[j];
        if (localObject2 == IMProvider.$UNKNOWN) {
          break label241;
        }
        localObject3 = IM_PROVIDERS_UI_INDEXED_ARRAY;
        m = i + 1;
        localObject3[i] = localObject2;
        i = m;
      }
      for (;;)
      {
        j += 1;
        break;
        localObject1 = new PhoneNumberType[PhoneNumberType.values().length];
        PHONE_NUMBER_TYPES_SPINNER_INDEXED_ARRAY = (PhoneNumberType[])localObject1;
        localObject1[0] = PhoneNumberType.$UNKNOWN;
        localObject1 = PhoneNumberType.values();
        m = localObject1.length;
        i = 1;
        j = k;
        if (j < m)
        {
          localObject2 = localObject1[j];
          if (localObject2 == PhoneNumberType.$UNKNOWN) {
            break label238;
          }
          localObject3 = PHONE_NUMBER_TYPES_SPINNER_INDEXED_ARRAY;
          k = i + 1;
          localObject3[i] = localObject2;
          i = k;
        }
        for (;;)
        {
          j += 1;
          break;
          return;
        }
      }
    }
  }
  
  public static Bitmap adjustOpacity$161932a8(Bitmap paramBitmap)
  {
    if (paramBitmap.isMutable()) {}
    for (;;)
    {
      new Canvas(paramBitmap).drawColor(637534208, PorterDuff.Mode.DST_IN);
      return paramBitmap;
      paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    }
  }
  
  private static boolean checkCountryCodePresent(String paramString, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    paramString = paramString.toLowerCase(Locale.US);
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramString.equals(paramArrayOfString[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static int getCityPositionByName(List<City> paramList, String paramString)
  {
    int i = 0;
    while (i < paramList.size())
    {
      City localCity = (City)paramList.get(i);
      if ((cityName.endsWith(paramString)) || (cityName.startsWith(paramString))) {
        return i;
      }
      i += 1;
    }
    return paramList.size() - 1;
  }
  
  public static int getCityPositionByUrn(List<City> paramList, String paramString)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (paramString.equals(getentityUrn.toString())) {
        return i;
      }
      i += 1;
    }
    return paramList.size() - 1;
  }
  
  public static int getCountryPosition(List<Country> paramList, String paramString)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      Country localCountry = (Country)paramList.get(i);
      if (!localHashMap.containsKey(countryCode)) {
        localHashMap.put(countryCode, Integer.valueOf(i));
      }
      i += 1;
    }
    if (localHashMap.containsKey(paramString)) {
      return ((Integer)localHashMap.get(paramString)).intValue();
    }
    return -1;
  }
  
  public static String getDateString(Date paramDate, I18NManager paramI18NManager)
  {
    return paramI18NManager.getString(2131232377, new Object[] { Long.valueOf(DateUtils.getTimeStampInMillis(paramDate)), Boolean.valueOf(hasMonth) });
  }
  
  public static Urn getDummyMockUrn()
  {
    return Urn.createFromTuple("mockEntity", new Object[] { "-1" });
  }
  
  public static CustomArrayAdapter getEmptyAdapterWithHint(Context paramContext, String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramString);
    paramContext = new CustomArrayAdapter(paramContext, localArrayList);
    paramContext.setDropDownViewResource(17367049);
    return paramContext;
  }
  
  public static String getFormattedUrl(String paramString)
  {
    if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://"))) {
      return "http://" + paramString;
    }
    return paramString;
  }
  
  public static IMProvider getIMProviderBySpinnerIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < IM_PROVIDERS_UI_INDEXED_ARRAY.length)) {
      return IM_PROVIDERS_UI_INDEXED_ARRAY[paramInt];
    }
    return IMProvider.$UNKNOWN;
  }
  
  public static int getIMProviderSpinnerIndex(IMProvider paramIMProvider)
  {
    return Arrays.asList(IM_PROVIDERS_UI_INDEXED_ARRAY).indexOf(paramIMProvider);
  }
  
  public static Urn getMockUrn()
  {
    return Urn.createFromTuple("mockEntity", new Object[] { "-1" });
  }
  
  public static ArrayAdapter<CharSequence> getMonthArrayAdapter(Context paramContext)
  {
    paramContext = ArrayAdapter.createFromResource(paramContext, 2131296256, 17367048);
    paramContext.setDropDownViewResource(17367049);
    return paramContext;
  }
  
  public static String getMonthDayDateString(Date paramDate, I18NManager paramI18NManager)
  {
    return paramI18NManager.getString(2131232378, new Object[] { Long.valueOf(DateUtils.getTimeStampInMillis(paramDate)) });
  }
  
  public static PhoneNumberType getPhoneNumberTypeBySpinnerIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < PHONE_NUMBER_TYPES_SPINNER_INDEXED_ARRAY.length)) {
      return PHONE_NUMBER_TYPES_SPINNER_INDEXED_ARRAY[paramInt];
    }
    return PhoneNumberType.$UNKNOWN;
  }
  
  public static int getPhoneNumberTypeIndex(PhoneNumberType paramPhoneNumberType)
  {
    return Arrays.asList(PHONE_NUMBER_TYPES_SPINNER_INDEXED_ARRAY).indexOf(paramPhoneNumberType);
  }
  
  public static JSONObject getPositionEducationReorderingObject$2a0651e3(String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramString1 != null) {}
    try
    {
      localJSONObject.put("urnOfPositionToMove", paramString1);
      localJSONObject.put("toIndexPosition", 0L);
      if (paramString2 != null)
      {
        localJSONObject.put("urnOfEducationToMove", paramString2);
        localJSONObject.put("toIndexEducation", 0L);
      }
      return localJSONObject;
    }
    catch (JSONException paramString1) {}
    return null;
  }
  
  public static String getStateCodeFromCityUrn(Urn paramUrn)
  {
    return paramUrn.getLastId().split("-")[0];
  }
  
  public static int getStatePositionByCode(List<State> paramList, String paramString)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      State localState = (State)paramList.get(i);
      if (!localHashMap.containsKey(stateCode)) {
        localHashMap.put(stateCode, Integer.valueOf(i));
      }
      i += 1;
    }
    if (localHashMap.containsKey(paramString)) {
      return ((Integer)localHashMap.get(paramString)).intValue();
    }
    return -1;
  }
  
  public static int getStatePositionByName(List<State> paramList, String paramString)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramList.size())
    {
      State localState = (State)paramList.get(i);
      if (!localHashMap.containsKey(stateName)) {
        localHashMap.put(stateName, Integer.valueOf(i));
      }
      i += 1;
    }
    if (localHashMap.containsKey(paramString)) {
      return ((Integer)localHashMap.get(paramString)).intValue();
    }
    return -1;
  }
  
  public static int getVolunteerCauseResourceId(Context paramContext, VolunteerCause paramVolunteerCause)
  {
    return paramContext.getResources().getIdentifier("identity_profile_volunteer_cause_" + paramVolunteerCause.name(), "string", paramContext.getPackageName());
  }
  
  public static WebsiteCategory getWebsiteCategoryBySpinnerIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < WEBSITE_CATEGORIES_SPINNER_VALUE_ARRAY.length)) {
      return WEBSITE_CATEGORIES_SPINNER_VALUE_ARRAY[paramInt];
    }
    return WebsiteCategory.$UNKNOWN;
  }
  
  public static int getWebsiteCategorySpinnerIndex(WebsiteCategory paramWebsiteCategory)
  {
    return Arrays.asList(WEBSITE_CATEGORIES_SPINNER_VALUE_ARRAY).indexOf(paramWebsiteCategory);
  }
  
  public static boolean isAlphanumericPostalCodeCountry(String paramString)
  {
    return checkCountryCodePresent(paramString, FieldConstants.ALPHANUMERIC_POSTAL_CODE_COUNTRIES);
  }
  
  public static boolean isOnboardingThreeStepCountry(String paramString)
  {
    return checkCountryCodePresent(paramString, FieldConstants.ONBOARDING_THREE_STEP_COUNTRIES);
  }
  
  public static boolean isPostalCodeRequired(String paramString)
  {
    return checkCountryCodePresent(paramString, FieldConstants.POSTAL_CODE_REQUIRED_COUNTRIES);
  }
  
  public static boolean isThreeStepCountry(String paramString)
  {
    return checkCountryCodePresent(paramString, FieldConstants.THREE_STEP_COUNTRIES);
  }
  
  public static boolean isTwoStepCountry(String paramString)
  {
    return checkCountryCodePresent(paramString, FieldConstants.TWO_STEP_COUNTRIES);
  }
  
  public static void sendCustomShortPressTrackingEvent(String paramString, FragmentComponent paramFragmentComponent)
  {
    sendCustomTrackingEvent(paramString, InteractionType.SHORT_PRESS, paramFragmentComponent);
  }
  
  public static void sendCustomTrackingEvent(String paramString, InteractionType paramInteractionType, FragmentComponent paramFragmentComponent)
  {
    new ControlInteractionEvent(paramFragmentComponent.tracker(), paramString, ControlType.BUTTON, paramInteractionType).send();
  }
  
  public static void setLimit(EditText paramEditText, int paramInt)
  {
    paramEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
  }
  
  public static void setLimit(List<EditText> paramList, int paramInt)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((EditText)paramList.next()).setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInt) });
    }
  }
  
  public static void setProfileBackgroundImage$650b3508(Image paramImage, ImageView paramImageView, MediaCenter paramMediaCenter)
  {
    if (paramImage == null)
    {
      paramImageView.setImageResource(2130838697);
      return;
    }
    if (urlValue != null) {}
    for (paramImage = paramMediaCenter.loadUrl(urlValue);; paramImage = paramMediaCenter.load(paramImage, MediaFilter.ORIGINAL))
    {
      paramImage.error(2130838697).into(paramImageView);
      return;
    }
  }
  
  public static String truncate(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > paramInt) {
        str = paramString.substring(0, paramInt);
      }
    }
    return str;
  }
  
  public final String getDateRangeString(DateRange paramDateRange)
  {
    if (paramDateRange != null)
    {
      Date localDate = startDate;
      paramDateRange = endDate;
      if (localDate == null) {}
      for (long l1 = 0L; paramDateRange == null; l1 = DateUtils.getTimeStampInMillis(localDate)) {
        return i18NManager.getString(2131232288, new Object[] { Long.valueOf(l1) });
      }
      long l2 = DateUtils.getTimeStampInMillis(paramDateRange);
      return i18NManager.getString(2131232289, new Object[] { Long.valueOf(l1), Long.valueOf(l2) });
    }
    return "";
  }
  
  public final String getDateString(Date paramDate)
  {
    return getDateString(paramDate, i18NManager);
  }
  
  public final String getDisplayNameString(Contributor paramContributor)
  {
    if (hasName) {
      return name;
    }
    if (!hasMember) {
      return "unknown member";
    }
    return getDisplayNameString(member);
  }
  
  public final String getDisplayNameString(MiniProfile paramMiniProfile)
  {
    return i18NManager.getString(2131233236, new Object[] { I18NManager.getName(paramMiniProfile) });
  }
  
  public final String getFullOccupationString(Education paramEducation)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i18NManager.getString(2131232635, new Object[] { schoolName }));
    if ((hasDegreeName) || (hasFieldOfStudy)) {
      localStringBuilder.append(",");
    }
    if (hasDegreeName)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(degreeName);
    }
    if (hasFieldOfStudy)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(fieldOfStudy);
    }
    return localStringBuilder.toString();
  }
  
  public final CustomArrayAdapter<CharSequence> getIMTypesAdapter(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList(IMProvider.values().length);
    IMProvider[] arrayOfIMProvider = IM_PROVIDERS_UI_INDEXED_ARRAY;
    int j = arrayOfIMProvider.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfIMProvider[i];
      I18NManager localI18NManager = i18NManager;
      switch (ProfileUtil.4.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$identity$profile$IMProvider[localObject.ordinal()])
      {
      default: 
        localObject = "";
      }
      for (;;)
      {
        localArrayList.add(localObject);
        i += 1;
        break;
        localObject = localI18NManager.getString(2131232612);
        continue;
        localObject = localI18NManager.getString(2131232616);
        continue;
        localObject = localI18NManager.getString(2131232618);
        continue;
        localObject = localI18NManager.getString(2131232619);
        continue;
        localObject = localI18NManager.getString(2131232614);
        continue;
        localObject = localI18NManager.getString(2131232613);
        continue;
        localObject = localI18NManager.getString(2131232615);
        continue;
        localObject = localI18NManager.getString(2131232617);
      }
    }
    paramContext = new CustomArrayAdapter(paramContext, localArrayList);
    paramContext.setDropDownViewResource(17367049);
    return paramContext;
  }
  
  public final Urn getMockCompoundUrn(String paramString)
  {
    return Urn.createFromTuple(paramString, new Object[] { memberUtil.getProfileId(), "-1" });
  }
  
  public final Urn getMockCompoundUrn(String paramString1, String paramString2)
  {
    return Urn.createFromTuple(paramString1, new Object[] { memberUtil.getProfileId(), paramString2, "-1" });
  }
  
  public final String getMonthDayYearDateString(Date paramDate)
  {
    return i18NManager.getString(2131232379, new Object[] { Long.valueOf(DateUtils.getTimeStampInMillis(paramDate)) });
  }
  
  public final String getOccupationString(Position paramPosition)
  {
    return i18NManager.getString(2131232636, new Object[] { title, companyName });
  }
  
  public final CustomArrayAdapter<CharSequence> getPhoneNumberTypesAdapter(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList(PhoneNumberType.values().length);
    PhoneNumberType[] arrayOfPhoneNumberType = PHONE_NUMBER_TYPES_SPINNER_INDEXED_ARRAY;
    int j = arrayOfPhoneNumberType.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfPhoneNumberType[i];
      I18NManager localI18NManager = i18NManager;
      switch (ProfileUtil.4.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$identity$profile$PhoneNumberType[localObject.ordinal()])
      {
      default: 
        localObject = "";
      }
      for (;;)
      {
        localArrayList.add(localObject);
        i += 1;
        break;
        localObject = localI18NManager.getString(2131232649);
        continue;
        localObject = localI18NManager.getString(2131232646);
        continue;
        localObject = localI18NManager.getString(2131232647);
        continue;
        localObject = localI18NManager.getString(2131232645);
        continue;
        localObject = localI18NManager.getString(2131232648);
      }
    }
    paramContext = new CustomArrayAdapter(paramContext, localArrayList);
    paramContext.setDropDownViewResource(17367049);
    return paramContext;
  }
  
  public final CustomArrayAdapter<CharSequence> getWebsiteTypesAdapter(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList(WebsiteCategory.values().length);
    WebsiteCategory[] arrayOfWebsiteCategory = WEBSITE_CATEGORIES_SPINNER_VALUE_ARRAY;
    int j = arrayOfWebsiteCategory.length;
    int i = 0;
    if (i < j)
    {
      Object localObject = arrayOfWebsiteCategory[i];
      I18NManager localI18NManager = i18NManager;
      switch (ProfileUtil.4.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$identity$profile$WebsiteCategory[localObject.ordinal()])
      {
      default: 
        localObject = "";
      }
      for (;;)
      {
        localArrayList.add(localObject);
        i += 1;
        break;
        localObject = localI18NManager.getString(2131232747);
        continue;
        localObject = localI18NManager.getString(2131232745);
        continue;
        localObject = localI18NManager.getString(2131232744);
        continue;
        localObject = localI18NManager.getString(2131232749);
        continue;
        localObject = localI18NManager.getString(2131232748);
        continue;
        localObject = localI18NManager.getString(2131232746);
      }
    }
    paramContext = new CustomArrayAdapter(paramContext, localArrayList);
    paramContext.setDropDownViewResource(17367049);
    return paramContext;
  }
  
  public final void scrollToView(Activity paramActivity, ScrollView paramScrollView, View paramView)
  {
    if (paramScrollView != null) {
      paramView.getViewTreeObserver().addOnGlobalLayoutListener(new ProfileUtil.3(this, paramView, paramActivity, paramScrollView));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.shared.ProfileUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */