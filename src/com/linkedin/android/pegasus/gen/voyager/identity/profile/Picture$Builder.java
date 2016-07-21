package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Picture$Builder
  implements RecordTemplateBuilder<Picture>
{
  public ImageCropInfo cropInfo = null;
  public String croppedImage = null;
  public boolean hasCropInfo = false;
  public boolean hasCroppedImage = false;
  public boolean hasMasterImage = false;
  public String masterImage = null;
  
  public final Picture build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Picture.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new Picture(croppedImage, masterImage, cropInfo, hasCroppedImage, hasMasterImage, hasCropInfo);
      if (!hasCroppedImage) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture", "croppedImage");
      }
      if (!hasMasterImage) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture", "masterImage");
      }
    } while (hasCropInfo);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture", "cropInfo");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */