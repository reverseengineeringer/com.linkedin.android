package com.google.android.gms.auth.api.consent;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.ScopeDetail;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class GetConsentIntentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetConsentIntentRequest> CREATOR = new zzb();
  final int mVersionCode;
  final Account zzTI;
  final String zzVO;
  final int zzVP;
  final String zzVQ;
  final ScopeDetail[] zzVR;
  final boolean zzVS;
  final int zzVT;
  final String zzVU;
  
  GetConsentIntentRequest(int paramInt1, String paramString1, int paramInt2, String paramString2, Account paramAccount, ScopeDetail[] paramArrayOfScopeDetail, boolean paramBoolean, int paramInt3, String paramString3)
  {
    mVersionCode = paramInt1;
    zzVO = paramString1;
    zzVP = paramInt2;
    zzVQ = paramString2;
    zzTI = ((Account)zzx.zzz(paramAccount));
    zzVR = paramArrayOfScopeDetail;
    zzVS = paramBoolean;
    zzVT = paramInt3;
    zzVU = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.consent.GetConsentIntentRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */