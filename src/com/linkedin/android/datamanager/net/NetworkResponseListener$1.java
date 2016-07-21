package com.linkedin.android.datamanager.net;

import com.linkedin.android.networking.interfaces.RawResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

final class NetworkResponseListener$1
  implements RawResponse
{
  NetworkResponseListener$1(NetworkResponseListener paramNetworkResponseListener, int paramInt, Map paramMap, byte[] paramArrayOfByte) {}
  
  public final InputStream body(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {
      throw new IOException("Caching streams unsupported for error responses");
    }
    if (val$parsedResponse == null) {
      return null;
    }
    return new ByteArrayInputStream(val$parsedResponse);
  }
  
  public final int code()
  {
    return val$statusCode;
  }
  
  public final long contentLength()
  {
    if (val$parsedResponse == null) {
      return 0L;
    }
    return val$parsedResponse.length;
  }
  
  public final String getHeader(String paramString)
  {
    if (val$headers == null) {}
    do
    {
      return null;
      paramString = (List)val$headers.get(paramString);
    } while ((paramString == null) || (paramString.isEmpty()));
    return (String)paramString.get(0);
  }
  
  public final Map<String, List<String>> headers()
  {
    return val$headers;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.net.NetworkResponseListener.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */