package com.linkedin.android.identity.edit;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.identity.edit.premiumSettings.PrivacySettingsHelper;
import com.linkedin.android.identity.edit.premiumSettings.PrivacySettingsHelper.OnPrivacySettingsChangedListener;
import com.linkedin.android.identity.edit.topcard.TopCardTransformer;
import com.linkedin.android.identity.edit.topcard.TopCardViewHolder;
import com.linkedin.android.identity.edit.topcard.TopCardViewModel;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileModelUtils;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.shared.LocationHelper;
import com.linkedin.android.identity.shared.OccupationArrayAdapter;
import com.linkedin.android.identity.shared.ProfilePictureSelectDialogFragment.OnUserSelectionListener;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.identity.shared.SizeLimitWatcher;
import com.linkedin.android.identity.shared.multilistenerwidget.MultiListenerSpinner;
import com.linkedin.android.identity.shared.multilistenerwidget.VisibilityListenerRadioGroup;
import com.linkedin.android.identity.shared.validators.forms.BaseFormValidator;
import com.linkedin.android.identity.shared.validators.forms.BasicInfoValidator;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.PhotoUtils;
import com.linkedin.android.infra.shared.PhotoUtils.UriListener;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.CustomTextInputLayout;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Locale;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.common.Industry;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Education;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.MemberBadges.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Position;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PrivacySettings;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileLocation.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileView;
import com.linkedin.android.search.resourcelist.ResourceListBundleBuilder;
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
import java.util.Set;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileBasicInfoEditFragment
  extends ProfileEditBaseFragment
  implements PrivacySettingsHelper.OnPrivacySettingsChangedListener, ProfilePictureSelectDialogFragment.OnUserSelectionListener, PhotoUtils.UriListener
{
  private static final String TAG = ProfileBasicInfoEditFragment.class.getSimpleName();
  @InjectView(2131757320)
  Button addNewEducationButton;
  @InjectView(2131757321)
  EditText addNewEducationEditText;
  @InjectView(2131757322)
  ImageView addNewEducationEditTextPlus;
  @InjectView(2131757315)
  Button addNewPositionButton;
  @InjectView(2131757316)
  EditText addNewPositionEditText;
  @InjectView(2131757317)
  ImageView addNewPositionEditTextPlus;
  @InjectView(2131757331)
  RadioButton cityButton;
  @InjectView(2131757328)
  MultiListenerSpinner citySpinner;
  @InjectView(2131757324)
  MultiListenerSpinner countrySpinner;
  private int currentPositionCount = -1;
  private List<Position> currentPositions;
  private OccupationArrayAdapter educationArrayAdapter;
  private int educationCount = -1;
  private List<Education> educations;
  @InjectView(2131757560)
  TextInputLayout firstNameTextLayout;
  @InjectView(2131757306)
  ScrollView formScrollView;
  @InjectView(2131757337)
  TextInputLayout headlineTextLayout;
  @Inject
  I18NManager i18nManager;
  @InjectView(2131757335)
  TextInputLayout industryTextLayout;
  private ProfileBasicInfoEditBundleBuilder.Focus initialFocus;
  @InjectView(2131757561)
  TextInputLayout lastNameTextLayout;
  @InjectView(2131757333)
  TextView locationErrorView;
  private LocationHelper locationHelper;
  @InjectView(2131757323)
  LinearLayout locationSection;
  @InjectView(2131757329)
  TextView locationsThisAreaView;
  private NormProfile modifiedNormProfile;
  @InjectView(2131757318)
  TextView orderEducationLabelText;
  @InjectView(2131757319)
  MultiListenerSpinner orderEducationSpinner;
  @InjectView(2131757313)
  TextView orderPositionLabelText;
  @InjectView(2131757314)
  MultiListenerSpinner orderPositionSpinner;
  private Uri photoUri;
  @Inject
  PhotoUtils photoUtil;
  private OccupationArrayAdapter positionArrayAdapter;
  @InjectView(2131757311)
  RelativeLayout premiumSettingLayout;
  private PrivacySettingsHelper privacySettingsHelper;
  @InjectView(2131757307)
  LinearLayout profilePicViewSection;
  @Inject
  ProfileUtil profileUtil;
  @InjectView(2131757332)
  RadioButton regionButton;
  @InjectView(2131757330)
  VisibilityListenerRadioGroup regionSection;
  private boolean showPrivacySettings;
  @InjectView(2131757327)
  MultiListenerSpinner stateSpinner;
  @InjectView(2131757344)
  TextView summaryChars;
  @InjectView(2131757343)
  TextView summaryExceedLimit;
  @InjectView(2131757340)
  TextInputLayout summaryTextLayout;
  @InjectView(2131757334)
  Button useCurrentLocationButton;
  private BasicInfoValidator validator;
  private TopCardViewHolder viewHolder;
  private TopCardViewModel viewModel;
  @InjectView(2131757325)
  TextInputLayout zipEditTextLayout;
  
  private boolean arePrivacySettingsChanged()
  {
    if ((showPrivacySettings) && (privacySettingsHelper != null))
    {
      PrivacySettingsHelper localPrivacySettingsHelper = privacySettingsHelper;
      if ((privacySettings != null) && ((allowOpenProfile != privacySettings.allowOpenProfile) || (showPremiumSubscriberBadge != privacySettings.showPremiumSubscriberBadge))) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
    return false;
  }
  
  private boolean fullUpdateTopCard()
    throws BuilderException
  {
    Object localObject3 = null;
    Urn localUrn2;
    Urn localUrn1;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localObject1 = localJSONObject;
      if (orderPositionSpinner == null) {
        break label326;
      }
      localObject1 = localJSONObject;
      if (orderEducationSpinner == null) {
        break label326;
      }
      int i = orderPositionSpinner.getSelectedItemPosition();
      int j = orderEducationSpinner.getSelectedItemPosition();
      if (i <= 0)
      {
        localObject1 = localJSONObject;
        if (j <= 0) {
          break label326;
        }
      }
      localObject1 = localJSONObject;
      if (positionArrayAdapter == null) {
        break label326;
      }
      localObject1 = localJSONObject;
      if (educationArrayAdapter == null) {
        break label326;
      }
      localUrn2 = positionArrayAdapter.getOccupationUrn(i);
      localUrn1 = educationArrayAdapter.getOccupationUrn(j);
      if (localUrn2 != null) {
        break label311;
      }
      localObject1 = localJSONObject;
      if (localUrn1 == null) {
        break label326;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject1;
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Failed to generate diff for update: " + localJSONException.getMessage()));
    }
    localObject1 = ProfileUtil.getPositionEducationReorderingObject$2a0651e3((String)localObject1, (String)localObject3);
    for (;;)
    {
      label125:
      localObject3 = PegasusPatchGenerator.modelToJSON(getFormNormProfile());
      if (localObject3 != null) {
        ((JSONObject)localObject1).put("updatedProfile", localObject3);
      }
      if (((JSONObject)localObject1).length() > 0)
      {
        ((JSONObject)localObject1).put("versionTag", getDataProvider().getProfileVersionTag());
        ((JSONObject)localObject1).put("masterProfilePhotoSignature", getDataProvider().getMasterImageUploadSignature());
        ((JSONObject)localObject1).put("croppedProfilePhotoSignature", getDataProvider().getCroppedImageUploadSignature());
        setDidUpdate$1385ff();
        localObject1 = new JsonModel((JSONObject)localObject1);
        getDataProvider().postUpdateTopCard(busSubscriberId, getRumSessionId(), getProfileId(), (JsonModel)localObject1, Tracker.createPageInstanceHeader(getPageInstance()));
        return true;
        label243:
        localObject1 = localUrn2.toString();
        break label318;
        label252:
        localObject3 = localUrn1.toString();
        break;
      }
      label311:
      Object localObject2;
      label318:
      label326:
      do
      {
        localObject1 = new JSONObject();
        break label125;
        return false;
        if (localUrn2 != null) {
          break label243;
        }
        localObject2 = null;
        if (localUrn1 != null) {
          break label252;
        }
        break;
      } while (localObject2 == null);
    }
  }
  
  private List<Position> getCurrentPositions()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = getDataProvider().getPositionsForBackgroundDetail();
    if (localObject != null)
    {
      localObject = elements;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Position localPosition = (Position)((Iterator)localObject).next();
          if ((hasTimePeriod) && (!timePeriod.hasEndDate)) {
            localArrayList.add(localPosition);
          }
        }
      }
    }
    return localArrayList;
  }
  
  private NormProfile getFormNormProfile()
    throws BuilderException
  {
    NormProfile localNormProfile = null;
    if (getProfile() != null) {
      localNormProfile = ProfileModelUtils.toNormProfile(getProfile());
    }
    Object localObject = localNormProfile;
    if (localNormProfile != null)
    {
      localObject = new NormProfile.Builder(localNormProfile);
      populateNormProfileFields((NormProfile.Builder)localObject, localNormProfile);
      localObject = ((NormProfile.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
    }
    return (NormProfile)localObject;
  }
  
  private boolean isEducationOrderChanged()
  {
    boolean bool = false;
    int j;
    int i;
    if ((educationCount != -1) && (educationArrayAdapter != null) && (educationArrayAdapter.getCount() != educationCount))
    {
      j = 1;
      i = 0;
      if (orderEducationSpinner != null)
      {
        if ((educations == null) || (educations.size() <= 0)) {
          break label96;
        }
        if (orderEducationSpinner.getSelectedItemPosition() <= 1) {
          break label91;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if ((j != 0) || (i != 0)) {
        bool = true;
      }
      return bool;
      j = 0;
      break;
      label91:
      i = 0;
      continue;
      label96:
      if (orderEducationSpinner.getSelectedItemPosition() > 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  private boolean isPositionOrderChanged()
  {
    boolean bool = false;
    int j;
    int i;
    if ((currentPositionCount != -1) && (positionArrayAdapter != null) && (positionArrayAdapter.getCount() != currentPositionCount))
    {
      j = 1;
      i = 0;
      if (orderPositionSpinner != null)
      {
        if ((currentPositions == null) || (currentPositions.size() <= 0)) {
          break label96;
        }
        if (orderPositionSpinner.getSelectedItemPosition() <= 1) {
          break label91;
        }
        i = 1;
      }
    }
    for (;;)
    {
      if ((j != 0) || (i != 0)) {
        bool = true;
      }
      return bool;
      j = 0;
      break;
      label91:
      i = 0;
      continue;
      label96:
      if (orderPositionSpinner.getSelectedItemPosition() > 0) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public static ProfileBasicInfoEditFragment newInstance(ProfileBasicInfoEditBundleBuilder paramProfileBasicInfoEditBundleBuilder)
  {
    ProfileBasicInfoEditFragment localProfileBasicInfoEditFragment = new ProfileBasicInfoEditFragment();
    localProfileBasicInfoEditFragment.setArguments(paramProfileBasicInfoEditBundleBuilder.build());
    return localProfileBasicInfoEditFragment;
  }
  
  private boolean partialUpdateTopCard()
    throws BuilderException
  {
    for (;;)
    {
      try
      {
        localObject1 = ProfileModelUtils.toNormProfile(getProfile());
        Object localObject3 = getFormNormProfile();
        Object localObject4 = PegasusPatchGenerator.INSTANCE.diff((RecordTemplate)localObject1, (RecordTemplate)localObject3);
        localObject1 = null;
        JsonModel localJsonModel = null;
        localObject3 = localObject1;
        int i;
        if (orderEducationSpinner != null)
        {
          localObject3 = localObject1;
          if (isEducationOrderChanged())
          {
            i = orderEducationSpinner.getSelectedItemPosition();
            localObject3 = localObject1;
            if (i > 0)
            {
              localObject3 = localObject1;
              if (educationArrayAdapter != null) {
                localObject3 = educationArrayAdapter.getOccupationUrn(i);
              }
            }
          }
        }
        localObject1 = localJsonModel;
        if (orderPositionSpinner != null)
        {
          localObject1 = localJsonModel;
          if (isPositionOrderChanged())
          {
            i = orderPositionSpinner.getSelectedItemPosition();
            localObject1 = localJsonModel;
            if (i > 0)
            {
              localObject1 = localJsonModel;
              if (positionArrayAdapter != null) {
                localObject1 = positionArrayAdapter.getOccupationUrn(i);
              }
            }
          }
        }
        if ((((JSONObject)localObject4).length() <= 0) && (!isEducationOrderChanged()) && (!isPositionOrderChanged())) {
          break label303;
        }
        setDidUpdate$1385ff();
        localJsonModel = new JsonModel((JSONObject)localObject4);
        localObject4 = getDataProvider();
        String str1 = busSubscriberId;
        String str2 = getRumSessionId();
        String str3 = getProfileId();
        String str4 = getDataProvider().getProfileVersionTag();
        if (localObject3 == null)
        {
          localObject3 = null;
          break label305;
          ((ProfileDataProvider)localObject4).postPartialUpdateTopCard(str1, str2, str3, localJsonModel, str4, (String)localObject3, (String)localObject1, getDataProvider().getMasterImageUploadSignature(), getDataProvider().getCroppedImageUploadSignature(), Tracker.createPageInstanceHeader(getPageInstance()));
          return true;
        }
        else
        {
          localObject3 = ((Urn)localObject3).toString();
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("Failed to generate diff for update: " + localJSONException.getMessage()));
      }
      localObject1 = ((Urn)localObject1).toString();
      continue;
      label303:
      return false;
      label305:
      if (localJSONException == null) {
        Object localObject2 = null;
      }
    }
  }
  
  private void populateNormProfileFields(NormProfile.Builder paramBuilder, NormProfile paramNormProfile)
    throws BuilderException
  {
    paramBuilder.setFirstName(viewHolder.firstNameEdit.getText().toString());
    paramBuilder.setLastName(viewHolder.lastNameEdit.getText().toString());
    paramBuilder.setSummary(viewHolder.summaryEdit.getText().toString());
    paramBuilder.setHeadline(viewHolder.headlineEdit.getText().toString());
    if (modifiedNormProfile != null)
    {
      if (modifiedNormProfile.hasPictureInfo) {
        paramBuilder.setPictureInfo(modifiedNormProfile.pictureInfo);
      }
      if (modifiedNormProfile.hasBackgroundImage) {
        paramBuilder.setBackgroundImage(modifiedNormProfile.backgroundImage);
      }
    }
    Object localObject;
    if (location != null)
    {
      localObject = new ProfileLocation.Builder(location);
      if (locationHelper != null) {
        locationHelper.setLocation((ProfileLocation.Builder)localObject);
      }
      paramBuilder.setLocation(((ProfileLocation.Builder)localObject).build(RecordTemplate.Flavor.RECORD));
    }
    if (viewHolder.industryEditLayout.getVisibility() == 0)
    {
      localObject = viewHolder.industryEdit.getTag();
      if ((localObject instanceof Urn)) {
        paramBuilder.setIndustryUrn((Urn)localObject);
      }
      if ((hasIndustryName) || (viewHolder.industryEdit.getText().length() > 0)) {
        paramBuilder.setIndustryName(viewHolder.industryEdit.getText().toString());
      }
    }
    if (viewHolder.phoneticFirstNameEditLayout.getVisibility() != 8) {
      paramBuilder.setPhoneticFirstName(viewHolder.phoneticFirstNameEdit.getText().toString());
    }
    if (viewHolder.phoneticLastNameEditLayout.getVisibility() != 8) {
      paramBuilder.setPhoneticLastName(viewHolder.phoneticLastNameEdit.getText().toString());
    }
  }
  
  private boolean updatePrivacySettings()
    throws BuilderException
  {
    for (;;)
    {
      try
      {
        if (!arePrivacySettingsChanged()) {
          break;
        }
        setDidUpdate$1385ff();
        Object localObject1 = privacySettingsHelper.getPrivacySettingsDiff();
        ProfileDataProvider localProfileDataProvider = getDataProvider();
        String str1 = busSubscriberId;
        String str2 = getRumSessionId();
        localObject2 = getProfileId();
        boolean bool = privacySettingsHelper.getCurrentPrivacySettings().showPremiumSubscriberBadge;
        Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
        localObject2 = ProfileRoutes.buildAddEntityRoute("normPrivacySettings", (String)localObject2, localProfileDataProvider.getProfileVersionTag()).toString();
        localObject1 = ProfileDataProvider.newUpdateRequestBuilder().required(Request.post().url((String)localObject2).model((RecordTemplate)localObject1));
        localObject2 = localProfileDataProvider.getMemberBadges();
        if (localObject2 != null) {}
        try
        {
          localObject2 = new MemberBadges.Builder((MemberBadges)localObject2);
          localObject3 = Boolean.valueOf(bool);
          if (localObject3 != null) {
            continue;
          }
          hasPremium = false;
          premium = false;
          localObject2 = ((MemberBadges.Builder)localObject2).build(RecordTemplate.Flavor.RECORD);
          localObject3 = (ProfileState)state;
          ((ProfileState)localObject3).setModel(memberBadgesRoute, (RecordTemplate)localObject2, str1);
        }
        catch (BuilderException localBuilderException)
        {
          Object localObject3;
          Util.safeThrow$7a8b4789(new RuntimeException("Cannot toggle MemberBadges", localBuilderException));
          continue;
        }
        localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, (MultiplexRequest.Builder)localObject1);
        return true;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        Util.safeThrow$7a8b4789(new RuntimeException("Failed to generate diff for privacy settings: " + localJSONException.getMessage()));
      }
      hasPremium = true;
      premium = ((Boolean)localObject3).booleanValue();
    }
    return false;
  }
  
  protected final void addTrackedListeners()
  {
    profilePicViewSection.setOnClickListener(new ProfileBasicInfoEditFragment.1(this, tracker, "edit_profile_photo", new TrackingEventBuilder[0]));
    premiumSettingLayout.setOnClickListener(new ProfileBasicInfoEditFragment.2(this, tracker, "edit_premium_settings", new TrackingEventBuilder[0]));
    addNewPositionButton.setOnClickListener(new ProfileBasicInfoEditFragment.3(this, tracker, "add_new_position", new TrackingEventBuilder[0]));
    addNewPositionEditText.setOnClickListener(new ProfileBasicInfoEditFragment.4(this, tracker, "add_new_position", new TrackingEventBuilder[0]));
    addNewEducationButton.setOnClickListener(new ProfileBasicInfoEditFragment.5(this, tracker, "add_new_education", new TrackingEventBuilder[0]));
    addNewEducationEditText.setOnClickListener(new ProfileBasicInfoEditFragment.6(this, tracker, "add_new_education", new TrackingEventBuilder[0]));
    addEditTextDoneListener(viewHolder.firstNameEdit, "edit_first_name_done");
    addEditTextDoneListener(viewHolder.lastNameEdit, "edit_last_name_done");
    orderPositionSpinner.setOnItemSelectedListener(new TrackingOnItemSelectedListener(tracker, "select_current_position_done", new TrackingEventBuilder[0]));
    orderEducationSpinner.setOnItemSelectedListener(new TrackingOnItemSelectedListener(tracker, "select_education_done", new TrackingEventBuilder[0]));
    countrySpinner.setOnItemSelectedListener(new TrackingOnItemSelectedListener(tracker, "edit_location_country", new TrackingEventBuilder[0]));
    stateSpinner.setOnItemSelectedListener(new TrackingOnItemSelectedListener(tracker, "edit_location_state", new TrackingEventBuilder[0]));
    citySpinner.setOnItemSelectedListener(new TrackingOnItemSelectedListener(tracker, "edit_location_city", new TrackingEventBuilder[0]));
    addEditTextDoneListener(viewHolder.zipEdit, "edit_location_zip_code_done");
    cityButton.setOnClickListener(new TrackingOnClickListener(tracker, "pick_location", new TrackingEventBuilder[0]));
    regionButton.setOnClickListener(new TrackingOnClickListener(tracker, "pick_location", new TrackingEventBuilder[0]));
  }
  
  public final void doPause()
  {
    super.doPause();
    try
    {
      if (getProfile() != null)
      {
        NormProfile localNormProfile = ProfileModelUtils.toNormProfile(getProfile());
        NormProfile.Builder localBuilder = new NormProfile.Builder(localNormProfile);
        populateNormProfileFields(localBuilder, localNormProfile);
        modifiedNormProfile = localBuilder.build(RecordTemplate.Flavor.RECORD);
        getDataProvider().setModifiedNormProfileModel(modifiedNormProfile);
      }
      if (positionArrayAdapter != null) {
        currentPositionCount = positionArrayAdapter.getCount();
      }
      if (educationArrayAdapter != null) {
        educationCount = educationArrayAdapter.getCount();
      }
      return;
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        Log.d(TAG, "Failed to copy core profile or mini profile: " + localBuilderException.getMessage());
      }
    }
  }
  
  public final void doResume()
  {
    super.doResume();
    Object localObject3 = null;
    Object localObject1 = localObject3;
    try
    {
      if (getProfile() != null) {
        localObject1 = ProfileModelUtils.toNormProfile(getProfile());
      }
      if (localObject1 != null) {
        enableEditSave = ((NormProfile)localObject1).equals(modifiedNormProfile);
      }
      return;
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        Util.safeThrow(new RuntimeException("Failed to convert profile to core profile", localBuilderException));
        Object localObject2 = localObject3;
      }
    }
  }
  
  public final String getCancelTrackingControlName()
  {
    return "edit_top_card_back";
  }
  
  protected final int getContentViewId()
  {
    return -1;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969167;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131233272;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final String getTitle()
  {
    return i18NManager.getString(2131232317);
  }
  
  protected final void initializeFields()
  {
    int j = 1;
    modifiedNormProfile = getDataProvider().getModifiedNormProfileModel();
    if ((getProfile() != null) && (modifiedNormProfile == null)) {}
    try
    {
      modifiedNormProfile = ProfileModelUtils.toNormProfile(getProfile());
      Object localObject3;
      Object localObject1;
      if (modifiedNormProfile != null)
      {
        localObject3 = modifiedNormProfile;
        if (!getDataProvider().isDataAvailable()) {
          break label686;
        }
        localObject1 = getDataProvider();
        ((ProfileDataProvider)localObject1).verifyDataAvailable("getPrimaryLocale");
        if (!profileViewApiEnabled) {
          break label658;
        }
        localObject1 = ((ProfileState)state).profileView();
        if (localObject1 != null)
        {
          localObject1 = primaryLocale;
          viewModel = TopCardTransformer.toViewModel((NormProfile)localObject3, (Locale)localObject1, this);
          localObject1 = viewModel;
          ((BaseActivity)getActivity()).getLayoutInflater();
          ((TopCardViewModel)localObject1).onBindViewHolder$ebe6e00(applicationComponent.mediaCenter(), viewHolder);
        }
      }
      else
      {
        currentPositions = getCurrentPositions();
        positionArrayAdapter = new OccupationArrayAdapter(getActivity());
        positionArrayAdapter.setPositions(currentPositions, profileUtil, getString(2131232561));
        orderPositionSpinner.setAdapter(positionArrayAdapter);
        localObject1 = orderPositionSpinner;
        if (currentPositions.size() <= 0) {
          break label692;
        }
        i = 1;
        ((MultiListenerSpinner)localObject1).setSelection(i, false);
        k = (int)getResources().getDimension(2131492995);
        if (!"control".equals(fragmentComponent.lixManager().getTreatment(Lix.PROFILE_EDIT_TOP_CARD_CURRENT_POSITION)))
        {
          if (currentPositions.size() <= 0) {
            break label697;
          }
          orderPositionLabelText.setVisibility(0);
          orderPositionSpinner.setVisibility(0);
          addNewPositionButton.setVisibility(0);
          addNewPositionEditText.setVisibility(8);
          addNewPositionEditTextPlus.setVisibility(8);
        }
        educations = getEducations();
        educationArrayAdapter = new OccupationArrayAdapter(getActivity());
        educationArrayAdapter.setEducations(educations, profileUtil, getString(2131232558));
        orderEducationSpinner.setAdapter(educationArrayAdapter);
        localObject1 = orderEducationSpinner;
        if (educations.size() <= 0) {
          break label754;
        }
        i = j;
        ((MultiListenerSpinner)localObject1).setSelection(i, false);
        if (educations.size() <= 0) {
          break label759;
        }
        orderEducationLabelText.setVisibility(0);
        orderEducationSpinner.setVisibility(0);
        addNewEducationButton.setVisibility(0);
        addNewEducationEditText.setVisibility(8);
        addNewEducationEditTextPlus.setVisibility(8);
        if ((showPrivacySettings) && (privacySettingsHelper != null))
        {
          Object localObject4 = privacySettingsHelper;
          isPremium = memberUtil.isPremium();
          localObject1 = profileDataProvider;
          localObject3 = subscriberId;
          String str = rumSessionId;
          localObject4 = trackingHeader;
          state).privacySettingsRoute = ProfileRoutes.buildPrivacySettingsRoute(profileId).toString();
          localObject3 = ((ProfileDataProvider)localObject1).newModelListener((String)localObject3, str);
          localObject3 = Request.get().url(state).privacySettingsRoute).customHeaders((Map)localObject4).builder(PrivacySettings.BUILDER).listener((RecordTemplateListener)localObject3).filter(DataManager.DataStoreFilter.ALL);
          activityComponent.dataManager().submit((Request.Builder)localObject3);
        }
        locationHelper.fetchInitialLocation(modifiedNormProfile.location);
        return;
      }
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        int k;
        Util.safeThrow(new RuntimeException("Failed to convert Profile to NormProfile", localBuilderException));
        continue;
        Object localObject2 = null;
        continue;
        label658:
        localObject2 = (ProfileState)state;
        localObject2 = (Locale)((ProfileState)localObject2).getModel(primaryLocaleRoute);
        continue;
        label686:
        localObject2 = null;
        continue;
        label692:
        int i = 0;
        continue;
        label697:
        orderPositionLabelText.setVisibility(8);
        orderPositionSpinner.setVisibility(8);
        addNewPositionButton.setVisibility(8);
        addNewPositionEditText.setPadding(k, 0, 0, 0);
        addNewPositionEditText.setVisibility(0);
        addNewPositionEditTextPlus.setVisibility(0);
        continue;
        label754:
        i = 0;
        continue;
        label759:
        orderEducationLabelText.setVisibility(8);
        orderEducationSpinner.setVisibility(8);
        addNewEducationButton.setVisibility(8);
        addNewEducationEditText.setPadding(k, 0, 0, 0);
        addNewEducationEditText.setVisibility(0);
        addNewEducationEditTextPlus.setVisibility(0);
      }
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final boolean isFormModified()
  {
    if ((viewHolder.firstNameEdit.getText().length() == 0) || (viewHolder.lastNameEdit.getText().length() == 0)) {}
    for (int i = 1; i != 0; i = 0) {
      return false;
    }
    bool2 = true;
    bool1 = bool2;
    if (getProfile() != null)
    {
      bool1 = bool2;
      if (modifiedNormProfile == null) {}
    }
    for (;;)
    {
      try
      {
        if ((getFormNormProfile().equals(ProfileModelUtils.toNormProfile(getProfile()))) && (!isPositionOrderChanged()) && (!isEducationOrderChanged()))
        {
          bool1 = arePrivacySettingsChanged();
          if (!bool1) {
            continue;
          }
        }
        bool1 = true;
      }
      catch (BuilderException localBuilderException)
      {
        Log.d(TAG, "Failed to populate fields: " + localBuilderException.getMessage());
        bool1 = bool2;
        continue;
      }
      return bool1;
      bool1 = false;
    }
  }
  
  protected final boolean isFormValid()
    throws BuilderException
  {
    if (validator == null) {}
    NormProfile localNormProfile;
    do
    {
      return false;
      localNormProfile = getFormNormProfile();
    } while ((localNormProfile == null) || (!validator.isValid(localNormProfile, summary, locationHelper.countries)));
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      }
    }
    do
    {
      do
      {
        return;
        photoUri = paramIntent.getData();
      } while ((photoUri == null) || (photoUri.toString().isEmpty()));
      if (profileViewListener != null)
      {
        ProfileEditFragmentUtils.startEditPhoto(profileViewListener, photoUri);
        return;
      }
      ProfileEditFragmentUtils.startEditPhoto((ProfileEditListener)getActivity(), photoUri);
      return;
      getActivity().getContentResolver().notifyChange(photoUri, null);
      if (profileViewListener != null)
      {
        ProfileEditFragmentUtils.startEditPhoto(profileViewListener, photoUri);
        return;
      }
      ProfileEditFragmentUtils.startEditPhoto((ProfileEditListener)getActivity(), photoUri);
      return;
      paramIntent = ResourceListBundleBuilder.getIndustry(paramIntent.getExtras());
    } while (paramIntent == null);
    viewHolder.industryEdit.setTag(entityUrn);
    viewHolder.industryEdit.setText(localizedName);
  }
  
  public final void onCameraDestinationUri(Uri paramUri)
  {
    photoUri = paramUri;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    getDataProvider().setModifiedNormProfileModel(null);
    getDataProvider().setMasterImageUploadSignature(null);
    getDataProvider().setCroppedImageUploadSignature(null);
    showPrivacySettings = "enabled".equals(fragmentComponent.lixManager().getTreatment(Lix.PROFILE_EDIT_PRIVACY_SETTINGS));
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (paramType == DataStore.Type.NETWORK)
    {
      if (LocationHelper.isLocationRoute(paramSet)) {
        locationHelper.onLocationDataError();
      }
    }
    else {
      return;
    }
    super.onDataError(paramType, paramSet, paramDataManagerException);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramType == DataStore.Type.LOCAL) && (dataResponseHandler.isInitialLoadRoutes(paramSet))) {}
    int i;
    do
    {
      return;
      if (modifiedNormProfile != null) {
        break;
      }
      i = 0;
      if (i == 0) {
        break label210;
      }
    } while (initialFocus == null);
    switch (ProfileBasicInfoEditFragment.7.$SwitchMap$com$linkedin$android$identity$edit$ProfileBasicInfoEditBundleBuilder$Focus[initialFocus.ordinal()])
    {
    }
    for (;;)
    {
      initialFocus = ProfileBasicInfoEditBundleBuilder.Focus.NONE;
      return;
      if (!locationHelper.isLocationDataReady(paramSet, modifiedNormProfile.location))
      {
        i = 0;
        break;
      }
      i = 1;
      break;
      profileUtil.scrollToView(getActivity(), formScrollView, locationSection);
      continue;
      profileUtil.scrollToView(getActivity(), formScrollView, summaryTextLayout);
      continue;
      profileUtil.scrollToView(getActivity(), formScrollView, headlineTextLayout);
      continue;
      profileUtil.scrollToView(getActivity(), formScrollView, industryTextLayout);
    }
    label210:
    if ((showPrivacySettings) && (privacySettingsHelper != null))
    {
      PrivacySettingsHelper localPrivacySettingsHelper = privacySettingsHelper;
      if (paramSet != null)
      {
        Object localObject = ProfileRoutes.buildPrivacySettingsRoute(memberUtil.getProfileId()).toString();
        Iterator localIterator = paramSet.iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if ((str.contains((CharSequence)localObject)) && ("GET".equals(getrequest.method)))
            {
              i = 1;
              if (i == 0) {
                break label416;
              }
              localObject = (ProfileState)profileDataProvider.state;
              privacySettings = ((PrivacySettings)((ProfileState)localObject).getModel(privacySettingsRoute));
              if (privacySettings != null)
              {
                allowOpenProfile = privacySettings.allowOpenProfile;
                showPremiumSubscriberBadge = privacySettings.showPremiumSubscriberBadge;
                localPrivacySettingsHelper.updatePremiumSettingLayout();
              }
            }
          }
        }
      }
      label416:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label422;
        }
        Log.d("PrivacySettings loaded");
        return;
        i = 0;
        break;
      }
    }
    label422:
    dataResponseHandler.handleOnDataReady(paramType, paramSet, paramMap);
  }
  
  public void onDestroyView()
  {
    orderPositionSpinner.removeOnItemSelectedListener();
    orderEducationSpinner.removeOnItemSelectedListener();
    countrySpinner.removeOnItemSelectedListener();
    stateSpinner.removeOnItemSelectedListener();
    citySpinner.removeOnItemSelectedListener();
    super.onDestroyView();
  }
  
  public void onPrepareOptionsMenu(Menu paramMenu)
  {
    enableEditSave = isFormModified();
    super.onPrepareOptionsMenu(paramMenu);
  }
  
  public final void onPrivacySettingsChanged()
  {
    setEditSaveMenuItemEnabled(isFormModified());
  }
  
  public final void onRequestPermissionsResult(Set<String> paramSet1, Set<String> paramSet2)
  {
    super.onRequestPermissionsResult(paramSet1, paramSet2);
    locationHelper.onRequestPermissionsResult$27a8552b(paramSet1);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("photoUri", photoUri);
  }
  
  public final void onUserSelected(int paramInt)
  {
    getDataProvider().setModifiedNormProfileModel(modifiedNormProfile);
    String str = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      photoUtil.onUserSelection(paramInt, profileEditListener, this, this, tracker, str);
      return;
      str = "profile_self_member_photo_view";
      continue;
      str = "profile_self_member_photo_library";
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (paramBundle != null) {
      photoUri = ((Uri)paramBundle.getParcelable("photoUri"));
    }
  }
  
  protected final void optimisticLockingUpdateForm() {}
  
  public final String pageKey()
  {
    return "profile_self_edit_top_card";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    super.setFragmentData(paramBundle);
    if (initialFocus == null) {
      initialFocus = ((ProfileBasicInfoEditBundleBuilder.Focus)getArguments().getSerializable("defaultFocus"));
    }
    viewHolder = ((TopCardViewHolder)TopCardViewHolder.CREATOR.createViewHolder(formScrollView));
    ProfileUtil.setLimit(viewHolder.firstNameEdit, 20);
    ProfileUtil.setLimit(viewHolder.lastNameEdit, 20);
    ProfileUtil.setLimit(viewHolder.headlineEdit, 120);
    ProfileUtil.setLimit(viewHolder.zipEdit, 10);
    viewHolder.summaryEdit.addTextChangedListener(new SizeLimitWatcher(viewHolder.summaryEdit, summaryExceedLimit, summaryChars, 2000, 20, i18NManager));
    paramBundle = new BasicInfoValidator();
    firstNameTextLayout = firstNameTextLayout;
    lastNameTextLayout = lastNameTextLayout;
    headlineTextLayout = headlineTextLayout;
    summaryTextLayout = summaryTextLayout;
    zipCodeTextLayout = zipEditTextLayout;
    countrySpinner = countrySpinner;
    stateSpinner = stateSpinner;
    citySpinner = citySpinner;
    zipEdit = viewHolder.zipEdit;
    regionSection = regionSection;
    locationErrorView = locationErrorView;
    validator = paramBundle;
    validator.setActivity(getActivity()).setI18NManager(i18NManager).setProfileUtil(profileUtil).setFormScrollView(formScrollView);
    addEditTextWatchList(new EditText[] { viewHolder.firstNameEdit, viewHolder.lastNameEdit, viewHolder.headlineEdit, viewHolder.zipEdit, viewHolder.summaryEdit, viewHolder.industryEdit });
    addMultilineEditTextOnFocusChangeWatchList(new EditText[] { viewHolder.summaryEdit });
    addSpinnerWatchList(new Spinner[] { orderPositionSpinner, orderEducationSpinner, countrySpinner, stateSpinner, citySpinner });
    paramBundle = regionSection;
    int i = 0;
    while (i <= 0)
    {
      RadioGroup localRadioGroup = new RadioGroup[] { paramBundle }[0];
      localRadioGroup.setOnCheckedChangeListener(radioGroupChangeWatcher);
      if ((localRadioGroup instanceof VisibilityListenerRadioGroup)) {
        ((VisibilityListenerRadioGroup)localRadioGroup).setOnVisibilityChangeListener(visibilityChangeWatcher);
      }
      i += 1;
    }
    locationHelper = new LocationHelper(viewHolder.zipEdit, busSubscriberId, getRumSessionId(), getActivityComponent(), this, regionSection, cityButton, regionButton, locationsThisAreaView, countrySpinner, validator, Tracker.createPageInstanceHeader(getPageInstance()), profileUtil, stateSpinner, citySpinner, locationErrorView, zipEditTextLayout, useCurrentLocationButton);
    if (showPrivacySettings)
    {
      privacySettingsHelper = new PrivacySettingsHelper(fragmentComponent, memberUtil, busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), getDataProvider(), premiumSettingLayout);
      privacySettingsHelper.listener = this;
    }
  }
  
  protected final void updateProfileData()
    throws BuilderException
  {
    boolean bool2;
    if (getProfile() != null)
    {
      LixManager localLixManager = fragmentComponent.lixManager();
      bool2 = updatePrivacySettings();
      if ("control".equals(localLixManager.getTreatment(Lix.PROFILE_EDIT_TOPCARD_PARTIAL_UPDATE))) {
        break label62;
      }
      bool1 = true;
      if (!bool1) {
        break label67;
      }
    }
    label62:
    label67:
    for (boolean bool1 = bool2 | partialUpdateTopCard();; bool1 = bool2 | fullUpdateTopCard())
    {
      if (!bool1) {
        goBackToPreviousFragment();
      }
      return;
      bool1 = false;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileBasicInfoEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */