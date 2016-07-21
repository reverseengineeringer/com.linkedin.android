package com.linkedin.android.growth.login.fastrack;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.widget.EditText;
import com.linkedin.android.growth.login.PrefillManager;
import com.linkedin.android.infra.network.Auth;
import javax.inject.Inject;

public class FastrackManager
{
  private static final String TAG = FastrackManager.class.getSimpleName();
  public final Auth auth;
  @Inject
  PrefillManager prefillManager;
  
  @Inject
  public FastrackManager(Auth paramAuth)
  {
    auth = paramAuth;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.fastrack.FastrackManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */