package com.linkedin.data.lite;

import java.io.Writer;

public abstract interface JsonGenerator
{
  public abstract <V extends DataTemplate<V>> void generate(V paramV, Writer paramWriter)
    throws JsonGeneratorException;
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.JsonGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */