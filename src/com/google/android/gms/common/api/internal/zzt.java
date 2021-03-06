package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public final class zzt<R extends Result>
  extends PendingResult<R>
{
  final Status zzUX;
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    throw new UnsupportedOperationException("Operation not supported on PendingResults generated by ResultTransform.createFailedResult()");
  }
  
  public final Integer zzpa()
  {
    throw new UnsupportedOperationException("Operation not supported on PendingResults generated by ResultTransform.createFailedResult()");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.internal.zzt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */