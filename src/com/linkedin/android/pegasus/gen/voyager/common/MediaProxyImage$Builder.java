package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class MediaProxyImage$Builder
  implements RecordTemplateBuilder<MediaProxyImage>
{
  private boolean hasOriginalHeight = false;
  private boolean hasOriginalWidth = false;
  private boolean hasUrl = false;
  private int originalHeight = 0;
  private int originalWidth = 0;
  private String url = null;
  
  public final MediaProxyImage build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MediaProxyImage.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new MediaProxyImage(url, originalWidth, originalHeight, hasUrl, hasOriginalWidth, hasOriginalHeight);
    } while (hasUrl);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage", "url");
  }
  
  public final Builder setOriginalHeight(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasOriginalHeight = false;
      originalHeight = 0;
      return this;
    }
    hasOriginalHeight = true;
    originalHeight = paramInteger.intValue();
    return this;
  }
  
  public final Builder setOriginalWidth(Integer paramInteger)
  {
    if (paramInteger == null)
    {
      hasOriginalWidth = false;
      originalWidth = 0;
      return this;
    }
    hasOriginalWidth = true;
    originalWidth = paramInteger.intValue();
    return this;
  }
  
  public final Builder setUrl(String paramString)
  {
    if (paramString == null)
    {
      hasUrl = false;
      url = null;
      return this;
    }
    hasUrl = true;
    url = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */