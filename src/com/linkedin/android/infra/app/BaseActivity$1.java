package com.linkedin.android.infra.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.linkedin.android.feed.shared.FeedNavigationUtils;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.growth.onboarding.OnboardingBundleBuilder;
import com.linkedin.android.growth.onboarding.OnboardingIntent;
import com.linkedin.android.growth.onboarding.OnboardingLaunchEvent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.events.ClickableSpanClickEvent;
import com.linkedin.android.infra.events.LaunchAlertEvent;
import com.linkedin.android.infra.shared.AppUpgradeUtils;
import com.linkedin.android.infra.shared.AppUpgradeUtils.1;
import com.linkedin.android.infra.shared.AppUpgradeUtils.2;
import com.linkedin.android.infra.shared.AppUpgradeUtils.3;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.android.pegasus.gen.voyager.common.LaunchAlert;
import com.linkedin.android.pegasus.gen.voyager.common.Takeover;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;

final class BaseActivity$1
{
  BaseActivity$1(BaseActivity paramBaseActivity) {}
  
  @Subscribe
  public final void onEvent(OnboardingLaunchEvent paramOnboardingLaunchEvent)
  {
    paramOnboardingLaunchEvent = new OnboardingBundleBuilder();
    bundle.putBoolean("isOnboardingResume", true);
    this$0.startActivity(this$0.intentRegistry.onboarding.newIntent(this$0, paramOnboardingLaunchEvent));
  }
  
  @Subscribe
  public final void onEvent(ClickableSpanClickEvent paramClickableSpanClickEvent)
  {
    ActivityComponent localActivityComponent = BaseActivity.access$000(this$0);
    if (miniProfile != null) {
      FeedNavigationUtils.openMiniProfile(miniProfile, localActivityComponent);
    }
    do
    {
      return;
      if (miniCompany != null)
      {
        FeedNavigationUtils.openMiniCompany(miniCompany, localActivityComponent, null);
        return;
      }
      if (miniSchool != null)
      {
        FeedNavigationUtils.openMiniSchool(miniSchool, localActivityComponent);
        return;
      }
      if (miniGroup != null)
      {
        FeedNavigationUtils.openMiniGroup(miniGroup, localActivityComponent, null);
        return;
      }
      if (channel != null)
      {
        FeedNavigationUtils.openChannel(channel, localActivityComponent);
        return;
      }
    } while (TextUtils.isEmpty(url));
    if ((update != null) && (FeedTracking.isSponsored(update, localActivityComponent.lixManager())))
    {
      str = url;
      paramClickableSpanClickEvent = WebViewerBundle.createFeedViewer(str, str, null, update, 2);
      localActivityComponent.webRouterUtil().launchWebViewer(paramClickableSpanClickEvent, localActivityComponent, WebRouterUtil.shouldForceIgnoreDeeplink(str));
      return;
    }
    String str = url;
    paramClickableSpanClickEvent = WebViewerBundle.create(str, str, null, webViewerUsage);
    localActivityComponent.webRouterUtil().launchWebViewer(paramClickableSpanClickEvent, localActivityComponent, WebRouterUtil.shouldForceIgnoreDeeplink(str));
  }
  
  @Subscribe
  public final void onEvent(LaunchAlertEvent paramLaunchAlertEvent)
  {
    AppUpgradeUtils localAppUpgradeUtils = this$0.appUpgradeUtils;
    Object localObject1 = this$0;
    Object localObject2 = launchAlert;
    paramLaunchAlertEvent = title;
    String str1 = message;
    String str2 = labelForAction;
    String str3 = labelForCancel;
    boolean bool = hasLabelForCancel;
    localObject2 = new AppUpgradeUtils.1(localAppUpgradeUtils, (Activity)localObject1, (LaunchAlert)localObject2);
    localObject1 = new AlertDialog.Builder((Context)localObject1);
    if (bool) {
      ((AlertDialog.Builder)localObject1).setNegativeButton(str3, null);
    }
    paramLaunchAlertEvent = ((AlertDialog.Builder)localObject1).setTitle(paramLaunchAlertEvent).setMessage(str1).setPositiveButton(str2, new AppUpgradeUtils.2(localAppUpgradeUtils)).setCancelable(bool).create();
    paramLaunchAlertEvent.show();
    paramLaunchAlertEvent.getButton(-1).setOnClickListener(new AppUpgradeUtils.3(localAppUpgradeUtils, bool, paramLaunchAlertEvent, (View.OnClickListener)localObject2));
  }
  
  @Subscribe
  public final void onEvent(List<Takeover> paramList)
  {
    BaseActivity.access$100(this$0, paramList);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.BaseActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */