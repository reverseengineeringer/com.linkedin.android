package com.linkedin.android.growth.login.join;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.Optional;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;
import com.linkedin.android.growth.boost.BoostUtil;
import com.linkedin.android.growth.login.LoginIntentBundle;
import com.linkedin.android.growth.login.PrefillManager;
import com.linkedin.android.growth.login.login.LoginManager;
import com.linkedin.android.growth.login.login.LoginManager.LoginListener;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.growth.login.presenters.PasswordVisibilityPresenter;
import com.linkedin.android.growth.login.smartlock.SmartLockCredentialRequestListener;
import com.linkedin.android.growth.login.smartlock.SmartLockManager;
import com.linkedin.android.growth.onboarding.OnboardingBundleBuilder;
import com.linkedin.android.growth.utils.GrowthLixHelper;
import com.linkedin.android.growth.utils.InputValidator;
import com.linkedin.android.growth.utils.ThirdPartySdkTrackingUtils;
import com.linkedin.android.infra.ChineseLocaleUtils;
import com.linkedin.android.infra.ChineseLocaleUtils.StandardizedChineseName;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.PreAuthLix;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.StringUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.CustomTextInputLayout;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.common.LiError;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse.RegistrationListener;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.android.liauthlib.registration.RegistrationResponseData;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.AbstractTrackingEvent;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.MultipleTrackingEventSender;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.android.tracking.v2.listeners.TrackingOnEditorActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

public class JoinFragment
  extends PageFragment
{
  private static final String TAG = JoinFragment.class.getSimpleName();
  @InjectView(2131756010)
  TextView accountExistText;
  @Inject
  FlagshipDataManager dataManager;
  @InjectView(2131756026)
  TextView emailOrPhoneBoxLabel;
  @InjectView(2131756024)
  CustomTextInputLayout emailOrPhoneContainer;
  @InjectView(2131756025)
  EditText emailOrPhoneInput;
  @InjectView(2131756014)
  CustomTextInputLayout firstNameContainer;
  @InjectView(2131756015)
  EditText firstNameInput;
  @InjectView(2131756016)
  TextView firstNameLabel;
  @Inject
  FlagshipSharedPreferences flagshipSharedPreferences;
  @InjectView(2131756011)
  @Optional
  CustomTextInputLayout fullNameContainer;
  @InjectView(2131756012)
  @Optional
  EditText fullNameInput;
  @InjectView(2131756013)
  @Optional
  TextView fullNameLabel;
  @Inject
  I18NManager i18nManager;
  @Inject
  InputValidator inputValidator;
  protected boolean isRegistrationViaThirdPartySdk;
  @InjectView(2131756009)
  Button joinButton;
  @Inject
  JoinManager joinManager;
  @Inject
  KeyboardUtil keyboardUtil;
  @InjectView(2131756017)
  CustomTextInputLayout lastNameContainer;
  @InjectView(2131756018)
  EditText lastNameInput;
  @InjectView(2131756019)
  TextView lastNameLabel;
  @InjectView(2131756008)
  TextView legalText;
  @Inject
  LoginManager loginManager;
  @InjectView(2131756029)
  TextView passwordBoxLabel;
  @InjectView(2131756027)
  CustomTextInputLayout passwordContainer;
  @InjectView(2131756028)
  EditText passwordInput;
  @Inject
  PasswordVisibilityPresenter passwordVisibilityPresenter;
  @Inject
  PreAuthLixManager preAuthLixManager;
  protected PreRegListener preRegListener;
  @Inject
  PrefillManager prefillManager;
  @Inject
  SmartLockManager smartLockManager;
  private Uri smartlockImageUri;
  @Inject
  SnackbarUtil snackBar;
  @Inject
  StringUtils stringUtils;
  protected String thirdPartyApplicationPackageName;
  @Inject
  Tracker tracker;
  private boolean wweLixOn;
  
  private void handleSmartLockVisibleError$2061f3c7()
  {
    smartLockManager.isSmartLockOn = false;
  }
  
  private boolean isSignupWithFullName()
  {
    return (GrowthLixHelper.isEnabled(preAuthLixManager, PreAuthLix.LIX_GROWTH_CHINESE_MERGED_NAME)) && (ChineseLocaleUtils.isChineseLocale(getResourcesgetConfigurationlocale)) && (fullNameContainer != null) && (fullNameInput != null) && (fullNameLabel != null);
  }
  
  final void goToSignInPage()
  {
    if (preRegListener != null)
    {
      preRegListener.showLoginScreen();
      return;
    }
    getActivity();
    Util.safeThrow$7a8b4789(new IllegalStateException(TAG + " sign in button does not have a listener attached"));
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  final void join()
  {
    KeyboardUtil.hideKeyboard(passwordInput);
    String str1;
    if (inputValidator.validate())
    {
      if (!isSignupWithFullName()) {
        break label221;
      }
      localObject1 = ChineseLocaleUtils.splitName(fullNameInput.getText().toString());
      str1 = firstName;
    }
    Object localObject2;
    Object localObject3;
    String str2;
    Auth localAuth;
    for (Object localObject1 = lastName;; localObject1 = lastNameInput.getText().toString().trim())
    {
      if (Patterns.PHONE.matcher(emailOrPhoneInput.getText().toString().trim()).matches())
      {
        localObject2 = new ControlInteractionEvent(tracker, "phone_only_join", ControlType.BUTTON, InteractionType.SHORT_PRESS);
        new MultipleTrackingEventSender(tracker, (AbstractTrackingEvent)localObject2, new TrackingEventBuilder[0]).sendAll();
      }
      localObject3 = joinManager;
      localObject2 = emailOrPhoneInput.getText().toString().trim();
      str2 = passwordInput.getText().toString().trim();
      JoinManager.JoinListener local5 = new JoinManager.JoinListener()
      {
        public final void onCaptcha(String paramAnonymousString, CheckpointChallengeResponseData paramAnonymousCheckpointChallengeResponseData, RegistrationResponseData paramAnonymousRegistrationResponseData, RegistrationInfo paramAnonymousRegistrationInfo)
        {
          preRegListener.showPhoneNumberConfirmationScreen(paramAnonymousString, paramAnonymousCheckpointChallengeResponseData, paramAnonymousRegistrationResponseData, paramAnonymousRegistrationInfo);
        }
        
        public final void onFail(LiRegistrationResponse paramAnonymousLiRegistrationResponse)
        {
          if (getActivity() == null) {}
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  if (paramAnonymousLiRegistrationResponse != null) {
                    break;
                  }
                  paramAnonymousLiRegistrationResponse = snackBar.make(2131230833, 0);
                } while (paramAnonymousLiRegistrationResponse == null);
                paramAnonymousLiRegistrationResponse.show();
                return;
              } while (statusCode == 200);
              if ((error == null) || (TextUtils.isEmpty(error.errorMsg))) {
                break;
              }
              paramAnonymousLiRegistrationResponse = snackBar.make(error.errorMsg, 0);
            } while (paramAnonymousLiRegistrationResponse == null);
            paramAnonymousLiRegistrationResponse.show();
            return;
            paramAnonymousLiRegistrationResponse = snackBar.make(2131230833, 0);
          } while (paramAnonymousLiRegistrationResponse == null);
          paramAnonymousLiRegistrationResponse.show();
        }
        
        public final void onSuccess()
        {
          BoostUtil.verifyAndUpgradeAccount(dataManager, flagshipSharedPreferences, getActivity());
          OnboardingBundleBuilder localOnboardingBundleBuilder = null;
          if (smartlockImageUri != null)
          {
            localOnboardingBundleBuilder = new OnboardingBundleBuilder(new Bundle());
            Uri localUri = smartlockImageUri;
            bundle.putParcelable("smartlockImageUri", localUri);
          }
          preRegListener.onJoinSuccess(localOnboardingBundleBuilder);
        }
      };
      localAuth = auth;
      localObject3 = ((JoinManager)localObject3).createRegistrationListener(local5);
      sharedPreferences.setMemberEmail((String)localObject2);
      if (!phoneNumberRegisterAllowed) {
        break;
      }
      liAuth.emailOrPhoneRegister(context, str1, (String)localObject1, (String)localObject2, str2, "trk=p_flagship3_reg_join_tap_join", "confirmEmailRedirectURL", (LiRegistrationResponse.RegistrationListener)localObject3);
      return;
      label221:
      str1 = firstNameInput.getText().toString().trim();
    }
    liAuth.register(context, str1, (String)localObject1, (String)localObject2, str2, "trk=p_flagship3_reg_join_tap_join", "confirmEmailRedirectURL", (LiRegistrationResponse.RegistrationListener)localObject3);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent != null)
    {
      paramIntent = (Credential)paramIntent.getParcelableExtra("com.google.android.gms.credentials.Credential");
      if (paramIntent != null) {
        if (GrowthLixHelper.isEnabled(preAuthLixManager, PreAuthLix.LIX_SMARTLOCK_PROFILE_IMAGE_UPLOAD)) {
          smartlockImageUri = zzVV;
        }
      }
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 3: 
      if (paramInt2 == -1)
      {
        smartLockManager.credentialEmail = zzyv;
        SmartLockManager.sendTrackingEvent(tracker, "smartlock_choose_hint_email");
        emailOrPhoneInput.setText(zzyv);
        return;
      }
      SmartLockManager.sendTrackingEvent(tracker, "smartlock_cancel_hint_selector");
      return;
    }
    if (paramInt2 == -1)
    {
      loginManager.performLogin(zzyv, zzVX, new LoginManager.LoginListener()
      {
        public final void onFail(LiError.LiAuthErrorCode paramAnonymousLiAuthErrorCode)
        {
          JoinFragment.access$200$4348af3c(JoinFragment.this);
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
      if (paramActivity.getIntent() != null)
      {
        thirdPartyApplicationPackageName = LoginIntentBundle.getThirdPartyApplicationPackageName(paramActivity.getIntent().getExtras());
        if (TextUtils.isEmpty(thirdPartyApplicationPackageName)) {
          break label59;
        }
      }
      label59:
      for (boolean bool = true;; bool = false)
      {
        isRegistrationViaThirdPartySdk = bool;
        return;
      }
    }
    getActivity();
    Util.safeThrow$7a8b4789(new IllegalStateException(TAG + " attached to an Activity that does not implement PreRegListener"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968815, paramViewGroup, false);
  }
  
  public void onDestroyView()
  {
    accountExistText.setOnClickListener(null);
    joinButton.setOnClickListener(null);
    legalText.setOnClickListener(null);
    super.onDestroyView();
  }
  
  final boolean onEditorAction(int paramInt)
  {
    if (paramInt == 6)
    {
      if (isRegistrationViaThirdPartySdk) {
        ThirdPartySdkTrackingUtils.emitCustomRegistrationActionEvent(tracker, thirdPartyApplicationPackageName);
      }
      join();
      return true;
    }
    return false;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    passwordVisibilityPresenter.bind(paramView);
    boolean bool;
    if (!"control".equals(preAuthLixManager.getTreatment(PreAuthLix.WWE_REGISTRATION)))
    {
      bool = true;
      wweLixOn = bool;
      legalText.setMovementMethod(LinkMovementMethod.getInstance());
      if (!wweLixOn) {
        break label408;
      }
      legalText.setText(i18nManager.getSpannedString(2131231439, new Object[0]));
      label90:
      legalText.setOnClickListener(new TrackingOnClickListener(tracker, "legal_docs", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          paramAnonymousView = new Bundle();
          paramAnonymousView.putBoolean("wwe_lix", wweLixOn);
          LegalTextChooserDialogBuilder localLegalTextChooserDialogBuilder = new LegalTextChooserDialogBuilder();
          localLegalTextChooserDialogBuilder.setArguments(paramAnonymousView);
          localLegalTextChooserDialogBuilder.show(getFragmentManager(), null);
        }
      });
      prefillManager.prefill(emailOrPhoneInput);
      if (wweLixOn) {
        emailOrPhoneContainer.setHint(2131230850);
      }
      joinButton.setOnClickListener(new TrackingOnClickListener(tracker, "join", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          if (isRegistrationViaThirdPartySdk) {
            ThirdPartySdkTrackingUtils.emitCustomRegistrationActionEvent(tracker, thirdPartyApplicationPackageName);
          }
          join();
        }
      });
      accountExistText.setOnClickListener(new TrackingOnClickListener(tracker, "sign_in", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          goToSignInPage();
        }
      });
      if (!isSignupWithFullName()) {
        break label432;
      }
      inputValidator.bind(null, null, fullNameContainer, emailOrPhoneContainer, passwordContainer, getResourcesgetConfigurationlocale, wweLixOn);
      firstNameContainer.setVisibility(8);
      lastNameContainer.setVisibility(8);
      fullNameContainer.setVisibility(0);
      fullNameInput.setOnEditorActionListener(new TrackingOnEditorActionListener(tracker, "full_name_field", new TrackingEventBuilder[0]));
      JellyBeanMr1Utils.setLabelFor(fullNameLabel, 2131756012);
    }
    for (;;)
    {
      emailOrPhoneInput.setOnEditorActionListener(new TrackingOnEditorActionListener(tracker, "email_field", new TrackingEventBuilder[0]));
      passwordInput.setOnEditorActionListener(new TrackingOnEditorActionListener(tracker, "password_field", new TrackingEventBuilder[0])
      {
        public final boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          super.onEditorAction(paramAnonymousTextView, paramAnonymousInt, paramAnonymousKeyEvent);
          return onEditorAction(paramAnonymousInt);
        }
      });
      JellyBeanMr1Utils.setLabelFor(emailOrPhoneBoxLabel, 2131756025);
      JellyBeanMr1Utils.setLabelFor(passwordBoxLabel, 2131756028);
      if ((smartLockManager.isSmartLockOn()) && (smartLockManager.isConnected())) {
        smartLockManager.loadCredentials(new SmartLockCredentialRequestListener()
        {
          public final void onCredentialRequestFailed() {}
          
          public final void onCredentialRequestHintSelector(Status paramAnonymousStatus)
          {
            JoinFragment.access$300(JoinFragment.this, paramAnonymousStatus, 3);
          }
          
          public final void onCredentialRequestMultipleResults(Status paramAnonymousStatus)
          {
            JoinFragment.access$300(JoinFragment.this, paramAnonymousStatus, 2);
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
      return;
      bool = false;
      break;
      label408:
      legalText.setText(i18nManager.getSpannedString(2131231438, new Object[0]));
      break label90;
      label432:
      inputValidator.bind(firstNameContainer, lastNameContainer, null, emailOrPhoneContainer, passwordContainer, null, wweLixOn);
      firstNameContainer.setVisibility(0);
      lastNameContainer.setVisibility(0);
      if (fullNameContainer != null) {
        fullNameContainer.setVisibility(8);
      }
      firstNameInput.setOnEditorActionListener(new TrackingOnEditorActionListener(tracker, "first_name_field", new TrackingEventBuilder[0]));
      lastNameInput.setOnEditorActionListener(new TrackingOnEditorActionListener(tracker, "last_name_field", new TrackingEventBuilder[0]));
      JellyBeanMr1Utils.setLabelFor(firstNameLabel, 2131756015);
      JellyBeanMr1Utils.setLabelFor(lastNameLabel, 2131756018);
    }
  }
  
  public final String pageKey()
  {
    return "reg_join";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */