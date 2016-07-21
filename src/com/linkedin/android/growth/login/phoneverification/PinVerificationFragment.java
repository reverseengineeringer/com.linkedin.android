package com.linkedin.android.growth.login.phoneverification;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnTextChanged;
import butterknife.OnTextChanged.Callback;
import com.linkedin.android.growth.login.join.JoinManager;
import com.linkedin.android.growth.login.join.JoinManager.JoinListener;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.common.LiError;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse.RegistrationListener;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.CountryDialingCodeMap;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.android.liauthlib.registration.RegistrationResponseData;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.Map;
import javax.inject.Inject;

public class PinVerificationFragment
  extends PageFragment
{
  private static final String TAG = PhoneConfirmationFragment.class.getSimpleName();
  @Inject
  Auth auth;
  @InjectView(2131756183)
  Button changePhoneNumberButton;
  CheckpointChallengeResponseData checkpointResponseData;
  @Inject
  JoinManager joinManager;
  @InjectView(2131756179)
  EditText pinInputText;
  @InjectView(2131756177)
  TextView pinVerificationTitle;
  @InjectView(2131756181)
  Button pinVerifyButton;
  protected PreRegListener preRegListener;
  RegistrationInfo registrationInfo;
  String registrationUri;
  @InjectView(2131756182)
  Button resendPinButton;
  @Inject
  SnackbarUtil snackbar;
  
  public final boolean isAnchorPage()
  {
    return true;
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
    return paramLayoutInflater.inflate(2130968855, paramViewGroup, false);
  }
  
  @OnTextChanged(callback=OnTextChanged.Callback.AFTER_TEXT_CHANGED, value={2131756179})
  public void onPinEdited(Editable paramEditable)
  {
    Button localButton = pinVerifyButton;
    if (!TextUtils.isEmpty(paramEditable)) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    paramView = getArguments();
    if (paramView != null)
    {
      paramView = paramView.getString("registrationUri");
      registrationUri = paramView;
      paramView = getArguments();
      if (paramView == null) {
        break label296;
      }
      paramView = (CheckpointChallengeResponseData)paramView.getParcelable("checkpointResponseData");
      label56:
      checkpointResponseData = paramView;
      paramView = getArguments();
      if (paramView == null) {
        break label301;
      }
    }
    label296:
    label301:
    for (paramView = (RegistrationInfo)paramView.getParcelable("registrationInfo");; paramView = null)
    {
      registrationInfo = paramView;
      pinVerifyButton.setEnabled(true);
      if (registrationInfo != null)
      {
        paramView = (String)CountryDialingCodeMap.dialingCodeMap.get(registrationInfo.mCountryCode) + registrationInfo.mPhoneNumber;
        pinVerificationTitle.setText(getLocalizedString(2131231645, new Object[] { paramView.replace(" ", " ") }));
      }
      pinVerifyButton.setOnClickListener(new TrackingOnClickListener(tracker, "verify_phone", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          Object localObject = PinVerificationFragment.this;
          if (!TextUtils.isEmpty(pinInputText.getText().toString()))
          {
            paramAnonymousView = pinInputText.getText().toString();
            pinVerifyButton.setEnabled(false);
            Auth localAuth = auth;
            String str = registrationUri;
            RegistrationInfo localRegistrationInfo = registrationInfo;
            CheckpointChallengeResponseData localCheckpointChallengeResponseData = checkpointResponseData;
            localObject = joinManager.createRegistrationListener(new PinVerificationFragment.4((PinVerificationFragment)localObject));
            liAuth.verifySMSPin(context, str, localRegistrationInfo, localCheckpointChallengeResponseData, paramAnonymousView, (LiRegistrationResponse.RegistrationListener)localObject);
          }
        }
      });
      resendPinButton.setOnClickListener(new TrackingOnClickListener(tracker, "resend", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          paramAnonymousView = PinVerificationFragment.this;
          auth.phoneJoin(registrationInfo.mPhoneNumber, registrationInfo.mCountryCode, registrationInfo.mPassword, registrationInfo.mFirstName, registrationInfo.mLastName, new PinVerificationFragment.5(paramAnonymousView));
        }
      });
      changePhoneNumberButton.setOnClickListener(new TrackingOnClickListener(tracker, "edit_phone", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          getFragmentManager().popBackStack();
        }
      });
      if (!"control".equalsIgnoreCase(fragmentComponent.lixManager().getTreatment(Lix.LIX_WWE_WAIT_PIN_TOAST)))
      {
        paramView = snackbar.make(2131231642, 0);
        if (paramView != null) {
          paramView.show();
        }
      }
      return;
      paramView = null;
      break;
      paramView = null;
      break label56;
    }
  }
  
  public final String pageKey()
  {
    return "wwe_phone_verify";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PinVerificationFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */