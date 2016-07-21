package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Picture
  implements FissileDataModel<Picture>, RecordTemplate<Picture>
{
  public static final PictureBuilder BUILDER = PictureBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final ImageCropInfo cropInfo;
  public final String croppedImage;
  public final boolean hasCropInfo;
  public final boolean hasCroppedImage;
  public final boolean hasMasterImage;
  public final String masterImage;
  
  Picture(String paramString1, String paramString2, ImageCropInfo paramImageCropInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    croppedImage = paramString1;
    masterImage = paramString2;
    cropInfo = paramImageCropInfo;
    hasCroppedImage = paramBoolean1;
    hasMasterImage = paramBoolean2;
    hasCropInfo = paramBoolean3;
    _cachedId = null;
  }
  
  public final Picture accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasCroppedImage)
    {
      paramDataProcessor.startRecordField$505cff1c("croppedImage");
      paramDataProcessor.processString(croppedImage);
    }
    if (hasMasterImage)
    {
      paramDataProcessor.startRecordField$505cff1c("masterImage");
      paramDataProcessor.processString(masterImage);
    }
    ImageCropInfo localImageCropInfo = null;
    boolean bool = false;
    if (hasCropInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("cropInfo");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label143;
      }
      localImageCropInfo = cropInfo.accept(paramDataProcessor);
      if (localImageCropInfo == null) {
        break label160;
      }
    }
    label143:
    label160:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label229;
      }
      try
      {
        if (hasCroppedImage) {
          break label165;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture", "croppedImage");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localImageCropInfo = (ImageCropInfo)paramDataProcessor.processDataTemplate(cropInfo);
      break;
    }
    label165:
    if (!hasMasterImage) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture", "masterImage");
    }
    if (!hasCropInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture", "cropInfo");
    }
    return new Picture(croppedImage, masterImage, localImageCropInfo, hasCroppedImage, hasMasterImage, bool);
    label229:
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
      paramObject = (Picture)paramObject;
      if (croppedImage != null)
      {
        if (croppedImage.equals(croppedImage)) {}
      }
      else {
        while (croppedImage != null) {
          return false;
        }
      }
      if (masterImage != null)
      {
        if (masterImage.equals(masterImage)) {}
      }
      else {
        while (masterImage != null) {
          return false;
        }
      }
      if (cropInfo == null) {
        break;
      }
    } while (cropInfo.equals(cropInfo));
    for (;;)
    {
      return false;
      if (cropInfo == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasCroppedImage) {
      i = PegasusBinaryUtils.getEncodedLength(croppedImage) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasMasterImage) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(masterImage);
    }
    j = i + 1;
    i = j;
    if (hasCropInfo)
    {
      i = j + 1;
      if (cropInfo._cachedId == null) {
        break label112;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(cropInfo._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label112:
      i += cropInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (croppedImage != null)
    {
      i = croppedImage.hashCode();
      if (masterImage == null) {
        break label87;
      }
    }
    label87:
    for (int j = masterImage.hashCode();; j = 0)
    {
      if (cropInfo != null) {
        k = cropInfo.hashCode();
      }
      i = (j + (i + 527) * 31) * 31 + k;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Picture");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label162:
    label265:
    label275:
    label300:
    label308:
    label310:
    do
    {
      ByteBuffer localByteBuffer;
      for (;;)
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-156864988);
        if (hasCroppedImage)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, croppedImage);
          if (!hasMasterImage) {
            break label265;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, masterImage);
          if (!hasCropInfo) {
            break label300;
          }
          localByteBuffer.put((byte)1);
          if (cropInfo._cachedId == null) {
            break label275;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, cropInfo._cachedId);
          cropInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label308;
          }
          if (str != null) {
            break label310;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label162;
          localByteBuffer.put((byte)1);
          cropInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          continue;
          localByteBuffer.put((byte)0);
        }
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */