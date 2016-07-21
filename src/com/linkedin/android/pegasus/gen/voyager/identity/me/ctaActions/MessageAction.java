package com.linkedin.android.pegasus.gen.voyager.identity.me.ctaActions;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class MessageAction
  implements FissileDataModel<MessageAction>, RecordTemplate<MessageAction>
{
  public static final MessageActionBuilder BUILDER = MessageActionBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final AttributedText displayText;
  public final boolean hasDisplayText;
  public final boolean hasPrefilledMessage;
  public final String prefilledMessage;
  
  MessageAction(AttributedText paramAttributedText, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    displayText = paramAttributedText;
    prefilledMessage = paramString;
    hasDisplayText = paramBoolean1;
    hasPrefilledMessage = paramBoolean2;
    _cachedId = null;
  }
  
  public final MessageAction accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    AttributedText localAttributedText = null;
    boolean bool = false;
    if (hasDisplayText)
    {
      paramDataProcessor.startRecordField$505cff1c("displayText");
      if (!paramDataProcessor.shouldAcceptTransitively()) {
        break label107;
      }
      localAttributedText = displayText.accept(paramDataProcessor);
      if (localAttributedText == null) {
        break label124;
      }
    }
    label107:
    label124:
    for (bool = true;; bool = false)
    {
      if (hasPrefilledMessage)
      {
        paramDataProcessor.startRecordField$505cff1c("prefilledMessage");
        paramDataProcessor.processString(prefilledMessage);
      }
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label129;
      }
      return new MessageAction(localAttributedText, prefilledMessage, bool, hasPrefilledMessage);
      localAttributedText = (AttributedText)paramDataProcessor.processDataTemplate(displayText);
      break;
    }
    label129:
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
      paramObject = (MessageAction)paramObject;
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
    int i = 0 + 1 + 4 + 1;
    if (hasDisplayText) {
      if (displayText._cachedId == null) {
        break label83;
      }
    }
    label83:
    for (i = PegasusBinaryUtils.getEncodedLength(displayText._cachedId) + 9;; i = displayText.getSerializedSize() + 7)
    {
      int j = i + 1;
      i = j;
      if (hasPrefilledMessage) {
        i = j + 2 + PegasusBinaryUtils.getEncodedLength(prefilledMessage);
      }
      __sizeOfObject = i;
      return i;
    }
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (displayText != null) {}
    for (int i = displayText.hashCode();; i = 0)
    {
      if (prefilledMessage != null) {
        j = prefilledMessage.hashCode();
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
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building MessageAction");
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
        localByteBuffer.putInt(534257186);
        if (hasDisplayText)
        {
          localByteBuffer.put((byte)1);
          if (displayText._cachedId != null)
          {
            localByteBuffer.put((byte)0);
            paramFissionAdapter.writeString(localByteBuffer, displayText._cachedId);
            displayText.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
            if (!hasPrefilledMessage) {
              break label264;
            }
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeString(localByteBuffer, prefilledMessage);
          }
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
          localByteBuffer.put((byte)1);
          displayText.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          break;
          localByteBuffer.put((byte)0);
          break;
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
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.ctaActions.MessageAction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */