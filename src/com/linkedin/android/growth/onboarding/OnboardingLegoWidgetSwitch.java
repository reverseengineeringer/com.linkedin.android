package com.linkedin.android.growth.onboarding;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.linkedin.android.growth.boost.splash.BoostSplashLegoWidget;
import com.linkedin.android.growth.lego.LegoBundleBuilder;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.lego.LegoWidgetSwitch;
import com.linkedin.android.growth.onboarding.abi.OnboardingAbiM2GLegoWidget;
import com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GEmailOnlyLegoWidget;
import com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GSmsOnlyLegoWidget;
import com.linkedin.android.growth.onboarding.abi.m2g.OnboardingAbiM2GUnifiedSMSEmailLegoWidget;
import com.linkedin.android.growth.onboarding.abi.m2m.OnboardingAbiM2MLegoWidget;
import com.linkedin.android.growth.onboarding.abi.splash.OnboardingAbiSplashLegoWidget;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationLegoWidget;
import com.linkedin.android.growth.onboarding.jobseeker_promo.JobseekerPromoLegoWidget;
import com.linkedin.android.growth.onboarding.location.LocationLegoWidget;
import com.linkedin.android.growth.onboarding.phonetic_name.PhoneticNameLegoWidget;
import com.linkedin.android.growth.onboarding.photo.PhotoLegoWidget;
import com.linkedin.android.growth.onboarding.position_education.PositionLegoWidget;
import com.linkedin.android.growth.onboarding.pymk.PymkLegoWidget;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedBundleBuilder;
import com.linkedin.android.growth.onboarding.rbmf.RebuildMyFeedIntent;
import com.linkedin.android.growth.onboarding.welcome_mat.WelcomeMatLegoWidget;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;
import javax.inject.Inject;

public final class OnboardingLegoWidgetSwitch
  extends LegoWidgetSwitch
{
  private Context context;
  @Inject
  FlagshipSharedPreferences flagshipSharedPreferences;
  @Inject
  FragmentRegistry fragmentRegistry;
  private IntentRegistry intentRegistry;
  
  @Inject
  public OnboardingLegoWidgetSwitch(Context paramContext, IntentRegistry paramIntentRegistry)
  {
    context = paramContext;
    intentRegistry = paramIntentRegistry;
  }
  
  private Intent createHomeIntent(HomeTabInfo paramHomeTabInfo)
  {
    HomeBundle localHomeBundle = new HomeBundle();
    activeTab = paramHomeTabInfo;
    paramHomeTabInfo = intentRegistry.home.newIntent(context, localHomeBundle);
    paramHomeTabInfo.setFlags(268468224);
    return paramHomeTabInfo;
  }
  
  protected final LegoWidget detectLegoWidget(WidgetContent paramWidgetContent, Bundle paramBundle)
  {
    paramWidgetContent = widgetId;
    int i = -1;
    switch (paramWidgetContent.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        Log.e("Lego widget : " + paramWidgetContent + " is unsupported");
      }
      break;
    }
    do
    {
      return null;
      if (!paramWidgetContent.equals("voyager_onboarding_profile_edit_phonetic_name")) {
        break;
      }
      i = 0;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_profile_edit_occupation")) {
        break;
      }
      i = 1;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_profile_edit_location")) {
        break;
      }
      i = 2;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_profile_edit_photo")) {
        break;
      }
      i = 3;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_abi")) {
        break;
      }
      i = 4;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_m2m")) {
        break;
      }
      i = 5;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_m2g")) {
        break;
      }
      i = 6;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_m2g_email_only")) {
        break;
      }
      i = 7;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_m2g_sms_only")) {
        break;
      }
      i = 8;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_unified_m2g_email_sms")) {
        break;
      }
      i = 9;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_email_confirmation")) {
        break;
      }
      i = 10;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_welcome_mat")) {
        break;
      }
      i = 11;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_pymk")) {
        break;
      }
      i = 12;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_jobseeker_promo")) {
        break;
      }
      i = 13;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_boost_splash")) {
        break;
      }
      i = 14;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_landing_feed_tab")) {
        break;
      }
      i = 15;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_landing_me_tab")) {
        break;
      }
      i = 16;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_landing_search_tab")) {
        break;
      }
      i = 17;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_landing_people_tab")) {
        break;
      }
      i = 18;
      break;
      if (!paramWidgetContent.equals("debug_placeholder")) {
        break;
      }
      i = 19;
      break;
      if (!paramWidgetContent.equals("voyager_onboarding_landing_rebuild_my_feed_screen")) {
        break;
      }
      i = 20;
      break;
      return PhoneticNameLegoWidget.newInstance();
      return PositionLegoWidget.newInstance();
      return LocationLegoWidget.newInstance();
      return PhotoLegoWidget.newInstance();
      return new OnboardingAbiSplashLegoWidget();
      return new OnboardingAbiM2MLegoWidget();
      return new OnboardingAbiM2GLegoWidget();
      return new OnboardingAbiM2GEmailOnlyLegoWidget();
      return new OnboardingAbiM2GSmsOnlyLegoWidget();
      return new OnboardingAbiM2GUnifiedSMSEmailLegoWidget();
      return EmailConfirmationLegoWidget.newInstance(paramBundle);
      return WelcomeMatLegoWidget.newInstance();
      return PymkLegoWidget.newInstance();
      return new JobseekerPromoLegoWidget();
    } while (!flagshipSharedPreferences.getPreferences().getBoolean("boostUpgradeStatus", false));
    return new BoostSplashLegoWidget();
    LegoBundleBuilder.addHomeIntent(paramBundle, createHomeIntent(HomeTabInfo.FEED));
    return null;
    LegoBundleBuilder.addHomeIntent(paramBundle, createHomeIntent(HomeTabInfo.NOTIFICATIONS));
    return null;
    LegoBundleBuilder.addHomeIntent(paramBundle, createHomeIntent(HomeTabInfo.SEARCH));
    return null;
    LegoBundleBuilder.addHomeIntent(paramBundle, createHomeIntent(HomeTabInfo.RELATIONSHIPS));
    return null;
    return new OnboardingPlaceholderWidget();
    paramWidgetContent = intentRegistry.rebuildMyFeedIntent.newIntent(context, RebuildMyFeedBundleBuilder.createBundle(false));
    paramWidgetContent.setFlags(268468224);
    paramBundle.putParcelable("rebuildMyFeedIntent", paramWidgetContent);
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingLegoWidgetSwitch
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */