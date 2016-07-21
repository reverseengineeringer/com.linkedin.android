package okio;

import java.io.Closeable;
import java.io.IOException;

public abstract interface Source
  extends Closeable
{
  public abstract void close()
    throws IOException;
  
  public abstract long read(Buffer paramBuffer, long paramLong)
    throws IOException;
  
  public abstract Timeout timeout();
}

/* Location:
 * Qualified Name:     okio.Source
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */