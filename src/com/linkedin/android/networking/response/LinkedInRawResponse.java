package com.linkedin.android.networking.response;

import com.linkedin.android.networking.LinkedInNetwork;
import com.linkedin.android.networking.interfaces.RawResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class LinkedInRawResponse
  implements RawResponse
{
  private final LinkedInNetwork linkedInNetwork;
  private final Response response;
  public final Map<String, List<String>> responseHeaders;
  
  public LinkedInRawResponse(LinkedInNetwork paramLinkedInNetwork, Response paramResponse)
  {
    linkedInNetwork = paramLinkedInNetwork;
    response = paramResponse;
    if ((paramResponse == null) || (headers == null))
    {
      responseHeaders = null;
      return;
    }
    responseHeaders = getHeadersAsMap(headers);
  }
  
  private Map<String, List<String>> getHeadersAsMap(Headers paramHeaders)
  {
    LinkedInRawResponse.1 local1 = new LinkedInRawResponse.1(this);
    int i = 0;
    int j = namesAndValues.length / 2;
    while (i < j)
    {
      String str = paramHeaders.name(i).toLowerCase(Locale.US);
      List localList = (List)local1.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList(2);
        local1.put(str, localObject);
      }
      ((List)localObject).add(paramHeaders.value(i));
      i += 1;
    }
    return local1;
  }
  
  public final InputStream body(boolean paramBoolean)
    throws IOException
  {
    if ((response == null) || (response.body == null)) {
      return null;
    }
    return LinkedInNetwork.getUncompressedInputStream(response.body, getHeader("Content-Encoding"), response.body.contentLength(), paramBoolean);
  }
  
  public final int code()
  {
    if (response == null) {
      return 400;
    }
    return response.code;
  }
  
  public final long contentLength()
  {
    if ((response == null) || (response.body == null)) {
      return -1L;
    }
    return response.body.contentLength();
  }
  
  public final String getHeader(String paramString)
  {
    if ((response == null) || (response.headers == null)) {
      return null;
    }
    return response.headers.get(paramString);
  }
  
  public final Map<String, List<String>> headers()
  {
    return responseHeaders;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.response.LinkedInRawResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */