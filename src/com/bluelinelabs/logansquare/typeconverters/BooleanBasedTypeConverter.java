package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;

public abstract class BooleanBasedTypeConverter<T>
  implements TypeConverter<T>
{
  public abstract boolean convertToBoolean(T paramT);
  
  public abstract T getFromBoolean(boolean paramBoolean);
  
  public T parse(JsonParser paramJsonParser)
    throws IOException
  {
    return (T)getFromBoolean(paramJsonParser.getValueAsBoolean$138603());
  }
  
  public void serialize(T paramT, String paramString, boolean paramBoolean, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramJsonGenerator.writeBooleanField(paramString, convertToBoolean(paramT));
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.typeconverters.BooleanBasedTypeConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */