package com.linkedin.crosspromo.common.android;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class RichText
  implements FissileDataModel<RichText>, RecordTemplate<RichText>
{
  public static final RichTextBuilder BUILDER = RichTextBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final boolean hasRawText;
  public final boolean hasRtData;
  public final String rawText;
  public final List<RTData> rtData;
  
  RichText(String paramString, List<RTData> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    rawText = paramString;
    if (paramList == null) {}
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList))
    {
      rtData = paramString;
      hasRawText = paramBoolean1;
      hasRtData = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final RichText accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasRawText)
    {
      paramDataProcessor.startRecordField$505cff1c("rawText");
      paramDataProcessor.processString(rawText);
    }
    Object localObject = null;
    RTData localRTData = null;
    boolean bool = false;
    if (hasRtData)
    {
      paramDataProcessor.startRecordField$505cff1c("rtData");
      rtData.size();
      paramDataProcessor.startArray$13462e();
      localObject = localRTData;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = rtData.iterator();
      if (localIterator.hasNext())
      {
        localRTData = (RTData)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localRTData = localRTData.accept(paramDataProcessor);; localRTData = (RTData)paramDataProcessor.processDataTemplate(localRTData))
        {
          if ((localObject != null) && (localRTData != null)) {
            ((List)localObject).add(localRTData);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label241;
      }
    }
    label241:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break;
      }
      return new RichText(rawText, (List)localObject, hasRawText, bool);
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
      paramObject = (RichText)paramObject;
      if (rawText != null)
      {
        if (rawText.equals(rawText)) {}
      }
      else {
        while (rawText != null) {
          return false;
        }
      }
      if (rtData == null) {
        break;
      }
    } while (rtData.equals(rtData));
    for (;;)
    {
      return false;
      if (rtData == null) {
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
    if (hasRawText) {
      i = PegasusBinaryUtils.getEncodedLength(rawText) + 8;
    }
    i += 1;
    int j = i;
    if (hasRtData)
    {
      i += 2;
      Iterator localIterator = rtData.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        RTData localRTData = (RTData)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localRTData.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (rawText != null) {}
    for (int i = rawText.hashCode();; i = 0)
    {
      if (rtData != null) {
        j = rtData.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building RichText");
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
    label283:
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(-1707688080);
        Iterator localIterator;
        if (hasRawText)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, rawText);
          if (hasRtData)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, rtData.size());
            localIterator = rtData.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label283;
            }
            RTData localRTData = (RTData)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localRTData.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            localRTData.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
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
 * Qualified Name:     com.linkedin.crosspromo.common.android.RichText
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */