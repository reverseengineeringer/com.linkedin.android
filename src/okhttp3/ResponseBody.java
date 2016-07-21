package okhttp3;

import java.io.Closeable;
import java.io.InputStream;
import okhttp3.internal.Util;
import okio.BufferedSource;

public abstract class ResponseBody
  implements Closeable
{
  public final InputStream byteStream()
  {
    return source().inputStream();
  }
  
  public void close()
  {
    Util.closeQuietly(source());
  }
  
  public abstract long contentLength();
  
  public abstract MediaType contentType();
  
  public abstract BufferedSource source();
}

/* Location:
 * Qualified Name:     okhttp3.ResponseBody
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */