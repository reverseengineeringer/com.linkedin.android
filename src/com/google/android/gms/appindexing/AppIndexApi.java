package com.google.android.gms.appindexing;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface AppIndexApi
{
  public abstract PendingResult<Status> end(GoogleApiClient paramGoogleApiClient, Action paramAction);
  
  public abstract PendingResult<Status> start(GoogleApiClient paramGoogleApiClient, Action paramAction);
}

/* Location:
 * Qualified Name:     com.google.android.gms.appindexing.AppIndexApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */