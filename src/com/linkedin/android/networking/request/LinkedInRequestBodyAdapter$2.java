package com.linkedin.android.networking.request;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

public final class LinkedInRequestBodyAdapter$2
  extends RequestBody
{
  public LinkedInRequestBodyAdapter$2(RequestBody paramRequestBody) {}
  
  public final long contentLength()
  {
    return -1L;
  }
  
  public final MediaType contentType()
  {
    return val$body.contentType();
  }
  
  public final void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    paramBufferedSink = Okio.buffer(new GzipSink(paramBufferedSink));
    val$body.writeTo(paramBufferedSink);
    paramBufferedSink.close();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.request.LinkedInRequestBodyAdapter.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */