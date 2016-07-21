package okhttp3;

import java.util.Collections;
import java.util.List;

public abstract interface CookieJar
{
  public static final CookieJar NO_COOKIES = new CookieJar()
  {
    public final List<Cookie> loadForRequest(HttpUrl paramAnonymousHttpUrl)
    {
      return Collections.emptyList();
    }
    
    public final void saveFromResponse$2fcdfa96() {}
  };
  
  public abstract List<Cookie> loadForRequest(HttpUrl paramHttpUrl);
  
  public abstract void saveFromResponse$2fcdfa96();
}

/* Location:
 * Qualified Name:     okhttp3.CookieJar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */