package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.zzb;

public final class PendingResults
{
  private static final class zzc<R extends Result>
    extends zzb<R>
  {
    public zzc(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected final R zzc(Status paramStatus)
    {
      throw new UnsupportedOperationException("Creating failed results is not supported");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.PendingResults
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */