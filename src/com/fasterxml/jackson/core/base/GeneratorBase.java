package com.fasterxml.jackson.core.base;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.json.DupDetector;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.VersionUtil;
import java.io.IOException;

public abstract class GeneratorBase
  extends JsonGenerator
{
  protected static final int DERIVED_FEATURES_MASK = WRITE_NUMBERS_AS_STRINGS_mask | ESCAPE_NON_ASCII_mask | STRICT_DUPLICATE_DETECTION_mask;
  public boolean _cfgNumbersAsStrings;
  protected boolean _closed;
  protected int _features;
  protected ObjectCodec _objectCodec;
  public JsonWriteContext _writeContext;
  
  public GeneratorBase(int paramInt, ObjectCodec paramObjectCodec)
  {
    _features = paramInt;
    _objectCodec = paramObjectCodec;
    if (JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION.enabledIn(paramInt)) {}
    for (paramObjectCodec = new DupDetector(this);; paramObjectCodec = null)
    {
      _writeContext = new JsonWriteContext(0, null, paramObjectCodec);
      _cfgNumbersAsStrings = JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS.enabledIn(paramInt);
      return;
    }
  }
  
  public abstract void _releaseBuffers();
  
  public abstract void _verifyValueWrite(String paramString)
    throws IOException;
  
  public void close()
    throws IOException
  {
    _closed = true;
  }
  
  public final boolean isEnabled(JsonGenerator.Feature paramFeature)
  {
    return (_features & _mask) != 0;
  }
  
  public Version version()
  {
    return VersionUtil.versionFor(getClass());
  }
  
  public final void writeObject$5d527811()
    throws IOException
  {
    writeNull();
  }
  
  public final void writeRawValue(String paramString)
    throws IOException
  {
    _verifyValueWrite("write raw value");
    writeRaw(paramString);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.base.GeneratorBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */