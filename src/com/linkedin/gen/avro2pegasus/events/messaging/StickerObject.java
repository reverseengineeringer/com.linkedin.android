package com.linkedin.gen.avro2pegasus.events.messaging;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class StickerObject
  implements RecordTemplate<StickerObject>
{
  public static final StickerObjectBuilder BUILDER = StickerObjectBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasStickerNumber;
  public final boolean hasStickerPackName;
  public final long stickerNumber;
  public final String stickerPackName;
  
  StickerObject(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    stickerPackName = paramString;
    stickerNumber = paramLong;
    hasStickerPackName = paramBoolean1;
    hasStickerNumber = paramBoolean2;
    _cachedId = null;
  }
  
  public final StickerObject accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasStickerPackName)
    {
      paramDataProcessor.startRecordField$505cff1c("stickerPackName");
      paramDataProcessor.processString(stickerPackName);
    }
    if (hasStickerNumber)
    {
      paramDataProcessor.startRecordField$505cff1c("stickerNumber");
      paramDataProcessor.processLong(stickerNumber);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasStickerPackName) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerObject", "stickerPackName");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasStickerNumber) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerObject", "stickerNumber");
      }
      return new StickerObject(stickerPackName, stickerNumber, hasStickerPackName, hasStickerNumber);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (StickerObject)paramObject;
      if (stickerPackName != null)
      {
        if (stickerPackName.equals(stickerPackName)) {}
      }
      else {
        while (stickerPackName != null) {
          return false;
        }
      }
    } while (stickerNumber == stickerNumber);
    return false;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (stickerPackName != null) {}
    for (int i = stickerPackName.hashCode();; i = 0)
    {
      i = (i + 527) * 31 + (int)(stickerNumber ^ stickerNumber >>> 32);
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<StickerObject>
  {
    private boolean hasStickerNumber = false;
    private boolean hasStickerPackName = false;
    private long stickerNumber = 0L;
    private String stickerPackName = null;
    
    public final StickerObject build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (StickerObject.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new StickerObject(stickerPackName, stickerNumber, hasStickerPackName, hasStickerNumber);
        if (!hasStickerPackName) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerObject", "stickerPackName");
        }
      } while (hasStickerNumber);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.messaging.StickerObject", "stickerNumber");
    }
    
    public final Builder setStickerNumber(Long paramLong)
    {
      if (paramLong == null)
      {
        hasStickerNumber = false;
        stickerNumber = 0L;
        return this;
      }
      hasStickerNumber = true;
      stickerNumber = paramLong.longValue();
      return this;
    }
    
    public final Builder setStickerPackName(String paramString)
    {
      if (paramString == null)
      {
        hasStickerPackName = false;
        stickerPackName = null;
        return this;
      }
      hasStickerPackName = true;
      stickerPackName = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.StickerObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */