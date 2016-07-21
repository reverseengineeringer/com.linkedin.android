package com.linkedin.android.growth.login.join;

import com.linkedin.android.growth.login.login.LoginManager.LoginListener;
import com.linkedin.android.growth.login.prereg.PreRegListener;
import com.linkedin.android.liauthlib.common.LiError.LiAuthErrorCode;

final class JoinFragment$6
  implements LoginManager.LoginListener
{
  JoinFragment$6(JoinFragment paramJoinFragment) {}
  
  public final void onFail(LiError.LiAuthErrorCode paramLiAuthErrorCode)
  {
    JoinFragment.access$200$4348af3c(this$0);
  }
  
  public final void onSuccess()
  {
    this$0.preRegListener.onLoginSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.join.JoinFragment.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */