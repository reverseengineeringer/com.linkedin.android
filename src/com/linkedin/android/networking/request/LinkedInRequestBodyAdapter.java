package com.linkedin.android.networking.request;

import java.io.IOException;
import okhttp3.MediaType;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.GzipSink;
import okio.Okio;
import okio.SegmentedByteString;

public final class LinkedInRequestBodyAdapter
{
  public static okhttp3.RequestBody getRequestBody(com.linkedin.android.networking.interfaces.RequestBody paramRequestBody)
  {
    if (paramRequestBody.getType() == null) {}
    for (MediaType localMediaType = null;; localMediaType = MediaType.parse(paramRequestBody.getType())) {
      return okhttp3.RequestBody.create(localMediaType, paramRequestBody.getBody());
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.request.LinkedInRequestBodyAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */