package com.linkedin.android.growth.login.join;

import com.linkedin.android.growth.login.login.LoginManager.LoginListener;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;

final class JoinFragment$7$1
  implements LoginManager.LoginListener
{
  JoinFragment$7$1(JoinFragment.7 param7) {}
  
  public final void onFail(LiError.LiAuthErrorCode paramLiAuthErrorCode) {}
  
  public final void onSuccess()
  {
    this$1.this$0.preRegListener.onLoginSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinFragment.7.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */