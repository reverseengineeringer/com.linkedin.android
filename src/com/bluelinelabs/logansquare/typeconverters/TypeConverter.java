package com.bluelinelabs.logansquare.typeconverters;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;

public abstract interface TypeConverter<T>
{
  public abstract T parse(JsonParser paramJsonParser)
    throws IOException;
  
  public abstract void serialize(T paramT, String paramString, boolean paramBoolean, JsonGenerator paramJsonGenerator)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.typeconverters.TypeConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */