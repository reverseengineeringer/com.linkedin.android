package okhttp3;

import java.io.IOException;
import okhttp3.internal.Util;
import okio.BufferedSink;

public abstract class RequestBody
{
  public static RequestBody create(MediaType paramMediaType, final byte[] paramArrayOfByte)
  {
    final int i = paramArrayOfByte.length;
    if (paramArrayOfByte == null) {
      throw new NullPointerException("content == null");
    }
    Util.checkOffsetAndCount$487762af(paramArrayOfByte.length, i);
    new RequestBody()
    {
      public final long contentLength()
      {
        return i;
      }
      
      public final MediaType contentType()
      {
        return val$contentType;
      }
      
      public final void writeTo(BufferedSink paramAnonymousBufferedSink)
        throws IOException
      {
        paramAnonymousBufferedSink.write(paramArrayOfByte, val$offset, i);
      }
    };
  }
  
  public static RequestBody create$6b6de878(String paramString)
  {
    return create(null, paramString.getBytes(Util.UTF_8));
  }
  
  public long contentLength()
    throws IOException
  {
    return -1L;
  }
  
  public abstract MediaType contentType();
  
  public abstract void writeTo(BufferedSink paramBufferedSink)
    throws IOException;
}

/* Location:
 * Qualified Name:     okhttp3.RequestBody
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */