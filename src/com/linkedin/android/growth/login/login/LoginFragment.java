package com.linkedin.android.growth.login.login;

import android.accounts.Account;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.linkedin.android.growth.login.LoginIntentBundle;
import com.linkedin.android.growth.login.PrefillManager;
import com.linkedin.android.growth.login.fastrack.FastrackManager;
import com.linkedin.android.growth.login.fastrack.FastrackManager.1;
import com.linkedin.android.growth.login.idtoken.GoogleIdTokenListener;
import com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager;
import com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager.1;
import com.linkedin.android.growth.login.idtoken.GoogleIdTokenManager.2;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.growth.login.presenters.PasswordVisibilityPresenter;
import com.linkedin.android.growth.login.smartlock.SmartLockCredentialRequestListener;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.growth.utils.InputValidator;
import com.linkedin.android.growth.utils.ThirdPartySdkTrackingUtils;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.PreAuthLix;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.CustomTextInputLayout;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.networking.cookies.CookieUtil;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.android.tracking.v2.listeners.TrackingOnEditorActionListener;
import com.linkedin.gen.avro2pegasus.events.mobilesdk.VoyagerLoginResult;
import javax.inject.Inject;

public class LoginFragment
  extends PageFragment
{
  private static final String TAG = LoginFragment.class.getSimpleName();
  @InjectView(2131756026)
  TextView emailOrPhoneBoxLabel;
  @InjectView(2131756024)
  CustomTextInputLayout emailOrPhoneContainer;
  @InjectView(2131756025)
  EditText emailOrPhoneInput;
  @Inject
  FastrackManager fastrackManager;
  @InjectView(2131756022)
  TextView forgetPasswordText;
  @Inject
  GoogleIdTokenManager googleIdTokenManager;
  @Inject
  InputValidator inputValidator;
  private boolean isEmailConfirmationAuthentication;
  @InjectView(2131756023)
  TextView joinText;
  @Inject
  PreAuthLixManager lixManager;
  private LoginManager.LoginListener loginListener;
  @Inject
  LoginManager loginManager;
  @Inject
  MemberUtil memberUtil;
  @InjectView(2131756029)
  TextView passwordBoxLabel;
  @InjectView(2131756027)
  CustomTextInputLayout passwordContainer;
  @InjectView(2131756028)
  EditText passwordInput;
  @Inject
  PasswordVisibilityPresenter passwordVisibilityPresenter;
  protected PreRegListener preRegListener;
  @Inject
  PrefillManager prefillManager;
  @Inject
  FlagshipSharedPreferences sharedPreferences;
  @InjectView(2131756021)
  Button signInButton;
  @Inject
  SmartLockManager smartLockManager;
  @Inject
  SnackbarUtil snackbar;
  @Inject
  Tracker tracker;
  
  private void handleSmartLockVisibleError$2061f3c7()
  {
    smartLockManager.isSmartLockOn = false;
  }
  
  private void prefillEmailWithHintCredential(Credential paramCredential)
  {
    smartLockManager.credentialEmail = zzyv;
    emailOrPhoneInput.setText(zzyv);
  }
  
  final void goToJoinPage()
  {
    if (preRegListener != null)
    {
      preRegListener.showJoinScreen();
      return;
    }
    getActivity();
    Util.safeThrow$7a8b4789(new IllegalStateException(TAG + " join button does not have a listener attached"));
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      if (paramInt2 == -1) {
        SmartLockManager.sendTrackingEvent(tracker, "smartlock_save_credential");
      }
      for (;;)
      {
        loginManager.onLoginSuccess(loginListener);
        return;
        SmartLockManager.sendTrackingEvent(tracker, "smartlock_cancel_save_credential");
      }
    case 3: 
      if (paramInt2 == -1)
      {
        final Object localObject2 = (Credential)paramIntent.getParcelableExtra("com.google.android.gms.credentials.Credential");
        SmartLockManager.sendTrackingEvent(tracker, "smartlock_choose_hint_email");
        if ("enabled".equals(lixManager.getTreatment(PreAuthLix.GROWTH_GOOGLE_ID_TOKEN_SIGN_IN)))
        {
          paramIntent = googleIdTokenManager;
          Object localObject1 = zzyv;
          localObject2 = new GoogleIdTokenListener()
          {
            public final void onFetchFailed()
            {
              LoginFragment.this.prefillEmailWithHintCredential(localObject2);
            }
            
            public final void onFetchSucceed(String paramAnonymousString)
            {
              googleIdTokenManager.sendTrackingEvent("googleidtoken_choose_hint_email");
              loginManager.loginWithGoogleIdToken(localObject2zzyv, paramAnonymousString, new LoginFragment.9(LoginFragment.this));
            }
          };
          GoogleSignInOptions.Builder localBuilder = new GoogleSignInOptions.Builder();
          zzTI = new Account(zzx.zzcM((String)localObject1), "com.google");
          zzXa = true;
          zzx.zzcM("789113911969.apps.googleusercontent.com");
          boolean bool1 = bool2;
          if (zzXd != null) {
            if (!zzXd.equals("789113911969.apps.googleusercontent.com")) {
              break label299;
            }
          }
          label299:
          for (bool1 = bool2;; bool1 = false)
          {
            zzx.zzb(bool1, "two different server client ids provided");
            zzXd = "789113911969.apps.googleusercontent.com";
            localObject1 = localBuilder.build();
            googleApiClient = new GoogleApiClient.Builder(activity).addApi(com.google.android.gms.auth.api.Auth.GOOGLE_SIGN_IN_API, (Api.ApiOptions.HasOptions)localObject1).addConnectionCallbacks(new GoogleIdTokenManager.2(paramIntent, (GoogleIdTokenListener)localObject2)).addOnConnectionFailedListener(new GoogleIdTokenManager.1(paramIntent, (GoogleIdTokenListener)localObject2)).build();
            googleApiClient.connect();
            return;
          }
        }
        prefillEmailWithHintCredential((Credential)localObject2);
        return;
      }
      SmartLockManager.sendTrackingEvent(tracker, "smartlock_cancel_hint_selector");
      return;
    }
    if (paramInt2 == -1)
    {
      paramIntent = (Credential)paramIntent.getParcelableExtra("com.google.android.gms.credentials.Credential");
      loginManager.performLogin(zzyv, zzVX, new LoginManager.LoginListener()
      {
        public final void onFail(LiError.LiAuthErrorCode paramAnonymousLiAuthErrorCode)
        {
          LoginFragment.access$100$43fbe68(LoginFragment.this);
        }
        
        public final void onSuccess()
        {
          preRegListener.onLoginSuccess();
        }
      });
      return;
    }
    handleSmartLockVisibleError$2061f3c7();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof PreRegListener))
    {
      preRegListener = ((PreRegListener)paramActivity);
      return;
    }
    getActivity();
    Util.safeThrow$7a8b4789(new IllegalStateException(TAG + " attached to an Activity that does not implement PreRegListener"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968817, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    emailOrPhoneInput.setOnEditorActionListener(null);
    joinText.setOnClickListener(null);
    signInButton.setOnClickListener(null);
    ButterKnife.reset(passwordVisibilityPresenter);
    emailOrPhoneInput.setOnEditorActionListener(null);
    passwordInput.setOnEditorActionListener(null);
    forgetPasswordText.setOnClickListener(null);
    super.onDestroyView();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    passwordVisibilityPresenter.bind(paramView);
    boolean bool;
    if (!"control".equals(lixManager.getTreatment(PreAuthLix.WWE_LOGIN)))
    {
      bool = true;
      inputValidator.bind(null, null, null, emailOrPhoneContainer, passwordContainer, null, bool);
      if (bool) {
        emailOrPhoneContainer.setHint(2131230850);
      }
      loginListener = new LoginManager.LoginListener()
      {
        boolean isLoginFromThirdPartySdk;
        Intent loginActivityIntent;
        String thirdPartyApplicationPackageName;
        
        public final void onFail(LiError.LiAuthErrorCode paramAnonymousLiAuthErrorCode)
        {
          if (isLoginFromThirdPartySdk) {
            ThirdPartySdkTrackingUtils.emitCustomLoginActionEvent(tracker, thirdPartyApplicationPackageName, VoyagerLoginResult.INVALID_LOGIN, null, -1L);
          }
          SnackbarUtil localSnackbarUtil = snackbar;
          paramAnonymousLiAuthErrorCode = SnackbarUtil.make(getView(), LoginManager.getErrorMessage(paramAnonymousLiAuthErrorCode), 0);
          if (paramAnonymousLiAuthErrorCode != null) {
            paramAnonymousLiAuthErrorCode.show();
          }
        }
        
        public final void onSuccess()
        {
          if (isLoginFromThirdPartySdk)
          {
            String str = applicationComponent.cookieUtil().getJsessionIdOrSetIfNull(sharedPreferences.getAuthUrl());
            ThirdPartySdkTrackingUtils.emitCustomLoginActionEvent(tracker, thirdPartyApplicationPackageName, VoyagerLoginResult.SUCCESS, str, memberUtil.getMemberId());
          }
          preRegListener.onLoginSuccess();
        }
      };
      if (getActivity() == null) {
        break label442;
      }
      paramView = getActivity().getIntent();
      label111:
      if (paramView == null) {
        break label447;
      }
      paramView = paramView.getExtras();
      label120:
      isEmailConfirmationAuthentication = LoginIntentBundle.isEmailConfirmationAuthentication(paramView);
      if (!isEmailConfirmationAuthentication) {
        break label452;
      }
      joinText.setVisibility(8);
      paramBundle = (RelativeLayout.LayoutParams)forgetPasswordText.getLayoutParams();
      paramBundle.addRule(14);
      forgetPasswordText.setLayoutParams(paramBundle);
      label169:
      signInButton.setOnClickListener(new TrackingOnClickListener(tracker, "sign_in", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          signIn();
        }
      });
      emailOrPhoneInput.setOnEditorActionListener(new TrackingOnEditorActionListener(tracker, "email_field", new TrackingEventBuilder[0]));
      passwordInput.setOnEditorActionListener(new TrackingOnEditorActionListener(tracker, "password_field", new TrackingEventBuilder[0])
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          super.onEditorAction(paramAnonymousTextView, paramAnonymousInt, paramAnonymousKeyEvent);
          paramAnonymousTextView = LoginFragment.this;
          if (paramAnonymousInt == 6)
          {
            paramAnonymousTextView.signIn();
            return true;
          }
          return false;
        }
      });
      forgetPasswordText.setOnClickListener(new TrackingOnClickListener(tracker, "forgot_password", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          LoginFragment.access$000(LoginFragment.this);
        }
      });
      JellyBeanMr1Utils.setLabelFor(passwordBoxLabel, 2131756028);
      JellyBeanMr1Utils.setLabelFor(emailOrPhoneBoxLabel, 2131756025);
      if ((smartLockManager.isSmartLockOn()) && (smartLockManager.isConnected())) {
        smartLockManager.loadCredentials(new SmartLockCredentialRequestListener()
        {
          public final void onCredentialRequestFailed() {}
          
          public final void onCredentialRequestHintSelector(Status paramAnonymousStatus)
          {
            LoginFragment.access$300(LoginFragment.this, paramAnonymousStatus, 3);
          }
          
          public final void onCredentialRequestMultipleResults(Status paramAnonymousStatus)
          {
            LoginFragment.access$300(LoginFragment.this, paramAnonymousStatus, 2);
          }
          
          public final void onCredentialRequestSuccess(Credential paramAnonymousCredential)
          {
            loginManager.performLogin(zzyv, zzVX, new LoginManager.LoginListener()
            {
              public final void onFail(LiError.LiAuthErrorCode paramAnonymous2LiAuthErrorCode) {}
              
              public final void onSuccess()
              {
                preRegListener.onLoginSuccess();
              }
            });
          }
        });
      }
      if (paramView == null) {
        break label481;
      }
      paramView = paramView.getString("midToken");
      label337:
      if ("control".equals(lixManager.getTreatment(PreAuthLix.LIX_FASTRACK))) {
        break label486;
      }
    }
    label442:
    label447:
    label452:
    label481:
    label486:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) || (paramView == null) || (!TextUtils.isEmpty(emailOrPhoneInput.getText()))) {
        break label491;
      }
      Object localObject = fastrackManager;
      EditText localEditText = emailOrPhoneInput;
      paramBundle = auth;
      localObject = new FastrackManager.1((FastrackManager)localObject, new Handler(), localEditText);
      liAuth.getFastrackProfile(context, paramView, (ResultReceiver)localObject);
      return;
      bool = false;
      break;
      paramView = null;
      break label111;
      paramView = null;
      break label120;
      joinText.setOnClickListener(new TrackingOnClickListener(tracker, "join", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          goToJoinPage();
        }
      });
      break label169;
      paramView = null;
      break label337;
    }
    label491:
    prefillManager.prefill(emailOrPhoneInput);
  }
  
  public final String pageKey()
  {
    if (isEmailConfirmationAuthentication) {
      return "reg_sign_in_confirm_relogin";
    }
    return "reg_sign_in";
  }
  
  final void signIn()
  {
    if (ActivityManager.isUserAMonkey()) {
      loginManager.performLogin("voy.infra.android@test.linkedin.com", "password", loginListener);
    }
    while (!inputValidator.validate()) {
      return;
    }
    loginManager.performLogin(emailOrPhoneInput.getText().toString().trim(), passwordInput.getText().toString().trim(), loginListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */