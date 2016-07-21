package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;

public abstract class DoubleBasedTypeConverter<T>
  implements TypeConverter<T>
{
  public abstract double convertToDouble(T paramT);
  
  public abstract T getFromDouble(double paramDouble);
  
  public T parse(JsonParser paramJsonParser)
    throws IOException
  {
    return (T)getFromDouble(paramJsonParser.getValueAsDouble$133357());
  }
  
  public void serialize(T paramT, String paramString, boolean paramBoolean, JsonGenerator paramJsonGenerator)
    throws IOException
  {
    double d = convertToDouble(paramT);
    paramJsonGenerator.writeFieldName(paramString);
    paramJsonGenerator.writeNumber(d);
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.typeconverters.DoubleBasedTypeConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */