package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.SerializedString;
import java.io.IOException;
import java.io.Serializable;

public final class DefaultPrettyPrinter
  implements PrettyPrinter, Serializable
{
  public static final SerializedString DEFAULT_ROOT_VALUE_SEPARATOR = new SerializedString(" ");
  protected Indenter _arrayIndenter = FixedSpaceIndenter.instance;
  protected transient int _nesting = 0;
  protected Indenter _objectIndenter = DefaultIndenter.SYSTEM_LINEFEED_INSTANCE;
  protected final SerializableString _rootSeparator;
  protected boolean _spacesInObjectEntries = true;
  
  public DefaultPrettyPrinter()
  {
    this(DEFAULT_ROOT_VALUE_SEPARATOR);
  }
  
  private DefaultPrettyPrinter(SerializableString paramSerializableString)
  {
    _rootSeparator = paramSerializableString;
  }
  
  public final void beforeArrayValues(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    _arrayIndenter.writeIndentation(paramJsonGenerator, _nesting);
  }
  
  public final void beforeObjectEntries(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    _objectIndenter.writeIndentation(paramJsonGenerator, _nesting);
  }
  
  public final void writeArrayValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw(',');
    _arrayIndenter.writeIndentation(paramJsonGenerator, _nesting);
  }
  
  public final void writeEndArray(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException, JsonGenerationException
  {
    if (!_arrayIndenter.isInline()) {
      _nesting -= 1;
    }
    if (paramInt > 0) {
      _arrayIndenter.writeIndentation(paramJsonGenerator, _nesting);
    }
    for (;;)
    {
      paramJsonGenerator.writeRaw(']');
      return;
      paramJsonGenerator.writeRaw(' ');
    }
  }
  
  public final void writeEndObject(JsonGenerator paramJsonGenerator, int paramInt)
    throws IOException, JsonGenerationException
  {
    if (!_objectIndenter.isInline()) {
      _nesting -= 1;
    }
    if (paramInt > 0) {
      _objectIndenter.writeIndentation(paramJsonGenerator, _nesting);
    }
    for (;;)
    {
      paramJsonGenerator.writeRaw('}');
      return;
      paramJsonGenerator.writeRaw(' ');
    }
  }
  
  public final void writeObjectEntrySeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw(',');
    _objectIndenter.writeIndentation(paramJsonGenerator, _nesting);
  }
  
  public final void writeObjectFieldValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    if (_spacesInObjectEntries)
    {
      paramJsonGenerator.writeRaw(" : ");
      return;
    }
    paramJsonGenerator.writeRaw(':');
  }
  
  public final void writeRootValueSeparator(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    if (_rootSeparator != null) {
      paramJsonGenerator.writeRaw(_rootSeparator);
    }
  }
  
  public final void writeStartArray(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    if (!_arrayIndenter.isInline()) {
      _nesting += 1;
    }
    paramJsonGenerator.writeRaw('[');
  }
  
  public final void writeStartObject(JsonGenerator paramJsonGenerator)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeRaw('{');
    if (!_objectIndenter.isInline()) {
      _nesting += 1;
    }
  }
  
  public static final class FixedSpaceIndenter
    extends DefaultPrettyPrinter.NopIndenter
  {
    public static final FixedSpaceIndenter instance = new FixedSpaceIndenter();
    
    public final boolean isInline()
    {
      return true;
    }
    
    public final void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeRaw(' ');
    }
  }
  
  public static abstract interface Indenter
  {
    public abstract boolean isInline();
    
    public abstract void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
      throws IOException;
  }
  
  public static class NopIndenter
    implements DefaultPrettyPrinter.Indenter, Serializable
  {
    public static final NopIndenter instance = new NopIndenter();
    
    public boolean isInline()
    {
      return true;
    }
    
    public void writeIndentation(JsonGenerator paramJsonGenerator, int paramInt)
      throws IOException
    {}
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.util.DefaultPrettyPrinter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */