package com.bluelinelabs.logansquare;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class JsonMapper<T>
{
  public abstract T parse(JsonParser paramJsonParser)
    throws IOException;
  
  public T parse(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = LoganSquare.JSON_FACTORY.createParser(paramInputStream);
    paramInputStream.nextToken();
    return (T)parse(paramInputStream);
  }
  
  public T parse(String paramString)
    throws IOException
  {
    paramString = LoganSquare.JSON_FACTORY.createParser(paramString);
    paramString.nextToken();
    return (T)parse(paramString);
  }
  
  public T parse(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = LoganSquare.JSON_FACTORY.createParser(paramArrayOfByte);
    paramArrayOfByte.nextToken();
    return (T)parse(paramArrayOfByte);
  }
  
  public T parse(char[] paramArrayOfChar)
    throws IOException
  {
    paramArrayOfChar = LoganSquare.JSON_FACTORY.createParser(paramArrayOfChar);
    paramArrayOfChar.nextToken();
    return (T)parse(paramArrayOfChar);
  }
  
  public List<T> parseList(JsonParser paramJsonParser)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJsonParser.getCurrentToken() == JsonToken.START_ARRAY) {
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
        localArrayList.add(parse(paramJsonParser));
      }
    }
    return localArrayList;
  }
  
  public List<T> parseList(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = LoganSquare.JSON_FACTORY.createParser(paramInputStream);
    paramInputStream.nextToken();
    return parseList(paramInputStream);
  }
  
  public List<T> parseList(String paramString)
    throws IOException
  {
    paramString = LoganSquare.JSON_FACTORY.createParser(paramString);
    paramString.nextToken();
    return parseList(paramString);
  }
  
  public List<T> parseList(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = LoganSquare.JSON_FACTORY.createParser(paramArrayOfByte);
    paramArrayOfByte.nextToken();
    return parseList(paramArrayOfByte);
  }
  
  public List<T> parseList(char[] paramArrayOfChar)
    throws IOException
  {
    paramArrayOfChar = LoganSquare.JSON_FACTORY.createParser(paramArrayOfChar);
    paramArrayOfChar.nextToken();
    return parseList(paramArrayOfChar);
  }
  
  public Map<String, T> parseMap(JsonParser paramJsonParser)
    throws IOException
  {
    HashMap localHashMap = new HashMap();
    while (paramJsonParser.nextToken() != JsonToken.END_OBJECT)
    {
      String str = paramJsonParser.getText();
      paramJsonParser.nextToken();
      if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
        localHashMap.put(str, null);
      } else {
        localHashMap.put(str, parse(paramJsonParser));
      }
    }
    return localHashMap;
  }
  
  public Map<String, T> parseMap(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = LoganSquare.JSON_FACTORY.createParser(paramInputStream);
    paramInputStream.nextToken();
    return parseMap(paramInputStream);
  }
  
  public Map<String, T> parseMap(String paramString)
    throws IOException
  {
    paramString = LoganSquare.JSON_FACTORY.createParser(paramString);
    paramString.nextToken();
    return parseMap(paramString);
  }
  
  public Map<String, T> parseMap(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = LoganSquare.JSON_FACTORY.createParser(paramArrayOfByte);
    paramArrayOfByte.nextToken();
    return parseMap(paramArrayOfByte);
  }
  
  public Map<String, T> parseMap(char[] paramArrayOfChar)
    throws IOException
  {
    paramArrayOfChar = LoganSquare.JSON_FACTORY.createParser(paramArrayOfChar);
    paramArrayOfChar.nextToken();
    return parseMap(paramArrayOfChar);
  }
  
  public String serialize(T paramT)
    throws IOException
  {
    StringWriter localStringWriter = new StringWriter();
    JsonGenerator localJsonGenerator = LoganSquare.JSON_FACTORY.createGenerator(localStringWriter);
    serialize(paramT, localJsonGenerator, true);
    localJsonGenerator.close();
    return localStringWriter.toString();
  }
  
  public String serialize(List<T> paramList)
    throws IOException
  {
    StringWriter localStringWriter = new StringWriter();
    JsonGenerator localJsonGenerator = LoganSquare.JSON_FACTORY.createGenerator(localStringWriter);
    serialize(paramList, localJsonGenerator);
    localJsonGenerator.close();
    return localStringWriter.toString();
  }
  
  public String serialize(Map<String, T> paramMap)
    throws IOException
  {
    StringWriter localStringWriter = new StringWriter();
    JsonGenerator localJsonGenerator = LoganSquare.JSON_FACTORY.createGenerator(localStringWriter);
    serialize(paramMap, localJsonGenerator);
    localJsonGenerator.close();
    return localStringWriter.toString();
  }
  
  public abstract void serialize(T paramT, JsonGenerator paramJsonGenerator, boolean paramBoolean)
    throws IOException;
  
  public void serialize(T paramT, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = LoganSquare.JSON_FACTORY.createGenerator(paramOutputStream);
    serialize(paramT, paramOutputStream, true);
    paramOutputStream.close();
  }
  
  public void serialize(List<T> paramList, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramJsonGenerator.writeStartArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (localObject != null) {
        serialize(localObject, paramJsonGenerator, true);
      } else {
        paramJsonGenerator.writeNull();
      }
    }
    paramJsonGenerator.writeEndArray();
  }
  
  public void serialize(List<T> paramList, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = LoganSquare.JSON_FACTORY.createGenerator(paramOutputStream);
    serialize(paramList, paramOutputStream);
    paramOutputStream.close();
  }
  
  public void serialize(Map<String, T> paramMap, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramJsonGenerator.writeStartObject();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramJsonGenerator.writeFieldName((String)localEntry.getKey());
      if (localEntry.getValue() == null) {
        paramJsonGenerator.writeNull();
      } else {
        serialize(localEntry.getValue(), paramJsonGenerator, true);
      }
    }
    paramJsonGenerator.writeEndObject();
  }
  
  public void serialize(Map<String, T> paramMap, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = LoganSquare.JSON_FACTORY.createGenerator(paramOutputStream);
    serialize(paramMap, paramOutputStream);
    paramOutputStream.close();
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.JsonMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */