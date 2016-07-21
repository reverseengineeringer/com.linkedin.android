package com.linkedin.android.pegasus.gen.batch;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.restli.common.ErrorResponse;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class BatchGet<RESULT extends FissileDataModel<RESULT>>
  implements FissileDataModel<BatchGet<RESULT>>, RecordTemplate<BatchGet<RESULT>>
{
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final Map<String, ErrorResponse> errors;
  public final boolean hasErrors;
  public final boolean hasResults;
  public final boolean hasStatuses;
  public final Map<String, RESULT> results;
  public final Map<String, Integer> statuses;
  
  BatchGet(Map<String, RESULT> paramMap, Map<String, Integer> paramMap1, Map<String, ErrorResponse> paramMap2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramMap == null)
    {
      paramMap = null;
      results = paramMap;
      if (paramMap1 != null) {
        break label79;
      }
      paramMap = null;
      label31:
      statuses = paramMap;
      if (paramMap2 != null) {
        break label87;
      }
    }
    label79:
    label87:
    for (paramMap = null;; paramMap = Collections.unmodifiableMap(paramMap2))
    {
      errors = paramMap;
      hasResults = paramBoolean1;
      hasStatuses = paramBoolean2;
      hasErrors = paramBoolean3;
      _cachedId = null;
      return;
      paramMap = Collections.unmodifiableMap(paramMap);
      break;
      paramMap = Collections.unmodifiableMap(paramMap1);
      break label31;
    }
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
      paramObject = (BatchGet)paramObject;
      if (results != null)
      {
        if (results.equals(results)) {}
      }
      else {
        while (results != null) {
          return false;
        }
      }
      if (statuses != null)
      {
        if (statuses.equals(statuses)) {}
      }
      else {
        while (statuses != null) {
          return false;
        }
      }
      if (errors == null) {
        break;
      }
    } while (errors.equals(errors));
    for (;;)
    {
      return false;
      if (errors == null) {
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
    int j = i;
    Iterator localIterator;
    Object localObject;
    if (hasResults)
    {
      i += 2;
      localIterator = results.entrySet().iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        j = PegasusBinaryUtils.getEncodedLength((String)((Map.Entry)localObject).getKey());
        localObject = (FissileDataModel)((Map.Entry)localObject).getValue();
        i = i + 2 + j + 1;
        if (((FissileDataModel)localObject).id() != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(((FissileDataModel)localObject).id());
        } else {
          i += ((FissileDataModel)localObject).getSerializedSize();
        }
      }
    }
    i = j + 1;
    j = i;
    if (hasStatuses)
    {
      i += 2;
      localIterator = statuses.entrySet().iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        j = PegasusBinaryUtils.getEncodedLength((String)((Map.Entry)localObject).getKey());
        ((Map.Entry)localObject).getValue();
        i = i + 2 + j + 4;
      }
    }
    i = j + 1;
    j = i;
    if (hasErrors)
    {
      i += 2;
      localIterator = errors.entrySet().iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (Map.Entry)localIterator.next();
        j = PegasusBinaryUtils.getEncodedLength((String)((Map.Entry)localObject).getKey());
        localObject = (ErrorResponse)((Map.Entry)localObject).getValue();
        i = i + 2 + j + 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += ((ErrorResponse)localObject).getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (results != null)
    {
      i = results.hashCode();
      if (statuses == null) {
        break label93;
      }
    }
    label93:
    for (int j = statuses.hashCode();; j = 0)
    {
      if (errors != null) {
        k = errors.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building BatchGet");
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
        localByteBuffer.putInt(-1803013860);
        Iterator localIterator;
        Object localObject;
        if (hasResults)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, results.size());
          localIterator = results.entrySet().iterator();
          while (localIterator.hasNext())
          {
            localObject = (Map.Entry)localIterator.next();
            paramFissionAdapter.writeString(localByteBuffer, (String)((Map.Entry)localObject).getKey());
            localObject = (FissileDataModel)((Map.Entry)localObject).getValue();
            if (((FissileDataModel)localObject).id() != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, ((FissileDataModel)localObject).id());
              ((FissileDataModel)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((FissileDataModel)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
          }
        }
        localByteBuffer.put((byte)0);
        if (hasStatuses)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, statuses.size());
          localIterator = statuses.entrySet().iterator();
          while (localIterator.hasNext())
          {
            localObject = (Map.Entry)localIterator.next();
            paramFissionAdapter.writeString(localByteBuffer, (String)((Map.Entry)localObject).getKey());
            localByteBuffer.putInt(((Integer)((Map.Entry)localObject).getValue()).intValue());
          }
        }
        localByteBuffer.put((byte)0);
        if (hasErrors)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, errors.size());
          localIterator = errors.entrySet().iterator();
          while (localIterator.hasNext())
          {
            localObject = (Map.Entry)localIterator.next();
            paramFissionAdapter.writeString(localByteBuffer, (String)((Map.Entry)localObject).getKey());
            localObject = (ErrorResponse)((Map.Entry)localObject).getValue();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              ((ErrorResponse)localObject).writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            }
            else
            {
              localByteBuffer.put((byte)1);
              ((ErrorResponse)localObject).writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            }
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.batch.BatchGet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */