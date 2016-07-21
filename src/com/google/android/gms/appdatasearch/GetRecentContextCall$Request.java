package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetRecentContextCall$Request
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  final int mVersionCode;
  public final Account zzTT;
  public final boolean zzTU;
  public final boolean zzTV;
  public final boolean zzTW;
  public final String zzTX;
  
  public GetRecentContextCall$Request()
  {
    this((byte)0);
  }
  
  private GetRecentContextCall$Request(byte paramByte)
  {
    this(1, null, false, false, false, null);
  }
  
  GetRecentContextCall$Request(int paramInt, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    mVersionCode = paramInt;
    zzTT = paramAccount;
    zzTU = paramBoolean1;
    zzTV = paramBoolean2;
    zzTW = paramBoolean3;
    zzTX = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.GetRecentContextCall.Request
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */