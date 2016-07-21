package com.conviva.json;

import java.io.StringReader;
import java.util.Map;
import org.json.simple.JSONValue;

public final class SimpleJsonInterface
  implements IJsonInterface
{
  public final Map<String, Object> decode(String paramString)
  {
    try
    {
      paramString = (Map)JSONValue.parse(new StringReader(paramString));
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public final String encode(Map<String, Object> paramMap)
  {
    try
    {
      paramMap = JSONValue.toJSONString(paramMap);
      return paramMap;
    }
    catch (Exception paramMap) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     com.conviva.json.SimpleJsonInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */