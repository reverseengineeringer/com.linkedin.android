package com.linkedin.android.growth;

import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.network.Auth;
import dagger.MembersInjector;
import javax.inject.Provider;

public final class SendInviteActivity_MembersInjector
  implements MembersInjector<SendInviteActivity>
{
  private final Provider<Auth> authProvider;
  private final MembersInjector<BaseActivity> supertypeInjector;
  
  static
  {
    if (!SendInviteActivity_MembersInjector.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  private SendInviteActivity_MembersInjector(MembersInjector<BaseActivity> paramMembersInjector, Provider<Auth> paramProvider)
  {
    assert (paramMembersInjector != null);
    supertypeInjector = paramMembersInjector;
    assert (paramProvider != null);
    authProvider = paramProvider;
  }
  
  public static MembersInjector<SendInviteActivity> create(MembersInjector<BaseActivity> paramMembersInjector, Provider<Auth> paramProvider)
  {
    return new SendInviteActivity_MembersInjector(paramMembersInjector, paramProvider);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.SendInviteActivity_MembersInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */