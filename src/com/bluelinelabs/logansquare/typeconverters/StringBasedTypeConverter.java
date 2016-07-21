package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;

public abstract class StringBasedTypeConverter<T>
  implements TypeConverter<T>
{
  public abstract String convertToString(T paramT);
  
  public abstract T getFromString(String paramString);
  
  public T parse(JsonParser paramJsonParser)
    throws IOException
  {
    return (T)getFromString(paramJsonParser.getValueAsString(null));
  }
  
  public void serialize(T paramT, String paramString, boolean paramBoolean, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramJsonGenerator.writeStringField(paramString, convertToString(paramT));
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.typeconverters.StringBasedTypeConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */