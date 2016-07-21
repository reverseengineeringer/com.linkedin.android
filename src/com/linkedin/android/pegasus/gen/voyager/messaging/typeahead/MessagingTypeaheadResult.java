package com.linkedin.android.pegasus.gen.voyager.messaging.typeahead;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MessagingTypeaheadResult
  implements FissileDataModel<MessagingTypeaheadResult>, RecordTemplate<MessagingTypeaheadResult>
{
  public static final MessagingTypeaheadResultBuilder BUILDER = MessagingTypeaheadResultBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasHitInfo;
  public final HitInfo hitInfo;
  
  MessagingTypeaheadResult(HitInfo paramHitInfo, boolean paramBoolean)
  {
    hitInfo = paramHitInfo;
    hasHitInfo = paramBoolean;
    _cachedId = null;
  }
  
  private MessagingTypeaheadResult accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    HitInfo localHitInfo = null;
    boolean bool = false;
    if (hasHitInfo)
    {
      paramDataProcessor.startRecordField$505cff1c("hitInfo");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label93;
      }
      localHitInfo = hitInfo.accept(paramDataProcessor);
      if (localHitInfo == null) {
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
        if (hasHitInfo) {
          break label115;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.typeahead.MessagingTypeaheadResult", "hitInfo");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localHitInfo = (HitInfo)paramDataProcessor.processDataTemplate(hitInfo);
      break;
    }
    label115:
    return new MessagingTypeaheadResult(localHitInfo, bool);
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
      paramObject = (MessagingTypeaheadResult)paramObject;
      if (hitInfo == null) {
        break;
      }
    } while (hitInfo.equals(hitInfo));
    for (;;)
    {
      return false;
      if (hitInfo == null) {
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
    if (hasHitInfo) {
      if (hitInfo._cachedId == null) {
        break label58;
      }
    }
    label58:
    for (i = PegasusBinaryUtils.getEncodedLength(hitInfo._cachedId) + 9;; i = hitInfo.getSerializedSize() + 7)
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
    if (hitInfo != null) {}
    for (int i = hitInfo.hashCode();; i = 0)
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MessagingTypeaheadResult");
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
        localByteBuffer.putInt(-1847863824);
        if (hasHitInfo)
        {
          localByteBuffer.put((byte)1);
          if (hitInfo._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, hitInfo._cachedId);
            hitInfo.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          hitInfo.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class HitInfo
    implements FissileDataModel<HitInfo>, UnionTemplate<HitInfo>
  {
    public static final MessagingTypeaheadResultBuilder.HitInfoBuilder BUILDER = MessagingTypeaheadResultBuilder.HitInfoBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final boolean hasThreadTypeaheadResultValue;
    public final boolean hasTypeaheadHitValue;
    public final ThreadTypeaheadResult threadTypeaheadResultValue;
    public final TypeaheadHit typeaheadHitValue;
    
    HitInfo(ThreadTypeaheadResult paramThreadTypeaheadResult, TypeaheadHit paramTypeaheadHit, boolean paramBoolean1, boolean paramBoolean2)
    {
      threadTypeaheadResultValue = paramThreadTypeaheadResult;
      typeaheadHitValue = paramTypeaheadHit;
      hasThreadTypeaheadResultValue = paramBoolean1;
      hasTypeaheadHitValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final HitInfo accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasThreadTypeaheadResultValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.messaging.typeahead.ThreadTypeaheadResult");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = threadTypeaheadResultValue.accept(paramDataProcessor);
          if (localObject1 == null) {
            break label149;
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
        if (hasTypeaheadHitValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.typeahead.TypeaheadHit");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label158;
          }
          localObject1 = typeaheadHitValue.accept(paramDataProcessor);
          label95:
          if (localObject1 == null) {
            break label176;
          }
        }
      }
      label149:
      label158:
      label176:
      for (boolean bool2 = true;; bool2 = false)
      {
        paramDataProcessor.endUnion();
        if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
          break label181;
        }
        return new HitInfo((ThreadTypeaheadResult)localObject2, (TypeaheadHit)localObject1, bool1, bool2);
        localObject1 = (ThreadTypeaheadResult)paramDataProcessor.processDataTemplate(threadTypeaheadResultValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (TypeaheadHit)paramDataProcessor.processDataTemplate(typeaheadHitValue);
        break label95;
      }
      label181:
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
        paramObject = (HitInfo)paramObject;
        if (threadTypeaheadResultValue != null)
        {
          if (threadTypeaheadResultValue.equals(threadTypeaheadResultValue)) {}
        }
        else {
          while (threadTypeaheadResultValue != null) {
            return false;
          }
        }
        if (typeaheadHitValue == null) {
          break;
        }
      } while (typeaheadHitValue.equals(typeaheadHitValue));
      for (;;)
      {
        return false;
        if (typeaheadHitValue == null) {
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
      if (hasThreadTypeaheadResultValue)
      {
        if (threadTypeaheadResultValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(threadTypeaheadResultValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasTypeaheadHitValue)
        {
          i = j + 1;
          if (typeaheadHitValue._cachedId == null) {
            break label114;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(typeaheadHitValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = threadTypeaheadResultValue.getSerializedSize() + 7;
        break;
        label114:
        i += typeaheadHitValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (threadTypeaheadResultValue != null) {}
      for (int i = threadTypeaheadResultValue.hashCode();; i = 0)
      {
        if (typeaheadHitValue != null) {
          j = typeaheadHitValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building HitInfo");
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
          localByteBuffer.putInt(638930401);
          if (hasThreadTypeaheadResultValue)
          {
            localByteBuffer.put((byte)1);
            if (threadTypeaheadResultValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, threadTypeaheadResultValue._cachedId);
              threadTypeaheadResultValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasTypeaheadHitValue) {
                break label323;
              }
              localByteBuffer.put((byte)1);
              if (typeaheadHitValue._cachedId == null) {
                break label298;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, typeaheadHitValue._cachedId);
              typeaheadHitValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            threadTypeaheadResultValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            typeaheadHitValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.typeahead.MessagingTypeaheadResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */