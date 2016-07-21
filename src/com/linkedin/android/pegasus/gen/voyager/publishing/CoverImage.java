package com.linkedin.android.pegasus.gen.voyager.publishing;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.common.Rectangle;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CoverImage
  implements FissileDataModel<CoverImage>, RecordTemplate<CoverImage>
{
  public static final CoverImageBuilder BUILDER = CoverImageBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AttributedText caption;
  public final Rectangle cropInfo;
  public final Image croppedImage;
  public final boolean hasCaption;
  public final boolean hasCropInfo;
  public final boolean hasCroppedImage;
  public final boolean hasOriginalImage;
  public final Image originalImage;
  
  CoverImage(Image paramImage1, AttributedText paramAttributedText, Image paramImage2, Rectangle paramRectangle, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    originalImage = paramImage1;
    caption = paramAttributedText;
    croppedImage = paramImage2;
    cropInfo = paramRectangle;
    hasOriginalImage = paramBoolean1;
    hasCaption = paramBoolean2;
    hasCroppedImage = paramBoolean3;
    hasCropInfo = paramBoolean4;
    _cachedId = null;
  }
  
  public final CoverImage accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    label56:
    Object localObject3;
    boolean bool2;
    label95:
    label106:
    Object localObject4;
    boolean bool3;
    if (hasOriginalImage)
    {
      paramDataProcessor.startRecordField$505cff1c("originalImage");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = originalImage.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label268;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      localObject3 = null;
      bool2 = false;
      if (hasCaption)
      {
        paramDataProcessor.startRecordField$505cff1c("caption");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label277;
        }
        localObject1 = caption.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label295;
        }
        bool2 = true;
        localObject3 = localObject1;
      }
      localObject4 = null;
      bool3 = false;
      if (hasCroppedImage)
      {
        paramDataProcessor.startRecordField$505cff1c("croppedImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label304;
        }
        localObject1 = croppedImage.accept(paramDataProcessor);
        label146:
        if (localObject1 == null) {
          break label322;
        }
        bool3 = true;
        localObject4 = localObject1;
      }
      label158:
      localObject1 = null;
      bool4 = false;
      if (hasCropInfo)
      {
        paramDataProcessor.startRecordField$505cff1c("cropInfo");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label332;
        }
        localObject1 = cropInfo.accept(paramDataProcessor);
        label198:
        if (localObject1 == null) {
          break label350;
        }
      }
    }
    label268:
    label277:
    label295:
    label304:
    label322:
    label332:
    label350:
    for (boolean bool4 = true;; bool4 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label416;
      }
      try
      {
        if (hasOriginalImage) {
          break label356;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.publishing.CoverImage", "originalImage");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (Image)paramDataProcessor.processDataTemplate(originalImage);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (AttributedText)paramDataProcessor.processDataTemplate(caption);
      break label95;
      bool2 = false;
      localObject3 = localObject1;
      break label106;
      localObject1 = (Image)paramDataProcessor.processDataTemplate(croppedImage);
      break label146;
      bool3 = false;
      localObject4 = localObject1;
      break label158;
      localObject1 = (Rectangle)paramDataProcessor.processDataTemplate(cropInfo);
      break label198;
    }
    label356:
    if (!hasCroppedImage) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.publishing.CoverImage", "croppedImage");
    }
    if (!hasCropInfo) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.publishing.CoverImage", "cropInfo");
    }
    return new CoverImage((Image)localObject2, (AttributedText)localObject3, (Image)localObject4, (Rectangle)localObject1, bool1, bool2, bool3, bool4);
    label416:
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
      paramObject = (CoverImage)paramObject;
      if (originalImage != null)
      {
        if (originalImage.equals(originalImage)) {}
      }
      else {
        while (originalImage != null) {
          return false;
        }
      }
      if (caption != null)
      {
        if (caption.equals(caption)) {}
      }
      else {
        while (caption != null) {
          return false;
        }
      }
      if (croppedImage != null)
      {
        if (croppedImage.equals(croppedImage)) {}
      }
      else {
        while (croppedImage != null) {
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
    if (hasOriginalImage)
    {
      if (originalImage._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(originalImage._cachedId) + 9;
      }
    }
    else
    {
      int j = i + 1;
      i = j;
      if (hasCaption)
      {
        i = j + 1;
        if (caption._cachedId == null) {
          break label198;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(caption._cachedId);
      }
      label93:
      j = i + 1;
      i = j;
      if (hasCroppedImage)
      {
        i = j + 1;
        if (croppedImage._cachedId == null) {
          break label211;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(croppedImage._cachedId);
      }
      label135:
      j = i + 1;
      i = j;
      if (hasCropInfo)
      {
        i = j + 1;
        if (cropInfo._cachedId == null) {
          break label224;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(cropInfo._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = originalImage.getSerializedSize() + 7;
      break;
      label198:
      i += caption.getSerializedSize();
      break label93;
      label211:
      i += croppedImage.getSerializedSize();
      break label135;
      label224:
      i += cropInfo.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int m = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    if (originalImage != null)
    {
      i = originalImage.hashCode();
      if (caption == null) {
        break label110;
      }
      j = caption.hashCode();
      label45:
      if (croppedImage == null) {
        break label115;
      }
    }
    label110:
    label115:
    for (int k = croppedImage.hashCode();; k = 0)
    {
      if (cropInfo != null) {
        m = cropInfo.hashCode();
      }
      i = (k + (j + (i + 527) * 31) * 31) * 31 + m;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CoverImage");
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
    label230:
    label290:
    label418:
    label443:
    label453:
    label478:
    label488:
    label513:
    label521:
    label523:
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
        localByteBuffer.putInt(-202516986);
        if (hasOriginalImage)
        {
          localByteBuffer.put((byte)1);
          if (originalImage._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, originalImage._cachedId);
            originalImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCaption) {
              break label443;
            }
            localByteBuffer.put((byte)1);
            if (caption._cachedId == null) {
              break label418;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, caption._cachedId);
            caption.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCroppedImage) {
              break label478;
            }
            localByteBuffer.put((byte)1);
            if (croppedImage._cachedId == null) {
              break label453;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, croppedImage._cachedId);
            croppedImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasCropInfo) {
              break label513;
            }
            localByteBuffer.put((byte)1);
            if (cropInfo._cachedId == null) {
              break label488;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, cropInfo._cachedId);
            cropInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label521;
          }
          if (str != null) {
            break label523;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          originalImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          caption.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
          localByteBuffer.put((byte)1);
          croppedImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label290;
          localByteBuffer.put((byte)0);
          break label290;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.publishing.CoverImage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */