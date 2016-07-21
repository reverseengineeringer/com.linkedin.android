package com.linkedin.android.liauthlib.registration;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;
import com.linkedin.android.liauthlib.common.LiRegistrationException;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistrationResponseData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new RegistrationResponseData.1();
  public String mChallengeId;
  public String mChallengeUrl;
  public String mCountryCode;
  public String mFormattedPhoneNumber;
  public String mMemberUrn;
  public String mSubmissionId;
  
  private RegistrationResponseData(Parcel paramParcel)
  {
    mMemberUrn = paramParcel.readString();
    mSubmissionId = paramParcel.readString();
    mChallengeUrl = paramParcel.readString();
    mChallengeId = paramParcel.readString();
    mFormattedPhoneNumber = paramParcel.readString();
    mCountryCode = paramParcel.readString();
  }
  
  public RegistrationResponseData(String paramString)
    throws LiRegistrationException
  {
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("memberUrn")) {
        mMemberUrn = paramString.getString("memberUrn");
      }
      if (paramString.has("submissionId")) {
        mSubmissionId = paramString.getString("submissionId");
      }
      if (paramString.has("challenge"))
      {
        JSONObject localJSONObject = paramString.getJSONObject("challenge");
        if ((localJSONObject != null) && (localJSONObject.has("url"))) {
          mChallengeUrl = localJSONObject.getString("url");
        }
      }
      if (paramString.has("challengeId")) {
        mChallengeId = paramString.getString("challengeId");
      }
      if (paramString.has("phoneNumberInNationalFormat")) {
        mFormattedPhoneNumber = paramString.getString("phoneNumberInNationalFormat");
      }
      if (paramString.has("countryCode")) {
        mCountryCode = paramString.getString("countryCode");
      }
      return;
    }
    catch (JSONException paramString)
    {
      throw RegistrationHelper.badRegistrationRequestException(LiError.LiAuthErrorCode.UNKNOWN_ERROR);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(mMemberUrn);
    paramParcel.writeString(mSubmissionId);
    paramParcel.writeString(mChallengeUrl);
    paramParcel.writeString(mChallengeId);
    paramParcel.writeString(mFormattedPhoneNumber);
    paramParcel.writeString(mCountryCode);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.registration.RegistrationResponseData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */