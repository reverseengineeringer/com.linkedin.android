package com.linkedin.android.datamanager;

import com.linkedin.data.lite.DataTemplateParser;
import com.linkedin.data.lite.DataTemplateParserFactory;
import com.linkedin.data.lite.jackson.JacksonJsonParser;
import com.linkedin.data.lite.jackson.JacksonJsonParserFactory;
import com.linkedin.data.lite.json.FastJsonParser;
import com.linkedin.data.lite.json.FastJsonParserFactory;

public final class DataManagerParserFactory
  implements DataTemplateParserFactory
{
  private static final FastJsonParserFactory FAST_JSON_PARSER_FACTORY = new FastJsonParserFactory();
  private static final JacksonJsonParserFactory JACKSON_JSON_PARSER_FACTORY;
  public static boolean USE_FAST_JSON_PARSER = false;
  
  static
  {
    JACKSON_JSON_PARSER_FACTORY = new JacksonJsonParserFactory();
  }
  
  public final DataTemplateParser createParser()
  {
    if (USE_FAST_JSON_PARSER) {
      return new FastJsonParser();
    }
    return new JacksonJsonParser();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.DataManagerParserFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */