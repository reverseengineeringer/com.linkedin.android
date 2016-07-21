package okhttp3;

import java.io.IOException;

public abstract interface Call
{
  public abstract Response execute()
    throws IOException;
}

/* Location:
 * Qualified Name:     okhttp3.Call
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */