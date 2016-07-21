package com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.voyager.common.Duration;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.UnionTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class OverlapInfo
  implements FissileDataModel<OverlapInfo>, RecordTemplate<OverlapInfo>
{
  public static final OverlapInfoBuilder BUILDER = OverlapInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final Detail detail;
  public final boolean hasDetail;
  public final boolean hasOverlapDetail;
  public final boolean hasOverlapType;
  public final OverlapDetail overlapDetail;
  public final OverlapType overlapType;
  
  OverlapInfo(Detail paramDetail, OverlapDetail paramOverlapDetail, OverlapType paramOverlapType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    detail = paramDetail;
    overlapDetail = paramOverlapDetail;
    overlapType = paramOverlapType;
    hasDetail = paramBoolean1;
    hasOverlapDetail = paramBoolean2;
    hasOverlapType = paramBoolean3;
    _cachedId = null;
  }
  
  public final OverlapInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    Object localObject2 = null;
    boolean bool1 = false;
    Object localObject1;
    if (hasDetail)
    {
      paramDataProcessor.startRecordField$505cff1c("detail");
      if (paramDataProcessor.shouldAcceptTransitively())
      {
        localObject1 = detail.accept(paramDataProcessor);
        if (localObject1 == null) {
          break label189;
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
      if (hasOverlapDetail)
      {
        paramDataProcessor.startRecordField$505cff1c("overlapDetail");
        if (!paramDataProcessor.shouldAcceptTransitively()) {
          break label198;
        }
        localObject1 = overlapDetail.accept(paramDataProcessor);
        label95:
        if (localObject1 == null) {
          break label216;
        }
      }
    }
    label189:
    label198:
    label216:
    for (boolean bool2 = true;; bool2 = false)
    {
      if (hasOverlapType)
      {
        paramDataProcessor.startRecordField$505cff1c("overlapType");
        paramDataProcessor.processEnum(overlapType);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label281;
      }
      try
      {
        if (hasDetail) {
          break label221;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.OverlapInfo", "detail");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      localObject1 = (Detail)paramDataProcessor.processDataTemplate(detail);
      break;
      bool1 = false;
      localObject2 = localObject1;
      break label56;
      localObject1 = (OverlapDetail)paramDataProcessor.processDataTemplate(overlapDetail);
      break label95;
    }
    label221:
    if (!hasOverlapDetail) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.OverlapInfo", "overlapDetail");
    }
    if (!hasOverlapType) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.OverlapInfo", "overlapType");
    }
    return new OverlapInfo((Detail)localObject2, (OverlapDetail)localObject1, overlapType, bool1, bool2, hasOverlapType);
    label281:
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
      paramObject = (OverlapInfo)paramObject;
      if (detail != null)
      {
        if (detail.equals(detail)) {}
      }
      else {
        while (detail != null) {
          return false;
        }
      }
      if (overlapDetail != null)
      {
        if (overlapDetail.equals(overlapDetail)) {}
      }
      else {
        while (overlapDetail != null) {
          return false;
        }
      }
      if (overlapType == null) {
        break;
      }
    } while (overlapType.equals(overlapType));
    for (;;)
    {
      return false;
      if (overlapType == null) {
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
    if (hasDetail)
    {
      if (detail._cachedId != null) {
        i = PegasusBinaryUtils.getEncodedLength(detail._cachedId) + 9;
      }
    }
    else
    {
      j = i + 1;
      i = j;
      if (hasOverlapDetail)
      {
        i = j + 1;
        if (overlapDetail._cachedId == null) {
          break label131;
        }
        i = i + 2 + PegasusBinaryUtils.getEncodedLength(overlapDetail._cachedId);
      }
    }
    for (;;)
    {
      j = i + 1;
      i = j;
      if (hasOverlapType) {
        i = j + 2;
      }
      __sizeOfObject = i;
      return i;
      i = detail.getSerializedSize() + 7;
      break;
      label131:
      i += overlapDetail.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (detail != null)
    {
      i = detail.hashCode();
      if (overlapDetail == null) {
        break label87;
      }
    }
    label87:
    for (int j = overlapDetail.hashCode();; j = 0)
    {
      if (overlapType != null) {
        k = overlapType.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building OverlapInfo");
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
    label327:
    label352:
    label362:
    label370:
    label372:
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
        localByteBuffer.putInt(-13678438);
        if (hasDetail)
        {
          localByteBuffer.put((byte)1);
          if (detail._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, detail._cachedId);
            detail.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasOverlapDetail) {
              break label352;
            }
            localByteBuffer.put((byte)1);
            if (overlapDetail._cachedId == null) {
              break label327;
            }
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, overlapDetail._cachedId);
            overlapDetail.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasOverlapType) {
              break label362;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, overlapType.ordinal());
          }
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label370;
          }
          if (str != null) {
            break label372;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)1);
          detail.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          overlapDetail.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Detail
    implements FissileDataModel<Detail>, UnionTemplate<Detail>
  {
    public static final OverlapInfoBuilder.DetailBuilder BUILDER = OverlapInfoBuilder.DetailBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final com.linkedin.android.pegasus.gen.common.DateRange dateRangeValue;
    public final Duration durationValue;
    public final boolean hasDateRangeValue;
    public final boolean hasDurationValue;
    
    Detail(com.linkedin.android.pegasus.gen.common.DateRange paramDateRange, Duration paramDuration, boolean paramBoolean1, boolean paramBoolean2)
    {
      dateRangeValue = paramDateRange;
      durationValue = paramDuration;
      hasDateRangeValue = paramBoolean1;
      hasDurationValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final Detail accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasDateRangeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.common.DateRange");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = dateRangeValue.accept(paramDataProcessor);
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
        if (hasDurationValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.common.Duration");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label158;
          }
          localObject1 = durationValue.accept(paramDataProcessor);
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
        return new Detail((com.linkedin.android.pegasus.gen.common.DateRange)localObject2, (Duration)localObject1, bool1, bool2);
        localObject1 = (com.linkedin.android.pegasus.gen.common.DateRange)paramDataProcessor.processDataTemplate(dateRangeValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (Duration)paramDataProcessor.processDataTemplate(durationValue);
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
        paramObject = (Detail)paramObject;
        if (dateRangeValue != null)
        {
          if (dateRangeValue.equals(dateRangeValue)) {}
        }
        else {
          while (dateRangeValue != null) {
            return false;
          }
        }
        if (durationValue == null) {
          break;
        }
      } while (durationValue.equals(durationValue));
      for (;;)
      {
        return false;
        if (durationValue == null) {
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
      if (hasDateRangeValue)
      {
        if (dateRangeValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(dateRangeValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasDurationValue)
        {
          i = j + 1;
          if (durationValue._cachedId == null) {
            break label114;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(durationValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = dateRangeValue.getSerializedSize() + 7;
        break;
        label114:
        i += durationValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (dateRangeValue != null) {}
      for (int i = dateRangeValue.hashCode();; i = 0)
      {
        if (durationValue != null) {
          j = durationValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Detail");
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
          localByteBuffer.putInt(-1551265394);
          if (hasDateRangeValue)
          {
            localByteBuffer.put((byte)1);
            if (dateRangeValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, dateRangeValue._cachedId);
              dateRangeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasDurationValue) {
                break label323;
              }
              localByteBuffer.put((byte)1);
              if (durationValue._cachedId == null) {
                break label298;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, durationValue._cachedId);
              durationValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            dateRangeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            durationValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class OverlapDetail
    implements FissileDataModel<OverlapDetail>, UnionTemplate<OverlapDetail>
  {
    public static final OverlapInfoBuilder.OverlapDetailBuilder BUILDER = OverlapInfoBuilder.OverlapDetailBuilder.INSTANCE;
    private volatile int __sizeOfObject = -1;
    private volatile int _cachedHashCode = -1;
    final String _cachedId;
    public final com.linkedin.android.pegasus.gen.voyager.common.DateRange dateRangeValue;
    public final Duration durationValue;
    public final boolean hasDateRangeValue;
    public final boolean hasDurationValue;
    
    OverlapDetail(com.linkedin.android.pegasus.gen.voyager.common.DateRange paramDateRange, Duration paramDuration, boolean paramBoolean1, boolean paramBoolean2)
    {
      dateRangeValue = paramDateRange;
      durationValue = paramDuration;
      hasDateRangeValue = paramBoolean1;
      hasDurationValue = paramBoolean2;
      _cachedId = null;
    }
    
    public final OverlapDetail accept(DataProcessor paramDataProcessor)
      throws DataProcessorException
    {
      paramDataProcessor.startUnion();
      Object localObject2 = null;
      boolean bool1 = false;
      Object localObject1;
      if (hasDateRangeValue)
      {
        paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.common.DateRange");
        if (paramDataProcessor.shouldAcceptTransitively())
        {
          localObject1 = dateRangeValue.accept(paramDataProcessor);
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
        if (hasDurationValue)
        {
          paramDataProcessor.startUnionMember$505cff1c("com.linkedin.voyager.common.Duration");
          if (!paramDataProcessor.shouldAcceptTransitively()) {
            break label158;
          }
          localObject1 = durationValue.accept(paramDataProcessor);
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
        return new OverlapDetail((com.linkedin.android.pegasus.gen.voyager.common.DateRange)localObject2, (Duration)localObject1, bool1, bool2);
        localObject1 = (com.linkedin.android.pegasus.gen.voyager.common.DateRange)paramDataProcessor.processDataTemplate(dateRangeValue);
        break;
        bool1 = false;
        localObject2 = localObject1;
        break label56;
        localObject1 = (Duration)paramDataProcessor.processDataTemplate(durationValue);
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
        paramObject = (OverlapDetail)paramObject;
        if (dateRangeValue != null)
        {
          if (dateRangeValue.equals(dateRangeValue)) {}
        }
        else {
          while (dateRangeValue != null) {
            return false;
          }
        }
        if (durationValue == null) {
          break;
        }
      } while (durationValue.equals(durationValue));
      for (;;)
      {
        return false;
        if (durationValue == null) {
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
      if (hasDateRangeValue)
      {
        if (dateRangeValue._cachedId != null) {
          i = PegasusBinaryUtils.getEncodedLength(dateRangeValue._cachedId) + 9;
        }
      }
      else
      {
        int j = i + 1;
        i = j;
        if (hasDurationValue)
        {
          i = j + 1;
          if (durationValue._cachedId == null) {
            break label114;
          }
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(durationValue._cachedId);
        }
      }
      for (;;)
      {
        __sizeOfObject = i;
        return i;
        i = dateRangeValue.getSerializedSize() + 7;
        break;
        label114:
        i += durationValue.getSerializedSize();
      }
    }
    
    public final int hashCode()
    {
      int j = 0;
      if (_cachedHashCode > 0) {
        return _cachedHashCode;
      }
      if (dateRangeValue != null) {}
      for (int i = dateRangeValue.hashCode();; i = 0)
      {
        if (durationValue != null) {
          j = durationValue.hashCode();
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
        throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building OverlapDetail");
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
          localByteBuffer.putInt(-1661223226);
          if (hasDateRangeValue)
          {
            localByteBuffer.put((byte)1);
            if (dateRangeValue._cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, dateRangeValue._cachedId);
              dateRangeValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              if (!hasDurationValue) {
                break label323;
              }
              localByteBuffer.put((byte)1);
              if (durationValue._cachedId == null) {
                break label298;
              }
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, durationValue._cachedId);
              durationValue.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
            dateRangeValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
            break;
            localByteBuffer.put((byte)0);
            break;
            localByteBuffer.put((byte)1);
            durationValue.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.OverlapInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */