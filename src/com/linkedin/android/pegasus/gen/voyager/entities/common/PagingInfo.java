package com.linkedin.android.pegasus.gen.voyager.entities.common;

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

public final class PagingInfo
  implements FissileDataModel<PagingInfo>, RecordTemplate<PagingInfo>
{
  public static final PagingInfoBuilder BUILDER = PagingInfoBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  public final String _cachedId;
  public final int count;
  public final boolean hasCount;
  public final boolean hasStart;
  public final boolean hasTotal;
  public final int start;
  public final int total;
  
  PagingInfo(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    start = paramInt1;
    count = paramInt2;
    total = paramInt3;
    hasStart = paramBoolean1;
    hasCount = paramBoolean2;
    hasTotal = paramBoolean3;
    _cachedId = null;
  }
  
  public final PagingInfo accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasStart)
    {
      paramDataProcessor.startRecordField$505cff1c("start");
      paramDataProcessor.processInt(start);
    }
    if (hasCount)
    {
      paramDataProcessor.startRecordField$505cff1c("count");
      paramDataProcessor.processInt(count);
    }
    if (hasTotal)
    {
      paramDataProcessor.startRecordField$505cff1c("total");
      paramDataProcessor.processInt(total);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasStart) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo", "start");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasCount) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo", "count");
      }
      return new PagingInfo(start, count, total, hasStart, hasCount, hasTotal);
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
      paramObject = (PagingInfo)paramObject;
      if (start != start) {
        return false;
      }
      if (count != count) {
        return false;
      }
    } while (total == total);
    return false;
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasStart) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasCount) {
      i = j + 4;
    }
    j = i + 1;
    i = j;
    if (hasTotal) {
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
    int i = ((start + 527) * 31 + count) * 31 + total;
    _cachedHashCode = i;
    return i;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PagingInfo");
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
    label158:
    label225:
    label235:
    label243:
    label245:
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
        localByteBuffer.putInt(-1201641331);
        if (hasStart)
        {
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(start);
          if (!hasCount) {
            break label225;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(count);
          if (!hasTotal) {
            break label235;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(total);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label243;
          }
          if (str != null) {
            break label245;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label158;
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
    implements RecordTemplateBuilder<PagingInfo>
  {
    public int count = 0;
    public boolean hasCount = false;
    public boolean hasStart = false;
    private boolean hasTotal = false;
    public int start = 0;
    private int total = 0;
    
    public final PagingInfo build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (PagingInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new PagingInfo(start, count, total, hasStart, hasCount, hasTotal);
        if (!hasStart) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo", "start");
        }
      } while (hasCount);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo", "count");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */