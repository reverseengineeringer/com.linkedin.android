package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class GetRecentContextCall
{
  public static class Request
    implements SafeParcelable
  {
    public static final zzf CREATOR = new zzf();
    final int mVersionCode;
    public final Account zzTT;
    public final boolean zzTU;
    public final boolean zzTV;
    public final boolean zzTW;
    public final String zzTX;
    
    public Request()
    {
      this((byte)0);
    }
    
    private Request(byte paramByte)
    {
      this(1, null, false, false, false, null);
    }
    
    Request(int paramInt, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
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
  
  public static class Response
    implements Result, SafeParcelable
  {
    public static final zzg CREATOR = new zzg();
    final int mVersionCode;
    public Status zzTY;
    public List<UsageInfo> zzTZ;
    @Deprecated
    public String[] zzUa;
    
    public Response()
    {
      mVersionCode = 1;
    }
    
    Response(int paramInt, Status paramStatus, List<UsageInfo> paramList, String[] paramArrayOfString)
    {
      mVersionCode = paramInt;
      zzTY = paramStatus;
      zzTZ = paramList;
      zzUa = paramArrayOfString;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public final Status getStatus()
    {
      return zzTY;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzg.zza(this, paramParcel, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.GetRecentContextCall
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */