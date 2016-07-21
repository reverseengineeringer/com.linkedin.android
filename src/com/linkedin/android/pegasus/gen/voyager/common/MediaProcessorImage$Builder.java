package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class MediaProcessorImage$Builder
  implements RecordTemplateBuilder<MediaProcessorImage>
{
  private boolean hasId = false;
  private String id = null;
  
  public final MediaProcessorImage build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MediaProcessorImage.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MediaProcessorImage(id, hasId);
    } while (hasId);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorImage", "id");
  }
  
  public final Builder setId(String paramString)
  {
    if (paramString == null)
    {
      hasId = false;
      id = null;
      return this;
    }
    hasId = true;
    id = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorImage.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */