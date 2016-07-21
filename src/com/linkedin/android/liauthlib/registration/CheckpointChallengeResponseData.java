package com.linkedin.android.liauthlib.registration;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;
import com.linkedin.android.liauthlib.common.LiRegistrationException;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckpointChallengeResponseData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new CheckpointChallengeResponseData.1();
  public String mSendPinViaCallUri;
  public String mSendPinViaSMSUri;
  public String mSubmitUri;
  
  private CheckpointChallengeResponseData(Parcel paramParcel)
  {
    mSubmitUri = paramParcel.readString();
    mSendPinViaCallUri = paramParcel.readString();
    mSendPinViaSMSUri = paramParcel.readString();
  }
  
  public CheckpointChallengeResponseData(String paramString)
    throws LiRegistrationException
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (!paramString.has("view")) {
        break label192;
      }
      paramString = paramString.getJSONObject("view");
      if (paramString.has("com.linkedin.checkpoint.challenge.PhoneVerificationView"))
      {
        paramString = paramString.getJSONObject("com.linkedin.checkpoint.challenge.PhoneVerificationView");
        if (paramString.has("submitUri")) {
          mSubmitUri = paramString.getString("submitUri");
        }
        if (paramString.has("sendPinViaPhoneCallUri")) {
          mSendPinViaCallUri = paramString.getString("sendPinViaPhoneCallUri");
        }
        if (!paramString.has("sendPinViaSmsUri")) {
          return;
        }
        mSendPinViaSMSUri = paramString.getString("sendPinViaSmsUri");
        return;
      }
      if (paramString.has("com.linkedin.checkpoint.challenge.RegisterPhoneNumberView"))
      {
        paramString = paramString.getJSONObject("com.linkedin.checkpoint.challenge.RegisterPhoneNumberView");
        if (paramString.has("submitUri")) {
          mSubmitUri = paramString.getString("submitUri");
        }
        if (paramString.has("sendPinViaPhoneCallUri")) {
          mSendPinViaCallUri = paramString.getString("sendPinViaPhoneCallUri");
        }
        if (!paramString.has("sendPinViaSmsUri")) {
          return;
        }
        mSendPinViaSMSUri = paramString.getString("sendPinViaSmsUri");
        return;
      }
    }
    catch (JSONException paramString)
    {
      throw RegistrationHelper.badRegistrationRequestException(LiError.LiAuthErrorCode.UNKNOWN_ERROR);
    }
    throw RegistrationHelper.badRegistrationRequestException(LiError.LiAuthErrorCode.UNKNOWN_ERROR);
    label192:
    throw RegistrationHelper.badRegistrationRequestException(LiError.LiAuthErrorCode.UNKNOWN_ERROR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(mSubmitUri);
    paramParcel.writeString(mSendPinViaCallUri);
    paramParcel.writeString(mSendPinViaSMSUri);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */