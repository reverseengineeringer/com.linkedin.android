package com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class PropAction
  implements FissileDataModel<PropAction>, RecordTemplate<PropAction>
{
  public static final PropActionBuilder BUILDER = PropActionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String displayText;
  public final boolean hasDisplayText;
  public final boolean hasPrefilledMessage;
  public final boolean hasType;
  public final String prefilledMessage;
  public final PropActionType type;
  
  PropAction(PropActionType paramPropActionType, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    type = paramPropActionType;
    displayText = paramString1;
    prefilledMessage = paramString2;
    hasType = paramBoolean1;
    hasDisplayText = paramBoolean2;
    hasPrefilledMessage = paramBoolean3;
    _cachedId = null;
  }
  
  public final PropAction accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasType)
    {
      paramDataProcessor.startRecordField$505cff1c("type");
      paramDataProcessor.processEnum(type);
    }
    if (hasDisplayText)
    {
      paramDataProcessor.startRecordField$505cff1c("displayText");
      paramDataProcessor.processString(displayText);
    }
    if (hasPrefilledMessage)
    {
      paramDataProcessor.startRecordField$505cff1c("prefilledMessage");
      paramDataProcessor.processString(prefilledMessage);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate())
    {
      try
      {
        if (!hasType) {
          throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropAction", "type");
        }
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
      return new PropAction(type, displayText, prefilledMessage, hasType, hasDisplayText, hasPrefilledMessage);
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
      paramObject = (PropAction)paramObject;
      if (type != null)
      {
        if (type.equals(type)) {}
      }
      else {
        while (type != null) {
          return false;
        }
      }
      if (displayText != null)
      {
        if (displayText.equals(displayText)) {}
      }
      else {
        while (displayText != null) {
          return false;
        }
      }
      if (prefilledMessage == null) {
        break;
      }
    } while (prefilledMessage.equals(prefilledMessage));
    for (;;)
    {
      return false;
      if (prefilledMessage == null) {
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
    if (hasType) {
      i = j + 2;
    }
    j = i + 1;
    i = j;
    if (hasDisplayText) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(displayText);
    }
    j = i + 1;
    i = j;
    if (hasPrefilledMessage) {
      i = j + 2 + PegasusBinaryUtils.getEncodedLength(prefilledMessage);
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
    if (type != null)
    {
      i = type.hashCode();
      if (displayText == null) {
        break label87;
      }
    }
    label87:
    for (int j = displayText.hashCode();; j = 0)
    {
      if (prefilledMessage != null) {
        k = prefilledMessage.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building PropAction");
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
        localByteBuffer.putInt(-1940182986);
        if (hasType)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeUnsignedShort(localByteBuffer, type.ordinal());
          if (!hasDisplayText) {
            break label234;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, displayText);
          if (!hasPrefilledMessage) {
            break label244;
          }
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, prefilledMessage);
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */