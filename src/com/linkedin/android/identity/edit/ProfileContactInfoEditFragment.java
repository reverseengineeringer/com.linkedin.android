package com.linkedin.android.identity.edit;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import butterknife.InjectView;
import butterknife.InjectViews;
import com.linkedin.android.identity.edit.contactInfo.ContactInfoTransformer.1;
import com.linkedin.android.identity.edit.contactInfo.ContactInfoTransformer.10;
import com.linkedin.android.identity.edit.contactInfo.ContactInfoTransformer.2;
import com.linkedin.android.identity.edit.contactInfo.ContactInfoTransformer.3;
import com.linkedin.android.identity.edit.contactInfo.ContactInfoTransformer.4;
import com.linkedin.android.identity.edit.contactInfo.ContactInfoTransformer.5;
import com.linkedin.android.identity.edit.contactInfo.ContactInfoTransformer.6;
import com.linkedin.android.identity.edit.contactInfo.ContactInfoTransformer.7;
import com.linkedin.android.identity.edit.contactInfo.ContactInfoTransformer.8;
import com.linkedin.android.identity.edit.contactInfo.ContactInfoTransformer.9;
import com.linkedin.android.identity.edit.contactInfo.ContactInfoViewHolder;
import com.linkedin.android.identity.edit.contactInfo.ContactInfoViewModel;
import com.linkedin.android.identity.edit.contactInfoVersionTwo.ContactInfoVersionTwoTransformer.1;
import com.linkedin.android.identity.edit.contactInfoVersionTwo.ContactInfoVersionTwoTransformer.10;
import com.linkedin.android.identity.edit.contactInfoVersionTwo.ContactInfoVersionTwoTransformer.11;
import com.linkedin.android.identity.edit.contactInfoVersionTwo.ContactInfoVersionTwoTransformer.12;
import com.linkedin.android.identity.edit.contactInfoVersionTwo.ContactInfoVersionTwoTransformer.2;
import com.linkedin.android.identity.edit.contactInfoVersionTwo.ContactInfoVersionTwoTransformer.3;
import com.linkedin.android.identity.edit.contactInfoVersionTwo.ContactInfoVersionTwoTransformer.4;
import com.linkedin.android.identity.edit.contactInfoVersionTwo.ContactInfoVersionTwoTransformer.5;
import com.linkedin.android.identity.edit.contactInfoVersionTwo.ContactInfoVersionTwoTransformer.6;
import com.linkedin.android.identity.edit.contactInfoVersionTwo.ContactInfoVersionTwoTransformer.7;
import com.linkedin.android.identity.edit.contactInfoVersionTwo.ContactInfoVersionTwoTransformer.8;
import com.linkedin.android.identity.edit.contactInfoVersionTwo.ContactInfoVersionTwoTransformer.9;
import com.linkedin.android.identity.edit.contactInfoVersionTwo.ContactInfoVersionTwoViewHolder;
import com.linkedin.android.identity.edit.contactInfoVersionTwo.ContactInfoVersionTwoViewModel;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.identity.shared.validators.forms.BaseFormValidator;
import com.linkedin.android.identity.shared.validators.forms.ContactInfoValidator;
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
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.StringUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.CustomTextInputLayout;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Date.Builder;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.CustomWebsite.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.IM;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.IM.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.IMProvider;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NetworkVisibilitySetting;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PhoneNumber;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PhoneNumber.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PhoneNumberType;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileWebsite;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileWebsite.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileWebsite.Type.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.StandardWebsite.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.WeChatContactInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.WebsiteCategory;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileContactInfoEditFragment
  extends ProfileEditBaseFragment
{
  private static final String TAG = ProfileContactInfoEditFragment.class.getSimpleName();
  @InjectView(2131757419)
  CustomTextInputLayout addressLayout;
  private ProfileContactInfo contactInfo;
  @Inject
  FlagshipDataManager dataManager;
  private int dateDayOfMonth;
  private int dateMonth = -1;
  @InjectView(2131757387)
  LinearLayout formLayout;
  @InjectView(2131757386)
  ScrollView formScrollView;
  @InjectViews({2131757427, 2131757433, 2131757439})
  List<CustomTextInputLayout> imLayouts;
  @InjectView(2131757426)
  LinearLayout imSection;
  private ProfileContactInfoEditBundleBuilder.Focus initialFocus;
  @Inject
  IntentRegistry intentRegistry;
  @InjectView(2131757414)
  CustomTextInputLayout phoneNumberLayout;
  @InjectView(2131757413)
  LinearLayout phoneSection;
  @Inject
  ProfileUtil profileUtil;
  private final BroadcastReceiver receiver = new ProfileContactInfoEditFragment.1(this);
  private boolean shouldUseV2;
  @Inject
  StringUtils stringUtils;
  private ContactInfoValidator validator;
  private ContactInfoViewHolder viewHolder;
  private ContactInfoVersionTwoViewHolder viewHolderV2;
  private ContactInfoVersionTwoViewModel viewModelV2;
  @InjectViews({2131757394, 2131757402, 2131757410})
  List<CustomTextInputLayout> websiteOtherTypeLayouts;
  @InjectView(2131757388)
  LinearLayout websiteSection;
  @InjectViews({2131757389, 2131757397, 2131757405})
  List<CustomTextInputLayout> websiteUrlLayouts;
  
  private ProfileContactInfo getUpdatedContactInfoFromForm()
  {
    if (contactInfo == null) {
      return null;
    }
    ProfileContactInfo.Builder localBuilder;
    int i;
    Object localObject2;
    Object localObject4;
    Object localObject3;
    try
    {
      localBuilder = new ProfileContactInfo.Builder();
      localBuilder.setEntityUrn(contactInfo.entityUrn);
      if ((!shouldUseV2) || (viewHolderV2 == null) || (viewModelV2 == null)) {
        break label855;
      }
      ArrayList localArrayList = new ArrayList();
      if ((contactInfo != null) && (contactInfo.hasWebsites)) {
        localArrayList.addAll(contactInfo.websites);
      }
      if (viewHolderV2 == null) {
        break label382;
      }
      i = viewHolderV2.websiteLayouts.size() - 1;
      if (i < 0) {
        break label382;
      }
      localObject2 = ((EditText)viewHolderV2.websiteUrlEditTexts.get(i)).getText().toString();
      localObject4 = ProfileUtil.getWebsiteCategoryBySpinnerIndex(((Spinner)viewHolderV2.websiteTypeSpinners.get(i)).getSelectedItemPosition());
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label361;
      }
      localObject3 = new ProfileWebsite.Type.Builder();
      if (localObject4 == WebsiteCategory.OTHER)
      {
        localObject4 = ((EditText)viewHolderV2.websiteOtherTypeEditTexts.get(i)).getText().toString();
        ((ProfileWebsite.Type.Builder)localObject3).setCustomWebsiteValue(new CustomWebsite.Builder().setLabel((String)localObject4).build(RecordTemplate.Flavor.RECORD));
      }
      for (;;)
      {
        localObject4 = new ProfileWebsite.Builder();
        ((ProfileWebsite.Builder)localObject4).setUrl((String)localObject2);
        ((ProfileWebsite.Builder)localObject4).setType(((ProfileWebsite.Type.Builder)localObject3).build());
        localObject2 = ((ProfileWebsite.Builder)localObject4).build(RecordTemplate.Flavor.RECORD);
        if (localArrayList.size() <= i) {
          break;
        }
        localArrayList.set(i, localObject2);
        break label1146;
        ((ProfileWebsite.Type.Builder)localObject3).setStandardWebsiteValue(new StandardWebsite.Builder().setCategory((WebsiteCategory)localObject4).build(RecordTemplate.Flavor.RECORD));
      }
      localBuilderException.add(localObject2);
    }
    catch (BuilderException localBuilderException)
    {
      Log.d(TAG, "Failed to populate data model: " + localBuilderException.getMessage());
      return null;
    }
    break label1146;
    label361:
    label382:
    label391:
    Object localObject1;
    if (localBuilderException.size() > i)
    {
      localBuilderException.remove(i);
      break label1146;
      if (localBuilderException.size() <= 0) {
        break label1153;
      }
      localBuilder.setWebsites(localBuilderException);
      if (viewHolderV2 == null) {
        break label1158;
      }
      localObject2 = viewHolderV2.phoneNumberEditText.getText().toString();
      localObject3 = ProfileUtil.getPhoneNumberTypeBySpinnerIndex(viewHolderV2.phoneTypeSpinner.getSelectedItemPosition());
      localObject1 = new ArrayList();
      if ((contactInfo != null) && (contactInfo.hasPhoneNumbers)) {
        ((List)localObject1).addAll(contactInfo.phoneNumbers);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject4 = new PhoneNumber.Builder();
        ((PhoneNumber.Builder)localObject4).setNumber((String)localObject2);
        ((PhoneNumber.Builder)localObject4).setType((PhoneNumberType)localObject3);
        localObject2 = ((PhoneNumber.Builder)localObject4).build(RecordTemplate.Flavor.RECORD);
        if (((List)localObject1).size() > 0)
        {
          ((List)localObject1).set(0, localObject2);
          if (((List)localObject1).size() <= 0) {
            break label1158;
          }
          label540:
          localBuilder.setPhoneNumbers((List)localObject1);
          localBuilder.setIms(populateIMsV2());
          localObject2 = viewHolderV2.addressEditText.getText().toString();
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            localObject1 = null;
          }
          localBuilder.setAddress((String)localObject1);
          localBuilder.setEmailAddress(viewHolderV2.emailAddressEditText.getText().toString());
          if ((viewModelV2 == null) || (viewModelV2.month < 0) || (viewModelV2.dayOfMonth <= 0)) {
            break label1163;
          }
          localObject1 = new Date.Builder();
          ((Date.Builder)localObject1).setMonth(Integer.valueOf(viewModelV2.month + 1));
          ((Date.Builder)localObject1).setDay(Integer.valueOf(viewModelV2.dayOfMonth));
          localObject1 = ((Date.Builder)localObject1).build(RecordTemplate.Flavor.RECORD);
          label683:
          if (localObject1 != null) {
            break label825;
          }
          hasBirthDateOn = false;
          birthDateOn = null;
          label699:
          localObject1 = viewModelV2.birthdayVisibilitySetting;
          if (localObject1 != null) {
            break label840;
          }
          hasBirthdayVisibilitySetting = false;
          birthdayVisibilitySetting = null;
        }
      }
      label723:
      label761:
      label785:
      label825:
      label840:
      label855:
      do
      {
        for (;;)
        {
          localObject1 = contactInfo.twitterHandles;
          if ((localObject1 != null) && (!((List)localObject1).equals(Collections.emptyList()))) {
            break label1116;
          }
          hasTwitterHandles = false;
          twitterHandles = Collections.emptyList();
          localObject1 = contactInfo.weChatContactInfo;
          if (localObject1 != null) {
            break label1131;
          }
          hasWeChatContactInfo = false;
          weChatContactInfo = null;
          return localBuilder.build(RecordTemplate.Flavor.RECORD);
          ((List)localObject1).add(localObject2);
          break;
          if (((List)localObject1).size() <= 0) {
            break;
          }
          ((List)localObject1).remove(0);
          break;
          hasBirthDateOn = true;
          birthDateOn = ((Date)localObject1);
          break label699;
          hasBirthdayVisibilitySetting = true;
          birthdayVisibilitySetting = ((NetworkVisibilitySetting)localObject1);
        }
      } while (viewHolder == null);
      localBuilder.setWebsites(populateWebsites());
      if (viewHolder == null) {
        break label1168;
      }
      localObject2 = viewHolder.phoneNumberEditText.getText().toString();
      localObject3 = ProfileUtil.getPhoneNumberTypeBySpinnerIndex(viewHolder.phoneTypeSpinner.getSelectedItemPosition());
      localObject1 = new ArrayList();
      if ((contactInfo != null) && (contactInfo.hasPhoneNumbers)) {
        ((List)localObject1).addAll(contactInfo.phoneNumbers);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject4 = new PhoneNumber.Builder();
        ((PhoneNumber.Builder)localObject4).setNumber((String)localObject2);
        ((PhoneNumber.Builder)localObject4).setType((PhoneNumberType)localObject3);
        localObject2 = ((PhoneNumber.Builder)localObject4).build(RecordTemplate.Flavor.RECORD);
        if (((List)localObject1).size() > 0)
        {
          ((List)localObject1).set(0, localObject2);
          label1005:
          if (((List)localObject1).size() <= 0) {
            break label1168;
          }
        }
      }
    }
    for (;;)
    {
      localBuilder.setPhoneNumbers((List)localObject1);
      localBuilder.setIms(populateIMs());
      localObject2 = viewHolder.addressEditText.getText().toString();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = null;
      }
      localBuilder.setAddress((String)localObject1);
      localBuilder.setEmailAddress(viewHolder.emailAddressEditText.getText().toString());
      break label723;
      ((List)localObject1).add(localObject2);
      break label1005;
      if (((List)localObject1).size() <= 0) {
        break label1005;
      }
      ((List)localObject1).remove(0);
      break label1005;
      label1116:
      hasTwitterHandles = true;
      twitterHandles = ((List)localObject1);
      break label761;
      label1131:
      hasWeChatContactInfo = true;
      weChatContactInfo = ((WeChatContactInfo)localObject1);
      break label785;
      label1146:
      i -= 1;
      break;
      label1153:
      localObject1 = null;
      break label391;
      label1158:
      localObject1 = null;
      break label540;
      label1163:
      localObject1 = null;
      break label683;
      label1168:
      localObject1 = null;
    }
  }
  
  public static ProfileContactInfoEditFragment newInstance(ProfileContactInfoEditBundleBuilder paramProfileContactInfoEditBundleBuilder)
  {
    ProfileContactInfoEditFragment localProfileContactInfoEditFragment = new ProfileContactInfoEditFragment();
    localProfileContactInfoEditFragment.setArguments(paramProfileContactInfoEditBundleBuilder.build());
    return localProfileContactInfoEditFragment;
  }
  
  private List<IM> populateIMs()
    throws BuilderException
  {
    ArrayList localArrayList = new ArrayList();
    if ((contactInfo != null) && (contactInfo.hasIms)) {
      localArrayList.addAll(contactInfo.ims);
    }
    if (viewHolder != null)
    {
      int i = viewHolder.imLayouts.size() - 1;
      if (i >= 0)
      {
        Object localObject = ((EditText)viewHolder.imEditTexts.get(i)).getText().toString();
        IMProvider localIMProvider = ProfileUtil.getIMProviderBySpinnerIndex(((Spinner)viewHolder.imTypeSpinners.get(i)).getSelectedItemPosition());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          IM.Builder localBuilder = new IM.Builder();
          localBuilder.setId((String)localObject);
          localBuilder.setProvider(localIMProvider);
          localObject = localBuilder.build(RecordTemplate.Flavor.RECORD);
          if (localArrayList.size() > i) {
            localArrayList.set(i, localObject);
          }
        }
        for (;;)
        {
          i -= 1;
          break;
          localArrayList.add(localObject);
          continue;
          if (localArrayList.size() > i) {
            localArrayList.remove(i);
          }
        }
      }
    }
    if (localArrayList.size() > 0) {
      return localArrayList;
    }
    return null;
  }
  
  private List<IM> populateIMsV2()
    throws BuilderException
  {
    ArrayList localArrayList = new ArrayList();
    if ((contactInfo != null) && (contactInfo.hasIms)) {
      localArrayList.addAll(contactInfo.ims);
    }
    if (viewHolderV2 != null)
    {
      int i = viewHolderV2.imLayouts.size() - 1;
      if (i >= 0)
      {
        Object localObject = ((EditText)viewHolderV2.imEditTexts.get(i)).getText().toString();
        IMProvider localIMProvider = ProfileUtil.getIMProviderBySpinnerIndex(((Spinner)viewHolderV2.imTypeSpinners.get(i)).getSelectedItemPosition());
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          IM.Builder localBuilder = new IM.Builder();
          localBuilder.setId((String)localObject);
          localBuilder.setProvider(localIMProvider);
          localObject = localBuilder.build(RecordTemplate.Flavor.RECORD);
          if (localArrayList.size() > i) {
            localArrayList.set(i, localObject);
          }
        }
        for (;;)
        {
          i -= 1;
          break;
          localArrayList.add(localObject);
          continue;
          if (localArrayList.size() > i) {
            localArrayList.remove(i);
          }
        }
      }
    }
    if (localArrayList.size() > 0) {
      return localArrayList;
    }
    return null;
  }
  
  private List<ProfileWebsite> populateWebsites()
    throws BuilderException
  {
    ArrayList localArrayList = new ArrayList();
    if ((contactInfo != null) && (contactInfo.hasWebsites)) {
      localArrayList.addAll(contactInfo.websites);
    }
    if (viewHolder != null)
    {
      int i = viewHolder.websiteLayouts.size() - 1;
      if (i >= 0)
      {
        Object localObject1 = ((EditText)viewHolder.websiteUrlEditTexts.get(i)).getText().toString();
        Object localObject2 = ProfileUtil.getWebsiteCategoryBySpinnerIndex(((Spinner)viewHolder.websiteTypeSpinners.get(i)).getSelectedItemPosition());
        ProfileWebsite.Type.Builder localBuilder;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localBuilder = new ProfileWebsite.Type.Builder();
          if (localObject2 == WebsiteCategory.OTHER)
          {
            localObject2 = ((EditText)viewHolder.websiteOtherTypeEditTexts.get(i)).getText().toString();
            localBuilder.setCustomWebsiteValue(new CustomWebsite.Builder().setLabel((String)localObject2).build(RecordTemplate.Flavor.RECORD));
            label184:
            localObject2 = new ProfileWebsite.Builder();
            ((ProfileWebsite.Builder)localObject2).setUrl((String)localObject1);
            ((ProfileWebsite.Builder)localObject2).setType(localBuilder.build());
            localObject1 = ((ProfileWebsite.Builder)localObject2).build(RecordTemplate.Flavor.RECORD);
            if (localArrayList.size() <= i) {
              break label273;
            }
            localArrayList.set(i, localObject1);
          }
        }
        for (;;)
        {
          i -= 1;
          break;
          localBuilder.setStandardWebsiteValue(new StandardWebsite.Builder().setCategory((WebsiteCategory)localObject2).build(RecordTemplate.Flavor.RECORD));
          break label184;
          label273:
          localArrayList.add(localObject1);
          continue;
          if (localArrayList.size() > i) {
            localArrayList.remove(i);
          }
        }
      }
    }
    if (localArrayList.size() > 0) {
      return localArrayList;
    }
    return null;
  }
  
  private void setFormData(ProfileContactInfo paramProfileContactInfo)
  {
    if ((BaseActivity)getActivity() == null) {}
    FragmentComponent localFragmentComponent;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    do
    {
      return;
      if ((!shouldUseV2) || (viewHolderV2 == null)) {
        break;
      }
      localFragmentComponent = fragmentComponent;
      localObject2 = i18NManager;
      localObject3 = profileUtil;
      localObject1 = new ContactInfoVersionTwoViewModel();
      i18NManager = ((I18NManager)localObject2);
      fragmentComponent = localFragmentComponent;
      profileUtil = ((ProfileUtil)localObject3);
      showBirthdayField = "enabled".equals(localFragmentComponent.lixManager().getTreatment(Lix.PROFILE_EDIT_ADDITIONAL_INFO_BIRTHDAY));
      if (hasWebsites) {
        websites = websites;
      }
      if (hasPhoneNumbers) {
        phoneNumber = ((PhoneNumber)phoneNumbers.get(0));
      }
      if (hasAddress) {
        address = address;
      }
      if (hasEmailAddress) {
        emailAddress = emailAddress;
      }
      if (hasIms) {
        ims = ims;
      }
      if (hasBirthDateOn)
      {
        localObject2 = birthDateOn;
        if ((localObject2 != null) && (hasMonth) && (hasDay))
        {
          month = (month - 1);
          dayOfMonth = day;
        }
        if (hasBirthdayVisibilitySetting) {
          birthdayVisibilitySetting = birthdayVisibilitySetting;
        }
      }
      onAddressEditTouched = new ContactInfoVersionTwoTransformer.1(localFragmentComponent);
      onWebsiteEditTouched = new ContactInfoVersionTwoTransformer.2(localFragmentComponent);
      onIMEditTouched = new ContactInfoVersionTwoTransformer.3(localFragmentComponent);
      onPhoneEditTouched = new ContactInfoVersionTwoTransformer.4(localFragmentComponent);
      onAddWebsiteClickTrackingClosure = new ContactInfoVersionTwoTransformer.5(localFragmentComponent.tracker(), "add_website");
      onAddIMClickTrackingClosure = new ContactInfoVersionTwoTransformer.6(localFragmentComponent.tracker(), "add_instant_messenger");
      onWebsiteTypeClickTrackingClosure = new ContactInfoVersionTwoTransformer.7(localFragmentComponent.tracker(), "edit_website_type");
      onPhoneTypeClickTrackingClosure = new ContactInfoVersionTwoTransformer.8(localFragmentComponent.tracker(), "edit_phone_type");
      onIMTypeClickTrackingClosure = new ContactInfoVersionTwoTransformer.9(localFragmentComponent.tracker(), "edit_instant_messenger_type");
      onEmailEditClickListener = new ContactInfoVersionTwoTransformer.10(localFragmentComponent.tracker(), "edit_email", new TrackingEventBuilder[0], localFragmentComponent);
      onBirthdayEditClickTrackingClosure = new ContactInfoVersionTwoTransformer.11(localFragmentComponent.tracker(), "edit_birthday");
      onBirthdayVisibilityClickTrackingClosure = new ContactInfoVersionTwoTransformer.12(localFragmentComponent.tracker(), "edit_birthday_visibility");
      viewModelV2 = ((ContactInfoVersionTwoViewModel)localObject1);
      paramProfileContactInfo = viewModelV2;
      ((BaseActivity)getActivity()).getLayoutInflater();
      applicationComponent.mediaCenter();
      paramProfileContactInfo.onBindViewHolder$70b888a6(viewHolderV2);
      if (dateMonth >= 0) {
        viewModelV2.month = dateMonth;
      }
      if (dateDayOfMonth > 0) {
        viewModelV2.dayOfMonth = dateDayOfMonth;
      }
    } while (initialFocus == null);
    switch (ProfileContactInfoEditFragment.2.$SwitchMap$com$linkedin$android$identity$edit$ProfileContactInfoEditBundleBuilder$Focus[initialFocus.ordinal()])
    {
    }
    for (;;)
    {
      initialFocus = ProfileContactInfoEditBundleBuilder.Focus.NONE;
      return;
      if (viewHolder == null) {
        break;
      }
      localFragmentComponent = fragmentComponent;
      localObject1 = i18NManager;
      localObject2 = profileUtil;
      localObject3 = new ContactInfoViewModel();
      i18NManager = ((I18NManager)localObject1);
      fragmentComponent = localFragmentComponent;
      profileUtil = ((ProfileUtil)localObject2);
      if (hasWebsites) {
        websites = websites;
      }
      if ((hasPhoneNumbers) && (phoneNumbers != null)) {
        phoneNumber = ((PhoneNumber)phoneNumbers.get(0));
      }
      if (hasAddress) {
        address = address;
      }
      if (hasEmailAddress) {
        emailAddress = emailAddress;
      }
      if (hasIms) {
        ims = ims;
      }
      onAddressEditTouched = new ContactInfoTransformer.1(localFragmentComponent);
      onWebsiteEditTouched = new ContactInfoTransformer.2(localFragmentComponent);
      onIMEditTouched = new ContactInfoTransformer.3(localFragmentComponent);
      onPhoneEditTouched = new ContactInfoTransformer.4(localFragmentComponent);
      onAddWebsiteClickTrackingClosure = new ContactInfoTransformer.5(localFragmentComponent.tracker(), "add_website");
      onAddIMClickTrackingClosure = new ContactInfoTransformer.6(localFragmentComponent.tracker(), "add_instant_messenger");
      onWebsiteTypeClickTrackingClosure = new ContactInfoTransformer.7(localFragmentComponent.tracker(), "edit_website_type");
      onPhoneTypeClickTrackingClosure = new ContactInfoTransformer.8(localFragmentComponent.tracker(), "edit_phone_type");
      onIMTypeClickTrackingClosure = new ContactInfoTransformer.9(localFragmentComponent.tracker(), "edit_instant_messenger_type");
      onEmailEditClickListener = new ContactInfoTransformer.10(localFragmentComponent.tracker(), "edit_email", new TrackingEventBuilder[0], localFragmentComponent);
      ((BaseActivity)getActivity()).getLayoutInflater();
      applicationComponent.mediaCenter();
      ((ContactInfoViewModel)localObject3).onBindViewHolder$1b7c2e32(viewHolder);
      break;
      profileUtil.scrollToView(getActivity(), formScrollView, websiteSection);
      continue;
      profileUtil.scrollToView(getActivity(), formScrollView, phoneSection);
      continue;
      profileUtil.scrollToView(getActivity(), formScrollView, addressLayout);
      continue;
      profileUtil.scrollToView(getActivity(), formScrollView, imSection);
    }
  }
  
  protected final void addTrackedListeners() {}
  
  public final void doPause()
  {
    super.doPause();
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(receiver);
  }
  
  public final void doResume()
  {
    super.doResume();
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(receiver, new IntentFilter("datePicked"));
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(receiver, new IntentFilter("birthdayVisibilityOptionSelected"));
  }
  
  protected final int getContentViewId()
  {
    return 2131757386;
  }
  
  protected final int getContentViewResourceId()
  {
    if (shouldUseV2) {
      return 2130969172;
    }
    return 2130969171;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return -1;
  }
  
  public final String getTitle()
  {
    if (Util.isEnglish(getContext())) {}
    for (int i = 2131232344;; i = 2131232355) {
      return i18NManager.getString(i);
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
    ProfileContactInfo localProfileContactInfo = getUpdatedContactInfoFromForm();
    return (localProfileContactInfo != null) && (contactInfo != null) && (!contactInfo.equals(localProfileContactInfo));
  }
  
  protected final boolean isFormValid()
  {
    ProfileContactInfo localProfileContactInfo = getUpdatedContactInfoFromForm();
    if (localProfileContactInfo != null)
    {
      if (validator == null)
      {
        validator = new ContactInfoValidator();
        validator.setActivity(getActivity()).setI18NManager(i18NManager).setFormScrollView(formScrollView).setProfileUtil(profileUtil);
        ContactInfoValidator localContactInfoValidator = validator;
        websiteUrlLayouts = websiteUrlLayouts;
        websiteOtherTypeLayouts = websiteOtherTypeLayouts;
        phoneLayout = phoneNumberLayout;
        addressLayout = addressLayout;
        imLayouts = imLayouts;
      }
      if (validator.isValid(localProfileContactInfo)) {
        return true;
      }
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    if (paramBundle != null)
    {
      shouldUseV2 = paramBundle.getBoolean("shouldUseV2");
      dateMonth = paramBundle.getInt("dateMonth");
      dateDayOfMonth = paramBundle.getInt("dateDay");
      return;
    }
    shouldUseV2 = "enabled".equals(fragmentComponent.lixManager().getTreatment(Lix.PROFILE_EDIT_CONTACT_INFO_V2));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("shouldUseV2", shouldUseV2);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected final void optimisticLockingUpdateForm()
  {
    ProfileContactInfo localProfileContactInfo = getDataProvider().getContactInfo();
    if (localProfileContactInfo == null)
    {
      goBackToPreviousFragment();
      return;
    }
    setFormData(localProfileContactInfo);
  }
  
  public final String pageKey()
  {
    return "profile_self_edit_contact_info";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    Bundle localBundle = getArguments();
    contactInfo = ProfileContactInfoEditBundleBuilder.getContactInfo(localBundle);
    super.setFragmentData(paramBundle);
    if (initialFocus == null)
    {
      paramBundle = localBundle.getString("defaultFocus");
      if (paramBundle != null)
      {
        paramBundle = ProfileContactInfoEditBundleBuilder.Focus.valueOf(paramBundle);
        initialFocus = paramBundle;
      }
    }
    else
    {
      if (contactInfo == null) {
        goBackToPreviousFragment();
      }
      if (!shouldUseV2) {
        break label208;
      }
      viewHolderV2 = ((ContactInfoVersionTwoViewHolder)ContactInfoVersionTwoViewHolder.CREATOR.createViewHolder(formScrollView));
      addEditTextWatchList(new EditText[] { viewHolderV2.phoneNumberEditText, viewHolderV2.phoneTypeEditText, viewHolderV2.addressEditText, viewHolderV2.emailAddressEditText });
      addEditTextWatchList(viewHolderV2.websiteUrlEditTexts);
      addEditTextWatchList(viewHolderV2.websiteTypeEditTexts);
      addEditTextWatchList(viewHolderV2.imEditTexts);
      addEditTextWatchList(viewHolderV2.imTypeEditTexts);
      addEditTextWatchList(new EditText[] { viewHolderV2.birthdayEditText });
    }
    for (;;)
    {
      setFormData(contactInfo);
      return;
      paramBundle = null;
      break;
      label208:
      viewHolder = ((ContactInfoViewHolder)ContactInfoViewHolder.CREATOR.createViewHolder(formScrollView));
      addEditTextWatchList(new EditText[] { viewHolder.phoneNumberEditText, viewHolder.phoneTypeEditText, viewHolder.addressEditText, viewHolder.emailAddressEditText });
      addEditTextWatchList(viewHolder.websiteUrlEditTexts);
      addEditTextWatchList(viewHolder.websiteTypeEditTexts);
      addEditTextWatchList(viewHolder.imEditTexts);
      addEditTextWatchList(viewHolder.imTypeEditTexts);
    }
  }
  
  protected final void updateProfileData()
  {
    Object localObject = getUpdatedContactInfoFromForm();
    if ((localObject != null) && (contactInfo != null)) {
      try
      {
        localObject = PegasusPatchGenerator.INSTANCE.diff(contactInfo, (RecordTemplate)localObject);
        if ((((JSONObject)localObject).length() > 0) && (getRumSessionId() != null))
        {
          setDidUpdate$1385ff();
          localObject = new JsonModel((JSONObject)localObject);
          ProfileDataProvider localProfileDataProvider = getDataProvider();
          String str1 = busSubscriberId;
          String str2 = getRumSessionId();
          String str3 = getProfileId();
          String str4 = getDataProvider().getProfileVersionTag();
          Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
          str4 = ProfileRoutes.buildEditEntityRoute("normProfileContactInfo", str3, "", str4).toString();
          state).contactInfoRoute = ProfileRoutes.buildContactInfoRoute(str3).toString();
          localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, localProfileDataProvider.getPostRequestBuilder(str4, str3, (RecordTemplate)localObject, Request.get().url(state).contactInfoRoute).builder(ProfileContactInfo.BUILDER), true));
          return;
        }
        goBackToPreviousFragment();
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.d(TAG, "Failed to generate diff for update: " + localJSONException.getMessage());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileContactInfoEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */