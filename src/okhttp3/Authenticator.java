package okhttp3;

import java.io.IOException;

public abstract interface Authenticator
{
  public static final Authenticator NONE = new Authenticator()
  {
    public final Request authenticate$31deecb3()
    {
      return null;
    }
  };
  
  public abstract Request authenticate$31deecb3()
    throws IOException;
}

/* Location:
 * Qualified Name:     okhttp3.Authenticator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */