package com.linkedin.android.pegasus.gen.voyager.common;

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

public final class MediaProxyImage
  implements FissileDataModel<MediaProxyImage>, RecordTemplate<MediaProxyImage>
{
  public static final MediaProxyImageBuilder BUILDER = MediaProxyImageBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasOriginalHeight;
  public final boolean hasOriginalWidth;
  public final boolean hasUrl;
  public final int originalHeight;
  public final int originalWidth;
  public final String url;
  
  MediaProxyImage(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    url = paramString;
    originalWidth = paramInt1;
    originalHeight = paramInt2;
    hasUrl = paramBoolean1;
    hasOriginalWidth = paramBoolean2;
    hasOriginalHeight = paramBoolean3;
    _cachedId = null;
  }
  
  public final MediaProxyImage accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasUrl)
    {
      paramDataProcessor.startRecordField$505cff1c("url");
      paramDataProcessor.processString(url);
    }
    if (hasOriginalWidth)
    {
      paramDataProcessor.startRecordField$505cff1c("originalWidth");
      paramDataProcessor.processInt(originalWidth);
    }
    if (hasOriginalHeight)
    {
      paramDataProcessor.startRecordField$505cff1c("originalHeight");
      paramDataProcessor.processInt(originalHeight);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasUrl) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage", "url");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new MediaProxyImage(url, originalWidth, originalHeight, hasUrl, hasOriginalWidth, hasOriginalHeight);
    }
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
      paramObject = (MediaProxyImage)paramObject;
      if (url != null)
      {
        if (url.equals(url)) {}
      }
      else {
        while (url != null) {
          return false;
        }
      }
      if (originalWidth != originalWidth) {
        return false;
      }
    } while (originalHeight == originalHeight);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasUrl) {
      i = PegasusBinaryUtils.getEncodedLength(url) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasOriginalWidth) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasOriginalHeight) {
      i = j + 4;
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (url != null) {}
    for (int i = url.hashCode();; i = 0)
    {
      i = ((i + 527) * 31 + originalWidth) * 31 + originalHeight;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MediaProxyImage");
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
    label160:
    label227:
    label237:
    label245:
    label247:
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
        localByteBuffer.putInt(-1561552235);
        if (hasUrl)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, url);
          if (!hasOriginalWidth) {
            break label227;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(originalWidth);
          if (!hasOriginalHeight) {
            break label237;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(originalHeight);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label245;
          }
          if (str != null) {
            break label247;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label160;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */