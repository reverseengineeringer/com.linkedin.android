package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ImageCropInfo$Builder
  implements RecordTemplateBuilder<ImageCropInfo>
{
  public boolean hasHeight = false;
  public boolean hasWidth = false;
  public boolean hasX = false;
  public boolean hasY = false;
  public int height = 0;
  public int width = 0;
  public int x = 0;
  public int y = 0;
  
  public final ImageCropInfo build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ImageCropInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ImageCropInfo(x, y, width, height, hasX, hasY, hasWidth, hasHeight);
      if (!hasX) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ImageCropInfo", "x");
      }
      if (!hasY) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ImageCropInfo", "y");
      }
      if (!hasWidth) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ImageCropInfo", "width");
      }
    } while (hasHeight);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.ImageCropInfo", "height");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.ImageCropInfo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */