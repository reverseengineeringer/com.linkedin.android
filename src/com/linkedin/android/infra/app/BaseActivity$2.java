package com.linkedin.android.infra.app;

import java.util.Set;

final class BaseActivity$2
  implements PermissionRequester.PermissionRequestCallback
{
  BaseActivity$2(BaseActivity paramBaseActivity) {}
  
  public final void permissionsResult(Set<String> paramSet1, Set<String> paramSet2)
  {
    BaseActivity.access$200(this$0, paramSet1, paramSet2);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.BaseActivity.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */