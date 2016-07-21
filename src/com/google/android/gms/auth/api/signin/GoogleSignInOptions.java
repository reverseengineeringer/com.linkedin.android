package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions
  implements Api.ApiOptions.Optional, SafeParcelable
{
  public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zzc();
  public static final GoogleSignInOptions DEFAULT_SIGN_IN;
  private static Comparator<Scope> zzWV = new Comparator() {};
  public static final Scope zzWW = new Scope("profile");
  public static final Scope zzWX = new Scope("email");
  public static final Scope zzWY = new Scope("openid");
  final int versionCode;
  public Account zzTI;
  private final ArrayList<Scope> zzWZ;
  public boolean zzXa;
  public final boolean zzXb;
  final boolean zzXc;
  public String zzXd;
  String zzXe;
  
  static
  {
    Builder localBuilder = new Builder().requestId();
    zzXf.add(zzWW);
    DEFAULT_SIGN_IN = localBuilder.build();
  }
  
  GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2)
  {
    versionCode = paramInt;
    zzWZ = paramArrayList;
    zzTI = paramAccount;
    zzXa = paramBoolean1;
    zzXb = paramBoolean2;
    zzXc = paramBoolean3;
    zzXd = paramString1;
    zzXe = paramString2;
  }
  
  private GoogleSignInOptions(Set<Scope> paramSet, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2)
  {
    this(2, new ArrayList(paramSet), paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString1, paramString2);
  }
  
  public static GoogleSignInOptions zzbJ(String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    HashSet localHashSet = new HashSet();
    paramString = localJSONObject.getJSONArray("scopes");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      localHashSet.add(new Scope(paramString.getString(i)));
      i += 1;
    }
    paramString = localJSONObject.optString("accountName", null);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = new Account(paramString, "com.google");; paramString = null) {
      return new GoogleSignInOptions(localHashSet, paramString, localJSONObject.getBoolean("idTokenRequested"), localJSONObject.getBoolean("serverAuthRequested"), localJSONObject.getBoolean("forceCodeForRefreshToken"), localJSONObject.optString("serverClientId", null), localJSONObject.optString("hostedDomain", null));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramObject = (GoogleSignInOptions)paramObject;
        if ((zzWZ.size() != ((GoogleSignInOptions)paramObject).zzmN().size()) || (!zzWZ.containsAll(((GoogleSignInOptions)paramObject).zzmN()))) {
          continue;
        }
        if (zzTI == null)
        {
          if (zzTI != null) {
            continue;
          }
          label56:
          if (!TextUtils.isEmpty(zzXd)) {
            break label128;
          }
          if (!TextUtils.isEmpty(zzXd)) {
            continue;
          }
        }
        while ((zzXc == zzXc) && (zzXa == zzXa) && (zzXb == zzXb))
        {
          return true;
          if (!zzTI.equals(zzTI)) {
            break;
          }
          break label56;
          label128:
          boolean bool = zzXd.equals(zzXd);
          if (!bool) {
            break;
          }
        }
        return false;
      }
      catch (ClassCastException paramObject) {}
    }
  }
  
  public int hashCode()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = zzWZ.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(nextzzagB);
    }
    Collections.sort(localArrayList);
    return zzezzpzzpzzTI).zzp(zzXd).zzP(zzXc).zzP(zzXa).zzP(zzXb).zzXz;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public final JSONObject zzmJ()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Collections.sort(zzWZ, zzWV);
      Iterator localIterator = zzWZ.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(nextzzagB);
      }
      localJSONException.put("scopes", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    if (zzTI != null) {
      localJSONException.put("accountName", zzTI.name);
    }
    localJSONException.put("idTokenRequested", zzXa);
    localJSONException.put("forceCodeForRefreshToken", zzXc);
    localJSONException.put("serverAuthRequested", zzXb);
    if (!TextUtils.isEmpty(zzXd)) {
      localJSONException.put("serverClientId", zzXd);
    }
    if (!TextUtils.isEmpty(zzXe)) {
      localJSONException.put("hostedDomain", zzXe);
    }
    return localJSONException;
  }
  
  public final ArrayList<Scope> zzmN()
  {
    return new ArrayList(zzWZ);
  }
  
  public static final class Builder
  {
    public Account zzTI;
    public boolean zzXa;
    private boolean zzXb;
    private boolean zzXc;
    public String zzXd;
    private String zzXe;
    public Set<Scope> zzXf = new HashSet();
    
    public Builder() {}
    
    public Builder(GoogleSignInOptions paramGoogleSignInOptions)
    {
      zzx.zzz(paramGoogleSignInOptions);
      zzXf = new HashSet(GoogleSignInOptions.zzb(paramGoogleSignInOptions));
      zzXb = GoogleSignInOptions.zzc(paramGoogleSignInOptions);
      zzXc = GoogleSignInOptions.zzd(paramGoogleSignInOptions);
      zzXa = GoogleSignInOptions.zze(paramGoogleSignInOptions);
      zzXd = GoogleSignInOptions.zzf(paramGoogleSignInOptions);
      zzTI = GoogleSignInOptions.zzg(paramGoogleSignInOptions);
      zzXe = GoogleSignInOptions.zzh(paramGoogleSignInOptions);
    }
    
    public final GoogleSignInOptions build()
    {
      if ((zzXa) && ((zzTI == null) || (!zzXf.isEmpty()))) {
        requestId();
      }
      return new GoogleSignInOptions(zzXf, zzTI, zzXa, zzXb, zzXc, zzXd, zzXe, (byte)0);
    }
    
    public final Builder requestId()
    {
      zzXf.add(GoogleSignInOptions.zzWY);
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.GoogleSignInOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */