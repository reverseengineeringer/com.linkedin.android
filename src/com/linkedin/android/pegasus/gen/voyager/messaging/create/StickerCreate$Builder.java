package com.linkedin.android.pegasus.gen.voyager.messaging.create;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class StickerCreate$Builder
  implements RecordTemplateBuilder<StickerCreate>
{
  public StickerCreate.CustomContent customContent = null;
  public boolean hasCustomContent = false;
  private boolean hasStickerUrn = false;
  private Urn stickerUrn = null;
  
  public final StickerCreate build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (StickerCreate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new StickerCreate(stickerUrn, customContent, hasStickerUrn, hasCustomContent);
    } while (hasStickerUrn);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.StickerCreate", "stickerUrn");
  }
  
  public final Builder setStickerUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasStickerUrn = false;
      stickerUrn = null;
      return this;
    }
    hasStickerUrn = true;
    stickerUrn = paramUrn;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.StickerCreate.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */