package com.linkedin.android.liauthlib.registration;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class RegistrationInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new RegistrationInfo.1();
  public String mAuthToken;
  public String mChallengeId;
  public String mCountryCode;
  public String mEmail;
  public String mFirstName;
  public String mLastName;
  public String mPassword;
  public String mPhoneNumber;
  
  protected RegistrationInfo(Parcel paramParcel)
  {
    mAuthToken = paramParcel.readString();
    mFirstName = paramParcel.readString();
    mLastName = paramParcel.readString();
    mEmail = paramParcel.readString();
    mPhoneNumber = paramParcel.readString();
    mCountryCode = paramParcel.readString();
    mPassword = paramParcel.readString();
    mChallengeId = paramParcel.readString();
  }
  
  public RegistrationInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    mAuthToken = paramString1;
    mFirstName = paramString2;
    mLastName = paramString3;
    mEmail = paramString4;
    mPhoneNumber = paramString5;
    mCountryCode = paramString6;
    mPassword = paramString7;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(mAuthToken);
    paramParcel.writeString(mFirstName);
    paramParcel.writeString(mLastName);
    paramParcel.writeString(mEmail);
    paramParcel.writeString(mPhoneNumber);
    paramParcel.writeString(mCountryCode);
    paramParcel.writeString(mPassword);
    paramParcel.writeString(mChallengeId);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.registration.RegistrationInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */