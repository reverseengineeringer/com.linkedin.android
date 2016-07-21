package com.linkedin.android.growth.login.phoneverification;

import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.EditText;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.liauthlib.registration.CountryDialingCodeMap;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class PhoneConfirmationFragment$1
  extends TrackingOnClickListener
{
  PhoneConfirmationFragment$1(PhoneConfirmationFragment paramPhoneConfirmationFragment, Tracker paramTracker, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramTracker, paramString, paramVarArgs);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    PhoneConfirmationFragment localPhoneConfirmationFragment = this$0;
    newDialingCode = countrySelector.getText().toString();
    if ((newDialingCode.equalsIgnoreCase(dialingCode)) && (!dialingCodeChanged) && (PhoneNumberUtils.compare(phoneConfirm.getText().toString(), formattedPhoneNumber))) {}
    for (int i = 1; i != 0; i = 0)
    {
      localPhoneConfirmationFragment.sendSMSPin(registrationUri, registrationInfo, checkpointResponseData);
      return;
    }
    dialingCodeChanged = false;
    dialingCode = countrySelector.getText().toString();
    paramView = newDialingCode;
    Object localObject1 = CountryDialingCodeMap.dialingCodeMap.entrySet().iterator();
    Object localObject2;
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
    } while (!paramView.equalsIgnoreCase((String)((Map.Entry)localObject2).getValue()));
    for (paramView = (String)((Map.Entry)localObject2).getKey();; paramView = null)
    {
      localObject1 = phoneConfirm.getText().toString();
      localObject2 = registrationInfo.mPassword;
      String str1 = registrationInfo.mFirstName;
      String str2 = registrationInfo.mLastName;
      auth.phoneJoin((String)localObject1, paramView, (String)localObject2, str1, str2, new PhoneConfirmationFragment.4(localPhoneConfirmationFragment));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.phoneverification.PhoneConfirmationFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */