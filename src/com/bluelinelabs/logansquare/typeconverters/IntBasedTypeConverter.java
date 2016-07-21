package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;

public abstract class IntBasedTypeConverter<T>
  implements TypeConverter<T>
{
  public abstract int convertToInt(T paramT);
  
  public abstract T getFromInt(int paramInt);
  
  public T parse(JsonParser paramJsonParser)
    throws IOException
  {
    return (T)getFromInt(paramJsonParser.getValueAsInt$134621());
  }
  
  public void serialize(T paramT, String paramString, boolean paramBoolean, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    paramJsonGenerator.writeNumberField(paramString, convertToInt(paramT));
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.typeconverters.IntBasedTypeConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */