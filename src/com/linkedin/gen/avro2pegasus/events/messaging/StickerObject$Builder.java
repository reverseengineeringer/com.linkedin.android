package com.linkedin.gen.avro2pegasus.events.messaging;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class StickerObject$Builder
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

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.messaging.StickerObject.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */