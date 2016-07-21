package com.linkedin.android.liauthlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Handler;
import android.os.ResultReceiver;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import com.linkedin.android.liauthlib.common.DeviceIdentifier;
import com.linkedin.android.liauthlib.common.LiAuthAppInterface;
import com.linkedin.android.liauthlib.common.LiAuthResponse;
import com.linkedin.android.liauthlib.common.LiAuthResponse.AuthListener;
import com.linkedin.android.liauthlib.common.LiError;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;
import com.linkedin.android.liauthlib.common.LiRegistrationException;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse.RegistrationListener;
import com.linkedin.android.liauthlib.common.LiSSOInfo;
import com.linkedin.android.liauthlib.common.LiSharedPrefUtils;
import com.linkedin.android.liauthlib.network.HttpOperationListener;
import com.linkedin.android.liauthlib.network.HttpStack;
import com.linkedin.android.liauthlib.network.NetworkUtils;
import com.linkedin.android.liauthlib.network.impl.AuthHttpStackWrapper;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.RegistrationHelper;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import com.linkedin.android.liauthlib.sso.LiSSOHelper;
import com.linkedin.android.liauthlib.sso.LiSSOServiceBindingListener;
import com.linkedin.android.liauthlib.thirdparty.LiThirdPartyAuthorizeResponse;
import com.linkedin.android.liauthlib.thirdparty.LiThirdPartyAuthorizeResponse.AuthListener;
import com.linkedin.android.liauthlib.utils.InputValidator;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class LiAuthImpl
  implements LiAuth
{
  public static Set<String> cookieDomainSpec;
  LiSSOHelper authHelper = null;
  String baseHost = null;
  private int logoutTimeout = 5000;
  private final Context mContext;
  private final HttpStack mHttpStack;
  private boolean mSupportSSOWithPhoneLogin;
  
  static
  {
    HashSet localHashSet = new HashSet();
    cookieDomainSpec = localHashSet;
    localHashSet.add(".linkedin-ei.com");
    cookieDomainSpec.add("linkedin-ei.com");
    cookieDomainSpec.add(".www.linkedin-ei.com");
    cookieDomainSpec.add("www.linkedin-ei.com");
    cookieDomainSpec.add(".linkedin.com");
    cookieDomainSpec.add("linkedin.com");
    cookieDomainSpec.add(".www.linkedin.com");
    cookieDomainSpec.add("www.linkedin.com");
  }
  
  public LiAuthImpl(Context paramContext, boolean paramBoolean)
  {
    mContext = paramContext.getApplicationContext();
    if (!(mContext instanceof LiAuthAppInterface)) {
      throw new RuntimeException("Host application class needs to implement LiAuthAppInterface");
    }
    mHttpStack = new AuthHttpStackWrapper(mContext, ((LiAuthAppInterface)mContext).getHttpStack());
    baseHost = LiSharedPrefUtils.getString(paramContext, "auth_selected_host", "https://www.linkedin.com");
    authHelper = new LiSSOHelper(paramContext);
    String str = getUsername();
    if ((!TextUtils.isEmpty(str)) && (paramBoolean)) {
      fetchProfileData(baseHost, paramContext, str, null, null);
    }
    if (TextUtils.isEmpty(getUsername())) {
      mHttpStack.performGET(baseHost + "/uas/authenticate", null, 5000, new LiAuthImpl.1(this));
    }
  }
  
  private static void addValueOrRemoveIfEmpty(SharedPreferences.Editor paramEditor, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramEditor.putString(paramString1, paramString2);
      return;
    }
    paramEditor.remove(paramString1);
  }
  
  private void authenticate$6aeb899a(Context paramContext, String paramString1, String paramString2, String paramString3, LiAuthResponse.AuthListener paramAuthListener)
  {
    NetworkUtils.performRequestWithCSRFToken(mHttpStack, baseHost, new LiAuthImpl.5(this, paramContext, paramString1, paramString2, paramString3, paramAuthListener), new LiAuthImpl.6(this, paramAuthListener));
  }
  
  private void fetchProfileData(String paramString1, Context paramContext, String paramString2, HttpOperationListener paramHttpOperationListener1, HttpOperationListener paramHttpOperationListener2)
  {
    paramString1 = paramString1 + "/mob/sso/you";
    mHttpStack.performGET(paramString1, null, 5000, new LiAuthImpl.10(this, paramContext, paramString2, paramHttpOperationListener2, paramHttpOperationListener1));
  }
  
  public static LiError generateError(String paramString)
  {
    if ("PASS".equalsIgnoreCase(paramString)) {
      return null;
    }
    if ("BAD_EMAIL".equalsIgnoreCase(paramString)) {
      return new LiError(LiError.LiAuthErrorCode.BAD_USERNAME, "BAD_EMAIL");
    }
    if ("BAD_PASSWORD".equalsIgnoreCase(paramString)) {
      return new LiError(LiError.LiAuthErrorCode.BAD_PASSWORD, "BAD_PASSWORD");
    }
    if ("LOGIN_RESTRICTED".equalsIgnoreCase(paramString)) {
      return new LiError(LiError.LiAuthErrorCode.LOGIN_RESTRICTED, "LOGIN_RESTRICTED");
    }
    if ("CHALLENGE".equalsIgnoreCase(paramString)) {
      return new LiError(LiError.LiAuthErrorCode.CHALLENGE, "CHALLENGE");
    }
    if ("USER_CANCELLED".equalsIgnoreCase(paramString)) {
      return new LiError(LiError.LiAuthErrorCode.USER_CANCELLED, "USER_CANCELLED");
    }
    return new LiError(LiError.LiAuthErrorCode.UNKNOWN_ERROR, "Unknown Error");
  }
  
  private void logoutInternal(Context paramContext, LiAuthResponse.AuthListener paramAuthListener, boolean paramBoolean, LiAuth.LogoutReason paramLogoutReason)
  {
    Object localObject = getUsername();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramBoolean)) {
      startSSOService(new LiAuthImpl.2(this, (String)localObject));
    }
    List localList = mHttpStack.getCookieNameValuePairs(cookieDomainSpec);
    localObject = null;
    if (paramLogoutReason != null) {
      localList.add(new Pair("logout_reason", paramLogoutReason.name()));
    }
    try
    {
      paramLogoutReason = NetworkUtils.getUrlEncodedString(localList).getBytes();
      localObject = new HashMap();
      ((Map)localObject).put("Content-Type", "application/x-www-form-urlencoded");
      mHttpStack.performPOST(baseHost + "/uas/directLogout", (Map)localObject, logoutTimeout, paramLogoutReason, new LiAuthImpl.3(this, paramAuthListener));
      saveUserInfo(paramContext, null);
      LiSSOInfo.clearPicture(paramContext);
      return;
    }
    catch (IllegalArgumentException paramLogoutReason)
    {
      for (;;)
      {
        paramLogoutReason = (LiAuth.LogoutReason)localObject;
      }
    }
  }
  
  private void onLoginValidationError(LiError.LiAuthErrorCode paramLiAuthErrorCode, LiAuthResponse.AuthListener paramAuthListener)
  {
    LiAuthResponse localLiAuthResponse = new LiAuthResponse();
    statusCode = 400;
    error = new LiError(paramLiAuthErrorCode, paramLiAuthErrorCode.name());
    new Handler().post(new LiAuthImpl.4(this, paramAuthListener, localLiAuthResponse));
  }
  
  private void register(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, LiRegistrationResponse.RegistrationListener paramRegistrationListener)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString7)) || ((!TextUtils.isEmpty(paramString3)) && (TextUtils.isEmpty(paramString8)))) {
      throw new IllegalStateException("missing mandatory input");
    }
    new LiAuthImpl.16(this, paramContext, paramString3, paramString7, paramString8, paramString1, paramString2, paramString4, paramString5, paramString6, paramRegistrationListener).execute(new Void[0]);
  }
  
  private static String resolveHost(LiAuth.LiAuthHost paramLiAuthHost, String paramString)
  {
    switch (LiAuthImpl.23.$SwitchMap$com$linkedin$android$liauthlib$LiAuth$LiAuthHost[paramLiAuthHost.ordinal()])
    {
    default: 
      return "https://www.linkedin.com";
    case 1: 
    case 2: 
      return "https://www.linkedin-ei.com";
    }
    return paramString;
  }
  
  private void saveProfileData(Context paramContext, LiSSOInfo paramLiSSOInfo, HttpOperationListener paramHttpOperationListener)
  {
    if (TextUtils.isEmpty(getUsername())) {
      return;
    }
    String str = paramContext.getSharedPreferences("auth_library_prefs", 0).getString("auth_picture_url", null);
    if (!TextUtils.isEmpty(pictureUrl)) {
      if ((!pictureUrl.equals(str)) || (!LiSSOInfo.getPictureFile(paramContext).exists())) {
        mHttpStack.performGET(pictureUrl, null, 5000, new LiAuthImpl.9(this, paramContext, paramHttpOperationListener));
      }
    }
    for (;;)
    {
      saveUserInfo(paramContext, paramLiSSOInfo);
      return;
      if (LiSSOInfo.getPictureFile(paramContext).exists()) {
        LiSSOInfo.clearPicture(paramContext);
      }
    }
  }
  
  private static void saveUserInfo(Context paramContext, LiSSOInfo paramLiSSOInfo)
  {
    Object localObject = null;
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("auth_library_prefs", 0).edit();
    if (paramLiSSOInfo == null)
    {
      paramContext = null;
      addValueOrRemoveIfEmpty(localEditor, "auth_username", paramContext);
      if (paramLiSSOInfo != null) {
        break label143;
      }
      paramContext = null;
      label35:
      addValueOrRemoveIfEmpty(localEditor, "auth_member_id", paramContext);
      if (paramLiSSOInfo != null) {
        break label151;
      }
      paramContext = null;
      label49:
      addValueOrRemoveIfEmpty(localEditor, "auth_first_name", paramContext);
      if (paramLiSSOInfo != null) {
        break label159;
      }
      paramContext = null;
      label63:
      addValueOrRemoveIfEmpty(localEditor, "auth_last_name", paramContext);
      if (paramLiSSOInfo != null) {
        break label167;
      }
      paramContext = null;
      label77:
      addValueOrRemoveIfEmpty(localEditor, "auth_short_full_name", paramContext);
      if (paramLiSSOInfo != null) {
        break label175;
      }
      paramContext = null;
      label91:
      addValueOrRemoveIfEmpty(localEditor, "auth_full_name", paramContext);
      if (paramLiSSOInfo != null) {
        break label183;
      }
      paramContext = null;
      label105:
      addValueOrRemoveIfEmpty(localEditor, "auth_headline", paramContext);
      if (paramLiSSOInfo != null) {
        break label191;
      }
    }
    label143:
    label151:
    label159:
    label167:
    label175:
    label183:
    label191:
    for (paramContext = (Context)localObject;; paramContext = pictureUrl)
    {
      addValueOrRemoveIfEmpty(localEditor, "auth_picture_url", paramContext);
      localEditor.commit();
      return;
      paramContext = username;
      break;
      paramContext = memberID;
      break label35;
      paramContext = firstName;
      break label49;
      paramContext = lastName;
      break label63;
      paramContext = shortFullName;
      break label77;
      paramContext = fullName;
      break label91;
      paramContext = headline;
      break label105;
    }
  }
  
  private LiThirdPartyAuthorizeResponse thirdPartyAuthorizeAuthenticated(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, LiThirdPartyAuthorizeResponse.AuthListener paramAuthListener)
  {
    String str2 = DeviceIdentifier.id(paramContext);
    paramContext = Uri.parse(baseHost).getHost();
    String str3 = mHttpStack.getCookie("JSESSIONID", paramContext);
    String str1 = "";
    paramContext = paramString2;
    if (paramString2 == null) {
      paramContext = Locale.getDefault().toString();
    }
    if (paramString5 == null) {
      paramString2 = "";
    }
    try
    {
      for (;;)
      {
        paramString1 = "scope=" + paramString1 + "&locale=" + URLEncoder.encode(paramContext, "UTF-8") + "&duid=" + URLEncoder.encode(str2, "UTF-8") + "&packageName=" + URLEncoder.encode(paramString3, "UTF-8") + "&packageHash=" + URLEncoder.encode(paramString4, "UTF-8") + "&csrfToken=" + URLEncoder.encode(str3, "UTF-8") + "&userAuthorized=" + paramBoolean + paramString2;
        paramString2 = new HashMap();
        paramString2.put("Content-Type", "application/x-www-form-urlencoded");
        paramString2.put("Locale", paramContext.toString());
        paramString2.put("X-isAJAXForm", "1");
        mHttpStack.performPOST(baseHost + "/uas/mobilesdk/authorize", paramString2, 5000, paramString1.getBytes(), new LiAuthImpl.14(this, paramAuthListener));
        return null;
        paramString2 = "&sd=" + paramString5;
      }
    }
    catch (UnsupportedEncodingException paramString1)
    {
      for (;;)
      {
        new StringBuilder("Unable to encode body ").append(paramString1);
        paramString1 = str1;
      }
    }
  }
  
  public final void authenticate(Context paramContext, String paramString1, String paramString2, LiAuthResponse.AuthListener paramAuthListener)
  {
    LiError.LiAuthErrorCode localLiAuthErrorCode = InputValidator.loginValidateEmailOrPhone(paramString1, paramString2);
    if (localLiAuthErrorCode != null)
    {
      onLoginValidationError(localLiAuthErrorCode, paramAuthListener);
      return;
    }
    authenticate$6aeb899a(paramContext, paramString1, paramString2, null, paramAuthListener);
  }
  
  public final void authenticateWithGoogleIdToken(Context paramContext, String paramString1, String paramString2, LiAuthResponse.AuthListener paramAuthListener)
  {
    LiError.LiAuthErrorCode localLiAuthErrorCode = InputValidator.loginValidateEmailAndIdToken(paramString1, paramString2);
    if (localLiAuthErrorCode != null)
    {
      onLoginValidationError(localLiAuthErrorCode, paramAuthListener);
      return;
    }
    authenticate$6aeb899a(paramContext, paramString1, null, paramString2, paramAuthListener);
  }
  
  public final void emailOrPhoneRegister(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LiRegistrationResponse.RegistrationListener paramRegistrationListener)
  {
    Object localObject3;
    try
    {
      LiError.LiAuthErrorCode localLiAuthErrorCode = InputValidator.regValidateEmailOrPhone(paramString1, paramString2, paramString3, paramString4);
      if (localLiAuthErrorCode != null) {
        throw RegistrationHelper.badRegistrationRequestException(localLiAuthErrorCode);
      }
    }
    catch (LiRegistrationException localLiRegistrationException)
    {
      if (paramRegistrationListener != null) {
        paramRegistrationListener.onResponse(localLiRegistrationException.getError());
      }
      localObject3 = null;
      localObject1 = null;
      localObject2 = null;
      if (!InputValidator.isEmailInvalid(paramString3)) {
        break label127;
      }
    }
    Object localObject2 = ((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = Locale.getDefault().getCountry();
    }
    localObject2 = localObject1;
    localObject1 = paramString3;
    paramString3 = (String)localObject3;
    label127:
    for (;;)
    {
      register(paramContext, paramString1, paramString2, paramString3, (String)localObject1, (String)localObject2, paramString4, paramString5, paramString6, paramRegistrationListener);
      return;
    }
  }
  
  public final String getBaseHost()
  {
    return baseHost;
  }
  
  public final void getFastrackProfile(Context paramContext, String paramString, ResultReceiver paramResultReceiver)
  {
    NetworkUtils.performRequestWithCSRFToken(mHttpStack, baseHost, new LiAuthImpl.21(this, paramContext, paramString, paramResultReceiver), new LiAuthImpl.22(this, paramResultReceiver));
  }
  
  public final HttpStack getHttpStack()
  {
    return mHttpStack;
  }
  
  public final boolean getSSOTokens(Context paramContext, LiSSOInfo paramLiSSOInfo)
  {
    paramContext = paramContext.getApplicationContext();
    Object localObject = LiSSOHelper.getSSOTokens(pkgName, username);
    boolean bool = false;
    localObject = ((List)localObject).iterator();
    if (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((mHttpStack.addCookie(str)) || (bool)) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    if (bool)
    {
      saveUserInfo(paramContext, paramLiSSOInfo);
      paramContext = baseHost + "/mob/sso/you";
      mHttpStack.performGET(paramContext, null, 5000, new LiAuthImpl.11(this));
    }
    return bool;
  }
  
  public final List<LiSSOInfo> getSSOUsers()
  {
    return LiSSOHelper.getSSOUsers(baseHost, mSupportSSOWithPhoneLogin);
  }
  
  public final String getUsername()
  {
    return mContext.getSharedPreferences("auth_library_prefs", 0).getString("auth_username", null);
  }
  
  public final void logout(Context paramContext, LiAuthResponse.AuthListener paramAuthListener, LiAuth.LogoutReason paramLogoutReason)
  {
    logoutInternal(paramContext, paramAuthListener, true, paramLogoutReason);
  }
  
  public final boolean needsAuth$faab209()
  {
    return TextUtils.isEmpty(getUsername());
  }
  
  public final void phoneRegister(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LiRegistrationResponse.RegistrationListener paramRegistrationListener)
  {
    try
    {
      LiError.LiAuthErrorCode localLiAuthErrorCode = InputValidator.regValidateEmailOrPhone(paramString1, paramString2, paramString3, paramString5);
      if (localLiAuthErrorCode != null) {
        throw RegistrationHelper.badRegistrationRequestException(localLiAuthErrorCode);
      }
    }
    catch (LiRegistrationException localLiRegistrationException)
    {
      if (paramRegistrationListener != null) {
        paramRegistrationListener.onResponse(localLiRegistrationException.getError());
      }
      register(paramContext, paramString1, paramString2, null, paramString3, paramString4, paramString5, paramString6, null, paramRegistrationListener);
    }
  }
  
  public final void register(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, LiRegistrationResponse.RegistrationListener paramRegistrationListener)
  {
    try
    {
      LiError.LiAuthErrorCode localLiAuthErrorCode = InputValidator.regValidate(paramString1, paramString2, paramString3, paramString4);
      if (localLiAuthErrorCode != null) {
        throw RegistrationHelper.badRegistrationRequestException(localLiAuthErrorCode);
      }
    }
    catch (LiRegistrationException localLiRegistrationException)
    {
      if (paramRegistrationListener != null) {
        paramRegistrationListener.onResponse(localLiRegistrationException.getError());
      }
      register(paramContext, paramString1, paramString2, paramString3, null, null, paramString4, paramString5, paramString6, paramRegistrationListener);
    }
  }
  
  public final void saveProfileData(Context paramContext, LiSSOInfo paramLiSSOInfo)
  {
    saveProfileData(paramContext, paramLiSSOInfo, null);
  }
  
  public final void sendSMSPin(Context paramContext, String paramString, RegistrationInfo paramRegistrationInfo, CheckpointChallengeResponseData paramCheckpointChallengeResponseData, ResultReceiver paramResultReceiver)
  {
    NetworkUtils.performRequestWithCSRFToken(mHttpStack, baseHost, new LiAuthImpl.17(this, paramContext, paramString, paramRegistrationInfo, paramCheckpointChallengeResponseData, paramResultReceiver), new LiAuthImpl.18(this, paramResultReceiver));
  }
  
  public final void setCustomHostname(Context paramContext, String paramString)
  {
    baseHost = resolveHost(LiAuth.LiAuthHost.CUSTOM, paramString);
    LiSharedPrefUtils.putString(paramContext, "auth_selected_host", baseHost);
  }
  
  public final void setHost(Context paramContext, LiAuth.LiAuthHost paramLiAuthHost)
  {
    baseHost = resolveHost(paramLiAuthHost, null);
    LiSharedPrefUtils.putString(paramContext, "auth_selected_host", baseHost);
  }
  
  public final void setSSOWithPhoneLoginEnabled()
  {
    mSupportSSOWithPhoneLogin = true;
  }
  
  public final void ssoLogout(Context paramContext)
  {
    logoutInternal(paramContext, null, false, null);
  }
  
  public final void startSSOService(LiSSOServiceBindingListener paramLiSSOServiceBindingListener)
  {
    authHelper.doBindService(paramLiSSOServiceBindingListener);
  }
  
  public final void stopSSOService()
  {
    authHelper.doUnbindService();
  }
  
  public final LiThirdPartyAuthorizeResponse thirdPartyAuthorize(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, LiThirdPartyAuthorizeResponse.AuthListener paramAuthListener)
  {
    if ((paramString3 == null) || (paramString3.length() == 0)) {
      return new LiThirdPartyAuthorizeResponse(400, new LiError(LiError.LiAuthErrorCode.UNKNOWN_ERROR, "empty appPackage"));
    }
    if ((paramString4 == null) || (paramString4.length() == 0)) {
      return new LiThirdPartyAuthorizeResponse(400, new LiError(LiError.LiAuthErrorCode.UNKNOWN_ERROR, "empty appSignature"));
    }
    NetworkUtils.performRequestWithCSRFToken(mHttpStack, baseHost, new LiAuthImpl.12(this, paramContext, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, paramAuthListener), new LiAuthImpl.13(this, paramAuthListener));
    return null;
  }
  
  public final void verifySMSPin(Context paramContext, String paramString1, RegistrationInfo paramRegistrationInfo, CheckpointChallengeResponseData paramCheckpointChallengeResponseData, String paramString2, LiRegistrationResponse.RegistrationListener paramRegistrationListener)
  {
    NetworkUtils.performRequestWithCSRFToken(mHttpStack, baseHost, new LiAuthImpl.19(this, paramContext, paramString1, paramRegistrationInfo, paramCheckpointChallengeResponseData, paramString2, paramRegistrationListener), new LiAuthImpl.20(this, paramRegistrationListener));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.LiAuthImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */