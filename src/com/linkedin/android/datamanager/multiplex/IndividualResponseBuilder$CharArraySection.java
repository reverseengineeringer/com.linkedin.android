package com.linkedin.android.datamanager.multiplex;

import com.linkedin.data.lite.json.CharArrayReader;
import com.linkedin.data.lite.json.FastJsonParser;
import com.linkedin.data.lite.json.FastJsonStreamReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

final class IndividualResponseBuilder$CharArraySection
  implements IndividualResponseBuilder.Section
{
  public final int length;
  private final FastJsonParser parser;
  public final int start;
  
  public IndividualResponseBuilder$CharArraySection(FastJsonParser paramFastJsonParser, int paramInt1, int paramInt2)
  {
    parser = paramFastJsonParser;
    start = paramInt1;
    length = paramInt2;
  }
  
  public final InputStream inputStream()
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Reader localReader = reader();
    for (;;)
    {
      int i = localReader.read();
      if (i == -1) {
        break;
      }
      localStringBuilder.append((char)i);
    }
    return new ByteArrayInputStream(localStringBuilder.toString().getBytes());
  }
  
  public final int length()
  {
    return length;
  }
  
  public final Reader reader()
  {
    FastJsonParser localFastJsonParser = parser;
    int i = start;
    int j = length;
    return new CharArrayReader(_fastJsonStreamReader._data, i, j);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.multiplex.IndividualResponseBuilder.CharArraySection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */