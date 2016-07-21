package com.linkedin.android.infra.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.security.ProviderInstaller;
import com.google.android.gms.security.ProviderInstaller.ProviderInstallListener;
import com.linkedin.android.authenticator.LaunchActivity;
import com.linkedin.android.feed.shared.FeedNavigationUtils;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.growth.login.LoginActivity;
import com.linkedin.android.growth.login.LoginIntent;
import com.linkedin.android.growth.login.LoginIntentBundle;
import com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroDialogFragment;
import com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroDialogFragmentBundleBuilder;
import com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroDialogFragmentFactory;
import com.linkedin.android.growth.onboarding.OnboardingBundleBuilder;
import com.linkedin.android.growth.onboarding.OnboardingIntent;
import com.linkedin.android.growth.onboarding.OnboardingLaunchEvent;
import com.linkedin.android.growth.seo.samename.SameNameDirectoryActivity;
import com.linkedin.android.growth.takeover.AbiTakeover;
import com.linkedin.android.growth.takeover.CalendarSyncTakeover;
import com.linkedin.android.growth.takeover.NewToVoyagerTakeover;
import com.linkedin.android.growth.takeover.NewToVoyagerTransactionalLaunchManager;
import com.linkedin.android.growth.takeover.OnboardingTakeover;
import com.linkedin.android.growth.takeover.PhoneCollectTakeover;
import com.linkedin.android.growth.takeover.SmsReminderConsentTakeover;
import com.linkedin.android.growth.takeover.TakeoverLauncher;
import com.linkedin.android.growth.takeover.TakeoverManager;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.identity.profile.ProfileViewActivity;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.animations.AnimationProxy;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.DaggerActivityComponent;
import com.linkedin.android.infra.components.DaggerActivityComponent.Builder;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.debug.ui.DeveloperSettingsActivity;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.ClickableSpanClickEvent;
import com.linkedin.android.infra.events.LaunchAlertEvent;
import com.linkedin.android.infra.modules.ActivityModule;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.AppUpgradeUtils;
import com.linkedin.android.infra.shared.AppUpgradeUtils.1;
import com.linkedin.android.infra.shared.AppUpgradeUtils.2;
import com.linkedin.android.infra.shared.AppUpgradeUtils.3;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.IntentUtils;
import com.linkedin.android.infra.shared.InternetConnectionMonitor;
import com.linkedin.android.infra.ui.lightbox.LightboxFragment.LightboxListener;
import com.linkedin.android.infra.webviewer.WebRouterUtil;
import com.linkedin.android.infra.webviewer.WebViewerBundle;
import com.linkedin.android.l2m.deeplink.DeepLinkHelperActivity;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.LaunchAlert;
import com.linkedin.android.pegasus.gen.voyager.common.Takeover;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class BaseActivity
  extends AppCompatActivity
  implements LightboxFragment.LightboxListener
{
  private static boolean needsSecurityProviderCheck = true;
  private int activityCloseEnterAnimation;
  private int activityCloseExitAnimation;
  public ActivityComponent activityComponent;
  private ActivityModule activityModule;
  private int activityOpenEnterAnimation;
  private int activityOpenExitAnimation;
  @Inject
  AnimationProxy animationProxy;
  @Inject
  AppUpgradeUtils appUpgradeUtils;
  public ApplicationComponent applicationComponent;
  @Inject
  Auth auth;
  @Inject
  Bus bus;
  private final Object eventListener = new Object()
  {
    @Subscribe
    public final void onEvent(OnboardingLaunchEvent paramAnonymousOnboardingLaunchEvent)
    {
      paramAnonymousOnboardingLaunchEvent = new OnboardingBundleBuilder();
      bundle.putBoolean("isOnboardingResume", true);
      startActivity(intentRegistry.onboarding.newIntent(BaseActivity.this, paramAnonymousOnboardingLaunchEvent));
    }
    
    @Subscribe
    public final void onEvent(ClickableSpanClickEvent paramAnonymousClickableSpanClickEvent)
    {
      ActivityComponent localActivityComponent = activityComponent;
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
        paramAnonymousClickableSpanClickEvent = WebViewerBundle.createFeedViewer(str, str, null, update, 2);
        localActivityComponent.webRouterUtil().launchWebViewer(paramAnonymousClickableSpanClickEvent, localActivityComponent, WebRouterUtil.shouldForceIgnoreDeeplink(str));
        return;
      }
      String str = url;
      paramAnonymousClickableSpanClickEvent = WebViewerBundle.create(str, str, null, webViewerUsage);
      localActivityComponent.webRouterUtil().launchWebViewer(paramAnonymousClickableSpanClickEvent, localActivityComponent, WebRouterUtil.shouldForceIgnoreDeeplink(str));
    }
    
    @Subscribe
    public final void onEvent(LaunchAlertEvent paramAnonymousLaunchAlertEvent)
    {
      AppUpgradeUtils localAppUpgradeUtils = appUpgradeUtils;
      Object localObject1 = BaseActivity.this;
      Object localObject2 = launchAlert;
      paramAnonymousLaunchAlertEvent = title;
      String str1 = message;
      String str2 = labelForAction;
      String str3 = labelForCancel;
      boolean bool = hasLabelForCancel;
      localObject2 = new AppUpgradeUtils.1(localAppUpgradeUtils, (Activity)localObject1, (LaunchAlert)localObject2);
      localObject1 = new AlertDialog.Builder((Context)localObject1);
      if (bool) {
        ((AlertDialog.Builder)localObject1).setNegativeButton(str3, null);
      }
      paramAnonymousLaunchAlertEvent = ((AlertDialog.Builder)localObject1).setTitle(paramAnonymousLaunchAlertEvent).setMessage(str1).setPositiveButton(str2, new AppUpgradeUtils.2(localAppUpgradeUtils)).setCancelable(bool).create();
      paramAnonymousLaunchAlertEvent.show();
      paramAnonymousLaunchAlertEvent.getButton(-1).setOnClickListener(new AppUpgradeUtils.3(localAppUpgradeUtils, bool, paramAnonymousLaunchAlertEvent, (View.OnClickListener)localObject2));
    }
    
    @Subscribe
    public final void onEvent(List<Takeover> paramAnonymousList)
    {
      BaseActivity.this.handleTakeovers(paramAnonymousList);
    }
  };
  @Inject
  public FragmentRegistry fragmentRegistry;
  @Inject
  I18NManager i18NManager;
  public boolean ignoreBackButtonTracking;
  @Inject
  public IntentRegistry intentRegistry;
  private PermissionRequester.PermissionRequestCallback internalPermissionRequestCallback;
  private InternetConnectionMonitor internetConnectionMonitor;
  private boolean isActivityDestroyed;
  public boolean isPostResumeDone;
  public boolean isResumed;
  public boolean isSoftwareBack;
  private boolean isStateSaved;
  @Inject
  NewToVoyagerTransactionalLaunchManager newToVoyagerTransactionalLaunchManager;
  private Runnable onPostResumeRunnable;
  private PermissionRequester permissionRequester;
  private PermissionRequester.PermissionRequestCallback registeredPermissionRequestCallback;
  @Inject
  TakeoverManager takeoverManager;
  @Inject
  Tracker tracker;
  String trackingPath;
  String trackingReferrer;
  
  private void handleTakeovers(List<Takeover> paramList)
  {
    Object localObject = getIntent().getExtras();
    if ((localObject != null) && (((Bundle)localObject).getBoolean("fromDeeplinking", false))) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (CollectionUtils.isNonEmpty(paramList))
      {
        localObject = (Takeover)paramList.get(0);
        if (localObject != null)
        {
          paramList = fragmentRegistry;
          activityComponent.legoTrackingDataProvider().sendWidgetImpressionEvent$4bb724c7(globalLegoTrackingToken, Visibility.SHOW);
          localObject = new NewToVoyagerIntroDialogFragmentBundleBuilder(legoTrackingToken);
          ((NewToVoyagerIntroDialogFragment)newToVoyagerIntroDialog.newFragment((BundleBuilder)localObject)).show(getSupportFragmentManager(), NewToVoyagerIntroDialogFragment.TAG);
        }
      }
      return;
    }
    localObject = intentRegistry;
    ActivityComponent localActivityComponent = activityComponent;
    paramList = paramList.iterator();
    label131:
    Takeover localTakeover;
    if (paramList.hasNext())
    {
      localTakeover = (Takeover)paramList.next();
      switch (com.linkedin.android.growth.takeover.TakeoverLauncher.1.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$common$TakeoverType[takeoverType.ordinal()])
      {
      default: 
        paramList = null;
      }
    }
    while (paramList != null)
    {
      activityComponent.legoTrackingDataProvider().sendWidgetImpressionEvent$4bb724c7(takeover.globalLegoTrackingToken, Visibility.SHOW);
      paramList.launch(this, (IntentRegistry)localObject);
      return;
      paramList = new AbiTakeover(localTakeover, localActivityComponent);
      continue;
      paramList = new OnboardingTakeover(localTakeover);
      continue;
      paramList = new NewToVoyagerTakeover(localTakeover);
      continue;
      paramList = new PhoneCollectTakeover(localTakeover);
      continue;
      paramList = new SmsReminderConsentTakeover(localTakeover);
      continue;
      if (!localActivityComponent.flagshipSharedPreferences().getCalendarSyncEnabled()) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label337;
        }
        paramList = new CalendarSyncTakeover(localTakeover);
        break;
      }
      label337:
      break label131;
      paramList = null;
    }
  }
  
  private void loadTransitionAnimations()
  {
    TypedArray localTypedArray = getTheme().obtainStyledAttributes(new int[] { 16842936, 16842937, 16842938, 16842939 });
    int i = 0;
    if (i < localTypedArray.getIndexCount())
    {
      int j = localTypedArray.getIndex(i);
      if (j == 0) {
        activityOpenEnterAnimation = localTypedArray.getResourceId(j, 0);
      }
      for (;;)
      {
        i += 1;
        break;
        if (j == 1) {
          activityOpenExitAnimation = localTypedArray.getResourceId(j, 0);
        } else if (j == 2) {
          activityCloseEnterAnimation = localTypedArray.getResourceId(j, 0);
        } else if (j == 3) {
          activityCloseExitAnimation = localTypedArray.getResourceId(j, 0);
        }
      }
    }
    localTypedArray.recycle();
  }
  
  private void performSecurityProviderCheck()
  {
    needsSecurityProviderCheck = false;
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
    if ((i != 0) && (i != 2)) {
      return;
    }
    ProviderInstaller.installIfNeededAsync(this, new ProviderInstaller.ProviderInstallListener()
    {
      public final void onProviderInstallFailed$10b55c15(int paramAnonymousInt)
      {
        if (GooglePlayServicesUtil.isUserRecoverableError(paramAnonymousInt))
        {
          BaseActivity localBaseActivity = (BaseActivity)val$activityWeakReference.get();
          if ((localBaseActivity != null) && (localBaseActivity.canExecuteFragmentTransactions())) {
            GooglePlayServicesUtil.showErrorDialogFragment(paramAnonymousInt, localBaseActivity, 1, new BaseActivity.4.1(this));
          }
          BaseActivity.access$302$138603();
        }
      }
    });
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(new CalligraphyContextWrapper(paramContext));
  }
  
  public final boolean canExecuteFragmentTransactions()
  {
    return (isPostResumeDone) && (!isActivityDestroyed);
  }
  
  public boolean disableTransitionAnimations()
  {
    return false;
  }
  
  public void finish()
  {
    super.finish();
    if (!disableTransitionAnimations()) {
      overridePendingTransition(activityCloseEnterAnimation, activityCloseExitAnimation);
    }
  }
  
  public final void fireBackPressedControlInteractionEvent()
  {
    Tracker localTracker;
    if (!ignoreBackButtonTracking)
    {
      localTracker = tracker;
      if (!isSoftwareBack) {
        break label52;
      }
    }
    label52:
    for (String str = "nav-back";; str = "hardware-back")
    {
      new ControlInteractionEvent(localTracker, str, ControlType.BUTTON, InteractionType.SHORT_PRESS).send();
      isSoftwareBack = false;
      ignoreBackButtonTracking = false;
      return;
    }
  }
  
  @SuppressLint({"CommitTransaction"})
  public final FragmentTransaction getAnimationFragmentTransaction(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return AnimationProxy.setAnimations(getSupportFragmentManager().beginTransaction(), paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @SuppressLint({"CommitTransaction"})
  public final FragmentTransaction getAnimationFragmentTransaction$228f0801()
  {
    return getSupportFragmentManager().beginTransaction().setCustomAnimations$228f0801();
  }
  
  public String getCallingPackage()
  {
    applicationComponent.thirdPartySdkManager();
    return super.getCallingPackage();
  }
  
  public final String getLocalizedString(int paramInt)
  {
    return i18NManager.getString(paramInt);
  }
  
  @SuppressLint({"CommitTransaction"})
  public final FragmentTransaction getModalFragmentTransaction()
  {
    return AnimationProxy.setAnimations(getSupportFragmentManager().beginTransaction(), 2131034140, 2131034134, 0, 2131034141);
  }
  
  @SuppressLint({"CommitTransaction"})
  public final FragmentTransaction getPageFragmentTransaction()
  {
    return AnimationProxy.setAnimations(getSupportFragmentManager().beginTransaction(), 2131034147, 2131034134, 0, 2131034148);
  }
  
  public final boolean isSafeToExecuteTransaction()
  {
    return !isStateSaved;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    isStateSaved = false;
    if (paramInt1 == 1) {
      needsSecurityProviderCheck = true;
    }
  }
  
  public void onBackPressed()
  {
    fireBackPressedControlInteractionEvent();
    if (isResumed) {
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    CrashReporter.logComponentInfo("Starting activity " + getClass().getSimpleName(), getIntent());
    activityModule = new ActivityModule(this);
    Object localObject2 = (FlagshipApplication)getApplication();
    Object localObject1 = activityModule;
    ((FlagshipApplication)localObject2).getAppComponent().refWatcher();
    localObject2 = ((FlagshipApplication)localObject2).getAppComponent();
    Object localObject3 = DaggerActivityComponent.builder();
    if (localObject2 == null) {
      throw new NullPointerException("applicationComponent");
    }
    applicationComponent = ((ApplicationComponent)localObject2);
    if (localObject1 == null) {
      throw new NullPointerException("activityModule");
    }
    activityModule = ((ActivityModule)localObject1);
    if (activityModule == null) {
      throw new IllegalStateException("activityModule must be set");
    }
    if (applicationComponent == null) {
      throw new IllegalStateException("applicationComponent must be set");
    }
    activityComponent = new DaggerActivityComponent((DaggerActivityComponent.Builder)localObject3, (byte)0);
    activityComponent.inject(this);
    applicationComponent = ((FlagshipApplication)getApplication()).getAppComponent();
    super.onCreate(paramBundle);
    permissionRequester = new PermissionRequester(this);
    internalPermissionRequestCallback = new PermissionRequester.PermissionRequestCallback()
    {
      public final void permissionsResult(Set<String> paramAnonymousSet1, Set<String> paramAnonymousSet2)
      {
        BaseActivity.access$200(BaseActivity.this, paramAnonymousSet1, paramAnonymousSet2);
      }
    };
    if (needsSecurityProviderCheck) {
      performSecurityProviderCheck();
    }
    if (!auth.isAuthenticated())
    {
      paramBundle = getClass().getName();
      if ((!LaunchActivity.class.getName().equals(paramBundle)) && (!LoginActivity.class.getName().equals(paramBundle)) && (!ProfileViewActivity.class.getName().equals(paramBundle)) && (!DeepLinkHelperActivity.class.getName().equals(paramBundle)) && (!SameNameDirectoryActivity.class.getName().equals(paramBundle)) && (!DeveloperSettingsActivity.class.getName().equals(paramBundle))) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramBundle = getIntent();
        localObject1 = activityComponent.intentRegistry().login;
        localObject2 = new LoginIntentBundle().setRedirectIntent(paramBundle);
        localObject3 = paramBundle.getStringExtra("midToken");
        bundle.putString("midToken", (String)localObject3);
        localObject1 = ((LoginIntent)localObject1).newIntent(this, (BundleBuilder)localObject2);
        if ((paramBundle.getFlags() & 0x1) != 0) {
          IntentUtils.grantReadUriPermission((Intent)localObject1, paramBundle);
        }
        startActivity((Intent)localObject1);
        finish();
        return;
      }
    }
    loadTransitionAnimations();
    if (!disableTransitionAnimations()) {
      overridePendingTransition(activityOpenEnterAnimation, activityOpenExitAnimation);
    }
    trackingReferrer = getIntent().getStringExtra("trackingReferrer");
    trackingPath = getIntent().getStringExtra("trackingPath");
    getIntent().removeExtra("trackingReferrer");
    getIntent().removeExtra("trackingPath");
    internetConnectionMonitor = applicationComponent.internetConnectionMonitor();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    isActivityDestroyed = true;
    internalPermissionRequestCallback = null;
    registeredPermissionRequestCallback = null;
    internetConnectionMonitor = null;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    CrashReporter.reportNonFatal(new Throwable("onNewIntent called in BaseActivity"));
  }
  
  public void onPause()
  {
    super.onPause();
    Bus.unsubscribe(eventListener);
    isResumed = false;
    isPostResumeDone = false;
    InternetConnectionMonitor localInternetConnectionMonitor = internetConnectionMonitor;
    if (internetSnackbarLixEnabled)
    {
      appContext.unregisterReceiver(connectivityBroadcastReceiver);
      localInternetConnectionMonitor.dismissSnackbar();
    }
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    isPostResumeDone = true;
    if (needsSecurityProviderCheck) {
      performSecurityProviderCheck();
    }
    if (onPostResumeRunnable != null)
    {
      onPostResumeRunnable.run();
      onPostResumeRunnable = null;
    }
    isStateSaved = false;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!permissionRequester.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt, internalPermissionRequestCallback)) {
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  protected final void onRequestPermissionsResult(Set<String> paramSet1, Set<String> paramSet2)
  {
    if (registeredPermissionRequestCallback != null) {
      registeredPermissionRequestCallback.permissionsResult(paramSet1, paramSet2);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Bus.unsubscribe(eventListener);
    Bus.subscribe(eventListener);
    List localList = (List)Bus.getAndClearStickyEvent(List.class);
    if (localList != null) {
      handleTakeovers(localList);
    }
    isResumed = true;
    internetConnectionMonitor.registerInternetCheckReceiver();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    isStateSaved = true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.BaseActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */