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

public final class LegoWidgetActionEvent
  implements FissileDataModel<LegoWidgetActionEvent>, RecordTemplate<LegoWidgetActionEvent>
{
  public static final LegoWidgetActionEventBuilder BUILDER = LegoWidgetActionEventBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  private final String _cachedId;
  public final ActionCategory actionCategory;
  public final int actionCount;
  public final boolean hasActionCategory;
  public final boolean hasActionCount;
  public final boolean hasTrackingId;
  public final boolean hasTrackingToken;
  public final String trackingId;
  public final String trackingToken;
  
  LegoWidgetActionEvent(String paramString1, String paramString2, ActionCategory paramActionCategory, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    trackingToken = paramString1;
    trackingId = paramString2;
    actionCategory = paramActionCategory;
    actionCount = paramInt;
    hasTrackingToken = paramBoolean1;
    hasTrackingId = paramBoolean2;
    hasActionCategory = paramBoolean3;
    hasActionCount = paramBoolean4;
    _cachedId = null;
  }
  
  private LegoWidgetActionEvent accept(DataProcessor paramDataProcessor)
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
    if (hasActionCategory)
    {
      paramDataProcessor.startRecordField$505cff1c("actionCategory");
      paramDataProcessor.processEnum(actionCategory);
    }
    if (hasActionCount)
    {
      paramDataProcessor.startRecordField$505cff1c("actionCount");
      paramDataProcessor.processInt(actionCount);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasTrackingToken) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetActionEvent", "trackingToken");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      if (!hasActionCategory) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetActionEvent", "actionCategory");
      }
      return new LegoWidgetActionEvent(trackingToken, trackingId, actionCategory, actionCount, hasTrackingToken, hasTrackingId, hasActionCategory, hasActionCount);
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
      paramObject = (LegoWidgetActionEvent)paramObject;
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
      if (actionCategory != null)
      {
        if (actionCategory.equals(actionCategory)) {}
      }
      else {
        while (actionCategory != null) {
          return false;
        }
      }
    } while (actionCount == actionCount);
    return false;
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
    if (hasActionCategory) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasActionCount) {
      i = j + 4;
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
        break label95;
      }
    }
    label95:
    for (int j = trackingId.hashCode();; j = 0)
    {
      if (actionCategory != null) {
        k = actionCategory.hashCode();
      }
      i = ((j + (i + 527) * 31) * 31 + k) * 31 + actionCount;
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building LegoWidgetActionEvent");
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
    label205:
    label272:
    label282:
    label292:
    label300:
    label302:
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
        localByteBuffer.putInt(397287208);
        if (hasTrackingToken)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, trackingToken);
          if (!hasTrackingId) {
            break label272;
          }
          localByteBuffer.put((byte)1);
          byte[] arrayOfByte = trackingId.getBytes();
          localByteBuffer.putInt(arrayOfByte.length);
          localByteBuffer.put(arrayOfByte);
          if (!hasActionCategory) {
            break label282;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, actionCategory.ordinal());
          if (!hasActionCount) {
            break label292;
          }
          localByteBuffer.put((byte)1);
          localByteBuffer.putInt(actionCount);
        }
        for (;;)
        {
          if (paramByteBuffer != null) {
            break label300;
          }
          if (str != null) {
            break label302;
          }
          paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
          paramFissionAdapter.recycle(localByteBuffer);
          return;
          localByteBuffer.put((byte)0);
          break;
          localByteBuffer.put((byte)0);
          break label176;
          localByteBuffer.put((byte)0);
          break label205;
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
    implements RecordTemplateBuilder<LegoWidgetActionEvent>
  {
    private ActionCategory actionCategory = null;
    private int actionCount = 0;
    private boolean hasActionCategory = false;
    private boolean hasActionCount = false;
    public boolean hasTrackingId = false;
    private boolean hasTrackingToken = false;
    public String trackingId = null;
    private String trackingToken = null;
    
    public final LegoWidgetActionEvent build(RecordTemplate.Flavor paramFlavor)
      throws BuilderException
    {
      switch (LegoWidgetActionEvent.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
      {
      }
      do
      {
        return new LegoWidgetActionEvent(trackingToken, trackingId, actionCategory, actionCount, hasTrackingToken, hasTrackingId, hasActionCategory, hasActionCount);
        if (!hasActionCount) {
          actionCount = 1;
        }
        if (!hasTrackingToken) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetActionEvent", "trackingToken");
        }
      } while (hasActionCategory);
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetActionEvent", "actionCategory");
    }
    
    public final Builder setActionCategory(ActionCategory paramActionCategory)
    {
      if (paramActionCategory == null)
      {
        hasActionCategory = false;
        actionCategory = null;
        return this;
      }
      hasActionCategory = true;
      actionCategory = paramActionCategory;
      return this;
    }
    
    public final Builder setActionCount(Integer paramInteger)
    {
      if ((paramInteger == null) || (paramInteger.intValue() == 1))
      {
        hasActionCount = false;
        actionCount = 1;
        return this;
      }
      hasActionCount = true;
      actionCount = paramInteger.intValue();
      return this;
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
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.lego.LegoWidgetActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */