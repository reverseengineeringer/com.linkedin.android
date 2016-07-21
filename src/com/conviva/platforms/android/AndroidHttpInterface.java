package com.conviva.platforms.android;

import com.conviva.api.system.ICallbackInterface;
import com.conviva.api.system.IHttpInterface;

public final class AndroidHttpInterface
  implements IHttpInterface
{
  public final void makeRequest(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, ICallbackInterface paramICallbackInterface)
  {
    HTTPTask localHTTPTask = new HTTPTask();
    _httpMethod = paramString1;
    _url = paramString2;
    _data = paramString3;
    _contentT = paramString4;
    _timeoutMs = paramInt;
    _callback = paramICallbackInterface;
    new Thread(localHTTPTask).start();
  }
}

/* Location:
 * Qualified Name:     com.conviva.platforms.android.AndroidHttpInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */