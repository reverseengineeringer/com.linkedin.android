package com.linkedin.android.identity.guidededit.infra.shared;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.routes.RouteDefinition;
import com.linkedin.android.deeplink.routes.RoutePart;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.identity.edit.ProfileEducationEditFragment;
import com.linkedin.android.identity.edit.ProfilePositionEditFragment;
import com.linkedin.android.identity.guidededit.GuidedEditActivity;
import com.linkedin.android.identity.guidededit.educationv2.GuidedEditEducationBundleBuilder;
import com.linkedin.android.identity.guidededit.infra.GuidedEditBaseBundleBuilder;
import com.linkedin.android.identity.guidededit.infra.GuidedEditFragmentHelper;
import com.linkedin.android.identity.guidededit.positionv2.GuidedEditPositionBundleBuilder;
import com.linkedin.android.identity.guidededit.suggestedpublications.GuidedEditSuggestedPublicationsBundleBuilder;
import com.linkedin.android.identity.profile.ProfileBundleBuilder;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.CategoryNames;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Education;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Position;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompany;
import com.linkedin.data.lite.BuilderException;
import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;

public final class GuidedEditIntent
  extends IntentFactory<GuidedEditBaseBundleBuilder>
  implements DeeplinkIntent
{
  private static boolean isMeTabProfile;
  private static EnumMap<GuidedEditLegacyTaskName, CategoryNames> legacyTaskNameCategoryNamesEnumMap;
  
  static
  {
    EnumMap localEnumMap = new EnumMap(GuidedEditLegacyTaskName.class);
    legacyTaskNameCategoryNamesEnumMap = localEnumMap;
    localEnumMap.put(GuidedEditLegacyTaskName.ADD_CURRENT_POSITION, CategoryNames.ADD_CURRENT_POSITION);
    legacyTaskNameCategoryNamesEnumMap.put(GuidedEditLegacyTaskName.ADD_POSITION, CategoryNames.ADD_CURRENT_POSITION);
    legacyTaskNameCategoryNamesEnumMap.put(GuidedEditLegacyTaskName.SCHOOL_NAME, CategoryNames.ADD_EDUCATION);
    legacyTaskNameCategoryNamesEnumMap.put(GuidedEditLegacyTaskName.ADD_POSITION_NEW, CategoryNames.ADD_CURRENT_POSITION);
    legacyTaskNameCategoryNamesEnumMap.put(GuidedEditLegacyTaskName.SUGGESTED_SKILLS, CategoryNames.ADD_SUGGESTED_SKILLS);
  }
  
  private static Intent setIsMeTabProfile(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean) {
      paramIntent.putExtras(ProfileBundleBuilder.createMeTabProfile().build());
    }
    return paramIntent;
  }
  
  public static void setIsMeTabProfile(boolean paramBoolean)
  {
    isMeTabProfile = paramBoolean;
  }
  
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    Intent localIntent = provideIntent(paramContext);
    ProfileBundleBuilder localProfileBundleBuilder = ProfileBundleBuilder.createSelfProfile();
    paramContext = GuidedEditSource.DEEPLINK;
    bundle.putSerializable("guidedEditSource", paramContext);
    paramString = Uri.parse(paramString).getQueryParameter("startTask");
    paramArrayMap = null;
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        paramContext = GuidedEditLegacyTaskName.valueOf(paramString.toUpperCase(Locale.US));
        paramLinkingRoutes = (CategoryNames)legacyTaskNameCategoryNamesEnumMap.get(paramContext);
        paramContext = paramArrayMap;
        if (paramLinkingRoutes != null) {
          paramContext = GuidedEditFragmentHelper.getForcedCategoryPath(paramLinkingRoutes.name());
        }
      }
      catch (IllegalArgumentException paramContext)
      {
        Log.e("Wrong start task name: " + paramString, paramContext);
        paramContext = paramArrayMap;
        continue;
      }
      if (!TextUtils.isEmpty(paramContext))
      {
        bundle.putString("guidedEditForceCategory", paramContext);
        bundle.putBoolean("shouldLoadProfileViewData", true);
      }
      paramContext = GuidedEditBaseBundleBuilder.wrap(localProfileBundleBuilder.build());
      paramContext.setFlowTrackingId(GuidedEditFragmentHelper.generateRandomTrackingId());
      localIntent.putExtras(paramContext.build());
      return localIntent;
      paramString = routeDefinition.segments;
      paramContext = paramArrayMap;
      if (paramString.size() > 0) {
        paramContext = GuidedEditFragmentHelper.getForcedCategoryPath(getsize1staticSegment);
      }
    }
  }
  
  public final Intent getDemoIntent(Context paramContext, CategoryNames paramCategoryNames)
  {
    paramContext = provideIntent(paramContext);
    GuidedEditBaseBundleBuilder localGuidedEditBaseBundleBuilder = GuidedEditBaseBundleBuilder.create();
    localGuidedEditBaseBundleBuilder.setGuidedEditSource(GuidedEditSource.DEEPLINK);
    localGuidedEditBaseBundleBuilder.setGuidedEditForceCategoryPath(GuidedEditFragmentHelper.getForcedCategoryPath(paramCategoryNames.name()));
    localGuidedEditBaseBundleBuilder.setFlowTrackingId(GuidedEditFragmentHelper.generateRandomTrackingId());
    paramContext.putExtras(localGuidedEditBaseBundleBuilder.build());
    return paramContext;
  }
  
  public final Intent getIntentForCategory(Context paramContext, GuidedEditCategory paramGuidedEditCategory, GuidedEditSource paramGuidedEditSource, String paramString)
  {
    paramContext = provideIntent(paramContext);
    paramGuidedEditCategory = GuidedEditBaseBundleBuilder.create().setCategory(paramGuidedEditCategory).setGuidedEditSource(paramGuidedEditSource);
    if (paramString == null) {
      paramGuidedEditCategory.setFlowTrackingId(GuidedEditFragmentHelper.generateRandomTrackingId());
    }
    for (;;)
    {
      paramContext.putExtras(paramGuidedEditCategory.build());
      setIsMeTabProfile(isMeTabProfile, paramContext);
      return paramContext;
      paramGuidedEditCategory.setFlowTrackingId(paramString);
    }
  }
  
  public final Intent getIntentForMeCardSuggestion(Context paramContext, GuidedEditSource paramGuidedEditSource, String paramString1, String paramString2, String paramString3, CategoryNames paramCategoryNames)
  {
    paramContext = provideIntent(paramContext);
    paramCategoryNames = GuidedEditFragmentHelper.getForcedCategoryPath(paramCategoryNames.name());
    GuidedEditSuggestedPublicationsBundleBuilder localGuidedEditSuggestedPublicationsBundleBuilder = new GuidedEditSuggestedPublicationsBundleBuilder();
    bundle = new Bundle();
    paramGuidedEditSource = localGuidedEditSuggestedPublicationsBundleBuilder.setGuidedEditForceCategoryPath(paramCategoryNames).setGuidedEditSource(paramGuidedEditSource);
    bundle.putString("meNotificationId", paramString2);
    paramGuidedEditSource = paramGuidedEditSource.setFlowTrackingId(paramString3);
    bundle.putString("guidedEditSuggestionId", paramString1);
    paramContext.putExtras(paramGuidedEditSource.build());
    setIsMeTabProfile(isMeTabProfile, paramContext);
    return paramContext;
  }
  
  public final Intent getIntentForUpdateEducation(Context paramContext, GuidedEditCategory paramGuidedEditCategory, GuidedEditSource paramGuidedEditSource, Education paramEducation, String paramString)
  {
    paramContext = provideIntent(paramContext);
    GuidedEditEducationBundleBuilder localGuidedEditEducationBundleBuilder = new GuidedEditEducationBundleBuilder();
    bundle = new Bundle();
    if (paramString == null) {
      localGuidedEditEducationBundleBuilder.setFlowTrackingId(GuidedEditFragmentHelper.generateRandomTrackingId());
    }
    for (;;)
    {
      try
      {
        localGuidedEditEducationBundleBuilder.setNormEducation(ProfileEducationEditFragment.normalizeEducation(paramEducation));
        if (entityUrn != null) {
          localGuidedEditEducationBundleBuilder.setPostEntityId(entityUrn.getLastId());
        }
        if (school != null) {
          localGuidedEditEducationBundleBuilder.setMiniSchool(school);
        }
      }
      catch (BuilderException paramEducation)
      {
        Util.safeThrow$7a8b4789(new RuntimeException("Failed to start update education task ", paramEducation));
        continue;
      }
      localGuidedEditEducationBundleBuilder.setCategory(paramGuidedEditCategory);
      localGuidedEditEducationBundleBuilder.setGuidedEditSource(paramGuidedEditSource);
      paramContext.putExtras(localGuidedEditEducationBundleBuilder.build());
      setIsMeTabProfile(isMeTabProfile, paramContext);
      return paramContext;
      localGuidedEditEducationBundleBuilder.setFlowTrackingId(paramString);
    }
  }
  
  public final Intent getIntentForUpdatePosition(Context paramContext, GuidedEditCategory paramGuidedEditCategory, GuidedEditSource paramGuidedEditSource, Position paramPosition, String paramString)
  {
    paramContext = provideIntent(paramContext);
    GuidedEditPositionBundleBuilder localGuidedEditPositionBundleBuilder = new GuidedEditPositionBundleBuilder();
    bundle = new Bundle();
    if (paramString == null) {
      localGuidedEditPositionBundleBuilder.setFlowTrackingId(GuidedEditFragmentHelper.generateRandomTrackingId());
    }
    for (;;)
    {
      try
      {
        localGuidedEditPositionBundleBuilder.setPosition(ProfilePositionEditFragment.normalizePosition(paramPosition));
        if (entityUrn != null) {
          localGuidedEditPositionBundleBuilder.setPostEntityId(entityUrn.getLastId());
        }
        if (company != null) {
          localGuidedEditPositionBundleBuilder.setMiniCompany(company.miniCompany);
        }
      }
      catch (BuilderException paramPosition)
      {
        Util.safeThrow$7a8b4789(new RuntimeException("Failed to start update position task ", paramPosition));
        continue;
      }
      localGuidedEditPositionBundleBuilder.setCategory(paramGuidedEditCategory);
      localGuidedEditPositionBundleBuilder.setGuidedEditSource(paramGuidedEditSource);
      paramContext.putExtras(localGuidedEditPositionBundleBuilder.build());
      setIsMeTabProfile(isMeTabProfile, paramContext);
      return paramContext;
      localGuidedEditPositionBundleBuilder.setFlowTrackingId(paramString);
    }
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, GuidedEditActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.infra.shared.GuidedEditIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */