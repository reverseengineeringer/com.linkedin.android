package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.UnionMemberCountException;

public final class Image$Builder
{
  private boolean hasMediaProcessorImageValue = false;
  private boolean hasMediaProxyImageValue = false;
  private boolean hasUrlValue = false;
  private MediaProcessorImage mediaProcessorImageValue = null;
  private MediaProxyImage mediaProxyImageValue = null;
  private String urlValue = null;
  
  public final Image build()
    throws BuilderException
  {
    int j = 0;
    if (hasMediaProcessorImageValue) {
      j = 0 + 1;
    }
    int i = j;
    if (hasMediaProxyImageValue) {
      i = j + 1;
    }
    j = i;
    if (hasUrlValue) {
      j = i + 1;
    }
    if (j > 1) {
      throw new UnionMemberCountException("com.linkedin.android.pegasus.gen.voyager.common.Image", j);
    }
    return new Image(mediaProcessorImageValue, mediaProxyImageValue, urlValue, hasMediaProcessorImageValue, hasMediaProxyImageValue, hasUrlValue);
  }
  
  public final Builder setMediaProcessorImageValue(MediaProcessorImage paramMediaProcessorImage)
  {
    if (paramMediaProcessorImage == null)
    {
      hasMediaProcessorImageValue = false;
      mediaProcessorImageValue = null;
      return this;
    }
    hasMediaProcessorImageValue = true;
    mediaProcessorImageValue = paramMediaProcessorImage;
    return this;
  }
  
  public final Builder setMediaProxyImageValue(MediaProxyImage paramMediaProxyImage)
  {
    if (paramMediaProxyImage == null)
    {
      hasMediaProxyImageValue = false;
      mediaProxyImageValue = null;
      return this;
    }
    hasMediaProxyImageValue = true;
    mediaProxyImageValue = paramMediaProxyImage;
    return this;
  }
  
  public final Builder setUrlValue(String paramString)
  {
    if (paramString == null)
    {
      hasUrlValue = false;
      urlValue = null;
      return this;
    }
    hasUrlValue = true;
    urlValue = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.Image.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */