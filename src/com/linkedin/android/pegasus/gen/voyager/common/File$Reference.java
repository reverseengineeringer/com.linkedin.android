package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class File$Reference
  implements FissileDataModel<Reference>, UnionTemplate<Reference>
{
  public static final FileBuilder.ReferenceBuilder BUILDER = FileBuilder.ReferenceBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final boolean hasMediaProxyImageValue;
  public final boolean hasUrlValue;
  public final MediaProxyImage mediaProxyImageValue;
  public final String urlValue;
  
  public File$Reference(MediaProxyImage paramMediaProxyImage, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    mediaProxyImageValue = paramMediaProxyImage;
    urlValue = paramString;
    hasMediaProxyImageValue = paramBoolean1;
    hasUrlValue = paramBoolean2;
    _cachedId = null;
  }
  
  public final Reference accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startUnion();
    MediaProxyImage localMediaProxyImage = null;
    boolean bool = false;
    if (hasMediaProxyImageValue)
    {
      paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.common.MediaProxyImage");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label107;
      }
      localMediaProxyImage = mediaProxyImageValue.accept(paramDataProcessor);
      if (localMediaProxyImage == null) {
        break label124;
      }
    }
    label107:
    label124:
    for (bool = true;; bool = false)
    {
      if (hasUrlValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("string");
        paramDataProcessor.processString(urlValue);
      }
      paramDataProcessor.endUnion();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label129;
      }
      return new Reference(localMediaProxyImage, urlValue, bool, hasUrlValue);
      localMediaProxyImage = (MediaProxyImage)paramDataProcessor.processDataTemplate(mediaProxyImageValue);
      break;
    }
    label129:
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
      paramObject = (Reference)paramObject;
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
    if (hasMediaProxyImageValue) {
      if (mediaProxyImageValue._cachedId == null) {
        break label83;
      }
    }
    label83:
    for (i = PegasusBinaryUtils.getEncodedLength(mediaProxyImageValue._cachedId) + 9;; i = mediaProxyImageValue.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasUrlValue) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(urlValue);
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
    if (mediaProxyImageValue != null) {}
    for (int i = mediaProxyImageValue.hashCode();; i = 0)
    {
      if (urlValue != null) {
        j = urlValue.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Reference");
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
    label264:
    label272:
    label274:
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
        localByteBuffer.putInt(659354824);
        if (hasMediaProxyImageValue)
        {
          localByteBuffer.put((byte)1);
          if (mediaProxyImageValue._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, mediaProxyImageValue._cachedId);
            mediaProxyImageValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasUrlValue) {
              break label264;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, urlValue);
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label272;
          }
          if (str != null) {
            break label274;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          mediaProxyImageValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
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
    public boolean hasMediaProxyImageValue = false;
    public boolean hasUrlValue = false;
    public MediaProxyImage mediaProxyImageValue = null;
    public String urlValue = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.File.Reference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */