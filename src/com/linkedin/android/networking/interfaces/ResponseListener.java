package com.linkedin.android.networking.interfaces;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract interface ResponseListener<S, E>
{
  public abstract void onFailure(int paramInt, E paramE, Map<String, List<String>> paramMap, IOException paramIOException);
  
  public abstract void onSuccess(int paramInt, S paramS, Map<String, List<String>> paramMap);
  
  public abstract E parseErrorResponse(RawResponse paramRawResponse)
    throws IOException;
  
  public abstract S parseSuccessResponse(RawResponse paramRawResponse)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.interfaces.ResponseListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */