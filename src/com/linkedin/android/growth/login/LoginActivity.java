package com.linkedin.android.growth.login;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import butterknife.ButterKnife;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.auth.api.credentials.HintRequest.Builder;
import com.google.android.gms.auth.api.credentials.IdToken;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.boost.BoostUtil;
import com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager;
import com.linkedin.android.growth.login.join.JoinFragmentFactory;
import com.linkedin.android.growth.login.login.LoginFragmentFactory;
import com.linkedin.android.growth.login.login.LoginManager;
import com.linkedin.android.growth.login.login.LoginManager.LoginListener;
import com.linkedin.android.growth.login.phoneverification.PhoneConfirmationBundle;
import com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragmentFactory;
import com.linkedin.android.growth.login.phoneverification.PinVerificationBundle;
import com.linkedin.android.growth.login.phoneverification.PinVerificationFragmentFactory;
import com.linkedin.android.growth.login.prereg.PreRegFragmentFactory;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.growth.login.prereg.PreRegPropFragment;
import com.linkedin.android.growth.login.smartlock.SmartLockConnectListener;
import com.linkedin.android.growth.login.smartlock.SmartLockCredentialRequestListener;
import com.linkedin.android.growth.login.smartlock.SmartLockDisableAutoSignInListener;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.growth.login.smartlock.SmartLockManager.6;
import com.linkedin.android.growth.login.sso.SSOManager;
import com.linkedin.android.growth.onboarding.OnboardingBundleBuilder;
import com.linkedin.android.growth.onboarding.OnboardingIntent;
import com.linkedin.android.growth.takeover.TakeoverManager;
import com.linkedin.android.growth.takeover.TakeoverManager.1;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.DefaultBundle;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.LogoutUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.LaunchUtils;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.PreAuthLix;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.infra.shared.IntentUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.l2m.notification.NotificationUtils;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.LiAuth.LogoutReason;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;
import com.linkedin.android.liauthlib.common.LiSSOInfo;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.android.liauthlib.registration.RegistrationResponseData;
import com.linkedin.android.liauthlib.sso.LiSSOServiceBindingListener;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.voyager.common.Takeover;
import java.util.List;
import javax.inject.Inject;

public class LoginActivity
  extends BaseActivity
  implements PreRegListener
{
  private static final String TAG = LoginActivity.class.getSimpleName();
  @Inject
  com.linkedin.android.infra.network.Auth auth;
  @Inject
  Bus bus;
  @Inject
  FlagshipDataManager dataManager;
  @Inject
  android.support.v4.app.FragmentManager fragmentManager;
  @Inject
  FragmentRegistry fragmentRegistry;
  @Inject
  GoogleIdTokenManager googleIdTokenManager;
  private boolean hasPreRegBeenStarted;
  private boolean isBoostEligibilityFetched;
  @Inject
  LaunchUtils launchUtils;
  @Inject
  PreAuthLixManager lixManager;
  @Inject
  LoginManager loginManager;
  @Inject
  LoginUtils loginUtils;
  @Inject
  NotificationUtils notificationUtils;
  private Bundle savedInstanceStateForPreLoading;
  @Inject
  FlagshipSharedPreferences sharedPreferences;
  private boolean showGoogleIdTokenErrorToastOnResume;
  private boolean showLoginScreenOnPostResume;
  @Inject
  SmartLockManager smartLockManager;
  @Inject
  SnackbarUtil snackbar;
  @Inject
  SSOManager ssoManager;
  @Inject
  TakeoverManager takeoverManager;
  @Inject
  Tracker tracker;
  
  private LoginManager.LoginListener createSmartLockLoginListener()
  {
    new LoginManager.LoginListener()
    {
      public final void onFail(LiError.LiAuthErrorCode paramAnonymousLiAuthErrorCode)
      {
        paramAnonymousLiAuthErrorCode = smartLockManager;
        SmartLockManager.sendTrackingEvent(activityComponent.tracker(), "smartlock_auto_signin_failed");
        paramAnonymousLiAuthErrorCode = LoginActivity.this;
        if (savedInstanceStateForPreLoading == null) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousLiAuthErrorCode.startPreReg(bool);
          return;
        }
      }
      
      public final void onSuccess()
      {
        SmartLockManager localSmartLockManager = smartLockManager;
        SmartLockManager.sendTrackingEvent(activityComponent.tracker(), "smartlock_auto_signin_success");
        onLoginSuccess();
      }
    };
  }
  
  private void handleError()
  {
    boolean bool = false;
    smartLockManager.isSmartLockOn = false;
    if (savedInstanceStateForPreLoading == null) {
      bool = true;
    }
    startPreReg(bool);
  }
  
  private void showGoogleIdTokenErrorToast()
  {
    Snackbar localSnackbar = snackbar.make(2131232797, 0);
    if (localSnackbar != null) {
      localSnackbar.show();
    }
  }
  
  private void signOut(LiAuth.LogoutReason paramLogoutReason)
  {
    auth.signOut(LogoutUtils.createSignOutListener(applicationComponent, true), paramLogoutReason);
  }
  
  private void startPreReg(boolean paramBoolean)
  {
    if ((paramBoolean) && (isSafeToExecuteTransaction()))
    {
      PreRegPropFragment.setPromoViewed(false);
      hasPreRegBeenStarted = true;
      fragmentManager.beginTransaction().add(16908290, fragmentRegistry.preReg.newFragment(new DefaultBundle())).commit();
    }
    while (savedInstanceStateForPreLoading == null) {
      return;
    }
    PreRegPropFragment.setPromoViewed(savedInstanceStateForPreLoading.getBoolean("boostPromoViewed"));
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool1 = true;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = false;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = fragmentManager.findFragmentById(16908290);
    if ((localObject != null) && (((Fragment)localObject).isAdded()))
    {
      ((Fragment)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    switch (paramInt1)
    {
    default: 
      if (savedInstanceStateForPreLoading != null) {
        break;
      }
    }
    for (;;)
    {
      startPreReg(bool1);
      return;
      if (paramInt2 == -1)
      {
        paramIntent = (Credential)paramIntent.getParcelableExtra("com.google.android.gms.credentials.Credential");
        loginManager.performLogin(zzyv, zzVX, createSmartLockLoginListener());
        return;
      }
      if (savedInstanceStateForPreLoading != null)
      {
        bool1 = bool2;
        if (hasPreRegBeenStarted) {}
      }
      else
      {
        bool1 = true;
      }
      startPreReg(bool1);
      return;
      if (paramInt2 == -1)
      {
        paramIntent = (Credential)paramIntent.getParcelableExtra("com.google.android.gms.credentials.Credential");
        if ((paramIntent != null) && (zzVW != null) && (!zzVW.isEmpty()))
        {
          googleIdTokenManager.sendTrackingEvent("googleidtoken_choose_hint_email");
          localObject = zzVW.get(0)).zzWk;
          loginManager.loginWithGoogleIdToken(zzyv, (String)localObject, new LoginManager.LoginListener()
          {
            public final void onFail(LiError.LiAuthErrorCode paramAnonymousLiAuthErrorCode)
            {
              Log.e(LoginActivity.TAG, "Login using Google ID token failed");
              googleIdTokenManager.sendTrackingEvent("googleidtoken_signin_failure");
              if (isResumed)
              {
                LoginActivity.this.showGoogleIdTokenErrorToast();
                paramAnonymousLiAuthErrorCode = LoginActivity.this;
                if ((savedInstanceStateForPreLoading != null) && (hasPreRegBeenStarted)) {
                  break label82;
                }
              }
              label82:
              for (boolean bool = true;; bool = false)
              {
                paramAnonymousLiAuthErrorCode.startPreReg(bool);
                return;
                LoginActivity.access$1102$46badd47(LoginActivity.this);
                break;
              }
            }
            
            public final void onSuccess()
            {
              googleIdTokenManager.sendTrackingEvent("googleidtoken_signin_success");
              onLoginSuccess();
            }
          });
          return;
        }
        Log.e(TAG, "Credential does not contain ID token");
        if (isResumed) {
          showGoogleIdTokenErrorToast();
        }
        for (;;)
        {
          if (savedInstanceStateForPreLoading != null)
          {
            bool1 = bool3;
            if (hasPreRegBeenStarted) {}
          }
          else
          {
            bool1 = true;
          }
          startPreReg(bool1);
          return;
          showGoogleIdTokenErrorToastOnResume = true;
        }
      }
      googleIdTokenManager.sendTrackingEvent("googleidtoken_cancel_hint_selector");
      if (savedInstanceStateForPreLoading != null)
      {
        bool1 = bool4;
        if (hasPreRegBeenStarted) {}
      }
      else
      {
        bool1 = true;
      }
      startPreReg(bool1);
      return;
      bool1 = false;
    }
  }
  
  public void onBackPressed()
  {
    if (!getFragmentManager().popBackStackImmediate()) {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    savedInstanceStateForPreLoading = paramBundle;
    super.onCreate(paramBundle);
    activityComponent.inject(this);
    setContentView(2130968943);
    ButterKnife.inject(this);
    if (!getIntent().getBooleanExtra("UseSmartLock", true)) {
      smartLockManager.isSmartLockOn = false;
    }
    final Object localObject1 = getIntent().getExtras();
    Object localObject2;
    int i;
    label123:
    RecordTemplateListener local1;
    String str;
    if (localObject1 != null)
    {
      localObject1 = (LiAuth.LogoutReason)((Bundle)localObject1).getSerializable("logoutReason");
      if (LoginIntentBundle.isLogout(getIntent().getExtras()))
      {
        localObject2 = getIntent().getExtras();
        if ((localObject2 == null) || (!((Bundle)localObject2).getBoolean("underageLogout"))) {
          break label272;
        }
        i = 1;
        if (i == 0)
        {
          localObject2 = notificationUtils;
          local1 = new RecordTemplateListener()
          {
            public final void onResponse(DataStoreResponse<JsonModel> paramAnonymousDataStoreResponse)
            {
              LoginActivity.this.signOut(localObject1);
            }
          };
          str = sharedPreferences.getNotificationToken();
          if (str != null) {
            break label277;
          }
          i = 0;
          label162:
          if (i == 0) {
            signOut((LiAuth.LogoutReason)localObject1);
          }
        }
      }
      if (paramBundle != null) {
        break label296;
      }
      localObject1 = getIntent().getExtras();
      if ((localObject1 == null) || (!((Bundle)localObject1).getBoolean("boostEligibilityFetched", false))) {
        break label291;
      }
      bool1 = true;
      label204:
      isBoostEligibilityFetched = bool1;
      if (!isBoostEligibilityFetched)
      {
        BoostUtil.getEligibility(sharedPreferences, dataManager, bus, this);
        isBoostEligibilityFetched = true;
      }
      localObject1 = getIntent().getExtras();
      if (!LoginIntentBundle.isEmailConfirmationAuthentication((Bundle)localObject1)) {
        break label307;
      }
      showLoginScreen(false);
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label470;
      }
      return;
      localObject1 = null;
      break;
      label272:
      i = 0;
      break label123;
      label277:
      ((NotificationUtils)localObject2).sendTokenForDeregister(str, local1);
      i = 1;
      break label162;
      label291:
      bool1 = false;
      break label204;
      label296:
      bool1 = paramBundle.getBoolean("boostEligibilityFetched");
      break label204;
      label307:
      if ((localObject1 != null) && (((Bundle)localObject1).getBoolean("showJoinScreen", false))) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label373;
        }
        getSupportFragmentManager().beginTransaction().replace(16908290, fragmentRegistry.join.newFragment(new DefaultBundle())).commit();
        i = 1;
        break;
      }
      label373:
      localObject2 = smartLockManager;
      if ((localObject1 != null) && (((Bundle)localObject1).getString("publicIdentifier") != null) && (!isSmartLockOn)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label465;
        }
        fragmentManager.popBackStackImmediate();
        getAnimationFragmentTransaction(2131034159, 2131034163, 2131034159, 2131034163).add(16908290, fragmentRegistry.join.newFragment(new DefaultBundle())).commit();
        i = 1;
        break;
      }
      label465:
      i = 0;
    }
    label470:
    if ((paramBundle != null) && (paramBundle.getBoolean("hasPreRegBeenStarted"))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      hasPreRegBeenStarted = bool1;
      activityComponent.preAuthLixManager().addTreatmentListener(PreAuthLix.LIX_SMART_LOCK, smartLockManager.getTreatmentListener());
      if (!smartLockManager.isSmartLockOn()) {
        break;
      }
      smartLockManager.connect(new SmartLockConnectListener()
      {
        public final void onConnectFailed()
        {
          boolean bool = false;
          smartLockManager.isSmartLockOn = false;
          LoginActivity localLoginActivity = LoginActivity.this;
          if (savedInstanceStateForPreLoading == null) {
            bool = true;
          }
          localLoginActivity.startPreReg(bool);
        }
        
        public final void onConnectSucceed()
        {
          if (LoginIntentBundle.isLogout(getIntent().getExtras()))
          {
            SmartLockManager localSmartLockManager = smartLockManager;
            SmartLockDisableAutoSignInListener local1 = new SmartLockDisableAutoSignInListener()
            {
              public final void onPostDisable()
              {
                LoginActivity localLoginActivity = LoginActivity.this;
                if (savedInstanceStateForPreLoading == null) {}
                for (boolean bool = true;; bool = false)
                {
                  localLoginActivity.startPreReg(bool);
                  return;
                }
              }
            };
            com.google.android.gms.auth.api.Auth.CredentialsApi.disableAutoSignIn(credentialsApiClient).setResultCallback(new SmartLockManager.6(localSmartLockManager, local1));
            return;
          }
          smartLockManager.loadCredentials(new SmartLockCredentialRequestListener()
          {
            public final void onCredentialRequestFailed()
            {
              LoginActivity localLoginActivity = LoginActivity.this;
              if (savedInstanceStateForPreLoading == null) {}
              for (boolean bool = true;; bool = false)
              {
                localLoginActivity.startPreReg(bool);
                return;
              }
            }
            
            public final void onCredentialRequestHintSelector(Status paramAnonymous2Status)
            {
              boolean bool = true;
              if (("enabled".equals(lixManager.getTreatment(PreAuthLix.GROWTH_GOOGLE_ID_TOKEN_SIGN_IN_APP_LAUNCH))) && (fragmentManager.findFragmentById(16908290) == null))
              {
                paramAnonymous2Status = smartLockManager;
                Object localObject = new HintRequest.Builder();
                zzWi = true;
                zzWe = new String[] { "https://accounts.google.com" };
                if (zzWe == null) {
                  zzWe = new String[0];
                }
                if ((!zzWi) && (!zzWj) && (zzWe.length == 0)) {
                  throw new IllegalStateException("At least one authentication method must be specified");
                }
                localObject = new HintRequest((HintRequest.Builder)localObject, (byte)0);
                localObject = com.google.android.gms.auth.api.Auth.CredentialsApi.getHintPickerIntent(credentialsApiClient, (HintRequest)localObject);
                try
                {
                  activity.startIntentSenderForResult(((PendingIntent)localObject).getIntentSender(), 3, null, 0, 0, 0);
                  return;
                }
                catch (IntentSender.SendIntentException paramAnonymous2Status)
                {
                  Log.e(SmartLockManager.TAG, "loadHintCredentials: could not start hint picker intent");
                  return;
                }
              }
              paramAnonymous2Status = LoginActivity.this;
              if (savedInstanceStateForPreLoading == null) {}
              for (;;)
              {
                paramAnonymous2Status.startPreReg(bool);
                return;
                bool = false;
              }
            }
            
            public final void onCredentialRequestMultipleResults(Status paramAnonymous2Status)
            {
              LoginActivity.access$400(LoginActivity.this, paramAnonymous2Status);
            }
            
            public final void onCredentialRequestSuccess(Credential paramAnonymous2Credential)
            {
              loginManager.performLogin(zzyv, zzVX, LoginActivity.this.createSmartLockLoginListener());
            }
          });
        }
      });
      return;
    }
    if (paramBundle == null) {}
    for (bool1 = bool2;; bool1 = false)
    {
      startPreReg(bool1);
      return;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ssoManager.liAuth.stopSSOService();
    activityComponent.preAuthLixManager().removeTreatmentListener(PreAuthLix.LIX_SMART_LOCK, smartLockManager.getTreatmentListener());
  }
  
  public final void onJoinSuccess(OnboardingBundleBuilder paramOnboardingBundleBuilder)
  {
    Object localObject = takeoverManager;
    dataManager.submit(Request.get().url(Routes.TAKEOVERS.buildUponRoot().toString()).builder(CollectionTemplate.of(Takeover.BUILDER)).listener(new TakeoverManager.1((TakeoverManager)localObject, this)).filter(DataManager.DataStoreFilter.NETWORK_ONLY));
    localObject = paramOnboardingBundleBuilder;
    if (paramOnboardingBundleBuilder == null) {
      localObject = new OnboardingBundleBuilder();
    }
    startActivity(intentRegistry.onboarding.newIntent(this, (BundleBuilder)localObject));
    finish();
  }
  
  public final void onLoginSuccess()
  {
    Object localObject = getIntent();
    String str = LoginIntentBundle.getThirdPartyApplicationPackageName(((Intent)localObject).getExtras());
    localObject = ((Intent)localObject).getExtras();
    if (localObject != null)
    {
      localObject = (Intent)((Bundle)localObject).getParcelable("redirect");
      if (localObject == null) {
        break label112;
      }
    }
    for (;;)
    {
      Bundle localBundle = ((Intent)localObject).getExtras();
      if (localBundle != null) {
        localBundle.setClassLoader(getClassLoader());
      }
      Intent localIntent = getIntent();
      if ((localIntent.getFlags() & 0x1) != 0) {
        IntentUtils.grantReadUriPermission((Intent)localObject, localIntent);
      }
      if ((TextUtils.isEmpty(str)) || ((localBundle != null) && (localBundle.containsKey("thirdPartyApplicationPackageName")))) {
        startActivity((Intent)localObject);
      }
      finish();
      return;
      localObject = null;
      break;
      label112:
      localObject = intentRegistry.home.newIntent(this, null);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    SmartLockManager localSmartLockManager = smartLockManager;
    if (credentialsApiClient != null) {
      credentialsApiClient.disconnect();
    }
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    if (showLoginScreenOnPostResume)
    {
      showLoginScreen(true);
      showLoginScreenOnPostResume = false;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (showGoogleIdTokenErrorToastOnResume)
    {
      showGoogleIdTokenErrorToast();
      showGoogleIdTokenErrorToastOnResume = false;
    }
    if ((smartLockManager.isSmartLockOn()) && (!smartLockManager.isConnected())) {
      smartLockManager.connect(new SmartLockConnectListener()
      {
        public final void onConnectFailed() {}
        
        public final void onConnectSucceed() {}
      });
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("boostEligibilityFetched", isBoostEligibilityFetched);
    paramBundle.putBoolean("boostPromoViewed", PreRegPropFragment.getPromoViewed());
    paramBundle.putBoolean("hasPreRegBeenStarted", hasPreRegBeenStarted);
  }
  
  public final void showJoinScreen()
  {
    if (isSafeToExecuteTransaction())
    {
      fragmentManager.popBackStackImmediate();
      getAnimationFragmentTransaction(2131034159, 2131034163, 2131034159, 2131034163).add(16908290, fragmentRegistry.join.newFragment(new DefaultBundle())).addToBackStack(null).commitAllowingStateLoss();
    }
  }
  
  public final void showLoginScreen()
  {
    showLoginScreen(true);
  }
  
  final void showLoginScreen(boolean paramBoolean)
  {
    if (isSafeToExecuteTransaction())
    {
      fragmentManager.popBackStackImmediate();
      FragmentTransaction localFragmentTransaction = getAnimationFragmentTransaction(2131034159, 2131034163, 2131034159, 2131034163).add(16908290, fragmentRegistry.login.newFragment(new DefaultBundle()));
      if (paramBoolean) {
        localFragmentTransaction.addToBackStack(null);
      }
      localFragmentTransaction.commit();
    }
  }
  
  public final void showPhoneNumberConfirmationScreen(String paramString, CheckpointChallengeResponseData paramCheckpointChallengeResponseData, RegistrationResponseData paramRegistrationResponseData, RegistrationInfo paramRegistrationInfo)
  {
    if (isSafeToExecuteTransaction()) {
      getSupportFragmentManager().beginTransaction().add(16908290, fragmentRegistry.phoneConfirm.newFragment(new PhoneConfirmationBundle(paramString, paramCheckpointChallengeResponseData, paramRegistrationResponseData, paramRegistrationInfo))).addToBackStack(null).commit();
    }
  }
  
  public final void showPinVerificationScreen(String paramString, CheckpointChallengeResponseData paramCheckpointChallengeResponseData, RegistrationInfo paramRegistrationInfo)
  {
    if (isSafeToExecuteTransaction()) {
      getSupportFragmentManager().beginTransaction().add(16908290, fragmentRegistry.pinVerify.newFragment(new PinVerificationBundle(paramString, paramCheckpointChallengeResponseData, paramRegistrationInfo))).addToBackStack(null).commit();
    }
  }
  
  public final void showSSOScreenIfApplicable()
  {
    SSOManager localSSOManager = ssoManager;
    LiSSOServiceBindingListener local4 = new LiSSOServiceBindingListener()
    {
      public final void onBindSuccess()
      {
        Object localObject = Util.safeGet(ssoManager.getSSOUsers());
        int i = ((List)localObject).size() - 1;
        while (i >= 0)
        {
          if (!TextUtils.isEmpty(getfirstName))
          {
            localObject = LoginActivity.this;
            if (savedInstanceStateForPreLoading == null) {}
            for (boolean bool = true;; bool = false)
            {
              LoginActivity.access$500((LoginActivity)localObject, bool);
              return;
            }
          }
          i -= 1;
        }
        if (isPostResumeDone)
        {
          showLoginScreen(true);
          return;
        }
        LoginActivity.access$702$46badd47(LoginActivity.this);
      }
    };
    liAuth.startSSOService(local4);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */