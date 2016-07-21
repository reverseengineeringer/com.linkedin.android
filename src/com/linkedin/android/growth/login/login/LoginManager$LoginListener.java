package com.linkedin.android.growth.login.login;

import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;

public abstract interface LoginManager$LoginListener
{
  public abstract void onFail(LiError.LiAuthErrorCode paramLiAuthErrorCode);
  
  public abstract void onSuccess();
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.login.LoginManager.LoginListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */