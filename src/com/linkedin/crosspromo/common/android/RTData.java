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

public final class RTData
  implements FissileDataModel<RTData>, RecordTemplate<RTData>
{
  public static final RTDataBuilder BUILDER = RTDataBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final List<RTAttribute> attribute;
  public final int endIdx;
  public final boolean hasAttribute;
  public final boolean hasEndIdx;
  public final boolean hasStartIdx;
  public final boolean hasType;
  public final int startIdx;
  public final String type;
  
  RTData(String paramString, int paramInt1, int paramInt2, List<RTAttribute> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    type = paramString;
    startIdx = paramInt1;
    endIdx = paramInt2;
    if (paramList == null) {}
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList))
    {
      attribute = paramString;
      hasType = paramBoolean1;
      hasStartIdx = paramBoolean2;
      hasEndIdx = paramBoolean3;
      hasAttribute = paramBoolean4;
      _cachedId = null;
      return;
    }
  }
  
  public final RTData accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processString(type);
    }
    if (hasStartIdx)
    {
      paramDataProcessor.startRecordField$505cff1c("startIdx");
      paramDataProcessor.processInt(startIdx);
    }
    if (hasEndIdx)
    {
      paramDataProcessor.startRecordField$505cff1c("endIdx");
      paramDataProcessor.processInt(endIdx);
    }
    Object localObject = null;
    RTAttribute localRTAttribute = null;
    boolean bool = false;
    if (hasAttribute)
    {
      paramDataProcessor.startRecordField$505cff1c("attribute");
      attribute.size();
      paramDataProcessor.startArray$13462e();
      localObject = localRTAttribute;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = attribute.iterator();
      if (localIterator.hasNext())
      {
        localRTAttribute = (RTAttribute)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localRTAttribute = localRTAttribute.accept(paramDataProcessor);; localRTAttribute = (RTAttribute)paramDataProcessor.processDataTemplate(localRTAttribute))
        {
          if ((localObject != null) && (localRTAttribute != null)) {
            ((List)localObject).add(localRTAttribute);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label307;
      }
    }
    label307:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break;
      }
      return new RTData(type, startIdx, endIdx, (List)localObject, hasType, hasStartIdx, hasEndIdx, bool);
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
      paramObject = (RTData)paramObject;
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (startIdx != startIdx) {
        return false;
      }
      if (endIdx != endIdx) {
        return false;
      }
      if (attribute == null) {
        break;
      }
    } while (attribute.equals(attribute));
    for (;;)
    {
      return false;
      if (attribute == null) {
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
    if (hasType) {
      i = PegasusBinaryUtils.getEncodedLength(type) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasStartIdx) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasEndIdx) {
      i = j + 4;
    }
    i += 1;
    j = i;
    if (hasAttribute)
    {
      i += 2;
      Iterator localIterator = attribute.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        RTAttribute localRTAttribute = (RTAttribute)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localRTAttribute.getSerializedSize();
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
    if (type != null) {}
    for (int i = type.hashCode();; i = 0)
    {
      int k = startIdx;
      int m = endIdx;
      if (attribute != null) {
        j = attribute.hashCode();
      }
      i = (((i + 527) * 31 + k) * 31 + m) * 31 + j;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building RTData");
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
    label184:
    label301:
    label311:
    label344:
    label351:
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
        localByteBuffer.putInt(-166200955);
        Iterator localIterator;
        if (hasType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, type);
          if (!hasStartIdx) {
            break label301;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(startIdx);
          if (!hasEndIdx) {
            break label311;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(endIdx);
          if (!hasAttribute) {
            break label344;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, attribute.size());
          localIterator = attribute.iterator();
        }
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label351;
          }
          RTAttribute localRTAttribute = (RTAttribute)localIterator.next();
          if (_cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, _cachedId);
            localRTAttribute.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            continue;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)0);
            break label160;
            localByteBuffer.put((byte)0);
            break label184;
          }
          localByteBuffer.put((byte)1);
          localRTAttribute.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.crosspromo.common.android.RTData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */