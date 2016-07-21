package com.linkedin.crosspromo.fe.api.android;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.crosspromo.common.android.AnyRecord;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MetricsInfo
  implements FissileDataModel<MetricsInfo>, RecordTemplate<MetricsInfo>
{
  public static final MetricsInfoBuilder BUILDER = MetricsInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AnyRecord customInfo;
  public final boolean hasCustomInfo;
  public final boolean hasPageKeySuffix;
  public final String pageKeySuffix;
  
  MetricsInfo(String paramString, AnyRecord paramAnyRecord, boolean paramBoolean1, boolean paramBoolean2)
  {
    pageKeySuffix = paramString;
    customInfo = paramAnyRecord;
    hasPageKeySuffix = paramBoolean1;
    hasCustomInfo = paramBoolean2;
    _cachedId = null;
  }
  
  public final MetricsInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasPageKeySuffix)
    {
      paramDataProcessor.startRecordField$505cff1c("pageKeySuffix");
      paramDataProcessor.processString(pageKeySuffix);
    }
    AnyRecord localAnyRecord = null;
    boolean bool = false;
    if (hasCustomInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("customInfo");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label107;
      }
      localAnyRecord = customInfo.accept(paramDataProcessor);
      if (localAnyRecord == null) {
        break label124;
      }
    }
    label107:
    label124:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label129;
      }
      return new MetricsInfo(pageKeySuffix, localAnyRecord, hasPageKeySuffix, bool);
      localAnyRecord = (AnyRecord)paramDataProcessor.processDataTemplate(customInfo);
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
      paramObject = (MetricsInfo)paramObject;
      if (pageKeySuffix != null)
      {
        if (pageKeySuffix.equals(pageKeySuffix)) {}
      }
      else {
        while (pageKeySuffix != null) {
          return false;
        }
      }
      if (customInfo == null) {
        break;
      }
    } while (customInfo.equals(customInfo));
    for (;;)
    {
      return false;
      if (customInfo == null) {
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
    if (hasPageKeySuffix) {
      i = PegasusBinaryUtils.getEncodedLength(pageKeySuffix) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasCustomInfo) {
      i = j + 1 + customInfo.getSerializedSize();
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (pageKeySuffix != null) {}
    for (int i = pageKeySuffix.hashCode();; i = 0)
    {
      if (customInfo != null) {
        j = customInfo.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MetricsInfo");
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
    label215:
    label223:
    label225:
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
        localByteBuffer.putInt(-484054978);
        if (hasPageKeySuffix)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, pageKeySuffix);
          if (!hasCustomInfo) {
            break label215;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.put((byte)1);
          customInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label223;
          }
          if (str != null) {
            break label225;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
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
}

/* Location:
 * Qualified Name:     com.linkedin.crosspromo.fe.api.android.MetricsInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */