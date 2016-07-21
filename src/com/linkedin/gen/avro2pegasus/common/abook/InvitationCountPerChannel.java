package com.linkedin.gen.avro2pegasus.common.abook;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class InvitationCountPerChannel
  implements RecordTemplate<InvitationCountPerChannel>
{
  public static final InvitationCountPerChannelBuilder BUILDER = InvitationCountPerChannelBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final int emailCount;
  public final boolean hasEmailCount;
  public final boolean hasSmsCount;
  public final int smsCount;
  
  InvitationCountPerChannel(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    emailCount = paramInt1;
    smsCount = paramInt2;
    hasEmailCount = paramBoolean1;
    hasSmsCount = paramBoolean2;
    _cachedId = null;
  }
  
  public final InvitationCountPerChannel accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasEmailCount)
    {
      paramDataProcessor.startRecordField$505cff1c("emailCount");
      paramDataProcessor.processInt(emailCount);
    }
    if (hasSmsCount)
    {
      paramDataProcessor.startRecordField$505cff1c("smsCount");
      paramDataProcessor.processInt(smsCount);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasEmailCount) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannel", "emailCount");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasSmsCount) {
        throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannel", "smsCount");
      }
      return new InvitationCountPerChannel(emailCount, smsCount, hasEmailCount, hasSmsCount);
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
      paramObject = (InvitationCountPerChannel)paramObject;
      if (emailCount != emailCount) {
        return false;
      }
    } while (smsCount == smsCount);
    return false;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i = (emailCount + 527) * 31 + smsCount;
    _cachedHashCode = i;
    return i;
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public static final class Builder
    implements RecordTemplateBuilder<InvitationCountPerChannel>
  {
    public int emailCount = 0;
    public boolean hasEmailCount = false;
    public boolean hasSmsCount = false;
    public int smsCount = 0;
    
    public final InvitationCountPerChannel build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (InvitationCountPerChannel.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new InvitationCountPerChannel(emailCount, smsCount, hasEmailCount, hasSmsCount);
        if (!hasEmailCount) {
          throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannel", "emailCount");
        }
      } while (hasSmsCount);
      throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannel", "smsCount");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.common.abook.InvitationCountPerChannel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */