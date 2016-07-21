package com.linkedin.android.datamanager.multiplex;

import com.linkedin.android.networking.interfaces.RawResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

final class IndividualResponseBuilder$1
  implements RawResponse
{
  IndividualResponseBuilder$1(IndividualResponseBuilder paramIndividualResponseBuilder, int paramInt, Map paramMap, IndividualResponseBuilder.Section paramSection) {}
  
  public final InputStream body(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {
      throw new IOException("Caching streams unsupported for individual responses");
    }
    return val$section.inputStream();
  }
  
  public final int code()
  {
    return val$status;
  }
  
  public final long contentLength()
  {
    return val$section.length();
  }
  
  public final String getHeader(String paramString)
  {
    paramString = (List)val$headers.get(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {
      return null;
    }
    return (String)paramString.get(0);
  }
  
  public final Map<String, List<String>> headers()
  {
    return val$headers;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.multiplex.IndividualResponseBuilder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */