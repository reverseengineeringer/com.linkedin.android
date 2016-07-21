package com.linkedin.android.liauthlib.sso;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.RemoteException;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.common.LiSSOInfo;
import com.linkedin.android.liauthlib.common.LiSharedPrefUtils;
import com.linkedin.android.liauthlib.network.HttpStack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class LiSSOService$1
  extends IAuthService.Stub
{
  LiSSOService$1(LiSSOService paramLiSSOService) {}
  
  private static Map<String, String> getSignedInUserWithProfileData(String paramString, Context paramContext, boolean paramBoolean)
  {
    Object localObject = null;
    if (LiSSOService.verifyCallerSignature(paramContext, getCallingUid()))
    {
      LiAuth localLiAuth = LiSSOService.getLiAuth(paramContext);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(localLiAuth.getBaseHost())) && (!TextUtils.isEmpty(localLiAuth.getHttpStack().getCookie("li_at", Uri.parse(paramString).getHost()))))
      {
        paramString = paramContext.getSharedPreferences("auth_library_prefs", 0);
        if (TextUtils.isEmpty(paramString.getString("auth_username", null))) {}
        for (paramString = (String)localObject; (paramString == null) || ((!paramBoolean) && (!TextUtils.isEmpty(username)) && (!username.contains("@"))); paramString = new LiSSOInfo(paramContext, paramString)) {
          return Collections.emptyMap();
        }
        paramContext = new HashMap();
        paramContext.put("auth_username", username);
        paramContext.put("auth_member_id", memberID);
        paramContext.put("auth_first_name", firstName);
        paramContext.put("auth_last_name", lastName);
        paramContext.put("auth_full_name", fullName);
        paramContext.put("auth_short_full_name", shortFullName);
        paramContext.put("auth_headline", headline);
        paramContext.put("auth_picture_url", pictureUrl);
        paramContext.put("auth_package_name", pkgName);
        paramContext.put("auth_app_name", appName);
        return paramContext;
      }
    }
    return Collections.emptyMap();
  }
  
  public final Map getEmailAndPhoneSignedInUserWithProfileData(String paramString)
    throws RemoteException
  {
    return getSignedInUserWithProfileData(paramString, this$0, true);
  }
  
  public final Bitmap getProfilePicForUser(String paramString)
    throws RemoteException
  {
    Object localObject2 = null;
    LiSSOService localLiSSOService = this$0;
    Object localObject1 = localObject2;
    if (LiSSOService.verifyCallerSignature(localLiSSOService, getCallingUid()))
    {
      String str = localLiSSOService.getSharedPreferences("auth_library_prefs", 0).getString("auth_username", null);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = localObject2;
        if (paramString.equalsIgnoreCase(str)) {
          localObject1 = LiSSOInfo.loadPicture(localLiSSOService);
        }
      }
    }
    return (Bitmap)localObject1;
  }
  
  public final Map<String, String> getSignedInUserWithProfileData(String paramString)
    throws RemoteException
  {
    return getSignedInUserWithProfileData(paramString, this$0, false);
  }
  
  public final List<String> getTokensForUser(String paramString)
    throws RemoteException
  {
    ArrayList localArrayList = new ArrayList();
    LiSSOService localLiSSOService = this$0;
    if (LiSSOService.verifyCallerSignature(localLiSSOService, getCallingUid()))
    {
      String str = LiSharedPrefUtils.getString(localLiSSOService, "auth_username", null);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(str)))
      {
        paramString = LiSSOService.getLiAuth(localLiSSOService).getHttpStack().getCookies().iterator();
        while (paramString.hasNext()) {
          localArrayList.add((String)paramString.next());
        }
      }
    }
    return localArrayList;
  }
  
  public final void signout()
    throws RemoteException
  {
    LiSSOService localLiSSOService = this$0;
    int i = getCallingUid();
    LiAuth localLiAuth;
    Intent localIntent;
    String str;
    if (LiSSOService.verifyCallerSignature(localLiSSOService, i))
    {
      localLiAuth = LiSSOService.getLiAuth(localLiSSOService);
      localIntent = new Intent("com.linkedin.android.EXTERNAL_SSO_LOGOUT_ACTION");
      str = localLiSSOService.getPackageManager().getPackagesForUid(i)[0];
      i = -1;
    }
    try
    {
      int j = getPackageManagergetPackageInfo0versionCode;
      i = j;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;) {}
    }
    localIntent.putExtra("CALLING_PACKAGE_NAME", str);
    localIntent.putExtra("CALLING_PACKAGE_VERSION", i);
    LocalBroadcastManager.getInstance(localLiSSOService).sendBroadcastSync(localIntent);
    localLiAuth.ssoLogout(localLiSSOService);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.sso.LiSSOService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */