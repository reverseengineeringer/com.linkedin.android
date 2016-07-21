package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;

public abstract class FloatBasedTypeConverter<T>
  implements TypeConverter<T>
{
  public abstract float convertToFloat(T paramT);
  
  public abstract T getFromFloat(float paramFloat);
  
  public T parse(JsonParser paramJsonParser)
    throws IOException
  {
    return (T)getFromFloat((float)paramJsonParser.getValueAsDouble$133357());
  }
  
  public void serialize(T paramT, String paramString, boolean paramBoolean, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    float f = convertToFloat(paramT);
    paramJsonGenerator.writeFieldName(paramString);
    paramJsonGenerator.writeNumber(f);
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.typeconverters.FloatBasedTypeConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */