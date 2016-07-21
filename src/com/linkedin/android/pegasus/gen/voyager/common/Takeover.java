package com.linkedin.android.pegasus.gen.voyager.common;

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

public final class Takeover
  implements FissileDataModel<Takeover>, RecordTemplate<Takeover>
{
  public static final TakeoverBuilder BUILDER = TakeoverBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final String globalLegoTrackingToken;
  public final boolean hasGlobalLegoTrackingToken;
  public final boolean hasLegoTrackingToken;
  public final boolean hasTakeoverType;
  public final String legoTrackingToken;
  public final TakeoverType takeoverType;
  
  Takeover(TakeoverType paramTakeoverType, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    takeoverType = paramTakeoverType;
    legoTrackingToken = paramString1;
    globalLegoTrackingToken = paramString2;
    hasTakeoverType = paramBoolean1;
    hasLegoTrackingToken = paramBoolean2;
    hasGlobalLegoTrackingToken = paramBoolean3;
    _cachedId = null;
  }
  
  private Takeover accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTakeoverType)
    {
      paramDataProcessor.startRecordField$505cff1c("takeoverType");
      paramDataProcessor.processEnum(takeoverType);
    }
    if (hasLegoTrackingToken)
    {
      paramDataProcessor.startRecordField$505cff1c("legoTrackingToken");
      paramDataProcessor.processString(legoTrackingToken);
    }
    if (hasGlobalLegoTrackingToken)
    {
      paramDataProcessor.startRecordField$505cff1c("globalLegoTrackingToken");
      paramDataProcessor.processString(globalLegoTrackingToken);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasTakeoverType) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Takeover", "takeoverType");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasLegoTrackingToken) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Takeover", "legoTrackingToken");
      }
      if (!hasGlobalLegoTrackingToken) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Takeover", "globalLegoTrackingToken");
      }
      return new Takeover(takeoverType, legoTrackingToken, globalLegoTrackingToken, hasTakeoverType, hasLegoTrackingToken, hasGlobalLegoTrackingToken);
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
      paramObject = (Takeover)paramObject;
      if (takeoverType != null)
      {
        if (takeoverType.equals(takeoverType)) {}
      }
      else {
        while (takeoverType != null) {
          return false;
        }
      }
      if (legoTrackingToken != null)
      {
        if (legoTrackingToken.equals(legoTrackingToken)) {}
      }
      else {
        while (legoTrackingToken != null) {
          return false;
        }
      }
      if (globalLegoTrackingToken == null) {
        break;
      }
    } while (globalLegoTrackingToken.equals(globalLegoTrackingToken));
    for (;;)
    {
      return false;
      if (globalLegoTrackingToken == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int j = 0 + 1 + 4 + 1;
    int i = j;
    if (hasTakeoverType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasLegoTrackingToken) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(legoTrackingToken);
    }
    j = i + 1;
    i = j;
    if (hasGlobalLegoTrackingToken) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(globalLegoTrackingToken);
    }
    __sizeOfObject = i;
    return i;
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    if (takeoverType != null)
    {
      i = takeoverType.hashCode();
      if (legoTrackingToken == null) {
        break label87;
      }
    }
    label87:
    for (int j = legoTrackingToken.hashCode();; j = 0)
    {
      if (globalLegoTrackingToken != null) {
        k = globalLegoTrackingToken.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building Takeover");
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
    label165:
    label234:
    label244:
    label252:
    label254:
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
        localByteBuffer.putInt(1663176597);
        if (hasTakeoverType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, takeoverType.ordinal());
          if (!hasLegoTrackingToken) {
            break label234;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, legoTrackingToken);
          if (!hasGlobalLegoTrackingToken) {
            break label244;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, globalLegoTrackingToken);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label252;
          }
          if (str != null) {
            break label254;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label165;
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
    implements RecordTemplateBuilder<Takeover>
  {
    public String globalLegoTrackingToken = null;
    public boolean hasGlobalLegoTrackingToken = false;
    public boolean hasLegoTrackingToken = false;
    public boolean hasTakeoverType = false;
    public String legoTrackingToken = null;
    public TakeoverType takeoverType = null;
    
    public final Takeover build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (Takeover.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new Takeover(takeoverType, legoTrackingToken, globalLegoTrackingToken, hasTakeoverType, hasLegoTrackingToken, hasGlobalLegoTrackingToken);
        if (!hasTakeoverType) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Takeover", "takeoverType");
        }
        if (!hasLegoTrackingToken) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Takeover", "legoTrackingToken");
        }
      } while (hasGlobalLegoTrackingToken);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.Takeover", "globalLegoTrackingToken");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.Takeover
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */