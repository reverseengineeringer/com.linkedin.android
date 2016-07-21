package com.linkedin.android.identity.guidededit.infra;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.TextView;
import com.linkedin.android.identity.guidededit.educationv2.GuidedEditEducationBundleBuilder;
import com.linkedin.android.identity.guidededit.educationv2.GuidedEditEducationFragmentFactory;
import com.linkedin.android.identity.guidededit.industry.GuidedEditIndustryFragmentFactory;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditSource;
import com.linkedin.android.identity.guidededit.location.GuidedEditLocationFragmentFactory;
import com.linkedin.android.identity.guidededit.photo.GuidedEditPhotoFactory;
import com.linkedin.android.identity.guidededit.positionv2.GuidedEditPositionBundleBuilder;
import com.linkedin.android.identity.guidededit.positionv2.GuidedEditPositionFragmentFactory;
import com.linkedin.android.identity.guidededit.suggestedcertifications.GuidedEditSuggestedCertificationFragmentFactory;
import com.linkedin.android.identity.guidededit.suggestedpatents.GuidedEditSuggestedPatentsTaskFragmentFactory;
import com.linkedin.android.identity.guidededit.suggestedpublications.GuidedEditSuggestedPublicationTaskFragmentFactory;
import com.linkedin.android.identity.guidededit.suggestedskills.GuidedEditSuggestedSkillsTaskFragmentFactory;
import com.linkedin.android.identity.guidededit.suggestedskills.GuidedEditSuggestedSkillsTransformer;
import com.linkedin.android.identity.me.shared.actions.MeActionBundleBuilder;
import com.linkedin.android.identity.me.shared.actions.MeActionBundleBuilder.Action;
import com.linkedin.android.identity.me.shared.actions.SnackbarMeActionBundleBuilder;
import com.linkedin.android.identity.me.shared.actions.events.MePostExecuteActionEvent;
import com.linkedin.android.identity.profile.ProfileBundleBuilder;
import com.linkedin.android.identity.profile.ProfileViewIntent;
import com.linkedin.android.identity.shared.validators.base.BaseTextFieldValidator;
import com.linkedin.android.identity.shared.validators.forms.BaseFormValidator;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.CategoryNames;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.ContextType;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditProfileUpdate;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditProfileUpdate.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditProfileUpdate.ProfileUpdate;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditProfileUpdate.ProfileUpdate.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.ProfileCategories;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.Suggestion;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEducation;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.UnionMemberCountException;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditCategoryName;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditContextType;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditEntryAction;
import com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditEntryImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.identity.Contributor.Builder;
import com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.identity.SuggestedContributorImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditActionType;
import com.linkedin.gen.avro2pegasus.events.identity.SuggestedEditImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.identity.SuggestionSource;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public final class GuidedEditFragmentHelper
{
  private static com.linkedin.gen.avro2pegasus.events.identity.Contributor convertToContributorInTrackingEvent(com.linkedin.android.pegasus.gen.voyager.identity.profile.Contributor paramContributor)
  {
    try
    {
      Contributor.Builder localBuilder = new Contributor.Builder();
      if (hasName)
      {
        localBuilder.setName(name);
        if ((hasProfileUrn) && (profileUrn != null))
        {
          paramContributor = profileUrn.toString();
          if (paramContributor != null) {
            break label119;
          }
          hasMemberUrn = false;
        }
      }
      for (memberUrn = null;; memberUrn = paramContributor)
      {
        return localBuilder.build(RecordTemplate.Flavor.RECORD);
        if ((!hasMember) || (member == null)) {
          break;
        }
        MiniProfile localMiniProfile = member;
        localBuilder.setName(firstName + lastName);
        break;
        label119:
        hasMemberUrn = true;
      }
      return null;
    }
    catch (BuilderException paramContributor) {}
  }
  
  public static GuidedEditContextType convertToGuidedEditContextType(GuidedEditSource paramGuidedEditSource)
  {
    if (paramGuidedEditSource == GuidedEditSource.ORGANIC) {
      return GuidedEditContextType.PROFILE_VIEW;
    }
    return GuidedEditContextType.of(paramGuidedEditSource.name());
  }
  
  public static ContextType convertToUeditContextType(GuidedEditSource paramGuidedEditSource)
  {
    if (paramGuidedEditSource == GuidedEditSource.ORGANIC) {
      return ContextType.PROFILE_VIEW;
    }
    return ContextType.of(paramGuidedEditSource.name());
  }
  
  public static String generateRandomTrackingId()
  {
    UUID localUUID = UUID.randomUUID();
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[16]);
    localByteBuffer.putLong(localUUID.getMostSignificantBits());
    localByteBuffer.putLong(localUUID.getLeastSignificantBits());
    return Base64.encodeToString(localByteBuffer.array(), 2);
  }
  
  public static String getFlowTrackingId(Suggestion paramSuggestion, Bundle paramBundle)
  {
    String str = paramBundle.getString("flowTrackingId");
    paramBundle = str;
    if (str == null)
    {
      paramBundle = str;
      if (paramSuggestion != null) {
        paramBundle = flowTrackingId;
      }
    }
    return paramBundle;
  }
  
  public static String getForcedCategoryPath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = CategoryNames.of(paramString.replace("-", "_").toUpperCase(Locale.US));
    switch (GuidedEditFragmentHelper.1.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$identity$guidededit$CategoryNames[paramString.ordinal()])
    {
    case 10: 
    case 11: 
    case 12: 
    default: 
      return null;
    }
    return ("hydra:" + paramString.toString()).toLowerCase(Locale.US);
  }
  
  public static int getGuidedEditEntryCardSlotInPymk$34bfd0e9(LixManager paramLixManager)
  {
    int i = -1;
    paramLixManager = paramLixManager.getTreatment(Lix.GUIDED_EDIT_U_EDIT_PYMK_ENTRY_SLOT).split("-");
    if (paramLixManager.length == 2) {}
    try
    {
      i = Integer.valueOf(paramLixManager[1]).intValue();
      i -= 1;
      return i;
    }
    catch (NumberFormatException paramLixManager)
    {
      Util.safeThrow$7a8b4789(new RuntimeException(paramLixManager));
    }
    return -1;
  }
  
  public static GuidedEditTaskFragmentFactory getGuidedEditFragmentFactory(CategoryNames paramCategoryNames)
  {
    switch (GuidedEditFragmentHelper.1.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$identity$guidededit$CategoryNames[paramCategoryNames.ordinal()])
    {
    default: 
      return null;
    case 1: 
    case 2: 
      return new GuidedEditEducationFragmentFactory();
    case 3: 
    case 4: 
    case 5: 
      return new GuidedEditPositionFragmentFactory();
    case 6: 
      return new GuidedEditSuggestedCertificationFragmentFactory();
    case 7: 
      return new GuidedEditSuggestedSkillsTaskFragmentFactory();
    case 8: 
      return new GuidedEditSuggestedPublicationTaskFragmentFactory();
    case 9: 
      return new GuidedEditSuggestedPatentsTaskFragmentFactory();
    case 10: 
      return new GuidedEditIndustryFragmentFactory();
    case 11: 
      return new GuidedEditLocationFragmentFactory();
    }
    return new GuidedEditPhotoFactory();
  }
  
  public static GuidedEditProfileUpdate getGuidedEditProfileUpdate(GuidedEditBaseBundleBuilder paramGuidedEditBaseBundleBuilder)
  {
    int i = 0;
    Object localObject2 = paramGuidedEditBaseBundleBuilder.build();
    paramGuidedEditBaseBundleBuilder = GuidedEditPositionBundleBuilder.getPosition((Bundle)localObject2);
    Object localObject1 = GuidedEditEducationBundleBuilder.getNormEducation((Bundle)localObject2);
    if ((GuidedEditBaseBundleBuilder.getCategory((Bundle)localObject2) == null) || ((paramGuidedEditBaseBundleBuilder == null) && (localObject1 == null))) {
      return null;
    }
    localObject2 = new GuidedEditProfileUpdate.ProfileUpdate.Builder();
    if (paramGuidedEditBaseBundleBuilder != null) {
      if (paramGuidedEditBaseBundleBuilder == null)
      {
        hasNormPositionValue = false;
        normPositionValue = null;
      }
    }
    for (;;)
    {
      try
      {
        paramGuidedEditBaseBundleBuilder = new GuidedEditProfileUpdate.Builder();
        if (hasNormPositionValue) {
          i = 1;
        }
        int j = i;
        if (hasNormEducationValue) {
          j = i + 1;
        }
        if (j <= 1) {
          break;
        }
        throw new UnionMemberCountException("ProfileUpdate", 2);
      }
      catch (BuilderException paramGuidedEditBaseBundleBuilder)
      {
        Util.safeThrow$7a8b4789(new RuntimeException("error building GuidedEditProfileUpdate", paramGuidedEditBaseBundleBuilder));
        return null;
      }
      hasNormPositionValue = true;
      normPositionValue = paramGuidedEditBaseBundleBuilder;
      continue;
      if (localObject1 == null)
      {
        hasNormEducationValue = false;
        normEducationValue = null;
      }
      else
      {
        hasNormEducationValue = true;
        normEducationValue = ((NormEducation)localObject1);
      }
    }
    localObject1 = new GuidedEditProfileUpdate.ProfileUpdate(normPositionValue, normEducationValue, hasNormPositionValue, hasNormEducationValue);
    hasProfileUpdate = true;
    profileUpdate = ((GuidedEditProfileUpdate.ProfileUpdate)localObject1);
    paramGuidedEditBaseBundleBuilder = paramGuidedEditBaseBundleBuilder.build(RecordTemplate.Flavor.RECORD);
    return paramGuidedEditBaseBundleBuilder;
  }
  
  public static String getLegoTrackingId(GuidedEditCategory paramGuidedEditCategory)
  {
    if (CollectionUtils.isNonEmpty(tasks)) {
      return tasks.get(0)).legoTrackingId;
    }
    return null;
  }
  
  public static void postMeSnackbarAction(ActivityComponent paramActivityComponent, ProfileCategories paramProfileCategories, int paramInt, String paramString)
  {
    MeActionBundleBuilder localMeActionBundleBuilder = MeActionBundleBuilder.create(MeActionBundleBuilder.Action.DISMISS_CARD);
    paramProfileCategories = ProfileBundleBuilder.createSelfProfile().setDefaultCategoryView(paramProfileCategories);
    paramProfileCategories = SnackbarMeActionBundleBuilder.create$32bc305a(paramString, intentRegistryprofileView.newIntent(paramActivityComponent.activity(), paramProfileCategories), paramInt);
    paramActivityComponent.eventBus();
    MePostExecuteActionEvent.replaceCardClickPostExecuteActions$14130d1(Arrays.asList(new MeActionBundleBuilder[] { localMeActionBundleBuilder, paramProfileCategories }));
  }
  
  public static void sendGuidedEditEntryActionEvent(Tracker paramTracker, GuidedEditCategory paramGuidedEditCategory, GuidedEditEntryAction paramGuidedEditEntryAction, GuidedEditSource paramGuidedEditSource, String paramString)
  {
    if (GuidedEditCategoryName.of(id.name()) != GuidedEditCategoryName.$UNKNOWN)
    {
      paramGuidedEditCategory = new GuidedEditEntryActionEvent.Builder();
      if (paramGuidedEditEntryAction == null)
      {
        hasUserAction = false;
        userAction = null;
        paramGuidedEditEntryAction = convertToGuidedEditContextType(paramGuidedEditSource);
        if (paramGuidedEditEntryAction != null) {
          break label91;
        }
        hasContextType = false;
        contextType = null;
        label57:
        if (paramString != null) {
          break label104;
        }
        hasFlowTrackingId = false;
      }
      for (flowTrackingId = null;; flowTrackingId = paramString)
      {
        paramTracker.send(paramGuidedEditCategory);
        return;
        hasUserAction = true;
        userAction = paramGuidedEditEntryAction;
        break;
        label91:
        hasContextType = true;
        contextType = paramGuidedEditEntryAction;
        break label57;
        label104:
        hasFlowTrackingId = true;
      }
    }
    paramTracker = appContext;
    Util.safeThrow$7a8b4789(new RuntimeException("The GuidedEditCategory is unknown."));
  }
  
  public static void sendGuidedEditEntryImpressionEvent(Tracker paramTracker, GuidedEditCategory paramGuidedEditCategory, GuidedEditContextType paramGuidedEditContextType, String paramString)
  {
    paramGuidedEditCategory = GuidedEditCategoryName.of(id.name());
    if (paramGuidedEditCategory != GuidedEditCategoryName.$UNKNOWN)
    {
      paramTracker.send(new GuidedEditEntryImpressionEvent.Builder().setContextType(paramGuidedEditContextType).setGuidedEditCategoryName(paramGuidedEditCategory).setFlowTrackingId(paramString));
      return;
    }
    paramTracker = appContext;
    Util.safeThrow$7a8b4789(new RuntimeException("The GuidedEditCategory is unknown."));
  }
  
  public static void sendSuggestedContributorActionEvent(Tracker paramTracker, String paramString, List<com.linkedin.android.pegasus.gen.voyager.identity.profile.Contributor> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.linkedin.gen.avro2pegasus.events.identity.Contributor localContributor = convertToContributorInTrackingEvent((com.linkedin.android.pegasus.gen.voyager.identity.profile.Contributor)paramList.next());
      if (localContributor != null)
      {
        SuggestedContributorActionEvent.Builder localBuilder = new SuggestedContributorActionEvent.Builder();
        SuggestedEditActionType localSuggestedEditActionType = SuggestedEditActionType.ACCEPT;
        if (localSuggestedEditActionType == null)
        {
          hasActionType = false;
          actionType = null;
          label64:
          if (paramString != null) {
            break label121;
          }
          hasFlowTrackingId = false;
          flowTrackingId = null;
          label80:
          if (localContributor != null) {
            break label136;
          }
          hasContributor = false;
        }
        for (contributor = null;; contributor = localContributor)
        {
          paramTracker.send(localBuilder);
          break;
          hasActionType = true;
          actionType = localSuggestedEditActionType;
          break label64;
          label121:
          hasFlowTrackingId = true;
          flowTrackingId = paramString;
          break label80;
          label136:
          hasContributor = true;
        }
      }
    }
  }
  
  public static void sendSuggestedContributorImpressionEvent(Tracker paramTracker, List<com.linkedin.android.pegasus.gen.voyager.identity.profile.Contributor> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      com.linkedin.gen.avro2pegasus.events.identity.Contributor localContributor = convertToContributorInTrackingEvent((com.linkedin.android.pegasus.gen.voyager.identity.profile.Contributor)localIterator.next());
      if (localContributor != null) {
        localArrayList.add(localContributor);
      }
    }
    if (!paramList.isEmpty())
    {
      paramList = new SuggestedContributorImpressionEvent.Builder();
      if (paramString != null) {
        break label105;
      }
      hasFlowTrackingId = false;
    }
    for (flowTrackingId = null;; flowTrackingId = paramString)
    {
      hasContributors = true;
      contributors = localArrayList;
      paramTracker.send(paramList);
      return;
      label105:
      hasFlowTrackingId = true;
    }
  }
  
  public static void sendSuggestedEditActionEvent(Tracker paramTracker, Suggestion paramSuggestion, String paramString, SuggestedEditActionType paramSuggestedEditActionType)
  {
    SuggestedEditActionEvent.Builder localBuilder = new SuggestedEditActionEvent.Builder();
    if (paramSuggestedEditActionType == null)
    {
      hasActionType = false;
      actionType = null;
      if (paramString != null) {
        break label87;
      }
      hasFlowTrackingId = false;
      flowTrackingId = null;
      label41:
      paramSuggestion = rawProfileElement.toString();
      if (paramSuggestion != null) {
        break label102;
      }
      hasRawProfileElementUrn = false;
    }
    for (rawProfileElementUrn = null;; rawProfileElementUrn = paramSuggestion)
    {
      paramTracker.send(localBuilder);
      return;
      hasActionType = true;
      actionType = paramSuggestedEditActionType;
      break;
      label87:
      hasFlowTrackingId = true;
      flowTrackingId = paramString;
      break label41;
      label102:
      hasRawProfileElementUrn = true;
    }
  }
  
  public static void sendSuggestedEditImpressionEvent(Tracker paramTracker, Suggestion paramSuggestion, GuidedEditCategory paramGuidedEditCategory, Bundle paramBundle)
  {
    Object localObject = GuidedEditBaseBundleBuilder.getGuidedEditSource(paramBundle);
    SuggestedEditImpressionEvent.Builder localBuilder;
    switch (GuidedEditFragmentHelper.1.$SwitchMap$com$linkedin$android$identity$guidededit$infra$shared$GuidedEditSource[localObject.ordinal()])
    {
    default: 
      localObject = SuggestionSource.$UNKNOWN;
      localBuilder = new SuggestedEditImpressionEvent.Builder();
      paramSuggestion = getFlowTrackingId(paramSuggestion, paramBundle);
      if (paramSuggestion == null) {
        hasFlowTrackingId = false;
      }
      break;
    }
    for (flowTrackingId = null;; flowTrackingId = paramSuggestion)
    {
      paramSuggestion = new ArrayList();
      paramGuidedEditCategory = GuidedEditSuggestedSkillsTransformer.toSuggestions(paramGuidedEditCategory).iterator();
      while (paramGuidedEditCategory.hasNext()) {
        paramSuggestion.add(nextrawProfileElement.toString());
      }
      localObject = SuggestionSource.GUIDED_EDIT;
      break;
      localObject = SuggestionSource.EMAIL;
      break;
      localObject = SuggestionSource.NOTIFICATION;
      break;
      hasFlowTrackingId = true;
    }
    hasRawProfileElementUrns = true;
    rawProfileElementUrns = paramSuggestion;
    if (localObject == null) {
      hasSuggestionSource = false;
    }
    for (suggestionSource = null;; suggestionSource = ((SuggestionSource)localObject))
    {
      paramTracker.send(localBuilder);
      return;
      hasSuggestionSource = true;
    }
  }
  
  public static boolean validateDateField$130223a9(Date paramDate1, Date paramDate2, TextView paramTextView, boolean paramBoolean1, boolean paramBoolean2, I18NManager paramI18NManager, boolean paramBoolean3)
  {
    return new BaseFormValidator().setI18NManager(paramI18NManager).setDateErrorTextView(paramTextView).validateDateFields(paramDate1, paramDate2, 1, paramBoolean3, paramBoolean1, paramBoolean2);
  }
  
  public static boolean validateTextField$6807f0ee(String paramString, Urn paramUrn, TextView paramTextView, I18NManager paramI18NManager, boolean paramBoolean)
  {
    paramI18NManager = new BaseFormValidator().setI18NManager(paramI18NManager);
    BaseTextFieldValidator localBaseTextFieldValidator = new BaseTextFieldValidator();
    urn = paramUrn;
    return paramI18NManager.validateTextField$2e4aa0c5(localBaseTextFieldValidator, paramString, paramBoolean, paramTextView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.infra.GuidedEditFragmentHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */