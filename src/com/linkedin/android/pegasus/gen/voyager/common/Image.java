package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionMemberCountException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class Image
  implements FissileDataModel<Image>, UnionTemplate<Image>
{
  public static final ImageBuilder BUILDER = ImageBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasMediaProcessorImageValue;
  public final boolean hasMediaProxyImageValue;
  public final boolean hasUrlValue;
  public final MediaProcessorImage mediaProcessorImageValue;
  public final MediaProxyImage mediaProxyImageValue;
  public final String urlValue;
  
  Image(MediaProcessorImage paramMediaProcessorImage, MediaProxyImage paramMediaProxyImage, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    mediaProcessorImageValue = paramMediaProcessorImage;
    mediaProxyImageValue = paramMediaProxyImage;
    urlValue = paramString;
    hasMediaProcessorImageValue = paramBoolean1;
    hasMediaProxyImageValue = paramBoolean2;
    hasUrlValue = paramBoolean3;
    _cachedId = null;
  }
  
  public final Image accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasMediaProcessorImageValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.common.MediaProcessorImage");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = mediaProcessorImageValue.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label182;
        }
        bool1 = true;
        localObject2 = localObject1;
      }
    }
    else
    {
      label56:
      localObject1 = null;
      bool2 = false;
      if (hasMediaProxyImageValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.common.MediaProxyImage");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label191;
        }
        localObject1 = mediaProxyImageValue.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label209;
        }
      }
    }
    label182:
    label191:
    label209:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasUrlValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("string");
        paramDataProcessor.processString(urlValue);
      }
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label214;
      }
      return new Image((MediaProcessorImage)localObject2, (MediaProxyImage)localObject1, urlValue, bool1, bool2, hasUrlValue);
      localObject1 = (MediaProcessorImage)paramDataProcessor.processDataTemplate(mediaProcessorImageValue);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (MediaProxyImage)paramDataProcessor.processDataTemplate(mediaProxyImageValue);
      break label95;
    }
    label214:
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
      paramObject = (Image)paramObject;
      if (mediaProcessorImageValue != null)
      {
        if (mediaProcessorImageValue.equals(mediaProcessorImageValue)) {}
      }
      else {
        while (mediaProcessorImageValue != null) {
          return false;
        }
      }
      if (mediaProxyImageValue != null)
      {
        if (mediaProxyImageValue.equals(mediaProxyImageValue)) {}
      }
      else {
        while (mediaProxyImageValue != null) {
          return false;
        }
      }
      if (urlValue == null) {
        break;
      }
    } while (urlValue.equals(urlValue));
    for (;;)
    {
      return false;
      if (urlValue == null) {
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
    int j;
    if (hasMediaProcessorImageValue)
    {
      if (mediaProcessorImageValue._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(mediaProcessorImageValue._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasMediaProxyImageValue)
      {
        i = j + 1;
        if (mediaProxyImageValue._cachedId == null) {
          break label139;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(mediaProxyImageValue._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasUrlValue) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(urlValue);
      }
      __sizeOfObject = i;
      return i;
      i = mediaProcessorImageValue.getSerializedSize() + 7;
      break;
      label139:
      i += mediaProxyImageValue.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (mediaProcessorImageValue != null)
    {
      i = mediaProcessorImageValue.hashCode();
      if (mediaProxyImageValue == null) {
        break label87;
      }
    }
    label87:
    for (int j = mediaProxyImageValue.hashCode();; j = 0)
    {
      if (urlValue != null) {
        k = urlValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Image");
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
    label324:
    label349:
    label359:
    label367:
    label369:
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
        localByteBuffer.putInt(-227258689);
        if (hasMediaProcessorImageValue)
        {
          localByteBuffer.put((byte)1);
          if (mediaProcessorImageValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, mediaProcessorImageValue._cachedId);
            mediaProcessorImageValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasMediaProxyImageValue) {
              break label349;
            }
            localByteBuffer.put((byte)1);
            if (mediaProxyImageValue._cachedId == null) {
              break label324;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, mediaProxyImageValue._cachedId);
            mediaProxyImageValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasUrlValue) {
              break label359;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, urlValue);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label367;
          }
          if (str != null) {
            break label369;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          mediaProcessorImageValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          mediaProxyImageValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break label230;
          localByteBuffer.put((byte)0);
          break label230;
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.Image
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */