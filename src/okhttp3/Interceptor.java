package okhttp3;

import java.io.IOException;

public abstract interface Interceptor
{
  public abstract Response intercept(Interceptor.Chain paramChain)
    throws IOException;
}

/* Location:
 * Qualified Name:     okhttp3.Interceptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */