package com.linkedin.android.pegasus.gen.voyager.feed.urlpreview;

import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class PreviewImage$Builder
  implements RecordTemplateBuilder<PreviewImage>
{
  public boolean hasMediaProxyImage = false;
  public boolean hasOriginalImage = false;
  public Image mediaProxyImage = null;
  public Image originalImage = null;
  
  public final PreviewImage build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PreviewImage.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new PreviewImage(originalImage, mediaProxyImage, hasOriginalImage, hasMediaProxyImage);
      if (!hasOriginalImage) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.PreviewImage", "originalImage");
      }
    } while (hasMediaProxyImage);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.PreviewImage", "mediaProxyImage");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.PreviewImage.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */