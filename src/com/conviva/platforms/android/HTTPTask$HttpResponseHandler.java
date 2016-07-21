package com.conviva.platforms.android;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;

final class HTTPTask$HttpResponseHandler
  implements ResponseHandler<Void>
{
  private HTTPTask$HttpResponseHandler(HTTPTask paramHTTPTask) {}
  
  private Void handleResponse(HttpResponse paramHttpResponse)
  {
    int i;
    try
    {
      i = paramHttpResponse.getStatusLine().getStatusCode();
      if (i != 200) {
        break label95;
      }
      paramHttpResponse = paramHttpResponse.getEntity().getContent();
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        i = paramHttpResponse.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      HTTPTask.access$100(this$0, null, localByteArrayOutputStream.toByteArray());
    }
    catch (Exception paramHttpResponse)
    {
      HTTPTask.access$100(this$0, paramHttpResponse, null);
      return null;
    }
    return null;
    label95:
    HTTPTask.access$100(this$0, new Exception("Status code in HTTP response is not OK: " + i), null);
    return null;
  }
}

/* Location:
 * Qualified Name:     com.conviva.platforms.android.HTTPTask.HttpResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */