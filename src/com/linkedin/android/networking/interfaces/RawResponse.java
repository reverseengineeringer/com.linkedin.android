package com.linkedin.android.networking.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public abstract interface RawResponse
{
  public abstract InputStream body(boolean paramBoolean)
    throws IOException;
  
  public abstract int code();
  
  public abstract long contentLength();
  
  public abstract String getHeader(String paramString);
  
  public abstract Map<String, List<String>> headers();
}

/* Location:
 * Qualified Name:     com.linkedin.android.networking.interfaces.RawResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */