package com.linkedin.crosspromo.fe.api.android;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class LegoTrackingEvent
  implements FissileDataModel<LegoTrackingEvent>, RecordTemplate<LegoTrackingEvent>
{
  public static final LegoTrackingEventBuilder BUILDER = LegoTrackingEventBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasLegoTrackingToken;
  public final boolean hasMetricsObject;
  public final String legoTrackingToken;
  public final MetricsInfo metricsObject;
  
  LegoTrackingEvent(String paramString, MetricsInfo paramMetricsInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    legoTrackingToken = paramString;
    metricsObject = paramMetricsInfo;
    hasLegoTrackingToken = paramBoolean1;
    hasMetricsObject = paramBoolean2;
    _cachedId = null;
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
      paramObject = (LegoTrackingEvent)paramObject;
      if (legoTrackingToken != null)
      {
        if (legoTrackingToken.equals(legoTrackingToken)) {}
      }
      else {
        while (legoTrackingToken != null) {
          return false;
        }
      }
      if (metricsObject == null) {
        break;
      }
    } while (metricsObject.equals(metricsObject));
    for (;;)
    {
      return false;
      if (metricsObject == null) {
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
    if (hasLegoTrackingToken) {
      i = PegasusBinaryUtils.getEncodedLength(legoTrackingToken) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasMetricsObject)
    {
      i = j + 1;
      if (metricsObject._cachedId == null) {
        break label87;
      }
      i = i + 2 + PegasusBinaryUtils.getEncodedLength(metricsObject._cachedId);
    }
    for (;;)
    {
      __sizeOfObject = i;
      return i;
      label87:
      i += metricsObject.getSerializedSize();
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (legoTrackingToken != null) {}
    for (int i = legoTrackingToken.hashCode();; i = 0)
    {
      if (metricsObject != null) {
        j = metricsObject.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building LegoTrackingEvent");
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
    label239:
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
        localByteBuffer.putInt(-1428498056);
        if (hasLegoTrackingToken)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, legoTrackingToken);
          if (!hasMetricsObject) {
            break label264;
          }
          localByteBuffer.put((byte)1);
          if (metricsObject._cachedId == null) {
            break label239;
          }
          localByteBuffer.put((byte)0);
          paramFissionAdapter.writeString(localByteBuffer, metricsObject._cachedId);
          metricsObject.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
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
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)1);
          metricsObject.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
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
  
  public static final class Builder
    implements RecordTemplateBuilder<LegoTrackingEvent>
  {
    public boolean hasLegoTrackingToken = false;
    public boolean hasMetricsObject = false;
    public String legoTrackingToken = null;
    public MetricsInfo metricsObject = null;
    
    public final LegoTrackingEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (LegoTrackingEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new LegoTrackingEvent(legoTrackingToken, metricsObject, hasLegoTrackingToken, hasMetricsObject);
      } while (hasLegoTrackingToken);
      throw new MissingRecordFieldException("com.linkedin.crosspromo.fe.api.android.LegoTrackingEvent", "legoTrackingToken");
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.crosspromo.fe.api.android.LegoTrackingEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */