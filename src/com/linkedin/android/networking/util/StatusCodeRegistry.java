package com.linkedin.android.networking.util;

import android.util.SparseArray;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.StatusCodeHandler;
import com.linkedin.android.networking.request.AbstractRequest;

public final class StatusCodeRegistry
{
  public SparseArray<StatusCodeHandler> handlers = new SparseArray();
  
  public final void process$1624e69e(RawResponse paramRawResponse, AbstractRequest paramAbstractRequest)
  {
    StatusCodeHandler localStatusCodeHandler = (StatusCodeHandler)handlers.get(paramRawResponse.code());
    if (localStatusCodeHandler != null) {
      localStatusCodeHandler.handleStatusCode$511594e5(paramAbstractRequest, paramRawResponse);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.util.StatusCodeRegistry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */