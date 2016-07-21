package com.linkedin.android.networking.request;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.SegmentedByteString;

public final class LinkedInRequestBodyAdapter$1
  extends RequestBody
{
  public LinkedInRequestBodyAdapter$1(RequestBody paramRequestBody, Buffer paramBuffer) {}
  
  public final long contentLength()
  {
    return val$buffer.size;
  }
  
  public final MediaType contentType()
  {
    return val$requestBody.contentType();
  }
  
  public final void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    Object localObject = val$buffer;
    if (size > 2147483647L) {
      throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + size);
    }
    int i = (int)size;
    if (i == 0) {}
    for (localObject = ByteString.EMPTY;; localObject = new SegmentedByteString((Buffer)localObject, i))
    {
      paramBufferedSink.write((ByteString)localObject);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.request.LinkedInRequestBodyAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */