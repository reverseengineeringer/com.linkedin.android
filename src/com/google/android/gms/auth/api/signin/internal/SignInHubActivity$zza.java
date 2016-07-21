package com.google.android.gms.auth.api.signin.internal;

import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import com.google.android.gms.common.api.GoogleApiClient;

final class SignInHubActivity$zza
  implements LoaderManager.LoaderCallbacks<Void>
{
  private SignInHubActivity$zza(SignInHubActivity paramSignInHubActivity) {}
  
  public final Loader<Void> onCreateLoader$e57f803(int paramInt)
  {
    return new zzb(zzXZ, GoogleApiClient.zzoV());
  }
  
  public final void onLoaderReset$5dda1f52() {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.auth.api.signin.internal.SignInHubActivity.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */