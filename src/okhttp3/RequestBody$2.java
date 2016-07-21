package okhttp3;

import java.io.IOException;
import okio.BufferedSink;

final class RequestBody$2
  extends RequestBody
{
  RequestBody$2(MediaType paramMediaType, int paramInt, byte[] paramArrayOfByte) {}
  
  public final long contentLength()
  {
    return val$byteCount;
  }
  
  public final MediaType contentType()
  {
    return val$contentType;
  }
  
  public final void writeTo(BufferedSink paramBufferedSink)
    throws IOException
  {
    paramBufferedSink.write(val$content, val$offset, val$byteCount);
  }
}

/* Location:
 * Qualified Name:     okhttp3.RequestBody.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */