package com.linkedin.android.growth.onboarding.email_confirmation;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.ConfirmEmailAddress.EmailManagementController;
import com.linkedin.android.ConfirmEmailAddress.EmailManagementController.Result;
import com.linkedin.android.ConfirmEmailAddress.EmailManagementController.ResultListener;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.growth.lego.LegoActionTrackingOnClickListener;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.login.presenters.InputValidationPresenter;
import com.linkedin.android.growth.onboarding.OnboardingBundleBuilder;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider.OnboardingState;
import com.linkedin.android.growth.utils.InputValidator;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.JellyBeanMr1Utils;
import com.linkedin.android.infra.shared.StringUtils;
import com.linkedin.android.infra.ui.CustomTextInputLayout;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.networking.AbstractNetworkClient;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.AbstractRequest;
import com.linkedin.android.networking.request.LinkedInRequestBodyFactory;
import com.linkedin.android.networking.request.RequestDelegateBuilder;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.growth.confirmation.EmailConfirmationTask;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class EmailConfirmationFragment
  extends LegoFragment
{
  @InjectView(2131756101)
  ImageView clearButton;
  @Inject
  DelayedExecution delayedExecution;
  @InjectView(2131756100)
  ImageView editButton;
  private EmailManagementController.ResultListener emailChangeListener;
  private boolean emailConfirmed;
  @InjectView(2131756097)
  CustomTextInputLayout emailContainer;
  @InjectView(2131756098)
  EditText emailInput;
  @InjectView(2131756099)
  TextView emailLabel;
  private EmailManagementController.ResultListener emailSendListener;
  @Inject
  EmailManagementController emailSender;
  @InjectView(2131756106)
  Button goToEmail;
  private boolean hasConfirmEmailError;
  @Inject
  InputValidationPresenter inputValidationPresenter;
  @Inject
  InputValidator inputValidator;
  @Inject
  IntentRegistry intentRegistry;
  @InjectView(2131756102)
  TextView resendEmailText;
  @Inject
  FlagshipSharedPreferences sharedPreferences;
  @InjectView(2131756107)
  Button skipButton;
  @InjectView(2131756096)
  TextView subtitle;
  @InjectView(2131756095)
  TextView title;
  private Runnable updatePollingRunnable;
  
  private OnboardingDataProvider getDataProvider()
  {
    return fragmentComponent.activity().activityComponent.onboardingDataProvider();
  }
  
  private boolean isEmailEditEnabled()
  {
    return !"control".equals(fragmentComponent.lixManager().getTreatment(Lix.GROWTH_ONBOARDING_EMAIL_EDITABLE));
  }
  
  private boolean isSkipEnabled()
  {
    return ("hardblock_wskip".equals(fragmentComponent.lixManager().getTreatment(Lix.GROWTH_ONBOARDING_EMAIL_EDITABLE))) || ((!isEmailEditEnabled()) && (OnboardingBundleBuilder.isOnboardingResume(getActivity().getIntent().getExtras())));
  }
  
  public final void doPause()
  {
    super.doPause();
    delayedExecution.stopDelayedExecution(updatePollingRunnable);
  }
  
  public final void doResume()
  {
    super.doResume();
    if ((emailConfirmed) || (TextUtils.isEmpty(sharedPreferences.getMemberEmail())))
    {
      legoWidget.finishCurrentFragment();
      return;
    }
    getDataProvider().fetchEmailConfirmationTask(busSubscriberId, Tracker.createPageInstanceHeader(getPageInstance()));
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    boolean bool;
    if (paramBundle != null)
    {
      emailConfirmed = paramBundle.getBoolean("emailConfirmed");
      bool = paramBundle.getBoolean("hasConfirmEmailError");
    }
    for (;;)
    {
      hasConfirmEmailError = bool;
      updatePollingRunnable = new Runnable()
      {
        public final void run()
        {
          EmailConfirmationFragment localEmailConfirmationFragment = EmailConfirmationFragment.this;
          if ((localEmailConfirmationFragment.isAdded()) && (localEmailConfirmationFragment.isResumed())) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              EmailConfirmationFragment.this.getDataProvider().fetchEmailConfirmationTask(busSubscriberId, Tracker.createPageInstanceHeader(getPageInstance()));
            }
            return;
          }
        }
      };
      emailSendListener = new EmailManagementController.ResultListener()
      {
        public final void onResult(EmailManagementController.Result paramAnonymousResult)
        {
          View localView = getView();
          if (localView != null)
          {
            if (success) {
              Snackbar.make(localView, 2131231542, 0).show();
            }
          }
          else {
            return;
          }
          Snackbar.make(localView, 2131231541, 0).show();
        }
      };
      emailChangeListener = new EmailManagementController.ResultListener()
      {
        public final void onResult(EmailManagementController.Result paramAnonymousResult)
        {
          View localView = getView();
          if (localView != null)
          {
            if (success) {
              EmailConfirmationFragment.access$100(EmailConfirmationFragment.this, paramAnonymousResult, localView);
            }
          }
          else {
            return;
          }
          Snackbar.make(localView, 2131231541, 0).show();
          legoWidget.finishCurrentFragment();
        }
      };
      return;
      paramBundle = getArguments();
      if ((paramBundle != null) && (paramBundle.getBoolean("hasConfirmEmailError"))) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968833, paramViewGroup, false);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    paramType = ((OnboardingDataProvider.OnboardingState)getDataProviderstate).emailConfirmationTask();
    if ((paramType != null) && (!hasEmail))
    {
      emailConfirmed = true;
      legoWidget.finishCurrentFragment();
      return;
    }
    delayedExecution.postDelayedExecution(updatePollingRunnable, 5000L);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("emailConfirmed", emailConfirmed);
    paramBundle.putBoolean("hasConfirmEmailError", hasConfirmEmailError);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    inputValidator.bind(null, null, null, emailContainer, null, null, false);
    paramBundle = sharedPreferences.getMemberEmail();
    if (!TextUtils.isEmpty(paramBundle)) {
      emailInput.setText(paramBundle);
    }
    if (isEmailEditEnabled())
    {
      editButton.setVisibility(0);
      emailInput.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            clearButton.setVisibility(0);
            editButton.setVisibility(8);
          }
        }
      });
      emailInput.addTextChangedListener(new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          boolean bool = false;
          Object localObject = clearButton;
          if (paramAnonymousEditable.length() == 0) {}
          for (int i = 8;; i = 0)
          {
            ((ImageView)localObject).setVisibility(i);
            localObject = resendEmailText;
            if (paramAnonymousEditable.length() > 0) {
              bool = true;
            }
            ((TextView)localObject).setEnabled(bool);
            return;
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      });
      clearButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          emailInput.setText("");
          emailInput.setSelection(emailInput.getText().length());
          emailInput.requestFocus();
        }
      });
      editButton.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          emailInput.setFocusableInTouchMode(true);
          emailInput.setSelection(emailInput.getText().length());
          emailInput.requestFocus();
        }
      });
      resendEmailText.setVisibility(0);
      resendEmailText.setOnClickListener(new LegoActionTrackingOnClickListener(legoWidget.getTrackingToken(), ActionCategory.SECONDARY_ACTION, legoTrackingDataProvider, tracker, "resend", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          resendEmailIfValid();
        }
      });
      if ((isSkipEnabled()) || ((OnboardingBundleBuilder.isOnboardingResume(getActivity().getIntent().getExtras())) && (isEmailEditEnabled())))
      {
        title.setText(2131231546);
        subtitle.setText(2131231544);
      }
      goToEmail.setText(2131231535);
      goToEmail.setEnabled(true);
      goToEmail.setOnClickListener(new LegoActionTrackingOnClickListener(legoWidget.getTrackingToken(), ActionCategory.PRIMARY_ACTION, legoTrackingDataProvider, tracker, "go_to_email", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          Intent localIntent = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.APP_EMAIL");
          try
          {
            startActivity(localIntent);
            return;
          }
          catch (ActivityNotFoundException localActivityNotFoundException)
          {
            Snackbar.make(paramAnonymousView, 2131231536, 0).show();
          }
        }
      });
      if (!isSkipEnabled()) {
        break label386;
      }
      skipButton.setText(2131231613);
      skipButton.setOnClickListener(new LegoActionTrackingOnClickListener(legoWidget.getTrackingToken(), ActionCategory.DISMISS, legoTrackingDataProvider, tracker, "dismiss", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          legoWidget.finishCurrentFragment();
        }
      });
    }
    for (;;)
    {
      JellyBeanMr1Utils.setLabelFor(emailLabel, 2131756098);
      if (hasConfirmEmailError)
      {
        hasConfirmEmailError = false;
        Snackbar.make(paramView, 2131231537, 0).show();
      }
      return;
      emailInput.setFocusable(false);
      emailInput.setEnabled(false);
      break;
      label386:
      if (isEmailEditEnabled())
      {
        skipButton.setVisibility(8);
      }
      else
      {
        skipButton.setText(2131231540);
        skipButton.setOnClickListener(new LegoActionTrackingOnClickListener(legoWidget.getTrackingToken(), ActionCategory.SECONDARY_ACTION, legoTrackingDataProvider, tracker, "resend", new TrackingEventBuilder[0])
        {
          public final void onClick(View paramAnonymousView)
          {
            super.onClick(paramAnonymousView);
            resendEmailIfValid();
          }
        });
      }
    }
  }
  
  public final String pageKey()
  {
    return "onboarding_email_confirm";
  }
  
  protected final void resendEmailIfValid()
  {
    final Object localObject1 = inputValidator;
    final Object localObject2;
    if (emailOrPhone != null)
    {
      localObject2 = emailOrPhone.getEditText().getText();
      if (StringUtils.isEmptyTrimmed((CharSequence)localObject2))
      {
        i = 3;
        inputValidationPresenter.presentValidation(i, emailOrPhone);
        if (i == 13) {
          break label218;
        }
      }
    }
    label218:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        if ((!isEmailEditEnabled()) || (emailInput.getText().toString().equals(sharedPreferences.getMemberEmail()))) {
          break label223;
        }
        emailInput.setFocusable(false);
        clearButton.setVisibility(8);
        editButton.setVisibility(0);
        localObject1 = new AlertDialog.Builder(getActivity());
        P.mView = null;
        P.mViewLayoutResId = 2130969122;
        P.mViewSpacingSpecified = false;
        ((AlertDialog.Builder)localObject1).setCancelable(true);
        localObject1 = ((AlertDialog.Builder)localObject1).create();
        ((AlertDialog)localObject1).show();
        localObject2 = (EditText)((AlertDialog)localObject1).findViewById(2131757127);
        ((Button)((AlertDialog)localObject1).findViewById(2131757128)).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            paramAnonymousView = emailSender;
            Object localObject3 = emailInput.getText().toString();
            Object localObject4 = localObject2.getText().toString();
            Object localObject2 = emailChangeListener;
            try
            {
              Object localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("emailToAdd=").append((String)localObject3).append('&').append("password=").append((String)localObject4);
              localObject3 = mNetworkClient.getRequestFactory();
              localObject2 = paramAnonymousView.getResponseListener((EmailManagementController.ResultListener)localObject2);
              localObject4 = mContext;
              localObject1 = ((RequestFactory)localObject3).getAbsoluteRequest$3868be9b(1, "https://www.linkedin-ei.com/psettings/email/change", (ResponseListener)localObject2, createsetBodycreate"application/x-www-form-urlencoded"toStringgetBytes"UTF-8"requestDelegate);
              mNetworkClient.add((AbstractRequest)localObject1);
              localObject1.dismiss();
              return;
            }
            catch (UnsupportedEncodingException paramAnonymousView)
            {
              for (;;)
              {
                Log.e(EmailManagementController.TAG, "Error encoding update email post body", paramAnonymousView);
              }
            }
          }
        });
      }
      return;
      if (InputValidator.isInvalidEmail((CharSequence)localObject2))
      {
        i = 8;
        break;
      }
      i = 13;
      break;
    }
    label223:
    emailSender.send(emailInput.getText().toString(), "confirm_your_email", "start-onboarding-takeover", emailSendListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.email_confirmation.EmailConfirmationFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */