package com.linkedin.data.lite.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.linkedin.data.lite.Bytes;
import com.linkedin.data.lite.BytesUtil;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.DataTemplate;
import java.io.IOException;

public final class JacksonJsonGenerator
  implements DataProcessor, com.linkedin.data.lite.JsonGenerator
{
  private static final JsonFactory FACTORY = new JsonFactory();
  private com.fasterxml.jackson.core.JsonGenerator _generator;
  
  public final void endArray()
    throws DataProcessorException
  {
    try
    {
      _generator.writeEndArray();
      return;
    }
    catch (IOException localIOException)
    {
      throw new DataProcessorException(localIOException);
    }
  }
  
  public final void endMap()
    throws DataProcessorException
  {
    try
    {
      _generator.writeEndObject();
      return;
    }
    catch (IOException localIOException)
    {
      throw new DataProcessorException(localIOException);
    }
  }
  
  public final void endRecord()
    throws DataProcessorException
  {
    try
    {
      _generator.writeEndObject();
      return;
    }
    catch (IOException localIOException)
    {
      throw new DataProcessorException(localIOException);
    }
  }
  
  public final void endUnion()
    throws DataProcessorException
  {
    try
    {
      _generator.writeEndObject();
      return;
    }
    catch (IOException localIOException)
    {
      throw new DataProcessorException(localIOException);
    }
  }
  
  /* Error */
  public final <T extends DataTemplate<T>> void generate(T paramT, java.io.Writer paramWriter)
    throws com.linkedin.data.lite.JsonGeneratorException
  {
    // Byte code:
    //   0: aload_0
    //   1: getstatic 21	com/linkedin/data/lite/jackson/JacksonJsonGenerator:FACTORY	Lcom/fasterxml/jackson/core/JsonFactory;
    //   4: aload_2
    //   5: invokevirtual 53	com/fasterxml/jackson/core/JsonFactory:createGenerator	(Ljava/io/Writer;)Lcom/fasterxml/jackson/core/JsonGenerator;
    //   8: putfield 30	com/linkedin/data/lite/jackson/JacksonJsonGenerator:_generator	Lcom/fasterxml/jackson/core/JsonGenerator;
    //   11: aload_1
    //   12: aload_0
    //   13: invokeinterface 59 2 0
    //   18: pop
    //   19: aload_0
    //   20: getfield 30	com/linkedin/data/lite/jackson/JacksonJsonGenerator:_generator	Lcom/fasterxml/jackson/core/JsonGenerator;
    //   23: ifnull +10 -> 33
    //   26: aload_0
    //   27: getfield 30	com/linkedin/data/lite/jackson/JacksonJsonGenerator:_generator	Lcom/fasterxml/jackson/core/JsonGenerator;
    //   30: invokevirtual 62	com/fasterxml/jackson/core/JsonGenerator:close	()V
    //   33: return
    //   34: astore_1
    //   35: new 49	com/linkedin/data/lite/JsonGeneratorException
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 63	com/linkedin/data/lite/JsonGeneratorException:<init>	(Ljava/lang/Throwable;)V
    //   43: athrow
    //   44: astore_1
    //   45: aload_0
    //   46: getfield 30	com/linkedin/data/lite/jackson/JacksonJsonGenerator:_generator	Lcom/fasterxml/jackson/core/JsonGenerator;
    //   49: ifnull +10 -> 59
    //   52: aload_0
    //   53: getfield 30	com/linkedin/data/lite/jackson/JacksonJsonGenerator:_generator	Lcom/fasterxml/jackson/core/JsonGenerator;
    //   56: invokevirtual 62	com/fasterxml/jackson/core/JsonGenerator:close	()V
    //   59: aload_1
    //   60: athrow
    //   61: astore_1
    //   62: goto -27 -> 35
    //   65: astore_2
    //   66: goto -7 -> 59
    //   69: astore_1
    //   70: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	JacksonJsonGenerator
    //   0	71	1	paramT	T
    //   0	71	2	paramWriter	java.io.Writer
    // Exception table:
    //   from	to	target	type
    //   0	19	34	com/linkedin/data/lite/DataProcessorException
    //   0	19	44	finally
    //   35	44	44	finally
    //   0	19	61	java/io/IOException
    //   52	59	65	java/io/IOException
    //   26	33	69	java/io/IOException
  }
  
  public final void processArrayItem(int paramInt)
    throws DataProcessorException
  {}
  
  public final void processBoolean(boolean paramBoolean)
    throws DataProcessorException
  {
    try
    {
      _generator.writeBoolean(paramBoolean);
      return;
    }
    catch (IOException localIOException)
    {
      throw new DataProcessorException(localIOException);
    }
  }
  
  public final void processBytes(Bytes paramBytes)
    throws DataProcessorException
  {
    try
    {
      _generator.writeString(BytesUtil.bytesToString(paramBytes.getBytes()));
      return;
    }
    catch (IOException paramBytes)
    {
      throw new DataProcessorException(paramBytes);
    }
  }
  
  public final <T extends DataTemplate<T>> T processDataTemplate(T paramT)
    throws DataProcessorException
  {
    return null;
  }
  
  public final void processDouble(double paramDouble)
    throws DataProcessorException
  {
    try
    {
      _generator.writeNumber(paramDouble);
      return;
    }
    catch (IOException localIOException)
    {
      throw new DataProcessorException(localIOException);
    }
  }
  
  public final <E extends Enum<E>> void processEnum(E paramE)
    throws DataProcessorException
  {
    try
    {
      _generator.writeString(paramE.name());
      return;
    }
    catch (IOException paramE)
    {
      throw new DataProcessorException(paramE);
    }
  }
  
  public final void processFloat(float paramFloat)
    throws DataProcessorException
  {
    try
    {
      _generator.writeNumber(paramFloat);
      return;
    }
    catch (IOException localIOException)
    {
      throw new DataProcessorException(localIOException);
    }
  }
  
  public final void processInt(int paramInt)
    throws DataProcessorException
  {
    try
    {
      _generator.writeNumber(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      throw new DataProcessorException(localIOException);
    }
  }
  
  public final void processJsonString(String paramString)
    throws DataProcessorException
  {
    try
    {
      _generator.writeRawValue(paramString);
      return;
    }
    catch (IOException paramString)
    {
      throw new DataProcessorException(paramString);
    }
  }
  
  public final void processLong(long paramLong)
    throws DataProcessorException
  {
    try
    {
      _generator.writeNumber(paramLong);
      return;
    }
    catch (IOException localIOException)
    {
      throw new DataProcessorException(localIOException);
    }
  }
  
  public final void processMapKey(String paramString, int paramInt)
    throws DataProcessorException
  {
    try
    {
      _generator.writeFieldName(paramString);
      return;
    }
    catch (IOException paramString)
    {
      throw new DataProcessorException(paramString);
    }
  }
  
  public final void processString(String paramString)
    throws DataProcessorException
  {
    try
    {
      _generator.writeString(paramString);
      return;
    }
    catch (IOException paramString)
    {
      throw new DataProcessorException(paramString);
    }
  }
  
  public final boolean shouldAcceptTransitively()
  {
    return true;
  }
  
  public final boolean shouldReturnProcessedTemplate()
  {
    return false;
  }
  
  public final void startArray$13462e()
    throws DataProcessorException
  {
    try
    {
      _generator.writeStartArray();
      return;
    }
    catch (IOException localIOException)
    {
      throw new DataProcessorException(localIOException);
    }
  }
  
  public final void startMap$13462e()
    throws DataProcessorException
  {
    try
    {
      _generator.writeStartObject();
      return;
    }
    catch (IOException localIOException)
    {
      throw new DataProcessorException(localIOException);
    }
  }
  
  public final void startRecord()
    throws DataProcessorException
  {
    try
    {
      _generator.writeStartObject();
      return;
    }
    catch (IOException localIOException)
    {
      throw new DataProcessorException(localIOException);
    }
  }
  
  public final void startRecordField$505cff1c(String paramString)
    throws DataProcessorException
  {
    try
    {
      _generator.writeFieldName(paramString);
      return;
    }
    catch (IOException paramString)
    {
      throw new DataProcessorException(paramString);
    }
  }
  
  public final void startUnion()
    throws DataProcessorException
  {
    try
    {
      _generator.writeStartObject();
      return;
    }
    catch (IOException localIOException)
    {
      throw new DataProcessorException(localIOException);
    }
  }
  
  public final void startUnionMember$505cff1c(String paramString)
    throws DataProcessorException
  {
    try
    {
      _generator.writeFieldName(paramString);
      return;
    }
    catch (IOException paramString)
    {
      throw new DataProcessorException(paramString);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.jackson.JacksonJsonGenerator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */