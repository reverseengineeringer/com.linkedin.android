package com.linkedin.android.pegasus.gen.voyager.entities.company;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class CareerImage
  implements FissileDataModel<CareerImage>, RecordTemplate<CareerImage>
{
  public static final CareerImageBuilder BUILDER = CareerImageBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasHeight;
  public final boolean hasImage;
  public final boolean hasUrl;
  public final boolean hasWidth;
  public final int height;
  public final Image image;
  public final String url;
  public final int width;
  
  CareerImage(Image paramImage, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    image = paramImage;
    url = paramString;
    height = paramInt1;
    width = paramInt2;
    hasImage = paramBoolean1;
    hasUrl = paramBoolean2;
    hasHeight = paramBoolean3;
    hasWidth = paramBoolean4;
    _cachedId = null;
  }
  
  public final CareerImage accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Image localImage = null;
    boolean bool = false;
    if (hasImage)
    {
      paramDataProcessor.startRecordField$505cff1c("image");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label168;
      }
      localImage = image.accept(paramDataProcessor);
      if (localImage == null) {
        break label185;
      }
    }
    label168:
    label185:
    for (bool = true;; bool = false)
    {
      if (hasUrl)
      {
        paramDataProcessor.startRecordField$505cff1c("url");
        paramDataProcessor.processString(url);
      }
      if (hasHeight)
      {
        paramDataProcessor.startRecordField$505cff1c("height");
        paramDataProcessor.processInt(height);
      }
      if (hasWidth)
      {
        paramDataProcessor.startRecordField$505cff1c("width");
        paramDataProcessor.processInt(width);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label224;
      }
      try
      {
        if (hasImage) {
          break label190;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.company.CareerImage", "image");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localImage = (Image)paramDataProcessor.processDataTemplate(image);
      break;
    }
    label190:
    return new CareerImage(localImage, url, height, width, bool, hasUrl, hasHeight, hasWidth);
    label224:
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
      paramObject = (CareerImage)paramObject;
      if (image != null)
      {
        if (image.equals(image)) {}
      }
      else {
        while (image != null) {
          return false;
        }
      }
      if (url != null)
      {
        if (url.equals(url)) {}
      }
      else {
        while (url != null) {
          return false;
        }
      }
      if (height != height) {
        return false;
      }
    } while (width == width);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasImage) {
      if (image._cachedId == null) {
        break label117;
      }
    }
    label117:
    for (i = PegasusBinaryUtils.getEncodedLength(image._cachedId) + 9;; i = image.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasUrl) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(url);
      }
      j = i + 1;
      i = j;
      if (hasHeight) {
        i = j + 4;
      }
      j = i + 1;
      i = j;
      if (hasWidth) {
        i = j + 4;
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (image != null) {}
    for (int i = image.hashCode();; i = 0)
    {
      if (url != null) {
        j = url.hashCode();
      }
      i = (((i + 527) * 31 + j) * 31 + height) * 31 + width;
      _cachedHashCode = i;
      return i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building CareerImage");
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
    label196:
    label220:
    label312:
    label322:
    label332:
    label340:
    label342:
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
        localByteBuffer.putInt(400796483);
        if (hasImage)
        {
          localByteBuffer.put((byte)1);
          if (image._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, image._cachedId);
            image.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasUrl) {
              break label312;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, url);
            if (!hasHeight) {
              break label322;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(height);
            if (!hasWidth) {
              break label332;
            }
            localByteBuffer.put((byte)1);
            localByteBuffer.putInt(width);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label340;
          }
          if (str != null) {
            break label342;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          image.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label196;
          localByteBuffer.put((byte)0);
          break label220;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.company.CareerImage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */