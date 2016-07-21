package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;

public abstract class LongBasedTypeConverter<T>
  implements TypeConverter<T>
{
  public abstract long convertToLong(T paramT);
  
  public abstract T getFromLong(long paramLong);
  
  public T parse(JsonParser paramJsonParser)
    throws IOException
  {
    return (T)getFromLong(paramJsonParser.getValueAsLong$1349e3());
  }
  
  public void serialize(T paramT, String paramString, boolean paramBoolean, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramJsonGenerator.writeNumberField(paramString, convertToLong(paramT));
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.typeconverters.LongBasedTypeConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */