package com.linkedin.android.infra.app;

import java.util.Set;

public abstract interface PermissionRequester$PermissionRequestCallback
{
  public abstract void permissionsResult(Set<String> paramSet1, Set<String> paramSet2);
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.PermissionRequester.PermissionRequestCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */