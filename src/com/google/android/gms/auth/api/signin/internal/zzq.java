package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzq
{
  private static final Lock zzYa = new ReentrantLock();
  private static zzq zzYb;
  private final Lock zzYc = new ReentrantLock();
  private final SharedPreferences zzYd;
  
  private zzq(Context paramContext)
  {
    zzYd = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }
  
  public static zzq zzaf(Context paramContext)
  {
    zzx.zzz(paramContext);
    zzYa.lock();
    try
    {
      if (zzYb == null) {
        zzYb = new zzq(paramContext.getApplicationContext());
      }
      paramContext = zzYb;
      return paramContext;
    }
    finally
    {
      zzYa.unlock();
    }
  }
  
  private GoogleSignInAccount zzbQ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = zzbS(zzs("googleSignInAccount", paramString));
    } while (paramString == null);
    try
    {
      paramString = GoogleSignInAccount.zzbH(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  private GoogleSignInOptions zzbR(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = zzbS(zzs("googleSignInOptions", paramString));
    } while (paramString == null);
    try
    {
      paramString = GoogleSignInOptions.zzbJ(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  private String zzbS(String paramString)
  {
    zzYc.lock();
    try
    {
      paramString = zzYd.getString(paramString, null);
      return paramString;
    }
    finally
    {
      zzYc.unlock();
    }
  }
  
  private void zzbV(String paramString)
  {
    zzYc.lock();
    try
    {
      zzYd.edit().remove(paramString).apply();
      return;
    }
    finally
    {
      zzYc.unlock();
    }
  }
  
  static String zzs(String paramString1, String paramString2)
  {
    return paramString1 + ":" + paramString2;
  }
  
  final void zza(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzx.zzz(paramGoogleSignInAccount);
    zzx.zzz(paramGoogleSignInOptions);
    String str1 = zzWU;
    String str2 = zzs("googleSignInAccount", str1);
    paramGoogleSignInAccount = paramGoogleSignInAccount.zzmJ();
    paramGoogleSignInAccount.remove("serverAuthCode");
    zzr(str2, paramGoogleSignInAccount.toString());
    zzr(zzs("googleSignInOptions", str1), paramGoogleSignInOptions.zzmJ().toString());
  }
  
  public final void zzb(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzx.zzz(paramGoogleSignInAccount);
    zzx.zzz(paramGoogleSignInOptions);
    zzr("defaultGoogleSignInAccount", zzWU);
    zza(paramGoogleSignInAccount, paramGoogleSignInOptions);
  }
  
  final SignInAccount zzbP(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = zzbS(zzs("signInAccount", paramString));
    } while (TextUtils.isEmpty(paramString));
    try
    {
      paramString = SignInAccount.zzbM(paramString);
      if (zzXm != null)
      {
        GoogleSignInAccount localGoogleSignInAccount = zzbQ(zzXm.zzWU);
        if (localGoogleSignInAccount != null) {
          zzXm = localGoogleSignInAccount;
        }
      }
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  final void zzbU(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    zzbV(zzs("googleSignInAccount", paramString));
    zzbV(zzs("googleSignInOptions", paramString));
  }
  
  public final GoogleSignInAccount zzno()
  {
    return zzbQ(zzbS("defaultGoogleSignInAccount"));
  }
  
  public final GoogleSignInOptions zznp()
  {
    return zzbR(zzbS("defaultGoogleSignInAccount"));
  }
  
  public final void zznq()
  {
    String str = zzbS("defaultSignInAccount");
    zzbV("defaultSignInAccount");
    zznr();
    if (!TextUtils.isEmpty(str))
    {
      SignInAccount localSignInAccount = zzbP(str);
      zzbV(zzs("signInAccount", str));
      zzbV(zzs("signInConfiguration", str));
      if ((localSignInAccount != null) && (zzXm != null)) {
        zzbU(zzXm.zzWU);
      }
    }
  }
  
  public final void zznr()
  {
    String str = zzbS("defaultGoogleSignInAccount");
    zzbV("defaultGoogleSignInAccount");
    zzbU(str);
  }
  
  final void zzr(String paramString1, String paramString2)
  {
    zzYc.lock();
    try
    {
      zzYd.edit().putString(paramString1, paramString2).apply();
      return;
    }
    finally
    {
      zzYc.unlock();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.zzq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */