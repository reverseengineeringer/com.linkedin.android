package com.linkedin.android.growth.login;

import android.content.Intent;
import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.liauthlib.LiAuth.LogoutReason;

public final class LoginIntentBundle
  implements BundleBuilder
{
  public final Bundle bundle = new Bundle();
  
  public static String getThirdPartyApplicationPackageName(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("thirdPartyApplicationPackageName");
    }
    return null;
  }
  
  public static boolean isEmailConfirmationAuthentication(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.getBoolean("emailConfirmationAuthentication"));
  }
  
  public static boolean isLogout(Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBundle != null)
    {
      bool1 = bool2;
      if (paramBundle.getBoolean("logout", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final LoginIntentBundle isLogout(LiAuth.LogoutReason paramLogoutReason)
  {
    bundle.putBoolean("logout", true);
    bundle.putSerializable("logoutReason", paramLogoutReason);
    return this;
  }
  
  public final LoginIntentBundle setRedirectIntent(Intent paramIntent)
  {
    bundle.putParcelable("redirect", paramIntent);
    return this;
  }
  
  public final LoginIntentBundle setThirdPartyApplicationPackageName(String paramString)
  {
    bundle.putString("thirdPartyApplicationPackageName", paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.LoginIntentBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */