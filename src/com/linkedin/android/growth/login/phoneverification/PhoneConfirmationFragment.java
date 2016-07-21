package com.linkedin.android.growth.login.phoneverification;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import butterknife.InjectView;
import butterknife.OnTextChanged;
import butterknife.OnTextChanged.Callback;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.liauthlib.common.LiError;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse.RegistrationListener;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.CountryDialingCodeMap;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.android.liauthlib.registration.RegistrationResponseData;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.Country;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.xmsg.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;

public class PhoneConfirmationFragment
  extends PageFragment
{
  private static final String TAG = PhoneConfirmationFragment.class.getSimpleName();
  @Inject
  Auth auth;
  CheckpointChallengeResponseData checkpointResponseData;
  List<Country> countriesList = new ArrayList();
  @InjectView(2131756168)
  EditText countrySelector;
  @Inject
  CountrySelectorManager countrySelectorManager;
  String dialingCode;
  boolean dialingCodeChanged;
  String formattedPhoneNumber;
  String newDialingCode;
  @InjectView(2131756169)
  EditText phoneConfirm;
  @InjectView(2131756171)
  Button phoneConfirmButton;
  protected PreRegListener preRegListener;
  ProfileDataProvider profileDataProvider;
  RegistrationInfo registrationInfo;
  String registrationUri;
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
    return paramLayoutInflater.inflate(2130968852, paramViewGroup, false);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    paramType = ((ProfileState)profileDataProvider.state).countries();
    if (paramType != null) {
      countriesList = elements;
    }
  }
  
  @OnTextChanged(callback=OnTextChanged.Callback.AFTER_TEXT_CHANGED, value={2131756169})
  public void onPhoneNumberEdited(Editable paramEditable)
  {
    Button localButton = phoneConfirmButton;
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
    countrySelector.setOnClickListener(new TrackingOnClickListener(tracker, "area_code", new TrackingEventBuilder[0]));
    phoneConfirmButton.setOnClickListener(new TrackingOnClickListener(tracker, "send", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        PhoneConfirmationFragment localPhoneConfirmationFragment = PhoneConfirmationFragment.this;
        newDialingCode = countrySelector.getText().toString();
        if ((newDialingCode.equalsIgnoreCase(dialingCode)) && (!dialingCodeChanged) && (PhoneNumberUtils.compare(phoneConfirm.getText().toString(), formattedPhoneNumber))) {}
        for (int i = 1; i != 0; i = 0)
        {
          localPhoneConfirmationFragment.sendSMSPin(registrationUri, registrationInfo, checkpointResponseData);
          return;
        }
        dialingCodeChanged = false;
        dialingCode = countrySelector.getText().toString();
        paramAnonymousView = newDialingCode;
        Object localObject1 = CountryDialingCodeMap.dialingCodeMap.entrySet().iterator();
        Object localObject2;
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
        } while (!paramAnonymousView.equalsIgnoreCase((String)((Map.Entry)localObject2).getValue()));
        for (paramAnonymousView = (String)((Map.Entry)localObject2).getKey();; paramAnonymousView = null)
        {
          localObject1 = phoneConfirm.getText().toString();
          localObject2 = registrationInfo.mPassword;
          String str1 = registrationInfo.mFirstName;
          String str2 = registrationInfo.mLastName;
          auth.phoneJoin((String)localObject1, paramAnonymousView, (String)localObject2, str1, str2, new PhoneConfirmationFragment.4(localPhoneConfirmationFragment));
          return;
        }
      }
    });
    paramView = getArguments();
    if (paramView != null)
    {
      paramView = paramView.getString("registrationUri");
      registrationUri = paramView;
      paramView = getArguments();
      if (paramView == null) {
        break label374;
      }
      paramView = (CheckpointChallengeResponseData)paramView.getParcelable("checkpointResponseData");
      label105:
      checkpointResponseData = paramView;
      paramView = getArguments();
      if (paramView == null) {
        break label379;
      }
      paramView = (RegistrationInfo)paramView.getParcelable("registrationInfo");
      label129:
      registrationInfo = paramView;
      if ((BaseActivity)getActivity() != null) {
        profileDataProvider = getActivityactivityComponent.profileDataProvider();
      }
      if (getRumSessionId() != null) {
        profileDataProvider.getCountries(busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()));
      }
      paramView = getArguments();
      if (paramView == null) {
        break label384;
      }
      paramView = (RegistrationResponseData)paramView.getParcelable("registrationResponseData");
      label212:
      if (paramView != null)
      {
        formattedPhoneNumber = mFormattedPhoneNumber;
        paramBundle = formattedPhoneNumber;
        phoneConfirm.setText(getLocalizedString(2131231631, new Object[] { paramBundle }));
        if (mCountryCode == null) {
          break label389;
        }
      }
    }
    label374:
    label379:
    label384:
    label389:
    for (dialingCode = ((String)CountryDialingCodeMap.dialingCodeMap.get(mCountryCode));; dialingCode = "+1")
    {
      if (registrationInfo != null)
      {
        registrationInfo.mCountryCode = mCountryCode;
        registrationInfo.mPhoneNumber = mFormattedPhoneNumber;
      }
      newDialingCode = dialingCode;
      countrySelector.setText(dialingCode);
      countrySelector.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          PhoneConfirmationFragment localPhoneConfirmationFragment = PhoneConfirmationFragment.this;
          dialingCodeChanged = newDialingCode.equalsIgnoreCase(dialingCode);
          new PageViewEvent(tracker, "wwe_code_typeahead", false).send();
          CountrySelectorManager localCountrySelectorManager = countrySelectorManager;
          paramAnonymousView = countriesList;
          EditText localEditText = countrySelector;
          Object localObject1 = new AlertDialog.Builder(activity);
          Object localObject2 = (ScrollView)activity.findViewById(2131756163);
          localObject2 = activity.getLayoutInflater().inflate(2130968854, (ViewGroup)localObject2, false);
          ((AlertDialog.Builder)localObject1).setView((View)localObject2);
          AlertDialog localAlertDialog = ((AlertDialog.Builder)localObject1).show();
          ((Button)((View)localObject2).findViewById(2131756176)).setOnClickListener(new CountrySelectorManager.1(localCountrySelectorManager, localAlertDialog));
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = paramAnonymousView.iterator();
          while (localIterator.hasNext())
          {
            paramAnonymousView = (Country)localIterator.next();
            String str = countryName;
            localObject1 = (String)CountryDialingCodeMap.dialingCodeMap.get(countryCode);
            paramAnonymousView = (View)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramAnonymousView = "+1";
            }
            localObject1 = new CountryNameDialingCodeViewModel();
            countryName = str;
            dialingCode = paramAnonymousView;
            listener = new CountryNameDialingCodeTransformer.1(localEditText, (CountryNameDialingCodeViewModel)localObject1, localAlertDialog);
            localArrayList.add(localObject1);
          }
          paramAnonymousView = new ViewModelArrayAdapter(activity, applicationComponent.mediaCenter(), localArrayList);
          localObject1 = (RecyclerView)((View)localObject2).findViewById(2131756175);
          ((RecyclerView)localObject1).setLayoutManager(new LinearLayoutManager(activity));
          ((RecyclerView)localObject1).setAdapter(paramAnonymousView);
          localAlertDialog.getWindow().setLayout(-1, -1);
        }
      });
      countrySelector.setFocusable(false);
      countrySelector.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getActivity(), 2130837940), null);
      return;
      paramView = null;
      break;
      paramView = null;
      break label105;
      paramView = null;
      break label129;
      paramView = null;
      break label212;
    }
  }
  
  public final String pageKey()
  {
    return "wwe_phone_confirm";
  }
  
  final void sendSMSPin(String paramString, RegistrationInfo paramRegistrationInfo, CheckpointChallengeResponseData paramCheckpointChallengeResponseData)
  {
    auth.sendSMSPin(paramString, paramRegistrationInfo, paramCheckpointChallengeResponseData, new ResultReceiver(new Handler())
    {
      public void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        String str;
        CheckpointChallengeResponseData localCheckpointChallengeResponseData;
        if (paramAnonymousInt == 1)
        {
          str = paramAnonymousBundle.getString("registrationUri");
          localCheckpointChallengeResponseData = (CheckpointChallengeResponseData)paramAnonymousBundle.getParcelable("checkpointResponseData");
          paramAnonymousBundle = (RegistrationInfo)paramAnonymousBundle.getParcelable("registrationInfo");
          if ((str == null) || (localCheckpointChallengeResponseData == null) || (paramAnonymousBundle == null))
          {
            paramAnonymousBundle = snackbar.make(2131231634, 0);
            if (paramAnonymousBundle != null) {
              paramAnonymousBundle.show();
            }
          }
        }
        do
        {
          return;
          preRegListener.showPinVerificationScreen(str, localCheckpointChallengeResponseData, paramAnonymousBundle);
          return;
          str = paramAnonymousBundle.getString("sendSmsError");
          paramAnonymousBundle = str;
          if (StringUtils.isEmpty(str)) {
            paramAnonymousBundle = i18NManager.getString(2131231634);
          }
          paramAnonymousBundle = snackbar.make(paramAnonymousBundle, 0);
        } while (paramAnonymousBundle == null);
        paramAnonymousBundle.show();
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */