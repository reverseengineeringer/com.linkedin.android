package com.linkedin.android.infra.network;

import android.content.Context;
import android.os.ResultReceiver;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.LiAuth.LogoutReason;
import com.linkedin.android.liauthlib.LiAuthProvider;
import com.linkedin.android.liauthlib.common.LiAuthResponse.AuthListener;
import com.linkedin.android.liauthlib.common.LiRegistrationResponse.RegistrationListener;
import com.linkedin.android.liauthlib.registration.CheckpointChallengeResponseData;
import com.linkedin.android.liauthlib.registration.RegistrationInfo;
import javax.inject.Inject;

public final class Auth
{
  public final Context context;
  public final I18NManager i18NManager;
  public final LiAuth liAuth;
  public boolean phoneNumberRegisterAllowed = true;
  public final FlagshipSharedPreferences sharedPreferences;
  
  @Inject
  public Auth(Context paramContext, FlagshipSharedPreferences paramFlagshipSharedPreferences, I18NManager paramI18NManager)
  {
    context = paramContext.getApplicationContext();
    sharedPreferences = paramFlagshipSharedPreferences;
    i18NManager = paramI18NManager;
    liAuth = LiAuthProvider.getInstance(paramContext, false);
    liAuth.setSSOWithPhoneLoginEnabled();
  }
  
  public final boolean isAuthenticated()
  {
    return !liAuth.needsAuth$faab209();
  }
  
  public final void phoneJoin(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, LiRegistrationResponse.RegistrationListener paramRegistrationListener)
  {
    liAuth.phoneRegister(context, paramString4, paramString5, paramString1, paramString2, paramString3, "trk=p_flagship3_reg_join_tap_join", paramRegistrationListener);
  }
  
  public final void sendSMSPin(String paramString, RegistrationInfo paramRegistrationInfo, CheckpointChallengeResponseData paramCheckpointChallengeResponseData, ResultReceiver paramResultReceiver)
  {
    liAuth.sendSMSPin(context, paramString, paramRegistrationInfo, paramCheckpointChallengeResponseData, paramResultReceiver);
  }
  
  public final void signOut(LiAuthResponse.AuthListener paramAuthListener, LiAuth.LogoutReason paramLogoutReason)
  {
    liAuth.logout(context, paramAuthListener, paramLogoutReason);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.network.Auth
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */