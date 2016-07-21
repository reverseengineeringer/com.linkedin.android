package com.linkedin.android.pegasus.gen.voyager.feed.urlpreview;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class PreviewCreationSuccessful
  implements FissileDataModel<PreviewCreationSuccessful>, RecordTemplate<PreviewCreationSuccessful>
{
  public static final PreviewCreationSuccessfulBuilder BUILDER = PreviewCreationSuccessfulBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final UrlPreviewData data;
  public final boolean hasData;
  
  PreviewCreationSuccessful(UrlPreviewData paramUrlPreviewData, boolean paramBoolean)
  {
    data = paramUrlPreviewData;
    hasData = paramBoolean;
    _cachedId = null;
  }
  
  public final PreviewCreationSuccessful accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    UrlPreviewData localUrlPreviewData = null;
    boolean bool = false;
    if (hasData)
    {
      paramDataProcessor.startRecordField$505cff1c("data");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label93;
      }
      localUrlPreviewData = data.accept(paramDataProcessor);
      if (localUrlPreviewData == null) {
        break label110;
      }
    }
    label93:
    label110:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label125;
      }
      try
      {
        if (hasData) {
          break label115;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.PreviewCreationSuccessful", "data");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localUrlPreviewData = (UrlPreviewData)paramDataProcessor.processDataTemplate(data);
      break;
    }
    label115:
    return new PreviewCreationSuccessful(localUrlPreviewData, bool);
    label125:
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
      paramObject = (PreviewCreationSuccessful)paramObject;
      if (data == null) {
        break;
      }
    } while (data.equals(data));
    for (;;)
    {
      return false;
      if (data == null) {
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
    if (hasData) {
      if (data._cachedId == null) {
        break label58;
      }
    }
    label58:
    for (i = PegasusBinaryUtils.getEncodedLength(data._cachedId) + 9;; i = data.getSerializedSize() + 7)
    {
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (data != null) {}
    for (int i = data.hashCode();; i = 0)
    {
      i += 527;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PreviewCreationSuccessful");
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
    label238:
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
        localByteBuffer.putInt(-1652758961);
        if (hasData)
        {
          localByteBuffer.put((byte)1);
          if (data._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, data._cachedId);
            data.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
          }
        }
        while (paramByteBuffer == null)
        {
          if (str != null) {
            break label238;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          data.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.PreviewCreationSuccessful
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */