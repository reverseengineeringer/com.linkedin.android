package com.linkedin.android.pegasus.gen.voyager.feed.urlpreview;

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
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class PreviewImage
  implements FissileDataModel<PreviewImage>, RecordTemplate<PreviewImage>
{
  public static final PreviewImageBuilder BUILDER = PreviewImageBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasMediaProxyImage;
  public final boolean hasOriginalImage;
  public final Image mediaProxyImage;
  public final Image originalImage;
  
  PreviewImage(Image paramImage1, Image paramImage2, boolean paramBoolean1, boolean paramBoolean2)
  {
    originalImage = paramImage1;
    mediaProxyImage = paramImage2;
    hasOriginalImage = paramBoolean1;
    hasMediaProxyImage = paramBoolean2;
    _cachedId = null;
  }
  
  public final PreviewImage accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject = null;
    boolean bool1 = false;
    Image localImage;
    if (hasOriginalImage)
    {
      paramDataProcessor.startRecordField$505cff1c("originalImage");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localImage = originalImage.accept(paramDataProcessor);
        if (localImage == null) {
          break label164;
        }
        bool1 = true;
        localObject = localImage;
      }
    }
    else
    {
      label56:
      localImage = null;
      bool2 = false;
      if (hasMediaProxyImage)
      {
        paramDataProcessor.startRecordField$505cff1c("mediaProxyImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label173;
        }
        localImage = mediaProxyImage.accept(paramDataProcessor);
        label95:
        if (localImage == null) {
          break label191;
        }
      }
    }
    label164:
    label173:
    label191:
    for (boolean bool2 = true;; bool2 = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label229;
      }
      try
      {
        if (hasOriginalImage) {
          break label196;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.PreviewImage", "originalImage");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localImage = (Image)paramDataProcessor.processDataTemplate(originalImage);
      break;
      bool1 = false;
      localObject = localImage;
      break label56;
      localImage = (Image)paramDataProcessor.processDataTemplate(mediaProxyImage);
      break label95;
    }
    label196:
    if (!hasMediaProxyImage) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.PreviewImage", "mediaProxyImage");
    }
    return new PreviewImage((Image)localObject, localImage, bool1, bool2);
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
      paramObject = (PreviewImage)paramObject;
      if (originalImage != null)
      {
        if (originalImage.equals(originalImage)) {}
      }
      else {
        while (originalImage != null) {
          return false;
        }
      }
      if (mediaProxyImage == null) {
        break;
      }
    } while (mediaProxyImage.equals(mediaProxyImage));
    for (;;)
    {
      return false;
      if (mediaProxyImage == null) {
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
      if (hasMediaProxyImage)
      {
        i = j + 1;
        if (mediaProxyImage._cachedId == null) {
          break label114;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(mediaProxyImage._cachedId);
      }
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      i = originalImage.getSerializedSize() + 7;
      break;
      label114:
      i += mediaProxyImage.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (originalImage != null) {}
    for (int i = originalImage.hashCode();; i = 0)
    {
      if (mediaProxyImage != null) {
        j = mediaProxyImage.hashCode();
      }
      i = (i + 527) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PreviewImage");
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
    label298:
    label323:
    label331:
    label333:
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
        localByteBuffer.putInt(-528286363);
        if (hasOriginalImage)
        {
          localByteBuffer.put((byte)1);
          if (originalImage._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, originalImage._cachedId);
            originalImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMediaProxyImage) {
              break label323;
            }
            localByteBuffer.put((byte)1);
            if (mediaProxyImage._cachedId == null) {
              break label298;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, mediaProxyImage._cachedId);
            mediaProxyImage.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label331;
          }
          if (str != null) {
            break label333;
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
          mediaProxyImage.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.PreviewImage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */