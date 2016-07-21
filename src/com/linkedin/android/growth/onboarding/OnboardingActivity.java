package com.linkedin.android.growth.onboarding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.growth.lego.LegoBundleBuilder;
import com.linkedin.android.growth.lego.LegoFlowNavigation;
import com.linkedin.android.growth.lego.LegoGroupContent;
import com.linkedin.android.growth.lego.LegoManager;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.lego.LegoWidgetContent;
import com.linkedin.android.growth.lego.LegoWidgetMultiplexCompletionCallback;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationBundle;
import com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationLoadingFragmentFactory;
import com.linkedin.android.growth.onboarding.greeting.GreetingBundle;
import com.linkedin.android.growth.onboarding.greeting.GreetingFragment;
import com.linkedin.android.growth.onboarding.greeting.GreetingFragmentFactory;
import com.linkedin.android.growth.utils.EmailConfirmationUtils;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import java.util.List;
import javax.inject.Inject;

public class OnboardingActivity
  extends BaseActivity
  implements LegoFlowNavigation
{
  private String currentLegoWidgetTag;
  @Inject
  FragmentRegistry fragmentRegistry;
  @Inject
  I18NManager i18nManager;
  @Inject
  LegoManager manager;
  @Inject
  MemberUtil memberUtil;
  @Inject
  OnboardingDataProvider onboardingDataProvider;
  @Inject
  OnboardingLegoWidgetSwitch onboardingLegoWidgetSwitch;
  @Inject
  Tracker tracker;
  
  private void fireLegoNoDataEvent(String paramString)
  {
    activityComponent.legoTrackingDataProvider().sendWidgetImpressionEvent$4bb724c7(paramString, Visibility.NO_DATA);
  }
  
  private void startWidget(String paramString, LegoWidget paramLegoWidget)
  {
    if (isResumed)
    {
      currentLegoWidgetTag = paramString;
      getAnimationFragmentTransaction(2131034161, 2131034164, 2131034160, 2131034165).replace(2131756103, paramLegoWidget, paramString).addToBackStack(paramString).commit();
    }
    while (TextUtils.isEmpty(currentLegoWidgetTag)) {
      return;
    }
    manager.skipToWidget(currentLegoWidgetTag);
  }
  
  private void switchToWidget(final WidgetContent paramWidgetContent, Bundle paramBundle)
  {
    final LegoWidget localLegoWidget;
    if (paramBundle == null)
    {
      paramBundle = new Bundle();
      localLegoWidget = onboardingLegoWidgetSwitch.getLegoWidget(paramWidgetContent, paramBundle);
      if (LegoBundleBuilder.getHomeIntent(paramBundle) == null) {
        break label42;
      }
      exitFlow(LegoBundleBuilder.getHomeIntent(paramBundle));
    }
    label42:
    int i;
    do
    {
      return;
      break;
      if (LegoBundleBuilder.getRebuildMyFeedIntent(paramBundle) != null)
      {
        exitFlow(LegoBundleBuilder.getRebuildMyFeedIntent(paramBundle));
        return;
      }
      if (localLegoWidget == null)
      {
        moveToNextLegoWidget();
        return;
      }
      i = localLegoWidget.getStatus(activityComponent);
      if (i != 1) {
        break label124;
      }
      paramBundle = activityComponent;
      paramWidgetContent = widgetId;
    } while (localLegoWidget.loadData(paramBundle, new LegoWidgetMultiplexCompletionCallback(activityComponent, localLegoWidget)
    {
      protected final void onDataReady$34d43c58()
      {
        int i = localLegoWidget.getStatus(activityComponent);
        if (i == 2)
        {
          OnboardingActivity.this.fireLegoNoDataEvent(localLegoWidget.getTrackingToken());
          OnboardingActivity.access$100(OnboardingActivity.this, localLegoWidget.getTrackingToken());
          moveToNextLegoWidget();
          return;
        }
        if (i == 4)
        {
          OnboardingActivity.access$100(OnboardingActivity.this, localLegoWidget.getTrackingToken());
          moveToNextLegoWidget();
          return;
        }
        OnboardingActivity.this.startWidget(paramWidgetContent, localLegoWidget);
      }
    }));
    moveToNextLegoWidget();
    return;
    label124:
    if (i == 2)
    {
      fireLegoNoDataEvent(localLegoWidget.getTrackingToken());
      moveToNextLegoWidget();
      return;
    }
    if (i == 4)
    {
      moveToNextLegoWidget();
      return;
    }
    startWidget(widgetId, localLegoWidget);
  }
  
  public final void exitFlow(Intent paramIntent)
  {
    if (paramIntent != null) {
      startActivity(paramIntent);
    }
    for (;;)
    {
      supportFinishAfterTransition();
      return;
      startActivity(intentRegistry.home.newIntent(this, null).setFlags(268468224));
    }
  }
  
  public final int getFlowContainer()
  {
    return 2131756103;
  }
  
  public final int getFlowLayout()
  {
    return 2130968834;
  }
  
  public final void moveToNextGroupLegoWidget()
  {
    Object localObject = manager;
    LegoGroupContent localLegoGroupContent = currentWidget.group.next;
    if (localLegoGroupContent == null) {}
    for (localObject = null; localObject == null; localObject = currentWidget.widgetContent)
    {
      exitFlow(null);
      return;
      if (widgets.size() == 0) {
        Util.safeThrow$7a8b4789(new IllegalStateException("Group should not have empty list of widgets"));
      }
      currentWidget = ((LegoWidgetContent)widgets.get(0));
    }
    switchToWidget((WidgetContent)localObject, null);
  }
  
  public final void moveToNextLegoWidget()
  {
    WidgetContent localWidgetContent = manager.goToNextLegoWidget();
    if (localWidgetContent == null)
    {
      exitFlow(null);
      return;
    }
    switchToWidget(localWidgetContent, null);
  }
  
  public final void moveToPreviousLegoWidget()
  {
    if (getSupportFragmentManager().getBackStackEntryCount() == 1)
    {
      supportFinishAfterTransition();
      return;
    }
    currentLegoWidgetTag = getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount() - 2).getName();
    if (!TextUtils.isEmpty(currentLegoWidgetTag)) {
      manager.skipToWidget(currentLegoWidgetTag);
    }
    getSupportFragmentManager().popBackStackImmediate();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (currentLegoWidgetTag != null) {
      ((LegoWidget)getSupportFragmentManager().findFragmentByTag(currentLegoWidgetTag)).onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    LegoWidget localLegoWidget = (LegoWidget)getSupportFragmentManager().findFragmentByTag(currentLegoWidgetTag);
    if (localLegoWidget != null)
    {
      localLegoWidget.handleBack();
      super.fireBackPressedControlInteractionEvent();
      return;
    }
    if ((getSupportFragmentManager().getFragments().size() == 1) && ((getSupportFragmentManager().getFragments().get(0) instanceof GreetingFragment)))
    {
      super.onBackPressed();
      return;
    }
    Util.safeThrow$7a8b4789(new IllegalStateException("Something got messed up with the lego navigation state. currentLegoWidgetTag: " + currentLegoWidgetTag + " manager.currentWidget: " + manager.currentWidget.widgetContent));
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    super.onCreate(paramBundle);
    activityComponent.inject(this);
    setContentView(2130968834);
    Object localObject = getIntent().getExtras();
    boolean bool1;
    MiniProfile localMiniProfile;
    if (!TextUtils.isEmpty(OnboardingBundleBuilder.getLapseUserTrackingToken((Bundle)localObject)))
    {
      bool1 = true;
      if (paramBundle != null) {
        break label247;
      }
      paramBundle = null;
      localMiniProfile = memberUtil.getMiniProfile();
      if (localMiniProfile != null)
      {
        if (!OnboardingBundleBuilder.isOnboardingResume(getIntent().getExtras())) {
          break label186;
        }
        paramBundle = i18nManager.getString(2131231612, new Object[] { I18NManager.getName(localMiniProfile) });
      }
      label101:
      if ((localObject == null) || (!((Bundle)localObject).getBoolean("isDebug", false))) {
        break label242;
      }
    }
    for (;;)
    {
      localObject = new GreetingBundle(bool1);
      bundle.putString("greeting", paramBundle);
      bundle.putBoolean("debug", bool2);
      getSupportFragmentManager().beginTransaction().replace(2131756103, fragmentRegistry.greeting.newFragment((BundleBuilder)localObject)).commit();
      return;
      bool1 = false;
      break;
      label186:
      if (bool1)
      {
        paramBundle = i18nManager.getString(2131231557, new Object[] { I18NManager.getName(localMiniProfile) });
        break label101;
      }
      paramBundle = i18nManager.getString(2131231574, new Object[] { I18NManager.getName(localMiniProfile) });
      break label101;
      label242:
      bool2 = false;
    }
    label247:
    localObject = (OnboardingDataProvider.OnboardingState)onboardingDataProvider.state;
    if (bool1) {}
    for (paramBundle = Routes.ONBOARDING_LAPSE_FLOW.buildUponRoot().toString();; paramBundle = Routes.ONBOARDING_FLOW.buildUponRoot().toString())
    {
      onboardingFlowRoute = paramBundle;
      onboardingDataProvider.loadDataModelFromCache(onboardingDataProvider.state).onboardingFlowRoute, new DefaultModelListener()
      {
        public final void onCacheError(DataManagerException paramAnonymousDataManagerException)
        {
          super.onCacheError(paramAnonymousDataManagerException);
          Log.e("Failed to load onboarding flow from cache", paramAnonymousDataManagerException);
          exitFlow(null);
        }
      }, PageContent.BUILDER);
      return;
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    currentLegoWidgetTag = paramBundle.getString("currentLegoWidgetTag");
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("currentLegoWidgetTag", currentLegoWidgetTag);
  }
  
  public final void startFlow()
  {
    if (!isResumed) {
      return;
    }
    if (currentLegoWidgetTag != null)
    {
      manager.skipToWidget(currentLegoWidgetTag);
      return;
    }
    Object localObject1 = null;
    Object localObject2 = getIntent().getExtras();
    int i;
    label79:
    WidgetContent localWidgetContent;
    if ((localObject2 != null) && (((Bundle)localObject2).getBoolean("emailConfirmation")))
    {
      i = 1;
      if (i == 0) {
        break label242;
      }
      localObject2 = getIntent().getExtras();
      if (localObject2 == null) {
        break label154;
      }
      str = ((Bundle)localObject2).getString("originalUrl");
      localWidgetContent = manager.skipToWidget("voyager_onboarding_email_confirmation");
      if ((str == null) || (localWidgetContent == null) || (!EmailConfirmationUtils.isUrlGeneratedDuringReg(str))) {
        break label160;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("originalUrl", str);
      localObject2 = localWidgetContent;
    }
    for (;;)
    {
      if (!getSupportFragmentManager().popBackStackImmediate())
      {
        if (localObject2 != null) {
          break label258;
        }
        exitFlow(null);
        return;
        i = 0;
        break;
        label154:
        str = null;
        break label79;
        label160:
        localObject2 = localWidgetContent;
        if (str != null)
        {
          localObject1 = new EmailConfirmationBundle().setConfirmEmailUrl(str);
          bundle.putBoolean("isFirstTimeConfirmingPrimaryEmail", false);
          if (localWidgetContent != null)
          {
            localObject2 = trackingToken;
            bundle.putString("widgetTrackingToken", (String)localObject2);
          }
          getSupportFragmentManager().beginTransaction().replace(2131756103, fragmentRegistry.onboardingEmailConfirmationLoading.newFragment((BundleBuilder)localObject1)).commit();
          return;
          label242:
          localObject2 = manager.currentWidget.widgetContent;
          localObject1 = null;
        }
      }
    }
    label258:
    String str = OnboardingBundleBuilder.getLapseUserTrackingToken(getIntent().getExtras());
    if (!TextUtils.isEmpty(str)) {
      activityComponent.legoTrackingDataProvider().sendWidgetImpressionEvent$4bb724c7(str, Visibility.SHOW);
    }
    switchToWidget((WidgetContent)localObject2, (Bundle)localObject1);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */