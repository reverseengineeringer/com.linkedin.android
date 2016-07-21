package com.conviva.json;

import java.util.Map;

public abstract interface IJsonInterface
{
  public abstract Map<String, Object> decode(String paramString);
  
  public abstract String encode(Map<String, Object> paramMap);
}

/* Location:
 * Qualified Name:     com.conviva.json.IJsonInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */