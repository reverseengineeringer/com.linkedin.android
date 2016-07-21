package com.linkedin.data.lite;

public abstract interface DataProcessor
{
  public abstract void endArray()
    throws DataProcessorException;
  
  public abstract void endMap()
    throws DataProcessorException;
  
  public abstract void endRecord()
    throws DataProcessorException;
  
  public abstract void endUnion()
    throws DataProcessorException;
  
  public abstract void processArrayItem(int paramInt)
    throws DataProcessorException;
  
  public abstract void processBoolean(boolean paramBoolean)
    throws DataProcessorException;
  
  public abstract void processBytes(Bytes paramBytes)
    throws DataProcessorException;
  
  public abstract <T extends DataTemplate<T>> T processDataTemplate(T paramT)
    throws DataProcessorException;
  
  public abstract void processDouble(double paramDouble)
    throws DataProcessorException;
  
  public abstract <E extends Enum<E>> void processEnum(E paramE)
    throws DataProcessorException;
  
  public abstract void processFloat(float paramFloat)
    throws DataProcessorException;
  
  public abstract void processInt(int paramInt)
    throws DataProcessorException;
  
  public abstract void processLong(long paramLong)
    throws DataProcessorException;
  
  public abstract void processMapKey(String paramString, int paramInt)
    throws DataProcessorException;
  
  public abstract void processString(String paramString)
    throws DataProcessorException;
  
  public abstract boolean shouldAcceptTransitively();
  
  public abstract boolean shouldReturnProcessedTemplate();
  
  public abstract void startArray$13462e()
    throws DataProcessorException;
  
  public abstract void startMap$13462e()
    throws DataProcessorException;
  
  public abstract void startRecord()
    throws DataProcessorException;
  
  public abstract void startRecordField$505cff1c(String paramString)
    throws DataProcessorException;
  
  public abstract void startUnion()
    throws DataProcessorException;
  
  public abstract void startUnionMember$505cff1c(String paramString)
    throws DataProcessorException;
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.DataProcessor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */