package com.linkedin.android.pegasus.gen.voyager.common.lego;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.BytesCoercer;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class LegoWidgetImpressionEvent
  implements FissileDataModel<LegoWidgetImpressionEvent>, RecordTemplate<LegoWidgetImpressionEvent>
{
  public static final LegoWidgetImpressionEventBuilder BUILDER = LegoWidgetImpressionEventBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final boolean hasTrackingId;
  public final boolean hasTrackingToken;
  public final boolean hasVisibility;
  public final String trackingId;
  public final String trackingToken;
  public final Visibility visibility;
  
  LegoWidgetImpressionEvent(String paramString1, String paramString2, Visibility paramVisibility, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    trackingToken = paramString1;
    trackingId = paramString2;
    visibility = paramVisibility;
    hasTrackingToken = paramBoolean1;
    hasTrackingId = paramBoolean2;
    hasVisibility = paramBoolean3;
    _cachedId = null;
  }
  
  private LegoWidgetImpressionEvent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasTrackingToken)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingToken");
      paramDataProcessor.processString(trackingToken);
    }
    if (hasTrackingId)
    {
      paramDataProcessor.startRecordField$505cff1c("trackingId");
      BytesCoercer localBytesCoercer = BytesCoercer.INSTANCE;
      paramDataProcessor.processBytes(BytesCoercer.coerceFromCustomType(trackingId));
    }
    if (hasVisibility)
    {
      paramDataProcessor.startRecordField$505cff1c("visibility");
      paramDataProcessor.processEnum(visibility);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasTrackingToken) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetImpressionEvent", "trackingToken");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasVisibility) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetImpressionEvent", "visibility");
      }
      return new LegoWidgetImpressionEvent(trackingToken, trackingId, visibility, hasTrackingToken, hasTrackingId, hasVisibility);
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
      paramObject = (LegoWidgetImpressionEvent)paramObject;
      if (trackingToken != null)
      {
        if (trackingToken.equals(trackingToken)) {}
      }
      else {
        while (trackingToken != null) {
          return false;
        }
      }
      if (trackingId != null)
      {
        if (trackingId.equals(trackingId)) {}
      }
      else {
        while (trackingId != null) {
          return false;
        }
      }
      if (visibility == null) {
        break;
      }
    } while (visibility.equals(visibility));
    for (;;)
    {
      return false;
      if (visibility == null) {
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
    if (hasTrackingToken) {
      i = PegasusBinaryUtils.getEncodedLength(trackingToken) + 8;
    }
    int j = i + 1;
    i = j;
    if (hasTrackingId) {
      i = j + 4 + trackingId.getBytes().length;
    }
    j = i + 1;
    i = j;
    if (hasVisibility) {
      i = j + 2;
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
    if (trackingToken != null)
    {
      i = trackingToken.hashCode();
      if (trackingId == null) {
        break label87;
      }
    }
    label87:
    for (int j = trackingId.hashCode();; j = 0)
    {
      if (visibility != null) {
        k = visibility.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building LegoWidgetImpressionEvent");
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
    label176:
    label248:
    label258:
    label266:
    label268:
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
        localByteBuffer.putInt(-1460848405);
        if (hasTrackingToken)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingToken);
          if (!hasTrackingId) {
            break label248;
          }
          localByteBuffer.put((byte)1);
          byte[] arrayOfByte = trackingId.getBytes();
          localByteBuffer.putInt(arrayOfByte.length);
          localByteBuffer.put(arrayOfByte);
          if (!hasVisibility) {
            break label258;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, visibility.ordinal());
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label266;
          }
          if (str != null) {
            break label268;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label176;
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
    implements RecordTemplateBuilder<LegoWidgetImpressionEvent>
  {
    public boolean hasTrackingId = false;
    private boolean hasTrackingToken = false;
    private boolean hasVisibility = false;
    public String trackingId = null;
    private String trackingToken = null;
    private Visibility visibility = null;
    
    public final LegoWidgetImpressionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (LegoWidgetImpressionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new LegoWidgetImpressionEvent(trackingToken, trackingId, visibility, hasTrackingToken, hasTrackingId, hasVisibility);
        if (!hasTrackingToken) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetImpressionEvent", "trackingToken");
        }
      } while (hasVisibility);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetImpressionEvent", "visibility");
    }
    
    public final Builder setTrackingToken(String paramString)
    {
      if (paramString == null)
      {
        hasTrackingToken = false;
        trackingToken = null;
        return this;
      }
      hasTrackingToken = true;
      trackingToken = paramString;
      return this;
    }
    
    public final Builder setVisibility(Visibility paramVisibility)
    {
      if (paramVisibility == null)
      {
        hasVisibility = false;
        visibility = null;
        return this;
      }
      hasVisibility = true;
      visibility = paramVisibility;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetImpressionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */